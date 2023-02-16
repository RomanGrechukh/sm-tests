@main
Feature: SM auth restriction by SSN

  @samlRegistration
  @SsnAuthRestriction
  Scenario: Verify auth is not possible with incorrect SSN for pid 205003
    * User opens SAML page
    * User logs in to SAML
    * User enters user data
      | FirstName | LastName   | Address | City | State | Email         | Birthday | PMID | SSN       |
      | Angellica | Avellaneda | test    | test | CA    | test@test.com | 01011990 | cob1 | 666666666 |
    * User selects partner '205003' from drop down
    * User selects whether to use Iframe or not 'No', SSO Relay state 'Widget - UI V2', SSO Server 'Beta'
    * User clicks on SAML submit button
    * User switches to tab 'Widget'
    * User verifies unregistered widget is shown
    * User clicks on check your score button
    * User switches to tab 'Application'
    * User verifies Identity not match page is shown

  @samlRegistration
  @SsnAuthRestriction
  Scenario: Verify auth is not possible with empty SSN without confirmation of identity
    * User opens SAML page
    * User logs in to SAML
    * User enters user data
      | FirstName | LastName   | Address | City | State | Email         | Birthday | PMID | SSN |
      | Angellica | Avellaneda | test    | test | CA    | test@test.com | 01011990 | cob1 |     |
    * User selects partner '205003' from drop down
    * User selects whether to use Iframe or not 'No', SSO Relay state 'Widget - UI V2', SSO Server 'Beta'
    * User clicks on SAML submit button
    * User switches to tab 'Widget'
    * User verifies unregistered widget is shown
    * User clicks on check your score button
    * User switches to tab 'Application'
    * User verifies confirm identity page is shown
    * User confirms identity with the following SSN: '4689'
    * User switches to tab 'Application'
    * And verifies score '726' is shown on dashboard
    * User switches to tab 'Widget'
    * User verifies score is shown on registered widget