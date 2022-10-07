package stepDefinitions.coreFlex;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.iris.IRIS_AssignmentOverviewPage;
import com.aires.pages.iris.IRIS_AssignmentServicePage;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.pages.iris.IRIS_Welcome12C;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;

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
		CoreFlex_PolicyBenefitsCategoriesPage.pageObjectManager_CoreFlex = testContext.getCoreFlexPageObjectManager();
		testContext.getCoreFlexPageObjectManager().initializeCoreFlexPageObjects();
		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();
		mxTransfereeMyBenefitsBundlePage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeMyBenefitsBundlePage();
	}

	/**********************************************************************/

	@Given("^he has verified submitted Aires Managed Benefit Flex and Core card status updated to \"([^\"]*)\" on \"([^\"]*)\" page - \"([^\"]*)\"$")
	public void he_has_verified_submitted_Aires_Managed_Benefit_Flex_and_Core_card_status_updated_to_on_page(
			String expectedStatus, String pageName, String tracingSelection) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(expectedStatus, tracingSelection),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,
						pageName));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(tracingSelection), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL, pageName));
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
	}
	
	@Given("^he has verified submitted Benefits Flex and Core card status updated to \"([^\"]*)\" on \"([^\"]*)\" page - \"([^\"]*)\"$")
	public void he_has_verified_submitted_Benefits_Flex_and_Core_card_status_updated_to_on_page(
			String expectedStatus, String pageName, String tracingSelection) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(expectedStatus, tracingSelection),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,
						pageName));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(tracingSelection), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL, pageName));
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
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

	@Then("^selected Aires Managed Benefit Core Card having '([^\"]*)' Milestones with \"([^\"]*)\" status should be displayed on \"([^\"]*)\" page - \"([^\"]*)\"$")
	public void selected_Aires_Managed_Benefit_Core_card_having_Milestones_with_status_should_be_displayed_on_page(
			int noOfMileStones,String expectedStatus, String pageName, String tracingPrompt) throws Throwable {
		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(MobilityXConstants.PRE_INITIAL_TRACING, noOfMileStones),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL,
						pageName));
	}

	@Then("^Flex card should not be displayed for Selected/Not-Submitted Aires Managed Benefit on \"([^\"]*)\" page$")
	public void Flex_card_should_not_be_displayed_for_selected_Not_Submitted_Aires_Managed_Benefit_on_page(
			String pageName) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyFlexCardForNotSubmittedAiresManagedBenefit(),
				MessageFormat.format(MobilityXConstants.FLEX_CARD_DISPLAYED_FOR_NOT_SUBMITTED_AIRES_MANAGED_BENEFIT,
						CoreConstants.FAIL, pageName));
	}

	@Given("^he has verified submitted Aires Managed Benefit status updated to \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void he_has_verified_submitted_Aires_Managed_Benefit_status_updated_to_on_page(String expectedStatus,
			String pageName) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedAiresManagedBenefitDetails(expectedStatus),
				MessageFormat.format(MobilityXConstants.SUBMITTED_AIRES_MANAGED_BENEFIT_DETAILS_NOT_MATCHED,
						CoreConstants.FAIL, pageName));
		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
	}
	
//	@Given("^he has verified submitted Aires Managed Benefit status for 'Multiple Submission' updated to \"([^\"]*)\" on \"([^\"]*)\" page$")
//	public void he_has_verified_submitted_Aires_Managed_Benefit_status_for_Multiple_Submission_updated_to_on_page(String expectedStatus,
//			String pageName) throws Throwable {
//		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedAMMultipleSubmissionBenefitDetails(expectedStatus),
//				MessageFormat.format(MobilityXConstants.SUBMITTED_AIRES_MANAGED_BENEFIT_DETAILS_NOT_MATCHED,
//						CoreConstants.FAIL, pageName));
//		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
//		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
//				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
//		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
//		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
//				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
//				CoreConstants.FAIL));
//	}

