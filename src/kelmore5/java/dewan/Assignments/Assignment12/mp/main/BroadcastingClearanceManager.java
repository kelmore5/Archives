package kelmore5.java.dewan.Assignments.Assignment12.mp.main;

import kelmore5.java.dewan.Assignments.Assignment12.mp.interfaces.BroadcastingClearanceManagerImpl;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.NO_PATTERN) 
public class BroadcastingClearanceManager implements BroadcastingClearanceManagerImpl{

	public synchronized void proceedAll() {
		notifyAll();
	}
	
	@Override
	public synchronized void proceed() {
		notify();
	}

	@Override
	public synchronized void waitForProceed() {
		try {
			wait();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
