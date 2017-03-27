package kelmore5.java.dewan.Assignments.Assignment11.mp.main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.Avatar;
import kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.interfaces.BridgeImpl;
import kelmore5.java.dewan.Assignments.Assignment11.mp.interfaces.BeanInterface;
import kelmore5.java.dewan.Assignments.Assignment11.mp.interfaces.CommandInterpreterImpl;
import kelmore5.java.dewan.Assignments.Assignment11.mp.interfaces.PropertyListenerSupport;
import kelmore5.java.dewan.Assignments.Assignment11.mp.interfaces.TableInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.ObserverRegisterer;
import util.annotations.ObserverTypes;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"CommandInterpreter"})
@PropertyNames({"Command"}) 
@EditablePropertyNames({"Command"})
@StructurePattern("Bean Pattern")
public class CommandInterpreter implements CommandInterpreterImpl{
	private PropertyListenerSupport propertyListenerSupport = new APropertyListenerSupport();
	@Visible(false)
	private BridgeImpl bridgeScene;
	@Visible(false)
	private TableInterface avatarTable;
	@Visible(false)
	private Parser parser;
	@Visible(false)
	private TableImpl animators;
	public String Command;
	
	public CommandInterpreter(BridgeImpl bridgeScene, BeanInterface beanScanner) {
		super();
		this.bridgeScene = bridgeScene;
		this.parser = new Parser(this.bridgeScene);
		this.Command = "";
		animators = new TableImpl();
		
		avatarTable = new TableImpl();
		avatarTable.put("arthur", bridgeScene.getArthur());
		avatarTable.put("galahad", bridgeScene.getGalahad());
		avatarTable.put("guard", bridgeScene.getGuard());
		avatarTable.put("lancelot", bridgeScene.getLancelot());
		avatarTable.put("robin", bridgeScene.getRobin());
		
		animators.put("arthur", new Animator());
		animators.put("galahad", new Animator());
		animators.put("lancelot", new Animator());
		animators.put("robin", new Animator());
	}

	public String getCommand() {
		return Command;
	}

	public void setCommand(String command) {
		String oldCommand = this.Command;
		Command = command;
		
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Command", oldCommand, this.Command));
		}
		
		parser.setCommandText(command);
	}
	
	@Tags({"asynchronousArthur"})
	public void animateArthur() {
		Avatar avatar = bridgeScene.currentKnight2("arthur");
		Thread thread = new Thread(new AnimatingClass((Animator) animators.get("arthur"), avatar, 50, 100, 150));
		thread.start();
	} 
	
	@Tags({"asynchronousGalahad"})
	public void animateGalahad() {
		Avatar avatar = bridgeScene.currentKnight2("galahad");
		Thread thread = new Thread(new AnimatingClass((Animator) animators.get("galahad"), avatar, 50, 200, 75));
		thread.start();
	}
	
	@Tags({"asynchronousLancelot"})
	public void animateLancelot() {
		Avatar avatar = bridgeScene.currentKnight2("lancelot");
		Thread thread = new Thread(new AnimatingClass((Animator) animators.get("lancelot"), avatar, 50, 300, 300));
		thread.start();
	}
	
	@Tags({"asynchronousRobin"})
	public void animateRobin() {
		Avatar avatar = bridgeScene.currentKnight2("robin");
		Thread thread = new Thread(new AnimatingClass((Animator) animators.get("robin"), avatar, 50, 150, -100));
		thread.start();
	}
	
	@Override
	@ObserverRegisterer(ObserverTypes.PROPERTY_LISTENER)
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyListenerSupport.addElement(listener);
	}
}
