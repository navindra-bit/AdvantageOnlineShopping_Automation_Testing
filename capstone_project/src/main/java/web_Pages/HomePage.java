package web_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver = null;
    By speakers = By.xpath("//span[@id='speakersTxt']");
    By tablet = By.xpath("//span[@id='tabletsTxt']");
    By laptop = By.cssSelector("#laptopsTxt");  
    By mice = By.cssSelector("#miceTxt");
    By headphone = By.xpath("//span[@id='headphonesTxt']");
    By specialOffer = By.xpath("//a[normalize-space()='SPECIAL OFFER']");
    By slidingPanel = By.xpath("//div[@class='explore_now_btn']");
    By popularItem = By.xpath("//a[normalize-space()='POPULAR ITEMS']");
    By contactUs = By.xpath("//a[normalize-space()='CONTACT US']");
    By  ShoppingCart = By.id("shoppingCartLink");
    By home = By.xpath("//a[@href='#/']");
    By seeoffer = By.xpath("//button[@id='see_offer_btn']");
    By details = By.xpath("(//label[@id='details_16'])[1]");
    By sendbnt = By.xpath("//button[@id='send_btn']");
    By helpmenu = By.cssSelector("#menuHelp");
    By cart = By.id("menuCart");
    By account = By.id("menuUserLink");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement speakers() {
        return driver.findElement(speakers);
    }

    public WebElement tablet() {
        return driver.findElement(tablet);
    }

    public WebElement laptop() {
        return driver.findElement(laptop);
    }

    public WebElement mice() {
        return driver.findElement(mice);
    }

    public WebElement headphone() {
        return driver.findElement(headphone);
    }

    public WebElement specialOffer() {
        return driver.findElement(specialOffer);
    }

    public WebElement slidingPanel() {
        return driver.findElement(slidingPanel);
    }

    public WebElement popularItem() {
        return driver.findElement(popularItem);
    }

    public WebElement contactUs() {
        return driver.findElement(contactUs);
    }
    public WebElement account() {
		return driver.findElement(account);
	}

    public WebElement getShoppingCart() {
        return driver.findElement(ShoppingCart);
    }
    public WebElement gethome() {
        return driver.findElement(home);
    }
    public WebElement getseeoffer() {
        return driver.findElement(seeoffer);
    }
    public WebElement getdetails() {
        return driver.findElement(details);
    }
    public WebElement getmenuHelp() {
        return driver.findElement(helpmenu);
    }
    public WebElement cart() {
		return driver.findElement(cart);
	}

}
