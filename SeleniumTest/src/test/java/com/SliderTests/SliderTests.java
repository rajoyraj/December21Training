package com.SliderTests;

import org.testng.annotations.Test;

import com.SliderPages.Slider;

import framework.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class SliderTests extends TestBase {

	@Test
	public void canTestSlider() {

		Slider sl = new Slider(this.getDriver()).navigate();
		sl.setValue("80");
		System.out.println(sl.getValue());

		sl.setValue("17");
		System.out.println(sl.getValue());

		sl.setValue("0");
		System.out.println(sl.getValue());

		sl.setValue("100");
		System.out.println(sl.getValue());
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
