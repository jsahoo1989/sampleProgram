Feature: Validate the Mobility Journey Cards Functionality of Flex Benefit Type

  @Flex-Cards_PF @End-to-End_Flex_Cards
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'Policy Digitization Tool' application
    Given he has setup a new "Flex" Type Policy with following selection in 'Policy Digitization Tool (PDT)' application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized |
    And he has navigated to 'Custom Bundles' page after setting-up following Benefit/SubBenefits of "Flex" type for Mobility Journey Card setup
      | BenefitName       | SubBenefits                                         |
      | Language Training | Language Training Employee;Language Training Family |
    When he clicks on "SUBMIT" button on "Custom Bundles" page
    Then a success dialog should be displayed for Successfully Submitted Policy
    And Policy Status should be displayed as "Submitted" on "View/Edit Policy Forms" page

  @Flex-Cards_MX @End-to-End_Flex_Cards
  Scenario: MXTransferee - Submitting a Aires Managed benefits available in configured policy and Verifying Motiblity Journey Flex Card
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has navigated to "My Benefits Bundle" page after validating and selecting following 'Aires Managed' benefit on "FleX Planning Tool" page
      | BenefitName       |
      | Language Training |
    And he has clicked on "Review and Submit" button after validating 'Aires Managed' benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog to submit 'Aires Managed' benefit
    And he has verified 'Aires Managed' benefit card not added under 'Service Monitoring' section of "Mobility Journey Home" page
    And he has created a Service and SubService for following 'Aires Managed' benefit in Services tab of IRIS application
      | Service           | Type              | Name                       | Core/Flex |
      | Language Training | Language Training | Flex Aires Managed Benefit | Flex      |
    And he has verified "Language Training" card having "Starting Soon" status displayed under 'Service Monitoring' section of "Mobility Journey Home" page
    When he actualize the "Language Training Start date" tracing in 'Activity & Finance' tab of of IRIS application
    Then "Language Training" card status should be changed to "In Progress" under 'Service Monitoring' section of "Mobility Journey Home" page
