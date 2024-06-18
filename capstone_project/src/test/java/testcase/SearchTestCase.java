package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import web_Pages.*;
import common_pages.*;


	public class SearchTestCase extends BaseClass{
	    @BeforeSuite
				public void setUp() throws InterruptedException  {
			    	invokeBrowser("chrome");
					driver.get("https://www.advantageonlineshopping.com/#/");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					Thread.sleep(3000);	       
			}
			    @Test
			    public void testValidProductSearch() throws InterruptedException {
			    	Search  searchPage = new Search(driver);
			    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
			    	searchPage.getSearchButton().click();
			    	Thread.sleep(2000);
			        searchPage.getsearchBox().sendKeys("Speakers");
			        Thread.sleep(2000);
			        searchPage.getsearch().click();
			        Thread.sleep(2000);
			        searchPage.getsearchclose().click();
			        Thread.sleep(3000);
			        }
			    
			    @Test 
			    public void testPartialProductSearch() throws InterruptedException {
			    	Search  searchPage = new Search(driver);
			    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
			    	searchPage.getSearchButton().click();
			    	Thread.sleep(2000);
			        searchPage.getsearchBox().sendKeys("Lap");
			        Thread.sleep(2000);
			        searchPage.getsearch().click();
			        Thread.sleep(2000);
			        searchPage.getsearchclose().click();
			        Thread.sleep(3000);
			        }
			    @Test
			    public void testInvalidProductSearch() throws InterruptedException {
			    	Search  searchPage = new Search(driver);
			    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
			    	searchPage.getSearchButton().click();
			    	Thread.sleep(2000);
			        searchPage.getsearchBox().sendKeys("Watches");
			        Thread.sleep(2000);
			        searchPage.getsearch().click();
			        Thread.sleep(2000);
			        searchPage.getsearchclose().click();
			        Thread.sleep(3000);
			        }
			    @Test
			    public void testValidProductSearch1() throws InterruptedException {
			    	Search  searchPage = new Search(driver);
			    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
			    	searchPage.getSearchButton().click();
			    	Thread.sleep(2000);
			        searchPage.getsearchBox().sendKeys("Laptops");
			        Thread.sleep(2000);
			        searchPage.getsearch().click();
			        Thread.sleep(2000);
			        searchPage.getsearchclose().click();
			        Thread.sleep(3000);
			        }
			    @Test
			    public void testSearchWithSpecialCharacter() throws InterruptedException {
			    	Search   searchPage = new Search(driver);
			    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
			    	searchPage.getSearchButton().click();
			    	Thread.sleep(2000);
			        searchPage.getsearchBox().sendKeys("Tab@lets");
			        Thread.sleep(2000);
			        searchPage.getsearch().click();
			        Thread.sleep(2000);
			        searchPage.getsearchclose().click();
			        Thread.sleep(3000);
			        }
			    @Test
			    public void testBlankSearch() throws InterruptedException {
			    	Search   searchPage = new Search(driver);
			    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
			    	searchPage.getSearchButton().click();
			    	Thread.sleep(2000);
			        searchPage.getsearchBox().sendKeys("");
			        Thread.sleep(2000);
			        searchPage.getsearch().click();
			        Thread.sleep(2000);
			        searchPage.getsearchclose().click();
			        Thread.sleep(3000);
			        }
			    
			    @AfterSuite
			    public void tearDown() throws InterruptedException {
			    	Thread.sleep(3000);
			    	closeDriver(driver);
			        
			    }

		}

