package kelmore5.java.dewan.recitations.Recitation4.main;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.LINE_PATTERN)
public class ALine implements Shape{
    int x, y, width, height;
    
    public ALine (int initX, int initY, int initWidth, int initHeight) {
        x = initX; 
        y = initY;
        width = initWidth;
        height = initHeight;    
    }
    public int getX() {return x;}
    public void setX(int newX) {x = newX;}
    public int getY() {return y;}
    public void setY(int newY) {y = newY;}
    public int getWidth() {return width;}
    public void setWidth(int newVal) {width = newVal;}
    public int getHeight() {return height;}
    public void setHeight(int newHeight) {height = newHeight;}

}
