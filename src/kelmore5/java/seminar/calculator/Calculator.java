package kelmore5.java.seminar.calculator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;

public class Calculator implements Runnable{
  private JFrame frame;
  private JPanel panel;
  
  public Calculator() {
    frame = new JFrame();
    panel = new JPanel();
    panel.setBackground(new Color(255,255,255));
    
    JPanel numberPanel = new JPanel(new GridLayout(3,3));
    numberPanel.add(new JButton("9"));
    numberPanel.add(new JButton("8"));
    numberPanel.add(new JButton("7"));
    numberPanel.add(new JButton("6"));
    numberPanel.add(new JButton("5"));
    numberPanel.add(new JButton("4"));
    numberPanel.add(new JButton("3"));
    numberPanel.add(new JButton("2"));
    numberPanel.add(new JButton("1"));
    
    panel.add(numberPanel);
  }
  
  public void run() {
    frame.setVisible(true);
    frame.setSize(500,500);
    frame.add(panel);
  }
  
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    javax.swing.SwingUtilities.invokeLater(calculator);
  }
}