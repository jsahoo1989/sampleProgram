package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
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
import com.aires.pages.iris.IRIS_ActivityAndFinancePage;
import com.aires.pages.iris.IRIS_AssignmentOverviewPage;
import com.aires.pages.iris.IRIS_AssignmentServicePage;
import com.aires.pages.iris.IRIS_AssignmentTransfereeNFamilyPage;
import com.aires.pages.iris.IRIS_Corporation_Accounting;
import com.aires.pages.iris.IRIS_Corporation_Main;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.pages.iris.IRIS_Welcome12C;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_LoginPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.aires.testdatatypes.coreflex.CoreFlex_LoginInfo;
import com.aires.testdatatypes.coreflex.TransfereeSubmissions_LoginData;
import com.aires.testdatatypes.iris.IRIS_AssignmentData;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CoreFlex_SharedSteps {

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

	int _initialTableRowCount = 0;
	private CoreFlex_LoginInfo _loginInfo;

	public CoreFlex_SharedSteps(TestContext context) {
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

	@Given("^he is on the \"([^\"]*)\" page after clicking on the link \"([^\"]*)\" displayed under the left navigation menu on the 'View Policy' page$")
	public void he_is_on_the_page_after_clicking_on_the_link_displayed_under_the_left_navigation_menu_on_the_View_Policy_page(
			String pageName, String linkName) throws Throwable {
		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(pageName),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, pageName,
						PDTConstants.ADD_NEW_POLICY_FORM, addNewPolicyPage.getElementText(PDTConstants.HEADING)));
	}

	@Given("^he has clicked on \"([^\"]*)\" button after selecting \"([^\"]*)\" Policy for \"([^\"]*)\" client on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_selecting_Policy_for_client_on_page(String nextButton, String policyType,
			String clientID, String pageName) throws Throwable {
		addNewPolicyPage.enterClientID(clientID);
		Assert.assertTrue(addNewPolicyPage.verifyAndClickValidClientIDResult(clientID), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_VALID_CLIENT_ID_DROPDOWN_OPTIONS, CoreConstants.FAIL));
		Assert.assertTrue(addNewPolicyPage.selectAPolicy(addNewPolicyPage.getFirstAvailablePolicyOption()),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));

		testContext.getBasePage().invokeIrisApplication();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginInfo);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.CORPORATION_MODULE);
		testContext.getIrisPageManager().irisCorporationMain = new IRIS_Corporation_Main();
		testContext.getIrisPageManager().irisCorporationMain.queryCorporation(clientID);
		testContext.getIrisPageManager().irisCorporationMain.selectCorporationModules(IRISConstants.ACCOUNTING);
		testContext.getIrisPageManager().irisCorporationAccounting = new IRIS_Corporation_Accounting();
		testContext.getIrisPageManager().irisCorporationAccounting.verifyAccountingTab();
		testContext.getIrisPageManager().irisCorporationAccounting.performCoreFlexCheckboxSelectionForPolicy(policyType,
				IRISConstants.CHECKED, addNewPolicyPage.getSelectedPolicyName());
		testContext.getIrisPageManager().irisCorporationAccounting.clickOnSaveBtn();
		testContext.getBasePage().cleanIrisProcesses();

		addNewPolicyPage.clickElementOfPage(COREFLEXConstants.LOGOUT);
		Assert.assertTrue(loginPage.loginByUserType(PDTConstants.CSM, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));
		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
		addNewPolicyPage.enterClientID(clientID);
		Assert.assertTrue(addNewPolicyPage.verifyAndClickValidClientIDResult(clientID), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_VALID_CLIENT_ID_DROPDOWN_OPTIONS, CoreConstants.FAIL));
		Assert.assertTrue(addNewPolicyPage.selectAPolicy(addNewPolicyPage.getSelectedPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));
		addNewPolicyPage.clickElementOfPage(PDTConstants.NEXT);
	}

	@Given("^he has filled all the below mandatory fields after navigating to \"([^\"]*)\" page of selected \"([^\"]*)\" Client/Policy$")
	public void he_has_filled_all_the_below_mandatory_fields_after_navigating_to_page_of_selected_ClientPolicy(
			String pageName, String clientID, DataTable dataTable) throws Throwable {
		Assert.assertTrue(
				generalInfoPage.validateClientAndPolicyDetailsOnGeneralInfo(pageName, clientID,
						addNewPolicyPage.getSelectedPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_CLIENT_POLICY_DATA_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		generalInfoPage.fillOtherMandatoryFields(dataTable);
	}

	@Given("^he has clicked on \"([^\"]*)\" button after selecting \"([^\"]*)\" option for \"([^\"]*)\" field$")
	public void he_has_clicked_on_button_after_selecting_option_for_field(String nextButton, String optionSelection,
			String fieldName) throws Throwable {
		Assert.assertTrue(generalInfoPage.selectFieldOption(fieldName, optionSelection), MessageFormat
				.format(PDTConstants.FAILED_TO_SELECT_FIELD_OPTIONS_ON_GENERAL_INFO_PAGE, CoreConstants.FAIL));
		generalInfoPage.clickElementOfPage(nextButton);
	}

	@Given("^he has clicked on \"([^\"]*)\" button after performing following fields selection on navigated \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_performing_following_fields_selection_on_navigated_page(
			String nextButton, String expectedPageName, DataTable dataTable) throws Throwable {
		Assert.assertTrue(flexPolicySetupPage.verifyPageNavigation(expectedPageName), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POINT_POLICY_SETUP_PAGE, CoreConstants.FAIL));
		flexPolicySetupPage.selectFlexPolicySetupPageFields(dataTable);
		flexPolicySetupPage.clickElementOfPage(nextButton);
	}

	@Given("^he has clicked on \"([^\"]*)\" button after selecting following 'Benefits' on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_selecting_following_Benefits_on_page(String nextButton,
			String expectedPageName, DataTable dataTable) throws Throwable {
		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyPageNavigation(expectedPageName),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));
		// coreFlexPolicyBenefitsCategoriesPage.selectBenefits(dataTable);
		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(nextButton);
//		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyBenefitsDisplayedOnLeftNavigation(dataTable),
//				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DISPLAYED_ON_LEFT_NAVIGATION,
//						CoreConstants.FAIL));
	}

	@Then("^a success message pop-up should be displayed with message \"([^\"]*)\"$")
	public void a_success_message_pop_up_should_be_displayed_with_message(String submitStatusMessage) throws Throwable {
		Assert.assertTrue(
				coreFlexCustomBundlesPage.verifyPolicySubmitStatus(submitStatusMessage,
						addNewPolicyPage.getSelectedPolicyName()),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_SUBMIT_STATUS_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.OK);
	}

	/**********************************************************************************************************************************/

	@Given("^he has setup a new CoreFlex Policy with following selection in Blueprint application$")
	public void he_has_setup_a_new_CoreFlex_Policy_with_following_selection_in_Blueprint_application(
			DataTable dataTable) throws Throwable {

		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
		String policyRequiredFor = dataMap.get(0).get("PolicyRequiredFor");
		String benefitType = dataMap.get(0).get("BenefitType");
		String flexSetupType = dataMap.get(0).get("Flex Setup Type");
		String cashoutAvailability = dataMap.get(0).get("Cashout Availability");
		String personResponsibleForBenefitSelection = dataMap.get(0).get("Person Responsible For Benefit Selection");
		CoreFunctions.writeToPropertiesFile("CoreFlex_Policy_RequiredFor", policyRequiredFor);
		CoreFunctions.writeToPropertiesFile("CoreFlex_Policy_BenefitType", benefitType);
		CoreFunctions.writeToPropertiesFile("CoreFlex_Policy_FlexSetupType", flexSetupType);
		CoreFunctions.writeToPropertiesFile("CoreFlex_Policy_PersonResponsible", personResponsibleForBenefitSelection);
		CoreFunctions.writeToPropertiesFile("PolicyCashoutType", cashoutAvailability);

		Assert.assertTrue(bluePrintCFLoginPage.verifyLoginPageNavigation(), MessageFormat.format(
				PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_BLUE_PRINT_APPLICATION_LOGIN_PAGE, CoreConstants.FAIL));

		Assert.assertTrue(bluePrintCFLoginPage.loginByUserType(PDTConstants.CSM, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));

		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(COREFLEXConstants.ADD_NEW_POLICY_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL,
						COREFLEXConstants.ADD_NEW_POLICY_PAGE, PDTConstants.ADD_NEW_POLICY_FORM,
						addNewPolicyPage.getElementText(PDTConstants.HEADING)));

//		Assert.assertTrue(addNewPolicyPage.selectFirstAvailableClientID(),
//				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_CLIENTID_FROM_CLIENTID_FIELD, CoreConstants.FAIL));
//		Assert.assertTrue(addNewPolicyPage.selectAPolicy(addNewPolicyPage.getFirstAvailablePolicyOption()),
//				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));

		addNewPolicyPage.selectClient(_loginInfo.details.clientId, _loginInfo.details.clientName);
		Assert.assertTrue(addNewPolicyPage.selectAutomationPolicy(),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));

