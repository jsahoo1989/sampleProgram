Feature: Validate the MXClient Auth Form Sequential-ApprovalWF and CoreFlex End-To-End Business Test Flow(BluePrint, MXClient, Transferee Submissions) for Both_MXClient_UserDefined_PortionCashout_Delete_DenyAll selection

  @OnPoint_Regression @CF_End-To-End_MasterScript @CF_MXClient_ApprovalWF_Sequential_UserDefined_PortionCashout @CF_MXClient_ApprovalWF_Sequential_UserDefined_PortionCashout_PS
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Approval WorkFlow for Client-SequentialWF-UserDefined-PortionCashout_MasterScript Policy Setup
    Given he has setup a new OnPoint Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor |
      | Client Initiator                         | User Defined    | Portion Cashout      | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @OnPoint_Regression @CF_End-To-End_MasterScript @CF_MXClient_ApprovalWF_Sequential_UserDefined_PortionCashout @CF_MXClient_ApprovalWF_Sequential_UserDefined_PortionCashout_PS
  Scenario: MXClient - Validating Total Points Section & Core/Flex benefits displayed on BenefitSelectionTool page and Sequential ApprovalWF Options for Client Initiator BluePrint Policy Setup
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has verified 'Total Points' section displayed on 'Authorization Form' for "User Defined" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy
    And he has verified 'FleX Benefits' section displayed on 'Authorization Form' for "Client Initiator" - 'Person Responsible' selection in BluePrint CoreFlex Policy
    And he has clicked on 'Start Benefit Selection' after entering valid 'Benfit Total Points' value on 'Auth Form Template' page
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits and Cashout on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected FlexBenefit and Cashout details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has clicked on "Collaboration" tab on 'Intiation' page to navigate to 'Collaboration Workflow' page
    And he has added following approvers for 'Authorization Form' to be routed in "Route in sequential order" order on 'Collaboration' tab
      | Role     | Name             | Comments                          | Email                               | Approver job title   |
      | Approver | Test ApproverOne | Add an first approver to an Auth  | airesautomation@aires.com           | Relonet Approver One |
      | Approver | Test ApproverTwo | Add an second approver to an Auth | airesautomationTransferee@aires.com | Relonet Approver Two |
    And he has clicked on "Start routing" button from right floating menu of 'Authorization Form' page
    And he has verified 'Initiation routed for approver workflow' success dialog displayed on 'Authorization Form' page
    When he clicks on "Continue working on this initiation" option on sucess dialog
    Then 'Form Intiator' should not navigate away from 'Collaboration Workflow' page
    And 'Form Intiator' Contibutor workflow should be completed and "Routing for approval..." text should be displayed in Approval Workflow section
    And 'Cancel Routing' and 'Resubmit to Aires' buttons should be displayed on right floating menu of 'Authorization Form' page
    And Email notification should be sent to First Approver "Test ApproverOne" for approval but not to Second Approver "Test ApproverTwo"

  @OnPoint_Regression @CF_End-To-End_MasterScript @CF_MXClient_ApprovalWF_Sequential_UserDefined_PortionCashout @CF_MXClient_ApprovalWF_Sequential_UserDefined_PortionCashout_AF1
  Scenario: MXClient - Validating Email Contents received in Approver Review Required Email and Approval of Authorization by ApproverOne
    Given "Test ApproverOne" has received 'Approver Review Required' email
    And "Test ApproverOne" has verified 'CoreFlex Assignment' details in the received 'Approver Review Required' email before 'Approving' request
    And "Test ApproverOne" has navigated to "AuthWorkFlowAction" page after clicking on "SUBMIT MY RESPONSE" button on 'Approver Review Required' email
    And he has verified CoreFlex 'Benefits_Cashout' and 'BenefitsTotalPoints' details on 'Authorization Form' displayed on the "AuthWorkFlowAction" page
    When "Test ApproverOne" clicks on "Approve" button on 'Authorization Form'
    Then 'Auth Form' status should be displayed as "Approved" on "AuthWorkFlowAction" page
    And Email notification should be sent to Second Approver "Test ApproverTwo" for approval

  @OnPoint_Regression @CF_End-To-End_MasterScript @CF_MXClient_ApprovalWF_Sequential_UserDefined_PortionCashout @CF_MXClient_ApprovalWF_Sequential_UserDefined_PortionCashout_AF2
  Scenario: MXClient - Validating Email Contents received in Approver Review Required Email and Approval of Authorization by ApproverTwo
    Given "Test ApproverTwo" has received 'Approver Review Required' email
    And "Test ApproverTwo" has verified 'CoreFlex Assignment' details in the received 'Approver Review Required' email before 'Approving' request
    And "Test ApproverTwo" has navigated to "AuthWorkFlowAction" page after clicking on "SUBMIT MY RESPONSE" button on 'Approver Review Required' email
    And he has verified CoreFlex 'Benefits_Cashout' and 'BenefitsTotalPoints' details on 'Authorization Form' displayed on the "AuthWorkFlowAction" page
    When "Test ApproverTwo" clicks on "Approve" button on 'Authorization Form'
    Then 'Auth Form' status should be displayed as "Approved" on "AuthWorkFlowAction" page

  #And 'Authorization Form' status should be displayed as 'Submitted' in 'Mobility Submitted' email
  @OnPoint_Regression @CF_End-To-End_MasterScript @CF_MXClient_ApprovalWF_Sequential_UserDefined_PortionCashout @CF_MXClient_ApprovalWF_Sequential_UserDefined_PortionCashout_CF2
  Scenario: MXClient - Verifying Authorization Submission after Deleting Submitted Core/Flex Benefits Status on MXClient Submitted Benefits
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "View all initiations" link on 'Authorization Home Page' to navigate to 'View all initiation' page
    And he has clicked 'Transferee Name' from 'All Initiations' List on 'View all initiation' page
    And he has clicked on "Resubmit to Aires" button from right floating menu of 'Authorization Form' page to Resubmit Auth Form
    And he has verified 'Auth Submit Success' growl message displayed on the navigated 'Advanced Authorization Search' page
    And he has verified 'Revised Initiation Submitted' email having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits Points
    And he has actualized the Transferee after selecting required 'MSPEC_PPC' user and setting file status as 'Active' in IRIS application
    And he has clicked 'Transferee Name' from 'All Initiations' List on 'View all initiation' page
    And he has navigated to 'Benefit Selection Tool' page after clicking on 'Manage Benefit Selection' button
    And he has verified following details on 'Benefit Selection Tool' page post Authorization form submission
      | Available Point Balance | Edit Submitted Benefits | Cashout |
    And he has clicked on 'Edit Submitted Benefits' button to navigate to 'Benefits Bundle' page
    And he has verified submitted 'Core_Flex Benefit_Cashout' details displayed under 'Submitted Benefits' section of 'Benefits Bundle' page
    And he has 'Deleted' submitted Benefit_Cashout on Benefits Bundle page and confirmed 'Remove Benefit Selection' dialog by entering username and clicking on "Yes-request to delete this benefit"
    And he has verified 'Status' of the deleted Benefit_Cashout displayed as "Delete Request Pending" under 'Submitted Benefits' section of 'Benefits Bundle' page
    And he has clicked on 'Back to initiation' link on 'Benefit Selection Tool' to navigate to 'Authorization Form' page
    When he clicks on "Resubmit to Aires" button from right floating menu of 'Authorization Form' page
    Then 'Auth Submit Success' growl message should be displayed on the navigated 'Advanced Authorization Search' page
    And 'Revised Mobility Initiation' email having submitted_deleted Benefit and Points details should be received

  @OnPoint_Regression @CF_End-To-End_MasterScript @CF_MXClient_ApprovalWF_Sequential_UserDefined_PortionCashout @CF_MXClient_ApprovalWF_Sequential_UserDefined_PortionCashout_TS
  Scenario: TransfereeSubmissions - Verifying UserDefined Points, Benefit_Cashout Submissions and Delete Request DenyAll transaction for the request made by the Client
    Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user
    And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the Client
    And he has clicked on "Review" button for Bundle submitted by the Client on "Transferee Submissions Dashboard" page
    And he has navigated to "Transferee Submission Details" page having list of submitted Benefits_Cashout details by Client
    And he has clicked on "Check All" followed by "Resolve Multiple" button to resolve multiple 'Delete Request Pending' request of the Client
    When he confirms request by selecting "Deny All" option after verifying 'Delete Request Pending' benefit request details on 'Requests' dialog by Client
    Then 'Action Completed' growl message for "Deny Request" should be displayed on "Transferee Submission Details" page
    And 'Delete Request Pending' Benefit_Cashout request status should be updated to 'Submitted' in 'Transferee Submission Details' list of the Client
    And benefit details should be updated in 'MXClient' application based on "Denied" 'Delete Request' on Transferee Submission
