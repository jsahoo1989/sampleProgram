Feature: Validate the functionality of Mylo Assignment Identification & Documentation section
  As a Mylo user, I want to validate the functionality for "Mylo Assignment - Identification & Documentation" section

Background: Login to the  Mylo application
    Given he has logged into the 'Mylo' application
   
@IRIS-1155 @217069 @217066 @217054 @IRIS-1225 @217510 @Mylo-Regression
Scenario:  Mylo-Validate enability of Edit, Add, Save icons of Identification & Documentation section for different UserType on Mylo Journey page
Given he has logged into the Mylo application with mentioned userType "Without Resource300140"
And "Edit" "Add" "Save" icons of Identification Records section is disabled for "Active Assignment" fileID
When he views Identification Records section for "Active Assignment" file ID after relogging into the Mylo application with userType "With Resource300140"
Then "Edit" "Add" "Save" icons of Identification Records section should get enabled for "Active Assignment" fileID

@IRIS-1155 @217067 @217068 @217511 @Mylo-Regression 
Scenario:  Mylo-Validate enability of Edit, Add, Save icons of Identification & Documentation section for different File Status on Mylo Journey page
Given he is on Mylo Assignment Summary page for file ID with "Closed Identity Doc" status
And "Add" "Edit" "Save" icons of Identification Records section is disabled for "Closed Identity Doc" status fileID
When he views Identification Records section for "Canceled" status file ID
Then "Add" "Edit" "Save" icons of Identification Records section should get disabled for "Canceled" status fileID

@IRIS-1155 @217072 @217074 @217076 @217056 @217512 @Mylo-Regression
Scenario:  Mylo-Validate Warning Messages for Mandatory fields and Cancel option of Identification & Documentation on Mylo Journey page
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

@IRIS-1155 @217077 @217078 @217513 @Mylo-Regression
Scenario:  Mylo-Validate Yes/no buttons for Cancel option of Identification & Documentation section on Mylo Journey page 
Given he is on Mylo Assignment Summary page for file ID with "Active Assignment" data
And he clicks on the "Cancel" button after entering below valid data for mandatory fields of "Identification & Documentation" section by clicking on "Add" button
|IdentityType   |Number|FromDate  |
|Cedula         |  59  |04/03/2022|
And he is redirected back to the edit screen after clicking on "No" option
When he clicks on "Yes" option after clicking on "Cancel" button
Then identification record should not get updated as well as data should get reset to the initial values.

@IRIS-1155 @IRIS-1225 @217070 @217071 @217079 @217053 @217059 @217514 @Mylo-Regression
Scenario:  Mylo-Validate Save and Update functionality for Multiple Rows of Identification & Documentation section on Mylo Journey page 
Given he is on Mylo Assignment Summary page for file ID with "Active Assignment" data
And message "Your changes have been successfully saved." is displayed after clicking on "Save" button with below valid data for multiple rows of "Identification & Documentation" section
|Row|IdentityType       |Country |Number    |FromDate  |ToDate    | 
|1  |Drivers License    |USA     |   12     |04/03/2022|current   |
|2  |Cedula             |Canada  |   15     |04/01/2022|04/02/2022|
|3  |Diplomatic Passport|Random  |   10      |03/03/2022|03/04/2022|
When he clicks on "Edit" button after verifying the saved values
Then he should be able to update below fields upon clicking on "Save" button
|Row|IdentityType       |Country|Number    |FromDate  |ToDate    | 
|2  |Drivers License    |  USA  | 5        |02/02/2022|02/04/2022|
|3  |Random             |  USA  | 8        |03/01/2022|03/03/2022|
And Saved identification data should get deleted after clicking on "Remove" button for 3 rows

