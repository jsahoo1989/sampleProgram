package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_LoginPage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DashboardHomePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DetailsPage;
import com.aires.pages.coreflex.TransfereeSubmissions_LoginPage;
import com.vimalselvam.cucumber.listener.Reporter;

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
	private MX_Transferee_LoginPage mxTransfereeLoginPage;
	private TransfereeSubmissions_LoginPage transfereeSubmissionsLoginPage;

	public static List<Map<String, String>> selectedBenefitDetails;

	public CF_Transferee_StaticFixedPoints_CashNotAuth_Both_EndToEndFlow_Steps(TestContext context) {
		testContext = context;
		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();
		mxTransfereeMyBenefitsBundlePage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeMyBenefitsBundlePage();
		transfereeSubmissionsDashboardHomePage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDashboardHomePage();
		transfereeSubmissionsDetailsPage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDetailsPage();
		mxTransfereeLoginPage = testContext.getCoreFlexPageObjectManager().getMXTransfereeLoginPage();
		transfereeSubmissionsLoginPage = testContext.getCoreFlexPageObjectManager().getTransfereeSubmissionsLoginPage();
	}

	@Given("^he has clicked on \"([^\"]*)\" button for a benefit under 'Submitted Benefits' section$")
	public void he_has_clicked_on_button_for_a_benefit_under_Submitted_Benefits_section(String action)
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.performSubmittedBenefitAction(action),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DELETE_SUBMITTED_BENEFIT, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he confirms 'Remove Benefit Selection' dialog by entering username and clicking on \"([^\"]*)\"$")
	public void he_confirms_Remove_Benefit_Selection_dialog_by_entering_username_and_clicking_on(String buttonName)
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isDeleteBenefitPopupDisplayed(), MessageFormat
				.format(MobilityXConstants.REMOVE_BENEFIT_SELECTION_POPUP_NOT_DISPLAYED, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyBenefitsDetailsOnRemoveBenefitDialog(),
				MessageFormat.format(MobilityXConstants.POINTS_AND_BENEFIT_DETAILS_NOT_MATCHED_ON_SUBMIT_BUNDLE_POPUP,
						CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.reviewAndConfirmRemoveBenefitSubmission(
				MobilityXConstants.SUBMIT_BENEFITS_OPTIONAL_NOTES,
				CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
						+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
				buttonName);
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^'Delete Request Sent' growl message should be displayed on 'My Benefit Bundle' page$")
	public void delete_Request_Sent_growl_message_should_be_displayed_on_My_Benefit_Bundle_page() throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyRemoveBenefitRequestSuccessMessage(), MessageFormat
				.format(MobilityXConstants.DELETE_BENEFIT_REQUEST_SENT_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^'Status' of the deleted benefit should be displayed as \"([^\"]*)\" under 'Submitted Benefits' section of 'My Benefit Bundle' page$")
	public void status_of_the_deleted_benefit_should_be_displayed_as_under_Submitted_Benefits_section_of_My_Benefit_Bundle_page(
			String arg1) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyDeletedBenefitStatus(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_DELETED_BENEFIT_STATUS, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has clicked on \"([^\"]*)\" button for Bundle submitted by the transferee on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_for_Bundle_submitted_by_the_transferee_on_page(String btnName, String pageName)
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		transfereeSubmissionsDashboardHomePage.clickElementOfPage(btnName);
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^he has navigated to \"([^\"]*)\" page having list of submitted benefits details$")
	public void he_has_navigated_to_page_having_list_of_submitted_benefits_details(String pageName) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifiyPageNavigation(pageName),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
						CoreConstants.FAIL, pageName));
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyTransfereeAndPointsDetails(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_TRANSFEREE_AND_POINTS_DETAILS_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifySubmittedBenefitsDetails(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_SUBMITTED_BENEFITS_DETAILS_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
				CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has clicked on \"([^\"]*)\" button for 'Delete Request Pending' request of the Transferee$")
	public void he_has_clicked_on_button_for_Delete_Request_Pending_request_of_the_Transferee(String btnName)
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		transfereeSubmissionsDetailsPage.clickElementOfPage(btnName);
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he confirms the \"([^\"]*)\" after verifying 'Delete Request Pending' benefit request details and adding comments on 'Requests' dialog$")
	public void he_confirms_the_after_verifying_Delete_Request_Pending_benefit_request_details_and_adding_comments_on_Requests_dialog(
			String action) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyBenefitDetailsOnRequestsDialog(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_DELETE_REQUEST_BENEFIT_DETAILS_ON_REQUESTS_DIALOG,
						CoreConstants.FAIL));
		transfereeSubmissionsDetailsPage.clickElementOfPage(action);
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^'Action Completed' growl message for \"([^\"]*)\" should be displayed on \"([^\"]*)\" page$")
	public void Action_Completed_growl_message_for_should_be_displayed_on_page(String actionPerformed, String pageName)
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyActionCompletedMessage(actionPerformed, pageName),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_ACTION_COMPLETED_GROWL_MESSAGE_ON_TRANSFEREE_SUBMISSION_DETAILS_PAGE,
						CoreConstants.FAIL));
