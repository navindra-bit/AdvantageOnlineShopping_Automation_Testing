package testcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import common_pages.BaseClass;
//import web_Pages.AddToCart;
import web_Pages.CreateAccount;
import web_Pages.HomePage;
import web_Pages.LoginPage;
import web_Pages.MyAccount;
import web_Pages.MyOrders;
import web_Pages.OrderPayment;
import web_Pages.Search;
import web_Pages.ShoppingCart;


public class AppTest extends BaseClass{

	
	HomePage homePage;
	OrderPayment payment;
	CreateAccount createAccount;
	//AddToCart addToCart;
	LoginPage login;
	Search search;
	MyAccount myAccount;
	MyOrders myOrders;
	ShoppingCart shoppingCart;
	OrderPayment orderPayment;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	Properties properties=new Properties();

	@BeforeSuite
	public void beforeTest() throws InterruptedException {
		invokeBrowser("firefox");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies(); //delete all cookies
		Thread.sleep(7000); //wait 7 seconds to clear cookies.
		driver.get("https://www.advantageonlineshopping.com/#/");
	}
	
	@Test(priority=0)
	public void accountDetails() throws InterruptedException {
		createAccount=new CreateAccount(driver);
		Thread.sleep(5000);
		createAccount.getLoginicon().click();
		Thread.sleep(1000);
		createAccount.getCreateNewAccount().click();
		Thread.sleep(1000);
		createAccount.getUsername().sendKeys(("Vk"+UUID.randomUUID()).substring(0, 14));
		Thread.sleep(1000);
		createAccount.getEmail().sendKeys(("Vk"+UUID.randomUUID()).substring(0, 10)+"ing@gmail.com");
		Thread.sleep(1000);
		String str = ("Vkoh"+UUID.randomUUID()).substring(0, 11);
		createAccount.getPassword().sendKeys(str);
		Thread.sleep(1000);
		createAccount.getConfirmPassword().sendKeys(str);
	}
	@Test(priority=1, dependsOnMethods = "accountDetails")
	public void personalDetails() throws InterruptedException {
		Thread.sleep(1000);
		createAccount.getFirstName().sendKeys(("Vir"+UUID.randomUUID()).substring(0, 12));
		Thread.sleep(1000);
		createAccount.getLastName().sendKeys(("koh"+UUID.randomUUID()).substring(0, 12));
		Thread.sleep(1000);
		createAccount.getPhoneNumber().sendKeys(("74245"+UUID.randomUUID()).substring(0, 10));
		Thread.sleep(1000);
	}
	@Test(priority=2, dependsOnMethods = "personalDetails")
	public void register() throws InterruptedException {

		WebElement country = createAccount.getCountry();
		Select sel = new Select(country);
		sel.selectByVisibleText("India");
		Thread.sleep(1000);
		createAccount.getCity().sendKeys(("DELHI"+UUID.randomUUID()).substring(0, 9));
		Thread.sleep(1000);
		createAccount.getAddress().sendKeys(("dl"+UUID.randomUUID()).substring(0, 14));
		Thread.sleep(1000);
		createAccount.getState().sendKeys(("del"+UUID.randomUUID()).substring(0, 9));
		Thread.sleep(1000);
		createAccount.getPostalCode().sendKeys((""+UUID.randomUUID()).substring(0, 5));
		Thread.sleep(3000);
		createAccount.getI_agree().click();
		Thread.sleep(1000);
		createAccount.getRegister_btn().click();
		Thread.sleep(3000);
		
		// handling popup
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        alert.dismiss();
        
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
            
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            alert.dismiss();
        } catch (Exception e) {
            System.out.println("No alert found.");
        }
		
