Feature: Validate the functionality of Mylo Journey Send Login Credentials section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Send Login Credentials" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application

@IRIS-1792 @217692 @Mylo:217940 @Mylo-Regression
Scenario:  Mylo-Validate Mandatory Answer for Identity Challenge Question for Send Login Credential on Mylo Journey page
Given he is on Mylo Journey page for fileID with "TRANSSCH_IDENTCHALLENGE" requirement
When he clicks on the "Send Login Credentials" button
Then pop up "Please contact the transferee to complete the Identity Verification question in the Transferee Tab under Identity Verification. Login credentials cannot be sent until this is completed." should be displayed on MyloJourney page

@IRIS-1792 @217707 @217708 @Mylo:217941 @Mylo-Regression 
Scenario:  Mylo-Validate Identity Verification PopUp and Mandatory Transferee EmailId for Send Login Credential on Mylo Journey page
Given he is on Mylo Journey page for fileID with "TRANSSCH_withoutEmail" requirement without valid email for the transferee
When he clicks on the "Send Login Credentials" button after answering the Identity Challenge Question
Then "Identity Verification" popup should be displayed containing the Identity Challenge Question Answer
And popup "Login credentials cannot be sent to the transferee until you add a valid email address in the record." should be displayed after he clicks on "Yes" button

@IRIS-1792 @217708 @Mylo:217942 @Mylo-Regression
Scenario:  Mylo-Validate Mandatory actualization of Transferee for Send Login Credential on Mylo Journey page
Given he is on Mylo Journey page for fileID with "TRANSSCH" requirement having valid email for the transferee
And he clicks on the "Send Login Credentials" button after answering the Identity Challenge Question
When he clicks on "Yes" button after verifying the "Identity Verification" popup
Then popup "Please actualize either Make first contact with transferee or Perform needs assessment with transferee activity." should be displayed on Mylo Journey page

@IRIS-1792 @217712 @217714 @Mylo:217943 @Mylo-Regression
Scenario:  Mylo-Validate Duplicate Transferee Email popup for Send Login Credential on Mylo Journey page
Given he is on Mylo Journey page for fileID with "TRANSSCH_duplicateEmailActualizedTransferee" requirement having valid previously used email for the actualized transferee
And he clicks on the "Send Login Credentials" button after answering the Identity Challenge Question
When he clicks on "Yes" button after verifying the "Identity Verification" popup
Then popup should display prompting the user that email has been already used
And popup should be closed after clicking on "Yes" button

@IRIS-1792 @Mylo:217944 @Mylo-Regression
Scenario:  Mylo-Validate Login Credentials popup for Send Login Credential on Mylo Journey page
Given he is on Mylo Journey page for fileID with "TRANSSCH_uniqueEmailActualizedTransferee" requirement having valid previously used email for the actualized transferee
And he clicks on the "Send Login Credentials" button after answering the Identity Challenge Question
When he clicks on "Yes" button after verifying the "Identity Verification" popup
Then popup message "You are about to email the transferee his/her username. Would you also like to reset his/her password?" should be displayed on Mylo Journey page
And popup should be closed after clicking on "Cancel" button

@IRIS-1792 @217715 @Mylo:217961 @Mylo-Regression
Scenario:  Mylo-Validate Login Credentials sent to the email of transferee using Send Login Credentials section on Mylo Journey page
Given he is in Login Credentials popup to send username and password for fileID with "TRANSSCH_ActualizedTransferee" requirement
And he clicks on "Yes" button after verifying the "Identity Verification" popup
When he clicks on "Yes" button after verifying the "Login credentials were already sent to this transferee. Do you want to resend the login credentials?" popup on Mylo Journey page
Then popup message "You are about to email the transferee his/her username. Would you also like to reset his/her password?" should be displayed on Mylo Journey page
And login credentials should be sent to the email selected after clicking on "Send UserName Password" button

@IRIS-1834  @Mylo-Regression
Scenario:  Mylo-Validate SSO enabled for Transferee users of Send Login Credential on Mylo Journey page
Given he is on Mylo Journey page for fileID with "CLIENT_TRANSFEREE_SSOENABLED" requirement which has already received SSO email
When he clicks on the "Send Login Credentials" button
Then pop up "This client is Single Sign On enabled for transferee users.Please advise the user to contact their IT team for password reset." should be displayed on MyloJourney page

@IRIS-1834  @Mylo-Regression
Scenario:  Mylo-Validate Login Credentials sent to the selected email out of Multiple emails for Send Login Credential on Mylo Journey page
Given he is on Mylo Journey page for fileID with "TRANSFEREE_WITH_MULTIPLE_EMAIL" of actualized transferee having multiple emails
And popup "Please select the email address to which login credentials should be sent:" is displayed after clicking on "Send Login Credentials" button
When he clicks on "Submit" button after selecting any email address from the popup
Then popup "Login credentials were already sent to this transferee. Do you want to resend the login credentials?" should be displayed on Mylo Journey page for resending the login credentials
And login credentials should be sent to the email selected after clicking on "Yes"
And login credentials should not be sent to the email selected after clicking on "Cancel"

@IRIS-1834  @Mylo-Regression
Scenario:  Mylo-Validate Transferee File Link for Send Login Credential on Mylo Journey page
Given he is on Mylo Journey page for fileID with "TRANSFEREE_FILELINK" that matches another file in Mylo
When he clicks on the "Send Login Credentials" button
Then File Linking Window should appear with existing transferee details along with Data Integrity Alert messages
And "Same person, Link as a New Journey","Same Person, Link to Existing Journey" buttons should be enabled after selecting the transferee displayed