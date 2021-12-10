package quintrix.Assignment;

import org.junit.Test;

public class CarTests {

	@Test
	public void canBuildCar() {

		Car myCar = new Car("corvette");
		myCar.drive(25);
		System.out.println(myCar.getOdometer());
		myCar.start();
		myCar.engine.start();

	}

}
