package scheduler.ycp.edu;

import java.io.File;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;

public class ListReadTest {
	private ListRead list;
	
	@Before
	public void setUp() throws Exception {		
	}

	@Test
	public void testListRead() throws Exception {
		File fileName = new File("Course_List.csv");
		list = new ListRead(fileName);
		ArrayList<Course> testCourses = new ArrayList<Course>();
		testCourses = list.Read();
		assertEquals("CS101", testCourses.get(0).name);  
	}

}
