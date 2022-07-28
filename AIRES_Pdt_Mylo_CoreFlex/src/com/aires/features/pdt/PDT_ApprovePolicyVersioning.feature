Feature: Approve Policy to create new version
  Validate the functionality of Approve Policy with Versioning feature

  Background: Login to  Policy Digitization Tool (PDT) application
    Given he is logged into 'Aires Policy Tool' application as a "Client Service Manager" user

  @Sprint-29 @PDT-Regression @PDT-1115 @Pdt:217683
  Scenario: PDT - Validate 'Approve Policy' button is displayed as visible after submission of a policy from 'Policy benefit' page
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Home Leave" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    #When he clicks on the 'OK' button of success message "Policy saved and submitted" displayed on the "Policy Benefit" page
    Then "Approve Policy" button should become visible on the 'Policy Benefit' page
    And "SAVE & SUBMIT" button should become disabled on the 'Policy Benefit' page

  @Sprint-29 @PDT-Regression @PDT-1115 @Pdt:217684
  Scenario: PDT - Validate the UI of 'Approve Policy' pop-up displayed after clicking Approve Policy button on "Policy Benefit" page
    Given he is on the "Policy Benefit" page after selecting "Home Leave" as Benefit Category;
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    #When he clicks on 'Approve Policy' button after verifying success message "Policy saved and submitted" on "Policy Benefit" page
    When he clicks on 'Approve Policy' button after verifying status "Submitted" on header section of "Policy Benefit" page
    Then below information should be displayed on 'Approve Policy' Pop-up
      | Heading   | Do you want to proceed with the approval of this policy?                                                                                                                                           |
      | Message1  | You are approving version 1 of this policy. If approved, the policy state will change from Submitted to Active and indicates that you have reviewed the policy benefits and approve them for use.  |
      | Message2  | There are currently 0 Assignments or Files associated with this policy in IRIS. The following options are only effective for the client of this policy if Blueprint has been enabled in IRIS Corp: |
      | Checkbox1 | Associate this policy with an EXISTING authorization in IRIS?_Disabled                                                                                                                             |
      | Checkbox2 | Associate this policy with a NEW authorization in IRIS?_Enabled                                                                                                                                    |
      | button    | Approve_disabled, Cancel_Enabled                                                                                                                                                                   |

  @Sprint-29 @PDT-Regression @PDT-1115 @Pdt:217685
  Scenario: PDT - Validate 'Approve' button on 'Approve Policy' pop-up becomes enabled after selecting checkbox 'Associate this policy with a NEW authorization' on Policy benefit page
    Given he is on the "Policy Benefit" page after selecting "Home Leave" as Benefit Category;
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    #And he clicks on 'Approve Policy' button after verifying success message "Policy saved and submitted" on "Policy Benefit" page
    And he clicks on 'Approve Policy' button after verifying status "Submitted" on header section of "Policy Benefit" page
    When he selects the checkbox having label 'Associate this policy with a NEW authorization in IRIS?' on 'Approve Policy' pop-up
    Then "Approve" button should become "enabled" on 'Approve Policy' pop-up

  @Sprint-29 @PDT-Regression @PDT-1115 @Pdt:217686
  Scenario: PDT - Verify that status of a 'Submitted' Policy changes to 'Active' after clicking 'Approve' button on 'Approve Policy' pop-up
    Given he is on the "Policy Benefit" page after selecting "Home Leave" as Benefit Category;
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    #And he clicks on 'Approve Policy' button after verifying success message "Policy saved and submitted" on "Policy Benefit" page
    And he clicks on 'Approve Policy' button after verifying status "Submitted" on header section of "Policy Benefit" page
    And he selects the checkbox having label 'Associate this policy with a NEW authorization in IRIS?' on 'Approve Policy' pop-up
    When he clicks on "Approve" button on 'Approve Policy' pop-up on "Policy Benefit" page
    Then Version "V1" of Policy should be displayed on "View/Edit Policy Forms" page with "Active" status

  @Sprint-29 @PDT-Regression @PDT-1115 @Pdt:217687
  Scenario: PDT - Verify that Policy Status of a 'Submitted' Policy should not change after clicking 'Cancel' button on 'Approve Policy' pop-up
    Given he is on the "Policy Benefit" page after selecting "Home Leave" as Benefit Category;
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    #And he clicks on 'Approve Policy' button after verifying success message "Policy saved and submitted" on "Policy Benefit" page
    And he clicks on 'Approve Policy' button after verifying status "Submitted" on header section of "Policy Benefit" page
    And he selects the checkbox having label 'Associate this policy with a NEW authorization in IRIS?' on 'Approve Policy' pop-up
    When he clicks on "Cancel" button on 'Approve Policy' pop-up on "Policy Benefit" page
    Then Status of Policy should remain "Submitted" with Version "V1" on "Policy Benefit" Page

  @Sprint-30 @PDT-Regression
  Scenario: PDT - Verify that Assignment History Section should display the Assignments linked with newly created Active Policy
    Given he is on the "View/Edit Policy Forms" page after approving a policy with below sub-benefits of "Language Training" Benefit Category;
      | Language Training Employee | Language Training Family |
    And he has submitted a new authorization form in MobilityX application using template "Global Relocation Authorization"
    When he clicks on "Assignment History" icon on "View/Edit Policy Forms" page of 'PDT' application for the newly created Active policy
    Then Assignment details should be displayed in 'Assignment History' Page

  @Sprint-30 @PDT-Regression @uiv
  Scenario: PDT - Verify the UI of Version Control pop-up while editing Active Policy having assignments.
    Given he is on the "View/Edit Policy Forms" page after approving a policy with below sub-benefits of "Language Training" Benefit Category;
      | Language Training Employee | Language Training Family |
    And he has submitted a new authorization form in MobilityX application using template "Global Relocation Authorization"
    When he clicks on "Edit" icon on "View/Edit Policy Forms" page of 'PDT' application for the newly created Active policy
    Then below information should be displayed in the pop-up
      | Message1    | This policy version "V1" is in an Active state and currently has 1 assignments or files associated with it in IRIS.                                                  |
      | Message2    | To edit this policy, you will need to create a new version and save it to a Draft state. To create the new draft, please input a brief description, then click create. |
      | Version     | Version: V2                                                                                                                                                                     |
      | Description | textbox                                                                                                                                                                |
      | Button      | Create_disabled, Cancel_enabled                                                                                                                                        |
    And "Create" button becomes "enabled" after entering text on Description textbox

  @Sprint-31
  Scenario: PDT - Verify the UI of Version Control pop-up while editing Active Policy having assignments.
    Given he is on the "View/Edit Policy Forms" page after approving a policy with below sub-benefits of "Language Training" Benefit Category;
      | Language Training Employee | Language Training Family |
    And he has submitted a new authorization form in MobilityX application using template "Global Relocation Authorization"
    #And he has navigated to 'General Information page' which displays version "V2" with status "Draft" after clicking on "Edit" icon on "View/Edit Policy Forms" page
    And he has updated mandatory information on 'General Information' page followed by selection of "Cultural Training" as Benefit Category on "Policy Benefit" page after clicking on "Edit" icon on "View/Edit Policy Forms" page
    When he approves the policy after selecting selecting the checkbox having label 'Associate this policy with a NEW authorization in IRIS?' on 'Approve Policy' pop-up with Default Date
    Then both versions "V1, V2" of Policy should be displayed on "View/Edit" Policy Forms with below information
      | Version | Status | Icon Status                                                                                      | Assignments_Linked |
      | V2      | Active | Edit_Enabled, Clone_Enabled, Delete_Disabled, AssignmentHistory_Enabled, ApprovePolicy_Disabled  |                  0 |
      | V1      | Legacy | Edit_Disabled, Clone_Enabled, Delete_Disabled, AssignmentHistory_Enabled, ApprovePolicy_Disabled |                  1 |
