package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeSection;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.MyloMemoryCapacityFileIds;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloDashboard_Steps {
	TestContext testContext;
	Mylo_LoginPage loginPage;
	Mylo_DashboardHomePage myloDashboardPage;
	Mylo_AssignmentPage myloAssignmentPage;
	MyloJourneyPage_TransfereeSection myloJourneyPageTransfereeSection;
	Mylo_JourneyPage myloJourneyPage;
	String sortColName;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);
	MyloMemoryCapacityFileIds myloFileIdDetails = FileReaderManager.getInstance().getMyloJsonReader()
			.getFileIdListByEnv("DEV5");

	public MyloDashboard_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
	}

	/**
	 * Logging into the Mylo application and verify the username logged in
	 * 
	 * @throws Throwable
	 */
	@Given("^he has logged into the 'Mylo' application$")
	public void he_has_logged_into_the_Mylo_application() throws Throwable {
		loginPage.openApplication();
		loginPage.enterUserEmailAndPasswordForMylo(loginData.MyloUserName, loginData.MyloPassword);
		loginPage.clickSignIn();
		Assert.assertTrue(myloDashboardPage.verifyUserName(loginData.MyloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						loginData.MyloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	/**
	 * Verify the username logged in
	 */
	@Given("^he is on Mylo Dashboard Home page$")
	public void he_is_on_Mylo_Dashboard_Home_page() {
		Assert.assertTrue(myloDashboardPage.verifyUserName(loginData.MyloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						loginData.MyloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	@When("^he clicks on the \"([^\"]*)\" \"([^\"]*)\" option in the Mylo Menu on the sidebar$")
	public void he_clicks_on_the_option_in_the_Mylo_Menu_on_the_sidebar(String section, String subSection) {
		myloDashboardPage.clickOptionFromMainMenu(section);
		myloDashboardPage.selectOptionsFromAssignmentMenu(subSection);
	}

	@Then("^the Select Query Type screen should display with the given parameters$")
	public void the_Select_Query_Type_screen_should_display_with_the_given_parameters(DataTable data) {
		Assert.assertTrue(myloDashboardPage.verifySelectQueryOptions(data), MYLOConstants.INCORRECT_QUERY_PARAMETERS);
	}

	@Given("^he selects \"([^\"]*)\" section after clicking on \"([^\"]*)\" option in the Mylo Menu on the sidebar$")
	public void he_selects_section_after_clicking_on_option_in_the_Mylo_Menu_on_the_sidebar(String parameter,
			String mainMenuOption) {
		myloDashboardPage.clickOptionFromMainMenu(mainMenuOption);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(parameter);
	}

	@Given("^Select Parameter popup should display all the given parameters$")
	public void select_Parameter_popup_should_display_all_the_given_parameters(DataTable data) {
		Assert.assertTrue(myloDashboardPage.verifyFileParameterOptions(data),
				MYLOConstants.FILE_PARAMETERS_OPTIONS_NOT_MATCHING);

	}

	@Given("^Message \"([^\"]*)\" is displayed after clicking on Execute button$")
	public void message_is_displayed_after_clicking_on_Execute_button(String message) {
		myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(myloDashboardPage.verifyPopUpMessageAfterExecute(message),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, message,
						MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	@Given("^alert message \"([^\"]*)\" is displayed after clicking on Execute button$")
	public void alert_message_is_displayed_after_clicking_on_Execute_button(String message) {
		myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessage(message),
				MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, message,
						MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	@Given("^Message \"([^\"]*)\" is displayed after clicking on Execute button with invalid File ID \"([^\"]*)\"$")
	public void message_is_displayed_after_clicking_on_Execute_button_with_invalid_File_ID(String message,
			String fileID) {
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		Assert.assertTrue(myloDashboardPage.verifyPopUpMessageAfterExecute(message),
				MessageFormat.format(MYLOConstants.VERIFIED_POPUP_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, message,
						MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	@When("^user clicks on Execute button after entering valid Client Id \"([^\"]*)\", Status \"([^\"]*)\", Origin Country \"([^\"]*)\" and Destination Country \"([^\"]*)\"$")
	public void user_clicks_on_Execute_button_after_entering_valid_Client_Id_Status_Origin_Country_and_Destination_Country(
			String clientID, String status, String orgCountry, String destCountry) {
		myloDashboardPage.resetFileParameters();
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.CLIENT_ID, clientID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.STATUS, status);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.ORIGIN_COUNTRY, orgCountry);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.DESTINATION_COUNTRY, destCountry);
		myloDashboardPage.clickExecuteButton();
	}

	@Then("^Query results should appear based on the parameter provided sorted by File ID$")
	public void query_results_should_appear_based_on_the_parameter_provided_sorted_by_File_ID() {
		Assert.assertTrue(myloDashboardPage.verifyQueryResults(MYLOConstants.STATUS, MYLOConstants.STATUS_VALUE),
				MessageFormat.format(MYLOConstants.VERIFIED_VALUE_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.STATUS, MYLOConstants.STATUS_VALUE, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		Assert.assertTrue(myloDashboardPage.verifyQueryResults(MYLOConstants.ORIGIN, MYLOConstants.COUNTRY_NAME),
				MessageFormat.format(MYLOConstants.VERIFIED_VALUE_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.ORIGIN, MYLOConstants.COUNTRY_NAME, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		Assert.assertTrue(myloDashboardPage.verifyQueryResults(MYLOConstants.DESTINATION, MYLOConstants.COUNTRY_NAME),
				MessageFormat.format(MYLOConstants.VERIFIED_VALUE_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.DESTINATION, MYLOConstants.COUNTRY_NAME, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	@Given("^he queries \"([^\"]*)\" files for clientId \"([^\"]*)\"$")
	public void he_queries_files_for_clientId(String statusName, String clientID) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.CLIENT_ID, clientID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.STATUS, statusName);
		myloDashboardPage.clickExecuteButton();
	}

	@Then("^he is on \"([^\"]*)\" section after selecting \"([^\"]*)\" tab on \"([^\"]*)\" for (\\d+) different files selected each time from the query results$")
	public void he_is_on_section_after_selecting_tab_on_for_different_files_selected_each_time_from_the_query_results(
			String arg1, String arg2, String arg3, int maxLimit) {
		myloDashboardPage.navigateActFinanceSectionForDifffileIds(maxLimit);
	}

	@Given("^he is on Mylo Dashboard Home page with different fileIds used for checking memory capacity$")
	public void he_is_on_Mylo_Dashboard_Home_page_with_different_fileIds_used_for_checking_memory_capacity() {
		String[] fileIDS = myloFileIdDetails.fileId.split(",");
		List<String> fileIds = Arrays.asList(fileIDS);
		myloDashboardPage.executeDifferentFileIds(fileIds.size(), fileIds);
	}

	@When("^he loads the file alternatively for given number of times on Mylo Journey page$")
	public void he_loads_the_file_alternatively_for_given_number_of_times_on_Mylo_Journey_page() {
		myloDashboardPage.loadAlternateFiles();
	}

	@Then("^browser should not be crashed for loading files continuosly$")
	public void browser_should_not_be_crashed_for_loading_files_continuosly() {

	}

	@When("^he clicks on 'Execute' button after selecting any 'Status' from 'FileStatus'dropdown on 'Query Your Files by Status' popup$")
	public void he_clicks_on_Execute_button_after_selecting_any_Status_from_FileStatus_dropdown_on_Query_Your_Files_by_Status_popup() {
		myloDashboardPage.selectFileStatus(MYLOConstants.BOOKED);
		myloDashboardPage.clickFieldsOnMyFilesSection(MYLOConstants.EXECUTE);
		myloDashboardPage.checkMyFilesResultModalAppears(MYLOConstants.BOOKED, MYLOConstants.NONE);
	}

	@Then("^related files should get appear into the query result modal as per the selected 'Status'$")
	public void related_files_should_get_appear_into_the_query_result_modal_as_per_the_selected_Status() {
		Assert.assertTrue(
				myloDashboardPage.verifyMyFilesResultFromDB(MYLOConstants.MXSSO_DEV5_EMP_NO, MYLOConstants.FILEID,
						MYLOConstants.STATUS),
				MessageFormat.format(MYLOConstants.VERIFIED_RESULTS_MATCH_WITH_DATABSE, CoreConstants.FAIL,
						MYLOConstants.FILEID, MYLOConstants.MY_FILES));
		Assert.assertTrue(
				myloDashboardPage.verifyMyFilesResultFromDB(MYLOConstants.MXSSO_DEV5_EMP_NO, MYLOConstants.CLIENTNAME,
						MYLOConstants.STATUS),
				MessageFormat.format(MYLOConstants.VERIFIED_RESULTS_MATCH_WITH_DATABSE, CoreConstants.FAIL,
						MYLOConstants.CLIENTNAME, MYLOConstants.MY_FILES));
		Assert.assertTrue(
				myloDashboardPage.verifyMyFilesResultFromDB(MYLOConstants.MXSSO_DEV5_EMP_NO, MYLOConstants.STATUS,
						MYLOConstants.STATUS),
				MessageFormat.format(MYLOConstants.VERIFIED_RESULTS_MATCH_WITH_DATABSE, CoreConstants.FAIL,
						MYLOConstants.STATUS, MYLOConstants.MY_FILES));
	}

	@Given("^he is on \"([^\"]*)\" popup by selecting \"([^\"]*)\" option available on \"([^\"]*)\" section$")
	public void he_is_on_popup_by_selecting_option_available_on_section(String popUpHeader, String subSection,
			String section) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(section);
		myloDashboardPage.selectParameterFromQueryScreen(subSection);
		Assert.assertTrue(myloJourneyPage.verifySectionHeader(subSection, popUpHeader), MessageFormat
				.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL, popUpHeader, subSection));
	}

	@Then("^following check boxes should get appear under 'My Files' section$")
	public void following_check_boxes_should_get_appear_under_My_Files_section(DataTable table) {
		Assert.assertTrue(myloDashboardPage.verifyMyFilesCheckBoxesDisplayed(table), MessageFormat.format(
				MYLOConstants.VERIFIED_CHECKBOX_OPTIONS_DOESNT_MATCH, CoreConstants.FAIL, MYLOConstants.MY_FILES));
	}

	@When("^he clicks on \"([^\"]*)\" dropdown on 'My Files' section$")
	public void he_clicks_on_dropdown_on_My_Files_section(String fieldName) {
		myloDashboardPage.clickFieldsOnMyFilesSection(MYLOConstants.FILE_STATUS);
	}

	@Then("^\"([^\"]*)\" dropdown should display the below options on \"([^\"]*)\" section$")
	public void dropdown_should_display_the_below_options_on_section(String arg1, String arg2, DataTable table) {
		Assert.assertTrue(myloDashboardPage.verifyStatusOptionsDisplayed(table),
				MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_DOESNT_MATCH, CoreConstants.FAIL,
						MYLOConstants.FILE_STATUS, MYLOConstants.MY_FILES));
	}

	@Then("^related files should get appear into the query result modal as per the selected 'Status' with 'checkbox'$")
	public void related_files_should_get_appear_into_the_query_result_modal_as_per_the_selected_Status_with_checkbox() {
		myloDashboardPage.checkMyFilesResultModalAppears(MYLOConstants.RANDOM, MYLOConstants.RANDOM);
		Assert.assertTrue(
				myloDashboardPage.verifyMyFilesResultFromDB(MYLOConstants.MXSSO_DEV5_EMP_NO, MYLOConstants.FILEID,
						MYLOConstants.CHECKBOX),
				MessageFormat.format(MYLOConstants.VERIFIED_RESULTS_MATCH_WITH_DATABSE, CoreConstants.FAIL,
						MYLOConstants.FILEID, MYLOConstants.MY_FILES));
		Assert.assertTrue(
				myloDashboardPage.verifyMyFilesResultFromDB(MYLOConstants.MXSSO_DEV5_EMP_NO, MYLOConstants.CLIENTNAME,
						MYLOConstants.CHECKBOX),
				MessageFormat.format(MYLOConstants.VERIFIED_RESULTS_MATCH_WITH_DATABSE, CoreConstants.FAIL,
						MYLOConstants.CLIENTNAME, MYLOConstants.MY_FILES));
		Assert.assertTrue(
				myloDashboardPage.verifyMyFilesResultFromDB(MYLOConstants.MXSSO_DEV5_EMP_NO,
						MYLOConstants.TRANSFEREENAME, MYLOConstants.CHECKBOX),
				MessageFormat.format(MYLOConstants.VERIFIED_RESULTS_MATCH_WITH_DATABSE, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREENAME, MYLOConstants.MY_FILES));
		Assert.assertTrue(
				myloDashboardPage.verifyMyFilesResultFromDB(MYLOConstants.MXSSO_DEV5_EMP_NO, MYLOConstants.STATUS,
						MYLOConstants.CHECKBOX),
				MessageFormat.format(MYLOConstants.VERIFIED_RESULTS_MATCH_WITH_DATABSE, CoreConstants.FAIL,
						MYLOConstants.STATUS, MYLOConstants.MY_FILES));
	}

	@Given("^he is on \"([^\"]*)\" modal after random selection of File Status on 'MyFiles' section$")
	public void he_is_on_modal_after_random_selection_of_File_Status_on_MyFiles_section(String arg1) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.MY_FILES);
		Assert.assertTrue(myloJourneyPage.verifySectionHeader(MYLOConstants.MY_FILES, MYLOConstants.MY_FILES_HEADER),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.MY_FILES_HEADER, MYLOConstants.MY_FILES));
		myloDashboardPage.selectFileStatus(MYLOConstants.RANDOM);
		myloDashboardPage.selectMyFilesCheckBox(MYLOConstants.NONE);
		myloDashboardPage.clickFieldsOnMyFilesSection(MYLOConstants.EXECUTE);
		myloDashboardPage.checkMyFilesResultModalAppears(MYLOConstants.RANDOM, MYLOConstants.NONE);
		Assert.assertTrue(
				myloJourneyPage.verifySectionHeader(MYLOConstants.MY_FILES_QUERY_RESULT,
						MYLOConstants.MY_FILES_RESULT_HEADER),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.MY_FILES_RESULT_HEADER, MYLOConstants.MY_FILES_QUERY_RESULT));
	}

	@When("^he clicks on a 'caret' next to any column on \"([^\"]*)\" modal$")
	public void he_clicks_on_a_caret_next_to_any_column_on_modal(String arg1) {
		sortColName = myloDashboardPage.clickColumnCaretButton(MYLOConstants.RANDOM);
	}

	@Then("^that column should be sorted in ascending order with caret pointing upwards$")
	public void that_column_should_be_sorted_in_ascending_order_with_caret_pointing_upwards() {
		Assert.assertTrue(
				myloDashboardPage.verifyMyFilesSortResultFromDB(MYLOConstants.MXSSO_DEV5_EMP_NO, MYLOConstants.ASC),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELDS_NOT_SORTED, CoreConstants.FAIL,
						MYLOConstants.MY_FILES_QUERY_RESULT, sortColName, MYLOConstants.ASC));
	}

	@Then("^that column should be sorted in descending order by again clicking on 'caret' next to it$")
	public void that_column_should_be_sorted_in_descending_order_by_again_clicking_on_caret_next_to_it() {
		myloDashboardPage.clickColumnCaretButton(sortColName);
		Assert.assertTrue(
				myloDashboardPage.verifyMyFilesSortResultFromDB(MYLOConstants.MXSSO_DEV5_EMP_NO, MYLOConstants.DESC),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELDS_NOT_SORTED, CoreConstants.FAIL,
						MYLOConstants.MY_FILES_QUERY_RESULT, sortColName, MYLOConstants.DESC));
	}

	@Then("^\"([^\"]*)\" should be displayed after he clicks on \"([^\"]*)\" button on \"([^\"]*)\" modal$")
	public void should_be_displayed_after_he_clicks_on_button_on_modal(String headerText, String btnName,
			String sectionName) {
		myloDashboardPage.clickFieldsOnMyFilesSection(MYLOConstants.NEW_QUERY);
		Assert.assertTrue(myloJourneyPage.verifySectionHeader(MYLOConstants.QUERY_POPUP, headerText),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL, headerText,
						MYLOConstants.QUERY_POPUP));
	}

	@When("^he clicks on \"([^\"]*)\" button after random selection of 'checkbox' with 'File Status' on 'My Files' section$")
	public void he_clicks_on_button_after_random_selection_of_checkbox_with_File_Status_on_My_Files_section(
			String btnName) {
		myloDashboardPage.selectFileStatus(MYLOConstants.RANDOM);
		myloDashboardPage.selectMyFilesCheckBox(MYLOConstants.RANDOM);
		myloDashboardPage.clickFieldsOnMyFilesSection(btnName);
	}

	@Then("^\"([^\"]*)\" popup should get closed$")
	public void popup_should_get_closed(String arg1) {
		Assert.assertFalse(myloDashboardPage.verifyMyFilesPopUpDisplayed(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.MY_FILES, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VRFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.MY_FILES, MYLOConstants.JOURNEY));
	}

}
