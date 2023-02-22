Feature: Validate the functionality of Mylo Charge Code
  I want to test the functionality of Mylo Charge Code

  Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application with user type "With Resource24"

  @Mylo-Regression @Mylo-phase2
  Scenario: Mylo-Validate Toast Messages for Mandatory fields on Direct, InDirect tabs in Charge Code screen
    Given he is on the charge code file after clicking on the Charge Codes Button on the Journey Summary File created with "NG Client"
    Then following validation messages should be displayed, with leaving below mandatory fields blank on both "Direct", "Indirect" tabs
      | FieldName            | Message                              |
      | Entity Code          | Entity Code is required              |
      | Cost Center          | Cost Center is required              |
      | Start Date           | Start Date is required               |
      | End Date             | End Date is required                 |
      | Move Cost Percentage | Move Cost Percentage is required     |
      | Service Type         | Service Type is required             |
      | FAR                  | FAR is required                      |
      | GL Number            | GL Number is required                |
      | Network Number       | Network Number is required           |
      | Activity code        | Activity code is required            |
      | Charge Number        | Charge Number Authorizer is required |
  
  @Mylo-Regression @Mylo-phase2
  Scenario: Mylo - Validate add,update,delete on Direct, InDirect tabs in Charge Code screen with charge code History
    Given he is on the charge code file after clicking on the Charge Codes Button on the Journey Summary File created with "NG Client"
    Then clicking "Save" button after providing all the required information should save the charge code on both "Direct", "Indirect" tabs
    And he should be able to view all fields on "Charge Code History" screen after clicking on view charge code history button
    And upon entering data in any column on both "Direct", "Indirect" tabs the row will be highighted in red in "Charge Code History" screen    
    And clicking "yes" on the confirmation popup displayed after clicking on the trash can icon next to a existing direct charge code deletes the line on both "Direct", "Indirect" tabs
 
  @Mylo-Regression @Mylo-phase2
  Scenario: Mylo - Validate add,delete,save buttons are visible based on user permission
    Given he is on the charge code file after clicking on the Charge Codes Button on the Journey Summary File
    Then Add,Delete,Save options are visible on both "Direct", "Indirect" tabs in "Charge Codes" screen
    And Add,Delete,Save options are disable on both "Direct", "Indirect" tabs after he has logged into the Mylo application with userType "Without Resource34"

  @Mylo-Regression @Mylo-phase2
  Scenario: Mylo - Validate Start date and end date on both "Direct", "Indirect" tabs in Charge Code screen
    Given he is on the charge code file after clicking  the Charge Codes Button on the Journey Summary File created with "NG Client"
    Then the start date should be displayed in red upon clicking 'Save' button after entering start date greater than the current date on both "Direct", "Indirect" tabs
    And the end date should be displayed in red upon clicking 'Save' button after entering end date less than the current date on both "Direct", "Indirect" tabs

  @Mylo-Regression @Mylo-phase2
  Scenario: Mylo - Validate mandatory field, warning message of Direct-Indirect Charge Code Size < 2 for "NG Client"
    Given he is on the charge code file after clicking  the Charge Codes Button on the Journey Summary File created with Client "NG Client"
    Then error message "Please enter cost center or WBS" should be displayed after clicking on 'Save' button leaving COST CENTER, WBS empty on both "Direct", "Indirect" tabs
    And error message "Please enter at least 2 Charge Codes" should be displayed after clicking 'Save' button on both Direct, Indirect charge Code with only one charge code   
  
  @Mylo-Regression
  Scenario: Mylo - Validate Warning Message of Direct-Indirect Charge Code having 0 size for NG Client
    Given he is on the charge code file after clicking  the Charge Codes Button on the Journey Summary File created with Client "NG Client"
    When he clicks 'save' button on charge codes screen with no charge code on both "Direct", "Indirect" tabs  
    Then error message "Please choose at least 1 Direct or Indirect Charge Code" should be displayed

