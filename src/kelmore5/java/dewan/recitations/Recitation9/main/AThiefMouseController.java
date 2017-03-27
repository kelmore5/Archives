package kelmore5.java.dewan.recitations.Recitation9.main;

import java.awt.event.MouseEvent;

public class AThiefMouseController implements ThiefMouseController{
	Scene aScene;
	ASceneView aView;
    
    public AThiefMouseController (Scene newScene, ASceneView newView) {
    	aScene = newScene;
    	aView = newView;
    	aView.addMouseListener(this);
    }   
    public void mouseClicked(MouseEvent e) {
        aScene.getThief().setX(e.getX());
        aScene.getThief().setY(e.getY());
    }    
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}  
}
