Feature: Validate the MXClient Post Initial Submission - Points Increase and Decrease operation on Authorization Form Page

  @OnPoint_Regression @CF_OnPoint_Feature @CF_PostInitialSubmission_PointsIncreaseDecrease @CF_PostInitialSubmission_PointsIncrease_Client_PS
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Client_UserDefined Policy Setup
    Given he has setup a new OnPoint Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor |
      | Client Initiator                         | User Defined    | Cashout Not Authorized | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @OnPoint_Regression @CF_OnPoint_Feature @CF_PostInitialSubmission_PointsIncreaseDecrease @CF_PostInitialSubmission_PointsIncrease_CF_Accept
  Scenario: MXClient - Verifying Total Points is updated at multiple places in MXClient Flow - Post Initial Submission - Points Increase on Authorization Form
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has clicked on 'Start Benefit Selection' after entering valid 'Benfit Total Points' value on 'Auth Form Template' page
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected Flex Benefit details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' details displayed on the navigated 'Authorization Form' page
    And he has clicked on "Submit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    And he has verified 'Auth Submit Success' growl message displayed on the navigated 'MobilityX Dashboard Home' page
    And he has verified 'New Initiation Submitted' email having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits
    And he has clicked on "View all initiations" link on 'Authorization Home Page' to navigate to 'View all initiation' page
    And he has clicked 'Transferee Name' from 'All Initiations' List on 'View all initiation' page
    And he has clicked on "Manage Benefit Selection" button after increasing 'Benfit Total Points' value on 'Auth Form Template' page
    When he accepts 'Increase Total Points' confirmation dialog displayed on 'Authorization Form' page
    Then 'Available Points' and 'Total Points' should be updated on following pages based on increased 'Total Points'
      | Benefit Selection Tool | Benefits Bundle | Authorization Form |
    And 'Revised Mobility Initiation' email having revised Available and Total Points details should be received on 'Resubmission' of Auth Form

  @OnPoint_Regression @CF_OnPoint_Feature @CF_PostInitialSubmission_PointsIncreaseDecrease @CF_PostInitialSubmission_PointsIncrease_CF_DiscardChanges
  Scenario: MXClient - Verifying Total Points is not updated - Post Initial Submission - Discarding Points Increase on Authorization Form
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has clicked on 'Start Benefit Selection' after entering valid 'Benfit Total Points' value on 'Auth Form Template' page
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected Flex Benefit details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' details displayed on the navigated 'Authorization Form' page
    And he has clicked on "Submit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    And he has verified 'Auth Submit Success' growl message displayed on the navigated 'MobilityX Dashboard Home' page
    And he has verified 'New Initiation Submitted' email having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits
    And he has clicked on "View all initiations" link on 'Authorization Home Page' to navigate to 'View all initiation' page
    And he has clicked 'Transferee Name' from 'All Initiations' List on 'View all initiation' page
    And he has clicked on "Back to search results" button after increasing 'Benfit Total Points' value on 'Auth Form Template' page
    When he "DISCARD" - 'What would you like to do with the changes to the submitted authorization?' confirmation dialog displayed on 'Authorization Form' page
    Then 'Available Points' and 'Total Points' should not be updated on following pages based on discarded increased 'Total Points'
      | Benefit Selection Tool | Benefits Bundle | Authorization Form |

  @OnPoint_Regression @CF_OnPoint_Feature @CF_PostInitialSubmission_PointsIncreaseDecrease @CF_PostInitialSubmission_PointsIncreaseDecrease_Transf_PS
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of Transferee_UserDefined Policy Setup
    Given he has setup a new OnPoint Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor |
      | Transferee                               | User Defined    | Portion Cashout      | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @OnPoint_Regression @CF_OnPoint_Feature @CF_PostInitialSubmission_PointsIncreaseDecrease @CF_PostInitialSubmission_PointsIncreaseDecrease_TF
  Scenario: MXClient - Verifying Total Points is updated at multiple places in MXTransferee Flow - Post Initial Submission - Points Increase on Authorization Form
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has clicked on "Submit to Aires" button after entering valid 'Benfit Total Points' value on 'Auth Form Template' page
    And he has verified 'Auth Submit Success' growl message displayed on the navigated 'MobilityX Dashboard Home' page
    And he has verified 'New Initiation Submitted' email having Transferee details along with assigned CoreFlex Total Points
    And he has clicked on "View all initiations" link on 'Authorization Home Page' to navigate to 'View all initiation' page
    And he has clicked 'Transferee Name' from 'All Initiations' List on 'View all initiation' page
    And he has clicked on 'Resubmit to Aires' after increasing 'Benfit Total Points' value on 'Auth Form Template' page
    When he accepts 'Increase Total Points' confirmation dialog displayed on 'Authorization Form' page
    Then 'Auth Submit Success' growl message should be displayed on the navigated 'View all initiation' page on confirmation of the last dialog
    And Revised 'New Initiation Submitted' email having updated Transferee and Benefit Points details should be received

  @OnPoint_Regression @CF_OnPoint_Feature @CF_PostInitialSubmission_PointsIncreaseDecrease @CF_PointsIncDec_CAT_TransfNotInPicture_PS
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of ClientAndTransferee_UserDefined Policy Setup
    Given he has setup a new OnPoint Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor |
      | Client and Transferee                    | User Defined    | Portion Cashout      | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @OnPoint_Regression @CF_OnPoint_Feature @CF_PostInitialSubmission_PointsIncreaseDecrease @CF_PointsIncreaseDecrease_ClientAndTransf_TransfNotInPicture
  Scenario: MXClient - Verifying Total Points is updated at multiple places in MXClientAndTransferee Flow - Post Initial Submission - Points Increase on Authorization Form with Transferee not in picture
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has clicked on 'Start Benefit Selection' after entering valid 'Benfit Total Points' value on 'Auth Form Template' page
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits and Cashout on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected Flex Benefit details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' along with 'Cashout' details displayed on the navigated 'Authorization Form' page
    And he has clicked on "Submit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    And he has verified 'Auth Submit Success' growl message displayed on the navigated 'MobilityX Dashboard Home' page
    And he has verified 'New Initiation Submitted' email having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits
    And he has clicked on "View all initiations" link on 'Authorization Home Page' to navigate to 'View all initiation' page
    And he has clicked 'Transferee Name' from 'All Initiations' List on 'View all initiation' page
    And he has clicked on "Manage Benefit Selection" button after increasing 'Benfit Total Points' value on 'Auth Form Template' page
    When he accepts 'Increase Total Points' confirmation dialog displayed on 'Authorization Form' page
    Then 'Available Points' and 'Total Points' should be updated on following pages based on increased 'Total Points'
      | Benefit Selection Tool | Benefits Bundle | Authorization Form |
    And 'Revised Mobility Initiation' email having revised Available and Total Points details should be received on 'Resubmission' of Auth Form

  @OnPoint_Regression @CF_OnPoint_Feature @CF_PostInitialSubmission_PointsIncreaseDecrease @CF_PointsIncDec_CAT_TransfInPicture_PS
  Scenario: CoreFlex - Validating policy status is updated to 'Active' on completion of ClientAndTransferee_UserDefined Policy Setup
    Given he has setup a new OnPoint Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability | BenefitType | PolicyRequiredFor |
      | Client and Transferee                    | User Defined    | Portion Cashout      | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @OnPoint_Regression @CF_OnPoint_Feature @CF_PostInitialSubmission_PointsIncreaseDecrease @CF_PointsIncreaseDecrease_ClientAndTransf_TransfInPicture_CF
  Scenario: MXClient - Verifying Total Points is updated at multiple places in MXClientAndTransferee Flow - Post Initial Submission - Points Increase on Authorization Form with Transferee has selected benefits
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has clicked on 'Start Benefit Selection' after entering valid 'Benfit Total Points' value on 'Auth Form Template' page
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected Flex Benefit details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' details displayed on the navigated 'Authorization Form' page
    And he has clicked on "Submit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    And he has verified 'Auth Submit Success' growl message displayed on the navigated 'MobilityX Dashboard Home' page
    And he has verified 'New Initiation Submitted' email having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits
    And 'Transferee' user has selected 'Benefit_Cashout' on 'OnPoint Planning Tool' page after logging into 'MobilityX' application
    And he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "View all initiations" link on 'Authorization Home Page' to navigate to 'View all initiation' page
    And he has clicked 'Transferee Name' from 'All Initiations' List on 'View all initiation' page
    And he has clicked on "Resubmit to Aires" button after increasing 'Benfit Total Points' value on 'Auth Form Template' page
    When he accepts 'Increase Total Points' confirmation dialog displayed on 'Authorization Form' page
    Then 'Auth Submit Success' growl message should be displayed on the navigated 'Advanced Authorization Search' page
    And 'Available Points' and 'Total Points' should be updated on 'Authorization Form' page based on increased 'Total Points' - post Transferee Activity
    And 'Revised Mobility Initiation' email having revised Available and Total Points details should be received on 'Resubmission' of Auth Form
