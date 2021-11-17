Feature: Validate the functionality of General Information Page for CoreFlex and Non-CoreFlex Policies 

Background: Login to  Policy Digitization Tool (PDT) application 
	Given he has logged into 'Aires Policy Tool' application as a "Client Service Manager" user 
	
@CF-28 @CoreFlex-PolicyUpdate-Sprint1 @GeneralInfoCheckForCoreFlexEnabledPolicy 
Scenario: CoreFlex - Verify CoreFlex related updates are displayed on 'General Information' page for CoreFlex Enabled Policy 
	Given he has selected a policy for "49211" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application 
	And he has saved the record after "checking" "CoreFlex Enabled" checkbox for the policy selected above in 'Policy table' of "Accounting" tab from "Corporation" module of IRIS Application 
	And he had selected the same policy after logging out and logging in again to 'Aires Policy Tool' application as a "Client Service Manager" user 
	When he clicks on 'Next' button 
	Then user should be navigated to the "General Information" page of the selected Client Policy 
		| ClientID | ClientName                   |
		|    49211 | AIRES-CIS-DEMO&'TEST(CLIENT) |
	And "Core/Flex Policy" field should be displayed as "Yes" in read-only mode 
	And "Benefit Package Type" dropdown field should be displayed having following options with default selection as "Core/Flex" 
		| BenefitPackageTypeOptions |
		| Core/Flex |
	And "Points Based Flex Policy" dropdown field should be displayed having following options with default selection as "blank" 
		| PointsBasedFlexPolicyOptions |
		| Yes |
		| No |
		
		
@CF-28 @CoreFlex-PolicyUpdate-Sprint1 @GeneralInfoCheckForNonCoreFlexPolicy 
Scenario: CoreFlex - Verify CoreFlex related updates are not displayed on 'General Information' page for Non CoreFlex Policy 
	Given he has selected a policy for "49211" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application 
	And he has saved the record after "unchecking" "CoreFlex Enabled" checkbox for the policy selected above in 'Policy table' of "Accounting" tab from "Corporation" module of IRIS Application 
	And he had selected the same policy after logging out and logging in again to 'Aires Policy Tool' application as a "Client Service Manager" user 
	When he clicks on 'Next' button 
	Then user should be navigated to the "General Information" page of the selected Client Policy 
		| ClientID | ClientName                   |
		|    49211 | AIRES-CIS-DEMO&'TEST(CLIENT) |
	And "Core/Flex Policy" field should be displayed as "No" in read-only mode 
	And "Benefit Package Type" dropdown field should be displayed having following options with default selection as "blank" 
		| BenefitPackageTypeOptions |
		| Bundle     |
		| A la Carte |
	And "Points Based Flex Policy" dropdown field should not be displayed
	
	
@CF-28 @CoreFlex-PolicyUpdate-Sprint1 @PointsBasedFlexPolicyWorkflowCheck 
Scenario: CoreFlex - Verify that flex workflow is initiated, when user selects 'Yes' option in 'Points Based Flex Policy' dropdown for 'CoreFlex Enabled' Policy
	Given he has selected a "CoreFlex Enabled" policy for "49211" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application 
	And he has selected "Yes" option for "Points Based Flex Policy" dropdown field after filling all other mandatory fields
	When he clicks on 'Next' button 
	Then user should be navigated to the "Flex Policy Setup" page of the selected Client Policy
	
@CF-28 @CoreFlex-PolicyUpdate-Sprint1 @NoPointsBasedFlexPolicyWorkflowCheck 
Scenario: CoreFlex - Verify that flex workflow is initiated, when user selects 'Yes' option in 'Points Based Flex Policy' dropdown for 'CoreFlex Enabled' Policy
	Given he has selected a "CoreFlex Enabled" policy for "49211" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application 
	And he has selected "No" option for "Points Based Flex Policy" dropdown field after filling all other mandatory fields
	When he clicks on 'Next' button 
	Then user should be navigated to the "Policy Benefits Categories" page of the selected Client Policy
	
@CF-28 @CoreFlex-PolicyUpdate-Sprint1 @FlexPolicyWorkflowChangePopUpValidation 
Scenario: CoreFlex - Verify confirmation popup box contents, when changing CoreFlex Policy to Non CoreFlex Policy
	Given he has selected a "CoreFlex Enabled" policy for "49211" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application 
	And he has selected "Yes" option for "Points Based Flex Policy" dropdown field after filling all other mandatory fields
	And he has navigated to "General Information" page from "Flex Policy Setup" page through left navigation
	When he change "Points Based Flex Policy" dropdown selection to "No"
	Then a confirmation pop-up dialog should be displayed having following message and options
	|FieldType | FieldValue |
	|Message   |Are you sure you want to change the CoreFlex Points Based policy to Regular Policy? This change will delete all the saved Flex policy data. Do you still want to continue?|
	|Options   | Ok, Cancel |
	
@CF-28 @CoreFlex-PolicyUpdate-Sprint1 @FlexPolicyWorkflowChangePopUpValidation 
Scenario: CoreFlex - Verify confirmation popup box contents, when changing Non CoreFlex Policy to CoreFlex Policy
	Given he has selected a "CoreFlex Enabled" policy for "49211" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application 
	And he has selected "No" option for "Points Based Flex Policy" dropdown field after filling all other mandatory fields
	And he has navigated to "General Information" page from "Policy Benefits Categories" page through left navigation
	When he change "Points Based Flex Policy" dropdown selection to "Yes"
	Then a confirmation pop-up dialog should be displayed having following message and options
	|FieldType | FieldValue |
	|Message   |"Are you sure you want to change the CoreFlex Points Based policy to Regular Policy? This change will delete all the saved Flex policy data. Do you still want to continue?|
	|Options   | Ok, Cancel |
	
	
@CF-28 @CoreFlex-PolicyUpdate-Sprint1 @FlexPolicyWorkflowChangePopUpValidation 
Scenario: CoreFlex - Verify policy workflow when changing CoreFlex Policy to Non CoreFlex Policy
	Given he has selected a "CoreFlex Enabled" policy for "49211" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application 
	And he has selected "Yes" option for "Points Based Flex Policy" dropdown field after filling all other mandatory fields
	And he has navigated to "General Information" page from "Flex Policy Setup" page through left navigation
	And he has changed "Points Based Flex Policy" dropdown selection to "No"
	And he has selected "Ok" option on Confirmation Pop-up box
	When he clicks on 'Next' button 
	Then user should be navigated to the "Policy Benefits Categories" page of the selected Client Policy
	
@CF-28 @CoreFlex-PolicyUpdate-Sprint1 @FlexPolicyWorkflowChangePopUpValidation 
Scenario: CoreFlex - Verify policy workflow when changing Non CoreFlex Policy to CoreFlex Policy
	Given he has selected a "CoreFlex Enabled" policy for "49211" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application 
	And he has selected "No" option for "Points Based Flex Policy" dropdown field after filling all other mandatory fields
	And he has navigated to "General Information" page from "Policy Benefits Categories" page through left navigation
	And he has changed "Points Based Flex Policy" dropdown selection to "Yes"
	And he has selected "Ok" option on Confirmation Pop-up box
	When he clicks on 'Next' button 
	Then user should be navigated to the "Flex Policy Setup" page of the selected Client Policy
		
		