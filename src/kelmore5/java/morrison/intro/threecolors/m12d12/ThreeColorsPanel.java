package kelmore5.java.morrison.intro.threecolors.m12d12;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

public class ThreeColorsPanel extends JPanel
{
  private ColorPanel left;
  private ColorPanel middle;
  private ColorPanel right;
  
  public ThreeColorsPanel()
  {
    super(new GridLayout(1,3));
    left = new ColorPanel();
    middle = new ColorPanel();
    right = new ColorPanel();
    add(left);
    add(middle);
    add(right);
  }
  public ColorPanel getLeft()
  {
    return left;
  }
  public ColorPanel getMiddle()
  {
    return middle;
  }
  public ColorPanel getRight()
  {
    return right;
  }
}