package kelmore5.java.dewan.recitations.Recitation12.main;

public interface Undoer<T> {
    public void undo();
    public void execute(UndoableCommand<T> command);
    public void redo();
}
