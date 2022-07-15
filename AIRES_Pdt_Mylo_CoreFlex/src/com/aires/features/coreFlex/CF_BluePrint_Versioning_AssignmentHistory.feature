Feature: Validate Assignment History Feature of Points based CoreFlex policy that has one or more assignments/files for BluePrint Enabled Client

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_AssignmentHistory @AssignmentHistoryIconEnabledDisabledStatusCheck
  Scenario Outline: CoreFlex - Validate Assignment History Icon - Enabled/Disabled status for Policy with Submit/Active/Legacy/Inactive/Draft status
    Given he has logged into 'BluePrint' application as 'CSM - SSO' user
    And he has searched for 'Points Based CoreFlex Policy' with Policy Status as "<PolicyStatus>"
    When he mouse-hover the "Assignment History" icon to check to check "<PolicyStatus>" policy Enabled/Disabled property
    Then "Assignment History" icon Enabled/Disabled status should be "<EnabledDisabledStatus>" for "<PolicyStatus>" Policy Status

    Examples: 
      | PolicyStatus | EnabledDisabledStatus |
      | Active       | Enabled               |
      | Legacy       | Enabled               |
      | Submitted    | Disabled              |
      | Draft        | Disabled              |

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_AssignmentHistory @ActiveStatusPolicyCreationAssignmentHistory
  Scenario: CoreFlex - Validate policy status is updated to 'Active' on completion of Policy Setup Approval WorkFlow
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Flex        | Versioning        |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledged 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_AssignmentHistory @AssignmentHistoryDataNotAvailableCheck
  Scenario: CoreFlex - Validate Assignment History Data is not available for selected points based core flex policy until Assignment is associated with the Policy
    Given he has searched for 'Active' points based CoreFlex policy that does not have any assignments/files association on "View/Edit Policy Forms" page
    When he clicks on "Assignment History" icon of the searched "Active" points based CoreFlex policy
    Then he should be navigated to the searched policy "View Policy Benefit" - 'Assignment History' page
    And "No data found." text should be displayed in 'Assignment History' table
    And "Export" button should not be displayed above 'Assignment History' table

  @End-To_End_CoreFlex @CF_BluePrint_Versioning @Versioning_AssignmentHistory @AssignmentHistoryDataVerification
  Scenario: CoreFlex - Validate Assignment History Data for selected points based core flex policy that has one or more assignments/files
    Given he has created a new 'Transferee' through IRIS application for 'Cloning/Versioning' Data Setup
    And he has searched for "Active" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    When he clicks on "Assignment History" icon of the searched "Active" points based CoreFlex policy
    Then he should be navigated to the searched policy "View Policy Benefit" - 'Assignment History' page
    And following details of Assignment should be displayed under 'Assignment History' table
      | Assignment ID | Transferee Name | Assignment Status | Booked Date | Origin Country | Destination Country | MSPEC Name | PPC Name |
    And "Export" button should be displayed above 'Assignment History' table
