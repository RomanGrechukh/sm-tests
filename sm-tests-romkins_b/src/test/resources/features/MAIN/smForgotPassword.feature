@main
Feature: SM forgot password
  @ForgotPassword1
  @recheck
  Scenario Outline: SM forgot password verification
    * User opens forgot password page
    * User enters email '<email>'
    * User clicks on Submit button
    * User verifies error message '<errorMessage>' is displayed
    Examples:
      | email                     | errorMessage                                                                               |
      | 1234567890shdfkj@test.com | Email doesn't exist                                                                        |
      | test@test.com             | Your account is blocked because you exceeded the number of attempts to verify you identity |

  @ForgotPassword2
  @recheck
  Scenario:  SM forgot password verification - 2
    * User opens forgot password page
    * User enters email 'test123@test.com'
    * User clicks on Submit button
    * User verifies email is sent to 'test123@test.com'

  @ForgotPassword3
  @recheck
  Scenario:  SM forgot password verification - 3
    * User opens forgot password page
    * User clicks on Sign In button
    * User verifies Sign In page is opened

