package scheduler.ycp.edu.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DatabaseServiceAsync {

	void pullDatabase(AsyncCallback<Boolean> callback);
}
