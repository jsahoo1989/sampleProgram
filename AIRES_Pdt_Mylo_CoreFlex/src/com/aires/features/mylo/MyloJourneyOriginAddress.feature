Feature: Validate the functionality of Mylo Journey Origin Address section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Origin Address" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-1997 @217988 @Mylo:218038 @Mylo-Regression
Scenario Outline:  Mylo-Validate Edit Option availability for Mylo Journey Origin Address section with different UserTypes
Given he has logged into the Mylo application with mentioned userType "<UserType>" 
And he is on Mylo Journey Summary page for file ID with "ORIG" address type
When he views "Origin Address" section after clicking on "Origin Address Details" button
Then "Origin Address Edit" button should be "<Status>" depending on "<UserType>" for "Origin Address" section on Mylo Journey Page
Examples:
|UserType              |Status  |
|With Resource300023   |Enabled |
|Without Resource300023|Disabled|

@IRIS-1997 @218001 @218002 @Mylo:218039 @Mylo-Regression
Scenario Outline:  Mylo-Validate Edit & CopyToMail Option availability of Mylo Journey Origin Address section with respect to File Status
Given he is on Mylo Journey Summary page for file ID with "<FileStatus>"
And "Status" of the file should be "<FileStatus>"  after clicking on "Details Carrot" on FileInformation section
When he views "Origin Address" section after clicking on "Origin Address Details" button
Then "Origin Address Edit", "Origin Address Copy to Mail" button should be disabled for both "<FileStatus>" status of "Origin Address" section
Examples:
|FileStatus|
|Closed    |
|Canceled  |

@IRIS-1997 @217990 @Mylo:218040 @Mylo-Regression
Scenario:  Mylo-Validate Save functionality and Warning Messages for Boundary Conditions on City, ZipCode, Address1,Address2,and State field under Origin Address section on Mylo Journey page  
Given he is on "Origin Address" section after clicking on "Origin Address Edit" button displayed under it for file ID with "ORIG"
And he enters below invalid data for different fields with other mandatory data being provided for "Origin Address" section
|Field Name             |CharacterLength |Message                                                              |
|Origin City            |61          |Maximum length of City in origin address is 60 characters!           |
|Origin Zip Code        |11          |Maximum length of Zip/postal code in origin address is 10 characters!|
|Origin address1        |201         |Maximum length of address1 in origin address is 200 characters!      |
|Origin address2        |201         |Maximum length of address2 in origin address is 200 characters!	    |
|Origin State Text Field|61          |Maximum length of state/province in origin address is 60 characters! |
When he clicks on "Origin Address Save" button after entering below valid data for respective fields on "Origin Address" section
|Field Name             |CharacterLength |
|Origin Country         |Random          |
|Origin City            |60              |
|Origin Zip Code        |10              |
|Origin address1        |200             |
|Origin address2        |200             |
|Origin State Text Field|60              |
Then below fieldValues should be successfully saved under "Origin Address" Dropdown section
|Field Name              |
|Origin Country Value    |
|Origin State Text Field |
|Origin City             |
|Origin Zip Code         |
|Origin address1         |
|Origin address2         |


@IRIS-1997 @217991 @Mylo:218041 @Mylo-Regression
Scenario:  Mylo-Validate Warning Messages for Mandatory fields of Origin Address section on Mylo Journey page 
Given he adds "Origin Address" for a newly created file on Mylo Journey page
And he enters below invalid data combination of mandatory fields on "Origin Address" section
|Country   |State Text Field  |City |Message                                              | 
|Random    |60                |     |You need to fill in the city field in origin address!|
|Select One|60                |25   |You need to select a country in origin address!      |
|India     |Select One        |25   |You need to select a state in Property address!      |
|USA       |Select One        |25   |You need to select a state in Property address!      |
When he clicks on "Origin Address Save" button after entering below mandatory data on "Origin Address" section
|Field Name             |CharacterLength |
|Origin Country         |Random          |
|Origin State Text Field|60              |
|Origin City            |25              |
Then entered data for below fields should be successfully saved in "Origin Address" Dropdown section
|Field Name              |
|Origin City             |
|Origin State Text Field |
|Origin Country Value    |

