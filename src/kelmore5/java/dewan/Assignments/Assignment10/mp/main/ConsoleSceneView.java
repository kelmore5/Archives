package kelmore5.java.dewan.Assignments.Assignment10.mp.main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import kelmore5.java.dewan.Assignments.Assignment10.mp.drawables.interfaces.BridgeImpl;
import util.annotations.Tags;

@Tags("ConsoleSceneView")
public class ConsoleSceneView implements PropertyChangeListener {
	
	public ConsoleSceneView() {
		this(SingletonsCreator.getOrCreateBridge());
	}
	
	public ConsoleSceneView(BridgeImpl bridge) {
		bridge.addPropertyChangeListener(this);
		bridge.getArthur().addPropertyChangeListener(this);
		bridge.getBridge().addPropertyChangeListener(this);
		bridge.getGalahad().addPropertyChangeListener(this);
		bridge.getGorge().addPropertyChangeListener(this);
		bridge.getGuard().addPropertyChangeListener(this);
		bridge.getGuardArea().addPropertyChangeListener(this);
		bridge.getKnightArea().addPropertyChangeListener(this);
		bridge.getLancelot().addPropertyChangeListener(this);
		bridge.getRobin().addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);
	}
}
