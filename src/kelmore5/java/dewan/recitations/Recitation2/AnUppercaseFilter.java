package kelmore5.java.dewan.recitations.Recitation2;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern; 

@StructurePattern("Bean Pattern") 
@PropertyNames({"InputString","UppercaseLetters"}) 
@EditablePropertyNames({"InputString"}) 
public class AnUppercaseFilter implements UppercaseFilter {
	public String inputString;
	public String uppercaseLetters;
	
	public AnUppercaseFilter() {
		uppercaseLetters = "";
	}
	
	public void setInputString(String input) {
		System.out.println("setInputString is called");
		
		this.inputString = input;
		this.uppercaseLetters = "";
		
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if(Character.isUpperCase(c)) {
				uppercaseLetters += c;
			}
		}
	}
	
	public String getUppercaseLetters() {
		System.out.println("getUppercaseLetters is called");
		return uppercaseLetters;
	}
	
	public String getInputString() {
		System.out.println("getInputString is called");
		return inputString;
	}
}
