package kelmore5.java.dewan.Assignments.Assignment10.mp.tokens;

import kelmore5.java.dewan.Assignments.Assignment10.mp.interfaces.InputInterface;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Word", "Start"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class StartToken extends WordToken implements InputInterface{
	String Input;

	public StartToken(String input) {
		super(input);
	}
}
