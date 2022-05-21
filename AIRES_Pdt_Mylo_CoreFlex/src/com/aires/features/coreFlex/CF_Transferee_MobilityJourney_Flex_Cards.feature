Feature: Validate the Mobility Journey Cards Functionality of Flex Aires Managed Benefit

  @End-To_End_CoreFlex @Flex-Cards_PF @AllCards
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'Policy Digitization Tool' application with Flex type 'Aires Managed' benefit
    Given he has setup a new "Flex" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized |
    And he has navigated to 'Custom Bundles' page after setting-up Aires Managed Benefit of "Flex" type for Mobility Journey Card setup
    When he clicks on "SUBMIT" button on "Custom Bundles" page
    Then a success dialog should be displayed for Successfully Submitted Policy
    And Policy Status should be displayed as "Submitted" on "View/Edit Policy Forms" page

  @End-To_End_CoreFlex @Flex-Cards_MX @AllCards
  Scenario: MXTransferee - Verifying Mobility Journey Flex Card details for submitted Flex type Aires Managed benefits  
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after validating and selecting 'Aires Managed' benefit on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating 'Aires Managed' benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog to submit 'Aires Managed' benefit
    And he has verified 'Aires Managed' benefit card not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created a Service and SubService for following 'Aires Managed' benefit in Services tab of IRIS application
      | Service           | Type              | Name                   | Core/Flex |
      | Language Training | Language Training | Flex Language Training | Flex      |
    And he has verified submitted Aires Managed Benefit Flex card having "Starting Soon" status displayed under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has verified submitted Aires Managed Benefit status updated to "Starting Soon" on "My Benefit Bundle" page
    And he has added a new participant in 'Activity & Finance' tab for the created service
      | Service           | Sub-Service                   | Function       | Comp ID | Company                      |
      | Language Training | (ACTV) Flex Language Training | Language Agent |   49211 | AIRES-CIS-DEMO&'TEST(CLIENT) |
    And he has provided the "Est Date" for below tracing prompt after clicking on the "Activity & Finance" tab of Language Training sub-service
      | tracingPrompt                   |
      | Start Date of Language Training |
    And he has verified submitted Aires Managed Benefit Flex card status updated to "Begin Training" on "Mobility Journey Home" page
    And he has verified submitted Aires Managed Benefit status updated to "In Progress" on "My Benefit Bundle" page
    When he has provides the "Act Date" for below tracing prompt after clicking on the "Activity & Finance" tab of Language Training sub-service
      | tracingPrompt                 |
      | End Date of Language Training |
    Then submitted Aires Managed Benefit Flex card status should be updated to "Training Complete" on "Mobility Journey Home" page
    And submitted Aires Managed Benefit status should be updated to "Complete" on "My Benefit Bundle" page

  @End-To_End_CoreFlex @CardsRemoved_AfterUpdatingSubservice @AllCards
  Scenario: MXTransferee - Verifying Aires Managed Benefit Cards removed from Mobility Journey page on Delete_Update Core_Flex SubService Type in I_R_I_S 
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after validating and selecting 'Aires Managed' benefit on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating 'Aires Managed' benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog to submit 'Aires Managed' benefit
    And he has verified 'Aires Managed' benefit card not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created a Service and SubService for following 'Aires Managed' benefit in Services tab of IRIS application
      | Service           | Type              | Name                   | Core/Flex |
      | Language Training | Language Training | Flex Language Training | Flex      |
    And he has verified submitted Aires Managed Benefit Flex card having "Starting Soon" status displayed under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has verified submitted Aires Managed Benefit status updated to "Starting Soon" on "My Benefit Bundle" page
    When he change the SubService "Core/Flex" type of the following 'Aires Managed' benefit to "Core" on Services tab of IRIS application
      | Service           | Name                   |
      | Language Training | Flex Language Training |
    Then submitted Flex and Core Cards should not be displayed under 'Service Monitoring' section of "Mobility Journey Home" page
