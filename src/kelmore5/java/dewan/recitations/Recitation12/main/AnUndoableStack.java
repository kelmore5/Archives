package kelmore5.java.dewan.recitations.Recitation12.main;

public class AnUndoableStack<T>{
	MyStack<T> stack = new AStack<T>();
	Undoer<T> historyUndoer = new UndoerHistory<T>();
	Undoer<T> lastCommandUndoer = new LastCommandUndoer<T>();
	
    public T pop () {
    	return stack.pop();
    }
    
    public T peek(){
    	return stack.peek();
    }

    public void push(T element){
//    	historyUndoer.execute(new AddCommand<T>(stack, element));
    	lastCommandUndoer.execute(new AddCommand<T>(stack, element));
    }
    
    public void printStack(){
    	stack.printStack();
    }
    public void undo() {
//    	historyUndoer.undo();
    	lastCommandUndoer.undo();
    	}
    public void redo() {
//    	historyUndoer.redo();
    	lastCommandUndoer.redo();
    	} 
    
    public static void main(String[] arg){
    	AnUndoableStack<Integer> aStack = new AnUndoableStack<Integer>();
    	
    	aStack.push(1);
    	aStack.push(2);
    	aStack.push(3);
    	aStack.push(4);
    	aStack.printStack();
    	
    	aStack.undo();
    	
    	aStack.printStack();
    }
}
