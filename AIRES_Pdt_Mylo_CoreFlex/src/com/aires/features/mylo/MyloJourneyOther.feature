Feature: Validate the functionality of Mylo Journey Other section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Other" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-1637 @217598 @217599 @217600 @Mylo:217675 @Mylo-Regression
Scenario:  Mylo-Validate Options available for Different Other Dropdown fields on Mylo Journey page with the Database
Given he is on "Add Other" section after clicking on 'Add' link displayed in right panel under Other section for "domesticPolicyType" fileID
When he clicks on below Other dropdown fields
|Field Name        |
|Gender            |
|Destination       |
#|Citizenship      |
Then list of values displayed in the dropdown for below Other fields should match with the values present in respective tables on database
|Field Name        |
|Gender            |
|Destination       |
#|Citizenship      |

@IRIS-1637 @217642 @217645 @Mylo:217676  @Mylo-Regression
Scenario: Mylo-Validate Toast Messages for Mandatory fields of Other on Mylo Journey page
Given he is on Other section after clicking on "Other Dropdown arrow" displayed in right panel under "Transferee and Family" section for "transfereeMemberDetails" fileID
And he enters below fields under Other section after clicking on "Edit" button
|OtherFirstName   	    |OtherLastName         |Message                                          | 
|                       |AutoMyloLastNameOther |You need to fill in the family member first name!|
|AutoMyloFirstNameOther |                      |You need to fill in the family member last name! |
When he clicks on "Save" button after entering below valid other data for mandatory fields under "Transferee and Family" section
|OtherFirstName   	    |OtherLastName          |Message                                          | 
|AutoMyloFirstNameOther |AutoMyloLastNameOther  |Your changes have been successfully saved.|
Then entered data for below other fields should be successfully saved in "Transferee and Family" section
|Field Name       |
|OtherFirstName   |
|OtherLastName    |

@IRIS-1637 @217644 @217647 @217649 @217651 @217654 @Mylo:217677 @Mylo-Regression
Scenario: Mylo-Validate Toast Messages for different Other fields with SpecialCharacters on Mylo Journey page
Given he is on Other section after clicking on "Other Dropdown arrow" displayed in right panel under "Transferee and Family" section for "transfereeMemberDetails" fileID
Then messages corresponding to below fields should be displayed after entering "specialCharacters" for different fields of Other section under "Transferee and Family" section 
|Field Name        |Message                                      |
|OtherFirstName    |Tag Scripts are not allowed in first name    |
|OtherLastName     |Tag Scripts are not allowed in last name     |
|OtherMiddleName   |Tag Scripts are not allowed in middle name   |
|OtherSuffix       |Tag Scripts are not allowed in suffix        |
|OtherMaidenName   |Tag Scripts are not allowed in maiden name   |

@IRIS-1637 @217643 @217646 @217648 @217650 @217653 @217663 @Mylo:217678 @Mylo-Regression
Scenario:  Mylo-Validate Boundary Conditions for Character Limit validations for different Other fields on Mylo Journey page 
Given he is on Other section after clicking on "Other Dropdown arrow" displayed in right panel under "Transferee and Family" section for "transfereeAllMemberDetails" fileID
And he enters below invalid data for different fields with other mandatory data being provided under Other section
|Field Name     |CharacterLength |
|OtherFirstName |31              |
|OtherLastName  |61              |
|OtherMiddleName|31              |
|OtherSuffix    |16              |
|OtherMaidenName|61              |
When he clicks on "Save" button present under Other section
Then values should be successfully saved as per below character limit set for different fields under Other section
|Field Name     |CharacterLength |
|OtherFirstName |30              |
|OtherLastName  |60              |
|OtherMiddleName|30              |
|OtherSuffix    |15              |
|OtherMaidenName|60              |

