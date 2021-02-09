package Cucumber.CucumberAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Scenario;

public class BaseTest {

	public static WebDriver driver;

	public static WebDriver getDriver() {

		String browser = getProperty("browser");
		try {
			if (browser.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\91893\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browser.equals("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\91893\\Downloads\\geckodriver-v0.29.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();

			}
		} catch (Exception e) {
			System.out.println("Driver not launch");
		}
		return driver;

	}

	public static void getScreenShot(Scenario scenario) {

		// File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		// FileUtils.copyFile(screenshot, new File("target\\screenshots\\src.png"));

		scenario.attach(screenshot, "image/png", "ss");
	}

	public static String getScreenShot2(Scenario scenario) throws Exception {

		String strPath = "D:\\CucumberAutomation2\\target\\screenshots\\src.png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String strFilename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File dest = new File("D:\\CucumberAutomation2\\target\\screenshots\\" + strFilename + ".png");

		// byte[] screenshot =
		// ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		// FileUtils.copyFile(screenshot, new
		// File("D:\\CucumberAutomation2\\target\\screenshots\\src.png"));
		FileUtils.copyFile(screenshot, new File(dest.toString()));

		// scenario.attach(screenshot, "image/png", "ss");

		return dest.toString();
	}

	public static String getProperty(String strProp) {
		String strValue = "";
		try {
			Properties prop = new Properties();
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/Global.properties");
			prop.load(file);

			strValue = prop.getProperty(strProp);
		} catch (Exception e) {

		}

		return strValue;
	}
}
