package stepDefinitions.mylo;

import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

	@Given("^user views Summary Tab under Assignment after clicking on Execute button with FileID \"([^\"]*)\"$")
	public void user_views_Summary_Tab_under_Assignment_after_clicking_on_Execute_button_with_FileID(String fileID) {
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
	}

	@Given("^user should be able to view the current Aires File team$")
	public void user_should_be_able_to_view_the_current_Aires_File_team() {
		Assert.assertTrue(myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY));
	}

	@When("^user clicks on Add button to add a new team member$")
	public void user_clicks_on_Add_button_to_add_a_new_team_member() {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(MYLOConstants.ADD_BUTTON);
	}

	@Then("^user should be able to select \"([^\"]*)\" as role with \"([^\"]*)\" as team member from the dropdown for the new row created$")
	public void user_should_be_able_to_select_as_role_with_as_team_member_from_the_dropdown_for_the_new_row_created(
			String roleName, String memberName) {
		myloAssignmentPage.addRole(roleName);
		myloAssignmentPage.addTeamMember(memberName);
	}

	@Then("^user should have the capability to cancel the changes they have made to Aires File Team before saving the record$")
	public void user_should_have_the_capability_to_cancel_the_changes_they_have_made_to_Aires_File_Team_before_saving_the_record() {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(MYLOConstants.CANCEL_BUTTON);
		Assert.assertFalse(myloAssignmentPage.verifyRowAddedInAiresFileTeam());
	}

	@Given("^user is on Mylo Assignment Summary page for file ID \"([^\"]*)\"$")
	public void user_is_on_Mylo_Assignment_Summary_page_for_file_ID(String fileID) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.ASSIGNMENT);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY));
	}

	@Given("^user did not find the existing team member for specified \"([^\"]*)\" in the dropdown section after clicking on \"([^\"]*)\" button$")
	public void user_did_not_find_the_existing_team_member_for_specified_in_the_dropdown_section_after_clicking_on_button(
			String roleName, String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(buttonName);
		myloAssignmentPage.addRole(roleName);
		Assert.assertFalse(myloAssignmentPage.verifyExistingTeamMemberInDropdown(roleName));

	}

	@Given("^user selects \"([^\"]*)\" as role in the dropdown section after clicking on \"([^\"]*)\" button$")
	public void user_selects_as_role_in_the_dropdown_section_after_clicking_on_button(String roleName,
			String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(buttonName);
	}

	@Given("^pop up should appear with the message \"([^\"]*)\" after clicking \"([^\"]*)\" button on selecting different team member with \"([^\"]*)\"$")
	public void pop_up_should_appear_with_the_message_after_clicking_button_on_selecting_different_team_member_with(
			String msg, String buttonName, String roleName) {
		myloAssignmentPage.addRole(roleName);
		myloAssignmentPage.addTeamMember(MYLOConstants.RANDOM);
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(buttonName);
		Assert.assertTrue(myloAssignmentPage.verifyPopUpMessage(msg));
	}

	@When("^user clicks on \"([^\"]*)\" button$")
	public void user_clicks_on_button(String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(buttonName);
	}

	@Then("^new row should not be added in the Aires File Team section$")
	public void new_row_should_not_be_added_in_the_Aires_File_Team_section() {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(MYLOConstants.CANCEL_BUTTON);
		Assert.assertFalse(myloAssignmentPage.verifyRowAddedInAiresFileTeam());
	}

	@Then("^new row should be added for \"([^\"]*)\" with updated team member, End Date to current date$")
	public void new_row_should_be_added_for_with_updated_team_member_End_Date_to_current_date(String roleName) {
		Assert.assertTrue(myloAssignmentPage.verifyUpdatedRow(roleName));
	}

	@Given("^all the values are readonly in the AiresFileTeam grid$")
	public void all_the_values_are_readonly_in_the_AiresFileTeam_grid() {
		Assert.assertTrue(myloAssignmentPage.verifyAiresFileTeamRecordsReadonly());
	}

	@Given("^user has logged into the Mylo application with mentioned userType \"([^\"]*)\"$")
	public void user_has_logged_into_the_Mylo_application_with_mentioned_userType(String userType)
			throws InterruptedException {
		if (userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE15)) {
			Assert.assertTrue(myloDashboardPage.verifyUserName(loginData.MyloProfileName));
			loginPage.logout();
			loginPage.openApplication();
			loginPage.switchWindow();
			loginPage.clickAnotherAccount();
			loginPage.enterUserEmailAndPasswordForMylo(loginData.MyloWithOutResource15UserName, loginData.MyloPassword);
			loginPage.clickSignIn();
		}

	}

	@When("^user clicks on role dropdown after clicking on \"([^\"]*)\" button$")
	public void user_clicks_on_role_dropdown_after_clicking_on_button(String buttonName) {
		myloAssignmentPage.clickButtonOnAiresFileTeamSection(buttonName);
	}

	@Then("^\"([^\"]*)\" role options availability should depends on the type of Users \"([^\"]*)\" logged in$")
	public void role_options_availability_should_depends_on_the_type_of_Users_logged_in(String roleName,
			String userType) {
		if (userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE15))
			Assert.assertFalse(myloAssignmentPage.verifyRoleInDropdown(roleName));
		else
			Assert.assertTrue(myloAssignmentPage.verifyRoleInDropdown(roleName));
	}
}
