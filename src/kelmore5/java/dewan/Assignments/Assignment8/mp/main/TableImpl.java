package kelmore5.java.dewan.Assignments.Assignment8.mp.main;

import java.util.ArrayList;

import kelmore5.java.dewan.Assignments.Assignment8.mp.interfaces.TableInterface;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.MAP_PATTERN) 
@Tags({"Table"})
public class TableImpl implements TableInterface {
	private ArrayList<String> keys;
	private ArrayList<Object> values;
	
	public TableImpl() {
		keys = new ArrayList<String>();
		values = new ArrayList<Object>();
	}

	@Override
	public void put(String key, Object value) {
		for(int i = 0; i < keys.size(); i++) {
			if(keys.get(i).equalsIgnoreCase(key)) {
				values.set(i, value);
				return;
			}
		}
		
		keys.add(key);
		values.add(value);
	}

	@Override
	public Object get(String key) {
		for(int i = 0; i < keys.size(); i++) {
			if(keys.get(i).equalsIgnoreCase(key)) {
				return values.get(i);
			}
		}
		return null;
	}
}