		WebElement ma= hp.account();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ma);
		ma.click();*/
		
		
		HomePage hp=new HomePage(driver);
		hp.account().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[@role='link'][normalize-space()='Sign out'])")).click();
		Thread.sleep(2000);
	}

	@Test(priority=3, dependsOnMethods = "register")
	public void LoginTestCase() throws InterruptedException, IOException {
		login=new LoginPage(driver);	
		login.loginBtn().click();
		FileInputStream fis=new FileInputStream("./src/test/java/credentials/data.properties");
		properties.load(fis);
		Thread.sleep(2000);
		login.userName().sendKeys(properties.getProperty("username"));
		Thread.sleep(2000);
		login.password().sendKeys(properties.getProperty("password"));
		Thread.sleep(2000);
		login.remeberme().click();
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

	@Test(priority=4, dependsOnMethods = "LoginTestCase")
	public void handlingCart() throws InterruptedException {
		Thread.sleep(3000);
		HomePage hp=new HomePage(driver);
		hp.cart().click();
		Thread.sleep(2000);
		shoppingCart=new ShoppingCart(driver);
		shoppingCart.getGoBackToShopping().click();
		Thread.sleep(3000);
		
		Search sc=new Search(driver);
		Thread.sleep(2000);
		sc.getSearchButton().click();
		sc.getsearchBox().sendKeys("hp");
		Thread.sleep(1000);
		sc.getSearchButton().click();
		Thread.sleep(2000);
		sc.getsearchclose().click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("img[id='9']")).click();
		Thread.sleep(3000);
		shoppingCart.getAddtoCart().click();
		Thread.sleep(5000);
		shoppingCart.getAddToCartLink().click();
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 5, dependsOnMethods = "handlingCart")
	public void editFromCart() throws InterruptedException {
		
		shoppingCart=new ShoppingCart(driver);
//		shoppingCart.getedit().click();
		driver.findElement(By.linkText("EDIT")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@class='uiview ng-scope']//span[2]")).click();
		Thread.sleep(4000);
		shoppingCart.getAddToCartLink().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[normalize-space()='REMOVE'])[1]"));
		Thread.sleep(5000);
	}
	  
	

	@Test(priority = 6 ,dependsOnMethods = "editFromCart")
	public void addingProduct() throws InterruptedException {

		homePage =new HomePage(driver);
		Thread.sleep(4000);
		homePage.gethome().click();
		Thread.sleep(4000);
		homePage.tablet().click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[normalize-space()='HP Elite x2 1011 G1 Tablet']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[@id='rabbit'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='plus']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[name='save_to_cart']")).click();
		Thread.sleep(2000);
		homePage.cart().click();
	}

	@Test(priority = 7, dependsOnMethods = "addingProduct")
	public void checkout() throws InterruptedException {
		shoppingCart = new ShoppingCart(driver);
		//shoppingCart.getCheckout().click();
		driver.findElement(By.xpath("(//button[@id='checkOutButton'])[1]"));
		Thread.sleep(2000);
		orderPayment = new OrderPayment(driver);
		Thread.sleep(2000);
		orderPayment.Next();
		Thread.sleep(2000);
		orderPayment.payNow().click();
		Thread.sleep(2000);	
	}
	
	@Test (priority = 8, dependsOnMethods = "checkout")
	public void paymentWithSafePay() throws InterruptedException, IOException {
		homePage =new HomePage(driver);
		Thread.sleep(4000);
		homePage.gethome().click();
		Thread.sleep(2000);
		homePage.headphone().click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("img[id='15']")).click();
		Thread.sleep(2000);
		shoppingCart=new ShoppingCart(driver);
		shoppingCart.getAddtoCart().click();
		Thread.sleep(3000);
		shoppingCart.getAddToCartLink().click();
		Thread.sleep(2000);
		shoppingCart.getCheckout().click();
		Thread.sleep(2000);
		orderPayment = new OrderPayment(driver);
		Thread.sleep(2000);
		orderPayment.Next();
		Thread.sleep(2000);
		orderPayment.Paysafepay().click();
		Thread.sleep(2000);
		
		//Changing username of safepay
		driver.findElement(By.xpath("//input[@name='safepay_username']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='safepay_username']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='safepay_username']")).sendKeys("User07");
		Thread.sleep(2000);
		
		//Changing password of safepay
		driver.findElement(By.xpath("//input[@name='safepay_password']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='safepay_password']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='safepay_password']")).sendKeys("User@077");
		Thread.sleep(2000);
		
		orderPayment.payNow().click();
		Thread.sleep(2000);	
	}



	@AfterSuite
	public void afterTest() throws InterruptedException {
		closeDriver(driver);
	}
}
