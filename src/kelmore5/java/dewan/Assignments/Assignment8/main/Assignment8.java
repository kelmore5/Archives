package kelmore5.java.dewan.Assignments.Assignment8.main;
import bus.uigen.ObjectEditor;
import bus.uigen.uiFrame;
import kelmore5.java.dewan.Assignments.Assignment8.mp.drawables.interfaces.BridgeImpl;
import kelmore5.java.dewan.Assignments.Assignment8.mp.interfaces.BeanInterface;
import kelmore5.java.dewan.Assignments.Assignment8.mp.interfaces.CommandInterpreterImpl;
import kelmore5.java.dewan.Assignments.Assignment8.mp.main.SingletonsCreator;
import util.misc.ThreadSupport;

public class Assignment8{
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
				
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("approach Arthur ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("say \"hi!\" ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("say \"Hello!\" ");
		ThreadSupport.sleep(waitTime);
		
		commands.setCommand("move Arthur 0200 0100 ");
		ThreadSupport.sleep(waitTime);
	}
}