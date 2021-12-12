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

}
