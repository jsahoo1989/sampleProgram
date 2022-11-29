Feature: Validate the CoreFlex End-To-End Business Test Flow(BluePrint, MXClientAndTransferee, Transferee Submissions) for Both_MXClientAndTransferee_StaticFixed_CashoutNotAuthorized_Delete_DenyAll selection

  @Coreflex:218407 @CF_End-To-End_MasterScript @CF_Master_ClientAndTransferee_CashNotAuth_Deny @CF_Master_ClientAndTransferee_CashNotAuth_Deny_PS
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Approval WorkFlow for ClientAndTransferee-CashoutNotAuthorized MasterScript Policy Setup
    Given he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor |
      | Client and Transferee                    | Static/Fixed    | Cashout Not Authorized | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @Coreflex:218408 @CF_End-To-End_MasterScript @CF_Master_ClientAndTransferee_CashNotAuth_Deny @CF_Master_ClientAndTransferee_CashNotAuth_Deny_CF
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
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected Flex Benefit details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' details displayed on the navigated 'Authorization Form' page
    When he clicks on "Submit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    Then 'Auth Submit Success' growl message should be displayed on the navigated 'MobilityX Dashboard Home' page
    And 'New Initiation Submitted' email should be received having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits Points

  @Coreflex:218409 @CF_End-To-End_MasterScript @CF_Master_ClientAndTransferee_CashNotAuth_Deny @CF_Master_ClientAndTransferee_CashNotAuth_Deny_TF
  Scenario: MXTransferee - Validating Selection & Submission of Flex benefits available in Client configured policy and Tracking Available_Used Benefits Points
    Given he has logged into 'MobilityX' application after actualizing a new 'Transferee' through IRIS application and setting-up user profile in 'MobilityX' application
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" page after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has clicked on 'Next' floating button after verifying Benefits_Points details Submitted by Client on 'Flex Planning Tool' page
    And he has verified Benefits Submitted by Client details under 'Submitted Benefits' section of 'My Benefits Bundle' page
    When he 'Delete' submitted Benefits and confirms 'Remove Benefit Selection' dialog by entering username and clicking on "Yes-request to delete this benefit"
    Then 'Status' of the deleted benefit should be displayed as "Delete Request Pending" under 'Submitted Benefits' section of 'My Benefit Bundle' page

  @Coreflex:218410 @CF_End-To-End_MasterScript @CF_Master_ClientAndTransferee_CashNotAuth_Deny @CF_Master_ClientAndTransferee_CashNotAuth_Deny_TS
  Scenario: TransfereeSubmissions - Verifying StaticFixed Points, BenefitSubmissions and Delete Request Deny transaction for the request made by the Transferee
    Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user
    And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the transferee
    And he has clicked on "Review" button for Bundle submitted by the transferee on "Transferee Submissions Dashboard" page
    And he has navigated to "Transferee Submission Details" page having list of submitted benefits details
    And he has clicked on "Check All" followed by "Resolve Multiple" button to resolve multiple 'Delete Request Pending' request of the Transferee
    When he confirms request by selecting "Deny All" option after verifying 'Delete Request Pending' benefit request details on 'Requests' dialog
    Then 'Action Completed' growl message for "Deny Request" should be displayed on "Transferee Submission Details" page
    And 'Delete Request Pending' benefit request status should be updated to 'Submitted' in 'Transferee Submission Details' list
    And benefit details should be updated in 'MXTransferee' application based on "Denied" 'Delete Request' on Transferee Submission
