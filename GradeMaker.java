
public class GradeMaker {

	public static void main(String[] args) {
		GradeBook n1 = new GradeBook(2);
		n1.addScore(80);
		n1.addScore(100);
		String i = n1.toString();
		System.out.println(i);
	}

}
