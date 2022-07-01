Feature: Validate the New Policy Versioning Workflow for ‘Active’ points based CoreFlex policy that has one or more assignments/files

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @NewInitialVersionPolicyApprovalWorkFlowCheck
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Policy Setup Approval WorkFlow
     Given he has submitted a new "Both" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | PolicyRequiredFor |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Cloning           |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledged 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @TransfereeAssociationVersioning
  Scenario: MXTransferee - Validating association of Transferee with the Active BluePrint Version1 Policy
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    When he navigates to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    Then benefits selected on Active BluePrint "Version1" - "Both" Type Policy should be displayed on "FleX Planning Tool" page
    And custom bundle created in Active BluePrint "Version1" - "Both" Policy should be displayed on "Suggested Bundles" page

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @NewVersionPolicyWorkFlowVersionCheck
  Scenario: CoreFlex - Validating Status & Version of New Policy version created from ‘Active’ points based CoreFlex policy that has one or more assignments/files
    Given he has searched for 'Active' points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched 'Active' points based CoreFlex policy
    And he has entered 'Description' after verifying 'Version Control' popup screen contents
    When he clicks on "CREATE" button on 'Version Control' popup screen
    Then user should be navigated to "General Information" page of 'New Version' policy in 'Editable' mode having Policy Status displayed as "Draft"
    And 'Points Based Flex Policy' field should be disabled with default value as "Yes"

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @NewVersionPolicyWorkFlowBenefitSelectionCheck
  Scenario: CoreFlex - Validating selected Benefits & Custom Bundles of New Policy version created from ‘Active’ points based CoreFlex policy that has one or more assignments/files
    Given he has searched for 'Active' points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has verified 'Enabled/Disabled' status of searched 'Points Based CoreFlex Policy' Icons - "Post" Versioning on "View/Edit Policy Forms" page
      | PolicyVersion | PolicyStatus | EditIcon | DeleteIcon | CloneIcon | AssignmentHistoryIcon |
      | V1            | Active       | Disabled | Disabled   | Enabled   | Enabled               |
      | V2            | Draft        | Enabled  | Enabled    | Disabled  | Disabled              |
    And he has clicked on "Edit" icon of "V2" - "Draft" version of the searched points based CoreFlex policy
    And he has navigated to "General Information" page of 'New Version' policy in 'Editable' mode having Policy Status displayed as "Draft"
    And he has verified 'Policy-Benefits-SubBenefits' details of "V2" - "Draft" version Policy matches with following "V1" policy selections
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | PolicyType | PolicyRequiredFor |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Both       | Versioning        |
    And he has verified 'CustomBundles' and 'Transferee Preview' details of "V2" - "Draft" version Policy matches with "V1" - "Both" type policy
    And he has acknowledged 'Submit Success' dialog after clicking on "Submit" button on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V2" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V2" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledged 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V2" respectively on "View/Edit Policy Forms" page

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @CancelPolicy
  Scenario: CoreFlex - Validating policy status is NOT updated to 'Active' on cancellation of Policy Setup Approval WorkFlow
    Given he has submitted a new "Both" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized |
    And he has clicked on "Approve Policy" button to approve "VI" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V2" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Cancel" button to close 'Approve this Policy' dialog
    Then 'Approve this Policy' dialog should be closed
    And user should be navigated to "Custom Bundles" page having 'Policy Status' and 'Version Number' displayed as "Submitted" and "V1" respectively
