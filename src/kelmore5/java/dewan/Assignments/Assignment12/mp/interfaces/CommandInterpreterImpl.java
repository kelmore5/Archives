package kelmore5.java.dewan.Assignments.Assignment12.mp.interfaces;

import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

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
	
	@Tags({"waitingArthur"})
	public void waitingArthur();
	
	@Tags({"waitingGalahad"})
	public void waitingGalahad();
	
	@Tags({"waitingLancelot"})
	public void waitingLancelot();
	
	@Tags({"waitingRobin"})
	public void waitingRobin();
	
	@Tags({"startAnimation"})
	public void proceedAllAnimations();
}
