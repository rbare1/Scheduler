package scheduler.ycp.edu.server;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import scheduler.ycp.edu.client.CreateKeyListService;
import scheduler.ycp.edu.shared.Course;
import scheduler.ycp.edu.shared.Schedule;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class CreateDatabaseImpl extends RemoteServiceServlet implements CreateKeyListService{
	//private FakeDatabase database;
	FakeDatabase database = new FakeDatabase();
	public ArrayList<Course> pullDatabase(String courseName){
			ArrayList<Course> course = (ArrayList<Course>) database.findCourse(courseName);
			return course;
	}
	
	public ArrayList<String> pullKeyList(){
		File fileName = new File("Course_List.csv");
		//FakeDatabase database = new FakeDatabase();
		try {
			database.CreateFakeDatabase(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Collection<String> tempCourseList = database.getDatabase().keySet();
		
		ArrayList<String> result = new ArrayList<>();
		result.addAll(database.getDatabase().keySet());
		return result;
	}
	
	@Override
	public Boolean createCSV(ArrayList<Course> totalSchedule) {
		FileWriter writer;
		try {
			// creates CSV file whenever the Generate Button is pressed
			// change it to use the database to generate the schedule on a page like
			// website.com/schedule1
			writer = new FileWriter("H:\\git\\Scheduler\\SchedulerView\\Schedules.csv");
			for(int i = 0; i < totalSchedule.size(); i++){
				writer.append((char)totalSchedule.get(i).getCRNNum());
			    writer.append(',');
			    writer.append(totalSchedule.get(i).getName());
			    writer.append(',');
			    writer.append(totalSchedule.get(i).getNum());
			    writer.append(',');
			    writer.append((char)totalSchedule.get(i).getCredit());
			    writer.append(',');
			    writer.append(totalSchedule.get(i).getDays());
			    writer.append(',');
			    writer.append((char)totalSchedule.get(i).getStartTime());
			    writer.append(',');
			    writer.append((char)totalSchedule.get(i).getEndTime());
			    writer.append(',');
			    writer.append(totalSchedule.get(i).getInstructor());
			    writer.append(',');
			    writer.append(totalSchedule.get(i).getRoom());
			    writer.append('\n');
			}
	 
		    writer.flush();
		    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public Boolean saveSchedule(ArrayList<Course> totalSchedule) {
		IDatabase database = DBUtil.instance();	
		try {		
			database.saveSchedule(totalSchedule);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}
	
	public ArrayList<Course> getSchedule(int scheduleId) {
		IDatabase database = DBUtil.instance();	
		ArrayList<Course> schedule = new ArrayList<Course>();
		try {		
			schedule.addAll(database.getSchedule(scheduleId));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		Course course = new Course();
//		course.setNum("Database test Course");
//		schedule.add(course);
		return schedule;
	}

}
