package kelmore5.java.dewan.recitations.Recitation11.main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class AScene implements Scene{
	ImageShape plane;
	ImageShape car;
	ImageShape ship;
	
	AnAnimator carAnimator;
	AnAnimator planeAnimator;
	AnAnimator shipAnimator;
	
	public AScene(){
		car  = new AShapeImage("car.jpg", 0, 100);
		plane = new AShapeImage("airplane.jpg", 0, 300);
		ship = new AShapeImage("ship.jpg", 0, 500);
		
		ClearanceManager manager = new AClearanceManager();
		OEFrame editor2 = ObjectEditor.edit(manager);
		
		carAnimator = new AnAnimator(car, manager);
		planeAnimator = new AnAnimator(plane, manager);
		shipAnimator = new AnAnimator(ship, manager);
	}
	
	public void demo(){
		Thread carThread = new Thread(carAnimator, "car");
		Thread planeThread = new Thread(planeAnimator, "plane");
		Thread shipThread = new Thread(shipAnimator, "ship");
		
		carThread.start();
		planeThread.start();
		shipThread.start();
	}
	
	public ImageShape getCar(){
		return car;
	}
	public ImageShape getAirplane(){
		return plane;
	}
	public ImageShape getShip(){
		return ship;
	}
}
