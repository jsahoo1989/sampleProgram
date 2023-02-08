Feature: Validate the functionality of Mylo Link/Mobility Journey Section
  I want to test the functionality of Mylo Link/Mobility Journey Section

  @MYLO2-258 @218575 @218578
  Scenario: MX_Mylo-Validate "link/Mobility Journey" popup not appearing on Mylo application for files with different Transferee Name created on MobilityX & Mylo application
    Given he has submitted a new Authorization for a newly created file with different transferee name on MobilityX application
    And "link/Mobility Journey" popup is not displayed after he searched the same file on MYLO application logged in with user type "With Resource100008"
    When he tries to search newly created file on MYLO application with different transferee name
    Then he should be navigated to mylo journey summary page with "link/Mobility Journey" popup not being displayed
    
  @MYLO2-258 @218574 @218576
  Scenario: MX_Mylo-Validate "link/Mobility Journey" popup & "Files Attached to this Transferee" behavior on Mylo application with different UserTypes for existing Transferee Name files created on MobilityX application
    Given he has submitted a new Authorization for a newly created file with existing transferee name on MobilityX application
    And "link/Mobility Journey" popup is displayed with below fields after he searched the same file on MYLO application logged in for user type "With Resource100008"
      | Transferee Name | Employee ID | Email Address | Booked | File ID | Client Name | Origin | Destination |
    And he should be able to see below information after clicking on "Files Attached to this Transferee" dropdown
      | Booked date | File ID | Client Name | Origin | Destination |
    When he tries to search same file on Mylo application after relogin with user type "Without Resource100008"
    Then "link/Mobility Journey" popup should not appear for userType "Without Resource100008" on Mylo application
    And he should be navigated to the Mylo journey summary page of the searched file

  @MYLO2-312 @218577 @218580 @218586
  Scenario: Mylo-Validate "Remind Me Later" & "Send Login Credentials" behavior on "link/Mobility Journey" popup displayed for same transferee Name files created on Mylo application
    Given he has created a new file with existing transferee name on Mylo application logged in with user type "With Resource100008"
    When he clicks on "Remind Me Later" after verifying the "link/Mobility Journey" popup displayed with below fields
      | Transferee Name | Employee ID | Email Address | Booked | File ID | Client Name | Origin | Destination |
    Then he should be navigated to mylo journey summary page with "link/Mobility Journey" pop up being closed
    And "link/Mobility Journey" popup should be displayed after he clicks on "Send Login Credentials" button on Mylo journey summary page
    And he should be navigated to mylo journey summary page with "link/Mobility Journey" popup not being displayed after he searched the same file on MYLO application logged in with user type "Without Resource100008"

  @MYLO2-312 @218583 @218584 @218585 @218579
  Scenario: Mylo- Validate "Same Person, Link to Existing Journey" behavior on "link/Mobility Journey" on Mylo application
    Given he is on "link/Mobility Journey" popup for an existing file with same transferee name on Mylo application logged in with user type "With Resource100008"
    And "Select the Journey to Which This File Should be Added" pop up is displayed after he clicks on "Same Person, Link to Existing Journey" button on "link/Mobility Journey" popup
    And file is not linked to that journey with "link/Mobility Journey" popup being closed after he clicks on "Cancel" button
    When he clicks on "Link" button after clicking on "Same Person, Link to Existing Journey" button on "link/Mobility Journey" popup while searching the same file again
    Then file should be successfully linked to existing journey with "Journey Selection" pop up being closed
    And file should be successfully linked as a new journey after clicking on "Same person, Link as a New Journey" button on "link/Mobility Journey" popup for newly created file with existing transferee name

  @MYLO2-312 @218587 @218588 @218581 @218582
  Scenario: MX_Mylo- Validate "link/Mobility Journey" popup & "Different person, do not wish to link" behavior appearing on Mylo application for files with same email created on MobilityX & Mylo application
    Given he has submitted a new Authorization for a newly created file with same email on MobilityX application
    And "link/Mobility Journey" popup is displayed for same email after he searched the same file on MYLO application logged in with user type "With Resource100008"
    When he tries to search newly created file on Mylo application with same email
    Then "link/Mobility Journey" popup should get displayed with header as "We found transferees with the same name, employee ID, or primary email address (highlighted in red). Is this the same person?"
    And file should not be successfully linked to that journey on clicking "Different Person, Do Not Link" on "link/Mobility Journey" popup
