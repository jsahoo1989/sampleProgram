Feature: Validate the CoreFlex End-To-End Business Test Flow(Policy Setup, MXTransferee, MSPEC) for Both_Transferee_StaticFixedPoints_CashoutNotAuthorized_Delete_Deny selection

@Both-CashNotAuth_DenyRequest_PF @End-To-End-Flow_Both-CashNotAuth_DenyRequest
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'Policy Digitization Tool' application
    Given he has setup a new "Both" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized |
 	When he clicks on "SUBMIT" button on "Custom Bundles" page 
	Then a success dialog should be displayed for Successfully Submitted Policy
	And Policy Status should be displayed as "Submitted" on "View/Edit Policy Forms" page
		
@Both-CashNotAuth_DenyRequest_MX @End-To-End-Flow_Both-CashNotAuth_DenyRequest
Scenario: MXTransferee - Selecting & Submitting benefits available in configured policy and Tracking Available_Used Benefits Points
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" page with below Policy-Benefit type after clicking on 'Manage my Points' button on "Mobility Journey Home" page
      | PolicyType |
      | Both       |
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

@Both-CashNotAuth_DenyRequest_MX @End-To-End-Flow_Both-CashNotAuth_DenyRequest
Scenario: TransfereeSubmissions - Verifying_Approving_Denying submissions made by Transferee for the Client(s) assigned to PPC User 
	Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user 
	And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the transferee  
	And he has clicked on "Review" button for Bundle submitted by the transferee on "Transferee Submissions Dashboard" page	
	And he has navigated to "Transferee Submission Details" page having list of submitted benefits details
	And he has clicked on "Resolve" button for 'Delete Request Pending' request of the Transferee
	When he confirms the "Deny Request" after verifying 'Delete Request Pending' benefit request details and adding comments on 'Requests' dialog
	Then 'Action Completed' growl message for "Deny Request" should be displayed on "Transferee Submission Details" page
	And points should not be updated in 'Points Balance' section for the "Denied" delete request on "Transferee Submission Details" page
	And 'Delete Request Pending' benefit request status should be updated to 'Submitted' in 'Transferee Submission Details' list
	And benefit details should be updated in 'MXTransferee' application based on "Denied" 'Delete Request' on Transferee Submission