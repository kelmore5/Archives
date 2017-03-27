package kelmore5.java.seminar.bike;

import java.awt.Color;

class MountainBike implements Bike{
    int gear = 0;
    
      
  void changeGear(int _gear) {
    gear = _gear;
  }
  
  public void paintBike(Color _color) {
    
  }
  
  public void printSpecs() {
    
  }
  
  public int applyBrakes(int increment) {
    return 0;
  }
  
  public int speedUp(int increment) {
    return 0;
  }
  
  private void hello() {
    System.out.println("Hello");
  }
}