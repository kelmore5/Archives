package kelmore5.java.dewan.recitations.Recitation9.main;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
public class AShapeImage implements ImageShape {
	String imageFileName;
	int x, y;
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();

	public AShapeImage(String initImageFileName, int initX, int initY) {
		x = initX;
		y = initY;
		imageFileName = initImageFileName;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String newVal) {
		String oldVal = imageFileName;
		imageFileName = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this,
				"ImageFileName", oldVal, newVal));
	}

	public int getX() {
		return x;
	}

	public void setX(int newX) {
		int oldVal = x;
		x = newX;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X",
				oldVal, newX));
	}

	public int getY() {
		return y;
	}

	public void setY(int newY) {
		int oldVal = y;
		y = newY;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y",
				oldVal, newY));
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
	}
}
