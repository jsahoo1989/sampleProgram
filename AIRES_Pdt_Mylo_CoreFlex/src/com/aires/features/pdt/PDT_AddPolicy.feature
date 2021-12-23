Feature: Add new Policy form with Benefit Categories
  Validate the functionality of Add new Policy form

  Background: Login to Policy App Application
    Given he is logged into Policy App application with below credentials
      | userName | password |
      | kbrian   | kbrian   |

  @Sprint-14 @PDT-Regression @drop-1
  Scenario: Verify Core/Flex policy drop down should display as "No" on General Information section for selected PDT policy
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    When he clicks on the 'Next' button after selecting below information on the 'Add New Policy' page
      | ClientId | ClientName                    | PolicyName                                    |
      |     7403 | Dow Chemical Company (Global) | Sadara to Dow Consecutive Long Term (# 11100) |
    Then by default "No" option should be selected for 'Core/Flex policy' drop down on "General Information" page
    And 'Benefit Package Type' drop down should display below options
      | Bundle     |
      | A la carte |

  @Sprint-14 @PDT-Regression @drop-2
  Scenario: PDT - Verify Policy Benefit Categories are displayed on the 'Policy Benefits' page while adding a new Policy
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting below information on the 'Add New Policy' page
      | ClientId | ClientName                    | PolicyName                                    |
      |     7403 | Dow Chemical Company (Global) | Sadara to Dow Consecutive Long Term (# 11100) |
    When he clicks on the 'Next' button after selecting below information on 'General Information' page
      | PolicyType    | EmployeeType                   | HomeownerType                  | BenefitPackageType | CappedPolicy     | ExpenseManagementClient |
      | International | Both - benefits differ by type | Both - benefits differ by type | Bundle             | Partially Capped | No                      |
    Then all the available benefit categories should be displayed on the "Policy Benefits" page

  @Sprint-14 @PDT-Regression
  Scenario: PDT - Validate that sub benefit form should show & hide after selecting sub benefit checkbox as checked or unchecked
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting below information on the 'Add New Policy' page
      | ClientId | ClientName                    | PolicyName                                    |
      |     7403 | Dow Chemical Company (Global) | Sadara to Dow Consecutive Long Term (# 11100) |
    And he has selected below information on 'General Information' page followed by selection of "Pre-Acceptance Services" as Benefit Category on "Policy Benefit" page
      | PolicyType    | EmployeeType                   | HomeownerType                  | BenefitPackageType | CappedPolicy     | ExpenseManagementClient |
      | International | Both - benefits differ by type | Both - benefits differ by type | Bundle             | Partially Capped | No                      |
    And sub benefit category form should appear after selecting below categories on "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
    When he unchecks the below sub benefit categories  on "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
    Then below sub benefit categories form should disappear from  "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
