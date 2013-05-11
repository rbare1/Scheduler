package scheduler.ycp.edu.client;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.impl.SchedulerImpl;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import scheduler.ycp.edu.server.DerbyDatabase;
import scheduler.ycp.edu.shared.Course;
import scheduler.ycp.edu.shared.Generate;
import scheduler.ycp.edu.shared.GenerateInit;
import scheduler.ycp.edu.shared.IPublisher;
import scheduler.ycp.edu.shared.ISubscriber;
import scheduler.ycp.edu.shared.Schedule;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;

public class GenerateView extends Composite implements ISubscriber{
	
	private Schedule model;
	//private SchedulerViewView schedulerViewView;
	private ArrayList<Course> requiredCourseList = new ArrayList<Course>();
	private ArrayList<Course> optionalCourseList = new ArrayList<Course>();
	private List<Course> scheduleM = new ArrayList<Course>();
	private List<Course> scheduleT = new ArrayList<Course>();
	private List<Course> scheduleW = new ArrayList<Course>();
	private List<Course> scheduleR = new ArrayList<Course>();
	private List<Course> scheduleF = new ArrayList<Course>();
	private ArrayList<Course> totalSchedule = new ArrayList<Course>();
	private SchedulerViewView schedulerView;
	FlowPanel panel = new FlowPanel();
	
	private DataGrid<Course> dataGrid;
	
