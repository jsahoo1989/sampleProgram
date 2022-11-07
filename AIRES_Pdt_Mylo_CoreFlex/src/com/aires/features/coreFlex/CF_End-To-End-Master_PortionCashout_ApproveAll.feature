Feature: Validate MXTransferee Workflow and MJ Cards(CancelledStatus) for Transferee-PortionCashout selection, Versioning & CloningToDifferentClient, Transferee Mobility Journey, PortionCashout and Transferee Submissions ApproveAll Operation

  @Coreflex:218336 @CF_End-To-End_MasterScript @CF_Master_PortionApprova1 @CF_Master_PortionApprove_PolicySetup
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Approval WorkFlow for Transferee-PortionCashout MasterScript Policy Setup
    Given he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor |
      | Transferee                               | Static/Fixed    | Portion Cashout      | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @Coreflex:218331 @CF_End-To-End_MasterScript @CF_Master_PortionApprove @CF_Master_PortionApprove_CloningToDifferentClientPolicy
  Scenario Outline: CoreFlex - Validating Cloned Policy contents for different Client reference selection and Policy with Submit/Active/Legacy status
    Given he has logged into 'BluePrint' application as 'CSM - SSO' user
    And he has clicked on 'Clone Policy' icon after searching for 'Points Based CoreFlex Policy' with Policy Status as "<PolicyStatus>"
    And he has verified following 'Clone Policy' dialog values after clicking on 'Clone Policy' icon for Enabled Clone Icon "<PolicyStatus>"
      | Reference Policy | Reference Client | Clone to: Client | Clone to: Policy |
    And he has selected a "Different" client value in 'Clone to: Client' dropdown along with a new policy in 'Clone to: Policy' dropdown
    When he clicks on "SAVE AS DRAFT" button
    Then he should be navigated to "General Information" page of new 'Cloned - Points based CoreFlex Policy' saved as "Draft" with Policy Version as "V1"
    And all the 'CoreFlex' benefits from the reference 'Points Based CoreFlex policy' should be copied over to the 'Cloned - Points based CoreFlex Policy'

    Examples: 
      | PolicyStatus |
      | Active       |

  @Coreflex:218332 @CF_End-To-End_MasterScript @CF_Master_PortionApprove @CF_Master_PortionApprove_MXTransfereeFlow
  Scenario: MXTransferee - Submitting Flex benefits & PortionCahout available in configured policy and Validating Available_Used Benefits Points and Cashout Post Delete Operation
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
    And he has verified 'Portion Cashout' details on "FleX Planning Tool" page
    And he has navigated to "My Benefits Bundle" page after selecting required Benefits and Cashout on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating all the benefit and Cashout details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog
    And he has clicked on "OK - Let Me See My Benefits!" button displayed on 'Success Flex' dialog
    And he has verified submitted points details on 'Mobility Journey Home' and 'Flex Planning Tool' page
    And he has verified submitted benefit details under 'Submitted Benefits' section of 'My Benefits Bundle' page
    When he 'Delete' submitted Benefit_Cashout and confirms 'Remove Benefit Selection' dialog by entering username and clicking on "Yes-request to delete this benefit"
    Then 'Status' of the deleted benefit_cashout should be displayed as "Delete Request Pending" under 'Submitted Benefits' section of 'My Benefit Bundle' page

  @Coreflex:C218333 @CF_End-To-End_MasterScript @CF_Master_PortionApprove @CF_Master_PortionApprove_MSPEC_PPC_Flow
  Scenario: TransfereeSubmissions - Verifying Benefit_Cashout_Points Details in TransfereeSubmissions & MobilityX application post Approve All Delete request selection by MSPEC/PPC User
    Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user
    And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the transferee
    And he has clicked on "Review" button for Bundle submitted by the transferee on "Transferee Submissions Dashboard" page
    And he has navigated to "Transferee Submission Details" page having list of submitted benefits details
    And he has clicked on "Check All" followed by "Resolve Multiple" button to resolve multiple 'Delete Request Pending' request of the Transferee
    When he confirms request by selecting "Approve All" option after verifying 'Delete Request Pending' benefit request details on 'Requests' dialog
    Then 'Action Completed' growl message for "Approve Request" should be displayed on "Transferee Submission Details" page
    And 'Delete Request Pending' benefit request should be removed from 'Transferee Submission Details' list
    And benefit details should be updated in 'MXTransferee' application based on "Approved" 'Delete Request' on Transferee Submission

  @Coreflex:218334 @CF_End-To-End_MasterScript @CF_Master_PortionApprove @CF_Master_PortionApprove_Cards_PF
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'CoreFlex Blueprint Application' with Both type 'Aires Managed' benefits
    Given he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor            |
      | Transferee                               | Static/Fixed    | Portion Cashout      | Both        | Aires Managed Benefits Cards |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @Coreflex:218335 @CF_End-To-End_MasterScript @CF_Master_PortionApprove @MJ_Cards_Cancelled_StatusChecks
  Scenario: MXTransferee - Verifying Flex_Core Cards details and (Cancelled) status of the submitted Aires Managed Benefit
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after validating and selecting 'Aires Managed' benefit on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating 'Aires Managed' benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog to submit 'Aires Managed' benefit
    And he has verified submitted Aires Managed Benefit status updated to "Submitted" on "My Benefit Bundle" page
    And he has verified 'Aires Managed' benefit card not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created Service and SubService for 'Aires Managed' benefits with '2' Milestones of CoreFlex type "Both" in Services tab of IRIS application
    And he has verified submitted Aires Managed Benefit Flex and Core card status updated to "Starting Soon" on "Mobility Journey Home" page - "Pre Initial Tracing"
    And he has verified submitted Aires Managed Benefit status updated to "Starting Soon" on "My Benefit Bundle" page
    When he change status of the 'Aires Managed' benefit SubService to "Cancel" from Services tab of IRIS application
    Then submitted Aires Managed Benefit Flex and Core card status should be updated to "Cancelled" on "Mobility Journey Home" page
    And submitted Aires Managed Benefit status should be updated to "Cancelled" on "My Benefit Bundle" page
