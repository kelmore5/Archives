package kelmore5.java.dewan.recitations.Recitation11.syncPackage;

public class main {
	public static void main(String[] args) {
		CommandClass test = new CommandClass();
		Thread threadA = new Thread(test, "A");
		Thread threadB = new Thread(test, "B");
		threadA.start();
		threadB.start();
	}
}
