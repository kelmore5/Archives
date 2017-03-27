package kelmore5.java.dewan.recitations.Recitation9.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class AThiefController implements ThiefController, ActionListener{
	JButton button;
	Scene aScene;
	
    public AThiefController(JButton aButton, Scene theScene) {
        button = aButton;
        aScene = theScene;
        button.addActionListener(this);
    }

	public void setModel(Scene newScene) {
		aScene = newScene;
	}

	public void actionPerformed(ActionEvent arg0) {
			aScene.getThief().setX(aScene.getThief().getX() - 30);
	}

	public void processInput() {}

}
