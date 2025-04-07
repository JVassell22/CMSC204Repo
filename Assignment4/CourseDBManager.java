import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	
	CourseDBStructure classTable;
	
	public CourseDBManager() {
		classTable = new CourseDBStructure(500); // estimated value of array size 
	}

	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement temp = new CourseDBElement(id, crn, credits, roomNum, instructor);
		classTable.add(temp);
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return(classTable.get(crn));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader(input));
		String course;
		try {
			while((course = in.readLine()) != null) {
				CourseDBElement element = new CourseDBElement();
				String[] tempArr = course.split(" ");
					
				element.id = tempArr[0];
				element.crn = Integer.parseInt(tempArr[1]);
				element.credits = Integer.parseInt(tempArr[2]);
				element.roomNum = tempArr[3];
				for(int i = 3; i < tempArr.length; i++) {
					element.instructor += tempArr[i]+" ";	
				}
				classTable.add(element);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<String> showAll() {
		return(classTable.showAll());
	}

}
