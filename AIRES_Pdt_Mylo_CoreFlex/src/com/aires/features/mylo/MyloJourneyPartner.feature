Feature: Validate the functionality of Mylo Journey Partner section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Partner" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-1450 @217120 @217121 @217122 @217123 @217124 @Mylo:217560 @Mylo-Regression
Scenario:  Mylo-Validate Options available for Different Partner Dropdown fields on Mylo Journey page with the Database
Given he is on "Add Partner" section after clicking on 'Add' link displayed in right panel under "Transferee and Family" section for  "Active Assignment" fileID
When he clicks on below Partner dropdown fields
|Field Name        |
|Gender            |
|New Destination   |
|Relationships     |
#|Citizenship      |
Then list of values displayed in the dropdown for below Partner fields should match with the values present in respective tables on database
|Field Name        |
|Gender            |
|New Destination   |
|Relationships     |
#|Citizenship      |

@IRIS-1543 @217539 @217542 @Mylo:217561 @Mylo-Regression
Scenario: Mylo-Validate Toast Messages for Mandatory fields of Partner on Mylo Journey page
Given he is on Partner section after clicking on "Partner Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Partner Data" fileID
And he enters below fields under Partner section after clicking on "Edit" button
|PartnerFirstName   	    |PartnerLastName         |Message                                          | 
|                         |AutoMyloLastNamePartner |You need to fill in the family member first name!|
|AutoMyloFirstNamePartner |                        |You need to fill in the family member last name! |
When he clicks on "Save" button after entering below valid partner data for mandatory fields under "Transferee and Family" section
|PartnerFirstName         |PartnerLastName          |Message                                   |
|AutoMyloFirstNamePartner |AutoMyloLastNamePartner  |Your changes have been successfully saved.|
Then entered data for below partner fields should be successfully saved in "Transferee and Family" section
|Field Name         |
|PartnerFirstName   |
|PartnerLastName    |

@IRIS-1543 @217541 @217544 @217546 @217548 @217551 @Mylo:217562 @Mylo-Regression
Scenario: Mylo-Validate Toast Messages for different Partner fields with SpecialCharacters on Mylo Journey page
Given he is on Partner section after clicking on "Partner Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Partner Data" fileID
Then messages corresponding to below fields should be displayed after entering "specialCharacters" for different fields of Partner section under "Transferee and Family" section 
|Field Name          |Message                                      |
|PartnerFirstName    |Tag Scripts are not allowed in first name    |
|PartnerLastName     |Tag Scripts are not allowed in last name     |
|PartnerMiddleName   |Tag Scripts are not allowed in middle name   |
|PartnerSuffix       |Tag Scripts are not allowed in suffix        |
|PartnerMaidenName   |Tag Scripts are not allowed in maiden name   |
|PartnerPreferredName|Tag Scripts are not allowed in preferred name|

@IRIS-1543 @217540 @217543 @217545 @217547 @217550 @Mylo:217563 @Mylo-Regression
Scenario:  Mylo-Validate Boundary Conditions for Character Limit validations for different Partner fields on Mylo Journey page 
Given he is on Partner section after clicking on "Partner Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Partner All Data" fileID
And he enters below invalid data for different fields with other mandatory data being provided under Partner section
|Field Name       |CharacterLength |
|PartnerFirstName |31              |
|PartnerLastName  |61              |
|PartnerMiddleName|31              |
|PartnerSuffix    |16              |
|PartnerMaidenName|61              |
When he clicks on "Save" button present under Partner section
Then values should be successfully saved as per below character limit set for different fields under Partner section
|Field Name       |CharacterLength |
|PartnerFirstName |30              |
|PartnerLastName  |60              |
|PartnerMiddleName|30              |
|PartnerSuffix    |15              |
|PartnerMaidenName|60              |

