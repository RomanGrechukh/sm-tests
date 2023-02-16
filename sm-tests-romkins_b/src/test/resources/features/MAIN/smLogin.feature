Feature: SM login

  @Login1
  @recheck
  Scenario Outline: 4 - SM login verification
    * User opens login page
    * User logs in with the following '<username>'
    * And '<password>'
    * And verifies '<errorMessage>' is displayed
    Examples:
      | username                | password  | errorMessage                                                |
      | romkins@bob.com         | start123  | Wrong email address/password combination. Please try again. |
      | stankins@bob.com        | start123  | Wrong email address/password combination. Please try again. |
      | rhrechukh@romexsoft.com | start12345 | Wrong email address/password combination. Please try again. |

  @Login2
  @recheck
  Scenario Outline:  4 - SM login verification 2
    * User opens login page
    * User logs in with the following '<username>'
    * And '<password>'
    * And verifies score '753' is shown on dashboard
    Examples:
      | username                | password         |
      | demo_171@savvymoney.com | DGkK7R6EWJkX1ZVC |

  #@Login3
  # Scenario Outline: 4 - SM login verification 3
  #  * User opens login page
  #  * User enters '<username>', '<password>' and verifies '<errorMessage>' is displayed
  #  Examples:
  #    | username | password | errorMessage                       |
  #    | romkins  | start123 | Please enter a valid email address |
  #    | stankins | start123 | Please enter a valid email address |

  @Login4
  @recheck
  Scenario Outline: 4 - SM login verification 4
    * User opens login page for '<PID>'
    * User clicks on banner
    * User verifies banner is clickable '<ClickableExpected>'
    Examples:
      | PID | ClickableExpected |
      | 167 | false             |
      | 181 | true              |
      | 304 | false             |
      | 309 | false             |
