package com.HyperLinksTests;

import org.testng.annotations.Test;

import com.HyperLinkPages.HyperLink;
import com.DriverManager.TestBase;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class HyperLinkTest extends TestBase {

	@Test
	public void canTestHyperLinks() {

		HyperLink hl = new HyperLink(this.getDriver()).navigate();
		hl.click("badrequest");

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
