package com.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		options.setAcceptInsecureCerts(true);		
		WebDriver driver = new ChromeDriver(options);
		this.setDriver(driver);

	}

}
