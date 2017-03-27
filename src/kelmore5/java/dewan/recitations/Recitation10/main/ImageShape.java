package kelmore5.java.dewan.recitations.Recitation10.main;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.models.PropertyListenerRegisterer;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
public interface ImageShape extends PropertyListenerRegisterer{//what if no extends here
	public String getImageFileName();

	public void setImageFileName(String newVal);

	public int getX();

	public void setX(int newX);

	public int getY();

	public void setY(int newY);
}
