package kelmore5.java.dewan.Assignments.Assignment5.mp.drawables.interfaces;

import util.annotations.Tags;

public interface PointImpl {
	public int getX();
	public void setX(int x);
	public int getY();
	public void setY(int y);
	@Tags({"move"})
	public void move(int x, int y);
}
