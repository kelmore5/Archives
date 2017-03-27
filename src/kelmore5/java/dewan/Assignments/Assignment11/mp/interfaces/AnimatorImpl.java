package kelmore5.java.dewan.Assignments.Assignment11.mp.interfaces;

import kelmore5.java.dewan.Assignments.Assignment11.mp.drawables.Avatar;
import util.annotations.Tags;

public interface AnimatorImpl {
	@Tags({"animateAvatar"})
	public void walkingAnimation(Avatar a, int animationPauseTime, int amountX, int amountY);
}
