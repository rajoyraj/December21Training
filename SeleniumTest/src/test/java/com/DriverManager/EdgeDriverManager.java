package com.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	public void createDriver() {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		this.setDriver(driver);
	}

}
