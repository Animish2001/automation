Feature: Estamp_Upload
  @estampUpload
  Scenario: Successful uploading of e-stamp paper
    Given user is already logged in the application
    When user clicks on E-Stamping and upload stamp paper option
    When user enters the valid details and clicks on the upload stamp paper button
    Then estamp paper should get uploaded successfully