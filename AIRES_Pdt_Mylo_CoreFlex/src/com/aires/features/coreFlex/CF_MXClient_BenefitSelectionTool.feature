Feature: Validate the MobilityX Client Total Points & Flex Benefit Selection Tool sections for Configured Points Based Flex Policy

  @End-To-End_CoreFlex @CF_BluePrint_MXClientInitiatior_DataCreation @CF_BluePrint_MXClientInitiatior_BST
  Scenario: CoreFlex - Creating & Validating a new Active Points Based CoreFlex Policy with Client Initiator, UserDefined and CashNotAuth selection
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor | MileStones |
      | Client Initiator                         | User Defined    | Cashout Not Authorized | Both        | Client            |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_MX_ClientInitiatior_BenefitSelectionTool @CF_BluePrint_MXClientInitiatior_BST
  Scenario: MXClient - Validating Total Points Section & Core/Flex benefits displayed on BenefitSelectionTool page for Client Initiator BluePrint Policy Setup
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has verified 'Total Points' section displayed on 'Authorization Form' for "User Defined" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy
    And he has verified 'FleX Benefits' section displayed on 'Authorization Form' for "Client Initiator" - 'Person Responsible' selection in BluePrint CoreFlex Policy
    And he has verified 'Error Growl Message' and 'Required Field Validation' displayed after clicking on "Start Benefit Selection" button with Blank/No 'Total Points' value
    And he has navigated to "Benefit Selection Tool" page after entering valid 'Total Points' value and clicking on "Start Benefit Selection" button
    And he has verified following details on "Benefit Selection Tool" page based on configured Points Based CoreFlex BluePrint Policy
      | Available Point Balance | Core Benefits | Flex Benefits | Suggested Bundles | Cashout |
    When he clicks on 'Back to initiation' link on "Benefit Selection Tool" page
    Then he should be navigated back to 'Authorization Form' page
    And all information entered before navigating to 'Benefit Selection Tool' page should be auto-saved on 'Authorization Form'

  @End-To-End_CoreFlex @CF_BluePrint_MXClientAndTransferee_DataCreation @CF_BluePrint_MXClientAndTransferee_BST
  Scenario: CoreFlex - Creating & Validating a new Active Points Based CoreFlex Policy with Client & Transferee, UserDefined and PortionCashout selection
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor | MileStones |
      | Client and Transferee                    | User Defined    | Portion Cashout      | Both        | Client            |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_MX_ClientAndTransferee_BenefitSelectionTool @CF_BluePrint_MX_ClientAndTransferee_BST
  Scenario: MXClient - Validating Total Points Section & Core/Flex benefits displayed on BenefitSelectionTool page for Client and Transferee BluePrint Policy Setup
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has verified 'Total Points' section displayed on 'Authorization Form' for "User Defined" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy
    And he has verified 'FleX Benefits' section displayed on 'Authorization Form' for "Client and Transferee" - 'Person Responsible' selection in BluePrint CoreFlex Policy
    And he has verified 'Error Growl Message' and 'Required Field Validation' displayed after clicking on "Submit to Aires" button with Blank/No 'Total Points' value
    And he has navigated to "Benefit Selection Tool" page after entering valid 'Total Points' value and clicking on "Start Benefit Selection" button
    And he has verified following details on "Benefit Selection Tool" page based on configured Points Based CoreFlex BluePrint Policy
      | Available Point Balance | Core Benefits | Flex Benefits | Suggested Bundles | Cashout |
    When he clicks on 'Back to initiation' link on "Benefit Selection Tool" page
    Then he should be navigated back to 'Authorization Form' page
    And all information entered before navigating to 'Benefit Selection Tool' page should be auto-saved on 'Authorization Form'

  @End-To-End_CoreFlex @CF_BluePrint_MXTransferee_UserDefined @CF_BluePrint_MXTransferee_BST
  Scenario: CoreFlex - Creating & Validating a new Active Points Based CoreFlex Policy with Transferee, UserDefined and AfterRelocationOnly selection
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability  | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | User Defined    | After Relocation Only | Both        | Client            |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_MX_Transferee_UserDefined @CF_BluePrint_MX_Transferee_BST
  Scenario: MXClient - Validating Total Points section is displayed for UserDefined FlexSetupType and Flex Benefits section is not displayed for Transferee selection in BluePrint Policy Setup
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    When he selects CoreFlex policy in the 'Relocation Policy' dropdown on the Authorization form
    Then 'Total Points' section should be displayed on 'Authorization Form' for "User Defined" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy
    And 'FleX Benefits' section should not be displayed on 'Authorization Form' for "Transferee" - 'Person Responsible' selection in BluePrint CoreFlex Policy

  @End-To-End_CoreFlex @CF_BluePrint_MXTransferee_StaticFixed @CF_BluePrint_MXTransferee_BST 
  Scenario: CoreFlex - Creating & Validating a new Active Points Based CoreFlex Policy with Transferee, Static/Fixed and AfterRelocationOnly selection
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability  | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | Static/Fixed    | After Relocation Only | Both        | Client            |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_MX_Transferee_StaticFixed @CF_BluePrint_MX_Transferee_BST 
  Scenario: MXClient - Validating Total Points section is not displayed for Static/Fixed FlexSetupType and Flex Benefits section is not displayed for Transferee selection in BluePrint Policy Setup
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    When he selects CoreFlex policy in the 'Relocation Policy' dropdown on the Authorization form
    Then 'Total Points' section should not be displayed on 'Authorization Form' for "Static/Fixed" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy
    And 'FleX Benefits' section should not be displayed on 'Authorization Form' for "Transferee" - 'Person Responsible' selection in BluePrint CoreFlex Policy

  @End-To-End_CoreFlex @CF_BluePrint_MXClientInitiatior_StaticFixed @CF_BluePrint_MXClientInitiatior_BST
  Scenario: CoreFlex - Creating & Validating a new Active Points Based CoreFlex Policy with ClientInitiatior, Static/Fixed and AfterRelocationOnly selection
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability  | BenefitType | PolicyRequiredFor | MileStones |
      | ClientInitiatior                         | Static/Fixed    | After Relocation Only | Both        | Client            |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_MX_ClientInitiatior_StaticFixed @CF_BluePrint_MX_ClientInitiatior_BST
  Scenario: MXClient - Validating Total Points section is not displayed for Static/Fixed FlexSetupType and Flex Benefits section is displayed for ClientInitiatior selection in BluePrint Policy Setup
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    When he selects CoreFlex policy in the 'Relocation Policy' dropdown on the Authorization form
    Then 'Total Points' section should not be displayed on 'Authorization Form' for "Static/Fixed" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy
    And 'FleX Benefits' section should be displayed on 'Authorization Form' for "Client Initiatior" - 'Person Responsible' selection in BluePrint CoreFlex Policy

  @End-To-End_CoreFlex @CF_BluePrint_MXClientAndTransferee_StaticFixed @CF_BluePrint_MXClientAndTransferee_BST
  Scenario: CoreFlex - Creating & Validating a new Active Points Based CoreFlex Policy with Client & Transferee, Static/Fixed and AfterRelocationOnly selection
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability  | BenefitType | PolicyRequiredFor | MileStones |
      | Client and Transferee                    | Static/Fixed    | After Relocation Only | Both        | Client            |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_MX_ClientAndTransferee_StaticFixed @CF_BluePrint_MX_ClientAndTransferee_BST
  Scenario: MXClient - Validating Total Points section is not displayed for Static/Fixed FlexSetupType and Flex Benefits section is displayed for Client & Transferee selection in BluePrint Policy Setup
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    When he selects CoreFlex policy in the 'Relocation Policy' dropdown on the Authorization form
    Then 'Total Points' section should not be displayed on 'Authorization Form' for "Static/Fixed" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy
    And 'FleX Benefits' section should be displayed on 'Authorization Form' for "Client and Transferee" - 'Person Responsible' selection in BluePrint CoreFlex Policy
