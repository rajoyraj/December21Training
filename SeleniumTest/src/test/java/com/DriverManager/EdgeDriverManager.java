package com.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class EdgeDriverManager extends DriverManager {

	public void createDriver() {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");

		EdgeOptions options = new EdgeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		WebDriver driver = new EdgeDriver(options);
		this.setDriver(driver);
	}

}
