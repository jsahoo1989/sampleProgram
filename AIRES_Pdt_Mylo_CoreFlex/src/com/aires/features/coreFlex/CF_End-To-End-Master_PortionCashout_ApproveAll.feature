Feature: Validate End-to-End Business workflow of BluePrint CF Transferee-PortionCashout Policy Setup with Versioning & Cloning, Transferee Mobility Journey and Transferee Submissions ApproveAll operation

  @CF_End-To-End_MasterScript @CF_Master_PortionApprove1 @CF_Master_PortionApprove_PolicySetup
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Policy Setup Approval WorkFlow
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | Static/Fixed    | Portion Cashout      | Both        | All Benefits      |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @CF_End-To-End_MasterScript @CF_Master_PortionApprove @CF_Master_PortionApprove_MXPolicyVerification
  Scenario: MXTransferee - Validating association of Transferee with the Active BluePrint Version1 Policy
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    When he navigates to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    Then benefits selected on Active BluePrint "Version1" Policy should be displayed on "FleX Planning Tool" page
    And custom bundle created in Active BluePrint "Version1" Policy should be displayed on "Suggested Bundles" page

  @CF_End-To-End_MasterScript @CF_Master_PortionApprove @CF_Master_PortionApprove_CreatingNewVersion
  Scenario: CoreFlex - Validating Status & Version of New Policy version created from �Active� points based CoreFlex policy that has one or more assignments/files
    Given he has searched for "Active" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has verified following 'Assignment Details' after clicking on "Assignment History" icon of the searched "Active" points based CoreFlex policy
      | Assignment ID | Transferee Name | Assignment Status | Booked Date | Origin Country | Destination Country | MSPEC Name | PPC Name |
    And he has clicked on "Edit" icon of the searched "Active" points based CoreFlex policy
    And he has entered 'Description' after verifying 'Version Control' popup screen contents
    When he clicks on "CREATE" button on 'Version Control' popup screen
    Then user should be navigated to "General Information" page of 'New Version' policy in 'Editable' mode having Policy Status displayed as "Draft"
    And 'Points Based Flex Policy' field should be disabled with default value as "Yes"

  @CF_End-To-End_MasterScript @CF_Master_PortionApprove @CF_Master_PortionApprove_BluePrintNewVersionPolicyBenefitSelection
  Scenario: CoreFlex - Validating selected Benefits & Custom Bundles of New Policy version created from �Active� points based CoreFlex policy that has one or more assignments/files
    Given he has searched for "Active" points based CoreFlex policy that has one or more assignments/files on "View/Edit Policy Forms" page
    And he has verified 'Enabled/Disabled' status of searched 'Points Based CoreFlex Policy' Icons - "Post" Versioning on "View/Edit Policy Forms" page
      | PolicyVersion | PolicyStatus | EditIcon | DeleteIcon | CloneIcon | AssignmentHistoryIcon |
      | V1            | Active       | Disabled | Disabled   | Enabled   | Enabled               |
      | V2            | Draft        | Enabled  | Enabled    | Disabled  | Disabled              |
    And he has clicked on "Edit" icon of "V2" - "Draft" version of the searched points based CoreFlex policy
    And he has navigated to "General Information" page of 'New Version' policy in 'Editable' mode having CoreFlex Policy Status displayed as "Draft"
    And he has verified 'Policy-Benefits-SubBenefits' details of "V2" - "Draft" version Policy matches with following "V1" policy selections
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | Static/Fixed    | Portion Cashout      | Both        | All Benefits      |          0 |
    And he has verified 'CustomBundles' and 'Transferee Preview' details of "V2" - "Draft" version Policy matches with "V1" - "Active" version Policy
    And he has acknowledged 'Submit Success' dialog after clicking on "Submit" button on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V2" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V2" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V2" respectively on "View/Edit Policy Forms" page
    And Policy Status of Version "V1" policy should be displayed as "Legacy" on "View/Edit Policy Forms" page

  @CF_End-To-End_MasterScript @CF_Master_PortionApprove @CF_Master_PortionApprove_CloningToDifferentClientPolicy
  Scenario Outline: CoreFlex - Validating Cloned Policy contents for different Client reference selection and Policy with Submit/Active/Legacy status
    Given he has logged into 'BluePrint' application as 'CSM - SSO' user
    And he has clicked on 'Clone Policy' icon after searching for 'Points Based CoreFlex Policy' with Policy Status as "<PolicyStatus>"
    And he has verified following 'Clone Policy' dialog values after clicking on 'Clone Policy' icon for Enabled Clone Icon "<PolicyStatus>"
      | Reference Policy | Reference Client | Clone to: Client | Clone to: Policy |
    And he has selected a "Different" client value in 'Clone to: Client' dropdown along with a new policy in 'Clone to: Policy' dropdown
    When he clicks on "SAVE AS DRAFT" button
    Then he should be navigated to "General Information" page of new 'Cloned - Points based CoreFlex Policy' saved as "Draft" with Policy Version as "V1"
    And all the 'CoreFlex' benefits from the reference 'Points Based CoreFlex policy' should be copied over to the 'Cloned - Points based CoreFlex Policy'
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | Static/Fixed    | Portion Cashout      | Both        | All Benefits      |          0 |

    Examples: 
      | PolicyStatus |
      | Active       |

  @CF_End-To-End_MasterScript @CF_Master_PortionApprove @CF_Master_PortionApprove_MXTransfereeFlow
  Scenario: MXTransferee - Submitting Flex benefits & Portion Cashout available in configured policy and Tracking Available_Used Benefits Points
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

  @CF_End-To-End_MasterScript @CF_Master_PortionApprove @CF_Master_PortionApprove_MSPEC_PPC_Flow
  Scenario: TransfereeSubmissions - Verifying ApproveAll Delete request for submissions made by Transferee for the Client assigned to PPC User
    Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user
    And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the transferee
    And he has clicked on "Review" button for Bundle submitted by the transferee on "Transferee Submissions Dashboard" page
    And he has navigated to "Transferee Submission Details" page having list of submitted benefits details
    And he has clicked on "Check All" followed by "Resolve Multiple" button to resolve multiple 'Delete Request Pending' request of the Transferee
    When he confirms request by selecting "Approve All" option after verifying 'Delete Request Pending' benefit request details on 'Requests' dialog
    Then 'Action Completed' growl message for "Approve Request" should be displayed on "Transferee Submission Details" page
    And 'Delete Request Pending' benefit request should be removed from 'Transferee Submission Details' list
    And benefit details should be updated in 'MXTransferee' application based on "Approved" 'Delete Request' on Transferee Submission

  @CF_End-To-End_MasterScript @CF_Master_PortionApprove @CF_Master_PortionApprove_TwoMilestones_MJCards
  Scenario: MXTransferee - Verifying Flex_Core Cards details and (Submitted,StartingSoon,InProgress,Complete) status of 2 Milestones Aires Managed Benefit
    Given he has logged into 'MobilityX' application with the 'Transferee' user
    And he has navigated to 'My Benefit Bundle' page from 'Mobility Journey Home' page
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - changed to "Submitted" on "My Benefit Bundle" page
    And he has verified 'Aires Managed' benefits with '2' Milestones card not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created Service and SubService for 'Aires Managed' benefits with '2' Milestones of CoreFlex type "Both" in Services tab of IRIS application
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - changed to "Starting Soon" on "Mobility Journey Home" page - "Pre Initial Tracing"
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - changed to "Starting Soon" on "My Benefit Bundle" page
    And he has provided "Est Date" for added '2' services tracing prompt after clicking on the "Activity & Finance" tab of added Service
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - changed to "In Progress" on "Mobility Journey Home" page - "Post Initial Tracing"
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - changed to "In Progress" on "My Benefit Bundle" page
    When he provides "Act Date" for added '2' sub-services tracing prompts after clicking on the "Activity & Finance" tab of added Service
    Then submitted Aires Managed Benefits with '2' Milestones Status - should be changed to "Complete" on "Mobility Journey Home" page - "Post End Tracing"
    And submitted Aires Managed Benefits with '2' Milestones Status - should be changed to "Complete" on "My Benefit Bundle" page

  @CF_End-To-End_MasterScript @CF_Master_PortionApprove @CF_Master_PortionApprove_FourMilestones_MJCards
  Scenario: MXTransferee - Verifying Flex_Core Cards details and (Submitted,StartingSoon,InProgress,Complete) status of 4 Milestones Aires Managed Benefit
    Given he has logged into 'MobilityX' application with the 'Transferee' user
    And he has navigated to 'My Benefit Bundle' page from 'Mobility Journey Home' page
    And he has verified submitted Aires Managed Benefits with '4' Milestones Status - changed to "Submitted" on "My Benefit Bundle" page
    And he has created Service and SubService for 'Aires Managed' benefits with '4' Milestones of CoreFlex type "Both" in Services tab of IRIS application
    And he has verified submitted Aires Managed Benefits with '4' Milestones Status - changed to "Starting Soon" on "Mobility Journey Home" page - "Pre Initial Tracing"
    And he has verified submitted Aires Managed Benefits with '4' Milestones Status - changed to "Starting Soon" on "My Benefit Bundle" page
    And he has provided "Act Date" for added '4' services tracing prompt after clicking on the "Activity & Finance" tab of added Service
    And he has verified submitted Aires Managed Benefits with '4' Milestones Status - changed to "In Progress" on "Mobility Journey Home" page - "Post Initial Tracing"
    And he has verified submitted Aires Managed Benefits with '4' Milestones Status - changed to "In Progress" on "My Benefit Bundle" page
    When he provides "Act Date" for added '4' sub-services tracing prompts after clicking on the "Activity & Finance" tab of added Service
    Then submitted Aires Managed Benefits with '4' Milestones Status - should be changed to "Complete" on "Mobility Journey Home" page - "Post End Tracing"
    And submitted Aires Managed Benefits with '4' Milestones Status - should be changed to "Complete" on "My Benefit Bundle" page