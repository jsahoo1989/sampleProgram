package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloAssignmentIdentificationDocumentation_Steps {

	TestContext testContext;
	Mylo_LoginPage loginPage;
	Mylo_DashboardHomePage myloDashboardPage;
	Mylo_AssignmentPage myloAssignmentPage;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloAssignmentIdentificationDocumentation_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
	}

	/**********************************************/

	@Given("^he is on Mylo Assignment Summary page for file ID with \"([^\"]*)\" status$")
	public void he_is_on_Mylo_Assignment_Summary_page_for_file_ID_with_status(String fileType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.FILE_ID_ENTERED, CoreConstants.PASS, fileID));
		myloDashboardPage.clickExecuteButton();
		//myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" icons of Identification Records section is disabled for \"([^\"]*)\" status fileID$")
	public void icons_of_Identification_Records_section_is_disabled_for_status_fileID(String button1, String button2,
			String button3, String fileStatus) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocButtonDisplayed(button1));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he views Identification Records section for \"([^\"]*)\" status file ID$")
	public void he_views_Identification_Records_section_for_status_file_ID(String fileType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.FILE_ID_ENTERED, CoreConstants.PASS, fileID));
		myloDashboardPage.clickExecuteButton();
		//myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" icons of Identification Records section should get disabled for \"([^\"]*)\" status fileID$")
	public void icons_of_Identification_Records_section_should_get_disabled_for_status_fileID(String button1,
			String button2, String button3, String fileStatus) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocButtonDisplayed(button1));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he is on Mylo Assignment Summary page for file ID with \"([^\"]*)\" data$")
	public void he_is_on_Mylo_Assignment_Summary_page_for_file_ID_with_data(String fileType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.FILE_ID_ENTERED, CoreConstants.PASS, fileID));
		myloDashboardPage.clickExecuteButton();
		//myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he enters below invalid data combination for mandatory fields of \"([^\"]*)\" section$")
	public void he_enters_below_invalid_data_combination_for_mandatory_fields_of_section(String section,
			DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.ADD_BUTTON);
		myloAssignmentPage.verifyMandatoryFieldsToastMessagesIdentDocSection(table);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on the \"([^\"]*)\" button after entering below valid data for mandatory fields of \"([^\"]*)\" section$")
	public void he_clicks_on_the_button_after_entering_below_valid_data_for_mandatory_fields_of_section(
			String buttonName, String arg2, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloAssignmentPage.setIdentDocMembersMandatoryFields(data.get(i).get(MYLOConstants.IDENTITY_TYPE),
					data.get(i).get(MYLOConstants.NUMBER), data.get(i).get(MYLOConstants.FROMDATE));
		}
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" message should get displayed$")
	public void message_should_get_displayed(String msg) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyPopUpMessage(msg));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he clicks on the \"([^\"]*)\" button after entering below valid data for mandatory fields of \"([^\"]*)\" section by clicking on \"([^\"]*)\" button$")
	public void he_clicks_on_the_button_after_entering_below_valid_data_for_mandatory_fields_of_section_by_clicking_on_button(
			String buttonName2, String section, String buttonName1, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName1);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloAssignmentPage.setIdentDocMembersMandatoryFields(data.get(i).get(MYLOConstants.IDENTITY_TYPE),
					data.get(i).get(MYLOConstants.NUMBER), data.get(i).get(MYLOConstants.FROMDATE));
		}
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName2);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he is redirected back to the edit screen after clicking on \"([^\"]*)\" option$")
	public void he_is_redirected_back_to_the_edit_screen_after_clicking_on_option(String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		Assert.assertTrue(myloAssignmentPage.verifyMandatoryFieldValuesIdentificationAndDocumentationSection(0));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" option after clicking on \"([^\"]*)\" button$")
	public void he_clicks_on_option_after_clicking_on_button(String buttonName2, String buttonName1) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName1);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName2);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^identification record should not get updated as well as data should get reset to the initial values\\.$")
	public void identification_record_should_not_get_updated_as_well_as_data_should_get_reset_to_the_initial_values() {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		//Assert.assertTrue(myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY));
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.ADD_BUTTON);
		Assert.assertTrue(myloAssignmentPage.verifyMandatoryFieldInitialValuesIdentificationAndDocumentationSection(0));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" icons of Identification Records section is disabled for \"([^\"]*)\" fileID$")
	public void icons_of_Identification_Records_section_is_disabled_for_fileID(String button1, String button2,
			String arg3, String fileType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.FILE_ID_ENTERED, CoreConstants.PASS, fileID));
		myloDashboardPage.clickExecuteButton();
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocButtonDisplayed(button2));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he views Identification Records section for \"([^\"]*)\" file ID after relogging into the Mylo application with userType \"([^\"]*)\"$")
	public void he_views_Identification_Records_section_for_file_ID_after_relogging_into_the_Mylo_application_with_userType(
			String fileType, String userType) throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		loginPage.loginWithUser(userType);
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.FILE_ID_ENTERED, CoreConstants.PASS, fileID));
		myloDashboardPage.clickExecuteButton();
	//	myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");

	}

	@Then("^\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" icons of Identification Records section should get enabled for \"([^\"]*)\" fileID$")
	public void icons_of_Identification_Records_section_should_get_enabled_for_fileID(String button1, String button2,
			String arg3, String arg4) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocButtonDisplayed(button2));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^message \"([^\"]*)\" is displayed after clicking on \"([^\"]*)\" button with below valid data for multiple rows of \"([^\"]*)\" section$")
	public void message_is_displayed_after_clicking_on_button_with_below_valid_data_for_multiple_rows_of_section(
			String msg, String buttonName, String section, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.setIdentDocMultipleRowFieldValues(table);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.SAVE_BUTTON);
		myloAssignmentPage.verifyAlertMessage(msg);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" button after verifying the saved values$")
	public void he_clicks_on_button_after_verifying_the_saved_values(String arg1) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.reverseidentDocList();
		Assert.assertTrue(myloAssignmentPage.verifyMultipleRowsFieldValuesIdentDocSection());
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.EDIT_BUTTON);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^he should be able to update below fields upon clicking on \"([^\"]*)\" button$")
	public void he_should_be_able_to_update_below_fields_upon_clicking_on_button(String buttonName, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.updateIdentDocMultipleRowFieldValues(table);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		Assert.assertTrue(myloAssignmentPage.verifyMultipleRowsFieldValuesIdentDocSection());
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^Saved identification data should get deleted after clicking on \"([^\"]*)\" button for (\\d+) rows$")
	public void saved_identification_data_should_get_deleted_after_clicking_on_button_for_rows(String buttonName,
			int noOfRows) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.EDIT_BUTTON);
		for (int i = 0; i < noOfRows; i++) {
			myloAssignmentPage.clickElementOnIdentificationAndDocumentationSection(buttonName, 0);
			myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.YES_BUTTON);
			myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		}
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" button after entering below invalid ToDate data for multiple rows of \"([^\"]*)\" section$")
	public void he_clicks_on_button_after_entering_below_invalid_ToDate_data_for_multiple_rows_of_section(
			String buttonName, String section, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.setIdentDocMultipleRowFieldValues(table);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" message should get displayed for multiple records$")
	public void message_should_get_displayed_for_multiple_records(String msg) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessageList(msg, 0));
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessageList(msg, 1));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he cicks on \"([^\"]*)\" field to match the values appearing inside the dropdown with the database after clicking on \"([^\"]*)\" icon of \"([^\"]*)\" section$")
	public void he_cicks_on_field_to_match_the_values_appearing_inside_the_dropdown_with_the_database_after_clicking_on_icon_of_section(
			String fieldName, String buttonName, String section) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		myloAssignmentPage.clickElementOnIdentificationAndDocumentationSection(fieldName, 0);
		Assert.assertTrue(myloAssignmentPage.verifyIdentityTypeValuesListFromDB());
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" dropdown field$")
	public void he_clicks_on_dropdown_field(String fieldName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnIdentificationAndDocumentationSection(fieldName, 0);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^dropdown should display \"([^\"]*)\" as the first country with remaining countries in alphabetical order$")
	public void dropdown_should_display_as_the_first_country_with_remaining_countries_in_alphabetical_order(
			String countryName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyFirstCountry(countryName),
			CoreConstants.FAILED_TO_VERFY + countryName + MYLOConstants.AS_FIRST_COUNTRY);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_COUNTRY_PRESENT, CoreConstants.PASS,
				MYLOConstants.USA_STATE, MYLOConstants.COUNTRY_DROPDOWN,
				MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		Assert.assertTrue(myloAssignmentPage.verifyDropdownListOrder(MYLOConstants.COUNTRY),
				MYLOConstants.COUNTRY_DROPDOWN_NOT_IN_ASCENDING_ORDER);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_COUNTRIES_PRESENT, CoreConstants.PASS,
				MYLOConstants.COUNTRY_DROPDOWN, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^below toast messages are displayed after clicking on \"([^\"]*)\" button without filling mandatory fields of \"([^\"]*)\" section$")
	public void below_toast_messages_are_displayed_after_clicking_on_button_without_filling_mandatory_fields_of_section(
			String buttonName, String section, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.ADD_BUTTON);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue(myloAssignmentPage.verifyAlertMessageList(data.get(i).get(MYLOConstants.MESSAGE), i));
		}
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^the color of the tab associated with that record matches the toast messages displayed for \"([^\"]*)\" section on \"([^\"]*)\" page$")
	public void the_color_of_the_tab_associated_with_that_record_matches_the_toast_messages_displayed_for_section_on_page(
			String arg1, String arg2) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.ALERT_MESSAGE, 0));
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.ALERT_MESSAGE, 1));
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.ALERT_MESSAGE, 2));
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.FROMDATE, 0));
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.NUMBER, 0));
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.IDENTITY_TYPE, 0));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" icon to delete the record of \"([^\"]*)\" section$")
	public void he_clicks_on_icon_to_delete_the_record_of_section(String buttonName, String section) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.YES_BUTTON);
		myloAssignmentPage.highlightSectionHeader(section);
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessageList(MYLOConstants.SUCCESSFULLY_REMOVED, 0));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^the toast messages should get deleted with tab color for the associated record should be restored back to its state for \"([^\"]*)\" section$")
	public void the_toast_messages_should_get_deleted_with_tab_color_for_the_associated_record_should_be_restored_back_to_its_state_for_section(
			String arg1) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.ADD_BUTTON);
		Assert.assertFalse(myloAssignmentPage.verifyAlertMessagesPresent());
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.FROMDATE, 0));
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.NUMBER, 0));
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.IDENTITY_TYPE, 0));
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.CANCEL_BUTTON);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.YES_BUTTON);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^below toast messages are displayed by clicking on \"([^\"]*)\" button after removing mandatory fields for existing data of \"([^\"]*)\" section$")
	public void below_toast_messages_are_displayed_by_clicking_on_button_after_removing_mandatory_fields_for_existing_data_of_section(
			String buttonName, String section, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.selectIdentDocTransfereeDetails(1);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.EDIT_BUTTON);
		myloAssignmentPage.setIdentDocMembersMandatoryFields(MYLOConstants.SELECT_ONE, "", "");
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue(myloAssignmentPage.verifyAlertMessageList(data.get(i).get(MYLOConstants.MESSAGE), i));
		}
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^Below data is restored for given transferee of \"([^\"]*)\" section$")
	public void below_data_is_restored_for_given_transferee_of_section(String section, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.selectIdentDocTransfereeDetails(1);
		myloAssignmentPage.setIdentDocMultipleRowFieldValues(table);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.SAVE_BUTTON);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has clicked on the tab for the family member which has Identification data in \"([^\"]*)\" section$")
	public void he_has_clicked_on_the_tab_for_the_family_member_which_has_Identification_data_in_section(String arg1) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		myloAssignmentPage.selectIdentDocTransfereeDetails(1);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^message \"([^\"]*)\" is displayed after he clicks on \"([^\"]*)\" button$")
	public void message_is_displayed_after_he_clicks_on_button(String msg, String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.EDIT_BUTTON);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.REMOVE_BUTTON);
		Assert.assertTrue(myloAssignmentPage.verifyPopUpMessage(msg));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^the identification fields for the family member will remain unchanged after he clicks on \"([^\"]*)\" button$")
	public void the_identification_fields_for_the_family_member_will_remain_unchanged_after_he_clicks_on_button(
			String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		myloAssignmentPage.selectIdentDocTransfereeDetails(1);
		Assert.assertTrue(myloAssignmentPage.verifyRowsFieldValuesIdentDocSection());
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^the identification fields are removed for the transferee from the UI$")
	public void the_identification_fields_are_removed_for_the_transferee_from_the_UI() {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		myloAssignmentPage.selectIdentDocTransfereeDetails(1);
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocButtonDisplayed(MYLOConstants.ADD_BUTTON));
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocButtonPresent(MYLOConstants.EDIT_BUTTON));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
}
