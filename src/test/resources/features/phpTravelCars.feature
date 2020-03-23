Feature: Initial page
  As a web user
  I want to navigate PhpTravels Cars web page
  And search a Car using Chicago as a location and complete the form.

  @Smoke
  Scenario: As a web user I want to navigate PHPTravel and search a Car between two days.
#    Given The user is in Cars page
#    Change this step due to lack of functionality on the test page
    Given The user is in home page
    When The user search a car between two days
    Then The search page list the available cars in those days.

  @Smoke
  Scenario: As a web user I want to navigate PHPTravel and complete a cars booking process
    #Given The user is in Cars page
    Given The user is in home page
    When The user search a car between two days
    And The user select the first result in the list
    And The user complete the booking car form
    And The user complete the payment form <payment data provided below>
    Then A reservation number is provided