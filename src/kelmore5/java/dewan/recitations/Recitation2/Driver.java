package kelmore5.java.dewan.recitations.Recitation2;

import bus.uigen.ObjectEditor;

public class Driver { 
	public static void main(String[] args) { 
		UppercaseFilter filter = new AnUppercaseFilter(); 
		filter.setInputString("Initial Input"); 
		ObjectEditor.edit(filter); 
	} 
} 