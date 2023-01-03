Feature: Validate the Complete/InComplete Draft policy Indicator feature of Points Based CoreFlex policy in BluePrint Application

  @End-To-End_CoreFlex @CF_BluePrint_DraftPolicyIndicator @CF_BluePrint_DraftPolicyIndicator_Incomplete
  Scenario: CoreFlex - Validating Red Indicator is displayed for Policy in Draft - Incomplete Status
    Given he has logged in to 'OnPoint-Blueprint' application as a 'CSM' user
    And he has clicked on "Next" button after selecting Client and a new Points Based CoreFlex Policy on 'Add New Policy Forms' page
    And he has verified 'Red Indicator' is displayed beside Draft Policy status to indicate 'Incomplete Policy' on the navigated 'General Information' page
    And he has clicked on "Next" button after filling all the mandatory fields on 'General Information' page
    And he has clicked on "Next" button after filling following details on the navigated 'Point Policy Setup' page
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized |
    And he has clicked on "Next" button after selecting some benefits on 'Policy Benefits Categories' page
    When he navigate to 'Vew/Edit Policy Forms' page without filling required details on selected benefits
    Then "Red Indicator" should be displayed beside Draft Policy status to indicate "Policy incomplete. Please complete missing information" on following pages
    | Vew/Edit Policy Forms | View Policy Benefit | Edit Policy Benefit |

  @End-To-End_CoreFlex @CF_BluePrint_DraftPolicyIndicator @CF_BluePrint_DraftPolicyIndicator_Complete
  Scenario: CoreFlex - Validating Green Indicator is displayed for Policy in Draft - Complete Status
    Given he has logged in to 'OnPoint-Blueprint' application as a 'CSM' user
    And he has clicked on "Next" button after selecting Client and a new Points Based CoreFlex Policy on 'Add New Policy Forms' page
    And he has verified 'Red Indicator' is displayed beside Draft Policy status to indicate 'Incomplete Policy' on the navigated 'General Information' page
    And he has clicked on "Next" button after filling all the mandatory fields on 'General Information' page
    And he has clicked on "Next" button after filling following details on the navigated 'Point Policy Setup' page
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized |
    And he has clicked on "Next" button after selecting some benefits on 'Policy Benefits Categories' page
    And he has clicked on 'Save & Continue' after filling all the required details of the selected benefits
    And he has clicked on 'Continue' button on 'Benefit Summary' page
    When he navigate to 'Vew/Edit Policy Forms' page after filling all the required details on selected benefits
    Then "Green Indicator" should be displayed beside Draft Policy status to indicate "Policy complete. Ready for submission" on following pages
    | Vew/Edit Policy Forms | View Policy Benefit | Edit Policy Benefit |
