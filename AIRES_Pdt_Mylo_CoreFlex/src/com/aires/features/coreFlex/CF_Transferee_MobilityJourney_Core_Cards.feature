Feature: Validate the Mobility Journey Cards Functionality of Core Aires Managed Benefit

  @End-To_End_CoreFlex @Core-Cards_PF @AllCards @CoreCards
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'Policy Digitization Tool' with Both type 'Aires Managed' benefit
    Given he has setup a new "Flex" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized |
    When he clicks on "SUBMIT" button on "Custom Bundles" page
    Then a success dialog should be displayed for Successfully Submitted Policy
    And Policy Status should be displayed as "Submitted" on "View/Edit Policy Forms" page

  @End-To_End_CoreFlex @Core-Cards_MX @AllCards @CoreCards
  Scenario: MXTransferee - Selecting an Aires Managed benefit available in configured policy and Verifying Mobility Journey Core Card
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after validating and selecting 'Aires Managed' benefit on "FleX Planning Tool" page
    And he has validated 'Aires Managed' benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    When he creates a Service and SubService for following 'Aires Managed' benefit in Services tab of IRIS application
      | Service           | Type              | Name                       | Core/Flex |
      | Language Training | Language Training | Flex Language Training     | Core      |
    Then selected Aires Managed Benefit Core card having "Starting Soon" status should be displayed under 'Service Monitoring' section of "Mobility Journey Home" page
	And Flex card should not be displayed for Selected/Not-Submitted Aires Managed Benefit on "Mobility Journey Home" page