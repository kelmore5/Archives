package kelmore5.java.dewan.recitations.Recitation11.main;

import util.annotations.ComponentWidth;
import util.annotations.Row;

public class AClearanceManager implements ClearanceManager{
    @Row(0)
    @ComponentWidth(100)
    public synchronized void proceed() {
        notify();
    }
    @Row(1)
    @ComponentWidth(100)
    public synchronized void proceedAll() {
        notifyAll();
    }
    public synchronized void waitForProceed() {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
