package kelmore5.java.dewan.recitations.Recitation9.main;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		Scene test = new AScene();
		ASceneView view = new ASceneView(test);
		
		JFrame frame = new JFrame("A Scene View");
		JFrame frame2 = new JFrame("Thief Controller");
		frame.add((Component) view);
		frame.setSize(1000, 400);
		frame.setVisible(true);
		
		
		JButton button = new JButton("Marches the Thief");
		frame2.add(button);
		frame2.setSize(300, 100);
		frame2.setVisible(true);
		frame2.setLocation(300, 450);
		ThiefController controller = new AThiefController(button, test);
		
		ThiefMouseController controller2 = new AThiefMouseController(test, view);

		PropertyChangeMonitor theMonitor = new APropertyChangeMonitor(test);
	}
	
}
