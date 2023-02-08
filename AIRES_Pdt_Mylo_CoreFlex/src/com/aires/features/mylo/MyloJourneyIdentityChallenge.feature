Feature: Validate the functionality of Mylo Journey Identity Challenge section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Identity Challenge" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-1762 @217694 @217695 @217702 @Mylo:217716 @Mylo-Regression
Scenario:  Mylo-Validate Identity Challenge Question availability on Mylo Journey page
Given he is on Mylo Journey page for fileID with client having the "TRANSSCH_IDENTCHALLENGE" requirement
And "Identity Challenge Question" button is displayed on footer section for the file not in "CLSD" or "CNCL" status
When he clicks on "Save" button without making an entry in the Answer field after clicking on "Identity Challenge Question" button on Mylo Journey page
Then validation message "Answer is required." should be displayed on Mylo Journey page
And validation message "Tag Scripts are not allowed in Answer" should be displayed after he enter special characters in the Answer field of identity Challenge question on Mylo Journey page


@IRIS-1762 @217701 @217703 @217704 @217705 @217706 @Mylo:217717 @Mylo-Regression
Scenario:  Mylo-Validate Identity Challenge Question Answer Save Functionality on Mylo Journey page
Given he is on "Identity Challenge Question" section on "Mylo Journey page" for fileID with client having the "TRANSSCH_IDENTCHALLENGE" requirement
And answer entered is not saved by clicking on "Cancel" button after he made an entry in the Answer field
And answer entered is not saved by clicking on "Close" popup after he made an entry in the Answer field
When he clicks on "Save" button after entering more than "150" characters in the Answer field
Then answer should be successfully saved for that Identity Challenge Question with maximum "150" characters on Mylo Journey page
And existing Identity Challenge Question should be displayed with editable answer field