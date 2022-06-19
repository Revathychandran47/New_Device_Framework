Feature: Validation on Home Page
  #User must click on the login and nagivated to home page
    
  Scenario: Validate that the user is able to Login with valid data
  	Given Launch the app
    When Enter valid phonenumber, password and cliks on login button
    Then validate homepage
    
  Scenario: Validate that the user is in Home page
    When clicks on all the grid tiles
    
 Scenario: Validate that the user is navigated to the Second Opinion page on clicking 'Request for second opinion' button
    When clicks on the 'Request for second opinion' button
    Then navigated to the Second opinion page
    
  Scenario: Validate that the user is navigated to the  Refer a friend page on clicking 'Refer a friend' button
    When clicks on 'Refer a friend' button
    Then navigated to the Refer a friend page