Feature: Validate the functionality of new CoreFlex Column in IRIS Corporation -> Accounting -> PolicyTable.
  He wants to validate the functionality of new CoreFlex Column in IRIS Corporation -> Accounting -> PolicyTable.

  Background: Login to IRIS Application
    Given he has logged into IRIS application as "vkamins" user
    
 @CF-14 @CoreFlex-PolicyUpdate-Sprint1 @CoreFlexEnabledCheckboxUICheck
  Scenario: IRIS - Verify that user selection of 'CoreFlex Enabled' checkbox is maintained for the policies in IRIS Application
    Given he has queried "49211" corporation in "Corporation" module from "Welcome12C" window
    And he has 'Checked/Unchecked' "CoreFleX Enabled" checkbox for following Policy in 'Policy table' of "Accounting" tab
      | PolicyName        | CoreFleXEnabledCheckboxSelection |
      | AOL Digital Media | Checked                          |
      | AOL Publishing    | Unchecked                        |
    When he clicks on 'Save' button
    Then selection of the 'Checked/Unchecked' "CoreFleX Enabled" checkbox performed above should be maintained for "49211" corporation
      | PolicyName        | CoreFleXEnabledCheckboxSelection |
      | AOL Digital Media | Checked                          |
      | AOL Publishing    | Unchecked                        |
    
    
 