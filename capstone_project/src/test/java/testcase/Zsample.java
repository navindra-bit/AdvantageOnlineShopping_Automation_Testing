package testcase;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Zsample {
    public static void main(String[] args) throws InterruptedException {
        // Path to the Excel file
        String excelFilePath = "./src/test/java/credentials/accountData.xlsx";
        String sheetName = "Sheet1";

        // Variables to hold the username and password
        String username = null;
        String password = null;

        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Get the first sheet
            Sheet sheet = workbook.getSheet(sheetName);

            // Read the first row (row 0)
            Row row = sheet.getRow(0);
            if (row != null) {
                // Read the username and password
                username = row.getCell(0).getStringCellValue();
                password = row.getCell(1).getStringCellValue();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the demo website
            driver.get("https://www.advantageonlineshopping.com/#/");
            driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    		
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp")));
    		

    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
    		Thread.sleep(2000);
    		
    		 WebElement menuElement  = driver.findElement(By.id("menuUser"));
    		 menuElement.click();
    		 WebElement creatElement  = driver.findElement(By.xpath("//a[normalize-space()='CREATE NEW ACCOUNT']"));
    		 creatElement.click();
    		 
    	
            WebElement usernameField = driver.findElement(By.xpath("//input[@name='usernameRegisterPage']"));
            WebElement passwordField = driver.findElement(By.xpath("//input[@name='passwordRegisterPage']"));

            // Enter the username and password
            usernameField.sendKeys(username);
            passwordField.sendKeys(password);

            // Optionally, find and click the login button
           // WebElement loginButton = driver.findElement(By.xpath("//button[@id='sign_in_btn']"));
            //loginButton.click();
            
            
            Thread.sleep(9000);

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
