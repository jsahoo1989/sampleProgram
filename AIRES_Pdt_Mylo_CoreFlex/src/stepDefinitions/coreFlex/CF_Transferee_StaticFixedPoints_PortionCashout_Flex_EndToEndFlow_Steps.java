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
import com.aires.managers.PageObjectManager_CoreFlex;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DashboardHomePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DetailsPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_Transferee_StaticFixedPoints_PortionCashout_Flex_EndToEndFlow_Steps {

	private TestContext testContext;
	private PageObjectManager_CoreFlex _pageObjectManagerCoreFlex;
	private TransfereeSubmissions_DashboardHomePage transfereeSubmissionsDashboardHomePage;
	private TransfereeSubmissions_DetailsPage transfereeSubmissionsDetailsPage;

	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;

	public static List<Map<String, String>> selectedBenefitDetails;

	public CF_Transferee_StaticFixedPoints_PortionCashout_Flex_EndToEndFlow_Steps(TestContext context) {
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
	}

	@Given("^he has navigated to \"([^\"]*)\" page after selecting required benefits and PortionCashout on \"([^\"]*)\" page$")
	public void he_has_navigated_to_page_after_selecting_required_benefits_and_PortionCashout_on_page(
			String navigatedPage, String sourcePage) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyPortionCashOutOnFPT(), MessageFormat.format(
				MobilityXConstants.PORTION_CASHOUT_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.selectBenefitsAndProceedToReviewAndSubmit(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_SELECT_BENEFITS_AND_PROCEED_TO_REVIEW_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(MessageFormat.format(CoreConstants.TOTAL_TIME_TAKEN_BY_GIVEN,
				(CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000));
	}

	@Given("^he has clicked on \"([^\"]*)\" button after validating all the benefit and Cashout details listed under 'Selected Benefits' section on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_validating_all_the_benefit_and_Cashout_details_listed_under_Selected_Benefits_section_on_page(
			String reviewAndSubmitButton, String pageName) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifySelectedPortionCashoutDetails(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_SELECTED_PORTION_CASHOUT_DETAILS_ON_MY_BUNDLE_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifySelectedBenefitDetails(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.clickReviewAndSubmit();
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he 'Delete' submitted Benefit_Cashout and confirms 'Remove Benefit Selection' dialog by entering username and clicking on \"([^\"]*)\"$")
	public void he_Delete_submited_Benefit_Cashout_and_confirms_Remove_Benefit_Selection_dialog_by_entering_username_and_clicking_on(
			String buttonName) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.deleteSubmittedBenefitAndCashout(buttonName), MessageFormat
				.format(MobilityXConstants.FAILED_TO_DELETE_SUBMITTED_BENEFIT_AND_CASHOUT, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^'Status' of the deleted benefit_cashout should be displayed as \"([^\"]*)\" under 'Submitted Benefits' section of 'My Benefit Bundle' page$")
	public void status_of_the_deleted_benefit_cashout_should_be_displayed_as_under_Submitted_Benefits_section_of_My_Benefit_Bundle_page(
			String arg1) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyDeletedBenefitCashoutStatus(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_DELETED_BENEFIT_AND_CASHOUT_STATUS, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
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
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyBenefitDetailsOnRequestsDialog(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_DELETE_REQUEST_BENEFIT_DETAILS_ON_REQUESTS_DIALOG,
						CoreConstants.FAIL));
		transfereeSubmissionsDetailsPage.clickElementOfPage(action);		
	}

}
