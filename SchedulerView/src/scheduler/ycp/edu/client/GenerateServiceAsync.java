package scheduler.ycp.edu.client;

<<<<<<< HEAD
=======
import scheduler.ycp.edu.Course;
>>>>>>> branch 'master' of git@github.com:rbare1/Scheduler.git
import scheduler.ycp.edu.shared.Schedule;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GenerateServiceAsync {
	
	void hello(String message, AsyncCallback<Boolean> callback);

	void generateSchedule(Schedule schedule, AsyncCallback<Boolean> callback);
}
