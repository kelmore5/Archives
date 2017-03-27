package kelmore5.java.dewan.Assignments.Assignment6.mp.drawables;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.generics.GenericShape;
import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.interfaces.ImageShapeImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Head"})
@StructurePattern(StructurePatternNames.IMAGE_PATTERN) 
@PropertyNames({"x", "y", "imageFileName", "width", "height"}) 
@EditablePropertyNames({"x", "y", "imageFileName", "width", "height"}) 
public class Head extends GenericShape implements ImageShapeImpl{
	private String imageFileName;
	
	public Head(int x, int y, String imageFileName) {
		super(x, y, 0, 0);
		this.imageFileName = imageFileName;
		Icon icon = new ImageIcon(imageFileName);
		this.height = icon.getIconHeight();
		this.width = icon.getIconWidth();
	}
	
	public Head(String imageFileName) {
		this(0, 0, imageFileName);
	}
	
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
}
