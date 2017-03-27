package kelmore5.java.dewan.Assignments.Assignment5.mp.drawables;

import kelmore5.java.dewan.Assignments.Assignment5.mp.drawables.generics.GenericPoint;
import kelmore5.java.dewan.Assignments.Assignment5.mp.drawables.interfaces.BridgeImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"BridgeScene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"arthur", "lancelot", "robin", "galahad", "guard",}) 
@EditablePropertyNames({"x", "y"})
public class Bridge extends GenericPoint implements BridgeImpl {
	private Avatar arthur, lancelot, robin, galahad, guard;
	
	public Bridge() {
		super(0,0);
		arthur = new Avatar("arthur", new Head(10, 10, "arthur.jpg"));
		lancelot = new Avatar("lancelot", new Head(60, 10, "lancelot.jpg"));
		robin = new Avatar("robin", new Head(10, 200, "robin.jpg"));
		galahad = new Avatar("galahad", new Head(50, 200, "galahad.jpg"));
		guard = new Avatar("guard", new Head(320, 50, "guard.jpg"));
	}

	public Avatar getArthur() {
		return arthur;
	}

	public Avatar getLancelot() {
		return lancelot;
	}

	public Avatar getRobin() {
		return robin;
	}

	public Avatar getGalahad() {
		return galahad;
	}

	public Avatar getGuard() {
		return guard;
	}
}
