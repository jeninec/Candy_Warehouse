Feature: Test the Admin Page

	Scenario: The User goes to the admin page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an admin email and password
		When The User clicks the login button
		When The User clicks the admin link
		Then The User should be on the admin page
		
	Scenario: The User goes to the edit user page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an admin email and password
		When The User clicks the login button
		When The User go to the edit user page
		Then The User should be on the edit user page
		
	Scenario: The User goes to the manager page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs a manager email and password
		When The User clicks the login button
		When The User clicks the manager link
		Then The User should be on the manager page
		
	Scenario: The User goes to the employee page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an employee email and password
		When The User clicks the login button
		When The User clicks the employee link
		Then The User should be on the employee page
		
	Scenario: The User goes to the user page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an user email and password
		When The User clicks the login button
		When The User clicks the user link
		Then The User should be on the user page

		