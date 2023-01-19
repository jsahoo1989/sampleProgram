package stepDefinitions.mylo;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.MyloJourneyPage_AccountingQuerySection;
import com.aires.pages.mylo.MyloJourneyPage_AddressSection;
import com.aires.pages.mylo.MyloJourneyPage_AuthTrackSection;
import com.aires.pages.mylo.MyloJourneyPage_CreateNewFileSection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloAccountingQuerySteps {
	private TestContext testContext;
	private Mylo_DashboardHomePage myloDashboardPage;
	private MyloJourneyPage_AccountingQuerySection myloJourneyPageAccountingQuerySection;
	private Mylo_JourneyPage myloJourneyPage;
	private MyloJourneyPage_CreateNewFileSection myloNewFileSection;
	private MyloJourneyPage_AddressSection myloJourneyPageAddressSection;
	private MyloJourneyPage_AuthTrackSection myloJourneyPageAuthTrack;
	private String sortColName;

	public MyloAccountingQuerySteps(TestContext context) {
		testContext = context;
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloJourneyPageAddressSection = testContext.getMyloPageObjectManager().getJourneyPageAddressSection();
		myloNewFileSection = testContext.getMyloPageObjectManager().getJourneyPageCreateNewFileSection();
		myloJourneyPageAccountingQuerySection = testContext.getMyloPageObjectManager().getJourneyAccountingQuery();
		myloJourneyPageAuthTrack = testContext.getMyloPageObjectManager().getJourneyPageAuthTrackSection();
	}

	@Then("^tag script messages should be displayed for entering 'specialCharacters' on below fields after clicking on \"([^\"]*)\" button on \"([^\"]*)\" section$")
	public void tag_script_messages_should_be_displayed_for_entering_specialCharacters_on_below_fields_after_clicking_on_button_on_section(
			String btnName, String section, DataTable table) {
		myloJourneyPageAccountingQuerySection.verifySpecialCharactersToastMessage(table);
	}

	@Given("^he enters data beyond character limit for different fields under \"([^\"]*)\" section$")
	public void he_enters_data_beyond_character_limit_for_different_fields_under_section(String arg1, DataTable table) {
		myloJourneyPageAccountingQuerySection.setFieldValueAsPerCharacterLimit(table);
	}

	@Then("^values should be successfully entered as per below character limit set for different fields under 'Accounting Query' section$")
	public void values_should_be_successfully_entered_as_per_below_character_limit_set_for_different_fields_under_Accounting_Query_section(
			DataTable table) {
		myloJourneyPageAccountingQuerySection.verifyAccountingQueryFieldValueEntered(table);
	}

	@When("^he clicks on \"([^\"]*)\" button without entering any parameters on \"([^\"]*)\" popup$")
	public void he_clicks_on_button_without_entering_any_parameters_on_popup(String btnName, String arg2) {
		myloJourneyPageAccountingQuerySection.clickButtonsOnAccountingQuerySection(btnName);
	}

	@Then("^an error popup message \"([^\"]*)\" should be displayed for 'Accounting Query' section on Journey page$")
	public void an_error_popup_message_should_be_displayed_for_Accounting_Query_section_on_Journey_page(String msg) {
		Assert.assertTrue(myloJourneyPage.verifyToastMessage(msg), MessageFormat
				.format(MYLOConstants.VERIFIED_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, msg, MYLOConstants.JOURNEY));
	}

	@Then("^search popup should get closed after clicking on \"([^\"]*)\" button on 'Accounting Query' section$")
	public void search_popup_should_get_closed_after_clicking_on_button_on_Accounting_Query_section(String btnName) {
		myloJourneyPageAccountingQuerySection.clickButtonsOnAccountingQuerySection(btnName);
		Assert.assertFalse(myloJourneyPageAccountingQuerySection.verifyAccountingQueryPopUpDisplayed(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.ACCOUNTING_QUERY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.ACCOUNTING_QUERY, MYLOConstants.JOURNEY));
	}

	@Given("^he has added \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" information for newly created file on Mylo Journey page$")
	public void he_has_added_information_for_newly_created_file_on_Mylo_Journey_page(String arg1, String arg2,
			String arg3) {
		myloDashboardPage.closePopUp();
		myloDashboardPage.createNewFileIfNotExists(MYLOConstants.AUTOMATION_CLIENT_ID, myloNewFileSection);
		myloJourneyPageAuthTrack.addAuthTrackDataIfNotPresent();
		myloJourneyPageAddressSection.addOriginAddressIfNotPresent();
		myloJourneyPageAddressSection.addDestinationAddressIfNotPresent();	
	}

	@When("^he clicks on \"([^\"]*)\" button after entering \"([^\"]*)\" values on \"([^\"]*)\" popup$")
	public void he_clicks_on_button_after_entering_values_on_popup(String arg1, String fieldName, String arg3) {
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.ACCOUNTING);
		Assert.assertTrue(myloJourneyPage.verifySectionHeader(MYLOConstants.ACCOUNTING, MYLOConstants.ACCOUNTING_QUERY),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.ACCOUNTING_QUERY, MYLOConstants.ACCOUNTING));
		myloJourneyPageAccountingQuerySection.setFieldValueForSearch(fieldName);
		myloJourneyPageAccountingQuerySection.clickButtonsOnAccountingQuerySection(MYLOConstants.EXECUTE);
	}

	@Then("^journey page should be displayed for resulting 'File' matching the \"([^\"]*)\" entered from \"([^\"]*)\" popup$")
	public void journey_page_should_be_displayed_for_resulting_File_matching_the_entered_from_popup(String fieldName,
			String arg2) {
		Assert.assertTrue(myloJourneyPageAccountingQuerySection.verifySearchedSingleFile(fieldName,
				myloJourneyPage.getJourneyPageFieldValues(fieldName)));
	}

	@When("^he clicks on \"([^\"]*)\" button after random selection of \"([^\"]*)\" with \"([^\"]*)\" on 'Accounting' section$")
	public void he_clicks_on_button_after_random_selection_of_with_on_Accounting_section(String btnName,
			String fieldName1, String fieldName2) {
		myloJourneyPageAccountingQuerySection.setAccountingDropdownValues(fieldName1, MYLOConstants.RANDOM);
		myloJourneyPageAccountingQuerySection.setAccountingDropdownValues(fieldName2, MYLOConstants.RANDOM);
		myloJourneyPageAccountingQuerySection.clickButtonsOnAccountingQuerySection(btnName);
	}

	@Then("^related files should get appear into the query result modal as per the selected 'Service' with 'Service Status'$")
	public void related_files_should_get_appear_into_the_query_result_modal_as_per_the_selected_Service_with_Service_Status() {
		myloJourneyPageAccountingQuerySection.checkAccountingResultModalAppears(MYLOConstants.RANDOM,
				MYLOConstants.RANDOM);
		Assert.assertTrue(myloJourneyPageAccountingQuerySection.verifyAccountingFilesResultFromDB(MYLOConstants.FILEID),
				MessageFormat.format(MYLOConstants.VERIFIED_RESULTS_MISMATCH_WITH_DATABASE, CoreConstants.FAIL,
						MYLOConstants.FILEID, MYLOConstants.ACCOUNTING_QUERY));
	}

	@Given("^he is on \"([^\"]*)\" modal after random selection of \"([^\"]*)\" with \"([^\"]*)\" on 'Accounting' section$")
	public void he_is_on_modal_after_random_selection_of_with_on_Accounting_section(String arg1, String fieldName1,
			String fieldName2) {
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.ACCOUNTING);
		Assert.assertTrue(myloJourneyPage.verifySectionHeader(MYLOConstants.ACCOUNTING, MYLOConstants.ACCOUNTING_QUERY),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.ACCOUNTING_QUERY, MYLOConstants.ACCOUNTING));
		myloJourneyPageAccountingQuerySection.setAccountingDropdownValues(fieldName1, MYLOConstants.RANDOM);
		myloJourneyPageAccountingQuerySection.setAccountingDropdownValues(fieldName2, MYLOConstants.RANDOM);
		myloJourneyPageAccountingQuerySection.clickButtonsOnAccountingQuerySection(MYLOConstants.EXECUTE);
		myloJourneyPageAccountingQuerySection.checkAccountingResultModalAppears(MYLOConstants.RANDOM,
				MYLOConstants.RANDOM);
	}

	@When("^he clicks on a 'caret' next to any column on 'Accounting Query result' modal$")
	public void he_clicks_on_a_caret_next_to_any_column_on_Accounting_Query_result_modal() {
		sortColName = myloJourneyPage.clickColumnCaretButtonOnResultsModal(MYLOConstants.RANDOM);
	}

	@Then("^that column should be sorted in ascending order with caret pointing upwards on 'Accounting Query result' modal$")
	public void that_column_should_be_sorted_in_ascending_order_with_caret_pointing_upwards_on_Accounting_Query_result_modal() {
		Assert.assertTrue(
				myloJourneyPageAccountingQuerySection.verifyAccountingSortResultFromDB(sortColName, MYLOConstants.ASC),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELDS_NOT_SORTED, CoreConstants.FAIL,
						MYLOConstants.ACCOUNTING_QUERY_RESULT, sortColName, MYLOConstants.ASC));
	}

	@Then("^that column should be sorted in descending order by again clicking on 'caret' next to it on 'Accounting Query result' modal$")
	public void that_column_should_be_sorted_in_descending_order_by_again_clicking_on_caret_next_to_it_on_Accounting_Query_result_modal() {
		myloJourneyPage.clickColumnCaretButtonOnResultsModal(sortColName);
		Assert.assertTrue(
				myloJourneyPageAccountingQuerySection.verifyAccountingSortResultFromDB(sortColName, MYLOConstants.DESC),
				MessageFormat.format(MYLOConstants.VERIFIED_FIELDS_NOT_SORTED, CoreConstants.FAIL,
						MYLOConstants.ACCOUNTING_QUERY_RESULT, sortColName, MYLOConstants.DESC));
	}
}
