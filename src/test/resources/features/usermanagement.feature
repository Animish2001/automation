Feature: User Management
  @user_management
  Scenario: To add/manage user access
    Given user logged in for the application
    And clicks on the user_management
    And enters full name, email address, phone no.,department, designation, user group, region
    And set user privilege
    Then clicks on create button