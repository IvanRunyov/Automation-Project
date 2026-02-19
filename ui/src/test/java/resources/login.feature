@ui
Feature: UI Scenario

  Background:
    Given the user navigate to the Login page

    Scenario: User logs into Sauce labs
      When the user enter valid username
      And the user enter valid password
      And the user click on the login button
      Then the user should see page header value is 'Products'