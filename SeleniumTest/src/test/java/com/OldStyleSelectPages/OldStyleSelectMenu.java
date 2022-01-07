package com.OldStyleSelectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ControlExtensions.OldStyleSelectCtrlExtn;
import com.Pages.PageObjectBase;

public class OldStyleSelectMenu extends PageObjectBase {

	private static final String URL = "https://demoqa.com/select-menu";
	@FindBy(how = How.ID, using = "oldSelectMenu")
	public WebElement oldStyleSelectMenu;

	public OldStyleSelectMenu(WebDriver driver) {
		super(driver);
	}

	public OldStyleSelectMenu navigate() {

		this.driver.get(URL);
		return this;
	}

	public String getSelected(String text) {

		return new OldStyleSelectCtrlExtn(oldStyleSelectMenu).getValue(text);
	}

	public OldStyleSelectMenu select(String text) {

		new OldStyleSelectCtrlExtn(oldStyleSelectMenu).setValue(text);
		return this;
	}
	
	public void getAlloptions() {
		
		new OldStyleSelectCtrlExtn(oldStyleSelectMenu).getOptions();
	}

}
