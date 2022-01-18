Feature: Validate the functionality of new CoreFlex Column in IRIS Corporation -> Accounting -> PolicyTable.
  He wants to validate the functionality of new CoreFlex Column in IRIS Corporation -> Accounting -> PolicyTable.

  Background: Login to IRIS Application
    Given he is logged into IRIS application as "vkamins" user
    
 @CF-14 @CoreFlex-PolicyUpdate-Sprint1
  Scenario: IRIS - Verify that user selection of 'CoreFlex Enabled' checkbox is maintained for the policies in IRIS Application
    Given he has queried "94940" corporation in "Corporation" module from "Welcome12C" window
    And he has 'Checked/Unchecked' "CoreFleX Enabled" checkbox for following Policy in 'Policy table' of "Accounting" tab
      | PolicyName          | CoreFleXEnabledCheckboxSelection |
      | A la carte services | Checked                          |
    And he has clicked on 'Save' button
    When he navigates back to "Accounting" tab of Corporation module for "94940" corporation after logging out and logging again to IRIS application
    Then selection of the 'Checked/Unchecked' "CoreFleX Enabled" checkbox performed above should be maintained
      | PolicyName          | CoreFleXEnabledCheckboxSelection |
      | A la carte services | Checked                          |