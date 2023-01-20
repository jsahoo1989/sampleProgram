Feature: Validate the FleX PDF - DocMan Attachment template for submitted Flex benefits by Client, Transferee, Impersonator and Delegate user

  @CF_End-To-End_MasterScript @CF_FlexPDF_DocManAttachment @CF_FlexPDF_DocManAttachment_PS_Client
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Approval WorkFlow for FleX PDF - DocMan Attachment Policy Setup
    Given he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor |
      | Client Initiator                         | User Defined    | Portion Cashout      | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @CF_End-To-End_MasterScript @CF_FlexPDF_DocManAttachment @CF_FlexPDF_DocManAttachment_Client
  Scenario: MXClient - Verifying submitted Benefits and Points details by Client on downloaded Point Summary PDF document
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has navigated to "Benefit Selection Tool" page after entering valid 'Total Points' value and clicking on "Start Benefit Selection" button
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits and Cashout on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected FlexBenefit and Cashout details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' along with 'Cashout' details displayed on the navigated 'Authorization Form' page
    And he has clicked on "Submit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    And he has verified 'Auth Submit Success' growl message displayed on the navigated 'MobilityX Dashboard Home' page
    And he has verified 'New Initiation Submitted' email having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits Points
    And he has clicked on 'Employee Name' from the search result list after searching for employee in 'Search' field
    And he has verified 'Assignment' and 'SubmittedPoints' details on the navigated 'Mobility Journey' page
    And he has verified 'Point Summary.pdf' document and following details of 'Flex PDF' displayed under "Documents" section of 'Mobility Journey Home' page
      | FileName          | Category             | Service    |
      | Point Summary.pdf | Authorizations/Forms | Assignment |
    And he has clicked on "Point Summary.pdf" document under 'Documents' section
    And "Point Summary.pdf" document should be opened in preview mode having submitted 'Benefits' and 'Points' details
    When he clicks on "Download document" link on the preview summary page of 'Point Summary.pdf' document
    Then "Point Summary.pdf" document should downloaded having submitted 'Benefits' and 'Points' details by 'Client'

  @CF_End-To-End_MasterScript @CF_FlexPDF_DocManAttachment @CF_FlexPDF_DocManAttachment_PS_Transf
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Approval WorkFlow for FleX PDF - DocMan Attachment Policy Setup
    Given he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor |
      | Transferee                               | Static/Fixed    | Portion Cashout      | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @CF_End-To-End_MasterScript @CF_FlexPDF_DocManAttachment @CF_FlexPDF_DocManAttachment_Transferee
  Scenario: MXTransferee - Verifying submitted Benefits and Points details by Transferee on downloaded Point Summary PDF document
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has navigated to "OnPoint Planning Tool" page after clicking on 'Manage my Points' button on "Mobility Journey Home" page
    And he has verified Benefits details displayed under 'Core Benefits' and 'Flex Benefits' section on "OnPoint Planning Tool" page
    And he has navigated to "Suggested Bundles" page after clicking on following link on "OnPoint Planning Tool" page
      | Take a look at some suggested options! |
    And he has verified 'Custom Bundle' Benefit details displayed under 'Recommended Bundle' section on "Suggested Bundles" page
    And he has navigated back to "OnPoint Planning Tool" page after clicking on 'Back to benefits list' button
    And he has navigated to "My Benefits Bundle" page after selecting required benefits on "OnPoint Planning Tool" page
    And he has clicked on "Review and Submit" button after validating all the benefit and Cashout details listed under 'Selected Benefits' section on "My Benefits Bundle" page
    And he has clicked on "Yes - submit my bundle" button after entering Transferee name on "Submit Bundle Confirmation" dialog
    And he has clicked on "OK - Let Me See My Benefits!" button displayed on 'Success Flex' dialog
    And he has verified 'Mobility Benefits Submission' email generated upon OnPoint Benefits Submission
    And he has verified submitted points details after navigating to 'Mobility Journey Home'    
    And he has verified 'Point Summary.pdf' document and following details of 'Flex PDF' displayed under "Documents" section of 'Mobility Journey Home' page
      | FileName          | Category             | Service    |
      | Point Summary.pdf | Authorizations/Forms | Assignment |
    And he has clicked on "Point Summary.pdf" document under 'Documents' section
    And "Point Summary.pdf" document should be opened in preview mode having submitted 'Benefits' and 'Points' details
    When he clicks on "Download document" link on the preview summary page of 'Point Summary.pdf' document
    Then "Point Summary.pdf" document should downloaded having submitted 'Benefits' and 'Points' details by 'Transferee'
