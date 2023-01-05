Feature: Validate the functionality of Mylo Journey Secondary Contact section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Secondary Contact" section

  Background: Login to  Mylo application
    Given he selects "New File" option under "Journey" section available on left panel of Home Page after successfully logging into the 'Mylo' application

  @C218551 @C218555 @Mylo-Regression
  Scenario: Mylo-Validate the warning if primary contact is added as Secondary Contact and other Transferee as secondary contact to a file in Mylo Journey File Information panel
    Given he is on Mylo Journey Summary page after entering all the mandatory fields on 'Create New File' popup and clicking on "Create File" button
    And he adds below members in the Tranferee and Family Details Sections after clicking on "Transferee and Family Dropdown arrow" displayed in the right panel
      | Member    | Relationship     |
      | Partner   | Domestic Partner |
      | Partner   | Spouse           |
      | Dependent | Parent           |
      | Dependent | Child            |
      | Other     | Other            |
    When he clicks the "Select Secondary Contact" link in the 'Secondary Contact' module after clicking 'Primary Contact Details' dropdown arrow displayed in the right panel
    Then below "warning message" should appear if he tries to select primary contact and click "save" button on 'Please select a Secondary Contact' popup
      | Warning Message                                                                                                                              |
      | The contact selected is already designated as the Primary Contact on this file. A contact may not be both the Primary and Secondary Contact. |
    And he should be able to select above created "Members" individually and clicking save buttton should display the contact in 'Secondary Contact' section

  @C218548 @Mylo-Regression
  Scenario: Mylo-Validate Removing Secondary Contact From a File under Secondary Contact module in Mylo Journey File Information panel
    Given he is on Mylo Journey Summary page after entering all the mandatory fields on 'Create New File' popup and clicking on "Create File" button
    And he adds members in the Tranferee and Family Details Sections after clicking on "Transferee and Family Dropdown arrow" displayed in the right panel
    And he has selected and saved a memeber by clicking on "Select Secondary Contact" link under Secondary Contact Section that is displayed by clicking Primary contact details drop down arrow
    When he clicks on the "remove" button on the secondary contact card under "Secondary Contact" section
    Then the secondary contact should be removed from the file and the secondary contact section should display "+ Select Secondary Contact"
    And the removed contact should still be presented in the 'Transferee & Family' section
    And he should be able to add the removed member again by clicking on "Select Secondary Contact" link under 'Secondary Contact' section

  @C218570 @Mylo-Regression
  Scenario: Mylo-Validate Changing Secondary Contact On a File from Secondary Contact Section in Mylo Journey File Information panel
    Given he is on Mylo Journey Summary page after entering all the mandatory fields on 'Create New File' popup and clicking on "Create File" button
    And he adds members in the Tranferee and Family Details Sections after clicking on "Transferee and Family Dropdown arrow" displayed in the right panel
    And he has selected and saved the memeber by clicking on "Select Secondary Contact" link under Secondary Contact Section that is displayed by clicking Primary contact details drop down arrow
    When he clicks on the "change" button on the secondary contact card under "Secondary Contact" section
    Then below "warning message" should appear if he tries to select primary contact and click "save" button on 'Please select a Secondary Contact' popup
      | Warning Message                                                                                                                              |
      | The contact selected is already designated as the Primary Contact on this file. A contact may not be both the Primary and Secondary Contact. |
    And selecting a different member on 'Please select a Secondary Contact' popup and clicking 'save' button should update the contact on the 'Secondary Contact' section

  @C218561 @Mylo-Regression
  Scenario: Mylo-Validate if the contact information is updated in transferee and family section, the details are updated on Secondary contact
    Given he is on Mylo Journey Summary page after entering all the mandatory fields on 'Create New File' popup and clicking on "Create File" button
    And he adds members in the Tranferee and Family Details Sections after clicking on "Transferee and Family Dropdown arrow" displayed in the right panel
    And he has selected and saved the memeber by clicking on "Select Secondary Contact" link under Secondary Contact Section that is displayed by clicking Primary contact details drop down arrow
    When he updates the below fields of the selected secondary contact information in the Transferee & Family Section
      | Fields       |
      | First Name   |
      | Last Name    |
      | Pronouns     |
      | Relationship |
      | Number       |
      | Email        |
    Then the updated information should be displayed for the secondary contact in the secondary contact section
