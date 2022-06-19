//package Stepdefinition;
//
//import org.junit.Assert;
//import org.openqa.selenium.By;
//
//import Reusable_Functions.Generic_functions;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Login_positive_scenario extends Generic_functions{
//	public static boolean value;
//	public static String text;
//
//	/*TC 001 - Validate that the'Phone number' field is prefixed with '+1' country code*/
//	@Given("Launch the URL")
//	public static void app_launching() throws Exception {
//		try {
//			app_launch();
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_positive_app_launching");
//		}
//	}
//
//	@When("Clicks on 'Login' button")
//	public static void click_login_button() throws Exception {
//		try {
//			if (platformName.equals("iOS")) {
//				page_wait(2000);
//				click("welcome_login");
//				click("continue");
//				page_wait(3000);
//			}
//			else if (platformName.equals("Android")) {
//				page_wait(2000);
//				click("welcome_login");
//				page_wait(4000);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_positive_click_login_button");
//		}
//	}
//
//	@Then("check  the  'Phone number' field is prefixed with country code")
//	public static void check_code() throws Exception {
//		try {
//			value = driver.findElement(By.xpath(OR_reader("plus_one"))).isDisplayed();
//			Assert.assertEquals(true,value);
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_positive_check_code");
//		}
//	}
//
//	/*TC 002 - Validate that the user is able to click on the 'Forgot password?' link*/
//	@When("clicks on 'Forgot password'")
//	public static void click_forgot_password() throws Exception {
//		try {
//
//			// ADD WORK AROUND CODE
//
//			//			page_wait(1000);
//			//			click("forgot_password_link");
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_positive_click_forgot_password");
//		}
//	}
//
//	@Then("navigated to Forgot password page")
//	public static void navigate_forgot_password_page() {
//		//	try {
//		//		value = driver.findElement(By.xpath(OR_reader("send_resend_link"))).isDisplayed();
//		//		Assert.assertEquals(true,value);
//		//		page_wait(1000);
//		//	} catch (Exception e) {
//		//		e.printStackTrace();
//		//		takeScreenShot("login_positive_navigate_forgot_password_page");
//		//}
//
//	}
//
//	/*TC 003 - Validate that the user is able click on the 'Sign up' link*/
//	@When("clicks on 'Sign up'")
//	public static void click_signup() throws Exception {
//		try {
//			page_wait(2000);
//			//click("forgot_signup_link");
//			page_wait(10000);
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_positive_click_signup");
//		}
//	}
//	@Then("navigated to Sign up page")
//	public static void navigate_signup_page()  throws Exception {
//		try {
////			text= driver.findElement(By.xpath(OR_reader("signup_page_title"))).getText();
////			Assert.assertEquals(text,td_reader("signup_page_title"));
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_positive_navigate_signup_page");
//		}
//	}
//
//	/*TC 004 - Validate that the user is able to enter password on the Password field*/
//	@Then("enters the Password")
//	public static void enter_password() throws Exception {
//		try {
//			page_wait(10000);
//			//click("forgot_login_link");
//			page_wait(3000);
//			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",1));
//			page_wait(3000);
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_positive_enter_password");
//		}
//	}
//
//	/*TC 005 - Validate that the user User enters valid phonenumber and password and User click on login*/
//	@When("enters valid phonenumber and password")
//	public static void enter_valid_cred() throws Exception {
//		try {
//			field_clear("login_password");
//			page_wait(3000);
//			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
//			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",0));
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_positive_enter_valid_cred");
//		}
//	}
//	@Then("clicks on 'login'")
//	public static void click_login() throws Exception {
//		try {
//			click("login");
//			page_explicit_wait("home",13000);
//			value = driver.findElement(By.xpath(OR_reader("hamburger"))).isDisplayed();
//			Assert.assertEquals(true,value);
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_positive_click_login");
//		}
//	}
//
//	/*TC 006 - Validate that the user is navigated to 'Landing page' on clicking the 'Log out' option*/
//	@When("clicks on Logout")
//	public static void click_logout() throws Exception {
//		try {
//			page_wait(4000);
//			click("hamburger");
//			page_wait(1000);
//			click("logout");
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_positive_click_logout");
//		}
//	}
//	@Then("navigated to Landing page")
//	public static void navigate_landingpage() throws Exception {
//		try {
//			page_wait(6000);
//			value = driver.findElement(By.xpath(OR_reader("welcome_login"))).isDisplayed();
//			Assert.assertEquals(true,value);
//			page_wait(6000);
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_positive_navigate_landingpage");
//		}
//	}
//}