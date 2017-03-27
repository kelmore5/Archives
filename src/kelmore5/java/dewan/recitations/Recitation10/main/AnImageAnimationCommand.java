	package kelmore5.java.dewan.recitations.Recitation10.main;

public class AnImageAnimationCommand implements Runnable {
    ImageShape img;
    int displacement;
    int animationStep;
    int animationPauseTime; 
    
    public AnImageAnimationCommand (ImageShape anImg, int newDisplacement,
                                int anAnimationStep, int anAnimationPauseTime) {
    	img = anImg;
    	displacement = newDisplacement;
        animationStep = anAnimationStep;
        animationPauseTime = anAnimationPauseTime;
    }

    public void run() {
        int distance = 0;
        while(distance <= displacement){
        	img.setX(img.getX() - animationStep);
        	distance += animationStep;
        	ThreadSupport.sleep(animationPauseTime);
        }
    }

}
