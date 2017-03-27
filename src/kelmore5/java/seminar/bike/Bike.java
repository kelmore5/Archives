package kelmore5.java.seminar.bike;

import java.awt.Color;

public interface Bike {
  int speedUp(int increment);
  int applyBrakes(int increment);
  void printSpecs();
  void paintBike(Color _color);
}