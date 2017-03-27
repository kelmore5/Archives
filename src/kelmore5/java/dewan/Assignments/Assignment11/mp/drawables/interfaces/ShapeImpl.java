package kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.interfaces;

import util.annotations.Tags;

@Tags({"String", "Line", "Angle", "Head", "BoundedShape"})
public interface ShapeImpl extends PointImpl{
	public int getWidth();
	public void setWidth(int width);
	public int getHeight();
	public void setHeight(int height);
}
