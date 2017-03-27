package kelmore5.java.dewan.Assignments.Assignment10.mp.tokens;

import kelmore5.java.dewan.Assignments.Assignment10.mp.interfaces.InputInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Token", "Number"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"}) 
public class NumberToken extends Token implements InputInterface{
	private int Value;
	
	public NumberToken(String input) {
		super(input);
		Value = parseInput(input); //parse the input
	}
	
	//How to parse String to integer
	private int parseInput(String input) {
		int output = 0;
		try {
			output = Integer.parseInt(input);
		} catch(Exception ex) {
			
		}
		
		return output;
	}
	
	@Override
	public void setInput(String input) {
		Value = parseInput(input);
		Input = input;
	}
	
	public int getValue() {
		return Value;
	}
}