//		 Invoking IRIS application to select CoreFleXEnabled Policy
//		testContext.getBasePage().reLaunchIrisToAvoidFreezingIssue();
//		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
//		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
//		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
//		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.CORPORATION_MODULE);
//		testContext.getIrisPageManager().irisCorporationMain = new IRIS_Corporation_Main();
//		testContext.getIrisPageManager().irisCorporationMain
//				.queryCorporation(CoreFunctions.getPropertyFromConfig("Policy_ClientID"));
//		testContext.getIrisPageManager().irisCorporationMain.selectCorporationModules(IRISConstants.ACCOUNTING);
//		testContext.getIrisPageManager().irisCorporationAccounting = new IRIS_Corporation_Accounting();
//		testContext.getIrisPageManager().irisCorporationAccounting.verifyAccountingTab();
//		testContext.getIrisPageManager().irisCorporationAccounting.performCoreFlexCheckboxSelectionForPolicy(
//				PDTConstants.COREFLEX_ENABLED, IRISConstants.CHECKED,
//				CoreFunctions.getPropertyFromConfig("Assignment_Policy"));
//		testContext.getIrisPageManager().irisCorporationAccounting.clickOnSaveBtn();
//		testContext.getBasePage().cleanIrisProcesses();

		// Setting up a CoreFlex Enabled Policy
		addNewPolicyPage.clickElementOfPage(PDTConstants.NEXT);

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
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.TRACING_SET,
						CoreFunctions.getPropertyFromConfig("Policy_TracingSet")),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.TRACING_SET));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.CORE_FLEX_POLICY, PDTConstants.YES),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.CORE_FLEX_POLICY));
		Assert.assertTrue(generalInfoPage.verifyCappedPointBasedPolicyConditions(), MessageFormat.format(
				PDTConstants.FAILED_TO_VERIFY_CAPPED_AND_POINTS_BASED_FLEX_POLICY_CONDITIONAL_CHECKS_ERROR_POP_UP_ON_GENRAL_INFORMATION_PAGE,
				CoreConstants.FAIL, PDTConstants.CORE_FLEX_POLICY));
		generalInfoPage.fillOtherMandatoryFields();
		Assert.assertTrue(
				generalInfoPage.selectFieldOption(PDTConstants.POINTS_BASED_FLEX_POLICY, COREFLEXConstants.YES),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_FIELD_OPTIONS_ON_GENERAL_INFO_PAGE,
						CoreConstants.FAIL));
		generalInfoPage.clickElementOfPage(PDTConstants.NEXT);

		Assert.assertTrue(flexPolicySetupPage.verifyPageNavigation(COREFLEXConstants.POINT_POLICY_SETUP),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POINT_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));

		Assert.assertTrue(flexPolicySetupPage.verifyBenfitExpirationLockBenefitTooltip(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_BENEFIT_EXPIRATION_AND_LOCK_BENEFITS_TOOLTIP_ON_FLEX_POLICY_SETUP_PAGE,
				CoreConstants.FAIL));
