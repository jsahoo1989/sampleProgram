package stepDefinitions.mylo;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_QueryBySubServiceID;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyQueryBySubServiceID_Steps {
	private TestContext _testContext;
	private MyloJourneyPage_QueryBySubServiceID _myloJourneyPageQueryBySubServiceID;
	private Mylo_DashboardHomePage _myloDashboardPage;
	private Mylo_JourneyPage _myloJourneyPage;
	private Mylo_LoginPage _loginPage;
	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloJourneyQueryBySubServiceID_Steps(TestContext context) {
		_testContext = context;
		_myloJourneyPageQueryBySubServiceID = _testContext.getMyloPageObjectManager().getJourneyQueryBySubServiceID();
		_myloDashboardPage = _testContext.getMyloPageObjectManager().getDashboardHomePage();
		_myloJourneyPage = _testContext.getMyloPageObjectManager().getJourneyPage();
		_loginPage = _testContext.getMyloPageObjectManager().getLoginPage();
	}

	@Given("^he selects \"([^\"]*)\" option under \"([^\"]*)\" section available on left panel of Home Page after successfully logging into the 'Mylo' application$")
	public void he_selects_option_under_section_available_on_left_panel_of_Home_Page_after_successfully_logging_into_the_Mylo_application(
			String option, String section) throws Exception {
		_loginPage.openApplication();
		_loginPage.enterUserEmailAndPasswordForMylo(loginData.MyloUserName, loginData.MyloPassword);
		_loginPage.clickSignIn();
		Assert.assertTrue(_myloDashboardPage.verifyUserName(loginData.MyloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						loginData.MyloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));

		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		Assert.assertTrue(
				_myloJourneyPage.verifySectionHeader(MYLOConstants.QUERY_POPUP,
						MYLOConstants.ASSIGNMENT_QUERYTYPE_HEADER),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.ASSIGNMENT_QUERYTYPE_HEADER, MYLOConstants.QUERY_FILE));
	}

	@Given("^he is on \"([^\"]*)\" popup by selecting \"([^\"]*)\" option available on the \"([^\"]*)\" section$")
	public void he_is_on_popup_by_selecting_option_available_on_the_section(String popUpHeader, String subSection,
			String section) {
		_myloDashboardPage.selectParameterFromQueryScreen(subSection);
		Assert.assertTrue(_myloJourneyPage.verifySectionHeader(subSection, popUpHeader), MessageFormat
				.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL, popUpHeader, subSection));
	}

	@When("^he clicks on \"([^\"]*)\" button after entering \"([^\"]*)\" subServiceId in the \"([^\"]*)\" field on \"([^\"]*)\" section$")
	public void he_clicks_on_button_after_entering_subServiceId_in_the_field_on_section(String button,
			String subServiceIDType, String field, String section) {
		_myloJourneyPageQueryBySubServiceID.setSubServiceIDValue(DbFunctions.getSubServiceID(subServiceIDType),
				MYLOConstants.VALUE);
		_myloJourneyPageQueryBySubServiceID.clickButtonInQueryBySubServiceIDPopUp(MYLOConstants.SUBMIT_BUTTON);
	}

	@When("^he should be taken to the Summary Overview page with shipment sidescreen being displayed after entering \"([^\"]*)\" subServiceId on \"([^\"]*)\" section$")
	public void he_should_be_taken_to_the_Summary_Overview_page_with_shipment_sidescreen_being_displayed_after_entering_subServiceId_on_section(
			String subServiceIDType, String section) {
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.SUB_SERVICE_ID);
		_myloJourneyPageQueryBySubServiceID.setSubServiceIDValue(DbFunctions.getSubServiceID(subServiceIDType),
				MYLOConstants.VALUE);
		_myloJourneyPageQueryBySubServiceID.clickButtonInQueryBySubServiceIDPopUp(MYLOConstants.SUBMIT_BUTTON);
		Assert.assertTrue(_myloJourneyPageQueryBySubServiceID.isShipmentSubServiceScreenDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, MYLOConstants.SHIPMENT_WEBSWING));
		
	}

	@Then("^he should be taken to the Summary Overview section for that subservice without shipment sidescreen being displayed on Mylo Journey page$")
	public void he_should_be_taken_to_the_Summary_Overview_section_for_that_subservice_on_Mylo_Journey_page() {
		Assert.assertTrue(_myloJourneyPageQueryBySubServiceID.isSummaryDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, MYLOConstants.SUMMARY));
		Assert.assertFalse(_myloJourneyPageQueryBySubServiceID.isShipmentSubServiceScreenDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, MYLOConstants.SHIPMENT_WEBSWING));
	}

	@When("^he enters data beyond number limit for \"([^\"]*)\" field under \"([^\"]*)\" section$")
	public void he_enters_data_beyond_number_limit_for_field_under_section(String field, String section) {
		_myloJourneyPageQueryBySubServiceID.setSubServiceIDValue(
				String.valueOf(MYLOConstants.SUB_SERVICE_ID_FIELD_LIMIT + 1), MYLOConstants.RANDOM_INTEGER);
	}

	@Then("^values should be successfully entered as per number limit 10 set for \"([^\"]*)\" field under \"([^\"]*)\" section$")
	public void values_should_be_successfully_entered_as_per_below_number_limit_set_for_field_under_section(
			String field, String section) {
		Assert.assertTrue(_myloJourneyPageQueryBySubServiceID.verifySubServiceIDMaxLength(), MessageFormat.format(
				MYLOConstants.INCORRECT_FIELD_VALUE, CoreConstants.FAIL, MYLOConstants.QUERY_BY_SUB_SERVICE_ID));
	}

	@Then("^he should not be able to enter any character in \"([^\"]*)\" field under \"([^\"]*)\" section$")
	public void he_should_not_be_able_to_enter_any_character_in_field_under_section(String field, String section) {
		_myloJourneyPageQueryBySubServiceID.setSubServiceIDValue(
				String.valueOf(MYLOConstants.SUB_SERVICE_ID_FIELD_LIMIT), MYLOConstants.RANDOM_STRING);
		Assert.assertTrue(_myloJourneyPageQueryBySubServiceID.isSubServiceIDFieldEmpty(), MessageFormat.format(
				MYLOConstants.INCORRECT_FIELD_VALUE, CoreConstants.FAIL, MYLOConstants.QUERY_BY_SUB_SERVICE_ID));
		
	}

	@Then("^\"([^\"]*)\" modal should be closed after clicking on \"([^\"]*)\" button$")
	public void modal_should_be_closed_after_clicking_on_button(String popUp, String button) {
		_myloJourneyPageQueryBySubServiceID.clickButtonInQueryBySubServiceIDPopUp(button);
		Assert.assertFalse(_myloJourneyPageQueryBySubServiceID.isQueryBySubServiceIDPopUpExist(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL, popUp,
						MYLOConstants.QUERY_BY_SUB_SERVICE_ID));
		
	}

	@When("^he clicks on \"([^\"]*)\" button after entering an invalid sub-service id in the \"([^\"]*)\" field on \"([^\"]*)\" section$")
	public void he_clicks_on_button_after_entering_an_invalid_sub_service_id_in_the_field_on_section(String button,
			String field, String section) {
		_myloJourneyPageQueryBySubServiceID.setSubServiceIDValue(
				String.valueOf(MYLOConstants.SUB_SERVICE_ID_FIELD_LIMIT), MYLOConstants.RANDOM_INTEGER);
		_myloJourneyPageQueryBySubServiceID.clickButtonInQueryBySubServiceIDPopUp(MYLOConstants.SUBMIT_BUTTON);
	}

	@Then("^\"([^\"]*)\" popup message should be displayed above \"([^\"]*)\" popup$")
	public void popup_message_should_be_displayed(String popupText, String popupName) {
		Assert.assertTrue(_myloJourneyPageQueryBySubServiceID.isNoSuchFilePopUpExist(), MessageFormat
				.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, MYLOConstants.NO_SUCH_FILE_FOUND));

	}

	@Then("^\"([^\"]*)\" modal should be closed after clicking on \"([^\"]*)\" icon on \"([^\"]*)\" section$")
	public void modal_should_be_closed_after_clicking_on_icon_on_section(String popUp, String button, String section) {
		_myloJourneyPageQueryBySubServiceID.clickButtonInQueryBySubServiceIDPopUp(button);
		Assert.assertFalse(_myloJourneyPageQueryBySubServiceID.isQueryBySubServiceIDPopUpExist(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL, popUp,
						MYLOConstants.QUERY_BY_SUB_SERVICE_ID));
	}

}
