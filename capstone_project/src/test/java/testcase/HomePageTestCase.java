package testcase;

import java.io.IOException;
import java.time.Duration;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import common_pages.BaseClass;
import web_Pages.HomePage;
import web_Pages.LoginPage;
import web_Pages.Search;

public class HomePageTestCase extends BaseClass {
	@BeforeSuite
	public void openBrowser() throws InterruptedException {

		invokeBrowser("chrome");
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(1798.670 , 596.479)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
	}

	@Test(priority = 0)
	public void ourproduct() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		Thread.sleep(5000);
		WebElement speakerElement = homePage.speakers();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", speakerElement);
		speakerElement.click();
		Thread.sleep(5000);
		driver.navigate().back();
		homePage.tablet().click();
		Thread.sleep(5000);
		driver.navigate().back();
		homePage.laptop().click();
		Thread.sleep(5000);
		driver.navigate().back();
		homePage.mice().click();
		Thread.sleep(5000);
		driver.navigate().back();
		homePage.headphone().click();
		Thread.sleep(5000);
		driver.navigate().back();
	}

	@Test(priority = 1)
	public void specialoffer() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		Thread.sleep(5000);
		homePage.specialOffer().click();
		Thread.sleep(2000);
		//screenShot(driver);
		homePage.getseeoffer().click();
		Thread.sleep(3000);
		homePage.gethome().click();

	}

	@Test(priority = 2)
	public void popularitems() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.popularItem().click();
		Thread.sleep(2000);
		//screenShot(driver);
		homePage.getdetails().click();
		Thread.sleep(2000);
		homePage.gethome().click();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void contactus() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		Thread.sleep(3000);
		homePage.contactUs().click();
		WebElement dropElement = driver.findElement(By.name("categoryListboxContactUs"));
		Thread.sleep(2000);
		dropElement.click();
		Thread.sleep(2000);
		dropElement.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		dropElement.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		dropElement.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// WebElement dropElement2 =
		// driver.findElement(By.name("productListboxContactUs"));
		WebElement dropElement2 = driver
				.findElement(with(By.name("productListboxContactUs")).above(By.name("emailContactUs")));
		Thread.sleep(2000);
		dropElement2.click();
		Thread.sleep(2000);
		dropElement2.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		dropElement2.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		dropElement2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement emailElement2 = driver.findElement(By.name("emailContactUs"));
		Thread.sleep(2000);
		emailElement2.sendKeys("wiprosdet123@gmail.com");
		Thread.sleep(2000);
		// subjectTextareaContactUs
		WebElement subjectElement = driver.findElement(By.name("subjectTextareaContactUs"));
		subjectElement.sendKeys("hello how are you-_-!");
		Thread.sleep(2000);
		driver.findElement(By.id("send_btn")).click();
		Thread.sleep(2000);
		//screenShot(driver);
		driver.findElement(By.xpath("//a[normalize-space()='CONTINUE SHOPPING']")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void homesearch() throws InterruptedException, IOException {
		Search search = new Search(driver);
		search.getSearchButton().click();
		Thread.sleep(2000);
		search.getsearchBox().sendKeys("laptop");
		Thread.sleep(2000);
		search.getsearch().click();
		search.getsearchclose().click();
		//screenShot(driver);
		Thread.sleep(5000);
		driver.navigate().back();
	}

	@Test(priority = 5)
	public void user() throws InterruptedException, IOException {
		LoginPage login = new LoginPage(driver);
		clickElementUsingJS(login.getusermenu());
        Thread.sleep(2000);

        clickElementUsingJS(login.getnewAccount());
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        clickElementUsingJS(login.getusermenu());
        Thread.sleep(2000);

        login.userName().sendKeys("hello");
        Thread.sleep(2000);

        login.password().sendKeys("Helloworld1");
        Thread.sleep(2000);

        login.remeberme().click();
        Thread.sleep(2000);
        //screenShot(driver);
        login.signIn().click();
        Thread.sleep(2000);

        clickElementUsingJS(login.getusermenu());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[@role='link'][normalize-space()='My account']")).click();
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(2000);

        clickElementUsingJS(login.getusermenu());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[@role='link'][normalize-space()='My orders']")).click();
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        clickElementUsingJS(login.getusermenu());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[@role='link'][normalize-space()='Sign out']")).click();
        Thread.sleep(2000);
    }
    private void clickElementUsingJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
	@Test(priority = 6)
	public void helpmenu() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);

		homePage.getmenuHelp().click();
		Thread.sleep(2000);
		
		  driver.findElement(By.xpath("//label[@role='link'][normalize-space()='About']")).click(); ;
		  Thread.sleep(2000);
		  //screenShot(driver);
		 driver.navigate().back();
		Thread.sleep(3000);
	}
	@Test(priority = 7)
	public void homecart() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.getShoppingCart().click();
		Thread.sleep(2000);
		//screenShot(driver);
		driver.navigate().back();
		Thread.sleep(2000);
	}

	@AfterSuite
	public void afterTest() throws  IOException, InterruptedException {
		screenShot(driver);
		Thread.sleep(3000);
		closeDriver(driver);
	}
}
