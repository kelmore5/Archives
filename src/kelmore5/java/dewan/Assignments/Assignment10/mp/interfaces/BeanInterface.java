package kelmore5.java.dewan.Assignments.Assignment10.mp.interfaces;

import util.annotations.Tags;

@Tags({"ScannerBean"})
public interface BeanInterface {
	public String getScannedString();
	public void setScannedString(String scannedString);
	public InputInterface[] getTokens();
}