@IRIS-1637 @217656 @217657 @217658 @Mylo:217679 @Mylo-Regression
Scenario:  Mylo-Validate Toast Messages for Mandatory fields of Phone Field under Other section on Mylo Journey page
Given he is on Other section after clicking on "Other Dropdown arrow" displayed in right panel under "Transferee and Family" section for "transfereeAllMemberDetails" fileID
And messages corresponding to below fields should be displayed after entering below field values under Other section after clicking on "Other Add Phone" button
|Other Phone number    |Other OrgDest Type   |Other Phone Type   |Message        					| 
|                      |Random               |Random             |You need to fill in a phone number!|
|6854759685            |Select One           |Random             |You need to select a location!     |
|7894561235            |Random               |Select One         |You need to select a phone type!   |
And he enters below data for different fields of "Other Add Phone" under Other section
|Field Name                |CharacterLength |Other OrgDest Type    |Other Phone Type  |
|Other Phone number        |31              |Random                |Random            |
When he clicks on "Save" button present under Other section
Then values should be successfully saved as per below character limit set for different fields of "Other Add Phone" under Other section
|Field Name           |CharacterLength |
|Other Phone number   |30              |
And data for "Other Add Phone" field should be removed successfully after clicking on Delete icon under Other section

@IRIS-1637 @217660 @217661 @217662 @Mylo:217680 @Mylo-Regression
Scenario:  Mylo-Validate Toast Messages for Mandatory fields of Email Field under Other section on Mylo Journey page
Given he is on Other section after clicking on "Other Dropdown arrow" displayed in right panel under "Transferee and Family" section for "transfereeAllMemberDetails" fileID
And messages corresponding to below fields should be displayed after entering below field values under Other section after clicking on "Other Add Email" button
|Other Email Address          |Other Email Type    |Message        			               | 
|                             |Other               |Please enter email address!        |
|test@aires.com               |Select One          |Please select email type!          |
|qwedssa                      |Other               |Email address (qwedssa) is invalid!|
And he enters below data for different fields of "Other Add Email" under Other section
|Field Name                   |Field Value                   |Other Email Type |
|Other Email Address          |test@aires.com                |Other            |
When he clicks on "Save" button present under Other section
Then values should be successfully saved for different fields under Other section
|Field Name               |
|Other Email Address      |
|Other Email Type         |
And data for "Other Add Email" field should be removed successfully after clicking on Delete icon under Other section

@IRIS-1637 @217659 @Mylo:217681 @Mylo-Regression
Scenario:  Mylo-Validate CheckBox selection of Phone and Email Field under Other section on Mylo Journey page
Given he is on Other section after clicking on "Other Dropdown arrow" displayed in right panel under "Transferee and Family" section for "relocationPolicyType" fileID
And other already has a "Other Phone number" as preferred number with "Other Email Address" as preferred email
When he checks the preferred box for another other number after clicking on "Other Add Phone" button
Then previous selected preferred checkbox for "Other Phone number" should be cleared with latest selected preferred box AS-IS under Other section
And previous selected preferred checkbox for "Other Email Address" should be cleared with latest selected preferred box AS-IS after he checks the preferred box for another email on clicking "Other Add Email" button under Other section

@IRIS-1637 @217652 @217655 @Mylo:217682 @Mylo-Regression
Scenario:  Mylo-Validate Mandatory Message for Relationship field and Invalid birthdate under Other section on Mylo Journey page
Given he is on "Add Other" section after clicking on 'Add' link displayed in right panel under Other section for "domesticPolicyType" fileID
And he enters below fields under Other section
|OtherFirstName   	   |OtherLastName        |Message                                        | 
|AutoMyloFirstNameOther|AutoMyloLastNameOther|You need to fill in the family member relation!|
When he clicks on "Save" button after entering "Relationships" as "Other" with "02/31/3100" invalid date in "OtherDateOfBirth" field under Other section
Then toast message "Invalid birthdate!" should be displayed with "OtherDateOfBirth" box highlighted under Other section