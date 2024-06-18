package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;

import common_pages.BaseClass;
//import web_Pages.HomePage;
import web_Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;
	LoginPage lp;

	@Given("Browser is open and user is on Advantage Online Shopping home page")
	public void browser_is_open_and_user_is_on_advantage_online_shopping_home_page() throws InterruptedException {
		driver = BaseClass.invokeBrowser("chrome");
		driver.get("https://www.advantageonlineshopping.com/#/");
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		lp = new LoginPage(driver);
	}

	@Then("User click on login icon")
	public void user_click_on_login_icon() throws InterruptedException {
		driver.findElement(By.id("menuUserLink")).click();
		Thread.sleep(5000);
	}

	@When("User enters {string} and {string} and clicks on login button")
	public void user_enters_and_and_clicks_on_login_button(String username, String password) {
		lp.userName().sendKeys(username);
		lp.password().sendKeys(password);
		lp.signIn().click();
	}

	@Then("User is successfully logged in")
	public void user_is_successfully_logged_in() throws InterruptedException {
		Thread.sleep(3000);
		WebElement uname = driver.findElement(By.cssSelector(".hi-user.containMiniTitle.ng-binding"));
		if (uname.getText().length() > 0)
			System.out.println("usr logged in");
	}

	@Then("User logsout")
	public void user_logsout() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("menuUserLink")).click();
		driver.findElement(By.xpath("//label[@role='link'][normalize-space()='Sign out']")).click();
		BaseClass.closeDriver(driver);
	}

}
