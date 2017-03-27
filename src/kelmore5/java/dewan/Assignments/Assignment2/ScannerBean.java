package kelmore5.java.dewan.Assignments.Assignment2;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString"})
@EditablePropertyNames({"ScannedString"})
public class ScannerBean {
	public String ScannedString;
	
	public ScannerBean(){
		ScannedString = "";
	}

	public String getScannedString() {
		return ScannedString;
	}

	public void setScannedString(String scannedString) {
		ScannedString = scannedString;
		String output = parseInput(scannedString);
		System.out.println(output);
	}
	
	//Parses the string ^ in function main
		public static String parseInput(String input) {
			//Create an ouput string - the output Prasun is looking for
			String output_string = "";
							
			//Loop through the string
			for(int i = 0; i < input.length()-1; i++) {			
				//Get the character at the given int i in the String input
				char c = input.charAt(i);
				
				//Trying to check for...
				//If the first character is a digit or a character
				//in other words...
					//if the word starts with a letter m or A or a number 1, 2 etc - then it's one categor
					//if it starts with a quoted string " ", it's another
				//lol this might not make sense but in coding terms:
				if(c == '"') {
					output_string += "quoted string: ";
					i++;
					c = input.charAt(i);
					
					//now, loop through and get the number
					while(c != '"') {
						output_string += c;
						i++;
						c = input.charAt(i);
					}
					i++;
					
					output_string += "\n\n";
				} else {
					//If the character's not a quote ", it's either a number or character
					if(Character.isDigit(c)) {//if digit
						//output is a number
						output_string += "number: ";
						
						//now, loop through and get the number
						while(Character.isDigit(c)) {
							output_string += c;
							i++;
							c = input.charAt(i);
						}
						
						output_string += "\n\n";
					} else {
						//otherwise, output is a word
						output_string += "word: ";
						
						//loop will end when c is not a space ' '
						while(c != ' ') {
							//if character c is not a space, 
							//it's a letter, so add it to the output string
							output_string += c;
							
							//then go up one on the string in the loop ^^
							i++;
							c = input.charAt(i);
						}
						
						output_string += "\n\n";
					}
				}
			}		
			
			return output_string;
		}
}
