package scheduler.ycp.edu.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;


public class SchedulerViewView extends Composite {
	private SchedulerView model;
	public SchedulerViewView() {
		
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("687px", "479px");
		
		ListBox courseListBox = new ListBox();
		layoutPanel.add(courseListBox);
		layoutPanel.setWidgetLeftWidth(courseListBox, 37.0, Unit.PX, 185.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(courseListBox, 33.0, Unit.PX, 392.0, Unit.PX);
		courseListBox.setVisibleItemCount(5);
		
		Button buttonAddRequired = new Button("New button");
		buttonAddRequired.setText("Add");
		layoutPanel.add(buttonAddRequired);
		layoutPanel.setWidgetLeftWidth(buttonAddRequired, 279.0, Unit.PX, 95.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(buttonAddRequired, 51.0, Unit.PX, 48.0, Unit.PX);
		
		Button buttonRemoveRequired = new Button("New button");
		buttonRemoveRequired.setText("Remove");
		layoutPanel.add(buttonRemoveRequired);
		layoutPanel.setWidgetLeftWidth(buttonRemoveRequired, 279.0, Unit.PX, 95.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(buttonRemoveRequired, 119.0, Unit.PX, 48.0, Unit.PX);
		
		ListBox requiredListBox = new ListBox();
		layoutPanel.add(requiredListBox);
		layoutPanel.setWidgetLeftWidth(requiredListBox, 463.0, Unit.PX, 172.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(requiredListBox, 33.0, Unit.PX, 159.0, Unit.PX);
		requiredListBox.setVisibleItemCount(5);
		
		ListBox optionalListBox = new ListBox();
		optionalListBox.setVisibleItemCount(5);
		layoutPanel.add(optionalListBox);
		layoutPanel.setWidgetLeftWidth(optionalListBox, 463.0, Unit.PX, 172.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(optionalListBox, 250.0, Unit.PX, 159.0, Unit.PX);
		
		Button buttonAddOptional = new Button("New button");
		buttonAddOptional.setText("Add");
		layoutPanel.add(buttonAddOptional);
		layoutPanel.setWidgetLeftWidth(buttonAddOptional, 279.0, Unit.PX, 95.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(buttonAddOptional, 266.0, Unit.PX, 48.0, Unit.PX);
		
		Button buttonRemoveOptional = new Button("New button");
		buttonRemoveOptional.setText("Remove");
		layoutPanel.add(buttonRemoveOptional);
		layoutPanel.setWidgetLeftWidth(buttonRemoveOptional, 279.0, Unit.PX, 95.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(buttonRemoveOptional, 337.0, Unit.PX, 48.0, Unit.PX);
		
		CheckBox checkBox8AM = new CheckBox("No 8AM Classes");
		layoutPanel.add(checkBox8AM);
		layoutPanel.setWidgetLeftWidth(checkBox8AM, 37.0, Unit.PX, 155.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(checkBox8AM, 442.0, Unit.PX, 20.0, Unit.PX);
		
		CheckBox checkBoxNoEvening = new CheckBox("No Evening Classes ");
		layoutPanel.add(checkBoxNoEvening);
		layoutPanel.setWidgetLeftWidth(checkBoxNoEvening, 206.0, Unit.PX, 168.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(checkBoxNoEvening, 442.0, Unit.PX, 20.0, Unit.PX);
		
		Label labelCourseList = new Label("Course List");
		layoutPanel.add(labelCourseList);
		layoutPanel.setWidgetLeftWidth(labelCourseList, 39.0, Unit.PX, 102.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(labelCourseList, 9.0, Unit.PX, 18.0, Unit.PX);
		
		Label labelRequiredCourses = new Label("Required Courses");
		layoutPanel.add(labelRequiredCourses);
		layoutPanel.setWidgetLeftWidth(labelRequiredCourses, 467.0, Unit.PX, 138.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(labelRequiredCourses, 9.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblOptionalCourses = new Label("Optional Courses");
		layoutPanel.add(lblOptionalCourses);
		layoutPanel.setWidgetLeftWidth(lblOptionalCourses, 467.0, Unit.PX, 108.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblOptionalCourses, 226.0, Unit.PX, 18.0, Unit.PX);
	}
	

	public void update() {
		// TODO Auto-generated method stub
		
	}
}
