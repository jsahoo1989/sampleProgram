package stepDefinitions.mylo;

import java.util.Date;
import java.util.List;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.testdatatypes.mylo.MyloAssignmentDetails;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloAssignmentFileInformation_Steps {
	private TestContext testContext;
	//private Mylo_LoginPage loginPage;
	private Mylo_DashboardHomePage myloDashboardPage;
	private Mylo_AssignmentPage myloAssignmentPage;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);
	MyloAssignmentDetails assignmentDetails = FileReaderManager.getInstance().getMyloJsonReader()
			.getAssignmentDetailsByApplication(MYLOConstants.IRIS);

	public MyloAssignmentFileInformation_Steps(TestContext context) {
		testContext = context;
		//loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
	}
	
	@Given("^he views the File Information section where \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" are hard coded with background color \"([^\"]*)\"$")
	public void he_views_the_File_Information_section_where_are_hard_coded_with_background_color(String fieldName1, String fieldName2, String fieldName3, String colorCode) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		String environment=CoreFunctions.getPropertyFromConfig("envt");
		String fileID = null,clientID = null,clientName = null,policyType = null;
		if(environment.equals(MYLOConstants.UAT)) {
			clientID = assignmentDetails.activeAssignment.clientID;
			clientName=assignmentDetails.activeAssignment.clientName;
			policyType=assignmentDetails.activeAssignment.policyType;
			fileID=assignmentDetails.activeAssignment.fileID;
		}	
		else if(environment.equals(MYLOConstants.RELONETQA4)) {
			clientID = assignmentDetails.activeAssignment_relonetqa4.clientID;
			clientName=assignmentDetails.activeAssignment_relonetqa4.clientName;
			policyType=assignmentDetails.activeAssignment_relonetqa4.policyType;
			fileID=assignmentDetails.activeAssignment_relonetqa4.fileID;
		}
		
		Assert.assertTrue(
				myloAssignmentPage.verifyFileInfoDisplayedFields(fileID,
						clientID + "-"
								+ clientName,
								policyType),
				MYLOConstants.INCORRECT_FIELD_VALUES_IN_FILEINFO);
		Assert.assertTrue(myloAssignmentPage.verifyElementCSSValue(fieldName1, "background-color", colorCode));
		Assert.assertTrue(myloAssignmentPage.verifyElementCSSValue(fieldName2, "background-color", colorCode));
		Assert.assertTrue(myloAssignmentPage.verifyElementCSSValue(fieldName3, "background-color", colorCode));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on the button \"([^\"]*)\" under the file information section$")
	public void he_clicks_on_the_button_under_the_file_information_section(String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^the file information should expand to display additional fields$")
	public void the_file_information_should_expand_to_display_additional_fields() {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoAdditionalFieldsDisplayed(),
				MYLOConstants.ADDITIONAL_FIELDS_FILEINFO_NOT_DISPLAYED);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^\"([^\"]*)\" of the file is not \"([^\"]*)\" or \"([^\"]*)\"$")
	public void of_the_file_is_not_or(String fieldName, String statusName1, String statusName2) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		String statusDisplayed = myloAssignmentPage.getFileInfoFieldValue(fieldName);
		Assert.assertNotEquals(statusDisplayed, statusName1, MYLOConstants.MISMATCH_VALUE + fieldName);
		Assert.assertNotEquals(statusDisplayed, statusName2, MYLOConstants.MISMATCH_VALUE + fieldName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" button will be enabled for Resource(\\d+) or disabled for Without Resource(\\d+) depending on \"([^\"]*)\"$")
	public void button_will_be_enabled_for_Resource_or_disabled_for_Without_Resource_depending_on(String fieldName,
			int arg2, int arg3, String userType) throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.verifyFileInfoFieldsForScenarioType(userType, fieldName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has updated some fields in the file information section after clicking on \"([^\"]*)\" button$")
	public void he_has_updated_some_fields_in_the_file_information_section_after_clicking_on_button(String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoAdditionalFieldsDisplayed(),
				MYLOConstants.ADDITIONAL_FIELDS_FILEINFO_NOT_DISPLAYED);
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.POLICY_TYPE, MYLOConstants.RANDOM);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.JOURNEY_TYPE, MYLOConstants.JOURNEY_TYPE2_VALUE);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.HOMESTATUS, MYLOConstants.HOMESTATUS2_VALUE);
		myloAssignmentPage.clickCheckBoxOnAiresFileInfoSection(MYLOConstants.INHERITED_FILE);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^updated fields should be saved or not saved depending on the \"([^\"]*)\" clicked in the Assignment File information section$")
	public void updated_fields_should_be_saved_or_not_saved_depending_on_the_clicked_in_the_Assignment_File_information_section(
			String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.verifyFileInfoFieldsOnClickedButton(buttonName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" of the file should be \"([^\"]*)\"$")
	public void of_the_file_should_be(String fieldName, String statusName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertEquals(myloAssignmentPage.getFileInfoFieldValue(fieldName), statusName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" button will be disabled for both CLSD and CNCD status$")
	public void button_will_be_disabled_for_both_CLSD_and_CNCD_status(String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertFalse(myloAssignmentPage.verifyFileInfoFieldsReadOnly(buttonName));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he is on Mylo Assignment Summary page for file ID with \"([^\"]*)\"$")
	public void he_is_on_Mylo_Assignment_Summary_page_for_file_ID_with(String fileType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		String fileId = myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileId);
		myloDashboardPage.clickExecuteButton();
		//Assert.assertTrue(myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY),
			//	MYLOConstants.SUMMARY + MYLOConstants.TAB_NOT_ACTIVE);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" dropdown should display as read only for \"([^\"]*)\"$")
	public void dropdown_should_display_as_read_only_for(String fieldName, String fileType) throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.verifyFileInfoFieldsForScenarioType(fileType, fieldName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he verifies the \"([^\"]*)\" checkbox to be unchecked after clicking on \"([^\"]*)\" under file information$")
	public void he_verifies_the_checkbox_to_be_unchecked_after_clicking_on_under_file_information(String checkBoxName,
			String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		Assert.assertFalse(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName),
				MYLOConstants.CHECKBOX_NOT_SELECTED);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he has updated the policy type to a \"([^\"]*)\" policy after clicking on \"([^\"]*)\" button$")
	public void he_has_updated_the_policy_type_to_a_policy_after_clicking_on_button(String policyName,
			String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.POLICY_TYPE, policyName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^the \"([^\"]*)\" checkbox should be checked$")
	public void the_checkbox_should_be_checked(String checkBoxName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName),
				MYLOConstants.CHECKBOX_NOT_SELECTED);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^a warning message should display as \"([^\"]*)\"$")
	public void a_warning_message_should_display_as(String msg) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyPopUpMessage(msg));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he has updated the office to \"([^\"]*)\" which is not equal to the Assignment office after clicking on \"([^\"]*)\"$")
	public void he_has_updated_the_office_to_which_is_not_equal_to_the_Assignment_office_after_clicking_on(
			String officeType, String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.OFFICE, officeType);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he clicks on \"([^\"]*)\" button after he clicks on the \"([^\"]*)\" under file information$")
	public void he_clicks_on_button_after_he_clicks_on_the_under_file_information(String buttonName1,
			String buttonName2) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName2);
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName1);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^a warning message \"([^\"]*)\" displayed after he selects \"([^\"]*)\" check box$")
	public void a_warning_message_displayed_after_he_selects_check_box(String msg, String checkBoxName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickToastMesssgeCloseIcon();
		myloAssignmentPage.clickCheckBoxOnAiresFileInfoSection(checkBoxName);
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessage(msg));
		//myloAssignmentPage.clickButtonOnAiresFileInformationSection(MYLOConstants.OK_BUTTON);
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he selects \"([^\"]*)\" checkbox under file information$")
	public void he_selects_checkbox_under_file_information(String checkBoxName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickCheckBoxOnAiresFileInfoSection(checkBoxName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" checkbox should automatically be checked$")
	public void checkbox_should_automatically_be_checked(String checkBoxName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" checkbox should automatically unchecked after he unchecks the \"([^\"]*)\" box$")
	public void checkbox_should_automatically_unchecked_after_he_unchecks_the_box(String checkBoxName2,
			String checkBoxName1) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickCheckBoxOnAiresFileInfoSection(checkBoxName1);
		Assert.assertFalse(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName2));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^a warning message \"([^\"]*)\" displayed after he clicks \"([^\"]*)\" check box$")
	public void a_warning_message_displayed_after_he_clicks_check_box(String msg, String checkBoxName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickCheckBoxOnAiresFileInfoSection(checkBoxName);
		Assert.assertTrue(myloAssignmentPage.verifyPopUpMessage(msg));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^\"([^\"]*)\" checkbox is checked after he clicks on \"([^\"]*)\"$")
	public void checkbox_is_checked_after_he_clicks_on(String checkBoxName, String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" checkbox should be unchecked$")
	public void checkbox_should_be_unchecked(String checkBoxName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertFalse(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^the \"([^\"]*)\" checkbox is \"([^\"]*)\"$")
	public void the_checkbox_is(String checkboxName, String checkBoxStatus) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.verifyFileInfoCheckBoxIsChecked(checkboxName, checkBoxStatus);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^\"([^\"]*)\" checkbox is \"([^\"]*)\" after he clicks on \"([^\"]*)\"$")
	public void checkbox_is_after_he_clicks_on(String checkboxName, String checkBoxStatus, String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		myloAssignmentPage.verifyFileInfoCheckBoxIsChecked(checkboxName, checkBoxStatus);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" checkbox should be \"([^\"]*)\"$")
	public void checkbox_should_be(String checkboxName, String checkBoxStatus) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.verifyFileInfoCheckBoxIsChecked(checkboxName, checkBoxStatus);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he has clicked on the dropdown for \"([^\"]*)\" after clicking on \"([^\"]*)\" button$")
	public void he_has_clicked_on_the_dropdown_for_after_clicking_on_button(String fieldName, String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^\"([^\"]*)\" should display in the list of values of the \"([^\"]*)\"  dropdown$")
	public void should_display_in_the_list_of_values_of_the_dropdown(String listValue, String fieldName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoDropDownValues(fieldName, listValue));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Then("^\"([^\"]*)\" should display in the list of values of the mentioned dropdown fields$")
	public void should_display_in_the_list_of_values_of_the_mentioned_dropdown_fields(String listValue, DataTable fields) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();	
		for (String fieldName  : fields.raw().get(0)) {
			Assert.assertTrue(myloAssignmentPage.verifyFileInfoDropDownValues(fieldName, listValue));		
		}	
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

}