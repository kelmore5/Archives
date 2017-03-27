package kelmore5.java.dewan.recitations.Recitation4.main;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Driver {
	public static void main(String[] args) {
		Shape[] lineArray = new Shape[2];
		lineArray[0] = new ALine(5,10,50,50);
		lineArray[1] = new AShape(5,5,69,69);
		OEFrame editor = ObjectEditor.edit(lineArray);
//		editor.showTreePanel();   /** Try uncommenting this **/
//		editor.hideMainPanel();   /** Try uncommenting this (when using Bean Pattern in AShape) **/
		editor.setSize(600,200);
		/*demo, motion of object*/
		for(int i = 0;i < 500; i++){
			sleep(8);/* the unit is millisecond*/
			moveShapes(lineArray,1);
			editor.refresh();
		}
		/*demo ends*/
		
	}
	/*move an object along the x axis*/
	public static void moveShape(Shape lineInstance, int xDist){
		lineInstance.setX(xDist + lineInstance.getX());
	}
	/* move an array of objects along the x axis
	 *  by calling the moveShape method individually
	 */
	public static void moveShapes(Shape[] lineInstance, int xDist){
		for(Shape aLine : lineInstance){
			moveShape(aLine, xDist);
		}
	}
	
	/*enable program can be hung up for a while*/
    public static void sleep(long interval) {
        try {
            Thread.sleep(interval);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