//		flexPolicySetupPage.verifyNumericRangeFieldsValidation();
		flexPolicySetupPage.selectFlexPolicySetupPageFields(dataTable);
		Assert.assertTrue(flexPolicySetupPage.verifyFlexSetupTypeSelection(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_FLEX_SETUP_TYPE_SELECTION_ON_FLEX_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));
		flexPolicySetupPage.clickElementOfPage(PDTConstants.NEXT);

		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));

		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyPolicyCategoriesBenefitsAndOrder(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_CATEGORIES_BENEFITS_AND_ORDER_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));
		coreFlexPolicyBenefitsCategoriesPage.selectBenefits(benefitType, policyRequiredFor);
		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(PDTConstants.NEXT);

		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyInformationDialog(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_INFORMATION_DIALOG_AFTER_SELECTING_BENEFITS_AND_CLICKING_NEXT_ON_POLICY_BENEFIT_CATEGORIES_PAGE,
				CoreConstants.FAIL));

		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyBenefitsDisplayedOnLeftNavigation(benefitType,
						policyRequiredFor),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DISPLAYED_ON_LEFT_NAVIGATION,
						CoreConstants.FAIL));

		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.selectAndFillAddedBenefits(benefitType, policyRequiredFor),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_SELECT_AND_FILL_ADDED_BENEFITS, CoreConstants.FAIL));

		Assert.assertTrue(
				coreFlexBenefitSummaryPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFITS_BENEFIT_SUMMARY),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));

		Assert.assertTrue(coreFlexBenefitSummaryPage.iterateAndVerifyBenefitSummaryDetails(policyRequiredFor),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_BENEFIT_SUBBENEFIT_DETAILS_ON_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
		coreFlexBenefitSummaryPage.clickElementOfPage(COREFLEXConstants.CONTINUE);

		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPageNavigation(COREFLEXConstants.CUSTOM_BUNDLES),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));

		Assert.assertTrue(
				coreFlexCustomBundlesPage.iterateAndAddNewCustomBundle(COREFLEXConstants.ADD_NEW_CUSTOM_BUNDLE,
						benefitType, COREFLEXConstants.SAVE_CUSTOM_BUNDLE, policyRequiredFor),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_ADD_A_NEW_BUNDLE_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.PREVIEW_TRANSFEREE_EXPERIENCE);

		Assert.assertTrue(coreFlexTransfereePreviewPage.isPreviewTransfereePageDisplayed(), MessageFormat
				.format(COREFLEXConstants.FAILED_TO_VERIFY_NAVIGATION_TO_TRANSFEREE_PREVIEW_PAGE, CoreConstants.FAIL));

		Assert.assertTrue(
				coreFlexTransfereePreviewPage.verifyPreviewTransfereeExperience(benefitType, policyRequiredFor),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DETAILS_ON_PREVIEW_TRANSFEREE_PAGE,
						CoreConstants.FAIL));
		coreFlexTransfereePreviewPage.clickElementOfPage(COREFLEXConstants.CLOSE_TRANSFEREE_PREVIEW);
	}

	@Given("^he has clicked on \"([^\"]*)\" button to submit \"([^\"]*)\" policy verison on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_to_submit_policy_version_on_page(String buttonName, String policyVersion,
			String pageName) throws Throwable {
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.SUBMIT);
		Reporter.addStepLog(MessageFormat.format(
				COREFLEXConstants.SUCCESSFULLY_CLICKED_ON_SUBMIT_BUTTON_ON_CUSTOM_BUNDLES_PAGE, CoreConstants.PASS));

		Assert.assertTrue(
				coreFlexCustomBundlesPage.verifyPolicySubmitStatus(COREFLEXConstants.POLICY_SUBMIT_STATUS_MESSAGE,
						CoreFunctions.getPropertyFromConfig("Assignment_Policy")),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_SUBMIT_STATUS_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.OK);
	}

	@Given("^he has clicked on \"([^\"]*)\" button after removing/deselecting a benefit on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_removing_deselecting_a_benefit_on_page(String buttonName,
			String pageName) throws Throwable {
		coreFlexCustomBundlesPage.clickLeftNavigationMenuOfPage(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES);
		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.deselectSelectedBenefit(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_DESELECT_BENEFIT_ON_POLICY_BENEFIT_CATEGORIES_PAGE, CoreConstants.FAIL));
		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(buttonName);
	}

	@Given("^he clicks on \"([^\"]*)\" button to submit \"([^\"]*)\" policy verison on \"([^\"]*)\" page$")
	public void he_clicks_on_button_to_submit_policy_version_on_page(String buttonName, String policyVersion,
			String pageName) throws Throwable {
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.SUBMIT);
		Reporter.addStepLog(MessageFormat.format(
				COREFLEXConstants.SUCCESSFULLY_CLICKED_ON_SUBMIT_BUTTON_ON_CUSTOM_BUNDLES_PAGE, CoreConstants.PASS));

		Assert.assertTrue(
				coreFlexCustomBundlesPage.verifyPolicySubmitStatus(COREFLEXConstants.POLICY_SUBMIT_STATUS_MESSAGE,
						CoreFunctions.getPropertyFromConfig("Assignment_Policy")),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_SUBMIT_STATUS_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));

		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.OK);
	}

	@Then("^Policy Status and Version should be displayed as \"([^\"]*)\" and \"([^\"]*)\" respectively on 'Custom Bundles' page$")
	public void Policy_Status_and_Version_should_be_displayed_as_and_respectively_on_Custom_Bundles_page(
			String expectedStatus, String expectedVersion) throws Throwable {
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicyStatusPostSubmission(expectedStatus),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, COREFLEXConstants.CUSTOM_BUNDLES));
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicyVersionPostSubmission(expectedVersion),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_VERSION_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, COREFLEXConstants.CUSTOM_BUNDLES));
		Assert.assertTrue(coreFlexCustomBundlesPage.verifySubmitButtonDisabledPostSubmission(),
				MessageFormat.format(
						COREFLEXConstants.SUBMIT_BUTTON_NOT_DISABLED_AFTER_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, COREFLEXConstants.CUSTOM_BUNDLES));
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyApproveButtonDisplayedPostSubmission(), MessageFormat.format(
				COREFLEXConstants.APPROVE_POLICY_BUTTON_NOT_DISPLAYED_AFTER_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
				CoreConstants.FAIL, COREFLEXConstants.CUSTOM_BUNDLES));
	}

	@Given("^he has clicked on \"([^\"]*)\" button to approve \"([^\"]*)\" policy verison on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_to_approve_policy_version_on_page(String buttonName, String policyVersion,
			String pageName) throws Throwable {
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicyStatusPostSubmission(COREFLEXConstants.SUBMITTED),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, pageName));
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicyVersionPostSubmission(policyVersion),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_VERSION_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, pageName));
		Assert.assertTrue(coreFlexCustomBundlesPage.verifySubmitButtonDisabledPostSubmission(),
				MessageFormat.format(
						COREFLEXConstants.SUBMIT_BUTTON_NOT_DISABLED_AFTER_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, pageName));
		coreFlexCustomBundlesPage.clickElementOfPage(buttonName);
		Reporter.addStepLog(
				MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_CLICKED_ON_BUTTON_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.PASS, buttonName));
	}

	@Given("^he has filled 'Description' after selecting following option on 'Approval this Policy' dialog of \"([^\"]*)\" Policy$")
	public void he_has_filled_Description_after_selecting_following_option_on_Approval_this_Policy_dialog_of_Policy(
			String policyVersion, DataTable dataTable) throws Throwable {
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyApproveThisPolicyDialog(policyVersion), MessageFormat
				.format(COREFLEXConstants.FAILED_TO_VERIFY_APPROVE_THIS_POLICY_DIALOG, CoreConstants.FAIL));
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.ASSOCIATE_THIS_POLICY);
		Reporter.addStepLog(
				MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_CLICKED_ON_BUTTON_ON_APPROVE_THIS_POLICY_DIALOG,
						CoreConstants.PASS, COREFLEXConstants.ASSOCIATE_THIS_POLICY));
	}

	@When("^he clicks on \"([^\"]*)\" button to acknowledge 'Approve this Policy' dialog$")
	public void he_clicks_on_button_to_acknowledge_Approve_this_Policy_dialog(String buttonName) throws Throwable {
		coreFlexCustomBundlesPage.clickElementOfPage(buttonName);
		Reporter.addStepLog(
				MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_CLICKED_ON_BUTTON_ON_APPROVE_THIS_POLICY_DIALOG,
						CoreConstants.PASS, buttonName));
	}

	@Then("^Policy Status and Version should be displayed as \"([^\"]*)\" and \"([^\"]*)\" respectively on \"([^\"]*)\" page$")
	public void Policy_Status_and_Version_should_be_displayed_as_and_respectively_on_page(String expectedStatus,
			String expectedVersion, String pageName) throws Throwable {
		Assert.assertTrue(viewPolicyPage.verifyPageNavigation(COREFLEXConstants.VIEW_EDIT_POLICY_FORMS),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_VIEW_EDIT_POLICY_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				viewPolicyPage.verifyApprovedPolicyStatusAndVersion(
						CoreFunctions.getPropertyFromConfig("Assignment_Policy"), expectedStatus, expectedVersion),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_APPROVED_POLICY_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(viewPolicyPage.verifyFlexWordNotDisplayed(), MessageFormat
				.format(COREFLEXConstants.FLEX_WORD_DISPLAYED_ON_VIEW_EDIT_POLICY_FORMS_PAGE, CoreConstants.FAIL));
	}

	@Then("^Policy Status of Version \"([^\"]*)\" policy should be displayed as \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void Policy_Status_of_Version_policy_should_be_displayed_as_on_page(String policyVersion,
			String expectedStatus, String pageName) throws Throwable {
		Assert.assertTrue(
				viewPolicyPage.verifyPolicyStatusForVersion(CoreFunctions.getPropertyFromConfig("Assignment_Policy"),
						expectedStatus, policyVersion),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_APPROVED_POLICY_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'$")
	public void he_has_logged_into_MobilityX_application_after_creating_a_new_Transferee_through_IRIS_application_for_policy_setup_in_Policy_Digitization_Tool()
			throws Throwable {
		Assert.assertTrue(mobilityXLoginPage.verifyPageNavigation(),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_MOBILITYX_LOGIN_PAGE, CoreConstants.FAIL));
		createAnAssignmentInIRIS();
		Assert.assertTrue(mobilityXLoginPage.readCredentialsFromMail(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_READ_USER_CREDENTIALS_FROM_GENERATED_EMAIL, CoreConstants.FAIL));
		mobilityXLoginPage.enterUsernameAndPasswordForMobilityX(
				CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail"),
				CoreFunctions.getPropertyFromConfig("Transferee_PasswordInEMail"));
		mobilityXLoginPage.clickSignIn();
		mxTransfereeMyProfilePage.setUpNewMobilityXTransferee();
		mxTransfereeJourneyHomePage.handle_Cookie_AfterLogin();
		mxTransfereeJourneyHomePage.handle_points_expiry_reminder_popup();
	}

	private void createAnAssignmentInIRIS() {
		try {
			testContext.getBasePage().reLaunchIrisToAvoidFreezingIssue();
			testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
			testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginInfo);
			testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
			testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
			testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
			Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentOverviewPage.verifyOverviewTab(),
					MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
							IRISConstants.OVERVIEW));
			IRIS_AssignmentData assignmentOverviewData = FileReaderManager.getInstance().getIrisJsonReader()
					.getAssignmentDataByTabName(IRISConstants.OVERVIEW);
			testContext.getIrisPageManager().irisAssignmentOverviewPage.selectNewAssignmentFromFileMenu();
			testContext.getIrisPageManager().irisAssignmentOverviewPage.addDetailsOnOverviewTabForNewAssignment(
					assignmentOverviewData, CoreFunctions.getPropertyFromConfig("Policy_ClientID"),
					CoreFunctions.getPropertyFromConfig("Assignment_Policy"));
			IRIS_AssignmentData assignmentTransfereeData = FileReaderManager.getInstance().getIrisJsonReader()
					.getAssignmentDataByTabName(IRISConstants.TRANSFEREE_AND_FAMILY);
			testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.TRANSFEREE_AND_FAMILY);
			testContext
					.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage = new IRIS_AssignmentTransfereeNFamilyPage();
			testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
					.verifyTransfereeAndFamilyTab(IRISConstants.TRANSFEREE_AND_FAMILY);
			testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
					.addNewTransfereeDetails(assignmentTransfereeData);
			Assert.assertTrue(
					testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
							.saveTransferee(IRISConstants.NEW_TRANSFEREE_CREATED_SUCCESS_MSG),
					IRISConstants.NEW_TRANSFEREE_CREATED_SUCCESS_MSG + " Message " + IRISConstants.IS_NOT_DISPLAYED);
			testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage.addTransfereeIdentityDetails();
			testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
					.addNewFamilyDetails(assignmentTransfereeData);
			testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.ACTIVITY_FINANCE_TAB);
			testContext.getIrisPageManager().irisActivityAndFinancePage = new IRIS_ActivityAndFinancePage();
			Assert.assertTrue(testContext.getIrisPageManager().irisActivityAndFinancePage.verifyActivityAndFinanceTab(),
					MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
							IRISConstants.ACTIVITY_AND_FINANCE));
			testContext.getIrisPageManager().irisActivityAndFinancePage.displayActivityTable();
			testContext.getIrisPageManager().irisActivityAndFinancePage.actualizeTracingPrompt(IRISConstants.ACT_DATE,
					IRISConstants.ACTIVITY, IRISConstants.MAKE_FIRST_CONTACT);
			testContext.getIrisPageManager().irisActivityAndFinancePage.clickOnSaveBtn();
			testContext.getIrisPageManager().irisActivityAndFinancePage.sendLoginCredentials(IRISConstants.YES,
					IRISConstants.SEND_CREDENTIALS, IRISConstants.SEND_USER_LOGIN_MSG);
//		testContext.getIrisPageManager().irisActivityAndFinancePage.acceptIdentityChallengeQuestionDialog();
			Assert.assertTrue(
					testContext.getIrisPageManager().irisActivityAndFinancePage
							.relonetCredentialsSent(IRISConstants.SUCCESS_MSG, IRISConstants.MESSAGE_DIALOG),
					MessageFormat.format(IRISConstants.FAILED_TO_VERIFY_MESSAGE, CoreConstants.FAIL,
							IRISConstants.SUCCESS_MSG));
