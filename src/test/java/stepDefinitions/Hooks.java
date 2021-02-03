package stepDefinitions;

import Cucumber.CucumberAutomation.BaseTest;
import io.cucumber.java.After;

public class Hooks extends BaseTest {

	@After("@SmokeTest")
	public void driverClose(){
		System.out.println("Driver is closed");
		driver.close();
	}
}
