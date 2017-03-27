package kelmore5.java.dewan.Assignments.Assignment4.tokens;

import kelmore5.java.dewan.Assignments.Assignment4.interfaces.InputInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Token", "End"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input"})
@EditablePropertyNames({"Input"})
public class EndToken implements InputInterface {
    String Input;

    public EndToken(String input) {
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
