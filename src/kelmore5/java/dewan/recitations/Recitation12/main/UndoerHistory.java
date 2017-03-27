package kelmore5.java.dewan.recitations.Recitation12.main;

import java.util.ArrayList;
import java.util.List;

public class UndoerHistory<T> implements Undoer<T>{
    List<UndoableCommand<T>> historyList = new ArrayList<UndoableCommand<T>>();    
    int nextCommandIndex = 0;
    public void execute (UndoableCommand<T> c) {
        while(nextCommandIndex < historyList.size()) {
              historyList.remove(nextCommandIndex); // clear redo chain
        }       
        c.execute();
        historyList.add(c); 
        nextCommandIndex++;
    }
    public void undo() {
        if (nextCommandIndex == 0)return;
        nextCommandIndex--;
        UndoableCommand<T> c = historyList.get(nextCommandIndex);
        c.undo();       
    }
    public void redo() {
        if (nextCommandIndex == historyList.size()) return;
        UndoableCommand<T> c = historyList.get(nextCommandIndex);
        c.execute();
        nextCommandIndex++;         
    }
}
