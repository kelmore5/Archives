package kelmore5.java.dewan.Assignments.Assignment7.main;
import bus.uigen.ObjectEditor;
import bus.uigen.uiFrame;
import kelmore5.java.dewan.Assignments.Assignment7.mp.commands.Bean;
import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.Bridge;
import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.interfaces.BridgeImpl;
import kelmore5.java.dewan.Assignments.Assignment7.mp.interfaces.BeanInterface;
import kelmore5.java.dewan.Assignments.Assignment7.mp.interfaces.CommandInterpreterImpl;
import kelmore5.java.dewan.Assignments.Assignment7.mp.interfaces.TableInterface;
import kelmore5.java.dewan.Assignments.Assignment7.mp.main.CommandInterpreter;
import kelmore5.java.dewan.Assignments.Assignment7.mp.main.TableImpl;
import util.misc.ThreadSupport;

public class Assignment7{
	//gets input from the user
	static BeanInterface bean = new Bean();
	static BridgeImpl bridge = new Bridge();
	private static final int frameSize = 1000;
	private static final int waitTime = 1000;
	static CommandInterpreterImpl commands = new CommandInterpreter(bridge, bean);

	public static void main(String[] args) {
		uiFrame oeFrame = ObjectEditor.edit(bridge);
		oeFrame.setSize(frameSize, frameSize);
		oeFrame.refresh();
		
		uiFrame oeFrame2 = ObjectEditor.edit(bean);
		uiFrame oeFrame3 = ObjectEditor.edit(commands);
		
		uiFrame[] frames = {oeFrame, oeFrame2, oeFrame3};
		
		ThreadSupport.sleep(1000);
		
		commands.setCommand("approach Arthur ");
		refreshAllFramesAndSleep(frames);
		
		commands.setCommand("say \"hi!\" ");
		refreshAllFramesAndSleep(frames);
		
		commands.setCommand("say \"Hello!\" ");
		refreshAllFramesAndSleep(frames);
		
		commands.setCommand("move Arthur 0200 0100 ");
		refreshAllFramesAndSleep(frames);
		
		TableInterface table = new TableImpl();
		
		table.put("Hello", 5);
		table.put("Hi", 6);
		
		System.out.println(table.get("hello"));
		System.out.println(table.get("hi"));
		
		table.put("Hi", 1);
		
		System.out.println(table.get("hi"));
	}
	
	public static void refreshAllFramesAndSleep(uiFrame[] oeFrames) {
		for(uiFrame u: oeFrames) {
			u.refresh();
		}
		ThreadSupport.sleep(waitTime);
	}
	
	public static void refreshAndSleep(uiFrame oeFrame, int time) {
		oeFrame.refresh();
		ThreadSupport.sleep(waitTime*2);
	}
}