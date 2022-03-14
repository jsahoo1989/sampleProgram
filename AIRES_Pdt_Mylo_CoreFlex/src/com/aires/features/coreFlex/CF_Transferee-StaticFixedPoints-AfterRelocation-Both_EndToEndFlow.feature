Feature: Validate the CoreFlex Policy Flow for Both_Transferee_StaticFixedPoints_AfterRelocationCashout selection

@PolicySetupFlow @Both-AfterRelocationOnly_PF
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'Policy Digitization Tool' application
    Given he has setup a new "Both" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availiblity    |
      | Transferee                               | Static/Fixed    | After Relocation Only  |
    When he clicks on "SUBMIT" button on "Custom Bundles" page 
	Then a success dialog should be displayed for Successfuly Submitted Policy
	And Policy Status should be displayed as "Submit" on "View/Edit Policy Forms" page
		
#@FlexPolicy-Transferee-Static-FixedPoints-CashNotAuthorized @Both-AfterRelocationOnly	
#Scenario: IRIS - Creating and Actualizing a new Transferee in IRIS Apllication for Policy Created in 'Policy Digitization Tool' 
#	Given he has Created and Actualized a 'New' Transferee in 'Assignment' module of IRIS Application
#	When he clicks on the "Yes" button of "Send Credentials" dialog having message "Do you want to email ReloNet login credentials to the transferee?" 
#	Then username, password email of newly created 'Assignment' should be sent to the provided email address 
	
#@FlexPolicy-Transferee-Static-FixedPoints-CashNotAuthorized @Both-AfterRelocationOnly
#Scenario: MXTransferee - Selecting & Submitting benefits available in configured policy and Tracking Available/Used Benefits Points
#	Given he has logged into 'MobilityX' application with the newly created 'Transferee' user
##    And he has clicked on "No thanks, I prefer to do this later" link on the 'Welcome' Pop-up displayed on "Mobility Journey Home" page
#    And he has clicked on "Manage My Points" floating button after validating 'Assignment-Policy' details on "Mobility Journey Home" page
#    And he has navigated to "FleX Planning Tool" page with configured Policy-Benefits details
#    And he has clicked on "Next" floating button after selecting following Benefits on "FleX Planning Tool" page
#    And he has navigated to "My Benefits Bundle" page having all the benefits listed down under 'Selected Benefits' section along with Quantity and Total Points in Editable mode
#    And he has clicked on "Review and Submit" button on "My Benefits Bundle" page
#    And he has clicked on "Yes - submit my bundle" after entering 'Transferee' name in 'Type your name to confirm' field and reviewing the selected benefits displayed on "Submit Bundle Confirmation" pop-up page in Non-Editable mode
#    When he has clicks on "OK - Let Me See My Benefits!" button of Submission success pop-up box 
#	Then he should be navigated to "Mobility Journey Home" page having updated Assignment Points details
#
#@FlexPolicy-Transferee-Static-FixedPoints-CashNotAuthorized	@NewFeatureFormat @viniTest232
#Scenario: TransfereeSubmissions - Verifying_Approving_Denying submissions made by Transferee for the Client(s) assigned to PPC User
#	Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user 
#	And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the transferee 
#	When he clicks on "Review" button for Bundle submitted by the transferee on "Transferee Submissions Dashboard" page 
#    Then he should be navigated to "Transferee Submission Details" page having list of benefits submmited in the bundle along with Quantity, Benefits Points, Added Comments, Remaining Points