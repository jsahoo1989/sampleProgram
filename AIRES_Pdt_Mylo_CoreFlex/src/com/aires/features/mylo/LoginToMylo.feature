Feature: Login to Mylo Application
  I want to test the login functionlity of Mylo applcation

  @IRIS-1733 @MyloLogin @Mylo:217536 @Mylo-Regression
  Scenario Outline: Login to Mylo Application
    Given he is on the Mylo login page
    And he has entered "<userEmail>" and "<password>" in username and password field
    When he clicks on Sign in button
    Then he should successfuly redirected onto the Dashboard home page of Mylo Application with "<userName>" getting displayed
    Examples: 
      | userEmail                | password            | userName   |
      | mxssodev5@corp.aires.com |  F74#jd*187_NB      |  mxsso!    |
      
  @IRIS-1733 @247665 @217688 @217689 @217691 @Mylo:217700 @Mylo-Regression
  Scenario: Validate Error messages for Different UserName and Password on Mylo Login page
    Given he is on the Mylo login page
		Then messages corresponding to different usernames mentioned below should be displayed on Mylo login page
		|Category                          | User Email          | Message                                                                                        |
    |Invalid emailaddress              | adfg@               | Enter a valid email address, phone number, or Skype name.                                      |
    |Invalid UserName                  | ghgj                | We couldn't find an account with that username.                                               |
    |ValidEmail with Incorrect userName|cfrtf@corp.aires.com |This username may be incorrect. Make sure you typed it correctly. Otherwise, contact your admin.|
    And messages corresponding to different combination of username password mentioned below should be displayed on Mylo login page 
    |Category                             | User Email               | password | Message   |
    |Valid userName with IncorrectPassword| mxssodev5@corp.aires.com |  fhjgh   | Your account or password is incorrect. If you don't remember your password, reset it now.|