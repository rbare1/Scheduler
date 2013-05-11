package scheduler.ycp.edu.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.gwt.core.shared.GWT;



import scheduler.ycp.edu.server.DBUtil;
import scheduler.ycp.edu.server.ITransaction;
import scheduler.ycp.edu.shared.Course;

public class DerbyDatabase implements IDatabase {

	private static final String DATASTORE = "H:/coursesdb";
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new RuntimeException("Could not load Derby JDBC driver");
		}
	}

	private class DatabaseConnection {
		public Connection conn;
		public int refCount;
	}

	private final ThreadLocal<DatabaseConnection> connHolder = new ThreadLocal<DatabaseConnection>();

	private DatabaseConnection getConnection() throws SQLException {
		DatabaseConnection dbConn = connHolder.get();
		if (dbConn == null) {
			dbConn = new DatabaseConnection();
			dbConn.conn = DriverManager.getConnection("jdbc:derby:" + DATASTORE
					+ ";create=true");
			dbConn.refCount = 0;
			connHolder.set(dbConn);
		}
		dbConn.refCount++;
		return dbConn;
	}

	private void releaseConnection(DatabaseConnection dbConn)
			throws SQLException {
		dbConn.refCount--;
		if (dbConn.refCount == 0) {
			try {
				dbConn.conn.close();
			} finally {
				connHolder.set(null);
			}
		}
	}

	private <E> E databaseRun(ITransaction<E> transaction) throws SQLException {
		// FIXME: retry if transaction times out due to deadlock
		DatabaseConnection dbConn = getConnection();
		try {
			boolean origAutoCommit = dbConn.conn.getAutoCommit();
			try {
				dbConn.conn.setAutoCommit(false);

				E result = transaction.run(dbConn.conn);
				dbConn.conn.commit();
				return result;
			} finally {
				dbConn.conn.setAutoCommit(origAutoCommit);
			}
		} finally {
			releaseConnection(dbConn);
		}
	}

	void createTables() throws SQLException {
		databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				try {
					stmt2 = conn
							.prepareStatement("create table schedules ("
									+ "  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
									+ "  name VARCHAR(256)" + ")");
					stmt2.executeUpdate();
					stmt = conn.prepareStatement(
					/*
					 * "create table order_receipts (" +
					 * "  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
					 * + "  userinfo VARCHAR(200) NOT NULL, " +
					 * "  price DECIMAL(10,2) " + ")"
					 */
					"create table courses ("
							+ "schedule_id INTEGER NOT NULL, "
							+ // which schedule the entry belongs to
							"entry_num INTEGER NOT NULL, "
							+ // which entry within the schedule this is
							"num VARCHAR(100) NOT NULL, " +
							"CRNNum INTEGER NOT NULL, " +
							"name VARCHAR(100) NOT NULL, " +
							"credit INTEGER NOT NULL, " +
							"days VARCHAR(100) NOT NULL, " +
							"startTime DOUBLE NOT NULL, " +
							"endTime DOUBLE NOT NULL, " +
							"instructor VARCHAR(100) NOT NULL, " +
							"room VARCHAR(100) NOT NULL" + ")");
					stmt.executeUpdate();
				} finally {
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt);
				}
				return true;
			}
		});
	}

	public ArrayList<Course> saveSchedule(final ArrayList<Course> courses) {
		try {
			return databaseRun(new ITransaction<ArrayList<Course>>() {
				@SuppressWarnings("resource")
				@Override
				public ArrayList<Course> run(Connection conn)
						throws SQLException {
					PreparedStatement stmt = null;
					PreparedStatement stmt2 = null;
					ResultSet generatedKeys = null;
					Random rand;
					rand = new Random();

					try {
						// TODO: need to insert into schedules table
						// and get the generated id
						int scheduleId = 1;//42;// rand.nextInt(100000); //generated schedule id
						
						stmt2 = conn.prepareStatement(
								"insert into schedules (name) values (?)",
								PreparedStatement.RETURN_GENERATED_KEYS
						);
						//stmt2.setInt(1, scheduleId);
						stmt2.setString(1, "Schedule #" + scheduleId);
						//stmt2.executeUpdate();
						
						ArrayList<Course> schedule = new ArrayList<Course>();
						for (int i = 0; i < courses.size(); i++) {
							schedule.add(courses.get(i));
						}
						stmt = conn.prepareStatement(
								"insert into courses (schedule_id, entry_num, num, CRNNum, name, credit, days, startTime, endTime, instructor, room) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
								PreparedStatement.RETURN_GENERATED_KEYS);
						for (int i = 0; i < schedule.size(); i++) {
							stmt.setInt(1, scheduleId);
							stmt.setInt(2,  i);
							Course course = schedule.get(i);
							stmt.setString(3, course.getNum());
							stmt.setInt(4, course.getCRNNum());
							stmt.setString(5, course.getName());
							stmt.setInt(6, course.getCredit());
							stmt.setString(7, course.getDays());	
							stmt.setDouble(8, course.getStartTime());
							stmt.setDouble(9, course.getEndTime());
							stmt.setString(10, course.getInstructor());
							stmt.setString(11, course.getRoom());
							stmt.addBatch();								
						}
						stmt.executeBatch();
						generatedKeys = stmt.getGeneratedKeys();
						if (!generatedKeys.next()) {
							throw new SQLException("Couldn't get generated key for schedule");
						}

						return schedule;
						
					} finally {
						DBUtil.closeQuietly(stmt);
						DBUtil.closeQuietly(generatedKeys);
					}
				}
			});
		} catch (SQLException e) {
			throw new RuntimeException("SQLException saving schedule", e);
		}
	}

	@Override
	public ArrayList<Course> getSchedule(int scheduleId) throws SQLException {
		return databaseRun(new ITransaction<ArrayList<Course>>() {
			@Override
			public ArrayList<Course> run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				try {
					stmt = conn.prepareStatement("select * from schedules");
					resultSet = stmt.executeQuery();
					
					ArrayList<Course> result = new ArrayList<Course>();
					while (resultSet.next()) {
						Course course = new Course(null, 0, null, 0, null, 0,
								0, null, null);
						course.setNum(resultSet.getString(0));
						course.setCRNNum(resultSet.getInt(1));
						course.setName(resultSet.getString(2));
						course.setCredit(resultSet.getInt(3));
						course.setDays(resultSet.getString(4));
						course.setStartTime(resultSet.getInt(5));
						course.setEndTime(resultSet.getInt(6));
						course.setInstructor(resultSet.getString(7));
						course.setRoom(resultSet.getString(8));
						result.add(course);
					}
//					Course course = new Course();
//					course.setNum("Database test Course");
//					result.add(course);
					return result;
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
	}

	@Override
	public ArrayList<Course> findCourse(String courseName) throws SQLException {
		return databaseRun(new ITransaction<ArrayList<Course>>() {
			@Override
			public ArrayList<Course> run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				try {
					stmt = conn.prepareStatement("select * from courses");
					resultSet = stmt.executeQuery();
					ArrayList<Course> result = new ArrayList<Course>();
					while (resultSet.next()) {
						Course course = new Course(null, 0, null, 0, null, 0,
								0, null, null);
						course.setNum(resultSet.getString(0));
						course.setCRNNum(resultSet.getInt(1));
						course.setName(resultSet.getString(2));
						course.setCredit(resultSet.getInt(3));
						course.setDays(resultSet.getString(4));
						course.setStartTime(resultSet.getInt(5));
						course.setEndTime(resultSet.getInt(6));
						course.setInstructor(resultSet.getString(7));
						course.setRoom(resultSet.getString(8));
						result.add(course);
					}
					return result;
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
	}

	@Override
	public Map<String, List<Course>> getDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public Map<String, List<Course>> getDatabase() { // put the
	 * courses into a table return null; }
	 */

}