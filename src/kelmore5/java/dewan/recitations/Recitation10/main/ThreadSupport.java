package kelmore5.java.dewan.recitations.Recitation10.main;

public class ThreadSupport {
	    
	    public static void sleep(long interval) {
	        try {
	            Thread.sleep(interval);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
