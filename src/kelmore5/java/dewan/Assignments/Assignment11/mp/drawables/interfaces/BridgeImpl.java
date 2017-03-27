package kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.interfaces;

import kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.Avatar;
import kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.ParallelLines;
import kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.Rectangle;
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
	
	public ParallelLines getGorge();

	public Rectangle getBridge();

	public boolean isOccupied();

	public boolean isKnightTurn();
	public Avatar currentKnight2(String knight);

	@Tags({"approach"})
	public void approach(Avatar a);
	
	@Tags({"passed"})
	public void passed();
	
	@Tags({"failed"})
	public void failed();
	
	@Tags({"say"})
	public void say(String utterance);
}
