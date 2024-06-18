package testcase;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import common_pages.BaseClass;
import common_pages.ExtentReportsClass;
import web_Pages.LoginPage;
import web_Pages.MyAccount;

public class MyAccountTest {

	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	LoginPage lp;
	MyAccount ma;
	Properties prop;

	@BeforeTest
	public void setup() throws IOException, InterruptedException {
		driver = BaseClass.invokeBrowser("chrome");
		driver.get("https://www.advantageonlineshopping.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		File f = new File("./src/test/java/credentials/update_details.properties");
		String path = f.getAbsolutePath();
		FileInputStream fis = new FileInputStream(path);
		prop = new Properties();
		prop.load(fis);

		lp = new LoginPage(driver);
		ma = new MyAccount(driver);
		Thread.sleep(10000);
		ma.getLoginIcon().click();
		Thread.sleep(3000);
		lp.userName().sendKeys(prop.getProperty("username"));
		lp.password().sendKeys(prop.getProperty("password"));
		lp.signIn().click();
		Thread.sleep(10000);
	}

	@BeforeMethod
	public void beforeMethod() {
		extent =  ExtentReportsClass.getInstance();
	}

	@Test(priority = 1)
	public void testUpdateAccountDetails() throws InterruptedException {
		test =  ExtentReportsClass.createTest("Test update account details.");
		test.assignAuthor("Naqeeb");
		test.info("Checking if user account details is updated or not.");

		try {

			ma.getLoginIcon().click();
			ma.gotoMyAccount().click();
			Thread.sleep(3000);
			ma.getEditDetailsLink().click();
			Thread.sleep(3000);

			ma.getFirstName().clear();
			ma.getFirstName().sendKeys(prop.getProperty("firstName"));
			ma.getLastName().clear();
			ma.getLastName().sendKeys(prop.getProperty("lastName"));
			ma.getPhoneNumber().clear();
			ma.getPhoneNumber().sendKeys(prop.getProperty("phone"));

			Select dropCountry = new Select(ma.getCountry());
			dropCountry.selectByVisibleText(prop.getProperty("country"));

			ma.getCity().clear();
			ma.getCity().sendKeys(prop.getProperty("city"));
			ma.getAddress().clear();
			ma.getAddress().sendKeys(prop.getProperty("address"));
			ma.getState().clear();
			ma.getState().sendKeys(prop.getProperty("state"));
			ma.getPostalCode().clear();
			ma.getPostalCode().sendKeys(prop.getProperty("postalcode"));

			ma.getsaveButton().click();

			Thread.sleep(5000);
			List<WebElement> ls = driver.findElements(By.cssSelector("label.ng-binding"));
			System.out.println(ls.size());
			if (ls.size() >= 1) {
				String path = BaseClass.ScreenShot();
				test.pass("User details updated successfully");
				test.addScreenCaptureFromPath(path);
			} else {
				String path = BaseClass.ScreenShot();
				test.fail("User details not updated");
				test.addScreenCaptureFromPath(path);
			}
		} catch (Exception e) {
			test.fail(e.toString());
			e.printStackTrace();
		}
	}

	@Test(priority = 2, enabled = true)
	public void testUpdateMasterCardDetails() throws InterruptedException {
		test =  ExtentReportsClass.createTest("Test update master card details.");
		test.assignAuthor("Naqeeb");
		test.info("Updating payment options to use master card.");

		try {
			ma = new MyAccount(driver);
			ma.getpaymentprefference().click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(ma.getmasterCard()));

			ma.getmasterCard().click();
			ma.getmasterCardnumber().clear();
			ma.getmasterCardnumber().sendKeys(prop.getProperty("cardNumber"));
			ma.getmasterCardpin().clear();
			ma.getmasterCardpin().sendKeys(prop.getProperty("cvv"));
			System.out.println(prop.getProperty("cvv"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)", "");

			Select dropMonth = new Select(ma.getmasterCardmonth());
			dropMonth.selectByVisibleText(prop.getProperty("month"));

			Select dropYear = new Select(ma.getmasterCardyear());
			dropYear.selectByVisibleText(prop.getProperty("year"));

			ma.getmasterCardname().clear();
			ma.getmasterCardname().sendKeys(prop.getProperty("cardHolderName"));

			if (!ma.getmasterCardcheckbox().isSelected())
				ma.getmasterCardcheckbox().click();

			Thread.sleep(5000);
			js.executeScript("window.scrollBy(0, 20)", "");
//			wait.until(ExpectedConditions.elementToBeClickable(ma.getsaveButton()));
//			Actions act = new Actions(driver);
//			act.moveToElement(ma.getsaveButton()).click();
			ma.getsaveButton().click();

			Thread.sleep(10000);
			if (driver.getCurrentUrl().contains("https://www.advantageonlineshopping.com/#/myAccount")) {
				js.executeScript("window.scrollBy(0, 450)", "");
				test.pass("payment option mastercard updated successfully");
				String path = BaseClass.ScreenShot();
				test.addScreenCaptureFromPath(path);
			} else {
				test.fail("failed to update mastercard payment option");
				String path = BaseClass.ScreenShot();
				test.addScreenCaptureFromPath(path);
			}
		} catch (Exception e) {
			test.fail(e.toString());
			e.printStackTrace();
		}
	}

	@Test(priority = 3, enabled = true)
	public void testUpdateSafePayDetails() throws InterruptedException {
		test = ExtentReportsClass.createTest("Test update safepay details.");
		test.assignAuthor("Naqeeb");
		test.info("Updating payment options to use safepay.");

		try {
			driver.get("https://www.advantageonlineshopping.com/#/myAccount");
			ma = new MyAccount(driver);
			ma.getpaymentprefference().click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(ma.getSafepay()));

			ma.getSafepay().click();
			ma.getSafepayUsername().clear();
			ma.getSafepayUsername().sendKeys(prop.getProperty("safePayUser"));
			ma.getSafepayPassword().clear();
			ma.getSafepayPassword().sendKeys(prop.getProperty("safePayPwd"));

			JavascriptExecutor js = (JavascriptExecutor) driver;

			if (!ma.getSafepayCheckbox().isSelected())
				ma.getSafepayCheckbox().click();

			Thread.sleep(5000);
			ma.getsaveButton().click();

			Thread.sleep(10000);
			if (driver.getCurrentUrl().contains("https://www.advantageonlineshopping.com/#/myAccount")) {
				js.executeScript("window.scrollBy(0, 450)", "");
				test.pass("payment option safepay updated successfully");
				Thread.sleep(3000);
				String path = BaseClass.ScreenShot();
				test.addScreenCaptureFromPath(path);
			} else {
				test.fail("failed to update safepay payment option");
				String path = BaseClass.ScreenShot();
				test.addScreenCaptureFromPath(path);
			}

		} catch (Exception e) {
			test.fail(e.toString());
			e.printStackTrace();
		}
	}

