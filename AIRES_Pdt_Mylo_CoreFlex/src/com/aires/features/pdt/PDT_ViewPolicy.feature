Feature: Validate the functionality of View Policy page
   I want to verify the functionality of View Policy page

  Background: Login to Policy Digitization Application
    Given he is logged into Policy App application with below credentials
      | userName | password |
      | kbrian   | kbrian   |

  @search
  Scenario: PDT - Verify search operation on View/Edit Policy Form Page
    Given he is on "View/Edit Policy" page
    Then he should be able to verify Policy data on "View/Edit Policy Forms" page after performing below SearchBy operations
      | SearchBy    | SearchText                     | ClientId | CompanyName            |
      | Policy      | Canada Field Relocation Policy |    51769 | Urban Outfitters, Inc. |
      | Client Id   |                          51769 |    51769 | Urban Outfitters, Inc. |
      | Client Name | Dow Chemical Company           |     7403 | Dow Chemical Company   |
