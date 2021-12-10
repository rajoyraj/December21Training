package quintrix.Assignment;

public class Car {

	String model;
	private int odometer;
	IEngine engine;

	public Car(String model) {

		LargeEngine largeEngineObject = new LargeEngine();
		engine=largeEngineObject;
		this.model = model;
	};

	public int getOdometer() {
		
		return this.odometer;
	}
	public void drive(int distance) {

		this.odometer=distance;
	}

	 public void start() {
	    	System.out.println("I have just started my car engine");
	    }
}
