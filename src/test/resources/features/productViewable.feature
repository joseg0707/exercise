@regression
@Reregression
Feature: Verify All Products and product detail page
  Scenario: User is able to navigate to products and see the information
    When User is at the home page clicks on products button
    And Verify user is navigated to 'ALL PRODUCTS' page successfully and products list is visible
    And Click on View Product of first product
    Then Verify that detail detail is visible: 'Blue Top', 'Women > Tops', 'Rs. 500', 'In Stock', 'New', 'Polo'