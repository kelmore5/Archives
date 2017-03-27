package kelmore5.java.seminar.bike;

import java.awt.Color;

class Bicycle {
  
  int wheels;
  int speed;
  Color color;
  
  public Bicycle() {
    wheels = 2;
    speed = 0;
    color = Color.red;
  }
  
  public Bicycle(int _wheels, int _speed, Color _color) {
    wheels = _wheels;
    speed = _speed;
    color = _color;
  }
  
  int speedUp(int increment) {
    speed += increment;
    return speed;
  }
  
  int applyBrakes(int increment) {
    speed -= increment;
    return speed;
  }
  
  void paintBike(Color _color) {
    color = _color;
  }
  
  void printSpecs() {
    System.out.println("Wheels: " + wheels 
                         + "\nSpeed: " + speed
                      + "\nColor: " + color);
  }
}