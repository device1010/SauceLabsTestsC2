Feature: Logout Sauce Demo
  Background: User logout Sauce Demo page
    Given Im in sauce demo web page

  @logout
  Scenario: Login into Sauce Demo page with valid credentials
    Given I set the user name field with "standard_user"
    And I set the password field with "secret_sauce"
    When I click on login button
    Then  I click on hamburguer button of Home Page
    And I click on logout link
    Then The loginPage should be displayed