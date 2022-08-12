Feature: Validate the Cloning feature of Points Based CoreFlex policy in BluePrint Application

  @End-To-End_CoreFlex @CF_MX_Client_BlueprintPolicies_DataCreation
  Scenario: CoreFlex - Creating & Validating a new Active Policy as a part of Data Creation activity for MX Client
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | User Defined    | Cashout Not Authorized | Both        | All Benefits      |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  