package scheduler.ycp.edu;

import java.io.File;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;

public class ListReadTest {
	private ListRead list; 
	private File fileName;
	private ArrayList<Course> testCourses;
	
	@Before
	public void setUp() throws Exception {
		fileName = new File("Course_List.csv");
		list = new ListRead(fileName);
		testCourses = list.Read();
	}

	@Test
	public void testListRead() throws Exception {
		assertEquals("CS101", testCourses.get(0).getNum());
		assertEquals(20168 , testCourses.get(0).CRNNum);
		assertEquals("Fund Comp Sci I", testCourses.get(0).name);
		assertEquals(2 , testCourses.get(0).credit);
		assertEquals("TR" , testCourses.get(0).days);
		assertEquals(8 , testCourses.get(0).startTime, .1);
		assertEquals(9.5 , testCourses.get(0).endTime, .1);
		assertEquals(2 , testCourses.get(0).credit);
		assertEquals("Babcock", testCourses.get(0).instructor);
		assertEquals("KEC 130", testCourses.get(0).room);
		
		assertEquals("ART101", testCourses.get(7).getNum());
		assertEquals(20759 , testCourses.get(7).CRNNum);
		assertEquals("Into Art Apprec", testCourses.get(7).name);
		assertEquals(3 , testCourses.get(7).credit);
		assertEquals("MWF" , testCourses.get(7).days);
		assertEquals(8.0 , testCourses.get(7).startTime, .1);
		assertEquals(8.5 , testCourses.get(7).endTime, .1);
		assertEquals("Stabley", testCourses.get(7).instructor);
		assertEquals("WOLF 316", testCourses.get(7).room);
	}

}
