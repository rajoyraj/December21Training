package com.OldStyleSelectTests;

import org.testng.annotations.Test;

import com.OldStyleSelectPages.OldStyleSelectMenu;
import framework.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class OldStyleSelectTests extends TestBase {

	@Test
	public void canTestOldStyleSelectMenu() throws InterruptedException {

		OldStyleSelectMenu old = new OldStyleSelectMenu(this.getDriver()).navigate();
		old.select("Blue");
		Thread.sleep(5000);
		System.out.println(old.getSelected("Purple"));
		old.getAlloptions();
	}

	@BeforeMethod
	public void setUp() {
		super.setup();
	}

	@AfterMethod
	public void tearDown() {

	//	super.cleanup();
	}

}
