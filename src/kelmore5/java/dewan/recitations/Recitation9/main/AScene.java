package kelmore5.java.dewan.recitations.Recitation9.main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class AScene implements Scene {
	ImageShape thief;
	ImageShape house;
	ImageShape alarm;
	StringShape state;
	
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();
	
	public AScene(){
		thief = new AShapeImage("thief.png", 900, 100);
		house = new AShapeImage("house.png", 400, 50);
		alarm = new AShapeImage("alarm2.png", 50, 50);
		state = new AStringShape("zZZ  zZZ", 190, 70);
		thief.addPropertyChangeListener(this);
	}
	
	public ImageShape getThief(){return thief;}
	public ImageShape getHouse(){return house;}
	public ImageShape getAlarm(){return alarm;}
	public StringShape getState(){return state;}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if( (Integer)(arg0.getOldValue()) <= 500){
			alarm.setImageFileName("alarm1.png");
			state.setText("Alarm! Alarm!");
		}
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "property change",
				null, null));
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
	}
}