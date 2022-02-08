package quintrix.Assignment;

public class LargeEngine implements IEngine {

	int cylinderCount = 8;

	public void start() {

		System.out.println(" Large Engine Started");

	}

	public int getCylinderCount() {
		
		return this.cylinderCount;
	}

}
