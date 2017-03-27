package kelmore5.java.dewan.recitations.Recitation10.main;

import java.beans.PropertyChangeListener;

import util.models.PropertyListenerRegisterer;
import bus.uigen.OEFrame;

public interface Scene extends PropertyChangeListener, PropertyListenerRegisterer{
	public ImageShape getThief();
	public ImageShape getHouse();
	public ImageShape getAlarm();
	public ImageShape getPoliceman();
	public StringShape getState();
	public void demo();
}
