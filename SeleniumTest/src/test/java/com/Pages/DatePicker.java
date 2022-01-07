package com.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DatePicker extends PageObjectBase {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	private final String url = "https://demoqa.com/date-picker";
	private final String date = "01/06/2022";

	@FindBy(how = How.ID, using = "datePickerMonthYearInput")
	private WebElement selectDate;

	@FindBy(how = How.ID, using = "dateAndTimePickerInput")
	private WebElement selectDateAndTime;

	public DatePicker(WebDriver driver) {

		super(driver);
	}

	public String getDate() {
		
		return selectDate.getAttribute("value");

	}

	public void setDate() {

		js.executeScript("document.querySelector('#datePickerMonthYearInput').setAttribute('value','01/06/2022')");
	}

	public DatePicker navigate() {

		this.driver.get(url);
		return this;

	}
}
