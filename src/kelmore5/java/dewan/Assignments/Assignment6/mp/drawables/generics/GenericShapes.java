package kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.generics;

import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.interfaces.MultiShapesImpl;
import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.interfaces.PointImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"x", "y", "shapes"}) 
@EditablePropertyNames({"x", "y"})
public class GenericShapes extends GenericPoint implements MultiShapesImpl{
	public PointImpl[] shapes;

	public GenericShapes(int x, int y) {
		super(x, y);
		
		shapes = new PointImpl[1];
	}
	
	@Visible(false)
	public void changeArrayLength(int length) {
		shapes = new PointImpl[length];
	}
	
	public PointImpl[] getShapes() {
		return shapes;
	}
	
	@Override
	@Tags({"move"})
	public void move(int x, int y) {
		for(PointImpl s: shapes) {
			s.move(x, y);
		}
	}
}
