package kelmore5.java.dewan.recitations.Recitation9.main;

import java.beans.PropertyChangeListener;

import util.models.PropertyListenerRegisterer;

public interface Scene extends PropertyChangeListener, PropertyListenerRegisterer{
	public ImageShape getThief();
	public ImageShape getHouse();
	public ImageShape getAlarm();
	public StringShape getState();
}
