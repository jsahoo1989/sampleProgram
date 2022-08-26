Feature: Validate the CoreFlex End-To-End Business Test Flow(BluePrint, MXTransferee,Transferee Submissions) for Both_Transferee_StaticFixedPoints_CashoutNotAuthorized_Delete_Approve selection

  @End-To-End_CoreFlex @CF_MXTransferee_UserDefined_CashNotAuth
  Scenario: CoreFlex - Creating & Validating a new Active Points Based CoreFlex Policy with Transferee, UserDefined and CashNotAuth selection
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | User Defined    | Cashout Not Authorized | Both        | Client            |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_MXTransferee_UserDefined_CashNotAuth @Test998
  Scenario: MXClient - Creating a new Authorization and assigning Total Flex Points for the Points Based CF policy
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
    When he clicks on 'Resubmit to Aires' after updating 'Benfit Total Points' value on 'Auth Form Template' page
    Then following confirmation dialogs should be displayed in sequence on acceptance of displayed dialog
      | You are increasing the Total Points to * point(s). The transferee will see the increased points in MobilityX. Do you want to continue? |
      | It looks like there arent any approvers set up for this initiation. Do you want to submit it without the required approvals?           |
      | Where should your changes be reflected? Note: revisions may incur additional costs to your organization.                               |
    And 'Auth Submit Success' growl message should be displayed on the navigated 'View all initiation' page on confirmation of the last dialog
    And Revised 'New Initiation Submitted' email having updated Transferee and Benefit Points details should be received

  @End-To_End_CoreFlex @CF_MXTransferee_UserDefined_CashNotAuth
  Scenario: MXTransferee - Selecting & Submitting Flex benefits available in configured policy and Tracking Available_Used Benefits Points
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" page after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has verified Benefits details displayed under 'Core Benefits' and 'Flex Benefits' section on "FleX Planning Tool" page
    And he has navigated to "Suggested Bundles" page after clicking on following link on "FleX Planning Tool" page
      | Take a look at some suggested options! |
    And he has verified 'Custom Bundle' Benefit details displayed under 'Recommended Bundle' section on "Suggested Bundles" page
    And he has navigated back to "FleX Planning Tool" page after clicking on 'Back to benefits list' button
    And he has navigated to "My Benefits Bundle" page after selecting required benefits and PortionCashout on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating all the benefit and Cashout details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog
    And he has clicked on "OK - Let Me See My Benefits!" button displayed on 'Success Flex' dialog
    And he has verified submitted points details on 'Mobility Journey Home' and 'Flex Planning Tool' page
    And he has verified submitted benefit details under 'Submitted Benefits' section of 'My Benefits Bundle' page
    When he 'Delete' submitted Benefit_Cashout and confirms 'Remove Benefit Selection' dialog by entering username and clicking on "Yes-request to delete this benefit"
    Then 'Status' of the deleted benefit_cashout should be displayed as "Delete Request Pending" under 'Submitted Benefits' section of 'My Benefit Bundle' page

  @End-To_End_CoreFlex @CF_MXTransferee_UserDefined_CashNotAuth
  Scenario: TransfereeSubmissions - Verifying submissions and Approving the delete request made by Transferee for the Client(s) assigned to PPC User
    Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user
    And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the transferee
    And he has clicked on "Review" button for Bundle submitted by the transferee on "Transferee Submissions Dashboard" page
    And he has navigated to "Transferee Submission Details" page having list of submitted benefits details
    And he has clicked on "Resolve" button for 'Delete Request Pending' request of the Transferee
    When he confirms the "Approve Request" after verifying 'Delete Request Pending' benefit request details and adding comments on 'Requests' dialog
    Then 'Action Completed' growl message for "Approve Request" should be displayed on "Transferee Submission Details" page
    And points should be updated in 'Points Balance' section for the "Approved" delete request on "Transferee Submission Details" page
    And 'Delete Request Pending' benefit request should be removed from 'Transferee Submission Details' list
    And benefit details should be updated in 'MXTransferee' application based on "Approved" 'Delete Request' on Transferee Submission
