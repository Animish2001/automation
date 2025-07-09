Feature: Legacy Contract
  @legacy_contract
  Scenario: Successful upload of legacy contracts
  Given user logged in the app
  And clicks on the legacy contract
  And clicks on single upload
  And enters the details, clicks on the upload button
#  Then user should be able to upload a contract successfully