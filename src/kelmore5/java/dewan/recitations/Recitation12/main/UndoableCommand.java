package kelmore5.java.dewan.recitations.Recitation12.main;

public interface UndoableCommand<T> {
    public void execute();
    public void undo();
}
