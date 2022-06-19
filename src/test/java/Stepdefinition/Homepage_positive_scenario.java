//package Stepdefinition;
//
//import java.util.List;
//
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import Reusable_Functions.Generic_functions;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Homepage_positive_scenario extends Generic_functions {
//	public static boolean value,value1,str,str1;
//	WebElement ele;
//	public static String ere,text;
//	public static List<WebElement> grid_elements;
//
//	/*TC_001 -Validate that the user is able to Login with valid data*/
//	@Given("Launch the app")
//	public static void launch_application() {
//		try {
//			app_launch();
//			page_wait(4000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@When("Enter valid phonenumber, password and cliks on login button")
//    public static void enter_usename_password() throws Exception {
//		page_wait(8000);
//		login(0,0);
//	}
//
//	@Then("validate homepage")
//	public static void validate_homepage() throws Exception {
//		try {
//			page_explicit_wait("home",20000);
//			value = driver.findElement(By.xpath(OR_reader("hamburger"))).isDisplayed();
//			Assert.assertEquals(true, value);
//		}catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("home_positive_verify_WelcomePage");
//		}
//	}
//
//	/*TC_002 - Validate that the user is navigated to  the Home page and User should be able to click on all the grid tiles */
//	@When("clicks on all the grid tiles")
//	public static void click_all_tiles() throws Exception, InterruptedException {
//		try {
//			//workaround is clicking on buy coverage(buy coverage tile not working)
//    		page_wait(23000);
//    		click("homepage_first_tile");
//			page_wait(5000);
//			grid_tile();
//			page_wait(8000);
//			click("homepage_second_tile");
//			page_wait(5000);
//			grid_tile();
//			page_wait(8000);
//			click("homepage_third_tile");
//			page_wait(5000);
//			grid_tile();
//			page_wait(8000);
//		}catch(Exception e) {
//			e.printStackTrace();
//			takeScreenShot("home_positive_click_all_tiles");
//		}
//	}
//
//	/*TC_003 -Validate that the user is navigated to the Second Opinion page on clicking 'Request for second opinion' button*/
//	@When("clicks on the 'Request for second opinion' button")
//	public static void click_request_second_opinion() throws InterruptedException, Exception {
//		try {
//			page_wait(9000);
//			click("homepage_request_second_opinion_tab");
//			page_wait(1000);
//		}catch(Exception e) {
//			e.printStackTrace();
//			takeScreenShot("home_positive_click_request_second_opinion");
//		}
//	}
//
//	@Then("navigated to the Second opinion page")
//	public static void navigate_second_opinion_page() throws Exception {
//		try {
//			text= driver.findElement(By.xpath(OR_reader("request_second_opinion_title"))).getText();
//			Assert.assertEquals(text,td_reader("request_second_opinion_title"));
//			page_wait(1500);
//			click("home");
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("home_positive_navigate_second_opinion_page");
//		}
//	}
//
//	/*TC_004-Validate that the user is navigated to the  Refer a friend page on clicking 'Refer a friend' button*/
//	@When("clicks on 'Refer a friend' button")
//	public static void click_refer_friend() throws InterruptedException, Exception {
//		try {
//			page_wait(25000);
//			click("homepage_refer_a_friend_tab");
//			page_wait(1500);
//		}catch(Exception e) {
//			e.printStackTrace();
//			takeScreenShot("home_positive_click_refer_friend");
//		}
//	}
//	@Then("navigated to the Refer a friend page")
//	public static void navigated_refer_friend_page() throws Exception {
//		try {
//			text= driver.findElement(By.xpath(OR_reader("refer_a_friend_title"))).getText();
//			Assert.assertEquals(text,td_reader("refer_a_friend_title"));
//			page_wait(3000);
//			click("home");
//			page_explicit_wait("home", 20000);
//			click("hamburger");
//			click("logout");
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("home_positive_navigated_refer_friend_page");
//		}
//	}
//}