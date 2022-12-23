Feature: Validate the functionality of Mylo Journey Create New File section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Create New File"

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application

@IRIS-1674 @217630 @Mylo:217696 @Mylo-Regression
Scenario: Mylo-Validate Toast Messages for Mandatory fields of Create New File section
Given he is on CreateNewFile section after clicking on "New File" displayed in left panel under "Journey" section
Then following validation messages should be displayed, if leaving below mandatory fields blank under "CreateNewFile" section
|TransfereeFirstName|TransfereeLastName|Client name               |Office    |Policy Type    |Tax Treatment|Message                  | 
|                   |AutoMyloLastName  |Aires QA Automation Client|CRO       |Select One     |Select One   |First name is required.  |
|AutoMyloFirstName  |                  |Aires QA Automation Client|CRO       |Select One     |Select One   |Last name is required.   |
|AutoMyloFirstName  |AutoMyloLastName  |                          |CRO       |Select One     |Select One   |Client name is required. |
|AutoMyloFirstName  |AutoMyloLastName  |Aires QA Automation Client|Select One|Select One     |Select One   |Office is required.      |
|AutoMyloFirstName  |AutoMyloLastName  |Aires QA Automation Client|CRO       |Domestic Policy|Select One   |Tax Treatment is required|

@IRIS-1674  @217630 @Mylo:217697 @Mylo-Regression
Scenario: Mylo-Validate Toast Message for Client,PolicyType & Journey Type combination of Create New File section
Given he is on CreateNewFile section after clicking on "New File" displayed in left panel under "Journey" section
And no dropdown options for client is visible for invalid client "19586" entered
When he selects "Not Affinity Enabled" client with journeyType as "Non-Relocation" after all mandatory fields provided
Then policyType dropdown field should be readonly field for affinity enabled journey type under CreateNewFile section
And message "Please select a different journey type" should be displayed after he clicks on "Create New File" button

@IRIS-1674 @217630 @Mylo:217698 @Mylo-Regression
Scenario: Mylo-Validate Toast Messages for different New File fields with SpecialCharacters
Given he is on CreateNewFile section after clicking on "New File" displayed in left panel under "Journey" section
Then messages corresponding to below fields should be displayed after entering "specialCharacters" for different fields of New File section
|Field Name         |Message                                  |
|TransfereeFirstName|Tag Scripts are not allowed in first name|
|TransfereeLastName |Tag Scripts are not allowed in last name |

@IRIS-1674 @217629, @217631, @217632, @217633, @217634, @217635, @217636, @217637, @217638, @217639, @217640, @217641  @Mylo:217699 @Mylo-Regression
Scenario:  Mylo-Validate Boundary Conditions for New File fields & Data Displayed for Newly Created File in Different sections on Mylo Journey page
Given he has provided all mandatory information on "New File" section with below Character Limit for mentioned fields
|Field Name          |CharacterLength |
|TransfereeFirstName |31              |
|TransfereeLastName  |61              |
When he clicks on "Create New File" button present under New File section
Then all values should be successfully saved as per below character limit for mentioned fields under "Purple bubble","File Information","Top right corner","Transferee","Primary Contact","Aires File Team" sections on Journey Page
|Field Name|CharacterLength |
|FirstName |30              |
|LastName  |60              |
And following information should be displayed under different sections mentioned below on Journey Page
|Section Name                  |Message                                      |
|Benefits At A Glance          |Benefits Currently Do Not Exist for this File|
|Identification & Documentation|No Identification/Documentation on File      |
|Authorization/Tracking Numbers|No Authorization/Tracking on File            |