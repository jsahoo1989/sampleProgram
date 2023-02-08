package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.coreflex.CoreFlex_BenefitSummaryPage;
import com.aires.pages.coreflex.CoreFlex_BluePrint_LoginPage;
import com.aires.pages.coreflex.CoreFlex_CustomBundlesPage;
import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.coreflex.CoreFlex_PreviewTransfereePage;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.coreflex.MX_Transferee_MyProfilePage;
import com.aires.pages.coreflex.MobilityX_LoginPage;
import com.aires.pages.coreflex.TransfereeSubmissions_DashboardHomePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DetailsPage;
import com.aires.pages.coreflex.TransfereeSubmissions_LoginPage;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_LoginPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.aires.testdatatypes.coreflex.CoreFlex_LoginInfo;
import com.aires.testdatatypes.coreflex.TransfereeSubmissions_LoginData;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_MX_Transferee_Steps {

	private TestContext testContext;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_AddNewPolicyPage addNewPolicyPage;
	private PDT_LoginPage loginPage;
	private PDT_GeneralInformationPage generalInfoPage;
	private CoreFlex_FlexPolicySetupPage flexPolicySetupPage;
	private CoreFlex_PolicyBenefitsCategoriesPage coreFlexPolicyBenefitsCategoriesPage;
	private CoreFlex_CustomBundlesPage coreFlexCustomBundlesPage;
	private CoreFlex_BenefitSummaryPage coreFlexBenefitSummaryPage;
	private MobilityX_LoginPage mobilityXLoginPage;
	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;
	private TransfereeSubmissions_LoginPage transfereeSubmissionsLoginPage;
	private TransfereeSubmissions_DashboardHomePage transfereeSubmissionsDashboardHomePage;
	private CoreFlex_PreviewTransfereePage coreFlexTransfereePreviewPage;
	private CoreFlex_BluePrint_LoginPage bluePrintCFLoginPage;
	private TransfereeSubmissions_DetailsPage transfereeSubmissionsDetailsPage;
	private MX_Transferee_MyProfilePage mxTransfereeMyProfilePage;
	private CoreFlex_LoginInfo _loginInfo;

	public CF_MX_Transferee_Steps(TestContext context) {
		testContext = context;
		CoreFlex_PolicyBenefitsCategoriesPage.pageObjectManager_CoreFlex = testContext.getCoreFlexPageObjectManager();
		testContext.getCoreFlexPageObjectManager().initializeCoreFlexPageObjects();
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();
		flexPolicySetupPage = testContext.getCoreFlexPageObjectManager().getFlexPolicySetupPage();
		coreFlexPolicyBenefitsCategoriesPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexPolicyBenefitsCategoriesPage();
		coreFlexCustomBundlesPage = testContext.getCoreFlexPageObjectManager().getCoreFlexCustomBundlesPage();

		coreFlexBenefitSummaryPage = testContext.getCoreFlexPageObjectManager().getCoreFlexBenefitSummaryPage();
		mobilityXLoginPage = testContext.getCoreFlexPageObjectManager().getMobilityXLoginPage();
		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();
		mxTransfereeMyBenefitsBundlePage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeMyBenefitsBundlePage();
		transfereeSubmissionsLoginPage = testContext.getCoreFlexPageObjectManager().getTransfereeSubmissionsLoginPage();
		transfereeSubmissionsDashboardHomePage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDashboardHomePage();

		coreFlexTransfereePreviewPage = testContext.getCoreFlexPageObjectManager().getCoreFlexTransfereePreviewPage();
		bluePrintCFLoginPage = testContext.getPageObjectManager().getBluePrintCoreFlexLoginPage();
		transfereeSubmissionsDetailsPage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDetailsPage();
		mxTransfereeMyProfilePage = testContext.getCoreFlexPageObjectManager().getTransfereeMyProfilePage();

		_loginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getLoginByEnvt(BusinessFunctions.getEnvBasedOnExecutionType().toLowerCase());
	}

	/**********************************************************************/

	private TransfereeSubmissions_LoginData _transfereeSubmissionLoginData = FileReaderManager.getInstance()
			.getCoreFlexJsonReader().getTransfereeSubmissionLoginDataList(COREFLEXConstants.TRANSFEREE_SUBMISSIONS);

	/**********************************************************************/

	@Given("^he has verified 'Welcome' dialog displayed post setting up new user profile on 'MobilityX' application$")
	public void he_has_verified_Welcome_dialog_displayed_post_setting_up_new_user_profile_on_MobilityX_application() throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.isWelcomePopupDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_WELCOME_POPUP_ON_TRANSFEREE_JOURNEY_HOME_PAGE,
						CoreConstants.FAIL));
	}

	@When("^he select \"([^\"]*)\" option on 'Welcome' dialog$")
	public void he_select_option_on_Welcome_dialog(String option) throws Throwable {
		mxTransfereeJourneyHomePage.progressOrSkipMobilityJourneyHomePage(option);
	}

	@Then("^he should be navigated to \"([^\"]*)\" page having following 'AppCues' displayed in the order below$")
	public void he_should_be_navigated_to_page_having_following_AppCues_displayed_in_the_order_below(String pageName, DataTable dataTable) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyAppCues(pageName,dataTable),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_APPCUES,
						CoreConstants.FAIL,pageName));
	}
	
	@Then("^following 'AppCues' should be displayed in the order below on 'OnPoint Planning Tool' page$")
	public void following_AppCues_should_be_displayed_in_the_order_below_on_OnPoint_Planning_Tool_page(DataTable dataTable) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAppCues(MobilityXConstants.ONPOINT_PLANNING_TOOL,dataTable),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_APPCUES,
						CoreConstants.FAIL,MobilityXConstants.ONPOINT_PLANNING_TOOL));
	}

	@Then("^following 'AppCues' should be displayed in the order below on 'My Benefit Bundle' page$")
	public void following_AppCues_should_be_displayed_in_the_order_below_on_My_Benefit_Bundle_page(DataTable dataTable) throws Throwable {
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyAppCues(MobilityXConstants.MY_BENEFITS_BUNDLE,dataTable),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_APPCUES,
						CoreConstants.FAIL,MobilityXConstants.MY_BENEFITS_BUNDLE));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.ONPOINT_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
	}
	
	@Given("^he has clicked on following option on 'Welcome' dialog post setting up new user profile on 'MobilityX' application$")
	public void he_has_clicked_on_following_option_on_Welcome_dialog_post_setting_up_new_user_profile_on_MobilityX_application(
			DataTable dataTable) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.isWelcomePopupDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_WELCOME_POPUP_ON_TRANSFEREE_JOURNEY_HOME_PAGE,
						CoreConstants.FAIL));
		List<Map<String, String>> action = dataTable.asMaps(String.class, String.class);
		mxTransfereeJourneyHomePage.progressOrSkipMobilityJourneyHomePage(action.get(0).get("WelcomeDialogSelection"));
	}
	
	@Given("^he has clicked on \"([^\"]*)\" link displayed on 'AppCue' displayed on 'Mobility Journey Home' page$")
	public void he_has_clicked_on_link_displayed_on_AppCue_displayed_on_Mobility_Journey_Home_page(String arg1) throws Throwable {
		mxTransfereeJourneyHomePage.switchToTooltipIFrameAndPerformAction(MobilityXConstants.HIDE,5);
	}

	@Given("^he has clicked on '\\?' displayed on top right corner besides 'Resources' dropdown$")
	public void he_has_clicked_on_displayed_on_top_right_corner_besides_Resources_dropdown() throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.GET_HELP);
	}

	@When("^he clicks on \"([^\"]*)\" option displayed under 'Get Help' section$")
	public void he_clicks_on_option_displayed_under_Get_Help_section(String option) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyGetHelpSectionOptions(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_GET_HELP_SECTION_OPTIONS_ON_TRANSFEREE_JOURNEY_HOME_PAGE,
						CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.clickElementOfPage(option);
	}

	@Then("^following 'AppCues' should be displayed in the order below on 'Mobility Journey Home' page$")
	public void following_AppCues_should_be_displayed_in_the_order_below_on_Mobility_Journey_Home_page(DataTable dataTable) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyAppCues(MobilityXConstants.MOBILITY_JOURNEY_HOME,dataTable),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_APPCUES,
						CoreConstants.FAIL,MobilityXConstants.MOBILITY_JOURNEY_HOME));
	}

}