	@Test(priority = 8, enabled = false)
	public void testDeleteAccountConfirm() {
		test =  ExtentReportsClass.createTest("Test deletetion of user account.");
		test.assignAuthor("Naqeeb");
		test.info("Trying to delete user account.");

		try {
			driver.get("https://www.advantageonlineshopping.com/#/myAccount");
			ma = new MyAccount(driver);
			ma.getdeleteAccountButton().click();
			Thread.sleep(3000);
			ma.getConfirmDeleteAccount().click();
			if (driver.getCurrentUrl().contains("https://www.advantageonlineshopping.com/#/")) {
				test.pass("Account deleted successfully");
				Thread.sleep(3000);
				String path = BaseClass.ScreenShot();
				test.addScreenCaptureFromPath(path);
			} else {
				test.fail("failed to delete account");
				String path = BaseClass.ScreenShot();
				test.addScreenCaptureFromPath(path);
			}
		} catch (Exception e) {
			test.fail(e.toString());
			e.printStackTrace();
		}

	}

	@Test(priority = 7, enabled = true)
	public void testDeleteAccountCancel() {
		test =  ExtentReportsClass.createTest("Test deletetion of user account and user cancel the operation.");
		test.assignAuthor("Naqeeb");
		test.info("User try to delete account then cancel the operation.");

		try {
			driver.get("https://www.advantageonlineshopping.com/#/myAccount");
			ma = new MyAccount(driver);
			ma.getdeleteAccountButton().click();
			Thread.sleep(5000);
			Actions act = new Actions(driver);
			act.moveToElement(ma.getCancelDeleteAccount(), 100, 0).click().perform();

			if (driver.getCurrentUrl().contains("https://www.advantageonlineshopping.com/#/myAccount")) {
				test.pass("Account deleted successfully");
				Thread.sleep(3000);
				String path = BaseClass.ScreenShot();
				test.addScreenCaptureFromPath(path);
			} else {
				test.fail("failed to delete account");
				String path = BaseClass.ScreenShot();
				test.addScreenCaptureFromPath(path);
			}
		} catch (Exception e) {
			test.fail(e.toString());
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void afterMethod() {
		extent.flush();
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		BaseClass.closeDriver(driver);
	}

}

