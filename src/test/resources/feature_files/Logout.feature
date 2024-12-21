@TutorialsNinjaLogout
Feature: Logout functionality on TutorialsNinja

  @Logout
  Scenario Outline: User Login With Valid Credentials
    Given User opens Login page
    When User enters emailText <email>
    And User enters passwordText <password>
    And User clicks on Login button to redirect to account page
    Then Account page is displayed
    When User clicks on logout button
    Then User is redirect to Logout page
    Examples:
      | email            | password |
      | galka1@gmail.com | 123456   |