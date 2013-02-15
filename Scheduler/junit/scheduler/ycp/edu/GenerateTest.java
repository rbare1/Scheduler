package scheduler.ycp.edu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GenerateTest {

	// fields for text fixture objects
		private Course course1 = new Course();
		private Course course2 = new Course();
		private Course course3 = new Course();
		private Course course4 = new Course();
		private Course course5 = new Course();

		@Before
		public void setUp() {
		// create test fixture objects
			course1.name = "CS101";
			course1.days = "MWF";
			
			course2.name = "ART101";
			course2.days = "MW";
			
			course3.name = "PE101";
			course3.days = "F";
			
			course4.name = "ECE101";
			course4.days = "TR";
			
			course5.name = "PHY101";
			course1.days = "R";
			
		}
	@Test
public void testGetCourse() throws Exception {		
		assertEquals("CS101", course1.getCourse().name);
		
	}

}
