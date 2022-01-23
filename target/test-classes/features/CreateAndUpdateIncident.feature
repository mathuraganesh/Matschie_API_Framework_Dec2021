Feature: Create New Incident,Get the Incident and Update the Short Description 

#2. ServiceNow
#- Create a new Problem using Rest API
#- Get the same Problem and update the short description

 Scenario: Create a new incident with short description
 
	Given enable logs
	And short description is added with Added from Cucumber
	When new incident is created
	Then the status code is 201
	And Get the Incident Number and Sys_id
		
	Scenario: Update the incident
	
 	Given enable logs
	And short description is added with Updated from Cucumber
	When new incident is updated
	Then the status code is 200
	
	Scenario: Get the incident
	
 	Given enable logs
	When Get the incident
	Then the status code is 200
	And response includes the following
	#json Path of the key|		Value
	|result.short_description|Updated from Cucumber|
	|result.sys_class_name|incident|