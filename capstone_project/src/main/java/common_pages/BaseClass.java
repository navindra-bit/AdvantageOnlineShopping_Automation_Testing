package common_pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class BaseClass {

	public static WebDriver driver = null;
	
	
	public static WebDriver invokeBrowser(String s) throws InterruptedException {
				if(s.equalsIgnoreCase("microsoft"))
				{	
					driver = new EdgeDriver();   
					driver.manage().window().maximize();      
					Thread.sleep(2000);
				}
			else if(s.equalsIgnoreCase("FireFox")) {
				driver = new FirefoxDriver();   
				driver.manage().window().maximize();      
				Thread.sleep(2000);
			}
			else if(s.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();   
				driver.manage().window().maximize();       
				Thread.sleep(2000);
			}
			else {
				System.out.println("None of the browser is matching");
			}
			return driver;
			}
	public static String ScreenShot() {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Screenshots/" + "Alert-" + System.currentTimeMillis() + ".png");
			String absPath = destFile.getAbsolutePath();
			Files.copy(srcFile, destFile);
			return absPath;
		} catch (Exception e) {
			System.out.println(e);
			return "";
		}
	}

			
			public static void screenShot(WebDriver driver) throws IOException {
				File src=null;
				TakesScreenshot tr=(TakesScreenshot)driver;
				src=tr.getScreenshotAs(OutputType.FILE);
				Files.copy(src,new File( "./ScreenShots/"+"Page-"+System.currentTimeMillis()+".png"));
				
			}
			public static void closeDriver(WebDriver d1) throws InterruptedException {
			Thread.sleep(2000);
			d1.close();
			}

}

