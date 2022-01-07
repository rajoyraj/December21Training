package com.RadioButtonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ControlExtensions.RadioButtonCtrlExtn;
import com.Pages.PageObjectBase;

public class RadioButton extends PageObjectBase {
	private String URL = "https://demoqa.com/radio-button";
	@FindBy(how = How.XPATH, using = "//label[@for='yesRadio']")
	private WebElement yesButton;

	@FindBy(how = How.XPATH, using = "//label[@for='impressiveRadio']")
	private WebElement impressiveButton;
	@FindBy(how = How.ID, using = "//label[@for='noRadio']")
	private WebElement noButton;

	@FindBy(how = How.XPATH, using = "//p[@class='mt-3']")
	private WebElement resultText;

	public RadioButton navigate() {

		this.driver.get(URL);
		return this;
	}

	public RadioButton(WebDriver driver) {
		super(driver);
	}

	public void select(String label) {
		if (label.toLowerCase().equalsIgnoreCase("yes")) {
			new RadioButtonCtrlExtn(yesButton).select();
		} else if (label.toLowerCase().equalsIgnoreCase("impressive")) {
			new RadioButtonCtrlExtn(impressiveButton).select();
		} else {
			new RadioButtonCtrlExtn(noButton).select();
		}
	}

	public String getSelected() {
		return new RadioButtonCtrlExtn(resultText).getSelected();
	}
}