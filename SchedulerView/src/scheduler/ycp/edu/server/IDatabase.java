package scheduler.ycp.edu.server;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import scheduler.ycp.edu.shared.Course;


public interface IDatabase {
	public List<Course> findCourse(String courseName) throws SQLException;

	Map<String, List<Course>> getDatabase();
}
