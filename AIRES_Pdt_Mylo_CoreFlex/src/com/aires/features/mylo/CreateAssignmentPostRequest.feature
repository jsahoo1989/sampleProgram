Feature: Validate the functionality of Create New Assignment Post Request
  I want to test the  functionlity of Create New Assignment Post Request
    
@createAssignAPI 
Scenario: Validate POST call for Create New Assignment
Given he has service api endpoint for "Create New Assignment" functionality
When a "POST" call is made for "Create New Assignment"
Then a 201 response code should be received
And all fieldValues related to created assignment should be populated in the response body

@getAssignAPI 
Scenario: Validate GET call for Get Assignment Details
Given he has service api endpoint for "Get Assignment" functionality
When a "GET" call is made for "Get Assignment" for value "611085"
Then a 200 response code should be received
And all fieldValues related to searched assignment should be populated in the response body

@End2EndFlowAssignmentAPI 
Scenario: Validate End to End flow of Assignment API
Given a "POST" call has been made using "Create New Assignment" service end point
And 201 response code is received with all field values populated in the response for new assignment
When a "GET" call is made using "Get Assignment" service end point for above created assignment
Then a 200 response code should be received with all assignment details fetched in the response
And assignment fetched should match with the payload provided for the POST request