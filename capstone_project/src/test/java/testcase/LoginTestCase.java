package testcase;



//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import common_pages.BaseClass;
import web_Pages.LoginPage;

public class LoginTestCase extends BaseClass{
	
	//Properties properties=new Properties();
	Properties prop=new Properties();
	
	@BeforeMethod
	public void beforeTest() throws IOException, InterruptedException {
		
		invokeBrowser("chrome");
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FileReader fis=new FileReader("./src/test/java/credentials/data.properties");
		prop.load(fis);
	}

	@Test(priority = 0)
	public void loginTC1()throws FileNotFoundException,IOException, InterruptedException {
		
		//Checking for correct password and username
		
		LoginPage login = new LoginPage(driver);
		login.loginBtn().click();
		Thread.sleep(1000);
		login.userName().sendKeys(prop.getProperty("username"));
		login.password().sendKeys(prop.getProperty("password"));
		Thread.sleep(2000);
		login.signIn().click();
		Thread.sleep(1000);
		
		if(login.getSignInResultMessage().getText().equals("Incorrect user name or password.")) {
			System.out.println("Incorrect user name or password.");
		}else {
			System.out.println("Login Successfull.");
		}	 
		Thread.sleep(1000);
	}
	
	@Test(priority=1 , enabled = false)
	public void loginTC2() throws InterruptedException {
		
		//Checking for incorrect password
		LoginPage login = new LoginPage(driver);
		//JavascriptExecutor executor = driver;
		login.loginBtn().click();
		Thread.sleep(1000);
		login.userName().sendKeys(prop.getProperty("username2"));
		login.password().sendKeys(prop.getProperty("password2"));
		Thread.sleep(2000);
		login.signIn().click();
		Thread.sleep(1000);
		if(login.getSignInResultMessage().getText().equals("Incorrect user name or password.")) {
			System.out.println("Incorrect user name or password.");
		}else {
			System.out.println("Login Successfull.");
		}	 
		Thread.sleep(3000);

	}
	@Test (priority=2)
	public void loginTC3() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.loginBtn().click();
		Thread.sleep(1000);
		login.userName().sendKeys(prop.getProperty("username"));
		login.password().sendKeys(prop.getProperty("Wrongpassword"));
		Thread.sleep(2000);
		login.signIn().click();
		Thread.sleep(1000);
		
		if(login.getSignInResultMessage().getText().equals("Incorrect user name or password.")) {
			System.out.println("Incorrect user name or password.");
		}else {
			System.out.println("Login Successfull.");
		}	 
		Thread.sleep(1000);
		//if(!login.forgetPassword().isEnabled())
		System.out.println("The forget password button is not working");
	}

	@AfterMethod
	public void afterTest() throws InterruptedException, IOException {
		Thread.sleep(3000);
		closeDriver(driver);
	}
}

