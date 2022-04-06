Feature: Validate the functionality of Mylo Assignment Identification & Documentation section
  As a Mylo user, I want to validate the functionality for "Mylo Assignment - Identification & Documentation" section

Background: Login to the  Mylo application
    Given he has logged into the 'Mylo' application
   
@IRIS-1155 @Mylo-Regression 
Scenario:  Mylo-Validate enability of Edit, Add, Save icons of Identification & Documentation section for different UserType on Mylo Assignment page
Given he has logged into the Mylo application with mentioned userType "Without Resource300140" 
And "Edit" "Add" "Save" icons of Identification Records section is disabled for "Active Assignment" fileID
When he views Identification Records section for "Active Assignment" file ID after relogging into the Mylo application with userType "With Resource300140"
Then "Edit" "Add" "Save" icons of Identification Records section should get enabled for "Active Assignment" fileID

@IRIS-1155 @Mylo-Regression 
Scenario:  Mylo-Validate enability of Edit, Add, Save icons of Identification & Documentation section for different File Status on Mylo Assignment page
Given he is on Mylo Assignment Summary page for file ID with "Closed Identity Doc" status
And "Add" "Edit" "Save" icons of Identification Records section is disabled for "Closed Identity Doc" status fileID
When he views Identification Records section for "Canceled" status file ID
Then "Add" "Edit" "Save" icons of Identification Records section should get disabled for "Canceled" status fileID

@IRIS-1155 @Mylo-Regression
Scenario:  Mylo-Validate Warning Messages for Mandatory fields and Cancel option of Identification & Documentation on Mylo Assignment page
Given he is on Mylo Assignment Summary page for file ID with "Active Assignment" data
And he enters below invalid data combination for mandatory fields of "Identification & Documentation" section
|IdentityType               |Number    |FromDate  |Message                                      | 
|Diplomatic Passport        |          |04/03/2022|You need to fill in an Identification Number!|
|Cedula                     |59        |          |From Date is required!                       |
|Select One                 |59        |04/03/2022|You need to select an Identification Type!   |
When he clicks on the "Cancel" button after entering below valid data for mandatory fields of "Identification & Documentation" section
|IdentityType|Number|FromDate  |
|Cedula      |  60  |04/03/2022|
Then "You have selected Cancel which will discard any unsaved changes. Do you wish to proceed?" message should get displayed

@IRIS-1155 @Mylo-Regression
Scenario:  Mylo-Validate Warning Message and functionality of Cancel option for Mandatory fields of Temporary Address on Mylo Assignment page under Other Addresses section 
Given he is on Mylo Assignment Summary page for file ID with "Active Assignment" data
And he clicks on the "Cancel" button after entering below valid data for mandatory fields of "Identification & Documentation" section by clicking on "Add" button
|IdentityType   |Number|FromDate  |
|Cedula         |  59  |04/03/2022|
And he is redirected back to the edit screen after clicking on "No" option
When he clicks on "Yes" option after clicking on "Cancel" button
Then identification record should not get updated as well as data should get reset to the initial values.