package kelmore5.java.dewan.Assignments.Assignment10.main;
import javax.swing.JFrame;

import bus.uigen.ObjectEditor;
import bus.uigen.uiFrame;
import kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.interfaces.BridgeImpl;
import kelmore5.java.dewan.Assignments.Assignment10.mp.interfaces.BeanInterface;
import kelmore5.java.dewan.Assignments.Assignment10.mp.interfaces.CommandInterpreterImpl;
import kelmore5.java.dewan.Assignments.Assignment10.mp.main.SingletonsCreator;
import util.misc.ThreadSupport;

public class Assignment10{
	//gets input from the user
	static SingletonsCreator s = new SingletonsCreator();
	static BeanInterface bean = s.getOrCreateScannerBean();
	static BridgeImpl bridge = s.getOrCreateBridge();
	private static final int frameSize = 1000;
	private static final int waitTime = 1000;
	static CommandInterpreterImpl commands = s.getOrCreateCommandInterpreter();

	public static void main(String[] args) {
		uiFrame oeFrame = ObjectEditor.edit(bridge);
		oeFrame.setSize(frameSize, frameSize);
		
		s.getOrCreateConsoleSceneView();
		
		JFrame frame = new JFrame();
		
		frame.add(s.getOrCreateBridgeScenePainter());
		frame.setSize(1000, 1000);
		frame.setVisible(true);
				
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("approach Arthur ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("say \"hi!\" ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("say \"Hello!\" ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("approach Robin ");
		ThreadSupport.sleep(waitTime);
		
		bridge.passed();
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("approach Robin ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("say \"You will not pass.!\" ");
		ThreadSupport.sleep(waitTime);
		
		bridge.failed();
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("move Arthur 0200 0100 ");
		ThreadSupport.sleep(waitTime);
		
		commands.animateArthur();
		commands.animateGalahad();
		commands.animateLancelot();
		commands.animateRobin();
	}
}