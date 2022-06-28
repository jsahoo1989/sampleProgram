Feature: Validate the functionality of Mylo Journey Dependent section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Dependent" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-1587 @217566 @217567 @217568 @217569  @Mylo:217667 @Mylo-Regression
Scenario:  Mylo-Validate Options available for Different Dependent Dropdown fields on Mylo Journey page with the Database
Given he is on "Add Dependent" section after clicking on 'Add' link displayed in right panel under Dependent section for "activeAssignment" fileID
When he clicks on below Dependent dropdown fields
|Field Name        |
|Relationships     |
|Gender            |
|Destination       |
#|Citizenship      |
Then list of values displayed in the dropdown for below Dependent fields should match with the values present in respective tables on database
|Field Name        |
|Relationships     |
|Gender            |
|Destination       |
#|Citizenship      |

@IRIS-1587 @217571 @217574 @Mylo:217668 @Mylo-Regression
Scenario: Mylo-Validate Toast Messages for Mandatory fields of Dependent on Mylo Journey page
Given he is on Dependent section after clicking on "Dependent Dropdown arrow" displayed in right panel under "Transferee and Family" section for "transfereeMemberDetails" fileID
And he enters below fields under Dependent section after clicking on "Edit" button
|DependentFirstName   	    |DependentLastName         |Message                                          | 
|                           |AutoMyloLastNameDependent |You need to fill in the family member first name!|
|AutoMyloFirstNameDependent |                          |You need to fill in the family member last name! |
When he clicks on "Save" button after entering below valid dependent data for mandatory fields under "Transferee and Family" section
|DependentFirstName   	    |DependentLastName          |Message                                          | 
|AutoMyloFirstNameDependent |AutoMyloLastNameDependent  |Your changes have been successfully saved.|
Then entered data for below dependent fields should be successfully saved in "Transferee and Family" section
|Field Name           |
|DependentFirstName   |
|DependentLastName    |

@IRIS-1587 @217573 @217576 @217578 @217580 @217583 @Mylo:217669 @Mylo-Regression
Scenario: Mylo-Validate Toast Messages for different Dependent fields with SpecialCharacters on Mylo Journey page
Given he is on Dependent section after clicking on "Dependent Dropdown arrow" displayed in right panel under "Transferee and Family" section for "transfereeMemberDetails" fileID
Then messages corresponding to below fields should be displayed after entering "specialCharacters" for different fields of Dependent section under "Transferee and Family" section 
|Field Name            |Message                                      |
|DependentFirstName    |Tag Scripts are not allowed in first name    |
|DependentLastName     |Tag Scripts are not allowed in last name     |
|DependentMiddleName   |Tag Scripts are not allowed in middle name   |
|DependentSuffix       |Tag Scripts are not allowed in suffix        |
|DependentMaidenName   |Tag Scripts are not allowed in maiden name   |

@IRIS-1587 @217572 @217575 @217577 @217579 @217582 @217601 @Mylo:217670 @Mylo-Regression
Scenario:  Mylo-Validate Boundary Conditions for Character Limit validations for different Dependent fields on Mylo Journey page 
Given he is on Dependent section after clicking on "Dependent Dropdown arrow" displayed in right panel under "Transferee and Family" section for "transfereeAllMemberDetails" fileID
And he enters below invalid data for different fields with other mandatory data being provided under Dependent section
|Field Name         |CharacterLength |
|DependentFirstName |31              |
|DependentLastName  |61              |
|DependentMiddleName|31              |
|DependentSuffix    |16              |
|DependentMaidenName|61              |
When he clicks on "Save" button present under Dependent section
Then values should be successfully saved as per below character limit set for different fields under Dependent section
|Field Name       |CharacterLength |
|DependentFirstName |30              |
|DependentLastName  |60              |
|DependentMiddleName|30              |
|DependentSuffix    |15              |
|DependentMaidenName|60              |