//		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyBenefitDeleteRequestEmail(actionPerformed), MessageFormat
//				.format(MobilityXConstants.FAILED_TO_READ_USER_CREDENTIALS_FROM_GENERATED_EMAIL, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^'Delete Request Pending' benefit request should be removed from 'Transferee Submission Details' list$")
	public void delete_Request_Pending_benefit_request_should_be_removed_from_Transferee_Submission_Details_list()
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyApprovedDeleteRequestRemovedFromList(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DETAILS_POST_APPROVE_DELETE_BENEFIT_REQUEST_OPERATION_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^'Delete Request Pending' benefit request status should be updated to 'Submitted' in 'Transferee Submission Details' list$")
	public void delete_Request_Pending_benefit_request_status_should_be_updated_to_Submitted_in_Transferee_Submission_Details_list()
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifySubmittedBenefitsDetails(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_DENY_DELETE_REQUEST_UPDATED_TO_SUBMITTED_IN_TRANSFEREE_SUBMISSION_DETAILS_PAGE,
				CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^benefit details should be updated in 'MXTransferee' application based on \"([^\"]*)\" 'Delete Request' on Transferee Submission$")
	public void benefit_details_should_be_updated_in_MXTransferee_application_based_on_Delete_Request_on_Transferee_Submission(
			String actionPerformed) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		testContext.getWebDriverManager().getDriver().navigate()
				.to(FileReaderManager.getInstance().getConfigReader().getMobilityXUrl());
		mxTransfereeLoginPage.enterUsernameAndPasswordForMobilityX(
				CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail"),
				CoreFunctions.getPropertyFromConfig("Transferee_PasswordInEMail"));
		mxTransfereeLoginPage.clickSignIn();
		mxTransfereeJourneyHomePage.handle_Cookie_AfterLogin();
		mxTransfereeJourneyHomePage.handle_points_expiry_reminder_popup();
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifySubmittedPointsDetails(),
				MessageFormat.format(
						MobilityXConstants.REMAINING_AVAILABLE_POINTS_DETAILS_NOT_MATCHED_ON_JOURNEY_HOME_PAGE,
						CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.navigateToFlexPlanningToolPage();
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessageAfterSubmission(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySubmittedPointsDetails(),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedBenefitDetailsPostDeleteRequestOperation(
				actionPerformed), MobilityXConstants.BENEFIT_CASHOUT_DETAILS_NOT_MATCHED_ON_MBB_PAGE);
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" button for the deleted benefit under 'Submitted Benefits' section of 'MXTransferee' application$")
	public void he_clicks_on_button_for_the_deleted_benefit_under_Submitted_Benefits_section_of_MXTransferee_application(
			String action) throws Throwable {

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		testContext.getWebDriverManager().getDriver().navigate()
				.to(FileReaderManager.getInstance().getConfigReader().getMobilityXUrl());
		mxTransfereeLoginPage.enterUsernameAndPasswordForMobilityX(
				CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail"),
				CoreFunctions.getPropertyFromConfig("Transferee_PasswordInEMail"));
		mxTransfereeLoginPage.clickSignIn();
		mxTransfereeJourneyHomePage.handle_Cookie_AfterLogin();
		mxTransfereeJourneyHomePage.handle_points_expiry_reminder_popup();
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifySubmittedPointsDetails(),
				MessageFormat.format(
						MobilityXConstants.REMAINING_AVAILABLE_POINTS_DETAILS_NOT_MATCHED_ON_JOURNEY_HOME_PAGE,
						CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.navigateToFlexPlanningToolPage();		
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessageAfterSubmission(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySubmittedPointsDetails(),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.performSubmittedBenefitAction(action),
				MessageFormat.format(MobilityXConstants.FAILED_TO_UNDO_DELETED_BENEFIT, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^'Undo Request Completed' growl message should be displayed on 'My Benefits Bundle' page$")
	public void undo_Request_Completed_growl_message_should_be_displayed_on_My_Benefits_Bundle_page() throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyUndoSuccessMessage(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_UNDO_SUCCESS_MESSAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^'Delete Request Pending' benefit status should be updated to 'View Payments' in 'Submitted Benefits' list on 'My Benefits Bundle' page$")
	public void delete_Request_Pending_benefit_status_should_be_updated_to_View_Payments_in_Submitted_Benefits_list_on_My_Benefits_Bundle_page()
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedBenefitDetails(),
				MobilityXConstants.SUBMITTED_BENEFIT_DETAILS_NOT_MATCHED);
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Then("^'Delete Request Pending' benefit request status should be updated to 'Submitted' in 'Transferee Submission Details' list of 'Transferee Submissions' application$")
	public void delete_Request_Pending_benefit_request_status_should_be_updated_to_Submitted_in_Transferee_Submission_Details_list_of_Transferee_Submissions_application()
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		testContext.getWebDriverManager().getDriver().navigate()
		.to(FileReaderManager.getInstance().getConfigReader().getCoreFlexTransfereeSubmissionsApplicationUrl());
		transfereeSubmissionsDashboardHomePage.clickElementOfPage(COREFLEXConstants.REVIEW);
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifySubmittedBenefitsDetails(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_DENY_DELETE_REQUEST_UPDATED_TO_SUBMITTED_IN_TRANSFEREE_SUBMISSION_DETAILS_PAGE,
				CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

}
