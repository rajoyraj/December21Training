package com.TestNG;

import org.testng.annotations.Test;

public class Test5 {

	@Test
	public void WebloginCarLoan() {

		System.out.println("weblogincar" + "  " + Thread.currentThread().getId());

	}

	@Test
	public void MobileLogincarLoan() {

		System.out.println("Mobilelogincar" + "  " + Thread.currentThread().getId());
	}

	@Test
	public void MobilesignimcarLoan() {

		System.out.println("Mobile SIGIN" + "  " + Thread.currentThread().getId());
	}

	@Test
	public void APIcarLoan() {

		System.out.println("APIlogincar" + "  " + Thread.currentThread().getId());
	}

}