//			testContext.getIrisPageManager().irisAssignmentOverviewPage.setFileStatus(IRISConstants.ACTIVATE);
			testContext.getBasePage().cleanIrisProcesses();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CREATING_A_NEW_TRANSFEREE_IN_IRIS_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
			Assert.fail(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CREATING_A_NEW_TRANSFEREE_IN_IRIS_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}

	}

	@Given("^he has logged into 'MobilityX' application with the 'Transferee' user$")
	public void he_has_logged_into_MobilityX_application_with_the_Transferee_user() throws Throwable {
		Assert.assertTrue(mobilityXLoginPage.verifyPageNavigation(),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_MOBILITYX_LOGIN_PAGE, CoreConstants.FAIL));

		mobilityXLoginPage.enterUsernameAndPasswordForMobilityX(
				CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail"),
				CoreFunctions.getPropertyFromConfig("Transferee_PasswordInEMail"));
		mobilityXLoginPage.clickSignIn();
		mxTransfereeJourneyHomePage.handle_Cookie_AfterLogin();
		mxTransfereeJourneyHomePage.handle_points_expiry_reminder_popup();
	}

	@And("he has delegated flex benefit access to a different user")
	public void he_has_delegated_flex_benefit_access_to_a_different_user() {
		mxTransfereeJourneyHomePage.proceedToAccountSettingsPage();
		mxTransfereeJourneyHomePage.delegateAccess();
		mobilityXLoginPage.clickLogOut();
	}

	@And("he has provided 'Access to OnPoint' delegate access to the newly created DelegateUser on 'Delegate Information' page")
	public void he_has_provided_Access_to_OnPoint_delegate_access_to_the_new_User_on_Delegate_Information_page() {
		mxTransfereeJourneyHomePage.proceedToAccountSettingsPage();
		Assert.assertTrue(mxTransfereeJourneyHomePage.delegateAccess(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_PROVIDE_FLEX_BENEFITS_DELEGATE_ACCESS_TO_DELEGATED_USER,
						CoreConstants.FAIL));
		mobilityXLoginPage.clickLogOut();
	}

	@When("he logged into MobilityX application as delegated user")
	public void he_logged_in_as_a_different_user() {
		Assert.assertTrue(mobilityXLoginPage.readDelegateCredentialsFromMail(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_READ_USER_CREDENTIALS_FROM_GENERATED_EMAIL, CoreConstants.FAIL));
		mobilityXLoginPage.enterUsernameAndPasswordForMobilityX(
				CoreFunctions.getPropertyFromConfig("Delegate_UserNameInEMail"),
				CoreFunctions.getPropertyFromConfig("Delegate_PasswordInEMail"));
		mobilityXLoginPage.clickSignIn();
		mxTransfereeMyProfilePage.setUpNewMobilityXTransferee();
		mxTransfereeJourneyHomePage.handle_Cookie_AfterLogin();
		mxTransfereeJourneyHomePage.handle_points_expiry_reminder_popup();
	}

	@Given("he has logged into MobilityX application as a delegated user")
	public void he_has_logged_into_MobilityX_application_as_a_delegated_user() {
		Assert.assertTrue(mobilityXLoginPage.readDelegateCredentialsFromMail(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_READ_USER_CREDENTIALS_FROM_GENERATED_EMAIL, CoreConstants.FAIL));
		mobilityXLoginPage.enterUsernameAndPasswordForMobilityX(
				CoreFunctions.getPropertyFromConfig("Delegate_UserNameInEMail"),
				CoreFunctions.getPropertyFromConfig("Delegate_PasswordInEMail"));
		mobilityXLoginPage.clickSignIn();
		mxTransfereeMyProfilePage.setUpNewMobilityXTransferee();
		mxTransfereeJourneyHomePage.handle_Cookie_AfterLogin();
		mxTransfereeJourneyHomePage.handle_points_expiry_reminder_popup();
		Assert.assertTrue(mxTransfereeJourneyHomePage.validateDelegateUserBanner(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_LOGGED_IN_DELEGATE_USER, CoreConstants.FAIL));
	}

	@Then("he should be able to access selected flex benefit details of the transferee")
	public void validate_selected_benefits_as_a_delegated_user() {
		mxTransfereeJourneyHomePage.validateDelegateUserBanner();
	}

	@Given("^he has impersonated the user with below details from MobilityX dashboard$")
	public void he_impersonates_a_user_with_below_details_from_MobilityX_Dashboard(DataTable table) {
		mxTransfereeJourneyHomePage.clickElementOfDashboardPage(COREFLEXConstants.IMPERSONATE_A_USER);
		mxTransfereeJourneyHomePage.verifyImpersonateDialogTitleAppear();
		mxTransfereeJourneyHomePage.searchUserAndImpersonate(table);
	}

	@Given("^he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog$")
	public void he_has_validated_Assignment_Policy_details_after_selecting_below_option_displayed_on_Welcome_dialog(
			DataTable dataTable) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.isWelcomePopupDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_WELCOME_POPUP_ON_TRANSFEREE_JOURNEY_HOME_PAGE,
						CoreConstants.FAIL));
		List<Map<String, String>> action = dataTable.asMaps(String.class, String.class);
		mxTransfereeJourneyHomePage.progressOrSkipMobilityJourneyHomePage(action.get(0).get("WelcomeDialogSelection"));
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyAssignmentAndPolicyDetails(), MessageFormat.format(
				MobilityXConstants.ASSIGNMENT_DETAILS_NOT_MATCHED_ON_MOBILITY_JOURNEY_HOME_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.setUpPaymentAccount(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_SETUP_PAYMENT_ACCOUNT, CoreConstants.FAIL));
	}

	@Given("^he has navigated to \"([^\"]*)\" page after clicking on 'Manage my Points' button on \"([^\"]*)\" page$")
	public void he_has_navigated_to_page_after_clicking_on_Manage_my_Points_button_on_page(String navigatedPage,
			String sourcePage) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.ONPOINT_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
	}

	@Given("^he has verified Benefits details displayed under 'Core Benefits' and 'Flex Benefits' section on \"([^\"]*)\" page$")
	public void he_has_verified_Benefits_details_displayed_under_Core_Benefits_and_Flex_Benefits_section_on_page(
			String pageName) throws Throwable {
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyWindowTitle(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VALIDATE_ONPOINT_PLANNING_TOOL_PAGE_TITLE, CoreConstants.FAIL));
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

	@Given("^he has navigated to \"([^\"]*)\" page after clicking on following link on \"([^\"]*)\" page$")
	public void he_has_navigated_to_page_after_clicking_on_following_link_on_page(String navigatedPageName,
			String sourcePageName, DataTable dataTable) throws Throwable {
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.SUGGESTED_OPTIONS_LINK);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyUserNavigationToSuggestedBundlesPage(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_NAVIGATE_TO_SUGGESTED_BUNDLES_PAGE, CoreConstants.FAIL));

	}

	@Given("^he has verified 'Custom Bundle' Benefit details displayed under 'Recommended Bundle' section on \"([^\"]*)\" page$")
	public void he_has_verified_Custom_Bundle_Benefit_details_displayed_under_Recommended_Bundle_section_on_page(
			String pageName) throws Throwable {
		Assert.assertTrue(
				mxTransfereeFlexPlanningToolPage.verifySuggestedBundlesDetailsBasedOnPolicyRequiredFor(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"),
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType")),
				MessageFormat.format(MobilityXConstants.CUSTOM_BUNDLE_DETAILS_NOT_MATCHED_ON_SUGGESTED_BUNDLES_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has navigated back to \"([^\"]*)\" page after clicking on 'Back to benefits list' button$")
	public void he_has_navigated_back_to_page_after_clicking_on_Back_to_benefits_list_button_on_page(
			String navigatedPage) throws Throwable {
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.ONPOINT_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
	}

	@Given("^he has clicked on \"([^\"]*)\" button after validating all the benefit details listed under 'Selected Benefits' section on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_validating_all_the_benefit_details_listed_under_Selected_Benefits_section_on_page(
			String reviewAndSubmitButton, String pageName) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifySelectedBenefitDetails(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.clickReviewAndSubmit();

	}

	@Given("^he has clicked on \"([^\"]*)\" button after validating all the 'Aires Managed' benefit details listed under 'Selected Benefits' section on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_validating_all_the_Aires_Managed_benefit_details_listed_under_Selected_Benefits_section_on_page(
			String reviewAndSubmitButton, String pageName) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifySelectedAiresManagedBenefitDetails(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_SELECTED_AIRES_MANAGED_BENEFITS_ON_MY_BUNDLE_PAGE,
						CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.clickReviewAndSubmit();

	}

	@Given("^he has clicked on \"([^\"]*)\" button after entering Transferee name on \"([^\"]*)\" dialog$")
	public void he_has_clicked_on_button_after_entering_Transferee_name_on_dialog(String buttonName,
			String submissionDialog) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isSubmitBundlePopupDisplayed(),
				MessageFormat.format(MobilityXConstants.SUBMIT_BUNDLE_POPUP_NOT_DISPLAYED, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyBenefitsDetailsOnSubmissionDialog(),
				MessageFormat.format(MobilityXConstants.POINTS_AND_BENEFIT_DETAILS_NOT_MATCHED_ON_SUBMIT_BUNDLE_POPUP,
						CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.reviewAndConfirmBenefitSubmission(
				MobilityXConstants.SUBMIT_BENEFITS_OPTIONAL_NOTES,
				CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
						+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
				buttonName);

	}

	@Given("^he has clicked on \"([^\"]*)\" button after entering Transferee name on \"([^\"]*)\" dialog and validating 'Aires Managed' benefit details$")
	public void he_has_clicked_on_button_after_entering_Transferee_name_on_dialog_and_validating_Aires_Managed_benefit_details(
			String buttonName, String submissionDialog) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isSubmitBundlePopupDisplayed(),
				MessageFormat.format(MobilityXConstants.SUBMIT_BUNDLE_POPUP_NOT_DISPLAYED, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyAiresManagedBenefitDetailsOnSubmissionDialog(),
				MessageFormat.format(MobilityXConstants.POINTS_AND_BENEFIT_DETAILS_NOT_MATCHED_ON_SUBMIT_BUNDLE_POPUP,
						CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.reviewAndConfirmBenefitSubmission(
				MobilityXConstants.SUBMIT_BENEFITS_OPTIONAL_NOTES,
				CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
						+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
				buttonName);

	}

	@Given("^he has clicked on \"([^\"]*)\" button displayed on 'Success Flex' dialog$")
	public void he_has_clicked_on_button_displayed_on_Success_Flex_dialog(String button) throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isBenefitSubmittedPopUpDisplayed(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_BENEFITS_SUCCESS_FLEX_DIALOG, CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.viewSubmittedBenefits();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
	}

	@Given("^he has verified 'Mobility Benefits Submission' email generated upon OnPoint Benefits Submission$")
	public void he_has_verified_Mobility_Benefits_Submission_email_generated_upon_OnPoint_Benefits_Submission()
			throws Throwable {
		Assert.assertTrue(
				mxTransfereeJourneyHomePage.verifyBenefitSubmissionEmail(MobilityXConstants.TRANSFEREE_SUBMISSION),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_MOBILITY_BENEFIT_SUBMISSION_EMAIL,
						CoreConstants.FAIL));
	}

	@Given("^he has verified 'Benefit Submission Email' for Impersonated Transferee by Client after clicking on \"([^\"]*)\" button displayed on 'Success Flex' dialog$")
	public void he_has_clicked_on_button_displayed_on_Success_Flex_dialog_for_Impersonated_User(String button)
			throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isBenefitSubmittedPopUpDisplayed(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_BENEFITS_SUCCESS_FLEX_DIALOG, CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.viewSubmittedBenefits();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(
				mxTransfereeJourneyHomePage
						.verifyBenefitSubmissionEmail(MobilityXConstants.CLIENT_IMPERSONATION_SUBMISSION),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_MOBILITY_FLEX_BENEFIT_SUBMISSION_IMPERSONATION_EMAIL,
						CoreConstants.FAIL));
	}

	@When("^he clicks on \"([^\"]*)\" button displayed on 'Success Flex' dialog$")
	public void he_clicks_on_button_displayed_on_Success_Flex_dialog(String button) throws Throwable {
		mxTransfereeMyBenefitsBundlePage.viewSubmittedBenefits();
	}

	@Given("^he has verified submitted points details on 'Mobility Journey Home' and 'OnPoint Planning Tool' page$")
	public void he_has_verified_submitted_points_details_on_Mobility_Journey_Home_and_OnPoint_Planning_Tool_page()
			throws Throwable {
		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.ONPOINT_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifySubmittedPointsDetails(), MessageFormat.format(
				MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_JOURNEY_HOME_PAGE, CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.ONPOINT_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		Assert.assertTrue(
				mxTransfereeFlexPlanningToolPage.verifyElementPresentOnPage(MobilityXConstants.EDIT_SUBMITTED_BENEFITS),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_ELEMENT_PRESENT_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL, MobilityXConstants.EDIT_SUBMITTED_BENEFITS));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessageAfterSubmission(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySubmittedPointsDetails(),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
	}

	@Then("^submitted points details should be updated on 'Mobility Journey Home' and 'Flex Planning Tool' page$")
	public void submitted_points_details_should_be_updated_on_Mobility_Journey_Home_and_Flex_Planning_Tool_page()
			throws Throwable {
		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.ONPOINT_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifySubmittedPointsDetails(), MessageFormat.format(
				MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_JOURNEY_HOME_PAGE, CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);

		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.ONPOINT_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessageAfterSubmission(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySubmittedPointsDetails(),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has logged into 'Transferee Submissions' application as a \"([^\"]*)\" user$")
	public void he_has_logged_into_Transferee_Submissions_application_as_a_user(String userType) throws Throwable {
		Assert.assertTrue(transfereeSubmissionsLoginPage.verifyPageNavigation(),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_MOBILITYX_LOGIN_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(transfereeSubmissionsLoginPage.loginByUserType(userType), MessageFormat
				.format(COREFLEXConstants.FAILED_TO_LOGIN_INTO_TRANSFEREE_SUBMISSIONS_APPLICATION, CoreConstants.FAIL));

	}

	@Given("^he has navigated to \"([^\"]*)\" page having record of Bundle submitted by the transferee$")
	public void he_has_navigated_to_page_having_record_of_Bundle_submitted_by_the_transferee(String pageName)
			throws Throwable {

		// Remove this method when 3rd party redirection issue is fixed
		transfereeSubmissionsDashboardHomePage.reloadApplicationIfNotLoaded();

		Assert.assertTrue(transfereeSubmissionsDashboardHomePage.verifyUserNavigationToDashboardPage(),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_TRANSFEREE_SUBMISSIONS_DASHBOARD_HOME_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				transfereeSubmissionsDashboardHomePage.verifyUserLogin(
						transfereeSubmissionsLoginPage.getCSMUserName(_transfereeSubmissionLoginData),
						COREFLEXConstants.TRANSFEREE_SUBMISSIONS_DASHBOARD_HOME_PAGE),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_DETAILS_ON_DASHBOARD_HOME_PAGE,
						CoreConstants.FAIL));
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

	@Given("^he has verified submitted benefit details under 'Submitted Benefits' section of 'My Benefits Bundle' page$")
	public void he_has_verified_submitted_benefit_details_under_Submitted_Benefits_section_of_my_benefits_bundle_page() {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedBenefitDetails(),
				MobilityXConstants.SUBMITTED_BENEFIT_DETAILS_NOT_MATCHED);
	}

	@Given("^he has verified submitted Benefit_Cashout details under 'Submitted Benefits' section of 'My Benefits Bundle' page$")
	public void he_has_verified_submitted_Benefit_Cashout_details_under_Submitted_Benefits_section_of_my_benefits_bundle_page() {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedBenefitDetails(),
				MobilityXConstants.SUBMITTED_BENEFIT_DETAILS_NOT_MATCHED);
	}

	@Then("^points should be updated in 'Points Balance' section for the \"([^\"]*)\" delete request on \"([^\"]*)\" page$")
	public void points_should_be_updated_in_Points_Balance_section_for_the_delete_request_on_page(String action,
			String pageName) throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyPointBalancePostDeleteRequestAction(action, pageName),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POINTS_DETAILS_POST_APPROVED_DELETE_REQUEST_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
						CoreConstants.FAIL));
	}

	@Then("^points should not be updated in 'Points Balance' section for the \"([^\"]*)\" delete request on \"([^\"]*)\" page$")
	public void points_should_not_be_updated_in_Points_Balance_section_for_the_delete_request_on_page(String action,
			String pageName) throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyPointBalancePostDeleteRequestAction(action, pageName),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POINTS_DETAILS_POST_DENIED_DELETE_REQUEST_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has created a new 'Transferee' through IRIS application for 'Cloning/Versioning' Data Setup$")
	public void he_has_created_a_new_Transferee_through_IRIS_application_for_Cloning_Versioning_Data_Setup()
			throws Throwable {
		testContext.getBasePage().reLaunchIrisToAvoidFreezingIssue();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginInfo);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentOverviewPage.verifyOverviewTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.OVERVIEW));
		IRIS_AssignmentData assignmentOverviewData = FileReaderManager.getInstance().getIrisJsonReader()
				.getAssignmentDataByTabName(IRISConstants.OVERVIEW);
		testContext.getIrisPageManager().irisAssignmentOverviewPage.selectNewAssignmentFromFileMenu();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.addDetailsOnOverviewTabForNewAssignment(
				assignmentOverviewData, CoreFunctions.getPropertyFromConfig("Policy_ClientID"),
				CoreFunctions.getPropertyFromConfig("Assignment_Policy"));
		IRIS_AssignmentData assignmentTransfereeData = FileReaderManager.getInstance().getIrisJsonReader()
				.getAssignmentDataByTabName(IRISConstants.TRANSFEREE_AND_FAMILY);
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.TRANSFEREE_AND_FAMILY);
		testContext
				.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage = new IRIS_AssignmentTransfereeNFamilyPage();
		testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
				.verifyTransfereeAndFamilyTab(IRISConstants.TRANSFEREE_AND_FAMILY);
		testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
				.addNewTransfereeDetails(assignmentTransfereeData);
		Assert.assertTrue(
				testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
						.saveTransferee(IRISConstants.NEW_TRANSFEREE_CREATED_SUCCESS_MSG),
				IRISConstants.NEW_TRANSFEREE_CREATED_SUCCESS_MSG + " Message " + IRISConstants.IS_NOT_DISPLAYED);
		testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage.addTransfereeIdentityDetails();

		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.ACTIVITY_FINANCE_TAB);
		testContext.getIrisPageManager().irisActivityAndFinancePage = new IRIS_ActivityAndFinancePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisActivityAndFinancePage.verifyActivityAndFinanceTab(),
				MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
						IRISConstants.ACTIVITY_AND_FINANCE));
		testContext.getIrisPageManager().irisActivityAndFinancePage.displayActivityTable();
		testContext.getIrisPageManager().irisActivityAndFinancePage.actualizeTracingPrompt(IRISConstants.ACT_DATE,
				IRISConstants.ACTIVITY, IRISConstants.MAKE_FIRST_CONTACT);
		testContext.getIrisPageManager().irisActivityAndFinancePage.clickOnSaveBtn();
		testContext.getIrisPageManager().irisActivityAndFinancePage.sendLoginCredentials(IRISConstants.YES,
				IRISConstants.SEND_CREDENTIALS, IRISConstants.SEND_USER_LOGIN_MSG);
		testContext.getIrisPageManager().irisActivityAndFinancePage.acceptIdentityChallengeQuestionDialog();
		Assert.assertTrue(
				testContext.getIrisPageManager().irisActivityAndFinancePage
						.relonetCredentialsSent(IRISConstants.SUCCESS_MSG, IRISConstants.MESSAGE_DIALOG),
				MessageFormat.format(IRISConstants.FAILED_TO_VERIFY_MESSAGE, CoreConstants.FAIL,
						IRISConstants.SUCCESS_MSG));
		testContext.getBasePage().cleanIrisProcesses();
		testContext.getBasePage().invokeIrisApplication();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginInfo);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentOverviewPage.verifyOverviewTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.OVERVIEW));
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.setFileStatus(IRISConstants.ACTIVATE);
		testContext.getBasePage().cleanIrisProcesses();
	}

	@Given("^he has logged into 'MobilityX' application after actualizing a new 'Transferee' through IRIS application and setting-up user profile in 'MobilityX' application$")
	public void he_has_logged_into_MobilityX_application_after_actualizing_a_new_Transferee_through_IRIS_application_and_setting_up_user_profile_in_MobilityX_application()
			throws Throwable {
		Assert.assertTrue(mobilityXLoginPage.verifyPageNavigation(),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_MOBILITYX_LOGIN_PAGE, CoreConstants.FAIL));
		actualizeTransfereeCreatedByClient();
		Assert.assertTrue(mobilityXLoginPage.readCredentialsFromMail(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_READ_USER_CREDENTIALS_FROM_GENERATED_EMAIL, CoreConstants.FAIL));
		mobilityXLoginPage.enterUsernameAndPasswordForMobilityX(
				CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail"),
				CoreFunctions.getPropertyFromConfig("Transferee_PasswordInEMail"));
		mobilityXLoginPage.clickSignIn();
		mxTransfereeMyProfilePage.setUpNewMobilityXTransferee();
		mxTransfereeJourneyHomePage.handle_Cookie_AfterLogin();
		mxTransfereeJourneyHomePage.handle_points_expiry_reminder_popup();
	}

	private void actualizeTransfereeCreatedByClient() throws Exception {
		testContext.getBasePage().reLaunchIrisToAvoidFreezingIssue();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginInfo);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptLinkSuggestionDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.ACTIVITY_FINANCE_TAB);
		testContext.getIrisPageManager().irisActivityAndFinancePage = new IRIS_ActivityAndFinancePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisActivityAndFinancePage.verifyActivityAndFinanceTab(),
				MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
						IRISConstants.ACTIVITY_AND_FINANCE));
		testContext.getIrisPageManager().irisActivityAndFinancePage.displayActivityTable();
		testContext.getIrisPageManager().irisActivityAndFinancePage.actualizeTracingPrompt(IRISConstants.ACT_DATE,
				IRISConstants.ACTIVITY, IRISConstants.MAKE_FIRST_CONTACT);
		testContext.getIrisPageManager().irisActivityAndFinancePage.clickOnSaveBtn();
		testContext.getIrisPageManager().irisActivityAndFinancePage.sendLoginCredentials(IRISConstants.YES,
				IRISConstants.SEND_CREDENTIALS, IRISConstants.SEND_USER_LOGIN_MSG);
		testContext.getIrisPageManager().irisActivityAndFinancePage.acceptWarningDialog();
