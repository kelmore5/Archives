package kelmore5.java.dewan.recitations.Recitation12.main;

public class AddCommand<T> implements UndoableCommand<T>{
	MyStack<T> aStack;
	T newVal;
	
	public AddCommand(MyStack<T> newStack, T val){
		aStack = newStack;
		newVal = val;
	}
	public void execute() {
		try {
			aStack.push(newVal);
		} catch (FullCollectionException e) {
			e.printStackTrace();
		}
	}

	public void undo() {
		aStack.pop();
	}
}
