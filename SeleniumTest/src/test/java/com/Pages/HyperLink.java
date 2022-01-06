package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HyperLink {

	private WebDriver driver;

	@FindBy(how = How.ID, using = "created")
	private WebElement created;
	@FindBy(how = How.ID, using = "no-content")
	private WebElement noContent;
	@FindBy(how = How.ID, using = "moved")
	private WebElement moved;
	@FindBy(how = How.ID, using = "bad-request")
	private WebElement badrequest;
	@FindBy(how = How.ID, using = "unauthorized")
	private WebElement unauthorized;
	@FindBy(how = How.ID, using = "forbidden")
	private WebElement forbidden;

	@FindBy(how = How.ID, using = "invalid-url")
	private WebElement nofound;

	public HyperLink(WebDriver driver) {
		this.driver = driver;
	}

	public void click(String string) {
	
	}

}