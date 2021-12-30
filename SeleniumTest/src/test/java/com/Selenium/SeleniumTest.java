package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest {

	private WebDriver driver;
	private final String url = "https://www.selenium.dev/";;

	@Test
	public void canValidateUrl() {
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(url, currenturl);
	}

	@Test
	public void canClickButton() {
		WebElement element = driver.findElement(By.cssSelector("a[href='/documentation/webdriver/']"));
		element.click();
		driver.quit();
	}

	@BeforeMethod
	public void setup() {

		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("mac")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver");

		}
		
		else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		}

		// System.setProperty("webdriver.gecko.driver",
		// System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		// System.setProperty("webdriver.edge.driver",
		// System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");

		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.navigate().to(url);
	}

	@AfterMethod
	public void tearDown() {
		this.driver.quit();
	}

}
