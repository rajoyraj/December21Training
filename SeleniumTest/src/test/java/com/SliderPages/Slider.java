package com.SliderPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ControlExtensions.SliderCtrlExtn;
import com.Pages.PageObjectBase;

public class Slider extends PageObjectBase {

	public int val;

	private final String URL = "https://demoqa.com/slider";

	@FindBy(how = How.CSS, using = "input.range-slider.range-slider--primary")
	private WebElement sliderValue;

	public Slider(WebDriver driver) {
		super(driver);
	}

	public Slider navigate() {
		this.driver.get(URL);
		return this;
	}

	public void setValue(String attValue) {

		new SliderCtrlExtn(sliderValue, this.driver).setAttribute(attValue);

	}

	public String getValue() {

		return new SliderCtrlExtn(sliderValue, this.driver).getAttribute();

	}

}
