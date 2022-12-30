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
	private TestContext testContext;
	private Mylo_JourneyPage myloJourneyPage;
	private MyloJourneyPage_TransfereeNameQuerySection myloJourneyPageTNameQuerySection;
	private CustomSoftAssert softAssert;

	public MyloTransfereeNameQuery_Steps(TestContext context) {
		testContext = context;
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
		myloJourneyPageTNameQuerySection = testContext.getMyloPageObjectManager().getJourneyTransfereeNameQuery();
		softAssert = testContext.getSoftAssertObject();
	}

	@Then("^\"([^\"]*)\" popup message should be displayed after clicking on \"([^\"]*)\" button for all \"([^\"]*)\" field values which is not in the system$")
	public void popup_message_should_be_displayed_after_clicking_on_button_for_all_field_values_which_is_not_in_the_system(
			String msg, String arg2, String arg3, DataTable table) {
		myloJourneyPageTNameQuerySection.verifyTransfereeNameNotExist(table, msg);
	}

	@Then("^query popup should get closed after clicking on \"([^\"]*)\" icon on 'Query By Transferee Name' section$")
	public void query_popup_should_get_closed_after_clicking_on_icon_on_Query_By_Transferee_Name_section(String arg1) {
		myloJourneyPageTNameQuerySection.clickCloseIcon();
		Assert.assertFalse(myloJourneyPageTNameQuerySection.verifyTransfereeNameQueryPopUpDisplayed(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY));
	}

	@When("^he views \"([^\"]*)\" section on journey page$")
	public void he_views_section_on_journey_page(String popUpHeader) {
		Assert.assertTrue(myloJourneyPage.verifySectionHeader(MYLOConstants.TRANSFEREE_NAME, popUpHeader),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL, popUpHeader,
						MYLOConstants.TRANSFEREE_NAME));
	}

	@Then("^\"([^\"]*)\" button should be disabled on 'Query By Transferee Name' section$")
	public void button_should_be_disabled_on_Query_By_Transferee_Name_section(String btnName) {
		myloJourneyPageTNameQuerySection.verifyTNameQueryButtonEnabilityStatus(btnName);
	}

	@Then("^query popup should get closed after clicking on \"([^\"]*)\" button on 'Query By Transferee Name' section$")
	public void query_popup_should_get_closed_after_clicking_on_button_on_Query_By_Transferee_Name_section(
			String btnName) {
		myloJourneyPageTNameQuerySection.clickButtonsOnTransfereeNameQuerySection(btnName);
		Assert.assertFalse(myloJourneyPageTNameQuerySection.verifyTransfereeNameQueryPopUpDisplayed(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
				MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY));
	}

	@Then("^tag script messages should be displayed for entering 'specialCharacters' on below fields after clicking on \"([^\"]*)\" button on 'Query By Transferee Name' section$")
	public void tag_script_messages_should_be_displayed_for_entering_specialCharacters_on_below_fields_after_clicking_on_button_on_Query_By_Transferee_Name_section(
			String arg1, DataTable table) {
		myloJourneyPageTNameQuerySection.verifyTagSciptErrorToastMsg(table, softAssert);
	}

	@When("^he enters data beyond character limit for different fields under 'Query By Transferee Name' section$")
	public void he_enters_data_beyond_character_limit_for_different_fields_under_Query_By_Transferee_Name_section(
			DataTable table) {
		myloJourneyPageTNameQuerySection.setTransfereeNameAsPerCharacterLimit(table);
	}

	@Then("^values should be successfully entered as per below character limit set for different fields under 'Query By Transferee Name' section$")
	public void values_should_be_successfully_entered_as_per_below_character_limit_set_for_different_fields_under_Query_By_Transferee_Name_section(
			DataTable table) {
		myloJourneyPageTNameQuerySection.verifyTNameFieldValuesEntered(table, softAssert);
	}

	@Then("^related files should get appear into the query result modal as per below inputs after clicking on \"([^\"]*)\" button of Query By Transferee Name section$")
	public void related_files_should_get_appear_into_the_query_result_modal_as_per_below_inputs_after_clicking_on_button_of_Query_By_Transferee_Name_section(
			String arg1, DataTable table) {
		myloJourneyPageTNameQuerySection.verifyQueryResultAsPerSearchedTName(table, softAssert);
	}

}
