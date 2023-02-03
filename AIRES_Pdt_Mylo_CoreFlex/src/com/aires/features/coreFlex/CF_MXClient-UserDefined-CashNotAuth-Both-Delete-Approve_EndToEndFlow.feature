Feature: Validate the CoreFlex End-To-End Business Test Flow(BluePrint, MXClient, Transferee Submissions) for Both_MXClient_UserDefined_CashoutNotAuthorized_Delete_ApproveAll selection

  @End-To-End_CoreFlex @CF_MXClient_UserDefined_CashNotAuth_Delete_Approve @CF_MXClient_UserDefined_CashNotAuth_Delete_Approve_PF
  Scenario: CoreFlex - Creating & Validating a new Active Points Based CoreFlex Policy with MXClient, UserDefined and CashNotAuth selection
    Given he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor |
      | Client Initiator                         | User Defined    | Cashout Not Authorized | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_MXClient_UserDefined_CashNotAuth_Delete_Approve @CF_MXClient_UserDefined_CashNotAuth_Delete_Approve_CF
  Scenario: MXClient - Verifying Authorization Submission with UserDefined TotalPoints & Core/Flex Benefits for configured ClientInitiator BluePrint Policy
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has verified 'Total Points' section displayed on 'Authorization Form' for "User Defined" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy
    And he has verified 'FleX Benefits' section displayed on 'Authorization Form' for "Client Initiator" - 'Person Responsible' selection in BluePrint CoreFlex Policy
    And he has verified 'Error Growl Message' and 'Required Field Validation' displayed after clicking on "Submit to Aires" button with Blank/No 'Total Points' value
    And he has navigated to "Benefit Selection Tool" page after entering valid 'Total Points' value and clicking on "Start Benefit Selection" button
    And he has verified following details on "Benefit Selection Tool" page based on configured Points Based CoreFlex BluePrint Policy
      | Available Point Balance | Core Benefits | Flex Benefits | Suggested Bundles | Cashout |
    And he has clicked on 'Back to initiation' link on 'Benefit Selection Tool' to navigate to 'Authorization Form' page
    And he has clicked on 'Start Benefit Selection' after decreasing 'Benfit Total Points' value on 'Auth Form Template' page
    And he has verified following details on "Benefit Selesction Tool" page based on configured Points Based CoreFlex BluePrint Policy
      | Available Point Balance | Core Benefits | Flex Benefits | Suggested Bundles | Cashout |
    And he has clicked on 'Back to benefits list' link to navigate to 'Benefit Selection Tool' page
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected Flex Benefit details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' details displayed on the navigated 'Authorization Form' page
    When he clicks on "Submit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    Then 'Auth Submit Success' growl message should be displayed on the navigated 'MobilityX Dashboard Home' page
    And 'New Initiation Submitted' email should be received having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits Points

  @End-To-End_CoreFlex @CF_MXClient_UserDefined_CashNotAuth_Delete_Approve
  Scenario: MXClient - Verifying Submitted Deleted request Core/Flex Benefits Status on MXClient Submitted Benefits
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has actualized the Transferee after selecting required 'MSPEC_PPC' user and setting file status as 'Active' in IRIS application
    And he has clicked on "View all initiations" link on 'Authorization Home Page' to navigate to 'View all initiation' page
    And he has clicked 'Transferee Name' from 'All Initiations' List on 'View all initiation' page
    And he has navigated to 'Benefit Selection Tool' page after clicking on 'Manage Benefit Selection' button
    And he has verified following details on 'Benefit Selection Tool' page post Authorization form submission
      | Available Point Balance | Edit Submitted Benefits | Cashout |
    And he has clicked on 'Edit Submitted Benefits' button to navigate to 'Benefits Bundle' page
    And he has verified submitted 'Core_Flex Benefit' details displayed under 'Submitted Benefits' section of 'Benefits Bundle' page
    And he has 'Deleted' submitted Benefit on Benefits Bundle page and confirmed 'Remove Benefit Selection' dialog by entering username and clicking on "Yes-request to delete this benefit"
    And he has verified 'Status' of the deleted benefit displayed as "Delete Request Pending" under 'Submitted Benefits' section of 'Benefits Bundle' page
    And he has clicked on 'Back to initiation' link on 'Benefit Selection Tool' to navigate to 'Authorization Form' page
    When he clicks on "Resubmit to Aires" button from right floating menu of 'Authorization Form' page
    Then 'Auth Submit Success' growl message should be displayed on the navigated 'Advanced Authorization Search' page
    And 'Revised Mobility Initiation' email having submitted_deleted Benefit and Points details should be received

  @End-To_End_CoreFlex @CF_MXClient_UserDefined_CashNotAuth_Delete_Approve
  Scenario: TransfereeSubmissions - Verifying UserDefined Points, BenefitSubmissions and Delete Request ApprovalAll transaction for the request made by the Client
    Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user
    And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the Client
    And he has clicked on "Review" button for Bundle submitted by the Client on "Transferee Submissions Dashboard" page
    And he has navigated to "Transferee Submission Details" page having list of submitted benefits details by Client
    And he has clicked on "Check All" followed by "Resolve Multiple" button to resolve multiple 'Delete Request Pending' request of the Client
    When he confirms request by selecting "Approve All" option after verifying 'Delete Request Pending' benefit request details on 'Requests' dialog
    Then 'Action Completed' growl message for "Approve Request" should be displayed on "Transferee Submission Details" page
    And 'Delete Request Pending' benefit request should be removed from 'Transferee Submission Details' list
    And benefit details should be updated in 'MXClient' application based on "Approved" 'Delete Request' on Transferee Submission