Feature: Home Page Functionality

@smokeTesing
Scenario: TC6_Verify user is able to Access the StockItems

	Given User launches the Application url
	When user enters username and password and click on the Login button
	Then validate the login page
	And click on StockItems menu and validate

