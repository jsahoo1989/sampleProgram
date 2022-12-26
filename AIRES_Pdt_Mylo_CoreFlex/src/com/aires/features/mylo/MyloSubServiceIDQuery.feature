Feature: Validate the functionality of Mylo SubServiceID Query
  I want to test the  functionlity of Mylo SubServiceID Query

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
Scenario: Validate sub-service id field

Given the user is in the sub-service id query
When the user tries to enter more than 10 characters
Then the field will restrict the user from using more than 10 characters
When the user tries to enter a character other than a number
Then the field restricts the user from adding the characters to the field
When the user enters an invalid sub-service id
And the user clicks on the execute button
Then "No such file" popup will display

Scenario Outline: Clicking cancel/close in Query By Sub-Service ID
Given the user is in the sub-service id query
When the user has entered some number in the sub-service id field
And the user clicks <button>
Then "Query By Sub-Service ID" modal will close

Examples: |button|
          |cancel|
          |close|

Scenario Outline: Validate with a shipment/not a shipment sub-service
Given the user is in the sub-service id query
When the user enters a valid sub-service id
And the sub-service is <shipment_type>
When the user clicks "execute"
Then user will be taken to the <page_name> for that sub-service.

Examples: |shipment_type   | page_name       |
          |not a shipment  | summary overview|
		      |a shipment      | file associated |




