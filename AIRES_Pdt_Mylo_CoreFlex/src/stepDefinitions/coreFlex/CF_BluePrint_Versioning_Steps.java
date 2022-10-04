package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.Date;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.coreflex.CoreFlex_BenefitSummaryPage;
import com.aires.pages.coreflex.CoreFlex_BluePrint_LoginPage;
import com.aires.pages.coreflex.CoreFlex_CustomBundlesPage;
import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.coreflex.CoreFlex_PreviewTransfereePage;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
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
	private CoreFlex_BenefitSummaryPage coreFlexBenefitSummaryPage;

	private CoreFlex_PreviewTransfereePage coreFlexTransfereePreviewPage;

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
		testContext.getCoreFlexPageObjectManager().initializeCoreFlexPageObjects();
		coreFlexBenefitSummaryPage = testContext.getCoreFlexPageObjectManager().getCoreFlexBenefitSummaryPage();

		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();

		coreFlexTransfereePreviewPage = testContext.getCoreFlexPageObjectManager().getCoreFlexTransfereePreviewPage();
		bluePrintCFLoginPage = testContext.getPageObjectManager().getBluePrintCoreFlexLoginPage();

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

	@Then("^benefits selected on Active BluePrint \"([^\"]*)\" Policy should be displayed on \"([^\"]*)\" page$")
	public void benefits_selected_on_Active_BluePrint_Policy_should_be_displayed_on_page(String version,
			String pageName) throws Throwable {

		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessage(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				mxTransfereeFlexPlanningToolPage.verifyBenefitDetailsOnFPTBasedOnPolicyRequiredFor(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"),
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType")),
				MessageFormat.format(
						MobilityXConstants.BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE_OF_MXTRANSFEREE_NOT_MATCHED_WITH_BENEFITS_DETAILS_SET_IN_BLUEPRINT_APPLICATION,
						CoreConstants.FAIL));
	}

	@Then("^custom bundle created in Active BluePrint \"([^\"]*)\" Policy should be displayed on \"([^\"]*)\" page$")
	public void custom_bundle_created_in_Active_BluePrint_Policy_should_be_displayed_on_page(String version,
			String pageName) throws Throwable {

		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.SUGGESTED_OPTIONS_LINK);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyUserNavigationToSuggestedBundlesPage(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_NAVIGATE_TO_SUGGESTED_BUNDLES_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Suggested Bundles</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(
				mxTransfereeFlexPlanningToolPage.verifySuggestedBundlesDetailsBasedOnPolicyRequiredFor(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"),
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType")),
				MessageFormat.format(MobilityXConstants.CUSTOM_BUNDLE_DETAILS_NOT_MATCHED_ON_SUGGESTED_BUNDLES_PAGE,
						CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
	}

	@Given("^he has searched for \"([^\"]*)\" points based CoreFlex policy that has one or more assignments/files on \"([^\"]*)\" page$")
	public void he_has_searched_for_points_based_CoreFlex_policy_that_has_one_or_more_assignments_files_on_page(
			String policyStatus, String pageName) throws Throwable {
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

	@Given("^he has clicked on \"([^\"]*)\" icon of the searched \"([^\"]*)\" points based CoreFlex policy$")
	public void he_has_clicked_on_icon_of_the_searched_points_based_CoreFlex_policy(String editIcon,
			String policyStatus) throws Throwable {
		viewPolicyPage.clickElementOfPage(editIcon);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
	}

	@Given("^he has searched for \"([^\"]*)\" points based CoreFlex policy on \"([^\"]*)\" page$")
	public void he_has_searched_for_points_based_CoreFlex_policy_on_page(String policyStatus, String pageName)
			throws Throwable {
		viewPolicyPage.searchAndVerifyPolicy(CoreFunctions.getPropertyFromConfig("Assignment_Policy"), pageName);
	}

	@Given("^he has verified following 'Assignment Details' after clicking on \"([^\"]*)\" icon of the searched \"([^\"]*)\" points based CoreFlex policy$")
	public void he_has_verified_following_Assignment_Details_after_clicking_on_AssignmentHistoryIcon_icon_of_the_searched_points_based_CoreFlex_policy(
			String assignmentHistoryIcon, String policyStatus, DataTable dataTable) throws Throwable {
		viewPolicyPage.clickElementOfPage(assignmentHistoryIcon);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(viewPolicyPage.verifyViewPolicyPageNavigation(COREFLEXConstants.VIEW_POLICY_BENEFIT),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_ASSIGNMENT_HISTORY_VIEW_POLICY_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>View Policy Benefit - Assignment History</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");
		Assert.assertTrue(viewPolicyPage.verifyRecordForAssignmentAssociation(dataTable), MessageFormat.format(
				PDTConstants.FAILED_TO_VERIFY_ASSIGNMENT_HISTORY_FOR_NO_ASSIGNMENT_ASSOCIATION, CoreConstants.FAIL));
		viewPolicyPage.clickElementOfPage(COREFLEXConstants.EXIT);
//		viewPolicyPage.clickElementOfPage(COREFLEXConstants.OK);
//		viewPolicyPage.searchAndVerifyPolicy(CoreFunctions.getPropertyFromConfig("Assignment_Policy"),
//				COREFLEXConstants.VIEW_EDIT_POLICY_FORMS);

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

	@Given("^he has clicked on \"([^\"]*)\" button on 'Version Control' popup screen$")
	public void he_has_clicked_on_button_on_Version_Control_popup_screen(String arg1) throws Throwable {
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
		Assert.assertTrue(generalInfoPage.verifyPolicyNumberAfterVersioning(viewPolicyPage), MessageFormat
				.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_VERSION_NUMBER_POST_VERSIONING, CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.TRACING_SET,
						CoreFunctions.getPropertyFromConfig("Policy_TracingSet")),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.TRACING_SET));
//		Assert.assertTrue(generalInfoPage.verifyFieldDisabledPostVersioning(PDTConstants.POINTS_BASED_FLEX_POLICY),
//				MessageFormat.format(COREFLEXConstants.FIELD_NOT_DISABLED_ON_GENERAL_INFORMATION_PAGE,
//						CoreConstants.FAIL, PDTConstants.POINTS_BASED_FLEX_POLICY));
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

	@Given("^he has verified 'Policy-Benefits-SubBenefits' details of \"([^\"]*)\" - \"([^\"]*)\" version Policy matches with \"([^\"]*)\" policy selections$")
	public void he_has_verified_Policy_Benefits_SubBenefits_details_of_version_Policy_matches_with_policy_selections(
			String newPolicyVersion, String newPolicyStatus, String oldPolicyVersion) throws Throwable {

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
		Assert.assertTrue(flexPolicySetupPage.verifyFPTFieldValuesPostVersioningCloning(),
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
		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyPolicyCategoriesBenefitsAndOrder(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_CATEGORIES_BENEFITS_AND_ORDER_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));

		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifySelectedBenefitsPostVersioningCloning(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0"),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));
		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(PDTConstants.NEXT);

		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyInformationDialog(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_INFORMATION_DIALOG_AFTER_SELECTING_BENEFITS_AND_CLICKING_NEXT_ON_POLICY_BENEFIT_CATEGORIES_PAGE,
				CoreConstants.FAIL));

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyBenefitsDisplayedOnLeftNavigation(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0"),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_LEFT_NAVIGATION_POST_VERSIONING_CLONING,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Selected Benefits</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyAddedBenefitDetailsPostVersioningCloning(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0"),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_SELECT_AND_FILL_ADDED_BENEFITS, CoreConstants.FAIL));
	}

	@Given("^he has verified 'CustomBundles' and 'Transferee Preview' details of \"([^\"]*)\" - \"([^\"]*)\" version Policy matches with \"([^\"]*)\" - \"([^\"]*)\" version Policy$")
	public void he_has_verified_CustomBundles_and_Transferee_Preview_details_of_version_Policy_matches_with_version_Policy(
			String newPolicyVersion, String newPolicyStatus, String oldPolicyVersion, String oldPolicyStatus)
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

		Assert.assertTrue(
				coreFlexBenefitSummaryPage.iterateAndVerifyBenefitSummaryDetails(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0"),
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

		Assert.assertTrue(
				coreFlexCustomBundlesPage.verifyAddedCustomBundlePostVersioningCloning(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor")),
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

		Assert.assertTrue(
				coreFlexTransfereePreviewPage.verifyPreviewTransfereeExperience(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0"),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DETAILS_ON_PREVIEW_TRANSFEREE_PAGE,
						CoreConstants.FAIL));
		coreFlexTransfereePreviewPage.clickElementOfPage(COREFLEXConstants.CLOSE_TRANSFEREE_PREVIEW);

	}

	@Given("^he has navigated to \"([^\"]*)\" page from Left Navigation$")
	public void he_has_navigated_to_page_from_Left_Navigation(String pageName) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(flexPolicySetupPage.verifyPageNavigation(COREFLEXConstants.FLEX_POLICY_SETUP),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_FLEX_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - Flex Policy Setup</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		flexPolicySetupPage.clickLeftNavigationMenuOfPage(pageName);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPageNavigation(COREFLEXConstants.CUSTOM_BUNDLES),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - Custom Bundles</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
	}

	@Given("^he has acknowledged 'Submit Success' dialog after clicking on \"([^\"]*)\" button on \"([^\"]*)\" page$")
	public void he_has_acknowledged_Submit_Success_dialog_after_clicking_on_button_on_page(String submitButton,
			String pageName) throws Throwable {

		Assert.assertTrue(coreFlexCustomBundlesPage.verifyButtonDisplayedOnDraftPolicyStatus(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_BUTTONS_DISPLAYED_ON_DRAFT_POLICY_STATUS, CoreConstants.FAIL));
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

	@Given("^he has searched for 'Active' points based CoreFlex policy that does not have any assignments/files association on \"([^\"]*)\" page$")
	public void he_has_searched_for_Active_points_based_CoreFlex_policy_that_does_not_have_any_assignments_files_association_on_page(
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

	@When("^he clicks on \"([^\"]*)\" icon of the searched \"([^\"]*)\" points based CoreFlex policy$")
	public void he_clicks_on_icon_of_the_searched_points_based_CoreFlex_policy(String iconName, String policyStatus)
			throws Throwable {
		viewPolicyPage.clickPolicyActionIcon(iconName, CoreFunctions.getPropertyFromConfig("CoreFlex_PolicyVersion"),
				policyStatus);
	}

	@Then("^he should be navigated to the searched policy \"([^\"]*)\" - 'Assignment History' page$")
	public void he_should_be_navigated_to_the_searched_policy_Assignment_History_page(String pageName)
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(viewPolicyPage.verifyViewPolicyPageNavigation(pageName), MessageFormat
				.format(PDTConstants.FAILED_TO_NAVIGATE_TO_ASSIGNMENT_HISTORY_VIEW_POLICY_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>View Policy Benefit - Assignment History</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" text should be displayed in 'Assignment History' table$")
	public void text_should_be_displayed_in_Assignment_History_table(String expectedText) throws Throwable {
		Assert.assertTrue(viewPolicyPage.verifyRecordForNoAssignmentAssociation(expectedText), MessageFormat.format(
				PDTConstants.FAILED_TO_VERIFY_ASSIGNMENT_HISTORY_FOR_NO_ASSIGNMENT_ASSOCIATION, CoreConstants.FAIL));
	}

	@Then("^\"([^\"]*)\" button should not be displayed above 'Assignment History' table$")
	public void button_should_not_be_displayed_above_Assignment_History_table(String buttonName) throws Throwable {
		Assert.assertFalse(viewPolicyPage.verifyExportButtonDisplayed(buttonName),
				MessageFormat.format(
						PDTConstants.EXPORT_BUTTON_DISPLAYED_ABOVE_ASSIGNMENT_HISTORY_FOR_NO_ASSIGNMENT_ASSOCIATION,
						CoreConstants.FAIL));
	}

	@Then("^following details of Assignment should be displayed under 'Assignment History' table$")
	public void following_details_of_Assignment_should_be_displayed_under_Assignment_History_table(DataTable dataTable)
			throws Throwable {
		Assert.assertTrue(viewPolicyPage.verifyRecordForAssignmentAssociation(dataTable), MessageFormat.format(
				PDTConstants.FAILED_TO_VERIFY_ASSIGNMENT_HISTORY_FOR_NO_ASSIGNMENT_ASSOCIATION, CoreConstants.FAIL));
	}

	@Then("^\"([^\"]*)\" button should be displayed above 'Assignment History' table$")
	public void button_should_be_displayed_above_Assignment_History_table(String buttonName) throws Throwable {
		Assert.assertTrue(viewPolicyPage.verifyExportButtonDisplayed(buttonName),
				MessageFormat.format(
						PDTConstants.EXPORT_BUTTON_NOT_DISPLAYED_ABOVE_ASSIGNMENT_HISTORY_FOR_ASSIGNMENT_ASSOCIATION,
						CoreConstants.FAIL));
	}

	@Given("^he has navigated to \"([^\"]*)\" page of 'Existing Version' policy in 'Editable' mode having Policy Status displayed as \"([^\"]*)\"$")
	public void he_has_navigated_to_page_of_Existing_Version_policy_in_Editable_mode_having_Policy_Status_displayed_as(
			String navigatedPageName, String policyStatus) throws Throwable {
		Assert.assertTrue(generalInfoPage.verifyPageNavigation(COREFLEXConstants.GENERAL_INFORMATION_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.validateClientAndPolicyDetailsOnGeneralInfo(COREFLEXConstants.GENERAL_INFORMATION_PAGE,
						CoreFunctions.getPropertyFromConfig("Policy_ClientID"),
						CoreFunctions.getPropertyFromConfig("Assignment_Policy")),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_CLIENT_POLICY_DATA_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.POLICY_STATUS, policyStatus),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.POLICY_STATUS));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(COREFLEXConstants.POLICY_VERSION,
						COREFLEXConstants.VERSION1),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, COREFLEXConstants.POLICY_VERSION));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.TRACING_SET,
						CoreFunctions.getPropertyFromConfig("Policy_TracingSet")),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.TRACING_SET));
//		generalInfoPage.fillOtherMandatoryFieldsPostVersioning();
	}

	@Given("^he has filled 'Benefit-SubBenefit' details after adding a new Benefit on 'Policy Benefit Categories' page$")
	public void he_has_filled_Benefit_SubBenefit_details_after_adding_a_new_Benefit_on_Policy_Benefit_Categories_page()
			throws Throwable {
		flexPolicySetupPage.clickLeftNavigationMenuOfPage(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES);
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
		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.selectAdditionalBenefit(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_SELECT_ADDITIONAL_BENEFIT_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));
		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(PDTConstants.NEXT);

		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyInformationDialog(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_INFORMATION_DIALOG_AFTER_SELECTING_BENEFITS_AND_CLICKING_NEXT_ON_POLICY_BENEFIT_CATEGORIES_PAGE,
				CoreConstants.FAIL));

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifySelectedBenefitDisplayedOnLeftNavigation(),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_LEFT_NAVIGATION,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Selected Benefits</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.selectAndFillAddedBenefits(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
						COREFLEXConstants.SIGNIFICANT_CHANGE, "0"),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_SELECT_AND_FILL_ADDED_BENEFITS, CoreConstants.FAIL));
	}

	@Then("^Policy Status should be changed from \"([^\"]*)\" to \"([^\"]*)\" on 'Custom Bundles' page$")
	public void policy_status_should_be_changed_from_to_on_Custom_Bundles_page(String previousStatus,
			String changedStatus) throws Throwable {
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicyStatus(changedStatus), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS, CoreConstants.FAIL, previousStatus, changedStatus));
	}

	@Given("^he has verified additional added benefit displayed on Summary Details after navigating to 'Benefit Summary' page$")
	public void he_has_verified_additional_added_benefit_displayed_on_Summary_Details_after_navigating_to_Benefit_Summary_page()
			throws Throwable {
		coreFlexPolicyBenefitsCategoriesPage.clickLeftNavigationMenuOfPage(COREFLEXConstants.BENEFIT_SUMMARY);
		Assert.assertTrue(
				coreFlexBenefitSummaryPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFITS_BENEFIT_SUMMARY),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexBenefitSummaryPage.iterateAndVerifyBenefitSummaryDetails(COREFLEXConstants.SIGNIFICANT_CHANGE,
						"0"),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_BENEFIT_SUBBENEFIT_DETAILS_ON_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has verified removed benefit is not displayed on Summary Details after navigating to 'Benefit Summary' page$")
	public void he_has_verified_removed_benefit_is_not_displayed_on_Summary_Details_after_navigating_to_Benefit_Summary_page()
			throws Throwable {
		coreFlexPolicyBenefitsCategoriesPage.clickLeftNavigationMenuOfPage(COREFLEXConstants.BENEFIT_SUMMARY);
		Assert.assertTrue(
				coreFlexBenefitSummaryPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFITS_BENEFIT_SUMMARY),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexBenefitSummaryPage.iterateAndVerifyBenefitSummaryDetails(COREFLEXConstants.VERSIONING, "0"),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_BENEFIT_SUBBENEFIT_DETAILS_ON_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
	}

	@When("^he clicks on \"([^\"]*)\" button on 'Benefit Summary' page$")
	public void he_clicks_on_button_on_Benefit_Summary_page(String buttonName) throws Throwable {
		coreFlexBenefitSummaryPage.clickElementOfPage(buttonName);
	}

	@Given("^he has clicked on \"([^\"]*)\" button on 'Benefit Summary' page$")
	public void he_has_clicked_on_button_on_Benefit_Summary_page(String buttonName) throws Throwable {
		coreFlexBenefitSummaryPage.clickElementOfPage(buttonName);
	}

	@Then("^he should be navigated to \"([^\"]*)\" page having following buttons displayed in enabled state and 'APPROVE POLICY' button should not be displayed$")
	public void he_should_be_navigated_to_page_having_and_displayed_in_enabled_state_and_Approve_Policy_button_should_not_be_displayed(
			String navigatedPageName, DataTable dataTable) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPageNavigation(navigatedPageName), MessageFormat
				.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_CUSTOM_BUNDLES_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - Custom Bundles</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyButtonDisplayedOnDraftPolicyStatus(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_BUTTONS_DISPLAYED_ON_DRAFT_POLICY_STATUS, CoreConstants.FAIL));
	}

	@When("^he clicks on \"([^\"]*)\" button on 'Custom Bundles' page$")
	public void he_clicks_on_button_on_Custom_Bundles_page(String buttonName) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPageNavigation(COREFLEXConstants.CUSTOM_BUNDLES),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - Custom Bundles</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		coreFlexCustomBundlesPage.clickElementOfPage(buttonName);
		Reporter.addStepLog(
				MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_CLICKED_ON_BUTTON_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.PASS, buttonName));
	}

	@Then("^\"([^\"]*)\" dialog with message \"([^\"]*)\" should be displayed$")
	public void dialog_with_message_should_be_displayed(String expectedDialogStatus, String expectedDialogMessage)
			throws Throwable {
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicySaveAsDraftDialogStatus(expectedDialogMessage),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_SAVE_AS_DRAFT_DIALOG_STATUS_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.OK);
	}

	@Then("^Policy Status should be displayed as \"([^\"]*)\" on 'Custom Bundles' page$")
	public void policy_Status_should_be_displayed_as_on_Custom_Bundles_page(String expectedStatus) throws Throwable {
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicyStatusPostSaveAsDraft(expectedStatus),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS_POST_SAVE_AS_DRAFT_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, COREFLEXConstants.CUSTOM_BUNDLES));
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicyVersionPostSaveAsDraft(COREFLEXConstants.VERSION1),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_VERSION_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, COREFLEXConstants.CUSTOM_BUNDLES));
	}

	@Then("^'Submit Success' dialog should be displayed$")
	public void Submit_Success_dialog_should_be_displayed() throws Throwable {
		Assert.assertTrue(
				coreFlexCustomBundlesPage.verifyPolicySubmitStatus(COREFLEXConstants.POLICY_SUBMIT_STATUS_MESSAGE,
						CoreFunctions.getPropertyFromConfig("Assignment_Policy")),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_SUBMIT_STATUS_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.OK);
	}

	@Given("^he has deselected an existing Benefit on 'Policy Benefit Categories' page$")
	public void he_has_deselected_an_existing_Benefit_on_Policy_Benefit_Categories_page() throws Throwable {
		flexPolicySetupPage.clickLeftNavigationMenuOfPage(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES);
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
		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.deselectSelectedBenefit(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_DESELECT_BENEFIT_ON_POLICY_BENEFIT_CATEGORIES_PAGE, CoreConstants.FAIL));
		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(PDTConstants.NEXT);
		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyInformationDialog(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_INFORMATION_DIALOG_AFTER_SELECTING_BENEFITS_AND_CLICKING_NEXT_ON_POLICY_BENEFIT_CATEGORIES_PAGE,
				CoreConstants.FAIL));
	}

	@Given("^he has changed Benefit type of added Benefits from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void he_has_changed_Benefit_type_of_added_Benefits_from_to(String previousPolicyType,
			String changedPolicyType) throws Throwable {
		generalInfoPage.clickElementOfPage(PDTConstants.NEXT);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(flexPolicySetupPage.verifyPageNavigation(COREFLEXConstants.FLEX_POLICY_SETUP),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_FLEX_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - Flex Policy Setup</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		flexPolicySetupPage.clickLeftNavigationMenuOfPage(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES);
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
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.iterateAndChangePolicyBenefitType(previousPolicyType,
						changedPolicyType),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_CHANGE_POLICY_BENEFIT_TYPE_OF_ADDED_BENEFITS,
						CoreConstants.FAIL, changedPolicyType));
	}

	@Then("^Policy Status should not be changed from \"([^\"]*)\" to \"([^\"]*)\" for Non-Significant Change in Policy$")
	public void Policy_Status_should_not_be_changed_from_to_for_Non_Significant_Change_in_Policy(
			String expectedPolicyStatus, String incorrectPolicyStatus) throws Throwable {
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicyStatus(expectedPolicyStatus), MessageFormat
				.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS, CoreConstants.FAIL, expectedPolicyStatus));
	}

	@Given("^he has clicked on \"([^\"]*)\" link from Left Navigation Menu$")
	public void he_has_clicked_on_link_from_Left_Navigation_Menu(String pageName) throws Throwable {
		flexPolicySetupPage.clickLeftNavigationMenuOfPage(pageName);
	}

	@Given("^he has clicked on 'Benefit Summary' link from Left Navigation Menu$")
	public void he_has_clicked_on_Benefit_Summary_link_from_Left_Navigation_Menu() throws Throwable {
		coreFlexPolicyBenefitsCategoriesPage.clickLeftNavigationMenuOfPage(COREFLEXConstants.BENEFIT_SUMMARY);
		Assert.assertTrue(
				coreFlexBenefitSummaryPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFITS_BENEFIT_SUMMARY),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has clicked on \"([^\"]*)\" button to navigate to \"([^\"]*)\" page$")
	public void he_has_clicked_on_link_from_Left_Navigation_Menu(String buttonName, String navigatedPageName)
			throws Throwable {
		generalInfoPage.clickElementOfPage(buttonName);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(flexPolicySetupPage.verifyPageNavigation(navigatedPageName), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_FLEX_POLICY_SETUP_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - Flex Policy Setup</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
	}

	@Given("^he has clicked on \"([^\"]*)\" button after removing a 'SubBenefit' from an added Benefit$")
	public void he_has_clicked_on_button_after_removing_a_Subbenefit_from_an_added_Benefit(String buttonName)
			throws Throwable {
		flexPolicySetupPage.clickLeftNavigationMenuOfPage(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES);
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
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage
						.deselectSelectedSubBenefit(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType")),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_DESELECT_SUBBENEFIT_FROM_SELECTED_BENEFIT_PAGE,
						CoreConstants.FAIL));

	}

	@Given("^he has clicked on \"([^\"]*)\" button after adding a 'SubBenefit' to an added Benefit$")
	public void he_has_clicked_on_button_after_adding_a_SubBenefit_to_an_added_Benefit(String buttonName)
			throws Throwable {
		flexPolicySetupPage.clickLeftNavigationMenuOfPage(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES);
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
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.selectAndFillUnSelectedSubBenefit(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType")),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_DESELECT_SUBBENEFIT_FROM_SELECTED_BENEFIT_PAGE,
						CoreConstants.FAIL));

	}

	@Then("^he should be navigated to \"([^\"]*)\" page having 'APPROVE POLICY' button in Enabled and 'SUBMIT' button is Disabled state$")
	public void he_should_be_navigated_to_page_having_Approve_Policy_button_in_Enabled_and_Submit_button_in_Disabled_state(
			String navigatedPageName) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPageNavigation(navigatedPageName), MessageFormat
				.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_CUSTOM_BUNDLES_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - Custom Bundles</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyButtonDisplayedOnSubmittedPolicyStatus(),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BUTTONS_DISPLAYED_ON_SUBMITTED_POLICY_STATUS,
						CoreConstants.FAIL));
	}

	@Given("^he has navigated to \"([^\"]*)\" page of 'New Version' policy in 'Editable' mode having CoreFlex Policy Status displayed as \"([^\"]*)\"$")
	public void he_has_navigated_to_page_of_New_Version_policy_in_Editable_mode_having_CoreFlex_Policy_Status_displayed_as(
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
}
