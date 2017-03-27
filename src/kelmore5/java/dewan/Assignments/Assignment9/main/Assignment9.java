package kelmore5.java.dewan.Assignments.Assignment9.main;
import javax.swing.JFrame;

import bus.uigen.ObjectEditor;
import bus.uigen.uiFrame;
import kelmore5.java.dewan.Assignments.Assignment9.mp.drawables.interfaces.BridgeImpl;
import kelmore5.java.dewan.Assignments.Assignment9.mp.interfaces.BeanInterface;
import kelmore5.java.dewan.Assignments.Assignment9.mp.interfaces.CommandInterpreterImpl;
import kelmore5.java.dewan.Assignments.Assignment9.mp.main.SingletonsCreator;
import util.misc.ThreadSupport;

public class Assignment9{
	//gets input from the user
	static SingletonsCreator s = new SingletonsCreator();
	static BeanInterface bean = s.getOrCreateScannerBean();
	static BridgeImpl bridge = s.getOrCreateBridge();
	private static final int frameSize = 1000;
	private static final int waitTime = 1000;
	static CommandInterpreterImpl commands = s.getOrCreateCommandInterpreter();

	public static void main(String[] args) {
		uiFrame oeFrame = ObjectEditor.edit(bridge);
		oeFrame.setSize(1000, 1000);
		
		s.getOrCreateConsoleSceneView();
		
		JFrame frame = new JFrame();
		
		frame.add(s.getOrCreateBridgeScenePainter());
		frame.setSize(1000, 1000);
		frame.setVisible(true);
				
		ThreadSupport.sleep(1000);
		
		commands.setCommand("approach Arthur ");
		ThreadSupport.sleep(1000);
		
		commands.setCommand("say \"hi!\" ");
		ThreadSupport.sleep(1000);
		
		commands.setCommand("say \"Hello!\" ");
		ThreadSupport.sleep(1000);
		
		commands.setCommand("move Arthur 0200 0100 ");
		ThreadSupport.sleep(1000);
	}
}