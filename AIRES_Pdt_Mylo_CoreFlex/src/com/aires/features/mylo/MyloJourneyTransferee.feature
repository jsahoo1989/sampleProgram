Feature: Validate the functionality of Mylo Journey Transferee section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Transferee and Family" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application


@IRIS-1283
Scenario:  Mylo-Validate CheckBox selection of Phone and Email Field under Transferee section on Mylo Journey page
#Given he is on "Transferee" section after clicking on "Transferee Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Transferee All Data" fileID
And transferee detail section has below corresponding field and values
|TransfereeFirstName|TransfereeLastName |TransfereeMiddleName |TransfereeSufix|TransfereeGrade|TransfereeTitle|TransfereeMaidenName|TransfereePreferredName|Marital Status|Citizenship|Gender|
|AutoMyloqwer       |TestMyloqwer       |MiddleMyloqwer       |SuffixMyloqwer |GradeMyloqwer  |TitleMyloqwer  |MaidenMyloqwer      |PreferredMyloqwer      |Single        |USA        |Male|
And message "Nonbinary, Intersex or Gender-Nonconforming" is displayed after he hovers on "X" in Gender dropdown field
When he clicks on "Save" button after entering "" invalid date in "Date of Birth" field
Then toast message "Invalid birthdate!" should be displayed with "Date of Birth" box highlighted

@IRIS-1283 @217085 @217086 @217090 @Mylo-Regression
Scenario:  Mylo-Validate Options available for Different Transferee Dropdown fields under Transferee and Family section on Mylo Assignment page with the Database
Given he is on "Transferee" section after clicking on "Transferee Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Active Assignment" fileID
When he clicks on below dropdown fields
|Field Name    |
|Marital Status|
|Pronouns      |
|Transferee Phone Type    |
|Transferee OrgDest Type |
|Citizenship   |
|Transferee Email Type    |
Then list of values displayed in the dropdown for below fields should match with the values present in respective tables on database
|Field Name    |
|Marital Status|
|Pronouns      |
|Transferee Email Type    |
|Transferee Phone Type    |
|Transferee OrgDest Type   |
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
Scenario:  Mylo-Validate Boundary Conditions for Character Limit validations for different Transferee fields under Transferee and Family section on Mylo Journey page 
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

@IRIS-1344 @Mylo-Regression
Scenario:  Mylo-Validate Toast Messages for Mandatory fields of Phone Field under Transferee section on Mylo Journey page
Given he is on "Transferee" section after clicking on "Transferee Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Transferee All Data" fileID
And messages corresponding to below fields should be displayed after entering below field values under "Transferee" section after clicking on "Transferee Add Phone" button
|Transferee Phone number|Transferee OrgDest Type |Transferee Phone Type |Message        					| 
|                       |Random                  |Random                |You need to fill in a phone number!|
|6854759685             |Select One              |Random                |You need to select a location!     |
|7894561235             |Random                  |Select One            |You need to select a phone type!   |
And he enters below data for different fields of "Transferee Add Phone" section under "Transferee" section
|Field Name                     |CharacterLength |Transferee OrgDest Type |Transferee Phone Type |
|Transferee Phone number        |31              |Random                  |Random                |
When he clicks on "Save" button present under "Transferee" section
Then values should be successfully saved as per below character limit set for different fields of "Transferee Add Phone" section under "Transferee" section
|Field Name             |CharacterLength |
|Transferee Phone number|30              |
And data for "Transferee Add Phone" field should be removed successfully after clicking on Delete icon under "Transferee" section

@IRIS-1344 @Mylo-Regression
Scenario:  Mylo-Validate Toast Messages for Mandatory fields of Email Field under Transferee section on Mylo Journey page
Given he is on "Transferee" section after clicking on "Transferee Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Transferee All Data" fileID
And messages corresponding to below fields should be displayed after entering below field values under "Transferee" section after clicking on "Transferee Add Email" button
|Transferee Email Address   |Transferee Email Type|Message        			          | 
|                           |Random               |Please enter email address!        |
|test@aires.com             |Select One           |Please select email type!          |
|qwedssa                    |Random               |Email address (qwedssa) is invalid!|
And he enters below data for different fields of "Transferee Add Email" section under "Transferee" section
|Field Name                     |Field Value                   |Transferee Email Type |
|Transferee Email Address       |test@aires.com                |Random         |
When he clicks on "Save" button present under "Transferee" section
Then values should be successfully saved for different fields under "Transferee" section
|Field Name                    |
|Transferee Email Address      |
|Transferee Email Type         |
And data for "Transferee Add Email" field should be removed successfully after clicking on Delete icon under "Transferee" section

@IRIS-1344 @Mylo-Regression
Scenario:  Mylo-Validate CheckBox selection of Phone and Email Field under Transferee section on Mylo Journey page
Given he is on "Transferee" section after clicking on "Transferee Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Transferee All Data" fileID
And transferee already has a "Transferee Phone number" as preferred number with "Transferee Email Address" as preferred email
When he checks the preferred box for another number after clicking on "Transferee Add Phone" button
Then previous selected preferred checkbox for "Transferee Phone number" should be cleared with latest selected preferred box AS-IS
And previous selected preferred checkbox for "Transferee Email Address" should be cleared with latest selected preferred box AS-IS after he checks the preferred box for another email on clicking "Transferee Add Email" button



