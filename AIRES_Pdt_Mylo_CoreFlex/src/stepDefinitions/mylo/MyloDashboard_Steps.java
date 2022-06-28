package stepDefinitions.mylo;

import java.text.MessageFormat;
import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeSection;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
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

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloDashboard_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
	}

	@Given("^he has logged into the 'Mylo' application$")
	public void he_has_logged_into_the_Mylo_application() throws Throwable {
		loginPage.openApplication();
		loginPage.enterUserEmailAndPasswordForMylo(loginData.MyloUserName, loginData.MyloPassword);
		loginPage.clickSignIn();
		Assert.assertTrue(myloDashboardPage.verifyUserName(loginData.MyloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						loginData.MyloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

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

	@Given("^Select Parameter popup should display with given parameters$")
	public void select_Parameter_popup_should_display_with_given_parameters(DataTable data) {
		Assert.assertTrue(myloDashboardPage.verifyFileParameterOptions(data),
				MYLOConstants.FILE_PARAMETERS_OPTIONS_NOT_MATCHING);

	}

	@Given("^Message \"([^\"]*)\" is displayed after clicking on Execute button$")
	public void message_is_displayed_after_clicking_on_Execute_button(String message) {
		myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(myloDashboardPage.verifyPopUpMessage(message),
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
		Assert.assertTrue(myloDashboardPage.verifyPopUpMessage(message),
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
		Assert.assertTrue(myloDashboardPage.verifyQueryResults(MYLOConstants.FILE_ID, ""),
				MYLOConstants.INCORRECT_FILEID_SORTING);
	}

}
