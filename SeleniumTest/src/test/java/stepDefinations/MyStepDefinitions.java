package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import framework.ContactUsPage;
import framework.HomePage;
import framework.TestBase;

import org.openqa.selenium.By;
import org.testng.Assert;

public class MyStepDefinitions extends TestBase {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = this.getDriver();
	}

	@When("^Navigate to HomePage$")
	public void navigate_to_homepage() throws Throwable {
		new HomePage(this.getDriver()).navigate();
	}

	@Then("^Verify that user has succefully done that $")
	public void verify_that_user_has_succefully_done_that() throws Throwable {
		Assert.assertEquals("Y", driver.findElement(By.cssSelector("p[class='alert alert-success']")).getText());
	}

	@And("^Click on Contact Us link in home page to land on contact us Page$")
	public void click_on_contact_us_link_in_home_page_to_land_on_contact_us_page() throws Throwable {
		new HomePage(this.getDriver()).navigate().clickContactUs();
	}

	@And("^User enters selects subject heading, enter emailAddress,enter order reference number,enter message and click on send us button$")
	public void user_enters_selects_subject_heading_enter_emailaddressenter_order_reference_numberenter_message_and_click_on_send_us_button()
			throws Throwable {
		new ContactUsPage(this.getDriver()).selectSubjectheading().enterEmailAddress(null).enterOrderreference(null)
				.enterMessage(null).clickSendButton();
	}

	@And("^close browsers$")
	public void close_browsers() throws Throwable {
		super.cleanup();
	}

}