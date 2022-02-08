package quintrix.Assignment;

public class SmallEngine implements IEngine {

	private int cylinderCount = 4;

	public int getCylinderCount() {
		return this.cylinderCount;
	}
	
	public void start() {
		
		System.out.println("Small engine started");
		
	}

}
