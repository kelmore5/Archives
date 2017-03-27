package kelmore5.java.dewan.Assignments.Assignment12.mp.drawables;

import kelmore5.java.dewan.Assignments.Assignment12.mp.drawables.generics.GenericShape;
import kelmore5.java.dewan.Assignments.Assignment12.mp.drawables.interfaces.ParallelLinesImpl;
import kelmore5.java.dewan.Assignments.Assignment12.mp.drawables.interfaces.RectangleImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"x", "y", "firstParallel", "secondParallel", "width", "height"}) 
@EditablePropertyNames({"x", "y", "width", "height"})
public class Rectangle extends GenericShape implements RectangleImpl {
	private ParallelLinesImpl firstParallel, secondParallel;
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		this.firstParallel = new ParallelLines(x, y, 0, height, true, width);
		this.secondParallel = new ParallelLines(x, y, width, 0, false, height);
	}

	public ParallelLines getFirstParallel() {
		return (ParallelLines) firstParallel;
	}

	public ParallelLines getSecondParallel() {
		return (ParallelLines) secondParallel;
	}
	
	@Override
	public void move(int x, int y) {
		this.firstParallel.move(x, y);
		this.secondParallel.move(x, y);
	}
}
