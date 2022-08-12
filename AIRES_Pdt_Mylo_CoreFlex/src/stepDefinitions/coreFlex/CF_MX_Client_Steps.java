package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.coreflex.MX_Client_AuthorizationHomePage;
import com.aires.pages.coreflex.MX_Client_BenefitSelectionToolPage;
import com.aires.pages.coreflex.MobilityX_LoginPage;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_MX_Client_Steps {

	private TestContext testContext;

	private MobilityX_LoginPage mobilityXLoginPage;
	private MX_Client_AuthorizationHomePage mxClientAuthorizationHomePage;
	private MX_Client_BenefitSelectionToolPage mxClientBenefitSelectionToolPage;
	private MX_Client_Dashboard_BscData bscAuthorizationData;

	public CF_MX_Client_Steps(TestContext context) {
		testContext = context;
		mobilityXLoginPage = testContext.getCoreFlexPageObjectManager().getMobilityXLoginPage();
		mxClientAuthorizationHomePage = testContext.getCoreFlexPageObjectManager().getMXClientAuthorizationHomePage();
		mxClientBenefitSelectionToolPage = testContext.getCoreFlexPageObjectManager().getMXClientBenefitSelectionTollPage();
	}

	private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader()
			.getLoginByApplication(CoreFunctions.getPropertyFromConfig("application").toLowerCase());	

	@Given("^he has logged into 'MobilityX' application as a 'Client' user$")
	public void he_is_logged_into_MobilityX_application_as_a_Client_user() throws Throwable {
		Assert.assertTrue(mobilityXLoginPage.verifyPageNavigation(),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_MOBILITYX_LOGIN_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Login</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		mobilityXLoginPage.enterUsernameAndPasswordForMobilityX(
				BusinessFunctions.getClientAndPolicyDetails(_loginDetailsApplication)[3],
				BusinessFunctions.getClientAndPolicyDetails(_loginDetailsApplication)[4]);
		mobilityXLoginPage.clickSignIn();
		mxClientAuthorizationHomePage.handle_Cookie_AfterLogin();

		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigation(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Home</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");	
	}
	
	@Given("^he has clicked on \"([^\"]*)\" after validating Client details on 'Authorization Home Page'$")
	public void he_has_clicked_on_after_validating_Client_details_on_Authorization_Home_Page(String createAuthButton) throws Throwable {
		Assert.assertTrue(
				mxClientAuthorizationHomePage.verifyClientDetails(
						BusinessFunctions.getClientAndPolicyDetails(_loginDetailsApplication)[5],
						BusinessFunctions.getClientAndPolicyDetails(_loginDetailsApplication)[6]),
				MessageFormat.format(MobilityXConstants.CLIENT_DETAILS_NOT_MATCHED_ON_MOBILITYX_CLIENT_HOME_PAGE,
						CoreConstants.FAIL));
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(createAuthButton);		
	}
	
	@Given("^he has filled all the mandatory information on 'Authorization Form' after selecting following 'Assignment Option' with 'Auth Form Template' for an employee on 'Authorization Home Page'$")
	public void he_has_filled_all_the_mandatory_information_on_Authorization_Form_after_selecting_following_Assignment_Option_with_Auth_Form_Template_for_an_employee_on_Authorization_Home_Page(
			DataTable dataTable) throws Throwable {
		 List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
		 String assignmentOption = dataMap.get(0).get("Assignment Option");
		 String authFormTemplate = dataMap.get(0).get("Authorization Form Template");
		mxClientAuthorizationHomePage.enterEmpFirstAndLastNameForNewAuthorization();
		mxClientAuthorizationHomePage.selectAuthorizationOptionForEmployee(assignmentOption);
		mxClientAuthorizationHomePage.selectAuthorizationFormTemplate(
				BusinessFunctions.getClientAndPolicyDetails(_loginDetailsApplication)[0],
				BusinessFunctions.getClientAndPolicyDetails(_loginDetailsApplication)[1], authFormTemplate);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigationToAuthForm(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Auth Form</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader().getBscDataByModuleName("DomesticAuthorizationFormData");
		mxClientAuthorizationHomePage.fillAuthorizationForBSCDomesticForm(bscAuthorizationData);
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyAuthFormChangesAutoSaved(), MessageFormat
				.format(MobilityXConstants.CHANGES_NOT_AUTO_SAVED_AFTER_FILLING_AUTHORIZATION_FORM, CoreConstants.FAIL));		
	}
	
	@Given("^he has verified 'Total Points' section displayed on 'Authorization Form' for \"([^\"]*)\" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy$")
	public void he_has_verified_Total_Points_section_displayed_on_Authorization_Form_for_Flex_Setup_Type_selection_in_BluePrint_CoreFlex_Policy(String arg1) throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyTotalPointsSection(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_TOTAL_POINTS_SECTION_ON_AUTHORIZATION_FORM, CoreConstants.FAIL));		
	}

	@Given("^he has verified 'FleX Benefits' section displayed on 'Authorization Form' for \"([^\"]*)\" - 'Person Responsible' selection in BluePrint CoreFlex Policy$")
	public void he_has_verified_FleX_Benefits_section_displayed_on_Authorization_Form_for_Person_Responsible_selection_in_BluePrint_CoreFlex_Policy(String arg1) throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyFlexBenefitsSection(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFITS_SECTION_ON_AUTHORIZATION_FORM, CoreConstants.FAIL));
	}

	@Given("^he has verified 'Error Growl Message' and 'Required Field Validation' displayed after clicking on \"([^\"]*)\" button with Blank/Invalid 'Total Points' value$")
	public void he_has_verified_Error_Growl_Message_and_Required_Field_Validation_displayed_after_clicking_on_button_with_Blank_Invalid_Total_Points_value(String arg1) throws Throwable {
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(MobilityXConstants.START_BENEFIT_SELECTION);
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyRequiredFieldsValidation(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_REQUIRED_FIELDS_VALIDATION_ON_AUTHORIZATION_FORM, CoreConstants.FAIL));		
	}

	@Given("^he has navigated to \"([^\"]*)\" page after entering valid 'Total Points' value and clicking on \"([^\"]*)\" button$")
	public void he_has_navigated_to_page_after_entering_valid_Total_Points_value_and_clicking_on_button(String arg1, String arg2) throws Throwable {
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader().getBscDataByModuleName("DomesticAuthorizationFormData");
		mxClientAuthorizationHomePage.enterValidTotalPointsValue(bscAuthorizationData);
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(MobilityXConstants.START_BENEFIT_SELECTION);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPageNavigation(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Benefit Selection Tool</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		
	}

	@Given("^he has verified following details on \"([^\"]*)\" page based on configured Points Based CoreFlex BluePrint Policy$")
	public void he_has_verified_following_details_on_page_based_on_configured_Points_Based_CoreFlex_BluePrint_Policy(String arg1, DataTable arg2) throws Throwable {
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyInitiationForText(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_INITIATION_FOR_TEXT_ON_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyAvailablePointsMessage(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				mxClientBenefitSelectionToolPage.verifyBenefitDetailsOnFPTBasedOnPolicyRequiredFor(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"),
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType")),
				MessageFormat.format(
						MobilityXConstants.BENEFIT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE_OF_MXCLIENT_NOT_MATCHED_WITH_BENEFITS_DETAILS_SET_IN_BLUEPRINT_APPLICATION,
						CoreConstants.FAIL));
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPortionCashOutOnBST(), MessageFormat.format(
				MobilityXConstants.PORTION_CASHOUT_DETAILS_NOT_MATCHED_ON_BENEFIT_SELECTION_TOOL_PAGE, CoreConstants.FAIL));
		
		mxClientBenefitSelectionToolPage.clickElementOfPage(MobilityXConstants.SUGGESTED_OPTIONS_LINK);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyUserNavigationToSuggestedBundlesPage(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_NAVIGATE_TO_SUGGESTED_BUNDLES_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MXClient Suggested Bundles</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(
				mxClientBenefitSelectionToolPage.verifySuggestedBundlesDetailsBasedOnPolicyRequiredFor(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"),
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType")),
				MessageFormat.format(MobilityXConstants.CUSTOM_BUNDLE_DETAILS_NOT_MATCHED_ON_SUGGESTED_BUNDLES_PAGE,
						CoreConstants.FAIL));
	} 

	@When("^he clicks on 'Back to initiation' link on \"([^\"]*)\" page$")
	public void he_clicks_on_Back_to_initiation_link_on_page(String arg1) throws Throwable {
		mxClientBenefitSelectionToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPageNavigation(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Benefit Selection Tool</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		mxClientBenefitSelectionToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_INITIATION);
	}

	@Then("^he should be navigated back to 'Authorization Form' page$")
	public void he_should_be_navigated_back_to_Authorization_Form_page() throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigationToAuthForm(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Auth Form</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
	}
}
