Feature: Validate Transferee Mobility Journey Cards & Aires Managed Benefits - Submitted, StartingSoon, InProgress, Complete & Canceled Status

  @OnPoint_Regression @CF_OnPoint_Feature @CF_Master_Transferee_Cards @CF_Master_Transferee_Cards_PolicySetup
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Approval WorkFlow for MJ Cards MasterScript Policy Setup
    Given he has setup a new OnPoint Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Both        | All Benefits      |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @OnPoint_Regression @CF_OnPoint_Feature @CF_Master_Transferee_Cards @CF_Master_MobilityJourneyCards_StatusCheck
  Scenario: MXTransferee - Verifying Flex_Core Cards details and (Submitted,StartingSoon,InProgress,Complete) status of the submitted Aires Managed Benefit
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "OnPoint Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after selecting 'Aires Managed' benefits on "OnPoint Planning Tool" page
    And he has clicked on "Review and Submit" button after validating all the 'Aires Managed' benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog and validating 'Aires Managed' benefit details
    And he has clicked on "OK - Let Me See My Benefits!" button displayed on 'Success Flex' dialog
    And he has verified submitted Aires Managed Benefits Status - changed to "Submitted" on "My Benefit Bundle" page
    And he has verified 'Aires Managed' benefit cards not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created Service and SubService for 'Aires Managed' benefits in Services tab of IRIS application
    And he has verified submitted Aires Managed Benefits Status - changed to "Starting Soon" on "Mobility Journey Home" page - "Pre Initial Tracing"
    And he has verified submitted Aires Managed Benefits Status - changed to "Starting Soon" on "My Benefit Bundle" page
    And he has provided "Est Date" for added services tracing after clicking on the "Activity & Finance" tab of added Service
    And he has verified submitted Aires Managed Benefits Status - changed to "In Progress" on "Mobility Journey Home" page - "Post Initial Tracing"
    And he has verified submitted Aires Managed Benefits Status - changed to "In Progress" on "My Benefit Bundle" page
    When he provides "Act Date" for added sub-services tracing prompts after clicking on the "Activity & Finance" tab of added Service
    Then submitted Aires Managed Benefits Status - should be changed to "Complete" on "Mobility Journey Home" page - "Post End Tracing"
    And submitted Aires Managed Benefits Status - should be changed to "Complete" on "My Benefit Bundle" page

  @OnPoint_Regression @CF_OnPoint_Feature @CF_Master_Transferee_CardsIgnore @CF_Master_MobilityJourneyCards_CancelledStatusCheck
  Scenario: MXTransferee - Verifying MobilityJourney Cards Cancelled status for submitted Flex_Core Cards Aires Managed Benefit
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "OnPoint Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after selecting 'Aires Managed' benefits on "OnPoint Planning Tool" page
    And he has clicked on "Review and Submit" button after validating 'Aires Managed' benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog and validating 'Aires Managed' benefit details
    And he has clicked on "OK - Let Me See My Benefits!" button displayed on 'Success Flex' dialog
    And he has verified submitted Aires Managed Benefits Status - changed to "Submitted" on "My Benefit Bundle" page
    And he has verified 'Aires Managed' benefit cards not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created Service and SubService for 'Aires Managed' benefits in Services tab of IRIS application
    And he has verified submitted Aires Managed Benefits Status - changed to "Starting Soon" on "Mobility Journey Home" page - "Pre Initial Tracing"
    And he has verified submitted Aires Managed Benefits Status - changed to "Starting Soon" on "My Benefit Bundle" page
    When he change status of the 'Aires Managed' benefit SubService to "Cancel" from Services tab of IRIS application
    Then submitted Aires Managed Benefit Flex and Core card status should be updated to "Canceled" on "Mobility Journey Home" page
    And submitted Aires Managed Benefit status should be updated to "Canceled" on "My Benefit Bundle" page
