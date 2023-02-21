Feature: Validate the functionality of Mylo Charge Code
  I want to test the functionality of Mylo Charge Code

  Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application

  @Mylo-Regression @Mylo-phase2
  Scenario: Mylo - Validate add,delete,mandatory field validation on Direct Charge Code screen
    Given he is on the charge code file after clicking on the Charge Codes Button on the Journey Summary File created with "NG Client"
    When he clicks on the plus icon on the right in the "Direct" tab on "Charge Codes" screen
    Then following validation messages should be displayed, if leaving below mandatory fields blank on a new charge code line
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
    And clicking on "Save" button after providing all the required information should save the direct charge code
    And clicking "yes" on the confirmation popup displayed after clicking on the trash can icon next to a existing direct charge code deletes the line
    And clicking the "x" button located at the top right of the window will close the charge code window

  @Mylo-Regression @Mylo-phase2
  Scenario: Mylo - Validate add,delete,mandatory field validation on InDirect Charge Code screen
    Given he is on the charge code file after clicking on the Charge Codes Button on the Journey Summary File created with "NG Client"
    When he clicks on the plus icon on the right in the "InDirect" tab on "Charge Codes" screen
    Then following validation messages should be displayed, if leaving below mandatory fields blank on a new charge code line
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
    And clicking on "Save" button after providing all the required information should save the Indirect charge code
    And clicking "yes" on the confirmation popup displayed after clicking on the trash can icon next to a existing direct charge code deletes the line

  @Mylo-Regression @Mylo-phase2
  Scenario: Mylo - Validate add,delete,save options are not visible for user with no permission
    Given he is on the charge code file after clicking on the Charge Codes Button on the Journey Summary File after logging with user with no permission
    Then Add,Delete,Save options are not visible in "Direct tab" on "Charge Codes" screen
    And Add,Delete,Save options are not visible in "InDirect tab" on "Charge Codes" screen

  @Mylo-Regression @Mylo-phase2
  Scenario: Mylo - Validate Start date and end date on Charge Code screen
    Given he is on the charge code file after clicking  the Charge Codes Button on the Journey Summary File created with "NG Client"
    When he clicks save button after entering start date greater than the current date
    Then the start date will be displayed in red
    And the end date will be displayed in red after he enters end date less than the current date

  @Mylo-Regression @Mylo-phase2
  Scenario: Mylo - Validate	mandatory field message and Warning Message when Direct-Indirect Charge Code Size < 2 for Client "NG Client"
    Given he is on the charge code file after clicking  the Charge Codes Button on the Journey Summary File created with Client "NG Client"
    Then below error message displays on the screen upon clicking "save" button after leaving COST CENTER, WBS empty on both "Direct", "Indirect" tabs
      | Message                         |
      | Please enter cost center or WBS |
    And below error toast message will appear on the screen upon clicking 'save' button on charge codes screen with only one charge code direct indirect charge code combined
      | Message                              |
      | Please enter at least 2 Charge Codes |

  @Mylo-Regression
  Scenario: Mylo - Validate	Warning Message when Direct-Indirect Charge Code Size is null for Client "NG Client"
    Given he is on the charge code file after clicking  the Charge Codes Button on the Journey Summary File created with Client "NG Client"
    Then below error toast message will appear on the screen upon clicking 'save' button on charge codes screen with no charge code in direct indirect charge code combined
      | Message                                                 |
      | Please choose at least 1 Direct or Indirect Charge Code |

  @Mylo-Regression @Mylo-phase2
  Scenario: Mylo - Validate	view charge code history
    Given he is on the charge code file after clicking  the Charge Codes Button on the Journey Summary File created with "NG Client"
    When he clicks on view charge code history button
    Then he should be able to view all fields on "Charge Code History" screen
    And Direct,Indirect Charge Code History Id column will not be visible in the table
    And the history code row is highlighted in red after entering data in Charge Code End Datefield
    And upon entering data in any column the row will be highighted in red in history screen
