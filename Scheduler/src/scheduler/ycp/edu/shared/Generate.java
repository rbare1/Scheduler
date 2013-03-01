package scheduler.ycp.edu.shared;

import java.util.ArrayList;
import java.util.List;


public class Generate { 
	private static List<Course> scheduleM = new ArrayList<Course>();
	private static List<Course> scheduleT = new ArrayList<Course>();
	private static List<Course> scheduleW = new ArrayList<Course>();
	private static List<Course> scheduleR = new ArrayList<Course>();
	private static List<Course> scheduleF = new ArrayList<Course>();
	private List<String> track = new ArrayList<String>();
	
	boolean checkOpen = false;

	
	public void GenerateSchedule(Course course1, Course course2, Course course3, Course course4, Course course5, Course course6, Course course7){
		
		int numCourses = 5;
		int cnt = 0;
		Course course;
		checkOpen = false;
		
		for(int i = 0; i < numCourses; i++){		// cycles through each course to add to the appropriate list
			track.clear();	//clears the tracker for each course
			
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
			else if(cnt == 5){
				course = course6;
			}
			else{
				course = course7;
			}
			cnt++;
			// separates classes by the day of the week they are in
			// classes can be in multiple days

			if(course.getDays() == "M" || course.getDays() == "MW" || course.getDays() == "MWF"){	// using == since .contains isn't working
				checkOpen = checkScheduleM(course);
				if(checkOpen){
					scheduleM.add(course);	
					track.add("M");
				}
				else{
					removeCourse();
				}
			}
			if(course.getDays() == "T" || course.getDays() == "TR"){
				checkOpen = checkScheduleT(course);
				if(checkOpen){
					scheduleT.add(course);
					track.add("T");
				}	
				else{
					removeCourse();
				}
			}
			if(course.getDays() == "W" || course.getDays() == "WF" || course.getDays() == "MW" || course.getDays() == "MWF"){
				checkOpen = checkScheduleW(course);
				if(checkOpen){
					scheduleW.add(course);
					track.add("W");
				}
				else{
					removeCourse();
				}
			}
			if(course.getDays() == "R" || course.getDays() == "TR"){
				checkOpen = checkScheduleR(course);
				if(checkOpen){
					scheduleR.add(course);
					track.add("R");
				}
				else{
					removeCourse();
				}
			}
			if(course.getDays() == "F" || course.getDays() == "WF" || course.getDays() == "MWF"){
				checkOpen = checkScheduleF(course);
				if(checkOpen){
					scheduleF.add(course);
					track.add("F");
				}
				else{
					removeCourse();
				}
			}
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
		if(scheduleM.size() == 0){	// List is empty so no time conflicts, for loop doesn't run in list is empty
			checkOpen = true;
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
		if(scheduleT.size() == 0){
			checkOpen = true;
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
		if(scheduleW.size() == 0){
			checkOpen = true;
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
		if(scheduleR.size() == 0){
			checkOpen = true;
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
		if(scheduleF.size() == 0){
			checkOpen = true;
		}
		return checkOpen;
	}
	
	public void removeCourse(){		// removes a course from any other schedule it may have been added to before the time conflict
		for(int i = 0; i < track.size(); i++){
			if(track.get(i) == "M"){
				scheduleM.remove(scheduleM.size() -1);
			}
			if(track.get(i) == "T"){
				scheduleT.remove(scheduleT.size() -1);
			}
			if(track.get(i) == "W"){
				scheduleW.remove(scheduleW.size() -1);
			}
			if(track.get(i) == "R"){
				scheduleR.remove(scheduleR.size() - 1);
			}
			if(track.get(i) == "F"){
				scheduleR.remove(scheduleF.size() -1);
			}
		}
		
	}
	
}


