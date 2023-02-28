Feature: Validate the Complete/InComplete Draft policy Indicator feature of Points Based CoreFlex policy in BluePrint Application

  @OnPoint_Regression @CF_OnPoint_Feature @CF_BluePrint_DraftPolicyIndicator @CF_BluePrint_DraftPolicyIndicator_Incomplete
  Scenario: CoreFlex - Validating Red Indicator is displayed for Policy in Draft - Incomplete Status
    Given he has logged in to 'OnPoint-Blueprint' application as a 'CSM' user
    And he has clicked on "Next" button after selecting Client and a new Points Based CoreFlex Policy on 'Add New Policy Forms' page
    And he has verified 'Red Indicator' is displayed beside Draft Policy status to indicate 'Incomplete Policy' on the navigated 'General Information' page
    And he has clicked on "Next" button after filling all the mandatory fields on 'General Information' page
    And he has verified 'Red Indicator' is displayed beside Draft Policy status to indicate 'Incomplete Policy' on the navigated 'Point Policy Setup' page
    And he has clicked on "Next" button after filling following details on the navigated 'Point Policy Setup' page
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized |
    And he has verified 'Red Indicator' is displayed beside Draft Policy status to indicate 'Incomplete Policy' on the navigated 'Policy Benefits Categories' page
    And he has clicked on "Next" button after selecting some benefits on 'Policy Benefits Categories' page
    When he navigate to 'Vew/Edit Policy Forms' page without filling required details on selected benefits
    Then "Red Indicator" should be displayed beside Draft Policy status to indicate "Policy incomplete. Please complete missing information" on following pages
      | Vew/Edit Policy Forms | View Policy Benefit | Edit Policy Benefit |

  @OnPoint_Regression @CF_OnPoint_Feature @CF_BluePrint_DraftPolicyIndicator @CF_BluePrint_DraftPolicyIndicator_CloningDraftInComplete
  Scenario: CoreFlex - Validating Red Indicator is displayed for Cloned Policy in Draft - Incomplete Status
    Given he has logged in to 'OnPoint-Blueprint' application as a 'CSM' user
    And he has clicked on 'Clone Policy' icon after searching for 'Points Based CoreFlex Policy' with "Draft - Incomplete" Policy Status
    And he has selected a "Existing" client value in 'Clone to: Client' dropdown along with a new policy in 'Clone to: Policy' dropdown
    When he clicks on "SAVE AS DRAFT" button
    Then he should be navigated to "General Information" page of new 'Cloned - Points based CoreFlex Policy' having following values
      | Policy Status | Policy Version | Policy Status Indicator | Policy Status Indicator Hover Text                     |
      | Draft         | V1             | Red Indicator           | Policy incomplete. Please complete missing information |
    And "Red Indicator" should be displayed beside Draft Policy status to indicate "Policy incomplete. Please complete missing information" on following pages
      | Vew/Edit Policy Forms | View Policy Benefit | Edit Policy Benefit |

  @OnPoint_Regression @CF_OnPoint_Feature @CF_BluePrint_DraftPolicyIndicator @CF_BluePrint_DraftPolicyIndicator_Complete
  Scenario: CoreFlex - Validating Green Indicator is displayed for Policy in Draft - Complete Status
    Given he has logged in to 'OnPoint-Blueprint' application as a 'CSM' user
    And he has clicked on "Next" button after selecting Client and a new Points Based CoreFlex Policy on 'Add New Policy Forms' page
    And he has verified 'Red Indicator' is displayed beside Draft Policy status to indicate 'Incomplete Policy' on the navigated 'General Information' page
    And he has clicked on "Next" button after filling all the mandatory fields on 'General Information' page
    And he has verified 'Red Indicator' is displayed beside Draft Policy status to indicate 'Incomplete Policy' on the navigated 'Point Policy Setup' page
    And he has clicked on "Next" button after filling following details on the navigated 'Point Policy Setup' page
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized |
    And he has clicked on "Next" button after selecting some benefits on 'Policy Benefits Categories' page
    And he has clicked on 'Save & Continue' after filling all the required details of the selected benefits
    When he click on 'Continue' button on 'Benefit Summary' page
    Then 'Green Indicator' should be displayed beside Draft Policy status to indicate 'Complete Policy' on the navigated 'Custom Bundles' page
    And "Green Indicator" should be displayed beside Draft Policy status to indicate "Policy complete. Ready for submission" on following pages
      | Vew/Edit Policy Forms | View Policy Benefit | Edit Policy Benefit |

  @OnPoint_Regression @CF_OnPoint_Feature @CF_BluePrint_DraftPolicyIndicator @CF_BluePrint_DraftPolicyIndicator_CloningDraftComplete
  Scenario: CoreFlex - Validating Green Indicator is displayed for Cloned Policy in Draft - Complete Status
    Given he has logged in to 'OnPoint-Blueprint' application as a 'CSM' user
    And he has clicked on 'Clone Policy' icon after searching for 'Points Based CoreFlex Policy' with "Draft - Complete" Policy Status
    And he has selected a "Existing" client value in 'Clone to: Client' dropdown along with a new policy in 'Clone to: Policy' dropdown
    When he clicks on "SAVE AS DRAFT" button
    Then he should be navigated to "General Information" page of new 'Cloned - Points based CoreFlex Policy' having following values
      | Policy Status | Policy Version | Policy Status Indicator | Policy Status Indicator Hover Text    |
      | Draft         | V1             | Green Indicator         | Policy complete. Ready for submission |
    And "Green Indicator" should be displayed beside Draft Policy status to indicate "Policy complete. Ready for submission" on following pages
      | Vew/Edit Policy Forms | View Policy Benefit | Edit Policy Benefit |

  @OnPoint_Regression @CF_OnPoint_Feature @CF_BluePrint_DraftPolicyIndicator @DPI_SubmittedPolicyDataCreationSignificantChange_PS
  Scenario: CoreFlex - Creating a new Submitted Status policy as a part of Data Creation activity to validate Significant Change Functionality
    Given he has setup a new OnPoint Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Flex        | Client            |
    When he clicks on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    Then Policy Status and Version should be displayed as "Submitted" and "V1" respectively on 'Custom Bundles' page

  @OnPoint_Regression @CF_OnPoint_Feature @CF_BluePrint_DraftPolicyIndicator @DPI_AddBenefit_SubmittedToDraft
  Scenario: CoreFlex - Validate Submitted Policy Status Change to Draft after adding a new Benefit to the Policy having assignment(s) association
    Given he has logged in to 'OnPoint-Blueprint' application as a 'CSM' user
    And he has searched for "Submitted" points based CoreFlex policy on "View/Edit Policy Forms" page
    And he has clicked on "Edit" icon of the searched "Submitted" points based CoreFlex policy
    And he has navigated to "General Information" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as "Submitted"
    And he has clicked on "Next" button to navigate to "Point Policy Setup" page
    And he has verified Policy Status displayed as "Submitted" on "Point Policy Setup" page
    And he has clicked on "Next" button to navigate to 'Policy Benefit Categories' page
    And he has verified Policy Status displayed as "Submitted" on "Policy Benefit Categories" page
    And he has filled 'Benefit-SubBenefit' details after adding a new Benefit on 'Policy Benefit Categories' page
    And he has verified additional added benefit displayed on Summary Details after navigating to 'Benefit Summary' page
    When he clicks on "Continue" button on 'Benefit Summary' page
    Then he should be navigated to "Custom Bundles" page having following buttons displayed in enabled state and 'APPROVE POLICY' button should not be displayed
      | PREVIEW TRANSFEREE EXPERIENCE | SAVE AS DRAFT | SUBMIT |
    And Policy Status should be changed from "Submitted" to "Draft" on 'Custom Bundles' page
    And 'Green Indicator' should be displayed beside Draft Policy status to indicate 'Complete Policy' on the navigated 'Custom Bundles' page
    And "Green Indicator" should be displayed beside Draft Policy status to indicate "Policy complete. Ready for submission" on following pages
      | Vew/Edit Policy Forms | View Policy Benefit | Edit Policy Benefit |
