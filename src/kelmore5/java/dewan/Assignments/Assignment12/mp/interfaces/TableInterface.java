package kelmore5.java.dewan.Assignments.Assignment12.mp.interfaces;

import util.annotations.Tags;

@Tags({"Table"})
public interface TableInterface<Key, T> {
	public void put(Key key, T value);
	public T get(Key key);
}
