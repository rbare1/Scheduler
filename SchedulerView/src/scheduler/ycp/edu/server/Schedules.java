package scheduler.ycp.edu.server;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scheduler.ycp.edu.shared.Course;

@SuppressWarnings("serial")
public class Schedules extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// The path info is the part of the URL that follows the
		// part identifying the servlet. For example, if the
		// URL was http://hostname/receipts/42, and assuming that
		// "/receipts" is the path to the servlet, the path info
		// would be "/42".
		String info = req.getPathInfo();
		System.out.println("Path info is: " + info);

		if (info == null) {
			badRequest(resp, "URL does not name a schedule id");
			return;
		}
		if (info.startsWith("/")) {
			info = info.substring(1);
		}
		if (!info.equals("")) {
			// get specific schedule
			// DerbyDatabase database = new DerbyDatabase();
			IDatabase database = DBUtil.instance();
			try {
				ArrayList<Course> schedule = database.getSchedule(Integer
						.valueOf(info));
				//DEBUG
//				Course testCourse = new Course();
//				testCourse.setNum("Test Course");
//				schedule.add(testCourse);
				// Send back course data as CSV?
				resp.setContentType("text/csv");
				for (Course course : schedule) {
					// TODO: do all fields
					resp.getWriter().println(
							course.getName() + "," + course.getCRNNum());
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			File fileName = new File("Course_List.csv");
			
			ListRead list = new ListRead(fileName);
			ArrayList<Course> schedule = (ArrayList<Course>) list.Read();
			for (Course course : schedule) {
				// TODO: do all fields
				resp.getWriter().println(
						course.getCRNNum() + "," + course.getName() + "," + course.getNum() + "," + course.getDays() + "," + course.getStartTime() +"," + course.getEndTime() + "," + course.getInstructor() + "," + course.getRoom()) ;
			}
//			badRequest(resp, "Schedule id not specified");
			return;
		}

		// TODO: write the response body with data from the database
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("text/plain");
		resp.getWriter().println("Success!");
	}

	private void badRequest(HttpServletResponse resp, String msg)
			throws IOException {
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		resp.setContentType("text/plain");
		resp.getWriter().println(msg);
	}
}