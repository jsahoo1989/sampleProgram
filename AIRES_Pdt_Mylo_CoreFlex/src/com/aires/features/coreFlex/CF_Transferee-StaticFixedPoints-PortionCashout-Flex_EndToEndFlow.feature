Feature: Validate the CoreFlex Policy Flow for Flex_Transferee_StaticFixedPoints_PortionCashout selection

@PolicySetupFlow @Flex-PortionCashout_123
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'Policy Digitization Tool' application
    Given he has setup a new "Flex" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    |  Portion Cashout       |
 	When he clicks on "SUBMIT" button on "Custom Bundles" page 
	Then a success dialog should be displayed for Successfully Submitted Policy
	And Policy Status should be displayed as "Submitted" on "View/Edit Policy Forms" page
		
@MXTransfereeFlow @Flex-PortionCashout
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

#@Flex-PortionCashout
#Scenario: TransfereeSubmissions - Verifying_Approving_Denying submissions made by Transferee for the Client(s) assigned to PPC User
#	Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user 
#	And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the transferee 
#	When he clicks on "Review" button for Bundle submitted by the transferee on "Transferee Submissions Dashboard" page 
#    Then he should be navigated to "Transferee Submission Details" page having list of benefits submmited in the bundle along with Quantity, Benefits Points, Added Comments, Remaining Points