package kelmore5.java.dewan.Assignments.Assignment6.mp.tokens;

import kelmore5.java.dewan.Assignments.Assignment6.mp.interfaces.InputInterface;
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
