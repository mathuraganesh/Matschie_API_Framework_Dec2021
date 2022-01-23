Feature: Create the JIRA Issue

#1. Jira
#Create a new issue
#update the newly created issue and 
#get all issues in JIRA using cucumber and services in the Matschie framework


Scenario: Create a new Issue

Given enable logs
And Issue description is added from CreateJiraIssue
When new issue is created
Then the status code is 201
And Get the Id


Scenario: Update the Issue
	
Given enable logs
And Issue description is added from UpdateJiraIssue
When new issue is updated
Then the status code is 204

Scenario: Get All the Issue
	
Given enable logs
When Get All issue
Then the status code is 200