import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class CourseDBManager_STUDENT_Test {
	
	CourseDBManagerInterface studentMgr;

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		studentMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		studentMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			studentMgr.add("ENGL101",12354, 3, "HUM109", "Michael Smith");
			studentMgr.add("HIST202",54672, 4, "HUM301", "John Robert");

		}
		catch(Exception e) {
			fail("add method caused exception");
		}
	}
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		studentMgr.add("ENGL101",12354, 3, "HUM109", "Michael Smith");
		studentMgr.add("HIST202",12355, 4, "HUM301", "John Robert");
		studentMgr.add("CHEM131",12353, 4, "SC110", "Kate Hubbard");
		ArrayList<String> list = studentMgr.showAll();
		assertEquals(list.get(2),"\nCourse:HIST202 CRN:12355 Credits:4 Instructor:John Robert Room:HUM301");
		assertEquals(list.get(1),"\nCourse:ENGL101 CRN:12354 Credits:3 Instructor:Michael Smith Room:HUM109");
		assertEquals(list.get(0),"\nCourse:CHEM131 CRN:12353 Credits:4 Instructor:Kate Hubbard Room:SC110");
		
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		File inFile = new File("Student_Test");
		PrintWriter in;
		try {
			in = new PrintWriter(inFile);
			in.println("ENGL101 12354 3 Michael Smith");
			in.println("HIST202 54672 4 John Robert");
			in.println("CHEM131 54030 4 Kate Hubbard");
			
			in.close();
			studentMgr.readFile(inFile);
			assertEquals("ENGL101",studentMgr.get(12354).getID());
			assertEquals("HIST202",studentMgr.get(54672).getID());
		} 
		catch (Exception e) {
			fail("Should not have thrown exception");
		}
		
		
		
	}

}
