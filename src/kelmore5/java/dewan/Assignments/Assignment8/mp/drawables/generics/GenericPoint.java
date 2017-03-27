package kelmore5.java.dewan.Assignments.Assignment8.mp.drawables.generics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import kelmore5.java.dewan.Assignments.Assignment8.mp.drawables.interfaces.PointImpl;
import kelmore5.java.dewan.Assignments.Assignment8.mp.interfaces.PropertyListenerSupport;
import kelmore5.java.dewan.Assignments.Assignment8.mp.main.APropertyListenerSupport;
import util.annotations.EditablePropertyNames;
import util.annotations.ObserverRegisterer;
import util.annotations.ObserverTypes;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"String", "Angle", "Line", "Head", "Locatable"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"x", "y"}) 
@EditablePropertyNames({"x", "y"}) 
public class GenericPoint implements PointImpl {
	protected PropertyListenerSupport propertyListenerSupport = new APropertyListenerSupport();
	protected int x, y;

	public GenericPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		int oldX = this.x;
		this.x = x;
		
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "x", oldX, this.x));
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		int oldY = this.y;
		this.y = y;
		
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "y", oldY, this.y));
		}
	}

	@Override
	@Tags({"move"})
	public void move(int x, int y) {
		int oldX = this.x;
		int oldY = this.y;
		
		this.x += x;
		this.y += y;
		
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "x", oldX, this.x));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "y", oldY, this.y));
		}
	}

	@Override
	@ObserverRegisterer(ObserverTypes.PROPERTY_LISTENER)
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyListenerSupport.addElement(listener);
	}
}
