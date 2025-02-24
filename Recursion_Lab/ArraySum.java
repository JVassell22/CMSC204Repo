
public class ArraySum {
	
	public ArraySum() {
		
	}
	
	public int sumOfArray(Integer[] a, int index) {
		if(index == a.length-1) {
			return a[index];
		}
		else if(a[index+1] == null) {
			return a[index];
		}
		
		return(a[index] + sumOfArray(a, index+1));
	}
}
