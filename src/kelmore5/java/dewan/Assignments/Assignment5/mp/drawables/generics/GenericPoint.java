package kelmore5.java.dewan.Assignments.Assignment5.mp.drawables.generics;

import kelmore5.java.dewan.Assignments.Assignment5.mp.drawables.interfaces.PointImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"x", "y"}) 
@EditablePropertyNames({"x", "y"}) 
public class GenericPoint implements PointImpl {
	protected int x, y;

	public GenericPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	@Tags({"move"})
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
}
