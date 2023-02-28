Feature: Validate the AppCues displayed for OnPoint Policy configuration for Transferee user on MobilityX application

  @OnPoint_Regression @CF_OnPoint_Feature @CF_MXTransfereeAppCues @CF_MXTransfereeAppCues_Transf_PolicySetup
  Scenario: CoreFlex - Creating a new Active Transferee type Points Based CoreFlex Policy for MXTransferee AppCues Verification
    Given he has setup a new OnPoint Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor |
      | Transferee                               | Static/Fixed    | Cashout Not Authorized | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @OnPoint_Regression @CF_OnPoint_Feature @CF_MXTransfereeAppCues @CF_MXTransfereeAppCues_TF_AllAppCues
  Scenario: MXTransferee - Validating OnPoint - AppCues in MXTransferee application after associating Transferee with the Active BluePrint Policy
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has verified 'Welcome' dialog displayed post setting up new user profile on 'MobilityX' application
    When he select "No thanks, I prefer to do this later" option on 'Welcome' dialog
    Then he should be navigated to "Mobility Journey Home" page having following 'AppCues' displayed in the order below
      | Manage your profile, preferred pronouns, banking information, year end tax, and account settings from here.        |
      | Find resources to help you move; destination guides, checklists, mortgage solutions, and more!                     |
      | Navigate tabs capturing any and all of your mobility journeys with Aires.                                          |
      | View your point balance/total points.                                                                              |
      | Easily access multiple legs of a journey, like an expatriation or a repatriation.                                  |
      | Understand your move's progress with meaningful status information, both at a journey and service level.           |
      | View, download, and upload important documents for each mobility journey and share with your Aires representative. |
      | Read communication for each mobility journey.                                                                      |
      | Keep track of your services with Aires and drill into your service cards for more details.                         |
      | Start your benefits selections.                                                                                    |
      | Start an expense form for your selected mobility journey by clicking on the floating add expense button.           |
    And following 'AppCues' should be displayed in the order below on 'OnPoint Planning Tool' page
      | View the Core Benefit(s) awarded to you as part of your relocation policy.                                           |
      | Review available Flex Benefits and click on the 'Select This' button to make your selection.                         |
      | As you make your benefits selections, view your point totals here. When ready, click on the 'Next' button to review. |
    And following 'AppCues' should be displayed in the order below on 'My Benefit Bundle' page
      | Click on the 'Review and Submit' button to submit your Flex Benefit Selection(s). |

  @OnPoint_Regression @CF_OnPoint_Feature @CF_MXTransfereeAppCues @CF_MXTransfereeAppCues_TF_AllAppCues_GetHelp_WF_MJH
  Scenario: MXTransferee - Validating OnPoint - AppCues in MXTransferee application by selecting 'Transferee Points MobilityX Overview' AppCues WorkFlow from GetHelp option on Mobility Journey page
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has verified 'Welcome' dialog displayed post setting up new user profile on 'MobilityX' application
    And he has clicked on "No thanks, I prefer to do this later" option on 'Welcome' dialog
    And he has clicked on "Hide these tips" link displayed on 'AppCue' displayed on 'Mobility Journey Home' page
    And he has clicked on '?' displayed on top right corner besides 'Resources' dropdown on 'Mobility Journey Home' page
    When he clicks on "(QA) Transferee Points MobilityX Overview" option displayed under 'Get Help' section on 'Mobility Journey Home' page
    Then following 'AppCues' should be displayed in the order below on 'Mobility Journey Home' page
      | Manage your profile, preferred pronouns, banking information, year end tax, and account settings from here.        |
      | Find resources to help you move; destination guides, checklists, mortgage solutions, and more!                     |
      | Navigate tabs capturing any and all of your mobility journeys with Aires.                                          |
      | View your point balance/total points.                                                                              |
      | Easily access multiple legs of a journey, like an expatriation or a repatriation.                                  |
      | Understand your move's progress with meaningful status information, both at a journey and service level.           |
      | View, download, and upload important documents for each mobility journey and share with your Aires representative. |
      | Read communication for each mobility journey.                                                                      |
      | Keep track of your services with Aires and drill into your service cards for more details.                         |
      | Start your benefits selections.                                                                                    |
      | Start an expense form for your selected mobility journey by clicking on the floating add expense button.           |
    And following 'AppCues' should be displayed in the order below on 'OnPoint Planning Tool' page
      | View the Core Benefit(s) awarded to you as part of your relocation policy.                                           |
      | Review available Flex Benefits and click on the 'Select This' button to make your selection.                         |
      | As you make your benefits selections, view your point totals here. When ready, click on the 'Next' button to review. |
    And following 'AppCues' should be displayed in the order below on 'My Benefit Bundle' page
      | Click on the 'Review and Submit' button to submit your Flex Benefit Selection(s). |

  @OnPoint_Regression @CF_OnPoint_Feature @CF_MXTransfereeAppCues @CF_MXTransfereeAppCues_TF_AllAppCues_GetHelp_WF_OPT
  Scenario: MXTransferee - Validating OnPoint - AppCues in MXTransferee application by selecting 'Transferee Points Overview' AppCues WorkFlow from GetHelp option on OnPoint Planning Tool page
    Given he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'
    And he has verified 'Welcome' dialog displayed post setting up new user profile on 'MobilityX' application
    And he has clicked on "No thanks, I prefer to do this later" option on 'Welcome' dialog
    And he has clicked on "Hide these tips" link displayed on 'AppCue' displayed on 'Mobility Journey Home' page
    And he has clicked on "Manage My Points" button on 'Mobility Journey Home' page to navigate to 'OnPoint Planning Tool' page
    And he has clicked on "Hide these tips" link displayed on 'AppCue' displayed on 'OnPoint Planning Tool' page
    And he has clicked on '?' displayed on top right corner besides 'Resources' dropdown on 'OnPoint Planning Tool' page
    When he clicks on "(QA) Transferee Points Overview" option displayed under 'Get Help' section on 'OnPoint Planning Tool' page
    Then following 'AppCues' workflow should be displayed in the order below on 'OnPoint Planning Tool' page
      | View the Core Benefit(s) awarded to you as part of your relocation policy.                                           |
      | Review available Flex Benefits and click on the 'Select This' button to make your selection.                         |
      | As you make your benefits selections, view your point totals here. When ready, click on the 'Next' button to review. |
    And following 'AppCues' should be displayed in the order below on 'My Benefit Bundle' page
      | Click on the 'Review and Submit' button to submit your Flex Benefit Selection(s). |

  @OnPoint_Regression @CF_OnPoint_Feature @CF_MXTransfereeAppCues @CF_MXTransfereeAppCues_ClientTransf_PolicySetup
  Scenario: CoreFlex - Creating a new Active - Client and Transferee type Points Based CoreFlex Policy for MXTransferee AppCues Verification
    Given he has setup a new OnPoint Policy with following selection in Blueprint application
      | Person Responsible For Benefit Selection | Flex Setup Type | Cashout Availability   | BenefitType | PolicyRequiredFor |
      | Client and Transferee                    | Static/Fixed    | Cashout Not Authorized | Both        | Client            |
    And he has clicked on "Submit" button to submit "V1" policy verison on "Custom Bundles" page
    And he has clicked on "Approve Policy" button to approve "V1" policy verison on "Custom Bundles" page
    And he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of "V1" Policy
      | Associate this policy with a NEW authorization in IRIS? |
      | Effective from booking date                             |
    When he clicks on "Approve" button to acknowledge 'Approve this Policy' dialog
    Then Policy Status and Version should be displayed as "Active" and "V1" respectively on "View/Edit Policy Forms" page

  @OnPoint_Regression @CF_OnPoint_Feature @CF_MXTransfereeAppCues @CF_MXTransfereeAppCues_ClientTransf_CWF1
  Scenario: MXClient - Creating a new Authorization having Flex Benefits submitted by Client for validating OnPoint MobilityX Appcues for Client and Transferee Policy Setup
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has verified 'FleX Benefits' section displayed on 'Authorization Form' for "Client and Transferee" - 'Person Responsible' selection in BluePrint CoreFlex Policy
    And he has clicked on 'Start Benefit Selection' on 'Auth Form Template' page to navigate to 'Benefit Selection Tool' page
    And he has verified following details on "Benefit Selesction Tool" page based on configured Points Based CoreFlex BluePrint Policy
      | Available Point Balance | Core Benefits | Flex Benefits | Suggested Bundles | Cashout |
    And he has clicked on 'Back to benefits list' link to navigate to 'Benefit Selection Tool' page
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected Flex Benefit details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' details displayed on the navigated 'Authorization Form' page
    When he clicks on "Submit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    Then 'Auth Submit Success' growl message should be displayed on the navigated 'MobilityX Dashboard Home' page
    And 'New Initiation Submitted' email should be received having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits Points

  @OnPoint_Regression @CF_OnPoint_Feature @CF_MXTransfereeAppCues @CF_MXTransfereeAppCues_ClientTransf_TWF1
  Scenario: MXTransferee - Validating OnPoint - AppCues in MXTransferee application after Flex Benefits Submission by Client in Client and Transferee Policy Setup
    Given he has logged into 'MobilityX' application after actualizing a new 'Transferee' through IRIS application and setting-up user profile in 'MobilityX' application
    And he has clicked on following option on 'Welcome' dialog post setting up new user profile on 'MobilityX' application
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has clicked on "Hide these tips" link displayed on 'AppCue' displayed on 'Mobility Journey Home' page
    And he has clicked on '?' displayed on top right corner besides 'Resources' dropdown on 'Mobility Journey Home' page
    When he clicks on "(QA) Transferee Points MobilityX Overview" option displayed under 'Get Help' section on 'Mobility Journey Home' page
    Then following 'AppCues' should be displayed in the order below on 'Mobility Journey Home' page
      | Manage your profile, preferred pronouns, banking information, year end tax, and account settings from here.        |
      | Find resources to help you move; destination guides, checklists, mortgage solutions, and more!                     |
      | Navigate tabs capturing any and all of your mobility journeys with Aires.                                          |
      | View your point balance/total points.                                                                              |
      | Easily access multiple legs of a journey, like an expatriation or a repatriation.                                  |
      | Understand your move's progress with meaningful status information, both at a journey and service level.           |
      | View, download, and upload important documents for each mobility journey and share with your Aires representative. |
      | Read communication for each mobility journey.                                                                      |
      | Keep track of your services with Aires and drill into your service cards for more details.                         |
      | Start your benefits selections.                                                                                    |
      | Start an expense form for your selected mobility journey by clicking on the floating add expense button.           |
    And following 'AppCues' should be displayed in the order below on 'OnPoint Planning Tool' page
      | View the Core Benefit(s) awarded to you as part of your relocation policy.                                           |
      | Review available Flex Benefits and click on the 'Select This' button to make your selection.                         |
      | As you make your benefits selections, view your point totals here. When ready, click on the 'Next' button to review. |
    And following 'AppCues' should be displayed in the order below on 'My Benefit Bundle' page
      | Click on the 'Review and Submit' button to submit your Flex Benefit Selection(s). |

  @OnPoint_Regression @CF_OnPoint_Feature @CF_MXTransfereeAppCues @CF_MXTransfereeAppCues_ClientTransf_CWF2
  Scenario: MXClient - Creating a new Authorization having Flex Benefits submitted by Client for validating OnPoint MobilityX Appcues for Client and Transferee Policy Setup
    Given he has logged into 'MobilityX' application as a 'Client' user
    And he has clicked on "Create an authorization" after validating Client details on 'Authorization Home Page'
    And he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'
      | Assignment Option            | Authorization Form Template |
      | A new transfer or assignment | Domestic Authorization Form |
    And he has verified 'FleX Benefits' section displayed on 'Authorization Form' for "Client and Transferee" - 'Person Responsible' selection in BluePrint CoreFlex Policy
    And he has clicked on 'Start Benefit Selection' on 'Auth Form Template' page to navigate to 'Benefit Selection Tool' page
    And he has verified following details on "Benefit Selesction Tool" page based on configured Points Based CoreFlex BluePrint Policy
      | Available Point Balance | Core Benefits | Flex Benefits | Suggested Bundles | Cashout |
    And he has clicked on 'Back to benefits list' link to navigate to 'Benefit Selection Tool' page
    And he has navigated to "Benefits Bundle" page after selecting required Flex Benefits on 'Benefit Selection Tool' page
    And he has clicked on "Save & Exit" button after validating selected Flex Benefit details listed under 'Selected Benefits' section on "Benefits Bundle" page
    And he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' details displayed on the navigated 'Authorization Form' page
    When he clicks on "Submit to Aires" button from right floating menu of 'Authorization Form' page without routing it to Approvers
    Then 'Auth Submit Success' growl message should be displayed on the navigated 'MobilityX Dashboard Home' page
    And 'New Initiation Submitted' email should be received having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits Points

  @OnPoint_Regression @CF_OnPoint_Feature @CF_MXTransfereeAppCues @CF_MXTransfereeAppCues_ClientTransf_TWF2
  Scenario: MXTransferee - Validating OnPoint - AppCues in MXTransferee application by selecting AppCues WorkFlow from GetHelp option on OnPoint Planning Tool page after Flex Benefits Submission by Client in Client and Transferee Policy Setup
    Given he has logged into 'MobilityX' application after actualizing a new 'Transferee' through IRIS application and setting-up user profile in 'MobilityX' application
    And he has clicked on following option on 'Welcome' dialog post setting up new user profile on 'MobilityX' application
      | WelcomeDialogSelection               |
      | No thanks, I prefer to do this later |
    And he has clicked on "Hide these tips" link displayed on 'AppCue' displayed on 'Mobility Journey Home' page
    And he has clicked on "Manage My Points" button on 'Mobility Journey Home' page to navigate to 'OnPoint Planning Tool' page
    And he has clicked on "Hide these tips" link displayed on 'AppCue' displayed on 'OnPoint Planning Tool' page
    And he has clicked on '?' displayed on top right corner besides 'Resources' dropdown on 'OnPoint Planning Tool' page
    When he clicks on "(QA) Transferee Points Overview" option displayed under 'Get Help' section on 'OnPoint Planning Tool' page
    Then following 'AppCues' workflow should be displayed in the order below on 'OnPoint Planning Tool' page
      | View the Core Benefit(s) awarded to you as part of your relocation policy.                                           |
      | Review available Flex Benefits and click on the 'Select This' button to make your selection.                         |
      | As you make your benefits selections, view your point totals here. When ready, click on the 'Next' button to review. |
    And following 'AppCues' should be displayed in the order below on 'My Benefit Bundle' page
      | Click on the 'Review and Submit' button to submit your Flex Benefit Selection(s). |
