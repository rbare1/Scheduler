package scheduler.ycp.edu.shared;

import java.util.HashMap;
import java.util.Map;

public class FakeDatabase implements IDatabase {
	private Map<String, Course> coursesByName;
	
	public FakeDatabase() {
		coursesByName = new HashMap<String, Course>();
		
		// Could load courses from CSV file
		
//		Course course = new Course();
//		course.setName("Test Course");
//		
//		coursesByName.put(course.getName(), course);
	}
	
	@Override
	public Course findCourse(String courseName) {
		return coursesByName.get(courseName);
	}
}
