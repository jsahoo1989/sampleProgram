package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DetailsPage;
import com.aires.pages.iris.IRIS_ActivityAndFinancePage;
import com.aires.pages.iris.IRIS_AssignmentOverviewPage;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.pages.iris.IRIS_Welcome12C;
import com.aires.testdatatypes.coreflex.CoreFlex_LoginInfo;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_Transferee_StaticFixedPoints_PortionCashout_Flex_EndToEndFlow_Steps {

	private TestContext testContext;
	private TransfereeSubmissions_DetailsPage transfereeSubmissionsDetailsPage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;
	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private CoreFlex_LoginInfo _loginInfo;
	public static List<Map<String, String>> selectedBenefitDetails;

	public CF_Transferee_StaticFixedPoints_PortionCashout_Flex_EndToEndFlow_Steps(TestContext context) {
		testContext = context;
		CoreFlex_PolicyBenefitsCategoriesPage.pageObjectManager_CoreFlex = testContext.getCoreFlexPageObjectManager();
		testContext.getCoreFlexPageObjectManager().initializeCoreFlexPageObjects();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();
		mxTransfereeMyBenefitsBundlePage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeMyBenefitsBundlePage();
		transfereeSubmissionsDetailsPage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDetailsPage();
		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();

		_loginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getLoginByEnvt(BusinessFunctions.getEnvBasedOnExecutionType().toLowerCase());
	}

	@Given("^he has verified 'Portion Cashout' details on \"([^\"]*)\" page$")
	public void he_has_verified_Portion_Cashout_details_on_page(String sourcePage) throws Throwable {
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyCashoutDetailsOnFPT(), MessageFormat.format(
				MobilityXConstants.PORTION_CASHOUT_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE, CoreConstants.FAIL));
	}

	@Given("^he has verified Cashout details after actualizing following 'Tracing' in IRIS for 'After Relocation only - Tracing Set' selection in Blueprint application$")
	public void he_has_verified_Cashout_details_after_actualizing_following_Tracing_in_IRIS_for_After_Relocation_only_Tracing_Set_selection_in_Blueprint_application(
			DataTable dataTable) throws Throwable {

		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
		String tracingSetSelection = mxTransfereeFlexPlanningToolPage.getTracingSetSelection(dataMap);

		testContext.getBasePage().reLaunchIrisToAvoidFreezingIssue();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginInfo);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptLinkSuggestionDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.ACTIVITY_FINANCE_TAB);
		testContext.getIrisPageManager().irisActivityAndFinancePage = new IRIS_ActivityAndFinancePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisActivityAndFinancePage.verifyActivityAndFinanceTab(),
				MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
						IRISConstants.ACTIVITY_AND_FINANCE));
		testContext.getIrisPageManager().irisActivityAndFinancePage.displayActivityTable();
		testContext.getIrisPageManager().irisActivityAndFinancePage.actualizeTracingPrompt(IRISConstants.ACT_DATE,
				IRISConstants.ACTIVITY, tracingSetSelection);
		testContext.getIrisPageManager().irisActivityAndFinancePage.clickOnSaveBtn();
		testContext.getIrisPageManager().irisActivityAndFinancePage.acceptSavedSuccessDialog();
		testContext.getBasePage().cleanIrisProcesses();
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.ONPOINT_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyCashoutDetailsOnFPT(),
				MessageFormat.format(
						MobilityXConstants.AFTER_RELOCATION_CASHOUT_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has verified Cashout details displayed on 'OnPoint Planning Tool' page before actualizing Assignment_Transfer 'Tracing' in IRIS application$")
	public void he_has_verified_Cashout_details_displayed_on_OnPoint_Planning_Tool_page_before_actualizing_Assignment_Transfer_Tracing_in_IRIS_application()
			throws Throwable {
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyCashoutDetailsOnFPTBeforeTracingAct(),
				MessageFormat.format(
						MobilityXConstants.AFTER_RELOCATION_CASHOUT_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has navigated to \"([^\"]*)\" page after selecting required Benefits and Cashout on \"([^\"]*)\" page$")
	public void he_has_navigated_to_page_after_selecting_required_Benefits_and_Cashout_on_page(String navigatedPage,
			String sourcePage) throws Throwable {
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.selectBenefitsAndProceedToReviewAndSubmit(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_SELECT_BENEFITS_AND_PROCEED_TO_REVIEW_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
	}

	@Given("^he has clicked on \"([^\"]*)\" button after validating all the benefit and Cashout details listed under 'Selected Benefits' section on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_validating_all_the_benefit_and_Cashout_details_listed_under_Selected_Benefits_section_on_page(
			String reviewAndSubmitButton, String pageName) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifySelectedCashoutDetails(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_SELECTED_CASHOUT_DETAILS_ON_MY_BUNDLE_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifySelectedBenefitDetails(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.clickReviewAndSubmit();
	}

	@When("^he 'Delete' submitted Benefit_Cashout and confirms 'Remove Benefit Selection' dialog by entering username and clicking on \"([^\"]*)\"$")
	public void he_Delete_submited_Benefit_Cashout_and_confirms_Remove_Benefit_Selection_dialog_by_entering_username_and_clicking_on(
			String buttonName) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.deleteSubmittedBenefitAndCashout(buttonName), MessageFormat
				.format(MobilityXConstants.FAILED_TO_DELETE_SUBMITTED_BENEFIT_AND_CASHOUT, CoreConstants.FAIL));
	}

	@When("^he 'Delete' submitted Benefits and confirms 'Remove Benefit Selection' dialog by entering username and clicking on \"([^\"]*)\"$")
	public void he_Delete_submited_Benefits_and_confirms_Remove_Benefit_Selection_dialog_by_entering_username_and_clicking_on(
			String buttonName) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.deleteSubmittedBenefitAndCashout(buttonName), MessageFormat
				.format(MobilityXConstants.FAILED_TO_DELETE_SUBMITTED_BENEFIT_AND_CASHOUT, CoreConstants.FAIL));
	}

	@Then("^'Status' of the deleted benefit_cashout should be displayed as \"([^\"]*)\" under 'Submitted Benefits' section of 'My Benefit Bundle' page$")
	public void status_of_the_deleted_benefit_cashout_should_be_displayed_as_under_Submitted_Benefits_section_of_My_Benefit_Bundle_page(
			String arg1) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyDeletedBenefitCashoutStatus(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_DELETED_BENEFIT_AND_CASHOUT_STATUS, CoreConstants.FAIL));
	}

	@Given("^he has clicked on \"([^\"]*)\" followed by \"([^\"]*)\" button to resolve multiple 'Delete Request Pending' request of the Transferee$")
	public void he_has_clicked_on_followed_by_button_to_resolve_multiple_Delete_Request_Pending_request_of_the_Transferee(
			String checkAllButton, String resolveMultipleButton) throws Throwable {
		transfereeSubmissionsDetailsPage.clickElementOfPage(checkAllButton);
		transfereeSubmissionsDetailsPage.clickElementOfPage(resolveMultipleButton);
	}

	@When("^he confirms request by selecting \"([^\"]*)\" option after verifying 'Delete Request Pending' benefit request details on 'Requests' dialog$")
	public void he_confirms_request_by_selecting_option_after_verifying_Delete_Request_Pending_benefit_request_details_on_Requests_dialog(
			String action) throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyBenefitDetailsOnRequestsDialog(action),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_DELETE_REQUEST_BENEFIT_DETAILS_ON_REQUESTS_DIALOG,
						CoreConstants.FAIL));
		transfereeSubmissionsDetailsPage.clickElementOfPage(action);
	}

	@When("^he confirms request by selecting \"([^\"]*)\" option after verifying 'Delete Request Pending' benefit request details on 'Requests' dialog by Client$")
	public void he_confirms_request_by_selecting_option_after_verifying_Delete_Request_Pending_benefit_request_details_on_Requests_dialog_by_Client(
			String action) throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyBenefitDetailsOnRequestsDialogClient(action),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_DELETE_REQUEST_BENEFIT_DETAILS_ON_REQUESTS_DIALOG,
						CoreConstants.FAIL));
		transfereeSubmissionsDetailsPage.clickElementOfPage(action);
	}

	@When("^\"([^\"]*)\" delete request Benefit_Cashout details should be displayed under 'Transferee History' section with \"([^\"]*)\" status$")
	public void delete_request_Benefit_Cashout_details_should_be_displayed_under_Transferee_History_section_with_status(
			String action, String expectedStatus) throws Throwable {
		transfereeSubmissionsDetailsPage.clickElementOfPage(COREFLEXConstants.TRANSFEREE_HISTORY_SECTION);
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyTransfereeHistorySection(action), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_BENEFIT_CASHOUT_DETAILS_DISPLAYED_UNDER_HISTORY_SECTION_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
				CoreConstants.FAIL, action));
	}

}
