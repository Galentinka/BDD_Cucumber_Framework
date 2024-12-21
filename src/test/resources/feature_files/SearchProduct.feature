@TutorialsNinjaSearchProduct
Feature: Search Product Functionality of TutorialsNinja

  @SearchWithValidProduct
  Scenario: User search with valid product
    Given User navigates to Landing page
    When User enters valid product "HP"
    And User clicks on search button
    Then User gets product info displayed in the Product page

  @SearchWithInvalidProduct
  Scenario: User search with invalid product
    Given User navigates to Landing page
    When User enters invalid product "DELL"
    And User clicks on search button
    Then User gets warning message no product found in the Product page

  @SearchWithNoProduct
  Scenario: User search with no product
    Given User navigates to Landing page
    And User clicks on search button
    Then User gets warning message no product found in the Product page



