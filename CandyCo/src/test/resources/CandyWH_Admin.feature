@tag
Feature: The Admin Functions

	Scenario: The Admin goes to the admin page
		Given The Admin is on the home page
		When The Admin logs into to their admin account
		When The Admin clicks on the admin page link
		Then The Admin should be on the admin page
		
	Scenario: The Admin views all users on the page
		Given The Admin is on the admin page
		When The Admin clicks on the view users button
		Then The Admin should be able to view all users of the page
		
	Scenario: The Admin deletes a user from the page
		Given The Admin is on the admin page
		When The Admin clicks on the view users button
		When The Admin clicks on the delete user button
		Then The selected user should be deleted