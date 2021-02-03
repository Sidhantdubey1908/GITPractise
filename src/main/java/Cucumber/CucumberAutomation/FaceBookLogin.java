package Cucumber.CucumberAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookLogin extends BaseTest{

	@FindBy(id="email")
	WebElement UserID;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement login;
	
	public FaceBookLogin(String strURL) {
		driver.get(strURL);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUserIdPassword(String strUser, String strPassword) throws Exception {
		
		UserID.sendKeys(strUser);
		password.sendKeys(strPassword);
		login.click();
		Thread.sleep(2000);
	}


	
	
}
