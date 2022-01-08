package com.ControlExtensions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SliderCtrlExtn {

	private WebElement mappedelement;

	private WebDriver driver;

	public SliderCtrlExtn(WebElement mappedelement, WebDriver driver) {

		this.mappedelement = mappedelement;
		this.driver = driver;
	}

	public void setAttribute(String attValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1];", this.mappedelement, attValue);
	}

	public String getAttribute() {

		return this.mappedelement.getAttribute("value");
	}

}
