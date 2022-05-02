package stepDefinitions.mylo;

import java.util.Date;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloAssignment_TransfereeFamilyPage;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloAssignmentTransfereeFamily_Steps {
	TestContext testContext;
	Mylo_LoginPage loginPage;
	Mylo_DashboardHomePage myloDashboardPage;
	Mylo_AssignmentPage myloAssignmentPage;
	MyloAssignment_TransfereeFamilyPage myloAssignmentTransfereePage;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloAssignmentTransfereeFamily_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
		myloAssignmentTransfereePage = testContext.getMyloPageObjectManager().getAssignmentTransfereePage();
	}
	
	@Given("^he is on \"([^\"]*)\" section after clicking on \"([^\"]*)\" displayed in right panel under \"([^\"]*)\" section for \"([^\"]*)\" fileID$")
	public void he_is_on_section_after_clicking_on_displayed_in_right_panel_under_section_for_fileID(String sectionHeader1, String expandSection, String sectionHeader, String fileType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.verifyUserName(MYLOConstants.USER_PROFILE_NAME);
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		myloAssignmentTransfereePage.highlightSectionHeader(sectionHeader);
		myloAssignmentTransfereePage.highlightSectionHeader(sectionHeader1);
		myloAssignmentTransfereePage.clickElementOnTransfereeSection(MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
		myloAssignmentTransfereePage.clickElementOnTransfereeSection(expandSection);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@When("^he clicks on below dropdown fields$")
	public void he_clicks_on_below_dropdown_fields(DataTable table){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentTransfereePage.clickElementOnTransfereeSection(MYLOConstants.EDIT_BUTTON);
		myloAssignmentTransfereePage.clickElementOnTransfereeSection(MYLOConstants.TRANSFEREE_ADD_PHONE);
		myloAssignmentTransfereePage.clickElementOnTransfereeSection(MYLOConstants.TRANSFEREE_ADD_EMAIL);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloAssignmentTransfereePage.clickElementOnTransfereeSection(data.get(i).get(MYLOConstants.FIELD_NAME));
		}
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^list of values displayed in the dropdown for below fields should match with the values present in respective tables on database$")
	public void list_of_values_displayed_in_the_dropdown_for_below_fields_should_match_with_the_values_present_in_respective_tables_on_database(DataTable table){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue(myloAssignmentTransfereePage.verifyFieldDropdownListValues(data.get(i).get(MYLOConstants.FIELD_NAME)));
		} 
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he enters below fields under \"([^\"]*)\" section after clicking on \"([^\"]*)\" button$")
	public void he_enters_below_fields_under_section_after_clicking_on_button(String section, String buttonName, DataTable table){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentTransfereePage.clickElementOnTransfereeSection(buttonName);
		Assert.assertTrue(myloAssignmentTransfereePage.verifyMandatoryFieldsToastMessagesTransfereeSection(table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@When("^he clicks on \"([^\"]*)\" button after entering below valid transferee data for mandatory fields under \"([^\"]*)\" section$")
	public void he_clicks_on_button_after_entering_below_valid_transferee_data_for_mandatory_fields_under_section(String buttonName, String section, DataTable table) throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentTransfereePage.verifyMandatoryFieldsToastMessagesTransfereeSection(table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^entered data for below transferee fields should be successfully saved in \"([^\"]*)\" section$")
	public void entered_data_for_below_transferee_fields_should_be_successfully_saved_in_section(String section, DataTable table)  {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentTransfereePage.verifyDifferentTransfereeFieldsUpdatedValue(table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Then("^messages corresponding to below fields should be displayed after entering \"([^\"]*)\" for different fields under \"([^\"]*)\" section$")
	public void messages_corresponding_to_below_fields_should_be_displayed_after_entering_for_different_fields_under_section(String arg1, String arg2, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentTransfereePage.clickElementOnTransfereeSection(MYLOConstants.EDIT_BUTTON);
		Assert.assertTrue(myloAssignmentTransfereePage.verifySpecialCharacterToastMessagesTransfereeSection(table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^he enters below invalid data for different fields with other mandatory data being provided under \"([^\"]*)\" section$")
	public void he_enters_below_invalid_data_for_different_fields_with_other_mandatory_data_being_provided_under_section(String arg1, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentTransfereePage.clickElementOnTransfereeSection(MYLOConstants.EDIT_BUTTON);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloAssignmentTransfereePage.setTransfereeFields(data.get(i).get(MYLOConstants.FIELD_NAME),data.get(i).get(MYLOConstants.CHARACTER_LENGTH));
		}
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" button present under \"([^\"]*)\" section$")
	public void he_clicks_on_button_present_under_section(String buttonName, String arg2){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentTransfereePage.clickElementOnTransfereeSection(buttonName);
		Assert.assertTrue(myloAssignmentTransfereePage.verifyAlertMessage(MYLOConstants.SAVE_SUCCESS_MESSAGE, MYLOConstants.TRANSFEREE_FAMILY));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^values should be successfully saved as per below character limit set for different fields under \"([^\"]*)\" section$")
	public void values_should_be_successfully_saved_as_per_below_character_limit_set_for_different_fields_under_section(String arg1, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentTransfereePage.verifyDifferentTransfereeFieldsUpdatedValue(table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
}
