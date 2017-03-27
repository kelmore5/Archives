package kelmore5.java.dewan.Assignments.Assignment4;

import bus.uigen.ObjectEditor;
import bus.uigen.uiFrame;
import java.util.Scanner;
import util.misc.ThreadSupport;

public class Assignment4 {
	static Scanner scanner = new Scanner(System.in); 
	static ScannerBean bean = new ScannerBean();

	public static void main(String[] args) {
		uiFrame oeFrame;
		oeFrame = ObjectEditor.edit(bean); 
		bean.setScannedString("MoVe 050 { saY \"hi!\" } Call thread wait ");
		oeFrame.refresh();
		ThreadSupport.sleep(3000);
		bean.setScannedString("RotateLeftArm 5 rotateLeftArm approach define fail move ");
		oeFrame.refresh();
		ThreadSupport.sleep(3000);
		bean.setScannedString("pass proceed redo repeat sleep undo ");
		oeFrame.refresh();
		ThreadSupport.sleep(3000);
	}
}