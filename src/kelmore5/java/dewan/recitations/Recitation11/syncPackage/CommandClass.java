package kelmore5.java.dewan.recitations.Recitation11.syncPackage;

public class CommandClass implements Runnable{
	public void run() {
		synchronized(this) {
			for (int i = 0; i < 8; i++) {
				System.out.println("Thread "+ Thread.currentThread().getName() + 
						" synchronized loop " + i);
			}
		}
	}
}
