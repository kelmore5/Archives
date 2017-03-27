package kelmore5.java.dewan.Assignments.Assignment9.mp.main;

import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.Approach;
import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.Call;
import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.Define;
import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.Move;
import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.ProceedAll;
import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.Redo;
import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.Repeat;
import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.RotateLeftArm;
import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.RotateRightArm;
import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.Say;
import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.Sleep;
import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.Undo;
import kelmore5.java.dewan.Assignments.Assignment9.mp.commands.Wait;
import kelmore5.java.dewan.Assignments.Assignment9.mp.drawables.Avatar;
import kelmore5.java.dewan.Assignments.Assignment9.mp.drawables.interfaces.BridgeImpl;
import kelmore5.java.dewan.Assignments.Assignment9.mp.interfaces.BeanInterface;
import kelmore5.java.dewan.Assignments.Assignment9.mp.interfaces.CommandInterpreterImpl;
import kelmore5.java.dewan.Assignments.Assignment9.mp.interfaces.InputInterface;
import kelmore5.java.dewan.Assignments.Assignment9.mp.interfaces.TableInterface;
import kelmore5.java.dewan.Assignments.Assignment9.mp.tokens.NumberToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"CommandInterpreter"})
@PropertyNames({"Command"}) 
@EditablePropertyNames({"Command"})
@StructurePattern("Bean Pattern")
public class CommandInterpreter implements CommandInterpreterImpl{
	@Visible(false)
	private BridgeImpl bridgeScene;
	@Visible(false)
	private BeanInterface beanScanner;
	@Visible(false)
	private TableInterface avatarTable;
	public String Command;
	
	public CommandInterpreter(BridgeImpl bridgeScene, BeanInterface beanScanner) {
		super();
		this.bridgeScene = bridgeScene;
		this.beanScanner = beanScanner;
		this.Command = "";
		
		avatarTable = new TableImpl();
		avatarTable.put("arthur", bridgeScene.getArthur());
		avatarTable.put("galahad", bridgeScene.getGalahad());
		avatarTable.put("guard", bridgeScene.getGuard());
		avatarTable.put("lancelot", bridgeScene.getLancelot());
		avatarTable.put("robin", bridgeScene.getRobin());
	}

	public String getCommand() {
		return Command;
	}

	public void setCommand(String command) {
		Command = command;
		
		beanScanner.setScannedString(command);
		parseCommands(beanScanner.getTokens());
	}
	
	private void parseCommands(InputInterface[] tokens) {
		for(int i = 0; i < tokens.length; i++) {
			InputInterface command = tokens[i++];
			
			if(command instanceof Approach) {
				bridgeScene.approach(((Avatar) avatarTable.get(tokens[i++].getInput())));
			} else if(command instanceof Call) {
				
			} else if(command instanceof Define) {
				
			} else if(command instanceof Move) {
				((Avatar) avatarTable.get(tokens[i++].getInput())).move(((NumberToken) tokens[i++]).getValue(), ((NumberToken) tokens[i++]).getValue());
			} else if(command instanceof ProceedAll) {
				
			} else if(command instanceof Redo) {
				
			} else if(command instanceof Repeat) {
				
			} else if(command instanceof RotateLeftArm) {
				
			} else if(command instanceof RotateRightArm) {
				
			} else if(command instanceof Say) {
				bridgeScene.say(tokens[i++].getInput());
			} else if(command instanceof Sleep) {
				
			} else if(command instanceof Thread) {
				
			} else if(command instanceof Undo) {
				
			} else if(command instanceof Wait) {
				
			} 
		}
	}
}
