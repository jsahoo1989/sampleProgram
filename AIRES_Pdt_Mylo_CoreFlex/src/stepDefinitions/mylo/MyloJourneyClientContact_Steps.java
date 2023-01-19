package stepDefinitions.mylo;

import java.text.MessageFormat;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_ClientContactSection;
import com.aires.pages.mylo.MyloJourneyPage_CreateNewFileSection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.aires.utilities.CustomSoftAssert;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyClientContact_Steps {
	private TestContext _testContext;
	private Mylo_LoginPage _loginPage;
	private Mylo_DashboardHomePage _myloDashboardPage;
	private Mylo_JourneyPage _myloJourneyPage;
	private MyloJourneyPage_ClientContactSection _myloJourneyPageClientContactSection;
	private MyloJourneyPage_CreateNewFileSection _myloNewFileSection;
	private CustomSoftAssert _softAssert;

	private Mylo_LoginData _loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloJourneyClientContact_Steps(TestContext context) {
		_testContext = context;
		_loginPage = _testContext.getMyloPageObjectManager().getLoginPage();
		_myloDashboardPage = _testContext.getMyloPageObjectManager().getDashboardHomePage();
		_myloJourneyPage = _testContext.getMyloPageObjectManager().getJourneyPage();
		_myloJourneyPageClientContactSection = _testContext.getMyloPageObjectManager().getJourneyClientContact();
		_myloNewFileSection = _testContext.getMyloPageObjectManager().getJourneyPageCreateNewFileSection();
		_softAssert = _testContext.getSoftAssertObject();
	}

	@Given("^he has logged into the 'Mylo' application with user type \"([^\"]*)\"$")
	public void he_has_logged_into_the_Mylo_application_with_user_type(String arg1) throws InterruptedException {
		_loginPage.openApplication();
		_loginPage.enterUserEmailAndPasswordForMylo(_loginData.MyloUserName, _loginData.MyloPassword);
		_loginPage.clickSignIn();
		_softAssert.assertTrue(_myloDashboardPage.verifyUserName(_loginData.MyloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						_loginData.MyloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	/**
	 * Pre-requisite: Logged into Mylo application with user having resource300096
	 * Search existing File ID having Client contact information
	 * @param sectionName
	 * @param fileStatus
	 * @param fileInfo
	 */
	@Given("^he is on \"([^\"]*)\" section for \"([^\"]*)\" file having \"([^\"]*)\" information on Mylo Journey Summary Page$")
	public void he_is_on_section_for_file_having_information_on_Mylo_Journey_Summary_Page(String sectionName,
			String fileStatus, String fileInfo) {
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = _myloJourneyPage.getClientContactFileIDFromDB(fileStatus);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		_myloDashboardPage.clickExecuteButton();
		_myloJourneyPage.scrollToJourneySection(sectionName, MYLOConstants.JOURNEY);
		_softAssert.assertTrue(
				_myloJourneyPage.verifySectionHeader(sectionName, MYLOConstants.CLIENT_CONTACT + MYLOConstants.COLON),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.CLIENT_CONTACT + MYLOConstants.COLON, MYLOConstants.CLIENT_CONTACT));
	}

	@Given("^\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" buttons of Client Contact section should be enabled for user type \"([^\"]*)\"$")
	public void buttons_of_Client_Contact_section_should_be_enabled_for_user_type(String button1, String button2,
			String button3, String userType) {
		_softAssert.assertFalse(_myloJourneyPageClientContactSection.isClientContactAddLinkDisable(),
				MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.FAIL, button1,
						MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.PASS, button1,
				MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
		_softAssert.assertTrue(
				_myloJourneyPageClientContactSection.verifyClientContactButtonEnabilityStatus(button2, userType),
				MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.FAIL, button2,
						MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
		_softAssert.assertTrue(
				_myloJourneyPageClientContactSection.verifyClientContactButtonEnabilityStatus(button3, userType),
				MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.FAIL, button3,
						MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
	}

	@When("^he views \"([^\"]*)\" section for the same file after relogin with user type \"([^\"]*)\"$")
	public void he_views_section_for_the_same_file_after_relogin_with_user_type(String sectionName, String userType) {
		_loginPage.loginWithUser(userType);
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = _myloJourneyPage.getClientContactFileIDFromDB(MYLOConstants.ACTIVE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		_myloDashboardPage.clickExecuteButton();
		_myloJourneyPage.scrollToJourneySection(sectionName, MYLOConstants.JOURNEY);
		_softAssert.assertTrue(
				_myloJourneyPage.verifySectionHeader(sectionName, MYLOConstants.CLIENT_CONTACT + MYLOConstants.COLON),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.CLIENT_CONTACT + MYLOConstants.COLON, MYLOConstants.CLIENT_CONTACT));
	}

	@Then("^\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" buttons of Client Contact section should be disabled for user type \"([^\"]*)\"$")
	public void buttons_of_Client_Contact_section_should_be_disabled_for_user_type(String button1, String button2,
			String button3, String userType) {
		_softAssert.assertTrue(_myloJourneyPageClientContactSection.isClientContactAddLinkDisable(),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, button1,
						MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.PASS,
				MYLOConstants.ADD_BUTTON, MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
		_softAssert.assertFalse(
				_myloJourneyPageClientContactSection.verifyClientContactButtonEnabilityStatus(button2, userType),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, button2,
						MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
		_softAssert.assertFalse(
				_myloJourneyPageClientContactSection.verifyClientContactButtonEnabilityStatus(button3, userType),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, button3,
						MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
		_softAssert.assertAll();
	}

	@When("^he views \"([^\"]*)\" section for \"([^\"]*)\" file having \"([^\"]*)\" information on Mylo Journey Summary Page$")
	public void he_views_section_for_file_having_information_on_Mylo_Journey_Summary_Page(String sectionName,
			String fileType, String section) {
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = _myloJourneyPage.getClientContactFileIDFromDB(fileType);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		_myloDashboardPage.clickExecuteButton();
		_myloJourneyPage.scrollToJourneySection(sectionName, MYLOConstants.JOURNEY);
		_softAssert.assertTrue(
				_myloJourneyPage.verifySectionHeader(sectionName, MYLOConstants.CLIENT_CONTACT + MYLOConstants.COLON),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.CLIENT_CONTACT + MYLOConstants.COLON, MYLOConstants.CLIENT_CONTACT));
	}

	@Then("^\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" buttons of Client Contact section should be disabled for \"([^\"]*)\" file$")
	public void buttons_of_Client_Contact_section_should_be_disabled_for_file(String button1, String button2,
			String button3, String fileType) {
		_softAssert.assertTrue(_myloJourneyPageClientContactSection.isClientContactAddLinkDisable(),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, button1,
						MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.PASS,
				MYLOConstants.ADD_BUTTON, MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
		_softAssert.assertFalse(
				_myloJourneyPageClientContactSection.verifyClientContactButtonEnabilityStatus(button2, fileType),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, button2,
						MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
		_softAssert.assertFalse(
				_myloJourneyPageClientContactSection.verifyClientContactButtonEnabilityStatus(button3, fileType),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, button3,
						MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
		_softAssert.assertAll();
	}

	/**
	 * Pre-requisite: Logged into Mylo application with user having resource300096
	 * Search any existing active File ID 
	 * @param linkName
	 * @param sectionName
	 * @param fileStatus
	 */
	@Given("^he clicks on \"([^\"]*)\" link available under \"([^\"]*)\" section on Mylo Journey Summary page for an existing \"([^\"]*)\" file$")
	public void he_clicks_on_link_available_under_section_on_Mylo_Journey_Summary_page_for_an_existing_file(
			String linkName, String sectionName, String fileStatus) {
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = _myloJourneyPage.getClientContactFileIDFromDB(fileStatus);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		_myloDashboardPage.clickExecuteButton();
		_myloJourneyPage.scrollToJourneySection(sectionName, MYLOConstants.JOURNEY);
		_softAssert.assertTrue(_myloJourneyPage.verifySectionHeader(sectionName, sectionName + MYLOConstants.COLON),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						sectionName + MYLOConstants.COLON, sectionName));
		_myloJourneyPageClientContactSection.clickAddClientContact(linkName);
	}

	@Then("^toast message should be displayed on clicking \"([^\"]*)\" button after entering below field values under \"([^\"]*)\" section$")
	public void toast_message_should_be_displayed_on_clicking_button_after_entering_below_field_values_under_section(
			String btnName, String arg2, DataTable table) {
		_softAssert.assertTrue(
				_myloJourneyPageClientContactSection.verifyClientContactMandatoryFieldsToastMessage(table, btnName),
				MessageFormat.format(MYLOConstants.FAIL_TO_VERIFY_MANDATORY_FIELDS_VALIDATION_MESSAGE_SECTION,
						CoreConstants.FAIL, MYLOConstants.CLIENT_CONTACT));
	}
	
	@Given("^tag script toast message should be displayed for entering \"([^\"]*)\" specialCharacters on below fields after clicking on \"([^\"]*)\" button under 'Add Client Contact' section$")
	public void tag_script_toast_message_should_be_displayed_for_entering_specialCharacters_on_below_fields_after_clicking_on_button_under_Add_Client_Contact_section(String arg1, String btnName, DataTable table) {
		_softAssert.assertTrue(_myloJourneyPageClientContactSection.verifyClientContactTagSciptToastMsg(table, btnName),
				MessageFormat.format(MYLOConstants.FAIL_TO_VERIFY_TAG_SCRIPT_VALIDATION_MESSAGE_SECTION,
						CoreConstants.FAIL, MYLOConstants.CLIENT_CONTACT));
		_softAssert.assertAll();
	}

	@When("^he enters data beyond character limit for different fields under 'Add Client Contact' section$")
	public void he_enters_data_beyond_character_limit_for_different_fields_under_Add_Client_Contact_section() {
		_myloJourneyPageClientContactSection.setClientContactBeyondCharacterLimit();
	}

	@Then("^values should be successfully restricted as per character limit set for below fields under \"([^\"]*)\" section$")
	public void values_should_be_successfully_restricted_as_per_character_limit_set_for_below_fields_under_section(
			String arg1, DataTable table) {
		_softAssert.assertTrue(_myloJourneyPageClientContactSection.verifyClientContactFieldValuesEntered(table),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
						MYLOConstants.CLIENT_CONTACT));
		_softAssert.assertAll();
	}

	@Given("^he clicks on \"([^\"]*)\" link under Client Contact section on Mylo Journey Summary page for a newly created file$")
	public void he_clicks_on_link_under_Client_Contact_section_on_Mylo_Journey_Summary_page_for_a_newly_created_file(
			String linkName) {
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.createNewFileIfNotExists(MYLOConstants.AUTOMATION_CLIENT_ID, _myloNewFileSection);
		_myloJourneyPage.scrollToJourneySection(MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY);
		_softAssert.assertTrue(
				_myloJourneyPage.verifySectionHeader(MYLOConstants.CLIENT_CONTACT,
						MYLOConstants.CLIENT_CONTACT + MYLOConstants.COLON),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.CLIENT_CONTACT + MYLOConstants.COLON, MYLOConstants.CLIENT_CONTACT));
		_myloJourneyPageClientContactSection.clickAddClientContact(linkName);
	}

	@When("^he clicks on \"([^\"]*)\" button after entering all random field values under 'Add Client Contact' section$")
	public void he_clicks_on_button_after_entering_all_random_field_values_under_Add_Client_Contact_section(
			String btnName) {
		_myloJourneyPageClientContactSection.setAllClientContactFieldWithRandomValues(MYLOConstants.ADD_CLIENT_CONTACT);
		_myloJourneyPageClientContactSection.clickButtonsOnClientContactSection(btnName,
				MYLOConstants.ADD_CLIENT_CONTACT);
		_softAssert.assertTrue(_myloJourneyPage.verifyToastMessage(MYLOConstants.SAVE_SUCCESS_MESSAGE),
				MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.SAVE_SUCCESS_MESSAGE, MYLOConstants.JOURNEY));
	}

	@Then("^all below fields should be successfully saved under 'Client Contact' section$")
	public void all_below_fields_should_be_successfully_saved_under_Client_Contact_section(DataTable table) {
		_myloJourneyPageClientContactSection.clickClientContactDetailsBtn();
		_softAssert.assertTrue(_myloJourneyPageClientContactSection.verifyClientContactUpdated(table),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
						MYLOConstants.CLIENT_CONTACT));
	}

	@Then("^all the below fields should be updated successfully on clicking the \"([^\"]*)\" button after updating all the fields with random values in \"([^\"]*)\" mode$")
	public void all_the_below_fields_should_be_updated_successfully_on_clicking_the_button_after_updating_all_the_fields_with_random_values_in_mode(
			String btnName, String btn, DataTable table) {
		_myloJourneyPageClientContactSection.clickButtonsOnClientContactSection(btn, MYLOConstants.CLIENT_CONTACT);
		_myloJourneyPageClientContactSection.setAllClientContactFieldWithRandomValues(MYLOConstants.CLIENT_CONTACT);
		_myloJourneyPageClientContactSection.setClientContactEndDate(MYLOConstants.RANDOM);
		_myloJourneyPageClientContactSection.clickButtonsOnClientContactSection(btnName, MYLOConstants.CLIENT_CONTACT);
		_softAssert.assertTrue(_myloJourneyPage.verifyToastMessage(MYLOConstants.SAVE_SUCCESS_MESSAGE),
				MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.SAVE_SUCCESS_MESSAGE, MYLOConstants.JOURNEY));
		_myloJourneyPageClientContactSection.clickClientContactDetailsBtn();
		_myloJourneyPageClientContactSection.clickClientContactDetailsBtn();
		_softAssert.assertTrue(_myloJourneyPageClientContactSection.verifyClientContactUpdated(table),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
						MYLOConstants.CLIENT_CONTACT));
		_softAssert.assertAll();
	}

	@Given("^new Client Contact card should be displayed under \"([^\"]*)\" section by clicking on \"([^\"]*)\" button after adding another Client Contact card$")
	public void new_Client_Contact_card_should_be_displayed_under_section_by_clicking_on_button_after_adding_another_Client_Contact_card(
			String arg1, String btnName) {
		_myloJourneyPageClientContactSection.clickAddClientContact(MYLOConstants.ADD_CLIENT_CONTACT);
		_myloJourneyPageClientContactSection.setAllClientContactFieldWithRandomValues(MYLOConstants.ADD_CLIENT_CONTACT);
		_myloJourneyPageClientContactSection.clickButtonsOnClientContactSection(btnName,
				MYLOConstants.ADD_CLIENT_CONTACT);
		_softAssert.assertTrue(_myloJourneyPage.verifyToastMessage(MYLOConstants.SAVE_SUCCESS_MESSAGE),
				MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.SAVE_SUCCESS_MESSAGE, MYLOConstants.JOURNEY));
		_softAssert.assertTrue(_myloJourneyPageClientContactSection.verifyRecentClientContactCardDisplayed(),
				MessageFormat.format(MYLOConstants.RECENT_CLIENT_CONTACT_CARD_NOT_DISPLAYED, CoreConstants.FAIL));
		Reporter.addStepLog(
				MessageFormat.format(MYLOConstants.RECENT_CLIENT_CONTACT_CARD_DISPLAYED, CoreConstants.PASS));
	}

	@When("^he clicks on \"([^\"]*)\" button on newly added Client Contact card on \"([^\"]*)\" section$")
	public void he_clicks_on_button_on_newly_added_Client_Contact_card_on_section(String btnName, String section) {
		_myloJourneyPageClientContactSection.clickButtonsOnClientContactSection(btnName, section);

	}

	@Then("^pop up message \"([^\"]*)\" should be displayed on Mylo Journey Summary Page$")
	public void pop_up_message_should_be_displayed_on_Mylo_Journey_Summary_Page(String msg) {
		_softAssert.assertTrue(_myloJourneyPage.verifyPopUpMessage(msg),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, msg,
						MYLOConstants.CLIENT_CONTACT));
	}

	@Given("^addded client contact card should not be deleted from \"([^\"]*)\" section by clicking on \"([^\"]*)\" or \"([^\"]*)\" button in pop up section$")
	public void addded_client_contact_card_should_not_be_deleted_from_section_by_clicking_on_or_button_in_pop_up_section(
			String section, String btnName1, String btnName2) {
		_softAssert.assertTrue(_myloJourneyPageClientContactSection.verifyClientContactDeleted(btnName1),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_DELETED, CoreConstants.FAIL,
						MYLOConstants.CLIENT_CONTACT_CARD, MYLOConstants.CLIENT_CONTACT, btnName1));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DELETED, CoreConstants.PASS,
				MYLOConstants.CLIENT_CONTACT_CARD, MYLOConstants.CLIENT_CONTACT, btnName1));
		_myloJourneyPageClientContactSection.clickButtonsOnClientContactSection(MYLOConstants.DELETE_BUTTON, section);
		_softAssert.assertTrue(_myloJourneyPageClientContactSection.verifyClientContactDeleted(btnName2),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_DELETED, CoreConstants.FAIL,
						MYLOConstants.CLIENT_CONTACT_CARD, MYLOConstants.CLIENT_CONTACT, btnName2));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DELETED, CoreConstants.PASS,
				MYLOConstants.CLIENT_CONTACT_CARD, MYLOConstants.CLIENT_CONTACT, btnName2));
	}

	@Then("^added client contact should be successfully deleted by clicking \"([^\"]*)\" button after clicking on \"([^\"]*)\" icon on client contact card$")
	public void added_client_contact_should_be_successfully_deleted_by_clicking_button_after_clicking_on_icon_on_client_contact_card(
			String btnName2, String btnName1) {
		_myloJourneyPageClientContactSection.clickButtonsOnClientContactSection(btnName1, MYLOConstants.CLIENT_CONTACT);
		_softAssert.assertFalse(_myloJourneyPageClientContactSection.verifyClientContactDeleted(btnName2),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DELETED, CoreConstants.FAIL,
						MYLOConstants.CLIENT_CONTACT_CARD, MYLOConstants.CLIENT_CONTACT, btnName2));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_SECTION_DELETED, CoreConstants.PASS,
				MYLOConstants.CLIENT_CONTACT_CARD, MYLOConstants.CLIENT_CONTACT, btnName2));

		_softAssert.assertTrue(_myloJourneyPage.verifyToastMessage(MYLOConstants.SUCCESSFULLY_REMOVED),
				MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.SUCCESSFULLY_REMOVED, MYLOConstants.JOURNEY));
		_softAssert.assertAll();
	}
}
