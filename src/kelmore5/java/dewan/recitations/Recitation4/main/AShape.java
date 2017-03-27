package kelmore5.java.dewan.recitations.Recitation4.main;

import util.annotations.ComponentWidth;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

import java.awt.Color;

//@StructurePattern(StructurePatternNames.LINE_PATTERN)
@StructurePattern(StructurePatternNames.RECTANGLE_PATTERN)
//@StructurePattern(StructurePatternNames.OVAL_PATTERN)
//@StructurePattern(StructurePatternNames.BEAN_PATTERN)

/***^^^DO NOT UNCOMMENT MORE THAN ONE OF THE ABOVE AT A TIME ^^^***/

public class AShape implements Shape{
    int x, y, width, height;
    
    public AShape (int initX, int initY, int initWidth, int initHeight) {
        x = initX; 
        y = initY;
        width = initWidth;
        height = initHeight;    
    }
    public Color getColor(){return Color.blue;}
    @ComponentWidth(50)    // only affects main panel (text fields)
    public int getX() {return x;}
    public void setX(int newX) {x = newX;}
    public int getY() {return y;}
    public void setY(int newY) {y = newY;}
    public int getWidth() {return width;}
    public void setWidth(int newVal) {width = newVal;}
    @ComponentWidth(250)    // only affects main panel (text fields)
    public int getHeight() {return height;}
    public void setHeight(int newHeight) {height = newHeight;}

}
