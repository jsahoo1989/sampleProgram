Feature: Approve Policy to create new version
  Validate the functionality of Approve Policy with Versioning feature
  
 Background: Login to  Policy Digitization Tool (PDT) application
    Given he is logged into 'Aires Policy Tool' application as a "Client Service Manager" user
    
    @Sprint-29 @PDT-Regression @visible
   Scenario: PDT - Validate 'Approve Policy' button is displayed as visible after submission of a policy from 'Policy benefit' page
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Home Leave" as Benefit Category on "Policy Benefit" page
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    When he clicks on the 'OK' button of success message "Policy saved and submitted" displayed on the "Policy Benefit" page
    Then "Approve Policy" button should become visible on the 'Policy Benefit' page
    And "SAVE & SUBMIT" button should become disabled on the 'Policy Benefit' page
	
	@Sprint-29 @PDT-Regression @ui
  Scenario: PDT - Validate the UI of 'Approve Policy' pop-up displayed after clicking Approve Policy button on "Policy Benefit" page
   # Given he is on the "Home Leave" Policy Benefit page
    Given he is on the "Policy Benefit" page after selecting "Home Leave" as Benefit Category;
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    When he clicks on 'Approve Policy' button after verifying success message "Policy saved and submitted" on "Policy Benefit" page
    Then below information should be displayed on 'Approve Policy' Pop-up
      | Heading   | Do you want to proceed with the approval of this policy?                                                                                                                                                          |
      | Message1  | You are approving version 1 of this policy. If approved, the policy state will change from Submitted to Active and indicates that you have reviewed the policy benefits and approve them for use.                 |
      | Message2  | There are currently 0 Assignments or Files associated with this policy in IRIS. The following options are only effective for the client of this policy if Blueprint has been enabled in IRIS Corp: |
      | Checkbox1 | Associate this policy with an EXISTING authorization in IRIS?_Disabled                                                                                                                                          |
      | Checkbox2 | Associate this policy with a NEW authorization in IRIS?_Enabled                                                                                                                                                 |
      | button    | Approve_disabled, Cancel_Enabled                                                                                                                                                                             |

	@Sprint-29 @PDT-Regression @PDT-POL
  Scenario: PDT - Validate 'Approve' button on 'Approve Policy' pop-up becomes enabled after selecting checkbox 'Associate this policy with a NEW authorization' on Policy benefit page
    Given he is on the "Policy Benefit" page after selecting "Home Leave" as Benefit Category;
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    And he clicks on 'Approve Policy' button after verifying success message "Policy saved and submitted" on "Policy Benefit" page
    When he selects the checkbox having label 'Associate this policy with a NEW authorization in IRIS?' on 'Approve Policy' pop-up
    Then "Approve" button should become "enabled" on 'Approve Policy' pop-up
	
	@Sprint-29 @PDT-Regression @PDT-POL-ACTIVE
  Scenario: PDT - Verify that status of a 'Submitted' Policy changes to 'Active' after clicking 'Approve' button on 'Approve Policy' pop-up
    Given he is on the "Policy Benefit" page after selecting "Home Leave" as Benefit Category;
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    And he clicks on 'Approve Policy' button after verifying success message "Policy saved and submitted" on "Policy Benefit" page
    And he selects the checkbox having label 'Associate this policy with a NEW authorization in IRIS?' on 'Approve Policy' pop-up
    When he clicks on "Approve" button on 'Approve Policy' pop-up on "Policy Benefit" page
    Then Version "V1" of Policy should be displayed on "View/Edit Policy Forms" page with "Active" status

  @Sprint-29 @PDT-Regression @PDT-POL-CANCEL
  Scenario: PDT - Verify that Policy Status of a 'Submitted' Policy should not change after clicking 'Cancel' button on 'Approve Policy' pop-up
    Given he is on the "Policy Benefit" page after selecting "Home Leave" as Benefit Category;
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    And he clicks on 'Approve Policy' button after verifying success message "Policy saved and submitted" on "Policy Benefit" page
    And he selects the checkbox having label 'Associate this policy with a NEW authorization in IRIS?' on 'Approve Policy' pop-up
    When he clicks on "Cancel" button on 'Approve Policy' pop-up on "Policy Benefit" page
    Then Status of Policy should remain "Submitted" with Version "V1" on "Policy Benefit" Page 