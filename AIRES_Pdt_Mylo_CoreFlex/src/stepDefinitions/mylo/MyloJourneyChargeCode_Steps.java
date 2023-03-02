package stepDefinitions.mylo;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_ChargeCode;
import com.aires.pages.mylo.MyloJourneyPage_CreateNewFileSection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.aires.utilities.CustomSoftAssert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyChargeCode_Steps {
	private TestContext _testContext;
	Mylo_DashboardHomePage _myloDashboardPage;
	private MyloJourneyPage_CreateNewFileSection _myloNewFileSection;
	private MyloJourneyPage_ChargeCode _myloJourneyPageChargeCode;
	private Mylo_LoginPage _loginPage;
	private CustomSoftAssert _softAssert;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloJourneyChargeCode_Steps(TestContext context) {
		_testContext = context;
		_testContext.getMyloPageObjectManager().getDashboardHomePage();
		_testContext.getMyloPageObjectManager().getJourneyPage();
		_loginPage = _testContext.getMyloPageObjectManager().getLoginPage();
		_myloDashboardPage = _testContext.getMyloPageObjectManager().getDashboardHomePage();
		_myloNewFileSection = _testContext.getMyloPageObjectManager().getJourneyPageCreateNewFileSection();
		_myloJourneyPageChargeCode = _testContext.getMyloPageObjectManager().getJourneyPageChargeCode();
		_softAssert = _testContext.getSoftAssertObject();
	}

	@Given("^he is on the charge code file after clicking the Charge Codes Button on the Journey Summary File created with \"([^\"]*)\"$")
	public void he_is_on_the_charge_code_file_after_clicking_on_the_Charge_Codes_Button_on_the_Journey_Summary_File_created_with(
			String clientName) {

		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.NEW_FILE_BUTTON);
		_myloNewFileSection.createNewFile(clientName);
		_myloJourneyPageChargeCode.clickChargeCodeButton();
	}

	@Then("^following validation messages should be displayed, with leaving below mandatory fields blank on both 'Direct', 'Indirect' tabs$")
	public void following_validation_messages_should_be_displayed_with_leaving_below_mandatory_fields_blank_on_both_tabs(
			DataTable table) {
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.ADD_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.verifyMandatoryFieldsToastMessagesChargeCodeSection(table, _softAssert,
				MYLOConstants.DIRECT_TAB);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.DELETE_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.INDIRECT_TAB);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.ADD_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.verifyMandatoryFieldsToastMessagesChargeCodeSection(table, _softAssert,
				MYLOConstants.INDIRECT_TAB);
		_softAssert.assertAll();
	}

	@Then("^clicking \"([^\"]*)\" button after providing all the required information should save the charge code on both \"([^\"]*)\", \"([^\"]*)\" tabs$")
	public void clicking_button_after_providing_all_the_required_information_should_save_the_charge_code_on_both_tabs(
			String arg1, String arg2, String arg3) {

	}

	@Then("^he should be able to view all fields on \"([^\"]*)\" screen after clicking on view charge code history button$")
	public void he_should_be_able_to_view_all_fields_on_screen_after_clicking_on_view_charge_code_history_button(
			String arg1) {

	}

	@Then("^upon entering data in any column on both \"([^\"]*)\", \"([^\"]*)\" tabs the row will be highighted in red in \"([^\"]*)\" screen$")
	public void upon_entering_data_in_any_column_on_both_tabs_the_row_will_be_highighted_in_red_in_screen(String arg1,
			String arg2, String arg3) {

	}

	@Then("^clicking \"([^\"]*)\" on the confirmation popup displayed after clicking on the trash can icon next to a existing direct charge code deletes the line on both \"([^\"]*)\", \"([^\"]*)\" tabs$")
	public void clicking_on_the_confirmation_popup_displayed_after_clicking_on_the_trash_can_icon_next_to_a_existing_direct_charge_code_deletes_the_line_on_both_tabs(
			String arg1, String arg2, String arg3) {

	}

	@Then("^Add,Delete,Save options are visible on both \"([^\"]*)\", \"([^\"]*)\" tabs in \"([^\"]*)\" screen$")
	public void add_Delete_Save_options_are_visible_on_both_tabs_in_screen(String directTabName, String inDirectTabName,
			String popUpName) {
		_softAssert.assertTrue(
				_myloJourneyPageChargeCode.isElementEnabledOnPopUp(MYLOConstants.DIRECT_TAB,
						MYLOConstants.ADD_CHARGE_CODE_BUTTON, MYLOConstants.WITH),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.ADD_CHARGE_CODE_BUTTON, MYLOConstants.DIRECT_TAB));
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.ADD_CHARGE_CODE_BUTTON);
		_softAssert.assertTrue(
				_myloJourneyPageChargeCode.isElementEnabledOnPopUp(MYLOConstants.DIRECT_TAB,
						MYLOConstants.DELETE_CHARGE_CODE_BUTTON, MYLOConstants.WITH),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.DELETE_CHARGE_CODE_BUTTON, MYLOConstants.DIRECT_TAB));
		_softAssert.assertTrue(
				_myloJourneyPageChargeCode.isElementEnabledOnPopUp(MYLOConstants.DIRECT_TAB,
						MYLOConstants.SAVE_CHARGE_CODE_BUTTON, MYLOConstants.WITH),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SAVE_CHARGE_CODE_BUTTON, MYLOConstants.DIRECT_TAB));
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.DELETE_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.INDIRECT_TAB);
		_softAssert.assertTrue(
				_myloJourneyPageChargeCode.isElementEnabledOnPopUp(MYLOConstants.INDIRECT_TAB,
						MYLOConstants.ADD_CHARGE_CODE_BUTTON, MYLOConstants.WITH),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.ADD_CHARGE_CODE_BUTTON, MYLOConstants.INDIRECT_TAB));
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.ADD_CHARGE_CODE_BUTTON);
		_softAssert.assertTrue(
				_myloJourneyPageChargeCode.isElementEnabledOnPopUp(MYLOConstants.INDIRECT_TAB,
						MYLOConstants.DELETE_CHARGE_CODE_BUTTON, MYLOConstants.WITH),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.DELETE_CHARGE_CODE_BUTTON, MYLOConstants.INDIRECT_TAB));
		_softAssert.assertTrue(
				_myloJourneyPageChargeCode.isElementEnabledOnPopUp(MYLOConstants.INDIRECT_TAB,
						MYLOConstants.SAVE_CHARGE_CODE_BUTTON, MYLOConstants.WITH),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SAVE_CHARGE_CODE_BUTTON, MYLOConstants.INDIRECT_TAB));
		_softAssert.assertAll();

	}

	@Then("^Add,Delete,Save options are not visible on both \"([^\"]*)\", \"([^\"]*)\" tabs after he has logged into the Mylo application with userType \"([^\"]*)\"$")
	public void add_Delete_Save_options_are_disable_on_both_tabs_after_he_has_logged_into_the_Mylo_application_with_userType(
			String directTabName, String inDirectTabName, String userProfile) {
		_loginPage.loginWithUser(userProfile);
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.NEW_FILE_BUTTON);
		_myloNewFileSection.createNewFile(MYLOConstants.CLIENT_78223);
		_myloJourneyPageChargeCode.clickChargeCodeButton();
		_softAssert.assertFalse(
				_myloJourneyPageChargeCode.isElementEnabledOnPopUp(MYLOConstants.DIRECT_TAB,
						MYLOConstants.ADD_CHARGE_CODE_BUTTON, MYLOConstants.WITHOUT),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.ADD_CHARGE_CODE_BUTTON, MYLOConstants.DIRECT_TAB));
		_softAssert.assertFalse(
				_myloJourneyPageChargeCode.isElementExistOnPopUp(MYLOConstants.DELETE_CHARGE_CODE_BUTTON),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.DELETE_CHARGE_CODE_BUTTON, MYLOConstants.DIRECT_TAB));
		_softAssert.assertFalse(
				_myloJourneyPageChargeCode.isElementEnabledOnPopUp(MYLOConstants.DIRECT_TAB,
						MYLOConstants.SAVE_CHARGE_CODE_BUTTON, MYLOConstants.WITHOUT),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SAVE_CHARGE_CODE_BUTTON, MYLOConstants.DIRECT_TAB));
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.INDIRECT_TAB);
		_softAssert.assertFalse(
				_myloJourneyPageChargeCode.isElementEnabledOnPopUp(MYLOConstants.INDIRECT_TAB,
						MYLOConstants.ADD_CHARGE_CODE_BUTTON, MYLOConstants.WITHOUT),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.ADD_CHARGE_CODE_BUTTON, MYLOConstants.INDIRECT_TAB));
		_softAssert.assertFalse(
				_myloJourneyPageChargeCode.isElementExistOnPopUp(MYLOConstants.DELETE_CHARGE_CODE_BUTTON),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.DELETE_CHARGE_CODE_BUTTON, MYLOConstants.INDIRECT_TAB));
		_softAssert.assertFalse(
				_myloJourneyPageChargeCode.isElementEnabledOnPopUp(MYLOConstants.INDIRECT_TAB,
						MYLOConstants.SAVE_CHARGE_CODE_BUTTON, MYLOConstants.WITHOUT),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SAVE_CHARGE_CODE_BUTTON, MYLOConstants.INDIRECT_TAB));
		_softAssert.assertAll();
	}

	@Then("^the start date should be displayed in red upon clicking 'Save' button after entering start date greater than the current date on both \"([^\"]*)\", \"([^\"]*)\" tabs$")
	public void the_start_date_should_be_displayed_in_red_upon_clicking_Save_button_after_entering_start_date_greater_than_the_current_date_on_both_tabs(
			String directTab, String inDirectTab) {
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.ADD_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.setChargeCodeDateFields(MYLOConstants.START_DATE, MYLOConstants.FUTURE_DATE);
		Assert.assertTrue(_myloJourneyPageChargeCode.isElementHighlightedInRed(MYLOConstants.START_DATE), MessageFormat
				.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL, MYLOConstants.START_DATE));
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.DELETE_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.INDIRECT_TAB);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.ADD_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.setChargeCodeDateFields(MYLOConstants.START_DATE, MYLOConstants.FUTURE_DATE);
		Assert.assertTrue(_myloJourneyPageChargeCode.isElementHighlightedInRed(MYLOConstants.START_DATE), MessageFormat
				.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL, MYLOConstants.START_DATE));

	}

	@Then("^the end date should be displayed in red upon clicking 'Save' button after entering end date less than the current date on both \"([^\"]*)\", \"([^\"]*)\" tabs$")
	public void the_end_date_should_be_displayed_in_red_upon_clicking_Save_button_after_entering_end_date_less_than_the_current_date_on_both_tabs(
			String directTab, String inDirectTab) {
		_myloJourneyPageChargeCode.setChargeCodeDateFields(MYLOConstants.END_DATE, MYLOConstants.PAST_DATE);
		Assert.assertTrue(_myloJourneyPageChargeCode.isElementHighlightedInRed(MYLOConstants.END_DATE), MessageFormat
				.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL, MYLOConstants.END_DATE));
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.DELETE_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.DIRECT_TAB);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.ADD_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.setChargeCodeDateFields(MYLOConstants.END_DATE, MYLOConstants.PAST_DATE);
		Assert.assertTrue(_myloJourneyPageChargeCode.isElementHighlightedInRed(MYLOConstants.END_DATE), MessageFormat
				.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL, MYLOConstants.END_DATE));
	}

	@Then("^error message \"([^\"]*)\" should be displayed after clicking on 'Save' button leaving COST CENTER, WBS empty on  \"([^\"]*)\" tab$")
	public void error_message_should_be_displayed_after_clicking_on_Save_button_leaving_COST_CENTER_WBS_empty_on_both_tabs(
			String message, String arg2, DataTable table) {
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.ADD_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.enterDataAndVerifyMandatoryFieldsToastMessage(table, _softAssert, message);
		_softAssert.assertAll();
	}

	@Then("^error message \"([^\"]*)\" should be displayed after clicking 'Save' button on both Direct, Indirect charge Code with only one charge code$")
	public void error_message_should_be_displayed_after_clicking_Save_button_on_both_Direct_Indirect_charge_Code_with_only_one_charge_code(
			String message) {
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.DELETE_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.ADD_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.enterMandatoryFieldsForChargeCode(MYLOConstants.CLIENT_80023,
				MYLOConstants.DIRECT_TAB);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.SAVE_CHARGE_CODE_BUTTON);
		Assert.assertTrue(_myloJourneyPageChargeCode.isCorrectToastMessageDisplayed(message),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL));
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.DELETE_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.INDIRECT_TAB);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.ADD_CHARGE_CODE_BUTTON);
		_myloJourneyPageChargeCode.enterMandatoryFieldsForChargeCode(MYLOConstants.CLIENT_80023,
				MYLOConstants.INDIRECT_TAB);
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.SAVE_CHARGE_CODE_BUTTON);
		Assert.assertTrue(_myloJourneyPageChargeCode.isCorrectToastMessageDisplayed(message),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL));

	}

	@When("^he clicks 'save' button on charge codes screen with no charge code on both \"([^\"]*)\", \"([^\"]*)\" tabs$")
	public void he_clicks_save_button_on_charge_codes_screen_with_no_charge_code_on_both_tabs(String message,
			String tabName) {
		_myloJourneyPageChargeCode.clickFieldsOnChargeCodeSection(MYLOConstants.SAVE_CHARGE_CODE_BUTTON);
	}

	@Then("^error message \"([^\"]*)\" should be displayed$")
	public void error_message_should_be_displayed(String message) {
		Assert.assertTrue(_myloJourneyPageChargeCode.isCorrectToastMessageDisplayed(message),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL, message));
	}

}
