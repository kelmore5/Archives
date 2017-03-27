package kelmore5.java.dewan.Assignments.Assignment3;

import kelmore5.java.dewan.Assignments.Assignment3.interfaces.BeanInterface;
import kelmore5.java.dewan.Assignments.Assignment3.interfaces.InputInterface;
import kelmore5.java.dewan.Assignments.Assignment3.tokens.EndToken;
import kelmore5.java.dewan.Assignments.Assignment3.tokens.NumberToken;
import kelmore5.java.dewan.Assignments.Assignment3.tokens.QuotedStringToken;
import kelmore5.java.dewan.Assignments.Assignment3.tokens.StartToken;
import kelmore5.java.dewan.Assignments.Assignment3.tokens.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString"})
@EditablePropertyNames({"ScannedString"})
public class ScannerBean implements BeanInterface {
	public String ScannedString;

	public ScannerBean(){
		ScannedString = "";
	}

	public String getScannedString() {
		return ScannedString;
	}

	public void setScannedString(String scannedString) {
		ScannedString = scannedString;
		parseInput(scannedString);
	}

	public static void parseInput(String input) {
		InputInterface token = null;

		for(int i = 0; i < input.length()-1; i++) {			
			String token_string = "";
			
			char c = input.charAt(i);
			if(c == '"') {
				i++;
				c = input.charAt(i);

				while(c != '"') {
					token_string += c;
					i++;
					c = input.charAt(i);
				}

				token = new QuotedStringToken(token_string);
				
				System.out.println(token);
				System.out.println(token.getInput());
				i++;
			} else {
				if(Character.isDigit(c)) {//if digit
					
					while(Character.isDigit(c)) {
						token_string += c;
						i++;
						c = input.charAt(i);
					}

					token = new NumberToken(token_string);
					
					System.out.println(token);
					System.out.println(token.getInput());
					System.out.println(((NumberToken) token).getValue());
				} else if(c == '{') {
					token_string = "" + c;
					token = new StartToken(token_string);
					
					System.out.println(token);
					System.out.println(token.getInput());
					i++;
				} else if(c == '}') {
					token_string = "" + c;
					token = new EndToken(token_string);
					
					System.out.println(token);
					System.out.println(token.getInput());
					i++;
				} else {
					while(c != ' ') {
						token_string += c;

						i++;
						c = input.charAt(i);
					}

					token = new WordToken(token_string);
					
					System.out.println(token);
					System.out.println(token.getInput());
					System.out.println(((WordToken) token).getValue());
				}
			}
		}
	}
}
