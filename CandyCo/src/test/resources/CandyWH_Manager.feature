@tag
Feature: The Manager Functions

	Scenario: The User goes to the manager page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs a manager email and password
		When The User clicks the login button
		When The User clicks the manager link
		Then The User should be on the manager page
		
	Scenario: The Manager adds a new candy to the warehouse
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs a manager email and password
		When The User clicks the login button
		When The User clicks the manager link
		When The User clicks the Add Item button
		When The User inputs the candy information
		When The User clicks the Submit Item button
		Then The item should be added to the item table
		

		