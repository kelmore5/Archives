package kelmore5.java.dewan.Assignments.Assignment12.main;
import javax.swing.JFrame;

import bus.uigen.ObjectEditor;
import bus.uigen.uiFrame;
import kelmore5.java.dewan.Assignments.Assignment12.mp.drawables.interfaces.BridgeImpl;
import kelmore5.java.dewan.Assignments.Assignment12.mp.interfaces.BeanInterface;
import kelmore5.java.dewan.Assignments.Assignment12.mp.interfaces.BroadcastingClearanceManagerImpl;
import kelmore5.java.dewan.Assignments.Assignment12.mp.interfaces.CommandInterpreterImpl;
import kelmore5.java.dewan.Assignments.Assignment12.mp.main.ConsoleSceneView;
import kelmore5.java.dewan.Assignments.Assignment12.mp.main.SingletonsCreator;
import util.misc.ThreadSupport;

@SuppressWarnings("static-access")
public class Assignment12{
	//gets input from the user
	static SingletonsCreator s = new SingletonsCreator();
	static BeanInterface bean = s.getOrCreateScannerBean();
	static BridgeImpl bridge = s.getOrCreateBridge();
	private static final int frameSize = 1000;
	private static final int waitTime = 3000;
	static CommandInterpreterImpl commands = s.getOrCreateCommandInterpreter();
	static ConsoleSceneView view = s.getOrCreateConsoleSceneView();
	static BroadcastingClearanceManagerImpl manager = s.getOrCreateBroadcastingClearanceManager();

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		uiFrame oeFrame = ObjectEditor.edit(bridge);
		oeFrame.setSize(frameSize, frameSize);
		
		commands.addPropertyChangeListener(view);
		
		JFrame frame = new JFrame();
		
		frame.add(s.getOrCreateBridgeScenePainter());
		frame.setSize(frameSize, frameSize);
		frame.setVisible(true);
		
		uiFrame oeFrame2 = ObjectEditor.edit(commands);
		oeFrame.setSize(frameSize/2, frameSize/2);
		
		uiFrame oeFrame3 = ObjectEditor.edit(manager);
		oeFrame.setSize(frameSize/2, frameSize/2);
				
		ThreadSupport.sleep(waitTime);
		
		/*commands.setCommand("approach Galahad ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("say \"hi!\" ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("say \"Hello!\" ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("approach Robin ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("passed ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("approach Robin ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("say \"You will not pass.!\" ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("say \"Aw man!\" ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("failed ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("approach Lancelot ");
		
		commands.setCommand("{ move Arthur 50 50 say \"Hi?\" move Galahad 60 40 } ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("repeat 4 { move Arthur 50 50 say \"Name?\" } ");
		ThreadSupport.sleep(waitTime);
		
		commands.animateArthur();
		commands.animateArthur();
		commands.animateGalahad();
		commands.animateLancelot();
		commands.animateRobin();
		
		ThreadSupport.sleep(waitTime);
		commands.animateArthur();*/
		
		commands.waitingArthur();
		commands.waitingGalahad();
		commands.waitingLancelot();
		commands.waitingRobin();
		
		ThreadSupport.sleep(waitTime);
		commands.waitingArthur();
	}
}