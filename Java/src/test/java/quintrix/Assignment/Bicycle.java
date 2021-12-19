package quintrix.Assignment;

public class Bicycle extends Vehicle {
	

	private int odometer = 2000;

	public int getOdometer() {

		return this.odometer;
	}

	public void drive() {

		this.odometer++;
	}

	public void start() {

		System.out.println("I am on my bicycle");
	}

}