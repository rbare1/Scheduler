package scheduler.ycp.edu;

import java.io.File;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
=======
import java.util.List;

>>>>>>> branch 'master' of git@github.com:rbare1/Scheduler.git
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import scheduler.ycp.edu.shared.Course;
import scheduler.ycp.edu.shared.ListRead;
<<<<<<< HEAD

import scheduler.ycp.edu.shared.Course;
import scheduler.ycp.edu.shared.ListRead;
=======
>>>>>>> branch 'master' of git@github.com:rbare1/Scheduler.git

public class ListReadTest {
	private ListRead list;
	private File fileName;
	private List<Course> testCourses;
<<<<<<< HEAD
	
=======
	
>>>>>>> branch 'master' of git@github.com:rbare1/Scheduler.git
	@Before
	public void setUp() throws Exception {
		fileName = new File("Course_List.csv");
		list = new ListRead(fileName);
		testCourses = list.Read();
	}

	@Test
<<<<<<< HEAD
	public void testListRead() throws Exception {
		assertEquals("CS101", testCourses.get(0).getNum());
=======
	public void testListRead() throws Exception {

		assertEquals("CS101", testCourses.get(0).getNum());

		assertEquals(20168 , testCourses.get(0).getCRNNum());
		assertEquals("Fund Comp Sci I", testCourses.get(0).getName());
		assertEquals(2 , testCourses.get(0).getCredit());
		assertEquals("TR" , testCourses.get(0).getDays());
		assertEquals(8 , testCourses.get(0).getStartTime(), .1);
		assertEquals(9.5 , testCourses.get(0).getEndTime(), .1);
		assertEquals("Babcock", testCourses.get(0).getInstructor());
		assertEquals("KEC 130", testCourses.get(0).getRoom());
		
		assertEquals("CS101", testCourses.get(1).getNum());

		
		assertEquals("ART101", testCourses.get(7).getNum());

		assertEquals(20759 , testCourses.get(7).getCRNNum());
		assertEquals("Intro Art Apprec", testCourses.get(7).getName());
		assertEquals(3 , testCourses.get(7).getCredit());
		assertEquals("MWF" , testCourses.get(7).getDays());
		assertEquals(8.0 , testCourses.get(7).getStartTime(), .1);
		assertEquals(8.5 , testCourses.get(7).getEndTime(), .1);
		assertEquals("Stabley", testCourses.get(7).getInstructor());
		assertEquals("WOLF 316", testCourses.get(7).getRoom());
>>>>>>> branch 'master' of git@github.com:rbare1/Scheduler.git

<<<<<<< HEAD
		assertEquals(20168, testCourses.get(0).getCRNNum());
		assertEquals("Fund Comp Sci I", testCourses.get(0).getName());
		assertEquals(2, testCourses.get(0).getCredit());
		assertEquals("TR", testCourses.get(0).getDays());
		assertEquals(8, testCourses.get(0).getStartTime(), .1);
		assertEquals(9.5, testCourses.get(0).getEndTime(), .1);
		assertEquals("Babcock", testCourses.get(0).getInstructor());
		assertEquals("KEC 130", testCourses.get(0).getRoom());

		assertEquals("ART101", testCourses.get(7).getNum());

		assertEquals(20759, testCourses.get(7).getCRNNum());
		assertEquals("Intro Art Apprec", testCourses.get(7).getName());
		assertEquals(3, testCourses.get(7).getCredit());
		assertEquals("MWF", testCourses.get(7).getDays());
		assertEquals(8.0, testCourses.get(7).getStartTime(), .1);
		assertEquals(8.5, testCourses.get(7).getEndTime(), .1);
		assertEquals("Stabley", testCourses.get(7).getInstructor());
		assertEquals("WOLF 316", testCourses.get(7).getRoom());

	}
}
=======

	}
}
>>>>>>> branch 'master' of git@github.com:rbare1/Scheduler.git
