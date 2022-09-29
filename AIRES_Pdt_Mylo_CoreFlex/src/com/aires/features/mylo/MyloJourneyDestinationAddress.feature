Feature: Validate the functionality of Mylo Journey Destination Address section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Destination Address" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-2037 @218009 @218010 @Mylo:218047 @Mylo-Regression
Scenario Outline:  Mylo-Validate Edit Option availability for Mylo Journey Destination Address section with different UserTypes
Given he has logged into the Mylo application with mentioned userType "<UserType>" 
And he is on Mylo Journey Summary page for file ID with "addressExist" 
When he views "Destination Address" section after clicking on "Destination Address Details" button
Then "Destination Address Edit" button should be "<Status>" depending on "<UserType>" for "Destination Address" section on Mylo Journey Page
Examples:
|UserType              |Status  |
|With Resource300023   |Enabled |
|Without Resource300023|Disabled|

@IRIS-2037 @218023 @218024 @Mylo:218048 @Mylo-Regression
Scenario Outline:  Mylo-Validate Edit & CopyToMail Option availability of Mylo Journey Destination Address section with respect to File Status
Given he is on Mylo Journey Summary page for file ID with "<FileType>"
And "Status" of the file should be "<FileStatus>"  after clicking on "Details Carrot" on FileInformation section
When he views "Destination Address" section after clicking on "Destination Address Details" button
Then "Destination Address Edit", "Destination Address Copy to Mail" button should be disabled for both "<FileStatus>" status of "Destination Address" section
Examples:
|FileType    |FileStatus|
|closedFile  |Closed    |
|canceledFile|Canceled  |

@IRIS-2037 @218012 @Mylo:218049 @Mylo-Regression
Scenario:  Mylo-Validate Save functionality and Warning Messages for Boundary Conditions on City, ZipCode, Address1,Address2,and State field under Destination Address section on Mylo Journey page  
Given he is on "Destination Address" section after clicking on "Destination Address Edit" button displayed under it for file ID with "addressExist"
And he enters below invalid data for different fields with other mandatory data being provided for "Destination Address" section
|Field Name                  |CharacterLength |Message                                                                   |
|Destination City            |61              |Maximum length of City in destination address is 60 characters!           |
|Destination Zip Code        |11              |Maximum length of Zip/postal code in destination address is 10 characters!|
|Destination address1        |201             |Maximum length of address1 in destination address is 200 characters!      |
|Destination address2        |201             |Maximum length of address2 in destination address is 200 characters!	     |
|Destination State Text Field|61              |Maximum length of state/province in destination address is 60 characters! |
When he clicks on "Destination Address Save" button after entering below valid data for respective fields on "Destination address" section
|Field Name                  |CharacterLength |
|Destination Country         |Random          |
|Destination City            |60              |
|Destination Zip Code        |10              |
|Destination address1        |200             |
|Destination address2        |200             |
|Destination State Text Field|60              |
Then below fieldValues should be successfully saved under "Destination Address" Dropdown section
|Field Name       |
|Destination Country Value    |
|Destination State Text Field |
|Destination City             |
|Destination Zip Code         |
|Destination address1         |
|Destination address2         |

@IRIS-2037 @218013 @Mylo:218050 @Mylo-Regression
Scenario:  Mylo-Validate Warning Messages for Mandatory fields of Destination Address section on Mylo Journey page 
Given he is on "Destination Address" section after clicking on "Destination Address Edit" button displayed under it for file ID with "addressExist"
And he enters below invalid data combination of mandatory fields on "Destination Address" section
|Country   |State Text Field|City |Message                                                    | 
|Random    |60              |     |You need to fill in the city field in destination address! |
|Select One|60              |25   |You need to select a country in destination address!       |
|India     |Select One      |25   |You need to select a state in Property address!            |
|USA       |Select One      |25   |You need to select a state in Property address!            |
When he clicks on "Destination Address Save" button after entering below mandatory data on "Destination Address" section
|Field Name                  |CharacterLength |
|Destination Country         |Random          |
|Destination State Text Field|60              |
|Destination City            |25              |
Then entered data for below fields should be successfully saved in "Destination Address" Dropdown section
|Field Name                   |
|Destination City             |
|Destination State Text Field |
|Destination Country Value    |

