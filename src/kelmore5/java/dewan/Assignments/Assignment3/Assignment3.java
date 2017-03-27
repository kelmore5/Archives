package kelmore5.java.dewan.Assignments.Assignment3;

import java.util.Scanner;

public class Assignment3 {
	static Scanner scanner = new Scanner(System.in); 
	static ScannerBean bean = new ScannerBean();

	public static void main(String[] args) {
		//			move Arthur 30 40 say "Quest?" say "2" "$%!@" 
		String input = scanner.nextLine(); 
		
		while(!input.equals(".")) {
			bean.setScannedString(input);
			input = scanner.nextLine();
		}
	}
}