package stepDefinitions.mylo;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.text.MessageFormat;
import java.util.Date;

import org.testng.Assert;

public class MyloAssignmentAiresFileTeam_Steps {
	TestContext testContext;
	Mylo_LoginPage loginPage;
	Mylo_DashboardHomePage myloDashboardPage;
	Mylo_AssignmentPage myloAssignmentPage;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloAssignmentAiresFileTeam_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
	}

	@Given("^he views Summary Tab under Assignment after clicking on Execute button with FileID \"([^\"]*)\"$")
	public void he_views_Summary_Tab_under_Assignment_after_clicking_on_Execute_button_with_FileID(String fileID) {
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
	}

	@Given("^he is on Mylo Assignment Summary page for file ID \"([^\"]*)\"$")
	public void he_is_on_Mylo_Assignment_Summary_page_for_file_ID(String fileID) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.FILE_ID_ENTERED, CoreConstants.PASS, fileID));
		myloDashboardPage.clickExecuteButton();
		//Assert.assertTrue(myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY),
			//	MYLOConstants.SUMMARY + MYLOConstants.TAB_NOT_ACTIVE);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he selects \"([^\"]*)\" with random team member from the dropdown after clicking on \"([^\"]*)\" button$")
	public void he_selects_with_random_team_member_from_the_dropdown_after_clicking_on_button(String roleName,
			String buttonName) {
		//Assert.assertTrue(myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY),
			//	MYLOConstants.SUMMARY + MYLOConstants.TAB_NOT_ACTIVE);
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(buttonName);
		myloAssignmentPage.addRole(roleName);
		myloAssignmentPage.addTeamMember(MYLOConstants.RANDOM);
	}

	@Given("^row is not updated in the 'Aires File Team' section after clicking on \"([^\"]*)\" button$")
	public void row_is_not_updated_in_the_Aires_File_Team_section_after_clicking_on_button(String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(buttonName);
		Assert.assertFalse(myloAssignmentPage.verifyRowAddedInAiresFileTeam(), MYLOConstants.ROW_ADDED);
	}

	@Given("^he did not find the existing team member for specified \"([^\"]*)\" in the dropdown section after clicking on \"([^\"]*)\" button$")
	public void he_did_not_find_the_existing_team_member_for_specified_in_the_dropdown_section_after_clicking_on_button(
			String roleName, String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(buttonName);
		myloAssignmentPage.addRole(roleName);
		Assert.assertFalse(myloAssignmentPage.verifyExistingTeamMemberInDropdown(roleName),
				MYLOConstants.EXISTING_TEAM_MEMBER_APPEARING_IN_DROPDOWN);
	}

	@Given("^he selects \"([^\"]*)\" as role in the dropdown section after clicking on \"([^\"]*)\" button$")
	public void he_selects_as_role_in_the_dropdown_section_after_clicking_on_button(String roleName,
			String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(buttonName);
	}

	@Given("^pop up should appear with the message \"([^\"]*)\" after clicking \"([^\"]*)\" button on selecting different team member with \"([^\"]*)\"$")
	public void pop_up_should_appear_with_the_message_after_clicking_button_on_selecting_different_team_member_with(
			String msg, String buttonName, String roleName) {
		myloAssignmentPage.addRole(roleName);
		myloAssignmentPage.addTeamMember(MYLOConstants.RANDOM);
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(buttonName);
		Assert.assertTrue(myloAssignmentPage.verifyPopUpMessage(msg),
				MYLOConstants.EXPECTED_POPUP_MESSAGE + CoreConstants.DIDNOT_MATCHED);
	}

	@When("^he clicks on \"([^\"]*)\" button in AiresFileTeam$")
	public void he_clicks_on_button_in_AiresFileTeam(String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(buttonName);
	}

	@Then("^new row should not be added in the Aires File Team section$")
	public void new_row_should_not_be_added_in_the_Aires_File_Team_section() {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(MYLOConstants.CANCEL_BUTTON);
		Assert.assertFalse(myloAssignmentPage.verifyRowAddedInAiresFileTeam(),
				MYLOConstants.ROW_ADDED + MYLOConstants.AIRES_FILE_TEAM);
	}

	@Then("^new row should be added for \"([^\"]*)\" with updated team member, End Date to current date$")
	public void new_row_should_be_added_for_with_updated_team_member_End_Date_to_current_date(String roleName) {
		Assert.assertTrue(myloAssignmentPage.verifyUpdatedRowAiresFileTeamSection(roleName), MYLOConstants.ROW_DIDNOT_UPDATED);
	}

	@Given("^all the values are readonly in the AiresFileTeam grid$")
	public void all_the_values_are_readonly_in_the_AiresFileTeam_grid() {
		Assert.assertTrue(myloAssignmentPage.verifyAiresFileTeamRecordsReadonly(), MYLOConstants.RECORDS_NOT_READONLY);
	}

	@Given("^he has logged into the Mylo application with mentioned userType \"([^\"]*)\"$")
	public void he_has_logged_into_the_Mylo_application_with_mentioned_userType(String userType)
			throws InterruptedException {
		myloDashboardPage.verifyUserName(loginData.MyloProfileName);
		loginPage.loginWithUser(userType);
		myloDashboardPage.verifyUserName(loginData.MyloProfileName);
	}

	@When("^he clicks on role dropdown after clicking on \"([^\"]*)\" button$")
	public void he_clicks_on_role_dropdown_after_clicking_on_button(String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(buttonName);
	}

	@Then("^\"([^\"]*)\" role options availability should depends on the type of Users \"([^\"]*)\" logged in$")
	public void role_options_availability_should_depends_on_the_type_of_Users_logged_in(String roleName,
			String userType) {
		Assert.assertTrue(myloAssignmentPage.verifyRoleAccessFromUserType(userType, roleName),
				MYLOConstants.INVALID_ROLE_ACCESS_FOR + userType);
	}
}
