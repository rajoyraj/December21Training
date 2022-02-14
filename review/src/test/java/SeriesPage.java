import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeriesPage extends PageObject {

	public SeriesPage(WebDriver driver) {
		super(driver);
	}

	public ProductDetailsPage clickSvt810e() {
		getDriver().findElement(By.cssSelector("a[href='svt810e/']>img")).click();
		return new ProductDetailsPage(getDriver());
	}

}
