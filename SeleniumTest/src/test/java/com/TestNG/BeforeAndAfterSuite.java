package com.TestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAndAfterSuite {

	@BeforeSuite
	public void beforesuite() {
		System.out.println("I am the no 1 from the beginning ");
	}

	@BeforeTest
	public void firstexecution() {
		System.out.println("I will execute after beforesuite");

	}

	@AfterTest
	public void lastexecution() {
		System.out.println("I will execute before aftersuite");

	}

	@Test
	public void Demo() {
		System.out.println("hello");

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am the no 1 from last ");
	}

	@Test
	public void SecondTest() {
		System.out.println("bye");
	}

}
