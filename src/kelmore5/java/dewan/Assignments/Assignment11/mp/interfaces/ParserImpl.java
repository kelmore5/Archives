package kelmore5.java.dewan.Assignments.Assignment11.mp.interfaces;


import kelmore5.java.dewan.Assignments.Assignment11.mp.commands.list.CommandList;
import kelmore5.java.dewan.Assignments.Assignment11.mp.commands.list.RepeatCommand;
import kelmore5.java.dewan.Assignments.Assignment11.mp.commands.runnable.ApproachCommand;
import kelmore5.java.dewan.Assignments.Assignment11.mp.commands.runnable.Command;
import kelmore5.java.dewan.Assignments.Assignment11.mp.commands.runnable.FailCommand;
import kelmore5.java.dewan.Assignments.Assignment11.mp.commands.runnable.MoveCommand;
import kelmore5.java.dewan.Assignments.Assignment11.mp.commands.runnable.PassCommand;
import kelmore5.java.dewan.Assignments.Assignment11.mp.commands.runnable.SayCommand;
import kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.Avatar;
import util.annotations.Tags;

public interface ParserImpl {
	public String getCommandText();
	
	public void setCommandText(String command);
	
	public Command getCommandObject();
	
	@Tags({"parseCommand"})
	public Command parseCommand();
	
	@Tags({"parseSay"})
	public SayCommand parseSay(String utterance);
	
	@Tags({"parseFail"})
	public FailCommand parseFail();
	
	@Tags({"parseSay"})
	public PassCommand parsePass();
	
	@Tags({"parseMove"})
	public MoveCommand parseMove(Avatar a, int x, int y);
	
	@Tags({"parseApproach"})
	public ApproachCommand parseApproach(Avatar a);
	
	@Tags({"parseCommandList"})
	public CommandList parseCommandList();
	
	@Tags({"parseRepeat"})
	public RepeatCommand parseRepeat(int count);
	public InputInterface next();
	public InputInterface peek();
	public boolean hasNext();
	public void reset();
}
