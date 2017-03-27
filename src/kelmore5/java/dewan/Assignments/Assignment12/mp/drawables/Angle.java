package kelmore5.java.dewan.Assignments.Assignment12.mp.drawables;

import kelmore5.java.dewan.Assignments.Assignment12.mp.drawables.generics.GenericShape;
import kelmore5.java.dewan.Assignments.Assignment12.mp.drawables.interfaces.AngleImpl;
import kelmore5.java.dewan.Assignments.Assignment12.mp.drawables.interfaces.ShapeImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Angle"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"x", "y", "leftLine", "rightLine", "width", "height"}) 
@EditablePropertyNames({"x", "y", "width", "height"})
public class Angle extends GenericShape implements AngleImpl {	
	private ShapeImpl leftLine, rightLine;
	private static final int angleDefault = 25;
	private static final int xyDefault = 50;
	
	public Angle() {
		super(angleDefault, angleDefault, xyDefault, xyDefault);
	}
	
	public Angle(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		this.leftLine = new Line(x, y, width, height);
		this.rightLine = new Line(x, y, -width, height);
	}
	
	public Angle(Line leftLine, Line rightLine) {
		super(leftLine.getX(), leftLine.getY(), leftLine.getWidth(), leftLine.getHeight());
		
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
