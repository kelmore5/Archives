package kelmore5.java.dewan.Assignments.Assignment10.mp.drawables;

import java.beans.PropertyChangeEvent;

import kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.generics.GenericShapes;
import kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.interfaces.AvatarImpl;
import kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.interfaces.PointImpl;
import kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.interfaces.ShapeImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"Avatar"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"utterance", "shapes", "height", "knight", "originalX", "originalY", "width", "height"}) 
@EditablePropertyNames({"x", "y", "utterance", "height", "width"})
public class Avatar extends GenericShapes implements AvatarImpl {
	private String utterance = "";
	private String knight;
	private int height;
	private final int legDefault = 25;
	private final int heightDif = 64;
	private final int headCenter = 15;
	private int originalX, originalY;
	
	public Avatar(String knight, Head head) {
		super(head.getX(), head.getY(), head.getWidth(), head.getHeight());
		
		this.originalX = head.getX();
		this.originalY = head.getY();
		
		this.knight = knight;
		
		this.changeArrayLength(5);
		
		int centerX = head.getX() + 15;
		
		ShapeImpl body = new Line(centerX, head.getY() + heightDif, 0, heightDif + 11);
		PointImpl arms = new Angle(centerX, body.getY()+headCenter-5, legDefault, legDefault);
		PointImpl legs = new Angle(centerX, body.getY()+body.getHeight(), legDefault, legDefault);
		
		this.height = heightDif + body.getHeight() + legDefault;
		
		this.shapes[0] = head;
		this.shapes[1] = body;
		this.shapes[2] = arms;
		this.shapes[3] = legs;
		this.shapes[4] = new StringShape(head.getX(), head.getY() - 30, "");
	}

	public String getUtterance() {
		return utterance;
	}
	
	@Visible(false)
	public StringShape getUtteranceShape() {
		return (StringShape) this.shapes[4];
	}

	public void setUtterance(String utterance) {
		String oldUtterance = this.utterance;
		this.utterance = utterance;
		((StringShape) this.shapes[4]).setText(utterance);
		
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "utterance", oldUtterance, this.utterance));
		}
	}

	public String getKnight() {
		return knight;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
	@Visible(false)
	public Head getHead() {
		return (Head) this.shapes[0];
	}

	@Visible(false)
	public Angle getArms() {
		return (Angle) this.shapes[2];
	}

	@Visible(false)
	public Angle getLegs() {
		return (Angle) this.shapes[3];
	}

	@Visible(false)
	public Line getBody() {
		return (Line) this.shapes[1];
	}
	
	public int getOriginalX() {
		return originalX;
	}

	public int getOriginalY() {
		return originalY;
	}
	
	@Override
	public void setX(int x) {
		this.move(x-this.getX(), 0);
	}
	
	@Override
	public void setY(int y) {
		this.move(0, y-this.getY());
	}
	
	@Tags({"move"})
	public void move(int x, int y) {
		int oldX = this.x;
		int oldY = this.y;
		
		for(PointImpl p: shapes) {
			p.move(x, y);
		}

		this.x = this.shapes[0].getX();
		this.y = this.shapes[0].getY();
		
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "x", oldX, this.x));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "y", oldY, this.y));
		}
	}
}
