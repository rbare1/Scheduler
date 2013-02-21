package scheduler.ycp.edu;

import java.util.ArrayList;
import java.util.List;


public class Generate { 
	private static List<Course> scheduleM = new ArrayList<Course>();
	private static List<Course> scheduleT = new ArrayList<Course>();
	private static List<Course> scheduleW = new ArrayList<Course>();
	private static List<Course> scheduleR = new ArrayList<Course>();
	private static List<Course> scheduleF = new ArrayList<Course>();
	
	boolean checkOpen = false;

	
	public void GenerateSchedule(Course course1, Course course2, Course course3, Course course4, Course course5){
		
		int numCourses = 5;
		int cnt = 0;
		Course course;
		
		for(int i = 0; i < numCourses; i++){		// cycles through each course to add to the appropriate list
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
			
			// separates classes by the day of the week they are in
			// classes can be in multiple days

			if(course.getDays() == "M"){	// .contains is not working for some reason
											// it is the cause of null pointer exceptions
											// since the test tries to access elements of an empty array
				checkOpen = checkScheduleM(course);
				if(checkOpen){
					scheduleM.add(course);	
				}
			}
			if(course.getDays().contains("T")){
				checkOpen = checkScheduleT(course);
				if(checkOpen){
					scheduleT.add(course);
				}	
			}
			if(course.getDays().contains("W")){
				checkOpen = checkScheduleW(course);
				if(checkOpen){
					scheduleW.add(course);
				}
			}
			if(course.getDays().contains("R")){
				checkOpen = checkScheduleT(course);
				if(checkOpen){
					scheduleR.add(course);
				}
			}
			if(course.getDays().contains("F")){
				checkOpen = checkScheduleF(course);
				if(checkOpen){
					scheduleF.add(course);
				}
			}
			scheduleM.add(course1);
		}
		
	}
	public List<Course> getScheduleM(){
	//	GenerateSchedule();
		return scheduleM;
	}
	public List<Course> getScheduleT(){
		//GenerateSchedule();
		return scheduleT;
	}
	public List<Course> getScheduleW(){
		//GenerateSchedule();
		return scheduleW;
	}
	public List<Course> getScheduleR(){
		//GenerateSchedule();
		return scheduleR;
	}
	public List<Course> getScheduleF(){
		//GenerateSchedule();
		return scheduleF;
	}
	
	public boolean checkScheduleM(Course course){
		for(int j = 0; j < scheduleM.size(); j ++){
			if(course.getStartTime() >= scheduleM.get(j).getStartTime() && course.getStartTime() <= scheduleM.get(j).getEndTime()){
				checkOpen = false;	// checkOpens if other classes already use start time slot
				break;	// break so checkOpen isn't overridden by checkOpening another class
			}
			else if(course.getEndTime() >= scheduleM.get(j).getStartTime() && course.getEndTime() <= scheduleM.get(j).getEndTime()){
				checkOpen = false;	// checkOpen if other classes already use end time slot
				break;
			}
			else{
				checkOpen = true;
			}
		}
		return checkOpen;
	}
	
	public boolean checkScheduleT(Course course){
		for(int j = 0; j < scheduleT.size(); j ++){
			if(course.getStartTime() >= scheduleT.get(j).getStartTime() && course.getStartTime() <= scheduleT.get(j).getEndTime()){
				checkOpen = false;	// checkOpens if other classes already use start time slot
				break;	// break so checkOpen isn't overridden by checkOpening another class
			}
			else if(course.getEndTime() >= scheduleT.get(j).getStartTime() && course.getEndTime() <= scheduleT.get(j).getEndTime()){
				checkOpen = false;	// checkOpen if other classes already use end time slot
				break;
			}
			else{
				checkOpen = true;
			}
		}
		return checkOpen;
	}
	
	public boolean checkScheduleW(Course course){
		for(int j = 0; j < scheduleW.size(); j ++){
			if(course.getStartTime() >= scheduleW.get(j).getStartTime() && course.getStartTime() <= scheduleW.get(j).getEndTime()){
				checkOpen = false;	// checkOpens if other classes already use start time slot
				break;	// break so checkOpen isn't overridden by checkOpening another class
			}
			else if(course.getEndTime() >= scheduleW.get(j).getStartTime() && course.getEndTime() <= scheduleW.get(j).getEndTime()){
				checkOpen = false;	// checkOpen if other classes already use end time slot
				break;
			}
			else{
				checkOpen = true;
			}
		}
		return checkOpen;
	}
	
	public boolean checkScheduleR(Course course){
		for(int j = 0; j < scheduleR.size(); j ++){
			if(course.getStartTime() >= scheduleR.get(j).getStartTime() && course.getStartTime() <= scheduleR.get(j).getEndTime()){
				checkOpen = false;	// checkOpens if other classes already use start time slot
				break;	// break so checkOpen isn't overridden by checkOpening another class
			}
			else if(course.getEndTime() >= scheduleR.get(j).getStartTime() && course.getEndTime() <= scheduleR.get(j).getEndTime()){
				checkOpen = false;	// checkOpen if other classes already use end time slot
				break;
			}
			else{
				checkOpen = true;
			}
		}
		return checkOpen;
	}
	
	public boolean checkScheduleF(Course course){
		for(int j = 0; j < scheduleF.size(); j ++){
			if(course.getStartTime() >= scheduleF.get(j).getStartTime() && course.getStartTime() <= scheduleF.get(j).getEndTime()){
				checkOpen = false;	// checkOpens if other classes already use start time slot
				break;	// break so checkOpen isn't overridden by checkOpening another class
			}
			else if(course.getEndTime() >= scheduleF.get(j).getStartTime() && course.getEndTime() <= scheduleF.get(j).getEndTime()){
				checkOpen = false;	// checkOpen if other classes already use end time slot
				break;
			}
			else{
				checkOpen = true;
			}
		}
		return checkOpen;
	}
	
}


