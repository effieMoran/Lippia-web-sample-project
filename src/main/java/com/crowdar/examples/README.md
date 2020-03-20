Instructions 
- Download and install Lippia web sample project from: https://github.com/Crowdar/Lippia-web-sample-project 
- Fork the code in GitHub with your user 
- Take a look at the test scenario in the sample project which is responsible for do a search in Google 
- Build the following test scenarios using the same approach that is used in the sample but with the following web application: http://phptravels.net/ 
 
Feature: Initial page 
As web user 
I want to navigate into PhpTravels 
And look into "About us" page 
 
@Test 
Scenario: As a web user i want to navigate PHPTravels "About us" page 
Given The user is in home page 
When The user go to "About us" page 
Then The "About us" page is displayed 
 
Feature: Initial page 
As a web user 
I want to navigate PhpTravels Cars web page 
And search a Car using Chicago as a location and complete the form. 
 
@Test 
Scenario: As a web user I want to navigate PHPTravel and search a Car between two days. 
Given The user is in Cars page 
When The user search a car betwteen two days 
Then The search page list the available cars in those days. 
 
@Test 
Scenario: As a web user I want to navigate PHPTravel and complete a cars booking process 
Given The user is in Cars page 
When the user search a car between two days 
And the user select the first result in the list 
And The user complete the booking car form 
And The user complete the payment form <payment data provided below> 
Then a reservation number is provided 
 
Credit card: Visa 
Number: 4263982640269299 
Exp Date: 02/2023 
CVV: 837 
 
- When your code is finished, send us the url of your fork or upload a zip file with your code 