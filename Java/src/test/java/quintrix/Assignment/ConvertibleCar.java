package quintrix.Assignment;

public class ConvertibleCar extends Car {

	private String topStatus;
	public String model;

	public ConvertibleCar(String model) {

		super(model);
		this.model = model;

	}

	public void lowerTop() {

		this.topStatus = "Down";
	}

	public void raiseTop() {
		this.topStatus = "Up";
	}

	public String geTopStatus() {
		return this.topStatus;
	}

}
