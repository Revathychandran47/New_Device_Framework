package Stepdefinition;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Random;

public class Signup_negative_scenario extends Generic_functions {
	public String str;
	String phoneNo = random_number();
	AppiumDriver driver;

	/* TC_001 -Verify entering blank email , password and confirm password fields */
	@Given("Launch app and click on signup")
	public void launch_app() throws Exception {
		try {
			driver=app_launch();
			page_wait(4000);
			click("welcome_signup");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_launch_app");
		}
	}

	@When("Click on Signup button")
	public void click_on_signup() throws Exception {
		try {
			click("signUp");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_click_on_signup");
		}
	}

	@Then("Verify error message for blank email,password and confirm password")
	public void verify_blank_field_messages() throws Exception {
		try {
			str = driver.findElement(By.xpath(OR_reader("signup_emailid_blank_valid_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_email_blank_msg", 0));
			str = driver.findElement(By.xpath(OR_reader("signup_password_blank_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_password_blank_msg", 0));
			str = driver.findElement(By.xpath(OR_reader("signup_confirmPassword_blank_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_confirmPassword_blank_msg", 0));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_blank_field_messages");
		}
	}

	@And("Close Signup page")
	public void closeApp() {
		close();
	}

	/* TC_002 -Verify entering invalid 'Email ID' */
	@When("Enter invalid 'Email ID'")
	public void enter_invalid_email() throws Exception {
		try {
			click("signup_email_id");
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id", 0));
			click("signup_password");
			page_wait(3000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_invalid_email");
		}
	}

	@Then("Verify error message for invalid email")
	public void verify_invalid_email_message() throws Exception {
		try {
			str = driver.findElement(By.xpath(OR_reader("signup_invalid_emailid_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_invalid_emailid_msg", 0));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_invalid_email_message");
		}
	}

	/* TC_003 -Verify entering password less than 8 characters */
	@When("Enter password less than 8 characters")
	public void enter_password_lessThan_8_characters() throws Exception {
		try {
			click("signup_password");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password", 0));
			click("signup_confirm_password");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_password_lessThan_8_characters");
		}
	}

	@Then("Verify password less than 8 characters message")
	public void verify_password_lessThan_8_character_message() throws Exception {
		try {
			str = driver.findElement(By.xpath(OR_reader("signup_password_invalidLength_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_password_invalidLength_msg", 0));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_password_lessThan_8_character_message");
		}
	}

	//TC_004 - Verify entering invalid characters in password field
	@When("Enter invalid characters in password field")
	public void enter_invalidCharacters_in_passwordField() throws Exception {
		try {
			click("signup_password");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password", 1));
			click("signup_confirm_password");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_invalidCharacters_in_passwordField");
		}
	}

	@Then("Verify error message for invalid characters on password field")
	public void verify_invalidCharacters_message() throws Exception {
		try {
			str = driver.findElement(By.xpath(OR_reader("signup_password_invalid_msg"))).getText();
			String text = td_reader("signup_password_invalid_msg", 0)+","+ td_reader("signup_password_invalid_msg", 1);
			Assert.assertEquals(str,text);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_invalidCharacters_message");
		}
	}

	/*TC_005 -Verify entering different data in 'Password' and 'Confirm Password' */
	@When("Enter password and confirm password data differently")
	public void enter_different_password() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id", 1));
			click("signup_password");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password", 2));
			click("signup_confirm_password");
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password", 0));
			page_wait(3000);
			click("signUp");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_different_password");
		}
	}

	@Then("Verify error message for different password and confirm password")
	public void verify_incorrectRepassword_message() throws Exception {
		try {
			str = driver.findElement(By.xpath(OR_reader("signup_password_invalidMatch_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_password_invalidMatch_msg", 0));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_incorrectRepassword_message");
		}
	}

	//TC_006 - Verify entering already registered email id for new signup
	@When("Enter already registered emailId")
	public void enter_already_registered_emailId() throws Exception {
		try {
			click("signup_email_id");
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id", 1));
			click("signup_password");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password", 2));
			click("signup_confirm_password");
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password", 1));
			click("signUp");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_already_registered_emailId");
		}
	}

	@Then("Verify error message for existing email")
	public void verify_existing_email_message() throws Exception {
		try {
			str = driver.findElement(By.xpath(OR_reader("signup_emailExists_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_emailExists_msg", 0));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_existing_email_message");
		}
	}

	//TC_007 - Verify entering blank firstname,lastname,phone number and T&C and Privacy policy checkbox
	// To move to Create Account page
	@When("On Create account page")
	public void on_createAccount_page() throws Exception {
		try {
			// To generate random mail id
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(100);

			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys("Test0" + randomInt + "@Mph.com");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password", 2));
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password", 1));
			click("signUp");
			pageWait_until_visibilityOfElement("First Name",3000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_on_createAccount_page");
		}
	}

	@Then("Click on Create Account button")
	public void click_on_createAccount_button() throws Exception {
		try {
			click("signup_createAccount");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_click_on_createAccount_button");
		}
	}

	@And("Verify error message for blank fields")
	public void verify_errorMessage() throws Exception {
		try {
			str = driver.findElement(By.xpath(OR_reader("signup_firstname_blank_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_firstname_blank_msg", 0));
			str = driver.findElement(By.xpath(OR_reader("signup_lastname_blank_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_lastname_blank_msg", 0));
			str = driver.findElement(By.xpath(OR_reader("signup_phoneNumber_blank_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_phoneNumber_blank_msg", 0));
			str = driver.findElement(By.xpath(OR_reader("signup_T&C_Privacy_blank_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_T&C_Privacy_blank_msg", 0));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_errorMessage");
		}
	}

	//TC_008 - Verify entering invalid firstname,lastname, phone number and Referral/Promo code fields
	@When("Enter invalid Firstname,Lastname,phone and Referral code")
	public void enter_invalid_firstName_lastName_Phnum() throws Exception {
		try {
			click("signup_firstName");
			driver.findElement(By.xpath(OR_reader("signup_firstName"))).sendKeys(td_reader("signup_first_name", 0));
			click("signup_lastName");
			driver.findElement(By.xpath(OR_reader("signup_lastName"))).sendKeys(td_reader("signup_last_name", 0));
			click("signup_phone_number");
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number", 0));
			scrollAndClick("Enter referral/promo code");
			driver.findElement(By.xpath(OR_reader("signup_referral_promo_code"))).sendKeys(td_reader("signup_referral_code", 0));
			scrollAndClick("Create Account");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_invalid_firstName_lastName_Phnum");
		}
	}

	@Then("Verify error message for invalid values")
	public void verify_invalid_fields_message() throws Exception {
		try {
			str = driver.findElement(By.xpath(OR_reader("signup_firstname_invalid_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_firstname_invalid_msg", 0));
			str = driver.findElement(By.xpath(OR_reader("signup_lastname_invalid_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_lastname_invalid_msg", 0));
			str = driver.findElement(By.xpath(OR_reader("signup_phoneNumber_invalid_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_phoneNumber_invalid_msg", 0));
			str = driver.findElement(By.xpath(OR_reader("signup_referralPromoCode_invalid_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_referralPromoCode_invalid_msg", 0));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_invalid_fields_message");
		}
	}

	@And("Enter characters in phone number field and enter invalid promo code")
	public void enter_characters_in_phoneNumberField_and_enter_invalid_promoCode() throws Exception {
		try{
			field_clear("signup_phone_number");
			click("signup_phone_number");
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number", 1));
			scrollAndClick(td_reader("signup_referral_code", 0));
			field_clear("signup_referral_promo_code");
			driver.findElement(By.xpath(OR_reader("signup_referral_promo_code"))).sendKeys(td_reader("signup_promo_code", 0));
			scrollAndClick("Create Account");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_characters_in_phoneNumberField_and_enter_invalid_promoCode");
		}
	}

	@And("Verify error message for invalid phonenumber and promocode")
	public void verify_error_message_for_invalid_phNum_and_promoCode() throws Exception {
		try{
			str = driver.findElement(By.xpath(OR_reader("signup_phoneNumber_invalid_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_phoneNumber_invalid_msg", 0));
			str = driver.findElement(By.xpath(OR_reader("signup_referralPromoCode_invalid_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_referralPromoCode_invalid_msg", 0));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_error_message_for_invalid_phNum_and_promoCode");
		}
	}

	//TC_009 - Verify entering already registered phone number for new signup
	@Then("Enter already registered phone number")
	public void enter_alreadyRegistered_phoneNumber() throws Exception {
		try {
			click("signup_firstName");
			driver.findElement(By.xpath(OR_reader("signup_firstName"))).sendKeys(td_reader("signup_first_name", 1));
			click("signup_lastName");
			driver.findElement(By.xpath(OR_reader("signup_lastName"))).sendKeys(td_reader("signup_last_name", 1));
			click("signup_phone_number");
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number", 2));
			scrollAndClick("Terms of Service");
			click("signup_terms_and_conditions");
			click("signup_createAccount");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_invalid_fields_message");
		}
	}

	@And("Verify error message for existing phone number")
	public void verify_existing_phno_message() throws Exception {
		try {
			str = driver.findElement(By.xpath(OR_reader("signup_phoneNumExists_msg"))).getText();
			Assert.assertEquals(str, td_reader("signup_phoneNumExists_msg", 0));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_invalid_fields_message");
		}
	}

	//TC_010 - Verify entering blank OTP
	@Then("On OTP page")
	public void on_OTPPage() throws Exception {
		try{
			click("signup_firstName");
			driver.findElement(By.xpath(OR_reader("signup_firstName"))).sendKeys(td_reader("signup_first_name", 1));
			click("signup_lastName");
			driver.findElement(By.xpath(OR_reader("signup_lastName"))).sendKeys(td_reader("signup_last_name", 1));
			click("signup_phone_number");
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(phoneNo);
			scrollAndClick("Terms of Service");
			click("signup_terms_and_conditions");
			click("signup_createAccount");
			page_wait(9000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_on_OTPPage");
		}
	}

	@And("Click on Verify button")
	public void click_on_verify_button() throws Exception {
		try{
			pageWait_until_visibilityOfElement("Verify",4000);
			click("otp_verify_button");
			page_wait(3000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_click_on_verify_button");
		}
	}

	@And("Verify error message for blank OTP")
	public void verify_error_message_for_blank_OTP() throws Exception {
		try{
			str = driver.findElement(By.xpath(OR_reader("otp_invalid_msg"))).getText();
			String text= td_reader("otp_invalid_msg", 0)+","+ td_reader("otp_invalid_msg", 1);
			Assert.assertEquals(str, text);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_error_message_for_blank_OTP");
		}
	}

	//TC_011 - Verify entering incorrect OTP
	@And("Enter incorrect OTP")
	public void enter_incorrect_OTP() throws Exception {
		try{
           click("otp_1");
		   driver.findElement(By.xpath(OR_reader("otp_1"))).sendKeys(td_reader("otp_1",1));
		   click("otp_2");
		   driver.findElement(By.xpath(OR_reader("otp_2"))).sendKeys(td_reader("otp_2",1));
		   click("otp_3");
		   driver.findElement(By.xpath(OR_reader("otp_3"))).sendKeys(td_reader("otp_3",1));
		   click("otp_4");
		   driver.findElement(By.xpath(OR_reader("otp_4"))).sendKeys(td_reader("otp_4",1));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_incorrect_OTP");
		}
	}

	@And("Verify error message for incorrect OTP")
	public void verify_error_message_for_incorrectOTP() throws Exception {
		try{
			str = driver.findElement(By.xpath(OR_reader("otp_invalid_msg"))).getText();
			String text= td_reader("otp_invalid_msg", 0)+","+ td_reader("otp_invalid_msg", 1);
			Assert.assertEquals(str, text);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_verify_error_message_for_incorrectOTP");
		}
	}


}