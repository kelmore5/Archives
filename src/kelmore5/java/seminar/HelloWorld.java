package kelmore5.java.seminar;

/**
 * Basic operations:
 * 
 * Math
 * 
 * String
 * 
 * Declaring object type
 * 
 * int, String, char, byte, boolean
 * 
 * Hello World
 * 
 * Discuss objects in real world and classes
 **/

public class HelloWorld {
  
  public void sayHello() {
    System.out.println("Hello!");
  }
  
  public static void main(String[] args) {
    System.out.println("Hello!");
  }
  
  private class Bicycle {
    
    int cadence = 0;
    int speed = 0;
    int gear = 1;
    
    void changeCadence(int newValue) {
      cadence = newValue;
    }
    
    void changeGear(int newValue) {
      gear = newValue;
    }
    
    void speedUp(int increment) {
      speed = speed + increment;   
    }
    
    void applyBrakes(int decrement) {
      speed = speed - decrement;
    }
    
    void printStates() {
      System.out.println("cadence:" +
                         cadence + " speed:" + 
                         speed + " gear:" + gear);
    }
  }
  
  //Inheritance
  //Shares properties in common with other class
  //Can use methods from class it is extending, overwrite methods, etc
  //Can add new methods as well
  private class MountainBike extends Bicycle {
    
  }
  
  private interface Bike {
     //  wheel revolutions per minute
    void changeCadence(int newValue);

    void changeGear(int newValue);

    void speedUp(int increment);

    void applyBrakes(int decrement);
  }
  
  //Implementing an interface
  //Must implement all methods
  //A contract betweeen this class and the interface
  private class ACMEBicycle implements Bike {

    // remainder of this class 
    // implemented as before
    public void changeCadence(int newValue) {
      
    }

    public void changeGear(int newValue) {
    }

    public void speedUp(int increment) {
    }

    public void applyBrakes(int decrement) {
    }
}
  
  //arrays
  //have to specifity number and object type
  //
}