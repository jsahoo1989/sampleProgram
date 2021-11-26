Feature: Validate the functionality of General Information Page for CoreFlex and Non-CoreFlex Policies

  Background: Login to  Policy Digitization Tool (PDT) application
    Given he has logged into 'Aires Policy Tool' application as a "Client Service Manager" user

  @CF-28 @CoreFlex-PolicyUpdate-Sprint1 @FlexPolicyToPdtWorkflowCheck
  Scenario: CoreFlex - Verify confirmation popup box contents, when changing CoreFlex Policy to Non CoreFlex Policy
    Given he has selected a "CoreFlex Enabled" policy for "49211" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application
    And he has selected "Yes" option for "Points Based Flex Policy" dropdown field after filling all other mandatory fields
    And he has navigated to "General Information" page from "Flex Policy Setup" page through left navigation
    And he has changed "Points Based Flex Policy" dropdown selection to "No"
    And he has selected "Ok" option on confirmation pop-up dialog having following message and options
      | FieldType | FieldValue                                                                                                                                                                 |
      | Message   | Are you sure you want to change the CoreFlex Points Based policy to Regular Policy? This change will delete all the saved Flex policy data. Do you still want to continue? |
      | Options   | Ok, Cancel                                                                                                                                                                 |
    When he clicks on 'Next' button
    Then user should be navigated to the "Policy Benefits Categories" page of the selected Client Policy

  @CF-28 @CoreFlex-PolicyUpdate-Sprint1 @FlexPolicyWorkflowChangePopUpValidation
  Scenario: CoreFlex - Verify confirmation popup box contents, when changing Non CoreFlex Policy to CoreFlex Policy
    Given he has selected a "CoreFlex Enabled" policy for "49211" Client on "Add New Policy Form" page of 'Aires Policy Tool' Application
    And he has selected "No" option for "Points Based Flex Policy" dropdown field after filling all other mandatory fields
    And he has navigated to "General Information" page from "Policy Benefits Categories" page through left navigation
    And he has changed "Points Based Flex Policy" dropdown selection to "Yes"
    And he has selected "Ok" option on confirmation pop-up dialog having following message and options
      | FieldType | FieldValue                                                                                                                                                                  |
      | Message   | "Are you sure you want to change the CoreFlex Points Based policy to Regular Policy? This change will delete all the saved Flex policy data. Do you still want to continue? |
      | Options   | Ok, Cancel                                                                                                                                                                  |
    When he clicks on 'Next' button
    Then user should be navigated to the "Flex Policy Setup" page of the selected Client Policy
