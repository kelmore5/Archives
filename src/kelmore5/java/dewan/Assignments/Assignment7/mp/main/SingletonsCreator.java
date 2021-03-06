package kelmore5.java.dewan.Assignments.Assignment7.mp.main;

import kelmore5.java.dewan.Assignments.Assignment7.mp.commands.Bean;
import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.Bridge;
import kelmore5.java.dewan.Assignments.Assignment7.mp.drawables.interfaces.BridgeImpl;
import kelmore5.java.dewan.Assignments.Assignment7.mp.interfaces.BeanInterface;
import kelmore5.java.dewan.Assignments.Assignment7.mp.interfaces.CommandInterpreterImpl;
import kelmore5.java.dewan.Assignments.Assignment7.mp.interfaces.TableInterface;
import util.annotations.Tags;

@Tags({"SingletonsCreator"})
public class SingletonsCreator {
	static BeanInterface scanner;
	static BridgeImpl bridge;
	static TableInterface avatarTable;
	static CommandInterpreterImpl commandInterpreter;

	@Tags({"scannerFactoryMethod"}) 
	public static BeanInterface getOrCreateScannerBean() { 
		if (scanner == null) { 
			scanner = new Bean(); 
		}  
		
		return scanner;   
	}
	
	@Tags({"bridgeSceneFactoryMethod"}) 
	public static BridgeImpl getOrCreateBridge() { 
		if (bridge == null) { 
			bridge = new Bridge(); 
		}  
		
		return bridge;   
	}
	
	@Tags({"avatarTableFactoryMethod"}) 
	public static TableInterface getOrCreateAvatarTable() { 
		if (avatarTable == null) { 
			avatarTable = new TableImpl(); 
			
			bridge = getOrCreateBridge();
			
			avatarTable.put("arthur", bridge.getArthur());
			avatarTable.put("galahad", bridge.getGalahad());
			avatarTable.put("guard", bridge.getGuard());
			avatarTable.put("lancelot", bridge.getLancelot());
			avatarTable.put("robin", bridge.getRobin());
		}  
		
		return avatarTable;   
	}
	
	@Tags({"commandInterpreterFactoryMethod"}) 
	public static CommandInterpreterImpl getOrCreateCommandInterpreter() { 
		if (commandInterpreter == null) { 
			commandInterpreter = new CommandInterpreter(getOrCreateBridge(), getOrCreateScannerBean()); 
		}  
		
		return commandInterpreter;   
	}
	
}
