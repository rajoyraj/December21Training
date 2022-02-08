package com.radioButtonTests;

import org.testng.annotations.Test;

import com.RadioButtonPages.RadioButton;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class RadioButtonTests extends com.DriverManager.TestBase {

	@Test
	public void canTestRadioButton() {

		RadioButton rb = new RadioButton(this.getDriver()).navigate();

		rb.select("Yes");
		System.out.println(rb.getSelected());

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
