package scheduler.ycp.edu.client;

<<<<<<< HEAD
=======
import scheduler.ycp.edu.Course;
>>>>>>> branch 'master' of git@github.com:rbare1/Scheduler.git
import scheduler.ycp.edu.shared.Schedule;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("generate")
public interface GenerateService extends RemoteService{

	public Boolean hello(String message);
	
	public Boolean generateSchedule(Schedule schedule);
}