@IRIS-2021 @217992 @Mylo:218042 @Mylo-Regression
Scenario:  Mylo-Validate Copy functionality of Origin Address section on Mylo Journey page 
Given he is on "Origin Address" section for file ID with "all addresses" on Mylo Journey page
When he clicks on "Origin Address Copy" button of "Origin Address" section after saving below data for respective fields
|Field Name             |CharacterLength |
|Origin Country         |Random          |
|Origin City            |5               |
|Origin Zip Code        |5               |
|Origin address1        |10              |
|Origin address2        |10              |
|Origin State Text Field|10              |
Then "Origin Address Copy" button should turn green with text changes to "Copied" on "Origin Address" section
And copied "Origin Address" can be verified by pasting in the "Mailing Address address1" field of "Mailing address" section on Mylo Journey page

@IRIS-2021 @217994 @Mylo:218043 @Mylo-Regression
Scenario: Mylo-Validate CopyToMail functionality for Yes option of Origin Address section without existing Mailing address on Mylo Journey page 
Given he is on "Origin Address" section after clicking on "Origin Address Edit" button displayed under it for file ID with "ORIG"
When he clicks on "Origin Address Copy to Mail" button of "Origin Address" section after saving below data for respective fields
|Field Name             |CharacterLength |
|Origin Country         |Random          |
|Origin City            |5               |
|Origin Zip Code        |5               |
|Origin address1        |10              |
|Origin address2        |10              |
|Origin State Text Field|10              |
Then a popup "Are you sure to copy this address?" should display for "Origin Address" section on Mylo Journey page 
And address should be updated in Mailing address section after clicking on "Yes" button
And Saved data should get deleted after clicking on "Delete" button under "Mailing address Dropdown" section

@IRIS-2021 @217995 @217996 @Mylo:218044 @Mylo-Regression
Scenario:  Mylo-Validate CopyToMail functionality for No option of Origin Address section without existing Mailing address on Mylo Journey page 
Given he is on "Origin Address" section after clicking on "Origin Address Edit" button displayed under it for file ID with "ORIG"
And he clicks on "Origin Address Copy to Mail" button of "Origin Address" section after saving below data for respective fields
|Field Name             |CharacterLength |
|Origin Country         |Random          |
|Origin City            |5               |
|Origin Zip Code        |5               |
|Origin address1        |10              |
|Origin address2        |10              |
|Origin State Text Field|10              |
When he clicks on "No" button after verifying the popup message "Are you sure to copy this address?" 
Then address should not get updated in Mailing address section on Mylo Journey page
And "Origin Address" should not get updated in "Mailing address" section after he clicks on "X" icon on popup in Journey page

@IRIS-2021 @217997 @217998 @Mylo:218045 @Mylo-Regression
Scenario:  Mylo-Validate CopyToMail functionality for Yes option of Origin Address section with existing Mailing address on Mylo Journey page 
Given he clicks on "Origin Address Copy to Mail" button of "Origin Address" section after saving below data for file ID with "all address"
|Field Name             |CharacterLength |
|Origin Country         |Random          |
|Origin City            |5               |
|Origin Zip Code        |5               |
|Origin address1        |10              |
|Origin address2        |10              |
|Origin State Text Field|10              |
When he clicks on "Yes" button after verifying the popup message "Are you sure to copy this address?" 
Then a popup "Selecting origin address will overwrite the current Mailing address. Are you sure you want to proceed?" should display for "Origin Address" section on Mylo Journey page 
And "Origin Address" should be updated in "Mailing address" section after clicking on "Yes" button

@IRIS-2021 @Mylo:218046 @Mylo-Regression
Scenario:  Mylo-Validate CopyToMail functionality for No option of Origin Address section with existing Mailing address on Mylo Journey page 
Given he clicks on "Origin Address Copy to Mail" button of "Origin Address" section after saving below data for file ID with "all address"
|Field Name             |CharacterLength |
|Origin Country         |Random          |
|Origin City            |5               |
|Origin Zip Code        |5               |
|Origin address1        |10              |
|Origin address2        |10              |
|Origin State Text Field|10              |
And he clicks on "Yes" button after verifying the popup message "Are you sure to copy this address?" 
When he clicks on "No" button after verifying the popup message "Selecting origin address will overwrite the current Mailing address. Are you sure you want to proceed?" 
Then "Origin Address" should not get updated in existing Mailing address section on Mylo Journey page
And "Origin Address" should not get updated in existing "Mailing address" section after he clicks on "X" icon on popup in Journey page