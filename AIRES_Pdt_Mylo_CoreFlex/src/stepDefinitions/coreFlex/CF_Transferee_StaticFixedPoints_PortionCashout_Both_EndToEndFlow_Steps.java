package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.PageObjectManager_CoreFlex;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DashboardHomePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DetailsPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;

public class CF_Transferee_StaticFixedPoints_PortionCashout_Both_EndToEndFlow_Steps {

	private TestContext testContext;
	private PageObjectManager_CoreFlex _pageObjectManagerCoreFlex;
	private TransfereeSubmissions_DashboardHomePage transfereeSubmissionsDashboardHomePage;
	private TransfereeSubmissions_DetailsPage transfereeSubmissionsDetailsPage;

	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;

	public static List<Map<String, String>> selectedBenefitDetails;

	public CF_Transferee_StaticFixedPoints_PortionCashout_Both_EndToEndFlow_Steps(TestContext context) {
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
	}

	@Given("^he has verified submitted points details on 'Mobility Journey Home' page$")
	public void he_has_verified_submitted_points_details_on_Mobility_Journey_Home_page()
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifySubmittedPointsDetails(), MessageFormat.format(
				MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_JOURNEY_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^he has verified submitted points details along with Post-Submission Portion Cashout details on 'Flex Planning Tool' page$")
	public void he_has_verified_submitted_points_details_along_with_Post_Submission_Portion_Cashout_details_on_Flex_Planning_Tool_page()
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessageAfterSubmission(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyPortionCashOutPostSubmissionOnFPT(),
				MessageFormat.format(MobilityXConstants.POST_SUBMISSION_PORTION_CASHOUT_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySubmittedPointsDetails(),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));		
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

}
