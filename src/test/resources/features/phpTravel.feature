Feature: Initial page
  As web user
  I want to navigate into PhpTravels
  And look into "About us" page

  @Smoke
  Scenario: As a web user i want to navigate PHPTravels "About us" page
    Given The user is in home page
    When The user go to About Us page
    Then The About Us page is displayed