package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Cucumber.CucumberAutomation.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

	private static ExtentReportGeneartor customExtentReprot;
	private static boolean isReportedRunning;

	@Before
	public void beforeScenario(Scenario scenario) {
		getDriver();
		if (!isReportedRunning) {
			customExtentReprot = new ExtentReportGeneartor("D:\\CucumberAutomation2\\target\\TestReport.html");
			isReportedRunning = true;
		}
	}

	@After()
	public void driverClose(Scenario scenario) throws Exception {

		String strPath = getScreenShot2(scenario);

		customExtentReprot.createTest(scenario, strPath);
		customExtentReprot.writetoReport();

		
		driver.close();
		System.out.println("Driver is closed");
	}
}
