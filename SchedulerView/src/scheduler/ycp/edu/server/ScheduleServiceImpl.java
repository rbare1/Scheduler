package scheduler.ycp.edu.server;

import java.io.File;
import java.io.IOException;

import scheduler.ycp.edu.client.GenerateService;
import scheduler.ycp.edu.shared.FakeDatabase;
import scheduler.ycp.edu.shared.Schedule;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ScheduleServiceImpl extends RemoteServiceServlet implements GenerateService{

	private FakeDatabase database;
	@Override
	public Boolean hello(String message) {
		System.out.println("Hello: " + message);
		return true;
	}

	@Override
	public Boolean generateSchedule(Schedule schedule) {
		
		return true;
	}
	
	public Boolean pullDatabase(){
		
		File fileName = new File("Course_List.csv");
		try {
			database.CreateFakeDatabase(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
