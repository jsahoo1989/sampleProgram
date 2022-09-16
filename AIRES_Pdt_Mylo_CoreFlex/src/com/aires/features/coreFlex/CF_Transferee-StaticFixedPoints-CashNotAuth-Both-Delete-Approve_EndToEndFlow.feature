Feature: Validate the CoreFlex End-To-End Business Test Flow(BluePrint, MXTransferee,Transferee Submissions) for Both_Transferee_StaticFixedPoints_CashoutNotAuthorized_Delete_Approve selection

  @End-To-End_CoreFlex @CF_MXTransferee_StaticFixed_CashNotAuth_DeleteApprove
  Scenario: CoreFlex - Creating & Validating a new Active Points Based CoreFlex Policy with Transferee, Static/Fixed and CashNotAuth selection
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Both        | Client            |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_MXTransferee_StaticFixed_CashNotAuth_DeleteApprove
  Scenario: MXTransferee - Selecting & Submitting Flex benefits available in configured policy and Tracking Available_Used Benefits Points
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" page after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after selecting required benefits on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating all the benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog
    And he has clicked on "OK - Let Me See My Benefits!" button displayed on 'Success Flex' dialog
    And he has verified submitted points details on 'Mobility Journey Home' and 'Flex Planning Tool' page
    And he has verified submitted benefit details under 'Submitted Benefits' section of 'My Benefits Bundle' page
    And he has clicked on "Delete" button for a benefit under 'Submitted Benefits' section
    When he confirms 'Remove Benefit Selection' dialog by entering username and clicking on "Yes-request to delete these benefits"
    Then 'Delete Request Sent' growl message should be displayed on 'My Benefit Bundle' page
    And 'Status' of the deleted benefit should be displayed as "Delete Request Pending" under 'Submitted Benefits' section of 'My Benefit Bundle' page

  @End-To-End_CoreFlex @CF_MXTransferee_StaticFixed_CashNotAuth_DeleteApprove
  Scenario: TransfereeSubmissions - Verifying StaticFixed Points, BenefitSubmissions and Delete Request Approve transaction for the request made by the Transferee
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
