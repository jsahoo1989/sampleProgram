Feature: Add new Policy form with Benefit Categories
  Validate the functionality of Add new Policy form

  Background: Login to Policy App Application
    Given he is logged into Policy App application with below credentials
      | userName | password |
      | kbrian   | kbrian   |
  
  @Sprint-14 @PDT-Regression
  Scenario: Verify Core/Flex policy drop down should display as "No" on General Information section for selected PDT policy
    Given he is on "Add New Policy Form" page after clicking link "Add New Policy Form" from left menu navigation on "View/Edit Policy Form" page
    When he clicks on "Next" button after selecting below Client, Policy information on "Add New Policy Form" page
      | ClientId | ClientName                    | PolicyName                 |
      |     7403 | Dow Chemical Company (Global) | Valued Relocation (# 9533) |
    Then by default "No" option should be selected for "Core/Flex policy" drop down on "General Information" page
    And "Benefit Package Type" drop down should display below options
      | Bundle     |
      | A la carte |

		@Sprint-14 @PDT-Regression
    Scenario: PDT - Verify Policy Benefit Categories are displayed after adding a new Policy
    Given he is on "Add New Policy Form" page after clicking link "Add New Policy Form" from left menu navigation on "View/Edit Policy Form" page
    And he has clicked on "Next" button after selecting below Client, Policy information on "Add New Policy Form" page
      | ClientId | ClientName                    | PolicyName                 |
      |     7403 | Dow Chemical Company (Global) | Valued Relocation (# 9533) |
    When he clicks on "Next" button after selecting below information for form fields on "General Information" page
      | PolicyType    | EmployeeType                   | HomeownerType                  | BenefitPackageType | CappedPolicy     | ExpenseManagementClient |
      | International | Both - benefits differ by type | Both - benefits differ by type | Bundle             | Partially Capped | No                      |
    Then benefit categories should be displayed on "Policy Benefit Category" page

		@Sprint-14 @PDT-Regression
    Scenario: PDT - Validate that sub benefit form should display and hide after marking subbenefit as checked or unchecked
    Given he is on "Add New Policy Form" page after clicking link "Add New Policy Form" from left menu navigation on "View/Edit Policy Form" page
    And he has clicked on "Next" button after selecting below Client, Policy information on "Add New Policy Form" page
      | ClientId | ClientName                    | PolicyName                 |
      |     7403 | Dow Chemical Company (Global) | Valued Relocation (# 9533) |
    And he has selected below information for form fields on "General Information" page followed by selection of "Pre-Acceptance Services" as Benefit Category on "Policy Benefit Category" page
      | PolicyType    | EmployeeType                   | HomeownerType                  | BenefitPackageType | CappedPolicy     | ExpenseManagementClient |
      | International | Both - benefits differ by type | Both - benefits differ by type | Bundle             | Partially Capped | No                      |
    And sub benefit category form appears after selecting below categories on "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
    When he deselects the below sub benefit category  on "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
    Then below sub benefit category form should disappear from  "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
