@tag
Feature: Test the Admin Page

	Scenario: The User goes to the admin page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an admin email and password
		When The User clicks the login button
		When The User clicks the admin link
		Then The User should be on the admin page
		
	Scenario: The Admin edits a user from the admin page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an admin email and password
		When The User clicks the login button
		When The User clicks the admin link
		When The User goes to the edit user page
		When The User changes the users title
		When The User clicks the Update User button
		Then The User should be redirected to the admin page
		
		
	Scenario: The Admin deletes a user from the page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an admin email and password
		When The User clicks the login button
		When The User clicks the admin link
		When The User goes to the edit user page
		When The User clicks the Delete User button
		Then The User should be redirected to the admin page
		
	Scenario: The Admin searches for a given user by name
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an admin email and password
		When The User clicks the login button
		When The User clicks the admin link
		When The User inputs a users first name and last name
		When The User clicks the Search by name button
		Then The Users should be filtered by name
		
	Scenario: The Admin searches for a given user by email
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs an admin email and password
		When The User clicks the login button
		When The User clicks the admin link
		When The User inputs a users email
		When The User clicks the Search by email button
		Then The Users should be filtered by email
		