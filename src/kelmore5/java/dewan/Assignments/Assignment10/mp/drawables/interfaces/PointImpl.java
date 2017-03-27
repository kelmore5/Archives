package kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.interfaces;

import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags({"String", "Line", "Angle", "Head", "Locatable"})
public interface PointImpl extends PropertyListenerRegisterer {
	public int getX();
	public void setX(int x);
	public int getY();
	public void setY(int y);
	@Tags({"move"})
	public void move(int x, int y);
}
