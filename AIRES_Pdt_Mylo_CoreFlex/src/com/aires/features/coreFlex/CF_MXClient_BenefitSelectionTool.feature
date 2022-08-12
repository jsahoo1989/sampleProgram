Feature: Validate the MobilityX Client - Flex Benefit Selection Tool data for Configured Points Based Flex Policy

  @End-To-End_CoreFlex @CF_BluePrint_MXClient_DataCreation @CF_BluePrint_MXClient_BST
  Scenario: CoreFlex - Creating & Validating a new Active Policy as a part of Data Creation activity for MX Client
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor | MileStones |
      | Client Initiator                         | User Defined    | Cashout Not Authorized | Both        | All Benefits      |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_MX_Client_BenefitSelectionTool @CF_BluePrint_MXClient_BST
  Scenario: MXClient - Validating benefits displayed on BenefitSelectionTool page same as policy setup in BluePrint application
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has verified 'Total Points' section displayed on 'Authorization Form' for "User Defined" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy
    And he has verified 'FleX Benefits' section displayed on 'Authorization Form' for "Client Initiator" - 'Person Responsible' selection in BluePrint CoreFlex Policy
    And he has verified 'Error Growl Message' and 'Required Field Validation' displayed after clicking on "Start Benefit Selection" button with Blank/Invalid 'Total Points' value
    And he has navigated to "Benefit Selection Tool" page after entering valid 'Total Points' value and clicking on "Start Benefit Selection" button
    And he has verified following details on "Benefit Selection Tool" page based on configured Points Based CoreFlex BluePrint Policy
      | Available Point Balance | Core Benefits | Flex Benefits | Suggested Bundles | Cashout |
    When he clicks on 'Back to initiation' link on "Benefit Selection Tool" page
    Then he should be navigated back to 'Authorization Form' page