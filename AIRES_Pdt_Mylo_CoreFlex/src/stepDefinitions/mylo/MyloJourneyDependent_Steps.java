package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.MyloJourneyPage_DependentSection;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeSection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyDependent_Steps {

	private TestContext testContext;
	private Mylo_DashboardHomePage myloDashboardPage;
	private MyloJourneyPage_TransfereeSection myloJourneyPageTransfereeSection;
	private MyloJourneyPage_DependentSection myloJourneyPageDependentSection;
	private Mylo_JourneyPage myloJourneyPage;

	public MyloJourneyDependent_Steps(TestContext context) {
		testContext = context;
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloJourneyPageTransfereeSection = testContext.getMyloPageObjectManager().getJourneyPageTransfereeSection();
		myloJourneyPageDependentSection = testContext.getMyloPageObjectManager().getJourneyPageDependentSection();
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
	}

	@Given("^he is on \"([^\"]*)\" section after clicking on 'Add' link displayed in right panel under Dependent section for \"([^\"]*)\" fileID$")
	public void he_is_on_section_after_clicking_on_Add_link_displayed_in_right_panel_under_Dependent_section_for_fileID(
			String sectionType, String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloJourneyPage.getFileInfoFieldByEnvtAndType(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.TRANSFEREE_FAMILY),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_FAMILY, MYLOConstants.TRANSFEREE_FAMILY));
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.DEPENDENTS),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.DEPENDENTS, MYLOConstants.TRANSFEREE_FAMILY));
		myloJourneyPageDependentSection.clickFieldsOnDependentSection(sectionType);
	}

	@When("^he clicks on below Dependent dropdown fields$")
	public void he_clicks_on_below_Dependent_dropdown_fields(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloJourneyPageDependentSection
					.saveDropdownListOptionsOnPartnerSection(data.get(i).get(MYLOConstants.FIELD_NAME));
		}
	}

	@Then("^list of values displayed in the dropdown for below Dependent fields should match with the values present in respective tables on database$")
	public void list_of_values_displayed_in_the_dropdown_for_below_Dependent_fields_should_match_with_the_values_present_in_respective_tables_on_database(
			DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue(
					myloJourneyPageDependentSection
							.verifyDependentFieldDropdownListOptions(data.get(i).get(MYLOConstants.FIELD_NAME)),
					MYLOConstants.DROPDOWN_VALUES_OF + data.get(i).get(MYLOConstants.FIELD_NAME)
							+ MYLOConstants.DID_NOT_MATCH_EXPECTED);
		}
	}

	@Given("^he is on Dependent section after clicking on \"([^\"]*)\" displayed in right panel under \"([^\"]*)\" section for \"([^\"]*)\" fileID$")
	public void he_is_on_Dependent_section_after_clicking_on_displayed_in_right_panel_under_section_for_fileID(
			String expandSection, String sectionHeader, String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloJourneyPage.getFileInfoFieldByEnvtAndType(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifySectionHeader(sectionHeader),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL, sectionHeader,
						MYLOConstants.TRANSFEREE_FAMILY));
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.DEPENDENTS),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.DEPENDENTS, MYLOConstants.TRANSFEREE_FAMILY));
		myloJourneyPageDependentSection.clickFieldsOnDependentSection(expandSection);
	}

	@Given("^he enters below fields under Dependent section after clicking on \"([^\"]*)\" button$")
	public void he_enters_below_fields_under_Dependent_section_after_clicking_on_button(String buttonName,
			DataTable table) {
		myloJourneyPageDependentSection.clickFieldsOnDependentSection(buttonName);
		Assert.assertTrue(myloJourneyPageDependentSection.verifyMandatoryFieldsToastMessagesDependentSection(table),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_ALERT_MESSAGE_SECTION, CoreConstants.FAIL,
						MYLOConstants.MANDATORY, MYLOConstants.DEPENDENT));
	}

	@When("^he clicks on \"([^\"]*)\" button after entering below valid dependent data for mandatory fields under \"([^\"]*)\" section$")
	public void he_clicks_on_button_after_entering_below_valid_dependent_data_for_mandatory_fields_under_section(
			String arg1, String arg2, DataTable table) {
		Assert.assertTrue(myloJourneyPageDependentSection.verifyMandatoryFieldsToastMessagesDependentSection(table),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_ALERT_MESSAGE_SECTION, CoreConstants.FAIL,
						MYLOConstants.MANDATORY, MYLOConstants.DEPENDENT));
	}

	@Then("^entered data for below dependent fields should be successfully saved in \"([^\"]*)\" section$")
	public void entered_data_for_below_dependent_fields_should_be_successfully_saved_in_section(String arg1,
			DataTable table) {
		Assert.assertTrue(myloJourneyPageDependentSection.verifyDifferentDependentFieldsUpdatedValue(table),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
						MYLOConstants.DEPENDENT));
	}

	@Then("^messages corresponding to below fields should be displayed after entering \"([^\"]*)\" for different fields of Dependent section under \"([^\"]*)\" section$")
	public void messages_corresponding_to_below_fields_should_be_displayed_after_entering_for_different_fields_of_Dependent_section_under_section(
			String arg1, String arg2, DataTable table) {
		myloJourneyPageDependentSection.clickFieldsOnDependentSection(MYLOConstants.EDIT_BUTTON);
		Assert.assertTrue(myloJourneyPageDependentSection.verifySpecialCharacterToastMessagesDependentSection(table),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_ALERT_MESSAGE_SECTION, CoreConstants.FAIL,
						CoreConstants.SPECIAL_CHARACTERS, MYLOConstants.DEPENDENT));
	}

	@Given("^he enters below invalid data for different fields with other mandatory data being provided under Dependent section$")
	public void he_enters_below_invalid_data_for_different_fields_with_other_mandatory_data_being_provided_under_Dependent_section(
			DataTable table) {
		myloJourneyPageDependentSection.clickFieldsOnDependentSection(MYLOConstants.EDIT_BUTTON);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloJourneyPageDependentSection.setDependentFields(data.get(i).get(MYLOConstants.FIELD_NAME),
					data.get(i).get(MYLOConstants.CHARACTER_LENGTH));
		}
	}

	@When("^he clicks on \"([^\"]*)\" button present under Dependent section$")
	public void he_clicks_on_button_present_under_Dependent_section(String arg1) {
		myloJourneyPageDependentSection.clickDependentSaveButton();
		Assert.assertTrue(
				myloJourneyPageDependentSection.verifyToastMessage(MYLOConstants.SAVE_SUCCESS_MESSAGE,
						MYLOConstants.TRANSFEREE_FAMILY),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_ALERT_MESSAGE_SECTION, CoreConstants.FAIL,
						MYLOConstants.SUCCESS_MESSAGE, MYLOConstants.DEPENDENT));
	}

	@Then("^values should be successfully saved as per below character limit set for different fields under Dependent section$")
	public void values_should_be_successfully_saved_as_per_below_character_limit_set_for_different_fields_under_Dependent_section(
			DataTable table) {
		Assert.assertTrue(myloJourneyPageDependentSection.verifyDifferentDependentFieldsUpdatedValue(table),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
						MYLOConstants.DEPENDENT));
	}

	@Given("^messages corresponding to below fields should be displayed after entering below field values under Dependent section after clicking on \"([^\"]*)\" button$")
	public void messages_corresponding_to_below_fields_should_be_displayed_after_entering_below_field_values_under_Dependent_section_after_clicking_on_button(
			String buttonName, DataTable table) {
		myloJourneyPageDependentSection.clickFieldsOnDependentSection(MYLOConstants.EDIT_BUTTON);
		myloJourneyPageDependentSection.scrollToDependentElement(MYLOConstants.DEPENDENT_PREFERREDNAME);
		myloJourneyPageDependentSection.clickFieldsOnDependentSection(buttonName);
		Assert.assertTrue(
				myloJourneyPageDependentSection.verifyMandatoryFieldsToastMessagesDependentPhoneEmailSection(table,
						buttonName),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_ALERT_MESSAGE_SECTION, CoreConstants.FAIL,
						MYLOConstants.MANDATORY + " " + buttonName, MYLOConstants.DEPENDENT));
	}

	@Given("^he enters below data for different fields of \"([^\"]*)\" under Dependent section$")
	public void he_enters_below_data_for_different_fields_of_under_Dependent_section(String section, DataTable table) {
		myloJourneyPageDependentSection.setFieldsDependentPhoneEmailSection(table, section);
	}

	@Then("^values should be successfully saved as per below character limit set for different fields of \"([^\"]*)\" under Dependent section$")
	public void values_should_be_successfully_saved_as_per_below_character_limit_set_for_different_fields_of_under_Dependent_section(
			String section, DataTable table) {
		int index = (section.equals(MYLOConstants.DEPENDENT_ADD_PHONE)) ? 0 : 1;
		Assert.assertTrue(myloJourneyPageDependentSection.verifyDifferentDependentPhoneFieldsUpdatedValue(table, index),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
						MYLOConstants.DEPENDENT_ADD_PHONE));
	}

	@Then("^data for \"([^\"]*)\" field should be removed successfully after clicking on Delete icon under Dependent section$")
	public void data_for_field_should_be_removed_successfully_after_clicking_on_Delete_icon_under_Dependent_section(
			String section) {
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.DEPENDENTS),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.DEPENDENTS, MYLOConstants.TRANSFEREE_FAMILY));
		myloJourneyPageDependentSection.clickFieldsOnDependentSection(MYLOConstants.EDIT_BUTTON);
		myloJourneyPageTransfereeSection.clickDeleteIcon(0);
		if (section.equals(MYLOConstants.DEPENDENT_ADD_PHONE))
			myloJourneyPageDependentSection.clickFieldsOnDependentSection(MYLOConstants.YES_BUTTON);
	}

	@Then("^values should be successfully saved for different fields under Dependent section$")
	public void values_should_be_successfully_saved_for_different_fields_under_Dependent_section(DataTable table) {
		Assert.assertTrue(myloJourneyPageDependentSection.verifyDifferentDependentEmailFieldsUpdatedValue(table, 0),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
						MYLOConstants.DEPENDENT_ADD_EMAIL));
	}

	@Given("^dependent already has a \"([^\"]*)\" as preferred number with \"([^\"]*)\" as preferred email$")
	public void dependent_already_has_a_as_preferred_number_with_as_preferred_email(String section1, String section2) {
		Assert.assertTrue(myloJourneyPageDependentSection.isPreferredChecked(section1, 0, MYLOConstants.FIRST),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_NOT_SELECTED, CoreConstants.FAIL,
						MYLOConstants.FIRST, MYLOConstants.PREFERRED, section1, MYLOConstants.DEPENDENT));
		Assert.assertTrue(myloJourneyPageDependentSection.isPreferredChecked(section2, 0, MYLOConstants.FIRST),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_NOT_SELECTED, CoreConstants.FAIL,
						MYLOConstants.FIRST, MYLOConstants.PREFERRED, section1, MYLOConstants.DEPENDENT));
	}

	@When("^he checks the preferred box for another dependent number after clicking on \"([^\"]*)\" button$")
	public void he_checks_the_preferred_box_for_another_dependent_number_after_clicking_on_button(String button) {
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.DEPENDENTS),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.DEPENDENTS, MYLOConstants.TRANSFEREE_FAMILY));
		myloJourneyPageDependentSection.clickFieldsOnDependentSection(MYLOConstants.EDIT_BUTTON);
		myloJourneyPageDependentSection.clickFieldsOnDependentSection(button);
		myloJourneyPageDependentSection.clickDropdownFieldsOnDependentSection(MYLOConstants.DEPENDENT_PHONE_PREFERRED,
				1);
	}

	@Then("^previous selected preferred checkbox for \"([^\"]*)\" should be cleared with latest selected preferred box AS-IS under Dependent section$")
	public void previous_selected_preferred_checkbox_for_should_be_cleared_with_latest_selected_preferred_box_AS_IS_under_Dependent_section(
			String section) {
		Assert.assertFalse(myloJourneyPageDependentSection.isPreferredChecked(section, 0, MYLOConstants.FIRST),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_SELECTED, CoreConstants.FAIL, MYLOConstants.FIRST,
						MYLOConstants.PREFERRED, section, MYLOConstants.DEPENDENT));
		Assert.assertTrue(myloJourneyPageDependentSection.isPreferredChecked(section, 1, MYLOConstants.SECOND),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_NOT_SELECTED, CoreConstants.FAIL,
						MYLOConstants.SECOND, MYLOConstants.PREFERRED, section, MYLOConstants.DEPENDENT));
	}

	@Then("^previous selected preferred checkbox for \"([^\"]*)\" should be cleared with latest selected preferred box AS-IS after he checks the preferred box for another email on clicking \"([^\"]*)\" button under Dependent section$")
	public void previous_selected_preferred_checkbox_for_should_be_cleared_with_latest_selected_preferred_box_AS_IS_after_he_checks_the_preferred_box_for_another_email_on_clicking_button_under_Dependent_section(
			String section, String button) {
		myloJourneyPageDependentSection.clickFieldsOnDependentSection(button);
		myloJourneyPageDependentSection.clickDropdownFieldsOnDependentSection(MYLOConstants.DEPENDENT_EMAIL_PREFERRED,
				1);
		Assert.assertFalse(myloJourneyPageDependentSection.isPreferredChecked(section, 0, MYLOConstants.FIRST),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_SELECTED, CoreConstants.FAIL, MYLOConstants.FIRST,
						MYLOConstants.PREFERRED, section, MYLOConstants.DEPENDENT));
		Assert.assertTrue(myloJourneyPageDependentSection.isPreferredChecked(section, 1, MYLOConstants.SECOND),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_NOT_SELECTED, CoreConstants.FAIL,
						MYLOConstants.SECOND, MYLOConstants.PREFERRED, section, MYLOConstants.DEPENDENT));
	}

	@Given("^he enters below fields under Dependent section$")
	public void he_enters_below_fields_under_Dependent_section(DataTable table) {
		Assert.assertTrue(myloJourneyPageDependentSection.verifyMandatoryToastMessageNewDependentSection(table),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_ALERT_MESSAGE_SECTION, CoreConstants.FAIL,
						MYLOConstants.MANDATORY, MYLOConstants.DEPENDENT));
	}

	@When("^he clicks on \"([^\"]*)\" button after entering \"([^\"]*)\" as \"([^\"]*)\" with \"([^\"]*)\" invalid date in \"([^\"]*)\" field under Dependent section$")
	public void he_clicks_on_button_after_entering_as_with_invalid_date_in_field_under_Dependent_section(
			String buttonName, String fieldName, String fieldValue, String fieldValue2, String fieldName2) {
		myloJourneyPageDependentSection.clickDropdownFieldsOnDependentSection(fieldName, 0);
		myloJourneyPageDependentSection.setDifferentDropDownFields(fieldName, fieldValue);
		myloJourneyPageDependentSection.setDependentFields(fieldName2, fieldValue2);
		myloJourneyPageDependentSection.clickFieldsOnDependentSection(MYLOConstants.SAVE_BUTTON);
	}

	@Then("^toast message \"([^\"]*)\" should be displayed with \"([^\"]*)\" box highlighted under Dependent section$")
	public void toast_message_should_be_displayed_with_box_highlighted_under_Dependent_section(String msg,
			String fieldName) {
		Assert.assertTrue(myloJourneyPageDependentSection.verifyToastMessage(msg, MYLOConstants.DEPENDENT),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_ALERT_MESSAGE_SECTION, CoreConstants.FAIL,
						MYLOConstants.DATEOFBIRTH, MYLOConstants.DEPENDENT));
	}

}
