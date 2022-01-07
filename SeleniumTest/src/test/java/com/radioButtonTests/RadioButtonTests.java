package com.radioButtonTests;

import org.testng.annotations.Test;

import com.RadioButtonPages.RadioButton;
import framework.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class RadioButtonTests extends TestBase {

	@Test
	public void canTestRadioButton() {

		RadioButton rb = new RadioButton(this.getDriver()).navigate();

		rb.select("Yes");
		System.out.println(rb.getSelected());

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
