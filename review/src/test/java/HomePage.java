import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {
	final String URL = "https://ampeg.com/index.html";

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage navigate() {
		getDriver().navigate().to(URL);
		return this;
	}

	public ProductsPage clickProductLink() {
		getDriver().findElement(By.cssSelector("a[title='Products']")).click();
		return new ProductsPage(getDriver());
	}
}
