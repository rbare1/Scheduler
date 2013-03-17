package scheduler.ycp.edu.shared;

import java.util.List;

public interface IDatabase {
	public List<Course> findCourse(String courseName);
}