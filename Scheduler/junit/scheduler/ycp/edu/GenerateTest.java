package scheduler.ycp.edu;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class GenerateTest {

	// fields for text fixture objects
		private Course course1 = new Course(null, 0, null, 0, null, 0, 0, null, null);
		private Course course2 = new Course(null, 0, null, 0, null, 0, 0, null, null);
		private Course course3 = new Course(null, 0, null, 0, null, 0, 0, null, null);
		private Course course4 = new Course(null, 0, null, 0, null, 0, 0, null, null);
		private Course course5 = new Course(null, 0, null, 0, null, 0, 0, null, null);
		ArrayList<Course> scheduleM = new ArrayList<Course>();
		ArrayList<Course> scheduleT = new ArrayList<Course>();
		ArrayList<Course> scheduleW = new ArrayList<Course>();
		ArrayList<Course> scheduleR = new ArrayList<Course>();
		ArrayList<Course> scheduleF = new ArrayList<Course>();

		@Before
		public void setUp() {
		// create test fixture objects
			course1.setNum("CS101");
			course1.setDays("MWF");
			scheduleM.add(course1);
			scheduleW.add(course1);
			
			course2.setNum("ART101");
			course2.setDays("MW");
			scheduleM.add(course2);
			scheduleW.add(course2);
			
			course3.setNum("PE101");
			course3.setDays("F");
			scheduleF.add(course3);
			
			course4.setNum("ECE101");
			course4.setDays("TR");
			scheduleT.add(course4);
			scheduleR.add(course4);
			
			course5.setNum("PHY101");
			course1.setDays("R");
			scheduleR.add(course5);
			
		}
		
	@Test
	public void testGetScheduleM() throws Exception {	
		 assertEquals("CS101", scheduleM.get(0).getNum());	
		 assertEquals("ART101", scheduleM.get(1).getNum());	
		}
	
	public void testGetScheduleT() throws Exception {	
		 assertEquals("ECE101", scheduleT.get(0).getNum());		
		}
	
	public void testGetScheduleW() throws Exception {	
		assertEquals("CS101", scheduleW.get(0).getNum());	
		 assertEquals("ART101", scheduleW.get(1).getNum());	
		}
	
	public void testGetScheduleR() throws Exception {	
		 assertEquals("ECE101", scheduleR.get(0).getNum());	
		 assertEquals("PHY101", scheduleR.get(0).getNum());	
		}
	
	public void testGetScheduleF() throws Exception {	
		 assertEquals("CS101", scheduleF.get(0).getNum());	
		}

}
