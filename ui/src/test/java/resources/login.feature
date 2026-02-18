@ui
Feature: UI Scenario

  Background:
    Given the website is opened

    Scenario: User perform actions
      When the user enter username
      And the user enter password
      Then Click the login button