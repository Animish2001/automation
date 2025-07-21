Feature: AI module
  @ai_feature
  Scenario: Successful creation of ai guidebooks
    Given user is already logged in
    When the user navigates to the AI module
    Then the guidebook list should be displayed
    And the columns "Name" and "Created On" should be visible