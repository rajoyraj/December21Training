package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RadioButton extends PageObjectBase {

	@FindBy(how = How.ID, using = "yesRadio")
	private WebElement yesButton;

	@FindBy(how = How.ID, using = "impressiveRadio")
	private WebElement impressiveButton;
	@FindBy(how = How.ID, using = "noRadio")
	private WebElement noButton;

	public RadioButton(WebDriver driver) {
		super(driver);
	}

	public void select(String label) {
		if (label.equalsIgnoreCase("yes")) {
			this.yesButton.click();
		} else if (label.equalsIgnoreCase("impressive")) {
			this.impressiveButton.click();
		} else {
			this.noButton.click();
		}
	}

	public String getSelected() {
		if (this.yesButton.isSelected()) {
			return this.yesButton.getText();
		} else if (this.impressiveButton.isSelected()) {
			return this.impressiveButton.getText();
		} else {
			return this.noButton.getText();
		}
	}
}