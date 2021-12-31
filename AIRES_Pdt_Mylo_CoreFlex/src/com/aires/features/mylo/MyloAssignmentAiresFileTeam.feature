Feature: Validate the functionality of Mylo Assignment Aires File Team section
  I want to test the  functionality of Mylo Assignment page of Aires File Team section

Background: Login to  Mylo application
    Given user has logged into the 'Mylo' application
    
 @IRIS-687 @Mylo-Regression
Scenario: Mylo-Validate Cancel Options for Mylo Assignment Aires File Team section
Given user is on Mylo Dashboard Home page
And user selects "File" section after clicking on "Assignment" option in the Mylo Menu on the sidebar
And user views Summary Tab under Assignment after clicking on Execute button with FileID "611070"
And user should be able to view the current Aires File team
When user clicks on Add button to add a new team member
Then user should be able to select "COMPPREP" as role with "Bobby Mathew" as team member from the dropdown for the new row created
And user should have the capability to cancel the changes they have made to Aires File Team before saving the record

 @IRIS-687 @Mylo-Regression
Scenario Outline: Mylo-Validate No Option for Replacement of Mylo Assignment Aires File Team member
Given user is on Mylo Assignment Summary page for file ID "611072"
And user did not find the existing team member for specified "<Role>" in the dropdown section after clicking on "Add" button
And pop up should appear with the message "A current <Role> already exists for this assignment. Do you want to replace this <Role>?" after clicking "Save" button on selecting different team member with "<Role>"
When user clicks on "No" button
Then new row should not be added in the Aires File Team section

Examples:
|Role|
|PPC  |
|EMAC |
|SALES|

 @IRIS-687 @Mylo-Regression
Scenario:  Mylo-Validate Yes Option for Replacement of Mylo Assignment Aires File Team member
Given user is on Mylo Assignment Summary page for file ID "611073"
And user selects "Emac" as role in the dropdown section after clicking on "Add" button
And pop up should appear with the message "A current EMAC already exists for this assignment. Do you want to replace this EMAC?" after clicking "Save" button on selecting different team member with "EMAC"
When user clicks on "Yes" button
Then new row should be added for "EMAC" with updated team member, End Date to current date
And all the values are readonly in the AiresFileTeam grid

 @IRIS-687 @Mylo-Regression
Scenario Outline: Mylo-Validate Sales Option Availability With Respect to Resource Id of MyloUsers
Given user has logged into the Mylo application with mentioned userType "<UserType>" 
And user selects "File" section after clicking on "Assignment" option in the Mylo Menu on the sidebar
And user views Summary Tab under Assignment after clicking on Execute button with FileID "611070"
When user clicks on role dropdown after clicking on "Add" button
Then "SALES" role options availability should depends on the type of Users "<UserType>" logged in  
Examples:
|UserType          |
|With Resource15   |
|Without Resource15|

