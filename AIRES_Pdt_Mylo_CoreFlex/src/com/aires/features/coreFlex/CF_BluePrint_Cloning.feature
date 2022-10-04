Feature: Validate the Cloning feature of Points Based CoreFlex policy in BluePrint Application

  @End-To-End_CoreFlex @CF_BluePrint_Cloning @DataCreation_Cloning
  Scenario: CoreFlex - Creating & Validating a new Active Policy as a part of Data Creation activity for Cloning
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Both        | All Benefits      |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_BluePrint_Cloning @DataCreation_Cloning
  Scenario: CoreFlex - Creating & Validating a new Legacy Status policy as a part of Data Creation activity for Cloning
    Given he has created a new 'Transferee' through IRIS application for 'Cloning/Versioning' Data Setup
    And he has searched for "Active" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Active" points based CoreFlex policy
    And he has entered 'Description' after verifying 'Version Control' popup screen contents
    And he has clicked on "CREATE" button on 'Version Control' popup screen
    And he has navigated to "General Information" page of 'New Version' policy in 'Editable' mode having Policy Status displayed as "Draft"
    And he has navigated to "Custom Bundles" page from Left Navigation
    And he has acknowledged 'Submit Success' dialog after clicking on "Submit" button on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V2" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V2" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V2" respectively on "View/Edit Policy Forms" page
    And Policy Status of Version "V1" policy should be displayed as "Legacy" on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_BluePrint_Cloning @DataCreation_Cloning
  Scenario: CoreFlex - Creating & Validating a new Submitted Status policy as a part of Data Creation activity for Cloning
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Both        | All Benefits      |          0 |
    When he clicks on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    Then Policy Status and Version should be displayed as "Submitted" and "V1" respectively on 'Custom Bundles' page

  @End-To-End_CoreFlex @CF_BluePrint_Cloning @CloneIconEnabledDisabledStatusCheck
  Scenario Outline: CoreFlex - Validating Clone Policy Icon - Enabled/Disabled status for Policy with Submit/Active/Legacy/Inactive/Draft status
    Given he has logged into 'BluePrint' application as 'CSM - SSO' user
    And he has searched for 'Points Based CoreFlex Policy' with Policy Status as "<PolicyStatus>"
    When he mouse-hover the "Clone" icon to check to check "<PolicyStatus>" policy Enabled/Disabled property
    Then "Clone" icon Enabled/Disabled status should be "<EnabledDisabledStatus>" for "<PolicyStatus>" Policy Status

    Examples: 
      | PolicyStatus | EnabledDisabledStatus |
      | Submitted    | Enabled               |
      | Active       | Enabled               |
      | Legacy       | Enabled               |
      | Draft        | Disabled              |

  @End-To-End_CoreFlex @CF_BluePrint_Cloning @CloningToSameClientPolicy
  Scenario Outline: CoreFlex - Validating Cloned Policy contents for same Client reference selection and Policy with Submit/Active/Legacy status
    Given he has logged into 'BluePrint' application as 'CSM - SSO' user
    And he has clicked on 'Clone Policy' icon after searching for 'Points Based CoreFlex Policy' with Policy Status as "<PolicyStatus>"
    And he has verified following 'Clone Policy' dialog values after clicking on 'Clone Policy' icon for Enabled Clone Icon "<PolicyStatus>"
      | Reference Policy | Reference Client | Clone to: Client | Clone to: Policy |
    And he has selected a "Existing" client value in 'Clone to: Client' dropdown along with a new policy in 'Clone to: Policy' dropdown
    When he clicks on "SAVE AS DRAFT" button
    Then he should be navigated to "General Information" page of new 'Cloned - Points based CoreFlex Policy' saved as "Draft" with Policy Version as "V1"
    And all the 'CoreFlex' benefits from the reference 'Points Based CoreFlex policy' should be copied over to the 'Cloned - Points based CoreFlex Policy'

    Examples: 
      | PolicyStatus |
      | Submitted    |
      | Active       |
      | Legacy       |

  @End-To-End_CoreFlex @CF_BluePrint_Cloning @CloningToDifferentClientPolicy
  Scenario Outline: CoreFlex - Validating Cloned Policy contents for different Client reference selection and Policy with Submit/Active/Legacy status
    Given he has logged into 'BluePrint' application as 'CSM - SSO' user
    And he has clicked on 'Clone Policy' icon after searching for 'Points Based CoreFlex Policy' with Policy Status as "<PolicyStatus>"
    And he has verified following 'Clone Policy' dialog values after clicking on 'Clone Policy' icon for Enabled Clone Icon "<PolicyStatus>"
      | Reference Policy | Reference Client | Clone to: Client | Clone to: Policy |
    And he has selected a "Different" client value in 'Clone to: Client' dropdown along with a new policy in 'Clone to: Policy' dropdown
    When he clicks on "SAVE AS DRAFT" button
    Then he should be navigated to "General Information" page of new 'Cloned - Points based CoreFlex Policy' saved as "Draft" with Policy Version as "V1"
    And all the 'CoreFlex' benefits from the reference 'Points Based CoreFlex policy' should be copied over to the 'Cloned - Points based CoreFlex Policy'

    Examples: 
      | PolicyStatus |
      | Submitted    |
      | Active       |
      | Legacy       |
