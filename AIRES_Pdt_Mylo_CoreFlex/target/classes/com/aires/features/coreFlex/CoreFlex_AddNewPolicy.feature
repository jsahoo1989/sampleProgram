Feature: Validate the functionality of Add New Policy

  Background: Login to  Policy Digitization Tool (PDT) application
    Given he has logged into 'Aires Policy Tool' application as a "Client Service Manager" user

  @CF-25 @ClientIDCheck
  Scenario: CoreFlex - Verify behavior of ClientID field for Valid and Invalid data
    Given he has navigated to "Add New Policy Form" menu from left navigation of 'Aires Policy Tool' homepage
    When he enters <FieldValue> value in 'Client ID' dropdown list
    Then 'Policy Name' dropdown list should be displayed having all the policies tied to entered "Valid" Client ID/Name
    And "No items found" text should be displayed in dropdown list followed by 'Record does not exist'Error popup for "Invalid" Client ID/Name
    And 'Policy Name' dropdown list should not be displayed for "Invalid" Client ID/Name

#    Examples: 
#      | FieldType | FieldValue |
#      | Valid     |        924 |
#      | Valid     |      49211 |
#      | Valid     | Air        |
#      | Valid     | Equifax    |
#      | Invalid   |        123 |
#      | Invalid   |      10002 |
#      | Invalid   | Inv        |
#      | Invalid   | Euiqfax    |

#  Scenario Outline: CoreFlex - Verify user is navigated to 'General Information' page when valid Client and CoreFlex Enabled/Regular Policy is selected
#    Given he has navigated to "Add New Policy Form" menu from left navigation of 'Aires Policy Tool' homepage
#    And he has entered and selected valid value "49211" in 'Client ID' dropdown list
#    And he has selected <FieldType> <FieldValue> policy from 'Policy Name' dropdown list
#    When he clicks on 'Next' button
#    Then user should be navigated to the "General Information" page of the selected Client Policy having following selections based on <FieldType>
#      | FieldType | FieldName            | FieldValue |
#      | CoreFlex  | Core/Flex Policy     | Yes        |
#      | CoreFlex  | Benefit Package Type | Core/Flex  |
#      | Regular   | Core/Flex Policy     | No         |
#      | Regular   | Benefit Package Type | Bundle     |
#
#    Examples: 
#      | FieldType | FieldValue                            |
#      | CoreFlex  | Flexible Benefits Policy              |
#      | Regular   | Dow Global Long Term Program with Tax |
