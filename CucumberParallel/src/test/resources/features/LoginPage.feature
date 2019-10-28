Feature: Test Login Page

  @Regression
  Scenario: Verify Loing Page functionality with valid data
    Given I go to Login page
    When I enter EmailId
    And I enter Password
    Then I click on Login button
    And I verify successful login