Feature: Validate the functionality of Mylo Link/Mobility Journey Section
  I want to test the functionality of Mylo Link/Mobility Journey Section

  @MYLO2-258 @218574 @218576 @Mylo-Regression
  Scenario: Mylo-Validate "link/Mobility Journey" popup on Mylo application with different UserTypes for same Transferee Name files created on MobilityX application
    Given he has submitted a new Authorization for a newly created file with existing transferee name on MobilityX application
    And "link/Mobility Journey" popup is displayed with header as "We found transferees with the same name, employee ID, or primary email address (highlighted in red). Is this the same person?" after he searched the same file on MYLO application logged in with user type "With Resource100008"
    When he tries to search same file on Mylo application after relogin with user type "Without Resource100008"
    Then "link/Mobility Journey" popup should not appear for userType "Without Resource100008" on Mylo application
    And he should be navigated to the Mylo journey summary page of the searched file

  @MYLO2-258 @218577 @218580 @218586 @Mylo-Regression
  Scenario: Mylo-Validate "link/Mobility Journey" popup displayed for same transferee Name files created on Mylo application and "Remind Me Later", "Send Login Credentials" button behavior on "link/Mobility Journey" popup
    Given he has created a new file with existing transferee name on Mylo application logged in with user type "With Resource100008"
    And "link/Mobility Journey" popup is displayed with header as "We found transferees with the same name, employee ID, or primary email address (highlighted in red). Is this the same person?"
    When he clicks on "Remind Me Later" on "link/Mobility Journey" popup after searching the same file
    Then he should be navigated to mylo journey summary page with "link/Mobility Journey" pop up being closed
    And "link/Mobility Journey" popup should be displayed after he clicks on "Send Login Credentials" button on Mylo journey summary page
    And he should be navigated to mylo journey summary page with "link/Mobility Journey" popup not being displayed after he searched the same file on MYLO application logged in with user type "Without Resource100008"

  @MYLO2-258 @218575 @218578 @Mylo-Regression
  Scenario: Mylo-Validate "link/Mobility Journey" popup not appearing on Mylo application for files with different Transferee Name created on MobilityX & Mylo application
    Given he has submitted a new Authorization for a newly created file with different transferee name on MobilityX application
    And "link/Mobility Journey" popup is not displayed after he searched the same file on MYLO application logged in with user type "With Resource100008"
    When he tries to search newly created file on MYLO application with different transferee name
    Then he should be navigated to mylo journey summary page with "link/Mobility Journey" popup not being displayed

  @MYLO2-258 @218583 @218584 @218585 @Mylo-Regression
  Scenario: Mylo-Validate "Same Person, Link as existing journey" behavior on "link/Mobility Journey" on Mylo application
    Given he has created a new file with existing transferee name on Mylo application logged in with user type "With Resource100008"
    And "Select the Journey to Which This File Should be Added" pop up is displayed after he clicks on "Same Person, Link as existing journey" button on "link/Mobility Journey" popup
    And file is not linked to that journe with "link/Mobility Journey" popup being closed after he clicks on "Cancel" button
    When he clicks on "Link" button after clicking on "Same Person, Link as existing journey" button on "link/Mobility Journey" popup while searching the same file again
    Then he should be navigated to mylo journey summary page with "Journey Selection" pop up being closed
    And file should be successfully linked to that journey

  @MYLO2-258 @218587 @218588 @218582 @Mylo-Regression
  Scenario: Mylo-Validate "link/Mobility Journey" popup appearing on Mylo application for files with same email created on MobilityX & Mylo application & "Files Attached to this Transferee" behavior on "link/Mobility Journey" popup
    Given he has submitted a new Authorization for a newly created file with same email on MobilityX application
    And "link/Mobility Journey" popup is displayed with header as "We found transferees with the same name, employee ID, or primary email address (highlighted in red). Is this the same person?" after he searched the same file on MYLO application logged in with user type "With Resource100008"
    When he tries to search newly created file on Mylo application with same email
    Then "link/Mobility Journey" popup should get displayed with header as "We found transferees with the same name, employee ID, or primary email address (highlighted in red). Is this the same person?"
    And he should be able to see below information after clicking on "Files Attached to this Transferee" dropdown
      | Booked date | File ID | Client Name | Origin | Destination |

  @MYLO2-258 @218579 @218581 @Mylo-Regression
  Scenario: Mylo-Validate "link/Mobility Journey" popup appearing on Mylo application for files with same email created on MobilityX & Mylo application & "Files Attached to this Transferee" behavior on "link/Mobility Journey" popup
    Given he has created a new file with existing transferee name on Mylo application logged in with user type "With Resource100008"
    And file is linked as new journey after clicking on "Same Person, Link As A New Journey" button on "link/Mobility Journey" popup
    When he clicks on "Different person, do not wish to link" on "link/Mobility Journey" popup for a newly created file on Mylo application with same transferee name
    Then he should be navigated to mylo journey summary page with "link/Mobility Journey" pop up being closed
    And file should not be successfully linked to that journey
