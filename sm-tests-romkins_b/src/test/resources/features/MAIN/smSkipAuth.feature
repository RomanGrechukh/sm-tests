@main
Feature: SM sign up - skip auth

  @skipAuth
  Scenario: Sign up - skip auth - happy path registration with skip auth
    * User opens SAML page
    * User logs in to SAML
    * User selects user 'PATRICK IHNKEN(694)' from drop down
    * User enters user data
      | FirstName | LastName | Address | City | State | Email         | Birthday |
      | test      | test     | test    | test | CA    | test@test.com | 01011990 |
    * User selects partner '310' from drop down
    * User selects whether to use Iframe or not 'No', SSO Relay state 'Application - UI V2', SSO Server 'Sandbox'
    * User clicks on SAML submit button
    * User switches to SM application tab
    * User sets auth checkbox
    * User clicks on Continue button
    * And verifies score '694' is shown on dashboard

  @skipAuth
  Scenario: Sign up - skip auth - last name is empty
    * User opens SAML page
    * User logs in to SAML
    * User selects user 'PATRICK IHNKEN(694)' from drop down
    * User enters user data
      | FirstName | LastName | Address | City | State | Email         | Birthday |
      | test      |          | test    | test | CA    | test@test.com | 01011990 |
    * User selects partner '310' from drop down
    * User selects whether to use Iframe or not 'No', SSO Relay state 'Application - UI V2', SSO Server 'Sandbox'
    * User clicks on SAML submit button
    * User switches to SM application tab
    * User verifies corresponding empty fields are shown
      | First Name |
    * User fills empty fields
      | First Name |
      | test |
    * User sets auth checkbox
    * User clicks on Continue button
    * User answers questions with '2' correct answers
    * And verifies score '694' is shown on dashboard
