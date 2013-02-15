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
			course1.setName("CS101");
			course1.setDays("MWF");
			
			course2.setName("ART101");
			course2.setDays("MW");
			
			course3.setName("PE101");
			course3.setDays("F");
			
			course4.setName("ECE101");
			course4.setDays("TR");
			
			course5.setName("PHY101");
			course1.setDays("R");
			
		}
	@Test
public void testGetCourse() throws Exception {		
		assertEquals("CS101", course1.);
		
	}

}
