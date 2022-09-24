package stepDefinitions.mylo;

import java.text.MessageFormat;
import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyFileInformation_Steps {
	private TestContext testContext;
	private Mylo_DashboardHomePage myloDashboardPage;
	private Mylo_AssignmentPage myloAssignmentPage;
	private Mylo_JourneyPage myloJourneyPage;

	public MyloJourneyFileInformation_Steps(TestContext context) {
		testContext = context;
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
	}

	@Given("^he views the File Information section where \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" are hard coded with background color \"([^\"]*)\"$")
	public void he_views_the_File_Information_section_where_are_hard_coded_with_background_color(String fieldName1,
			String fieldName2, String fieldName3, String colorCode) {
		String fileID = myloJourneyPage.getFileInfoFieldByEnvtAndType("activeAssignment", MYLOConstants.FILE_ID);
		String clientID = myloJourneyPage.getFileInfoFieldByEnvtAndType("activeAssignment", MYLOConstants.CLIENT_ID);
		String clientName = myloJourneyPage.getFileInfoFieldByEnvtAndType("activeAssignment",
				MYLOConstants.CLIENT_NAME);
		String policyType = myloJourneyPage.getFileInfoFieldByEnvtAndType("activeAssignment",
				MYLOConstants.POLICY_TYPE);
		Assert.assertTrue(
				myloAssignmentPage.verifyFileInfoDisplayedFields(fileID, clientID + "-" + clientName, policyType),
				MYLOConstants.INCORRECT_FIELD_VALUES_IN_FILEINFO);
		Assert.assertTrue(myloAssignmentPage.verifyElementCSSValue(fieldName1, "background-color", colorCode),
				MessageFormat.format(MYLOConstants.VERIFIED_BGCOLOR_NOT_DISPLAYED, CoreConstants.FAIL, fieldName1,
						colorCode, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		Assert.assertTrue(myloAssignmentPage.verifyElementCSSValue(fieldName2, "background-color", colorCode),
				MessageFormat.format(MYLOConstants.VERIFIED_BGCOLOR_NOT_DISPLAYED, CoreConstants.FAIL, fieldName2,
						colorCode, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		Assert.assertTrue(myloAssignmentPage.verifyElementCSSValue(fieldName3, "background-color", colorCode),
				MessageFormat.format(MYLOConstants.VERIFIED_BGCOLOR_NOT_DISPLAYED, CoreConstants.FAIL, fieldName3,
						colorCode, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	@When("^he clicks on the button \"([^\"]*)\" under the file information section$")
	public void he_clicks_on_the_button_under_the_file_information_section(String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
	}

	@Then("^the file information should expand to display additional fields$")
	public void the_file_information_should_expand_to_display_additional_fields() {
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoAdditionalFieldsDisplayed(),
				MYLOConstants.ADDITIONAL_FIELDS_FILEINFO_NOT_DISPLAYED);
	}

	@Given("^\"([^\"]*)\" of the file is not \"([^\"]*)\" or \"([^\"]*)\"$")
	public void of_the_file_is_not_or(String fieldName, String statusName1, String statusName2) {
		String statusDisplayed = myloAssignmentPage.getFileInfoFieldValue(fieldName);
		Assert.assertNotEquals(statusDisplayed, statusName1, MYLOConstants.MISMATCH_VALUE + fieldName);
		Assert.assertNotEquals(statusDisplayed, statusName2, MYLOConstants.MISMATCH_VALUE + fieldName);
	}

	@Then("^\"([^\"]*)\" button will be enabled for Resource(\\d+) or disabled for Without Resource(\\d+) depending on \"([^\"]*)\"$")
	public void button_will_be_enabled_for_Resource_or_disabled_for_Without_Resource_depending_on(String fieldName,
			int arg2, int arg3, String userType) throws Throwable {
		myloAssignmentPage.verifyFileInfoFieldsForScenarioType(userType, fieldName);
	}

	@Given("^he has updated some fields in the file information section after clicking on \"([^\"]*)\" button$")
	public void he_has_updated_some_fields_in_the_file_information_section_after_clicking_on_button(String buttonName) {
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoAdditionalFieldsDisplayed(),
				MYLOConstants.ADDITIONAL_FIELDS_FILEINFO_NOT_DISPLAYED);
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.POLICY_TYPE, MYLOConstants.RANDOM);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.JOURNEY_TYPE, MYLOConstants.JOURNEY_TYPE2_VALUE);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.HOMESTATUS, MYLOConstants.HOMESTATUS2_VALUE);
		myloJourneyPage.scrollToJourneySection(MYLOConstants.OFFICE, MYLOConstants.JOURNEY);
		myloAssignmentPage.clickCheckBoxOnAiresFileInfoSection(MYLOConstants.INHERITED_FILE);
		myloJourneyPage.scrollToJourneySection(MYLOConstants.FILE_INFORMATION_SECTION, MYLOConstants.JOURNEY);
	}

	@Then("^updated fields should be saved or not saved depending on the \"([^\"]*)\" clicked in the Journey File information section$")
	public void updated_fields_should_be_saved_or_not_saved_depending_on_the_clicked_in_the_Journey_File_information_section(
			String buttonName) {
		myloAssignmentPage.verifyFileInfoFieldsOnClickedButton(buttonName);
	}

	@Then("^\"([^\"]*)\" of the file should be \"([^\"]*)\"$")
	public void of_the_file_should_be(String fieldName, String statusName) {
		Assert.assertEquals(myloAssignmentPage.getFileInfoFieldValue(fieldName), statusName,
				MYLOConstants.MISMATCH_VALUE + fieldName);
	}

	@Then("^\"([^\"]*)\" button will be disabled for both CLSD and CNCD status$")
	public void button_will_be_disabled_for_both_CLSD_and_CNCD_status(String buttonName) {
		Assert.assertFalse(myloAssignmentPage.verifyFileInfoFieldsReadOnly(buttonName),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, buttonName,
						MYLOConstants.AIRES_FILE_INFORMATION, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	@Given("^he is on Mylo Journey Summary page for file ID with \"([^\"]*)\"$")
	public void he_is_on_Mylo_Journey_Summary_page_for_file_ID_with(String fileType) {
		String fileId = myloJourneyPage.getFileInfoFieldByEnvtAndType(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileId);
		myloDashboardPage.clickExecuteButton();
	}

	@Then("^\"([^\"]*)\" dropdown should display as read only for \"([^\"]*)\"$")
	public void dropdown_should_display_as_read_only_for(String fieldName, String fileType) throws Throwable {
		myloAssignmentPage.verifyFileInfoFieldsForScenarioType(fileType, fieldName);
	}

	@Given("^he verifies the \"([^\"]*)\" checkbox to be unchecked after clicking on \"([^\"]*)\" under file information$")
	public void he_verifies_the_checkbox_to_be_unchecked_after_clicking_on_under_file_information(String checkBoxName,
			String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		Assert.assertFalse(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_SELECTED, CoreConstants.FAIL, MYLOConstants.FIRST,
						checkBoxName, MYLOConstants.AIRES_FILE_INFORMATION, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	@When("^he has updated the policy type to a \"([^\"]*)\" policy after clicking on \"([^\"]*)\" button$")
	public void he_has_updated_the_policy_type_to_a_policy_after_clicking_on_button(String policyName,
			String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.POLICY_TYPE, policyName);
	}

	@Then("^the \"([^\"]*)\" checkbox should be checked$")
	public void the_checkbox_should_be_checked(String checkBoxName) {
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName),
				MYLOConstants.CHECKBOX_NOT_SELECTED);
	}

	@Then("^a warning message should display as \"([^\"]*)\"$")
	public void a_warning_message_should_display_as(String msg) {
		Assert.assertTrue(myloAssignmentPage.verifyPopUpMessage(msg),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, msg,
						MYLOConstants.AIRES_FILE_INFORMATION));
	}

	@Given("^he has updated the office to \"([^\"]*)\" which is not equal to the Assignment office after clicking on \"([^\"]*)\"$")
	public void he_has_updated_the_office_to_which_is_not_equal_to_the_Assignment_office_after_clicking_on(
			String officeType, String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.OFFICE, officeType);
	}

	@Given("^he clicks on \"([^\"]*)\" button after he clicks on the \"([^\"]*)\" under file information$")
	public void he_clicks_on_button_after_he_clicks_on_the_under_file_information(String buttonName1,
			String buttonName2) {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName2);
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName1);
	}

	@Given("^a warning message \"([^\"]*)\" displayed after he selects \"([^\"]*)\" check box$")
	public void a_warning_message_displayed_after_he_selects_check_box(String msg, String checkBoxName) {
		myloAssignmentPage.clickToastMesssgeCloseIcon();
		myloAssignmentPage.clickCheckBoxOnAiresFileInfoSection(checkBoxName);
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessage(msg),
				MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_NOT_DISPLAYED, CoreConstants.PASS, msg,
						MYLOConstants.AIRES_FILE_INFORMATION));
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName),
				MYLOConstants.CHECKBOX_NOT_SELECTED);
	}

	@When("^he selects \"([^\"]*)\" checkbox under file information$")
	public void he_selects_checkbox_under_file_information(String checkBoxName) {
		myloAssignmentPage.clickCheckBoxOnAiresFileInfoSection(checkBoxName);
	}

	@Then("^\"([^\"]*)\" checkbox should automatically be checked$")
	public void checkbox_should_automatically_be_checked(String checkBoxName) {
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName),
				MYLOConstants.CHECKBOX_NOT_SELECTED);
	}

	@Then("^\"([^\"]*)\" checkbox should automatically unchecked after he unchecks the \"([^\"]*)\" box$")
	public void checkbox_should_automatically_unchecked_after_he_unchecks_the_box(String checkBoxName2,
			String checkBoxName1) {
		myloAssignmentPage.clickCheckBoxOnAiresFileInfoSection(checkBoxName1);
		Assert.assertFalse(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName2),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_SELECTED, CoreConstants.FAIL, MYLOConstants.FIRST,
						checkBoxName2, MYLOConstants.AIRES_FILE_INFORMATION, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	@Given("^a warning message \"([^\"]*)\" displayed after he clicks \"([^\"]*)\" check box$")
	public void a_warning_message_displayed_after_he_clicks_check_box(String msg, String checkBoxName) {
		myloAssignmentPage.clickCheckBoxOnAiresFileInfoSection(checkBoxName);
		Assert.assertTrue(myloAssignmentPage.verifyPopUpMessage(msg),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, msg,
						MYLOConstants.AIRES_FILE_INFORMATION));
	}

	@Given("^\"([^\"]*)\" checkbox is checked after he clicks on \"([^\"]*)\"$")
	public void checkbox_is_checked_after_he_clicks_on(String checkBoxName, String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName),
				MYLOConstants.CHECKBOX_NOT_SELECTED);
	}

	@Then("^\"([^\"]*)\" checkbox should be unchecked$")
	public void checkbox_should_be_unchecked(String checkBoxName) {
		Assert.assertFalse(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName),
				MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_SELECTED, CoreConstants.FAIL, MYLOConstants.FIRST,
						checkBoxName, MYLOConstants.AIRES_FILE_INFORMATION, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	@Given("^the \"([^\"]*)\" checkbox is \"([^\"]*)\"$")
	public void the_checkbox_is(String checkboxName, String checkBoxStatus) {
		myloAssignmentPage.verifyFileInfoCheckBoxIsChecked(checkboxName, checkBoxStatus);
	}

	@Given("^\"([^\"]*)\" checkbox is \"([^\"]*)\" after he clicks on \"([^\"]*)\"$")
	public void checkbox_is_after_he_clicks_on(String checkboxName, String checkBoxStatus, String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		myloAssignmentPage.verifyFileInfoCheckBoxIsChecked(checkboxName, checkBoxStatus);
	}

	@Then("^\"([^\"]*)\" checkbox should be \"([^\"]*)\"$")
	public void checkbox_should_be(String checkboxName, String checkBoxStatus) {
		myloAssignmentPage.verifyFileInfoCheckBoxIsChecked(checkboxName, checkBoxStatus);
	}

	@When("^he has clicked on the dropdown for \"([^\"]*)\" after clicking on \"([^\"]*)\" button$")
	public void he_has_clicked_on_the_dropdown_for_after_clicking_on_button(String fieldName, String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
	}

	@Then("^\"([^\"]*)\" should display in the list of values of the mentioned dropdown fields$")
	public void should_display_in_the_list_of_values_of_the_mentioned_dropdown_fields(String listValue,
			DataTable fields) {
		for (String fieldName : fields.raw().get(0)) {
			Assert.assertTrue(myloAssignmentPage.verifyFileInfoDropDownValues(fieldName, listValue),
					MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_VALUE_NOT_APPEARING, CoreConstants.FAIL,
							listValue, fieldName, MYLOConstants.AIRES_FILE_INFORMATION));
		}
	}

}