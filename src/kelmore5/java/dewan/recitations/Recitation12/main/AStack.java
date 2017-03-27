package kelmore5.java.dewan.recitations.Recitation12.main;

public class AStack<T> implements MyStack<T>{
	public final int MAX_SIZE = 5;
    Object[] contents = new Object[MAX_SIZE];
    int size = 0;
    public int size() {return size; }   
    
    public T pop () {
    	size -= 1;
    	return (T)contents[size];
    }
    
    public T peek(){
    	return (T)contents[size - 1];
    }
    
    boolean isFull() {return size == MAX_SIZE;  }

    public void push(T element) {
        if (isFull())
            throw new FullCollectionException("");
        else {
            contents[size] = element;
            size++;
        }
    }
    
    public void printStack(){
    	for(int i=0; i<size; i++){
    		System.out.println(contents[i]);
    	}
    }
}
