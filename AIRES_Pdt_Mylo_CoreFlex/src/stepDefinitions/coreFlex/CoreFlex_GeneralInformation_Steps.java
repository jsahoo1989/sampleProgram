package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
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
import com.aires.pages.pdt.PDT_PolicyBenefitCategoryPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CoreFlex_GeneralInformation_Steps {

	private TestContext testContext;
	private PDT_LoginPage loginPage;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_AddNewPolicyPage addNewPolicyPage;
	private PDT_GeneralInformationPage generalInfoPage;
	private CoreFlex_FlexPolicySetupPage flexPolicySetupPage;
	private PDT_PolicyBenefitCategoryPage pdtPolicyBenefitCategoryPage;
	private PDT_LoginDetails _loginDetails = null;

	public CoreFlex_GeneralInformation_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();
		flexPolicySetupPage = testContext.getCoreFlexPageObjectManager().getFlexPolicySetupPage();
		pdtPolicyBenefitCategoryPage = testContext.getPageObjectManager().getpolicyBenefitCategoryPage();
	}

	@Then("^user should be navigated to the \"([^\"]*)\" page of the selected Client Policy$")
	public void user_should_be_navigated_to_the_page_of_the_selected_Client_Policy(String pageName, DataTable dataTable)
			throws Throwable {
		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
		Assert.assertTrue(
				generalInfoPage.validateClientAndPolicyDetailsOnGeneralInfo(pageName, dataMap.get(0).get("ClientID"),
						addNewPolicyPage.getSelectedPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_CLIENT_POLICY_DATA_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has selected a policy for Client \"([^\"]*)\"$")
	public void he_has_selected_a_policy_for_Client(String clientID) throws Throwable {
		addNewPolicyPage.enterClientID(clientID);
		Assert.assertTrue(addNewPolicyPage.verifyAndClickValidClientIDResult(clientID), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_VALID_CLIENT_ID_DROPDOWN_OPTIONS, CoreConstants.FAIL));
		Assert.assertTrue(addNewPolicyPage.selectAPolicy(addNewPolicyPage.getFirstAvailablePolicyOption()),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));
	}

	@Given("^he has searched the corporation \"([^\"]*)\" on the \"([^\"]*)\" tab after login to the IRIS application$")
	public void he_has_searched_the_corporation_on_the_tab_after_login_to_the_IRIS_application(String clientID,
			String tabName) throws Throwable {
		testContext.getBasePage().invokeIrisApplication();
		//_loginDetails = FileReaderManager.getInstance().getJsonReader().getLoginByApplication("IRIS");
		_loginDetails = FileReaderManager.getInstance().getJsonReader().getLoginByApplication(System.getProperty("application").toLowerCase());
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetails);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(tabName);
		testContext.getIrisPageManager().irisCorporationMain = new IRIS_Corporation_Main();
		testContext.getIrisPageManager().irisCorporationMain.queryCorporation(clientID);
	}

	@Given("^he has saved the information on the \"([^\"]*)\" tab after selecting the \"([^\"]*)\" checkbox as \"([^\"]*)\" for the selected policy in Aires Policy tool$")
	public void he_has_saved_the_information_on_the_tab_after_selecting_the_checkbox_as_for_the_selected_policy_in_Aires_Policy_tool(
			String tabName, String columnName, String checkboxSelection) throws Throwable {

		testContext.getIrisPageManager().irisCorporationMain.selectCorporationModules(tabName);
		testContext.getIrisPageManager().irisCorporationAccounting = new IRIS_Corporation_Accounting();
		testContext.getIrisPageManager().irisCorporationAccounting.verifyAccountingTab();
		testContext.getIrisPageManager().irisCorporationAccounting.performCoreFlexCheckboxSelectionForPolicy(columnName,
				checkboxSelection, addNewPolicyPage.getSelectedPolicyName());
		testContext.getIrisPageManager().irisCorporationAccounting.clickOnSaveBtn();
		testContext.getBasePage().cleanIrisProcesses();
	}

	@Given("^he has selected the same policy for the \"([^\"]*)\" Client on the \"([^\"]*)\" page after logging in again to the 'Aires Policy Tool' application$")
	public void he_has_selected_the_same_policy_for_the_Client_on_the_page_after_logging_in_again_to_the_Aires_Policy_Tool_application(
			String clientID, String pageName) throws Throwable {
		addNewPolicyPage.clickElementOfPage(COREFLEXConstants.LOGOUT);
		Assert.assertTrue(loginPage.loginByUserType(PDTConstants.CSM, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));
		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM, PDTConstants.VIEW_EDIT_POLICY_FORMS);
		addNewPolicyPage.enterClientID(clientID);
		Assert.assertTrue(addNewPolicyPage.verifyAndClickValidClientIDResult(clientID), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_VALID_CLIENT_ID_DROPDOWN_OPTIONS, CoreConstants.FAIL));
		Assert.assertTrue(addNewPolicyPage.selectAPolicy(addNewPolicyPage.getSelectedPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));
	}

	@Given("^he has clicked on 'Next' button$")
	public void he_has_clicked_on_Next_button() throws Throwable {
		addNewPolicyPage.clickElementOfPage(PDTConstants.NEXT);
	}

	@Then("^\"([^\"]*)\" page should be displayed having \"([^\"]*)\" field value as \"([^\"]*)\" for \"([^\"]*)\" Client$")
	public void page_should_be_displayed_having_field_value_as_for_Client(String pageName, String fieldName,
			String expectedFieldValue, String clientID) throws Throwable {
		Assert.assertTrue(
				generalInfoPage.validateClientAndPolicyDetailsOnGeneralInfo(pageName, clientID,
						addNewPolicyPage.getSelectedPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_CLIENT_POLICY_DATA_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(generalInfoPage.verifyGeneralInfoFieldDefaultValue(fieldName, expectedFieldValue),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_COREFLEX_POLICY_FIELD_ON_GENERAL_INFO_PAGE,
						CoreConstants.FAIL));
	}

	@Then("^\"([^\"]*)\" field visibility \"([^\"]*)\" having \"([^\"]*)\" dropdown options should depend on CoreFlexFieldValue \"([^\"]*)\"$")
	public void field_visibility_having_dropdown_options_should_depend_on_CoreFlexFieldValue(String fieldName,
			String fieldVisibility, String fieldOptions, String coreFlexPolicyFieldValue) throws Throwable {
		Assert.assertTrue(
				generalInfoPage.verifyFieldVisibilityAndOptionsOnGeneralInfoPage(fieldName, fieldVisibility,
						fieldOptions, coreFlexPolicyFieldValue),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_BENEFIT_PACKAGE_TYPE_FIELD_ON_GENERAL_INFO_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has selected \"([^\"]*)\" option for \"([^\"]*)\" dropdown field of \"([^\"]*)\" Policy after filling all other mandatory fields on \"([^\"]*)\" page for \"([^\"]*)\" Client$")
	public void he_has_selected_option_for_dropdown_field_after_filling_all_other_mandatory_fields_on_page_for_Client(
			String fieldSelection, String fieldName, String coreFlexYN, String pageName, String clientID,
			DataTable dataTable) throws Throwable {
		Assert.assertTrue(
				generalInfoPage.validateClientAndPolicyDetailsOnGeneralInfo(pageName, clientID,
						addNewPolicyPage.getSelectedPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_CLIENT_POLICY_DATA_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		generalInfoPage.fillOtherMandatoryFields(dataTable);
		Assert.assertTrue(generalInfoPage.selectFieldOption(fieldName, fieldSelection), MessageFormat
				.format(PDTConstants.FAILED_TO_SELECT_FIELD_OPTIONS_ON_GENERAL_INFO_PAGE, CoreConstants.FAIL));
	}

	@Then("^he should be navigated to \"([^\"]*)\" page having \"([^\"]*)\" based on \"([^\"]*)\" selection$")
	public void he_should_be_navigated_to_page_having_based_on_selection(String expectedPageTitle,
			String expectedLeftNavigationTitle, String pointsBasedFlexSelection) throws Throwable {
		Assert.assertTrue(
				generalInfoPage.verifyPageNavigation(pointsBasedFlexSelection, expectedPageTitle,
						expectedLeftNavigationTitle, flexPolicySetupPage, pdtPolicyBenefitCategoryPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_USER_NAVIGATION_PAST_GENERAL_INFORMATION,
						CoreConstants.FAIL));
	}	
}
