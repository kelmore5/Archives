package kelmore5.java.dewan.Assignments.Assignment6.main;
import bus.uigen.ObjectEditor;
import bus.uigen.uiFrame;
import kelmore5.java.dewan.Assignments.Assignment6.mp.commands.Bean;
import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.Bridge;
import kelmore5.java.dewan.Assignments.Assignment6.mp.drawables.interfaces.BridgeImpl;
import kelmore5.java.dewan.Assignments.Assignment6.mp.interfaces.BeanInterface;
import util.misc.ThreadSupport;

public class Assignment6{
	//gets input from the user
	static BeanInterface bean = new Bean();
	static BridgeImpl bridge = new Bridge();
	private static final int frameSize = 1000;
	private static final int waitTime = 1000;

	public static void main(String[] args) {
		uiFrame oeFrame = ObjectEditor.edit(bridge);
		oeFrame.setSize(frameSize, frameSize);
		oeFrame.refresh();
		ThreadSupport.sleep(waitTime);
		
		uiFrame oeFrame2 = ObjectEditor.edit(bean); 
		bean.setScannedString("MoVe 050 { SaY \"hi!\" } call thread wait ");
		oeFrame2.refresh();
		ThreadSupport.sleep(waitTime*3);
		bean.setScannedString("RotateLeftArm 5 rotateLeftArm approach define fail move ");
		oeFrame2.refresh();
		ThreadSupport.sleep(waitTime*3);
		bean.setScannedString("pass proceed redo repeat sleep undo ");
		oeFrame2.refresh();
		ThreadSupport.sleep(waitTime*3);
		
		
		bridge.approach(bridge.getArthur());
		refreshAndSleep(oeFrame, waitTime);
		
		bridge.say("You will pass");
		refreshAndSleep(oeFrame, waitTime);
		
		bridge.say("Okay");
		refreshAndSleep(oeFrame, waitTime);
		
		bridge.passed();
		refreshAndSleep(oeFrame, waitTime);
		
		bridge.approach(bridge.getGalahad());
		refreshAndSleep(oeFrame, waitTime);

		bridge.say("You will fail");
		refreshAndSleep(oeFrame, waitTime);
		
		bridge.say("Okay");
		refreshAndSleep(oeFrame, waitTime);
		
		bridge.failed();
		refreshAndSleep(oeFrame, waitTime);
		
		bridge.approach(bridge.getLancelot());
		refreshAndSleep(oeFrame, waitTime);
		
		bridge.say("I will fail");
		refreshAndSleep(oeFrame, waitTime);
		
		bridge.failed();
		refreshAndSleep(oeFrame, waitTime);
	}
	
	public static void refreshAndSleep(uiFrame oeFrame, int time) {
		oeFrame.refresh();
		ThreadSupport.sleep(time);
		oeFrame.refresh();
	}
}