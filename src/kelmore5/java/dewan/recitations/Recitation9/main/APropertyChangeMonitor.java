package kelmore5.java.dewan.recitations.Recitation9.main;

import java.beans.PropertyChangeEvent;

public class APropertyChangeMonitor implements PropertyChangeMonitor {
	Scene aScene;

	public APropertyChangeMonitor(Scene theScene) {
		aScene = theScene;
		theScene.getThief().addPropertyChangeListener(this);
		theScene.getHouse().addPropertyChangeListener(this);
		theScene.getAlarm().addPropertyChangeListener(this);
		theScene.getState().addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
//		String current = "";
//		if (arg0.getSource() == aScene.getThief())
//			current = "Thief";
//		else if (arg0.getSource() == aScene.getHouse())
//			current = "House";
//		else if (arg0.getSource() == aScene.getAlarm())
//			current = "Alarm";
//		else if (arg0.getSource() == aScene.getState())
//			current = "State";
//		System.out.println("Object: " + current + "\t Property name: "
//				+ arg0.getPropertyName() + "\t old value: "
//				+ arg0.getOldValue() + "\t new value: " + arg0.getNewValue());
//		System.out.println();
		System.out.println(arg0);
		System.out.println();
	}
}
