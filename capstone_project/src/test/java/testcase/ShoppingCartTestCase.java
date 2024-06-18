package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import common_pages.BaseClass;
import web_Pages.ShoppingCart;
import web_Pages.HomePage;
import web_Pages.Search;

public class ShoppingCartTestCase extends BaseClass {
	 
	@BeforeSuite
	public void openBrowser() throws InterruptedException {

		invokeBrowser("chrome");
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}


	 @Test (priority = 0)
	 public void openEmptycart() throws InterruptedException{
		 Thread.sleep(4000);
		 HomePage homePage = new HomePage(driver);
	
	WebElement clicElement =homePage.getShoppingCart();
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();",  clicElement);
	 clicElement.click();
	  }
	  
	 @Test(priority = 1)
	 public void searchCart() throws Exception {
		 Search search = new Search(driver);
		 search.getSearchButton().click();
		 Thread.sleep(2000);
		 search.getsearchBox().sendKeys("hp");
		 Thread.sleep(2000);
		 search.getsearch().click();
		 search.getsearchclose().click();
		 Thread.sleep(5000);
	 }
	 @Test(priority = 2)
	  public void addtoCart() throws InterruptedException {
		
		   driver.findElement(By.xpath("(//input[@name='category'])[3]")).click();
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//a[normalize-space()='HP Elite x2 1011 G1 Tablet']")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//*[@id=\"productProperties\"]/div[4]/button")).click();
	 }
	 @Test(priority = 3)
	 public void Gohome() throws InterruptedException {
		 HomePage homePage=new HomePage(driver);
		 homePage.gethome().click();
		 Thread.sleep(2000);
	 }
	
	 
	
	  @Test(priority = 4)
	  public void goToTablets() throws InterruptedException {
		  
		  HomePage homePage=new HomePage(driver);
		  homePage.tablet().click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@class='cell categoryRight']//li[1]//p[2]")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//*[@id=\"productProperties\"]/div[2]/e-sec-plus-minus/div/div[3]")).click();
		   driver.findElement(By.xpath("//*[@id=\"productProperties\"]/div[4]/button")).click();
		  
	  }
	  @Test(priority = 5)
	  public void goToCart() throws InterruptedException {
		  Thread.sleep(4000);
		  HomePage homePage=new HomePage(driver);
		  homePage.getShoppingCart().click();
		  
	  }
	  
	  @Test(priority = 6)
	  public void editFromCart() throws InterruptedException {
		  Thread.sleep(3000);
		  ShoppingCart shopcart=new ShoppingCart(driver);
		  shopcart.getedit().click();
		  Thread.sleep(2000);
		  driver.navigate().back();  
	  }
	  
	  @Test(priority = 7)
	  public void removeFromCart() throws InterruptedException {
		  Thread.sleep(2000);
		  ShoppingCart shopcart=new ShoppingCart(driver);
		  shopcart.getremove().click();
		  
	  }
	 
	  @Test(priority = 8)
	  public void proceedToCheckOut() throws InterruptedException {
		  Thread.sleep(2000);
		  ShoppingCart shopcart=new ShoppingCart(driver);
		  shopcart.getCheckout().click();
		 
	  }
	  
	 @AfterSuite
	 public void afterTest() throws InterruptedException {
		 Thread.sleep(3000);
		 closeDriver(driver);
	  }

}
