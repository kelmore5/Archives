package kelmore5.java.dewan.Assignments.Assignment5.mp.drawables.generics;

import kelmore5.java.dewan.Assignments.Assignment5.mp.drawables.interfaces.ShapeImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"x", "y", "width", "height"}) 
public class GenericShape extends GenericPoint implements ShapeImpl {
	protected int width, height;

	public GenericShape(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
