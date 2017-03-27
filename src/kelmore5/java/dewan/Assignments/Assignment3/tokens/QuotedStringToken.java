package kelmore5.java.dewan.Assignments.Assignment3.tokens;

import kelmore5.java.dewan.Assignments.Assignment3.interfaces.InputInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Token", "Quote"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input"})
@EditablePropertyNames({"Input"})
public class QuotedStringToken implements InputInterface {
    String Input;

    public QuotedStringToken(String input) {
        super();
        Input = input;
    }

    public String getInput() {
        return Input;
    }

    public void setInput(String input) {
        Input = input;
    }
}
