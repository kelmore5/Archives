package kelmore5.java.dewan.Assignments.Assignment12.mp.main;

import java.util.ArrayList;

import kelmore5.java.dewan.Assignments.Assignment12.mp.interfaces.TableInterface;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.HASHTABLE_PATTERN) 
@Tags({"Table"})
public class TableImpl<Key, T> implements TableInterface<Key, T>{
	private ArrayList<Key> keys;
	private ArrayList<T> values;
	
	public TableImpl() {
		keys = new ArrayList<Key>();
		values = new ArrayList<T>();
	}

	@Override
	public void put(Key key, T value) {
		for(int i = 0; i < keys.size(); i++) {
			if(keys.get(i) == key) {
				values.set(i, value);
				return;
			}
		}
		
		keys.add(key);
		values.add(value);
	}

	@Override
	public T get(Key key) {
		for(int i = 0; i < keys.size(); i++) {
			if(keys.get(i) == key) {
				return values.get(i);
			}
		}
		return null;
	}
}
