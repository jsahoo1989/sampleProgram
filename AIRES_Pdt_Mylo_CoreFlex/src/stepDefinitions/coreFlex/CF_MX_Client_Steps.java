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
import com.aires.businessrules.constants.IRISConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.coreflex.MX_Client_AuthorizationHomePage;
import com.aires.pages.coreflex.MX_Client_BenefitSelectionToolPage;
import com.aires.pages.coreflex.MX_Client_BenefitsBundlePage;
import com.aires.pages.coreflex.MX_Client_ViewAllInitiationsPage;
import com.aires.pages.coreflex.MobilityX_LoginPage;
import com.aires.pages.coreflex.TransfereeSubmissions_DashboardHomePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DetailsPage;
import com.aires.pages.coreflex.TransfereeSubmissions_LoginPage;
import com.aires.pages.iris.IRIS_ActivityAndFinancePage;
import com.aires.pages.iris.IRIS_AssignmentOverviewPage;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.pages.iris.IRIS_Welcome12C;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData;
import com.aires.testdatatypes.coreflex.TransfereeSubmissions_LoginData;
import com.aires.testdatatypes.iris.IRIS_AssignmentData;
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
	private MX_Client_BenefitsBundlePage mxClientBenefitsBundlePage;
	private MX_Client_ViewAllInitiationsPage mxClientViewAllInitiationsPage;
	private TransfereeSubmissions_LoginPage transfereeSubmissionsLoginPage;
	private TransfereeSubmissions_DashboardHomePage transfereeSubmissionsDashboardHomePage;
	private TransfereeSubmissions_DetailsPage transfereeSubmissionsDetailsPage;

	public CF_MX_Client_Steps(TestContext context) {
		testContext = context;
		mobilityXLoginPage = testContext.getCoreFlexPageObjectManager().getMobilityXLoginPage();
		mxClientAuthorizationHomePage = testContext.getCoreFlexPageObjectManager().getMXClientAuthorizationHomePage();
		mxClientBenefitSelectionToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXClientBenefitSelectionToolPage();
		mxClientBenefitsBundlePage = testContext.getCoreFlexPageObjectManager().getMXClientBenefitsBundlePage();
		mxClientViewAllInitiationsPage = testContext.getCoreFlexPageObjectManager().getMXClientViewAllInitiationsPage();
		transfereeSubmissionsDashboardHomePage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDashboardHomePage();
		transfereeSubmissionsLoginPage = testContext.getCoreFlexPageObjectManager().getTransfereeSubmissionsLoginPage();
		transfereeSubmissionsDetailsPage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDetailsPage();
	}
	
	private TransfereeSubmissions_LoginData _transfereeSubmissionLoginData = FileReaderManager.getInstance()
			.getCoreFlexJsonReader().getTransfereeSubmissionLoginDataList(COREFLEXConstants.TRANSFEREE_SUBMISSIONS);

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
	public void he_has_clicked_on_after_validating_Client_details_on_Authorization_Home_Page(String createAuthButton)
			throws Throwable {
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
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		mxClientAuthorizationHomePage.fillAuthorizationForBSCDomesticForm(bscAuthorizationData);
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyAuthFormChangesAutoSaved(), MessageFormat.format(
				MobilityXConstants.CHANGES_NOT_AUTO_SAVED_AFTER_FILLING_AUTHORIZATION_FORM, CoreConstants.FAIL));
	}

	@Given("^he has verified 'Total Points' section displayed on 'Authorization Form' for \"([^\"]*)\" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy$")
	public void he_has_verified_Total_Points_section_displayed_on_Authorization_Form_for_Flex_Setup_Type_selection_in_BluePrint_CoreFlex_Policy(
			String arg1) throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyTotalPointsSection(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_TOTAL_POINTS_SECTION_ON_AUTHORIZATION_FORM, CoreConstants.FAIL));
	}

	@Given("^he has verified 'FleX Benefits' section displayed on 'Authorization Form' for \"([^\"]*)\" - 'Person Responsible' selection in BluePrint CoreFlex Policy$")
	public void he_has_verified_FleX_Benefits_section_displayed_on_Authorization_Form_for_Person_Responsible_selection_in_BluePrint_CoreFlex_Policy(
			String personResponsible) throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyFlexBenefitsSection(personResponsible),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFITS_SECTION_ON_AUTHORIZATION_FORM,
						CoreConstants.FAIL));
	}

	@Given("^he has verified 'Error Growl Message' and 'Required Field Validation' displayed after clicking on \"([^\"]*)\" button with Blank/No 'Total Points' value$")
	public void he_has_verified_Error_Growl_Message_and_Required_Field_Validation_displayed_after_clicking_on_button_with_Blank_No_Total_Points_value(
			String buttonName) throws Throwable {
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(buttonName);
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyRequiredFieldsValidation(buttonName),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_REQUIRED_FIELDS_VALIDATION_ON_AUTHORIZATION_FORM,
						CoreConstants.FAIL));
	}

	@Given("^he has navigated to \"([^\"]*)\" page after entering valid 'Total Points' value and clicking on \"([^\"]*)\" button$")
	public void he_has_navigated_to_page_after_entering_valid_Total_Points_value_and_clicking_on_button(String arg1,
			String arg2) throws Throwable {
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		mxClientAuthorizationHomePage.enterValidInitialTotalPointsValue(bscAuthorizationData);
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(MobilityXConstants.START_BENEFIT_SELECTION);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>MobilityX Client Benefit Selection Tool</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");

	}

	@Given("^he has verified following details on \"([^\"]*)\" page based on configured Points Based CoreFlex BluePrint Policy$")
	public void he_has_verified_following_details_on_page_based_on_configured_Points_Based_CoreFlex_BluePrint_Policy(
			String arg1, DataTable arg2) throws Throwable {
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyInitiationForText(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VALIDATE_INITIATION_FOR_TEXT_ON_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyAvailablePointsMessage(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(
				mxClientBenefitSelectionToolPage.verifyBenefitDetailsOnBSTBasedOnPolicyRequiredFor(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"),
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType")),
				MessageFormat.format(
						MobilityXConstants.BENEFIT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE_OF_MXCLIENT_NOT_MATCHED_WITH_BENEFITS_DETAILS_SET_IN_BLUEPRINT_APPLICATION,
						CoreConstants.FAIL));
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPortionCashOutOnBST(false),
				MessageFormat.format(
						MobilityXConstants.PORTION_CASHOUT_DETAILS_NOT_MATCHED_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));

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
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>MobilityX Client Benefit Selection Tool</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");
		mxClientBenefitSelectionToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_INITIATION);
	}

	@Given("^he has clicked on 'Back to initiation' link on \"([^\"]*)\" to navigate to 'Authorization Form' page$")
	public void he_has_clicked_on_Back_to_initiation_link_on_to_navigate_to_Authorization_Form_page(String pageName)
			throws Throwable {
		mxClientBenefitSelectionToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>MobilityX Client Benefit Selection Tool</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");
		mxClientBenefitSelectionToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_INITIATION);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigationToAuthForm(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Auth Form</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
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

	@When("^he selects CoreFlex policy in the 'Relocation Policy' dropdown on the Authorization form$")
	public void he_selects_CoreFlex_policy_in_the_Relocation_Policy_dropdown_on_the_Authorization_form()
			throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.selectRelocationPolicy(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_SELECT_RELOCATION_POLICY_ON_AUTHORIZATION_FORM, CoreConstants.FAIL));
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyAuthFormChangesAutoSaved(), MessageFormat.format(
				MobilityXConstants.CHANGES_NOT_AUTO_SAVED_AFTER_FILLING_AUTHORIZATION_FORM, CoreConstants.FAIL));
	}

	@Then("^'Total Points' section should be displayed on 'Authorization Form' for \"([^\"]*)\" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy$")
	public void Total_Points_section_should_be_displayed_on_Authorization_Form_for_Flex_Setup_Type_selection_in_BluePrint_CoreFlex_Policy(
			String flexPolicyType) throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyTotalPointsSection(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_TOTAL_POINTS_SECTION_ON_AUTHORIZATION_FORM, CoreConstants.FAIL));
	}

	@Then("^'FleX Benefits' section should not be displayed on 'Authorization Form' for \"([^\"]*)\" - 'Person Responsible' selection in BluePrint CoreFlex Policy$")
	public void FleX_Benefits_section_should_not_be_displayed_on_Authorization_Form_for_Person_Responsible_selection_in_BluePrint_CoreFlex_Policy(
			String personResponsible) throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyFlexBenefitsSection(personResponsible),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFITS_SECTION_ON_AUTHORIZATION_FORM,
						CoreConstants.FAIL));
	}

	@Then("^'Total Points' section should not be displayed on 'Authorization Form' for \"([^\"]*)\" - 'Flex Setup Type' selection in BluePrint CoreFlex Policy$")
	public void Total_Points_section_should_not_be_displayed_on_Authorization_Form_for_Flex_Setup_Type_selection_in_BluePrint_CoreFlex_Policy(
			String flexPolicyType) throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyTotalPointsSection(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_TOTAL_POINTS_SECTION_ON_AUTHORIZATION_FORM, CoreConstants.FAIL));
	}

	@Then("^'FleX Benefits' section should be displayed on 'Authorization Form' for \"([^\"]*)\" - 'Person Responsible' selection in BluePrint CoreFlex Policy$")
	public void FleX_Benefits_section_should_be_displayed_on_Authorization_Form_for_Person_Responsible_selection_in_BluePrint_CoreFlex_Policy(
			String personResponsible) throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyFlexBenefitsSection(personResponsible),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFITS_SECTION_ON_AUTHORIZATION_FORM,
						CoreConstants.FAIL));
	}

	@Then("^all information entered before navigating to 'Benefit Selection Tool' page should be auto-saved on 'Authorization Form'$")
	public void all_information_entered_before_navigating_to_Benefit_Selection_Tool_page_should_be_auto_saved_on_Authorization_Form()
			throws Throwable {
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		Assert.assertTrue(
				mxClientAuthorizationHomePage.verifyAuthFormAutoSavedAfterNavigation(bscAuthorizationData,
						MobilityXConstants.INITIAL_BENEFIT_TOTAL_POINTS),
				MessageFormat.format(MobilityXConstants.AUTHORIZATION_FORM_NOT_AUTO_SAVED_POST_NAVIGATION,
						CoreConstants.FAIL));
	}

	@Given("^he has clicked on 'Back to benefits list' to navigate to 'Benefit Selection Tool' page$")
	public void he_has_clicked_on_Back_to_benefits_list_to_navigate_to_Benefit_Selection_Tool_page() throws Throwable {
		mxClientBenefitSelectionToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>MobilityX Client Benefit Selection Tool</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");
	}

	@Given("^he has clicked on \"([^\"]*)\" button after selecting required Benefits_Cashout on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_selecting_required_Benefits_Cashout_on_page(String arg1, String arg2)
			throws Throwable {
		Assert.assertTrue(mxClientBenefitSelectionToolPage.selectBenefitsAndProceedToReview(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_SELECT_BENEFITS_AND_PROCEED_TO_REVIEW_PAGE, CoreConstants.FAIL));
	}

	@Given("^he verified selected Benefits_Cashout details on the navigated \"([^\"]*)\" page$")
	public void he_verified_selected_Benefits_Cashout_details_on_the_navigated_page(String pageName) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitsBundlePage.isBenefitsBundlePageDisplayed(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_DISPLAY_MX_CLIENT_BENEFITS_BUNDLE_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MX Client Benefits Bundle</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(mxClientBenefitsBundlePage.verifySelectedPortionCashoutDetails(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_SELECTED_PORTION_CASHOUT_DETAILS_ON_BENEFITS_BUNDLE_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxClientBenefitsBundlePage.verifySelectedBenefitDetails(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_BENEFITS_BUNDLE_PAGE, CoreConstants.FAIL));

	}

	@When("^he has clicked on \"([^\"]*)\" button on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_on_page(String buttonName, String pageName) throws Throwable {
		mxClientBenefitsBundlePage.clickElementOfPage(buttonName);
	}

	@When("^he has navigated back to 'Authorization Form' page having Auth Form status displayed as \"([^\"]*)\"$")
	public void he_has_navigated_back_to_Authorization_Form_page_having_Auth_Form_status_displayed_as(
			String authFormStatus) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigationToAuthForm(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Auth Form</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyAuthFormStatus(authFormStatus), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_AUTHORIZATION_FORM_STATUS, CoreConstants.FAIL));
	}

	@Given("^he has verified submitted Benefits_Cashout details displayed under 'Flex Benefits' section on 'Authorization Form'$")
	public void he_has_verified_submitted_Benefits_Cashout_details_displayed_under_Flex_Benefits_section_on_Authorization_Form()
			throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifySelectedCoreFlexBenefits(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_SECTION_DETAILS_ON_AUTH_FORM_POST_BENEFIT_CASHOUT_SELECTION,
				CoreConstants.FAIL));
	}

	@Given("^he has clicked on 'Submit to Aires' button from right floating menu of 'Authorization Form'$")
	public void he_has_clicked_on_Submit_to_Aires_button_from_right_floating_menu_of_Authorization_Form()
			throws Throwable {
		mxClientAuthorizationHomePage.clickOnElementsOfFloatingMenu(MobilityXConstants.SUBMIT_TO_AIRES);
	}

	@Then("^an email should be sent to Aires team with authorization details$")
	public void an_email_should_be_sent_to_Aires_team_with_authorization_details() throws Throwable {

	}

	@Given("^he has verified 'FleX Benefits' section not displayed on 'Authorization Form' for \"([^\"]*)\" - 'Person Responsible' selection in BluePrint CoreFlex Policy$")
	public void he_has_verified_FleX_Benefits_section_not_displayed_on_Authorization_Form_for_Person_Responsible_selection_in_BluePrint_CoreFlex_Policy(
			String personResponsible) throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyFlexBenefitsSection(personResponsible),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFITS_SECTION_ON_AUTHORIZATION_FORM,
						CoreConstants.FAIL));
	}

	@Given("^he has clicked on 'Submit to Aires' button from right floating menu of 'Authorization Form' after entering valid 'Total Points' value$")
	public void he_has_clicked_on_Submit_to_Aires_button_from_right_floating_menu_of_Authorization_Form_after_entering_valid_Total_Points_value()
			throws Throwable {
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		mxClientAuthorizationHomePage.enterValidInitialTotalPointsValue(bscAuthorizationData);
		mxClientAuthorizationHomePage.clickOnElementsOfFloatingMenu(MobilityXConstants.SUBMIT_TO_AIRES);
	}

	@Given("^he has clicked on \"([^\"]*)\" button from right floating menu of 'Authorization Form' page$")
	public void he_has_clicked_on_button_from_right_floating_menu_of_Authorization_Form_page(String buttonName)
			throws Throwable {
		mxClientAuthorizationHomePage.clickOnElementsOfFloatingMenu(buttonName);
	}
	
	@When("^he clicks on \"([^\"]*)\" button from right floating menu of 'Authorization Form' page$")
	public void he_clicks_on_button_from_right_floating_menu_of_Authorization_Form_page(String buttonName)
			throws Throwable {
		mxClientAuthorizationHomePage.clickOnElementsOfFloatingMenu(buttonName);
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(MobilityXConstants.SUBMIT);
	}

	@Given("^he has clicked on \"([^\"]*)\" button on the 'Do you want to submit it without the required approvals\\?' dialog$")
	public void he_has_clicked_on_button_on_the_Do_you_want_to_submit_it_without_the_required_approvals_dialog(
			String buttonName) throws Throwable {
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(buttonName);
	}

	@Given("^he has verified 'Auth Submit Success' growl message displayed on the navigated 'MobilityX Dashboard Home' page$")
	public void he_has_verified_Auth_Submit_Success_growl_message_displayed_on_the_navigated_MobilityX_Dashboard_Home_page()
			throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyInitiationSubmittedSuccessGrowlMessage(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_INITIATION_SUBMITTED_SUCCESS_GROWL_MESSAGE,
						CoreConstants.FAIL));
		CoreFunctions.writeToPropertiesFile("CF_Transferee_AvailablePoints",
				String.valueOf(Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")) - Double
						.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints"))));
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigation(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
	}

	@Given("^he has verified 'New Initiation Submitted' email having Transferee details along with assigned CoreFlex Total Points$")
	public void he_has_verified_New_Initiation_Submitted_email_having_Transferee_details_along_with_assigned_CoreFlex_Total_Points()
			throws Throwable {
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyInitiationSubmissionEmail(bscAuthorizationData),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_INITIATION_SUBMISSION_EMAIL,
						CoreConstants.FAIL));
	}	

	@Given("^he has actualized the 'Authorization' created by the Client through IRIS application$")
	public void he_has_actualized_the_Authorization_created_by_the_Client_through_IRIS_application() throws Throwable {
//		testContext.getBasePage().reLaunchIrisToAvoidFreezingIssue();
		testContext.getBasePage().invokeIrisApplication();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.queryFile(CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptFailedImageLoadDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.acceptLinkSuggestionDialog();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.ACTIVITY_FINANCE_TAB);
		testContext.getIrisPageManager().irisActivityAndFinancePage = new IRIS_ActivityAndFinancePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisActivityAndFinancePage.verifyActivityAndFinanceTab(),
				MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
						IRISConstants.ACTIVITY_AND_FINANCE));
		testContext.getIrisPageManager().irisActivityAndFinancePage.displayAllActivityTable();
		testContext.getIrisPageManager().irisActivityAndFinancePage
				.actualizeInitialTracingPrompt(IRISConstants.ACT_DATE, IRISConstants.ACTIVITY);
		testContext.getBasePage().cleanIrisProcesses();
	}

	@Given("^he has clicked on \"([^\"]*)\" link on 'Authorization Home Page' to navigate to 'View all initiation' page$")
	public void he_has_clicked_on_link_on_Authorization_Home_Page_to_navigate_to_View_all_initiation_page(String arg1)
			throws Throwable {
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(MobilityXConstants.VIEW_ALL_INITIATIONS);
		Assert.assertTrue(mxClientViewAllInitiationsPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_VIEW_ALL_INITIATONS_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has clicked 'Transferee Name' from 'All Initiations' List on 'View all initiation' page$")
	public void he_has_clicked_Transferee_Name_from_All_Initiations_List_on_View_all_initiation_page()
			throws Throwable {
		mxClientViewAllInitiationsPage.clickElementOfPage(MobilityXConstants.INITIATION);
	}

	@When("^he clicks on 'Resubmit to Aires' after increasing 'Benfit Total Points' value on 'Auth Form Template' page$")
	public void he_clicks_on_Resubmit_to_Aires_after_increasing_Benfit_Total_Points_value_on_Auth_Form_Template_page()
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigationToAuthForm(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Auth Form</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		mxClientAuthorizationHomePage.enterValidIncreasedTotalPointsValue(bscAuthorizationData);
		mxClientAuthorizationHomePage.clickOnElementsOfFloatingMenu(MobilityXConstants.RESUBMIT_TO_AIRES);
	}

	@Given("^he has clicked on 'Resubmit to Aires' after decreasing 'Benfit Total Points' value on 'Auth Form Template' page$")
	public void he_has_clicked_on_Resubmit_to_Aires_after_decreasing_Benfit_Total_Points_value_on_Auth_Form_Template_page()
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigationToAuthForm(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Auth Form</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		mxClientAuthorizationHomePage.enterValidDecreasedTotalPointsValue(bscAuthorizationData);
		mxClientAuthorizationHomePage.clickOnElementsOfFloatingMenu(MobilityXConstants.RESUBMIT_TO_AIRES);
	}

	@Then("^following confirmation dialogs should be displayed after increasing 'Benfit Total Points' value in sequence on acceptance of current dialog$")
	public void following_confirmation_dialogs_should_be_displayed_after_increasing_Benefit_Total_Points_value_in_sequence_on_acceptance_of_current_dialog(
			DataTable dataTable) throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyAndAcceptIncreasedPointsDialog(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_AND_ACCEPT_INCREASED_POINTS_CONFIRMATION_DIALOG_ON_AUTH_FORM_PAGE,
				CoreConstants.FAIL));
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(MobilityXConstants.SUBMIT);
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(
				MobilityXConstants.RESUBMIT_WITH_CHANGES_MADE_TO_LETTER_POLICY_DOCUMENTS);
	}

	@Given("^'Auth Submit Success' growl message should be displayed on the navigated 'View all initiation' page on confirmation of the last dialog$")
	public void Auth_Submit_Success_growl_message_should_be_displayed_on_the_navigated_View_all_initiation_page_on_confirmation_of_the_last_dialog()
			throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyInitiationSubmittedSuccessGrowlMessage(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_INITIATION_SUBMITTED_SUCCESS_GROWL_MESSAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxClientViewAllInitiationsPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_VIEW_ALL_INITIATONS_PAGE,
						CoreConstants.FAIL));

	}

	@Then("^Revised 'New Initiation Submitted' email having updated Transferee and Benefit Points details should be received$")
	public void Revised_New_Initiation_Submitted_email_having_updated_Transferee_and_Benefit_Points_details_should_be_displayed()
			throws Throwable {
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyRevisedSubmissionEmail(bscAuthorizationData),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_INITIATION_SUBMISSION_EMAIL,
						CoreConstants.FAIL));
	}

	@Given("^he has verified 'Auth Submit Success' growl message displayed on the navigated 'View all initiation' page on confirmation of the last dialog$")
	public void he_has_verified_Auth_Submit_Success_growl_message_displayed_on_the_navigated_View_all_initiation_page_on_confirmation_of_the_last_dialog()
			throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyInitiationSubmittedSuccessGrowlMessage(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_INITIATION_SUBMITTED_SUCCESS_GROWL_MESSAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxClientViewAllInitiationsPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_VIEW_ALL_INITIATONS_PAGE,
						CoreConstants.FAIL));

	}

	@Given("^he has verified Revised 'New Initiation Submitted' email received having updated Transferee and Benefit Points details$")
	public void he_has_verified_Revised_New_Initiation_Submitted_email_received_having_updated_Transferee_and_Benefit_Points_details()
			throws Throwable {
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyRevisedSubmissionEmail(bscAuthorizationData),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_INITIATION_SUBMISSION_EMAIL,
						CoreConstants.FAIL));
	}

	@Given("^he has navigated to \"([^\"]*)\" page after selecting required Flex Benefits on 'Benefit Selection Tool' page$")
	public void he_has_navigated_to_page_after_selecting_required_Flex_Benefits_on_Benefit_Selection_Tool_page(
			String navigatedPageName) throws Throwable {
		Assert.assertTrue(mxClientBenefitSelectionToolPage.selectBenefitsAndProceedToSaveAndExit(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_SELECT_BENEFITS_AND_PROCEED_TO_REVIEW_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitsBundlePage.isBenefitsBundlePageDisplayed(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_DISPLAY_MX_CLIENT_BENEFITS_BUNDLE_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MX Client Benefits Bundle</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
	}

	@Given("^he has clicked on 'Back to initiation' link on 'Benefit Selection Tool' to navigate to 'Authorization Form' page$")
	public void he_has_clicked_on_Back_to_initiation_link_on_Benefit_Selection_Tool_to_navigate_to_Authorization_Form_page()
			throws Throwable {
		mxClientBenefitSelectionToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>MobilityX Client Benefit Selection Tool</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");
		mxClientBenefitSelectionToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_INITIATION);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigationToAuthForm(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Auth Form</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
	}

	@Given("^he has clicked on 'Back to benefits list' link on 'Suggested Bundles' to navigate to 'Benefit Selection Tool' page$")
	public void he_has_clicked_on_Back_to_benefits_list_link_on_Suggested_Bundles_to_navigate_to_Benefit_Selection_Tool_page()
			throws Throwable {
		mxClientBenefitSelectionToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>MobilityX Client Benefit Selection Tool</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");
	}

	@Given("^he has verified following confirmation dialogs after increasing 'Benfit Total Points' value displayed in sequence on acceptance of current dialog$")
	public void he_has_verified_following_confirmation_dialogs_after_increasing_Benefit_Total_Points_value_displayed_in_sequence_on_acceptance_of_current_dialog(
			DataTable dataTable) throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyAndAcceptIncreasedPointsDialog(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_AND_ACCEPT_INCREASED_POINTS_CONFIRMATION_DIALOG_ON_AUTH_FORM_PAGE,
				CoreConstants.FAIL));
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(MobilityXConstants.SUBMIT);
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(
				MobilityXConstants.RESUBMIT_WITH_CHANGES_MADE_TO_LETTER_POLICY_DOCUMENTS);
	}

	@Given("^he has clicked on 'Start Benefit Selection' after decreasing 'Benfit Total Points' value on 'Auth Form Template' page$")
	public void he_has_clicked_on_Start_Benefit_Selection_after_decreasing_Benfit_Total_Points_value_on_Auth_Form_Template_page()
			throws Throwable {
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		mxClientAuthorizationHomePage.enterValidDecreasedTotalPointsValue(bscAuthorizationData);
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(MobilityXConstants.START_BENEFIT_SELECTION);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>MobilityX Client Benefit Selection Tool</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");
	}

	@Given("^he has clicked on \"([^\"]*)\" button after validating selected Flex Benefit details listed under 'Selected Benefits' section on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_validating_selected_Flex_Benefit_details_listed_under_Selected_Benefits_section_on_page(
			String saveAndExitButton, String pageName) throws Throwable {
		Assert.assertTrue(mxClientBenefitsBundlePage.verifySelectedBenefitDetails(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VERIFY_SELECTED_BENEFITS_ON_BENEFITS_BUNDLE_PAGE, CoreConstants.FAIL));
		mxClientBenefitsBundlePage.clickElementOfPage(saveAndExitButton);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
	}

	@Given("^he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' details displayed on the navigated 'Authorization Form' page$")
	public void he_has_verified_entered_Total_Points_value_and_selected_Core_Flex_Benefit_details_displayed_on_the_navigated_Authorization_Form_page()
			throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigationToAuthForm(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Auth Form</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(
				mxClientAuthorizationHomePage.verifyFlexBenefitsSectionPostBenefitSelection(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFITS_SECTION_ON_AUTHORIZATION_FORM,
						CoreConstants.FAIL));
	}

	@Given("^he has verified 'New Initiation Submitted' email having Transferee and selected 'Core_Flex Benefit' details along with assigned CoreFlex Total Points$")
	public void he_has_verified_New_Initiation_Submitted_email_having_Transferee_and_selected_Core_Flex_Benefit_details_along_with_assigned_CoreFlex_Total_Points()
			throws Throwable {
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyInitiationSubmissionEmail(bscAuthorizationData),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_INITIATION_SUBMISSION_EMAIL,
						CoreConstants.FAIL));
	}

	@Given("^he has verified entered 'Total Points' value and selected 'Core_Flex Benefit' details displayed on the navigated 'Authorization Form' page post Auth form submission$")
	public void he_has_verified_entered_Total_Points_value_and_selected_Core_Flex_Benefit_details_displayed_on_the_navigated_Authorization_Form_page_post_Auth_form_submission()
			throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigationToAuthForm(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Auth Form</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(
				mxClientAuthorizationHomePage.verifyFlexBenefitsSectionPostAuthFormSubmission(
						CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFITS_SECTION_ON_AUTHORIZATION_FORM,
						CoreConstants.FAIL));
	}

	@Given("^he has navigated to 'Benefit Selection Tool' page after clicking on 'Manage Benefit Selection' button$")
	public void he_has_navigated_to_Benefit_Selection_Tool_page_after_clicking_on_Manage_Benefit_Selection_button()
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigationToAuthForm(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Auth Form</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(MobilityXConstants.MANAGE_BENEFIT_SELECTION);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>MobilityX Client Benefit Selection Tool</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");
	}

	@Given("^he has verified 'You cannot decrease the Total Points after submission of benefits.' dialog displayed on 'Auth Form Template' page$")
	public void he_has_verified_You_cannot_decrease_the_Total_Points_after_submission_of_benefits_dialog_displayed_on_Auth_Form_Template_page()
			throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyAndAcceptCannotDecreasedPointsAfterSubmissionDialog(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_AND_ACCEPT_DECREASED_POINTS_CONFIRMATION_DIALOG_ON_AUTH_FORM_PAGE,
						CoreConstants.FAIL));
	}

	@Given("^he has verified 'New Initiation Submitted' email having Transferee details along with assigned CoreFlex Total Points and Submitted Benefits Points$")
	public void he_has_verified_New_Initiation_Submitted_email_having_Transferee_details_along_with_assigned_CoreFlex_Total_Points_and_Submitted_Benefits_Points()
			throws Throwable {
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyInitiationBenefitsSubmissionEmail(bscAuthorizationData),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_INITIATION_BENEFITS_SUBMISSION_EMAIL,
						CoreConstants.FAIL));
	}
	
	@Given("^he has actualized the Transferee after selecting required 'MSPEC_PPC' user and setting file status as 'Active' in IRIS application$")
	public void he_has_actualized_the_Transferee_after_selecting_required_MSPEC_PPC_user_and_setting_file_status_as_Active_in_IRIS_application()
			throws Throwable {
		testContext.getBasePage().reLaunchIrisToAvoidFreezingIssue();
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetailsApplication);
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
		testContext.getIrisPageManager().irisAssignmentOverviewPage.setFileStatus(IRISConstants.ACTIVATE);
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.OVERVIEW);
		IRIS_AssignmentData assignmentOverviewData = FileReaderManager.getInstance().getIrisJsonReader()
				.getAssignmentDataByTabName(IRISConstants.OVERVIEW);
		testContext.getIrisPageManager().irisAssignmentOverviewPage
				.addAiresTeamDetailsOnOverviewTab(assignmentOverviewData);
		testContext.getBasePage().cleanIrisProcesses();
	}
	
	@Given("^he has verified following details on 'Benefit Selection Tool' page post Authorization form submission$")
	public void he_has_verified_following_details_on_Benefit_Selection_Tool_page_post_Authorization_form_submission(
			 DataTable dataTable) throws Throwable {
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyInitiationForText(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VALIDATE_INITIATION_FOR_TEXT_ON_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyAvailablePointsMessageAfterBenefitSubmission(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPortionCashOutOnBST(true),
				MessageFormat.format(
						MobilityXConstants.PORTION_CASHOUT_DETAILS_NOT_MATCHED_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				mxClientBenefitSelectionToolPage.validatePointsAfterSubmissionOnNextButton(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_AVAILABLE_POINTS_ON_NEXT_BUTTON_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				mxClientBenefitSelectionToolPage.verifyElementPresentOnPage(MobilityXConstants.EDIT_BENEFIT_SELECTION),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_ELEMENT_PRESENT_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL,MobilityXConstants.EDIT_BENEFIT_SELECTION));
	}
	
	@Given("^he has clicked on 'Edit Benefit Selection' button to navigate to 'Benefits Bundle' page$")
	public void he_has_clicked_on_Edit_Benefit_Selection_button_to_navigate_to_Benefits_Bundle_page()
			throws Throwable {
		mxClientBenefitSelectionToolPage.clickElementOfPage(MobilityXConstants.EDIT_BENEFIT_SELECTION);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitsBundlePage.isBenefitsBundlePageDisplayed(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_DISPLAY_MX_CLIENT_BENEFITS_BUNDLE_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MX Client Benefits Bundle</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
	}
	
	@Given("^he has verified submitted 'Core_Flex Benefit' details displayed under 'Submitted Benefits' section of 'Benefits Bundle' page$")
	public void he_has_verified_submitted_Core_Flex_Benefit_details_displayed_under_Submitted_Benefits_section_of_Benefits_Bundle_page() throws Throwable {
		Assert.assertTrue(mxClientBenefitsBundlePage.validateSubmittedBenefitDetails(), MessageFormat
				.format(MobilityXConstants.SUBMITTED_BENEFIT_DETAILS_NOT_MATCHED_ON_BENEFITS_BUNDLE_PAGE, CoreConstants.FAIL));
	}
	
	@Given("^he has 'Deleted' submitted Benefit on Benefits Bundle page and confirmed 'Remove Benefit Selection' dialog by entering username and clicking on \"([^\"]*)\"$")
	public void he_has_Deleted_submited_Benefit_on_Benefits_Bundle_page_and_confirmed_Remove_Benefit_Selection_dialog_by_entering_username_and_clicking_on(
			String buttonName) throws Throwable {
		Assert.assertTrue(mxClientBenefitsBundlePage.deleteSubmittedBenefit(buttonName), MessageFormat
				.format(MobilityXConstants.FAILED_TO_DELETE_SUBMITTED_BENEFIT_ON_BENEFITS_BUNDLE_PAGE, CoreConstants.FAIL));
	}
	
	@Given("^he has verified 'Status' of the deleted benefit displayed as \"([^\"]*)\" under 'Submitted Benefits' section of 'Benefits Bundle' page$")
	public void he_has_verified_status_of_the_deleted_benefit_displayed_as_under_Submitted_Benefits_section_of_Benefits_Bundle_page(
			String arg1) throws Throwable {
		Assert.assertTrue(mxClientBenefitsBundlePage.verifyDeletedBenefitStatus(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_DELETED_BENEFIT_AND_CASHOUT_STATUS, CoreConstants.FAIL));
	}
	
	@Given("^he has navigated to \"([^\"]*)\" page having record of Bundle submitted by the Client$")
	public void he_has_navigated_to_page_having_record_of_Bundle_submitted_by_the_Client(String pageName)
			throws Throwable {

		// Remove this method when 3rd party redirection issue is fixed
		transfereeSubmissionsDashboardHomePage.reloadApplicationIfNotLoaded();

		Assert.assertTrue(transfereeSubmissionsDashboardHomePage.verifyUserNavigationToDashboardPage(),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_TRANSFEREE_SUBMISSIONS_DASHBOARD_HOME_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Transferee Submissions Dashboard</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(
				transfereeSubmissionsDashboardHomePage.verifyUserLogin(
						transfereeSubmissionsLoginPage.getCSMUserName(_transfereeSubmissionLoginData),
						COREFLEXConstants.TRANSFEREE_SUBMISSIONS_DASHBOARD_HOME_PAGE),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USER_DETAILS_ON_DASHBOARD_HOME_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(transfereeSubmissionsDashboardHomePage.verifyClientBundleSubmissionDetails(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
						CoreConstants.FAIL));
	}
	
	@Given("^he has clicked on \"([^\"]*)\" button for Bundle submitted by the Client on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_for_Bundle_submitted_by_the_Client_on_page(String btnName, String pageName)
			throws Throwable {
		transfereeSubmissionsDashboardHomePage.clickElementOfPage(btnName);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
	}
	
	@Given("^he has navigated to \"([^\"]*)\" page having list of submitted benefits details by Client$")
	public void he_has_navigated_to_page_having_list_of_submitted_benefits_details_by_Client(String pageName) throws Throwable {
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifiyPageNavigation(pageName),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_NAVIGATE_TO_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
						CoreConstants.FAIL, pageName));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Transferee Submissions Detail</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");

		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifyClientAndPointsDetails(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_TRANSFEREE_AND_POINTS_DETAILS_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(transfereeSubmissionsDetailsPage.verifySubmittedBenefitsDetails(), MessageFormat.format(
				COREFLEXConstants.FAILED_TO_VERIFY_SUBMITTED_BENEFITS_DETAILS_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
				CoreConstants.FAIL));
	}
	
	@Given("^he has clicked on \"([^\"]*)\" followed by \"([^\"]*)\" button to resolve multiple 'Delete Request Pending' request of the Client$")
	public void he_has_clicked_on_followed_by_button_to_resolve_multiple_Delete_Request_Pending_request_of_the_Client(
			String checkAllButton, String resolveMultipleButton) throws Throwable {
		transfereeSubmissionsDetailsPage.clickElementOfPage(checkAllButton);
		transfereeSubmissionsDetailsPage.clickElementOfPage(resolveMultipleButton);
	}
	
	@Then("^'Auth Submit Success' growl message should be displayed on the navigated 'Advanced Authorization Search' page$")
	public void auth_Submit_Success_growl_message_should_be_displayed_on_the_navigated_Advanced_Authorization_Search_page() throws Throwable {
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyInitiationSubmittedSuccessGrowlMessage(),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_INITIATION_SUBMITTED_SUCCESS_GROWL_MESSAGE,
						CoreConstants.FAIL));
	}
	
	@Then("^'Revised Mobility Initiation' email having submitted_deleted Benefit and Points details should be received$")
	public void Revised_Mobility_Initiation_email_having_submitted_deleted_Benefit_Points_details_should_be_received()
			throws Throwable {
		bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getBscDataByModuleName("DomesticAuthorizationFormData");
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyRevisedBenefitsSubmissionEmail(bscAuthorizationData),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_REVISED_MOBILITY_INITIATION_EMAIL,
						CoreConstants.FAIL));
	}
	
	@Then("^benefit details should be updated in 'MXClient' application based on \"([^\"]*)\" 'Delete Request' on Transferee Submission$")
	public void benefit_details_should_be_updated_in_MXTransferee_application_based_on_Delete_Request_on_Transferee_Submission(
			String actionPerformed) throws Throwable {
		testContext.getWebDriverManager().getDriver().navigate()
				.to(FileReaderManager.getInstance().getConfigReader().getMobilityXUrl());
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
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(MobilityXConstants.VIEW_ALL_INITIATIONS);
		Assert.assertTrue(mxClientViewAllInitiationsPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_VIEW_ALL_INITIATONS_PAGE,
						CoreConstants.FAIL));
		mxClientViewAllInitiationsPage.clickElementOfPage(MobilityXConstants.INITIATION);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientAuthorizationHomePage.verifyPageNavigationToAuthForm(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_HOME_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MobilityX Client Auth Form</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		mxClientAuthorizationHomePage.clickOnElementOnAuthorizationPage(MobilityXConstants.MANAGE_BENEFIT_SELECTION);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPageNavigation(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_USER_NAVIGATION_TO_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>MobilityX Client Benefit Selection Tool</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");		
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyInitiationForText(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VALIDATE_INITIATION_FOR_TEXT_ON_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyAvailablePointsMessageAfterBenefitSubmission(), MessageFormat.format(
				MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_MXCLIENT_BENEFIT_SELECTION_TOOL_PAGE,
				CoreConstants.FAIL));
		Assert.assertTrue(mxClientBenefitSelectionToolPage.verifyPortionCashOutOnBST(true),
				MessageFormat.format(
						MobilityXConstants.PORTION_CASHOUT_DETAILS_NOT_MATCHED_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				mxClientBenefitSelectionToolPage.validatePointsAfterSubmissionOnNextButton(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_AVAILABLE_POINTS_ON_NEXT_BUTTON_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				mxClientBenefitSelectionToolPage.verifyElementPresentOnPage(MobilityXConstants.EDIT_BENEFIT_SELECTION),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VERIFY_ELEMENT_PRESENT_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL,MobilityXConstants.EDIT_BENEFIT_SELECTION));
		mxClientBenefitSelectionToolPage.clickElementOfPage(MobilityXConstants.EDIT_BENEFIT_SELECTION);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxClientBenefitsBundlePage.isBenefitsBundlePageDisplayed(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_DISPLAY_MX_CLIENT_BENEFITS_BUNDLE_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>MX Client Benefits Bundle</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");	
		Assert.assertTrue(mxClientBenefitsBundlePage
				.validateSubmittedBenefitDetailsPostDeleteRequestOperation(actionPerformed),
				MessageFormat.format(MobilityXConstants.BENEFIT_DETAILS_NOT_MATCHED_ON_BENEFITS_BUNDLE_PAGE, CoreConstants.FAIL));
	}
}
