package com.TestNG;

import org.testng.annotations.Test;

public class TestPriority {
	@Test(priority = 1)
	public void CloseBrowser() {

		System.out.println("Closing Google Chrome browser");
	}

	@Test(priority = 0)
	public void OpenBrowser() {
		System.out.println("Launching Google Chrome browser");

	}

	@Test(priority = 1)
	public void AccountTest() {
		System.out.println("Some tests for Customer Account");
	}
}
