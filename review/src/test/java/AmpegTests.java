import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AmpegTests {
	private WebDriver driver;

	@Test
	public void canGetArtistName() {

		String artistName = "Bootsy Collins";

		String actualArtistName = new HomePage(this.driver)
				.navigate()
				.clickProductLink()
				.clickOnClassicSeries()
				.clickSvt810e()
				.getArtistName();

		Assert.assertEquals(actualArtistName, artistName, "The names do not match");

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajoy\\Downloads\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		this.driver.quit();
	}
}
