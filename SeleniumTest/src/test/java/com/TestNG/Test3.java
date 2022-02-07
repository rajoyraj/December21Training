package com.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test3 {

	@Parameters({ "URL", "username" })
	@Test
	public void WebloginCarLoan(String urlname, String key) {
		// selenium
		System.out.println("weblogincar");
		System.out.println(urlname);
		System.out.println(key);

	}

	@Test(groups = { "Smoke" })
	public void MobileLogincarLoan() {
		// Appium
		System.out.println("Mobilelogincar");
	}

	@Test
	public void MobilesignimcarLoan() {
		// Appium
		System.out.println("Mobile SIGIN");
	}

	@Test(dependsOnMethods = { "WebloginCarLoan" })
	public void APIcarLoan() {
		// Rest API automation
		System.out.println("APIlogincar");
	}

}
