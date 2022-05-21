package stepDefinitions.coreFlex;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
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

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_Transferee_MobilityJourney_Both_Cards_Steps {

	private TestContext testContext;
	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;
	int _initialTableRowCount = 0;
	private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader()
			.getLoginByApplication(CoreFunctions.getPropertyFromConfig("application").toLowerCase());

	public CF_Transferee_MobilityJourney_Both_Cards_Steps(TestContext context) {
		testContext = context;

		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();
		mxTransfereeMyBenefitsBundlePage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeMyBenefitsBundlePage();
	}

	/**********************************************************************/

	@Given("^he has verified submitted Aires Managed Benefit Flex and Core card having \"([^\"]*)\" status displayed under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void he_has_verified_submitted_Aires_Managed_Benefit_Flex_and_Core_card_having_status_displayed_under_Service_Monitoring_section_of_page(
			String expectedStatus, String pageName) throws Throwable {
		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(expectedStatus), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL, pageName));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(expectedStatus), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL, pageName));
	}

	@Given("^he has verified \"([^\"]*)\" Core card having \"([^\"]*)\" status displayed under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void he_has_verified_Core_card_having_status_displayed_under_Service_Monitoring_section_of_page(
			String cardBenefitName, String expectedStatus, String pageName) throws Throwable {
		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(expectedStatus), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL, pageName));
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyFlexCardForNotSubmittedAiresManagedBenefit(),
				MessageFormat.format(MobilityXConstants.FLEX_CARD_DISPLAYED_FOR_NOT_SUBMITTED_AIRES_MANAGED_BENEFIT,
						CoreConstants.FAIL, pageName));
	}

	@Then("^selected Aires Managed Benefit Core card having \"([^\"]*)\" status should be displayed under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void selected_Aires_Managed_Benefit_Core_card_having_status_should_be_displayed_under_Service_Monitoring_section_of_page(String expectedStatus, String pageName) throws Throwable {
		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(expectedStatus), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL, pageName));
	}

	@Then("^Flex card should not be displayed for Selected/Not-Submitted Aires Managed Benefit on \"([^\"]*)\" page$")
	public void Flex_card_should_not_be_displayed_for_selected_Not_Submitted_Aires_Managed_Benefit_on_page(String pageName) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyFlexCardForNotSubmittedAiresManagedBenefit(),
				MessageFormat.format(MobilityXConstants.FLEX_CARD_DISPLAYED_FOR_NOT_SUBMITTED_AIRES_MANAGED_BENEFIT,
						CoreConstants.FAIL, pageName));
	}

	@Given("^he has verified submitted Aires Managed Benefit Flex and Core card status updated to \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void he_has_verified_submitted_Aires_Managed_Benefit_card_status_updated_to_on_page(String expectedStatus,
			String pageName) throws Throwable {
		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(expectedStatus), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL, pageName));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(expectedStatus), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL, pageName));
	}

	@Given("^he has verified submitted Aires Managed Benefit status updated to \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void he_has_verified_submitted_Aires_Managed_Benefit_status_updated_to_on_page(String expectedStatus,
			String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedAiresManagedBenefitDetails(expectedStatus),
				MessageFormat.format(MobilityXConstants.SUBMITTED_AIRES_MANAGED_BENEFIT_DETAILS_NOT_MATCHED,
						CoreConstants.FAIL, pageName));
	}

	@Then("^submitted Aires Managed Benefit Flex and Core card status should be updated to \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void submitted_Aires_Managed_Benefit_Flex_and_Core_card_status_should_be_updated_to_on_page(
			String expectedStatus, String pageName) throws Throwable {
		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(expectedStatus), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL, pageName));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(expectedStatus), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL, pageName));
	}

	@Then("^submitted Aires Managed Benefit status should be updated to \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void submitted_Aires_Managed_Benefit_status_should_be_updated_to_on_page(String expectedStatus,
			String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedAiresManagedBenefitDetails(expectedStatus),
				MessageFormat.format(MobilityXConstants.SUBMITTED_AIRES_MANAGED_BENEFIT_DETAILS_NOT_MATCHED,
						CoreConstants.FAIL, pageName));
	}

	@When("^he change status of the following 'Aires Managed' benefit SubService to \"([^\"]*)\" from Services tab of IRIS application$")
	public void he_change_status_of_the_following_Aires_Managed_benefit_SubService_to_from_Services_tab_of_IRIS_application(
			String subServiceStatus, DataTable dataTable) throws Throwable {
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
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.SERVICE_TAB);
		CoreFunctions.waitHandler(2);
		testContext.getIrisPageManager().irisAssignmentServicePage = new IRIS_AssignmentServicePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentServicePage.verifyServiceTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.SERVICE));
		testContext.getIrisPageManager().irisAssignmentServicePage.selectService(IRISConstants.SERVICE);
		testContext.getIrisPageManager().irisAssignmentServicePage.selectSubService(IRISConstants.SUB_SERVICE);
		testContext.getIrisPageManager().irisAssignmentOverviewPage.setSubServiceStatus(subServiceStatus);
		testContext.getBasePage().cleanIrisProcesses();
	}

}
