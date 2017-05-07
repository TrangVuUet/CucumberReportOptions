package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class HomepageDef {

	WebDriver driver = null;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "E:/Geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Given("^I access to the Toolqa Demo Homepage$")
	public void i_access_to_the_Toolqa_Demo_Homepage() throws Throwable {
		driver.get("http://store.demoqa.com/");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^I should see the Logo icon and My account icon$")
	public void i_should_see_the_Logo_icon_and_My_account_icon() throws Throwable {

		// Locate Logo icon
		if (driver.findElement(By.id("logo")).isDisplayed()) {
			Assert.assertTrue("Logo is dislayed", true);
		} else {
			Assert.assertFalse("Can not find the Logo", true);
		}

		// Locate the My account icon
		if (driver.findElement(By.id("account")).isDisplayed()) {
			Assert.assertTrue("My account icon is dislayed", true);
		} else {
			Assert.assertFalse("Can not find the My account icon", true);
		}
	}

	@Then("^I should see main Menu$")
	public void i_should_see_main_Menu() throws Throwable {

		// Locate the main Menu icon
		if (driver.findElement(By.id("main-nav")).isDisplayed()) {
			Assert.assertTrue("Main menu icon is dislayed", true);
		} else {
			Assert.assertFalse("Can not find the Main menu icon", true);
		}
	}

	@When("^I have already Login$")
	public void i_have_already_Login() throws Throwable {

		// Input username and password
		driver.findElement(By.cssSelector("#account>a[href='http://store.demoqa.com/products-page/your-account/']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#log[tabindex='1']")).sendKeys("TrangVu");
		driver.findElement(By.cssSelector("input[tabindex='2'][name='pwd']")).sendKeys("11111111");
		driver.findElement(By.id("login")).click();
		Thread.sleep(10000);
	}

	@Then("^I should see Log out link and Site Admin link$")
	public void i_should_see_Log_out_link_and_Site_Admin_link() throws Throwable {

		// Locate Site Admin link
		if (driver.findElement(By.xpath("//*[@id='meta']/ul/li[1]/a")).isDisplayed()
				&& driver.findElement(By.xpath("//*[@id='meta']/ul/li[2]/a")).isDisplayed()) {
			Assert.assertTrue("Site Admin and Logout link is dislayed", true);
		} else {
			Assert.assertFalse("Can not fine Site Admin and Logout link", true);
		}
	}

	@After
	public void cleanUp() {
		driver.quit();
	}

}
