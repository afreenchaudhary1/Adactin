@loginpage
Feature: verify login details of Adactin website

  Scenario Outline: Verify the login details with invalid credentials.
    Given User is on Adactin Login page.
    When User enters "<username>" and "<password>"
    Then User should click on Login Button

    Examples: 
      | username | password |
      | adm123   |    12345 |

  Scenario: Verify the login details with valid credentials.
    Given User is on Adactin Login page.
    When User enters username and password
    Then User again click on Login Button
