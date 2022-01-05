Feature: Login to Mylo Application
  I want to test the login functionlity of Mylo applcation

  @MyloLogin @Mylo-Regression
  Scenario Outline: Login to Mylo Application
    Given he is on the Mylo login page
    And he has entered "<userEmail>" and "<password>" in username and password field
    When he clicks on Sign in button
    Then he should successfuly redirected onto the Dashboard home page of Mylo Application with "<userName>" getting displayed
    Examples: 
      | userEmail                | password            | userName |
      | mxssodev5@corp.aires.com | AiresDevSSOTest$    |  mxsso!  |