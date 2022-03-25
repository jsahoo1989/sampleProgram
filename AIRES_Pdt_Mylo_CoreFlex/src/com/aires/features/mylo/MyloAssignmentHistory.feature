Feature: Validate the functionality of Mylo Assignment History section
  As a Mylo user, I want to validate the functionality for "Mylo Assignment - History" section

Background: Login to the Mylo application
    Given he has logged into the 'Mylo' application
   
@IRIS-9921 @Mylo-Regression @214504 @214508 @214510
Scenario:  Mylo-Validate History Card appearing for Searching Multiple FileIds on Mylo Assignment page in the current session
Given he is on Mylo Assignment Summary page for file ID "482350" 
When he queries another file for file ID "611085"
Then the prior file info should be displayed in the history card at the top of the page with the following data:
|Transferee Name|FileId & Client Name   |Origin & Destination Address|
|Virginia Woolf |482350 (MobilityX Inc.)|test, CA to test, AL        |
And the history card should continue to display after he refreshes the current session
And the history card should no longer display at the top of the page after he clicks on X 

@IRIS-992 @Mylo-Regression @214505 @214511 @214512
Scenario:  Mylo-Validate History Card appearing in the History dropdown with 3 History Card displaying in the History section on Mylo Assignment page in the current session
Given he is on Mylo Assignment Summary page with 4 recent files 
And 3 history cards is displayed at the top of the page ordered from left to right, left being the most recent
When he queries another file for file ID "611085" 
Then 3 most recent assignment history cards should display at the top of the page with 1 card available in the dropdown of History card for 5 recent files
And the least recent file history card should be displayed in the dropdown after he clicks on History card
And the history cards should no longer display at the top of the page after he relogins with same user

@IRIS-992 @Mylo-Regression @214506
Scenario:  Mylo-Validate maximum 17 History Card appearing in the History dropdown and last file being removed upon addition of 1 History Card in the History section on Mylo Assignment page in the current session
Given he is on Mylo Assignment Summary page with 21 recent files 
And 3 most recent assignment history cards should display at the top of the page with 17 card available in the dropdown of History card for 21 recent files
When he queries another file for file ID "611085" 
Then the most recent file should be added in the first position at the top with last 17th file being removed from the History dropdown 
And remaining cards should shift one space towards the most recent for 22 recent files

@IRIS-992 @Mylo-Regression @214507 @214509
Scenario:  Mylo-Validate maximum 17 History Card appearing in the History dropdown and last file being added upon deletion of 1 History Card in the History section on Mylo Assignment page in the current session
Given he is on Mylo Assignment Summary page with 22 recent files 
And 3 most recent assignment history cards should display at the top of the page with 17 card available in the dropdown of History card for 22 recent files
When he deletes one of the history cards among 22 recent files
Then file in 22nd position should now be displayed in the dropdown after he clicks on History card
And remaining cards should shift one space towards the most recent for 21 recent files