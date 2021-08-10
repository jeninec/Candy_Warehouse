@tag
Feature: The Basic User Functions

	Scenario: The User is trying to register an account
		Given The User is on the Candy Warehouse Main Page
		When The User goes to the login page
		When The User clicks on the registration button
		When The User inputs their registration information
		Then The User should be registered in the application

	Scenario: The User is trying to log in
		Given The User is on the Candy Warehouse Main Page
		When The User goes to the login page
		When The User clicks on the login button
		When The User inputs the correct login information
		Then The User should be logged into the application
		
	Scenario: The User is trying to add items to their cart
		Given The User is on the Candy Warehourse Main Page
		When The User goes to the products page
		When The User adds products to their cart
		Then The User should have the products display in their cart
		
	Scenario: The User is trying to buy the items in their cart
		Given The User is on the products page
		When The User views their cart
		When The User selects the submit order button
		Then The User should see that their order is submitted
		
	Scenario: The User searches for a candy using the search bar
		Given The User is on any page
		When The User inputs a candy name into the search bar
		When The User clicks search or presses the enter key
		Then The User should be redirected to a page with the right results
		
		