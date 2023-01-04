Feature: Validate the functionality of Mylo Transferee Name Query
  I want to test the functionlity of Mylo Transferee Name Query

  Background: Navigate to Query section after successfully logging into the Mylo application
    Given he selects "Query" option under "Journey" section available on left panel of Home Page after successfully logging into the 'Mylo' application

  @MYLO2-157 @218528 @218529 @218530 @Mylo:218539 @Mylo-Regression
  Scenario: Mylo-Validate Search Results for valid inputs of different fields on Query By Transferee Name section
    Given he is on "Query By Transferee's Name" popup by selecting "Transferee Name" option available on "Query PopUp" section
    Then related files should get appear into the query result modal as per below inputs after clicking on "Execute" button of Query By Transferee Name section
      | First Name | Last Name  |
      | automation |            |
      |            | automation |
      | automation | automation |

  @MYLO2-157 @218531 @218532 @218533 @218535 @Mylo:218540 @Mylo-Regression
  Scenario: Mylo-Validate Search Results for invalid inputs of different fields on Query By Transferee Name section
    Given he is on "Query By Transferee's Name" popup by selecting "Transferee Name" option available on "Query PopUp" section
    Then "No such file found" popup message should be displayed after clicking on "Execute" button for all "Query By Transferee Name" field values which is not in the system
      | First Name | Last Name |
      |     Random |           |
      |            |    Random |
      |    	Random |    Random |
    And query popup should get closed after clicking on "Close" icon on 'Query By Transferee Name' section

  @MYLO2-157 @218534 @218536 @Mylo:218541 @Mylo-Regression
  Scenario: Mylo-Validate Execute button status & Cancel button functionality on Mylo Query By Transferee Name section
    Given he is on "Query By Transferee's Name" popup by selecting "Transferee Name" option available on "Query PopUp" section
    When he views "Query By Transferee's Name" section on journey page
    Then "Execute" button should be disabled on 'Query By Transferee Name' section
    And query popup should get closed after clicking on "Cancel" button on 'Query By Transferee Name' section

  @MYLO2-157 @218537 @Mylo:218542 @Mylo-Regression
  Scenario: Mylo-Validate Tag Script Validation Messages for mentioned fields of Query By Transferee Name section
    Given he is on "Query By Transferee's Name" popup by selecting "Transferee Name" option available on "Query PopUp" section
    Then tag script messages should be displayed for entering 'specialCharacters' on below fields after clicking on "Execute" button on 'Query By Transferee Name' section
      | Field Name | Message                                   |
      | First Name | Tag Scripts are not allowed in first name |
      | Last Name  | Tag Scripts are not allowed in last name  |

  @MYLO2-157 @218538 @Mylo:218543 @Mylo-Regression
  Scenario: Mylo-Validate Boundary Conditions of Character Limit for different fields of Query By Transferee Name section
    Given he is on "Query By Transferee's Name" popup by selecting "Transferee Name" option available on "Query PopUp" section
    When he enters data beyond character limit for different fields under 'Query By Transferee Name' section
    Then values should be successfully entered as per character limit set for below fields under 'Query By Transferee Name' section
      | Field Name |CharacterLimit|
      | First Name |30            |
      | Last Name  |60            |
