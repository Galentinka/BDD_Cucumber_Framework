@TutorialsNinjaLogin
Feature: Login functionality on TutorialsNinja

  @LoginWithValidCredentials
  Scenario Outline: User Login With Valid Credentials
    Given User navigates to Login page
    When User enters valid email <email>
    And User enters valid password <password>
    And User clicks on Login button
    Then User is redirect to Account page
    Examples:
      | email            | password |
      | galka1@gmail.com | 123456   |

  @LoginWithInvalidCredentials
  Scenario: User Login With Invalid Credentials
    Given User navigates to Login page
    When User enters invalid email "galka123456@gmail.com"
    And User enters invalid password "123456789"
    And User clicks on Login button
    Then User gets warning message about credentials mismatch

  @LoginWithValidEmailInvalidPassword
  Scenario: User Login With Valid Email Invalid Password
    Given User navigates to Login page
    When User enters valid email "galka1@gmail.com"
    And User enters invalid password "123456789"
    And User clicks on Login button
    Then User gets warning message about credentials mismatch

  @LoginWithInvalidEmailValidPassword
  Scenario: User Login With Invalid Email Valid Password
    Given User navigates to Login page
    When User enters invalid email "galka123456789@gmail.com"
    And User enters valid password "123456"
    And User clicks on Login button
    Then User gets warning message about credentials mismatch

  @LoginWithNoCredentials
  Scenario: User Login With No Credentials
    Given User navigates to Login page
    And User clicks on Login button
    Then User gets warning message about credentials mismatch

