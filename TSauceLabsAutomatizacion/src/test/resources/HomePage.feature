Feature: Home Page Sauce Demo
  Background: User manage products of Sauce Demo page
    Given Im in sauce demo web page

  @NumberOfCartIncreasesWithProductAdded
  Scenario: add product to cart and increase the number of products in the cart
    Given I set the user name field with "standard_user"
    And I set the password field with "secret_sauce"
    When I click on login button
    And  I add a product to the cart
    Then The number of items in the cart increase

  @CheckFilterLowToHigh
  Scenario: Change filter low to high of home page
    Given I set the user name field with "wrong_user"
    And I set the password field with "wrong password"
    When I click on login button
    And I click on the filter to change low to high
    Then I verify the order of the prices