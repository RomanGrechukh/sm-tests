@main
Feature: SM main navigation

  @NavMenu1
  @test
  Scenario: User clicks on New Auto Loans menu item
    * User opens SAML page
    * User logs in to SAML
    * User enters user data
      | FirstName | LastName | Address | City | State | Email         | Birthday | PMID | SSN |
      | test      | test     | test    | test | CA    | test@test.com | 01011990 | cob1 |     |
    * User selects partner '205003' from drop down
    * User selects whether to use Iframe or not 'No', SSO Relay state 'Application - UI V2', SSO Server 'Beta'
    * User clicks on SAML submit button
    * User switches to SM application tab
    * User confirms identity with the following SSN: '4689'
    * And verifies score '726' is shown on dashboard
    * User clicks on menu item with name 'New Auto Loans'
    * User verifies title is visible