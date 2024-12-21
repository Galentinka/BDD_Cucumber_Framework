@TutorialsNinjaAddToCart
Feature: Add to cart functionality of TutorialsNinja

  @AddToCartLoggedInUserWithValidProduct
  Scenario Outline: Adding a valid product after logging in into the account
    Given User navigates to Login page to search for product
    When User enters validEmail to login <email>
    And User enters validPassword to login <password>
    And User clicks on Login button to login
    Then User is redirect to Account page to search for product
    When User enters "HP"
    And User clicks on search
    Then User gets product info displayed
    When User clicks on AddToCart button on Product page
    Then User is redirected to AddToCart page
    And User clicks on AddToCart button in AddToCart page
    Then User receive a success message
    Examples:
      | email            | password |
      | galka1@gmail.com | 123456   |

  @AddToCartLoggedInUserWithInvalidProduct
  Scenario Outline: Adding an invalid product after logging in into the account
    Given User navigates to Login page to search for product
    When User enters validEmail to login <email>
    And User enters validPassword to login <password>
    And User clicks on Login button to login
    Then User is redirect to Account page to search for product
    When User enters invalid "DELL"
    And User clicks on search
    Then User gets warning message no product1 found in the Product page
    Examples:
      | email            | password |
      | galka1@gmail.com | 123456   |

  @AddToCartWithoutLoginWithValidProduct
  Scenario: Adding a valid product without logging in into the account
    Given User navigates to Login page to search for product
    When User enters "HP"
    And User clicks on search
    Then User gets product info displayed
    When User clicks on AddToCart button on Product page
    Then User is redirected to AddToCart page
    And User clicks on AddToCart button in AddToCart page
    Then User receive a success message

  @AddToCartWithoutLoginWithInvalidProduct
  Scenario: Adding an invalid product without logging in into the account
    Given User navigates to Landing page
    When User enters invalid product "DELL"
    And User clicks on search button
    Then User gets warning message no product found in the Product page