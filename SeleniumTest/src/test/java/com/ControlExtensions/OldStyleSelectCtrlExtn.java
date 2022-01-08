package com.ControlExtensions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OldStyleSelectCtrlExtn {

	private WebElement mappedelement;

	public OldStyleSelectCtrlExtn(WebElement mappedelement) {

		this.mappedelement = mappedelement;
	}

	public void setValue(String text) {
		Select oldSelect = new Select(mappedelement);

		oldSelect.selectByVisibleText(text);
	}

	public String getValue(String text) {
		Select oldSelect = new Select(mappedelement);

		oldSelect.selectByVisibleText(text);

		return oldSelect.getFirstSelectedOption().getText();
	}

	public String getOptions() {
		Select oldSelect = new Select(mappedelement);

		List<WebElement> options = new ArrayList<WebElement>();
		options = oldSelect.getOptions();

		List<String> optn = new ArrayList<String>();

		for (WebElement element : options) {

			optn.add(element.getText());
		}
		return optn.toString();
	}
}
