package kelmore5.java.dewan.Assignments.Assignment11.mp.commands.runnable;

import kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.interfaces.BridgeImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;

@PropertyNames({"bridge"}) 
@StructurePattern("Bean Pattern")
@Tags({"FailCommand"})
public class FailCommand extends Command implements Runnable {
	private BridgeImpl bridge;
	
	public FailCommand(BridgeImpl bridge) {
		super();
		this.bridge = bridge;
	}

	@Override
	public void run() {
		this.bridge.failed();
	}

}

