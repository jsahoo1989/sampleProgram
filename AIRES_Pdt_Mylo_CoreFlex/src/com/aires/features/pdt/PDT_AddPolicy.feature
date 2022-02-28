@spant
Feature: Add new Policy form with Benefit Categories
  Validate the functionality of Add new Policy form

  Background: Login to  Policy Digitization Tool (PDT) application
    Given he is logged into 'Aires Policy Tool' application as a "Client Service Manager" user

  @Sprint-14 @PDT-Regression
  Scenario: Verify Core/Flex policy drop down should display as "No" on General Information section for selected PDT policy
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    When he clicks on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    Then by default "No" option should be selected for 'Core/Flex policy' drop down on "General Information" page
    And 'Benefit Package Type' drop down should display below options
      | Bundle     |
      | A la carte |

  @Sprint-14 @PDT-Regression
  Scenario: PDT - Verify Policy Benefit Categories are displayed on the 'Policy Benefits' page while adding a new Policy
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    When he clicks on the 'Next' button after entering mandatory information on 'General Information' page
    Then all the available benefit categories should be displayed on the "Policy Benefits" page

  @Sprint-14 @PDT-Regression
  Scenario: PDT - Validate that sub benefit form should show & hide after selecting sub benefit checkbox as checked or unchecked
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Pre-Acceptance Services" as Benefit Category on "Policy Benefit" page
    And sub benefit category form should appear after selecting below categories on "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
    When he unchecks the below sub benefit categories  on "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
    Then below sub benefit categories form should disappear from  "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |

  @Sprint-15 @PDT-Regression @pre
  Scenario: PDT - Add new Policy form using Pre-Acceptance Services as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Pre-Acceptance Services" as Benefit Category on "Policy Benefit" page
    When he clicks on 'SUBMIT' button after entering mandatory information for all the below selected sub benefits on "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
    Then success message "Policy saved and submitted" should be displayed on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page

  @Sprint-16 @PDT-Regression @imigration
  Scenario: PDT - Add new Policy form using Immigration as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Immigration" as Benefit Category on "Policy Benefit" page
    When he clicks on 'SUBMIT' button after entering mandatory information for all the below selected sub benefits on "Immigration" page
      | Immigration Fees | Immigration Travel |
    Then success message "Policy saved and submitted" should be displayed on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page

  @Sprint-16 @PDT-Regression @tab
  Scenario: PDT - Validate the display of tabs on Sub benefits form depending upon the selection/deselection of Benefit differs for Employee type, Benefit differs for Homeowner types
    Given he is on the "Add New Policy Form" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has selected below information for form fields on 'General Information' page followed by selection of "Pre-Acceptance Services" as Benefit Category on "Policy Benefit" page
      | PolicyType    | EmployeeType                   | HomeownerType                  | BenefitPackageType | CappedPolicy     | ExpenseManagementClient |
      | International | Both - benefits differ by type | Both - benefits differ by type | Bundle             | Partially Capped | No                      |
    When he selects 'Benefit differs for Employee type', 'Benefit differs for Homeowner type' for below Sub benefits on "Pre-Acceptance Services" page
      | SubBenefit                         | Benefit_differs_for_Employee_type | Benefit_differs_for_Home_Owner_type |
      | Candidate Selection                | Yes                               | No                                  |
      | Pre-Acceptance Trip Transportation | No                                | Yes                                 |
      | Pre-Acceptance Trip Lodging        | Yes                               | Yes                                 |
    Then below Tabs should appear in Sub benefit form on "Pre-Acceptance Services" page
      | SubBenefit                         | Benefit_differs_for_Employee_type | Benefit_differs_for_Home_Owner_type | Tabs                                                                                             |
      | Candidate Selection                | Yes                               | No                                  | Current Employee, New Hire                                                                       |
      | Pre-Acceptance Trip Transportation | No                                | Yes                                 | Home Owner, Renter                                                                               |
      | Pre-Acceptance Trip Lodging        | Yes                               | Yes                                 | Current Employee - HomeOwner, Current Employee - Renter, New Hire - HomeOwner, New Hire - Renter |

  @Sprint-17 @PDT-Regression @house
  Scenario: PDT - Add new Policy form using House Hunting Trip as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "House Hunting Trip" as Benefit Category on "Policy Benefit" page
    When he clicks on 'SUBMIT' button after entering mandatory information for all the below selected sub benefits on "House Hunting Trip" page
      | House Hunting Trip Transportation | House Hunting Trip Lodging | House Hunting Trip Meals |
    Then success message "Policy saved and submitted" should be displayed on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page

  @Sprint-17 @PDT-Regression @lang @PDT-384
  Scenario: PDT - Add new Policy form using Language Training as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Language Training" as Benefit Category on "Policy Benefit" page
    When he clicks on 'SUBMIT' button after entering mandatory information for all the below selected sub benefits on "Language Training" page
      | Language Training Employee | Language Training Family |
    Then success message "Policy saved and submitted" should be displayed on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page

  @Sprint-17 @PDT-Regression @cult @PDT-385
  Scenario: PDT - Add new Policy form using Cultural Training as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Cultural Training" as Benefit Category on "Policy Benefit" page
    When he clicks on 'SUBMIT' button after entering mandatory information for all the below selected sub benefits on "Cultural Training" page
      | Cultural Training Employee | Cultural Training Family |
    Then success message "Policy saved and submitted" should be displayed on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page

  @Sprint-18 @PDT-Regression @final @PDT-429
  Scenario: PDT - Add new Policy form using Final Move as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Final Move" as Benefit Category on "Policy Benefit" page
    When he clicks on 'SUBMIT' button after entering mandatory information for all the below selected sub benefits on "Final Move" page
      | Final Move Transportation | Final Move Lodging | Final Move Meals |
    Then success message "Policy saved and submitted" should be displayed on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page

  @Sprint-19 @PDT-Regression @temp @PDT-547
  Scenario: PDT - Add new Policy form using Temporary Living as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Temporary Living" as Benefit Category on "Policy Benefit" page
    When he clicks on 'SUBMIT' button after entering mandatory information for all the below selected sub benefits on "Temporary Living" page
      | Temporary Living Lodging | Temporary Living Meals | Temporary Living Transportation |
    Then success message "Policy saved and submitted" should be displayed on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page

  @Sprint-19 @PDT-Regression @home @PDT-546
  Scenario: PDT - Add new Policy form using Home Leave as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Home Leave" as Benefit Category on "Policy Benefit" page
    When he clicks on 'SUBMIT' button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    Then success message "Policy saved and submitted" should be displayed on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page

  @Sprint-20 @PDT-Regression @des @PDT-590
  Scenario: PDT - Add new Policy form using Destination Services as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Destination Services" as Benefit Category on "Policy Benefit" page
    When he clicks on 'SUBMIT' button after entering mandatory information for all the below selected sub benefits on "Destination Services" page
      | Airport Pickup | Area Tour | Auto Rental During Assignment | Concierge Services | Departure Services | Furniture Rental | Reimbursement of Membership Dues | School Search | Settling In Services | Transition Assistance Program | Tuition and Education |
    Then success message "Policy saved and submitted" should be displayed on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page
