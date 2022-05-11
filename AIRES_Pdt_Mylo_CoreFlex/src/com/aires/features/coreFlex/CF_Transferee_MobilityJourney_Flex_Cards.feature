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
Scenario: MXTransferee - Selecting & Submitting benefits available in configured policy and Verifying Motiblity Journey Cards
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "FleX Planning Tool" page with below Policy-Benefit type after clicking on 'Manage my Points' button on "Mobility Journey Home" page
      | PolicyType |
      | Flex       |
    And he has navigated to "My Benefits Bundle" page after selecting required benefits on "FleX Planning Tool" page
    And he has clicked on "Review and Submit" button after validating all the benefit details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog
    When he clicks on "OK - Let Me See My Benefits!" button displayed on 'Success Flex' dialog
    Then submitted points details should be updated on 'Mobility Journey Home' and 'Flex Planning Tool' page
    And submitted benefit details should be displayed under 'Submitted Benefits' section of 'My Benefits Bundle' page
    And 'Mobility Flex Benefit(s) Submission' email should be generated for the submitted benefit bundle 
