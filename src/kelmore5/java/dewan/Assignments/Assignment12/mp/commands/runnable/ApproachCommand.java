package kelmore5.java.dewan.Assignments.Assignment12.mp.commands.runnable;

import kelmore5.java.dewan.Assignments.Assignment12.mp.drawables.Avatar;
import kelmore5.java.dewan.Assignments.Assignment12.mp.drawables.interfaces.BridgeImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;

@PropertyNames({"avatar", "bridge"}) 
@StructurePattern("Bean Pattern")
@Tags({"ApproachCommand"})
public class ApproachCommand extends Command implements Runnable {
	private Avatar avatar;
	private BridgeImpl bridge;
	
	public ApproachCommand(BridgeImpl bridge, Avatar avatar) {
		super();
		this.avatar = avatar;
		this.bridge = bridge;
	}

	@Override
	public void run() {
		this.bridge.approach(avatar);
	}

}
