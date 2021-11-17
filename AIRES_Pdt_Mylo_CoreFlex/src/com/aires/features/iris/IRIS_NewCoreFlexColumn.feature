Feature: Validate the functionality of new CoreFlex Column in IRIS Corporation -> Accounting -> PolicyTable.
  He wants to validate the functionality of new CoreFlex Column in IRIS Corporation -> Accounting -> PolicyTable.

  Background: Login to IRIS Application
    Given he has logged into IRIS application as "vkamins" user

  @CF-14 @CoreFlex-PolicyUpdate-Sprint1 @CoreFlexEnabledCheckboxUICheck1
  Scenario: IRIS - Verify that a new column 'CoreFlex Enabled' of type checkbox is added in IRIS Application -> Corporation -> Accounting -> Policy Table
    Given he has queried "49211" corporation in "Corporation" module from "Welcome12C" window
    When he navigates to 'Policy table' of "Accounting" tab from "Corporation" module
    Then "CoreFlex Enabled" checkbox column should be displayed for each Policy in 'Policy table' before "Springboard Enabled" column
    
    
   @CF-14 @CoreFlex-PolicyUpdate-Sprint1 @CoreFlexEnabledCheckboxUICheck
  Scenario: IRIS - Verify that user selection of 'CoreFlex Enabled' checkbox is maintained for the policies in IRIS Application 
    Given he has queried "49211" corporation in "Corporation" module from "Welcome12C" window
    And he has checked and unchecked "CoreFlex Enabled" checkbox for few Policies in 'Policy table' of "Accounting" tab
    When he clicks on 'Save' button
    Then a Pop-Up dialog having "Corporation Policies have been saved!" message should be displayed
    And selection of the checked and unchecked "CoreFlex Enabled" checkbox performed above should be maintained
    
 