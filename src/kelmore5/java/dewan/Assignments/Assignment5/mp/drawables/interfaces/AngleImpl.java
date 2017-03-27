package kelmore5.java.dewan.Assignments.Assignment5.mp.drawables.interfaces;

import kelmore5.java.dewan.Assignments.Assignment5.mp.drawables.Line;
import util.annotations.Tags;

@Tags({"Angle"})
public interface AngleImpl extends MultiShapesImpl{
	public Line getLeftLine();

	public Line getRightLine();
}
