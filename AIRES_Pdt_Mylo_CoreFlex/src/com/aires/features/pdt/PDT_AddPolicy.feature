Feature: Add new Policy form with Benefit Categories
  Validate the functionality of Add new Policy form

  Background: Login to Policy App Application
    Given he is logged into Policy App application with below credentials
      | userName | password |
      | kbrian   | kbrian   |

  #/*******PDT-48********/
  Scenario: Add new Policy form with Pre-Acceptance Services as Benefit Category
    Given he is on "General Information" section of "Policy Benefit" page after selecting below information for creating a new policy
      | Client Id | Client Name               | Policy Name                     |
      |     50270 | American Eagle Outfitters | International Lump Sum (# 9805) |
    And he has provided mandatory information on "General Information" section as per the below option selected for "Expense Management" client
      | Expense Management Client |
      | No                        |
    And he has clicked on "Next" buton after selecting below service under "Policy Benefit Categories" section
      | Pre-Acceptance Services |
    When he clicks on "SUBMIT" button after entering mandatory information for all the below selected services
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
    Then success message "Data saved successfully" shoud be displayed
    And newly created Policy should be displayed under "View/Edit Policy Form" page

  Scenario: Save the new Pre-Acceptance Benefit Category in Draft mode
    Given he is on "General Information" section of "Policy Benefit" page after selecting below information for creating a new policy
      | Client Id | Client Name               | Policy Name                     |
      |     50270 | American Eagle Outfitters | International Lump Sum (# 9805) |
    And he has provided mandatory information on "General Information" section as per the below option selected for "Expense Management" client
      | Expense Management Client |
      | No                        |
    And he has clicked on "Next" buton after selecting below service under "Policy Benefit Categories" section
      | Pre-Acceptance Services |
    When he clicks on "SAVE AS DRAFT" button after entering mandatory information for all the below selected services
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
    Then success message "Data saved successfully" shoud be displayed
    And newly created Policy should be displayed under "View/Edit Policy Form" page in "Draft" status

  Scenario: Verify user is able to view already saved benefit
    Given he is on "View/Edit Policy Form" page after creating a new Policy Benefit with below details
      | Client Id | Client Name               | Policy Name                     | Benefit Categories      | Service                                                 |
      |     50270 | American Eagle Outfitters | International Lump Sum (# 9805) | Pre-Acceptance Services | Candidate Selection, Pre-Acceptance Trip Transportation |
    #   And he has searched the newly created policy on "View/Edit Policy Form" page
    #   When he clicks on policy name in search results on "View/Edit Policy Form" page
    When he clicks on policy name in search results on "View/Edit Policy Form" page after searching the newly created policy
    Then Policy Benefit data should be displayed in below sections
      | General Information | Benefit Categories | Service Section |

  Scenario: Verify user is able to update already saved benefit
    Given he is on "View/Edit Policy Form" page after creating a new Policy Benefit with below details
      | Client Id | Client Name               | Policy Name                     | Benefit Categories      | Service                                                 |
      |     50270 | American Eagle Outfitters | International Lump Sum (# 9805) | Pre-Acceptance Services | Candidate Selection, Pre-Acceptance Trip Transportation |
    #    And he has searched the newly created policy on "View/Edit Policy Form" page
    #    And he has clicked on policy name in search results on "View/Edit Policy Form" page
    And he clicks on policy name in search results on "View/Edit Policy Form" page after searching the newly created policy
    When he updates the field value information in below mentioned sections after clicking on "SUBMIT" button
      | Section Name        | Field Name           | Field Value   |
      | General Information | Policy Type          | International |
      | General Information | Benefit Package Type | Core/Flex     |
      | Candidate Selection | Gross-up             | No            |
      | Candidate Selection | Reimbursed by        | Client        |
    Then success message "Data saved successfully" shoud be displayed
    
    #/*******PDT-60********/

  Scenario: Verify Policies are displayed in descending order on View/Edit Policy Form Page
    Given he is on "ViewPolicy" page
    Then policies are displayed in desc order by policy_benefits_config_id

  Scenario: Verify search by client name on View/Edit Policy Form Page
    Given he is on "View/Edit Policy Forms" page
    And has entered below Client name in the "Client Name" field
      | Client Name      |
      | Urban Outfitters |
    When the user clicks "Search" button
    Then below policies for the client name under the current logged in user will be displayed in desc order by policy_benefits_config_id
      | Policy Name                    | Company Name           | Client Id | Policy Type   |
      | Home Office Relocation Policy  | Urban Outfitters, Inc. |     51769 | International |
      | Canada Field Relocation Policy | Urban Outfitters, Inc. |     51769 | International |

  Scenario: Verify search by client id on View/Edit Policy Form Page
    Given he is on "View/Edit Policy Forms" page
    And has entered below Client id in the "Client Id" field
      | Client Id |
      |     51769 |
    When the user clicks "Search" button
    Then below policies for the client id under the current logged in user will be displayed in desc order by policy_benefits_config_id
      | Policy Name                    | Company Name           | Client Id | Policy Type   |
      | Home Office Relocation Policy  | Urban Outfitters, Inc. |     51769 | International |
      | Canada Field Relocation Policy | Urban Outfitters, Inc. |     51769 | International |

  Scenario: Verify search by Policy name on View/Edit Policy Form Page
    Given he is on "View/Edit Policy Forms" page
    And has entered below Policy name in the "Policy Name" field
      | Policy name                    |
      | Canada Field Relocation Policy |
    When the user clicks "Search" button
    Then below policies for the policy name under the current logged in user will be displayed in desc order by policy_benefits_config_id
      | Canada Field Relocation Policy | Urban Outfitters, Inc. | 51769 | International |

  Scenario: Verify search operation on View/Edit Policy Form Page
    Given he is on "View/Edit Policy Forms" page
    Then he should be able to verify Policy data on "View/Edit Policy Forms" page after performing below SearchBy operations
      | SearchBy    | SearchText                     | PolicyName                                                   | ClientId | CompanyName            | Policy Type   |
      | Policy Name | Canada Field Relocation Policy | Canada Field Relocation Policy                               |    51769 | Urban Outfitters, Inc. | International |
      | Client Id   |                          51769 | Canada Field Relocation Policy_Home Office Relocation Policy |    51769 | Urban Outfitters, Inc. | International |
      | Client Name | Urban Outfitters, Inc.         | Canada Field Relocation Policy_Home Office Relocation Policy |    51769 | Urban Outfitters, Inc. | International |

	#/***************PDT-79***************************/
  Scenario: Verify edit/update operation on View/Edit Policy Form Page after searching Policy by name
    Given he has searched below Policy name in the "Policy Name" field
      | Policy name                    |
      | Canada Field Relocation Policy |
    And he has clicked on "Edit" icon for above policy
    When he updates below information for policy
    Then the updated information should get saved.
