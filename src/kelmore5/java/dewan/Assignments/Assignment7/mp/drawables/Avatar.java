package kelmore5.java.dewan.Assignments.Assignment7.mp.drawables;

import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.generics.GenericShapes;
import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.interfaces.AvatarImpl;
import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.interfaces.PointImpl;
import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.interfaces.ShapeImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Avatar"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"utterance", "shapes", "height", "knight"}) 
@EditablePropertyNames({"x", "y", "utterance"})
public class Avatar extends GenericShapes implements AvatarImpl {
	private String utterance = "";
	private String knight;
	private int height;
	private final int legDefault = 25;
	private final int heightDif = 64;
	private final int headCenter = 15;
	
	public Avatar(String knight, Head head) {
		super(head.getX(), head.getY());
		
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

	public void setUtterance(String utterance) {
		this.utterance = utterance;
		((StringShape) this.shapes[4]).setText(utterance);
	}

	public String getKnight() {
		return knight;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public void setX(int x) {
		int change = x-this.shapes[0].getX();
		
		for(PointImpl p: shapes) {
			p.move(change, 0);
		}
		
		this.x = this.shapes[0].getX();
	}
	
	@Override
	public void setY(int y) {
		int change = y-this.shapes[0].getY();
		for(PointImpl p: shapes) {
			p.move(0, change);
		}
		
		this.y = this.shapes[0].getY();
	}
	
	@Tags({"move"})
	public void move(int x, int y) {
		for(PointImpl p: shapes) {
			p.move(x, y);
		}

		this.x = this.shapes[0].getX();
		this.y = this.shapes[0].getY();
	}
}