@IRIS-1543 @217553 @217554 @217555 @Mylo:217564 @Mylo-Regression
Scenario:  Mylo-Validate Toast Messages for Mandatory fields of Phone Field under Partner section on Mylo Journey page
Given he is on Partner section after clicking on "Partner Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Partner All Data" fileID
And messages corresponding to below fields should be displayed after entering below field values under Partner section after clicking on "Partner Add Phone" button
|Partner Phone number|Partner OrgDest Type |Partner Phone Type |Message        					| 
|                    |Random               |Random             |You need to fill in a phone number!|
|6854759685          |Select One           |Random             |You need to select a location!     |
|7894561235          |Random               |Select One         |You need to select a phone type!   |
And he enters below data for different fields of "Partner Add Phone" under Partner section
|Field Name                     |CharacterLength |Partner OrgDest Type    |Partner Phone Type    |
|Partner Phone number           |31              |Random                  |Random                |
When he clicks on "Save" button present under Partner section
Then values should be successfully saved as per below character limit set for different fields of "Partner Add Phone" under Partner section
|Field Name             |CharacterLength |
|Partner Phone number   |30              |
And data for "Partner Add Phone" field should be removed successfully after clicking on Delete icon under Partner section

@IRIS-1543 @217557 @217558 @217559 @Mylo:217565 @Mylo-Regression
Scenario:  Mylo-Validate Toast Messages for Mandatory fields of Email Field under Partner section on Mylo Journey page
Given he is on Partner section after clicking on "Partner Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Partner All Data" fileID
And messages corresponding to below fields should be displayed after entering below field values under Partner section after clicking on "Partner Add Email" button
|Partner Email Address      |Partner Email Type   |Message        			          | 
|                           |Random               |Please enter email address!        |
|test@aires.com             |Select One           |Please select email type!          |
|qwedssa                    |Random               |Email address (qwedssa) is invalid!|
And he enters below data for different fields of "Partner Add Email" under Partner section
|Field Name                     |Field Value                   |Partner Email Type |
|Partner Email Address          |test@aires.com                |Random             |
When he clicks on "Save" button present under Partner section
Then values should be successfully saved for different fields under Partner section
|Field Name                    |
|Partner Email Address      |
|Partner Email Type         |
And data for "Partner Add Email" field should be removed successfully after clicking on Delete icon under Partner section

@IRIS-1543 @217556 @Mylo:217602 @Mylo-Regression
Scenario:  Mylo-Validate CheckBox selection of Phone and Email Field under Partner section on Mylo Journey page
Given he is on Partner section after clicking on "Partner Dropdown arrow" displayed in right panel under "Transferee and Family" section for "Relocation Policy" fileID
And partner already has a "Partner Phone number" as preferred number with "Partner Email Address" as preferred email
When he checks the preferred box for another partner number after clicking on "Partner Add Phone" button
Then previous selected preferred checkbox for "Partner Phone number" should be cleared with latest selected preferred box AS-IS under Partner section
And previous selected preferred checkbox for "Partner Email Address" should be cleared with latest selected preferred box AS-IS after he checks the preferred box for another email on clicking "Partner Add Email" button under Partner section

@IRIS-1543 @217549 @217552 @Mylo:217603 @Mylo-Regression
Scenario:  Mylo-Validate Mandatory Message for Relationship field and Invalid birthdate under Partner section on Mylo Journey page
Given he is on "Add Partner" section after clicking on 'Add' link displayed in right panel under "Transferee and Family" section for  "Active Assignment" fileID
And he enters below fields under Partner section
|PartnerFirstName   	    |PartnerLastName       |Message                                        | 
|AutoMyloFirstNamePartner|AutoMyloLastNamePartner|You need to fill in the family member relation!|
When he clicks on "Save" button after entering "Relationships" as "Spouse" with "02/31/3100" invalid date in "PartnerDateOfBirth" field
Then toast message "Invalid birthdate!" should be displayed with "PartnerDateOfBirth" box highlighted under Partner section