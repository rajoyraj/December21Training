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
		old.setValue("Blue");

		System.out.println(old.getValue("Purple") + " " + "is selected");
		String[] optns = old.getOptions();

		for (String op : optns) {

			System.out.println(op);
		}
	}

	@BeforeMethod
	public void setUp() {
		super.setup();
	}

	@AfterMethod
	public void tearDown() {

		super.cleanup();
	}

}
