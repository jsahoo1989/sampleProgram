package stepDefinitions.coreFlex;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;
import com.aires.pages.iris.IRIS_Corporation_Accounting;
import com.aires.pages.iris.IRIS_Corporation_Main;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.pages.iris.IRIS_Welcome12C;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_LoginPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

public class CoreFlex_SharedSteps {
	
	private TestContext testContext;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_AddNewPolicyPage addNewPolicyPage;
	private PDT_LoginDetails _loginDetails;
	private PDT_LoginPage loginPage;
	private PDT_GeneralInformationPage generalInfoPage;
	private CoreFlex_FlexPolicySetupPage flexPolicySetupPage;
//	private CoreFlex_PolicyBenefitsCategoriesPage coreFlexPolicyBenefitsCategoriesPage;
//	private CoreFlex_CustomBundlesPage coreFlexCustomBundlesPage;

	public CoreFlex_SharedSteps(TestContext context) {
		testContext = context;
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInformationPage();
		flexPolicySetupPage = testContext.getCoreFlexPageObjectManager().getFlexPolicySetupPage();
//		coreFlexPolicyBenefitsCategoriesPage = testContext.getCoreFlexPageObjectManager().getCoreFlexPolicyBenefitsCategoriesPage();
//		coreFlexCustomBundlesPage = testContext.getCoreFlexPageObjectManager().getCoreFlexCustomBundlesPage();
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
	public void he_has_clicked_on_button_after_selecting_Policy_for_client_on_page(String nextButton, String policyType, String clientID, String pageName) throws Throwable {
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
	public void he_has_clicked_on_button_after_performing_following_fields_selection_on_navigated_page(String nextButton,
			String expectedPageName, DataTable dataTable) throws Throwable {		
		Assert.assertTrue(flexPolicySetupPage.verifyPageNavigation(expectedPageName),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_FLEX_POLICY_SETUP_PAGE,
						CoreConstants.FAIL));
		flexPolicySetupPage.selectFlexPolicySetupPageFields(dataTable);		
		flexPolicySetupPage.clickElementOfPage(nextButton);		
	}
	
//	@Given("^he has clicked on \"([^\"]*)\" button after selecting following 'Benefits' on \"([^\"]*)\" page$")
//	public void he_has_clicked_on_button_after_selecting_following_Benefits_on_page(String nextButton, String expectedPageName, DataTable dataTable) throws Throwable {
//		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyPageNavigation(expectedPageName),
//				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_POLICY_BENEFITS_CATEGORIES_PAGE,
//						CoreConstants.FAIL));
//		coreFlexPolicyBenefitsCategoriesPage.selectBenefits(dataTable);
//		coreFlexPolicyBenefitsCategoriesPage.clickElementOfPage(nextButton);
//		Assert.assertTrue(coreFlexPolicyBenefitsCategoriesPage.verifyBenefitsDisplayedOnLeftNavigation(dataTable),
//				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_BENEFITS_DISPLAYED_ON_LEFT_NAVIGATION,
//						CoreConstants.FAIL));
//	}
//	
//	@When("^he clicks on \"([^\"]*)\" button on \"([^\"]*)\" page$")
//	public void he_clicks_on_button_on_page(String saveAndCompleteButton, String expectedPageName) throws Throwable {
//		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPageNavigation(expectedPageName),
//				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_CUSTOM_BUNDLES_PAGE,
//						CoreConstants.FAIL));
//		coreFlexCustomBundlesPage.clickElementOfPage(saveAndCompleteButton);
//	}
//
//	@Then("^a success message pop-up should be displayed with message \"([^\"]*)\"$")
//	public void a_success_message_pop_up_should_be_displayed_with_message(String submitStatusMessage) throws Throwable {
//		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicySubmitStatus(submitStatusMessage,addNewPolicyPage.getSelectedPolicyName()),
//				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_SUBMIT_STATUS_ON_CUSTOM_BUNDLES_PAGE,
//						CoreConstants.FAIL));
//		coreFlexCustomBundlesPage.clickElementOfPage(COREFLEXConstants.OK);
//	}
}
