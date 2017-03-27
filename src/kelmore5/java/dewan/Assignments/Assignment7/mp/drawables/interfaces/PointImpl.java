package kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.interfaces;

import util.annotations.Tags;

@Tags({"String", "Line", "Angle", "Head", "Locatable"})
public interface PointImpl {
	public int getX();
	public void setX(int x);
	public int getY();
	public void setY(int y);
	@Tags({"move"})
	public void move(int x, int y);
}
