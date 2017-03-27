package kelmore5.java.dewan.recitations.Recitation11.main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Driver {
	public static void main(String[] args) {
		Scene test = new AScene();
		OEFrame editor = ObjectEditor.edit(test);
		editor.setSize(800, 700);
		test.demo();
	}
}
