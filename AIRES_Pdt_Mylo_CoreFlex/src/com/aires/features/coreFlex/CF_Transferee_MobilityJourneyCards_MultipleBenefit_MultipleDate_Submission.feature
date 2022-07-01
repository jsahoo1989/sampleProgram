Feature: Validate the Mobility Journey Cards Functionality of Flex Aires Managed Benefit

  @End-To_End_CoreFlex @Flex-Cards_PF @AllCards
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'Policy Digitization Tool' application with Both type 'Aires Managed' benefit
     Given he has submitted a new "Both" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | PolicyRequiredFor |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Cloning           |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledged 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To_End_CoreFlex @MultipleDateSubmission_FirstSubmission @AllCards
  Scenario: MXTransferee - Verifying Mobility Journey Both Card details for submitted Both type Aires Managed benefits  
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
    When he provides "Est Date" for added services initial tracing prompt after clicking on the "Activity & Finance" tab of added Service
    Then submitted Aires Managed Benefit Flex and Core card status should be updated to "In Progress" on "Mobility Journey Home" page - "Post Initial Tracing"
    And submitted Aires Managed Benefit status should be updated to "In Progress" on "My Benefit Bundle" page for the first Submission
    
    @End-To_End_CoreFlex @MultipleDateSubmission_SecondSubmission @AllCards
  Scenario: MXTransferee - Verifying Mobility Journey Both Card Tracing Date details after Multiple Submission of Aires Managed Service on different dates
    Given he has logged into 'MobilityX' application with Transferee user of 'Submitted Benefits Policy'
    And he has navigated to "FleX Planning Tool" of 'Submitted Benefits Policy' after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page of 'Submitted Benefits Policy' after selecting 'Multiple Submission Aires Managed' benefit on "FleX Planning Tool" page
    And he has validated and submitted 'Multiple Submission Aires Managed' benefits on "My Benefits Bundle" page 
    And he has verified 'Multiple Submission Aires Managed' benefits status displayed as "Submitted" on "My Benefit Bundle" page 
    And he has verified 'Submitted Benefits Policy' Aires Managed Benefit status displayed as "In Progress" on "My Benefit Bundle" page
    And he has created additional "Both" type Subservice for submitted 'Multiple Submission Aires Managed' benefits in Services tab of IRIS application    
    #And he has verified submitted 'Multiple Submission Aires Managed' benefits Flex card status updated to "Starting Soon" on "Mobility Journey Home" page - "Pre Initial Tracing"
    #And he has verified submitted 'Multiple Submission Aires Managed' benefits status updated to "Starting Soon" on "My Benefit Bundle" page
    #And he has verified 'Submitted Benefits Policy' Aires Managed Benefit status displayed as "In Progress" on "My Benefit Bundle" page
    And he has added a new participant in 'Activity & Finance' tab for all the created service
    When he provides "Est Date" for added services initial tracing prompt after clicking on the "Activity & Finance" tab of added addiitonal Service
    Then submitted 'Multiple Submission Aires Managed' benefits Flex card status should be updated to "In Progress" along with submitted date on "Mobility Journey Home" page - "Post Initial Tracing"
    And 'Submitted Benefits Policy' Flex card status should be displayed as "In Progress" along with submitted date on "Mobility Journey Home" page - "Post Initial Tracing"
    And submitted 'Multiple Submission Aires Managed' benefits status should be updated to "In Progress" on "My Benefit Bundle" page for the second Submission
		And 'Submitted Benefits Policy' Aires Managed Benefit status should be displayed as "In Progress" on "My Benefit Bundle" page
 
    @End-To_End_CoreFlex @MultipleBenefitSubmission @AllCards
  Scenario: MXTransferee - Verifying multiple flex cards are displayed for multiple submission of Aires Managed benefits on Mobility Journey Home page
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
    And he has Selected and Submitted multiple 'Aires Managed' benefits on 'My Benefit Bundles' page
    When he creates additional "Both" type Subservice for submitted 'Aires Managed' benefits in Services tab of IRIS application
    Then multiple Flex Cards with status "Starting Soon" should be displayed for multiple submission of 'Aires Managed' benefits on "Mobility Journey Home" page
    