@IRIS-2054 @218014 @Mylo:218051 @Mylo-Regression
Scenario:  Mylo-Validate Copy functionality of Destination Address section on Mylo Journey page 
Given he is on "Destination Address" section after clicking on "Destination Address Edit" button displayed under it for file ID with "addressExist"
When he clicks on "Destination Address Copy" button of "Destination Address" section after saving below data for respective fields
|Field Name                  |CharacterLength |
|Destination Country         |Random          |
|Destination City            |5               |
|Destination Zip Code        |5               |
|Destination address1        |10              |
|Destination address2        |10              |
|Destination State Text Field|10              |
Then "Destination Address Copy" button should turn green with text changes to "Copied" on "Destination Address" section
And copied "Destination Address" can be verified by pasting in the "Mailing Address address1" field of "Mailing address" section on Mylo Journey page

@IRIS-2054 @218015 @218016 @Mylo:218052 @Mylo-Regression
Scenario:  Mylo-Validate CopyToMail functionality for Yes option of Destination Address section without existing Mailing address on Mylo Journey page 
Given he is on "Destination Address" section after clicking on "Destination Address Edit" button displayed under it for file ID with "mailingAddressNotExist"
When he clicks on "Destination Address Copy to Mail" button of "Destination Address" section after saving below data for respective fields
|Field Name                  |CharacterLength |
|Destination Country         |Random          |
|Destination City            |5               |
|Destination Zip Code        |5               |
|Destination address1        |10              |
|Destination address2        |10              |
|Destination State Text Field|10              |
Then a popup "Are you sure to copy this address?" should display for "Destination Address" section on Mylo Journey page 
And address should be updated in Mailing address section after clicking on "Yes" button
And Saved data should get deleted after clicking on "Delete" button under "Mailing address Dropdown" section

@IRIS-2054 @218017 @218018 @Mylo:218053 @Mylo-Regression
Scenario:  Mylo-Validate CopyToMail functionality for No option of Destination Address section without existing Mailing address on Mylo Journey page 
Given he is on "Destination Address" section after clicking on "Destination Address Edit" button displayed under it for file ID with "mailingAddressNotExist"
And he clicks on "Destination Address Copy to Mail" button of "Destination Address" section after saving below data for respective fields
|Field Name                  |CharacterLength |
|Destination Country         |Random          |
|Destination City            |5               |
|Destination Zip Code        |5               |
|Destination address1        |10              |
|Destination address2        |10              |
|Destination State Text Field|10              |
When he clicks on "No" button after verifying the popup message "Are you sure to copy this address?" 
Then address should not get updated in Mailing address section on Mylo Journey page
And "Destination Address" should not get updated in "Mailing address" section after he clicks on "X" icon on popup in Journey page

@IRIS-2054 @218019 @218020 @Mylo:218054 @Mylo-Regression
Scenario:  Mylo-Validate CopyToMail functionality for Yes option of Destination Address section with existing Mailing address on Mylo Journey page 
Given he clicks on "Destination Address Copy to Mail" button of "Destination Address" section after saving below data for file ID with "addressExist"
|Field Name                  |CharacterLength |
|Destination Country         |Random          |
|Destination City            |5               |
|Destination Zip Code        |5               |
|Destination address1        |10              |
|Destination address2        |10              |
|Destination State Text Field|10              |
When he clicks on "Yes" button after verifying the popup message "Are you sure to copy this address?" 
Then a popup "Selecting destination address will overwrite the current Mailing address. Are you sure you want to proceed?" should display for "Destination Address" section on Mylo Journey page 
And "Destination Address" should be updated in "Mailing address" section after clicking on "Yes" button

@IRIS-2054 @218021 @218022 @Mylo:218055 @Mylo-Regression
Scenario:  Mylo-Validate CopyToMail functionality for No option of Destination Address section with existing Mailing address on Mylo Journey page 
Given he clicks on "Destination Address Copy to Mail" button of "Destination Address" section after saving below data for file ID with "addressExist"
|Field Name                  |CharacterLength |
|Destination Country         |Random          |
|Destination City            |5               |
|Destination Zip Code        |5               |
|Destination address1        |10              |
|Destination address2        |10              |
|Destination State Text Field|10              |
And he clicks on "Yes" button after verifying the popup message "Are you sure to copy this address?" 
When he clicks on "No" button after verifying the popup message "Selecting destination address will overwrite the current Mailing address. Are you sure you want to proceed?" 
Then "Destination Address" should not get updated in existing Mailing address section on Mylo Journey page
And "Destination Address" should not get updated in existing "Mailing address" section after he clicks on "X" icon on popup in Journey page