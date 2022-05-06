Feature: Validate the functionality of Mylo Assignment Transferee and Family section
  As a Mylo user, I want to validate the functionality for "Mylo Assignment - Transferee and Family" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application


@IRIS-1283 @217085 @217086 @217090 @Mylo-Regression
Scenario:  Mylo-Validate Options available for Different Transferee Dropdown fields under Transferee and Family section on Mylo Assignment page with the Database
Given he is on "Transferee" section after clicking on "Transferee Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Active Assignment" fileID
When he clicks on below dropdown fields
|Field Name    |
|Marital Status|
|Pronouns      |
|Phone type    |
|origin/dest   |
|Citizenship   |
|Email type    |
Then list of values displayed in the dropdown for below fields should match with the values present in respective tables on database
|Field Name    |
|Marital Status|
|Pronouns      |
|Email type    |
#|Phone type   |
#|origin/dest  |
#|Citizenship  |

   
@IRIS-1283 @217091 @217094 @Mylo-Regression
Scenario:  Mylo-Validate Toast Messages for Mandatory fields of Transferee under Transferee and Family section on Mylo Assignment page
Given he is on "Transferee" section after clicking on "Transferee Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Active Assignment" fileID
And he enters below fields under "Transferee" section after clicking on "Edit" button
|TransfereeFirstName   |TransfereeLastName |Message                                       | 
|                      |TestMylo           |You need to fill in the transferee first name!|
|AutoMylo              |                   |You need to fill in the transferee last name! |
When he clicks on "Save" button after entering below valid transferee data for mandatory fields under "Transferee and Family" section
|TransfereeFirstName   |TransfereeLastName |Message                                   |
|AutoMylo              |TestMylo           |Your changes have been successfully saved.|
Then entered data for below transferee fields should be successfully saved in "Transferee and Family" section
|Field Name           |
|TransfereeFirstName  |
|TransfereeLastName   |

@IRIS-1283 @217093 @217096 @217098 @217102 @217104 @217106 @217108 @Mylo-Regression
Scenario:  Mylo-Validate Toast Messages for different Transferee fields with SpecialCharacters under Transferee and Family section on Mylo Assignment page
Given he is on "Transferee" section after clicking on "Transferee Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Active Assignment" fileID
Then messages corresponding to below fields should be displayed after entering "specialCharacters" for different fields under "Transferee and Family" section 
|Field Name          |Message                                   |
|TransfereeFirstName |Tag Scripts are not allowed in first name |
|TransfereeLastName  |Tag Scripts are not allowed in last name  |
|TransfereeMiddleName|Tag Scripts are not allowed in middle name|
|TransfereeSufix     |Tag Scripts are not allowed in suffix     |
|TransfereeGrade     |Tag Scripts are not allowed in grade      |
|TransfereeTitle     |Tag Scripts are not allowed in title      |
|TransfereeMaidenName|Tag Scripts are not allowed in maiden name|

@IRIS-1283 @217092 @217095 @217097 @217101 @217103 @217105 @217107 @Mylo-Regression
Scenario:  Mylo-Validate Boundary Conditions for Character Limit validations for different Transferee fields under Transferee and Family section on Mylo Assignment page 
Given he is on "Transferee" section after clicking on "Transferee Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Active Assignment" fileID
And he enters below invalid data for different fields with other mandatory data being provided under "Transferee" section
|Field Name          |CharacterLength |
|TransfereeFirstName |31              |
|TransfereeLastName  |61              |
|TransfereeMiddleName|31              |
|TransfereeSufix     |16              |
|TransfereeGrade     |61              |
|TransfereeTitle     |101             |
|TransfereeMaidenName|61              |
When he clicks on "Save" button present under "Transferee" section
Then values should be successfully saved as per below character limit set for different fields under "Transferee" section
|Field Name          |CharacterLength |
|TransfereeFirstName |30              |
|TransfereeLastName  |60              |
|TransfereeMiddleName|30              |
|TransfereeSufix     |15              |
|TransfereeGrade     |60              |
|TransfereeTitle     |100             |
|TransfereeMaidenName|60              |