package scheduler.ycp.edu;

import java.util.ArrayList;
import java.util.List;


public class Generate { 
	
	ArrayList<Course> scheduleM = new ArrayList<Course>();
	ArrayList<Course> scheduleT = new ArrayList<Course>();
	ArrayList<Course> scheduleW = new ArrayList<Course>();
	ArrayList<Course> scheduleR = new ArrayList<Course>();
	ArrayList<Course> scheduleF = new ArrayList<Course>();
	public void GenerateSchedule(){

		Course course1 = new Course(null, 0, null, 0, null, 0, 0, null, null);		// course 1 is most important
		Course course2 = new Course(null, 0, null, 0, null, 0, 0, null, null);		// course 2 is second, etc
		Course course3 = new Course(null, 0, null, 0, null, 0, 0, null, null);
		Course course4 = new Course(null, 0, null, 0, null, 0, 0, null, null);
		Course course5 = new Course(null, 0, null, 0, null, 0, 0, null, null);
		
		
		int numCourses = 5;
		int cnt = 0;
		Course course;
		
		for(int i =0; i < numCourses; i++){		// cycles through each course to add to the appropriate list
			if(cnt == 0){
				course = course1;
			}
			else if(cnt == 1){
				course = course2;
			}
			else if(cnt == 2){
				course = course3;
			}
			else if(cnt == 3){
				course = course4;
			}
			else{
				course = course5;
			}
			cnt++;
			
			if(course.getDays().contains("M")){		// separates classes by the day of the week they are in
				scheduleM.add(course);				// classes can be in separate days
			}
			if(course.getDays().contains("T")){
				scheduleT.add(course);
			}
			if(course.getDays().contains("W")){
				scheduleW.add(course);
			}
			if(course.getDays().contains("R")){
				scheduleR.add(course);
			}
			if(course.getDays().contains("F")){
				scheduleF.add(course);
			}
			
		}
		
	}
	public List<Course> getScheduleM(){
		GenerateSchedule();
		return scheduleM;
	}
	
}


