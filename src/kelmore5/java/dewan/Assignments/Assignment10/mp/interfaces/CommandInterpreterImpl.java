package kelmore5.java.dewan.Assignments.Assignment10.mp.interfaces;

import kelmore5.java.dewan.Assignments.Assignment10.mp.commands.runnable.MoveCommand;
import kelmore5.java.dewan.Assignments.Assignment10.mp.commands.runnable.SayCommand;
import kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.Avatar;
import util.annotations.Tags;

public interface CommandInterpreterImpl {
	public String getCommand();

	public void setCommand(String command);
	
	@Tags({"parseSay"})
	public SayCommand parseSay(String utterance);
	
	@Tags({"parseMove"})
	public MoveCommand parseMove(Avatar a, int x, int y);
	
	@Tags({"asynchronousArthur"})
	public void animateArthur();
	
	@Tags({"asynchronousGalahad"})
	public void animateGalahad();
	
	@Tags({"asynchronousLancelot"})
	public void animateLancelot();
	
	@Tags({"asynchronousRobin"})
	public void animateRobin();
}
