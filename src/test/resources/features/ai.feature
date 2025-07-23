Feature: AI module
  @ai_feature
  Scenario: Successful creation of ai guidebooks
    Given user is already logged in site
    When the user navigates to the AI module
#    Then the guidebook list should be displayed
#    And the columns "Name" and "Created On" should be visible
    Then clicks on dropdown
    Then clicks on Create New
    Then clicks on guide title
    Then clicks on agreement type