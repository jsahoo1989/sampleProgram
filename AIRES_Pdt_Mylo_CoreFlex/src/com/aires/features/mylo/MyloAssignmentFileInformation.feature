Feature: Validate the functionality of Mylo Assignment File Information section
  As a Mylo user, I want to validate the functionality for "Mylo Assignment - File Information"

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
   
@IRIS-731 @Mylo-Regression
Scenario Outline:  Mylo-Validate Edit Option availability and additional fields displayed for Mylo Assignment File Information with different UserTypes
Given he has logged into the Mylo application with mentioned userType "<UserType>" 
And he is on Mylo Assignment Summary page for file ID "611072" 
And he views the File Information section where File ID, Client ID & Name, Policy Type are hard coded with color "#D3BFFA"
When he clicks on the "Details Carrot" under file information
Then the file information will expand to display additional fields
And "Status" of the file is not "CLSD" or "CNCL" 
And "Edit" button will be enabled for Resource300096 or disabled for Without Resource300096 depending on "<UserType>"
Examples:
|UserType          |
|With Resource300096   |
#|Without Resource300096|


@IRIS-731 @Mylo-Regression
Scenario:  Mylo-Validate fields getting saved after updating in  Mylo Assignment File Information section
Given he is on Mylo Assignment Summary page for file ID "611085" 
And he clicks on the "Details Carrot" under file information
And "Status" of the file is not "CLSD" or "CNCL"
And he has updated some fields in the file information section after clicking on "Edit" button
When he clicks on "Save" button in file information section
Then updated fields should be saved in the Assignment File information section

@IRIS-731 @Mylo-Regression
Scenario Outline:  Mylo-Validate Edit Option availability of Mylo Assignment File Information for Cancelled and Closed File Status
Given he is on Mylo Assignment Summary page for file ID with "<FileStatus>"
When he clicks on the "Details Carrot" under file information
Then "Status" of the file should be "<FileStatus>" 
And "Edit" button will be disabled for both CLSD and CNCD status
Examples:
|FileStatus|
|Closed    |
|Canceled  |

@IRIS-731 @Mylo-Regression
Scenario Outline:  Mylo-Validate Policy Dropdown field availability of Mylo Assignment File Information for different FileAffinityStatus of Non-Relocation Policies
Given he is on Mylo Assignment Summary page for file ID with "<FileAffinityStatus>"
When he clicks on the "Details Carrot" under file information
Then "Policy Type" dropdown should display as read only for "<FileAffinityStatus>"
Examples:
|FileAffinityStatus|
|AffinityEnabled   |
|NotAffinityEnabled  |

@IRIS-731 @Mylo-Regression
Scenario Outline:  Mylo-Validate Office Dropdown field availability of Mylo Assignment File Information for different FileProvider
Given he is on Mylo Assignment Summary page for file ID with "<FileProviderName>"
When he clicks on the "Details Carrot" under file information
Then "Office" dropdown should display as read only for "<FileProviderName>"
Examples:
|FileProviderName|
|AIRESSH   |
|NOTAIRESSH  |

@IRIS-731 @Mylo-Regression
Scenario:  Mylo-Validate Office Dropdown field availability of Mylo Assignment File Information for different FileProvider
Given he is on Mylo Assignment Summary page for file ID with "Relocation Policy"
And he verifies the "ls" checkbox to be unchecked after clicking on "Details Carrot" under file information
When he has updated the policy type to a "Lump Sum Plan" policy after clicking on "Edit" button
Then the "ls" checkbox should be checked
