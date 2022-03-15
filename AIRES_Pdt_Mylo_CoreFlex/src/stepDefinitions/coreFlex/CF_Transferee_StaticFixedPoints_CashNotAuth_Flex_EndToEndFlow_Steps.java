package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

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

public class CF_Transferee_StaticFixedPoints_CashNotAuth_Flex_EndToEndFlow_Steps {

	private TestContext testContext;
	private PageObjectManager_CoreFlex _pageObjectManagerCoreFlex;
	private TransfereeSubmissions_DashboardHomePage transfereeSubmissionsDashboardHomePage;
	private TransfereeSubmissions_DetailsPage transfereeSubmissionsDetailsPage;

	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;

	public static List<Map<String, String>> selectedBenefitDetails;

	public CF_Transferee_StaticFixedPoints_CashNotAuth_Flex_EndToEndFlow_Steps(TestContext context) {
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

	@Given("^he has navigated to \"([^\"]*)\" page after selecting required benefits on \"([^\"]*)\" page$")
	public void he_has_navigated_to_page_after_selecting_required_benefits_on_page(String navigatedPage,
			String sourcePage) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.selectBenefitsAndProceedToReviewAndSubmit(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_SELECT_BENEFITS_AND_PROCEED_TO_REVIEW_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(MessageFormat.format(CoreConstants.TOTAL_TIME_TAKEN_BY_GIVEN,
				(CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000));
	}

	@Given("^he has navigated to \"([^\"]*)\" page having record of Bundle submitted by the transferee$")
	public void he_has_navigated_to_page_having_record_of_Bundle_submitted_by_the_transferee(String pageName)
			throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDashboardHomePage.verifyTransfereeBundleSubmissionDetails(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
						CoreConstants.FAIL));
	}

	@When("^he clicks on \"([^\"]*)\" button for Bundle submitted by the transferee on \"([^\"]*)\" page$")
	public void he_clicks_on_button_for_Bundle_submitted_by_the_transferee_on_page(String btnName, String pageName)
			throws Throwable {
		transfereeSubmissionsDashboardHomePage.clickElementOfPage(btnName);
	}

	@Then("^he should be navigated to \"([^\"]*)\" page having list of benefits submmited in the bundle along with Quantity, Benefits Points, Added Comments, Remaining Points$")
	public void he_should_be_navigated_to_page_having_list_of_benefits_submmited_in_the_bundle_along_with_Quantity_Benefits_Points_Added_Comments_Remaining_Points(
			String pageName) throws Throwable {
		transfereeSubmissionsDetailsPage = _pageObjectManagerCoreFlex.getTransfereeSubmissionsDetailsPage();
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

	@When("^he has created a payment account to credit portion cashout amount$")
	public void he_has_created_a_payment_account_to_credit_portion_cashout_amount() {
		Assert.assertTrue(mxTransfereeJourneyHomePage.setUpPaymentAccount(),
				MobilityXConstants.FAILED_TO_SETUP_PAYMENT_ACCOUNT);
	}

	@Then("^submitted benefit details should be displayed under 'Submitted Benefits' section of 'My Benefits Bundle' page$")
	public void submitted_benefit_details_should_be_displayed_under_Submitted_Benefits_section_of_my_benefits_bundle_page() {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedBenefitDetails(),
				MobilityXConstants.SUBMITTED_BENEFIT_DETAILS_NOT_MATCHED);
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Then("^'Mobility Flex Benefit\\(s\\) Submission' email should be generated for the submitted benefit bundle$")
	public void mobility_Flex_Benefit_s_Submission_email_should_be_generated_for_the_submitted_benefit_bundle() throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyBenefitSubmissionEmail(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_READ_USER_CREDENTIALS_FROM_GENERATED_EMAIL, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^point balance details should be upadted on \"([^\"]*)\" page$")
	public void available_points_details_should_be_upadted_on_Flex_Planning_Tool_page(String pageName) {
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyUpdatedPointDetails(),
				MobilityXConstants.UPDATED_POINT_BALANCE_DETAILS_NOT_MATCHED);
	}
}
