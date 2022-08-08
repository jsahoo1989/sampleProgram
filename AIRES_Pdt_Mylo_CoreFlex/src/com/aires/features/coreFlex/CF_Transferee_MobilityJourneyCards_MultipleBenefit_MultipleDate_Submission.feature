Feature: Validate the Mobility Journey Aires Managed Benefits Cards Functionality for Multiple Benefit & Multiple Date Benefit Submission on MobilityX Application.

  @End-To_End_CoreFlex @MJ_MultipleDateCardsSubmission_PolicyDataSetup
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'Blueprint' application with Both type 'Aires Managed' benefit
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor            | MileStones |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Both        | Aires Managed Benefits Cards |          2 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledged 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To_End_CoreFlex @MultipleDateSubmission_FirstSubmission
  Scenario: MXTransferee - Verifying Mobility Journey Both Card details of submitted Aires Managed benefits for Multiple Submission Scenario
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after validating and selecting 'Aires Managed' benefits with '2' Milestones on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating 'Aires Managed' benefits with '2' Milestones listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog to submit 'Aires Managed' benefits with '2' tracing prompts
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - changed to "Submitted" on "My Benefit Bundle" page
    And he has verified 'Aires Managed' benefits with '2' Milestones card not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created Service and SubService for 'Aires Managed' benefits with '2' Milestones of CoreFlex type "Both" in Services tab of IRIS application
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - changed to "Starting Soon" on "Mobility Journey Home" page - "Pre Initial Tracing"
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - changed to "Starting Soon" on "My Benefit Bundle" page
    When he provides "Est Date" for added '2' services tracing prompt after clicking on the "Activity & Finance" tab of added Service
    Then submitted Aires Managed Benefits with '2' Milestones Status - should be changed to "In Progress" on "Mobility Journey Home" page - "Post Initial Tracing"
    And submitted Aires Managed Benefits with '2' Milestones Status - should be changed to "In Progress" on "My Benefit Bundle" page for 'Multiple Submission'

  @End-To_End_CoreFlex @MultipleDateSubmission_SecondSubmission @AllCards
  Scenario: MXTransferee - Verifying Mobility Journey Both Card Tracing Date details after Submission of Aires Managed Service on different dates
    Given he has logged into 'MobilityX' application with Transferee user of 'Submitted Benefits Policy'
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - displayed as "In Progress" on "Mobility Journey Home" page - "Post Initial Tracing"
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - displayed as "In Progress" on "My Benefit Bundle" page
    When he provides "Act Date" for added '2' sub-services tracing prompts after clicking on the "Activity & Finance" tab of added Service
    Then submitted Aires Managed Benefits with '2' Milestones Status - should be changed to "Complete" on "Mobility Journey Home" page - "Post End Tracing"
    And submitted Aires Managed Benefits with '2' Milestones Status - should be changed to "Complete" on "My Benefit Bundle" page    

  @End-To_End_CoreFlex @MJ_Cards_MultipleBenefitSubmission @AllCards
  Scenario: MXTransferee - Verifying multiple flex cards are displayed for multiple submission of Aires Managed benefits on Mobility Journey Home page
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after validating and selecting 'Aires Managed' benefits with '2' Milestones on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating 'Aires Managed' benefits with '2' Milestones listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog to submit 'Aires Managed' benefits with '2' tracing prompts
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - changed to "Submitted" on "My Benefit Bundle" page
    And he has verified 'Aires Managed' benefits with '2' Milestones card not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created Service and SubService for 'Aires Managed' benefits with '2' Milestones of CoreFlex type "Both" in Services tab of IRIS application
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - changed to "Starting Soon" on "Mobility Journey Home" page - "Pre Initial Tracing"
    And he has verified submitted Aires Managed Benefits with '2' Milestones Status - changed to "Starting Soon" on "My Benefit Bundle" page
    And he has Selected and Submitted multiple 'Aires Managed' benefits on 'My Benefit Bundles' page
    When he creates additional "Both" type Subservice for submitted 'Aires Managed' benefits in Services tab of IRIS application
    Then multiple Flex Cards with status "Starting Soon" should be displayed for multiple submission of 'Aires Managed' benefits on "Mobility Journey Home" page
