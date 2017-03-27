package kelmore5.java.dewan.Assignments.Assignment11.mp.tokens;

import kelmore5.java.dewan.Assignments.Assignment11.mp.interfaces.InputInterface;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Word", "Quote"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
public class QuotedStringToken extends WordToken implements InputInterface{
	public QuotedStringToken(String input) {
		super(input);
	}
}
