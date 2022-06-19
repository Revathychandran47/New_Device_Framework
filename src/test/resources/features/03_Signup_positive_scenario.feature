Feature: Validation on Sign Up Positive test cases

  #User must be able to Signup with valid credentials
  Scenario: Verify the Signup without promo/referral code with UI validations
    Given Launch the URL and click on signup
    When Verify create account page UI
    Then Verify the help texts on text fields
    And Enter create account page details
    And Click on the unmask icon
    And Text should be displayed in the password field
    And Click on sign up button
    And Verify user details page UI
    And Enter user details
    And Click on Terms of service
    And View a pop up box with Terms of service
    And Click on Privacy policy
    And View a pop up box with Privacy policy
    And Verify Check box is unchecked
    And Verify that Create Account is disabled
    And Click on Check box
    And Click on create account button
    And Verify OTP page UI
    And Edit Phone Number
    And Click Cancel
    And Enter OTP
    And Verify account creation
    And Login with newly registered number
    And Close Signup Page


  Scenario: Verify the Signup without promo/referral code and edit phone number
    Given Launch the URL and click on signup
    When Verify create account page UI
    Then Enter create account page details
    And Click on sign up button
    And Enter user details
    And Click on Check box
    And Click on create account button
    # Verify OTP page resend OTP message
    And Edit Phone Number
    And Enter new phone number
    And Click Save
    And Enter OTP
    And Verify account creation
    And Login with newly registered email
    And Close Signup Page

  Scenario: Verify Sign Up with valid promo code
    Given Launch the URL and click on signup
    When Enter create account page details
    Then Click on sign up button
    And Enter user details
    And Enter promo code
    And Click on Check box
    And Click on create account button
    And Enter OTP
    And Verify account creation
    And Login with the entered credentials
    And Verify award points are rewarded for promo code
    And Logout
    And Close Signup Page

  Scenario: Verify Sign Up with valid Referral code
    Given Launch the URL and click on signup
    When Enter create account page details
    Then Click on sign up button
    And Enter user details
    And Enter referral code
    And Click on Check box
    And Click on create account button
    And Enter OTP
    And Verify account creation
    And Login into the referrer account
    And Verify award points are rewarded for the referrer
    And Logout
    And Close Signup Page

  Scenario: Verify when OTP is not entered on sign up
    Given Launch the URL and click on signup
    When Enter create account page details
    Then Click on sign up button
    And Enter user details
    And Click on Check box
    And Click on create account button
    And Redirect to login page
    And Login with Newly registered number
    And Verify if OTP screen is displayed
    And Enter OTP details after login
    And Homepage screen is displayed
    And Logout
    And Close Signup Page

  Scenario: Verify login link on Signup page
    Given Launch the URL and click on signup
    When Click on the 'Login' link
    Then Verify navigation to the login page
    And Close Signup Page