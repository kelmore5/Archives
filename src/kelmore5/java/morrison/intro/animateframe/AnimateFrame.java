package kelmore5.java.morrison.intro.animateframe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class AnimateFrame extends JFrame implements Runnable
{
  static Random r;
  static
  {
    r = new Random();
  }
  Point position;
  AnimatePanel ap;
  int xdir;
  int ydir;
  public AnimateFrame()
  {
    super("Animation Demonstration and Defenestration");
    setLocation(r.nextInt(800), r.nextInt(800));
    position = new Point(0,0);
    ap = new AnimatePanel();
    xdir = 1;
    ydir = 1;
  }
  public void run()
  {
    setSize(500,500);
    getContentPane().add(ap);
    makeMenus();
    setVisible(true);
    for(int k = 0; k < 3000; k++)
    {
      position.x += xdir;
      position.y += ydir;
      if(position.x > ap.getWidth() - 100)
        xdir = -xdir;
      if(position.x < 0)
        xdir = -xdir;
      if(position.y > ap.getHeight() - 100)
        ydir = -ydir;
      if(position.y < 0)
        ydir = -ydir;
      try
      {
        Thread.sleep(20);
      }
      catch(Exception ex)
      {
        //quackment
      }
      repaint();
    }
  }
  private void makeMenus()
  {
    JMenuBar mbar = new JMenuBar();
    setJMenuBar(mbar);
    JMenu fileMenu = new JMenu("File");
    JMenuItem newItem = new JMenuItem("New");
    JMenuItem closeItem = new JMenuItem("Close");
    JMenuItem quitItem = new JMenuItem("Quit");
    mbar.add(fileMenu);
    fileMenu.add(newItem);
    fileMenu.add(closeItem);
    fileMenu.add(quitItem);
    quitItem.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    });
    closeItem.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        dispose();
      }
    });
    newItem.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        Thread t = new Thread(new AnimateFrame());
        t.start();
      }
    });
  }
  class AnimatePanel extends JPanel
  {
    public void paintComponent(Graphics g)
    {
      g.setColor(Color.magenta);
      g.fillRect(0,0,getWidth(),getHeight());
      g.setColor(Color.yellow);
      g.fillOval(position.x, position.y, 100,100);
    }
  }
  public static void main(String[] args)
  {
    Thread t = new Thread(new AnimateFrame());
    t.start();
  }
  
}