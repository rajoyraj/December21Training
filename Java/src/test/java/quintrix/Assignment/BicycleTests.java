package quintrix.Assignment;

import org.junit.Test;

import junit.framework.Assert;

public class BicycleTests {

	@Test
	public void canRideBicycle() {

		Bicycle myBicycle = new Bicycle();
		int currentOdometer = myBicycle.getOdometer();

		myBicycle.drive();

		Assert.assertEquals(currentOdometer + 1, myBicycle.getOdometer());

	}

}