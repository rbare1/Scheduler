package scheduler.ycp.edu.server;

import scheduler.ycp.edu.client.GenerateService;
import scheduler.ycp.edu.client.SchedulerView;
import scheduler.ycp.edu.shared.Schedule;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ScheduleServiceImpl extends RemoteServiceServlet implements GenerateService{

	@Override
	public Boolean hello(String message) {
		System.out.println("Hello: " + message);
		return true;
	}

	@Override
	public Boolean generateSchedule(Schedule schedule) {
		
		return true;
	}

}
