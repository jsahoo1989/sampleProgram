Feature: Validate the MobilityX Client Auth Form Submission functionality with Total Points & Flex Benefits selections

  @End-To-End_CoreFlex @CF_BluePrint_MXClientInitiatior_AuthFormSubmission @CF_AuthFormSubmission
  Scenario: CoreFlex - Creating & Validating a new Active Points Based CoreFlex Policy with Client Initiator, UserDefined and CashNotAuth selection
    Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor | MileStones |
      | Client Initiator                         | User Defined    | Cashout Not Authorized | Both        | Client            |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To-End_CoreFlex @CF_MX_ClientInitiatior_AuthFormSubmission @CF_AuthFormSubmission11
  Scenario: MXClient - Validating Total Points & Core/Flex benefits displayed on Auth Form, Benefit Selection Tool & Benefit review page post Auth Form Submission
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has navigated to "Benefit Selection Tool" page after entering valid 'Total Points' value and clicking on "Start Benefit Selection" button
    And he has verified following details on "Benefit Selection Tool" page based on configured Points Based CoreFlex BluePrint Policy
      | Available Point Balance | Core Benefits | Flex Benefits | Suggested Bundles | Cashout |
    And he has clicked on 'Back to benefits list' to navigate to 'Benefit Selection Tool' page
    And he has clicked on "Next" button after selecting required Benefits_Cashout on "Benefit Selection Tool" page
    And he verified selected Benefits_Cashout details on the navigated "Benefit Review" page
    And he has clicked on "Save & Exit" button on "Benefit Review" page
    And he has navigated back to 'Authorization Form' page having Auth Form status displayed as "Draft"
    And he has verified submitted Benefits_Cashout details displayed under 'Flex Benefits' section on 'Authorization Form'
    And he has clicked on 'Submit to Aires' button from right floating menu of 'Authorization Form'
    When he clicks on "Submit" button of 'Do you want to submit it without the required approvals?' dialog
    
    Then an email should be sent to Aires team with authorization details 
