Feature: AI module
  @ai_feature
  Scenario: Verify AI module loads and displays list of guidebooks
    When the user navigates to the AI module
    Then the guidebook list should be displayed
    And the columns "Name" and "Created On" should be visible