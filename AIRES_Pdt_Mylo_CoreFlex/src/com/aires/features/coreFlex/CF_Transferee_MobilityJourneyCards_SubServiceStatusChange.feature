Feature: Validate the Mobility Journey Cards Functionality of Core Aires Managed Benefit

  @End-To_End_CoreFlex @MJ_Cards_SubServiceStatusChange_PF @AllCards
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'Policy Digitization Tool' with Both type 'Aires Managed' benefit
    Given he has submitted a new "Both" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized |
    And he has clicked on "Approve Policy" button to approve "VI" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V2" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledged 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To_End_CoreFlex @MJ_Cards_SubServiceStatusChange_Both_To_Core @AllCards
  Scenario: MXTransferee - Verifying Aires Managed Benefit Flex Cards removed from Mobility Journey page on Updating Core_Flex SubService from Both to Core Type in I_R_I_S
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after validating and selecting 'Aires Managed' benefit on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating 'Aires Managed' benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog to submit 'Aires Managed' benefit
    And he has verified submitted Aires Managed Benefit status updated to "Submitted" on "My Benefit Bundle" page
    And he has verified 'Aires Managed' benefit card not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created Service and SubService for 'Aires Managed' benefits of CoreFlex type "Both" in Services tab of IRIS application
    And he has verified submitted Aires Managed Benefit Flex and Core card status updated to "Starting Soon" on "Mobility Journey Home" page - "Pre Initial Tracing"
    And he has verified submitted Aires Managed Benefit status updated to "Starting Soon" on "My Benefit Bundle" page
    When he change the SubService "Core/Flex" type of the following 'Aires Managed' benefit to "Core" on Services tab of IRIS application
    Then submitted Flex Cards should not be displayed under 'Service Monitoring' section of "Mobility Journey Home" page
    And submitted Core Cards should be displayed under 'Service Monitoring' section of "Mobility Journey Home" page

  @End-To_End_CoreFlex @MJ_Cards_SubServiceStatusChange_Flex_To_Core @AllCards
  Scenario: MXTransferee - Verifying Aires Managed Benefit Flex Cards removed from Mobility Journey page on Updating Core_Flex SubService from Flex to Core Type in I_R_I_S
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after validating and selecting 'Aires Managed' benefit on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating 'Aires Managed' benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog to submit 'Aires Managed' benefit
    And he has verified submitted Aires Managed Benefit status updated to "Submitted" on "My Benefit Bundle" page
    And he has verified 'Aires Managed' benefit card not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created Service and SubService for 'Aires Managed' benefits of CoreFlex type "Flex" in Services tab of IRIS application
    And he has verified submitted Aires Managed Benefit Flex card status displayed as "Starting Soon" on "Mobility Journey Home" page - "Pre Initial Tracing"
    And he has verified submitted Aires Managed Benefit Core card not be displayed under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has verified submitted Aires Managed Benefit status updated to "Starting Soon" on "My Benefit Bundle" page
    When he change the SubService "Core/Flex" type of the following 'Aires Managed' benefit to "Core" on Services tab of IRIS application
    Then submitted Flex Cards should not be displayed under 'Service Monitoring' section of "Mobility Journey Home" page
    And submitted Core Cards should be displayed under 'Service Monitoring' section of "Mobility Journey Home" page

  @End-To_End_CoreFlex @MJ_Cards_SubServiceStatusChange_Core_To_Flex @AllCards
  Scenario: MXTransferee - Verifying Aires Managed Benefit Core Cards removed from Mobility Journey page on Updating Core_Flex SubService from Core to Flex Type in I_R_I_S
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after validating and selecting 'Aires Managed' benefit on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating 'Aires Managed' benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog to submit 'Aires Managed' benefit
    And he has verified submitted Aires Managed Benefit status updated to "Submitted" on "My Benefit Bundle" page
    And he has verified 'Aires Managed' benefit card not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created Service and SubService for 'Aires Managed' benefits of CoreFlex type "Core" in Services tab of IRIS application
    And he has verified submitted Aires Managed Benefit Core card status displayed as "Starting Soon" on "Mobility Journey Home" page - "Pre Initial Tracing"
    And he has verified submitted Aires Managed Benefit Flex card not be displayed under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has verified submitted Aires Managed Benefit status updated to "Starting Soon" on "My Benefit Bundle" page
    When he change the SubService "Core/Flex" type of the following 'Aires Managed' benefit to "Flex" on Services tab of IRIS application
    Then submitted Aires Managed Benefit Core Cards should not be displayed under 'Service Monitoring' section of "Mobility Journey Home" page
    And submitted Aires Managed Benefit Flex Cards should be displayed under 'Service Monitoring' section of "Mobility Journey Home" page

  @End-To_End_CoreFlex @SelectedBenefitsCoreCardsDisplay_MX @AllCards @SelectedBenefitsCoreCardsDisplay
  Scenario: MXTransferee - Selecting an Aires Managed benefit available in configured policy and Verifying Mobility Journey Core Card
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after validating and selecting 'Aires Managed' benefit on "FleX Planning Tool" page
    And he has validated 'Aires Managed' benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    When he creates Service and SubService for 'Aires Managed' benefits of CoreFlex type "Core" in Services tab of IRIS application
    Then selected Aires Managed Benefit Core card having "Starting Soon" status should be displayed on "Mobility Journey Home" page - "Pre Initial Tracing"
    And Flex card should not be displayed for Selected/Not-Submitted Aires Managed Benefit on "Mobility Journey Home" page
