Feature: Validate the functionality of Mylo Journey Tax Reporting Information section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Tax Reporting Information" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-1945 @217971 @Mylo:218003 @Mylo-Regression
Scenario Outline:  Mylo-Validate Edit Option availability for Mylo Journey Tax Reporting Information section with different UserTypes
Given he has logged into the Mylo application with mentioned userType "<UserType>" 
And he is on Mylo Journey Summary page for file ID with "activeAssignment" 
When he views "Tax Reporting Information" section
Then "Edit" button should be enabled for Resource300096 or disabled for Without Resource300096 depending on "<UserType>"
Examples:
|UserType              |
|With Resource300096   |
|Without Resource300096|

@IRIS-1945 @217972 @217974 @Mylo:218004 @Mylo-Regression
Scenario Outline:  Mylo-Validate Edit Option availability of Mylo Journey Tax Reporting Information with respect to File Status
Given he is on Mylo Journey Summary page for file ID with "<FileType>"
And "Status" of the file should be "<FileStatus>"  after clicking on "Details Carrot" on FileInformation section
When he views "Tax Reporting Information" section
Then "Edit" button should be disabled for both "<FileStatus>" status
Examples:
|FileType    |FileStatus|
|closedFile  |Closed    |
|canceledFile|Canceled  |

@IRIS-1945 @217970 @Mylo:218005  @Mylo-Regression
Scenario:  Mylo-Validate Toast Message for Expense management box on Mylo Journey Tax Reporting Information section
Given he is on Mylo Journey Summary page for file ID with "activeAssignment"
And the Expense management box is selected on Mylo Journey Tax Reporting Information section
When he un-checks the expense management box after clicking on "Edit" button on Mylo Journey Tax Reporting Information section
Then a popup should display "Do you want to set 'Transfers to RMS' indicator to 'No' for all unbilled DRs? Please contact CIS to remove billed DRs from RMS." on Mylo Journey Tax Reporting Information section

@IRIS-1945 @217975 @Mylo:218006 @Mylo-Regression
Scenario:  Mylo-Validate Options available for Different Tax Reporting Information Dropdown fields on Mylo Journey page
Given he is on Mylo Journey Summary page for file ID with "activeAssignment"
When he clicks on below dropdown fields after clicking on "Edit" button on Tax Reporting Information
|Field Name                 |
|Family Size                |
|Total Number of Dependents |
|Salary Currency            |
|Dep under 17               |
|True Home Country          |
|Filing Status              |
|Deduction Method           |
Then list of values displayed in the dropdown for below fields should match with the expected values
|Field Name                 |
|Family Size                |
|Total Number of Dependents |
|Salary Currency            |
|Dep under 17               |
|True Home Country          |
|Filing Status              |
|Deduction Method           |

@IRIS-1945 @217973 @Mylo:218007  @Mylo-Regression
Scenario:  Mylo-Validate Edit button status for Payment Cutoff Completion Date befor the Current Date on Mylo Journey Tax Reporting Information section
Given he is on Mylo Journey Summary page for file ID with "paymentCutOffDateCompletion" where payment completion date has been passed
When he views "Tax Reporting Information" section
Then "Edit" button should be disabled on Tax Reporting Information section

@IRIS-1945 @217975 @217981 @Mylo:218008 @Mylo-Regression
Scenario:  Mylo-Validate Number Limit Boundary Conditions & Save functionality for fields of Tax Reporting Information section on Mylo Journey page
Given he is on Mylo Journey Summary page for file ID with "activeAssignment"
And he has provided all mandatory information with below number Limit for mentioned fields after clicking on "Edit" icon on Tax Reporting Information section
|Field Name                 |Field Value|
|Family Size                |Random     |
|Total Number of Dependents |Random     |
|Salary Currency            |Random     |
|Dep under 17               |Random     |
|True Home Country          |Random     |
|Filing Status              |Random     |
|Deduction Method           |Random     |
|Salary                     |9          |
|Estimated Itemized Amount  |9          |
|Salary Comments  					|Test       |
When he clicks on "Save" button on Tax Reporting Information section
Then all values should be successfully saved as per below number limit for mentioned fields under Tax Reporting Information section on Mylo Journey Page
|Field Name                 |Field Value|
|Family Size                |Random     |
|Total Number of Dependents |Random     |
|Salary Currency            |Random     |
|Dep under 17               |Random     |
|True Home Country          |Random     |
|Filing Status              |Random     |
|Deduction Method           |Random     |
|Salary                     |8          |
|Estimated Itemized Amount  |8          |
|Salary Comments  					|Test       |
And "Updated By" field should get updated by the system generated mylo username along with date/time on Tax Reporting Information section
