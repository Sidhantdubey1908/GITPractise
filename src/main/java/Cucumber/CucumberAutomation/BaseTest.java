package Cucumber.CucumberAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Scenario;

public class BaseTest {

	public static WebDriver driver;	
	
	public static WebDriver getDriver() {
		 
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\91893\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 
		 return driver;
		
	}
	
	public static void getScreenShot(Scenario scenario) {
		
		//File screenshot =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
				byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			     // FileUtils.copyFile(screenshot, new File("target\\screenshots\\src.png"));
			      
			      scenario.attach(screenshot, "image/png", "ss");
	}
	
public static String getScreenShot2(Scenario scenario) throws Exception {
		
	String strPath = "D:\\CucumberAutomation2\\target\\screenshots\\src.png";
		File screenshot =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
				//byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			     FileUtils.copyFile(screenshot, new File("D:\\CucumberAutomation2\\target\\screenshots\\src.png"));
			      
			      //scenario.attach(screenshot, "image/png", "ss");
			     
			     return strPath;
	}
}
