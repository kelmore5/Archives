package kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.interfaces;

import kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.Angle;
import kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.Head;
import kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.Line;
import kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.StringShape;
import util.annotations.Tags;

@Tags({"Avatar"})
public interface AvatarImpl extends MultiShapesImpl {
	public String getUtterance();
	public String getKnight();
	public int getHeight();
	public Head getHead();

	public Angle getArms();

	public Angle getLegs();

	public Line getBody();
	public StringShape getUtteranceShape();
	public int getOriginalX();

	public int getOriginalY();
}
