package Stepdefinition;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class Landing_scenario extends Generic_functions{
	AppiumDriver driver;

	/*TC_001 - Validate Landing page UI */
	@Given("Launch the app")
	public void launch_app() throws Exception {
		try {
			driver = app_launch();
			page_wait(6000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_launch_app");
		}
	}
	@Then("Verify Landing page UI")
	public  void verify_landingPage_UI() throws Exception {
		try {
			Assert.assertTrue(driver.findElement(By.xpath(OR_reader("mph_image"))).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath(OR_reader("mph_logo"))).isDisplayed());
			String text= td_reader("welcome_oneAppToText",0)+","+td_reader("welcome_oneAppToText",1)+","+td_reader("welcome_oneAppToText",2)+","+td_reader("welcome_oneAppToText",3);
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("welcome_oneAppToText"))).getText(),text);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_verify_landingPage_UI");
		}		
	}

	/*TC_002 - Validate that the user is able to click on 'Sign Up' button and navigate to 'Sign Up' page */
	@When("Click on 'Sign Up' button")
	public  void click_signup() throws Exception  {
		try {
			page_wait(6000);
			click("welcome_signup");
			page_wait(1000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_click_signup");
		}
	}
	@Then("Verify Sign up page")
	public  void verify_signup_page() throws Exception {
		try {
			text= driver.findElement(By.xpath(OR_reader("signup_page_title"))).getText();
			Assert.assertEquals(text,td_reader("signup_page_title",0));
			page_wait(5000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_verify_signup_page");
		}		
	}

	/*TC_003 -Validate user is able to click on 'Login' button and navigate to Login page */
	@When("Click on 'Login' button")
	public  void click_login() throws Exception {
		try {
			if (platformName.equals("iOS")) {
				page_wait(2000);
				click("welcome_login");
				click("continue");
				page_wait(3000);
			}
			page_wait(5000);
			click("welcome_login");
			page_wait(50000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_clicks_login");
		}
	}
	@Then("Verify Login page")
	public  void verify_login_page() throws Exception {
		try {
			text= driver.findElement(By.xpath(OR_reader("login_page_title"))).getText();
			Assert.assertEquals(text,td_reader("login_page_title",0));

		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_verify_login_page");
		}	
	}

	@Then("Close Landing page")
	public void closeLandingPage() {
		close();
	}
}