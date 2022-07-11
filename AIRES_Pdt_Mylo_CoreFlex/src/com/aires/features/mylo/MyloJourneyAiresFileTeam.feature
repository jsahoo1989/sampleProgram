Feature: Validate the functionality of Mylo Journey Aires File Team section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Aires File Team"

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
  
@IRIS-687 @Mylo:217524 @Mylo-Regression
Scenario Outline: Mylo-Validate No Option for Replacement of Mylo Journey Aires File Team member
Given he is on Mylo Journey Summary page for file ID with "activeAssignment"
And he selects "<Role>" with random team member from the dropdown after clicking on "Add" button
And row is not updated in the 'Aires File Team' section after clicking on "Cancel" button
And he did not find the existing team member for specified "<Role>" in the dropdown section after clicking on "Add" button
And pop up should appear with the message "A current <Role> already exists for this assignment. Do you want to replace this <Role>?" after clicking "Save" button on selecting different team member with "<Role>"
When he clicks on "No" button in AiresFileTeam
Then new row should not be added in the Aires File Team section

Examples:
|Role|
|PPC  |
|EMAC |
|SALES|

@IRIS-687 @Mylo:217525 @Mylo-Regression
Scenario:  Mylo-Validate Yes Option for Replacement of Mylo Journey Aires File Team member
Given he is on Mylo Journey Summary page for file ID with "activeAssignment"
And he selects "Emac" as role in the dropdown section after clicking on "Add" button
And pop up should appear with the message "A current EMAC already exists for this assignment. Do you want to replace this EMAC?" after clicking "Save" button on selecting different team member with "EMAC"
When he clicks on "Yes" button in AiresFileTeam
Then new row should be added for "EMAC" with updated team member, End Date to current date
And all the values are readonly in the AiresFileTeam grid

@IRIS-687 @Mylo:217526 @Mylo-Regression
Scenario Outline: Mylo-Validate Sales Option Availability With Respect to Resource Id of MyloUsers
Given he has logged into the Mylo application with mentioned userType "<UserType>" 
And he selects "File" section after clicking on "Journey" option in the Mylo Menu on the sidebar
And he views Summary Tab under Journey after clicking on Execute button with FileID "611070"
When he clicks on role dropdown after clicking on "Add" button
Then "SALES" role options availability should depends on the type of Users "<UserType>" logged in  
Examples:
|UserType          |
|Without Resource15|
|With Resource15   |