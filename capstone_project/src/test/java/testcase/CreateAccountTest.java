package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common_pages.BaseClass;
import web_Pages.CreateAccount;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
*/
//import web_Pages.*;
//import common_pages.*;

//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class CreateAccountTest {
    private WebDriver driver;
    private String excelFilePath = "./src/test/java/credentials/accountData.xlsx";
    
   
    @BeforeTest
    public void setup() throws InterruptedException {
        driver = BaseClass.invokeBrowser("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
        driver.get("https://www.advantageonlineshopping.com/#/");
        Thread.sleep(2000);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));

        driver.findElement(By.id("menuUser")).click();
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));

        WebElement CreateNewAccount = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", CreateNewAccount);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        
    }
    

    @DataProvider(name = "accountData")
    public Object[][] getAccountData() throws IOException {
        FileInputStream fis = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(fis);

        // Assuming the data is in the first sheet (index 0)
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        Object[][] data = new Object[rowCount][12];

        // Start from row 1, assuming row 0 is the header row
        for (int rowNum = 1; rowNum <= rowCount; rowNum++) {
            Row row = sheet.getRow(rowNum);
            for (int colNum = 0; colNum < 12; colNum++) {
                Cell cell = row.getCell(colNum);
                if (cell.getCellType() == CellType.NUMERIC) {
                    // Convert numeric cell to string
                    data[rowNum - 1][colNum] = NumberToTextConverter.toText(cell.getNumericCellValue());
                } else {
                    data[rowNum - 1][colNum] = cell.getStringCellValue();
                }
            }
        }

        workbook.close();
        fis.close();
        return data;
    }


    @Test(dataProvider = "accountData")
    public void createAccount(String username, String email, String password, String confirmPassword, String firstName, String lastName, String phoneNumber, String country, String city, String address, String state, String postalCode) throws InterruptedException {
        CreateAccount createAccountPage = new CreateAccount(driver);

        createAccountPage.getUsername().sendKeys(username);
        createAccountPage.getEmail().sendKeys(email);
        createAccountPage.getPassword().sendKeys(password);
        createAccountPage.getConfirmPassword().sendKeys(confirmPassword);
        createAccountPage.getFirstName().sendKeys(firstName);
        createAccountPage.getLastName().sendKeys(lastName);
        createAccountPage.getPhoneNumber().sendKeys(phoneNumber);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountPage.getCountry()));

        Select countryDropdown = new Select(createAccountPage.getCountry());
        countryDropdown.selectByVisibleText(country);

        createAccountPage.getCity().sendKeys(city);
        createAccountPage.getAddress().sendKeys(address);
        createAccountPage.getState().sendKeys(state);
        createAccountPage.getPostalCode().sendKeys(postalCode);
        createAccountPage.getI_agree().click();
        Thread.sleep(3000);
      
        
        boolean isRegisterButtonEnabled = createAccountPage.getRegister_btn().isEnabled();

        if (isRegisterButtonEnabled) {
        	
            System.out.println("Account for " + username + " is created successfully.");
            Thread.sleep(3000);
        } 
        else {
            System.out.println("Please verify and enter the valid details for " + username + ".");
        }
        
        
     // Clear input fields for the next iteration
        createAccountPage.getUsername().clear();
        createAccountPage.getEmail().clear();
        createAccountPage.getPassword().clear();
        createAccountPage.getConfirmPassword().clear();
        createAccountPage.getFirstName().clear();
        createAccountPage.getLastName().clear();
        createAccountPage.getPhoneNumber().clear();
        createAccountPage.getCity().clear();
        createAccountPage.getAddress().clear();
        createAccountPage.getState().clear();
        createAccountPage.getPostalCode().clear();
    }
    
      //  createAccountPage.clearFields();
    
    

    @AfterTest
    public void teardown() throws InterruptedException {
    	Thread.sleep(3000);
        driver.quit();
    }
}