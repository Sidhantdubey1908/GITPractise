package stepDefinitions;

import java.awt.List;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Cucumber.CucumberAutomation.BaseTest;
import Cucumber.CucumberAutomation.FaceBookLogin;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.netty.handler.codec.http.multipart.FileUpload;

@RunWith(Cucumber.class)
public class FaceBook_StepDefinition extends BaseTest {

	
	//WebDriver driver = getDriver();
	String strURL = getProperty("URL");
	FaceBookLogin fb = new FaceBookLogin(strURL);
	
	
    @Given("^User is on the facebook login page$")
    public void user_is_on_the_facebook_login_page() throws Throwable {
      //driver = BaseTest.getDriver();
    	System.out.println("User is on Login page");
    	
    	
    }

    @When("^User enters the UserID and password and clicks on Login button$")
    public void user_enters_the_userid_and_password_and_clicks_on_login_button() throws Throwable {
       // throw new PendingException();
    	//FaceBookLogin fb = new FaceBookLogin("https://www.facebook.com/enespanol/");
    	fb.enterUserIdPassword("sidhantdubey1908@gmail.com", "saritadubey");
    	 System.out.println("User enters user id and passwprd");
    }

    @When("^User enters the (.+) and (.+) and clicks on Login button$")
    public void user_enters_the_and_and_clicks_on_login_button(String userid, String password) throws Throwable {
        
    	//FaceBookLogin fb = new FaceBookLogin("https://www.facebook.com/enespanol/");
    	//throw new PendingException();
    	fb.enterUserIdPassword(userid, password);
    	 System.out.println("User enter Userid "+userid+" and  password"+password+"");
    }

    @Then("^facebook homepage is displayed$")
    public void facebook_homepage_is_displayed() throws Throwable {
        //throw new PendingException();
    	 System.out.println("User is on home page");
    }

    @When("^User enters the following credentials$")
    public void user_enters_the_following_credentials(DataTable data) throws Throwable {
    	//FaceBookLogin fb = new FaceBookLogin("https://www.facebook.com/enespanol/");
    	java.util.List<String> list = data.asList();
    	System.out.println("User id = "+list.get(0)+"");
    	System.out.println("Password is = "+list.get(1)+"");
    	fb.enterUserIdPassword(list.get(0), list.get(1));
       
    }
    
    @Given("^validate the browser$")
    public void validate_the_browser() throws Throwable {
       System.out.println("Browser is there");
    }

    @When("^browser is trigerred$")
    public void browser_is_trigerred() throws Throwable {
    	 System.out.println("Browser is triggered");
    }

    @Then("^check if browser is started$")
    public void check_if_browser_is_started() throws Throwable {
   	 System.out.println("Browser is started");
    }

    @And("^i take screenhot$")
    public void i_take_screenhot() throws Throwable {
      File screenshot =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot, new File("target\\screenshots\\src.png"));
    }

}
