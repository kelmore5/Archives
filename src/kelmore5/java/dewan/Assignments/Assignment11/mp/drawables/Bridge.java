package kelmore5.java.dewan.Assignments.Assignment11.mp.drawables;

import java.beans.PropertyChangeEvent;

import kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.generics.GenericShapes;
import kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.interfaces.BridgeImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"BridgeScene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"arthur", "lancelot", "robin", "galahad", "guard", "shapes", "knightArea", "guardArea", "Occupied", "KnightTurn", "height",
	"width"}) 
@EditablePropertyNames({"x", "y", "height", "width"})
public class Bridge extends GenericShapes implements BridgeImpl {
	private Avatar arthur, lancelot, robin, galahad, guard;
	private Rectangle knightArea, guardArea;
	private boolean Occupied = false, KnightTurn = false;
	@Visible(false)
	private Avatar interactiveKnight;
	
	private int[] initialValues = new int[] { 10, 10, 60, 10, 10, 200, 50, 200, 320, 50, 400, 0, 0, 600, 100, 400, 150, 100, 50,
			300, 150, 75, 75, 200, 150, 75, 75
		};
		private final int[] approachXY = new int[] {220, 50};
		private final int[] passedXY = new int[] {350, 0};
		private final int[] guardFailedXY = new int[] {100, 200};
		private final int[] knightFailedXY = new int[] {200, 200};
	
	public Bridge() {
		super(0,0,0,0);
		
		arthur = new Avatar("arthur", new Head(initialValues[0], initialValues[1], "arthur.jpg"));
		lancelot = new Avatar("lancelot", new Head(initialValues[2], initialValues[3], "lancelot.jpg"));
		robin = new Avatar("robin", new Head(initialValues[4], initialValues[5], "robin.jpg"));
		galahad = new Avatar("galahad", new Head(initialValues[6], initialValues[7], "galahad.jpg"));
		guard = new Avatar("guard", new Head(initialValues[8], initialValues[9], "guard.jpg"));
		
		this.changeArrayLength(2);
		
		//Gorge & Bridge
		this.shapes[0] = new ParallelLines(initialValues[10], initialValues[11], initialValues[12], initialValues[13], true, initialValues[14]);
		this.shapes[1] = new Rectangle(initialValues[15], initialValues[16], initialValues[17], initialValues[18]);
		
		this.guardArea = new Rectangle(initialValues[19], initialValues[20], initialValues[21], initialValues[22]);
		this.knightArea = new Rectangle(initialValues[23], initialValues[24], initialValues[25], initialValues[26]);
	}

	public Avatar getArthur() {
		return arthur;
	}

	public Avatar getLancelot() {
		return lancelot;
	}

	public Avatar getRobin() {
		return robin;
	}

	public Avatar getGalahad() {
		return galahad;
	}

	public Avatar getGuard() {
		return guard;
	}
	
	@Visible(false)
	public ParallelLines getGorge() {
		return (ParallelLines) this.shapes[0];
	}
	
	@Visible(false)
	public Rectangle getBridge() {
		return (Rectangle) this.shapes[1];
	}

	public Rectangle getKnightArea() {
		return knightArea;
	}

	public Rectangle getGuardArea() {
		return guardArea;
	}

	public boolean isOccupied() {
		return Occupied;
	}

	public boolean isKnightTurn() {
		return KnightTurn;
	}
	
	public boolean preApproach(Avatar avatar) {
		return avatar != null && !this.Occupied;
	}

	@Tags({"approach"})
	public void approach(Avatar a) {
		assert preApproach(a);
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "say", true));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "pass", true));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", false));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "fail", true));
		}
		if(!this.Occupied) {
			this.interactiveKnight = currentKnight2(a.getKnight());
			this.interactiveKnight.setX(approachXY[0]);
			this.interactiveKnight.setY(approachXY[1]);
			this.Occupied = true;
			this.KnightTurn = false;
		}
	}
	
	public boolean prePass() {
		return this.Occupied && !this.KnightTurn;
	}
	
	@Tags({"passed"})
	public void passed() {
		assert prePass();
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "say", false));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "pass", false));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", true));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "fail", false));
		}
		if(this.Occupied && !this.KnightTurn) {
			this.interactiveKnight.move(passedXY[0], passedXY[1]);
			interactiveKnight = null;
			this.Occupied = false;
			this.KnightTurn = false;
		}
	}
	
	public boolean preFail() {
		return this.Occupied;
	}
	
	@Tags({"failed"})
	public void failed() {
		assert preFail();
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "say", false));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "pass", false));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", true));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "fail", false));
		}
		if(this.Occupied) {
			if(this.KnightTurn) {
				guard.move(guardFailedXY[0], guardFailedXY[1]);
			} else {
				this.interactiveKnight.move(knightFailedXY[0], knightFailedXY[1]);
				this.Occupied = false;
				this.interactiveKnight = null;
				this.KnightTurn = false;
			}
		}
	}
	
	public boolean preSay(String utterance) {
		return utterance != null && this.Occupied;
	}
	
	@Tags({"say"})
	public void say(String utterance) {
		assert preSay(utterance);
		if(this.Occupied) {
			if(this.KnightTurn) {
				this.interactiveKnight.setUtterance(utterance);
				this.KnightTurn = false;
			} else {
				guard.setUtterance(utterance);
				this.KnightTurn = true;
			}
		}
	}
	
	@Visible(false)
	public Avatar currentKnight() {	
		return this.interactiveKnight;
	}
	
	public Avatar currentKnight2(String knight) {	
		if(this.arthur.getKnight().equalsIgnoreCase(knight)) 
			return this.arthur;
		else if(this.lancelot.getKnight().equalsIgnoreCase(knight))
			return this.lancelot;
		else if(this.galahad.getKnight().equalsIgnoreCase(knight))
			return this.galahad;
		else if(this.guard.getKnight().equalsIgnoreCase(knight))
			return this.guard;
		else if(this.robin.getKnight().equalsIgnoreCase(knight))
			return this.robin;
			
		return null;
	}
}
