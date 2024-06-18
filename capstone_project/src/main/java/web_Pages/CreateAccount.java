package web_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	WebDriver driver=null;
	public CreateAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement for Account Details
	@FindBy(id = "menuUserLink") WebElement loginicon;
	@FindBy(xpath = "//a[@class='create-new-account ng-scope']") WebElement createNewAccount;
	@FindBy(xpath ="//input[@name='usernameRegisterPage']")WebElement username;
	@FindBy(xpath= "//input[contains(@name,'emailRegisterPage')]")WebElement email;
	@FindBy(name="passwordRegisterPage")WebElement password;
	@FindBy(name="confirm_passwordRegisterPage")WebElement confirmPassword;
	
	//WebElement for Personal Details
	@FindBy(name="first_nameRegisterPage")WebElement firstName;
	@FindBy(name="last_nameRegisterPage")WebElement lastName;
	@FindBy(name="phone_numberRegisterPage")WebElement phoneNumber;
	
	//WebElement for Address
	@FindBy(name="countryListboxRegisterPage")WebElement country;
	@FindBy(name="cityRegisterPage") WebElement city;
	@FindBy(name="addressRegisterPage")WebElement address;
	@FindBy(name="state_/_province_/_regionRegisterPage")WebElement state;
	@FindBy(name="postal_codeRegisterPage")WebElement postalCode;
	@FindBy(name="i_agree")WebElement i_agree;
	@FindBy(id="register_btn")WebElement register_btn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLoginicon() {
		return loginicon;
	}

	public WebElement getCreateNewAccount() {
		return createNewAccount;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getCountry() {
		return country;
		/*to select the particular country we have to pass this country 
		 * into the object of select object constructor and followed by send the country value
		 * by using method sendByValue("Country_name") */
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getI_agree() {
		return i_agree;
	}

	public WebElement getRegister_btn() {
		return register_btn;
	}
}
