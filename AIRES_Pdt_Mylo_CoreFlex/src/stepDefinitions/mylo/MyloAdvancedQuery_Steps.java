package stepDefinitions.mylo;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.MyloJourneyPage_AdvancedQuerySection;
import com.aires.pages.mylo.MyloJourneyPage_AuthTrackSection;
import com.aires.pages.mylo.MyloJourneyPage_CreateNewFileSection;
import com.aires.pages.mylo.MyloJourneyPage_FileTeamSection;
import com.aires.pages.mylo.MyloJourneyPage_PartnerSection;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeSection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.utilities.CustomSoftAssert;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloAdvancedQuery_Steps {
	private TestContext testContext;
	private Mylo_DashboardHomePage myloDashboardPage;
	private MyloJourneyPage_AdvancedQuerySection myloJourneyPageAdvancedQuerySection;
	private Mylo_JourneyPage myloJourneyPage;
	private MyloJourneyPage_CreateNewFileSection myloNewFileSection;
	private MyloJourneyPage_AuthTrackSection myloJourneyPageAuthTrack;
	private MyloJourneyPage_TransfereeSection myloJourneyTransfereeSection;
	private MyloJourneyPage_PartnerSection myloJourneyPartnerSection;
	private MyloJourneyPage_FileTeamSection myloJourneyFileTeamSection;
	private CustomSoftAssert softAssert;

	public MyloAdvancedQuery_Steps(TestContext context) {
		testContext = context;
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloNewFileSection = testContext.getMyloPageObjectManager().getJourneyPageCreateNewFileSection();
		myloJourneyPageAdvancedQuerySection = testContext.getMyloPageObjectManager().getJourneyAdvancedQuery();
		myloJourneyPageAuthTrack = testContext.getMyloPageObjectManager().getJourneyPageAuthTrackSection();
		myloJourneyTransfereeSection=testContext.getMyloPageObjectManager().getJourneyPageTransfereeSection();
		myloJourneyPartnerSection=testContext.getMyloPageObjectManager().getJourneyPagePartnerSection();
		myloJourneyFileTeamSection=testContext.getMyloPageObjectManager().getJourneyFileTeam();
		softAssert = testContext.getSoftAssertObject();
	}

	@Then("^tag script messages should be displayed for entering 'specialCharacters' on below fields after clicking on \"([^\"]*)\" button on 'Advanced Query' section$")
	public void tag_script_messages_should_be_displayed_for_entering_specialCharacters_on_below_fields_after_clicking_on_button_on_Advanced_Query_section(
			String arg1, DataTable table) {
		myloJourneyPageAdvancedQuerySection.verifySpecialCharactersToastMessage(table, softAssert);
		softAssert.assertAll();
	}
	
	@When("^he enters data beyond character limit for different fields under 'Advanced Query' section$")
	public void he_enters_data_beyond_character_limit_for_different_fields_under_Advanced_Query_section(DataTable table){
		myloJourneyPageAdvancedQuerySection.setFieldValueAsPerCharacterLimit(table);
	}

	@Then("^values should be successfully entered as per below character limit set for different fields under 'Advanced Query' section$")
	public void values_should_be_successfully_entered_as_per_below_character_limit_set_for_different_fields_under_Advanced_Query_section(DataTable table){
		myloJourneyPageAdvancedQuerySection.verifyAdvancedQueryFieldValueEntered(table, softAssert);
		softAssert.assertAll();
	}
	
	@When("^he clicks on \"([^\"]*)\" button without entering any parameters on 'Advanced Query popup$")
	public void he_clicks_on_button_without_entering_any_parameters_on_Advanced_Query_popup(String btnName) {
		myloJourneyPageAdvancedQuerySection.clickButtonsOnAdvancedQuerySection(btnName);
	}

	@Then("^an error popup message \"([^\"]*)\" should be displayed for \"([^\"]*)\" section on Journey page$")
	public void an_error_popup_message_should_be_displayed_for_section_on_Journey_page(String msg, String arg2){
		Assert.assertTrue(myloJourneyPage.verifyToastMessage(msg), MessageFormat
				.format(MYLOConstants.VERIFIED_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, msg, MYLOConstants.JOURNEY));
	}

	@Then("^search popup should get closed after clicking on \"([^\"]*)\" button on 'Advanced Query' section$")
	public void search_popup_should_get_closed_after_clicking_on_button_on_Advanced_Query_section(String btnName) {
		myloJourneyPageAdvancedQuerySection.clickButtonsOnAdvancedQuerySection(btnName);
		Assert.assertFalse(myloJourneyPageAdvancedQuerySection.verifyAdvancedQueryPopUpDisplayed(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.ADVANCED_QUERY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VRFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.ADVANCED_QUERY, MYLOConstants.JOURNEY));
	}
	
	@Given("^he has added \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" information for newly created Vendor file on Mylo Journey page$")
	public void he_has_added_information_for_newly_created_Vendor_file_on_Mylo_Journey_page(String arg1, String arg2, String arg3, String arg4)  {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.createNewFileIfNotExists(MYLOConstants.VENDOR_CLIENT_ID, myloNewFileSection);
		myloJourneyPageAuthTrack.addAuthTrackDataIfNotPresent();
		myloJourneyTransfereeSection.addTransfereePhoneEmailDetails();
		myloJourneyPartnerSection.addPartnerDetailsIfNotPresent();
		myloJourneyPage.scrollToJourneySection(MYLOConstants.AIRES_FILE_TEAM, MYLOConstants.JOURNEY);
		myloJourneyFileTeamSection.addFileTeamDetailsIfNotPresent();
		myloNewFileSection.setLeadCompanyID(MYLOConstants.AUTOMATION_CLIENT_ID);
	}

	@When("^he clicks on \"([^\"]*)\" button after entering \"([^\"]*)\" values on 'Advanced Query' popup$")
	public void he_clicks_on_button_after_entering_values_on_Advanced_Query_popup(String btnName, String fields) {
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.ADVANCED);
		Assert.assertTrue(myloJourneyPage.verifySectionHeader(MYLOConstants.ADVANCED, MYLOConstants.ADVANCED_QUERY),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.ADVANCED_QUERY, MYLOConstants.ADVANCED));
		myloJourneyPageAdvancedQuerySection.setAdvancedFieldValueForSearch(fields);
		myloJourneyPageAdvancedQuerySection.clickButtonsOnAdvancedQuerySection(btnName);
	}

}
