package com.XpathCss;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathandCss {

	WebDriver driver;

	@Test
	public void canFindXpath() {

		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("mac")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver");

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
		this.driver.navigate().to("https://demoqa.com/buttons");

		List<WebElement> buttons = driver.findElements(By.xpath("//button"));

	}
}
