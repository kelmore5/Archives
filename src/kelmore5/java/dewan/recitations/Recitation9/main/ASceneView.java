package kelmore5.java.dewan.recitations.Recitation9.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;



import util.models.PropertyListenerRegisterer;

public class ASceneView extends Component implements PropertyChangeListener{
	Scene aScene;
    BasicStroke dotted = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 
            5f, new float[] {2f}, 0f);
    
    public ASceneView(Scene theScene){
    	aScene = theScene;
    	aScene.addPropertyChangeListener(this);
    }
   
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(dotted);
        g.setColor(Color.BLACK);     
        draw(g2, aScene);
    }
    
    public void draw(Graphics2D g, Scene scene) {
    	draw(g, scene.getAlarm());
        draw(g, scene.getState());
        draw(g, scene.getThief());
        draw(g, scene.getHouse());
        
    }

    public void draw(Graphics g, StringShape aLabel) {
        String s = aLabel.getText();
        g.drawString(s, aLabel.getX(), aLabel.getY());      
    }
    
    public  void draw(Graphics2D g, ImageShape anImage) {
        Image img = Toolkit.getDefaultToolkit().getImage(anImage.getImageFileName());
        g.drawImage(img, anImage.getX(), anImage.getY(), this);     
    }
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		repaint();
	}
	
	public void register (PropertyListenerRegisterer aPropertyChangeRegister){
		aPropertyChangeRegister.addPropertyChangeListener(this);        
	}

}
