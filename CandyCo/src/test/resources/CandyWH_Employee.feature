@tag
Feature: The Employee Functions

	Scenario: The Employee goes to the inventory page 
		Given The Employee is on the Candy Warehouse Main Page
		When The Employee goes to the inventory page
		Then The Employee should be directed to the inventory page
		
	Scenario: The Employee changes the quantity of an item
		Given The Employee is on the Candy Warehouse Main Page
		When The Employee goes to the inventory page
		When The Employee adjusts the quantity of an item
		Then The changes should be displayed on the application
	
	Scenario: The Employee views all active orders
		Given The Employee is on the Candy Warehouse Main Page
		When The Employee goes to the inventory page
		When The Employee clicks on the show orders button
		Then The Employee should be able to view all orders for their warehouse
		
	Scenario: The Employee completes an active order
		Given The Employee is on the inventory page
		When The Employee adds all necessary items to the order
		When The Employee marks to order as completed
		Then The Employee should no longer be able to view that order