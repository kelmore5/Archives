package kelmore5.java.dewan.recitations.Recitation10.main;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.models.PropertyListenerRegisterer;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
public interface StringShape extends PropertyListenerRegisterer {
	    public int getX();
	    public void setX(int newX);
	    public int getY();
	    public void setY(int newY);
	    public String getText() ;  
	    public void setText(String newVal); 
	    public int getFontSize();

}
