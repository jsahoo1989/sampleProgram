Feature: Validate the functionality of Mylo Journey Authorization/Tracking section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Authorization/Tracking" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-1868 @217945 @217946 @217948 @217949 @Mylo:217976 @Mylo-Regression
Scenario Outline:  Mylo-Validate Edit/Add Option availability for Mylo Journey Authorization/Tracking section with different UserTypes
Given he has logged into the Mylo application with mentioned userType "<UserType>" 
And he is on Mylo Journey Summary page for file ID with "activeAssignment" 
When he views "Authorization/Tracking" section
Then "Edit","Add" button should be enabled for Resource300139 or disabled for Without Resource300139 depending on "<UserType>"
And he should be able to view the comments by hovering over to the Authorization/Tracking comments sections
Examples:
|UserType              |
|With Resource300139   |
|Without Resource300139|

@IRIS-1868 @217947 @Mylo:217977 @Mylo-Regression
Scenario:  Mylo-Validate Adding Auth & Tracking information where Auth/Track information does not exist on Mylo Journey page
Given he is on Mylo Journey Summary page for file ID "611085"
And Authorization/Tracking Information does not exist for a file
When he clicks on the box with the "No Authorization / Tracking on File"
Then a new row is added with below fields on Authorization/Tracking section
|Type|Number|Auth Form Label|Comment|

@IRIS-1868 @217950 @217951 @Mylo:217978 @Mylo-Regression
Scenario Outline:  Mylo-Validate Edit/Add Option availability of Mylo Journey Authorization/Tracking with respect to File Status
Given he is on Mylo Journey Summary page for file ID with "<FileType>"
And "Status" of the file should be "<FileStatus>"  after clicking on "Details Carrot" on FileInformation section
When he views "Authorization/Tracking" section
Then "Edit","Add" button should be disabled for both "<FileStatus>" status
Examples:
|FileType                  |FileStatus|
|closedFile_withAuthTrack  |Closed    |
|canceledFile_withAuthTrack|Canceled  |

@IRIS-1868 @217952 @217953 @Mylo:217979 @Mylo-Regression
Scenario Outline:  Mylo-Validate Number History for Mylo Journey Authorization/Tracking section with different UserTypes
Given he has logged into the Mylo application with mentioned userType "<UserType>" 
And he is on Mylo Journey Summary page for file ID with "activeAssignment" 
When he clicks on "history" label of "Authorization/Tracking" section
Then popup should be displayed with below fields for Resource300139 or doesnot appear for Without Resource300139 depending on "<UserType>" logged in
|History|Updated by|Update Date|
Examples:
|UserType              |
|With Resource300139   |
|Without Resource300139|

@IRIS-1868 @217955 @217956 @Mylo:217980 @Mylo-Regression
Scenario:  Mylo-Validate Warning Messages for Mandatory fields of Authorization/Tracking section on Mylo Journey page
Given he is on Mylo Journey Summary page for file ID with "activeAssignment"
And a new row is added with below fields after clicking on "Add" icon on Authorization/Tracking section
|Type|Number|Auth Form Label|Comment|
When he clicks on "Save" button on Authorization/Tracking section
Then below toast messages should be displayed for respective mandatory fields on Mylo Journey page
|FieldName   |Message            | 
|Type        |Type is required.  |
|Number      |Number is required.|

@IRIS-1868 @217954 @217957 @217958 @Mylo:217981 @Mylo-Regression
Scenario:  Mylo-Validate Character Limit Boundary Conditions for fields of Authorization/Tracking section on Mylo Journey page
Given he is on Mylo Journey Summary page for file ID with "activeAssignment"
And he has provided all mandatory information with below Character Limit for mentioned fields after clicking on "Add" icon on Authorization/Tracking section
|Field Name |CharacterLength |
|Number     |201             |
|Comment    |501             |
When he clicks on "Save" button on Authorization/Tracking section
Then all values should be successfully saved as per below character limit for mentioned fields under Authorization/Tracking section on Mylo Journey Page
|Field Name |CharacterLength |
|Number     |200             |
|Comment    |500             |
And Saved data should get deleted after clicking on "Delete" icon under Authorization/Tracking section

@IRIS-1868 @217959 @217960 @Mylo:217982 @Mylo-Regression
Scenario:  Mylo-Validate Sorting functionality of Mylo Journey Authorization/Tracking section with different categories and Sorting order
Given he is on Mylo Journey Summary page for file ID with "existingAuthTrackData"
Then authTracking fields should be sorted as per the "<Category>" selected with "<Sorting Order>" from "Sort By" dropdown on Authorization/Tracking section
|Field Name|Sorting Order| 
|Type    |Ascending    |
|Number  |Ascending    |
|Type    |Descending   |
|Number  |Descending   |


