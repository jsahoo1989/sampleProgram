Feature: Validate Impersonation & Delegate User functionality for Core/Flex benefits and Cashout Submission

  @Coreflex:218413 @CF_End-To-End_MasterScript @CF_ImpersonationDelegation @CF_ImpersonationDelegation_PolicySetup
  Scenario: CoreFlex - Creating a new Active Points Based CoreFlex Policy with Transferee selection for Impersonation & Delegate User Verification
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

  @Coreflex:218414 @CF_End-To-End_MasterScript @CF_ImpersonationDelegation @CF_Impersonation_MX
  Scenario: MXTransferee - Verifying submission of Core/Flex Benefits by Transferee Impersonated by Client User
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has logged into 'MobilityX' application as a 'Client' user
    And he has impersonated the user with below details from MobilityX dashboard
      | Client                    | User Type  |
      | Boston Scientific (13951) | Transferee |
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
    And he has verified 'Benefit Submission Email' for Impersonated Transferee by Client after clicking on "OK - Let Me See My Benefits!" button displayed on 'Success Flex' dialog
    And he has verified submitted points details on 'Mobility Journey Home' and 'Flex Planning Tool' page
    And he has verified submitted benefit details under 'Submitted Benefits' section of 'My Benefits Bundle' page
    When he 'Delete' submitted Benefits and confirms 'Remove Benefit Selection' dialog by entering username and clicking on "Yes-request to delete this benefit"
    Then 'Status' of the deleted benefit should be displayed as "Delete Request Pending" under 'Submitted Benefits' section of 'My Benefit Bundle' page

  @Coreflex:218415 @CF_End-To-End_MasterScript @CF_ImpersonationDelegation @CF_Impersonation_TS
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

  @Client_Transferee_Impersonate_Delegate_flow
  Scenario: MXTransferee - Delegate access flow
    Given he has logged into 'MobilityX' application with the 'Transferee' user
    And he has delegated flex benefit access to a different user
    When he logged into MobilityX application as delegated user
    Then he should be able to access selected flex benefit details of the transferee
    
    
    @Coreflex: @CF_End-To-End_MasterScript @CF_ImpersonationDelegation @CF_Delegation_MX
    Scenario: MXTransferee - Verifying submission of Core/Flex Benefits by Delegated Transferee User
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has provided 'Access to my Flex Benefits' delegate access to the newly created DelegateUser on 'Delegate Information' page  
