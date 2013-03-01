package scheduler.ycp.edu;

import java.util.List;

public interface IDatabase {
	public List<Course> findCourse(String courseName);
}
