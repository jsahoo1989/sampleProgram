package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.coreflex.MobilityX_LoginPage;
import com.aires.pages.coreflex.TransfereeSubmissions_DashboardHomePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DetailsPage;
import com.aires.pages.coreflex.TransfereeSubmissions_LoginPage;
import com.aires.testdatatypes.coreflex.CoreFlex_LoginInfo;
import com.aires.testdatatypes.coreflex.TransfereeSubmissions_LoginData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_Transferee_StaticFixedPoints_CashNotAuth_Both_EndToEndFlow_Steps {

	private TestContext testContext;
	private TransfereeSubmissions_DashboardHomePage transfereeSubmissionsDashboardHomePage;
	private TransfereeSubmissions_DetailsPage transfereeSubmissionsDetailsPage;

	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;
	private MobilityX_LoginPage mobilityXLoginPage;
	private TransfereeSubmissions_LoginPage transfereeSubmissionsLoginPage;
	private CoreFlex_LoginInfo _coreFlexLoginInfo;

	public static List<Map<String, String>> selectedBenefitDetails;

	public CF_Transferee_StaticFixedPoints_CashNotAuth_Both_EndToEndFlow_Steps(TestContext context) {
		testContext = context;
		CoreFlex_PolicyBenefitsCategoriesPage.pageObjectManager_CoreFlex = testContext.getCoreFlexPageObjectManager();
		testContext.getCoreFlexPageObjectManager().initializeCoreFlexPageObjects();
		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();
		mxTransfereeMyBenefitsBundlePage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeMyBenefitsBundlePage();
		transfereeSubmissionsDashboardHomePage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDashboardHomePage();
		transfereeSubmissionsDetailsPage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDetailsPage();
		mobilityXLoginPage = testContext.getCoreFlexPageObjectManager().getMobilityXLoginPage();
		transfereeSubmissionsLoginPage = testContext.getCoreFlexPageObjectManager().getTransfereeSubmissionsLoginPage();

//		_coreFlexLoginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
//				.getLoginByEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase());
		_coreFlexLoginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader().getLoginByEnvt(System.getProperty("envt").toLowerCase());
	}
	
	/********************************************************************************************/

	private TransfereeSubmissions_LoginData _transfereeSubmissionLoginData = FileReaderManager.getInstance()
			.getCoreFlexJsonReader().getTransfereeSubmissionLoginDataList(COREFLEXConstants.TRANSFEREE_SUBMISSIONS);
	
	/********************************************************************************************/

	@Given("^he has clicked on \"([^\"]*)\" button for a benefit under 'Submitted Benefits' section$")
	public void he_has_clicked_on_button_for_a_benefit_under_Submitted_Benefits_section(String action)
			throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.performSubmittedBenefitAction(action),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DELETE_SUBMITTED_BENEFIT, CoreConstants.FAIL));
	}

	@When("^he confirms 'Remove Benefit Selection' dialog by entering username and clicking on \"([^\"]*)\"$")
	public void he_confirms_Remove_Benefit_Selection_dialog_by_entering_username_and_clicking_on(String buttonName)
			throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isDeleteBenefitPopupDisplayed(), MessageFormat
				.format(MobilityXConstants.REMOVE_BENEFIT_SELECTION_POPUP_NOT_DISPLAYED, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.deleteSubmittedBenefitAndCashout(buttonName), MessageFormat
				.format(MobilityXConstants.FAILED_TO_DELETE_SUBMITTED_BENEFIT_AND_CASHOUT, CoreConstants.FAIL));
	}

	@Then("^'Delete Request Sent' growl message should be displayed on 'My Benefit Bundle' page$")
	public void delete_Request_Sent_growl_message_should_be_displayed_on_My_Benefit_Bundle_page() throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyRemoveBenefitRequestSuccessMessage(), MessageFormat
				.format(MobilityXConstants.DELETE_BENEFIT_REQUEST_SENT_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL));
	}

	@Then("^'Status' of the deleted benefit should be displayed as \"([^\"]*)\" under 'Submitted Benefits' section of 'My Benefit Bundle' page$")
	public void status_of_the_deleted_benefit_should_be_displayed_as_under_Submitted_Benefits_section_of_My_Benefit_Bundle_page(
			String arg1) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyDeletedBenefitStatus(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_DELETED_BENEFIT_STATUS, CoreConstants.FAIL));
	}

	@Given("^he has clicked on \"([^\"]*)\" button for Bundle submitted by the transferee on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_for_Bundle_submitted_by_the_transferee_on_page(String btnName, String pageName)
			throws Throwable {
		transfereeSubmissionsDashboardHomePage.clickElementOfPage(btnName);
		
	}

	@Given("^he has navigated to \"([^\"]*)\" page having list of submitted benefits details$")
	public void he_has_navigated_to_page_having_list_of_submitted_benefits_details(String pageName) throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifiyPageNavigation(pageName),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
						CoreConstants.FAIL, pageName));

		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyTransfereeAndPointsDetails(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_TRANSFEREE_AND_POINTS_DETAILS_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifySubmittedBenefitsDetails(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_SUBMITTED_BENEFITS_DETAILS_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
				CoreConstants.FAIL));
	}

	@Given("^he has clicked on \"([^\"]*)\" button for 'Delete Request Pending' request of the Transferee$")
	public void he_has_clicked_on_button_for_Delete_Request_Pending_request_of_the_Transferee(String btnName)
			throws Throwable {
		transfereeSubmissionsDetailsPage.clickElementOfPage(btnName);
	}

	@When("^he confirms the \"([^\"]*)\" after verifying 'Delete Request Pending' benefit request details and adding comments on 'Requests' dialog$")
	public void he_confirms_the_after_verifying_Delete_Request_Pending_benefit_request_details_and_adding_comments_on_Requests_dialog(
			String action) throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyRequestsDialogDisplayed(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_REQUESTS_DIALOG_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
						CoreConstants.FAIL));

		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyBenefitDetailsOnRequestsDialog(action),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_DELETE_REQUEST_BENEFIT_DETAILS_ON_REQUESTS_DIALOG,
						CoreConstants.FAIL));
		transfereeSubmissionsDetailsPage.clickElementOfPage(action);
	}

	@When("^'Action Completed' growl message for \"([^\"]*)\" should be displayed on \"([^\"]*)\" page$")
	public void Action_Completed_growl_message_for_should_be_displayed_on_page(String actionPerformed, String pageName)
			throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyActionCompletedMessage(actionPerformed, pageName),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_ACTION_COMPLETED_GROWL_MESSAGE_ON_TRANSFEREE_SUBMISSION_DETAILS_PAGE,
						CoreConstants.FAIL));
	}

	@When("^\"([^\"]*)\" email should be sent to Transferee for benefit \"([^\"]*)\" action by \"([^\"]*)\" user$")
	public void Delete_Request_Denied_email_should_be_sent_to_Transferee_for_benefit_action_by_user(String emailSubject,
			String actionPerformed, String user) throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyBenefitDeleteRequestEmail(actionPerformed),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_MOBILITY_FLEX_BENEFIT_DELETE_REQUEST_EMAIL,
						CoreConstants.FAIL, actionPerformed, emailSubject));
	}

	@When("^\"([^\"]*)\" email should be sent to Client for benefit \"([^\"]*)\" action by \"([^\"]*)\" user$")
	public void Delete_Request_Denied_email_should_be_sent_to_Client_for_benefit_action_by_user(String emailSubject,
			String actionPerformed, String user) throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyBenefitDeleteRequestEmailClient(actionPerformed),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_MOBILITY_FLEX_BENEFIT_DELETE_REQUEST_EMAIL,
						CoreConstants.FAIL, actionPerformed, emailSubject));
	}

	@Then("^'Delete Request Pending' benefit request should be removed from 'Transferee Submission Details' list$")
	public void delete_Request_Pending_benefit_request_should_be_removed_from_Transferee_Submission_Details_list()
			throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyApprovedDeleteRequestRemovedFromList(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DETAILS_POST_APPROVE_DELETE_BENEFIT_REQUEST_OPERATION_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
						CoreConstants.FAIL));
	}

	@Then("^'Delete Request Pending' benefit request status should be updated to 'Submitted' in 'Transferee Submission Details' list$")
	public void delete_Request_Pending_benefit_request_status_should_be_updated_to_Submitted_in_Transferee_Submission_Details_list()
			throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifySubmittedBenefitsDetails(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_DENY_DELETE_REQUEST_UPDATED_TO_SUBMITTED_IN_TRANSFEREE_SUBMISSION_DETAILS_PAGE,
				CoreConstants.FAIL));
	}

	@Then("^benefit details should be updated in 'MXTransferee' application based on \"([^\"]*)\" 'Delete Request' on Transferee Submission$")
	public void benefit_details_should_be_updated_in_MXTransferee_application_based_on_Delete_Request_on_Transferee_Submission(
			String actionPerformed) throws Throwable {

		testContext.getWebDriverManager().getDriver().navigate().to(_coreFlexLoginInfo.details.mobilityXURL);
		mobilityXLoginPage.enterUsernameAndPasswordForMobilityX(
				CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail"),
				CoreFunctions.getPropertyFromConfig("Transferee_PasswordInEMail"));
		mobilityXLoginPage.clickSignIn();
		mxTransfereeJourneyHomePage.handle_Cookie_AfterLogin();
		mxTransfereeJourneyHomePage.handle_points_expiry_reminder_popup();
		mxTransfereeJourneyHomePage
				.progressOrSkipMobilityJourneyHomePage(MobilityXConstants.ROUTE_TO_TRANSFEREE_JOURNEY_HOME_PAGE);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifySubmittedPointsDetails(),
				MessageFormat.format(
						MobilityXConstants.REMAINING_AVAILABLE_POINTS_DETAILS_NOT_MATCHED_ON_JOURNEY_HOME_PAGE,
						CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.ONPOINT_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessageAfterSubmission(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySubmittedPointsDetails(),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				mxTransfereeMyBenefitsBundlePage
						.validateSubmittedBenefitDetailsPostDeleteRequestOperation(actionPerformed),
				MessageFormat.format(MobilityXConstants.BENEFIT_CASHOUT_DETAILS_NOT_MATCHED_ON_MBB_PAGE,
						CoreConstants.FAIL));

	}

	@When("^he clicks on \"([^\"]*)\" button for the deleted benefit under 'Submitted Benefits' section of 'MXTransferee' application$")
	public void he_clicks_on_button_for_the_deleted_benefit_under_Submitted_Benefits_section_of_MXTransferee_application(
			String action) throws Throwable {
		testContext.getWebDriverManager().getDriver().navigate().to(_coreFlexLoginInfo.details.mobilityXURL);
		mobilityXLoginPage.enterUsernameAndPasswordForMobilityX(
				CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail"),
				CoreFunctions.getPropertyFromConfig("Transferee_PasswordInEMail"));
		mobilityXLoginPage.clickSignIn();
		mxTransfereeJourneyHomePage.handle_Cookie_AfterLogin();
		mxTransfereeJourneyHomePage.handle_points_expiry_reminder_popup();
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifySubmittedPointsDetails(),
				MessageFormat.format(
						MobilityXConstants.REMAINING_AVAILABLE_POINTS_DETAILS_NOT_MATCHED_ON_JOURNEY_HOME_PAGE,
						CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessageAfterSubmission(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySubmittedPointsDetails(),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.performSubmittedBenefitAction(action),
				MessageFormat.format(MobilityXConstants.FAILED_TO_UNDO_DELETED_BENEFIT, CoreConstants.FAIL));
	}

	@Then("^'Undo Request Completed' growl message should be displayed on 'My Benefits Bundle' page$")
	public void undo_Request_Completed_growl_message_should_be_displayed_on_My_Benefits_Bundle_page() throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyUndoSuccessMessage(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_UNDO_SUCCESS_MESSAGE, CoreConstants.FAIL));
	}

	@Then("^'Delete Request Pending' benefit status should be updated to 'View Payments' in 'Submitted Benefits' list on 'My Benefits Bundle' page$")
	public void delete_Request_Pending_benefit_status_should_be_updated_to_View_Payments_in_Submitted_Benefits_list_on_My_Benefits_Bundle_page()
			throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedBenefitDetails(),
				MobilityXConstants.SUBMITTED_BENEFIT_DETAILS_NOT_MATCHED);
	}

	@Then("^'Delete Request Pending' benefit request status should be updated to 'Submitted' in 'Transferee Submission Details' list of 'Transferee Submissions' application$")
	public void delete_Request_Pending_benefit_request_status_should_be_updated_to_Submitted_in_Transferee_Submission_Details_list_of_Transferee_Submissions_application()
			throws Throwable {
		testContext.getWebDriverManager().getDriver().navigate()
				.to(_coreFlexLoginInfo.details.transfereeSubmissionsURL);
		Assert.assertTrue(
				transfereeSubmissionsDashboardHomePage.verifyUserLogin(
						transfereeSubmissionsLoginPage.getCSMUserName(_transfereeSubmissionLoginData),
						COREFLEXConstants.TRANSFEREE_SUBMISSIONS_DASHBOARD_HOME_PAGE),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_TRANSFEREE_SUBMISSIONS_DASHBOARD_HOME_PAGE,
						CoreConstants.FAIL));
		transfereeSubmissionsDashboardHomePage.clickElementOfPage(COREFLEXConstants.REVIEW);
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifySubmittedBenefitsDetails(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_DENY_DELETE_REQUEST_UPDATED_TO_SUBMITTED_IN_TRANSFEREE_SUBMISSION_DETAILS_PAGE,
				CoreConstants.FAIL));
	}

}
