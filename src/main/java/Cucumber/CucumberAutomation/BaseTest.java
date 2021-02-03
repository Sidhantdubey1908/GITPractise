package Cucumber.CucumberAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public static WebDriver driver;	
	
	public static WebDriver getDriver() {
		 
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\91893\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 
		 return driver;
		
	}
}
