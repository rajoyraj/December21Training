package com.DriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class TestBase {
	DriverManager drivermanager;
	public Properties prop;

	public WebDriver getDriver() {

		return drivermanager.getDriver();
	}

	protected void setup() throws IOException {
		launchDriver();
	}

	protected void cleanup() {
		this.drivermanager.quitDriver();
	}

	protected void launchDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

		prop.load(fis);
		String browserType = prop.getProperty("BrowserType");

		this.drivermanager = DriverManagerFactory.getManager(browserType);
		this.drivermanager.createDriver();
		this.drivermanager.getDriver().manage().window().maximize();

		long pageLoadTimeout = 240;
		this.drivermanager.getDriver().manage().timeouts().implicitlyWait(pageLoadTimeout, TimeUnit.SECONDS);
	}
}