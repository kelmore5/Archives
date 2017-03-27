package kelmore5.java.dewan.Assignments.Assignment4;

import kelmore5.java.dewan.Assignments.Assignment4.commands.*;
import kelmore5.java.dewan.Assignments.Assignment4.commands.Thread;
import kelmore5.java.dewan.Assignments.Assignment4.interfaces.BeanInterface;
import kelmore5.java.dewan.Assignments.Assignment4.interfaces.InputInterface;
import kelmore5.java.dewan.Assignments.Assignment4.tokens.*;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString", "tokens"})
@EditablePropertyNames({"ScannedString"})
public class ScannerBean implements BeanInterface {
	public String ScannedString;
	
	@Visible(false)
	private static InputInterface[] largeTokenArray;
	private InputInterface[] tokens;
	
	private static int count;

	public ScannerBean(){
		ScannedString = "";
		largeTokenArray = new InputInterface[10];
		tokens = new InputInterface[0];
		count = 0;
	}

	public String getScannedString() {
		return ScannedString;
	}

	public void setScannedString(String scannedString) {
		ScannedString = scannedString;
		largeTokenArray = new InputInterface[scannedString.length()];
		tokens = new InputInterface[10];
		count = 0;
		parseInput(scannedString);
	}
	
	public InputInterface[] getTokens() {
		tokens = new InputInterface[count];
		for(int i = 0; i < tokens.length; i++) {
			tokens[i] = largeTokenArray[i];
		}
		return tokens;
	}

	public static void parseInput(String input) {
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

				largeTokenArray[count++] = new QuotedStringToken(token_string);
				i++;
			} else {
				if(Character.isDigit(c)) {//if digit
					
					while(Character.isDigit(c)) {
						token_string += c;
						i++;
						c = input.charAt(i);
					}

					largeTokenArray[count++] = new NumberToken(token_string);
				} else if(c == '{') {
					token_string = "" + c;
					largeTokenArray[count++] = new StartToken(token_string);
					i++;
				} else if(c == '}') {
					token_string = "" + c;
					largeTokenArray[count++] = new EndToken(token_string);
					i++;
				} else {
					while(c != ' ') {
						token_string += c;

						i++;
						c = input.charAt(i);
					}

					if(!parseWordToken(token_string)) {
						largeTokenArray[count++] = new WordToken(token_string);
					}
				}
			}
		}
	}
	
	private static boolean parseWordToken(String token_string) {
		int temp = count;
		
		if(token_string.equalsIgnoreCase("move")) {
			largeTokenArray[count++] = new Move(token_string);
		} else if(token_string.equalsIgnoreCase("say")) {
			largeTokenArray[count++] = new Say(token_string);
		} else if(token_string.equalsIgnoreCase("rotateLeftArm")) {
			largeTokenArray[count++] = new RotateLeftArm(token_string);
		} else if(token_string.equalsIgnoreCase("rotateRightArm")) {
			largeTokenArray[count++] = new RotateRightArm(token_string);
		} else if(token_string.equalsIgnoreCase("repeat")) {
			largeTokenArray[count++] = new Repeat(token_string);
		} else if(token_string.equalsIgnoreCase("define")) {
			largeTokenArray[count++] = new Define(token_string);
		} else if(token_string.equalsIgnoreCase("call")) {
			largeTokenArray[count++] = new Call(token_string);
		} else if(token_string.equalsIgnoreCase("thread")) {
			largeTokenArray[count++] = new Thread(token_string);
		} else if(token_string.equalsIgnoreCase("wait")) {
			largeTokenArray[count++] = new Wait(token_string);
		} else if(token_string.equalsIgnoreCase("proceedAll")) {
			largeTokenArray[count++] = new ProceedAll(token_string);
		} else if(token_string.equalsIgnoreCase("sleep")) {
			largeTokenArray[count++] = new Sleep(token_string);
		} else if(token_string.equalsIgnoreCase("undo")) {
			largeTokenArray[count++] = new Undo(token_string);
		} else if(token_string.equalsIgnoreCase("redo")) {
			largeTokenArray[count++] = new Redo(token_string);
		} else if(token_string.equalsIgnoreCase("approach")) {
			largeTokenArray[count++] = new Approach(token_string);
		}
		
		return temp != count;
	}
}
