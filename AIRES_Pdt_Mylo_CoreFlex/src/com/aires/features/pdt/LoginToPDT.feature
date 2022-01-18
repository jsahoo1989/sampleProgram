Feature: Login to Policy App Application
  I want to test the login functionality of Policy App application

  @login
  Scenario: PDT - Login to Policy Digitization Application
    Given he is on Policy App login page
    And he enters below login credentials in Username, Password fields
      | userName | password |
      | AKARNS   | AKARNS   |
    When he clicks on Login button
    Then he should be redirected to "ViewPolicy" page
    And below userName should be displayed on "ViewPolicy" page
      | userName |
      | AKARNS   |

  @pdtLogin @PDT-Regression
  Scenario Outline: PDT - Login to Policy Digitization Application
    Given he is on Policy App login page
    And he enters "<userName>" and "<password>" in username and password field
    When he clicks on Login button
    Then he should be redirected to "ViewPolicy" page
    And below "<userName>" should be displayed on "ViewPolicy" page

    Examples: 
      | userName | password |
      | kbrian   | kbrian   |
      | akarns   | akarns   |
      | spant    | spant    |
      
 @viewPolicyList @PDT-Regression
  Scenario: PDT - View Policy List after login
    Given he is on Policy App login page
    And he enters below login credentials in Username, Password fields
      | userName | password |
      | AKARNS   | AKARNS   |
    When he clicks on Login button
    Then Policies should be displayed on "ViewPolicy" page