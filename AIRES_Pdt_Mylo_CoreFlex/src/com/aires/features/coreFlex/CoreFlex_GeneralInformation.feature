Feature: Validate the functionality of General Information Page for CoreFlex and Non-CoreFlex Policies

  Background: Login to  Policy Digitization Tool (PDT) application
    Given he has logged into 'Aires Policy Tool' application as a "Client Service Manager" user

  @CF-28 @CoreFlex-PolicyUpdate-Sprint1 @GeneralInfoCheckForCoreFlexEnabledPolicy
  Scenario: CoreFlex - Verify CoreFlex related updates are displayed on 'General Information' page for CoreFlex Enabled Policy
    Given he has selected a policy for "49211" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application
    And he has saved the record after "Checked" "CoreFleX Enabled" checkbox for the policy selected above in 'Policy table' of "Accounting" tab from "Corporation" module of "49211" corporation
    And he had selected the same policy for "49211" Client after logging out and logging in again to 'Aires Policy Tool' application as a "Client Service Manager" user
    When he clicks on 'Next' button
    Then user should be navigated to the "General Information" page of the selected Client Policy
      | ClientID | ClientName                   |
      |    49211 | AIRES-CIS-DEMO&'TEST(CLIENT) |
    And "Core/Flex Policy" field should be displayed as "Yes" in read-only mode
      | - |
    And "Benefit Package Type" dropdown field should be displayed having following options with default selection as "Core/Flex"
      | Core/Flex |
    And "Points Based Flex Policy" dropdown field should be displayed having following options with default selection as "Please Select"
      | Yes |
      | No  |
      
      
  @CF-28 @CoreFlex-PolicyUpdate-Sprint1 @GeneralInfoCheckForNonCoreFlexPolicy
  Scenario: CoreFlex - Verify CoreFlex related updates are not displayed on 'General Information' page for Non CoreFlex Policy
    Given he has selected a policy for "49211" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application
    And he has saved the record after "Unchecked" "CoreFleX Enabled" checkbox for the policy selected above in 'Policy table' of "Accounting" tab from "Corporation" module of "49211" corporation
    And he had selected the same policy for "49211" Client after logging out and logging in again to 'Aires Policy Tool' application as a "Client Service Manager" user
    When he clicks on 'Next' button
    Then user should be navigated to the "General Information" page of the selected Client Policy
      | ClientID | ClientName                   |
      |    49211 | AIRES-CIS-DEMO&'TEST(CLIENT) |
    And "Core/Flex Policy" field should be displayed as "No" in read-only mode
    | - |
    And "Benefit Package Type" dropdown field should be displayed having following options with default selection as "Please Select"
      | Bundle                    |
      | A la carte                |
    And "Points Based Flex Policy" dropdown field should not be displayed
    
    
   @CF-28 @CoreFlex-PolicyUpdate-Sprint1 @FlexPolicyWorkflowCheck
  Scenario Outline: CoreFlex - Verify user navigation past General Information page, when CoreFlex Enabled Policy with PointsBasedFlexPolicy Y/N is selected
    Given he has navigated to "General Information" page after selecting a "<CoreFlexEnabled>" policy for "<ClientID>" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application
    And he has saved the record after "Checked" "CoreFleX Enabled" checkbox for the policy selected above in 'Policy table' of "Accounting" tab from "Corporation" module of "49211" corporation
    And he has selected "<PointsBasedFlexPolicy>" option for "Points Based Flex Policy" dropdown field of "<CoreFlexEnabled>" Policy after filling all other mandatory fields on "General Information" page for "<ClientID>" Client
    When he clicks on 'Next' button
    Then he should be navigated to "<ExpectedPageTitle>" page having "<ExpectedLeftNavigationTitle>" based on "<PointsBasedFlexPolicy>" selection

    Examples: 
      | ClientID | CoreFlexEnabled | PointsBasedFlexPolicy | ExpectedPageTitle          | ExpectedLeftNavigationTitle  |
      |    49211 | Yes             | Yes                   | Flex Policy Setup          | Flex Policy Setup            |
      |    49211 | Yes             | No                    | Policy Benefits Categories | Policy Benefits / Categories |

    
    
   