package stepDefinitions;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Cucumber.CucumberAutomation.BaseTest;
import io.cucumber.java.Scenario;

public class ExtentReportGeneartor extends BaseTest {

	private ExtentHtmlReporter extentHtmlReports;
	private ExtentReports extentReports;

	public ExtentReportGeneartor(String strFileName) {
		extentHtmlReports = new ExtentHtmlReporter(strFileName);
		extentHtmlReports.config().setEncoding("utf-8");
		extentHtmlReports.config().setDocumentTitle("Automation Cucumber");
		extentHtmlReports.config().setReportName("Automation Test Results");
		extentHtmlReports.config().setTheme(Theme.STANDARD);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReports);
	}

	public void createTest(Scenario scenario, String strSscreenShotFilepath) throws Exception {

		if (scenario != null) {
			String strTestCase = getScenarioName(scenario);
			switch (scenario.getStatus()) {
			case PASSED:
				extentReports.createTest(strTestCase).pass("Passed").addScreenCaptureFromPath(strSscreenShotFilepath);
				break;

			case FAILED:
				extentReports.createTest(strTestCase).fail("Failed").addScreenCaptureFromPath(strSscreenShotFilepath);

			default:
				break;
			}
		}

	}

	public void writetoReport() {
		if (extentReports != null) {
			extentReports.flush();
		}
	}

	public String getScenarioName(Scenario scenario) {
		return scenario.getName().replaceAll(" ", "");
	}
}
