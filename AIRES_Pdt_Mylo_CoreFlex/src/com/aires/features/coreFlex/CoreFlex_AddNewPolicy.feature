Feature: Validate the functionality of Add New Policy

  Background: Login to  Policy Digitization Tool (PDT) application
    Given he has logged into 'Aires Policy Tool' application as a "Client Service Manager" user

  @CF-25 @Regression
  Scenario Outline: CoreFlex - Verify behavior of ClientID field for Valid data
    Given he has navigated to "Add New Policy Form" menu from left navigation of 'Aires Policy Tool' homepage
    When he enters valid <ClientID> in 'Client ID' dropdown list
    Then 'Policy Name' dropdown list should be displayed having all the policies tied to entered <ClientID> Client ID/Name

    Examples: 
      | ClientID |
      |      924 |
      |      949 |
      |     9494 |
      |    94943 |
      |    49211 |
      | AIR      |
      | Equifax  |

  @CF-25 @Regression
  Scenario Outline: CoreFlex - Verify behavior of ClientID field for Invalid data

    Given he has navigated to "Add New Policy Form" menu from left navigation of 'Aires Policy Tool' homepage
    When he enters invalid <ClientID> in 'Client ID' dropdown list
    Then 'No items found' text should be displayed in dropdown list followed by 'Record does not exist' Error popup for Invalid <ClientID>
    And 'Policy Name' dropdown list should not be displayed for Invalid <ClientID>

    Examples: 
      | ClientID |
      |      123 |
      |    10002 |
      | zzz      |
      | Euiqfax  |

  @CF-25 @CoreFlex-PolicyUpdate-Sprint1 @NextButtonAndNavigationCheck
  Scenario: CoreFlex - Verify user is navigated to 'General Information' page after clicking on Next button
    Given he has navigated to "Add New Policy Form" menu from left navigation of 'Aires Policy Tool' homepage
    And he has entered a valid "49211" in 'Client ID' dropdown list
    And he has selected a policy from 'Policy Name' dropdown list
    When he clicks on 'Next' button
    Then user should be navigated to the "General Information" page of the selected Client Policy
      | ClientID | ClientName                   |
      |    49211 | AIRES-CIS-DEMO&'TEST(CLIENT) |

      