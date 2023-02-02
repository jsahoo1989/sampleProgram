Feature: Validate the CoreFlex End-To-End Business Test Flow(BluePrint, MXClientAndTransferee, Transferee Submissions) for Both_MXClientAndTransferee_StaticFixed_PortionCashout_Delete_ApproveAll selection

  @Coreflex:218615 @CF_End-To-End_MasterScript @CF_Master_ClientAndTransferee_PortionCashout_ApproveAll @CF_Master_ClientAndTransferee_PortionCashout_ApproveAll_PS
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Approval WorkFlow for ClientAndTransferee-PortionCashout MasterScript Policy Setup
    Given he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor |
      | Client and Transferee                    | Static/Fixed    | Portion Cashout      | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @Coreflex:218616 @CF_End-To-End_MasterScript @CF_Master_ClientAndTransferee_PortionCashout_ApproveAll @CF_Master_ClientAndTransferee_PortionCashout_ApproveAll_CF1
  Scenario: MXClient - Validating Total Points Section & Core/Flex benefits displayed on BenefitSelectionTool page for Client and Transferee BluePrint Policy Setup
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has verified 'FleX Benefits' section displayed on 'Authorization Form' for "Client and Transferee" - 'Person Responsible' selection in BluePrint CoreFlex Policy
    And he has clicked on 'Start Benefit Selection' on 'Auth Form Template' page to navigate to 'Benefit Selection Tool' page
    And he has verified following details on "Benefit Selesction Tool" page based on configured Points Based CoreFlex BluePrint Policy
      | Available Point Balance | Core Benefits | Flex Benefits | Suggested Bundles | Cashout |
    And he has clicked on 'Back to benefits list' link to navigate to 'Benefit Selection Tool' page
    #And he has verified 'Portion Cashout' details on 'Benefit Selection Tool' page
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits and Cashout on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected Flex Benefit details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' details displayed on the navigated 'Authorization Form' page
    When he clicks on "Submit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    Then 'Auth Submit Success' growl message should be displayed on the navigated 'MobilityX Dashboard Home' page
    And 'New Initiation Submitted' email should be received having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits Points

  @Coreflex:218617 @CF_End-To-End_MasterScript @CF_Master_ClientAndTransferee_PortionCashout_ApproveAll @CF_Master_ClientAndTransferee_PortionCashout_ApproveAll_TF
  Scenario: MXTransferee - Validating Selection & Submission of Flex benefits available in Client configured policy and Tracking Available_Used Benefits Points
    Given he has logged into 'MobilityX' application after actualizing a new 'Transferee' through IRIS application and setting-up user profile in 'MobilityX' application
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "OnPoint Planning Tool" page after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    When he clicks on 'Next' floating button after verifying Benefits_Points details Submitted by Client on 'OnPoint Planning Tool' page
    Then Benefits Submitted by Client should be displayed under 'Submitted Benefits' section of 'My Benefits Bundle' page

  @Coreflex:218618 @CF_End-To-End_MasterScript @CF_Master_ClientAndTransferee_PortionCashout_ApproveAll @CF_Master_ClientAndTransferee_PortionCashout_ApproveAll_CF2
  Scenario: MXClient - Validating Revised Initiation Submitted and Mobility Benefits Submission emails is generated upon resubmission of Flex benefits Auth Form
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "View all initiations" link on 'Authorization Home Page' to navigate to 'View all initiation' page
    And he has clicked 'Transferee Name' from 'All Initiations' List on 'View all initiation' page
    And he has navigated to 'Benefit Selection Tool' page after clicking on 'Manage Benefit Selection' button
    And he has navigated to "Benefits Bundle" page after selecting Flex Benefits for resubmission on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button on "Benefits Bundle" page
    When he clicks on "Resubmit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    Then 'Auth Submit Success' growl message should be displayed on the navigated 'View all initiation' page
    And 'Revised Initiation Submitted' email having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits Points should be received
    And 'Mobility Benefits Submission' email having mobility benefit information that company has submitted on behalf of transferee should be received
