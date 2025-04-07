
public class CourseDBElement implements Comparable<CourseDBElement> {

	String id, roomNum, instructor;
	int crn, credits;
	
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.id = id;
		this.roomNum = roomNum;
		this.instructor = instructor;
		this.crn = crn;
		this.credits = credits;
	}
	
	public CourseDBElement() {
		this.id = null;
		this.roomNum = null;
		this.instructor = null;
		this.crn = 0;
		this.credits = 0;
	}
	
	public String getID() {
		return id;
	}
	
	public int getCRN() {
		return crn;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	
	public String getInstructor() {
		return instructor;
	}
	
	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	@Override
	public boolean equals (Object element) {
		if(element == null || element.getClass() != getClass()) {
			return false;
		}
		CourseDBElement temp = (CourseDBElement) element;
		return(temp.crn == this.crn && temp.id.equals(this.id) && temp.roomNum.equals(this.roomNum) && temp.credits == this.credits 
				&& temp.instructor.equals(this.instructor));
		
	}
	
	@Override
	public int compareTo(CourseDBElement course) {
		if(this.crn > course.crn) {
			return 1;
		}
		else if(this.crn == course.crn) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		return("\nCourse:"+id+" CRN:"+crn+" Credits:"+credits+" Instructor:"+instructor+" Room:"+roomNum);
	}
	
	@Override
	public int hashCode() {
		return String.valueOf(crn).hashCode();
	}
}
