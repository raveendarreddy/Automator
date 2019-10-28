Feature: Test Home Page

  @Regression
  Scenario: Verify Home page and Bank Project page
    Given I Start the application
    When I click on Bank project page
    Then I verify the title of the web page