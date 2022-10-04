Feature: Validate Significant Change Feature of Points based CoreFlex policy for BluePrint Enabled Clients

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_SignificantChange @SubmittedPolicyDataCreationSignificantChange
  Scenario: CoreFlex - Creating a new Submitted Status policy as a part of Data Creation activity to validate Significant Change Functionality
    Given he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | Static/Fixed    | Portion Cashout      | Both        | Versioning        |          0 |
    When he clicks on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    Then Policy Status and Version should be displayed as "Submitted" and "V1" respectively on 'Custom Bundles' page

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_SignificantChange @SC_AddBenefit_SubmittedToDraft
  Scenario: CoreFlex - Validate Submitted Policy Status Change to Draft after adding a new Benefit to the Policy having assignment(s) association
    Given he has created a new 'Transferee' through IRIS application for 'Cloning/Versioning' Data Setup
    And he has searched for "Submitted" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Submitted" points based CoreFlex policy
    And he has navigated to "General Information" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as "Submitted"
    And he has clicked on "Next" button to navigate to "Flex Policy Setup" page
    And he has filled 'Benefit-SubBenefit' details after adding a new Benefit on 'Policy Benefit Categories' page
    And he has verified additional added benefit displayed on Summary Details after navigating to 'Benefit Summary' page
    When he clicks on "Continue" button on 'Benefit Summary' page
    Then he should be navigated to "Custom Bundles" page having following buttons displayed in enabled state and 'APPROVE POLICY' button should not be displayed
      | PREVIEW TRANSFEREE EXPERIENCE | SAVE AS DRAFT | SUBMIT |
    And Policy Status should be changed from "Submitted" to "Draft" on 'Custom Bundles' page

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_SignificantChange @SC_AddBenefit_SaveAsDraft
  Scenario: CoreFlex - Validate Save As Draft functionality after adding a new Benefit to the Policy having assignment(s) association
    Given he has searched for "Draft" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Draft" points based CoreFlex policy
    And he has navigated to "General Information" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as "Draft"
    And he has clicked on "Next" button to navigate to "Flex Policy Setup" page
    And he has clicked on "Custom Bundles" link from Left Navigation Menu
    When he clicks on "SAVE AS DRAFT" button on 'Custom Bundles' page
    Then "Success" dialog with message "Policy draft saved." should be displayed
    And Policy Status should be displayed as "Draft" on 'Custom Bundles' page

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_SignificantChange @SC_AddBenefit_DraftToSubmitted
  Scenario: CoreFlex - Validate Submit functionality after adding a new Benefit to the Policy having assignment(s) association
    Given he has searched for "Draft" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Draft" points based CoreFlex policy
    And he has navigated to "General Information" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as "Draft"
    And he has clicked on "Next" button to navigate to "Flex Policy Setup" page
    And he has clicked on "Custom Bundles" link from Left Navigation Menu
    When he clicks on "SUBMIT" button on 'Custom Bundles' page
    Then 'Submit Success' dialog should be displayed
    And Policy Status and Version should be displayed as "Submitted" and "V1" respectively on 'Custom Bundles' page

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_SignificantChange @SC_RemoveBenefit_SubmittedToDraft
  Scenario: CoreFlex - Validate Submitted Policy Status Change to Draft after removing an existing Benefit to the Policy having assignment(s) association
    Given he has searched for "Submitted" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Submitted" points based CoreFlex policy
    And he has navigated to "General Information" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as "Submitted"
    And he has clicked on "Next" button to navigate to "Flex Policy Setup" page
    And he has deselected an existing Benefit on 'Policy Benefit Categories' page
    And he has verified removed benefit is not displayed on Summary Details after navigating to 'Benefit Summary' page
    When he clicks on "Continue" button on 'Benefit Summary' page
    Then he should be navigated to "Custom Bundles" page having following buttons displayed in enabled state and 'APPROVE POLICY' button should not be displayed
      | PREVIEW TRANSFEREE EXPERIENCE | SAVE AS DRAFT | SUBMIT |
    And Policy Status should be changed from "Submitted" to "Draft" on 'Custom Bundles' page

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_SignificantChange @SC_RemoveBenefit_SaveAsDraft
  Scenario: CoreFlex - Validate Save As Draft functionality after removing an existing Benefit from the Policy having assignment(s) association
    Given he has searched for "Draft" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Draft" points based CoreFlex policy
    And he has navigated to "General Information" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as "Draft"
    And he has clicked on "Next" button to navigate to "Flex Policy Setup" page
    And he has clicked on "Custom Bundles" link from Left Navigation Menu
    When he clicks on "SAVE AS DRAFT" button on 'Custom Bundles' page
    Then "Success" dialog with message "Policy draft saved." should be displayed
    And Policy Status should be displayed as "Draft" on 'Custom Bundles' page

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_SignificantChange @SC_RemoveBenefit_DraftToSubmitted
  Scenario: CoreFlex - Validate Submit functionality after removing an existing Benefit from the Policy having assignment(s) association
    Given he has searched for "Draft" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Draft" points based CoreFlex policy
    And he has navigated to "General Information" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as "Draft"
    And he has clicked on "Next" button to navigate to "Flex Policy Setup" page
    And he has clicked on "Custom Bundles" link from Left Navigation Menu
    When he clicks on "SUBMIT" button on 'Custom Bundles' page
    Then 'Submit Success' dialog should be displayed
    And Policy Status and Version should be displayed as "Submitted" and "V1" respectively on 'Custom Bundles' page

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_SignificantChange @SC_ChangeBenefitType_NoChangeInPolicyStatus
  Scenario: CoreFlex - Validate Submitted Policy Status does not change to Draft after changing Benefit Type from Both to Flex of the Policy having assignment(s) association
    Given he has searched for "Submitted" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Submitted" points based CoreFlex policy
    And he has navigated to "General Information" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as "Submitted"
    And he has changed Benefit type of added Benefits from "Both" to "Flex"
    And he has clicked on 'Benefit Summary' link from Left Navigation Menu
    When he clicks on "Continue" button on 'Benefit Summary' page
    Then he should be navigated to "Custom Bundles" page having 'APPROVE POLICY' button in Enabled and 'SUBMIT' button is Disabled state
    And Policy Status should not be changed from "Submitted" to "Draft" for Non-Significant Change in Policy

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_SignificantChange @SC_NoChangeInPolicy_NoChangeInPolicyStatus
  Scenario: CoreFlex - Validate Submitted Policy Status does not change to Draft after changing Benefit Type from Both to Flex of the Policy having assignment(s) association
    Given he has searched for "Submitted" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Submitted" points based CoreFlex policy
    And he has navigated to "General Information" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as "Submitted"
    And he has clicked on "Next" button to navigate to "Flex Policy Setup" page
    And he has clicked on 'Benefit Summary' link from Left Navigation Menu
    When he clicks on "Continue" button on 'Benefit Summary' page
    Then he should be navigated to "Custom Bundles" page having 'APPROVE POLICY' button in Enabled and 'SUBMIT' button is Disabled state
    And Policy Status should not be changed from "Submitted" to "Draft" for Non-Significant Change in Policy

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_SignificantChange @SC_DataCreation
  Scenario: CoreFlex - Submitting a Policy with Additional Benefit as a part of Data Creation
    Given he has searched for "Submitted" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Submitted" points based CoreFlex policy
    And he has navigated to "General Information" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as "Submitted"
    And he has filled 'Benefit-SubBenefit' details after adding a new Benefit on 'Policy Benefit Categories' page
    And he has verified additional added benefit displayed on Summary Details after navigating to 'Benefit Summary' page
    And he has clicked on "Continue" button on 'Benefit Summary' page
    When he clicks on "SUBMIT" button on 'Custom Bundles' page
    Then 'Submit Success' dialog should be displayed
    And Policy Status and Version should be displayed as "Submitted" and "V1" respectively on 'Custom Bundles' page

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_SignificantChange @SC_RemoveSubBenefit_NoChangeInPolicyStatus
  Scenario: CoreFlex - Validate Submitted Policy Status does not change to Draft after Removing a Sub-Benefit from of the Policy having assignment(s) association
    Given he has searched for "Submitted" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Submitted" points based CoreFlex policy
    And he has navigated to "General Information" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as "Submitted"
    And he has clicked on "Next" button to navigate to "Flex Policy Setup" page
    And he has clicked on "Save & Continue" button after removing a 'SubBenefit' from an added Benefit
    And he has clicked on 'Benefit Summary' link from Left Navigation Menu
    When he clicks on "Continue" button on 'Benefit Summary' page
    Then he should be navigated to "Custom Bundles" page having 'APPROVE POLICY' button in Enabled and 'SUBMIT' button is Disabled state
    And Policy Status should not be changed from "Submitted" to "Draft" for Non-Significant Change in Policy

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_SignificantChange @SC_AddSubBenefit_NoChangeInPolicyStatus
  Scenario: CoreFlex - Validate Submitted Policy Status does not change to Draft after Adding a Sub-Benefit to the Policy having assignment(s) association
    Given he has searched for "Submitted" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Submitted" points based CoreFlex policy
    And he has navigated to "General Information" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as "Submitted"
    And he has clicked on "Next" button to navigate to "Flex Policy Setup" page
    And he has clicked on "Save & Continue" button after adding a 'SubBenefit' to an added Benefit
    And he has clicked on 'Benefit Summary' link from Left Navigation Menu
    When he clicks on "Continue" button on 'Benefit Summary' page
    Then he should be navigated to "Custom Bundles" page having 'APPROVE POLICY' button in Enabled and 'SUBMIT' button is Disabled state
    And Policy Status should not be changed from "Submitted" to "Draft" for Non-Significant Change in Policy
