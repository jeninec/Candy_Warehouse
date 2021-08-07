@tag
Feature: The Manager Functions

	Scenario: The Manager views the Manager Page
		Given The Manager is on the Warehouse Main Page
		When The Manager logs into their manager account
		When The Manager goes to the manager page
		Then The Manager should be on the manager page
		
	Scenario: The Manager views all employees of the warehouse
		Given The Manager is on the manager page
		When The Manager clicks the view employees button
		Then The Manager should see all employees of the warehouse
		
	Scenario: The Manager views all active employees of the warehouse
		Given The Manager is on the manager page
		When The Manager clicks the view active employees button
		Then The Manager should see all the employees currently working
		
	Scenario: The Manager views all completed orders
		Given The Manager is on the manager page
		When The Manager clicks the view completed orders button
		Then The Manager should see all the completed orders
		
	Scenario: The Manager views all active orders
		Given The Manager is on the manager page
		When The Manager clicks the view active orders button
		Then The Manager should see all the active orders
		
	Scenario Outline: The Manager adds a new candy to the warehouse stock
		Given The Manager is on the manager page
		When The Manager clicks the add new candy button
		When The Manager inputs the candy name <name> with quantity <quantity>
		Then The values should be added to the warehouse inventory
		
		Examples:
		  | name  | value |
      | cocoa |   200 |
      | nuggs |   150 |
      
	Scenario: The Manager deletes a candy from the warehouse stock
		Given The Manager is on the manager page
		When The Manager clicks on the delete candy button
		When The Manager selects a candy from the list of candies
		When The Manager clicks delete on a candy
		Then The candy should be deleted
		
		