//		testContext.getIrisPageManager().irisActivityAndFinancePage.acceptIdentityChallengeQuestionDialog();
		Assert.assertTrue(
				testContext.getIrisPageManager().irisActivityAndFinancePage
						.relonetCredentialsSent(IRISConstants.SUCCESS_MSG, IRISConstants.MESSAGE_DIALOG),
				MessageFormat.format(IRISConstants.FAILED_TO_VERIFY_MESSAGE, CoreConstants.FAIL,
						IRISConstants.SUCCESS_MSG));		
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.OVERVIEW);
		IRIS_AssignmentData assignmentOverviewData = FileReaderManager.getInstance().getIrisJsonReader()
				.getAssignmentDataByTabName(IRISConstants.OVERVIEW);
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.addAiresTeamDetailsOnOverviewTab(assignmentOverviewData);		
//		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.SERVICE_TAB);
//		testContext.getIrisPageManager().irisAssignmentServicePage = new IRIS_AssignmentServicePage();
//		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentServicePage.verifyServiceTab(), MessageFormat
//				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.SERVICE));		
//		testContext.getIrisPageManager().irisAssignmentServicePage.addService(IRISConstants.EXPENSE);
//		testContext.getIrisPageManager().irisAssignmentOverviewPage.setFileStatus(IRISConstants.ACTIVATE);
		testContext.getBasePage().cleanIrisProcesses();
	}

	@Given("^he has setup a new Points Based CoreFlex Policy with following selection in Blueprint application$")
	public void he_has_setup_a_new_Points_Based_CoreFlex_Policy_with_following_selection_in_Blueprint_application(
			DataTable dataTable) throws Throwable {

		BusinessFunctions.resetPropertiesValue();
		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
		String policyRequiredFor = dataMap.get(0).get("PolicyRequiredFor");
		String benefitType = dataMap.get(0).get("BenefitType");
		String flexSetupType = dataMap.get(0).get("Flex Setup Type");
		String personResponsibleForBenefitSelection = dataMap.get(0).get("Person Responsible For Benefit Selection");
		CoreFunctions.writeToPropertiesFile("CoreFlex_Policy_RequiredFor", policyRequiredFor);
		CoreFunctions.writeToPropertiesFile("CoreFlex_Policy_BenefitType", benefitType);
		CoreFunctions.writeToPropertiesFile("CoreFlex_Policy_FlexSetupType", flexSetupType);
		CoreFunctions.writeToPropertiesFile("CoreFlex_Policy_PersonResponsible", personResponsibleForBenefitSelection);

		Assert.assertTrue(bluePrintCFLoginPage.verifyLoginPageNavigation(), MessageFormat.format(
				PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_BLUE_PRINT_APPLICATION_LOGIN_PAGE, CoreConstants.FAIL));

		Assert.assertTrue(bluePrintCFLoginPage.loginByUserType(PDTConstants.CSM, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));

		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(COREFLEXConstants.ADD_NEW_POLICY_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL,
						COREFLEXConstants.ADD_NEW_POLICY_PAGE, PDTConstants.ADD_NEW_POLICY_FORM,
						addNewPolicyPage.getElementText(PDTConstants.HEADING)));

		addNewPolicyPage.clickElementOfPage(PDTConstants.CLIENT_ID);
		addNewPolicyPage.selectClient(_loginInfo.details.clientId, _loginInfo.details.clientName);
		addNewPoliciesForClientInIRIS(_loginInfo.details.clientId, addNewPolicyPage.verifyAutomationPolicyPresent());

		addNewPolicyPage.clickElementOfPage(PDTConstants.CLIENT_ID);
		addNewPolicyPage.selectClient(_loginInfo.details.clientId, _loginInfo.details.clientName);
		Assert.assertTrue(addNewPolicyPage.selectAutomationPolicy(),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));

		addNewPolicyPage.clickElementOfPage(PDTConstants.NEXT);
		Assert.assertTrue(generalInfoPage.verifyPageNavigation(COREFLEXConstants.GENERAL_INFORMATION_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));

		Assert.assertTrue(generalInfoPage.verifyFlexWordNotDisplayed(), MessageFormat
				.format(COREFLEXConstants.FLEX_WORD_DISPLAYED_ON_GENERAL_INFORMATION_PAGE, CoreConstants.FAIL));

		Assert.assertTrue(generalInfoPage.verifyGeneralInfoPageFieldValues(), MessageFormat
				.format(COREFLEXConstants.FAILED_TO_VERIFY_VALUES_ON_GENERAL_INFORMATION_PAGE, CoreConstants.FAIL));
		generalInfoPage.fillOtherMandatoryFields();
		Assert.assertTrue(
				generalInfoPage.selectFieldOption(PDTConstants.POINTS_BASED_FLEX_POLICY, COREFLEXConstants.YES),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_FIELD_OPTIONS_ON_GENERAL_INFO_PAGE,
						CoreConstants.FAIL));

		generalInfoPage.clickElementOfPage(PDTConstants.NEXT);
		Assert.assertTrue(flexPolicySetupPage.verifyPageNavigation(COREFLEXConstants.POINT_POLICY_SETUP),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POINT_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));

		flexPolicySetupPage.selectFlexPolicySetupPageFields(dataTable);
		Assert.assertTrue(flexPolicySetupPage.verifyFlexSetupTypeSelection(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_FLEX_SETUP_TYPE_SELECTION_ON_FLEX_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));

		flexPolicySetupPage.clickElementOfPage(PDTConstants.NEXT);
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));

		coreFlexPolicyBenefitsCategoriesPage.selectBenefits(benefitType, policyRequiredFor);
		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(PDTConstants.NEXT);

		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyInformationDialog(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_INFORMATION_DIALOG_AFTER_SELECTING_BENEFITS_AND_CLICKING_NEXT_ON_POLICY_BENEFIT_CATEGORIES_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyBenefitsDisplayedOnLeftNavigation(benefitType,
						policyRequiredFor),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DISPLAYED_ON_LEFT_NAVIGATION,
						CoreConstants.FAIL));

		coreFlexPolicyBenefitsCategoriesPage.clickLeftNavigationMenuOfPage(COREFLEXConstants.GENERAL_INFORMATION);
		Assert.assertTrue(generalInfoPage.verifyPageNavigation(COREFLEXConstants.GENERAL_INFORMATION_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		generalInfoPage.clickElementOfPage(PDTConstants.NEXT);
		Assert.assertTrue(flexPolicySetupPage.verifyPageNavigation(COREFLEXConstants.POINT_POLICY_SETUP),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POINT_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyBenefitsDisplayedOnLeftNavigation(benefitType,
						policyRequiredFor),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DISPLAYED_ON_LEFT_NAVIGATION,
						CoreConstants.FAIL));

		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.selectAndFillAddedBenefits(benefitType, policyRequiredFor),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_SELECT_AND_FILL_ADDED_BENEFITS, CoreConstants.FAIL));

		Assert.assertTrue(
				coreFlexBenefitSummaryPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFITS_BENEFIT_SUMMARY),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));

		Assert.assertTrue(coreFlexBenefitSummaryPage.verifyFlexWordNotDisplayed(), MessageFormat
				.format(COREFLEXConstants.FLEX_WORD_DISPLAYED_ON_BENEFIT_SUMMARY_PAGE, CoreConstants.FAIL));

		Assert.assertTrue(coreFlexBenefitSummaryPage.iterateAndVerifyBenefitSummaryDetails(policyRequiredFor),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_BENEFIT_SUBBENEFIT_DETAILS_ON_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
		coreFlexBenefitSummaryPage.clickElementOfPage(COREFLEXConstants.CONTINUE);

		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPageNavigation(COREFLEXConstants.CUSTOM_BUNDLES),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));

		Assert.assertTrue(
				coreFlexCustomBundlesPage.iterateAndAddNewCustomBundle(COREFLEXConstants.ADD_NEW_CUSTOM_BUNDLE,
						benefitType, COREFLEXConstants.SAVE_CUSTOM_BUNDLE, policyRequiredFor),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_ADD_A_NEW_BUNDLE_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));

		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.PREVIEW_TRANSFEREE_EXPERIENCE);

		Assert.assertTrue(coreFlexTransfereePreviewPage.isPreviewTransfereePageDisplayed(), MessageFormat
				.format(COREFLEXConstants.FAILED_TO_VERIFY_NAVIGATION_TO_TRANSFEREE_PREVIEW_PAGE, CoreConstants.FAIL));

		Assert.assertTrue(
				coreFlexTransfereePreviewPage.verifyPreviewTransfereeExperience(benefitType, policyRequiredFor),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DETAILS_ON_PREVIEW_TRANSFEREE_PAGE,
						CoreConstants.FAIL));
		coreFlexTransfereePreviewPage.clickElementOfPage(COREFLEXConstants.CLOSE_TRANSFEREE_PREVIEW);
	}

	/**
	 * Method to add New Policies in IRIS application -> Accounting tab for
	 * specified Client if available Automation Policy Count is <3
	 * 
	 * @param clientId
	 * @param isAutomationPolicyPresent
	 */
	private void addNewPoliciesForClientInIRIS(String clientId, boolean isAutomationPolicyPresent) {
		try {
			if (!isAutomationPolicyPresent) {
				testContext.getBasePage().reLaunchIrisToAvoidFreezingIssue();
				testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
				testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginInfo);
				testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
				testContext.getIrisPageManager().irisWelcome12C
						.selectWelcomeWindowModule(IRISConstants.CORPORATION_MODULE);
				testContext.getIrisPageManager().irisCorporationMain = new IRIS_Corporation_Main();
				testContext.getIrisPageManager().irisCorporationMain.queryCorporation(clientId);
				testContext.getIrisPageManager().irisCorporationMain.selectCorporationModules(IRISConstants.ACCOUNTING);
				testContext.getIrisPageManager().irisCorporationAccounting = new IRIS_Corporation_Accounting();
				testContext.getIrisPageManager().irisCorporationAccounting.verifyAccountingTab();
				testContext.getIrisPageManager().irisCorporationAccounting.addNewOnPointAutomationPolicies(clientId);
				testContext.getIrisPageManager().irisCorporationAccounting.clickOnSaveBtn();
				testContext.getBasePage().cleanIrisProcesses();
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_ADDED_15_ADDITIONAL_AUTOMATION_POLICIES_IN_ACCOUNTING_TAB_FOR_CLIENT,
						CoreConstants.PASS, clientId));
				viewPolicyPage.clickElementOfPage(PDTConstants.VIEW_EDIT_POLICY_FORMS);
				viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
			} else {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.MORE_THAN_3_AUTOMATION_POLICIES_ALREADY_PRESENT_IN_ACCOUNTING_TAB_FOR_CLIENT,
						CoreConstants.PASS, clientId));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_ADDING_NEW_POLICIES_IN_ACCOUNTING_TAB_FOR_CLIENT,
					CoreConstants.FAIL, e.getMessage(), clientId));
		}

	}

	/**
	 * Method to Reset all Properties values while setting-up a new policy for each
	 * End-To-End Test Run
	 */
	public void resetPropertiesValue() {
		CoreFunctions.writeToPropertiesFile("CF_Client_AvailablePoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_SelectedCashOutPoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_TotalAvailablePoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Client_SelectedCashOutPoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_DeleteRequestTotalPoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_AvailablePoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_TotalSelectedPoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Client_TotalSelectedPoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_DeleteRequestDenied", "false");
		CoreFunctions.writeToPropertiesFile("CF_Client_DeleteRequestDenied", "false");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_UndoDeleteBenefit", "false");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_DeleteRequestApproved", "false");
		CoreFunctions.writeToPropertiesFile("CF_Client_DeleteRequestApproved", "false");
		CoreFunctions.writeToPropertiesFile("CF_Client_UndoDeleteBenefit", "false");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_BenefitDeletedFlag", "false");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_BenefitUndoFlag", "false");
		CoreFunctions.writeToPropertiesFile("CF_Client_BenefitSubmitted", "false");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_BenefitSubmitted", "false");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_CashoutCurrencySign", "");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_CashoutCurrencyCode", "");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_CashoutCurrencyText", "");
		CoreFunctions.writeToPropertiesFile("Policy_TracingSet", "Assignment");
		CoreFunctions.writeToPropertiesFile("ClonePolicy_Reference_PolicyName", "");
		CoreFunctions.writeToPropertiesFile("ClonePolicy_Reference_PolicyVersion", "");
		CoreFunctions.writeToPropertiesFile("ClonePolicy_Reference_PolicyStatus", "");
		CoreFunctions.writeToPropertiesFile("ClonePolicy_Reference_Client", "");
		CoreFunctions.writeToPropertiesFile("application", CoreConstants.APP_COREFLEX);

	}

	@Given("^he has clicked on 'Next' floating button after verifying Benefits_Points details Submitted by Client on 'OnPoint Planning Tool' page$")
	public void he_has_clicked_on_Next_floating_button_after_verifying_Benefits_Points_details_Submitted_by_Client_on_OnPoint_Planning_Tool_page()
			throws Throwable {
		Assert.assertTrue(
				mxTransfereeFlexPlanningToolPage.verifyElementPresentOnPage(MobilityXConstants.EDIT_SUBMITTED_BENEFITS),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_ELEMENT_PRESENT_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL, MobilityXConstants.EDIT_SUBMITTED_BENEFITS));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessageAfterClientSubmission(),
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
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySubmittedPointsDetails(),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
	}

	@When("^he clicks on 'Next' floating button after verifying Benefits_Points details Submitted by Client on 'OnPoint Planning Tool' page$")
	public void he_clicks_on_Next_floating_button_after_verifying_Benefits_Points_details_Submitted_by_Client_on_OnPoint_Planning_Tool_page()
			throws Throwable {
		Assert.assertTrue(
				mxTransfereeFlexPlanningToolPage.verifyElementPresentOnPage(MobilityXConstants.EDIT_SUBMITTED_BENEFITS),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_ELEMENT_PRESENT_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL, MobilityXConstants.EDIT_SUBMITTED_BENEFITS));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessageAfterClientSubmission(),
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
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySubmittedPointsDetails(),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has verified Benefits Submitted by Client details under 'Submitted Benefits' section of 'My Benefits Bundle' page$")
	public void he_has_verified_Benefits_Submitted_by_Client_details_under_Submitted_Benefits_section_of_My_Benefits_Bundle_page()
			throws Throwable {
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedBenefitDetails(),
				MobilityXConstants.SUBMITTED_BENEFIT_DETAILS_NOT_MATCHED);
	}

	@Then("^Benefits Submitted by Client should be displayed under 'Submitted Benefits' section of 'My Benefits Bundle' page$")
	public void Benefits_Submitted_by_Client_should_be_displayed_under_Submitted_Benefits_section_of_My_Benefits_Bundle_page()
			throws Throwable {

		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedBenefitDetails(),
				MobilityXConstants.SUBMITTED_BENEFIT_DETAILS_NOT_MATCHED);
	}

	@When("he provides 'Access to OnPoint' delegate access to the newly created DelegateUser on 'Delegate Information' page")
	public void he_provides_Access_to_OnPoint_delegate_access_to_the_new_User_on_Delegate_Information_page() {
		mxTransfereeJourneyHomePage.proceedToAccountSettingsPage();
		Assert.assertTrue(mxTransfereeJourneyHomePage.delegateAccess(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_PROVIDE_FLEX_BENEFITS_DELEGATE_ACCESS_TO_DELEGATED_USER,
						CoreConstants.FAIL));
	}

	@Then("^'MobilityX Delegate Access Granted' email having permissions granted should be sent to the delegate user$")
	public void MobilityX_Delegate_Access_Granted_email_having_permissions_granted_should_be_sent_to_the_delegate_user()
			throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyDelegateAccessGrantedEmail(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_MOBILITYX_DELEGATE_ACCESS_GRANTED_EMAIL, CoreConstants.FAIL));
	}

	@Given("^he has verified submitted points details after navigating to 'Mobility Journey Home'$")
	public void he_has_verified_submitted_points_details_after_navigating_to_Mobility_Journey_Home_page()
			throws Throwable {
		mxTransfereeMyBenefitsBundlePage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.ONPOINT_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyUserNavigationToJourneyHomePage(), MessageFormat.format(
				MobilityXConstants.FALIED_TO_VALIDATE_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE_AFTER_BENEFIT_SUBMISSION,
				CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifySubmittedPointsDetails(), MessageFormat.format(
				MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_JOURNEY_HOME_PAGE, CoreConstants.FAIL));
	}

	@Then("^\"([^\"]*)\" document should downloaded having submitted 'Benefits' and 'Points' details by 'Transferee'$")
	public void document_should_downloaded_having_submitted_Benefits_and_Points_details_by_Transferee(
			String documentName) throws Throwable {
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyFlexPdfDownloadedDocument(documentName),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_BENEFITS_AND_POINTS_DETAILS_ON_FLEX_PDF_DOWNLOADED_DOCUMENT,
						CoreConstants.FAIL));
	}

	@Given("^he has created new 'OnPoint Enabled' policies for \"([^\"]*)\" client in IRIS application$")
	public void he_has_created_new_OnPoint_Enabled_policies_in_IRIS_application(String clientId) throws Throwable {
		testContext.getBasePage().reLaunchIrisToAvoidFreezingIssue();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginInfo);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.CORPORATION_MODULE);
		testContext.getIrisPageManager().irisCorporationMain = new IRIS_Corporation_Main();
		testContext.getIrisPageManager().irisCorporationMain.queryCorporation(clientId);
		testContext.getIrisPageManager().irisCorporationMain.selectCorporationModules(IRISConstants.ACCOUNTING);
		testContext.getIrisPageManager().irisCorporationAccounting = new IRIS_Corporation_Accounting();
		testContext.getIrisPageManager().irisCorporationAccounting.verifyAccountingTab();
		testContext.getIrisPageManager().irisCorporationAccounting.addNewOnPointAutomationPolicies(clientId);
		testContext.getIrisPageManager().irisCorporationAccounting.clickOnSaveBtn();
		testContext.getBasePage().cleanIrisProcesses();
	}
	
	@Given("^'Transferee' user has selected 'Benefit_Cashout' on 'OnPoint Planning Tool' page after logging into 'MobilityX' application$")
	public void transferee_user_has_selected_Benefit_Cashout_on_OnPoint_Planning_Tool_page_after_logging_into_MobilityX_application()
			throws Throwable {
		testContext.getWebDriverManager().getDriver().navigate().to(_loginInfo.details.mobilityXURL);		
		actualizeTransfereeCreatedByClient();
		Assert.assertTrue(mobilityXLoginPage.readCredentialsFromMail(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_READ_USER_CREDENTIALS_FROM_GENERATED_EMAIL, CoreConstants.FAIL));
		mobilityXLoginPage.enterUsernameAndPasswordForMobilityX(
				CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail"),
				CoreFunctions.getPropertyFromConfig("Transferee_PasswordInEMail"));
		mobilityXLoginPage.clickSignIn();
		mxTransfereeMyProfilePage.setUpNewMobilityXTransferee();
		mxTransfereeJourneyHomePage.handle_Cookie_AfterLogin();
		mxTransfereeJourneyHomePage.handle_points_expiry_reminder_popup();
		mxTransfereeJourneyHomePage.switchToTooltipIFrameAndPerformAction(MobilityXConstants.HIDE, 5);
		Assert.assertTrue(mxTransfereeJourneyHomePage.isWelcomePopupDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_WELCOME_POPUP_ON_TRANSFEREE_JOURNEY_HOME_PAGE,
						CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.progressOrSkipMobilityJourneyHomePage(MobilityXConstants.ROUTE_TO_TRANSFEREE_JOURNEY_HOME_PAGE);
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyAssignmentAndPolicyDetails(), MessageFormat.format(
				MobilityXConstants.ASSIGNMENT_DETAILS_NOT_MATCHED_ON_MOBILITY_JOURNEY_HOME_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.setUpPaymentAccount(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_SETUP_PAYMENT_ACCOUNT, CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.ONPOINT_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.selectCashOutOnFPT(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_SELECT_CASHOUT_ON_ONPOINT_PLANNING_TOOL_PAGE, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.NEXT);
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isMyBundlePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_MY_BENEFIT_BUNDLE_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifySelectedCashoutDetails(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_SELECTED_CASHOUT_DETAILS_ON_MY_BUNDLE_PAGE, CoreConstants.FAIL));
	}
	
	
	@Given("^he has setup a new OnPoint Policy with following selection in Blueprint application$")
	public void he_has_setup_a_new_OnPoint_Policy_with_following_selection_in_Blueprint_application(
			DataTable dataTable) throws Throwable {

		BusinessFunctions.resetPropertiesValue();
		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
		String policyRequiredFor = dataMap.get(0).get("PolicyRequiredFor");
		String benefitType = dataMap.get(0).get("BenefitType");
		String flexSetupType = dataMap.get(0).get("Flex Setup Type");
		String personResponsibleForBenefitSelection = dataMap.get(0).get("Person Responsible For Benefit Selection");
		CoreFunctions.writeToPropertiesFile("CoreFlex_Policy_RequiredFor", policyRequiredFor);
		CoreFunctions.writeToPropertiesFile("CoreFlex_Policy_BenefitType", benefitType);
		CoreFunctions.writeToPropertiesFile("CoreFlex_Policy_FlexSetupType", flexSetupType);
		CoreFunctions.writeToPropertiesFile("CoreFlex_Policy_PersonResponsible", personResponsibleForBenefitSelection);

		Assert.assertTrue(bluePrintCFLoginPage.verifyLoginPageNavigation(), MessageFormat.format(
				PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_BLUE_PRINT_APPLICATION_LOGIN_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(bluePrintCFLoginPage.loginByUserType(PDTConstants.CSM, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));
		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(COREFLEXConstants.ADD_NEW_POLICY_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL,
						COREFLEXConstants.ADD_NEW_POLICY_PAGE, PDTConstants.ADD_NEW_POLICY_FORM,
						addNewPolicyPage.getElementText(PDTConstants.HEADING)));
		addNewPolicyPage.clickElementOfPage(PDTConstants.CLIENT_ID);
		addNewPolicyPage.selectClient(_loginInfo.details.clientId, _loginInfo.details.clientName);
		addNewPoliciesForClientInIRIS(_loginInfo.details.clientId, addNewPolicyPage.verifyAutomationPolicyPresent());
		addNewPolicyPage.clickElementOfPage(PDTConstants.CLIENT_ID);
		addNewPolicyPage.selectClient(_loginInfo.details.clientId, _loginInfo.details.clientName);
		Assert.assertTrue(addNewPolicyPage.selectAutomationPolicy(),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));
		addNewPolicyPage.clickElementOfPage(PDTConstants.NEXT);
		Assert.assertTrue(generalInfoPage.verifyPageNavigation(COREFLEXConstants.GENERAL_INFORMATION_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		generalInfoPage.fillOtherMandatoryFields();
		Assert.assertTrue(
				generalInfoPage.selectFieldOption(PDTConstants.POINTS_BASED_FLEX_POLICY, COREFLEXConstants.YES),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_FIELD_OPTIONS_ON_GENERAL_INFO_PAGE,
						CoreConstants.FAIL));
		generalInfoPage.clickElementOfPage(PDTConstants.NEXT);
		Assert.assertTrue(flexPolicySetupPage.verifyPageNavigation(COREFLEXConstants.POINT_POLICY_SETUP),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POINT_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));
		flexPolicySetupPage.selectFlexPolicySetupPageFields(dataTable);
		Assert.assertTrue(flexPolicySetupPage.verifyFlexSetupTypeSelection(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_FLEX_SETUP_TYPE_SELECTION_ON_FLEX_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));
		flexPolicySetupPage.clickElementOfPage(PDTConstants.NEXT);
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));
		coreFlexPolicyBenefitsCategoriesPage.selectBenefits(benefitType, policyRequiredFor);
		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(PDTConstants.NEXT);
		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyInformationDialog(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_INFORMATION_DIALOG_AFTER_SELECTING_BENEFITS_AND_CLICKING_NEXT_ON_POLICY_BENEFIT_CATEGORIES_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyBenefitsDisplayedOnLeftNavigation(benefitType,
						policyRequiredFor),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DISPLAYED_ON_LEFT_NAVIGATION,
						CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.selectAndFillAddedBenefits(benefitType, policyRequiredFor),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_SELECT_AND_FILL_ADDED_BENEFITS, CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexBenefitSummaryPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFITS_BENEFIT_SUMMARY),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(coreFlexBenefitSummaryPage.iterateAndVerifyBenefitSummaryDetails(policyRequiredFor),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_BENEFIT_SUBBENEFIT_DETAILS_ON_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
		coreFlexBenefitSummaryPage.clickElementOfPage(COREFLEXConstants.CONTINUE);
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPageNavigation(COREFLEXConstants.CUSTOM_BUNDLES),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexCustomBundlesPage.iterateAndAddNewCustomBundle(COREFLEXConstants.ADD_NEW_CUSTOM_BUNDLE,
						benefitType, COREFLEXConstants.SAVE_CUSTOM_BUNDLE, policyRequiredFor),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_ADD_A_NEW_BUNDLE_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
	}

}
