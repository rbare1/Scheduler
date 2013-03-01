package scheduler.ycp.edu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeDatabase implements IDatabase {
	private Map<String, List<Course>> coursesByName;
	private ListRead list; 
	private List<Course> courseList;
	
	public void CreateFakeDatabase(File fileName) throws IOException {
		
		list = new ListRead(fileName);
		courseList = list.Read();
		
		coursesByName = new HashMap<String,List<Course>>();
		
		// Could load courses from CSV file
		
		Course course = new Course(null, 0, null, 0, null, 0, 0, null, null);

		String prevCourseName = "";
		List<Course> tempList = new ArrayList<Course>();
		for(int i = 0; i < courseList.size(); i++){
			course = courseList.get(i);	// get next class
			if(i == 0){
				prevCourseName = course.getNum();	// sets up the course name for the first run through
			}
			if(course.getNum().equals(prevCourseName)){	//checks if course is the same name but different section as last course
				tempList.add(course);
				if(i == courseList.size() -1){	// makes sure the last course still gets saved even if it's the same
												// course as the previous one
					coursesByName.put(tempList.get(0).getNum(), tempList);
				}
			}
			else{
				coursesByName.put(tempList.get(0).getNum(), tempList);	//stores the list of previous courses
																		// with a key of the name of the course
				tempList.clear();	// clears old courses out of the list
				tempList.add(course);	// add new course (with a different name) to the list
			}
			prevCourseName = course.getNum();	// change the name to the current course for comparison in the next loop cycle
		}

	}
	
	@Override
	public List<Course> findCourse(String courseName) {
		if(coursesByName.containsKey(courseName)){
			return coursesByName.get(courseName);
		}
		else{
			return null;
		}
	}
}
