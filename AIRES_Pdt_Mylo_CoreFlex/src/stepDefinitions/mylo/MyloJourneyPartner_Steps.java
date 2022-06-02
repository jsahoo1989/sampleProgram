package stepDefinitions.mylo;

import java.util.Date;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_PartnerSection;
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

public class MyloJourneyPartner_Steps {

	TestContext testContext;
	Mylo_LoginPage loginPage;
	Mylo_DashboardHomePage myloDashboardPage;
	Mylo_AssignmentPage myloAssignmentPage;
	MyloJourneyPage_TransfereeSection myloJourneyPageTransfereeSection;
	MyloJourneyPage_PartnerSection myloJourneyPagePartnerSection;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloJourneyPartner_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
		myloJourneyPageTransfereeSection = testContext.getMyloPageObjectManager().getJourneyPageTransfereeSection();
		myloJourneyPagePartnerSection = testContext.getMyloPageObjectManager().getJourneyPagePartnerSection();
	}
	
	@Given("^he is on \"([^\"]*)\" section after clicking on 'Add' link displayed in right panel under \"([^\"]*)\" section for  \"([^\"]*)\" fileID$")
	public void he_is_on_section_after_clicking_on_Add_link_displayed_in_right_panel_under_section_for_fileID(String sectionType, String sectionHeader, String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		myloJourneyPageTransfereeSection.verifySectionHeader(sectionHeader);
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
		myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.PARTNER);
		myloJourneyPagePartnerSection.clickFieldsOnPartnerSection(sectionType);
	}

	@When("^he clicks on below Partner dropdown fields$")
	public void he_clicks_on_below_Partner_dropdown_fields(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloJourneyPagePartnerSection
					.saveDropdownListOptionsOnPartnerSection(data.get(i).get(MYLOConstants.FIELD_NAME));
		}
	}

	@Then("^list of values displayed in the dropdown for below Partner fields should match with the values present in respective tables on database$")
	public void list_of_values_displayed_in_the_dropdown_for_below_Partner_fields_should_match_with_the_values_present_in_respective_tables_on_database(
			DataTable table){
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue(myloJourneyPagePartnerSection
					.verifyPartnerFieldDropdownListOptions(data.get(i).get(MYLOConstants.FIELD_NAME)),"Dropdown values of " + data.get(i).get(MYLOConstants.FIELD_NAME) + " didnot match with expected values");
		}
	}
	
	@Given("^he is on Partner section after clicking on \"([^\"]*)\" displayed in right panel under \"([^\"]*)\" section for \"([^\"]*)\" fileID$")
	public void he_is_on_Partner_section_after_clicking_on_displayed_in_right_panel_under_section_for_fileID(String expandSection, String sectionHeader, String fileType){
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		myloJourneyPageTransfereeSection.verifySectionHeader(sectionHeader);
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
		Assert.assertTrue(myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.PARTNER));
		myloJourneyPagePartnerSection.clickFieldsOnPartnerSection(expandSection);
	}
	
	@Given("^he enters below fields under Partner section after clicking on \"([^\"]*)\" button$")
	public void he_enters_below_fields_under_Partner_section_after_clicking_on_button(String buttonName, DataTable table){
		myloJourneyPagePartnerSection.clickFieldsOnPartnerSection(buttonName);
		Assert.assertTrue(myloJourneyPagePartnerSection.verifyMandatoryFieldsToastMessagesPartnerSection(table));
	}

	@When("^he clicks on \"([^\"]*)\" button after entering below valid partner data for mandatory fields under \"([^\"]*)\" section$")
	public void he_clicks_on_button_after_entering_below_valid_partner_data_for_mandatory_fields_under_section(String arg1, String arg2, DataTable table){
		Assert.assertTrue(myloJourneyPagePartnerSection.verifyMandatoryFieldsToastMessagesPartnerSection(table));
	}

	@Then("^entered data for below partner fields should be successfully saved in \"([^\"]*)\" section$")
	public void entered_data_for_below_partner_fields_should_be_successfully_saved_in_section(String arg1, DataTable table){
		Assert.assertTrue(myloJourneyPagePartnerSection.verifyDifferentPartnerFieldsUpdatedValue(table));
	}
	
	@Then("^messages corresponding to below fields should be displayed after entering \"([^\"]*)\" for different fields of Partner section under \"([^\"]*)\" section$")
	public void messages_corresponding_to_below_fields_should_be_displayed_after_entering_for_different_fields_of_Partner_section_under_section(String arg1, String arg2, DataTable table){
		myloJourneyPagePartnerSection.clickFieldsOnPartnerSection(MYLOConstants.EDIT_BUTTON);
		Assert.assertTrue(myloJourneyPagePartnerSection.verifySpecialCharacterToastMessagesPartnerSection(table));
	}
	
	@Given("^he enters below invalid data for different fields with other mandatory data being provided under Partner section$")
	public void he_enters_below_invalid_data_for_different_fields_with_other_mandatory_data_being_provided_under_Partner_section(DataTable table){
		myloJourneyPagePartnerSection.clickFieldsOnPartnerSection(MYLOConstants.EDIT_BUTTON);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloJourneyPagePartnerSection.setPartnerFields(data.get(i).get(MYLOConstants.FIELD_NAME),
					data.get(i).get(MYLOConstants.CHARACTER_LENGTH));
		}
	}

	@When("^he clicks on \"([^\"]*)\" button present under Partner section$")
	public void he_clicks_on_button_present_under_Partner_section(String arg1){
		myloJourneyPagePartnerSection.clickPartnerSaveButton();
		Assert.assertTrue(myloJourneyPagePartnerSection.verifyToastMessage(MYLOConstants.SAVE_SUCCESS_MESSAGE,
				MYLOConstants.TRANSFEREE_FAMILY));
	}

	@Then("^values should be successfully saved as per below character limit set for different fields under Partner section$")
	public void values_should_be_successfully_saved_as_per_below_character_limit_set_for_different_fields_under_Partner_section(DataTable table){
		Assert.assertTrue(myloJourneyPagePartnerSection.verifyDifferentPartnerFieldsUpdatedValue(table));
	}
	
	@Given("^messages corresponding to below fields should be displayed after entering below field values under Partner section after clicking on \"([^\"]*)\" button$")
	public void messages_corresponding_to_below_fields_should_be_displayed_after_entering_below_field_values_under_Partner_section_after_clicking_on_button(String buttonName, DataTable table){
		myloJourneyPagePartnerSection.clickFieldsOnPartnerSection(MYLOConstants.EDIT_BUTTON);
		myloJourneyPagePartnerSection.scrollToPartnerElement(MYLOConstants.PARTNER_PREFERREDNAME);
		myloJourneyPagePartnerSection.clickFieldsOnPartnerSection(buttonName);
		Assert.assertTrue(myloJourneyPagePartnerSection
				.verifyMandatoryFieldsToastMessagesPartnerPhoneEmailSection(table, buttonName));
	}

	@Given("^he enters below data for different fields of \"([^\"]*)\" under Partner section$")
	public void he_enters_below_data_for_different_fields_of_under_Partner_section(String section, DataTable table){
		myloJourneyPagePartnerSection.setFieldsPartnerPhoneEmailSection(table, section);
	}

	@Then("^values should be successfully saved as per below character limit set for different fields of \"([^\"]*)\" under Partner section$")
	public void values_should_be_successfully_saved_as_per_below_character_limit_set_for_different_fields_of_under_Partner_section(String section, DataTable table){
		int index = (section.equals(MYLOConstants.PARTNER_ADD_PHONE)) ? 0 : 1;
		Assert.assertTrue(myloJourneyPagePartnerSection.verifyDifferentPartnerPhoneFieldsUpdatedValue(table, index));
	}

	@Then("^data for \"([^\"]*)\" field should be removed successfully after clicking on Delete icon under Partner section$")
	public void data_for_field_should_be_removed_successfully_after_clicking_on_Delete_icon_under_Partner_section(String section) {
		myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.PARTNER);
		myloJourneyPagePartnerSection.clickFieldsOnPartnerSection(MYLOConstants.EDIT_BUTTON);
		myloJourneyPageTransfereeSection.clickDeleteIcon(0);
		if (section.equals(MYLOConstants.PARTNER_ADD_PHONE))
			myloJourneyPagePartnerSection.clickFieldsOnPartnerSection(MYLOConstants.YES_BUTTON);
	}
	
	@Then("^values should be successfully saved for different fields under Partner section$")
	public void values_should_be_successfully_saved_for_different_fields_under_Partner_section(DataTable table) {
		Assert.assertTrue(myloJourneyPagePartnerSection.verifyDifferentPartnerEmailFieldsUpdatedValue(table, 0));
	}

}
