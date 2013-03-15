package scheduler.ycp.edu.client;

<<<<<<< HEAD
import scheduler.ycp.edu.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SchedulerView implements EntryPoint {
	public void onModuleLoad() {
		FlowPanel panel = new FlowPanel();
		
		//Label helloWorld = new Label("Hello, world!");
		SchedulerViewView schedulerView = new SchedulerViewView();
		panel.add(schedulerView);
		
		//SchedulerView model = new SchedulerView();

		schedulerView.update();
		
		RootLayoutPanel.get().add(panel);
		//RootLayoutPanel.get().setWidgetTopBottom(panel, 10.0, Unit.PX, 10.0, Unit.PX);
		//RootLayoutPanel.get().setWidgetLeftRight(panel, 10.0, Unit.PX, 10.0, Unit.PX);
=======
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import scheduler.ycp.edu.shared.Schedule; 


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SchedulerView implements EntryPoint {

	public void onModuleLoad() {
		FlowPanel panel = new FlowPanel();
		
		SchedulerViewView schedulerView = new SchedulerViewView();
		panel.add(schedulerView);
		Schedule model = new Schedule();
		
		schedulerView.setModel(model);
		schedulerView.update();
		
		RootLayoutPanel.get().add(panel);
		RootLayoutPanel.get().setWidgetTopBottom(panel, 10.0, Unit.PX, 10.0, Unit.PX);
		RootLayoutPanel.get().setWidgetLeftRight(panel, 10.0, Unit.PX, 10.0, Unit.PX);
>>>>>>> refs/remotes/amille61/master
	}
}
