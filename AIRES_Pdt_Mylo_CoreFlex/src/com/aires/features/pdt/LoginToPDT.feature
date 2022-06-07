@login
Feature: Login to Policy App Application
  I want to test the login functionality of Policy App application

  Scenario: PDT - Login to Policy Digitization Application
    Given he is on Policy App login page
    And he enters below login credentials in userEmail, password fields
      | userEmail                | password      |
      | mxssodev5@corp.aires.com | F74#jd*187_NB |
    When he clicks on Login button
    Then he should be redirected to "ViewPolicy" page
    And below userName should be displayed on "ViewPolicy" page
      | userName   |
      | mxsso dev5 |

  @PDT-Regression
  Scenario Outline: PDT - Login to Policy Digitization Application
    Given he is on Policy App login page
    And he enters "<userEmail>" and "<password>" in username and password field
    When he clicks on Login button
    Then he should be redirected to "ViewPolicy" page
    And below "<userName>" should be displayed on "ViewPolicy" page

    Examples: 
      | userEmail                | password      | userName   | userStatus |
      | mxssodev5@corp.aires.com | F74#jd*187_NB | mxsso dev5 |    valid user        |
 
  @PDT-Regression
  Scenario: PDT - View Policy List after login
    Given he is on Policy App login page
    And he enters below login credentials in userEmail, password fields
      | userEmail                | password      |
      | mxssodev5@corp.aires.com | F74#jd*187_NB |
    When he clicks on Login button
    Then Policies should be displayed on "ViewPolicy" page