	public GenerateView() {
		
		
		this.schedulerView = new SchedulerViewView();
		panel.add(schedulerView);
//		Schedule model = new Schedule();
//		
//		schedulerView.setModel(model);
//		schedulerView.update();
	
		Button generateButton = new Button("Generate");
		generateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String courseName;
				if(!model.getRequiredList().isEmpty()){
					for(int i =0; i < model.getRequiredList().size(); i++){
							courseName = model.getRequiredList().get(i);
							handleGetDatabase(courseName);	//generate
					}
				}
			}
		});
		panel.add(generateButton);
		
		initWidget(panel);
		panel.setSize("932px", "517px");
			
		
		//output each course with it's information
		dataGrid = new DataGrid<Course>();
		panel.add(dataGrid);
		dataGrid.setSize("905px", "424px");
		dataGrid.addColumn(new CourseCRNColumn(), "CRN");
		dataGrid.addColumn(new CourseNameColumn(), "Name");
		dataGrid.addColumn(new CourseNumColumn(), "Course Num");
		dataGrid.addColumn(new CourseCreditColumn(), "Credit");
		dataGrid.addColumn(new CourseDaysColumn(), "Days");
		dataGrid.addColumn(new CourseStartTimeColumn(), "Start Time");
		dataGrid.addColumn(new CourseEndTimeColumn(), "End Time");
		dataGrid.addColumn(new CourseInstructorColumn(), "Instructor");
		dataGrid.addColumn(new CourseRoomColumn(), "Room");
	}
	
	private static class CourseCRNColumn extends TextColumn<Course> {
		@Override
		public String getValue(Course object) {
			return String.valueOf(object.getCRNNum());
		}
	}
	
	private static class CourseNameColumn extends TextColumn<Course> {
		@Override
		public String getValue(Course object) {
			return object.getName();
		}
	}
	
	private static class CourseNumColumn extends TextColumn<Course> {
		@Override
		public String getValue(Course object) {
			return object.getNum();
		}
	}
	
	private static class CourseCreditColumn extends TextColumn<Course> {
		@Override
		public String getValue(Course object) {
			return String.valueOf(object.getCredit());
		}
	}
	
	private static class CourseDaysColumn extends TextColumn<Course> {
		@Override
		public String getValue(Course object) {
			return object.getDays();
		}
	}
	
	private static class CourseStartTimeColumn extends TextColumn<Course> {
		@Override
		public String getValue(Course object) {
			return String.valueOf(object.getStartTime());
		}
	}
	
	private static class CourseEndTimeColumn extends TextColumn<Course> {
		@Override
		public String getValue(Course object) {
			return String.valueOf(object.getEndTime());
		}
	}
	
	private static class CourseInstructorColumn extends TextColumn<Course> {
		@Override
		public String getValue(Course object) {
			return object.getInstructor();
		}
	}
	
	private static class CourseRoomColumn extends TextColumn<Course> {
		@Override
		public String getValue(Course object) {
			return object.getRoom();
		}
	}
	
	public void setModel(Schedule model){
		this.model = model;
		schedulerView.setModel(model);
	}

	protected void handleGenerate() {
			RPC.generateService.generateSchedule(model, new AsyncCallback<Boolean>(){
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Fail!", caught);
			}

			@Override
			public void onSuccess(Boolean result) {		
				//moved to handleGetDatabase, remove later
			}
			
		});
		
	}
	protected void handleGetDatabase(String courseName) {
		RPC.keyListService.pullDatabase(courseName, new AsyncCallback<ArrayList<Course>>() {

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Fail!", caught);

			}

			@Override
			public void onSuccess(ArrayList<Course> result) {
				
				if(!requiredCourseList.contains(result)){
					GWT.log(result.get(0).getNum() + "SUCCESS");
					requiredCourseList.add(result.get(0));	//adds the first instance of the course [temporary]
				}

				
				if (requiredCourseList.size() == model.getRequiredList().size() ) {
					GWT.log(model.getRequiredList().get(0) + "list");
					Generate generate = new Generate();
					if(!requiredCourseList.isEmpty()){
						generate.GenerateSchedule(requiredCourseList, optionalCourseList);
						scheduleM = generate.getScheduleM();
						scheduleT = generate.getScheduleT();
						scheduleW = generate.getScheduleW();
						scheduleR = generate.getScheduleR();
						scheduleF = generate.getScheduleF();
						totalSchedule = (ArrayList<Course>) generate.getTotalSchedule();
						
						// Display total schedule in grid
						dataGrid.setRowCount(totalSchedule.size());
						dataGrid.setRowData(totalSchedule);
						
						GWT.log("GENERATED");
					}
					GWT.log("Monday");
					if(!scheduleM.isEmpty()){
						for(int i = 0; i < scheduleM.size(); i ++){
							GWT.log(scheduleM.get(i).getNum() + "M");
						}
					}
					else{
						GWT.log("M is empty");
					}
					GWT.log("Friday");
					if(!scheduleF.isEmpty()){
						GWT.log(scheduleF.get(0).getNum());
					}
					else{
						GWT.log("F is empty");
					}
					handleCreateCSV();
					handleSaveSchedule();
				}
				
			}

		});

	}

	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {
		// TODO Auto-generated method stub
		
	}
	
	protected void handleCreateCSV() {
		RPC.keyListService.createCSV(totalSchedule, new AsyncCallback<Boolean>(){
		@Override
		public void onFailure(Throwable caught) {
			GWT.log("Fail!", caught);
		}

		@Override
		public void onSuccess(Boolean result) {		
			//CSV created
		}
		
	});
	
	}
	protected void handleSaveSchedule() {
		GWT.log("Save Handle Start");
		RPC.keyListService.saveSchedule(totalSchedule, new AsyncCallback<Boolean>(){
		@Override
		public void onFailure(Throwable caught) {
			GWT.log("Fail! ScheduleSave", caught);
		}

		@Override
		public void onSuccess(Boolean result) {	
			GWT.log("Added to the database");
			handleGetSchedule(1);
		}
		
	});
	
	}
	
	protected void handleGetSchedule(int scheduleId) {
		RPC.keyListService.getSchedule(scheduleId, new AsyncCallback<ArrayList<Course>>(){
		@Override
		public void onFailure(Throwable caught) {
			GWT.log("Fail! GetSchedule", caught);
		}


		@Override
		public void onSuccess(ArrayList<Course> result) {
			if(!result.isEmpty()){
				GWT.log(result.get(0).getNum() + " retrieved from database");
			}
			else{
				GWT.log("Database retrieval failed");
			}
			
		}
		
	});
	
	}

}
