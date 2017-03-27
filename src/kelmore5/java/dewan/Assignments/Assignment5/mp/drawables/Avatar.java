package kelmore5.java.dewan.Assignments.Assignment5.mp.drawables;

import kelmore5.java.dewan.Assignments.Assignment5.mp.drawables.interfaces.AvatarImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Avatar"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"utterance", "knight", "head", "arms", "legs", "body", "height"}) 
@EditablePropertyNames({"utterance"})
public class Avatar implements AvatarImpl {
	private Line body;
	private Head head;
	private Angle arms, legs;
	private StringShape utterance;
	private String knight;
	private int height;
	private final int headCenter = 15;
	private final int legDefault = 25;
	private final int heightDif = 64;
	
	public Avatar(String knight, Head head) {		
		this.head = head;
		this.knight = knight;
				
		int centerX = head.getX() + headCenter;
		
		this.body = new Line(centerX, head.getY() + heightDif, 0, heightDif + 11);
		this.arms = new Angle(centerX, body.getY()+headCenter-5, legDefault, legDefault);
		this.legs = new Angle(centerX, body.getY()+body.getHeight(), legDefault, legDefault);
		
		this.height = heightDif + this.body.getHeight() + legDefault;
		
		this.utterance = new StringShape(head.getX(), head.getY() - legDefault + 5, "");
	}

	public StringShape getUtterance() {
		return utterance;
	}

	public void setUtterance(StringShape utterance) {
		this.utterance = utterance;
	}

	public String getKnight() {
		return knight;
	}
	
	public Head getHead() {
		return head;
	}

	public Angle getArms() {
		return arms;
	}

	public Angle getLegs() {
		return legs;
	}

	public Line getBody() {
		return body;
	}
	
	public int getHeight() {
		return height;
	}

	@Tags({"move"})
	public void move(int x, int y) {
		head.move(x, y);
		arms.move(x, y);
		legs.move(x, y);
		body.move(x, y);
		utterance.move(x, y);
	}
}
