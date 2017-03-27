package kelmore5.java.dewan.recitations.Recitation11.main;

public class AnAnimator implements Runnable{
	ImageShape shuttle;
    ClearanceManager sequencer;
    public AnAnimator(ImageShape theShuttle, ClearanceManager aSequencer) {
        shuttle = theShuttle;
        sequencer = aSequencer;
    }
    
    public void run() {    
        sequencer.waitForProceed();
        while(true){
        	shuttle.setX(shuttle.getX() + 1);
        	ThreadSupport.sleep(10);
        }
    }
}
