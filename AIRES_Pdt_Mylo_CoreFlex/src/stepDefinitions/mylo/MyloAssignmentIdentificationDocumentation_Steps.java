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
		myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
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
		myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
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
		myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he enters below invalid data combination for mandatory fields of \"([^\"]*)\" section$")
	public void he_enters_below_invalid_data_combination_for_mandatory_fields_of_section(String arg1, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
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
			String buttonName2, String arg2, String buttonName1, DataTable table) throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
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
	public void he_is_redirected_back_to_the_edit_screen_after_clicking_on_option(String buttonName) throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName);
		Assert.assertTrue(myloAssignmentPage.verifyMandatoryFieldValuesIdentificationAndDocumentationSection(0));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" option after clicking on \"([^\"]*)\" button$")
	public void he_clicks_on_option_after_clicking_on_button(String buttonName2, String buttonName1) throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName1);
		myloAssignmentPage.clickButtonOnIentificationAndDocumentationSection(buttonName2);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^identification record should not get updated as well as data should get reset to the initial values\\.$")
	public void identification_record_should_not_get_updated_as_well_as_data_should_get_reset_to_the_initial_values()
			throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY));
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
		myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		// Assert.assertFalse(myloAssignmentPage.verifyIdentDocButtonDisplayed(button1));
		// Assert.assertFalse(myloAssignmentPage.verifyIdentDocButtonDisplayed(button2));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he views Identification Records section for \"([^\"]*)\" file ID after relogging into the Mylo application with userType \"([^\"]*)\"$")
	public void he_views_Identification_Records_section_for_file_ID_after_relogging_into_the_Mylo_application_with_userType(
			String fileType, String userType) throws InterruptedException {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		loginPage.loginWithUser(userType);
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.FILE_ID_ENTERED, CoreConstants.PASS, fileID));
		myloDashboardPage.clickExecuteButton();
		myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
		myloAssignmentPage.highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
		
	}

	@Then("^\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" icons of Identification Records section should get enabled for \"([^\"]*)\" fileID$")
	public void icons_of_Identification_Records_section_should_get_enabled_for_fileID(String button1, String button2,
			String arg3, String arg4)  {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyIdentDocButtonDisplayed(button2));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

}
