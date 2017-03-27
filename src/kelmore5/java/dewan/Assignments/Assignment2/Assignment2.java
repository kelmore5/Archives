package kelmore5.java.dewan.Assignments.Assignment2;

import java.util.Scanner;

public class Assignment2 {
	//gets input from the user
	static Scanner scanner = new Scanner(System.in); 
	static ScannerBean bean = new ScannerBean();

	//
	public static void main(String[] args) {
		//input: for the input for the user
		//		takes in next line e.g. 
		//			move Arthur 30 40 say "Quest?" say "2" "$%!@" 
		String input = scanner.nextLine(); 
		
		while(!input.equals(".")) {
			bean.setScannedString(input);
			input = scanner.nextLine();
		}
	}
}