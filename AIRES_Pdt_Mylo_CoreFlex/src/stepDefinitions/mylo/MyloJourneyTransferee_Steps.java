package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeSection;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyTransferee_Steps {
	TestContext testContext;
	Mylo_LoginPage loginPage;
	Mylo_DashboardHomePage myloDashboardPage;
	Mylo_AssignmentPage myloAssignmentPage;
	MyloJourneyPage_TransfereeSection myloJourneyPageTransfereeSection;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloJourneyTransferee_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
		myloJourneyPageTransfereeSection = testContext.getMyloPageObjectManager().getJourneyPageTransfereeSection();
	}

	@Given("^he is on \"([^\"]*)\" section after clicking on \"([^\"]*)\" displayed in right panel under \"([^\"]*)\" section for \"([^\"]*)\" fileID$")
	public void he_is_on_section_after_clicking_on_displayed_in_right_panel_under_section_for_fileID(
			String sectionHeader1, String expandSection, String sectionHeader, String fileType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		myloJourneyPageTransfereeSection.verifySectionHeader(sectionHeader);
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
		myloJourneyPageTransfereeSection.verifySectionHeader(sectionHeader1);
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(expandSection);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on below dropdown fields$")
	public void he_clicks_on_below_dropdown_fields(DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.EDIT_BUTTON);
		myloJourneyPageTransfereeSection.scrollToTransfereeElement(MYLOConstants.TRANSFEREE_FIRSTNAME);
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_ADD_PHONE);
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_ADD_EMAIL);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloJourneyPageTransfereeSection
					.clickDropdownFieldsOnTransfereeSection(data.get(i).get(MYLOConstants.FIELD_NAME), 0);
		}
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^list of values displayed in the dropdown for below fields should match with the values present in respective tables on database$")
	public void list_of_values_displayed_in_the_dropdown_for_below_fields_should_match_with_the_values_present_in_respective_tables_on_database(
			DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue(myloJourneyPageTransfereeSection
					.verifyFieldDropdownListValuesFromDB(data.get(i).get(MYLOConstants.FIELD_NAME)));
		}
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he enters below fields under \"([^\"]*)\" section after clicking on \"([^\"]*)\" button$")
	public void he_enters_below_fields_under_section_after_clicking_on_button(String section, String buttonName,
			DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(buttonName);
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifyMandatoryFieldsToastMessagesTransfereeSection(table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" button after entering below valid transferee data for mandatory fields under \"([^\"]*)\" section$")
	public void he_clicks_on_button_after_entering_below_valid_transferee_data_for_mandatory_fields_under_section(
			String buttonName, String section, DataTable table) throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifyMandatoryFieldsToastMessagesTransfereeSection(table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^entered data for below transferee fields should be successfully saved in \"([^\"]*)\" section$")
	public void entered_data_for_below_transferee_fields_should_be_successfully_saved_in_section(String section,
			DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifyDifferentTransfereeFieldsUpdatedValue(table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^messages corresponding to below fields should be displayed after entering \"([^\"]*)\" for different fields under \"([^\"]*)\" section$")
	public void messages_corresponding_to_below_fields_should_be_displayed_after_entering_for_different_fields_under_section(
			String arg1, String arg2, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.EDIT_BUTTON);
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifySpecialCharacterToastMessagesTransfereeSection(table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he enters below invalid data for different fields with other mandatory data being provided under \"([^\"]*)\" section$")
	public void he_enters_below_invalid_data_for_different_fields_with_other_mandatory_data_being_provided_under_section(
			String arg1, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.EDIT_BUTTON);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloJourneyPageTransfereeSection.setTransfereeFields(data.get(i).get(MYLOConstants.FIELD_NAME),
					data.get(i).get(MYLOConstants.CHARACTER_LENGTH));
		}
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" button present under \"([^\"]*)\" section$")
	public void he_clicks_on_button_present_under_section(String buttonName, String arg2) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloJourneyPageTransfereeSection.clickTransfereeSaveButton();
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifyToastMessage(MYLOConstants.SAVE_SUCCESS_MESSAGE,
				MYLOConstants.TRANSFEREE_FAMILY));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^values should be successfully saved as per below character limit set for different fields under \"([^\"]*)\" section$")
	public void values_should_be_successfully_saved_as_per_below_character_limit_set_for_different_fields_under_section(
			String arg1, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifyDifferentTransfereeFieldsUpdatedValue(table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^messages corresponding to below fields should be displayed after entering below field values under \"([^\"]*)\" section after clicking on \"([^\"]*)\" button$")
	public void messages_corresponding_to_below_fields_should_be_displayed_after_entering_below_field_values_under_section_after_clicking_on_button(
			String arg1, String buttonName, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.EDIT_BUTTON);
		myloJourneyPageTransfereeSection.scrollToTransfereeElement(MYLOConstants.TRANSFEREE_TITLE);
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(buttonName);
		Assert.assertTrue(myloJourneyPageTransfereeSection
				.verifyMandatoryFieldsToastMessagesTransfereePhoneEmailSection(table, buttonName));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he enters below data for different fields of \"([^\"]*)\" section under \"([^\"]*)\" section$")
	public void he_enters_below_data_for_different_fields_of_section_under_section(String section, String arg2,
			DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloJourneyPageTransfereeSection.setFieldsTransfereePhoneEmailSection(table, section);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^values should be successfully saved as per below character limit set for different fields of \"([^\"]*)\" section under \"([^\"]*)\" section$")
	public void values_should_be_successfully_saved_as_per_below_character_limit_set_for_different_fields_of_section_under_section(
			String section, String arg2, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		int index = (section.equals(MYLOConstants.TRANSFEREE_ADD_PHONE)) ? 0 : 1;
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifyDifferentTransfereePhoneFieldsUpdatedValue(table, index));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^values should be successfully saved for different fields under \"([^\"]*)\" section$")
	public void values_should_be_successfully_saved_for_different_fields_under_section(String section,
			DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifyDifferentTransfereeEmailFieldsUpdatedValue(table, 0));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^data for \"([^\"]*)\" field should be removed successfully after clicking on Delete icon under \"([^\"]*)\" section$")
	public void data_for_field_should_be_removed_successfully_after_clicking_on_Delete_icon_under_section(
			String section, String sectionType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.TRANSFEREE);
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.EDIT_BUTTON);
		myloJourneyPageTransfereeSection.clickDeleteIcon(0);
		if (section.equals(MYLOConstants.TRANSFEREE_ADD_PHONE))
			myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.YES_BUTTON);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^transferee already has a \"([^\"]*)\" as preferred number with \"([^\"]*)\" as preferred email$")
	public void transferee_already_has_a_as_preferred_number_with_as_preferred_email(String section1, String section2) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloJourneyPageTransfereeSection.isPreferredChecked(section1, 0, MYLOConstants.FIRST),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_NOT_SELECTED, CoreConstants.FAIL,
						MYLOConstants.FIRST, MYLOConstants.PREFERRED, section1, MYLOConstants.TRANSFEREE));
		Assert.assertTrue(myloJourneyPageTransfereeSection.isPreferredChecked(section2, 0, MYLOConstants.FIRST),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_NOT_SELECTED, CoreConstants.FAIL,
						MYLOConstants.FIRST, MYLOConstants.PREFERRED, section1, MYLOConstants.TRANSFEREE));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he checks the preferred box for another number after clicking on \"([^\"]*)\" button$")
	public void he_checks_the_preferred_box_for_another_number_after_clicking_on_button(String button)
			throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.TRANSFEREE);
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.EDIT_BUTTON);
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(button);
		myloJourneyPageTransfereeSection.clickDropdownFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_PHONE_PREFERRED,
				1);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^previous selected preferred checkbox for \"([^\"]*)\" should be cleared with latest selected preferred box AS-IS$")
	public void previous_selected_preferred_checkbox_for_should_be_cleared_with_latest_selected_preferred_box_AS_IS(
			String section) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertFalse(myloJourneyPageTransfereeSection.isPreferredChecked(section, 0, MYLOConstants.FIRST),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_SELECTED, CoreConstants.FAIL, MYLOConstants.FIRST,
						MYLOConstants.PREFERRED, section, MYLOConstants.TRANSFEREE));
		Assert.assertTrue(myloJourneyPageTransfereeSection.isPreferredChecked(section, 1, MYLOConstants.SECOND),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_NOT_SELECTED, CoreConstants.FAIL,
						MYLOConstants.SECOND, MYLOConstants.PREFERRED, section, MYLOConstants.TRANSFEREE));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^previous selected preferred checkbox for \"([^\"]*)\" should be cleared with latest selected preferred box AS-IS after he checks the preferred box for another email on clicking \"([^\"]*)\" button$")
	public void previous_selected_preferred_checkbox_for_should_be_cleared_with_latest_selected_preferred_box_AS_IS_after_he_checks_the_preferred_box_for_another_email_on_clicking_button(
			String section, String button) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(button);
		myloJourneyPageTransfereeSection.clickDropdownFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_EMAIL_PREFERRED,
				1);
		Assert.assertFalse(myloJourneyPageTransfereeSection.isPreferredChecked(section, 0, MYLOConstants.FIRST),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_SELECTED, CoreConstants.FAIL, MYLOConstants.FIRST,
						MYLOConstants.PREFERRED, section, MYLOConstants.TRANSFEREE));
		Assert.assertTrue(myloJourneyPageTransfereeSection.isPreferredChecked(section, 1, MYLOConstants.SECOND),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_NOT_SELECTED, CoreConstants.FAIL,
						MYLOConstants.SECOND, MYLOConstants.PREFERRED, section, MYLOConstants.TRANSFEREE));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^transferee detail section has below corresponding field and values$")
	public void transferee_detail_section_has_below_corresponding_field_and_values(DataTable table){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		List<List<String>> dataList = table.asLists(String.class);
		for(int i=0;i<dataList.get(0).size();i++) {
			Assert.assertTrue(myloJourneyPageTransfereeSection.verifyExistingValuesInTransfereeSection(dataList.get(0).get(i), dataList.get(1).get(i)));
		}
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^message \"([^\"]*)\" is displayed after he hovers on \"([^\"]*)\" in Gender dropdown field$")
	public void message_is_displayed_after_he_hovers_on_in_Gender_dropdown_field(String msg, String arg2) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.TRANSFEREE);
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.EDIT_BUTTON);
		Assert.assertTrue(myloJourneyPageTransfereeSection.getGenderXHoverMessage(msg));
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" button after entering \"([^\"]*)\" invalid date in \"([^\"]*)\" field$")
	public void he_clicks_on_button_after_entering_invalid_date_in_field(String buttonName, String fieldValue, String fieldName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloJourneyPageTransfereeSection.setTransfereeFields(fieldName, fieldValue);
		myloJourneyPageTransfereeSection.clickTransfereeSaveButton();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^toast message \"([^\"]*)\" should be displayed with \"([^\"]*)\" box highlighted$")
	public void toast_message_should_be_displayed_with_box_highlighted(String msg, String section){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifyToastMessage(msg, MYLOConstants.TRANSFEREE));
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

}
