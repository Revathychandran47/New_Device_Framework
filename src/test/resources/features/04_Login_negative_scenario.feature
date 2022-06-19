Feature: Validate login negative functionality

  #User must click on the login and validate validation messages should be displayed
  Scenario: Validate that the user is not allowed to login when Phone number and Password fields are blank
    Given launch URL
    When clicks on login button

  Scenario: Validate that the user should get a validation message on entering invalid credentials in the 'Login' Page
    When enters invalid phone no and password
    Then validation message is displayed 

  Scenario: Validate that the user is not allowed to login with invalid 'Phone number' and valid 'Password'
    When enters invalid phone no and valid password
    Then validation message is displayed

  Scenario: Validate that the user is not allowed to login with invalid Password and valid phone number
    When enters invalid password and valid phone no
    Then validation message is displayed
    
