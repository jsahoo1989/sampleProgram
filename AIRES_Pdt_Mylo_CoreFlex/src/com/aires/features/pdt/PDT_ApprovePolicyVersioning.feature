Feature: Approve Policy to create new version
  Validate the functionality of Approve Policy with Versioning feature

  Background: Login to  Policy Digitization Tool (PDT) application
    Given he is logged into 'Aires Policy Tool' application as a "Client Service Manager" user

  @Sprint-29 @PDT-Regression @PDT-1115 @Pdt:217683 @test1
  Scenario: PDT - Validate 'Approve Policy' button is displayed as visible after submission of a policy from 'Policy benefit' page
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Home Leave" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    Then "Approve Policy" button should become visible on the 'Policy Benefit' page
    And "SAVE & SUBMIT" button should become disabled on the 'Policy Benefit' page

  @Sprint-29 @PDT-Regression @PDT-1115 @Pdt:217684 @test2
  Scenario: PDT - Validate the UI of 'Approve Policy' pop-up displayed after clicking Approve Policy button on "Policy Benefit" page
    Given he is on the "Policy Benefit" page after selecting "Home Leave" as Benefit Category;
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
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
    And he clicks on 'Approve Policy' button after verifying status "Submitted" on header section of "Policy Benefit" page
    When he selects the checkbox having label 'Associate this policy with a NEW authorization in IRIS?' on 'Approve Policy' pop-up
    Then "Approve" button should become "enabled" on 'Approve Policy' pop-up

  @Sprint-29 @PDT-Regression @PDT-1115 @Pdt:217686 @tes
  Scenario: PDT - Verify that status of a 'Submitted' Policy changes to 'Active' after clicking 'Approve' button on 'Approve Policy' pop-up
    Given he is on the "Policy Benefit" page after selecting "Home Leave" as Benefit Category;
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    And he clicks on 'Approve Policy' button after verifying status "Submitted" on header section of "Policy Benefit" page
    And he selects the checkbox having label 'Associate this policy with a NEW authorization in IRIS?' on 'Approve Policy' pop-up
    When he clicks on "Approve" button on 'Approve Policy' pop-up on "Policy Benefit" page
    Then Version "V1" of Policy should be displayed on "View/Edit Policy Forms" page with "Active" status

  @Sprint-29 @PDT-Regression @PDT-1115 @Pdt:217687
  Scenario: PDT - Verify that Policy Status of a 'Submitted' Policy should not change after clicking 'Cancel' button on 'Approve Policy' pop-up
    Given he is on the "Policy Benefit" page after selecting "Home Leave" as Benefit Category;
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    And he clicks on 'Approve Policy' button after verifying status "Submitted" on header section of "Policy Benefit" page
    And he selects the checkbox having label 'Associate this policy with a NEW authorization in IRIS?' on 'Approve Policy' pop-up
    When he clicks on "Cancel" button on 'Approve Policy' pop-up on "Policy Benefit" page
    Then Status of Policy should remain "Submitted" with Version "V1" on "Policy Benefit" Page

  @Sprint-30 @PDT-Regression @PDT-1116 @Pdt:218025
  Scenario: PDT - Verify that Assignment History Section should display the Assignments linked with newly created Active Policy
    Given he is on the "View/Edit Policy Forms" page after approving a policy with below sub-benefits of "Language Training" Benefit Category;
      | Language Training Employee | Language Training Family |
    And he has submitted a new authorization form in MobilityX application using template "Global Relocation Authorization"
    When he clicks on "Assignment History" icon on "View/Edit Policy Forms" page of 'PDT' application for the newly created Active policy
    Then Assignment details should be displayed in 'Assignment History' Page

  @Sprint-30 @PDT-Regression @PDT-1117 @Pdt:218026
  Scenario: PDT - Verify the UI of Version Control pop-up while editing Active Policy having assignments.
    Given he is on the "View/Edit Policy Forms" page after approving a policy with below sub-benefits of "Language Training" Benefit Category;
      | Language Training Employee | Language Training Family |
    And he has submitted a new authorization form in MobilityX application using template "Global Relocation Authorization"
    When he clicks on "Edit" icon on "View/Edit Policy Forms" page of 'PDT' application for the newly created Active policy
    Then below information should be displayed in the pop-up
      | Message1    | This policy version "V1" is in an Active state and currently has 1 assignments or files associated with it in IRIS.                                                    |
      | Message2    | To edit this policy, you will need to create a new version and save it to a Draft state. To create the new draft, please input a brief description, then click create. |
      | Version     | Version: V2                                                                                                                                                            |
      | Description | textbox                                                                                                                                                                |
      | Button      | Create_disabled, Cancel_enabled                                                                                                                                        |
    And "Create" button becomes "enabled" after entering text on Description textbox

  @Sprint-31 @PDT-Regression @BLUE-190 @Pdt:218027
  Scenario: PDT - Verify updating version V1 of Active Policy having assignments with option new Authorization with current date creates new Active version V2 of Policy and old version V1 becomes Legacy
    Given he is on the "View/Edit Policy Forms" page after approving a policy with below sub-benefits of "Language Training" Benefit Category;
      | Language Training Employee | Language Training Family |
    And he has submitted a new authorization form in MobilityX application using template "Global Relocation Authorization"
    And he has navigated to 'General Information page' of PDT application followed by selection of "Cultural Training" as Benefit Category on "Policy Benefit" page after clicking on "Edit" icon on "View/Edit Policy Forms" page
    And he has submitted the mandatory information for "Cultural Training" sub-benefit forms
    When he approves the policy after selecting the checkbox having label 'Associate this policy with a NEW authorization in IRIS?' on 'Approve Policy' pop-up with Default Date on "Cultural Training" page
    Then both versions "V1, V2" of Policy should be displayed on "View/Edit" Policy Forms with below information
      | Version | Status | EnabledIcon                     | DisabledIcon                 | Assignments_Linked |
      | V2      | Active | Edit, Clone, Assignment History | Delete, Approve Policy       |                  0 |
      | V1      | Legacy | Clone, Assignment History       | Edit, Delete, Approve Policy |                  1 |

  @BLUE-01 @PDT-Regression @BLUE-85 @Pdt:218028
  Scenario: PDT - Verify updating version V1 of Active Policy having assignments with option existing Authorization with current date creates new Active version V2 of Policy and old version V1 becomes Inactive.
    Given he is on the "View/Edit Policy Forms" page after approving a policy with below sub-benefits of "Language Training" Benefit Category;
      | Language Training Employee | Language Training Family |
    And he has submitted a new authorization form in MobilityX application using template "Global Relocation Authorization"
    And he has navigated to 'General Information page' of PDT application followed by selection of "Cultural Training" as Benefit Category on "Policy Benefit" page after clicking on "Edit" icon on "View/Edit Policy Forms" page
    And he has submitted the mandatory information for "Cultural Training" sub-benefit forms
    When he approves the policy after selecting selecting the checkbox having label 'Associate this policy with an existing authorization in IRIS?' on 'Approve Policy' pop-up with Default Date
    Then both versions "V1, V2" of Policy should be displayed on "View/Edit" Policy Forms with below information
      | Version | Status   | EnabledIcon                     | DisabledIcon                 | Assignments_Linked |
      | V2      | Active   | Edit, Clone, Assignment History | Delete, Approve Policy       |                  1 |
      | V1      | Inactive | Clone, Assignment History       | Edit, Delete, Approve Policy |                  0 |

  @BLUE-02 @PDT-Regression @BLUE-282 @Pdt:218029
  Scenario: PDT - Validate user is able to update an Active Policy having no Assignments without creating the new version of Policy.
    Given he has verified the name, version of Policy on "View/Edit Policy Forms" page after approving a policy with below sub-benefits of "Language Training" Benefit Category;
      | Language Training Employee | Language Training Family |
    And he has updated information on 'General Information page' of PDT application after clicking on "Edit" icon on "View/Edit Policy Forms" page
    And he has submitted the mandatory information for 'Cultural Training' sub-benefit forms after selecting "Cultural Training" as Benefit Category on "Policy Benefit" page
    When he approves the updated policy after selecting the checkbox having label 'Associate this policy with a NEW authorization in IRIS?' on 'Approve Policy' pop-up with Default Date on "Cultural Training" page
    Then version of policy should remain "V1" on "View/Edit Policy Forms" page with below information
      | Version | Status | EnabledIcon                     | DisabledIcon           | Assignments_Linked |
      | V1      | Active | Edit, Clone, Assignment History | Delete, Approve Policy |                  0 |
