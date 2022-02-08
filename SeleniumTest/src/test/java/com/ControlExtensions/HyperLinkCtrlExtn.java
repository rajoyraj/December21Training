package com.ControlExtensions;

import org.openqa.selenium.WebElement;

public class HyperLinkCtrlExtn {

	private WebElement mappedelement;

	public HyperLinkCtrlExtn(WebElement mappedelement) {

		this.mappedelement = mappedelement;
	}

	public void click() {

		this.mappedelement.click();

	}

}
