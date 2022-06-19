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

public class Signup_positive_scenario extends Generic_functions{
    AppiumDriver driver;
    String email , phoneNo = random_number(),phoneNumber;

	/*TC_001 - Verify the Signup without promo/referral code with UI validations */
	@Given("Launch the URL and click on signup")
	public  void launch_app() throws Exception {
		try {
			driver= app_launch();
			page_wait(3000);
			click("welcome_signup");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_launch_app");
		}
	}
    @When("Verify create account page UI")
    public void verify_createAccountPage_UI() throws Exception {
        try {
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_welcome_title"))).getText(),td_reader("signup_welcome_title",0));
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_page_title"))).getText(),td_reader("signup_page_title",0));
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("signup_email_id"))).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("signup_password"))).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("signUp"))).isDisplayed());
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_haveAnAccount_text"))).getText(),td_reader("signup_haveAnAccount_Text",0));
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("login_link"))).isDisplayed());
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_verify_createAccountPage_UI");
        }
    }
    @Then("Verify the help texts on text fields")
    public void verify_helpTexts_on_text_fields() throws Exception {
        try {
          Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_email_id"))).getText(),td_reader("signup_emailId_helpText",0));
          Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_password"))).getText(),td_reader("signup_password_helpText",0));
          Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).getText(),td_reader("signup_confirmPassword_helpText",0));
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_verify_helpTexts_on_text_fields");
        }
    }
    @And("Enter create account page details")
    public void enter_createAccountPage_details() throws Exception {
        try {
            // To generate random mail id
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100);

            driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys("Test0" + randomInt + "@mph.com");
            driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password", 2));
            driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password", 1));
            email=driver.findElement(By.xpath(OR_reader("signup_email_id"))).getText();
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_enter_createAccountPage_details");
        }
    }
    @And("Click on the unmask icon")
    public void click_on_unmask_Icon() throws Exception {
        try {
            click("signup_show_password");
            click("signup_show_confirmPassword");
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_click_on_unmask_Icon");
        }
    }
    @And("Text should be displayed in the password field")
    public void text_should_be_displayed_in_passwordField() throws Exception {
        try {
           Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_password"))).getText(),td_reader("signup_password", 2));
           Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).getText(),td_reader("signup_confirm_password", 1));
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_text_should_be_displayed_in_passwordField");
        }
    }

    @And("Click on sign up button")
    public void click_on_signUp_button() throws Exception {
        try{
            click("signUp");
            pageWait_until_visibilityOfElement("First Name",5000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_click_on_signUp_button");
        }
    }

    @And("Verify user details page UI")
    public void verify_userDetailsPage_UI() throws Exception {
        try{
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_userDetailsPage_title"))).getText(),td_reader("signup_userDetailsPage_title",0));
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("signup_firstName"))).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("signup_lastName"))).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("signup_phone_number"))).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("signup_referral_promo_code"))).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("signup_createAccount"))).isDisplayed());
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_byCreatingAn_text"))).getText(),td_reader("signup_byCreatingAn_text",0));
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("signup_termsOfService_link"))).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("signup_privacyPolicy_link"))).isDisplayed());
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_verify_userDetailsPage_UI");
        }
    }

    @And("Enter user details")
    public void enter_userDetails() throws Exception {
        try{
            click("signup_firstName");
            driver.findElement(By.xpath(OR_reader("signup_firstName"))).sendKeys(td_reader("signup_first_name", 1));
            click("signup_lastName");
            driver.findElement(By.xpath(OR_reader("signup_lastName"))).sendKeys(td_reader("signup_last_name", 1));
            click("signup_phone_number");
            driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(phoneNo);
            phoneNumber  = driver.findElement(By.xpath(OR_reader("signup_phone_number"))).getText();
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_enter_userDetails");
        }
    }

    @And("Click on Terms of service")
    public void click_on_TermsOfService() throws Exception {
        try{
            scrollAndClick("Terms of Service");
            click("signup_termsOfService_link");
            page_wait(2000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_click_on_TermsOfService");
        }
    }

    @And("View a pop up box with Terms of service")
    public void view_popUp_with_TermsOfService() throws Exception {
        try{
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_T&C_title"))).getText(),td_reader("signup_T&C_title",0));
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("IAgree_button"))).isDisplayed());
            click("IAgree_button");
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_view_popUp_with_TermsOfService");
        }
    }

    @And("Click on Privacy policy")
    public void click_on_PrivacyPolicy() throws Exception {
        try{
            click("signup_privacyPolicy_link");
            page_wait(2000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_click_on_PrivacyPolicy");
        }
    }

    @And("View a pop up box with Privacy policy")
    public void view_popUp_with_PrivacyPolicy() throws Exception {
        try{
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_PP_title"))).getText(),td_reader("signup_PP_title",0));
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("IAgree_button"))).isDisplayed());
            click("IAgree_button");
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_view_popUp_with_PrivacyPolicy");
        }
    }

    @And("Verify Check box is unchecked")
    public void verify_checkBox_is_unchecked() throws Exception {
        try{
            Assert.assertFalse(driver.findElement(By.xpath(OR_reader("signup_terms_and_conditions"))).isSelected());
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_verify_checkBox_is_unchecked");
        }
    }

    @And("Verify that Create Account is disabled")
    public void verify_createAccount_is_Disabled() throws Exception {
        try{
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("signup_createAccount"))).isEnabled());
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_verify_createAccount_is_Disabled");
        }
    }

    @And("Click on Check box")
    public void click_on_checkBox() throws Exception {
        try{
            scrollAndClick("Terms of Service");
            click("signup_terms_and_conditions");
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_click_on_checkBox");
        }
    }

    @And("Click on create account button")
    public void click_on_createAccount_button() throws Exception {
        try{
            click("signup_createAccount");
            page_wait(9000);
            pageWait_until_visibilityOfElement("Verify",4000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_click_on_createAccount_button");
        }
    }

    @And("Verify OTP page UI")
    public void verify_OTPPage_UI() throws Exception {
        try{
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("otp_page_title"))).getText(),td_reader("otp_page_title",0));
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("otp_enterThe4_text"))).getText(),td_reader("otp_enterThe4_text",0));
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("otp_phoneNumber"))).getText(),phoneNumber);
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("otp_1"))).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("otp_2"))).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("otp_3"))).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("otp_4"))).isDisplayed());
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("otp_didntReceiveIt_text"))).getText(),td_reader("otp_didntReceiveIt_text",0));
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("otp_verify_button"))).isDisplayed());
            page_wait(60000);
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("otp_resendCode"))).isDisplayed());
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_verify_OTPPage_UI");
        }
    }

    @And("Edit Phone Number")
    public void edit_phoneNumber() throws Exception {
        try{
            click("otp_editPhoneNumber");
            page_wait(1000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_edit_phoneNumber");
        }
    }

    @And("Click Cancel")
    public void click_Cancel() throws Exception {
        try{
            click("otp_editPhoneNumber_cancel");
            page_wait(2000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_click_Cancel");
        }
    }

    @And("Enter OTP")
    public void enter_OTP() throws Exception {
        try{
            click("otp_1");
            driver.findElement(By.xpath(OR_reader("otp_1"))).sendKeys(td_reader("otp_1",0));
            click("otp_2");
            driver.findElement(By.xpath(OR_reader("otp_2"))).sendKeys(td_reader("otp_2",0));
            click("otp_3");
            driver.findElement(By.xpath(OR_reader("otp_3"))).sendKeys(td_reader("otp_3",0));
            click("otp_4");
            driver.findElement(By.xpath(OR_reader("otp_4"))).sendKeys(td_reader("otp_4",0));
            click("otp_verify_button");
            page_wait(20000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_enter_OTP");
        }
    }

    @And("Verify account creation")
    public void verify_account_creation() throws Exception {
        try{
            pageWait_until_visibilityOfElement("Log In",7000);
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("welcome_login"))).isDisplayed());
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_verify_account_creation");
        }
    }

    @And("Login with newly registered number")
    public void login_with_newly_registered_number() throws Exception {
        try{
            click("welcome_login");
            page_wait(35000);
            driver.findElement(By.xpath(OR_reader("login_username"))).sendKeys(phoneNumber);
            driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("signup_confirm_password", 1));
            click("login");
            page_wait(9000);
            pageWait_until_visibilityOfElement("Skip",15000);
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("home_congratulations_text"))).getText(),td_reader("home_congratulations_text",0));
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_login_with_newly_registered_number");
        }
    }
    @And("Logout")
    public void Logout() throws Exception {
        try{
            logout();
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_logout");
        }
    }

    @And("Close Signup Page")
    public void closeSignupPage() {
        driver.quit();
    }


    //TC_002 - Verify the Signup without promo/referral code and edit phone number
    @And("Enter new phone number")
    public void enter_new_phoneNumber() throws Exception {
        try{
            click("edit_phoneNumber");
            field_clear("edit_phoneNumber");
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("edit_wellSendAOTP_text"))).getText(),td_reader("edit_wellSendAOTP_text",0));
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("edit_phoneNumber_Save"))).isDisplayed());
            String new_phoneNumber= random_number();
            driver.findElement(By.xpath(OR_reader("edit_phoneNumber"))).sendKeys(new_phoneNumber);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_enter_new_phoneNumber");
        }
    }

    @And("Click Save")
    public void click_Save() throws Exception {
        try{
            click("edit_phoneNumber_Save");
            pageWait_until_visibilityOfElement(td_reader("otp_page_title",0),5000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_click_Save");
        }
    }

    @And("Login with newly registered email")
    public void login_with_newlyRegistered_email() throws Exception {
        try{
            click("welcome_login");
            page_wait(35000);
            driver.findElement(By.xpath(OR_reader("login_username"))).sendKeys(email);
            driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("signup_confirm_password", 1));
            click("login");
            page_wait(9000);
            pageWait_until_visibilityOfElement("Skip",15000);
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("home_congratulations_text"))).getText(),td_reader("home_congratulations_text",0));
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_login_with_newlyRegistered_email");
        }
    }

    //TC_003 - Verify Sign Up with valid promo code
    @And("Enter promo code")
    public void enter_promoCode() throws Exception {
        try{
            scrollAndClick("Enter referral/promo code");
            driver.findElement(By.xpath(OR_reader("signup_referral_promoCode"))).sendKeys(td_reader("signup_promo_code",1));
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_enter_promoCode");
        }
    }

    @And("Login with the entered credentials")
    public void login_with_entered_credentials() throws Exception {
        try{
            click("welcome_login");
            page_wait(50000);
            driver.findElement(By.xpath(OR_reader("login_username"))).sendKeys(email);
            driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("signup_confirm_password", 1));
            click("login");
            page_wait(10000);
            pageWait_until_visibilityOfElement("Skip",15000);
            click("home_skip_button");
            page_wait(5000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_login_with_entered_credentials");
        }
    }
    @And("Verify award points are rewarded for promo code")
    public void verify_awardPoints_are_rewarded_for_PromoCode() throws Exception {
        try{
            click("home_awardPoints_tile");
            page_wait(4000);
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("awardPoints_youEarned_text"))).getText(),td_reader("awardPoints_youEarned_text",0));
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("awardPoints_value"))).getText(),td_reader("awardPoints_value",0));
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("awardPoints_usedMedi001_text"))).getText(),td_reader("awardPoints_usedMedi001_text",0));
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_verify_awardPoints_are_rewarded_for_PromoCode");
        }
    }

    //TC_004 - Verify Sign Up with valid Referral code
    @And("Enter referral code")
    public void enter_referralCode() throws Exception {
        try{
            scrollAndClick("Enter referral/promo code");
            driver.findElement(By.xpath(OR_reader("signup_referral_promoCode"))).sendKeys(td_reader("signup_referral_code",1));
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_enter_referralCode");
        }
    }

    @And("Login into the referrer account")
    public void login_into_referrer_account() throws Exception {
        try{
            click("welcome_login");
            page_wait(50000);
            driver.findElement(By.xpath(OR_reader("login_username"))).sendKeys(td_reader("login_username",0));
            driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password", 0));
            click("login");
            page_wait(30000);
            pageWait_until_visibilityOfElement("Hello Rev!",10000);
            click("home_awardPoints_tile");
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_login_into_referrer_account");
        }
    }
    @And("Verify award points are rewarded for the referrer")
    public void verify_awardPoints_are_rewarded_for_referrer() throws Exception {
        try{
            page_wait(4000);
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("awardPoints_youEarned_text"))).getText(),td_reader("awardPoints_youEarned_text",0));
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("awardPoints_value"))).getText(),td_reader("awardPoints_value",0));
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("awardPoints_someoneUsed_text"))).getText(),td_reader("awardPoints_someoneUsed_text",0));
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_verify_awardPoints_are_rewarded_for_referrer");
        }
    }

    //TC_005 - Verify when OTP is not entered on sign up
    @And("Redirect to login page")
    public void redirect_to_loginPage() throws Exception {
        try{
            click("otp_pageBack");
            page_wait(2000);
            click("signup_pageBack");
            page_wait(2000);
            click("signup_pageBack");
            page_wait(2000);
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("mph_image"))).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("mph_logo"))).isDisplayed());
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_redirect_to_loginPage");
        }
    }

    @And("Login with Newly registered number")
    public void login_with_Newly_registered_number() throws Exception {
        try{
            click("welcome_login");
            page_wait(35000);
            driver.findElement(By.xpath(OR_reader("login_username"))).sendKeys(phoneNumber);
            driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("signup_confirm_password", 1));
            click("login");
            page_wait(10000);
            pageWait_until_visibilityOfElement("Please Enter OTP",15000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_login_with_Newly_registered_number");
        }
    }

    @And("Verify if OTP screen is displayed")
    public void verify_if_OTP_screen_isDisplayed() throws Exception {
        try{
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("otp_page_title"))).getText(),td_reader("otp_page_title",0));
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("otp_enterThe4_text"))).getText(),td_reader("otp_enterThe4_text",0));
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("otp_phoneNumber"))).getText(),phoneNumber);
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("otp_didntReceiveIt_text"))).getText(),td_reader("otp_didntReceiveIt_text",0));
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("otp_verify_button"))).isDisplayed());
            page_wait(60000);
            Assert.assertTrue(driver.findElement(By.xpath(OR_reader("otp_resendCode"))).isDisplayed());
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_verify_if_OTP_screen_isDisplayed");
        }
    }

    @And("Enter OTP details after login")
    public void enter_OTP_details_after_login() throws Exception {
        try{
            click("otp_1");
            driver.findElement(By.xpath(OR_reader("otp_1"))).sendKeys(td_reader("otp_1",0));
            click("otp_2");
            driver.findElement(By.xpath(OR_reader("otp_2"))).sendKeys(td_reader("otp_2",0));
            click("otp_3");
            driver.findElement(By.xpath(OR_reader("otp_3"))).sendKeys(td_reader("otp_3",0));
            click("otp_4");
            driver.findElement(By.xpath(OR_reader("otp_4"))).sendKeys(td_reader("otp_4",0));
            click("otp_verify_button");
            page_wait(20000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_enter_OTP_details_after_login");
        }
    }

    @And("Homepage screen is displayed")
    public void homepage_screen_isDisplayed() throws Exception {
        try{
            pageWait_until_visibilityOfElement("Skip",15000);
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("home_congratulations_text"))).getText(),td_reader("home_congratulations_text",0));
            click("home_skip_button");
            page_wait(3000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_homepage_screen_isDisplayed");
        }
    }

    //TC_006 - Verify login link on Signup page
    @When("Click on the 'Login' link")
    public void click_on_loginLink() throws Exception {
        try{
            click("login_link");
            page_wait(35000);
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_click_on_loginLink");
        }
    }

    @Then("Verify navigation to the login page")
    public void verify_navigation_to_loginPage() throws Exception {
        try{
            Assert.assertEquals(driver.findElement(By.xpath(OR_reader("login_page_title"))).getText(),td_reader("login_page_title",0));
        }catch(Exception e) {
            e.printStackTrace();
            takeScreenShot("signup_positive_verify_navigation_to_loginPage");
        }
    }



}