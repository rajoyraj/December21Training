package quintrix.Assignment;

public class Car {

	String model;
	private int odometer = 7000;
	IEngine engine;

	public Car(String model) {

		LargeEngine largeEngineObject = new LargeEngine();
		this.engine = largeEngineObject;
		this.model = model;
	};

	public int getOdometer() {

		return this.odometer;
	}

	public void start() {

		System.out.println("I have just started my car engine");
	}
}
