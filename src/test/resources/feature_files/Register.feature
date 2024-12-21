@TutorialsNinjaRegister
Feature: Register Functionality of TutorialsNinja

  @RegisterWithAllMandatoryFields
  Scenario: User Register With All Mandatory Fields
    Given User navigates to Register page
    And User enters the below mandatory details
      | firstname       | Galina    |
      | lastname        | Ivanova   |
      | telephone       | 123456789 |
      | password        | 123456    |
      | confirmPassword | 123456    |
    And User selects Privacy Policy checkbox
    When User clicks on Continue button
    Then User is redirect to AccountSuccess page

  @RegisterWithAllFields
  Scenario Outline: User Register With All Fields
    Given User navigates to Register page
    And User enters firstname <firstname>
    And User enters lastname <lastname>
    And User enters email
    And User enters telephone <telephone>
    And User enters password <password>
    And User enters confirmPassword <confirmPassword>
    And User selects Yes for Newsletter
    And User selects Privacy Policy checkbox
    When User clicks on Continue button
    Then User is redirect to AccountSuccess page
    Examples:
      | firstname | lastname | telephone | password | confirmPassword |
      | Galina1   | Ivanova  | 123456789 | 123456   | 123456          |
      | Galina2   | Ivanova  | 123456789 | 123456   | 123456          |
      | Galina3   | Ivanova  | 123456789 | 123456   | 123456          |
      | Galina4   | Ivanova  | 123456789 | 123456   | 123456          |


  @RegisterWithDuplicateEmail
  Scenario: User Register Existing Email
    Given User navigates to Register page
    And User enters the below details with existing email
      | firstname       | Galina           |
      | lastname        | Ivanova          |
      | email           | galka1@gmail.com |
      | telephone       | 123456789        |
      | password        | 123456           |
      | confirmPassword | 123456           |
    And User selects Privacy Policy checkbox
    When User clicks on Continue button
    Then User gets warning message of duplicate email

  @RegisterWithIncorrectConfirmPassword
  Scenario: User Register With Incorrect Confirm Password
    Given User navigates to Register page
    And User enters the below details with incorrect confirmPassword
      | firstname       | Galina    |
      | lastname        | Ivanova   |
      | telephone       | 123456789 |
      | password        | 123456    |
      | confirmPassword | 12345678  |
    And User selects Privacy Policy checkbox
    When User clicks on Continue button
    Then User gets warning message of incorrect confirmPassword

  @LessThan4DigitsPassword
  Scenario: Register with password less than four characters
    Given User navigates to Register page
    And User enters below fields with less than four characters for password
      | firstname       | Galina    |
      | lastname        | Ivanova   |
      | telephone       | 123456789 |
      | password        | 123       |
      | confirmPassword | 123       |
    And User selects Privacy Policy checkbox
    When User clicks on Continue button
    Then User gets warning message of password cannot be less than certain characters

  @RegisterWithNoFields
  Scenario: User Register With Incorrect ConfirmPassword
    Given User navigates to Register page
    When User clicks on Continue button
    Then User gets warning message for all mandatory field
