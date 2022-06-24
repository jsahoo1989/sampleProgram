@iris
Feature: Create new Corporation Policy
  Validate the functionality of adding new Corporation policy.

  Background: Login to IRIS Application
    Given he is logged into IRIS application

  @Sprint-18 @create
  Scenario: Create new Corporation policy in IRIS application and verify that Policy is visible in PDT application
    Given he has selected "Corporation" module from "Welcome12C" window
    And he has queried corporation from "Corporation" module
    And he has added a new policy in the "Accounting" tab
    And he logins to the PDT application as a "Client Service Manager" user
    When he searches the newly added policy for client Id in the "Add New Policy" page
    Then newly added Policy should be displayed in Policy drop down of "Add New Policy" page

  Scenario: Verify/Make Client BluePrint enabled in IRIS application

  Scenario: Add BluePrint setting for client in IRIS application
    Given he has selected "Corporation" module from "Welcome12C" window
    And he has queried corporation from "Corporation" module
    And he selects the "BluePrint Enabled" requirement from drop-down after clicking 'Add' button in the 'General Requirements' section of 'Requirements' tab
    When he clicks on the 'Save' button in the 'General Requirements' section of 'Requirements' tab
    Then message 'General Requirements have been saved' should be displayed

  Scenario: Validate 'Approve Policy' button is displayed as visible after submission of a policy from 'Policy benefit' page
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Home Leave" as Benefit Category on "Policy Benefit" page
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    When he clicks on the 'OK' button of success message "Policy saved and submitted" displayed on the "Policy Benefit" page
    Then 'Approve Policy' button should become visible
    And 'SAVE & SUBMIT' button should become disabled

  Scenario: Validate the UI of 'Approve Policy' pop-up displayed after clicking Approve Policy button on "Policy Benefit" page
    Given he is on the "Home Leave" Policy Benefit page
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    When he clicks on 'Approve Policy' button on Policy Benefit page
    Then below information should be displayed on 'Approve Policy' Pop-up
      | Heading   | Do you want to proceed with the approval of this policy?                                                                                                                                                          |
      | Message1  | You are approving version 1 of this policy. If approved, the policy state will change from Submitted to Active and indicates that you have reviewed the policy benefits and approve them for use.                 |
      | Message2  | There are currently 0 Assignments or Files associated with this version of the policy in IRIS. The following options are only effective for the client of this policy if Blueprint has been enabled in IRIS Corp: |
      | Checkbox1 | Associate this policy with an EXISTING authorization in IRIS? (Disabled)                                                                                                                                          |
      | Checkbox2 | Associate this policy with a NEW authorization in IRIS? (Enabled)                                                                                                                                                 |
      | Button1   | Approve/(disabled),  Cancel/(Enabled)                                                                                                                                                                             |

  Scenario: Verify 'Approve' button on 'Approve Policy' pop-up becomes enabled after selecting checkbox 'Associate this policy with a NEW authorization in IRIS' on Policy benefit page
    Given he is on the "Home Leave" Policy Benefit page
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    And he clicks on 'Approve Policy' button on Policy Benefit page
    When he selects the checkbox having label "Associate this policy with a NEW authorization in IRIS?" on 'Approve Policy' pop-up
    Then "Approve" button should become enabled on 'Approve Policy' pop-up

  Scenario: Verify that status of a 'Submitted' Policy changes to 'Active' after clicking 'Approve' button on 'Approve Policy' pop-up
    Given he is on the "Home Leave" Policy Benefit page
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    And he clicks on 'Approve Policy' button on Policy Benefit page
    And he selects the checkbox having label "Associate this policy with a NEW authorization in IRIS?" on 'Approve Policy' pop-up
    When he clicks on "Approve" button on 'Approve Policy' pop-up
    Then Version "V1" of Policy should be displayed on 'View/Edit Policy Forms' page with "Active" status
    Then below Status, Version should be displayed of Policy on 'View/Edit Policy Forms' page
      | Satus  | Version |
      | Active | V1      |

  Scenario: Verify that Policy Status of a 'Submitted' Policy should not change after clicking 'Cancel' button on 'Approve Policy' pop-up
    Given he is on the "Home Leave" Policy Benefit page
    And he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    And he clicks on 'Approve Policy' button on Policy Benefit page
    And he selects the checkbox having label "Associate this policy with a NEW authorization in IRIS?" on 'Approve Policy' pop-up
    When he clicks on "Cancel" button on 'Approve Policy' pop-up
    Then Status of Policy should remain 'Submitted' with Version 'V1' on Policy Benefit Page.
