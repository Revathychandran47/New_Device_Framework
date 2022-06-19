Feature: Validation on Landing page

  #User is navigated to Welcome,Login,Sign Up page
  Scenario: Validate Landing page UI
    Given Launch the app
    When Verify Landing page UI
    Then Close Landing page

  Scenario: Validate user is able to click on 'Sign Up' button and navigate to Sign Up page
    Given Launch the app
    When Click on 'Sign Up' button
    Then Verify Sign up page
    And Close Landing page
    
Scenario: Validate user is able to click on 'Login' button and navigate to Login page
    Given Launch the app
    When Click on 'Login' button
    Then Verify Login page
    And Close Landing page