@main
Feature: SM sign up

  @directRegistration
  Scenario: Sign up - user answers additional question after answering only 1 correctly (direct registration)
    * User opens sign up page
    * User enters firstName, lastName, email, password, confirmPassword
      | firstName | lastName | email          | password | confirmPassword |
      | Test      | Test     | test@yahoo.com | start123 | start123        |
    * User clicks on Sign Up button
    * User enters address, city, state, zip, dob, ssn
      | address | city | state | zip   | dob      | ssn       |
      | Test    | Test | CA    | 12345 | 01011990 | 666560115 |
    * User sets auth checkbox
    * User clicks on Continue button
    * User answers questions with '1' correct answers
    * User answers additional question with '1' correct answers
    * And verifies score '568' is shown on dashboard

  @directRegistration
  Scenario: Sign up - happy path registration (direct registration)
    * User opens sign up page
    * User enters firstName, lastName, email, password, confirmPassword
      | firstName | lastName | email          | password | confirmPassword |
      | Test      | Test     | test@yahoo.com | start123 | start123        |
    * User clicks on Sign Up button
    * User enters address, city, state, zip, dob, ssn
      | address | city | state | zip   | dob      | ssn       |
      | Test    | Test | CA    | 12345 | 01011990 | 666418357 |
    * User sets auth checkbox
    * User clicks on Continue button
    * User answers questions with '2' correct answers
    * And verifies score '667' is shown on dashboard


  @samlRegistration
  Scenario: Sign up - user answers additional question after answering only 1 correctly (SAML registration)
    * User opens SAML page
    * User logs in to SAML
    * User selects user 'PATRICK IHNKEN(694)' from drop down
    * User enters user data
      | FirstName | LastName | Address | City | State | Email         | Birthday |
      | test      | test     | test    | test | CA    | test@test.com | 01011990 |
    * User selects partner '206033' from drop down
    * User selects whether to use Iframe or not 'No', SSO Relay state 'Application - UI V2', SSO Server 'Sandbox'
    * User clicks on SAML submit button
    * User switches to tab 'Application'
    * User sets auth checkbox
    * User clicks on Continue button
    * User answers questions with '1' correct answers
    * User answers additional question with '1' correct answers
    * And verifies score '694' is shown on dashboard

  @samlRegistration
  Scenario: Sign up - user submits empty data from prototype, verifies appropriate empty fields are shown, fills them and finish registration (SAML registration)
    * User opens SAML page
    * User logs in to SAML
    * User selects user 'PATRICK IHNKEN(694)' from drop down
    * User enters user data
      | FirstName | LastName | Address | City | State | Email | Birthday |
      |           |          |         |      |       |       |          |
    * User selects partner '206033' from drop down
    * User selects whether to use Iframe or not 'No', SSO Relay state 'Application - UI V2', SSO Server 'Sandbox'
    * User clicks on SAML submit button
    * User switches to tab 'Application'
    * User makes URL mock and refresh a page
    * User verifies corresponding empty fields are shown
      | First Name | Last Name | Email | Address | City | State | Date of Birth (MM/DD/YYYY) |
    * User fills empty fields
      | First Name | Last Name | Email         | Address | City | State | Date of Birth (MM/DD/YYYY) |
      | test       | test      | test@test.com | test    | test | AA    | 02031980                   |
    * User sets auth checkbox
    * User clicks on Continue button
    * User answers questions with '2' correct answers
    * And verifies score '694' is shown on dashboard
