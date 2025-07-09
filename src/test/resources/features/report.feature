Feature: Report Management
  @report
  Scenario: To generate the document reports using various filters
    Given user logged in
    And clicks on the reports
    And clicks on custom reports
    And enters a report name
    And selects the type of report
    And selects filters
    And clicks on the 'Generate contract report' button
    And clicks on CRM
    #Then a report should be get generated
