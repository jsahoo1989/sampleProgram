Feature: Validate the OnPoint MXClient Auth Form Cloning Functionality

  @CF_End-To-End_MasterScript @CF_MXClient_AuthFormCloning @CF_MXClient_AuthFormCloning_PS
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Approval WorkFlow for AuthForm Cloning Policy Setup
    Given he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor |
      | Client Initiator                         | User Defined    | Portion Cashout      | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

 @CF_End-To-End_MasterScript @CF_MXClient_AuthFormCloning @CF_MXClient_AuthFormCloning_PostSubmitScenario @CF_MXClient_PostSubmitScenario_AuthForm
  Scenario: MXClient - Verifying Authorization Submission with UserDefined TotalPoints, Core/Flex Benefits & PortionCashout for configured AuthForm Cloning BluePrint CF Policy
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has verified 'Total Points' section displayed on 'Authorization Form' for "User Defined" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy
    And he has verified 'FleX Benefits' section displayed on 'Authorization Form' for "Client Initiator" - 'Person Responsible' selection in BluePrint CoreFlex Policy
    And he has navigated to "Benefit Selection Tool" page after entering valid 'Total Points' value and clicking on "Start Benefit Selection" button
    And he has verified following details on "Benefit Selection Tool" page based on configured Points Based CoreFlex BluePrint Policy
      | Available Point Balance | Core Benefits | Flex Benefits | Suggested Bundles | Cashout |
    And he has clicked on 'Back to benefits list' link to navigate to 'Benefit Selection Tool' page
    And he has verified 'Portion Cashout' details on 'Benefit Selection Tool' page
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits and Cashout on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected FlexBenefit and Cashout details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' along with 'Cashout' details displayed on the navigated 'Authorization Form' page
    When he clicks on "Submit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    Then 'Auth Submit Success' growl message should be displayed on the navigated 'MobilityX Dashboard Home' page
    And 'New Initiation Submitted' email should be received having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits Points

@CF_End-To-End_MasterScript @CF_MXClient_AuthFormCloning @CF_MXClient_AuthFormCloning_PostSubmitScenario @CF_MXClient_PostSubmitScenario_ClonedAuthForm
 Scenario: MXClient - Validating Cloned Auth Form Contents and Flex Benefits_Cashout selections post Clone Auth Form Operation
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "View all initiations" link on 'Authorization Home Page' to navigate to 'View all initiation' page
    And he has hovered and clicked on "Clone authorization" button next to 'Submitted' status Authorization created in the above scenario
     And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for a Cloned Employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    
    
    
    
    And he has clicked 'Transferee Name' from 'All Initiations' List on 'View all initiation' page
    And he has navigated to 'Benefit Selection Tool' page after clicking on 'Manage Benefit Selection' button
    And he has navigated to "Benefits Bundle" page after selecting Flex Benefits for resubmission on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button on "Benefits Bundle" page
    When he clicks on "Resubmit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    Then 'Auth Submit Success' growl message should be displayed on the navigated 'View all initiation' page
    And 'Revised Initiation Submitted' email having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits Points should be received
    And 'Mobility Benefits Submission' email having mobility benefit information that company has submitted on behalf of transferee should be received
