@main
Feature: SM registered widget

  @RegWidget1
  @recheck
  Scenario: Verify recommendation blocks data matches
    * User opens SAML page
    * User logs in to SAML
    * User selects user 'PATRICK IHNKEN(694)' from drop down
    * User enters user data
      | FirstName | LastName | Address | City | State | Email              | Birthday | PMID | SSN       |
      | test      | test     | test    | test | CA    | testsdkfl@test.com | 01011990 |      | 666137043 |
    * User selects partner '205003' from drop down
    * User selects whether to use Iframe or not 'No', SSO Relay state 'Widget - UI V2', SSO Server 'Sandbox'
    * User clicks on SAML submit button
    * User switches to tab '2' having in general '2' tabs
    * User clicks on check your score button
    * User switches to tab '3' having in general '3' tabs
    * User sets auth checkbox
    * User clicks on Continue button
    * User answers questions with '2' correct answers
    * And verifies score '807' is shown on dashboard
    * User switches to tab '2' having in general '3' tabs
    * User verifies score is shown on registered widget
    * User verifies recommendation block data on dashboard matches recommendation block data on widget


  @RegWidget2
  @recheck
  Scenario: Verify offer links are applied correctly according to product types
    * User opens SAML page
    * User logs in to SAML
    * User selects user 'PATRICK IHNKEN(694)' from drop down
    * User enters user data
      | PMID | SSN       |
      | cob1 | 666137043 |
    * User selects partner '206032' from drop down
    * User selects whether to use Iframe or not 'No', SSO Relay state 'Widget - UI V2', SSO Server 'Beta'
    * User clicks on SAML submit button
    * User switches to tab 'Widget'
    * User verifies links on Get Offer buttons are correct according to product types

