@Reregression
Feature: Search Product
  Scenario: User is able to navigate to product page and search for a specific item
    When User is at the home page clicks on products button
    And Verify user is navigated to 'ALL PRODUCTS' page successfully and products list is visible
    Then Searches for 'top' and confirms 'SEARCHED PRODUCTS'
    And Verify all the products related to search are visible

