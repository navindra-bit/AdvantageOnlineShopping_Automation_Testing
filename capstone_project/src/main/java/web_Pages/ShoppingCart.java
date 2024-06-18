package web_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
	WebDriver driver = null;
	By addToCart = By.cssSelector("button[name='save_to_cart']");
	By addToCartLink = By.xpath("//a[@id='shoppingCartLink']");
	By checkout = By.cssSelector("#checkOutButton");
	By next = By.id("next_btn");
	By GoBackToShopping  = By.xpath("//a[normalize-space()='CONTINUE SHOPPING']");
	By edit =By.xpath("(//a[contains(text(),'EDIT')])[2]");
	By remove = By.xpath("(//a[@data-ng-click='removeProduct($index)'][normalize-space()='REMOVE'])[2]") ;
	
	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAddtoCart() {
		return driver.findElement(addToCart);
	}
	
	public WebElement getAddToCartLink() {
		return driver.findElement(addToCartLink);
	}
	
	public WebElement getCheckout() {
		return driver.findElement(checkout);
	}
	
	public WebElement getNext() {
		return driver.findElement(next);
	}
	public WebElement getGoBackToShopping() {
		return driver.findElement(GoBackToShopping);
	}
	public WebElement getedit() {
		return driver.findElement(edit);
	}
	public WebElement getremove() {
		return driver.findElement(remove);
	}
}
