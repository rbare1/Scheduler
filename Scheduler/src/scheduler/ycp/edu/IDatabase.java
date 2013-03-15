package scheduler.ycp.edu;

import java.util.List;

import scheduler.ycp.edu.shared.Course;

public interface IDatabase {
	public List<Course> findCourse(String courseName);

}
