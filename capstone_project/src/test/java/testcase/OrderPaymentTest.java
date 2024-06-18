package testcase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common_pages.BaseClass;
import web_Pages.LoginPage;
//import web_Pages.ShoppingCart;
import web_Pages.OrderPayment;

public class OrderPaymentTest {
	WebDriver driver;
	OrderPayment orderPayment;
	Properties prop=new Properties();
	
	@Before
    public void setUp() throws InterruptedException,IOException {
		driver= BaseClass.invokeBrowser("chrome");
		driver.get("https://www.advantageonlineshopping.com/#/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    Thread.sleep(5000);
	   driver.findElement(By.id("menuUser")).click();
	   FileReader fis=new FileReader("./src/test/java/credentials/secondData.properties");
	   prop.load(fis);
//	   LoginPage login=new LoginPage(driver);
//	   login.userName().sendKeys(prop.getProperty("username3"));
//	   login.password().sendKeys(prop.getProperty("password3"));
//	     Thread.sleep(1000);
//	     login.signIn().click();
//	    Thread.sleep(1000);
//	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
//		  
}
	
	@Test
    public void checkoutWithCard() throws InterruptedException {
		
		
		LoginPage login=new LoginPage(driver);
		   login.userName().sendKeys(prop.getProperty("username"));
		   login.password().sendKeys(prop.getProperty("password"));
		     Thread.sleep(1000);
		     login.signIn().click();
		    Thread.sleep(1000);
//		    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));		  
//		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));

    	 driver.findElement(By.xpath("//a[@id='shoppingCartLink']")).click();
    	 Thread.sleep(5000);
    	 driver.findElement(By.cssSelector("#checkOutButton")).click();
    	 Thread.sleep(5000);
    	 WebElement nextbtn = driver.findElement(By.id("next_btn"));
         JavascriptExecutor executor = (JavascriptExecutor) driver;
         executor.executeScript("arguments[0].click();", nextbtn);
         Thread.sleep(5000);
    	 
         WebElement paynowMastercard = driver.findElement(By.id("pay_now_btn_MasterCredit"));
          
         executor.executeScript("arguments[0].click();", paynowMastercard);
         Thread.sleep(5000);
    	 
    	 }
	
	
	@Test
	public void checkoutWithSafepay() throws InterruptedException{
		  
		
		  LoginPage login=new LoginPage(driver);
		   login.userName().sendKeys(prop.getProperty("username3"));
		   login.password().sendKeys(prop.getProperty("password3"));
		     Thread.sleep(1000);
		     login.signIn().click();
		    Thread.sleep(1000);
		    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
		
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
	    	
	    	 driver.findElement(By.xpath("//a[@id='shoppingCartLink']")).click();
	    	 Thread.sleep(5000);
	    	 driver.findElement(By.cssSelector("#checkOutButton")).click();
	    	 Thread.sleep(5000);
	    	 WebElement nextbtn = driver.findElement(By.id("next_btn"));
	         JavascriptExecutor executor = (JavascriptExecutor) driver;
	         executor.executeScript("arguments[0].click();", nextbtn);
	         Thread.sleep(5000);
	         driver.findElement(By.xpath("//input[@name='safepay']")).click();
	         Thread.sleep(5000);
	         
	         WebElement safePayUsername= driver.findElement(By.name("safepay_username"));
	         WebElement safePayPassword= driver.findElement(By.name("safepay_password"));
	       
	         safePayUsername.clear();
	         Thread.sleep(2000);
	         safePayPassword.clear();
	         Thread.sleep(2000);
	         safePayUsername.sendKeys(prop.getProperty("safepayUsername"));
	         Thread.sleep(5000);
	         safePayPassword.sendKeys(prop.getProperty("safepayPassword"));
	    	
	         WebElement paynowSafepay = driver.findElement(By.xpath("//button[@id='pay_now_btn_SAFEPAY']"));
	         executor.executeScript("arguments[0].click();", paynowSafepay);
	         Thread.sleep(5000);
	         System.out.println("Negative Testcase passed..!");
	}
	
	@After
    public void teardown() {
        driver.quit();
    }
}
