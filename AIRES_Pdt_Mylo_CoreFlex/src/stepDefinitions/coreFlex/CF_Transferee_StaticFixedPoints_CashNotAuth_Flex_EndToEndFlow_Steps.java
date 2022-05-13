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
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DetailsPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_Transferee_StaticFixedPoints_CashNotAuth_Flex_EndToEndFlow_Steps {

	private TestContext testContext;
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
		transfereeSubmissionsDetailsPage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDetailsPage();
	}

	@Given("^he has navigated to \"([^\"]*)\" page after selecting required benefits on \"([^\"]*)\" page$")
	public void he_has_navigated_to_page_after_selecting_required_benefits_on_page(String navigatedPage,
			String sourcePage) throws Throwable {		
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.selectBenefitsAndProceedToReviewAndSubmit(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_SELECT_BENEFITS_AND_PROCEED_TO_REVIEW_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>My Benefits Bundle</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
	}	

	@Then("^he should be navigated to \"([^\"]*)\" page having list of submitted benefits details$")
	public void he_should_be_navigated_to_page_having_list_of_submitted_benefits_details(
			String pageName) throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifiyPageNavigation(pageName),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
						CoreConstants.FAIL, pageName));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Transferee Submissions Detail</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
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
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedBenefitDetails(),
				MobilityXConstants.SUBMITTED_BENEFIT_DETAILS_NOT_MATCHED);
	}
	
	@Then("^'Mobility Flex Benefit\\(s\\) Submission' email should be generated for the submitted benefit bundle$")
	public void mobility_Flex_Benefit_s_Submission_email_should_be_generated_for_the_submitted_benefit_bundle() throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyBenefitSubmissionEmail(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_READ_USER_CREDENTIALS_FROM_GENERATED_EMAIL, CoreConstants.FAIL));
	}

	@Then("^point balance details should be upadted on \"([^\"]*)\" page$")
	public void available_points_details_should_be_upadted_on_Flex_Planning_Tool_page(String pageName) {
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyUpdatedPointDetails(),
				MobilityXConstants.UPDATED_POINT_BALANCE_DETAILS_NOT_MATCHED);
	}
}
