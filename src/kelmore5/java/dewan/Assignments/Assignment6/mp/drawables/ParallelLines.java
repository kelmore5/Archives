package kelmore5.java.dewan.Assignments.Assignment6.mp.drawables;

import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.generics.GenericPoint;
import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.interfaces.ParallelLinesImpl;
import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.interfaces.ShapeImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"x", "y", "firstLine", "secondLine"}) 
@EditablePropertyNames({"x", "y"})
public class ParallelLines extends GenericPoint implements ParallelLinesImpl {	
	private ShapeImpl firstLine, secondLine;
	
	public ParallelLines(int x, int y, int width, int height, boolean vertical, int spacing) {
		super(x, y);
		
		this.firstLine = new Line(x, y, width, height);
				
		if(vertical) {
			x += spacing;
		} else {
			y += spacing;
		}
		
		this.secondLine = new Line(x, y, width, height);
	}

	public Line getFirstLine() {
		return (Line) firstLine;
	}

	public Line getSecondLine() {
		return (Line) secondLine;
	}
	
	@Override
	public void move(int x, int y) {
		this.firstLine.move(x, y);
		this.secondLine.move(x, y);
	}
}
