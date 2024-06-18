package web_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver = null;
	
	
	
    @FindBy(css = "#menuUserLink")WebElement usermenu;
    @FindBy(name = "remember_me")WebElement remeberme;
	@FindBy(xpath = "//input[@name='username']") WebElement userName;
	@FindBy(css = "input[name='password']") WebElement password;
	@FindBy(id = "sign_in_btn") WebElement signIn;
	@FindBy(xpath = "//a[normalize-space()='CREATE NEW ACCOUNT']") WebElement newAccount;
	//@FindBy(className = "facebook ng_scope") WebElement facebookLogin;
	
	//--------------------------------------------------------------------------------
	@FindBy(xpath= "//a[@id='hrefUserIcon']//*[name()='svg']") WebElement loginBtn;
	@FindBy(id="signInResultMessage")WebElement signInResultMessage;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement userName() {
		return userName;
	}
	public WebElement password() {
		return password;
	}
	public WebElement signIn() {
		return signIn;
	}
	public WebElement getnewAccount() {
		return newAccount;
	}
	//public WebElement facebookLogin() {
	//	return facebookLogin;
	//}
	public WebElement remeberme() {
		return remeberme;
	}
	public WebElement getusermenu() {
		return usermenu;
	}
	
	//-----------------------------------------------------------------------------
	public WebElement loginBtn() {
		return loginBtn;
	}
	public WebElement getSignInResultMessage() {
		return signInResultMessage;
	}
	
}
