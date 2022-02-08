package quintrix.Assignment;

import org.junit.Test;

import junit.framework.Assert;

public class CylinderCountTests {
	@Test
	public void canCountCylinders() {

		LargeEngine lEngine = new LargeEngine();
		SmallEngine SEngine = new SmallEngine();

		Assert.assertEquals(8, lEngine.getCylinderCount());
		Assert.assertEquals(4, SEngine.getCylinderCount());

	}

}