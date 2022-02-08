package NestedIframesPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Pages.PageObjectBase;

public class NestedIframes extends PageObjectBase {
	private static final String URL = "https://demoqa.com/nestedframes";
	@FindBy(how=How.ID,using="frame1")
	WebElement ParentFrame;
	@FindBy(how=How.XPATH,using="//iframe[@srcdoc='<p>Child Iframe</p>']")
	WebElement ChildFrame;
	
	

	public NestedIframes(WebDriver driver) {
		super(driver);
	}
	public NestedIframes navigate() {
		
		this.driver.get(URL);
		return this;
	}
	public String getText() {
		
		driver.switchTo().frame(ParentFrame);
		driver.switchTo().frame(ChildFrame);
		
		return driver.findElement(By.xpath("/html/body/p")).getText();
	}
}
