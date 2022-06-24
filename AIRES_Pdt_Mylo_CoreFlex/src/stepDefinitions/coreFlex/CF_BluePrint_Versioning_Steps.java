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
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.coreflex.CoreFlex_AirportPickup_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_AreaTour_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_AutoRentalDuringAssignment_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_BenefitSummaryPage;
import com.aires.pages.coreflex.CoreFlex_BluePrint_LoginPage;
import com.aires.pages.coreflex.CoreFlex_ConciergeServices_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_CulturalTraining_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_CustomBundlesPage;
import com.aires.pages.coreflex.CoreFlex_DuplicateHousing_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_FinalMove_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;
import com.aires.pages.coreflex.CoreFlex_FurnitureRental_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_HomeLeave_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_HomePurchase_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_HouseHuntingTrip_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_LanguageTraining_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_LumpSum_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_OtherHousing_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.coreflex.CoreFlex_PreAcceptanceServices_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_PreviewTransfereePage;
import com.aires.pages.coreflex.CoreFlex_TemporaryLiving_BenefitsPage;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_LoginPage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DashboardHomePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DetailsPage;
import com.aires.pages.coreflex.TransfereeSubmissions_LoginPage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_BluePrint_Versioning_Steps {

	private TestContext testContext;

	private CoreFlex_CustomBundlesPage coreFlexCustomBundlesPage;
	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private CoreFlex_BluePrint_LoginPage bluePrintCFLoginPage;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_GeneralInformationPage generalInfoPage;
	private CoreFlex_FlexPolicySetupPage flexPolicySetupPage;
	private CoreFlex_PolicyBenefitsCategoriesPage coreFlexPolicyBenefitsCategoriesPage;
	private CoreFlex_DuplicateHousing_BenefitsPage coreFlexDuplicateHousingBenefitsPage;
	private CoreFlex_LumpSum_BenefitsPage coreFlexLumpSumBenefitsPage;
	private CoreFlex_BenefitSummaryPage coreFlexBenefitSummaryPage;
	private CoreFlex_OtherHousing_BenefitsPage coreFlexOtherHousingBenefitsPage;
	private MX_Transferee_LoginPage mxTransfereeLoginPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;
	private TransfereeSubmissions_LoginPage transfereeSubmissionsLoginPage;
	private TransfereeSubmissions_DashboardHomePage transfereeSubmissionsDashboardHomePage;
	private CoreFlex_PreviewTransfereePage coreFlexTransfereePreviewPage;
	private TransfereeSubmissions_DetailsPage transfereeSubmissionsDetailsPage;
	private CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage;
	private CoreFlex_TemporaryLiving_BenefitsPage coreFlexTemporaryLivingBenefitsPage;
	private CoreFlex_CulturalTraining_BenefitsPage coreFlexCulturalTrainingBenefitsPage;
	private CoreFlex_ConciergeServices_BenefitsPage coreFlexConciergeServicesBenefitsPage;
	private CoreFlex_HomePurchase_BenefitsPage coreFlexHomePurchaseBenefitsPage;
	private CoreFlex_FinalMove_BenefitsPage coreFlexFinalMoveBenefitsPage;
	private CoreFlex_AreaTour_BenefitsPage coreFlexAreaTourBenefitsPage;
	private CoreFlex_HomeLeave_BenefitsPage coreFlexHomeLeaveBenefitsPage;
	private CoreFlex_AirportPickup_BenefitsPage coreFlexAirportPickupBenefitsPage;
	private CoreFlex_PreAcceptanceServices_BenefitsPage coreFlexPreAcceptanceServicesBenefitsPage;
	private CoreFlex_FurnitureRental_BenefitsPage coreFlexFurnitureRentalBenefitsPage;
	private CoreFlex_AutoRentalDuringAssignment_BenefitsPage coreFlexAutoRentalDuringAssignmentBenefitsPage;
	private CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage coreFlexEducationAssistanceBenefitsPage;
	private CoreFlex_HouseHuntingTrip_BenefitsPage coreFlexHouseHuntingTripBenefitsPage;

	public CF_BluePrint_Versioning_Steps(TestContext context) {
		testContext = context;
		coreFlexCustomBundlesPage = testContext.getCoreFlexPageObjectManager().getCoreFlexCustomBundlesPage();
		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();
		bluePrintCFLoginPage = testContext.getPageObjectManager().getBluePrintCoreFlexLoginPage();
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();
		flexPolicySetupPage = testContext.getCoreFlexPageObjectManager().getFlexPolicySetupPage();
		coreFlexPolicyBenefitsCategoriesPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexPolicyBenefitsCategoriesPage();
		testContext = context;
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();
		flexPolicySetupPage = testContext.getCoreFlexPageObjectManager().getFlexPolicySetupPage();
		coreFlexPolicyBenefitsCategoriesPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexPolicyBenefitsCategoriesPage();
		coreFlexCustomBundlesPage = testContext.getCoreFlexPageObjectManager().getCoreFlexCustomBundlesPage();
		coreFlexDuplicateHousingBenefitsPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexDuplicateHousingBenefitsPage();
		coreFlexLumpSumBenefitsPage = testContext.getCoreFlexPageObjectManager().getCoreFlexLumpSumBenefitsPage();
		coreFlexBenefitSummaryPage = testContext.getCoreFlexPageObjectManager().getCoreFlexBenefitSummaryPage();
		mxTransfereeLoginPage = testContext.getCoreFlexPageObjectManager().getMXTransfereeLoginPage();
		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();
		mxTransfereeMyBenefitsBundlePage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeMyBenefitsBundlePage();
		transfereeSubmissionsLoginPage = testContext.getCoreFlexPageObjectManager().getTransfereeSubmissionsLoginPage();
		transfereeSubmissionsDashboardHomePage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDashboardHomePage();
		coreFlexOtherHousingBenefitsPage = testContext.getCoreFlexPageObjectManager().getOtherHousingBenefitPage();
		coreFlexTransfereePreviewPage = testContext.getCoreFlexPageObjectManager().getCoreFlexTransfereePreviewPage();
		bluePrintCFLoginPage = testContext.getPageObjectManager().getBluePrintCoreFlexLoginPage();
		transfereeSubmissionsDetailsPage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDetailsPage();
		coreFlexLanguageTrainingBenefitsPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexLanguageTrainingBenefitsPage();
		coreFlexTemporaryLivingBenefitsPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexTemporaryLivingBenefitPage();
		coreFlexCulturalTrainingBenefitsPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexCulturalTrainingBenefitsPage();
		coreFlexConciergeServicesBenefitsPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexConciergeServicesBenefitsPage();
		coreFlexHomePurchaseBenefitsPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexHomePurchaseBenefitsPage();
		coreFlexFinalMoveBenefitsPage = testContext.getCoreFlexPageObjectManager().getCoreFlexFinalMoveBenefitsPage();
		coreFlexAreaTourBenefitsPage = testContext.getCoreFlexPageObjectManager().getCoreFlexAreaTourBenefitsPage();
		coreFlexHomeLeaveBenefitsPage = testContext.getCoreFlexPageObjectManager().getCoreFlexHomeLeaveBenefitsPage();
		coreFlexAirportPickupBenefitsPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexAirportPickupBenefitsPage();
		coreFlexPreAcceptanceServicesBenefitsPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexPreAcceptanceServicesBenefitsPage();
		coreFlexFurnitureRentalBenefitsPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexFurnitureRentalBenefitsPage();
		coreFlexAutoRentalDuringAssignmentBenefitsPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexAutoRentalDuringAssignmentBenefitsPage();
		coreFlexEducationAssistanceBenefitsPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexEducationAssistanceBenefitsPage();
		coreFlexHouseHuntingTripBenefitsPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexHouseHuntingTripBenefitsPage();
	}

	@When("^he clicks on \"([^\"]*)\" button to close 'Approve this Policy' dialog$")
	public void he_clicks_on_button_to_close_Approve_this_Policy_dialog(String buttonName) throws Throwable {
		coreFlexCustomBundlesPage.clickElementOfPage(buttonName);
	}

	@Then("^'Approve this Policy' dialog should be closed$")
	public void approve_this_Policy_dialog_should_be_closed() throws Throwable {
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyApprovalDialogNotDisplayed(), MessageFormat.format(
				COREFLEXConstants.APPROVE_THIS_POLICY_DIALOG_DISPLAYED_AFTER_CANCEL_OPERATION, CoreConstants.FAIL));
	}

	@Then("^user should be navigated to \"([^\"]*)\" page having 'Policy Status' and 'Version Number' displayed as \"([^\"]*)\" and \"([^\"]*)\" respectively$")
	public void user_should_be_navigated_to_page_having_Policy_Status_and_Version_Number_displayed_as_and_respectively(
			String navigatedPageName, String expectedPolicyStatus, String expectedPolicyVersion) throws Throwable {
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicyStatusPostSubmission(expectedPolicyStatus),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, navigatedPageName));
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicyVersionPostSubmission(expectedPolicyVersion),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_VERSION_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, navigatedPageName));
		Assert.assertTrue(coreFlexCustomBundlesPage.verifySubmitButtonDisabledPostSubmission(),
				MessageFormat.format(
						COREFLEXConstants.SUBMIT_BUTTON_NOT_DISABLED_AFTER_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, navigatedPageName));
	}

	@When("^he navigates to \"([^\"]*)\" after clicking on 'Manage my Points' button on \"([^\"]*)\" page$")
	public void he_navigates_to_after_clicking_on_Manage_my_Points_button_on_page(String navigatedPage,
			String sourcePage) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Flex Planning Tool Home</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
	}

	@Then("^benefits selected on Active BluePrint \"([^\"]*)\" - \"([^\"]*)\" Type Policy should be displayed on \"([^\"]*)\" page$")
	public void benefits_selected_on_Active_BluePrint_Type_Policy_should_be_displayed_on_page(String version,
			String policyType, String pageName) throws Throwable {

		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessage(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyBenefitDetailsOnFPT(policyType), MessageFormat.format(
				MobilityXConstants.BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE_OF_MXTRANSFEREE_NOT_MATCHED_WITH_BENEFITS_DETAILS_SET_IN_BLUEPRINT_APPLICATION,
				CoreConstants.FAIL));
	}

	@Then("^custom bundle created in Active BluePrint \"([^\"]*)\" - \"([^\"]*)\" Policy should be displayed on \"([^\"]*)\" page$")
	public void custom_bundle_created_in_Active_BluePrint_Type_Policy_should_be_displayed_on_page(String version,
			String policyType, String pageName) throws Throwable {

		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.SUGGESTED_OPTIONS_LINK);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyUserNavigationToSuggestedBundlesPage(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_NAVIGATE_TO_SUGGESTED_BUNDLES_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Suggested Bundles</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySuggestedBundlesDetails(), MessageFormat.format(
				MobilityXConstants.CUSTOM_BUNDLE_DETAILS_NOT_MATCHED_ON_SUGGESTED_BUNDLES_PAGE, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
	}

	@Given("^he has searched for 'Active' points based CoreFlex policy that has one or more assignments/files on \"([^\"]*)\" page$")
	public void he_has_searched_for_Active_points_based_CoreFlex_policy_that_has_one_or_more_assignments_files_on_page(
			String pageName) throws Throwable {
		Assert.assertTrue(bluePrintCFLoginPage.verifyLoginPageNavigation(), MessageFormat.format(
				PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_BLUE_PRINT_APPLICATION_LOGIN_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>CoreFlex Policy BluePrint Application Login</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");
		Assert.assertTrue(bluePrintCFLoginPage.loginByUserType(PDTConstants.CSM, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));
		viewPolicyPage.searchAndVerifyPolicy(CoreFunctions.getPropertyFromConfig("Assignment_Policy"), pageName);
	}

	@Given("^he has clicked on \"([^\"]*)\" icon of the searched 'Active' points based CoreFlex policy$")
	public void he_has_clicked_on_icon_of_the_searched_Active_points_based_CoreFlex_policy(String editIcon)
			throws Throwable {
		viewPolicyPage.clickElementOfPage(editIcon);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
	}

	@Given("^he has entered 'Description' after verifying 'Version Control' popup screen contents$")
	public void he_has_entered_Description_after_verifying_Version_Control_popup_screen_contents() throws Throwable {
		Assert.assertTrue(viewPolicyPage.isVersionControlDialogDisplayed(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_DISPLAY_VERSION_CONTROL_DIALOG_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to display to <i>Version Control</i> dialog is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(viewPolicyPage.verifyVersionControlDialog(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_VERSION_CONTROL_DIALOG_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
						CoreConstants.FAIL));
		viewPolicyPage.enterVersionControlDialogDescription();
	}

	@When("^he clicks on \"([^\"]*)\" button on 'Version Control' popup screen$")
	public void he_clicks_on_button_on_Version_Control_popup_screen(String arg1) throws Throwable {
		viewPolicyPage.clickElementOfPage(COREFLEXConstants.CREATE);
	}

	@Then("^user should be navigated to \"([^\"]*)\" page of 'New Version' policy in 'Editable' mode having Policy Status displayed as \"([^\"]*)\"$")
	public void user_should_be_navigated_to_page_of_New_Version_policy_in_Editable_mode_having_Policy_Status_displayed_as(
			String navigatedPageName, String newPolicyStatus) throws Throwable {
		Assert.assertTrue(generalInfoPage.verifyPageNavigation(COREFLEXConstants.GENERAL_INFORMATION_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.validateClientAndPolicyDetailsOnGeneralInfo(COREFLEXConstants.GENERAL_INFORMATION_PAGE,
						CoreFunctions.getPropertyFromConfig("Policy_ClientID"),
						CoreFunctions.getPropertyFromConfig("Assignment_Policy")),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_CLIENT_POLICY_DATA_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.POLICY_STATUS, PDTConstants.DRAFT),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.POLICY_STATUS));
		Assert.assertTrue(generalInfoPage.verifyPolicyNumberAfterVersioning(viewPolicyPage), MessageFormat
				.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_VERSION_NUMBER_POST_VERSIONING, CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.TRACING_SET,
						CoreFunctions.getPropertyFromConfig("Policy_TracingSet")),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.TRACING_SET));
		generalInfoPage.fillOtherMandatoryFieldsPostVersioning();
	}

	@Then("^'Points Based Flex Policy' field should be disabled with default value as \"([^\"]*)\"$")
	public void points_Based_Flex_Policy_field_should_be_disabled_with_default_value_as(
			String pointsBasedFlexPolicyDefaultValue) throws Throwable {
		Assert.assertTrue(generalInfoPage.verifyFieldDisabledPostVersioning(PDTConstants.POINTS_BASED_FLEX_POLICY),
				MessageFormat.format(COREFLEXConstants.FIELD_NOT_DISABLED_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL, PDTConstants.POINTS_BASED_FLEX_POLICY));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.POINTS_BASED_FLEX_POLICY,
						pointsBasedFlexPolicyDefaultValue),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.POINTS_BASED_FLEX_POLICY));
	}

	@Given("^he has verified 'Enabled/Disabled' status of searched 'Points Based CoreFlex Policy' Icons - \"([^\"]*)\" Versioning on \"([^\"]*)\" page$")
	public void he_has_verified_Enabled_Disabled_status_of_searched_Points_Based_CoreFlex_Policy_Icons_Versioning_on_page(
			String versioning, String pageName, DataTable dataTable) throws Throwable {
		Assert.assertTrue(viewPolicyPage.verifyPolicyIconsStatus(versioning, pageName, dataTable), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_POLICY_ICONS_ENABLED_DISABLED_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
				CoreConstants.FAIL, pageName));
	}

	@Given("^he has clicked on \"([^\"]*)\" icon of \"([^\"]*)\" - \"([^\"]*)\" version of the searched points based CoreFlex policy$")
	public void he_has_clicked_on_icon_of_version_of_the_searched_points_based_CoreFlex_policy(String iconName,
			String policyVersion, String policyStatus) throws Throwable {

		viewPolicyPage.clickPolicyActionIcon(iconName, policyVersion, policyStatus);
	}

	@Given("^he has navigated to \"([^\"]*)\" page of 'New Version' policy in 'Editable' mode having Policy Status displayed as \"([^\"]*)\"$")
	public void he_has_navigated_to_page_of_New_Version_policy_in_Editable_mode_having_Policy_Status_displayed_as(
			String arg1, String arg2) throws Throwable {

		Assert.assertTrue(generalInfoPage.verifyPageNavigation(COREFLEXConstants.GENERAL_INFORMATION_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.validateClientAndPolicyDetailsOnGeneralInfo(COREFLEXConstants.GENERAL_INFORMATION_PAGE,
						CoreFunctions.getPropertyFromConfig("Policy_ClientID"),
						CoreFunctions.getPropertyFromConfig("Assignment_Policy")),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_CLIENT_POLICY_DATA_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.POLICY_STATUS, PDTConstants.DRAFT),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.POLICY_STATUS));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(COREFLEXConstants.POLICY_VERSION,
						CoreFunctions.getPropertyFromConfig("CoreFlex_PolicyVersion")),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, COREFLEXConstants.POLICY_VERSION));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.TRACING_SET,
						CoreFunctions.getPropertyFromConfig("Policy_TracingSet")),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.TRACING_SET));
		Assert.assertTrue(generalInfoPage.verifyFieldDisabledPostVersioning(PDTConstants.POINTS_BASED_FLEX_POLICY),
				MessageFormat.format(COREFLEXConstants.FIELD_NOT_DISABLED_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL, PDTConstants.POINTS_BASED_FLEX_POLICY));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.POINTS_BASED_FLEX_POLICY,
						COREFLEXConstants.YES),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.POINTS_BASED_FLEX_POLICY));
		Assert.assertTrue(generalInfoPage.verifyGeneralInfoAdditionalPolicyDetails(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_ADDITIONAL_POLICY_DETAILS_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		generalInfoPage.clickElementOfPage(PDTConstants.NEXT);
	}

	@Given("^he has verified 'Policy-Benefits-SubBenefits' details of \"([^\"]*)\" - \"([^\"]*)\" version Policy matches with following \"([^\"]*)\" policy selections$")
	public void he_has_verified_Policy_Benefits_SubBenefits_details_of_version_Policy_matches_with_following_policy_selections(
			String newPolicyVersion, String newPolicyStatus, String oldPolicyVersion, DataTable dataTable)
			throws Throwable {
		List<Map<String, String>> basePolicyDataMap = dataTable.asMaps(String.class, String.class);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(flexPolicySetupPage.verifyPageNavigation(COREFLEXConstants.FLEX_POLICY_SETUP),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_FLEX_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - Flex Policy Setup</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(flexPolicySetupPage.verifyBenfitExpirationLockBenefitTooltip(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_BENEFIT_EXPIRATION_AND_LOCK_BENEFITS_TOOLTIP_ON_FLEX_POLICY_SETUP_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(flexPolicySetupPage.verifyFPTFieldValuesPostVersioningCloning(dataTable),
				MessageFormat.format(
						COREFLEXConstants.FIELDS_VALIDATION_FAILED_ON_FLEX_POLICY_SETUP_PAGE_POST_VERSIONING_CLONING,
						CoreConstants.FAIL));
		flexPolicySetupPage.clickElementOfPage(PDTConstants.NEXT);

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - Policy Benefit Categories</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
//		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyPolicyCategoriesBenefitsAndOrder(),
//				MessageFormat.format(
//						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_CATEGORIES_BENEFITS_AND_ORDER_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
//						CoreConstants.FAIL));

		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage
						.verifySelectedBenefitsPostVersioningCloning(basePolicyDataMap.get(0).get("PolicyType")),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));
		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(PDTConstants.NEXT);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage
						.verifyBenefitsDisplayedOnLeftNavigation(basePolicyDataMap.get(0).get("PolicyType")),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_LEFT_NAVIGATION_POST_VERSIONING_CLONING,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Selected Benefits</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyAddedBenefitDetailsPostVersioningCloning(basePolicyDataMap.get(0).get("PolicyType"),
				coreFlexDuplicateHousingBenefitsPage, coreFlexLumpSumBenefitsPage, coreFlexOtherHousingBenefitsPage,
				coreFlexLanguageTrainingBenefitsPage, coreFlexTemporaryLivingBenefitsPage,
				coreFlexCulturalTrainingBenefitsPage, coreFlexConciergeServicesBenefitsPage,
				coreFlexHomePurchaseBenefitsPage, coreFlexFinalMoveBenefitsPage, coreFlexAreaTourBenefitsPage,
				coreFlexHomeLeaveBenefitsPage, coreFlexAirportPickupBenefitsPage,
				coreFlexPreAcceptanceServicesBenefitsPage, coreFlexFurnitureRentalBenefitsPage,
				coreFlexAutoRentalDuringAssignmentBenefitsPage, coreFlexEducationAssistanceBenefitsPage,
				coreFlexHouseHuntingTripBenefitsPage),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_SELECT_AND_FILL_ADDED_BENEFITS, CoreConstants.FAIL));
	}

	@Given("^he has verified 'CustomBundles' and 'Transferee Preview' details of \"([^\"]*)\" - \"([^\"]*)\" version Policy matches with \"([^\"]*)\" - \"([^\"]*)\" type policy$")
	public void he_has_verified_CustomBundles_and_Transferee_Preview_details_of_version_Policy_matches_with_type_policy(
			String newPolicyVersion, String newPolicyStatus, String oldPolicyVersion, String policyType)
			throws Throwable {
		coreFlexPolicyBenefitsCategoriesPage.clickLeftNavigationMenuOfPage(COREFLEXConstants.BENEFIT_SUMMARY);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(
				coreFlexBenefitSummaryPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFITS_BENEFIT_SUMMARY),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - Benefit Summary</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");

		Assert.assertTrue(coreFlexBenefitSummaryPage.iterateAndVerifyBenefitSummaryDetails(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_BENEFIT_SUBBENEFIT_DETAILS_ON_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
		coreFlexBenefitSummaryPage.clickElementOfPage(COREFLEXConstants.CONTINUE);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPageNavigation(COREFLEXConstants.CUSTOM_BUNDLES),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - Custom Bundles</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");

		Assert.assertTrue(coreFlexCustomBundlesPage.verifyAddedCustomBundlePostVersioningCloning(),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_ADDED_CUSTOM_BUNDLE_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.PREVIEW_TRANSFEREE_EXPERIENCE);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(coreFlexTransfereePreviewPage.isPreviewTransfereePageDisplayed(), MessageFormat
				.format(COREFLEXConstants.FAILED_TO_VERIFY_NAVIGATION_TO_TRANSFEREE_PREVIEW_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - Transfere Preview</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");

		Assert.assertTrue(coreFlexTransfereePreviewPage.verifyPreviewTransfereeExperience(policyType),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DETAILS_ON_PREVIEW_TRANSFEREE_PAGE,
						CoreConstants.FAIL));
		coreFlexTransfereePreviewPage.clickElementOfPage(COREFLEXConstants.CLOSE_TRANSFEREE_PREVIEW);

	}

	@Given("^he has acknowledged 'Submit Success' dialog after clicking on \"([^\"]*)\" button on \"([^\"]*)\" page$")
	public void he_has_acknowledged_Submit_Success_dialog_after_clicking_on_button_on_page(String submitButton, String pageName)
			throws Throwable {
		
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyButtonDisplayedOnDraftPolicyStatus(),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BUTTONS_DISPLAYED_ON_DRAFT_POLICY_STATUS,
						CoreConstants.FAIL));
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.SUBMIT);
		Reporter.addStepLog(MessageFormat.format(
				COREFLEXConstants.SUCCESSFULLY_CLICKED_ON_SUBMIT_BUTTON_ON_CUSTOM_BUNDLES_PAGE, CoreConstants.PASS));
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(
				coreFlexCustomBundlesPage.verifyPolicySubmitStatus(COREFLEXConstants.POLICY_SUBMIT_STATUS_MESSAGE,
						CoreFunctions.getPropertyFromConfig("Assignment_Policy")),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_SUBMIT_STATUS_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to verify <i>Policy Submit Status</i> is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.OK);
	}

}
