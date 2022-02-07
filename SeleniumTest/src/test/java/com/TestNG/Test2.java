package com.TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {

	@Test(groups = { "Smoke" })
	public void ploan() {
		System.out.println("good");
	}

}
