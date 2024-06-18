package testcase;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common_pages.BaseClass;
import web_Pages.MyOrders;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyOrdersTest extends BaseClass{
   WebDriver driver;
    MyOrders myOrders;
    
    @Before
    public void setUp() throws InterruptedException {
    	driver = BaseClass.invokeBrowser("chrome");
    	driver.get("https://www.advantageonlineshopping.com/#/"); 
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));

        
        
        performLogin();
        navigateToMyOrders();
        
        // Initialize the MyOrders page object Model
        myOrders = new MyOrders(driver);
    }
    
    public void performLogin() {
        driver.findElement(By.id("menuUser")).click();
        driver.findElement(By.name("username")).sendKeys("testuser2");
        driver.findElement(By.name("password")).sendKeys("Password123");
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        
        WebElement signInButton = driver.findElement(By.id("sign_in_btn"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", signInButton);
    }

    public void navigateToMyOrders() {
    	
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
        WebElement userMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']")));
        userMenu.click();
      //  WebElement hiUserSpan = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));
       // wait.until(ExpectedConditions.elementToBeClickable(hiUserSpan));
       // hiUserSpan.click();
        
        driver.findElement(By.xpath("//*[@id='loginMiniTitle']/label[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    
    @Test
    public void testContinueShopping() throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
    	
    	if (myOrders.Continueshopping().isDisplayed()) {
            System.out.println("No orders are present. Clicking on 'Continue Shopping' button.");
            Thread.sleep(5000);
            myOrders.Continueshopping().click();
        } 
    	else {
            System.out.println("Orders are present.");
            }
     
    }
    
    @Test
    public void testRemoveOrderDecline() throws InterruptedException {
    	
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
        Thread.sleep(2000);
        
    	
    	assertTrue(myOrders.Removebtn().isDisplayed());
    	Thread.sleep(5000);
        myOrders.Removebtn().click();

        // Decline the confirmation alert
        if (myOrders.RemoveDeclinebtn().isDisplayed()) {
        	Thread.sleep(5000);
            myOrders.RemoveDeclinebtn().click();
            System.out.println("Remove order decline action is success");
          
        }
    }
    
    @Test
    public void testRemoveOrderAccept() throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
        
        
    	
    	
    	assertTrue(myOrders.Removebtn().isDisplayed());
	    Thread.sleep(5000);
        myOrders.Removebtn().click();
       
        // Accept the confirmation alert
        if (myOrders.RemoveConfirmbtn().isDisplayed()) {
        	 Thread.sleep(5000);
             myOrders.RemoveConfirmbtn().click();
             System.out.println("Remove order accept action is success");
        }
   } 
    
    
  
    
    @Test
    public void testSearchOrderByProductName() throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
        
        // Check if the search order button is displayed
        if (!myOrders.Searchorder().isDisplayed()) {
            System.out.println("Search order button is not displayed.");
           // return; // Exit the test method if no orders are present
        }else {

        // Enter the product name to search for
        String productNameToSearch = "laptop"; // Change this to the product name you want to search for

        // Click on the search order button
        myOrders.Searchorder().click();

        // Enter the product name in the search field and perform the search
        myOrders.searchByProductName(productNameToSearch);
        }
      
        
    }
    
    @After
    public void tearDown() throws InterruptedException {
    	closeDriver(driver);
    }
}
