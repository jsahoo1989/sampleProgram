package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

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
import com.aires.pages.coreflex.CoreFlex_DuplicateHousing_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;
import com.aires.pages.coreflex.CoreFlex_LumpSum_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_OtherHousing_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.coreflex.CoreFlex_PreviewTransfereePage;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_LoginPage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.coreflex.MX_Transferee_MyProfilePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DashboardHomePage;
import com.aires.pages.coreflex.TransfereeSubmissions_LoginPage;
import com.aires.pages.iris.IRIS_ActivityAndFinancePage;
import com.aires.pages.iris.IRIS_AssignmentOverviewPage;
import com.aires.pages.iris.IRIS_AssignmentTransfereeNFamilyPage;
import com.aires.pages.iris.IRIS_Corporation_Accounting;
import com.aires.pages.iris.IRIS_Corporation_Main;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.pages.iris.IRIS_Welcome12C;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_LoginPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.aires.testdatatypes.iris.IRIS_AssignmentData;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CoreFlex_SharedSteps {

	private TestContext testContext;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_AddNewPolicyPage addNewPolicyPage;
	private PDT_LoginDetails _loginDetails;
	private PDT_LoginPage loginPage;
	private PDT_GeneralInformationPage generalInfoPage;
	private CoreFlex_FlexPolicySetupPage flexPolicySetupPage;
	private CoreFlex_PolicyBenefitsCategoriesPage coreFlexPolicyBenefitsCategoriesPage;
	private CoreFlex_CustomBundlesPage coreFlexCustomBundlesPage;
	private CoreFlex_DuplicateHousing_BenefitsPage coreFlexDuplicateHousingBenefitsPage;
	private CoreFlex_LumpSum_BenefitsPage coreFlexLumpSumBenefitsPage;
	private CoreFlex_BenefitSummaryPage coreFlexBenefitSummaryPage;
	private CoreFlex_OtherHousing_BenefitsPage coreFlexOtherHousingBenefitsPage;
	private MX_Transferee_LoginPage mxTransfereeLoginPage;
	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;
	private TransfereeSubmissions_LoginPage transfereeSubmissionsLoginPage;
	private TransfereeSubmissions_DashboardHomePage transfereeSubmissionsDashboardHomePage;
	private CoreFlex_PreviewTransfereePage coreFlexTransfereePreviewPage;
	private CoreFlex_BluePrint_LoginPage bluePrintCFLoginPage;

	private MX_Transferee_MyProfilePage mxTransfereeMyProfilePage;
	int _initialTableRowCount = 0;
	private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader()
			.getLoginByApplication(CoreFunctions.getPropertyFromConfig("application").toLowerCase());

	public CoreFlex_SharedSteps(TestContext context) {
		testContext = context;
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
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
		mxTransfereeMyProfilePage = testContext.getCoreFlexPageObjectManager().getTransfereeMyProfilePage();
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
	}

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
		_loginDetails = FileReaderManager.getInstance().getJsonReader().getLoginByApplication("IRIS");
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetails);
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
				COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_FLEX_POLICY_SETUP_PAGE, CoreConstants.FAIL));
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

	@Given("^he has setup a new \"([^\"]*)\" Type Policy with following selection in 'Policy Digitization Tool \\(PDT\\)' application$")
	public void he_has_setup_a_new_Type_Policy_with_following_selection_in_Policy_Digitization_Tool_PDT_application(
			String policyType, DataTable dataTable) throws Throwable {

		Assert.assertTrue(bluePrintCFLoginPage.verifyLoginPageNavigation(), MessageFormat.format(
				PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_BLUE_PRINT_APPLICATION_LOGIN_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to <i>Navigate to CoreFlex Policy BluePrint Application Login Page </i> is :"
						+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000
						+ " Seconds </b>");

		Assert.assertTrue(bluePrintCFLoginPage.loginByUserType(PDTConstants.CSM, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(COREFLEXConstants.ADD_NEW_POLICY_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL,
						COREFLEXConstants.ADD_NEW_POLICY_PAGE, PDTConstants.ADD_NEW_POLICY_FORM,
						addNewPolicyPage.getElementText(PDTConstants.HEADING)));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to <i>Navigate to CoreFlex - Add New Policy Page </i> is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");

		Assert.assertTrue(addNewPolicyPage.selectFirstAvailableClientID(),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_CLIENTID_FROM_CLIENTID_FIELD, CoreConstants.FAIL));
		Assert.assertTrue(addNewPolicyPage.selectAPolicy(addNewPolicyPage.getFirstAvailablePolicyOption()),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));

		// Invoking IRIS application to select CoreFleXEnabled Policy
//		testContext.getBasePage().invokeIrisApplication();
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

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(generalInfoPage.verifyPageNavigation(COREFLEXConstants.GENERAL_INFORMATION_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to <i>Navigate to CoreFlex - General Information Page </i> is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");

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

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(flexPolicySetupPage.verifyPageNavigation(COREFLEXConstants.FLEX_POLICY_SETUP),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_FLEX_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to <i>Navigate to CoreFlex - Flex Policy Setup Page </i> is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");

		flexPolicySetupPage.verifyNumericRangeFieldsValidation();
		flexPolicySetupPage.selectFlexPolicySetupPageFields(dataTable);
		flexPolicySetupPage.clickElementOfPage(PDTConstants.NEXT);

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to <i>Navigate to CoreFlex - Policy Benefit Categories Page </i> is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");

		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyPolicyCategoriesBenefitsAndOrder(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_CATEGORIES_BENEFITS_AND_ORDER_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));
		coreFlexPolicyBenefitsCategoriesPage.selectBenefits(policyType);
		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(PDTConstants.NEXT);

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyBenefitsDisplayedOnLeftNavigation(policyType),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DISPLAYED_ON_LEFT_NAVIGATION,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to <i>Navigate to Selected Benefits Page </i> is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");

		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.selectAndFillAddedBenefits(policyType,
				coreFlexDuplicateHousingBenefitsPage, coreFlexLumpSumBenefitsPage, coreFlexOtherHousingBenefitsPage),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_SELECT_AND_FILL_ADDED_BENEFITS, CoreConstants.FAIL));

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(
				coreFlexBenefitSummaryPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFITS_BENEFIT_SUMMARY),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to <i>Navigate to Benefit Summary Page </i> is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");

		Assert.assertTrue(coreFlexBenefitSummaryPage.iterateAndVerifyBenefitSummaryDetails(policyType),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_BENEFIT_SUBBENEFIT_DETAILS_ON_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
		coreFlexBenefitSummaryPage.clickElementOfPage(COREFLEXConstants.CONTINUE);

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPageNavigation(COREFLEXConstants.CUSTOM_BUNDLES),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to <i>Navigate to Custom Bundles Page </i> is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");

		Assert.assertTrue(
				coreFlexCustomBundlesPage.iterateAndAddNewCustomBundle(COREFLEXConstants.ADD_NEW_CUSTOM_BUNDLE,
						policyType, COREFLEXConstants.SAVE_CUSTOM_BUNDLE),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_ADD_A_NEW_BUNDLE_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.PREVIEW_TRANSFEREE_EXPERIENCE);

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(coreFlexTransfereePreviewPage.isPreviewTransfereePageDisplayed(), MessageFormat
				.format(COREFLEXConstants.FAILED_TO_VERIFY_NAVIGATION_TO_TRANSFEREE_PREVIEW_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to <i>Navigate to Transfere Preview Page </i> is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");

		Assert.assertTrue(coreFlexTransfereePreviewPage.verifyPreviewTransfereeExperience(policyType),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DETAILS_ON_PREVIEW_TRANSFEREE_PAGE,
						CoreConstants.FAIL));
		coreFlexTransfereePreviewPage.clickElementOfPage(COREFLEXConstants.CLOSE_TRANSFEREE_PREVIEW);
	}

	@When("^he clicks on \"([^\"]*)\" button on \"([^\"]*)\" page$")
	public void he_clicks_on_button_on_page(String submitButton, String expectedPageName) throws Throwable {
		coreFlexCustomBundlesPage.clickElementOfPage(submitButton);
		Reporter.addStepLog(MessageFormat.format(
				COREFLEXConstants.SUCCESSFULLY_CLICKED_ON_SUBMIT_BUTTON_ON_CUSTOM_BUNDLES_PAGE, CoreConstants.PASS));
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
	}

	@Then("^a success dialog should be displayed for Successfully Submitted Policy$")
	public void a_success_dialog_should_be_displayed_for_Successfully_Submitted_Policy() throws Throwable {

		Assert.assertTrue(
				coreFlexCustomBundlesPage.verifyPolicySubmitStatus(COREFLEXConstants.POLICY_SUBMIT_STATUS_MESSAGE,
						CoreFunctions.getPropertyFromConfig("Assignment_Policy")),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_SUBMIT_STATUS_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to <i> verify Policy Submit Status </i> is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.OK);
	}

	@Then("^Policy Status should be displayed as \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void Policy_Status_should_be_displayed_as_on_page(String status, String pageName) throws Throwable {		
		Assert.assertTrue(viewPolicyPage.verifyPageNavigation(COREFLEXConstants.VIEW_EDIT_POLICY_FORMS),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_VIEW_EDIT_POLICY_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to <i> navigate to View/Edit Policy Forms page</i> is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");		
		Assert.assertTrue(viewPolicyPage.verifySubmittedPolicyStatus(addNewPolicyPage.getSelectedPolicyName(), status),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_SUBMITTED_POLICY_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has logged into 'MobilityX' application after creating a new 'Transferee' through IRIS application for policy setup in 'Policy Digitization Tool'$")
	public void he_has_logged_into_MobilityX_application_after_creating_a_new_Transferee_through_IRIS_application_for_policy_setup_in_Policy_Digitization_Tool()
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
//		testContext.getBasePage().invokeIrisApplication();
//		testContext.getBasePage().killExistingBrowsers();
//		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
//		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
//		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
//		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
//		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
//		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentOverviewPage.verifyOverviewTab(), MessageFormat
//				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.OVERVIEW));
//		IRIS_AssignmentData assignmentOverviewData = FileReaderManager.getInstance().getIrisJsonReader()
//				.getAssignmentDataByTabName(IRISConstants.OVERVIEW);
//		testContext.getIrisPageManager().irisAssignmentOverviewPage.selectNewAssignmentFromFileMenu();
//		testContext.getIrisPageManager().irisAssignmentOverviewPage.addDetailsOnOverviewTabForNewAssignment(
//				assignmentOverviewData, CoreFunctions.getPropertyFromConfig("Policy_ClientID"),
//				CoreFunctions.getPropertyFromConfig("Assignment_Policy"));
//
//		IRIS_AssignmentData assignmentTransfereeData = FileReaderManager.getInstance().getIrisJsonReader()
//				.getAssignmentDataByTabName(IRISConstants.TRANSFEREE_AND_FAMILY);
//		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.TRANSFEREE_AND_FAMILY);
//		testContext
//				.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage = new IRIS_AssignmentTransfereeNFamilyPage();
//		testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
//				.verifyTransfereeAndFamilyTab(IRISConstants.TRANSFEREE_AND_FAMILY);
//		testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
//				.addNewTransfereeDetails(assignmentTransfereeData);
//		Assert.assertTrue(
//				testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
//						.saveTransferee(IRISConstants.NEW_TRANSFEREE_CREATED_SUCCESS_MSG),
//				IRISConstants.NEW_TRANSFEREE_CREATED_SUCCESS_MSG + " Message " + IRISConstants.IS_NOT_DISPLAYED);
//
//		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.ACTIVITY_FINANCE_TAB);
//		testContext.getIrisPageManager().irisActivityAndFinancePage = new IRIS_ActivityAndFinancePage();
//		Assert.assertTrue(testContext.getIrisPageManager().irisActivityAndFinancePage.verifyActivityAndFinanceTab(),
//				MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
//						IRISConstants.ACTIVITY_AND_FINANCE));
//		testContext.getIrisPageManager().irisActivityAndFinancePage.displayActivityTable();
//		testContext.getIrisPageManager().irisActivityAndFinancePage.actualizeTracingPrompt(IRISConstants.ACT_DATE,
//				IRISConstants.ACTIVITY, IRISConstants.MAKE_FIRST_CONTACT);
//
//		testContext.getIrisPageManager().irisActivityAndFinancePage.clickOnSaveBtn();
//		testContext.getIrisPageManager().irisActivityAndFinancePage.sendLoginCredentials(IRISConstants.YES,
//				IRISConstants.SEND_CREDENTIALS, IRISConstants.SEND_USER_LOGIN_MSG);
//
//		Assert.assertTrue(
//				testContext.getIrisPageManager().irisActivityAndFinancePage
//						.relonetCredentialsSent(IRISConstants.SUCCESS_MSG, IRISConstants.MESSAGE_DIALOG),
//				MessageFormat.format(IRISConstants.FAILED_TO_VERIFY_MESSAGE, CoreConstants.FAIL,
//						IRISConstants.SUCCESS_MSG));
//		testContext.getBasePage().cleanIrisProcesses();

//		Assert.assertTrue(mxTransfereeLoginPage.readCredentialsFromMail(), MessageFormat
//				.format(MobilityXConstants.FAILED_TO_READ_USER_CREDENTIALS_FROM_GENERATED_EMAIL, CoreConstants.FAIL));
		mxTransfereeLoginPage.enterUsernameAndPasswordForMobilityX(
				CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail"),
				CoreFunctions.getPropertyFromConfig("Transferee_PasswordInEMail"));
		mxTransfereeLoginPage.clickSignIn();
//		mxTransfereeMyProfilePage.setUpNewMobilityXTransferee();
		mxTransfereeJourneyHomePage.handle_Cookie_AfterLogin();
		mxTransfereeJourneyHomePage.handle_points_expiry_reminder_popup();
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has validated 'Assignment-Policy' details after selecting below option displayed on 'Welcome' dialog$")
	public void he_has_validated_Assignment_Policy_details_after_selecting_below_option_displayed_on_Welcome_dialog(
			DataTable dataTable) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
//		List<Map<String, String>> action = dataTable.asMaps(String.class, String.class);
//		Assert.assertTrue(mxTransfereeJourneyHomePage.isWelcomePopupDisplayed(),
//				MessageFormat.format(MobilityXConstants.FAILED_TO_DISPLAY_WELCOME_POPUP_ON_TRANSFEREE_JOURNEY_HOME_PAGE,
//						CoreConstants.FAIL));
//		mxTransfereeJourneyHomePage.progressOrSkipMobilityJourneyHomePage(action.get(0).get("WelcomeDialogSelection"));
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyAssignmentAndPolicyDetails(), MessageFormat.format(
				MobilityXConstants.ASSIGNMENT_DETAILS_NOT_MATCHED_ON_MOBILITY_JOURNEY_HOME_PAGE, CoreConstants.FAIL));
//		Assert.assertTrue(mxTransfereeJourneyHomePage.setUpPaymentAccount(),
//				MessageFormat.format(MobilityXConstants.FAILED_TO_SETUP_PAYMENT_ACCOUNT, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeJourneyHomePage.navigateToFlexPlanningToolPage(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_NAVIGATE_TO_FLEX_PLANNING_TOOL_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has navigated to \"([^\"]*)\" page with below Policy-Benefit type after clicking on 'Manage my Points' button on \"([^\"]*)\" page$")
	public void he_has_navigated_to_page_with_below_Policy_Benefit_type_after_clicking_on_Manage_my_Points_button_on_page(
			String navigatedPage, String sourcePage, DataTable dataTable) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		List<Map<String, String>> policTypeMap = dataTable.asMaps(String.class, String.class);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessage(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				mxTransfereeFlexPlanningToolPage.verifyBenefitDetailsOnFPT(policTypeMap.get(0).get("PolicyType")),
				MessageFormat.format(
						MobilityXConstants.BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE_OF_MXTRANSFEREE_NOT_MATCHED_WITH_BENEFITS_DETAILS_SET_IN_PDT,
						CoreConstants.FAIL));
//		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySuggestedBundlesDetails(), MessageFormat.format(
//				MobilityXConstants.CUSTOM_BUNDLE_DETAILS_NOT_MATCHED_ON_SUGGESTED_BUNDLES_PAGE, CoreConstants.FAIL));
//		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has clicked on \"([^\"]*)\" button after validating all the benefit details listed under 'Selected Benefits' section on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_validating_all_the_benefit_details_listed_under_Selected_Benefits_section_on_page(
			String reviewAndSubmitButton, String pageName) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifySelectedBenefitDetails(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.clickReviewAndSubmit();
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has clicked on \"([^\"]*)\" button after entering Transferee name on \"([^\"]*)\" dialog$")
	public void he_has_clicked_on_button_after_entering_Transferee_name_on_dialog(String buttonName,
			String submissionDialog) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
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
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has clicked on \"([^\"]*)\" button displayed on 'Success Flex' dialog$")
	public void he_has_clicked_on_button_displayed_on_Success_Flex_dialog(String button) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		mxTransfereeMyBenefitsBundlePage.viewSubmittedBenefits();
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifyBenefitSubmissionEmail(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_READ_USER_CREDENTIALS_FROM_GENERATED_EMAIL, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he has clicks on \"([^\"]*)\" button displayed on 'Success Flex' dialog$")
	public void he_has_clicks_on_button_displayed_on_Success_Flex_dialog(String button) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		mxTransfereeMyBenefitsBundlePage.viewSubmittedBenefits();
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has verified submitted points details on 'Mobility Journey Home' and 'Flex Planning Tool' page$")
	public void he_has_verified_submitted_points_details_on_Mobility_Journey_Home_and_Flex_Planning_Tool_page()
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifySubmittedPointsDetails(), MessageFormat.format(
				MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_JOURNEY_HOME_PAGE, CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.navigateToFlexPlanningToolPage();
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessageAfterSubmission(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySubmittedPointsDetails(),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^submitted points details should be updated on 'Mobility Journey Home' and 'Flex Planning Tool' page$")
	public void submitted_points_details_should_be_updated_on_Mobility_Journey_Home_and_Flex_Planning_Tool_page()
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeJourneyHomePage.verifySubmittedPointsDetails(), MessageFormat.format(
				MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_JOURNEY_HOME_PAGE, CoreConstants.FAIL));
		mxTransfereeJourneyHomePage.navigateToFlexPlanningToolPage();
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessageAfterSubmission(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySubmittedPointsDetails(),
				MessageFormat.format(MobilityXConstants.SUBMITTED_POINTS_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has logged into 'Transferee Submissions' application as a \"([^\"]*)\" user$")
	public void he_has_logged_into_Transferee_Submissions_application_as_a_user(String userType) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(
				transfereeSubmissionsLoginPage.loginByUserType(userType, transfereeSubmissionsDashboardHomePage),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_TRANSFEREE_SUBMISSIONS_DASHBOARD_HOME_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has navigated to \"([^\"]*)\" page having record of Bundle submitted by the transferee$")
	public void he_has_navigated_to_page_having_record_of_Bundle_submitted_by_the_transferee(String pageName)
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(transfereeSubmissionsDashboardHomePage.verifyTransfereeBundleSubmissionDetails(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" button for Bundle submitted by the transferee on \"([^\"]*)\" page$")
	public void he_clicks_on_button_for_Bundle_submitted_by_the_transferee_on_page(String btnName, String pageName)
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		transfereeSubmissionsDashboardHomePage.clickElementOfPage(btnName);
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has verified submitted benefit details under 'Submitted Benefits' section of 'My Benefits Bundle' page$")
	public void he_has_verified_submitted_benefit_details_under_Submitted_Benefits_section_of_my_benefits_bundle_page() {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.validateSubmittedBenefitDetails(),
				MobilityXConstants.SUBMITTED_BENEFIT_DETAILS_NOT_MATCHED);
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

}
