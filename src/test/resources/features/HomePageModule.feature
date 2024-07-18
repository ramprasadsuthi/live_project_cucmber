Feature: Home Page Functionality

@smokeTesing
Scenario: TC6_Verify user is able to Access the StockItems

	Given the user is on the login page for login
	When they enter valid credentials
	And click the login button
	Then they should be redirected to the home page
	And click on StockItems menu and validate

