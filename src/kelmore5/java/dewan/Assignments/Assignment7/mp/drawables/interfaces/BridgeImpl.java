package kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.interfaces;

import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.Avatar;
import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.Rectangle;
import util.annotations.Tags;

@Tags({"BridgeScene"})
public interface BridgeImpl extends MultiShapesImpl{
	public Avatar getArthur();

	public Avatar getLancelot();

	public Avatar getRobin();

	public Avatar getGalahad();

	public Avatar getGuard();

	public Rectangle getKnightArea();

	public Rectangle getGuardArea();

	public boolean isOccupied();

	public boolean isKnightTurn();

	@Tags({"approach"})
	public void approach(Avatar a);
	
	@Tags({"passed"})
	public void passed();
	
	@Tags({"failed"})
	public void failed();
	
	@Tags({"say"})
	public void say(String utterance);
}
