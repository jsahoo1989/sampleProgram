package stepDefinitions.mylo;

import org.testng.Assert;

import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.MyloAssignmentDetails;
import com.aires.testdatatypes.mylo.Mylo_LoginData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloAssignmentFileInformation_Steps {
	TestContext testContext;
	Mylo_LoginPage loginPage;
	Mylo_DashboardHomePage myloDashboardPage;
	Mylo_AssignmentPage myloAssignmentPage;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);
	MyloAssignmentDetails assignmentDetails = FileReaderManager.getInstance().getMyloJsonReader()
			.getAssignmentDetailsByApplication(MYLOConstants.IRIS);

	public MyloAssignmentFileInformation_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
	}

	@Given("^he views the File Information section where File ID, Client ID & Name, Policy Type are hard coded with color \"([^\"]*)\"$")
	public void he_views_the_File_Information_section_where_File_ID_Client_ID_Name_Policy_Type_are_hard_coded_with_color(
			String arg1) throws Throwable {
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoDisplayedFields(MYLOConstants.FILE_ID_DATA_UPDATION,
				assignmentDetails.activeAssignment.clientID + "-" + assignmentDetails.activeAssignment.clientName,
				assignmentDetails.activeAssignment.policyType),MYLOConstants.INCORRECT_FIELD_VALUES_IN_FILEINFO);
	}

	@When("^he clicks on the \"([^\"]*)\" under file information$")
	public void he_clicks_on_the_under_file_information(String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
	}

	@Then("^the file information will expand to display additional fields$")
	public void the_file_information_will_expand_to_display_additional_fields() {
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoAdditionalFieldsDisplayed(),MYLOConstants.ADDITIONAL_FIELDS_FILEINFO_NOT_DISPLAYED);
	}

	@Given("^\"([^\"]*)\" of the file is not \"([^\"]*)\" or \"([^\"]*)\"$")
	public void of_the_file_is_not_or(String fieldName, String statusName1, String statusName2) {
		Assert.assertNotEquals(myloAssignmentPage.getFileInfoFieldValue(fieldName), statusName1,MYLOConstants.MISMATCH_VALUE + fieldName);
		Assert.assertNotEquals(myloAssignmentPage.getFileInfoFieldValue(fieldName), statusName2,MYLOConstants.MISMATCH_VALUE + fieldName);
	}

	@Then("^\"([^\"]*)\" button will be enabled for Resource(\\d+) or disabled for Without Resource(\\d+) depending on \"([^\"]*)\"$")
	public void button_will_be_enabled_for_Resource_or_disabled_for_Without_Resource_depending_on(String fieldName,
			int arg2, int arg3, String userType) throws Throwable {
		myloAssignmentPage.verifyFileInfoFieldsForScenarioType(userType, fieldName);
	}

	@Given("^he has updated some fields in the file information section after clicking on \"([^\"]*)\" button$")
	public void he_has_updated_some_fields_in_the_file_information_section_after_clicking_on_button(String arg1)
			throws Throwable {
		myloAssignmentPage.verifyFileInfoAdditionalFieldsDisplayed();
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(MYLOConstants.EDIT_BUTTON);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.POLICY_TYPE, MYLOConstants.RANDOM);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.JOURNEY_TYPE, MYLOConstants.RANDOM);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.HOMESTATUS, MYLOConstants.RANDOM);
		myloAssignmentPage.clickCheckBoxOnAiresFileInfoSection(MYLOConstants.INHERITED_FILE);
	}

	@When("^he clicks on \"([^\"]*)\" button in file information section$")
	public void he_clicks_on_button_in_file_information_section(String arg1) throws Throwable {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(MYLOConstants.SAVE_BUTTON);
		Assert.assertTrue(myloAssignmentPage.verifyMessage(MYLOConstants.SUCCESS_MESSAGE));
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(MYLOConstants.OK_BUTTON);

	}

	@Then("^updated fields should be saved in the Assignment File information section$")
	public void updated_fields_should_be_saved_in_the_Assignment_File_information_section() throws Throwable {
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoUpdatedFields(MYLOConstants.POLICY_TYPE));
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoUpdatedFields(MYLOConstants.JOURNEY_TYPE));
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoUpdatedFields(MYLOConstants.HOMESTATUS));
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoCheckboxSelected(MYLOConstants.INHERITED_FILE));
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(MYLOConstants.EDIT_BUTTON);
		myloAssignmentPage.clickCheckBoxOnAiresFileInfoSection(MYLOConstants.INHERITED_FILE);
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(MYLOConstants.SAVE_BUTTON);
		Assert.assertTrue(myloAssignmentPage.verifyMessage(MYLOConstants.SUCCESS_MESSAGE));
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(MYLOConstants.OK_BUTTON);
	}

	@Then("^\"([^\"]*)\" of the file should be \"([^\"]*)\"$")
	public void of_the_file_should_be(String fieldName, String statusName) {
		Assert.assertEquals(myloAssignmentPage.getFileInfoFieldValue(fieldName), statusName);
	}

	@Then("^\"([^\"]*)\" button will be disabled for both CLSD and CNCD status$")
	public void button_will_be_disabled_for_both_CLSD_and_CNCD_status(String buttonName) {
		Assert.assertFalse(myloAssignmentPage.verifyFileInfoFieldsReadOnly(buttonName));
	}
	
	@Given("^he is on Mylo Assignment Summary page for file ID with \"([^\"]*)\"$")
	public void he_is_on_Mylo_Assignment_Summary_page_for_file_ID_with(String fileProviderName) {
		String fileId=myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileProviderName, MYLOConstants.FILE_ID);
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.ASSIGNMENT);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileId);
		myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY),
				MYLOConstants.SUMMARY + MYLOConstants.TAB_NOT_ACTIVE);
	}

	@Then("^\"([^\"]*)\" dropdown should display as read only for \"([^\"]*)\"$")
	public void dropdown_should_display_as_read_only_for(String fieldName, String fileStatusMode) throws InterruptedException {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(MYLOConstants.EDIT_BUTTON);
		myloAssignmentPage.verifyFileInfoFieldsForScenarioType(fileStatusMode, fieldName);
	}
	
	@Given("^he verifies the \"([^\"]*)\" checkbox to be unchecked after clicking on \"([^\"]*)\" under file information$")
	public void he_verifies_the_checkbox_to_be_unchecked_after_clicking_on_under_file_information(String checkBoxName, String buttonName){
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		Assert.assertFalse(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName),MYLOConstants.CHECKBOX_NOT_SELECTED);
	}

	@When("^he has updated the policy type to a \"([^\"]*)\" policy after clicking on \"([^\"]*)\" button$")
	public void he_has_updated_the_policy_type_to_a_policy_after_clicking_on_button(String policyName, String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(buttonName);
		myloAssignmentPage.updateFileInfoFields(MYLOConstants.POLICY_TYPE, policyName);
	}

	@Then("^the \"([^\"]*)\" checkbox should be checked$")
	public void the_checkbox_should_be_checked(String checkBoxName) {
		Assert.assertTrue(myloAssignmentPage.verifyFileInfoCheckboxSelected(checkBoxName),MYLOConstants.CHECKBOX_NOT_SELECTED);
	}

}
