package kelmore5.java.dewan.recitations.Recitation9.main;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.STRING_PATTERN) 
public class AStringShape implements StringShape{
    String text;
    int x, y;
    int fontSize = 24;
    PropertyListenerSupport propertySupport = new APropertyListenerSupport();

    public AStringShape(String initText, int initX, int initY) {
        text = initText;
        x = initX;
        y = initY;
    }
    
    public int getX() {
        return x;
    }
    public int getFontSize(){return fontSize;}
    public void setX(int newX) {
        x = newX;
    }
    public int getY() {
        return y;
    }
    public void setY(int newY) {
        y = newY;
    }
    public String getText() {
        return text;
    }
    public void setText(String newVal) {
    	String oldVal = text;
        text = newVal;
        propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Text", oldVal,
                newVal));
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.add(listener);  
    }

}
