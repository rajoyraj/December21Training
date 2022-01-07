package com.ControlExtensions;

import java.util.ArrayList;
import java.util.Iterator;
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

	public void getOptions() {
		Select oldSelect = new Select(mappedelement);

		List<WebElement> options = new ArrayList<WebElement>();
		options = oldSelect.getOptions();

		Iterator<WebElement> it = options.iterator();

		while (it.hasNext()) {

			System.out.println(it.next().getText());
		}

	}
}
