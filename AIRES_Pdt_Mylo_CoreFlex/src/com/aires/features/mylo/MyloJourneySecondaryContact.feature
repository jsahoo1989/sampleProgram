Feature: Validate the functionality of Mylo Journey Secondary Contact section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Secondary Contact" section

  Background: Login to  Mylo application
    Given he selects "Query" option under "Journey" section available on left panel of Home Page after successfully logging into the 'Mylo' application

  @C218551 @C218570 @Mylo:C218612 @Mylo-Regression 
  Scenario: Mylo - Validate add secondary contact and change functionality on secondary contact section
    Given he is on Mylo Journey Summary page by clicking on "Create File" button on 'Create New File' popup after entering all mandatory fields
    And he adds below members in the 'Transferee and Family Details' Section after clicking on "Transferee and Family Dropdown arrow" displayed in the right panel
      | Member    | Relationship     |
      | Partner   | Domestic Partner |
      | Partner   | Spouse           |
      | Dependent | Parent           |
      | Dependent | Child            |
      | Other     | Other            |
    When he clicks on the "Select Secondary Contact" link displayed under the 'Secondary Contact' section after expanding the 'Primary Contact Details' section in the right panel
    Then clicking 'save' buttton on 'Please select a Secondary Contact' popup after selecting the above created members individually should display the contact in 'Secondary Contact' section
    And following warning message should be displayed after replacing the secondary contact with the primary contact upon clicking the 'change' button displayed under "Secondary Contact" section
      | Warning Message                                                                                                                              |
      | The contact selected is already designated as the Primary Contact on this file. A contact may not be both the Primary and Secondary Contact. |
    And clicking 'save' buttton after selecting a different member should change the contact in 'Secondary Contact' section

  @C218548 @C218555 @Mylo:C218613 @Mylo-Regression 
  Scenario: Mylo-Validate Removing Secondary Contact From a File under Secondary Contact module and the warning message when user tries to select primary contact as secondary contact in Mylo Journey File Information panel
    Given he is on Mylo Journey Summary page by clicking on "Create File" button on 'Create New File' popup after entering all mandatory fields
    And he adds below members in the 'Transferee and Family Details' Section after clicking on "Transferee and Family Dropdown arrow" displayed in the right panel
      | Member    | Relationship     |
      | Partner   | Domestic Partner |
      | Partner   | Spouse           |
      | Dependent | Parent           |
      | Dependent | Child            |
      | Other     | Other            |
    And he has clicked 'Save' button after selecting a member on 'Please select Secondary contat' popup in 'Secondary contact' section
    When he clicks on the 'remove' button on the secondary contact card under 'Secondary Contact' section
    Then the secondary contact should be removed from the file with the secondary contact section displaying as "+ Select Secondary Contact"
    And the removed contact should still be presented in the 'Transferee & Family' section
    And below "warning message" should appear upon clicking "save" button after selecting primary contact on 'Please select a Secondary Contact' popup displayed by clicking "Select Secondary Contact" link
      | Warning Message                                                                                                                              |
      | The contact selected is already designated as the Primary Contact on this file. A contact may not be both the Primary and Secondary Contact. |
    And he should be able to add the removed member again after selecting same member on 'Please select a Secondary Contact' popup

  @C218561 @Mylo:C218614 @Mylo-Regression 
  Scenario: Mylo-Validate if the contact information is updated in transferee and family section, the details are updated on Secondary contact
    Given he is on Mylo Journey Summary page by clicking on "Create File" button on 'Create New File' popup after entering all mandatory fields
    And he adds below members in the 'Transferee and Family Details' Section after clicking on "Transferee and Family Dropdown arrow" displayed in the right panel
      | Member    | Relationship     |
      | Partner   | Domestic Partner |
      | Partner   | Spouse           |
      | Dependent | Parent           |
      | Dependent | Child            |
      | Other     | Other            |
    And he has saved the 'partner' by clicking on 'change' button on secondary contact card under 'Secondary Contact' details section
    When he updates the below fields of the 'partner' in the 'Transferee and Family Section' after clicking on "Transferee and Family Dropdown arrow"
      | Fields       |
      | First Name   |
      | Last Name    |
      | Pronouns     |
      | Relationship |
      | Number       |
      | Email        |
    Then the updated information of the 'partner' should be displayed for the secondary contact in the secondary contact section
    And Secondary Contact section should be updated after updating the below fields of selected secondary contact on Transferee and Family members
      | Fields       |
      | First Name   |
      | Last Name    |
      | Pronouns     |
      | Relationship |
      | Number       |
      | Email        |

  @C218566 @C218567 @Mylo:C218720 @Mylo-Regression 
  Scenario: Mylo - Validate primary contact details and change functionality on primary contact section
    Given he is on Mylo Journey Summary page by clicking on "Create File" button on 'Create New File' popup after entering all mandatory fields
    And he adds below members in the 'Transferee and Family Details' Section after clicking on "Transferee and Family Dropdown arrow" displayed in the right panel
      | Member    | Relationship     |
      | Partner   | Domestic Partner |
      | Partner   | Spouse           |
      | Dependent | Parent           |
      | Dependent | Child            |
      | Other     | Other            |
    When he views the 'Primary Contact Details' section in the right panel
    Then the transferee created during file creation should be visible in the 'Primary Contact Details' section
    And upon clicking 'change' button on primary contact card should display 'Please select a Primary Contact' popup
    And clicking 'save' button on 'Please select a Primary Contact' popup after selecting the above created members individually should display the contact in 'Primary Contact' section

  @C218569 @Mylo:C218721 @Mylo-Regression 
  Scenario: Mylo - Validate Primary Contact Module Information Is Updated If the Contacts Information is Updated in The Transferee & Family Module
    Given he is on Mylo Journey Summary page by clicking on "Create File" button on 'Create New File' popup after entering all mandatory fields
    And he adds below members in the 'Transferee and Family Details' Section after clicking on "Transferee and Family Dropdown arrow" displayed in the right panel
      | Member    | Relationship     |
      | Partner   | Domestic Partner |
      | Partner   | Spouse           |
      | Dependent | Parent           |
      | Dependent | Child            |
      | Other     | Other            |
    And he has saved the 'partner' by clicking on 'change' button on primary contact card under 'Primary Contact' details section
    When he updates the below fields of the 'partner' in the 'Transferee and Family Section' after clicking on "Transferee and Family Dropdown arrow"
      | Fields       |
      | First Name   |
      | Last Name    |
      | Pronouns     |
      | Relationship |
      | Number       |
      | Email        |
    Then the updated information of the 'partner' should be displayed for the primary contact in the primary contact section
    And Primary Contact section should be updated after updating the below fields of selected primary contact on Transferee and Family members
      | Fields       |
      | First Name   |
      | Last Name    |
      | Pronouns     |
      | Relationship |
      | Number       |
      | Email        |
