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
import com.aires.pages.mylo.MyloJourneyPage_ClientContactSection;
import com.aires.pages.mylo.MyloJourneyPage_CreateNewFileSection;
import com.aires.pages.mylo.MyloJourneyPage_LinkMobilityJourneySection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData;
import com.aires.testdatatypes.mylo.MyloEnvironmentDetails;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.aires.testdatatypes.pdt.PDT_LoginInfo;
import com.aires.utilities.CustomSoftAssert;
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloLinkMobilityJourney_Steps {
	private TestContext _testContext;
	private Mylo_LoginPage _loginPage;
	private Mylo_DashboardHomePage _myloDashboardPage;
	private Mylo_JourneyPage _myloJourneyPage;
	private MyloJourneyPage_ClientContactSection _myloJourneyPageClientContactSection;
	private MyloJourneyPage_CreateNewFileSection _myloNewFileSection;
	private CustomSoftAssert _softAssert;
	private MobilityX_LoginPage _mxLoginPage;
	private MobilityX_DashboardHomePage _mxDashboardHomePage;
	private MobilityX_AuthorizationPage _mxAuthorizationPage;
	private MyloJourneyPage_LinkMobilityJourneySection _linkMobJourneySection;

	private Mylo_LoginData _loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	// String _environment=System.getProperty("envt").toLowerCase();
	String _environment = CoreFunctions.getPropertyFromConfig("envt").toLowerCase();

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);
	private MyloEnvironmentDetails _myloEnvtDetails = FileReaderManager.getInstance().getMyloJsonReader()
			.getMyloLoginInfoByEnvt(_environment);

	public MyloLinkMobilityJourney_Steps(TestContext context) {
		_testContext = context;
		_loginPage = _testContext.getMyloPageObjectManager().getLoginPage();
		_myloDashboardPage = _testContext.getMyloPageObjectManager().getDashboardHomePage();
		_myloJourneyPage = _testContext.getMyloPageObjectManager().getJourneyPage();
		_myloJourneyPageClientContactSection = _testContext.getMyloPageObjectManager().getJourneyClientContact();
		_myloNewFileSection = _testContext.getMyloPageObjectManager().getJourneyPageCreateNewFileSection();
		_softAssert = _testContext.getSoftAssertObject();
		_mxLoginPage = _testContext.getMobilityXPageObjectManager().getLoginPage();
		_mxDashboardHomePage = _testContext.getMobilityXPageObjectManager().getDashboardHomePage();
		_mxAuthorizationPage = _testContext.getMobilityXPageObjectManager().getAuthorizationPage();
		_linkMobJourneySection = _testContext.getMyloPageObjectManager().getLinkMobJourneySection();
	}

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
		_mxAuthorizationPage.selectOptionForSimilarEmployees("No, this is a different employee");
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
		System.out.println("Mobility X File ID is : " + mxFileID);
		MyloNewFileUtil.setMxfileID(mxFileID);

	}

	@Given("^\"([^\"]*)\" popup is displayed with header as \"([^\"]*)\" after he searched the same file on MYLO application logged in with user type \"([^\"]*)\"$")
	public void popup_is_displayed_with_header_as_after_he_searched_the_same_file_on_MYLO_application_logged_in_with_user_type(
			String popUpName, String popUpHeader, String userType) throws InterruptedException {
		_testContext.getWebDriverManager().getDriver().navigate().to(_myloEnvtDetails.details.myloURL);
		_loginPage.openApplication();
		_loginPage.enterUserEmailAndPasswordForMylo(_myloEnvtDetails.details.myloUserWithResources,
				_myloEnvtDetails.details.myloPassword);
		_loginPage.clickSignIn();
		_softAssert.assertTrue(_myloDashboardPage.verifyUserName(_myloEnvtDetails.details.myloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						loginData.MyloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, MyloNewFileUtil.getMxfileID());
		_myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist());
		_softAssert.assertTrue(_myloJourneyPage.verifySectionHeader(popUpName, popUpHeader));
		_softAssert.assertTrue(_linkMobJourneySection.verifyDataIntegrityAlertMsg());
		_softAssert.assertTrue(_linkMobJourneySection
				.verifyAllMatchedTransfereeNames(_myloEnvtDetails.details.transfereeName.split(" ")[1] + ","
						+ MYLOConstants.SPACE + _myloEnvtDetails.details.transfereeName.split(" ")[0]));
		_myloJourneyPage.closePopUp();

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
		Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist());
	}

	@Then("^he should be navigated to the Mylo journey summary page of the searched file$")
	public void he_should_be_navigated_to_the_Mylo_journey_summary_page_of_the_searched_file() {
		 Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage());
		//_myloJourneyPage.closePopUp();
		_myloDashboardPage.changeFileStatus(MYLOConstants.CANCEL_BUTTON);
		_softAssert.assertAll();
	}

	@Given("^he has created a new file with existing transferee name on Mylo application logged in with user type \"([^\"]*)\"$")
	public void he_has_created_a_new_file_with_existing_transferee_name_on_Mylo_application_logged_in_with_user_type(
			String arg1) throws InterruptedException {
		_loginPage.openApplication();
		_loginPage.enterUserEmailAndPasswordForMylo(_myloEnvtDetails.details.myloUserWithResources,
				_myloEnvtDetails.details.myloPassword);
		_loginPage.clickSignIn();
		_softAssert.assertTrue(_myloDashboardPage.verifyUserName(_myloEnvtDetails.details.myloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						loginData.MyloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.NEW_FILE_BUTTON);
		_myloNewFileSection.createNewFileByClientIDAndTName(_myloEnvtDetails.details.transfereeName,
				MYLOConstants.AUTOMATION_CLIENT_ID);
	}

	@Given("^\"([^\"]*)\" popup is displayed with header as \"([^\"]*)\"$")
	public void popup_is_displayed_with_header_as(String popUpName, String popUpHeader) {
		Assert.assertTrue(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist());
		_softAssert.assertTrue(_myloJourneyPage.verifySectionHeader(popUpName, popUpHeader));
		_softAssert.assertTrue(_linkMobJourneySection.verifyDataIntegrityAlertMsg());
		_softAssert.assertTrue(_linkMobJourneySection
				.verifyAllMatchedTransfereeNames(_myloEnvtDetails.details.transfereeName.split(" ")[1] + ","
						+ MYLOConstants.SPACE + _myloEnvtDetails.details.transfereeName.split(" ")[0]));
	}

	@When("^he clicks on \"([^\"]*)\" on \"([^\"]*)\" popup after searching the same file$")
	public void he_clicks_on_on_popup_after_searching_the_same_file(String btnName, String popUpName) {
		_linkMobJourneySection.clickButtonsOnLinkMobJourneySection(btnName, popUpName);
	}

	@Then("^he should be navigated to mylo journey summary page with \"([^\"]*)\" pop up being closed$")
	public void he_should_be_navigated_to_mylo_journey_summary_page_with_pop_up_being_closed(String popUpName) {
		Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist());
		Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage());
	}

	@Then("^\"([^\"]*)\" popup should be displayed after he clicks on \"([^\"]*)\" button on Mylo journey summary page$")
	public void popup_should_be_displayed_after_he_clicks_on_button_on_Mylo_journey_summary_page(String popUpName,
			String btnName) {
		_linkMobJourneySection.clickOnFooterSectionBtns(btnName);
		Assert.assertTrue(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist());
		_softAssert.assertTrue(_linkMobJourneySection.verifyDataIntegrityAlertMsg());
		_softAssert.assertTrue(_linkMobJourneySection
				.verifyAllMatchedTransfereeNames(_myloEnvtDetails.details.transfereeName.split(" ")[1] + ","
						+ MYLOConstants.SPACE + _myloEnvtDetails.details.transfereeName.split(" ")[0]));
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
		// Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist());
		// Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage());
		_myloJourneyPage.closePopUp();
		_myloDashboardPage.changeFileStatus(MYLOConstants.CANCEL_BUTTON);
		_softAssert.assertAll();
	}

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
		System.out.println("Mobility X File ID is : " + mxFileID);
		MyloNewFileUtil.setMxfileID(mxFileID);
	}

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
						loginData.MyloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, MyloNewFileUtil.getMxfileID());
		_myloDashboardPage.clickExecuteButton();
		Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist());
		Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage());
		_myloDashboardPage.changeFileStatus(MYLOConstants.CANCEL_BUTTON);
	}

	@When("^he tries to search newly created file on MYLO application with different transferee name$")
	public void he_tries_to_search_newly_created_file_on_MYLO_application_with_different_transferee_name() {
		_myloDashboardPage.createNewFileIfNotExists(MYLOConstants.AUTOMATION_CLIENT_ID, _myloNewFileSection);
	}

	@Then("^he should be navigated to mylo journey summary page with \"([^\"]*)\" popup not being displayed$")
	public void he_should_be_navigated_to_mylo_journey_summary_page_with_popup_not_being_displayed(String arg1) {
		Assert.assertFalse(_linkMobJourneySection.isLinkMobilityJourneyPopUpExist());
		Assert.assertTrue(_linkMobJourneySection.isNavigatedToSummaryPage());
		_myloDashboardPage.changeFileStatus(MYLOConstants.CANCEL_BUTTON);
		_softAssert.assertAll();
	}
	
	@Given("^\"([^\"]*)\" pop up is displayed after he clicks on \"([^\"]*)\" button on \"([^\"]*)\" popup$")
	public void pop_up_is_displayed_after_he_clicks_on_button_on_popup(String popUpName, String btnName, String linkPopUp){
	    
	}

	@Given("^file is not linked to that journey with \"([^\"]*)\" popup being closed after he clicks on \"([^\"]*)\" button$")
	public void file_is_not_linked_to_that_journey_with_popup_being_closed_after_he_clicks_on_button(String popUpName, String btnName) {
	    
	}

	@When("^he clicks on \"([^\"]*)\" button after clicking on \"([^\"]*)\" button on \"([^\"]*)\" popup while searching the same file again$")
	public void he_clicks_on_button_after_clicking_on_button_on_popup_while_searching_the_same_file_again(String btnName, String lnkBtnName, String popUpName) {
	    
	}

	@When("^file should be successfully linked to that journey$")
	public void file_should_be_successfully_linked_to_that_journey() {
	    
	}
}
