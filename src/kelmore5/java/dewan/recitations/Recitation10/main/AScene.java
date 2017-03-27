package kelmore5.java.dewan.recitations.Recitation10.main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class AScene implements Scene{
	ImageShape thief;
	ImageShape house;
	ImageShape alarm;
	ImageShape policeman;
	StringShape state;
	boolean thiefExist;
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();
	
	Thread thread1;
	Thread thread2;
	static int threadNumber = 0;
	static String THREAD_NAME_1 = "Thief Animation";
	static String THREAD_NAME_2 = "Policeman Animation";
	
	public AScene(){
		thief = new AShapeImage("thief.png", 900, 100);
		house = new AShapeImage("house.png", 400, 50);
		alarm = new AShapeImage("alarm2.png", 50, 50);
		policeman  = new AShapeImage("police.jpg", 1600, 100);
		state = new AStringShape("zZZ  zZZ", 190, 70);
		thiefExist = true;
		thief.addPropertyChangeListener(this);
		policeman.addPropertyChangeListener(this);
	}
	public void setTheifExist(){
		thiefExist = false;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "thief existence",
				true, false));
	}
	public boolean preGetThief(){return thiefExist;}
	public ImageShape getThief(){
		assert preGetThief();
		return thief;
		}
	public ImageShape getHouse(){return house;}
	public ImageShape getAlarm(){return alarm;}
	public ImageShape getPoliceman(){return policeman;}
	public StringShape getState(){return state;}
	public boolean getThiefExist(){return thiefExist;}

	@SuppressWarnings("deprecation")
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if( (Integer)(arg0.getOldValue()) <= 500){
			alarm.setImageFileName("alarm1.png");
			state.setText("Alarm! Alarm!");
		}
		
		if(thief.getX() > policeman.getX() - 60){
			this.setTheifExist();
			thread1.stop();//Not good to use stop(), since it may cause deadlock
			thread2.stop();
		}
	}
	/*here is the body of demo*/
	public void demo(){
		OEFrame editor = ObjectEditor.edit(this);
		editor.hideMainPanel();
		editor.setSize(1000, 400);
		ThreadSupport.sleep(2000);
		
        thread1 = new Thread(new AnImageAnimationCommand(thief, 480, 1, 10));   
        threadNumber++;
        thread1.setName(THREAD_NAME_1 + " " + threadNumber);
        thread2 = new Thread(new AnImageAnimationCommand(policeman, policeman.getX(), 3, 10));   
        System.out.println("BLAH");
        threadNumber++;
        thread1.setName(THREAD_NAME_2 + " " + threadNumber);
        thread1.start();
		thread2.start();
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
	}
}