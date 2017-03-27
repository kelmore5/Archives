package kelmore5.java.dewan.Assignments.Assignment11.mp.interfaces;

import util.models.PropertyListenerRegisterer;
import kelmore5.java.dewan.Assignments.Assignment11.mp.commands.runnable.MoveCommand;
import kelmore5.java.dewan.Assignments.Assignment11.mp.commands.runnable.SayCommand;
import kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.Avatar;
import util.annotations.Tags;

public interface CommandInterpreterImpl extends PropertyListenerRegisterer {
	public String getCommand();

	public void setCommand(String command);
	
	@Tags({"asynchronousArthur"})
	public void animateArthur();
	
	@Tags({"asynchronousGalahad"})
	public void animateGalahad();
	
	@Tags({"asynchronousLancelot"})
	public void animateLancelot();
	
	@Tags({"asynchronousRobin"})
	public void animateRobin();
}
