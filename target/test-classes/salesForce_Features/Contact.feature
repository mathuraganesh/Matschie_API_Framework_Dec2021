Feature: Contact
  
  Scenario: Create a new Contact with First Name and Last Name
	Given enable logs
	And First Name is added with Divya
	And Last Name is added with Lakshmi
	When new contact is created
	Then the status code is 201
	
	
	Scenario: Update a Contact with New Address
	Given enable logs
	And Other Street is added with C7 Road
	And Other City is added with Coimbatore
	And Other State is added with Tamil Nadu
	And Other PostalCode is added with 567987
	And Other Country is added with India
	When Contact is Updated
	Then the status code is 204
	
	Scenario: Get all Contact
	Given enable logs
	When get all contact
	Then the status code is 200
	
	Scenario: Get and Verify Contact
	Given enable logs
	When Get the Contact
	Then the status code is 200
	And response includes the following
	|Name|Lakshmi|
	