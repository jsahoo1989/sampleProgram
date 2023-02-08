package stepDefinitions.mylo;

import java.text.MessageFormat;
import org.testng.Assert;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mobilityx.MobilityX_AuthorizationPage;
import com.aires.pages.mobilityx.MobilityX_DashboardHomePage;
import com.aires.pages.mobilityx.MobilityX_LoginPage;
import com.aires.pages.mylo.MyloJourneyPage_CreateNewFileSection;
import com.aires.pages.mylo.MyloJourneyPage_LinkMobilityJourneySection;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeSection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData;
import com.aires.testdatatypes.mylo.MyloEnvironmentDetails;
import com.aires.utilities.CustomSoftAssert;
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloLinkMobilityJourney_Steps {
	private TestContext _testContext;
	private Mylo_LoginPage _loginPage;
	private Mylo_DashboardHomePage _myloDashboardPage;
	private Mylo_JourneyPage _myloJourneyPage;
	private MyloJourneyPage_CreateNewFileSection _myloNewFileSection;
	private CustomSoftAssert _softAssert;
	private MobilityX_LoginPage _mxLoginPage;
	private MobilityX_DashboardHomePage _mxDashboardHomePage;
	private MobilityX_AuthorizationPage _mxAuthorizationPage;
	private MyloJourneyPage_LinkMobilityJourneySection _linkMobJourneySection;
	private MyloJourneyPage_TransfereeSection _myloTransfereeSection;
	private String _environment = CoreFunctions.getEnvironment();
	private String _linkFileID = "", _journeyDetails = "";
	private MyloEnvironmentDetails _myloEnvtDetails = FileReaderManager.getInstance().getMyloJsonReader()
			.getMyloLoginInfoByEnvt(_environment);

	public MyloLinkMobilityJourney_Steps(TestContext context) {
		_testContext = context;
		_loginPage = _testContext.getMyloPageObjectManager().getLoginPage();
		_myloDashboardPage = _testContext.getMyloPageObjectManager().getDashboardHomePage();
		_myloJourneyPage = _testContext.getMyloPageObjectManager().getJourneyPage();
		_myloNewFileSection = _testContext.getMyloPageObjectManager().getJourneyPageCreateNewFileSection();
		_softAssert = _testContext.getSoftAssertObject();
		_mxLoginPage = _testContext.getMobilityXPageObjectManager().getLoginPage();
		_mxDashboardHomePage = _testContext.getMobilityXPageObjectManager().getDashboardHomePage();
		_mxAuthorizationPage = _testContext.getMobilityXPageObjectManager().getAuthorizationPage();
		_linkMobJourneySection = _testContext.getMyloPageObjectManager().getLinkMobJourneySection();
		_myloTransfereeSection = _testContext.getMyloPageObjectManager().getJourneyPageTransfereeSection();
	}

	/**
	 * Prerequisite: Log into MobilityX application with client 49226 user Create
	 * New Assignment of different transferee name & Submit Authorization in
	 * MobilityX application
	 */
	@Given("^he has submitted a new Authorization for a newly created file with different transferee name on MobilityX application$")
	public void he_has_submitted_a_new_Authorization_for_a_newly_created_file_with_different_transferee_name_on_MobilityX_application() {
		_mxLoginPage.openApplication();
		_mxLoginPage.enterUsernameAndPasswordForMobilityX(_myloEnvtDetails.details.mxClientUserName,
				_myloEnvtDetails.details.mxClientPassword);
		_mxLoginPage.clickSignIn();
		_mxLoginPage.handle_Cookie_AfterLogin();
		_softAssert.assertTrue(_mxLoginPage.verifyUserlogin(_myloEnvtDetails.details.mxClientUserProfileName),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FIRST_AND_LAST_NAME, CoreConstants.FAIL,
						_myloEnvtDetails.details.mxClientUserProfileName, MobilityXConstants.HOME_PAGE));
		_mxDashboardHomePage.enterEmpFirstAndLastNameForNewAuthorization(MYLOConstants.CUSTOM_FIELD_LENGTH,
				MYLOConstants.CUSTOM_FIELD_LENGTH, MYLOConstants.RANDOM_STRING);
		_mxDashboardHomePage.selectAuthorizationOptionForEmployee(MobilityXConstants.NEW_TRANSFER_ASSIGNMENT);
		_softAssert.assertTrue(_mxAuthorizationPage.verifyAuthFormTitle(),
				MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.TITLE + MobilityXConstants.NOT_EXIST);
		_mxAuthorizationPage.selectAuthFormTemplate(MobilityXConstants.DEFAULT_AUTH_FORM);
		MobilityX_AuthorizationData authorizationData = FileReaderManager.getInstance().getJsonReader()
				.getDataByModuleName("Authorization");
		_mxAuthorizationPage.fillAuthFormBasedOnTemplate(authorizationData, MobilityXConstants.DEFAULT_AUTH_FORM);
		_mxAuthorizationPage.submitToAires();
		Assert.assertTrue(_mxAuthorizationPage.verifySuccessDialogDisplayed(),
				MobilityXConstants.SUCCESS_DIALOG + MobilityXConstants.IS_NOT_DISPLAYED);
		String mxFileID = _myloJourneyPage.getFileIDFromDBByTransfereeName(
				CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT),
				CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT));
		MyloNewFileUtil.setMxfileID(mxFileID);
	}

	/**
	 * Log into Mylo application and search the file created through MobilityX
	 * application
	 * 
	 * @param arg1
	 * @param arg2
	 * @throws InterruptedException
	 */
	@Given("^\"([^\"]*)\" popup is not displayed after he searched the same file on MYLO application logged in with user type \"([^\"]*)\"$")
	public void popup_is_not_displayed_after_he_searched_the_same_file_on_MYLO_application_logged_in_with_user_type(
			String arg1, String arg2) throws InterruptedException {
		_testContext.getWebDriverManager().getDriver().navigate().to(_myloEnvtDetails.details.myloURL);
		_loginPage.openApplication();
		_loginPage.enterUserEmailAndPasswordForMylo(_myloEnvtDetails.details.myloUserWithResources,
				_myloEnvtDetails.details.myloPassword);
		_loginPage.clickSignIn();
		_softAssert.assertTrue(_myloDashboardPage.verifyUserName(_myloEnvtDetails.details.myloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						_myloEnvtDetails.details.myloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, MyloNewFileUtil.getMxfileID());
		_myloDashboardPage.clickExecuteButton();
		Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage(), MessageFormat
				.format(MYLOConstants.VERIFIED_NOT_NAVIGATED_TO_PAGE, CoreConstants.FAIL,MYLOConstants.JOURNEY));
		_myloDashboardPage.changeFileStatus(MYLOConstants.CANCEL_BUTTON);
	}

	@When("^he tries to search newly created file on MYLO application with different transferee name$")
	public void he_tries_to_search_newly_created_file_on_MYLO_application_with_different_transferee_name() {
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.NEW_FILE_BUTTON);
		_myloNewFileSection.createNewFileByClientIDAndTName(MYLOConstants.RANDOM_STRING,
				MYLOConstants.AUTOMATION_CLIENT_ID, MYLOConstants.RANDOM_STRING);
	}

	@Then("^he should be navigated to mylo journey summary page with \"([^\"]*)\" popup not being displayed$")
	public void he_should_be_navigated_to_mylo_journey_summary_page_with_popup_not_being_displayed(String arg1) {
		Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage(), MessageFormat
				.format(MYLOConstants.VERIFIED_NOT_NAVIGATED_TO_PAGE, CoreConstants.FAIL, MYLOConstants.JOURNEY));
		_myloDashboardPage.changeFileStatus(MYLOConstants.CANCEL_BUTTON);
		_softAssert.assertAll();
	}

	/**
	 * Prerequisite: Log into MobilityX application with client 49226 user Create
	 * New Assignment of existing transferee name & Submit Authorization in
	 * MobilityX application
	 * 
	 * @throws InterruptedException
	 */
	@Given("^he has submitted a new Authorization for a newly created file with existing transferee name on MobilityX application$")
	public void he_has_submitted_a_new_Authorization_for_a_newly_created_file_with_existing_transferee_name_on_MobilityX_application()
			throws InterruptedException {
		_mxLoginPage.openApplication();
		_mxLoginPage.enterUsernameAndPasswordForMobilityX(_myloEnvtDetails.details.mxClientUserName,
				_myloEnvtDetails.details.mxClientPassword);
		_mxLoginPage.clickSignIn();
		_mxLoginPage.handle_Cookie_AfterLogin();
		_softAssert.assertTrue(_mxLoginPage.verifyUserlogin(_myloEnvtDetails.details.mxClientUserProfileName),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FIRST_AND_LAST_NAME, CoreConstants.FAIL,
						_myloEnvtDetails.details.mxClientUserProfileName, MobilityXConstants.HOME_PAGE));
		_mxDashboardHomePage.enterEmpFirstAndLastNameForNewAuthorization(
				_myloEnvtDetails.details.transfereeName.split(" ")[0],
				_myloEnvtDetails.details.transfereeName.split(" ")[1], MYLOConstants.VALUE);
		_mxAuthorizationPage.selectOptionForSimilarEmployees(MobilityXConstants.NO_THIS_IS_DIFFERENT_EMPLOYEE);
		_mxDashboardHomePage.selectAuthorizationOptionForEmployee(MobilityXConstants.NEW_TRANSFER_ASSIGNMENT);
		_softAssert.assertTrue(_mxAuthorizationPage.verifyAuthFormTitle(),
				MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.TITLE + MobilityXConstants.NOT_EXIST);
		_mxAuthorizationPage.selectAuthFormTemplate(MobilityXConstants.DEFAULT_AUTH_FORM);
		MobilityX_AuthorizationData authorizationData = FileReaderManager.getInstance().getJsonReader()
				.getDataByModuleName("Authorization");
		_mxAuthorizationPage.fillAuthFormBasedOnTemplate(authorizationData, MobilityXConstants.DEFAULT_AUTH_FORM);
		_mxAuthorizationPage.submitToAires();
		Assert.assertTrue(_mxAuthorizationPage.verifySuccessDialogDisplayed(),
				MobilityXConstants.SUCCESS_DIALOG + MobilityXConstants.IS_NOT_DISPLAYED);
		String mxFileID = _myloJourneyPage.getFileIDFromDBByTransfereeName(
				_myloEnvtDetails.details.transfereeName.split(" ")[0],
				_myloEnvtDetails.details.transfereeName.split(" ")[1]);
		MyloNewFileUtil.setMxfileID(mxFileID);
	}

	@Given("^\"([^\"]*)\" popup is displayed with below fields after he searched the same file on MYLO application logged in for user type \"([^\"]*)\"$")
	public void popup_is_displayed_with_below_fields_after_he_searched_the_same_file_on_MYLO_application_logged_in_for_user_type(
			String popUpName, String userType, DataTable table) throws InterruptedException {
		_testContext.getWebDriverManager().getDriver().navigate().to(_myloEnvtDetails.details.myloURL);
		_loginPage.openApplication();
		_loginPage.enterUserEmailAndPasswordForMylo(_myloEnvtDetails.details.myloUserWithResources,
				_myloEnvtDetails.details.myloPassword);
		_loginPage.clickSignIn();
		_softAssert.assertTrue(_myloDashboardPage.verifyUserName(_myloEnvtDetails.details.myloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						_myloEnvtDetails.details.myloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, MyloNewFileUtil.getMxfileID());
		_myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		_softAssert.assertTrue(
				_myloJourneyPage.verifySectionHeader(popUpName, MYLOConstants.LINK_MOBILITY_JOURNEY_HEADER),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY_HEADER, popUpName));
		_softAssert.assertTrue(_linkMobJourneySection.verifyDataIntegrityAlertMsg(),
				CoreConstants.FAILED_TO_VERFY + MYLOConstants.DATA_INTEGRITY_MSG);
		_softAssert.assertTrue(_linkMobJourneySection.verifyLinkPopUpColumnNames(table),
				CoreConstants.FAILED_TO_VERFY + MYLOConstants.LINK_MOBILITY_JOURNEY_COLUMN_NAMES);
		_softAssert.assertTrue(
				_linkMobJourneySection.verifyAllMatchFieldValuesOnLinkPopUp(MYLOConstants.TRANSFEREE_NAME,
						_myloEnvtDetails.details.transfereeName.split(" ")[1] + "," + MYLOConstants.SPACE
								+ _myloEnvtDetails.details.transfereeName.split(" ")[0]),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_NAME, MYLOConstants.LINK_MOBILITY_JOURNEY));
	}

	@Then("^he should be able to see below information after clicking on \"([^\"]*)\" dropdown$")
	public void he_should_be_able_to_see_below_information_after_clicking_on_dropdown(String btnName, DataTable arg2) {
		_linkMobJourneySection.clickFilesAttachedToTransferee(btnName);
		_softAssert.assertTrue(_linkMobJourneySection.verifyFilesAttachedToTransfereeInLinkSection(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.FILES_ATTACHED_TRANSFEREE, MYLOConstants.LINK_MOBILITY_JOURNEY));
		_myloJourneyPage.closePopUp();
		_myloDashboardPage.changeFileStatus(MYLOConstants.CANCEL_BUTTON);
	}

	@When("^he tries to search same file on Mylo application after relogin with user type \"([^\"]*)\"$")
	public void he_tries_to_search_same_file_on_Mylo_application_after_relogin_with_user_type(String userType) {
		_loginPage.loginWithUser(userType);
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, MyloNewFileUtil.getMxfileID());
		_myloDashboardPage.clickExecuteButton();
	}

	@Then("^\"([^\"]*)\" popup should not appear for userType \"([^\"]*)\" on Mylo application$")
	public void popup_should_not_appear_for_userType_on_Mylo_application(String arg1, String arg2) {
		Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
	}

	@Then("^he should be navigated to the Mylo journey summary page of the searched file$")
	public void he_should_be_navigated_to_the_Mylo_journey_summary_page_of_the_searched_file() {
		Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage(), MessageFormat
				.format(MYLOConstants.VERIFIED_NOT_NAVIGATED_TO_PAGE, CoreConstants.FAIL, MYLOConstants.JOURNEY));
		_myloDashboardPage.changeFileStatus(MYLOConstants.CANCEL_BUTTON);
		_softAssert.assertAll();
	}

	/**
	 * Prerequisite: Log into Mylo application with mxssodev5 user Create New
	 * Assignment of existing transferee name on Mylo application
	 * 
	 * @param arg1
	 * @throws InterruptedException
	 */
	@Given("^he has created a new file with existing transferee name on Mylo application logged in with user type \"([^\"]*)\"$")
	public void he_has_created_a_new_file_with_existing_transferee_name_on_Mylo_application_logged_in_with_user_type(
			String arg1) throws InterruptedException {
		_loginPage.openApplication();
		_loginPage.enterUserEmailAndPasswordForMylo(_myloEnvtDetails.details.myloUserWithResources,
				_myloEnvtDetails.details.myloPassword);
		_loginPage.clickSignIn();
		_softAssert.assertTrue(_myloDashboardPage.verifyUserName(_myloEnvtDetails.details.myloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						_myloEnvtDetails.details.myloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.NEW_FILE_BUTTON);
		_myloNewFileSection.createNewFileByClientIDAndTName(_myloEnvtDetails.details.transfereeName,
				MYLOConstants.AUTOMATION_CLIENT_ID, MYLOConstants.VALUE);
	}

	@When("^he clicks on \"([^\"]*)\" after verifying the \"([^\"]*)\" popup displayed with below fields$")
	public void he_clicks_on_after_verifying_the_popup_displayed_with_below_fields(String btnName, String popUpName,
			DataTable table) {
		Assert.assertTrue(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		_softAssert.assertTrue(
				_myloJourneyPage.verifySectionHeader(popUpName, MYLOConstants.LINK_MOBILITY_JOURNEY_HEADER),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY_HEADER, popUpName));
		_softAssert.assertTrue(_linkMobJourneySection.verifyDataIntegrityAlertMsg(),
				CoreConstants.FAILED_TO_VERFY + MYLOConstants.DATA_INTEGRITY_MSG);
		_softAssert.assertTrue(
				_linkMobJourneySection.verifyAllMatchFieldValuesOnLinkPopUp(MYLOConstants.TRANSFEREE_NAME,
						_myloEnvtDetails.details.transfereeName.split(" ")[1] + "," + MYLOConstants.SPACE
								+ _myloEnvtDetails.details.transfereeName.split(" ")[0]),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_NAME, MYLOConstants.LINK_MOBILITY_JOURNEY));
		_linkMobJourneySection.clickButtonsOnLinkMobJourneySection(btnName, popUpName);
	}

	@Then("^he should be navigated to mylo journey summary page with \"([^\"]*)\" pop up being closed$")
	public void he_should_be_navigated_to_mylo_journey_summary_page_with_pop_up_being_closed(String popUpName) {
		Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage(), MessageFormat
				.format(MYLOConstants.VERIFIED_NOT_NAVIGATED_TO_PAGE, CoreConstants.FAIL, MYLOConstants.JOURNEY));
	}

	@Then("^\"([^\"]*)\" popup should be displayed after he clicks on \"([^\"]*)\" button on Mylo journey summary page$")
	public void popup_should_be_displayed_after_he_clicks_on_button_on_Mylo_journey_summary_page(String popUpName,
			String btnName) {
		_linkMobJourneySection.clickFooterSectionJourneyPage(btnName);
		Assert.assertTrue(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		_softAssert.assertTrue(_linkMobJourneySection.verifyDataIntegrityAlertMsg(),
				CoreConstants.FAILED_TO_VERFY + MYLOConstants.DATA_INTEGRITY_MSG);
		_softAssert.assertTrue(
				_linkMobJourneySection.verifyAllMatchFieldValuesOnLinkPopUp(MYLOConstants.TRANSFEREE_NAME,
						_myloEnvtDetails.details.transfereeName.split(" ")[1] + "," + MYLOConstants.SPACE
								+ _myloEnvtDetails.details.transfereeName.split(" ")[0]),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_NAME, MYLOConstants.LINK_MOBILITY_JOURNEY));
		_linkMobJourneySection.clickButtonsOnLinkMobJourneySection(MYLOConstants.REMIND_ME_LATER, popUpName);
	}

	@Then("^he should be navigated to mylo journey summary page with \"([^\"]*)\" popup not being displayed after he searched the same file on MYLO application logged in with user type \"([^\"]*)\"$")
	public void he_should_be_navigated_to_mylo_journey_summary_page_with_popup_not_being_displayed_after_he_searched_the_same_file_on_MYLO_application_logged_in_with_user_type(
			String popUpName, String userType) {
		_loginPage.loginWithUser(userType);
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, MyloNewFileUtil.getFileID());
		_myloDashboardPage.clickExecuteButton();
		Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage(), MessageFormat
				.format(MYLOConstants.VERIFIED_NOT_NAVIGATED_TO_PAGE, CoreConstants.FAIL, MYLOConstants.JOURNEY));
		_softAssert.assertAll();
	}

	@Given("^he is on \"([^\"]*)\" popup for an existing file with same transferee name on Mylo application logged in with user type \"([^\"]*)\"$")
	public void he_is_on_popup_for_an_existing_file_with_same_transferee_name_on_Mylo_application_logged_in_with_user_type(
			String arg1, String arg2) throws InterruptedException {
		_loginPage.openApplication();
		_loginPage.enterUserEmailAndPasswordForMylo(_myloEnvtDetails.details.myloUserWithResources,
				_myloEnvtDetails.details.myloPassword);
		_loginPage.clickSignIn();
		_softAssert.assertTrue(_myloDashboardPage.verifyUserName(_myloEnvtDetails.details.myloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						_myloEnvtDetails.details.myloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, MyloNewFileUtil.getFileID());
		_myloDashboardPage.clickExecuteButton();
	}

	@Given("^\"([^\"]*)\" pop up is displayed after he clicks on \"([^\"]*)\" button on \"([^\"]*)\" popup$")
	public void pop_up_is_displayed_after_he_clicks_on_button_on_popup(String popUpName, String btnName,
			String linkPopUp) {
		Assert.assertTrue(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		_softAssert.assertTrue(_linkMobJourneySection.verifyDataIntegrityAlertMsg(),
				CoreConstants.FAILED_TO_VERFY + MYLOConstants.DATA_INTEGRITY_MSG);
		_softAssert.assertTrue(
				_linkMobJourneySection.verifyAllMatchFieldValuesOnLinkPopUp(MYLOConstants.TRANSFEREE_NAME,
						_myloEnvtDetails.details.transfereeName.split(" ")[1] + "," + MYLOConstants.SPACE
								+ _myloEnvtDetails.details.transfereeName.split(" ")[0]),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_NAME, MYLOConstants.LINK_MOBILITY_JOURNEY));
		Assert.assertFalse(
				_linkMobJourneySection.verifyLinkMobJourneyButtonEnabilityStatus(btnName, MYLOConstants.DISABLE,
						MYLOConstants.LINK_MOBILITY_JOURNEY),
				MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.FAIL, btnName,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		_linkFileID = _linkMobJourneySection.selectRandomTransfereeDetail();
		Assert.assertTrue(
				_linkMobJourneySection.verifyLinkMobJourneyButtonEnabilityStatus(btnName, MYLOConstants.ENABLE,
						MYLOConstants.LINK_MOBILITY_JOURNEY),
				MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.FAIL, btnName,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		_linkMobJourneySection.clickButtonsOnLinkMobJourneySection(btnName, linkPopUp);
		_softAssert.assertTrue(_myloJourneyPage.verifySectionHeader(linkPopUp, popUpName), MessageFormat
				.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL, popUpName, linkPopUp));
	}

	@Given("^file is not linked to that journey with \"([^\"]*)\" popup being closed after he clicks on \"([^\"]*)\" button$")
	public void file_is_not_linked_to_that_journey_with_popup_being_closed_after_he_clicks_on_button(String popUpName,
			String btnName) {
		Assert.assertFalse(
				_linkMobJourneySection.verifyLinkMobJourneyButtonEnabilityStatus(MYLOConstants.LINK,
						MYLOConstants.DISABLE, MYLOConstants.LINK_EXISTING_JOURNEY),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, MYLOConstants.LINK,
						MYLOConstants.LINK_EXISTING_JOURNEY, MYLOConstants.JOURNEY));
		_linkMobJourneySection.clickButtonsOnLinkMobJourneySection(btnName, MYLOConstants.LINK_EXISTING_JOURNEY);
		Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage(), MessageFormat
				.format(MYLOConstants.VERIFIED_NOT_NAVIGATED_TO_PAGE, CoreConstants.FAIL, MYLOConstants.JOURNEY));
		Assert.assertTrue(_linkMobJourneySection.verifyJourneyBtnText(MYLOConstants.LINK_JOURNEY));
	}

	@When("^he clicks on \"([^\"]*)\" button after clicking on \"([^\"]*)\" button on \"([^\"]*)\" popup while searching the same file again$")
	public void he_clicks_on_button_after_clicking_on_button_on_popup_while_searching_the_same_file_again(
			String btnName, String lnkBtnName, String popUpName) {
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, MyloNewFileUtil.getFileID());
		_myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		_softAssert.assertTrue(_linkMobJourneySection.verifyDataIntegrityAlertMsg(),
				CoreConstants.FAILED_TO_VERFY + MYLOConstants.DATA_INTEGRITY_MSG);
		_softAssert.assertTrue(
				_linkMobJourneySection.verifyAllMatchFieldValuesOnLinkPopUp(MYLOConstants.TRANSFEREE_NAME,
						_myloEnvtDetails.details.transfereeName.split(" ")[1] + "," + MYLOConstants.SPACE
								+ _myloEnvtDetails.details.transfereeName.split(" ")[0]),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_NAME, MYLOConstants.LINK_MOBILITY_JOURNEY));
		_linkFileID = _linkMobJourneySection.selectRandomTransfereeDetail();
		_linkMobJourneySection.clickButtonsOnLinkMobJourneySection(lnkBtnName, popUpName);
		Assert.assertFalse(
				_linkMobJourneySection.verifyLinkMobJourneyButtonEnabilityStatus(btnName, MYLOConstants.DISABLE,
						MYLOConstants.LINK_EXISTING_JOURNEY),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, btnName,
						MYLOConstants.LINK_EXISTING_JOURNEY, MYLOConstants.JOURNEY));
		_journeyDetails = _linkMobJourneySection.selectRandomJourneyCard();
		Assert.assertTrue(
				_linkMobJourneySection.verifyLinkMobJourneyButtonEnabilityStatus(btnName, MYLOConstants.ENABLE,
						MYLOConstants.LINK_EXISTING_JOURNEY),
				MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.FAIL, btnName,
						MYLOConstants.LINK_EXISTING_JOURNEY, MYLOConstants.JOURNEY));
		_linkMobJourneySection.clickButtonsOnLinkMobJourneySection(btnName, MYLOConstants.LINK_EXISTING_JOURNEY);
		_linkMobJourneySection.clickOptionForLinkDifferentJourneyType(MYLOConstants.YES_BUTTON);
	}

	@Then("^file should be successfully linked to existing journey with \"([^\"]*)\" pop up being closed$")
	public void file_should_be_successfully_linked_to_existing_journey_with_pop_up_being_closed(String popUpName) {
		Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage(), MessageFormat
				.format(MYLOConstants.VERIFIED_NOT_NAVIGATED_TO_PAGE, CoreConstants.FAIL, MYLOConstants.JOURNEY));
		Assert.assertTrue(_linkMobJourneySection.verifyLinkedAssignmentFileID(_linkFileID),
				MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL, _linkFileID,
						MYLOConstants.FILE_ID, MYLOConstants.LINK_JOURNEY, MYLOConstants.JOURNEY));
		Assert.assertTrue(_linkMobJourneySection.verifyLinkedAssignmentJourneyInfo(_linkFileID, _journeyDetails),
				MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL, _journeyDetails,
						MYLOConstants.LINKED_ASSIGNMENT_JOURNEY_INFO, MYLOConstants.LINK_JOURNEY,
						MYLOConstants.JOURNEY));
		_myloJourneyPage.closePopUp();
		Assert.assertTrue(_linkMobJourneySection.verifyJourneyBtnText(MYLOConstants.OTHER_JOURNEYS),
				MessageFormat.format(MYLOConstants.VERIFY_NOT_UPDATED_TEXT, CoreConstants.FAIL,
						MYLOConstants.LINK_JOURNEY, MYLOConstants.OTHER_JOURNEYS, MYLOConstants.PURPLE_BUBBLE_SECTION));
		_linkMobJourneySection.clickLinkJourneyBtn();
		Assert.assertTrue(_linkMobJourneySection.verifyLinkedAssignmentFileID(_linkFileID),
				MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL, _linkFileID,
						MYLOConstants.FILE_ID, MYLOConstants.LINK_JOURNEY, MYLOConstants.JOURNEY));
		Assert.assertTrue(_linkMobJourneySection.verifyLinkedAssignmentJourneyInfo(_linkFileID, _journeyDetails),
				MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL, _journeyDetails,
						MYLOConstants.LINKED_ASSIGNMENT_JOURNEY_INFO, MYLOConstants.LINK_JOURNEY,
						MYLOConstants.JOURNEY));
		_myloJourneyPage.closePopUp();
		_myloDashboardPage.changeFileStatus(MYLOConstants.CANCEL_BUTTON);
	}

	@Given("^file should be successfully linked as a new journey after clicking on \"([^\"]*)\" button on \"([^\"]*)\" popup for newly created file with existing transferee name$")
	public void file_should_be_successfully_linked_as_a_new_journey_after_clicking_on_button_on_popup_for_newly_created_file_with_existing_transferee_name(
			String btnName, String popUpName) {
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.NEW_FILE_BUTTON);
		_myloNewFileSection.createNewFileByClientIDAndTName(_myloEnvtDetails.details.transfereeName,
				MYLOConstants.AUTOMATION_CLIENT_ID, MYLOConstants.VALUE);
		_linkFileID = _linkMobJourneySection.selectRandomTransfereeDetail();
		Assert.assertTrue(
				_linkMobJourneySection.verifyLinkMobJourneyButtonEnabilityStatus(btnName, MYLOConstants.ENABLE,
						MYLOConstants.LINK_MOBILITY_JOURNEY),
				MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.FAIL, btnName,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		_linkMobJourneySection.clickButtonsOnLinkMobJourneySection(btnName, popUpName);
		Assert.assertTrue(_linkMobJourneySection.verifyLinkedAssignmentFileID(_linkFileID),
				MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL, _linkFileID,
						MYLOConstants.FILE_ID, MYLOConstants.LINK_JOURNEY, MYLOConstants.JOURNEY));
		_myloJourneyPage.closePopUp();
		Assert.assertTrue(_linkMobJourneySection.verifyJourneyBtnText(MYLOConstants.OTHER_JOURNEYS),
				MessageFormat.format(MYLOConstants.VERIFY_NOT_UPDATED_TEXT, CoreConstants.FAIL,
						MYLOConstants.LINK_JOURNEY, MYLOConstants.OTHER_JOURNEYS, MYLOConstants.PURPLE_BUBBLE_SECTION));
		_linkMobJourneySection.clickLinkJourneyBtn();
		Assert.assertTrue(_linkMobJourneySection.verifyLinkedAssignmentFileID(_linkFileID),
				MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL, _linkFileID,
						MYLOConstants.FILE_ID, MYLOConstants.LINK_JOURNEY, MYLOConstants.JOURNEY));
		_myloJourneyPage.closePopUp();
		_myloDashboardPage.changeFileStatus(MYLOConstants.CANCEL_BUTTON);
		_softAssert.assertAll();
	}

	@Given("^he has submitted a new Authorization for a newly created file with same email on MobilityX application$")
	public void he_has_submitted_a_new_Authorization_for_a_newly_created_file_with_same_email_on_MobilityX_application() {
		_mxLoginPage.openApplication();
		_mxLoginPage.enterUsernameAndPasswordForMobilityX(_myloEnvtDetails.details.mxClientUserName,
				_myloEnvtDetails.details.mxClientPassword);
		_mxLoginPage.clickSignIn();
		_mxLoginPage.handle_Cookie_AfterLogin();
		_softAssert.assertTrue(_mxLoginPage.verifyUserlogin(_myloEnvtDetails.details.mxClientUserProfileName),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FIRST_AND_LAST_NAME, CoreConstants.FAIL,
						_myloEnvtDetails.details.mxClientUserProfileName, MobilityXConstants.HOME_PAGE));
		_mxDashboardHomePage.enterEmpFirstAndLastNameForNewAuthorization(MYLOConstants.CUSTOM_FIELD_LENGTH,
				MYLOConstants.CUSTOM_FIELD_LENGTH, MYLOConstants.RANDOM_STRING);
		_mxDashboardHomePage.selectAuthorizationOptionForEmployee(MobilityXConstants.NEW_TRANSFER_ASSIGNMENT);
		_softAssert.assertTrue(_mxAuthorizationPage.verifyAuthFormTitle(),
				MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.TITLE + MobilityXConstants.NOT_EXIST);
		_mxAuthorizationPage.selectAuthFormTemplate(MobilityXConstants.DEFAULT_AUTH_FORM);
		MobilityX_AuthorizationData authorizationData = FileReaderManager.getInstance().getJsonReader()
				.getDataByModuleName("Authorization");
		_mxAuthorizationPage.fillAuthFormBasedOnTemplate(authorizationData, MobilityXConstants.DEFAULT_AUTH_FORM);
		_mxAuthorizationPage.addTransfereeEmail(MYLOConstants.AUTOMATION_EMAIL);
		_mxAuthorizationPage.submitToAires();
		Assert.assertTrue(_mxAuthorizationPage.verifySuccessDialogDisplayed(),
				MobilityXConstants.SUCCESS_DIALOG + MobilityXConstants.IS_NOT_DISPLAYED);
		String mxFileID = _myloJourneyPage.getFileIDFromDBByTransfereeName(
				CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT),
				CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT));
		MyloNewFileUtil.setMxfileID(mxFileID);
	}

	@Given("^\"([^\"]*)\" popup is displayed for same email after he searched the same file on MYLO application logged in with user type \"([^\"]*)\"$")
	public void popup_is_displayed_for_same_email_after_he_searched_the_same_file_on_MYLO_application_logged_in_with_user_type(
			String popUpName, String userType) throws InterruptedException {
		_testContext.getWebDriverManager().getDriver().navigate().to(_myloEnvtDetails.details.myloURL);
		_loginPage.openApplication();
		_loginPage.enterUserEmailAndPasswordForMylo(_myloEnvtDetails.details.myloUserWithResources,
				_myloEnvtDetails.details.myloPassword);
		_loginPage.clickSignIn();
		_softAssert.assertTrue(_myloDashboardPage.verifyUserName(_myloEnvtDetails.details.myloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						_myloEnvtDetails.details.myloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, MyloNewFileUtil.getMxfileID());
		_myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		_softAssert.assertTrue(
				_myloJourneyPage.verifySectionHeader(popUpName, MYLOConstants.LINK_MOBILITY_JOURNEY_HEADER),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY_HEADER, popUpName));
		_softAssert.assertTrue(_linkMobJourneySection.verifyDataIntegrityAlertMsg(),
				CoreConstants.FAILED_TO_VERFY + MYLOConstants.DATA_INTEGRITY_MSG);
		_softAssert.assertTrue(
				_linkMobJourneySection.verifyAllMatchFieldValuesOnLinkPopUp(MYLOConstants.EMAIL,
						MYLOConstants.AUTOMATION_EMAIL),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.EMAIL, MYLOConstants.LINK_MOBILITY_JOURNEY));
		_myloJourneyPage.closePopUp();
		_myloDashboardPage.changeFileStatus(MYLOConstants.CANCEL_BUTTON);
	}

	@When("^he tries to search newly created file on Mylo application with same email$")
	public void he_tries_to_search_newly_created_file_on_Mylo_application_with_same_email() {
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.NEW_FILE_BUTTON);
		_myloNewFileSection.createNewFileByClientIDAndTName(MYLOConstants.RANDOM_STRING,
				MYLOConstants.AUTOMATION_CLIENT_ID, MYLOConstants.RANDOM_STRING);
		_myloTransfereeSection.addTransfereeEmailDetails(MYLOConstants.AUTOMATION_EMAIL);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, MyloNewFileUtil.getFileID());
		_myloDashboardPage.clickExecuteButton();
	}

	@Then("^\"([^\"]*)\" popup should get displayed with header as \"([^\"]*)\"$")
	public void popup_should_get_displayed_with_header_as(String popUpName, String popUpHeader) {
		Assert.assertTrue(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		_softAssert.assertTrue(
				_myloJourneyPage.verifySectionHeader(popUpName, MYLOConstants.LINK_MOBILITY_JOURNEY_HEADER),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL, popUpHeader,
						popUpName));
		_softAssert.assertTrue(_linkMobJourneySection.verifyDataIntegrityAlertMsg(),
				CoreConstants.FAILED_TO_VERFY + MYLOConstants.DATA_INTEGRITY_MSG);
		_softAssert.assertTrue(
				_linkMobJourneySection.verifyAllMatchFieldValuesOnLinkPopUp(MYLOConstants.EMAIL,
						MYLOConstants.AUTOMATION_EMAIL),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.EMAIL, MYLOConstants.LINK_MOBILITY_JOURNEY));
	}

	@Given("^file should not be successfully linked to that journey on clicking \"([^\"]*)\" on \"([^\"]*)\" popup$")
	public void file_should_not_be_successfully_linked_to_that_journey_on_clicking_on_popup(String btnName,
			String popUpName) {
		_linkMobJourneySection.clickButtonsOnLinkMobJourneySection(btnName, popUpName);
		Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.LINK_MOBILITY_JOURNEY, MYLOConstants.JOURNEY));
		Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage(), MessageFormat
				.format(MYLOConstants.VERIFIED_NOT_NAVIGATED_TO_PAGE, CoreConstants.FAIL, MYLOConstants.JOURNEY));
		Assert.assertTrue(_linkMobJourneySection.verifyJourneyBtnText(MYLOConstants.LINK_JOURNEY),
				MessageFormat.format(MYLOConstants.VERIFY_NOT_UPDATED_TEXT, CoreConstants.FAIL,
						MYLOConstants.LINK_JOURNEY, MYLOConstants.LINK_JOURNEY, MYLOConstants.PURPLE_BUBBLE_SECTION));
		_myloDashboardPage.changeFileStatus(MYLOConstants.CANCEL_BUTTON);
	}
}