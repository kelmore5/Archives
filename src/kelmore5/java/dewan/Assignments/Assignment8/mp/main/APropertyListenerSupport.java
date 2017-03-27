package kelmore5.java.dewan.Assignments.Assignment8.mp.main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import kelmore5.java.dewan.Assignments.Assignment8.mp.interfaces.PropertyListenerSupport;

public class APropertyListenerSupport implements PropertyListenerSupport { 
	public final int MAX_SIZE = 50; PropertyChangeListener[] contents = new PropertyChangeListener[MAX_SIZE]; 
	int size = 0; 

	public int size() { 
		return size; 
	} 

	public PropertyChangeListener elementAt (int index) { 
		return contents[index]; 
	} 

	public boolean isFull() { 
		return size == MAX_SIZE; 
	} 

	public void addElement(PropertyChangeListener l) { 
		if (isFull()) 
			System.out.println("Adding item to a full history"); 
		else { contents[size] = l; size++ ; } 
	}   

	public void notifyAllListeners(PropertyChangeEvent event) { 
		for (int index = 0; index < size(); index++) { 
			elementAt(index ).propertyChange(event); 
		} 
	} 
}