package com.HyperLinkPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ControlExtensions.HyperLinkCtrlExtn;
import com.Pages.PageObjectBase;

public class HyperLink extends PageObjectBase {
	private String URL = "https://demoqa.com/links";

	@FindBy(how = How.XPATH, using = "//a[@id='created']")
	private WebElement created;
	@FindBy(how = How.XPATH, using = "//a[@id='no-content']")
	private WebElement nocontent;
	@FindBy(how = How.XPATH, using = "//a[@id='moved']")
	private WebElement moved;
	@FindBy(how = How.XPATH, using = "//a[@id='bad-request']")
	private WebElement badrequest;
	@FindBy(how = How.XPATH, using = "//a[@id='unauthorized']")
	private WebElement unauthorized;
	@FindBy(how = How.XPATH, using = "//a[@id='forbidden']")
	private WebElement forbidden;
	@FindBy(how = How.XPATH, using = "//a[@id='invalid-url']")
	private WebElement nofound;

	public HyperLink(WebDriver driver) {
		super(driver);

	}

	public HyperLink navigate() {

		this.driver.get(URL);
		return this;
	}

	public void click(String label) {
		if (label.toLowerCase().contains("create")) {
			new HyperLinkCtrlExtn(created).click();
		} else if (label.toLowerCase().contains("nocon")) {
			new HyperLinkCtrlExtn(nocontent).click();
		} else if (label.toLowerCase().contains("move")) {
			new HyperLinkCtrlExtn(moved).click();
		} else if (label.toLowerCase().contains("badreq")) {
			new HyperLinkCtrlExtn(badrequest).click();
		} else if (label.toLowerCase().contains("unauth")) {
			new HyperLinkCtrlExtn(unauthorized).click();
		} else if (label.toLowerCase().contains("forbid")) {
			new HyperLinkCtrlExtn(forbidden).click();
		} else {
			new HyperLinkCtrlExtn(nofound).click();
		}

	}

}