package stepDefinitions.mylo;

import java.text.MessageFormat;
import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeNameQuerySection;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.utilities.CustomSoftAssert;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloTransfereeNameQuery_Steps {
	private TestContext _testContext;
	private Mylo_JourneyPage _myloJourneyPage;
	private MyloJourneyPage_TransfereeNameQuerySection _myloJourneyPageTNameQuerySection;
	private CustomSoftAssert _softAssert;

	public MyloTransfereeNameQuery_Steps(TestContext context) {
		_testContext = context;
		_myloJourneyPage = _testContext.getMyloPageObjectManager().getJourneyPage();
		_myloJourneyPageTNameQuerySection = _testContext.getMyloPageObjectManager().getJourneyTransfereeNameQuery();
		_softAssert = _testContext.getSoftAssertObject();
	}

	@Then("^\"([^\"]*)\" popup message should be displayed after clicking on \"([^\"]*)\" button for all \"([^\"]*)\" field values which is not in the system$")
	public void popup_message_should_be_displayed_after_clicking_on_button_for_all_field_values_which_is_not_in_the_system(
			String msg, String arg2, String arg3, DataTable table) {
		_softAssert.assertTrue(
				_myloJourneyPageTNameQuerySection.verifyErrorPopUpForNonExistingTransfereeNames(table, msg),
				MessageFormat.format(MYLOConstants.FAIL_TO_VERIFY_POP_UP_MESSAGE_SECTION, CoreConstants.FAIL, msg,
						MYLOConstants.TRANSFEREE_NAME_QUERY));
	}

	@Then("^query popup should get closed after clicking on \"([^\"]*)\" icon on 'Query By Transferee Name' section$")
	public void query_popup_should_get_closed_after_clicking_on_icon_on_Query_By_Transferee_Name_section(String arg1) {
		_myloJourneyPageTNameQuerySection.clickCloseIcon();
		Assert.assertFalse(_myloJourneyPageTNameQuerySection.verifyTransfereeNameQueryPopUpDisplayed(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY));
		_softAssert.assertAll();
	}

	@When("^he views \"([^\"]*)\" section on journey page$")
	public void he_views_section_on_journey_page(String popUpHeader) {
		Assert.assertTrue(_myloJourneyPage.verifySectionHeader(MYLOConstants.TRANSFEREE_NAME, popUpHeader),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL, popUpHeader,
						MYLOConstants.TRANSFEREE_NAME));
	}

	@Then("^\"([^\"]*)\" button should be disabled on 'Query By Transferee Name' section$")
	public void button_should_be_disabled_on_Query_By_Transferee_Name_section(String btnName) {
		_softAssert.assertFalse(_myloJourneyPageTNameQuerySection.verifyTNameQueryButtonEnabilityStatus(btnName),
				MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, btnName,
						MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.PASS, btnName,
				MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY));
	}

	@Then("^query popup should get closed after clicking on \"([^\"]*)\" button on 'Query By Transferee Name' section$")
	public void query_popup_should_get_closed_after_clicking_on_button_on_Query_By_Transferee_Name_section(
			String btnName) {
		_myloJourneyPageTNameQuerySection.clickButtonsOnTransfereeNameQuerySection(btnName);
		Assert.assertFalse(_myloJourneyPageTNameQuerySection.verifyTransfereeNameQueryPopUpDisplayed(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY));
		_softAssert.assertAll();
	}

	@Then("^tag script messages should be displayed for entering 'specialCharacters' on below fields after clicking on \"([^\"]*)\" button on 'Query By Transferee Name' section$")
	public void tag_script_messages_should_be_displayed_for_entering_specialCharacters_on_below_fields_after_clicking_on_button_on_Query_By_Transferee_Name_section(
			String arg1, DataTable table) {
		Assert.assertTrue(_myloJourneyPageTNameQuerySection.verifyTagSciptErrorToastMsg(table),
				MessageFormat.format(MYLOConstants.FAIL_TO_VERIFY_TAG_SCRIPT_VALIDATION_MESSAGE_SECTION,
						CoreConstants.FAIL, MYLOConstants.TRANSFEREE_NAME_QUERY));
	}

	@When("^he enters data beyond character limit for different fields under 'Query By Transferee Name' section$")
	public void he_enters_data_beyond_character_limit_for_different_fields_under_Query_By_Transferee_Name_section() {
		_myloJourneyPageTNameQuerySection.setTransfereeNameBeyondCharacterLimit();
	}

	@Then("^values should be successfully entered as per character limit set for below fields under 'Query By Transferee Name' section$")
	public void values_should_be_successfully_entered_as_per_character_limit_set_for_below_fields_under_Query_By_Transferee_Name_section(
			DataTable table) {
		Assert.assertTrue(_myloJourneyPageTNameQuerySection.verifyTNameFieldValuesEntered(table),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_NAME_QUERY));
	}

	@Then("^related files should get appear into the query result modal as per below inputs after clicking on \"([^\"]*)\" button of Query By Transferee Name section$")
	public void related_files_should_get_appear_into_the_query_result_modal_as_per_below_inputs_after_clicking_on_button_of_Query_By_Transferee_Name_section(
			String arg1, DataTable table) {
		Assert.assertTrue(_myloJourneyPageTNameQuerySection.verifyQueryResultAsPerSearchedTName(table),
				MessageFormat.format(MYLOConstants.VERIFIED_QUERY_RESULT_FILES_MISMATCH, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_NAME, MYLOConstants.TRANSFEREE_NAME_QUERY));
	}

}