@IRIS-1587 @217585 @217586 @217587 @Mylo:217671 @Mylo-Regression
Scenario:  Mylo-Validate Toast Messages for Mandatory fields of Phone Field under Dependent section on Mylo Journey page
Given he is on Dependent section after clicking on "Dependent Dropdown arrow" displayed in right panel under "Transferee and Family" section for "transfereeAllMemberDetails" fileID
And messages corresponding to below fields should be displayed after entering below field values under Dependent section after clicking on "Dependent Add Phone" button
|Dependent Phone number|Dependent OrgDest Type |Dependent Phone Type |Message        					| 
|                      |Random               |Random             |You need to fill in a phone number!|
|6854759685            |Select One           |Random             |You need to select a location!     |
|7894561235            |Random               |Select One         |You need to select a phone type!   |
And he enters below data for different fields of "Dependent Add Phone" under Dependent section
|Field Name                     |CharacterLength |Dependent OrgDest Type    |Dependent Phone Type  |
|Dependent Phone number        |31              |Random                    |Random                |
When he clicks on "Save" button present under Dependent section
Then values should be successfully saved as per below character limit set for different fields of "Dependent Add Phone" under Dependent section
|Field Name               |CharacterLength |
|Dependent Phone number   |30              |
And data for "Dependent Add Phone" field should be removed successfully after clicking on Delete icon under Dependent section

@IRIS-1587 @217589 @217590 @217591 @Mylo:217672 @Mylo-Regression
Scenario:  Mylo-Validate Toast Messages for Mandatory fields of Email Field under Dependent section on Mylo Journey page
Given he is on Dependent section after clicking on "Dependent Dropdown arrow" displayed in right panel under "Transferee and Family" section for "transfereeAllMemberDetails" fileID
And messages corresponding to below fields should be displayed after entering below field values under Dependent section after clicking on "Dependent Add Email" button
|Dependent Email Address      |Dependent Email Type|Message        			          | 
|                             |Other               |Please enter email address!        |
|test@aires.com               |Select One          |Please select email type!          |
|qwedssa                      |Other               |Email address (qwedssa) is invalid!|
And he enters below data for different fields of "Dependent Add Email" under Dependent section
|Field Name                       |Field Value                   |Dependent Email Type |
|Dependent Email Address          |test@aires.com                |Other                |
When he clicks on "Save" button present under Dependent section
Then values should be successfully saved for different fields under Dependent section
|Field Name                    |
|Dependent Email Address      |
|Dependent Email Type         |
And data for "Dependent Add Email" field should be removed successfully after clicking on Delete icon under Dependent section

@IRIS-1587 @217588 @Mylo:217673 @Mylo-Regression
Scenario:  Mylo-Validate CheckBox selection of Phone and Email Field under Dependent section on Mylo Journey page
Given he is on Dependent section after clicking on "Dependent Dropdown arrow" displayed in right panel under "Transferee and Family" section for "relocationPolicyType" fileID
And dependent already has a "Dependent Phone number" as preferred number with "Dependent Email Address" as preferred email
When he checks the preferred box for another dependent number after clicking on "Dependent Add Phone" button
Then previous selected preferred checkbox for "Dependent Phone number" should be cleared with latest selected preferred box AS-IS under Dependent section
And previous selected preferred checkbox for "Dependent Email Address" should be cleared with latest selected preferred box AS-IS after he checks the preferred box for another email on clicking "Dependent Add Email" button under Dependent section

@IRIS-1587 @217581 @217584 @Mylo:217674 @Mylo-Regression
Scenario:  Mylo-Validate Mandatory Message for Relationship field and Invalid birthdate under Dependent section on Mylo Journey page
Given he is on "Add Dependent" section after clicking on 'Add' link displayed in right panel under Dependent section for "activeAssignment" fileID
And he enters below fields under Dependent section
|DependentFirstName   	    |DependentLastName        |Message                                        | 
|AutoMyloFirstNameDependent |AutoMyloLastNameDependent|You need to fill in the family member relation!|
When he clicks on "Save" button after entering "Relationships" as "Other" with "02/31/3100" invalid date in "DependentDateOfBirth" field under Dependent section
Then toast message "Invalid birthdate!" should be displayed with "DependentDateOfBirth" box highlighted under Dependent section