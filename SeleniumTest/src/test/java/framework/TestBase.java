package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {

	protected WebDriver driver;

	protected WebDriver getDriver() {
		return this.driver;
	}

	protected void setup() {
		launchChromeDriver();
	}

	protected void cleanup() {
		this.driver.quit();
	}

	private void launchChromeDriver() {
		/*
		 * Path resourceDirectory = Paths.get("src","test","resources"); String
		 * absolutePath = resourceDirectory.toFile().getAbsolutePath(); Path driverFile
		 * = Paths.get(absolutePath, "chromedriver.exe");
		 */

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");

		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();

		long pageLoadTimeout = 60;
		this.driver.manage().timeouts().implicitlyWait(pageLoadTimeout, TimeUnit.SECONDS);
	}
}