package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Map;
import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.MyloJourneyPage_AddressSection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyAddress_Steps {
	private TestContext testContext;
	private Mylo_DashboardHomePage myloDashboardPage;
	private Mylo_JourneyPage myloJourneyPage;
	private MyloJourneyPage_AddressSection myloJourneyPageAddressSection;

	public MyloJourneyAddress_Steps(TestContext context) {
		testContext = context;
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
		myloJourneyPageAddressSection = testContext.getMyloPageObjectManager().getJourneyPageAddressSection();
	}

	@When("^he views \"([^\"]*)\" section after clicking on \"([^\"]*)\" button$")
	public void he_views_section_after_clicking_on_button(String sectionName, String btnName) {
		myloJourneyPage.scrollToJourneySection(sectionName, MYLOConstants.JOURNEY);
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btnName, sectionName);
	}

	@Then("^\"([^\"]*)\" button should be \"([^\"]*)\" depending on \"([^\"]*)\" for \"([^\"]*)\" section on Mylo Journey Page$")
	public void button_should_be_depending_on_for_section_on_Mylo_Journey_Page(String btnName, String arg2, String type,
			String sectionName) {
		myloJourneyPageAddressSection.addressSectionButtonEnabilityStatus(type, btnName, sectionName);
	}

	@Then("^\"([^\"]*)\", \"([^\"]*)\" button should be disabled for both \"([^\"]*)\" status of \"([^\"]*)\" section$")
	public void button_should_be_disabled_for_both_status_of_section(String btnName1, String btnName2, String type,
			String sectionName) {
		myloJourneyPageAddressSection.addressSectionButtonEnabilityStatus(type, btnName1, sectionName);
		myloJourneyPageAddressSection.addressSectionButtonEnabilityStatus(type, btnName2, sectionName);
	}

	@Given("^he is on \"([^\"]*)\" section after clicking on \"([^\"]*)\" button displayed under it for file ID with \"([^\"]*)\"$")
	public void he_is_on_section_after_clicking_on_button_displayed_under_it_for_file_ID_with(String sectionType,
			String btnName, String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
		myloJourneyPage.scrollToJourneySection(sectionType, MYLOConstants.JOURNEY);
		String detailsBtn = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS))
				? MYLOConstants.ORIGIN_ADDRESS_DETAILS_BUTTON
				: MYLOConstants.DESTINATION_ADDRESS_DETAILS_BUTTON;
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(detailsBtn, sectionType);
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btnName, sectionType);
	}

	@Given("^he enters below invalid data for different fields with other mandatory data being provided for \"([^\"]*)\" section$")
	public void he_enters_below_invalid_data_for_different_fields_with_other_mandatory_data_being_provided_for_section(
			String sectionType, DataTable table) {
		myloJourneyPageAddressSection.verifyAddressSectionToastMessages(sectionType, table);
	}

	@When("^he clicks on \"([^\"]*)\" button after entering below valid data for respective fields on \"([^\"]*)\" section$")
	public void he_clicks_on_button_after_entering_below_valid_data_for_respective_fields_on_section(String btnName,
			String sectionType, DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			String fieldValue = data.get(i).get(MYLOConstants.CHARACTER_LENGTH);
			myloJourneyPageAddressSection.setAddressFieldValues(fieldName, fieldValue, MYLOConstants.RANDOM_STRING,
					sectionType);
		}
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btnName, sectionType);
	}

	@Then("^below fieldValues should be successfully saved under \"([^\"]*)\" Dropdown section$")
	public void below_fieldValues_should_be_successfully_saved_under_Dropdown_section(String sectionType,
			DataTable table) {
		String detailsBtn = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS))
				? MYLOConstants.ORIGIN_ADDRESS_DETAILS_BUTTON
				: MYLOConstants.DESTINATION_ADDRESS_DETAILS_BUTTON;
		myloJourneyPage.scrollToJourneySection(sectionType, MYLOConstants.JOURNEY);
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(detailsBtn, sectionType);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue(
					myloJourneyPageAddressSection
							.verifyAddressFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME), sectionType),
					MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
							sectionType));
		}
	}

	@Given("^he enters below invalid data combination of mandatory fields on \"([^\"]*)\" section$")
	public void he_enters_below_invalid_data_combination_of_mandatory_fields_on_section(String sectionType,
			DataTable table) {
		myloJourneyPageAddressSection.verifyMandatoryFieldsToastMessagesAddressSection(sectionType, table);
	}

	@When("^he clicks on \"([^\"]*)\" button after entering below mandatory data on \"([^\"]*)\" section$")
	public void he_clicks_on_button_after_entering_below_mandatory_data_on_section(String btnName, String sectionType,
			DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			String fieldValue = data.get(i).get(MYLOConstants.CHARACTER_LENGTH);
			myloJourneyPageAddressSection.setAddressFieldValues(fieldName, fieldValue, MYLOConstants.RANDOM_STRING,
					sectionType);
		}
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btnName, sectionType);
	}

	@Then("^entered data for below fields should be successfully saved in \"([^\"]*)\" Dropdown section$")
	public void entered_data_for_below_fields_should_be_successfully_saved_in_Dropdown_section(String sectionType,
			DataTable table) {
		String detailsBtn = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS))
				? MYLOConstants.ORIGIN_ADDRESS_DETAILS_BUTTON
				: MYLOConstants.DESTINATION_ADDRESS_DETAILS_BUTTON;
		myloJourneyPage.scrollToJourneySection(sectionType, MYLOConstants.JOURNEY);
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(detailsBtn, sectionType);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue(
					myloJourneyPageAddressSection
							.verifyAddressFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME), sectionType),
					MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
							sectionType));
		}
	}

	@When("^he clicks on \"([^\"]*)\" button of \"([^\"]*)\" section after saving below data for respective fields$")
	public void he_clicks_on_button_of_section_after_saving_below_data_for_respective_fields(String btn,
			String sectionType, DataTable table) {
		String btnName = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS)) ? MYLOConstants.ORIGIN_ADDRESS_SAVE_BUTTON
				: MYLOConstants.DESTINATION_ADDRESS_SAVE_BUTTON;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			String fieldValue = data.get(i).get(MYLOConstants.CHARACTER_LENGTH);
			myloJourneyPageAddressSection.setAddressFieldValues(fieldName, fieldValue, MYLOConstants.RANDOM_STRING,
					sectionType);
		}
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btnName, sectionType);
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btn, sectionType);
	}

	@Then("^\"([^\"]*)\" button should turn green with text changes to \"([^\"]*)\" on \"([^\"]*)\" section$")
	public void button_should_turn_green_with_text_changes_to_on_section(String btnName, String text,
			String sectionType) {
		Assert.assertTrue(myloJourneyPageAddressSection.verifyCopyButtonText(sectionType, text, btnName),
				MessageFormat.format(MYLOConstants.UNABLE_TO_FIND_TEXT, CoreConstants.FAIL, text, btnName));
	}

	@Then("^copied \"([^\"]*)\" can be verified by pasting in the \"([^\"]*)\" field of \"([^\"]*)\" section on Mylo Journey page$")
	public void copied_can_be_verified_by_pasting_in_the_field_of_section_on_Mylo_Journey_page(String sectionType,
			String arg2, String sectionType2) {
		String fieldName = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS)) ? MYLOConstants.COMPLETE_ORIGIN_ADDRESS
				: MYLOConstants.COMPLETE_DESTINATION_ADDRESS;
		String completetAddress = myloJourneyPageAddressSection.getAddressFieldValue(fieldName, sectionType)
				.replace("\n", ",");
		myloJourneyPage.scrollToJourneySection(sectionType2, MYLOConstants.JOURNEY);
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(MYLOConstants.MAILING_ADDRESS_DETAILS_BUTTON,
				sectionType);
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(MYLOConstants.MAILING_ADDRESS_EDIT_BUTTON,
				sectionType);
		Assert.assertTrue(myloJourneyPageAddressSection.verifyCopiedText(completetAddress, sectionType),
				MessageFormat.format(MYLOConstants.UNABLE_TO_COPY_TEXT, CoreConstants.FAIL, sectionType));
	}

	@Then("^a popup \"([^\"]*)\" should display for \"([^\"]*)\" section on Mylo Journey page$")
	public void a_popup_should_display_for_section_on_Mylo_Journey_page(String msg, String sectionType) {
		Assert.assertTrue(myloJourneyPage.verifyPopUpMessage(msg), MessageFormat
				.format(MYLOConstants.VERIFIED_POPUP_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, msg, sectionType));
	}

	@Then("^address should be updated in Mailing address section after clicking on \"([^\"]*)\" button$")
	public void address_should_be_updated_in_Mailing_address_section_after_clicking_on_button(String btnName) {
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btnName, MYLOConstants.JOURNEY);
		myloJourneyPage.scrollToJourneySection(MYLOConstants.MAILING_ADDRESS, MYLOConstants.JOURNEY);
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(MYLOConstants.MAILING_ADDRESS_DETAILS_BUTTON,
				MYLOConstants.MAILING_ADDRESS);
	}

	@When("^he clicks on \"([^\"]*)\" button after verifying the popup message \"([^\"]*)\"$")
	public void he_clicks_on_button_after_verifying_the_popup_message(String btnName, String msg) {
		Assert.assertTrue(myloJourneyPage.verifyPopUpMessage(msg), MessageFormat.format(
				MYLOConstants.VERIFIED_POPUP_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, msg, MYLOConstants.JOURNEY));
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btnName, MYLOConstants.JOURNEY);
	}

	@Then("^address should not get updated in Mailing address section on Mylo Journey page$")
	public void address_should_not_get_updated_in_Mailing_address_section_on_Mylo_Journey_page() {
		myloJourneyPage.scrollToJourneySection(MYLOConstants.MAILING_ADDRESS, MYLOConstants.JOURNEY);
		Assert.assertTrue(myloJourneyPageAddressSection.isAddressElementExist(MYLOConstants.ADD_MAILING_ADDRESS),
				MessageFormat.format(CoreConstants.VRFIED_ELE_NOT_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.ADD_MAILING_ADDRESS));
	}

	@Then("^\"([^\"]*)\" should not get updated in \"([^\"]*)\" section after he clicks on \"([^\"]*)\" icon on popup in Journey page$")
	public void should_not_get_updated_in_section_after_he_clicks_on_icon_on_popup_in_Journey_page(String sectionType,
			String section, String btn) {
		myloJourneyPage.scrollToJourneySection(sectionType, MYLOConstants.JOURNEY);
		String btnName = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS))
				? MYLOConstants.ORIGIN_ADDRESS_COPYTOMAIL_BUTTON
				: MYLOConstants.DESTINATION_ADDRESS_COPYTOMAIL_BUTTON;
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btnName, MYLOConstants.JOURNEY);
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(MYLOConstants.CLOSE_POPUP, MYLOConstants.JOURNEY);
		myloJourneyPage.scrollToJourneySection(section, MYLOConstants.JOURNEY);
		Assert.assertTrue(myloJourneyPageAddressSection.isAddressElementExist(MYLOConstants.ADD_MAILING_ADDRESS),
				MessageFormat.format(CoreConstants.VRFIED_ELE_NOT_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.ADD_MAILING_ADDRESS));
	}

	@Given("^he clicks on \"([^\"]*)\" button of \"([^\"]*)\" section after saving below data for file ID with \"([^\"]*)\"$")
	public void he_clicks_on_button_of_section_after_saving_below_data_for_file_ID_with(String btn, String sectionType,
			String fileType, DataTable table) throws Throwable {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
		myloJourneyPage.scrollToJourneySection(sectionType, MYLOConstants.JOURNEY);
		String editBtn = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS)) ? MYLOConstants.ORIGIN_ADDRESS_EDIT_BUTTON
				: MYLOConstants.DESTINATION_ADDRESS_EDIT_BUTTON;
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(editBtn, sectionType);
		String btnName = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS)) ? MYLOConstants.ORIGIN_ADDRESS_SAVE_BUTTON
				: MYLOConstants.DESTINATION_ADDRESS_SAVE_BUTTON;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			String fieldValue = data.get(i).get(MYLOConstants.CHARACTER_LENGTH);
			myloJourneyPageAddressSection.setAddressFieldValues(fieldName, fieldValue, MYLOConstants.RANDOM_STRING,
					sectionType);
		}
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btnName, sectionType);
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btn, sectionType);
	}

	@Then("^\"([^\"]*)\" should be updated in \"([^\"]*)\" section after clicking on \"([^\"]*)\" button$")
	public void should_be_updated_in_section_after_clicking_on_button(String sectionType, String section, String btn) {
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btn, sectionType);
		Assert.assertTrue(myloJourneyPageAddressSection.verifyAddressCopied(sectionType),
				MessageFormat.format(MYLOConstants.VERIFIED_ADDRESS_NOT_COPIED, CoreConstants.FAIL, sectionType,
						MYLOConstants.MAILING_ADDRESS));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ADDRESS_COPIED, CoreConstants.PASS, sectionType,
				MYLOConstants.MAILING_ADDRESS));
	}

	@Then("^\"([^\"]*)\" should not get updated in existing Mailing address section on Mylo Journey page$")
	public void should_not_get_updated_in_existing_Mailing_address_section_on_Mylo_Journey_page(String sectionType) {
		myloJourneyPage.scrollToJourneySection(MYLOConstants.MAILING_ADDRESS, MYLOConstants.JOURNEY);
		Assert.assertFalse(myloJourneyPageAddressSection.verifyAddressCopied(sectionType), MessageFormat.format(
				MYLOConstants.VERIFIED_ADDRESS_COPIED, CoreConstants.FAIL, sectionType, MYLOConstants.MAILING_ADDRESS));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ADDRESS_NOT_COPIED, CoreConstants.PASS,
				sectionType, MYLOConstants.MAILING_ADDRESS));
	}

	@Then("^\"([^\"]*)\" should not get updated in existing \"([^\"]*)\" section after he clicks on \"([^\"]*)\" icon on popup in Journey page$")
	public void should_not_get_updated_in_existing_section_after_he_clicks_on_icon_on_popup_in_Journey_page(
			String sectionType, String section, String arg3) {
		myloJourneyPage.scrollToJourneySection(sectionType, MYLOConstants.JOURNEY);
		String btnName = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS))
				? MYLOConstants.ORIGIN_ADDRESS_COPYTOMAIL_BUTTON
				: MYLOConstants.DESTINATION_ADDRESS_COPYTOMAIL_BUTTON;
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(btnName, MYLOConstants.JOURNEY);
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(MYLOConstants.YES_BUTTON, MYLOConstants.JOURNEY);
		myloJourneyPageAddressSection.clickFieldsOnAddressSection(MYLOConstants.CLOSE_POPUP, MYLOConstants.JOURNEY);
		myloJourneyPage.scrollToJourneySection(section, MYLOConstants.JOURNEY);
		Assert.assertFalse(myloJourneyPageAddressSection.verifyAddressCopied(sectionType), MessageFormat.format(
				MYLOConstants.VERIFIED_ADDRESS_COPIED, CoreConstants.FAIL, sectionType, MYLOConstants.MAILING_ADDRESS));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ADDRESS_NOT_COPIED, CoreConstants.PASS,
				sectionType, MYLOConstants.MAILING_ADDRESS));
	}
}
