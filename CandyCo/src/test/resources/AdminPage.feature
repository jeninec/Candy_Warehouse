Feature: Test the Admin Page

	Scenario: The User goes to the admin page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an admin email and password
		When The User clicks the login button
		When The User clicks the admin link
		Then The User should be on the admin page
		
		