Feature: Validate login positive functionality

  #User must click on the login and navigated to Home page
  Scenario: Validate that the 'Phone number' field is prefixed with +1 country code
    Given Launch the URL
    When Clicks on 'Login' button
    Then check  the  'Phone number' field is prefixed with country code

  Scenario: Validate that the user is able to click on the 'Forgot password?' link
    When clicks on 'Forgot password'
    Then navigated to Forgot password page

  Scenario: Validate that the user is able click on the 'Sign up' link
    When clicks on 'Sign up'
    Then navigated to Sign up page

  Scenario: Validate that the user is able to enter  the password in the 'Password' field
    Then enters the Password

  Scenario: Validate that the user is able to Login
    When enters valid phonenumber and password
    Then clicks on 'login'

  Scenario: Validate that the user is navigated to Landing page on clicking the Log out option
    When clicks on Logout
    Then navigated to Landing page
