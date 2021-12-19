package quintrix.Assignment;

import org.junit.Test;

import junit.framework.Assert;

public class CarTests {

	@Test
	public void canBuildCar() {

		Car myCar = new Car("corvette");
		int expectedOdometer = 7000;
		int currentOdometer = myCar.getOdometer();
		myCar.start();
		Assert.assertEquals(expectedOdometer, currentOdometer);

	}

	@Test
	public void canTrackMileage() {

		Car myCar = new Car("Toyota");
		int currentOdometer = myCar.getOdometer();

		myCar.drive();

		Assert.assertEquals(currentOdometer + 1, myCar.getOdometer());

	}

}
