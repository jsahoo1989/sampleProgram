package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Map;
import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyIdentificationDocumentation_Steps {

	private TestContext testContext;
	private Mylo_LoginPage loginPage;
	private Mylo_DashboardHomePage myloDashboardPage;
	private Mylo_AssignmentPage myloAssignmentPage;
	private Mylo_JourneyPage myloJourneyPage;

	public MyloJourneyIdentificationDocumentation_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
	}

	/**********************************************/

	@Given("^he is on Mylo Journey Summary page for file ID with \"([^\"]*)\" status$")
	public void he_is_on_Mylo_Journey_Summary_page_for_file_ID_with_status(String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
	}

	@Given("^\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" icons of Identification Records section is disabled for \"([^\"]*)\" status fileID$")
	public void icons_of_Identification_Records_section_is_disabled_for_status_fileID(String button1, String button2,
			String button3, String fileStatus) {
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocButtonDisplayed(button1),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, button1,
						MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION, MYLOConstants.JOURNEY));
	}

	@When("^he views Identification Records section for \"([^\"]*)\" status file ID$")
	public void he_views_Identification_Records_section_for_status_file_ID(String fileType) {
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
	}

	@Then("^\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" icons of Identification Records section should get disabled for \"([^\"]*)\" status fileID$")
	public void icons_of_Identification_Records_section_should_get_disabled_for_status_fileID(String button1,
			String button2, String button3, String fileStatus) {
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocButtonDisplayed(button1),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, button1,
						MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION, MYLOConstants.JOURNEY));
	}

	@Given("^he is on Mylo Journey Summary page for file ID with \"([^\"]*)\" data$")
	public void he_is_on_Mylo_Journey_Summary_page_for_file_ID_with_data(String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
	}

	@Given("^he enters below invalid data combination for mandatory fields of \"([^\"]*)\" section$")
	public void he_enters_below_invalid_data_combination_for_mandatory_fields_of_section(String section,
			DataTable table) {
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.ADD_BUTTON);
		myloAssignmentPage.verifyMandatoryFieldsToastMessagesIdentDocSection(table);
	}

	@When("^he clicks on the \"([^\"]*)\" button after entering below valid data for mandatory fields of \"([^\"]*)\" section$")
	public void he_clicks_on_the_button_after_entering_below_valid_data_for_mandatory_fields_of_section(
			String buttonName, String arg2, DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloAssignmentPage.setIdentDocMembersMandatoryFields(data.get(i).get(MYLOConstants.IDENTITY_TYPE),
					data.get(i).get(MYLOConstants.NUMBER), data.get(i).get(MYLOConstants.FROMDATE));
		}
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
	}

	@Then("^\"([^\"]*)\" message should get displayed$")
	public void message_should_get_displayed(String msg) {
		Assert.assertTrue(myloAssignmentPage.verifyPopUpMessage(msg),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, msg,
						MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
	}

	@Given("^he clicks on the \"([^\"]*)\" button after entering below valid data for mandatory fields of \"([^\"]*)\" section by clicking on \"([^\"]*)\" button$")
	public void he_clicks_on_the_button_after_entering_below_valid_data_for_mandatory_fields_of_section_by_clicking_on_button(
			String buttonName2, String section, String buttonName1, DataTable table) {
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName1);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloAssignmentPage.setIdentDocMembersMandatoryFields(data.get(i).get(MYLOConstants.IDENTITY_TYPE),
					data.get(i).get(MYLOConstants.NUMBER), data.get(i).get(MYLOConstants.FROMDATE));
		}
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName2);
	}

	@Given("^he is redirected back to the edit screen after clicking on \"([^\"]*)\" option$")
	public void he_is_redirected_back_to_the_edit_screen_after_clicking_on_option(String buttonName) {
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		Assert.assertTrue(myloAssignmentPage.verifyMandatoryFieldValuesIdentificationAndDocumentationSection(0),
				CoreConstants.FAIL + MYLOConstants.EXPECTED_FIELD_VALUE_NOTDISPLAYED);
	}

	@When("^he clicks on \"([^\"]*)\" option after clicking on \"([^\"]*)\" button$")
	public void he_clicks_on_option_after_clicking_on_button(String buttonName2, String buttonName1) {
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName1);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName2);
	}

	@Then("^identification record should not get updated as well as data should get reset to the initial values\\.$")
	public void identification_record_should_not_get_updated_as_well_as_data_should_get_reset_to_the_initial_values() {
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.ADD_BUTTON);
		Assert.assertTrue(myloAssignmentPage.verifyMandatoryFieldInitialValuesIdentificationAndDocumentationSection(0),
				CoreConstants.FAIL + MYLOConstants.EXPECTED_FIELD_VALUE_NOTDISPLAYED);
	}

	@Given("^\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" icons of Identification Records section is disabled for \"([^\"]*)\" fileID$")
	public void icons_of_Identification_Records_section_is_disabled_for_fileID(String button1, String button2,
			String arg3, String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocButtonDisplayed(button2),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, button2,
						MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION, MYLOConstants.JOURNEY));
	}

	@When("^he views Identification Records section for \"([^\"]*)\" file ID after relogging into the Mylo application with userType \"([^\"]*)\"$")
	public void he_views_Identification_Records_section_for_file_ID_after_relogging_into_the_Mylo_application_with_userType(
			String fileType, String userType) throws Throwable {
		loginPage.loginWithUser(userType);
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
	}

	@Then("^\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" icons of Identification Records section should get enabled for \"([^\"]*)\" fileID$")
	public void icons_of_Identification_Records_section_should_get_enabled_for_fileID(String button1, String button2,
			String arg3, String arg4) {
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocButtonDisplayed(button2),
				MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.FAIL, button2,
						MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION, MYLOConstants.JOURNEY));
	}

	@Given("^message \"([^\"]*)\" is displayed after clicking on \"([^\"]*)\" button with below valid data for multiple rows of \"([^\"]*)\" section$")
	public void message_is_displayed_after_clicking_on_button_with_below_valid_data_for_multiple_rows_of_section(
			String msg, String buttonName, String section, DataTable table) {
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.setIdentDocMultipleRowFieldValues(table);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.SAVE_BUTTON);
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessage(msg),
				MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, msg,
						MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
	}

	@When("^he clicks on \"([^\"]*)\" button after verifying the saved values$")
	public void he_clicks_on_button_after_verifying_the_saved_values(String arg1) {
		myloAssignmentPage.reverseidentDocList();
		Assert.assertTrue(myloAssignmentPage.verifyMultipleRowsFieldValuesIdentDocSection(),
				CoreConstants.FAIL + MYLOConstants.EXPECTED_FIELD_VALUE_NOTDISPLAYED);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.EDIT_BUTTON);
	}

	@Then("^he should be able to update below fields upon clicking on \"([^\"]*)\" button$")
	public void he_should_be_able_to_update_below_fields_upon_clicking_on_button(String buttonName, DataTable table) {
		myloAssignmentPage.updateIdentDocMultipleRowFieldValues(table);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessage(MYLOConstants.SAVE_SUCCESS_MESSAGE),
				MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.SAVE_SUCCESS_MESSAGE, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		;
		Assert.assertTrue(myloAssignmentPage.verifyMultipleRowsFieldValuesIdentDocSection(),
				CoreConstants.FAIL + MYLOConstants.EXPECTED_FIELD_VALUE_NOTDISPLAYED);
	}

	@Given("^Saved identification data should get deleted after clicking on \"([^\"]*)\" button for (\\d+) rows$")
	public void saved_identification_data_should_get_deleted_after_clicking_on_button_for_rows(String buttonName,
			int noOfRows) {
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.EDIT_BUTTON);
		for (int i = 0; i < noOfRows; i++) {
			myloAssignmentPage.clickElementOnIdentificationAndDocumentationSection(buttonName, 0);
			myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.YES_BUTTON);
			myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		}
	}

	@When("^he clicks on \"([^\"]*)\" button after entering below invalid ToDate data for multiple rows of \"([^\"]*)\" section$")
	public void he_clicks_on_button_after_entering_below_invalid_ToDate_data_for_multiple_rows_of_section(
			String buttonName, String section, DataTable table) {
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.setIdentDocMultipleRowFieldValues(table);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
	}

	@Then("^\"([^\"]*)\" message should get displayed for multiple records$")
	public void message_should_get_displayed_for_multiple_records(String msg) {
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessageList(msg, 0), MessageFormat
				.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL, msg, msg, MYLOConstants.JOURNEY));
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessageList(msg, 1), MessageFormat
				.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL, msg, msg, MYLOConstants.JOURNEY));
	}

	@Given("^he cicks on \"([^\"]*)\" field to match the values appearing inside the dropdown with the database after clicking on \"([^\"]*)\" icon of \"([^\"]*)\" section$")
	public void he_cicks_on_field_to_match_the_values_appearing_inside_the_dropdown_with_the_database_after_clicking_on_icon_of_section(
			String fieldName, String buttonName, String section) {
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		myloAssignmentPage.clickElementOnIdentificationAndDocumentationSection(fieldName, 0);
		Assert.assertTrue(myloAssignmentPage.verifyIdentityTypeValuesListFromDB(),
				MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MISMATCH, CoreConstants.FAIL,
						MYLOConstants.IDENTITY_TYPE, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
	}

	@When("^he clicks on \"([^\"]*)\" dropdown field$")
	public void he_clicks_on_dropdown_field(String fieldName) {
		myloAssignmentPage.clickElementOnIdentificationAndDocumentationSection(fieldName, 0);
	}

	@Then("^dropdown should display \"([^\"]*)\" as the first country with remaining countries in alphabetical order$")
	public void dropdown_should_display_as_the_first_country_with_remaining_countries_in_alphabetical_order(
			String countryName) {
		Assert.assertTrue(myloAssignmentPage.verifyFirstCountry(countryName),
				CoreConstants.FAILED_TO_VERFY + countryName + MYLOConstants.AS_FIRST_COUNTRY);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_COUNTRY_PRESENT, CoreConstants.PASS,
				MYLOConstants.USA_STATE, MYLOConstants.COUNTRY_DROPDOWN,
				MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		Assert.assertTrue(myloAssignmentPage.verifyDropdownListOrder(MYLOConstants.COUNTRY),
				MYLOConstants.COUNTRY_DROPDOWN_NOT_IN_ASCENDING_ORDER);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_COUNTRIES_PRESENT, CoreConstants.PASS,
				MYLOConstants.COUNTRY_DROPDOWN, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
	}

	@Given("^below toast messages are displayed after clicking on \"([^\"]*)\" button without filling mandatory fields of \"([^\"]*)\" section$")
	public void below_toast_messages_are_displayed_after_clicking_on_button_without_filling_mandatory_fields_of_section(
			String buttonName, String section, DataTable table) {
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.ADD_BUTTON);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue(myloAssignmentPage.verifyAlertMessageList(data.get(i).get(MYLOConstants.MESSAGE), i));
		}
	}

	@Given("^the color of the tab associated with that record matches the toast messages displayed for \"([^\"]*)\" section on \"([^\"]*)\" page$")
	public void the_color_of_the_tab_associated_with_that_record_matches_the_toast_messages_displayed_for_section_on_page(
			String arg1, String arg2) {
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.ALERT_MESSAGE, 0),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELD_NOT_HIGHLIGHTED, CoreConstants.FAIL,
						MYLOConstants.ALERT_MESSAGE, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.ALERT_MESSAGE, 1),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELD_NOT_HIGHLIGHTED, CoreConstants.FAIL,
						MYLOConstants.ALERT_MESSAGE, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.ALERT_MESSAGE, 2),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELD_NOT_HIGHLIGHTED, CoreConstants.FAIL,
						MYLOConstants.ALERT_MESSAGE, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.FROMDATE, 0),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELD_NOT_HIGHLIGHTED, CoreConstants.FAIL,
						MYLOConstants.FROMDATE, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.NUMBER, 0),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELD_NOT_HIGHLIGHTED, CoreConstants.FAIL,
						MYLOConstants.NUMBER, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.IDENTITY_TYPE, 0),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELD_NOT_HIGHLIGHTED, CoreConstants.FAIL,
						MYLOConstants.IDENTITY_TYPE, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
	}

	@When("^he clicks on \"([^\"]*)\" icon to delete the record of \"([^\"]*)\" section$")
	public void he_clicks_on_icon_to_delete_the_record_of_section(String buttonName, String section) {
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.YES_BUTTON);
		myloAssignmentPage.highlightSectionHeader(section);
	}

	@Then("^the toast messages should get deleted with tab color for the associated record should be restored back to its state for \"([^\"]*)\" section$")
	public void the_toast_messages_should_get_deleted_with_tab_color_for_the_associated_record_should_be_restored_back_to_its_state_for_section(
			String arg1) {
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.ADD_BUTTON);
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.FROMDATE, 0),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELD_HIGHLIGHTED, CoreConstants.PASS,
						MYLOConstants.FROMDATE, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.NUMBER, 0),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELD_HIGHLIGHTED, CoreConstants.PASS, MYLOConstants.NUMBER,
						MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocFieldErrorBackground(MYLOConstants.IDENTITY_TYPE, 0),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELD_HIGHLIGHTED, CoreConstants.PASS,
						MYLOConstants.IDENTITY_TYPE, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		Assert.assertFalse(myloAssignmentPage.verifyAlertMessagesPresent(),
				MessageFormat.format(MYLOConstants.TOAST_MESSAGE_PRESENT, CoreConstants.FAIL,
						MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION, MYLOConstants.JOURNEY));
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.CANCEL_BUTTON);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.YES_BUTTON);
		
	}

	@Given("^below toast messages are displayed by clicking on \"([^\"]*)\" button after removing mandatory fields for existing data of \"([^\"]*)\" section$")
	public void below_toast_messages_are_displayed_by_clicking_on_button_after_removing_mandatory_fields_for_existing_data_of_section(
			String buttonName, String section, DataTable table) {
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.selectIdentDocTransfereeDetails(1);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.EDIT_BUTTON);
		myloAssignmentPage.setIdentDocMembersMandatoryFields(MYLOConstants.SELECT_ONE, "", "");
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue(myloAssignmentPage.verifyAlertMessageList(data.get(i).get(MYLOConstants.MESSAGE), i),
					MessageFormat.format(MYLOConstants.TOAST_MESSAGE_NOT_PRESENT, CoreConstants.FAIL,
							MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION, MYLOConstants.JOURNEY));
		}
	}

	@Given("^Below data is restored for given transferee of \"([^\"]*)\" section$")
	public void below_data_is_restored_for_given_transferee_of_section(String section, DataTable table) {
		myloAssignmentPage.highlightSectionHeader(section);
		myloAssignmentPage.selectIdentDocTransfereeDetails(1);
		myloAssignmentPage.setIdentDocMultipleRowFieldValues(table);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.SAVE_BUTTON);
	}

	@Given("^he has clicked on the tab for the family member which has Identification data in \"([^\"]*)\" section$")
	public void he_has_clicked_on_the_tab_for_the_family_member_which_has_Identification_data_in_section(String arg1) {
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		myloAssignmentPage.selectIdentDocTransfereeDetails(1);
	}

	@Given("^message \"([^\"]*)\" is displayed after he clicks on \"([^\"]*)\" button$")
	public void message_is_displayed_after_he_clicks_on_button(String msg, String buttonName) {
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.EDIT_BUTTON);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(MYLOConstants.REMOVE_BUTTON);
		Assert.assertTrue(myloAssignmentPage.verifyPopUpMessage(msg),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, msg,
						MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
	}

	@Given("^the identification fields for the family member will remain unchanged after he clicks on \"([^\"]*)\" button$")
	public void the_identification_fields_for_the_family_member_will_remain_unchanged_after_he_clicks_on_button(
			String buttonName) {
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		myloAssignmentPage.selectIdentDocTransfereeDetails(1);
		Assert.assertTrue(myloAssignmentPage.verifyRowsFieldValuesIdentDocSection(),
				CoreConstants.FAIL + MYLOConstants.EXPECTED_FIELD_VALUE_NOTDISPLAYED);
	}

	@Then("^the identification fields are removed for the transferee from the UI$")
	public void the_identification_fields_are_removed_for_the_transferee_from_the_UI() {
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		myloAssignmentPage.selectIdentDocTransfereeDetails(1);
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocButtonDisplayed(MYLOConstants.ADD_BUTTON),
				MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.FAIL, MYLOConstants.ADD_BUTTON,
						MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION, MYLOConstants.JOURNEY));
		Assert.assertFalse(myloAssignmentPage.verifyIdentDocButtonPresent(MYLOConstants.EDIT_BUTTON),
				MessageFormat.format(MYLOConstants.BUTTON_PRESENT, CoreConstants.FAIL, MYLOConstants.EDIT_BUTTON,
						MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION, MYLOConstants.JOURNEY));
	}
}
