package kelmore5.java.dewan.Assignments.Assignment6.mp.tokens;

import kelmore5.java.dewan.Assignments.Assignment6.mp.interfaces.InputInterface;
import kelmore5.java.dewan.Assignments.Assignment6.mp.interfaces.WordTokenInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Token", "Word", "Approach", "Call", "Define", "Fail", "Move", "Pass", "ProceedAll", "Redo", "Repeat", "RotateLeftArm",
	"RotateRightArm", "Say", "Sleep", "Say", "Thread", "Undo", "Wait", "End", "Quote", "Start"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"}) 
public class WordToken extends Token implements InputInterface, WordTokenInterface {
	private String Value; //lowercase representation of String

	public WordToken(String input) {
		super(input);
		Value = parseInput(input);
	}
	
	//How to parse String to lowercase
	private String parseInput(String input) {			
		return input.toLowerCase();
	}

	public String getValue() {
		return Value;
	}
}
