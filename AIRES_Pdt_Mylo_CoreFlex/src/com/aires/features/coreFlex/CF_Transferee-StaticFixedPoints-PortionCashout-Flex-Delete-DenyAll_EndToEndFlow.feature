Feature: Validate the CoreFlex End-To-End Business Test Flow(BluePrint, MXTransferee,Transferee Submissions) for Flex_Transferee_StaticFixedPoints_PortionCashout_Delete_DenyAll selection

@End-To_End_CoreFlex @Flex-PortionCashout_DenyAllRequest_PF @Flex-PortionCashout_DenyAllRequest_End_To_End
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'Policy Digitization Tool' application
    Given he has submitted a new "Flex" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized |
    And he has clicked on "Approve Policy" button on "Custom Bundles" page
    And he has selected "Associate this policy with a NEW authorization in IRIS? " option and default 'Effective from booking date' on 'Approval this Policy' dialog
    When he clicks on "Approve" button to acknowledged 'Approve this Policy' dialog 
    Then Policy Status should be displayed as "Active" on "View/Edit Policy Forms" page
		
@End-To_End_CoreFlex @Flex-PortionCashout_DenyAllRequest_MX @Flex-PortionCashout_DenyAllRequest_End_To_End
Scenario: MXTransferee - Submitting benefits & Portion Cashout available in configured policy and Tracking Available_Used Benefits Points
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" page with below Policy-Benefit type after clicking on 'Manage my Points' button on "Mobility Journey Home" page
      | PolicyType |
      | Flex       |
    And he has navigated to "My Benefits Bundle" page after selecting required benefits and PortionCashout on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating all the benefit and Cashout details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog
    And he has clicked on "OK - Let Me See My Benefits!" button displayed on 'Success Flex' dialog
    And he has verified submitted points details on 'Mobility Journey Home' and 'Flex Planning Tool' page
    And he has verified submitted benefit details under 'Submitted Benefits' section of 'My Benefits Bundle' page
    When he 'Delete' submitted Benefit_Cashout and confirms 'Remove Benefit Selection' dialog by entering username and clicking on "Yes-request to delete these benefits"   
    Then 'Status' of the deleted benefit_cashout should be displayed as "Delete Request Pending" under 'Submitted Benefits' section of 'My Benefit Bundle' page

@End-To_End_CoreFlex @Flex-PortionCashout_DenyAllRequest_MX @Flex-PortionCashout_DenyAllRequest_End_To_End
Scenario: TransfereeSubmissions - Verifying DenyAll Delete request functionality for submissions made by Transferee for the Client assigned to PPC User 
	Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user 
	And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the transferee  
	And he has clicked on "Review" button for Bundle submitted by the transferee on "Transferee Submissions Dashboard" page	
	And he has navigated to "Transferee Submission Details" page having list of submitted benefits details
	And he has clicked on "Check All" followed by "Resolve Multiple" button to resolve multiple 'Delete Request Pending' request of the Transferee
	When he confirms request by selecting "Deny All" option after verifying 'Delete Request Pending' benefit request details on 'Requests' dialog
	Then 'Action Completed' growl message for "Deny Request" should be displayed on "Transferee Submission Details" page
	And 'Delete Request Pending' benefit request status should be updated to 'Submitted' in 'Transferee Submission Details' list
	And benefit details should be updated in 'MXTransferee' application based on "Denied" 'Delete Request' on Transferee Submission