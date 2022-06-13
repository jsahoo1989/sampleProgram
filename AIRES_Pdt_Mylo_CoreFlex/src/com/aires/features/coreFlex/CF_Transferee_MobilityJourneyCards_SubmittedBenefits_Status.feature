Feature: Validate the Core_Flex Cards details on Mobility Journey and Aires Managed Submitted Benefit status on My Benefit Bundle Page

  @End-To_End_CoreFlex @Both-Cards_PF_Card_StatusChecks @AllCards @MJ_Card_StatusChecks
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'Policy Digitization Tool' with Both type 'Aires Managed' benefit
    Given he has submitted a new "Both" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized |
    And he has clicked on "Approve Policy" button on "Custom Bundles" page
    And he has selected "Associate this policy with a NEW authorization in IRIS? " option and default 'Effective from booking date' on 'Approval this Policy' dialog
    When he clicks on "Approve" button to acknowledged 'Approve this Policy' dialog 
   Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To_End_CoreFlex @Both-Cards_MX @AllCards @MJ_Card_StatusChecks
  Scenario: MXTransferee - Verifying Flex_Core Cards details and (Submitted,StartingSoon,InProgress,Complete) status of the submitted Aires Managed Benefit
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
    And he has added a new participant in 'Activity & Finance' tab for all the created service
    And he has provided "Est Date" for added services tracing prompt after clicking on the "Activity & Finance" tab of added Service
    And he has verified submitted Aires Managed Benefit Flex and Core card status updated to "In Progress" on "Mobility Journey Home" page - "Post Initial Tracing"
    And he has verified submitted Aires Managed Benefit status updated to "In Progress" on "My Benefit Bundle" page
    When he provides "Act Date" for added services tracing prompt after clicking on the "Activity & Finance" tab of added Service
    Then submitted Aires Managed Benefit Flex and Core card status should be updated to "Complete" on "Mobility Journey Home" page - "Post End Tracing"
    And submitted Aires Managed Benefit status should be updated to "Complete" on "My Benefit Bundle" page

  @End-To_End_CoreFlex @Both-Cards_Cancelled_MX @AllCards @MJ_Card_StatusChecks
  Scenario: MXTransferee - Verifying Flex_Core Cards details and Cancelled status of the submitted Aires Managed Benefit
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
    When he change status of the 'Aires Managed' benefit SubService to "Cancel" from Services tab of IRIS application
    Then submitted Aires Managed Benefit Flex and Core card status should be updated to "Cancelled" on "Mobility Journey Home" page
    And submitted Aires Managed Benefit status should be updated to "Cancelled" on "My Benefit Bundle" page