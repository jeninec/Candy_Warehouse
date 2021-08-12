Feature: Test the Admin Page

	Scenario: The User goes to the admin page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an admin email and password
		When The User clicks the login button
		When The User clicks the admin link
		Then The User should be on the admin page
		
	Scenario: The Admin goes to the edit user page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an admin email and password
		When The User clicks the login button
		When The User clicks the admin link
		When The User goes to the edit user page
		Then The User should be on the edit user page
		
	Scenario: The Admin edits a user
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an admin email and password
		When The User clicks the login button
		When The User goes to the edit user page
		When The User clicks the update user button
		Then The User should be on the admin page
		
	Scenario: The Admin deletes a user
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an admin email and password
		When The User clicks the login button
		When The User goes to the edit user page
		When The User clicks the delete user button
		Then The User should be on the admin page
		