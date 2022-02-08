package quintrix.Assignment;

import org.junit.Test;

import junit.framework.Assert;

public class ConvertibleCarTests {

	@Test
	public void canBuildConvertibleCar() {

		ConvertibleCar conCar = new ConvertibleCar("Toyota");
		
		conCar.engine.start();

		Assert.assertNotNull(conCar);

	}

	@Test
	public void canRaiseTop() {

		ConvertibleCar conCar = new ConvertibleCar("Toyota");

		conCar.raiseTop();

		Assert.assertEquals("Up", conCar.geTopStatus());

	}

	@Test
	public void canLowerTop() {

		ConvertibleCar conCar = new ConvertibleCar("Toyota");

		conCar.lowerTop();
		;

		Assert.assertEquals("Down", conCar.geTopStatus());

	}

}