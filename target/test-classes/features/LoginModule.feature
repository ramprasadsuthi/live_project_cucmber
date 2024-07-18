Feature: Login Functionality

@smokeTesting
Scenario: TC1_ValidLogin

	Given the user is on the login page for login
	When they enter valid credentials "<username>" , "<password>"
	And click the login button
	Then they should be redirected to the home page
	
	Examples:
		| username | password |
		| admin    | master   |
						

Scenario: TC2_Logout

	Given the user is on the login page for logout
	When they enter valid credentials
	And click the login button
	Then they should be redirected to the home page
	And click on logout and validate

@smokeTesting	
Scenario: TC3_Invalid Login

	Given the user is on the login page for login
	When they enter Invalid credentials
	And click the login button
	Then Validate the Invalid Login Error message

@newTest
Scenario: TC4_RESET

	Given the user is on the login page for reset
	When they enter valid credentials
	And click the reset button
	Then Validate username and password fields gets empty
	
Scenario: TC5_Forgot Password page is opened for user

	Given the user is on the login page for forgot password
	When click on the forgot password link
	Then Validate forgot password page is displayed for the user
