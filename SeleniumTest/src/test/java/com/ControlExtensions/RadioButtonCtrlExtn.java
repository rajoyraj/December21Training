package com.ControlExtensions;

import org.openqa.selenium.WebElement;

public class RadioButtonCtrlExtn {

	private WebElement mappedelement;

	public RadioButtonCtrlExtn(WebElement mappedelement) {

		this.mappedelement = mappedelement;
	}

	public void select() {
		this.mappedelement.click();
	}

	public String getSelected() {
		return this.mappedelement.getText();
	}

}
