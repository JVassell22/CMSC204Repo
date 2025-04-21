import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	static MorseCodeTree tree = new MorseCodeTree();
	
	public MorseCodeConverter() {
		
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		Scanner in = new Scanner(codeFile);
		String temp = "";
		while(in.hasNext()) {
			String s = in.next();
			if(!s.equals(" ") && !s.equals("/")) {
				temp+=tree.fetch(s);
			}
			else if(s.equals("/")) {
				temp+=" ";
			}
		}
		in.close();
		return temp;
	}
	
	public static String convertToEnglish(String code) {
		String temp = "";
		String[] stringArr = code.split(" ");
		for(String s : stringArr) {
			if(s.equals("/")) {
				temp += " ";
			}
			else {
				temp+=tree.fetch(s);
			}
		}
		return temp;
	}
	
	public static String printTree() {
		ArrayList<String> tempArr = tree.toArrayList();
		String temp = "";
		for(String s: tempArr) {
			temp += s+" ";
		}
		return temp.substring(0, temp.length()-1);
	}

}
