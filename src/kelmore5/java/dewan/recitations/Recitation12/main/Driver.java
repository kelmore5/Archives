package kelmore5.java.dewan.recitations.Recitation12.main;

public class Driver {
	public static void main(String[] arg) {
		MyStack<Integer> test = new AStack<Integer>();
		MyStack<String> str = null;

		for (int i = 0; i < 10; i++) {
			try {
				test.push(i);
				str.printStack();
			} catch (FullCollectionException e) {
				System.out.println("Adding item to a full collection");
			} catch (Exception e) {
			}
		}

		test.printStack();
	}
}
