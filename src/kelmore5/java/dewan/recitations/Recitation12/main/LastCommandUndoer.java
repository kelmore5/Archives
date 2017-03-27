package kelmore5.java.dewan.recitations.Recitation12.main;

public class LastCommandUndoer<T> implements Undoer<T>{
	 UndoableCommand<T> lastCommand = null;
	    boolean lastCommandWasUndone = false;
	    public void execute (UndoableCommand<T> c){
	        c.execute();
	        lastCommand = c;
	        lastCommandWasUndone = false;
	    }    
	    public void undo() {
	        if (lastCommandWasUndone || lastCommand == null)   
	            return;       
	        lastCommand.undo();
	        lastCommandWasUndone = true;              
	    }
	    public void redo() {
	        if (!lastCommandWasUndone || lastCommand == null)
	            return;        
	        lastCommand.execute();
	        lastCommandWasUndone = false;                   
	    }
}
