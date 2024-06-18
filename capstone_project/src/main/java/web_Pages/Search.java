package web_Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Search {
	WebDriver driver= null;
	@FindBy(id = "menuSearch") WebElement searchButton;
	@FindBy(xpath="//input[@id='autoComplete']") WebElement searchBox;
	@FindBy(xpath="//a[@title='SEARCH']//*[name()='svg']") WebElement search;
	@FindBy(xpath="//*[@id=\"search\"]/div/div/img") WebElement closeSearch;
	
	/*
	 * WebDriver driver = null; By searchButton = By.id("menuSearch"); By searchBox
	 * = By.xpath("//input[@id='autoComplete']"); By search =
	 * By.xpath("//a[@title='SEARCH']//*[name()='svg']"); By searchclose
	 * =By.xpath("//img[@src='../../css/images/closeDark.png']");
	 */
	
	  public Search(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	  public WebElement getSearchButton() {
		return searchButton;
		}
	  public WebElement getsearchBox() {
			return searchBox;
			}
	  public WebElement getsearch() {
			return search;
			}
	  public WebElement getsearchclose() {
			return closeSearch ;
			}
	

}
