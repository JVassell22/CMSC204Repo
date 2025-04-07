import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {
	LinkedList<CourseDBElement>[] classTable;
	int size;
	
	public CourseDBStructure(int n) {
		int num = (int) (n/1.5);
		size = findPrime(num);
		classTable = new LinkedList[size];
	}

	public CourseDBStructure(String test, int n) {
		size = n;
		classTable = new LinkedList[n];

	}
	
	public boolean contains(int crn) {
		String temp = Integer.toString(crn);
		int hashIndex = Math.abs(temp.hashCode() % size);
		if(classTable[hashIndex] == null) {
			return false;
		}
		else {
			for(int i = 0; i < classTable[hashIndex].size(); i++) {
				if(classTable[hashIndex].get(i).crn == crn) {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public void add(CourseDBElement element) {
		LinkedList<CourseDBElement> tempList;
		int hashIndex = Math.abs(element.hashCode() % size);
		if(classTable[hashIndex] == null) {
			classTable[hashIndex] = new LinkedList<CourseDBElement>();
			classTable[hashIndex].add(element);
		}
		else if(!contains(element.getCRN())) {
			classTable[hashIndex].add(element);
		} else
			try {
				if(!get(element.getCRN()).equals(element)) {
					tempList = classTable[hashIndex];
					for(int i = 0; i < tempList.size(); i++) {
						if(tempList.get(i).getCRN() == element.getCRN()) {
							tempList.set(i, element);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		String temp = Integer.toString(crn);
		int hashIndex = Math.abs(temp.hashCode() % size);
		if(classTable[hashIndex] == null) {
			throw new IOException();
		}
		else {
			for(int i = 0; i < classTable[hashIndex].size(); i++) {
				if(classTable[hashIndex].get(i).getCRN() == crn) {
					return classTable[hashIndex].get(i);
				}
			}
		}
		throw new IOException();
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> temp = new ArrayList<>();
		for(int i = 0; i < classTable.length; i++) {
			if(classTable[i] != null) {
				for(int j = 0; j < classTable[i].size(); j++) {
					temp.add(classTable[i].get(j).toString());
				}
			}
		}
		return temp;
	}

	@Override
	public int getTableSize() {
		return size;
	}
	
	private int findPrime(int n) {
		int prime = (n/4);
		while(!isItPrime((4*prime+3))) {
			prime++;
		}
		return (4*prime+3);
	}
	
	private boolean isItPrime(int n) {
		for(int i = 2; i < Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	

}
