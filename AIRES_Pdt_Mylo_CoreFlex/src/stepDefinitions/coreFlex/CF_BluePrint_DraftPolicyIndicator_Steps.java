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
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.coreflex.CoreFlex_BenefitSummaryPage;
import com.aires.pages.coreflex.CoreFlex_BluePrint_LoginPage;
import com.aires.pages.coreflex.CoreFlex_CustomBundlesPage;
import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.iris.IRIS_Corporation_Accounting;
import com.aires.pages.iris.IRIS_Corporation_Main;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.pages.iris.IRIS_Welcome12C;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.aires.testdatatypes.coreflex.CoreFlex_LoginInfo;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_BluePrint_DraftPolicyIndicator_Steps {

	private TestContext testContext;
	private CoreFlex_BluePrint_LoginPage bluePrintCFLoginPage;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_GeneralInformationPage generalInfoPage;
	private CoreFlex_FlexPolicySetupPage flexPolicySetupPage;
	private CoreFlex_PolicyBenefitsCategoriesPage coreFlexPolicyBenefitsCategoriesPage;
	private CoreFlex_BenefitSummaryPage coreFlexBenefitSummaryPage;
	private PDT_AddNewPolicyPage addNewPolicyPage;
	private CoreFlex_LoginInfo _loginInfo;
	private CoreFlex_CustomBundlesPage coreFlexCustomBundlesPage;

	public CF_BluePrint_DraftPolicyIndicator_Steps(TestContext context) {
		testContext = context;
		CoreFlex_PolicyBenefitsCategoriesPage.pageObjectManager_CoreFlex = testContext.getCoreFlexPageObjectManager();
		testContext.getCoreFlexPageObjectManager().initializeCoreFlexPageObjects();
		bluePrintCFLoginPage = testContext.getPageObjectManager().getBluePrintCoreFlexLoginPage();
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();
		flexPolicySetupPage = testContext.getCoreFlexPageObjectManager().getFlexPolicySetupPage();
		coreFlexPolicyBenefitsCategoriesPage = testContext.getCoreFlexPageObjectManager()
				.getCoreFlexPolicyBenefitsCategoriesPage();
		coreFlexBenefitSummaryPage = testContext.getCoreFlexPageObjectManager().getCoreFlexBenefitSummaryPage();
		coreFlexCustomBundlesPage = testContext.getCoreFlexPageObjectManager().getCoreFlexCustomBundlesPage();

		_loginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getLoginByEnvt(BusinessFunctions.getEnvBasedOnExecutionType().toLowerCase());
	}

	private static int searchedPolicyIndex;

	@Given("^he has logged in to 'OnPoint-Blueprint' application as a 'CSM' user$")
	public void he_has_logged_in_to_OnPoint_Blueprint_application_as_a_CSM_user() throws Throwable {
		BusinessFunctions.resetPropertiesValue();
		Assert.assertTrue(bluePrintCFLoginPage.verifyLoginPageNavigation(), MessageFormat.format(
				PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_BLUE_PRINT_APPLICATION_LOGIN_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(bluePrintCFLoginPage.loginByUserType(PDTConstants.CSM, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));
	}

	@Given("^he has clicked on \"([^\"]*)\" button after selecting Client and a new Points Based CoreFlex Policy on 'Add New Policy Forms' page$")
	public void he_has_clicked_on_button_after_selecting_Client_and_a_new_Points_Based_CoreFlex_Policy_on_Add_New_Policy_Forms_page(
			String arg1) throws Throwable {

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

	}

	@Given("^he has verified 'Red Indicator' is displayed beside Draft Policy status to indicate 'Incomplete Policy' on the navigated 'General Information' page$")
	public void he_has_verified_Red_Indicator_is_displayed_beside_Draft_Policy_status_to_indicate_Incomplete_Policy_on_the_navigated_General_Information_page()
			throws Throwable {
		addNewPolicyPage.clickElementOfPage(PDTConstants.NEXT);
		Assert.assertTrue(generalInfoPage.verifyPageNavigation(COREFLEXConstants.GENERAL_INFORMATION_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(generalInfoPage.verifyOnPointPolicyStatusIndicator(COREFLEXConstants.RED_INDICATOR,
				COREFLEXConstants.POLICY_INCOMPLETE, COREFLEXConstants.CREATE_NEW_POLICY_BENEFIT_GENERAL_INFORMATION),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_ONPOINT_POLICY_DRAFT_STATUS_INDICATOR,
						CoreConstants.FAIL, COREFLEXConstants.CREATE_NEW_POLICY_BENEFIT_GENERAL_INFORMATION));
	}

	@Given("^he has verified 'Red Indicator' is displayed beside Draft Policy status to indicate 'Incomplete Policy' on the navigated 'Point Policy Setup' page$")
	public void he_has_verified_Red_Indicator_is_displayed_beside_Draft_Policy_status_to_indicate_Incomplete_Policy_on_the_navigated_Point_Policy_Setup_page()
			throws Throwable {
		Assert.assertTrue(
				flexPolicySetupPage.verifyOnPointPolicyStatusIndicator(COREFLEXConstants.RED_INDICATOR,
						COREFLEXConstants.POLICY_INCOMPLETE, COREFLEXConstants.CREATE_NEW_POLICY_POINT_POLICY_SETUP),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_ONPOINT_POLICY_DRAFT_STATUS_INDICATOR,
						CoreConstants.FAIL, COREFLEXConstants.CREATE_NEW_POLICY_POINT_POLICY_SETUP));
	}

	@Given("^he has verified 'Red Indicator' is displayed beside Draft Policy status to indicate 'Incomplete Policy' on the navigated 'Policy Benefits Categories' page$")
	public void he_has_verified_Red_Indicator_is_displayed_beside_Draft_Policy_status_to_indicate_Incomplete_Policy_on_the_navigated_Policy_Benefits_Categories_page()
			throws Throwable {

		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));

		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyOnPointPolicyStatusIndicator(COREFLEXConstants.RED_INDICATOR,
						COREFLEXConstants.POLICY_INCOMPLETE, COREFLEXConstants.POLICY_BENEFIT_CATEGORIES),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_ONPOINT_POLICY_DRAFT_STATUS_INDICATOR,
						CoreConstants.FAIL, COREFLEXConstants.POLICY_BENEFIT_CATEGORIES));
	}

	@Then("^'Green Indicator' should be displayed beside Draft Policy status to indicate 'Complete Policy' on the navigated 'Custom Bundles' page$")
	public void Green_Indicator_should_be_displayed_beside_Draft_Policy_status_to_indicate_Complete_Policy_on_the_navigated_Custom_Bundles_page()
			throws Throwable {
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPageNavigation(COREFLEXConstants.CUSTOM_BUNDLES),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexCustomBundlesPage.verifyOnPointPolicyStatusIndicator(COREFLEXConstants.GREEN_INDICATOR,
						COREFLEXConstants.POLICY_COMPLETE, COREFLEXConstants.CUSTOM_BUNDLES),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_ONPOINT_POLICY_DRAFT_STATUS_INDICATOR,
						CoreConstants.FAIL, COREFLEXConstants.CUSTOM_BUNDLES));
		coreFlexCustomBundlesPage.clickElementOfPage(PDTConstants.EXIT);
		Assert.assertTrue(viewPolicyPage.verifyPageNavigation(COREFLEXConstants.VIEW_EDIT_POLICY_FORMS),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_VIEW_EDIT_POLICY_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has verified Policy Status displayed as \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void he_has_verified_Policy_Status_displayed_as_on_page(String expectedPolicyStatus, String pageName)
			throws Throwable {
		Assert.assertTrue(flexPolicySetupPage.verifyPolicyStatus(expectedPolicyStatus, pageName), MessageFormat.format(
				PDTConstants.FAILED_TO_VERIFY_POLICY_STATUS, CoreConstants.FAIL, expectedPolicyStatus, pageName));
	}

	@Given("^he has clicked on \"([^\"]*)\" button after filling all the mandatory fields on 'General Information' page$")
	public void he_has_clicked_on_button_after_filling_all_the_mandatory_fields_on_General_Information_page(String arg1)
			throws Throwable {
		generalInfoPage.fillOtherMandatoryFields();
		Assert.assertTrue(
				generalInfoPage.selectFieldOption(PDTConstants.POINTS_BASED_FLEX_POLICY, COREFLEXConstants.YES),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_FIELD_OPTIONS_ON_GENERAL_INFO_PAGE,
						CoreConstants.FAIL));
		generalInfoPage.clickElementOfPage(PDTConstants.NEXT);
		Assert.assertTrue(flexPolicySetupPage.verifyPageNavigation(COREFLEXConstants.POINT_POLICY_SETUP),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POINT_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has clicked on \"([^\"]*)\" button after filling following details on the navigated 'Point Policy Setup' page$")
	public void he_has_clicked_on_button_after_filling_following_details_on_the_navigated_Point_Policy_Setup_page(
			String nextButton, DataTable dataTable) throws Throwable {
		flexPolicySetupPage.selectFlexPolicySetupPageFields(dataTable);
		Assert.assertTrue(flexPolicySetupPage.verifyFlexSetupTypeSelection(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_FLEX_SETUP_TYPE_SELECTION_ON_FLEX_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));

		flexPolicySetupPage.clickElementOfPage(PDTConstants.NEXT);

	}

	@Given("^he has clicked on \"([^\"]*)\" button after selecting some benefits on 'Policy Benefits Categories' page$")
	public void he_has_clicked_on_button_after_selecting_some_benefits_on_Policy_Benefits_Categories_page(String arg1)
			throws Throwable {
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL));

		coreFlexPolicyBenefitsCategoriesPage.selectBenefits(COREFLEXConstants.FLEX, COREFLEXConstants.CLIENT);
		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(PDTConstants.NEXT);

		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyInformationDialog(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_INFORMATION_DIALOG_AFTER_SELECTING_BENEFITS_AND_CLICKING_NEXT_ON_POLICY_BENEFIT_CATEGORIES_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyBenefitsDisplayedOnLeftNavigation(COREFLEXConstants.FLEX,
						COREFLEXConstants.CLIENT),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DISPLAYED_ON_LEFT_NAVIGATION,
						CoreConstants.FAIL));
	}

	@When("^he navigate to 'Vew/Edit Policy Forms' page without filling required details on selected benefits$")
	public void he_navigate_to_Vew_Edit_Policy_Forms_page_without_filling_required_details_on_selected_benefits()
			throws Throwable {
		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(PDTConstants.EXIT);
		Assert.assertTrue(viewPolicyPage.verifyPageNavigation(COREFLEXConstants.VIEW_EDIT_POLICY_FORMS),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_VIEW_EDIT_POLICY_PAGE,
						CoreConstants.FAIL));

	}

	@Then("^\"([^\"]*)\" should be displayed beside Draft Policy status to indicate \"([^\"]*)\" on following pages$")
	public void red_Indicator_should_be_displayed_beside_Draft_Policy_status_to_indicate_Incomplete_Policy_on_following_pages(
			String expectedIndicator, String expectedIndicatorHoverText, DataTable dataTable) throws Throwable {
		Assert.assertTrue(
				viewPolicyPage.verifyOnPointPolicyStatusIndicator(expectedIndicator, expectedIndicatorHoverText,
						CoreFunctions.getPropertyFromConfig("Assignment_Policy"), COREFLEXConstants.DRAFT,
						COREFLEXConstants.VERSION1),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_ONPOINT_POLICY_DRAFT_STATUS_INDICATOR,
						CoreConstants.FAIL, COREFLEXConstants.VIEW_EDIT_POLICY_FORMS));
		viewPolicyPage.clickElementOfPage(COREFLEXConstants.ASSIGNMENT_POLICY);
		Assert.assertTrue(viewPolicyPage.verifyViewPolicyPageNavigation(COREFLEXConstants.VIEW_POLICY_BENEFIT),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_ASSIGNMENT_HISTORY_VIEW_POLICY_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.verifyOnPointPolicyStatusIndicator(expectedIndicator, expectedIndicatorHoverText,
						COREFLEXConstants.VIEW_POLICY_BENEFIT_GENERAL_INFORMATION),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_ONPOINT_POLICY_DRAFT_STATUS_INDICATOR,
						CoreConstants.FAIL, COREFLEXConstants.VIEW_POLICY_BENEFIT_GENERAL_INFORMATION));
		viewPolicyPage.clickElementOfPage(COREFLEXConstants.EXIT);
		viewPolicyPage.searchByPolicyNameAndClickIcon(PDTConstants.ICON_EDIT,
				CoreFunctions.getPropertyFromConfig("Assignment_Policy"),
				COREFLEXConstants.EDIT_POLICY_BENEFIT_GENERAL_INFORMATION);
		Assert.assertTrue(viewPolicyPage.verifyEditPolicyBenefitPageNavigation(),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_EDIT_POLICY_BENEFIT_PAGE, CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.verifyOnPointPolicyStatusIndicator(expectedIndicator, expectedIndicatorHoverText,
						COREFLEXConstants.EDIT_POLICY_BENEFIT_GENERAL_INFORMATION),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_ONPOINT_POLICY_DRAFT_STATUS_INDICATOR,
						CoreConstants.FAIL, COREFLEXConstants.EDIT_POLICY_BENEFIT_GENERAL_INFORMATION));
	}

	@Given("^he has clicked on 'Save & Continue' after filling all the required details of the selected benefits$")
	public void he_has_clicked_on_Save_Continue_after_filling_all_the_required_details_of_the_selected_benefits()
			throws Throwable {
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyBenefitsDisplayedOnLeftNavigation(COREFLEXConstants.FLEX,
						COREFLEXConstants.CLIENT),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DISPLAYED_ON_LEFT_NAVIGATION,
						CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.verifyBenefitsDisplayedOnLeftNavigation(COREFLEXConstants.FLEX,
						COREFLEXConstants.CLIENT),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DISPLAYED_ON_LEFT_NAVIGATION,
						CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexPolicyBenefitsCategoriesPage.selectAndFillAddedBenefits(COREFLEXConstants.FLEX,
						COREFLEXConstants.CLIENT),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_SELECT_AND_FILL_ADDED_BENEFITS, CoreConstants.FAIL));
		Assert.assertTrue(
				coreFlexBenefitSummaryPage.verifyPageNavigation(COREFLEXConstants.POLICY_BENEFITS_BENEFIT_SUMMARY),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));

	}

	@When("^he click on 'Continue' button on 'Benefit Summary' page$")
	public void he_click_on_Continue_button_on_Benefit_Summary_page() throws Throwable {
		Assert.assertTrue(coreFlexBenefitSummaryPage.iterateAndVerifyBenefitSummaryDetails(COREFLEXConstants.CLIENT),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_BENEFIT_SUBBENEFIT_DETAILS_ON_BENEFIT_SUMMARY_PAGE,
						CoreConstants.FAIL));
		coreFlexBenefitSummaryPage.clickElementOfPage(COREFLEXConstants.CONTINUE);
	}

	@Given("^he has clicked on 'Clone Policy' icon after searching for 'Points Based CoreFlex Policy' with \"([^\"]*)\" Policy Status$")
	public void he_has_clicked_on_Clone_Policy_icon_after_searching_for_Points_Based_CoreFlex_Policy_with_Policy_Status(
			String policyStatus) throws Throwable {
		viewPolicyPage.searchPolicy(COREFLEXConstants.AUTOMATION_POLICY);
		searchedPolicyIndex = viewPolicyPage.searchPolicyByStatus(policyStatus.split("-")[0].trim(),
				policyStatus.split("-")[1].trim());
		viewPolicyPage.captureCorporationPolicyValue(searchedPolicyIndex, policyStatus, generalInfoPage);
		viewPolicyPage.searchPolicy(CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_PolicyName"));
		viewPolicyPage.clickCloneIconOfReferencePolicy(policyStatus);
	}

	@Then("^he should be navigated to \"([^\"]*)\" page of new 'Cloned - Points based CoreFlex Policy' having following values$")
	public void he_should_be_navigated_to_page_of_new_Cloned_Points_based_CoreFlex_Policy_having_following_values(
			String navigatedPageName, DataTable dataTable) throws Throwable {

		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
		String expectedClonedPolicyStatus = dataMap.get(0).get("Policy Status");
		String expectedClonedPolicyVersion = dataMap.get(0).get("Policy Version");
		String expectedClonedPolicyStatusIndicator = dataMap.get(0).get("Policy Status Indicator");
		String expectedClonedPolicyStatusIndicatorHoverText = dataMap.get(0).get("Policy Status Indicator Hover Text");

		Assert.assertTrue(generalInfoPage.verifyPageNavigation(COREFLEXConstants.GENERAL_INFORMATION_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
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
				generalInfoPage.verifyOnPointPolicyStatusIndicator(expectedClonedPolicyStatusIndicator,
						expectedClonedPolicyStatusIndicatorHoverText,
						COREFLEXConstants.CREATE_NEW_POLICY_BENEFIT_GENERAL_INFORMATION),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_ONPOINT_POLICY_DRAFT_STATUS_INDICATOR,
						CoreConstants.FAIL, COREFLEXConstants.CREATE_NEW_POLICY_BENEFIT_GENERAL_INFORMATION));

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
		CoreFunctions.writeToPropertiesFile("Assignment_Policy",
				CoreFunctions.getPropertyFromConfig("ClonedPolicy_Policy_Name"));
		generalInfoPage.clickElementOfPage(COREFLEXConstants.EXIT);
	}

	/**
	 * Method to add New Policies in IRIS application -> Accounting tab for
	 * specified Client if available Automation Policy Count is <5
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
				testContext.getIrisPageManager().irisCorporationAccounting.addNewOnPointAutomationPolicies();
				testContext.getIrisPageManager().irisCorporationAccounting.clickOnSaveBtn();
				testContext.getBasePage().cleanIrisProcesses();
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_ADDED_15_ADDITIONAL_AUTOMATION_POLICIES_IN_ACCOUNTING_TAB_FOR_CLIENT,
						CoreConstants.PASS, clientId));
				viewPolicyPage.clickElementOfPage(PDTConstants.VIEW_EDIT_POLICY_FORMS);
				viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
			} else {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.MORE_THAN_5_AUTOMATION_POLICIES_ALREADY_PRESENT_IN_ACCOUNTING_TAB_FOR_CLIENT,
						CoreConstants.PASS, clientId));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_ADDING_NEW_POLICIES_IN_ACCOUNTING_TAB_FOR_CLIENT,
					CoreConstants.FAIL, e.getMessage(), clientId));
		}

	}

}
