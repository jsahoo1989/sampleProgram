Feature: Silent Save
  Validate Silent Save functionality

  Background: Login to  Policy Digitization Tool (PDT) application
    Given he is logged into 'Aires Policy Tool' application as a "Client Service Manager" user

  @BLUE-03 @PDT-Regression @BLUE-309 @Pdt:218030
  Scenario: PDT - Validate Save button functionality when Policy is in Complete State
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Language Training" as Benefit Category on "Policy Benefit Categories" page
    When he clicks on 'Save' button after entering mandatory information for all sub-benefits of "Language Training" page
    Then Saved indicator is displayed for saved Policy Benefit Category on the left menu
    And he stays on the same benefit page without any change in policy status

  @BLUE-03 @PDT-Regression @BLUE-309 @Pdt:218031
  Scenario: PDT - Validate Save & Continue button functionality when Policy is in Complete State
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of below Benefit Categories on "Policy Benefit Categories" page
      | Language Training | Cultural Training |
    When he clicks on 'Save & Continue' button on each benefit page after entering mandatory information for all sub-benefits of each selected benefit Category
    Then Saved indicator is displayed for all saved Policy Benefit Categories except the last Benefit Category on the left menu

  @BLUE-03 @PDT-Regression @BLUE-309 @Pdt:218032
  Scenario: PDT - Validate Save & Submit functionality when Policy is in Complete State
    Given he is on "Policy Benefit Categories" Page after selecting Client/Policy information followed by filling information on "General Information" page
    And he has clicked on 'Next' button after selecting below categories on "Policy Benefit Categories" Page
      | House Hunting Trip | Compensation Services |
    And he has clicked on 'Save & Continue' button on each benefit page after entering mandatory information for all sub-benefits of each selected benefit Category
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all sub-benefits on last benefit category page
    Then Policy status is changed to "Submitted" having version "V1" on header of 'Benefit Category' page
    And Saved indicator is displayed for all saved Policy Benefit Categories on the left menu

  @BLUE-03 @BLUE-04 @PDT-Regression @BLUE-313 @Pdt:218033
  Scenario: PDT - Validate Save button functionality when Policy is in Incomplete State
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Language Training" as Benefit Category on "Policy Benefit Categories" page
    When he clicks on 'Save' button after entering mandatory information for some of field values of "Language Training" sub-benefit
    Then "red" color 'exclamation mark' "error"  indicator is displayed on each sub-benefit tab header level where the mandatory field value is missing
    And an 'exclamation mark' "error" indicator icon is displayed on Left menu for the Benefit if any of its sub benefit is in Incomplete state

  @BLUE-03 @BLUE-04 @PDT-Regression @BLUE-313 @Pdt:218034
  Scenario: PDT - Validate Save & Continue button functionality when Policy is in InComplete State
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of below Benefit Categories on "Policy Benefit Categories" page
      | Language Training | Cultural Training |
    When he clicks on 'Save & Continue' button on each benefit page after entering mandatory information for some of the field values of sub-benefits
    Then Policy status remains "Draft" on the last Benefit Page
    And Side bar menu shows an 'exclamation mark' "error" indicator icon for the Benefit if any of its sub benefit is in Incomplete state

  @BLUE-03 @BLUE-04 @PDT-Regression @BLUE-313 @Pdt:218035 @incomp
  Scenario: PDT - Validate Save & Submit functionality when Policy is in Incomplete State
    Given he is on "Policy Benefit Categories" Page after selecting Client/Policy information followed by filling information on "General Information" page
    And he has clicked on 'Next' button after selecting below categories on "Policy Benefit Categories" Page
      | Language Training | Cultural Training |
    And he has clicked on 'Save & Continue' button on each benefit page after entering mandatory information for some of the field values of sub-benefits
    When he clicks on 'Save & Submit' button after entering mandatory information for some of the field values on last benefit Category page
    Then below information is displayed in warning pop-up
      | Title                   | Message                                                                                                                                                                                                     |
      | Policy Incomplete State | This policy has one or more benefits in an Incomplete state. These sections are indicated by: error. You must complete the required information fields before the policy can be saved and succesfully submitted. |

  @BLUE-04 @PDT-Regression @BLUE-352 @Pdt:218036
  Scenario: PDT - Validate Exit button functionality when information is saved on each benefit and not updated
    Given he is on "Policy Benefit Categories" Page after selecting Client/Policy information followed by filling information on "General Information" page
    And he has clicked on 'Next' button after selecting below categories on "Policy Benefit Categories" Page
      | Language Training | Cultural Training |
    And he has clicked on 'Save & Continue' button on each benefit page after entering mandatory information for all sub-benefits of each selected benefit Category
    And he clicks on "SAVE" button after entering mandatory information for all sub-benefits on last benefit category page
    When he clicks on EXIT button on last benefit page
    Then he should navigate to "View/Edit Policy" Forms page

  @BLUE-04 @PDT-Regression @BLUE-353 @Pdt:218037
  Scenario: PDT - Validate Back button functionality when information is saved on each benefit and not updated
    Given he is on "Policy Benefit Categories" Page after selecting Client/Policy information followed by filling information on "General Information" page
    And he has clicked on 'Next' button after selecting below categories on "Policy Benefit Categories" Page
      | Language Training | Cultural Training |
    And he has clicked on 'Save & Continue' button on each benefit page after entering mandatory information for all sub-benefits of each selected benefit Category
    And he clicks on "SAVE" button after entering mandatory information for all sub-benefits on last benefit category page
    When he clicks on BACK button on last benefit category each page
    Then he should navigate to previous page with same result on subsequent BACK button click

  @BLUE-05 @PDT-Regression @Pdt:218374
  Scenario: PDT - Valdite the UI of Confirmation pop-up when Exit button is clicked after making Sub-benefit form dirty
    Given he is on "Policy Benefit Categories" Page after selecting Client/Policy information followed by filling information on "General Information" page
    And he has clicked on 'Next' button after selecting below categories on "Policy Benefit Categories" Page
      | Language Training | Cultural Training |
    And he has clicked on 'Save & Continue' button on each benefit page after entering mandatory information for all sub-benefits of each selected benefit Category
    When he clicks on "EXIT" button after entering mandatory information for all sub-benefits on last benefit category page
    Then a "Confirmation pop-up" should be displayed with below information
      | Heading | Confirmation                                                                                                                            |
      | Message | Please click Cancel to stay on the page, click OK to leave the page or click Save to save your current changes before leaving the page. |
      | Buttons | OK, CANCEL, SAVE                                                                                                                        |

  @BLUE-05 @PDT-Regression @Pdt:218375
  Scenario: PDT - Valdite OK, CANCEL, SAVE button functionality on Confirmation pop-up when Exit button is clicked after making Sub-benefit form dirty
    Given he is on "Policy Benefit Categories" Page after selecting Client/Policy information followed by filling information on "General Information" page
    And he has clicked on 'Next' button after selecting below categories on "Policy Benefit Categories" Page
      | Language Training | Cultural Training |
    And he has clicked on 'Save & Continue' button on each benefit page after entering mandatory information for all sub-benefits of each selected benefit Category
    When he clicks on "EXIT" button after entering mandatory information for all sub-benefits on last benefit category page
    Then a "Confirmation pop-up" should be displayed with 'OK, CANCEL, SAVE' buttons with below functionalities on clicking these buttons
      | OK     | User navigates to View/Edit Policy form page without saving changes on last benefit category page |
      | CANCEL | User remains on same page                                                                         |
      | SAVE   | User navigates to View/Edit Policy after silently saving the changes on sub-benefit forms         |

  @BLUE-05 @PDT-Regression @Pdt:218376
  Scenario: PDT - Valdite OK, CANCEL, SAVE button functionality on Confirmation pop-up when BACK button is clicked after making Sub-benefit form dirty
    Given he is on "Policy Benefit Categories" Page after selecting Client/Policy information followed by filling information on "General Information" page
    And he has clicked on 'Next' button after selecting below categories on "Policy Benefit Categories" Page
      | Language Training | Cultural Training |
    And he has clicked on 'Save & Continue' button on each benefit page after entering mandatory information for all sub-benefits of each selected benefit Category
    When he clicks on "BACK" button after entering mandatory information for all sub-benefits on last benefit category page
    Then a "Confirmation pop-up" should be displayed with 'OK, CANCEL, SAVE' buttons with below functionalities on click of these buttons
      | OK     | User navigates to previous page without saving changes on last benefit category page   |
      | CANCEL | User remains on same page                                                              |
      | SAVE   | User navigates to previous page after silently saving the changes on sub-benefit forms |

  @BLUE-06 @PDT-Regression @BLUE-422 @Pdt:218377
  Scenario: PDT - Validate EXIT button functionality in read only mode
    Given he is on "Policy Benefit Categories" Page after selecting Client/Policy information followed by filling information on "General Information" page
    And he has clicked on 'Next' button after selecting below categories on "Policy Benefit Categories" Page
      | Language Training | Cultural Training |
    And he has clicked on "SAVE & SUBMIT" button followed by "EXIT" button after entering mandatory information for all sub-benefits of each selected benefit Category
    When he clicks on newly added Policy after searching it on "View/Edit Policy Forms" page
    Then he should navigate back to "View/Edit Policy Forms" page without displaying exit modal after clicking on "EXIT/X" buttons on following pages
      | General Information | Policy Benefit Categories | Language Training | Cultural Training |

  @BLUE-06 @PDT-Regression @BLUE-458
  Scenario: PDT - Validate Save & Submit functionality for 16 multiple Policy benefit categories
    Given he is on "Policy Benefit Categories" Page after selecting Client/Policy information followed by filling information on "General Information" page
    And he has clicked on 'Next' button after selecting below categories on "Policy Benefit Categories" Page
      | Pre-Acceptance Services | Immigration | House Hunting Trip | One Time Payments/Reimbursements | Ongoing Payments/Reimbursements | Household Goods | Final Move | Destination Services | Language Training | Cultural Training | Home Leave | Temporary Living | Assignment Housing (Company Sponsored) | Home Purchase | Rental Assistance | Compensation Services |
    And he has clicked on 'Save & Continue' button on each benefit page after entering mandatory information for all sub-benefits of each selected benefit Category
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all sub-benefits on last benefit category page
    Then Policy status is changed to "Submitted" having version "V1" on header of 'Benefit Category' page
    And Saved indicator is displayed for all saved Policy Benefit Categories on the left menu