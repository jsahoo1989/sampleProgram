package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.Date;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.coreflex.CoreFlex_BenefitSummaryPage;
import com.aires.pages.coreflex.CoreFlex_BluePrint_LoginPage;
import com.aires.pages.coreflex.CoreFlex_CustomBundlesPage;
import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.coreflex.CoreFlex_PreviewTransfereePage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_BluePrint_Cloning_Steps {

	private TestContext testContext;

	private CoreFlex_CustomBundlesPage coreFlexCustomBundlesPage;

	private CoreFlex_BluePrint_LoginPage bluePrintCFLoginPage;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_GeneralInformationPage generalInfoPage;
	private CoreFlex_FlexPolicySetupPage flexPolicySetupPage;
	private CoreFlex_PolicyBenefitsCategoriesPage coreFlexPolicyBenefitsCategoriesPage;
	private CoreFlex_BenefitSummaryPage coreFlexBenefitSummaryPage;	
	private CoreFlex_PreviewTransfereePage coreFlexTransfereePreviewPage;
	


	public CF_BluePrint_Cloning_Steps(TestContext context) {
		testContext = context;
		coreFlexCustomBundlesPage = testContext.getCoreFlexPageObjectManager().getCoreFlexCustomBundlesPage();
		
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
		coreFlexTransfereePreviewPage = testContext.getCoreFlexPageObjectManager().getCoreFlexTransfereePreviewPage();
		bluePrintCFLoginPage = testContext.getPageObjectManager().getBluePrintCoreFlexLoginPage();
		coreFlexTransfereePreviewPage = testContext.getCoreFlexPageObjectManager().getCoreFlexTransfereePreviewPage();
		bluePrintCFLoginPage = testContext.getPageObjectManager().getBluePrintCoreFlexLoginPage();

	}

	private static int searchedPolicyIndex;

	@Given("^he has logged into 'BluePrint' application as 'CSM - SSO' user$")
	public void he_has_logged_into_BluePrint_application_as_CSM_SSO_user() throws Throwable {
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
	}

	@Given("^he has searched for 'Points Based CoreFlex Policy' with Policy Status as \"([^\"]*)\"$")
	public void he_has_searched_for_Points_Based_CoreFlex_Policy_with_Policy_Status_as(String policyStatus)
			throws Throwable {
		viewPolicyPage.searchPolicy(COREFLEXConstants.AUTOMATION_POLICY);
		searchedPolicyIndex = viewPolicyPage.searchPolicyByStatus(policyStatus);
	}

	@When("^he mouse-hover the \"([^\"]*)\" icon to check to check \"([^\"]*)\" policy Enabled/Disabled property$")
	public void he_mouse_hover_icon_to_check_to_check_policy_Enabled_Disabled_property(String iconName,
			String expectedPolicyStatus) throws Throwable {
		viewPolicyPage.hoverIcon(iconName, searchedPolicyIndex);
	}

	@Given("^he has clicked on 'Clone Policy' icon after searching for 'Points Based CoreFlex Policy' with Policy Status as \"([^\"]*)\"$")
	public void he_has_clicked_on_Clone_Policy_icon_after_searching_for_Points_Based_CoreFlex_Policy_with_Policy_Status_as(
			String policyStatus) throws Throwable {
		viewPolicyPage.searchPolicy(COREFLEXConstants.AUTOMATION_POLICY);
		searchedPolicyIndex = viewPolicyPage.searchPolicyByStatus(policyStatus);
		viewPolicyPage.captureCorporationPolicyValue(searchedPolicyIndex, policyStatus, generalInfoPage);
		viewPolicyPage.searchPolicy(CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_PolicyName"));
		viewPolicyPage.clickCloneIconOfReferencePolicy(policyStatus);
	}

	@Then("^\"([^\"]*)\" icon Enabled/Disabled status should be \"([^\"]*)\" for \"([^\"]*)\" Policy Status$")
	public void icon_Enabled_Disabled_status_should_be_for_Policy_Status(String iconName,
			String expectedCloneIconStatus, String expectedPolicyStatus) throws Throwable {
		Assert.assertTrue(
				viewPolicyPage.verifyIconStatus(iconName, searchedPolicyIndex, expectedCloneIconStatus,
						expectedPolicyStatus),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_ICON_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
						CoreConstants.FAIL, iconName, expectedPolicyStatus, expectedPolicyStatus));
	}

	@Given("^he has verified following 'Clone Policy' dialog values after clicking on 'Clone Policy' icon for Enabled Clone Icon \"([^\"]*)\"$")
	public void he_has_verified_following_Clone_Policy_dialog_values_after_clicking_on_Clone_Policy_icon_for_Enabled_Clone_Icon(
			String policyStatus, DataTable dataTable) throws Throwable {
		Assert.assertTrue(viewPolicyPage.verifyCoreFlexClonePolicyDialog(policyStatus, dataTable),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_COREFLEX_CLONE_POLICY_DIALOG_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
						CoreConstants.FAIL, policyStatus));
	}

	@Given("^he has selected a \"([^\"]*)\" client value in 'Clone to: Client' dropdown along with a new policy in 'Clone to: Policy' dropdown$")
	public void he_has_selected_a_client_value_in_Clone_to_Client_dropdown_along_with_a_new_policy_in_Clone_to_Policy_dropdown(
			String clientType) throws Throwable {
		Assert.assertTrue(viewPolicyPage.performCoreFlexCloneToClientPolicySelection(clientType),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_SELECT_COREFLEX_CLONE_TO_CLIENT_POLICY_ON_CLONE_POLICY_DIALOG,
						CoreConstants.FAIL));
	}

	@When("^he clicks on \"([^\"]*)\" button$")
	public void he_clicks_on_button(String buttonName) throws Throwable {
		viewPolicyPage.clickElementOfPage(buttonName);
	}

	@Then("^he should be navigated to \"([^\"]*)\" page of new 'Cloned - Points based CoreFlex Policy' saved as \"([^\"]*)\" with Policy Version as \"([^\"]*)\"$")
	public void he_should_be_navigated_to_page_of_new_Cloned_Points_based_CoreFlex_Policy_saved_as_with_Policy_Version_as(
			String navigatedPageName, String expectedClonedPolicyStatus, String expectedClonedPolicyVersion)
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(generalInfoPage.verifyPageNavigation(COREFLEXConstants.GENERAL_INFORMATION_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Blueprint - General Information</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(
				generalInfoPage.validateClientAndPolicyDetailsOnGeneralInfo(COREFLEXConstants.GENERAL_INFORMATION_PAGE,
						CoreFunctions.getPropertyFromConfig("ClonedPolicy_Client_ID"),
						CoreFunctions.getPropertyFromConfig("ClonedPolicy_Policy_Name")),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_CLIENT_POLICY_DATA_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.POLICY_STATUS,
						expectedClonedPolicyStatus),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.POLICY_STATUS));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(COREFLEXConstants.POLICY_VERSION,
						expectedClonedPolicyVersion),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, COREFLEXConstants.POLICY_VERSION));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.TRACING_SET,
						CoreFunctions.getPropertyFromConfig("Policy_TracingSet")),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.TRACING_SET));
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
	
	
	@Then("^all the 'CoreFlex' benefits from the reference 'Points Based CoreFlex policy' should be copied over to the 'Cloned - Points based CoreFlex Policy'$")
	public void all_the_CoreFlex_benefits_from_the_reference_Points_Based_CoreFlex_policy_should_be_copied_over_to_the_Cloned_Points_based_CoreFlex_Policy()
			throws Throwable {
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
		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyPolicyCategoriesBenefitsAndOrderPostCloning(),
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

}
