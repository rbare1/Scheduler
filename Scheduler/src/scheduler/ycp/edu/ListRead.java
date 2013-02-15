package scheduler.ycp.edu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ListRead {
	
	File fileName;
	
	public ListRead(File Name){
		fileName = Name;
	}
	
	public ArrayList Read() throws IOException{
	File fileName = new File("fileName");
	BufferedReader list = new BufferedReader(new FileReader(fileName));
	ArrayList<Course> courses = new ArrayList<Course>();
	String courseChoice = list.readLine();
	while(courseChoice!="NULL"){
		Course course = new Course();
		StringTokenizer description = new StringTokenizer(courseChoice,",");
		course.num = description.nextToken(); 
		course.CRNNum = Integer.valueOf(description.nextToken());
		course.name = description.nextToken();
		course.credit = description.nextToken();
		course.days = description.nextToken();
		course.startTime = Double.parseDouble(description.nextToken());
		course.endTime = Double.parseDouble(description.nextToken());
		course.instructor = description.nextToken();
		course.room = description.nextToken();
		courses.add(course);
	}
	return courses;
	}
}
