Feature: Validate the CoreFlex End-To-End Business Test Flow(BluePrint, MXClientAndTransferee, Transferee Submissions) for Both_MXClientAndTransferee_StaticFixed_CashoutNotAuthorized_Delete_DenyAll selection

  @End-To-End_CoreFlex @CF_DynamicDocument_PolicySetup 
  Scenario: CoreFlex - Creating a new Active Points Based CoreFlex Policy with MXClientAndTransferee selection for Dynamic Document Verification
    Given he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor |
      | Client and Transferee                    | Static/Fixed    | Cashout Not Authorized | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_DynamicDocument_PDF @Test45633
  Scenario: MXClient - Verifying Core/Flex benefits details on Dymanic doc Preview page and PDF file submitted on Core/Flex benefits displayed on BenefitSelectionTool page for Client and Transferee BluePrint Policy Setup
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has verified 'FleX Benefits' section displayed on 'Authorization Form' for "Client and Transferee" - 'Person Responsible' selection in BluePrint CoreFlex Policy
    And he has clicked on 'Start Benefit Selection' on 'Auth Form Template' page to navigate to 'Benefit Selection Tool' page
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected Flex Benefit details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' details displayed on the navigated 'Authorization Form' page
    And he has clicked on 'Upload or Create a Document' tab on 'Authorization Form' page
    When he clicks on "Create LOU" on 'What type of document would you like to add?' pop-up dialog
    Then he has verified following options on the navigated 'Demo Dynamic Document' pop-up dialog
    