package com.ControlExtensions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SliderCtrlExtn {

	private WebElement mappedelement;

	private WebDriver driver;
	
	

	public SliderCtrlExtn(WebElement mappedelement, WebDriver driver) {

		this.mappedelement = mappedelement;
		this.driver=driver;
	}

	public String getAttribute() {
		
		return this.mappedelement.getAttribute("value");
	}

	public void setAttribute(String val) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("document.getElementById('sliderValue').setAttribute('value',val)");
		
	}

}
