Feature: Create Contract
  @create_contract
  Scenario: Successful creation of contract
    Given user is already logged in contractzy application
    And clicks on create contract
    And clicks on pdf
#    And clicks on create new
    When Enters all the details and clicks on the create button
    Then Add signatory
    And performs drag and drop on party element
    And  places signature,clicks on the sent for signature button
    Given user sends an email
#    Then Gmail should be opened in Edge browser
#    Then contract should be sent for signature successfully