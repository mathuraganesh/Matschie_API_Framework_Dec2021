Feature: Lead
  
  Scenario: Create a new Lead with First Name Last Name and Company Name
	Given enable logs
	And First Name is added with Vidya
	And Last Name is added with Lakshmi
	And Company is added with CGI
	When new lead is created
	Then the status code is 201
	
	Scenario: Update a Lead with Company Name
	Given enable logs
	And Company is added with IBM
	When Lead is Updated
	Then the status code is 204
	
	
	Scenario: Get all Lead
	Given enable logs
	When get all lead
	Then the status code is 200	
	
	Scenario: Delete a Lead
	Given enable logs
	When Lead is Deleted
	Then the status code is 204