package kelmore5.java.dewan.Assignments.Assignment11.mp.commands.list;

import java.util.ArrayList;
import java.util.List;

import kelmore5.java.dewan.Assignments.Assignment11.mp.commands.runnable.Command;
import kelmore5.java.dewan.Assignments.Assignment11.mp.interfaces.CommandListImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"commands"})
@Tags({"CommandList"})
public class CommandList extends Command implements Runnable, CommandListImpl {
	List<Runnable> commands;

	public CommandList() {
		super();
		this.commands = new ArrayList<Runnable>();
	}
	
	@Tags({"add"})
	public void addCommand(Runnable r) {
		commands.add(r);
	}

	@Override
	public void run() {
		for(Runnable r: commands) {
			r.run();
		}
	}
}
