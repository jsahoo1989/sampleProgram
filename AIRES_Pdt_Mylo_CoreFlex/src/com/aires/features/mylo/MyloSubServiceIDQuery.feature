Feature: Validate the functionality of Mylo SubServiceID Query
  I want to test the  functionlity of Mylo SubServiceID Query

Background: Login to Mylo application
    Given he has logged into the 'Mylo' application
    #And he is on "Query popup" after selecting "Query" section under Journey available on left panel of Mylo Home Page

@C218342 @Mylo-Regression @MYLO2-161
Scenario: Mylo- Validate Summary Overview when user enters subserviceID that is not a shipment  
Given he is on "Query By Sub-Service ID" popup by selecting "Sub-Service ID" option available on "Query" section
And he enters valid "Non-Shipment" subServiceId in the "Sub-Service ID" field on QueryBySub-ServiceID section
When he clicks on "Execute" button on "QueryBySub-ServiceID" section
Then he should be taken to the Summary Overview section for that subservice on Mylo Journey page

@C218343 @Mylo-Regression @MYLO2-161
Scenario: Mylo- Validate Summary Overview and shipment sidescreen when user enters subserviceID that is a shipment  
Given he is on "Query By Sub-Service ID" popup by selecting "Sub-Service ID" option available on "Query" section
And he enters valid "Shipment" subServiceId in the "Sub-Service ID" field on QueryBySub-ServiceID section
When he clicks on "Execute" button on "QueryBySub-ServiceID" section
Then he should be taken to the Summary Overview of associate file with shipment sidescreen being displayed

@C218352 @C218344 @C218353 @Mylo-Regression @MYLO2-161
Scenario: Mylo-Validate Boundary Conditions of Number Limit for sub-service Id field & Cancel button functionality of Query By Sub-Service Id section
Given he is on "Query By Sub-Service ID" popup by selecting "Sub-Service ID" option available on "Query" section
When he enters data beyond number limit for "Sub-Service ID" field under "QueryBySub-ServiceID" section
     | Field Name       | NumberLength |
     | Sub-Service Id   | 11           |
Then values should be successfully entered as per below number limit set for "Sub-Service ID" field  under "QueryBySub-ServiceID" section
     | Field Name       | NumberLength |
     | Sub-Service Id   |            10|
And he should not be able to enter any character in "Sub-Service ID" field under "QueryBySub-ServiceID" section
     | Field Name       | StringLength  |
     | Sub-Service Id   | 						10|     
And "Query By Sub-Service ID" modal should be closed after clicking on "Cancel" button

 
@C218345 @Mylo-Regression @MYLO2-161
Scenario: Mylo: Validate No such file popup for invalid sub-serviceID and Close icon functionality of Query By Sub-Service Id section
Given he is on "Query By Sub-Service ID" popup by selecting "Sub-Service ID" option available on "Query" section
When he clicks on "Execute" button after entering an invalid sub-service id in the "Sub-Service ID" field on "QueryBySub-ServiceID" section
Then "No such file found" popup message should be displayed
And "Query By Sub-Service ID" modal should be closed after clicking on "Close" icon on "QueryBySub-ServiceID" section

             


