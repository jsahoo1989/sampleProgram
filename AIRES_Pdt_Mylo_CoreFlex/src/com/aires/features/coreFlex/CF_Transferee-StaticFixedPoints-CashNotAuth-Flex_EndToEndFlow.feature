Feature: Validate the CoreFlex End-To-End Business Test Flow(BluePrint, MXTransferee,Transferee Submissions) for Flex_Transferee_StaticFixedPoints_CashoutNotAuthorized Policy selection

  @End-To_End_CoreFlex @Flex-CashNotAuth_PF @End-to-End_Flex_CashNotAuth
  Scenario: CoreFlex - Setting up a New CoreFlex policy in 'BluePrint' application
   Given he has setup a new CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor | MileStones |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Flex        | All Benefits      |          0 |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has selected following options on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledged 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @End-To_End_CoreFlex @Flex-CashNotAuth_MX @End-to-End_Flex_CashNotAuth
  Scenario: MXTransferee - Selecting & Submitting benefits available in configured policy and Tracking Available_Used Benefits Points
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

  @End-To_End_CoreFlex @Flex-CashNotAuth_MX @End-to-End_Flex_CashNotAuth
  Scenario: TransfereeSubmissions - Verifying submissions made by Transferee for the Client(s) assigned to PPC User
    Given he has logged into 'Transferee Submissions' application as a "MSPEC/PPC" user
    And he has navigated to "Transferee Submissions Dashboard" page having record of Bundle submitted by the transferee
    When he clicks on "Review" button for Bundle submitted by the transferee on "Transferee Submissions Dashboard" page
    Then he should be navigated to "Transferee Submission Details" page having list of submitted benefits details
