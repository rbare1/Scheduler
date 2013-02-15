package scheduler.ycp.edu;

import java.util.ArrayList;


public class Generate { 
	
	
	public void main(String[] args) {
	}
	
	public void GenerateSchedule(){
		Course course1 = getCourse();		// course 1 is most important
		Course course2 = getCourse();		// course 2 is second, etc
		Course course3 = getCourse();
		Course course4 = getCourse();
		Course course5 = getCourse();
		
		ArrayList<Course> scheduleM = new ArrayList<Course>();
		ArrayList<Course> scheduleT = new ArrayList<Course>();
		ArrayList<Course> scheduleW = new ArrayList<Course>();
		ArrayList<Course> scheduleR = new ArrayList<Course>();
		ArrayList<Course> scheduleF = new ArrayList<Course>();
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
			if(course.days.contains("M")){		// separates classes by the day of the week they are in
				scheduleM.add(course);			// classes can be in separate days
			}
			if(course.days.contains("T")){
				scheduleT.add(course);
			}
			if(course.days.contains("W")){
				scheduleW.add(course);
			}
			if(course.days.contains("R")){
				scheduleR.add(course);
			}
			if(course.days.contains("F")){
				scheduleF.add(course);
			}
			
		}
	}
	
}


