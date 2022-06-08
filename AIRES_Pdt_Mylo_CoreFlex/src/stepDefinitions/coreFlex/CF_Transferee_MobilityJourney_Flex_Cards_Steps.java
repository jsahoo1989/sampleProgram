package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_LoginPage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.iris.IRIS_ActivityAndFinancePage;
import com.aires.pages.iris.IRIS_AssignmentOverviewPage;
import com.aires.pages.iris.IRIS_AssignmentServicePage;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.pages.iris.IRIS_Welcome12C;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_Transferee_MobilityJourney_Flex_Cards_Steps {

	private TestContext testContext;
	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;
	private MX_Transferee_LoginPage mxTransfereeLoginPage;
	int _initialTableRowCount = 0;
	private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader()
			.getLoginByApplication(CoreFunctions.getPropertyFromConfig("application").toLowerCase());

	public CF_Transferee_MobilityJourney_Flex_Cards_Steps(TestContext context) {
		testContext = context;

		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();
		mxTransfereeMyBenefitsBundlePage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeMyBenefitsBundlePage();
		mxTransfereeLoginPage = testContext.getCoreFlexPageObjectManager().getMXTransfereeLoginPage();
	}

	/**********************************************************************/

	/**********************************************************************/

	@Given("^he has navigated to \"([^\"]*)\" after clicking on 'Manage my Points' button on \"([^\"]*)\" page$")
	public void he_has_navigated_to_after_clicking_on_Manage_my_Points_button_on_page(String navigatedPage,
			String sourcePage) throws Throwable {
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Flex Planning Tool Home</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessage(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has navigated to \"([^\"]*)\" page after validating and selecting 'Aires Managed' benefit on \"([^\"]*)\" page$")
	public void he_has_navigated_to_page_after_validating_and_selecting_Aires_Managed_benefit_on_page(
			String navigatedPage, String sourcePage) throws Throwable {

		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyBenefitDetailsOnFPT(COREFLEXConstants.FLEX),
				MessageFormat.format(
						MobilityXConstants.BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE_OF_MXTRANSFEREE_NOT_MATCHED_WITH_BENEFITS_DETAILS_SET_IN_PDT,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.selectBenefitsAndProceedToReviewAndSubmit(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_SELECT_BENEFITS_AND_PROCEED_TO_REVIEW_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>My Benefits Bundle</i> page is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has clicked on \"([^\"]*)\" button after validating 'Aires Managed' benefit details listed under 'Selected Benefits' section on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_validating_Aires_Managed_benefit_details_listed_under_Selected_Benefits_section_on_page(
			String button, String pageName) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifySelectedBenefitDetails(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.clickReviewAndSubmit();
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
	}

	@Given("^he has validated 'Aires Managed' benefit details listed under 'Selected Benefits' section on \"([^\"]*)\" page$")
	public void he_has_validated_Aires_Managed_benefit_details_listed_under_Selected_Benefits_section_on_page(
			String pageName) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifySelectedBenefitDetails(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.FAIL));
	}

	@Given("^he has clicked on \"([^\"]*)\" button after entering Transferee name on \"([^\"]*)\" dialog to submit 'Aires Managed' benefit$")
	public void he_has_clicked_on_button_after_entering_Transferee_name_on_dialog_to_submit_Aires_Managed_benefit(
			String buttonName, String submissionDialog) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isSubmitBundlePopupDisplayed(),
				MessageFormat.format(MobilityXConstants.SUBMIT_BUNDLE_POPUP_NOT_DISPLAYED, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigateTo/display <i>Submit Benefit Bundle</i> dialog is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyBenefitsDetailsOnSubmissionDialog(),
				MessageFormat.format(MobilityXConstants.POINTS_AND_BENEFIT_DETAILS_NOT_MATCHED_ON_SUBMIT_BUNDLE_POPUP,
						CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.reviewAndConfirmBenefitSubmission(
				MobilityXConstants.SUBMIT_BENEFITS_OPTIONAL_NOTES,
				CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
						+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
				buttonName);
		mxTransfereeMyBenefitsBundlePage.viewSubmittedBenefits();

		if (CoreFunctions.getPropertyFromConfig("envt").equalsIgnoreCase("PreProd")) {
			mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
			Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
					MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
			mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
			Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(), MessageFormat
					.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		}
	}

	@Given("^he has verified 'Aires Managed' benefit card not added under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void he_has_verified_Aires_Managed_benefit_card_not_added_under_Service_Monitoring_section_of_page(
			String navigatedPage) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyAiresManagedBenefitCardNotDisplayed(), MessageFormat.format(
				MobilityXConstants.AIRES_MANAGED_BENEFIT_CARD_DISPLAYED_ON_MOBILITY_JOURNEY_PAGE, CoreConstants.FAIL));
	}

	@Given("^he has created Service and SubService for 'Aires Managed' benefits of CoreFlex type \"([^\"]*)\" in Services tab of IRIS application$")
	public void he_has_created_a_Service_and_SubService_for_Aires_Managed_benefit_of_CoreFlex_type_in_Services_tab_of_IRIS_application(
			String coreFlexType) throws Throwable {

		testContext.getBasePage().invokeIrisApplication();
//		testContext.getBasePage().killExistingBrowsers();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentOverviewPage.verifyOverviewTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.OVERVIEW));
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.SERVICE_TAB);
		CoreFunctions.waitHandler(2);
		testContext.getIrisPageManager().irisAssignmentServicePage = new IRIS_AssignmentServicePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentServicePage.verifyServiceTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.SERVICE));
		testContext.getIrisPageManager().irisAssignmentServicePage.addServiceAndSubService(coreFlexType);
		testContext.getBasePage().cleanIrisProcesses();
	}

	@When("^he creates Service and SubService for 'Aires Managed' benefits of CoreFlex type \"([^\"]*)\" in Services tab of IRIS application$")
	public void he_creates_Service_and_SubService_for_Aires_Managed_benefit_of_CoreFlex_type_in_Services_tab_of_IRIS_application(
			String coreFlexType) throws Throwable {

		testContext.getBasePage().invokeIrisApplication();
//		testContext.getBasePage().killExistingBrowsers();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentOverviewPage.verifyOverviewTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.OVERVIEW));
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.SERVICE_TAB);
		CoreFunctions.waitHandler(2);
		testContext.getIrisPageManager().irisAssignmentServicePage = new IRIS_AssignmentServicePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentServicePage.verifyServiceTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.SERVICE));
		testContext.getIrisPageManager().irisAssignmentServicePage.addServiceAndSubService(coreFlexType);
		testContext.getBasePage().cleanIrisProcesses();
	}

	@Given("^he has added a new participant in 'Activity & Finance' tab for all the created service$")
	public void he_has_added_a_new_participant_in_Activity_Finance_tab_for_all_the_created_service() throws Throwable {
		testContext.getBasePage().invokeIrisApplication();
//		testContext.getBasePage().killExistingBrowsers();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentOverviewPage.verifyOverviewTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.OVERVIEW));
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.ACTIVITY_FINANCE_TAB);
		testContext.getIrisPageManager().irisActivityAndFinancePage = new IRIS_ActivityAndFinancePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisActivityAndFinancePage.verifyActivityAndFinanceTab(),
				MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
						IRISConstants.ACTIVITY_AND_FINANCE));
		testContext.getIrisPageManager().irisActivityAndFinancePage.selectServiceAndAddParticipant();
		testContext.getBasePage().cleanIrisProcesses();
	}

	@Given("^he has provided \"([^\"]*)\" for added services tracing prompt after clicking on the \"([^\"]*)\" tab of added Service$")
	public void he_has_provided_for_added_services_tracing_prompt_after_clicking_on_the_tab_of_added_sub_service(
			String tracingColumn, String tabName) throws Throwable {
		testContext.getBasePage().reLaunchIrisToAvoidFreezingIssue();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.ACTIVITY_FINANCE_TAB);
		testContext.getIrisPageManager().irisActivityAndFinancePage = new IRIS_ActivityAndFinancePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisActivityAndFinancePage.verifyActivityAndFinanceTab(),
				MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
						IRISConstants.ACTIVITY_AND_FINANCE));
		testContext.getIrisPageManager().irisActivityAndFinancePage.displayAllActivityTable();
		testContext.getIrisPageManager().irisActivityAndFinancePage
				.actualizeInitialTracingPrompt(IRISConstants.EST_DATE, IRISConstants.ACTIVITY);
		testContext.getBasePage().cleanIrisProcesses();
	}

	@When("^he provides \"([^\"]*)\" for added services tracing prompt after clicking on the \"([^\"]*)\" tab of added Service$")
	public void he_provides_for_added_Services_tracing_prompt_after_clicking_on_the_tab_of_added_sub_service(
			String actDate, String tabName) throws Throwable {
		testContext.getBasePage().invokeIrisApplication();
//		testContext.getBasePage().killExistingBrowsers();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentOverviewPage.verifyOverviewTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.OVERVIEW));
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.ACTIVITY_FINANCE_TAB);
		testContext.getIrisPageManager().irisActivityAndFinancePage = new IRIS_ActivityAndFinancePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisActivityAndFinancePage.verifyActivityAndFinanceTab(),
				MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
						IRISConstants.ACTIVITY_AND_FINANCE));
		testContext.getIrisPageManager().irisActivityAndFinancePage.displayActivityTable();
		testContext.getIrisPageManager().irisActivityAndFinancePage.actualizeEndTracingPrompt(IRISConstants.ACT_DATE,
				IRISConstants.ACTIVITY);
		testContext.getBasePage().cleanIrisProcesses();
	}

	@When("^he change the SubService \"([^\"]*)\" type of the following 'Aires Managed' benefit to \"([^\"]*)\" on Services tab of IRIS application$")
	public void he_change_the_SubService_type_of_the_following_Aires_Managed_benefit_to_on_Services_tab_of_IRIS_application(
			String columnName, String newSubserviceServiceType) throws Throwable {
		testContext.getBasePage().invokeIrisApplication();
//		testContext.getBasePage().killExistingBrowsers();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentOverviewPage.verifyOverviewTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.OVERVIEW));
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.SERVICE_TAB);
		CoreFunctions.waitHandler(2);
		testContext.getIrisPageManager().irisAssignmentServicePage = new IRIS_AssignmentServicePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentServicePage.verifyServiceTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.SERVICE));
		testContext.getIrisPageManager().irisAssignmentServicePage.updateAddedServices(columnName,
				newSubserviceServiceType);
		testContext.getBasePage().cleanIrisProcesses();
	}

	@Then("^submitted Flex Cards should not be displayed under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void submitted_Flex_Cards_should_not_be_displayed_under_Service_Monitoring_section_of_page(String pageName)
			throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyFlexCardNotDisplayedAfterUpdatingSubServiceType(),
				MessageFormat.format(
						MobilityXConstants.FLEX_CARD_DISPLAYED_AFTER_CHANGING_COREFLEX_TYPE_SUBSERVICE_IN_IRIS,
						CoreConstants.FAIL, pageName));
	}

	@Given("^he has Selected and Submitted multiple 'Aires Managed' benefits on 'My Benefit Bundles' page$")
	public void he_has_Selected_and_Submitted_multiple_Aires_Managed_benefits_on_My_Benefit_Bundles_page()
			throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.selectBenefitsForMultipleSubmission(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_SELECT_BENEFITS_AND_PROCEED_TO_REVIEW_PAGE, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.clickReviewAndSubmit();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isSubmitBundlePopupDisplayed(),
				MessageFormat.format(MobilityXConstants.SUBMIT_BUNDLE_POPUP_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.reviewAndConfirmBenefitSubmission(
				MobilityXConstants.SUBMIT_BENEFITS_OPTIONAL_NOTES,
				CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
						+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
				MobilityXConstants.SUBMIT_MY_BUNDLE_BUTTON);
		mxTransfereeMyBenefitsBundlePage.viewSubmittedBenefits();
	}

	@When("^he creates additional \"([^\"]*)\" type Subservice for submitted 'Aires Managed' benefits in Services tab of IRIS application$")
	public void he_creates_additional_type_Subservice_for_submitted_Aires_Managed_benefits_in_Services_tab_of_IRIS_application(
			String coreFlexType) throws Throwable {
		testContext.getBasePage().invokeIrisApplication();
//		testContext.getBasePage().killExistingBrowsers();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentOverviewPage.verifyOverviewTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.OVERVIEW));
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.SERVICE_TAB);
		CoreFunctions.waitHandler(2);
		testContext.getIrisPageManager().irisAssignmentServicePage = new IRIS_AssignmentServicePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentServicePage.verifyServiceTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.SERVICE));
		testContext.getIrisPageManager().irisAssignmentServicePage.addAdditionalSubService(coreFlexType);
		testContext.getBasePage().cleanIrisProcesses();
	}

	@Then("^multiple Flex Cards with status \"([^\"]*)\" should be displayed for multiple submission of 'Aires Managed' benefits on \"([^\"]*)\" page$")
	public void multiple_Flex_Cards_with_status_should_be_displayed_for_multiple_submission_of_Aires_Managed_benefits_on_page(
			String expectedStatus, String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(
				mxTransfereeJourneyHomePage.isMultipleSubmissionFlexBenefitCardVerified(expectedStatus,
						MobilityXConstants.PRE_INITIAL_TRACING),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,
						pageName));

	}

	@When("^he provides \"([^\"]*)\" for added services initial tracing prompt after clicking on the \"([^\"]*)\" tab of added Service$")
	public void he_has_provided_for_added_services_initial_tracing_prompt_after_clicking_on_the_tab_of_added_sub_service(
			String tracingColumn, String tabName) throws Throwable {
		testContext.getBasePage().reLaunchIrisToAvoidFreezingIssue();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.ACTIVITY_FINANCE_TAB);
		testContext.getIrisPageManager().irisActivityAndFinancePage = new IRIS_ActivityAndFinancePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisActivityAndFinancePage.verifyActivityAndFinanceTab(),
				MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
						IRISConstants.ACTIVITY_AND_FINANCE));
		testContext.getIrisPageManager().irisActivityAndFinancePage.displayAllActivityTable();
		testContext.getIrisPageManager().irisActivityAndFinancePage
				.actualizeInitialTracingPrompt(IRISConstants.EST_DATE, IRISConstants.ACTIVITY);
		testContext.getBasePage().cleanIrisProcesses();
	}

	@Then("^submitted Aires Managed Benefit status should be updated to \"([^\"]*)\" on \"([^\"]*)\" page for the first Submission$")
	public void submitted_Aires_Managed_Benefit_status_should_be_updated_to_on_page_for_the_first_Submission(
			String expectedStatus, String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedAiresManagedBenefitDetails(expectedStatus),
				MessageFormat.format(MobilityXConstants.SUBMITTED_AIRES_MANAGED_BENEFIT_DETAILS_NOT_MATCHED,
						CoreConstants.FAIL, pageName));
		mxTransfereeJourneyHomePage.saveSubmittedPolicyState();
	}

	@Given("^he has logged into 'MobilityX' application with Transferee user of 'Submitted Benefits Policy'$")
	public void he_has_logged_into_MobilityX_application_with_Transferee_user_of_Submitted_Benefits_Policy()
			throws Throwable {
		Map<String, String> submittedPolicyDetails = CoreFunctions
				.convertStringToMapWithStream(CoreFunctions.getPropertyFromConfig("CoreFlexSubmittedPolicyData"));
		Assert.assertTrue(mxTransfereeLoginPage.verifyBasePolicySubmitted(),
				MessageFormat.format(
						COREFLEXConstants.BASE_POLICY_NOT_SUBMITTED_FOR_MUTIPLE_SUBMISSION_DATE_CARD_VALIDATION,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeLoginPage.verifyPageNavigation(),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_MOBILITYX_LOGIN_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Login</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		mxTransfereeLoginPage.enterUsernameAndPasswordForMobilityX(submittedPolicyDetails.get(" AssignmentUserName"),
				submittedPolicyDetails.get(" AssignmentPassword"));
		mxTransfereeLoginPage.clickSignIn();
		mxTransfereeJourneyHomePage.handle_Cookie_AfterLogin();
	}

	@Given("^he has navigated to \"([^\"]*)\" of 'Submitted Benefits Policy' after clicking on 'Manage my Points' button on \"([^\"]*)\" page$")
	public void he_has_navigated_to_of_Submitted_Benefits_Policy_after_clicking_on_Manage_my_Points_button_on_page(
			String navigatedToPage, String sourcePage) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyAssignmentAndPolicyDetailsPostSubmission(),
				MessageFormat.format(MobilityXConstants.ASSIGNMENT_DETAILS_NOT_MATCHED_ON_MOBILITY_JOURNEY_HOME_PAGE,
						CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));

	}

	@Given("^he has navigated to \"([^\"]*)\" page of 'Submitted Benefits Policy' after selecting 'Multiple Submission Aires Managed' benefit on \"([^\"]*)\" page$")
	public void he_has_navigated_to_page_of_Submitted_Benefits_Policy_after_selecting_Multiple_Submission_Aires_Managed_benefit_on_page(
			String arg1, String arg2) throws Throwable {
		MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints = 0;
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.selectBenefitsForMultipleSubmission(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_SELECT_BENEFITS_AND_PROCEED_TO_REVIEW_PAGE, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
	}

	@Given("^he has validated and submitted 'Multiple Submission Aires Managed' benefits on \"([^\"]*)\" page$")
	public void he_has_validated_and_submitted_Multiple_Submission_Aires_Managed_benefits_on_page(String arg1)
			throws Throwable {

		Map<String, String> submittedPolicyDetails = CoreFunctions
				.convertStringToMapWithStream(CoreFunctions.getPropertyFromConfig("CoreFlexSubmittedPolicyData"));
		mxTransfereeMyBenefitsBundlePage.clickReviewAndSubmit();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isSubmitBundlePopupDisplayed(),
				MessageFormat.format(MobilityXConstants.SUBMIT_BUNDLE_POPUP_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.reviewAndConfirmBenefitSubmission(
				MobilityXConstants.SUBMIT_BENEFITS_OPTIONAL_NOTES,
				submittedPolicyDetails.get(" AssignmentFirstName") + " "
						+ submittedPolicyDetails.get(" AssignmentLastName"),
				MobilityXConstants.SUBMIT_MY_BUNDLE_BUTTON);
		mxTransfereeMyBenefitsBundlePage.viewSubmittedBenefits();
		if (CoreFunctions.getPropertyFromConfig("envt").equalsIgnoreCase("PreProd")) {
			mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
			Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
					MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
			mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
			Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(), MessageFormat
					.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		}
	}

	@Given("^he has verified 'Multiple Submission Aires Managed' benefits status displayed as \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void he_has_verified_Multiple_Submission_Aires_Managed_benefits_status_displayed_as_on_page(
			String expectedStatus, String pageName) throws Throwable {
		Map<String, String> submittedPolicyDetails = CoreFunctions
				.convertStringToMapWithStream(CoreFunctions.getPropertyFromConfig("CoreFlexSubmittedPolicyData"));
		MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints += Double
				.parseDouble(submittedPolicyDetails.get(" TotalPointsSubmitted"));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedAiresManagedBenefitDetails(expectedStatus),
				MessageFormat.format(MobilityXConstants.SUBMITTED_AIRES_MANAGED_BENEFIT_DETAILS_NOT_MATCHED,
						CoreConstants.FAIL, pageName));
	}

	@Given("^he has verified 'Submitted Benefits Policy' Aires Managed Benefit status displayed as \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void he_has_verified_Submitted_Benefits_Policy_Aires_Managed_Benefit_status_displayed_as_on_page(
			String expectedStatus, String pageName) throws Throwable {
		Assert.assertTrue(
				mxTransfereeMyBenefitsBundlePage.validateSubmittedPolicyAiresManagedBenefitDetails(expectedStatus),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POLICY_AIRES_MANAGED_BENEFIT_DETAILS_NOT_MATCHED,
						CoreConstants.FAIL, pageName));
		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));

	}

	@Given("^he has created additional \"([^\"]*)\" type Subservice for submitted 'Multiple Submission Aires Managed' benefits in Services tab of IRIS application$")
	public void he_has_created_additional_type_Subservice_for_submitted_Multiple_Submission_Aires_Managed_benefits_in_Services_tab_of_IRIS_application(
			String coreFlexType) throws Throwable {
		testContext.getBasePage().invokeIrisApplication();
//		testContext.getBasePage().killExistingBrowsers();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentOverviewPage.verifyOverviewTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.OVERVIEW));
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.SERVICE_TAB);
		CoreFunctions.waitHandler(2);
		testContext.getIrisPageManager().irisAssignmentServicePage = new IRIS_AssignmentServicePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentServicePage.verifyServiceTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.SERVICE));
		testContext.getIrisPageManager().irisAssignmentServicePage.addAdditionalSubService(coreFlexType);
		testContext.getBasePage().cleanIrisProcesses();

	}

	@Given("^he has verified submitted 'Multiple Submission Aires Managed' benefits Flex card status updated to \"([^\"]*)\" on \"([^\"]*)\" page - \"([^\"]*)\"$")
	public void he_has_verified_submitted_Multiple_Submission_Aires_Managed_benefits_Flex_card_status_updated_to_on_page(
			String expectedStatus, String pageName, String tracingSelection) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(expectedStatus, tracingSelection),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,
						pageName));
	}

	@Given("^he has verified submitted 'Multiple Submission Aires Managed' benefits status updated to \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void he_has_verified_submitted_Multiple_Submission_Aires_Managed_benefits_status_updated_to_on_page(
			String expectedStatus, String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedAiresManagedBenefitDetails(expectedStatus),
				MessageFormat.format(MobilityXConstants.SUBMITTED_AIRES_MANAGED_BENEFIT_DETAILS_NOT_MATCHED,
						CoreConstants.FAIL, pageName));
	}

	@When("^he provides \"([^\"]*)\" for added services initial tracing prompt after clicking on the \"([^\"]*)\" tab of added addiitonal Service$")
	public void he_provides_for_added_services_initial_tracing_prompt_after_clicking_on_the_tab_of_added_addiitonal_Service(
			String arg1, String arg2) throws Throwable {
		testContext.getBasePage().reLaunchIrisToAvoidFreezingIssue();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.ACTIVITY_FINANCE_TAB);
		testContext.getIrisPageManager().irisActivityAndFinancePage = new IRIS_ActivityAndFinancePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisActivityAndFinancePage.verifyActivityAndFinanceTab(),
				MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
						IRISConstants.ACTIVITY_AND_FINANCE));
		testContext.getIrisPageManager().irisActivityAndFinancePage.displayAllActivityTable();
		testContext.getIrisPageManager().irisActivityAndFinancePage
				.actualizeInitialTracingPrompt(IRISConstants.EST_DATE, IRISConstants.ACTIVITY);
		testContext.getBasePage().cleanIrisProcesses();

	}

	@Then("^submitted 'Multiple Submission Aires Managed' benefits Flex card status should be updated to \"([^\"]*)\" along with submitted date on \"([^\"]*)\" page - \"([^\"]*)\"$")
	public void submitted_Multiple_Submission_Aires_Managed_benefits_Flex_card_status_should_be_updated_to_along_with_submitted_date_on_page(
			String expectedStatus, String pageName, String tracingSelection) throws Throwable {

		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(expectedStatus, tracingSelection),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,
						pageName));
	}

	@Then("^'Submitted Benefits Policy' Flex card status should be displayed as \"([^\"]*)\" along with submitted date on \"([^\"]*)\" page - \"([^\"]*)\"$")
	public void submitted_Benefits_Policy_Flex_card_status_should_be_displayed_as_along_with_submitted_date_on_page(
			String expectedStatus, String pageName, String tracingSelection) throws Throwable {
		Assert.assertTrue(
				mxTransfereeJourneyHomePage.isMultipleDateSubmissionFlexBenefitCardVerified(expectedStatus,
						tracingSelection),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_MULTIPLE_DATE_SUBMISSION_FLEX_BENEFIT_CARD,
						CoreConstants.FAIL, pageName));
	}

	@Then("^submitted 'Multiple Submission Aires Managed' benefits status should be updated to \"([^\"]*)\" on \"([^\"]*)\" page for the second Submission$")
	public void submitted_Multiple_Submission_Aires_Managed_benefits_status_should_be_updated_to_on_page_for_the_second_Submission(
			String expectedStatus, String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedAiresManagedBenefitDetails(expectedStatus),
				MessageFormat.format(MobilityXConstants.SUBMITTED_AIRES_MANAGED_BENEFIT_DETAILS_NOT_MATCHED,
						CoreConstants.FAIL, pageName));
	}
	
	@Given("^'Submitted Benefits Policy' Aires Managed Benefit status should be displayed as \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void Submitted_Benefits_Policy_Aires_Managed_Benefit_status_should_be_displayed_as_on_page(
			String expectedStatus, String pageName) throws Throwable {
		Assert.assertTrue(
				mxTransfereeMyBenefitsBundlePage.validateSubmittedPolicyAiresManagedBenefitDetails(expectedStatus),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POLICY_AIRES_MANAGED_BENEFIT_DETAILS_NOT_MATCHED,
						CoreConstants.FAIL, pageName));
		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));

	}

}