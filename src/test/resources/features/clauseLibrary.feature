Feature: ClauseLibrary
  @clause
  Scenario: Successful creation of clause
    Given user is already logged in
    When user clicks on clause library
    When clicks on the custom category
    When click on add category button
    When enter the category type
    Then click on create button
