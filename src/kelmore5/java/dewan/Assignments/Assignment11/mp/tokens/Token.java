package kelmore5.java.dewan.Assignments.Assignment11.mp.tokens;

import kelmore5.java.dewan.Assignments.Assignment11.mp.interfaces.InputInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Token", "Word", "Number", "Approach", "Call", "Define", "Fail", "Move", "Pass", "ProceedAll", "Redo", "Repeat", "RotateLeftArm",
	"RotateRightArm", "Say", "Sleep", "Say", "Thread", "Undo", "Wait", "End", "Quote", "Start"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input"}) 
@EditablePropertyNames({"Input"}) 
public class Token implements InputInterface {
	String Input;

	public Token(String input) {
		Input = input;
	}

	public String getInput() {
		return Input;
	}

	public void setInput(String input) {
		Input = input;
	}
}
