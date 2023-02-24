Feature: Validate the functionality of Mylo Journey Primary and Secondary Contact section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Primary and Secondary Contact" section

  Background: Login to  Mylo application
    Given he is on Home Page after successfully logging into the 'Mylo' application

  @C218551 @C218570 @C218566 @C218567 @Mylo:218720 @Mylo:218612 @Mylo-Regression
  Scenario: Mylo - Validate transferee and family members are displayed under Primary and Secondary contact popup
    Given Transferee name is displayed as a primary contact for a newly created file on Journey Summary page
    And he adds below members in the 'Transferee and Family Details' section after clicking on 'Transferee and Family Drop down arrow' displayed in the right panel
      | Member    | Relationship     |
      | Partner   | Domestic Partner |
      | Partner   | Spouse           |
      | Dependent | Parent           |
      | Dependent | Child            |
      | Other     | Other            |
    When he clicks on change button available under primary contact section on journey summary page
    Then all the added transferee and family members should be displayed on 'Please select a Primary Contact' popup
    And all the added transferee and family members should be displayed on 'Please select a Secondary Contact' popup after clicking on "Select Secondary Contact" link displayed under the 'Secondary Contact' section

   @C218569 @Mylo:218721 @C218561 @Mylo:218614 @Mylo-Regression
  Scenario: Mylo-Validate primary , secondary contact is updated on updating the selected contact in transferee and family section
    Given he is on Mylo Journey Summary page for an existing file with all transferee and family members
    Then selected contact should be updated after updating the below fields on selecting all the transferee and family members successively for both primary and secondary contact section
      | Fields       |
      | First Name   | 
      | Last Name    | 
      | Pronoun      |
      | Relationships|
      | Number       |
      | Email        |

@C218548 @C218555 @Mylo:218613 @Mylo-Regression
  Scenario: Mylo - Validate error message for same primary  and secondary contact along with remove funcationality of secondary contact
    Given he is on Mylo Journey Summary page for an existing file with all transferee and family members
    When he selects same contact on "Please Select Secondary Contact" popup which is already selected on primary contact Section 
    Then warning message should appear after clicking save button on "Please Select Secondary Contact" popup
    And warning message should appear if he tries to select same contact on "Please Select Primary Contact" popup which is already selected on primary secondary Section
    And he should be able to remove the secondary contact by clicking remove on Secondary Contact Card
    