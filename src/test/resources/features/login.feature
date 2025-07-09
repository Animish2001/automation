@sanity @regression
Feature: Login
  @login1
  Scenario: Successful Login with Valid Credentials
    #Step1
    Given user is on the Login page
    #Step2
    When user enters valid username and password
    #Step3
    And clicks on the login button
    #Step4
    Then user is navigated to the home page

  @login
  Scenario: Unsuccessful Login with Invalid Credentials
    #Step1
    Given user is on the Login page
    #Step2
    When user enters invalid username and password
    #Step3
    And clicks on the login button
    #Step4
    Then user should see an error message