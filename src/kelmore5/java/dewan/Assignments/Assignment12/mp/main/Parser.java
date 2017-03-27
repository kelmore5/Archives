package kelmore5.java.dewan.Assignments.Assignment12.mp.main;


import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Approach;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Bean;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Call;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Define;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Fail;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Move;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Pass;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.ProceedAll;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Redo;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Repeat;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.RotateLeftArm;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.RotateRightArm;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Say;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Sleep;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Undo;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.Wait;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.list.CommandList;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.list.RepeatCommand;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.runnable.ApproachCommand;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.runnable.Command;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.runnable.FailCommand;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.runnable.MoveCommand;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.runnable.PassCommand;
import kelmore5.java.dewan.Assignments.Assignment12.mp.commands.runnable.SayCommand;
import kelmore5.java.dewan.Assignments.Assignment12.mp.drawables.Avatar;
import kelmore5.java.dewan.Assignments.Assignment12.mp.drawables.interfaces.BridgeImpl;
import kelmore5.java.dewan.Assignments.Assignment12.mp.interfaces.InputInterface;
import kelmore5.java.dewan.Assignments.Assignment12.mp.interfaces.ParserImpl;
import kelmore5.java.dewan.Assignments.Assignment12.mp.tokens.EndToken;
import kelmore5.java.dewan.Assignments.Assignment12.mp.tokens.NumberToken;
import kelmore5.java.dewan.Assignments.Assignment12.mp.tokens.StartToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;

@PropertyNames({"CommandObject", "CommandText"}) 
@EditablePropertyNames({"CommandText"})
@StructurePattern("Bean Pattern")
public class Parser implements ParserImpl {
	private BridgeImpl bridgeScene;
	private Bean beanScanner;
	private TableImpl<String, Avatar> avatars;
	private InputInterface[] tokens;
	public Command CommandObject;
	private int index;
	public String CommandText;
	
	public Parser(BridgeImpl bridge) {
		super();
		this.bridgeScene = bridge;
		this.beanScanner = new Bean();
		
		tokens = new InputInterface[10];
		this.reset();
		
		avatars = new TableImpl<String, Avatar>();
		avatars.put("arthur", bridge.getArthur());
		avatars.put("galahad", bridge.getGalahad());
		avatars.put("lancelot", bridge.getLancelot());
		avatars.put("robin", bridge.getRobin());
		avatars.put("guard", bridge.getGuard());
	}
	
	public String getCommandText() {
		return CommandText;
	}
	
	public void setCommandText(String command) {
		this.CommandText = command;
		
		this.reset();
		beanScanner.setScannedString(this.CommandText);
		tokens = beanScanner.getTokens();
		CommandObject = parseCommand();
		System.out.println(CommandObject.getClass().getName());
		CommandObject.run();
	}
	
	public Command getCommandObject() {
		return CommandObject;
	}
	
	@Tags({"parseCommand"})
	public Command parseCommand() {
		while(this.hasNext()) {
			InputInterface command = this.next();
			
			if(command instanceof Approach) {
				return parseApproach(bridgeScene.currentKnight2(this.next().getInput()));
			} else if(command instanceof Call) {
				
			} else if(command instanceof Define) {
				
			} else if(command instanceof Move) {
				String input = this.next().getInput();
				int x = ((NumberToken) this.next()).getValue();
				int y = ((NumberToken) this.next()).getValue();
				return parseMove(this.bridgeScene.currentKnight2(input), x, y);
			} else if(command instanceof ProceedAll) {
				
			} else if(command instanceof Redo) {
				
			} else if(command instanceof Repeat) {
				return parseRepeat(((NumberToken) this.peek()).getValue());
			} else if(command instanceof RotateLeftArm) {
				
			} else if(command instanceof RotateRightArm) {
				
			} else if(command instanceof Say) {
				return parseSay(this.next().getInput());
			} else if(command instanceof Sleep) {
				
			} else if(command instanceof Thread) {
				
			} else if(command instanceof Undo) {
				
			} else if(command instanceof Wait) {
				
			} else if(command instanceof Pass) {
				return parsePass();
			} else if(command instanceof Fail) {
				return parseFail();
			} else if(command instanceof StartToken) {
				return parseCommandList();
			}
		}
		
		return null;
	}
	
	@Tags({"parseSay"})
	public SayCommand parseSay(String utterance) {
		return new SayCommand(this.bridgeScene, utterance);
	}
	
	@Tags({"parseFail"})
	public FailCommand parseFail() {
		return new FailCommand(this.bridgeScene);
	}
	
	@Tags({"parsePass"})
	public PassCommand parsePass() {
		return new PassCommand(this.bridgeScene);
	}
	
	@Tags({"parseMove"})
	public MoveCommand parseMove(Avatar a, int x, int y) {
		return new MoveCommand(a, x, y);
	}
	
	@Tags({"parseApproach"})
	public ApproachCommand parseApproach(Avatar a) {
		return new ApproachCommand(this.bridgeScene, a);
	}
	
	@Tags({"parseCommandList"})
	public CommandList parseCommandList() {
		CommandList cl = new CommandList();
		while(!(tokens[index] instanceof EndToken)) {
			cl.addCommand(parseCommand());
		}
		index++;
		return cl;
	}
	
	@Tags({"parseRepeat"})
	public RepeatCommand parseRepeat(int count) {
		return new RepeatCommand(parseCommand(), count);
	}

	@Override
	public InputInterface next() {
		return tokens[index++];
	}

	@Override
	public InputInterface peek() {
		return tokens[index];
	}

	@Override
	public boolean hasNext() {
		return index < tokens.length;
	}

	@Override
	public void reset() {
		this.index = 0;
	}
}