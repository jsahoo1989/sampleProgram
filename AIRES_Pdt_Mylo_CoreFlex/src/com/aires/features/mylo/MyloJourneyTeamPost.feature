Feature: Validate the functionality of Mylo Journey Team Post section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Team Post" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-2078 @218059 @218060 @Mylo:218361 @Mylo-Regression
Scenario: Mylo-Validate Edit functionality of Team Post made by other users and current user having Resource300023
Given he has logged into the Mylo application with mentioned userType "With Resource300023" 
When he views 'Team Post' section on Mylo Journey page for "relocationPolicyType" fileID
Then he should be able to edit the Team Post created by same as well as other users on Mylo Journey page

@IRIS-2078 @218057 @218058 @Mylo:218362 @Mylo-Regression
Scenario: Mylo-Validate Edit button behavior of Team Post made by other users and current user without having Resource300023
Given he has logged into the Mylo application with mentioned userType "Without Resource300023" 
When he views 'Team Post' section on Mylo Journey page for "relocationPolicyType" fileID
Then he should be able to edit the Team Post created by same users on Mylo Journey page
And he should not be able to edit the Team Post created by other users on Mylo Journey page

@IRIS-2078 @218062 @218063 @Mylo:218363 @Mylo-Regression
Scenario: Mylo-Validate Add button behavior of Team Post on Mylo Journey Page
Given he is on 'Team Post' add section after clicking on "Add icon" for fileID with type "relocationPolicyType" on Mylo Journey page
When he views "Save" button on 'Team Post' edit section after entering 'Comments'  without selecting 'Post Type'
Then "Save" button of 'Team Post' section should be disabled on Mylo Journey page
And "Save" button of 'Team Post' section should be disabled after selecting 'Post Type' without entering the 'Comments' on Mylo Journey page

@IRIS-2078 @218061 @218064 @218076 @218077 @Mylo:218364 @Mylo-Regression
Scenario Outline: Mylo-Validate Adding a Team Post functionality on Mylo Journey Page
Given he is on 'Team Post' add section after clicking on "Add icon" for newly created file on Mylo Journey page
When he clicks on "Save" button after entering 'Comments' for the selected "<Post Type>" on 'Team Post' section
Then "<Post Type>" post should be successfully saved with respective 'Color Codes' on 'Team Post' section
And "<Post Type>" post should be successfully archived by clicking on "Archive icon" after selecting the post on 'Team Post' section
And "<Post Type>" post should be displayed in "Team Post Expanded" section after he clicks on "Expand" icon on 'Team Post' section
Examples:
|Post Type |
|General   |
|Operations|
|Rates     |
#|Expense  |

@IRIS-2101 @218065 @218067 @Mylo:218365 @Mylo-Regression
Scenario Outline: Mylo-Validate Filter functionality of Team Post on Mylo Journey Page
Given he has added multiple posts of mentioned 'PostTypes' on 'Team Post' section for newly created file on Mylo Journey page
|Team Post Type |
|General        |
|Operations     |
|Expense        |
|Rates          |
When he clicks on "<FilterType>" of 'Team Post' filter section on Mylo Journey page
Then 'Team Post' section should only display the existing posts for "<PostType>" on Mylo Journey page
And filter should remain applied for "<PostType>" after he clicks on "Expand" icon on Mylo Journey page
Examples:
|FilterType|PostType   |
|Gen       |General    |
|Ops       |Operations |
|Rates     |Rates      |
#|Exp       |Expense    |

@IRIS-2101 @218072 @218073 @Mylo:218366 @Mylo-Regression
Scenario: Mylo-Validate Search Criteria functionality of Team Post on Mylo Journey Page
Given he has added multiple posts of mentioned 'PostTypes' on 'Team Post' section for newly created file on Mylo Journey page
|Team Post Type |
|General        |
|Operations     |
|Expense        |
|Rates          |
When he enters first 3 characters in the "Search" field of 'Team Post' section on Mylo Journey Page 
Then post should be filtered as per search criteria with matched characters displayed in bold letters
And search criteria should remain applied after he clicks on "Expand" icon on Mylo Journey page

@IRIS-2101 @218057 @218058 @Mylo:218367 @Mylo-Regression
Scenario: Mylo-Validate Save button behavior while editing the Team Post on Mylo Journey Page
Given he is on 'Team Post' section after adding any 'Post Type' for newly created file on Mylo Journey page
When he clicks on "Edit" button associated with the added 'Post' on 'Team Post' section
Then "Save" button of 'Team Post' section should be disabled
And "Save" button should be enabled after he made changes to 'Comments' or 'Post Type' on 'Team Post' section
And team post should be successfully updated after he clicks on "Save" button on 'Team Post' section

@IRIS-2101 @218068 @218069 @218070 @218071 @Mylo:218368 @Mylo-Regression
Scenario: Mylo-Verify Sort Functionality of the Team Post section on Mylo Journey Page
Given he is on Mylo Journey Summary page for file ID "607203" 
When he clicks on "Sort" icon of 'Team Post' section on Mylo Journey Page
Then 'Post' should be sorted in "Ascending" order with arrow pointing up on 'Team Post' section
And 'Post' should be sorted in "Descending" order with arrow pointing down after he clicks on "Sort" icon again on 'Team Post' section
And 'Post' should remain in "Descending" order after he clicks on "Expand" icon on Mylo Journey page 