package stepDefinitions.coreFlex;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
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
import cucumber.api.java.en.Then;

public class CoreFlex_GeneralInformation_Steps {

	TestContext testContext;
	PDT_LoginPage loginPage;
	PDT_ViewPolicyPage viewPolicyPage;
	PDT_AddNewPolicyPage addNewPolicyPage;
	PDT_GeneralInformationPage generalInfoPage;
	private PDT_LoginDetails _loginDetails = null;

	public CoreFlex_GeneralInformation_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInformationPage();
	}

	@Then("^user should be navigated to the \"([^\"]*)\" page of the selected Client Policy$")
	public void user_should_be_navigated_to_the_page_of_the_selected_Client_Policy(String pageName, DataTable dataTable)
			throws Throwable {

		Assert.assertTrue(
				generalInfoPage.validateGeneralInfo(pageName, dataTable, addNewPolicyPage.getSelectedPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_CLIENT_POLICY_DATA_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));

	}

	@Given("^he has selected a policy for \"([^\"]*)\" Client on \"([^\"]*)\" page of 'Aires Policy Tool' Application$")
	public void he_has_selected_a_policy_for_Client_on_page_of_Aires_Policy_Tool_Application(String clientID,
			String pageName) throws Throwable {

		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
		addNewPolicyPage.enterClientID(clientID);
		Assert.assertTrue(addNewPolicyPage.verifyValidClientIDResult(clientID), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_VALID_CLIENT_ID_DROPDOWN_OPTIONS, CoreConstants.FAIL));
		Assert.assertTrue(addNewPolicyPage.validatePolicyNameList(), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME_FIELD_FOR_VALID_CLIENTID, CoreConstants.FAIL));
		Assert.assertTrue(addNewPolicyPage.selectPolicy(),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));

	}

	@Given("^he has saved the record after \"([^\"]*)\" \"([^\"]*)\" checkbox for the policy selected above in 'Policy table' of \"([^\"]*)\" tab from \"([^\"]*)\" module of \"([^\"]*)\" corporation$")
	public void he_has_saved_the_record_after_checkbox_for_the_policy_selected_above_in_Policy_table_of_tab_from_module_of_corporation(
			String userSelection, String coreFlexColumnName, String tabName, String moduleName, String corporationId)
			throws Throwable {
		
		testContext.getBasePage().invokeIrisApplication();	
		_loginDetails = FileReaderManager.getInstance().getJsonReader().getLoginByApplication("IRIS");
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetails);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(moduleName);
		testContext.getIrisPageManager().irisCorporationMain = new IRIS_Corporation_Main();
		testContext.getIrisPageManager().irisCorporationMain.queryCorporation(corporationId);
		testContext.getIrisPageManager().irisCorporationMain.selectCorporationModules(tabName);
		testContext.getIrisPageManager().irisCorporationAccounting = new IRIS_Corporation_Accounting();
		testContext.getIrisPageManager().irisCorporationAccounting.verifyAccountingTab();
		testContext.getIrisPageManager().irisCorporationAccounting.performCoreFlexCheckboxSelectionForPolicy(coreFlexColumnName,userSelection,addNewPolicyPage.getSelectedPolicyName());
		testContext.getIrisPageManager().irisCorporationAccounting.clickOnSaveBtn();
		testContext.getIrisPageManager().irisCorporationAccounting.saveConfirmation();	
		testContext.getBasePage().cleanIrisProcesses();	

	}

	@Given("^he had selected the same policy for \"([^\"]*)\" Client after logging out and logging in again to 'Aires Policy Tool' application as a \"([^\"]*)\" user$")
	public void he_had_selected_the_same_policy_for_Client_after_logging_out_and_logging_in_again_to_Aires_Policy_Tool_application_as_a_user(
			String clientID, String userType) throws Throwable {

		addNewPolicyPage.clickLogout();
		Assert.assertTrue(loginPage.loginByUserType(userType, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));
		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
		addNewPolicyPage.enterClientID(clientID);
		Assert.assertTrue(addNewPolicyPage.verifyValidClientIDResult(clientID), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_VALID_CLIENT_ID_DROPDOWN_OPTIONS, CoreConstants.FAIL));
		Assert.assertTrue(addNewPolicyPage.validatePolicyNameList(), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME_FIELD_FOR_VALID_CLIENTID, CoreConstants.FAIL));
		Assert.assertTrue(addNewPolicyPage.selectVerifiedPolicy(),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));

	}

	@Then("^\"([^\"]*)\" field should be displayed as \"([^\"]*)\" in read-only mode$")
	public void field_should_be_displayed_as_in_read_only_mode(String fieldName, String defaultValue,
			DataTable dataTable) throws Throwable {

		Assert.assertTrue(generalInfoPage.verifyGeneralInfoField(fieldName, defaultValue, dataTable),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_COREFLEX_POLICY_FIELD_ON_GENERAL_INFO_PAGE, CoreConstants.FAIL));

	}

	@Then("^\"([^\"]*)\" dropdown field should be displayed having following options with default selection as \"([^\"]*)\"$")
	public void dropdown_field_should_be_displayed_having_following_options_with_default_selection_as(String fieldName,
			String defaultValue, DataTable dataTable) throws Throwable {

		Assert.assertTrue(generalInfoPage.verifyGeneralInfoField(fieldName, defaultValue, dataTable),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_BENEFIT_PACKAGE_TYPE_FIELD_ON_GENERAL_INFO_PAGE, CoreConstants.FAIL));
	}
	
	@Then("^\"([^\"]*)\" dropdown field should not be displayed$")
	public void dropdown_field_should_not_be_displayed(String pointsBasedFlexPolicyFeild) throws Throwable {
	    
		Assert.assertFalse(generalInfoPage.verifyFieldExist(pointsBasedFlexPolicyFeild),
				MessageFormat.format(PDTConstants.POINTS_BASED_FLEX_POLICY_FIELD_DISPLAYED_FOR_NON_COREFLEX_POLICY, CoreConstants.FAIL));
	}

}
