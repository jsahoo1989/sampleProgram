Feature: Validate the functionality of General Information Page for CoreFlex and Non-CoreFlex Policies

  Background: Login to  Policy Digitization Tool (PDT) application
    Given he is logged into 'Aires Policy Tool' application as a "Client Service Manager" user

  @CF-28 @CoreFlex-PolicyUpdate-Sprint1 
  Scenario Outline: CoreFlex - Verify CoreFlex related updates are displayed on the 'General Information' page for the CoreFlex policy, displayed as enabled on the Accounting tab of Corporation module in Iris Application
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has selected a policy for Client "<ClientID>"
    And he has searched the corporation "<ClientID>" on the "Corporation" tab after login to the IRIS application
    And he has saved the information on the "Accounting" tab after selecting the "CoreFleX Enabled" checkbox as "<CheckboxSelection>" for the selected policy in Aires Policy tool
    And he has selected the same policy for the "<ClientID>" Client on the "Add new Policy" page after logging in again to the 'Aires Policy Tool' application
    When he clicks on 'Next' button
    Then "General Information" page should be displayed having "Core/Flex Policy" field value as "<CoreFlexFieldValue>" for "<ClientID>" Client
    And "Points Based Flex Policy" field visibility "<PointsBasedFlexPolicyFieldDisplayed>" having "<PointsBasedFlexPolicyFieldOptions>" dropdown options should depend on CoreFlexFieldValue "<CoreFlexFieldValue>"
    And "Benefit Package Type" field visibility "<BenefitPackageTypeFieldDisplayed>" having "<BenefitPackageTypeFieldOptions>" dropdown options should depend on CoreFlexFieldValue "<CoreFlexFieldValue>"

    Examples: 
      | ClientID | CheckboxSelection | CoreFlexFieldValue | PointsBasedFlexPolicyFieldDisplayed | PointsBasedFlexPolicyFieldOptions | BenefitPackageTypeFieldDisplayed | BenefitPackageTypeFieldOptions |
      |    94940 | Checked           | Yes                | Yes                                 | Yes,No                            | No                               |                                |
      |    94940 | Unchecked         | No                 | No                                  |                                   | Yes                              | Bundle,A la carte              |

   @CF-28 @CoreFlex-PolicyUpdate-Sprint1
  Scenario Outline: CoreFlex - Verify user navigation to Flex Policy Setup(CoreFlex)/Policy Benefits Categories page depending upon the option selected for "Points Based Flex Policy" field on General Information page.
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has selected a policy for Client "<ClientID>"
    And he has searched the corporation "<ClientID>" on the "Corporation" tab after login to the IRIS application
    And he has saved the information on the "Accounting" tab after selecting the "CoreFleX Enabled" checkbox as "Checked" for the selected policy in Aires Policy tool
    And he has selected the same policy for the "<ClientID>" Client on the "Add new Policy" page after logging in again to the 'Aires Policy Tool' application
    And he has clicked on 'Next' button
    And he has selected "<PointsBasedFlexPolicy>" option for "Points Based Flex Policy" dropdown field of "<CoreFlexEnabled>" Policy after filling all other mandatory fields on "General Information" page for "<ClientID>" Client
    | PolicyType  | EmployeeType     | HomeownerType | CappedPolicy | ExpenseManagementClient |
    | US Domestic | Current Employee | Homeowner     | No           | No                      |
    When he clicks on 'Next' button
    Then he should be navigated to "<ExpectedPageTitle>" page having "<ExpectedLeftNavigationTitle>" based on "<PointsBasedFlexPolicy>" selection

    Examples: 
      | ClientID | CoreFlexEnabled | PointsBasedFlexPolicy | ExpectedPageTitle          | ExpectedLeftNavigationTitle  |
      |    94940 | Yes             | Yes                   | Flex Policy Setup          | Flex Policy Setup            |
      |    94940 | Yes             | No                    | Policy Benefits Categories | Policy Benefits Categories   |  