//	@Then("^submitted Aires Managed Benefit Flex and Core card status should be updated to \"([^\"]*)\" on \"([^\"]*)\" page - \"([^\"]*)\"$")
//	public void submitted_Aires_Managed_Benefit_Flex_and_Core_card_status_should_be_updated_to_on_page(
//			String expectedStatus, String pageName, String tracingSelection) throws Throwable {
//		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
//		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
//				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
//		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
//		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
//				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
//				CoreConstants.FAIL));
//		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(expectedStatus, tracingSelection),
//				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,
//						pageName));
//		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(tracingSelection), MessageFormat
//				.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL, pageName));
//	}

	@Then("^submitted Aires Managed Benefit Flex and Core card status should be updated to \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void submitted_Aires_Managed_Benefit_Flex_and_Core_card_status_should_be_updated_to_canceled_on_page(
			String tracingSelection, String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(tracingSelection, tracingSelection),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,
						pageName));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(tracingSelection), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL, pageName));
	}

	@Then("^submitted Aires Managed Benefit status should be updated to \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void submitted_Aires_Managed_Benefit_status_should_be_updated_to_on_page(String expectedStatus,
			String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedAiresManagedBenefitDetails(expectedStatus),
				MessageFormat.format(MobilityXConstants.SUBMITTED_AIRES_MANAGED_BENEFIT_DETAILS_NOT_MATCHED,
						CoreConstants.FAIL, pageName));
	}

	@When("^he change status of the 'Aires Managed' benefit SubService to \"([^\"]*)\" from Services tab of IRIS application$")
	public void he_change_status_of_the_Aires_Managed_benefit_SubService_to_from_Services_tab_of_IRIS_application(
			String subServiceStatus) throws Throwable {
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
		testContext.getIrisPageManager().irisAssignmentServicePage.cancelAddedServices(subServiceStatus);
		testContext.getBasePage().cleanIrisProcesses();
	}

	@Given("^he has verified submitted Aires Managed Benefit Flex card status displayed as \"([^\"]*)\" on \"([^\"]*)\" page - \"([^\"]*)\"$")
	public void he_has_verified_submitted_Aires_Managed_Benefit_Flex_card_status_displayed_as_on_page(
			String expectedStatus, String pageName, String tracingSelection) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(expectedStatus, tracingSelection),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,
						pageName));
	}

	@Given("^he has verified submitted Aires Managed Benefit Core card not be displayed under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void he_has_verified_submitted_Aires_Managed_Benefit_Core_card_not_be_displayed_under_Service_Monitoring_section_of_page(
			String pageName) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyCoreCardNotDisplayed(), MessageFormat.format(
				MobilityXConstants.CORE_CARD_DISPLAYED_ON_MOBILITY_JOURNEY_HOME_PAGE, CoreConstants.FAIL, pageName));
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
	}

	@Then("^submitted Core Cards having '([^\"]*)' Milestones should be displayed under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void submitted_Core_Cards_with_Milestones_should_be_displayed_under_Service_Monitoring_section_of_page(int noOfMileStones, String pageName)
			throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(MobilityXConstants.PRE_INITIAL_TRACING, noOfMileStones),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL,
						pageName));
	}

	@Given("^he has verified submitted Aires Managed Benefit Core card status displayed as \"([^\"]*)\" on \"([^\"]*)\" page - \"([^\"]*)\"$")
	public void he_has_verified_submitted_Aires_Managed_Benefit_Core_card_status_displayed_as_on_page(
			String expectedStatus, String pageName, String tracingSelection) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(tracingSelection), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL, pageName));
	}

	@Given("^he has verified submitted Aires Managed Benefit Flex card not be displayed under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void he_has_verified_submitted_Aires_Managed_Benefit_Flex_card_not_be_displayed_under_Service_Monitoring_section_of_page(
			String pageName) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyFlexCardNotDisplayed(), MessageFormat.format(
				MobilityXConstants.FLEX_CARD_DISPLAYED_ON_MOBILITY_JOURNEY_HOME_PAGE, CoreConstants.FAIL, pageName));
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
	}

	@Then("^submitted Aires Managed Benefit Core Cards should not be displayed under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void submitted_Aires_Managed_Benefit_Core_Cards_should_not_be_displayed_under_Service_Monitoring_section_of_page(
			String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyCoreCardNotDisplayedAfterUpdatingSubServiceType(),
				MessageFormat.format(
						MobilityXConstants.CORE_CARD_DISPLAYED_AFTER_CHANGING_COREFLEX_TYPE_SUBSERVICE_IN_IRIS,
						CoreConstants.FAIL, pageName));
	}

	@Then("^submitted Aires Managed Benefit Flex Cards having '([^\"]*)' Milestones should be displayed under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void submitted_Aires_Managed_Benefit_Flex_Cards_having_Milestones_should_be_displayed_under_Service_Monitoring_section_of_page(
			String noOfMilestones, String pageName) throws Throwable {
		Assert.assertTrue(
				mxTransfereeJourneyHomePage.verifyFlexBenefitCardDetailsOfAiresManagedBenefits(MobilityXConstants.STARTING_SOON,
						MobilityXConstants.PRE_INITIAL_TRACING, Integer.parseInt(noOfMilestones)),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,
						pageName));
	}	

}
