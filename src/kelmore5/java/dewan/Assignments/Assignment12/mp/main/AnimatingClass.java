package kelmore5.java.dewan.Assignments.Assignment12.mp.main;

import kelmore5.java.dewan.Assignments.Assignment12.mp.drawables.Avatar;
import kelmore5.java.dewan.Assignments.Assignment12.mp.interfaces.BroadcastingClearanceManagerImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"animator", "avatar", "animationPauseTime", "x", "y", "manager"})
@Tags({"AnimatingCommand"})
public class AnimatingClass implements Runnable{
	public Animator animator;
	public Avatar avatar;
	public int animationPauseTime, x, y;
	public BroadcastingClearanceManagerImpl manager;

	public AnimatingClass(BroadcastingClearanceManagerImpl manager, Animator animator, Avatar avatar, int animationPauseTime, int x, int y) {
		super();
		this.animator = animator;
		this.avatar = avatar;
		this.animationPauseTime = animationPauseTime;
		this.x = x;
		this.y = y;
		this.manager = manager;
	}

	@Override
	public void run() {
		manager.waitForProceed();
		animator.walkingAnimation(this.avatar, animationPauseTime, this.x, this.y);
	}
}
