package kelmore5.java.dewan.Assignments.Assignment7.mp.drawables;

import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.generics.GenericPoint;
import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.interfaces.AngleImpl;
import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.interfaces.ShapeImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Angle"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"x", "y", "leftLine", "rightLine"}) 
@EditablePropertyNames({"x", "y"})
public class Angle extends GenericPoint implements AngleImpl {	
	private ShapeImpl leftLine, rightLine;
	private static final int angleDefault = 25;
	
	public Angle() {
		super(angleDefault, angleDefault);
	}
	
	public Angle(int x, int y, int width, int height) {
		super(x, y);
		
		this.leftLine = new Line(x, y, width, height);
		this.rightLine = new Line(x, y, -width, height);
	}
	
	public Angle(Line leftLine, Line rightLine) {
		super(leftLine.getX(), leftLine.getY());
		
		this.leftLine = leftLine;
		this.rightLine = rightLine;
	}

	public Line getLeftLine() {
		return (Line) leftLine;
	}

	public Line getRightLine() {
		return (Line) rightLine;
	}

	@Override
	public void move(int x, int y) {
		this.leftLine.move(x, y);
		this.rightLine.move(x, y);
	}
}
