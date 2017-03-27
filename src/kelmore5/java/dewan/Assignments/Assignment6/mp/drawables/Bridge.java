package kelmore5.java.dewan.Assignments.Assignment6.mp.drawables;

import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.Head;
import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.ParallelLines;
import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.Rectangle;
import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.generics.GenericShapes;
import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.interfaces.BridgeImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"BridgeScene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"arthur", "lancelot", "robin", "galahad", "guard", "shapes", "knightArea", "guardArea", "Occupied", "KnightTurn"}) 
@EditablePropertyNames({"x", "y"})
public class Bridge extends GenericShapes implements BridgeImpl {
	private Avatar arthur, lancelot, robin, galahad, guard;
	private Rectangle knightArea, guardArea;
	private boolean Occupied = false, KnightTurn = false;
	@Visible(false)
	private Avatar interactiveKnight;
	
	private int[] initialValues = new int[] { 10, 10, 60, 10, 10, 200, 50, 200, 320, 50, 400, 0, 0, 600, 100, 400, 150, 100, 50,
		300, 150, 75, 75, 200, 150, 75, 75
	};
	
	public Bridge() {
		super(0,0);
		
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
	
	private final int[] approachXY = new int[] {220, 50};

	@Tags({"approach"})
	public void approach(Avatar a) {
		if(!this.Occupied) {
			this.interactiveKnight = currentKnight2(a.getKnight());
			this.interactiveKnight.setX(approachXY[0]);
			this.interactiveKnight.setY(approachXY[1]);
			this.Occupied = true;
			this.KnightTurn = false;
		}
	}
	
	private final int[] passedXY = new int[] {350, 0};
	
	@Tags({"passed"})
	public void passed() {
		if(this.Occupied && !this.KnightTurn) {
			this.interactiveKnight.move(passedXY[0], passedXY[1]);
			interactiveKnight = null;
			this.Occupied = false;
			this.KnightTurn = false;
		}
	}
	
	private final int[] guardFailedXY = new int[] {100, 200};
	private final int[] knightFailedXY = new int[] {200, 200};
	
	@Tags({"failed"})
	public void failed() {
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
	
	@Tags({"say"})
	public void say(String utterance) {
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
	private Avatar currentKnight(String knight) {	
		return this.interactiveKnight;
	}
	
	@Visible(false)
	private Avatar currentKnight2(String knight) {		
		if(this.arthur.getKnight().equals(knight)) 
			return this.arthur;
		else if(this.lancelot.getKnight().equals(knight))
			return this.lancelot;
		else if(this.galahad.getKnight().equals(knight))
			return this.galahad;
		else if(this.guard.getKnight().equals(knight))
			return this.guard;
		else if(this.robin.getKnight().equals(knight))
			return this.robin;
			
		return null;
	}
}
