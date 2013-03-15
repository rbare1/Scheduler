package scheduler.ycp.edu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import scheduler.ycp.edu.shared.Course;
import scheduler.ycp.edu.shared.Course;
import scheduler.ycp.edu.shared.ListRead;

public class FakeDatabase implements IDatabase {
	private Map<String, List<Course>> coursesByName;
	private ListRead list; 
	private List<Course> courseList;
	public static int global_check = 0;
	public static int global_check_size = 0;
	public static String check_name;
	public static int global_check_temp1;
	public static int global_check_temp2;
	
	public void CreateFakeDatabase(File fileName) throws IOException {
		
		list = new ListRead(fileName);
		courseList = list.Read();	//load courses from CSV file into Array List
		
		coursesByName = new HashMap<String,List<Course>>();
		
		Course course = new Course(null, 0, null, 0, null, 0, 0, null, null);

		String prevCourseName = "";
		List<Course> tempList = new ArrayList<Course>();
		for(int i = 0; i < courseList.size(); i++){
			course = courseList.get(i);	// get next class
			if(i == 0){
				prevCourseName = course.getNum();	// sets up the course name for the first run through
			}
			if((course.getNum()).equals(prevCourseName)){	//checks if course is the same name but different section as last course
				tempList.add(course);
				global_check++;
				if(i == courseList.size() -1){	// makes sure the last course still gets saved even if it's the same
												// course as the previous one
					coursesByName.put(prevCourseName, tempList);
					global_check_size++;
				}
			}
			else{
				coursesByName.put(prevCourseName, tempList);	//stores the list of previous courses
				/*if(i == 7){
					break;		//DEBUGGING
				}*/
				
				
				global_check_size++;
				global_check_temp1 = tempList.size();
				tempList = new ArrayList<Course>();
				// This line breaks the program
				//tempList.clear();	// clears old courses out of the list
				global_check_temp2 = tempList.size();
				tempList.add(course);	// add new course (with a different name) to the list
				
				
			}
			
			prevCourseName = course.getNum();	// change the name to the current course for comparison in the next loop cycle
			check_name = prevCourseName;
			
			
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
/* Current Issue:
 * All values of the array lists are stored fine and the prevCourseName changes with each iteration but the array lists are 
 * all being stored under the key CS101
 */