@IRIS-1155 @IRIS-1225 @217075 @217080 @217081 @217515  @Mylo-Regression
Scenario:  Mylo-Validate Warning Messages for Invalid ToDate with Multiple Rows of Identification & Documentation section on Mylo Journey page
Given he is on Mylo Assignment Summary page for file ID with "Active Assignment" data
When he clicks on "Save" button after entering below invalid ToDate data for multiple rows of "Identification & Documentation" section
|Row|IdentityType       |Country |Number    |FromDate  |ToDate    | 
|1  |Random             |Canada  |   15     |04/01/2022|32/02/2022|
|2  |Random             |Canada  |   15     |04/01/2022|03/02/2022|
Then "Invalid To Date!" message should get displayed for multiple records

@IRIS-1225 @217057 @217058 @217516 @Mylo-Regression
Scenario:  Mylo-Validate Country and IdentityType dropdown options of Identification & Documentation section on Mylo Journey page
Given he is on Mylo Assignment Summary page for file ID with "Active Assignment" data
And he cicks on "Identity Type" field to match the values appearing inside the dropdown with the database after clicking on "Add" icon of "Identification & Documentation" section
When he clicks on "Country" dropdown field
Then dropdown should display "USA" as the first country with remaining countries in alphabetical order

@IRIS-1225 @217064 @217517 @Mylo-Regression
Scenario:  Mylo-Validate Toast Messages for Mandatory Fields and Colour of the tab associated with the field for newly added records of Identification & Documentation section on Mylo Journey page
Given he is on Mylo Assignment Summary page for file ID with "Active Assignment" data
And below toast messages are displayed after clicking on "Save" button without filling mandatory fields of "Identification & Documentation" section
|Message                                      | 
|You need to select an Identification Type!   |
|You need to fill in an Identification Number!|
|From Date is required!                       |
And the color of the tab associated with that record matches the toast messages displayed for "Identification & Documentation" section on "Assignment" page
When he clicks on "Remove" icon to delete the record of "Identification & Documentation" section
Then the toast messages should get deleted with tab color for the associated record should be restored back to its state for "Identification & Documentation" section

@IRIS-1225 @217055 @217056 @217065 @217518 @Mylo-Regression
Scenario:  Mylo-Validate Toast Messages for Mandatory Fields and Colour of the tab associated with the field for existing records of Identification & Documentation section on Mylo Journey page
Given he is on Mylo Assignment Summary page for file ID with "Transferee With Family Member" data
And below toast messages are displayed by clicking on "Save" button after removing mandatory fields for existing data of "Identification & Documentation" section
|Message                                      | 
|You need to select an Identification Type!   |
|You need to fill in an Identification Number!|
|From Date is required!                       |
And the color of the tab associated with that record matches the toast messages displayed for "Identification & Documentation" section on "Assignment" page
When he clicks on "Remove" icon to delete the record of "Identification & Documentation" section
Then the toast messages should get deleted with tab color for the associated record should be restored back to its state for "Identification & Documentation" section 
And Below data is restored for given transferee of "Identification & Documentation" section
|Row|IdentityType       |Country    |Number    |FromDate  |ToDate    | 
|1  |Cedula             |Random     |   10     |01/01/2022|current   |

@IRIS-1225 @217061 @217062 @217063 @217519 @Mylo-Regression
Scenario:  Mylo-Validate Remove functionality for existing records of Identification & Documentation section on Mylo Journey page
Given he is on Mylo Assignment Summary page for file ID with "Transferee With Other Family Members" data
And he has clicked on the tab for the family member which has Identification data in "Identification & Documentation" section
And message "You are about to remove this information from the system and it will no longer be viewable. Do you want to proceed?" is displayed after he clicks on "Remove" button
And the identification fields for the family member will remain unchanged after he clicks on "No" button
When he clicks on "Yes" option after clicking on "Remove" button
Then the identification fields are removed for the transferee from the UI
And Below data is restored for given transferee of "Identification & Documentation" section
|Row|IdentityType       |Country    |Number    |FromDate  |ToDate       | 
|1  |Cedula             |USA        |   10     |01/01/2022|04/01/2022   |