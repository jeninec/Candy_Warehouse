@tag
Feature: The Manager Functions

	Scenario: The User goes to the manager page
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs a manager email and password
		When The User clicks the login button
		When The User clicks the manager link
		Then The User should be on the manager page
		
	Scenario: The User views employees
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs a manager email and password
		When The User clicks the login button
		When The User clicks the manager link
		When The User clicks the employees button
		Then The User should be on the manager page
		
	Scenario: The User views orders
		Given The User is on the home page
		When The User clicks on the login link
		When The User inputs a manager email and password
		When The User clicks the login button
		When The User clicks the manager link
		When The User clicks the orders button
		Then The User should be on the manager page
		
		

		

		