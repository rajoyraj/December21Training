package com.SliderTests;

import org.testng.annotations.Test;

import com.SliderPages.Slider;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class SliderTests extends com.DriverManager.TestBase {

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
	public void setUp() throws IOException {
		super.setup();
	}

	@AfterMethod
	public void tearDown() {

		super.cleanup();
	}

}
