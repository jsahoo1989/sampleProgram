Feature: Validate the functionality of Mylo Journey File Information section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - File Information" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
   
@IRIS-731 @Mylo:217527 
Scenario Outline:  Mylo-Validate Edit Option availability and additional fields displayed for Mylo Journey File Information section with different UserTypes
Given he has logged into the Mylo application with mentioned userType "<UserType>" 
And he is on Mylo Journey Summary page for file ID with "activeAssignment" 
And he views the File Information section where "File ID", "Client ID", "Policy Type" are hard coded with background color "rgba(211, 191, 250, 1)"
When he clicks on the button "Details Carrot" under the file information section
Then the file information should expand to display additional fields
And "Status" of the file is not "CLSD" or "CNCL" 
And "Edit" button will be enabled for Resource300096 or disabled for Without Resource300096 depending on "<UserType>"
Examples:
|UserType              |
|With Resource300096   |
|Without Resource300096|

@IRIS-731 @Mylo:217528 @Mylo-Regression
Scenario Outline:  Mylo - Validate the functionality of the Cancel/Save button in the Mylo Journey File Information section
Given he is on Mylo Journey Summary page for file ID "482350" 
And he clicks on the button "Details Carrot" under the file information section
And "Status" of the file is not "CLSD" or "CNCL"
And he has updated some fields in the file information section after clicking on "Edit" button
When he clicks on the button "<ButtonName>" under the file information section
Then updated fields should be saved or not saved depending on the "<ButtonName>" clicked in the Journey File information section
Examples:
|ButtonName|
|Cancel    |
|Save      |

@IRIS-731 @Mylo:217529 @Mylo-Regression
Scenario Outline:  Mylo-Validate Edit Option availability of Mylo Journey File Information with respect to File Status
Given he is on Mylo Journey Summary page for file ID with "<FileType>"
When he clicks on the button "Details Carrot" under the file information section
Then "Status" of the file should be "<FileStatus>" 
And "Edit" button will be disabled for both CLSD and CNCD status
Examples:
|FileType|FileStatus|
|closedFile|Closed|
|canceledFile|Canceled|

@IRIS-731 @Mylo:217530 @Mylo-Regression
Scenario Outline:  Mylo-Validate Policy and Office Dropdown fields for different File Types on Mylo Journey File Information section
Given he is on Mylo Journey Summary page for file ID with "<FileType>"
When he clicks on "Edit" button after he clicks on the "Details Carrot" under file information
Then "<FieldName>" dropdown should display as read only for "<FileType>"
Examples:
|FieldName  |FileType          |
|Policy Type|affinityEnabled   |
|Policy Type|affinityNotEnabled|
|Office     |airesshProvider   |
|Office     |notairesshProvider|

@IRIS-731 @Mylo:217531 @Mylo-Regression
Scenario:  Mylo-Validate automatic checkbox selection upon changing policy from Relocation to Lum Sum policy
Given he is on Mylo Journey Summary page for file ID with "relocationPolicyType"
And he verifies the "ls" checkbox to be unchecked after clicking on "Details Carrot" under file information
When he has updated the policy type to a "Lump Sum Plan" policy after clicking on "Edit" button
Then the "ls" checkbox should be checked

@IRIS-776 @Mylo:217532 @Mylo-Regression
Scenario:  Mylo-Validate Warning Message for Different Office selection and policy change from Lum Sum to Relocation policy in Mylo Journey File Information section
Given he is on Mylo Journey Summary page for file ID with "lumpSumpPlanPolicyType"
And he clicks on the button "Details Carrot" under the file information section
And he has updated the policy type to a "Long Term Assignment" policy after clicking on "Edit" button
And a warning message should display as "You are changing the IRIS Policy from one that is Springboard enabled to an IRIS Policy that is not Springboard enabled. Are you sure you want to make this change?"
And he has updated the office to "EMEA" which is not equal to the Assignment office after clicking on "No"
When he clicks on the button "Save" under the file information section
Then a warning message should display as "The office on file does not match the office of the Account Manager nor the office defined in Corporation for this booking client."

@IRIS-776 @Mylo:217533 @Mylo-Regression
Scenario:  Mylo-Validate warning message for confidential checkbox selection and automatic selection/deselection for evip and vip checkbox in Mylo Journey File Information section
Given he is on Mylo Journey Summary page for file ID with "activeAssignment"
And he clicks on "Edit" button after he clicks on the "Details Carrot" under file information
And a warning message "By checking this box, this transferee will not be included in any reports (with the exception of billing/payroll reports)." displayed after he selects "confidential" check box
When he selects "evip" checkbox under file information
Then "vip" checkbox should automatically be checked
And "evip" checkbox should automatically unchecked after he unchecks the "vip" box 

@IRIS-776 @Mylo:217534 @Mylo-Regression
Scenario Outline:  Mylo-Validate Warning Message for LS/Intern checkbox in Mylo Journey File Information section
Given he is on Mylo Journey Summary page for file ID with "<PolicyType>"
And he clicks on "Edit" button after he clicks on the "Details Carrot" under file information
And the "ls" checkbox is "<CheckBoxStatus>"
And a warning message "<WarningMsg>" displayed after he clicks "ls" check box
And "ls" checkbox is "<CheckBoxStatus>" after he clicks on "No"
And a warning message "<WarningMsg>" displayed after he clicks "ls" check box
When he clicks on the button "Yes" under the file information section
Then "ls" checkbox should be "<ExpectedCheckboxStatus>"
Examples:
|PolicyType            |CheckBoxStatus|WarningMsg                                                    |ExpectedCheckboxStatus|
|lumpSumpPlanPolicyType|checked       |Are you sure you want to change this?!                        |unchecked             |
|domesticPolicyType    |unchecked     |Do you want to change the policy type to Lump Sum/Intern only?|checked               |

@IRIS-776 @Mylo:217535 @Mylo-Regression
Scenario:  Mylo-Validate Select One option available in dropdown fields of Mylo Journey File Information section
Given he is on Mylo Journey Summary page for file ID with "activeAssignment"
And he clicks on the button "Details Carrot" under the file information section
When he has clicked on the dropdown for "<FieldName>" after clicking on "Edit" button
Then "Select One" should display in the list of values of the mentioned dropdown fields
|Office|Transfer Type|Policy Type|Homestatus|Journey Type|