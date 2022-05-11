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

	@Given("^he has navigated to \"([^\"]*)\" page after validating and selecting following 'Aires Managed' benefit on \"([^\"]*)\" page$")
	public void he_has_navigated_to_page_after_validating_and_selecting_following_Aires_Managed_benefit_on_page(
			String navigatedPage, String sourcePage, DataTable dataTable) throws Throwable {

		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyBenefitDetailsOnFPT(COREFLEXConstants.FLEX),
				MessageFormat.format(
						MobilityXConstants.BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE_OF_MXTRANSFEREE_NOT_MATCHED_WITH_BENEFITS_DETAILS_SET_IN_PDT,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAiresManagedBenefitDetailsOnFPT(),
				MessageFormat.format(
						MobilityXConstants.BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE_OF_MXTRANSFEREE_NOT_MATCHED_WITH_BENEFITS_DETAILS_SET_IN_PDT,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.selectAiresManagedBenefitAndProceedToReviewAndSubmit(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_SELECT_BENEFITS_AND_PROCEED_TO_REVIEW_PAGE,
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
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifySelectedAiresManagedBenefitDetails(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.clickReviewAndSubmit();
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
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
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyAiresManagedBenefitDetailsOnSubmissionDialog(),
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
	public void he_has_verified_Aires_Managed_benefit_card_not_added_under_Service_Monitoring_section_of_page(String navigatedPage) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyAiresManagedBenefitCardNotDisplayed(), MessageFormat.format(
				MobilityXConstants.AIRES_MANAGED_BENEFIT_CARD_DISPLAYED_ON_MOBILITY_JOURNEY_PAGE, CoreConstants.FAIL));
	}

	@Given("^he has created a Service and SubService for following 'Aires Managed' benefit in Services tab of IRIS application$")
	public void he_has_created_a_Service_and_SubService_for_following_Aires_Managed_benefit_in_Services_tab_of_IRIS_application(
			DataTable dataTable) throws Throwable {

		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
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
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.SERVICE_TAB);
		CoreFunctions.waitHandler(5);
		String serviceName = dataMap.get(0).get("Service");
		testContext.getIrisPageManager().irisAssignmentServicePage = new IRIS_AssignmentServicePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentServicePage.verifyServiceTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.SERVICE));
		testContext.getIrisPageManager().irisAssignmentServicePage.addService(serviceName);
		testContext.getIrisPageManager().irisAssignmentServicePage.clickSaveButton();
		testContext.getIrisPageManager().irisAssignmentServicePage.clickOnAddSubServiceButton();
		testContext.getIrisPageManager().irisAssignmentServicePage.addSubService(IRISConstants.SUB_SERVICE,dataTable);
		testContext.getIrisPageManager().irisAssignmentServicePage.clickSaveButton();
		testContext.getBasePage().cleanIrisProcesses();
	}

	@Given("^he has verified \"([^\"]*)\" card having \"([^\"]*)\" status displayed under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void he_has_verified_card_having_status_displayed_under_Service_Monitoring_section_of_page(String cardBenefitName,
			String expectedStatus, String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(cardBenefitName,expectedStatus),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,cardBenefitName,pageName));
	}

	@When("^he actualize the \"([^\"]*)\" tracing in 'Activity & Finance' tab of of IRIS application$")
	public void he_actualize_the_tracing_in_Activity_Finance_tab_of_of_IRIS_application(String arg1) throws Throwable {

	}

	@Then("^\"([^\"]*)\" card status should be changed to \"([^\"]*)\" under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void card_status_should_be_changed_to_under_Service_Monitoring_section_of_page(String arg1, String arg2,
			String arg3) throws Throwable {

	}

}
