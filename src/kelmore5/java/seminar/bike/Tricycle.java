package kelmore5.java.seminar.bike;

import java.awt.Color;

class Tricycle extends Bicycle {
  Color color;
  int speed;

  public Tricycle() {
    super(3, 0, Color.blue);
    color = Color.blue;
    speed = 0;
  }
  
  void paintBike(Color _color) {
    speed += 5;
    color = _color;
  }
  
  void printSpecs() {
    System.out.println("Wheels: " + wheels 
                         + "\nSpeed: " + speed
                      + "\nColor: " + color);
  }
  
}