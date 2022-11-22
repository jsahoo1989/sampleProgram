Feature: Validate MXTransferee Workflow and MJ Cards(Submitted,StartingSoon,InProgress,Complete Status) for Transferee-CashoutNotAuthorized selection, Versioning & CloningToSameClient, Transferee Mobility Journey and Transferee Submissions DenyAll Operation

  @Coreflex:218310 @CF_End-To-End_MasterScript @CF_Master_CashNotAuthDeny @CF_Master_CashNotAuthDeny_PolicySetup
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Approval WorkFlow for Transferee-CashoutNotAuthorized MasterScript Policy Setup
    Given he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @Coreflex:218322 @CF_End-To-End_MasterScript @CF_Master_CashNotAuthDeny @CF_Master_CashNotAuthDeny_MXPolicyVerification
  Scenario: MXTransferee - Validating Policy Benefit_Points Details in MXTransferee application after associating Transferee with the Active BluePrint Version1 Policy
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    When he navigates to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    Then benefits selected on Active BluePrint "Version1" Policy should be displayed on "FleX Planning Tool" page
    And custom bundle created in Active BluePrint "Version1" Policy should be displayed on "Suggested Bundles" page

  @Coreflex:218323 @CF_End-To-End_MasterScript @CF_Master_CashNotAuthDeny @CF_Master_CashNotAuthDeny_CreatingNewVersion
  Scenario: CoreFlex - Validating Assignment History & Status_Version of New Policy version created from ‘Active’ points based CoreFlex policy that has one or more assignments/files
    Given he has searched for "Active" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has verified following 'Assignment Details' after clicking on "Assignment History" icon of the searched "Active" points based CoreFlex policy
      | Assignment ID | Transferee Name | Assignment Status | Booked Date | Origin Country | Destination Country | MSPEC Name | PPC Name |
    And he has searched for "Active" points based CoreFlex policy on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Active" points based CoreFlex policy
    And he has entered 'Description' after verifying 'Version Control' popup screen contents
    When he clicks on "CREATE" button on 'Version Control' popup screen
    Then user should be navigated to "General Information" page of 'New Version' policy in 'Editable' mode having Policy Status displayed as "Draft"
    And 'Points Based Flex Policy' field should be disabled with default value as "Yes"

  @Coreflex:218324 @CF_End-To-End_MasterScript @CF_Master_CashNotAuthDeny @CF_Master_CashNotAuthDeny_BluePrintNewVersionPolicyBenefitSelection
  Scenario: CoreFlex - Validating selected Benefits & Custom Bundles of New Policy version created from ‘Active’ points based CoreFlex policy that has one or more assignments/files
    Given he has searched for "Active" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has verified 'Enabled/Disabled' status of searched 'Points Based CoreFlex Policy' Icons - "Post" Versioning on "View/Edit Policy Forms" page
      | PolicyVersion | PolicyStatus | EditIcon | DeleteIcon | CloneIcon | AssignmentHistoryIcon |
      | V1            | Active       | Disabled | Disabled   | Enabled   | Enabled               |
      | V2            | Draft        | Enabled  | Enabled    | Disabled  | Disabled              |
    And he has clicked on "Edit" icon of "V2" - "Draft" version of the searched points based CoreFlex policy
    And he has navigated to "General Information" page of 'New Version' policy in 'Editable' mode having CoreFlex Policy Status displayed as "Draft"
    And he has verified 'Policy-Benefits-SubBenefits' details of "V2" - "Draft" version Policy matches with "V1" policy selections
    And he has verified 'CustomBundles' and 'Transferee Preview' details of "V2" - "Draft" version Policy matches with "V1" - "Active" version Policy
    And he has acknowledged 'Submit Success' dialog after clicking on "Submit" button on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V2" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V2" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V2" respectively on "View/Edit Policy Forms" page
    And Policy Status of Version "V1" policy should be displayed as "Legacy" on "View/Edit Policy Forms" page

  @Coreflex:218325 @CF_End-To-End_MasterScript @CF_Master_CashNotAuthDeny @CF_Master_CashNotAuthDeny_CloningToSameClientPolicy
  Scenario Outline: CoreFlex - Validating Cloned Policy contents for same Client reference selection and Policy with Submit/Active/Legacy status
    Given he has logged into 'BluePrint' application as 'CSM - SSO' user
    And he has clicked on 'Clone Policy' icon after searching for 'Points Based CoreFlex Policy' with Policy Status as "<PolicyStatus>"
    And he has verified following 'Clone Policy' dialog values after clicking on 'Clone Policy' icon for Enabled Clone Icon "<PolicyStatus>"
      | Reference Policy | Reference Client | Clone to: Client | Clone to: Policy |
    And he has selected a "Existing" client value in 'Clone to: Client' dropdown along with a new policy in 'Clone to: Policy' dropdown
    When he clicks on "SAVE AS DRAFT" button
    Then he should be navigated to "General Information" page of new 'Cloned - Points based CoreFlex Policy' saved as "Draft" with Policy Version as "V1"
    And all the 'CoreFlex' benefits from the reference 'Points Based CoreFlex policy' should be copied over to the 'Cloned - Points based CoreFlex Policy'

    Examples: 
      | PolicyStatus |
      | Legacy       |

  @Coreflex:218326 @CF_End-To-End_MasterScript @CF_Master_CashNotAuthDeny @CF_Master_CashNotAuthDeny_MXTransfereeFlow
  Scenario: MXTransferee - Submitting Flex benefits available in configured policy and Validating Available_Used Benefits Points Post Delete Operation
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
    And he has navigated to "My Benefits Bundle" page after selecting required benefits on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating all the benefit and Cashout details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog
    And he has clicked on "OK - Let Me See My Benefits!" button displayed on 'Success Flex' dialog
    And he has verified submitted points details on 'Mobility Journey Home' and 'Flex Planning Tool' page
    And he has verified submitted benefit details under 'Submitted Benefits' section of 'My Benefits Bundle' page
    When he 'Delete' submitted Benefits and confirms 'Remove Benefit Selection' dialog by entering username and clicking on "Yes-request to delete this benefit"
    Then 'Status' of the deleted benefit should be displayed as "Delete Request Pending" under 'Submitted Benefits' section of 'My Benefit Bundle' page

  @Coreflex:218327 @CF_End-To-End_MasterScript @CF_Master_CashNotAuthDeny @CF_Master_CashNotAuthDeny_MSPEC_PPC_Flow
  Scenario: TransfereeSubmissions - Verifying Benefit_Points Details in TransfereeSubmissions & MobilityX application post Deny All Delete request selection by MSPEC/PPC User
    Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user
    And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the transferee
    And he has clicked on "Review" button for Bundle submitted by the transferee on "Transferee Submissions Dashboard" page
    And he has navigated to "Transferee Submission Details" page having list of submitted benefits details
    And he has clicked on "Check All" followed by "Resolve Multiple" button to resolve multiple 'Delete Request Pending' request of the Transferee
    When he confirms request by selecting "Deny All" option after verifying 'Delete Request Pending' benefit request details on 'Requests' dialog
    Then 'Action Completed' growl message for "Deny Request" should be displayed on "Transferee Submission Details" page
    And 'Delete Request Pending' benefit request status should be updated to 'Submitted' in 'Transferee Submission Details' list
    And benefit details should be updated in 'MXTransferee' application based on "Denied" 'Delete Request' on Transferee Submission

  @Coreflex:218329 @CF_End-To-End_MasterScript @CF_Master_CashNotAuthDeny @CF_Master_CashNotAuthDeny_Shipment_MJCards_MobilityX
  Scenario: MXTransferee - Verifying Flex_Core Cards details and (Submitted,StartingSoon,InProgress,Complete) status of the submitted Aires Managed Benefit
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after selecting 'Aires Managed' benefits on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating all the 'Aires Managed' benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog and validating 'Aires Managed' benefit details
    And he has clicked on "OK - Let Me See My Benefits!" button displayed on 'Success Flex' dialog
    And he has verified submitted Aires Managed Benefits Status - changed to "Submitted" on "My Benefit Bundle" page
    And he has verified 'Aires Managed' benefit cards not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created Service and SubService for 'Aires Managed' benefits in Services tab of IRIS application
    And he has verified submitted Aires Managed Benefits Status - changed to "Starting Soon" on "Mobility Journey Home" page - "Pre Initial Tracing"
    And he has verified submitted Aires Managed Benefits Status - changed to "Starting Soon" on "My Benefit Bundle" page
    And he has provided "Est Date" for added services tracing after clicking on the "Activity & Finance" tab of added Service
    And he has verified submitted Aires Managed Benefits Status - changed to "In Progress" on "Mobility Journey Home" page - "Post Initial Tracing"
    And he has verified submitted Aires Managed Benefits Status - changed to "In Progress" on "My Benefit Bundle" page
    When he provides "Act Date" for added sub-services tracing prompts after clicking on the "Activity & Finance" tab of added Service
    Then submitted Aires Managed Benefits Status - should be changed to "Complete" on "Mobility Journey Home" page - "Post End Tracing"
    And submitted Aires Managed Benefits Status - should be changed to "Complete" on "My Benefit Bundle" page
