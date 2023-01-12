Feature: Validate the CoreFlex End-To-End Business Test Flow(BluePrint,MXClient,MXTransferee,Transferee Submissions) for Both_Transferee_UserDefined_AfterRelocation_Delete_DenyAll selection

  @Coreflex:218380 @CF_End-To-End_MasterScript @CF_Master_MXTransferee_UserDefined_AfterRelocation @CF_MXTransferee_UserDefined_AfterRelocation_PF
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Approval WorkFlow for Transferee-UserDefined-AfterRelocation MasterScript Policy Setup
    Given he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability  | BenefitType | PolicyRequiredFor |
      | Transferee                               | User Defined    | After Relocation Only | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @Coreflex:218381 @CF_End-To-End_MasterScript @CF_Master_MXTransferee_UserDefined_AfterRelocation @CF_MXTransferee_UserDefined_AfterRelocation_CF
  Scenario: MXClient - Validating Creation & Configuration of new Authorization with the Points Based CF policy and assigning Total Flex Points for UserDefined Policy Selection
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has verified 'Total Points' section displayed on 'Authorization Form' for "User Defined" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy
    And he has verified 'FleX Benefits' section not displayed on 'Authorization Form' for "Transferee" - 'Person Responsible' selection in BluePrint CoreFlex Policy
    And he has verified 'Error Growl Message' and 'Required Field Validation' displayed after clicking on "Submit to Aires" button with Blank/No 'Total Points' value
    And he has clicked on 'Submit to Aires' button from right floating menu of 'Authorization Form' after entering valid 'Total Points' value
    And he has clicked on "SUBMIT" button on the 'Do you want to submit it without the required approvals?' dialog
    And he has verified 'Auth Submit Success' growl message displayed on the navigated 'MobilityX Dashboard Home' page
    And he has verified 'New Initiation Submitted' email having Transferee details along with assigned CoreFlex Total Points
    And he has clicked on "View all initiations" link on 'Authorization Home Page' to navigate to 'View all initiation' page
    And he has clicked 'Transferee Name' from 'All Initiations' List on 'View all initiation' page
    And he has clicked on 'Resubmit to Aires' after decreasing 'Benfit Total Points' value on 'Auth Form Template' page
    And he has verified 'You cannot decrease the Total Points after submission of benefits.' dialog displayed on 'Auth Form Template' page
    When he clicks on 'Resubmit to Aires' after increasing 'Benfit Total Points' value on 'Auth Form Template' page
    Then following confirmation dialogs should be displayed after increasing 'Benfit Total Points' value in sequence on acceptance of current dialog
      | You are increasing the Total Points to * point(s). The employee will see the increased points in MobilityX. Do you want to continue? |
      | It looks like there arent any approvers set up for this initiation. Do you want to submit it without the required approvals?         |
      | Where should your changes be reflected? Note: revisions may incur additional costs to your organization.                             |
    And 'Auth Submit Success' growl message should be displayed on the navigated 'View all initiation' page on confirmation of the last dialog
    And Revised 'New Initiation Submitted' email having updated Transferee and Benefit Points details should be received

  @Coreflex:218382 @CF_End-To-End_MasterScript @CF_Master_MXTransferee_UserDefined_AfterRelocation @CF_MXTransferee_UserDefined_AfterRelocation_TF
  Scenario: MXTransferee - Verifying AfterRelocation Cashout selection, Flex benefits, Available_Used Benefits Points & Cashout Post Delete Operation
    Given he has logged into 'MobilityX' application after actualizing a new 'Transferee' through IRIS application and setting-up user profile in 'MobilityX' application
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "OnPoint Planning Tool" page after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has verified Benefits details displayed under 'Core Benefits' and 'Flex Benefits' section on "OnPoint Planning Tool" page
    And he has verified Cashout details displayed on 'OnPoint Planning Tool' page before actualizing Assignment_Transfer 'Tracing' in IRIS application
    And he has navigated to "Suggested Bundles" page after clicking on following link on "OnPoint Planning Tool" page
      | Take a look at some suggested options! |
    And he has verified 'Custom Bundle' Benefit details displayed under 'Recommended Bundle' section on "Suggested Bundles" page
    And he has navigated back to "OnPoint Planning Tool" page after clicking on 'Back to benefits list' button
    And he has verified Cashout details after actualizing following 'Tracing' in IRIS for 'After Relocation only - Tracing Set' selection in Blueprint application
      | Tracing Set | Tracing                             |
      | Assignment  | Assignment start date               |
      | Transfer    | Transfer/Start Date in New Location |
    And he has navigated to "My Benefits Bundle" page after selecting required Benefits and Cashout on "OnPoint Planning Tool" page
    And he has clicked on "Review and Submit" button after validating all the benefit and Cashout details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog
    And he has clicked on "OK - Let Me See My Benefits!" button displayed on 'Success Flex' dialog
    And he has verified 'Mobility Benefits Submission' email generated upon OnPoint Benefits Submission
    And he has verified submitted points details on 'Mobility Journey Home' and 'OnPoint Planning Tool' page
    And he has verified submitted benefit details under 'Submitted Benefits' section of 'My Benefits Bundle' page
    When he 'Delete' submitted Benefit_Cashout and confirms 'Remove Benefit Selection' dialog by entering username and clicking on "Yes-request to delete this benefit"
    Then 'Status' of the deleted benefit_cashout should be displayed as "Delete Request Pending" under 'Submitted Benefits' section of 'My Benefit Bundle' page

  @Coreflex:218383 @CF_End-To-End_MasterScript @CF_Master_MXTransferee_UserDefined_AfterRelocation @CF_MXTransferee_UserDefined_AfterRelocation_SF
  Scenario: TransfereeSubmissions - Verifying Benefit_Cashout_Points Details in TransfereeSubmissions & MobilityX application post Deny All Delete request selection by MSPEC/PPC User for Transferee-UserDefined-AfterRelocation MasterScript Policy Setup
    Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user
    And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the transferee
    And he has clicked on "Review" button for Bundle submitted by the transferee on "Transferee Submissions Dashboard" page
    And he has navigated to "Transferee Submission Details" page having list of submitted benefits details
    And he has clicked on "Check All" followed by "Resolve Multiple" button to resolve multiple 'Delete Request Pending' request of the Transferee
    When he confirms request by selecting "Deny All" option after verifying 'Delete Request Pending' benefit request details on 'Requests' dialog
    Then 'Action Completed' growl message for "Deny Request" should be displayed on "Transferee Submission Details" page
    And "Delete Request Denied" email should be sent to Transferee for benefit "Deny Request" action by "MSPEC/PPC" user
    And 'Delete Request Pending' benefit request status should be updated to 'Submitted' in 'Transferee Submission Details' list
    And benefit details should be updated in 'MXTransferee' application based on "Denied" 'Delete Request' on Transferee Submission
