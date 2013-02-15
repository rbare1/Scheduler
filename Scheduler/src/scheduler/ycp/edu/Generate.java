package scheduler.ycp.edu;

import java.util.ArrayList;

public class Generate { 
	public static void main(String[] args) {
		Course course1;		// course 1 is most important
		Course course2;		// course 2 is second, etc
		Course course3;
		Course course4;
		Course course5;
		
		ArrayList<Course> scheduleM = new ArrayList<Course>();
		ArrayList<Course> scheduleT = new ArrayList<Course>();
		ArrayList<Course> scheduleW = new ArrayList<Course>();
		ArrayList<Course> scheduleR = new ArrayList<Course>();
		ArrayList<Course> scheduleF = new ArrayList<Course>();
		int numCourses = 5;
		int cnt = 0;
		Course course;
		
		for(int i =0; i < numCourses; i++){
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
			else if(cnt == 4){
				course = course5;
			}
			cnt++;
			if(course.days.contains('M')){
				scheduleM.add(course);
			}
			if(course.days.contains('T')){
				scheduleT.add(course);
			}
			if(course.days.contains('W')){
				scheduleW.add(course);
			}
			if(course.days.contains('R')){
				scheduleR.add(course);
			}
			if(course.days.contains('F')){
				scheduleF.add(course);
			}
			
		}
	}

	
}

