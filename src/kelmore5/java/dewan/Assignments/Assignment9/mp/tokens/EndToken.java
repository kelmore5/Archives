package kelmore5.java.dewan.Assignments.Assignment9.mp.tokens;

import kelmore5.java.dewan.Assignments.Assignment9.mp.interfaces.InputInterface;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Word", "End"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
public class EndToken extends WordToken implements InputInterface{
	public EndToken(String input) {
		super(input);
	}
}
