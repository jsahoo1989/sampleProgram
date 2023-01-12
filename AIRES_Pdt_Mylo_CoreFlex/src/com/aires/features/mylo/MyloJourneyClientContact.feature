Feature: Validate the functionality of Mylo Client Contact Section
  I want to test the functionality of Mylo Client Contact Section

  Background: Login to  Mylo application with mentioned User Type
    Given he has logged into the 'Mylo' application with user type "With Resource300096"

  @MYLO2-183 @218553 @218554 @Mylo:218606 @Mylo-Regression
  Scenario: Mylo-Validate Add,Edit and Delete button status of Client Contact section on Mylo Journey Summary Page with different UserTypes
    Given he is on "Client Contact" section for "Active" file having "Client Contact" information on Mylo Journey Summary Page
    And "Add","Edit","Delete" buttons of Client Contact section should be enabled for user type "With Resource300096"
    When he views "Client Contact" section for the same file after relogin with user type "Without Resource300096"
    Then "Add","Edit","Delete" buttons of Client Contact section should be disabled for user type "Without Resource300096"

  @MYLO2-183 @218556 @218557 @Mylo:218607 @Mylo-Regression
  Scenario: Mylo-Validate Add,Edit and Delete buttons status of Client Contact section on Mylo Journey Summary Page with different File Types
    Given he is on "Client Contact" section for "Closed" file having "Client Contact" information on Mylo Journey Summary Page
    And "Add","Edit","Delete" buttons of Client Contact section should be disabled for "Closed" file
    When he views "Client Contact" section for "Canceled" file having "Client Contact" information on Mylo Journey Summary Page
    Then "Add","Edit","Delete" buttons of Client Contact section should be disabled for "Canceled" file

  @MYLO2-183 @218559 @218563 @218564 @Mylo:218608 @Mylo-Regression
  Scenario: Mylo-Verify all(Tag Script,Mandatory & Email Field) Toast Messages validation for mentioned fields under Client Contact section
    Given he clicks on "Add Client Contact" link available under "Client Contact" section on Mylo Journey Summary page for an existing "Active" file
    Then toast message should be displayed on clicking "Save" button after entering below field values under "Add Client Contact" section
      | First Name | Last Name | Email | Message                         |
      | Random     | Random    | test  | Email address (test) is invalid |
      |            | Random    |       | First name is required.         |
      | Random     |           |       | Last name is required.          |
    And tag script toast message should be displayed for entering 'specialCharacters' on below fields after clicking on "Save" button under 'Add Client Contact' section
      | Field Name              | Message                                       |
      | First Name              | Tag Scripts are not allowed in first name     |
      | Last Name               | Tag Scripts are not allowed in last name      |
      | Phonetic/Preferred Name | Tag Scripts are not allowed in preferred name |
      | Comment                 | Tag Scripts are not allowed in comment        |

  @MYLO2-183 @218558 @Mylo:218609 @Mylo-Regression
  Scenario: Mylo-Validate Boundary Conditions of Character/Number Limit set for different fields under Client Contact section
    Given he clicks on "Add Client Contact" link available under "Client Contact" section on Mylo Journey Summary page for an existing "Active" file
    When he enters data beyond character limit for different fields under 'Add Client Contact' section
    Then values should be successfully restricted as per character limit set for below fields under "Add Client Contact" section
      | Field Name              | CharacterLimit |
      | First Name              |             30 |
      | Last Name               |             60 |
      | Phonetic/Preferred Name |             60 |
      | Email                   |            100 |
      | Phone Number            |             30 |
      | Comment                 |            500 |

  @MYLO2-183 @218549 @218560 @Mylo:218610 @Mylo-Regression
  Scenario: Mylo-Validate Save & Update functionality for Client Contact Section on Mylo Journey Summary Page
    Given he clicks on "Add Client Contact" link under Client Contact section on Mylo Journey Summary page for a newly created file
    When he clicks on "Save" button after entering all random field values under 'Add Client Contact' section
    Then all below fields should be successfully saved under 'Client Contact' section
      | Field Name              |
      | First Name              |
      | Last Name               |
      | Pronouns                |
      | Phonetic/Preferred Name |
      | Email                   |
      | Phone Number            |
      | Comment                 |
      | Start Date              |
      | Updated Date            |
      | Updated By              |
    And all below fields should be updated successfully on clicking "Save" button after updating all the field with random values in "Edit" mode
      | Field Name              |
      | First Name              |
      | Last Name               |
      | Pronouns                |
      | Phonetic/Preferred Name |
      | Email                   |
      | Phone Number            |
      | Comment                 |
      | Start Date              |
      | Updated Date            |
      | Updated By              |

  @MYLO2-183 @218562 @218565 @218571 @218572 @218573 @Mylo:218611 @Mylo-Regression
  Scenario: Mylo-Validate Multiple Client Contact Card Addition & Delete functionality for Client Contact section on Mylo Journey Summary Page
    Given he is on "Client Contact" section for "Active" file having "Client Contact" information on Mylo Journey Summary Page
    And new Client Contact card should be displayed under "Client Contact" section by clicking on "Save" button after adding another Client Contact card
    When he clicks on "Delete" button on newly added Client Contact card on "Client Contact" section
    Then pop up message "You are about to delete this Client Contact. Are you sure you want to proceed?" should be displayed on Mylo Journey Summary Page  
    And addded client contact card should not be deleted from "Client Contact" section by clicking on "No" or "Close" button in pop up section
    And added client contact should be successfully deleted by clicking "Yes" button after clicking on "Delete" icon on client contact card
