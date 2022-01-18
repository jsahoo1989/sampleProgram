Feature: Validate the functionality of Add New Policy

  Background: Login to  Policy Digitization Tool (PDT) application
    Given he is logged into 'Aires Policy Tool' application as a "Client Service Manager" user

  @Regression 
  Scenario Outline: CoreFlex - Verify the behavior of 'PolicyName' dropdown field for Valid/Invalid ClientID data on 'Add New Policy' page
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    When he enters the following 'Valid/Invalid' "<ClientID>" value for the Client ID field
    Then "Policy Name" drop-down field Visibility/Invisiblity should depend on the entered "<Valid/Invalid>" "<ClientID>" value
    
    Examples: 
      | ClientID | Valid/Invalid | 
      |      924 | Valid         | 
      |      949 | Valid         | 
      |     9494 | Valid         | 
      |    94943 | Valid         | 
      |    49211 | Valid         |
      | AIR      | Valid         | 
      | Equifax  | Valid         | 
      |      123 | Invalid       | 
      |    10002 | Invalid       | 
      | zzz      | Invalid       | 
      | Euiqfax  | Invalid       | 

  @CF-25 @CoreFlex-PolicyUpdate-Sprint1
  Scenario: CoreFlex - Verify user is navigated from 'Add New Policy' page to 'General Information' page, after entering/selecting valid ClientID/PolicyName and clicking on Next button on 'Add New Policy' page
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has entered a valid 'ClientID' "94940" in dropdown input field
    And he has selected a policy from 'Policy Name' dropdown list
    When he clicks on 'Next' button
    Then user should be navigated to the "General Information" page of the selected Client Policy
      | ClientID | ClientName |
      |    94940 | Total Specialties USA, Inc  |    