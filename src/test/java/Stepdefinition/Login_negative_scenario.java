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
//public class Login_negative_scenario extends Generic_functions{
//	public static String str;
//	public static String valid_msg;
//
//	/* TC_001 - Validate that the user is not allowed to login when Phone number and Password fields are blank */
//	@Given("launch URL")
//	public static void browser_launching() throws Exception {
//		app_launch();
//		page_wait(2000);
//	}
//	@When("clicks on login button")
//	public static void click_login() throws Exception {
//		try {
//			if (platformName.equals("iOS")) {
//				page_wait(2000);
//				click("welcome_login");
//				click("continue");
//				page_wait(5000);
//			}
//			else if (platformName.equals("Android")) {
//				page_wait(2000);
//				click("welcome_login");
//				page_wait(5000);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_negative_click_login");
//		}
//	}
//
//	/* TC_002 - Validate that the user should get a validation message on entering invalid credentials in the 'Login' Page */
//	@When("enters invalid phone no and password")
//	public static void enter_invalid_phoneno_and_password() throws Exception {
//		try {
//			page_wait(5000);
//			click("login_phone_number");
//			page_wait(2000);
//			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
//			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",1));
//			click("login");
//		}catch(Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_negative_enter_invalid_phoneno_and_password");
//		}
//	}
//	@Then("validation message is displayed")
//	public static void validation_msg() throws Exception {
//		try {
//			page_wait(5000);
//			str= driver.findElement(By.xpath(OR_reader("login_invalid_msg"))).getText();
//			Assert.assertEquals(str,td_reader("login_invalid_msg"));
//			page_wait(5000);
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_negative_validation_msg");
//		}
//	}
//
//	/*TC_004 - Validate that the user is not allowed to login with invalid 'Phone number' and valid 'Password' */
//	@When("enters invalid phone no and valid password")
//	public static void enter_invalid_phoneno_valid_password() throws Exception {
//		try {
//			page_wait(3000);
//			click("login_phone_number");
//			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",2));
//			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",1));
//			page_wait(1000);
//			click("login");
//		}catch(Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_negative_enter_invalid_phoneno_valid_password");
//		}
//	}
//
//	/*TC_005 - Validate that the user is not allowed to login with invalid Password and valid phone number */
//	@When("enters invalid password and valid phone no")
//	public static void enter_invalid_password() throws InterruptedException, Exception {
//		try {
//			page_wait(5000);
//			click("login_phone_number");
//			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
//			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",2));
//			page_wait(1000);
//			click("login");
//		}catch(Exception e) {
//			e.printStackTrace();
//			takeScreenShot("login_negative_enter_invalid_password");
//		}
//	}
//}
