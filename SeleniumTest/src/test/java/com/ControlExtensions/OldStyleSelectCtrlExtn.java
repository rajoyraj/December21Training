package com.ControlExtensions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OldStyleSelectCtrlExtn {

	private Select oldSelect;

	public OldStyleSelectCtrlExtn(WebElement mappedelement) {

		this.oldSelect = new Select(mappedelement);
	}

	public void setValue(String text) {

		oldSelect.selectByVisibleText(text);
	}

	public String getValue(String text) {

		oldSelect.selectByVisibleText(text);

		return oldSelect.getFirstSelectedOption().getText();
	}

	public String[] getOptions() {

		List<WebElement> options = new ArrayList<WebElement>();
		options = oldSelect.getOptions();

		List<String> optn = new ArrayList<String>();

		for (WebElement element : options) {

			optn.add(element.getText());
		}

		String[] arr = new String[optn.size()];

		for (int i = 0; i < optn.size(); i++) {

			arr[i] = optn.get(i);
		}

		return arr;
	}
}
