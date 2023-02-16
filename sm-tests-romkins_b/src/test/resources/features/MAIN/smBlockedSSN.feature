@main
Feature: SM sign up

  @blockedSSN
  Scenario: Sign up - block SSN during registration
    * User opens SAML page
    * User logs in to SAML
    * User selects user 'PATRICK IHNKEN(694)' from drop down
    * User selects partner '206033' from drop down
    * User selects whether to use Iframe or not 'No', SSO Relay state 'Application - UI V2', SSO Server 'Sandbox'
    * User clicks on SAML submit button
    * User switches to SM application tab
    * User sets auth checkbox
    * User clicks on Continue button
    * User answers questions with '0' correct answers
    * User verifies We couldn't pull your report page is opened
    * User clicks on verify again button
    * User switches to tab 'SAML'
    * User verifies member is not blocked and unblocks if blocked
    * User switches to tab 'Application'
    * User fills empty fields
      | Date of Birth (MM/DD/YYYY) | Social Security Number |
      | 01011990                   | 666901244              |
    * User sets auth checkbox
    * User clicks on Continue button
    * User answers questions with '0' correct answers
    * User verified blocked SSN text is displayed
    * User switches to tab 'SAML'
    * User unblocks member

  @blockedSSN
  Scenario: Sign up - verify SSN is blocked for existing user
    * User opens SAML page
    * User logs in to SAML
    * User enters user data
      | PMID           | SSN       |
      | pmi-0494357033 | 666628891 |
    * User selects partner '206033' from drop down
    * User selects whether to use Iframe or not 'No', SSO Relay state 'Application - UI V2', SSO Server 'Sandbox'
    * User clicks on SAML submit button
    * User switches to tab 'Application'
    * User verified blocked SSN text is displayed
