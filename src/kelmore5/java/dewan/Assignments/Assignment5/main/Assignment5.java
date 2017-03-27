package kelmore5.java.dewan.Assignments.Assignment5.main;
import bus.uigen.ObjectEditor;
import bus.uigen.uiFrame;
import kelmore5.java.dewan.Assignments.Assignment5.mp.commands.Bean;
import kelmore5.java.dewan.Assignments.Assignment5.mp.drawables.Bridge;
import util.misc.ThreadSupport;

public class Assignment5{
	//gets input from the user
	static Bean bean = new Bean();
	static Bridge bridge = new Bridge();

	public static void main(String[] args) {
		uiFrame oeFrame = ObjectEditor.edit(bridge);
		oeFrame.setSize(1000, 1000);
		oeFrame.refresh();
		ThreadSupport.sleep(1000);
		
		bridge.getArthur().move(200, 200);
		refreshAndSleep(oeFrame, 1000);
		
		bridge.getGalahad().move(250, 50);
		refreshAndSleep(oeFrame, 1000);
	}
	
	public static void refreshAndSleep(uiFrame oeFrame, int time) {
		oeFrame.refresh();
		ThreadSupport.sleep(2000);
	}
}