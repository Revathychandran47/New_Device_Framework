Feature: Validation on Sign Up Page negative test case

  #User should get validation messages on entering invalid Signup credentials

  Scenario: Verify entering invalid firstname,lastname, phone number and Referral/Promo code fields
    Given Launch app and click on signup
    When On Create account page
    Then Enter invalid Firstname,Lastname,phone and Referral code
    And Verify error message for invalid values
    And Enter characters in phone number field and enter invalid promo code
    And Verify error message for invalid phonenumber and promocode
    And Close Signup page




