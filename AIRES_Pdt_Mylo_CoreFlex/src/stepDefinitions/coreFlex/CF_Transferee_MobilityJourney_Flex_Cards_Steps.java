package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
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
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.iris.IRIS_ActivityAndFinancePage;
import com.aires.pages.iris.IRIS_AssignmentOverviewPage;
import com.aires.pages.iris.IRIS_AssignmentServicePage;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.pages.iris.IRIS_Welcome12C;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_Transferee_MobilityJourney_Flex_Cards_Steps {

	private TestContext testContext;
	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;
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
	}

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
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.selectBenefitsAndProceedToReviewAndSubmit(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_SELECT_BENEFITS_AND_PROCEED_TO_REVIEW_PAGE,
						CoreConstants.FAIL));
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
	public void he_has_added_a_new_participant_in_Activity_Finance_tab_for_all_the_created_service()
			throws Throwable {
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
		testContext.getIrisPageManager().irisActivityAndFinancePage.actualizeInitialTracingPrompt(IRISConstants.EST_DATE,
				IRISConstants.ACTIVITY);
		testContext.getBasePage().cleanIrisProcesses();
	}


	@When("^he provides \"([^\"]*)\" for added services tracing prompt after clicking on the \"([^\"]*)\" tab of added Service$")
	public void he_provides_for_added_Services_tracing_prompt_after_clicking_on_the_tab_of_added_sub_service(
			String actDate, String tabName) throws Throwable {
		testContext.getBasePage().invokeIrisApplication();
		testContext.getBasePage().killExistingBrowsers();
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
		testContext.getIrisPageManager().irisAssignmentServicePage.updateAddedServices(columnName,newSubserviceServiceType);
		testContext.getBasePage().cleanIrisProcesses();
	}

	@Then("^submitted Flex Cards should not be displayed under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void submitted_Flex_Cards_should_not_be_displayed_under_Service_Monitoring_section_of_page(
			String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyFlexCardNotDisplayedAfterUpdatingSubServiceType(),
				MessageFormat.format(MobilityXConstants.FLEX_CARD_DISPLAYED_AFTER_CHANGING_COREFLEX_TYPE_SUBSERVICE_IN_IRIS,
						CoreConstants.FAIL, pageName));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(MobilityXConstants.PRE_INITIAL_TRACING), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL, pageName));
	
	}

}
