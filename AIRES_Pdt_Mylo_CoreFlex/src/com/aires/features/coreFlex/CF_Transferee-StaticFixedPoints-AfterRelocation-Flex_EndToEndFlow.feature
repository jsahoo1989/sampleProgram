Feature: Validate the CoreFlex Policy Flow for Flex_Transferee_StaticFixedPoints_AfterRelocationCashout selection

  @PolicySetupFlow @Flex-AfterRelocationOnly_PF
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'Policy Digitization Tool' application
    Given he has submitted a new "Both" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | PolicyRequiredFor |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Cloning           |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledged 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page
    
    
#@FlexPolicy-Transferee-Static-FixedPoints-CashNotAuthorized @NewFeatureFormat 
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
