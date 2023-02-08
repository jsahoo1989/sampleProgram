package stepDefinitions.mylo;

import java.text.MessageFormat;
import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_CreateNewFileSection;
import com.aires.pages.mylo.MyloJourneyPage_TeamPostSection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.testdatatypes.mylo.MyloEnvironmentDetails;
import com.aires.utilities.CustomSoftAssert;
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyTeamPost_Steps {
	private TestContext testContext;
	private Mylo_DashboardHomePage myloDashboardPage;
	private Mylo_JourneyPage myloJourneyPage;
	private MyloJourneyPage_TeamPostSection myloJourneyPageTeamPostSection;
	private MyloJourneyPage_CreateNewFileSection myloNewFileSection;
	private CustomSoftAssert softAssert;
	// String _environment=System.getProperty("envt").toLowerCase();
	private String _environment = CoreFunctions.getPropertyFromConfig("envt").toLowerCase();
	private MyloEnvironmentDetails _myloEnvtDetails = FileReaderManager.getInstance().getMyloJsonReader()
			.getMyloLoginInfoByEnvt(_environment);

	public MyloJourneyTeamPost_Steps(TestContext context) {
		testContext = context;
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
		myloJourneyPageTeamPostSection = testContext.getMyloPageObjectManager().getJourneyPageTeamPostSection();
		myloNewFileSection = testContext.getMyloPageObjectManager().getJourneyPageCreateNewFileSection();
		softAssert = testContext.getSoftAssertObject();
	}

	@When("^he views 'Team Post' section on Mylo Journey page for \"([^\"]*)\" fileID$")
	public void he_views_Team_Post_section_on_Mylo_Journey_page_for_fileID(String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID,
				myloJourneyPage.getFileInfo(fileType, MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(myloJourneyPage.verifySectionHeader(MYLOConstants.TEAM_POSTS,
				MYLOConstants.TEAM_POSTS + MYLOConstants.COLON));
	}

	@Then("^he should be able to edit the Team Post created by same as well as other users on Mylo Journey page$")
	public void he_should_be_able_to_edit_the_Team_Post_created_by_same_as_well_as_other_users_on_Mylo_Journey_page() {
		Assert.assertTrue(myloJourneyPageTeamPostSection.isTeamPostEditOptionExist(MYLOConstants.MXSSODEV5),
				MessageFormat.format(MYLOConstants.BUTTON_NOT_EXISTS, CoreConstants.FAIL, MYLOConstants.EDIT_BUTTON,
						MYLOConstants.MXSSODEV5, MYLOConstants.TEAM_POSTS));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_EXISTS, CoreConstants.PASS,
				MYLOConstants.EDIT_BUTTON, MYLOConstants.MXSSODEV5, MYLOConstants.TEAM_POSTS));
		Assert.assertTrue(myloJourneyPageTeamPostSection.isTeamPostEditOptionExist(MYLOConstants.MXSSODEV7),
				MessageFormat.format(MYLOConstants.BUTTON_NOT_EXISTS, CoreConstants.FAIL, MYLOConstants.EDIT_BUTTON,
						MYLOConstants.MXSSODEV7, MYLOConstants.TEAM_POSTS));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_EXISTS, CoreConstants.PASS,
				MYLOConstants.EDIT_BUTTON, MYLOConstants.MXSSODEV7, MYLOConstants.TEAM_POSTS));
		Assert.assertTrue(myloJourneyPageTeamPostSection.isTeamPostEditOptionExist(MYLOConstants.MXSSODEV9),
				MessageFormat.format(MYLOConstants.BUTTON_NOT_EXISTS, CoreConstants.FAIL, MYLOConstants.EDIT_BUTTON,
						MYLOConstants.MXSSODEV9, MYLOConstants.TEAM_POSTS));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_EXISTS, CoreConstants.PASS,
				MYLOConstants.EDIT_BUTTON, MYLOConstants.MXSSODEV9, MYLOConstants.TEAM_POSTS));
	}

	@Then("^he should be able to edit the Team Post created by same users on Mylo Journey page$")
	public void he_should_be_able_to_edit_the_Team_Post_created_by_same_users_on_Mylo_Journey_page() {
		Assert.assertTrue(myloJourneyPageTeamPostSection.isTeamPostEditOptionExist(MYLOConstants.MXSSODEV9),
				MessageFormat.format(MYLOConstants.BUTTON_NOT_EXISTS, CoreConstants.FAIL, MYLOConstants.EDIT_BUTTON,
						MYLOConstants.MXSSODEV9, MYLOConstants.TEAM_POSTS));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_EXISTS, CoreConstants.PASS,
				MYLOConstants.EDIT_BUTTON, MYLOConstants.MXSSODEV9, MYLOConstants.TEAM_POSTS));
	}

	@Then("^he should not be able to edit the Team Post created by other users on Mylo Journey page$")
	public void he_should_not_be_able_to_edit_the_Team_Post_created_by_other_users_on_Mylo_Journey_page() {
		Assert.assertFalse(myloJourneyPageTeamPostSection.isTeamPostEditOptionExist(MYLOConstants.MXSSODEV7),
				MessageFormat.format(MYLOConstants.BUTTON_EXISTS, CoreConstants.FAIL, MYLOConstants.EDIT_BUTTON,
						MYLOConstants.MXSSODEV7, MYLOConstants.TEAM_POSTS));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_NOT_EXISTS, CoreConstants.PASS,
				MYLOConstants.EDIT_BUTTON, MYLOConstants.MXSSODEV7, MYLOConstants.TEAM_POSTS));
		Assert.assertFalse(myloJourneyPageTeamPostSection.isTeamPostEditOptionExist(MYLOConstants.MXSSODEV5),
				MessageFormat.format(MYLOConstants.BUTTON_EXISTS, CoreConstants.FAIL, MYLOConstants.EDIT_BUTTON,
						MYLOConstants.MXSSODEV5, MYLOConstants.TEAM_POSTS));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_NOT_EXISTS, CoreConstants.PASS,
				MYLOConstants.EDIT_BUTTON, MYLOConstants.MXSSODEV5, MYLOConstants.TEAM_POSTS));
	}

	/**
	 * PreCondition:User should be logged into the Mylo application Navigate to the
	 * TeamPost Edit section on Journey page by executing the assignment of given
	 * file type
	 * 
	 * @param btnName
	 * @param fileType
	 */
	@Given("^he is on 'Team Post' add section after clicking on \"([^\"]*)\" for fileID with type \"([^\"]*)\" on Mylo Journey page$")
	public void he_is_on_Team_Post_add_section_after_clicking_on_for_fileID_with_type_on_Mylo_Journey_page(
			String btnName, String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID,
				myloJourneyPage.getFileInfo(fileType, MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
		Assert.assertTrue(
				myloJourneyPage.verifySectionHeader(MYLOConstants.TEAM_POSTS,
						MYLOConstants.TEAM_POSTS + MYLOConstants.COLON),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.TEAM_POSTS + MYLOConstants.COLON,MYLOConstants.TEAM_POSTS));
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(btnName);
	}

	@When("^he views \"([^\"]*)\" button on 'Team Post' edit section after entering 'Comments'  without selecting 'Post Type'$")
	public void he_views_button_on_Team_Post_edit_section_after_entering_Comments_without_selecting_Post_Type(
			String buttonName) {
		myloJourneyPageTeamPostSection.setTeamPostCommentField("10", MYLOConstants.RANDOM_STRING);
		myloJourneyPageTeamPostSection.isTeamPostBtnEnabled(buttonName, MYLOConstants.DISABLE);
	}

	@Then("^\"([^\"]*)\" button of 'Team Post' section should be disabled on Mylo Journey page$")
	public void button_of_Team_Post_section_should_be_disabled_on_Mylo_Journey_page(String buttonName) {
		myloJourneyPageTeamPostSection.setTeamPostCommentField(" ", MYLOConstants.BLANK);
		myloJourneyPageTeamPostSection.selectTeamPostTypeField(MYLOConstants.GENERAL);
		myloJourneyPageTeamPostSection.isTeamPostBtnEnabled(buttonName, MYLOConstants.DISABLE);
	}

	@Then("^\"([^\"]*)\" button of 'Team Post' section should be disabled after selecting 'Post Type' without entering the 'Comments' on Mylo Journey page$")
	public void button_of_Team_Post_section_should_be_disabled_after_selecting_Post_Type_without_entering_the_Comments_on_Mylo_Journey_page(
			String buttonName) {
		myloJourneyPageTeamPostSection.setTeamPostCommentField("10", MYLOConstants.RANDOM_STRING);
		myloJourneyPageTeamPostSection.selectTeamPostTypeField(MYLOConstants.GENERAL);
		myloJourneyPageTeamPostSection.isTeamPostBtnEnabled(buttonName, MYLOConstants.ENABLE);
	}

	/**
	 * PreCondition:User should be logged into the Mylo application file type
	 * @param btnName
	 */
	@Given("^he is on 'Team Post' add section after clicking on \"([^\"]*)\" for newly created file on Mylo Journey page$")
	public void he_is_on_Team_Post_add_section_after_clicking_on_for_newly_created_file_on_Mylo_Journey_page(
			String btnName) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.createNewFileIfNotExists(MYLOConstants.AUTOMATION_CLIENT_ID, myloNewFileSection);
		softAssert.assertTrue(
				myloJourneyPage.verifySectionHeader(MYLOConstants.TEAM_POSTS,
						MYLOConstants.TEAM_POSTS + MYLOConstants.COLON),
				MessageFormat.format(MYLOConstants.MISMATCH_HEADERTEXT_SECTION, CoreConstants.FAIL,
						MYLOConstants.TEAM_POSTS));
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(btnName);
	}

	/**
	 * Adding a PostType in Team Post section on JourneyPage
	 * 
	 * @param btnName
	 * @param postType
	 */
	@When("^he clicks on \"([^\"]*)\" button after entering 'Comments' for the selected \"([^\"]*)\" on 'Team Post' section$")
	public void he_clicks_on_button_after_entering_Comments_for_the_selected_on_Team_Post_section(String btnName,
			String postType) {
		myloJourneyPageTeamPostSection.setTeamPostCommentField(MYLOConstants.COMMENT_FIELD_LENGTH, MYLOConstants.RANDOM_STRING);
		myloJourneyPageTeamPostSection.selectTeamPostTypeField(postType);
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(btnName);
	}

	/**
	 * Verify the Added PostType with its corresponding Background color on Team
	 * Post section
	 * 
	 * @param postType
	 */
	@Then("^\"([^\"]*)\" post should be successfully saved with respective 'Color Codes' on 'Team Post' section$")
	public void post_should_be_successfully_saved_with_respective_Color_Codes_on_Team_Post_section(String postType) {
		Assert.assertTrue(myloJourneyPage.verifyToastMessage(MYLOConstants.SAVE_SUCCESS_MESSAGE),MessageFormat.format(MYLOConstants.VERIFIED_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL,
				MYLOConstants.SAVE_SUCCESS_MESSAGE, MYLOConstants.JOURNEY));
		Assert.assertTrue(myloJourneyPageTeamPostSection.verifyTeamPostDisplayed(postType, MYLOConstants.TEAM_POSTS),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						postType + MYLOConstants.TEAM_POST_TYPE, MYLOConstants.TEAM_POSTS));
		softAssert.assertTrue(myloJourneyPageTeamPostSection.verifyTeamPostBgColor(postType, MYLOConstants.TEAM_POSTS),
				MessageFormat.format(MYLOConstants.INCORRECT_BG_COLOR, CoreConstants.FAIL,
						postType + MYLOConstants.SPACE + MYLOConstants.TEAM_POST_TYPE, MYLOConstants.TEAM_POSTS));
	}

	/**
	 * Add the PostType in Archive section and verify it with its corresponding
	 * Background color on Team Post Archive section
	 * 
	 * @param postType
	 * @param btnName
	 */
	@Then("^\"([^\"]*)\" post should be successfully archived by clicking on \"([^\"]*)\" after selecting the post on 'Team Post' section$")
	public void post_should_be_successfully_archived_by_clicking_on_after_selecting_the_post_on_Team_Post_section(
			String postType, String btnName) {
		myloJourneyPageTeamPostSection.isTeamPostBtnEnabled(btnName, MYLOConstants.DISABLE);
		myloJourneyPageTeamPostSection.selectTeamPost(postType);
		myloJourneyPageTeamPostSection.isTeamPostBtnEnabled(btnName, MYLOConstants.ENABLE);
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(btnName);
		Assert.assertTrue(myloJourneyPage.verifyToastMessage(MYLOConstants.ARCHIVE_SUCCESS_MESSAGE),MessageFormat.format(MYLOConstants.VERIFIED_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL,
				MYLOConstants.ARCHIVE_SUCCESS_MESSAGE, MYLOConstants.JOURNEY));
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(MYLOConstants.VIEW_ARCHIVE);
		Assert.assertTrue(myloJourneyPageTeamPostSection.verifyTeamPostDisplayed(postType, MYLOConstants.VIEW_ARCHIVE),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						postType + MYLOConstants.TEAM_POST_TYPE, MYLOConstants.VIEW_ARCHIVE));
		softAssert
				.assertTrue(myloJourneyPageTeamPostSection.verifyTeamPostBgColor(postType, MYLOConstants.VIEW_ARCHIVE),
						MessageFormat.format(MYLOConstants.INCORRECT_BG_COLOR, CoreConstants.FAIL,
								postType + MYLOConstants.SPACE + MYLOConstants.TEAM_POST_TYPE,
								MYLOConstants.VIEW_ARCHIVE));
	}

	/**
	 * Verify the added PostType in Team Post Expanded section with its
	 * corresponding Background color
	 * 
	 * @param postType
	 * @param sectionName
	 * @param btnName
	 */
	@Then("^\"([^\"]*)\" post should be displayed in \"([^\"]*)\" section after he clicks on \"([^\"]*)\" icon on 'Team Post' section$")
	public void post_should_be_displayed_in_section_after_he_clicks_on_icon_on_Team_Post_section(String postType,
			String sectionName, String btnName) {
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(btnName);
		Assert.assertTrue(
				myloJourneyPageTeamPostSection.verifyTeamPostDisplayed(postType, MYLOConstants.TEAM_POST_EXPANDED),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						postType + MYLOConstants.TEAM_POST_TYPE, sectionName));
		softAssert.assertTrue(
				myloJourneyPageTeamPostSection.verifyTeamPostBgColor(postType, MYLOConstants.TEAM_POST_EXPANDED),
				MessageFormat.format(MYLOConstants.INCORRECT_BG_COLOR, CoreConstants.FAIL,
						postType + MYLOConstants.SPACE + MYLOConstants.TEAM_POST_TYPE, sectionName));
		softAssert.assertAll();
	}

	@When("^he clicks on \"([^\"]*)\" of 'Team Post' filter section on Mylo Journey page$")
	public void he_clicks_on_of_Team_Post_filter_section_on_Mylo_Journey_page(String postType) {
		Assert.assertTrue(myloJourneyPage.verifySectionHeader(MYLOConstants.TEAM_POSTS,
				MYLOConstants.TEAM_POSTS + MYLOConstants.COLON));
		myloJourneyPageTeamPostSection.clickFilterOnTeamPostSection(postType);
	}

	@Then("^'Team Post' section should only display the existing posts for \"([^\"]*)\" on Mylo Journey page$")
	public void team_Post_section_should_only_display_the_existing_posts_for_on_Mylo_Journey_page(String postType) {
		Assert.assertTrue(
				myloJourneyPageTeamPostSection.verifyFilteredPostDisplayed(postType, MYLOConstants.TEAM_POSTS),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						postType + MYLOConstants.TEAM_POST_TYPE, MYLOConstants.TEAM_POST_EXPANDED));
		
		softAssert.assertTrue(
				myloJourneyPageTeamPostSection.verifyFilteredPostBgColor(postType, MYLOConstants.TEAM_POSTS),
				MessageFormat.format(MYLOConstants.INCORRECT_BG_COLOR, CoreConstants.FAIL,
						postType + MYLOConstants.SPACE + MYLOConstants.TEAM_POST_TYPE,
						MYLOConstants.TEAM_POST_EXPANDED));
	}

	@Then("^filter should remain applied for \"([^\"]*)\" after he clicks on \"([^\"]*)\" icon on Mylo Journey page$")
	public void filter_should_remain_applied_for_after_he_clicks_on_icon_on_Mylo_Journey_page(String postType,
			String btnName) {
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(btnName);
		Assert.assertTrue(
				myloJourneyPageTeamPostSection.verifyFilteredPostDisplayed(postType, MYLOConstants.TEAM_POST_EXPANDED),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						postType + MYLOConstants.TEAM_POST_TYPE, MYLOConstants.TEAM_POST_EXPANDED));
		
		softAssert.assertTrue(
				myloJourneyPageTeamPostSection.verifyFilteredPostBgColor(postType, MYLOConstants.TEAM_POST_EXPANDED),
				MessageFormat.format(MYLOConstants.INCORRECT_BG_COLOR, CoreConstants.FAIL,
						postType + MYLOConstants.SPACE + MYLOConstants.TEAM_POST_TYPE,
						MYLOConstants.TEAM_POST_EXPANDED));
	}
	
	@Given("^he has added multiple posts of mentioned 'PostTypes' on 'Team Post' section for newly created file on Mylo Journey page$")
	public void he_has_added_multiple_posts_of_mentioned_PostTypes_on_Team_Post_section_for_newly_created_file_on_Mylo_Journey_page(
			DataTable table) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.createNewFileIfNotExists(MYLOConstants.AUTOMATION_CLIENT_ID, myloNewFileSection);
		myloJourneyPageTeamPostSection.addmultipleTeamPostIfNotExist(table);
	}

	@When("^he enters first (\\d+) characters in the \"([^\"]*)\" field of 'Team Post' section on Mylo Journey Page$")
	public void he_enters_first_characters_in_the_field_of_Team_Post_section_on_Mylo_Journey_Page(int arg1,
			String arg2) {
		Assert.assertTrue(
				myloJourneyPage.verifySectionHeader(MYLOConstants.TEAM_POSTS,
						MYLOConstants.TEAM_POSTS + MYLOConstants.COLON),
				MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.TEAM_POSTS + MYLOConstants.COLON,MYLOConstants.TEAM_POSTS));
		myloJourneyPageTeamPostSection.searchTeamPostComments();
	}

	@Then("^post should be filtered as per search criteria with matched characters displayed in bold letters$")
	public void post_should_be_filtered_as_per_search_criteria_with_matched_characters_displayed_in_bold_letters() {
		Assert.assertTrue(
				myloJourneyPageTeamPostSection.verifyPostDisplayedOnSearchedComments(MYLOConstants.TEAM_POSTS),
				MessageFormat.format(MYLOConstants.VERIFIED_NOT_DISPLAYED, CoreConstants.FAIL, MYLOConstants.POST,
						MYLOConstants.SEARCHED_TEXT, MYLOConstants.TEAM_POSTS));
		softAssert.assertTrue(
				myloJourneyPageTeamPostSection.verifySearchedTextDisplayedInBold(MYLOConstants.TEAM_POSTS),
				MessageFormat.format(MYLOConstants.SEARCHED_TEXT_NOT_BOLD, CoreConstants.FAIL,
						MYLOConstants.TEAM_POSTS));
	}

	@Then("^search criteria should remain applied after he clicks on \"([^\"]*)\" icon on Mylo Journey page$")
	public void search_criteria_should_remain_applied_after_he_clicks_on_icon_on_Mylo_Journey_page(String btnName) {
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(btnName);
		Assert.assertTrue(
				myloJourneyPageTeamPostSection.verifyPostDisplayedOnSearchedComments(MYLOConstants.TEAM_POST_EXPANDED),
				MessageFormat.format(MYLOConstants.VERIFIED_NOT_DISPLAYED, CoreConstants.FAIL, MYLOConstants.POST,
						MYLOConstants.SEARCHED_TEXT, MYLOConstants.TEAM_POST_EXPANDED));
		softAssert.assertTrue(
				myloJourneyPageTeamPostSection.verifySearchedTextDisplayedInBold(MYLOConstants.TEAM_POST_EXPANDED),
				MessageFormat.format(MYLOConstants.SEARCHED_TEXT_NOT_BOLD, CoreConstants.FAIL,
						MYLOConstants.TEAM_POST_EXPANDED));
	}
	
	@Given("^he is on 'Team Post' section after adding any 'Post Type' for newly created file on Mylo Journey page$")
	public void he_is_on_Team_Post_section_after_adding_any_Post_Type_for_newly_created_file_on_Mylo_Journey_page(){
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.createNewFileIfNotExists(MYLOConstants.AUTOMATION_CLIENT_ID, myloNewFileSection);
		myloJourneyPageTeamPostSection.addTeamPostWithRandomComments(MYLOConstants.RANDOM);
	}

	@When("^he clicks on \"([^\"]*)\" button associated with the added 'Post' on 'Team Post' section$")
	public void he_clicks_on_button_associated_with_the_added_Post_on_Team_Post_section(String btnName){
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(btnName);
	}

	@Then("^\"([^\"]*)\" button of 'Team Post' section should be disabled$")
	public void button_of_Team_Post_section_should_be_disabled(String btnName){
		myloJourneyPageTeamPostSection.isTeamPostBtnEnabled(btnName, MYLOConstants.DISABLE);
	}

	@Then("^\"([^\"]*)\" button should be enabled after he made changes to 'Comments' or 'Post Type' on 'Team Post' section$")
	public void button_should_be_enabled_after_he_made_changes_to_Comments_or_Post_Type_on_Team_Post_section(String btnName) {
		myloJourneyPageTeamPostSection.setTeamPostCommentField(MYLOConstants.COMMENT_FIELD_LENGTH, MYLOConstants.RANDOM_STRING);
		myloJourneyPageTeamPostSection.isTeamPostBtnEnabled(btnName, MYLOConstants.ENABLE);
		myloJourneyPageTeamPostSection.selectTeamPostTypeField(MYLOConstants.RANDOM);
	}
	
	@Given("^team post should be successfully updated after he clicks on \"([^\"]*)\" button on 'Team Post' section$")
	public void team_post_should_be_successfully_updated_after_he_clicks_on_button_on_Team_Post_section(String btnName){
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(btnName);
		Assert.assertTrue(myloJourneyPageTeamPostSection.verifyTeamPostUpdated(MYLOConstants.TEAM_POSTS));
	}
	
	@When("^he clicks on \"([^\"]*)\" icon of 'Team Post' section on Mylo Journey Page$")
	public void he_clicks_on_icon_of_Team_Post_section_on_Mylo_Journey_Page(String btnName){
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(btnName);
	}

	@Then("^'Post' should be sorted in \"([^\"]*)\" order with arrow pointing up on 'Team Post' section$")
	public void post_should_be_sorted_in_order_with_arrow_pointing_up_on_Team_Post_section(String sortOrder){
		Assert.assertTrue(myloJourneyPageTeamPostSection.verifyTeamPostSorted(sortOrder, MYLOConstants.TEAM_POSTS_DATES));
	}

	@Then("^'Post' should be sorted in \"([^\"]*)\" order with arrow pointing down after he clicks on \"([^\"]*)\" icon again on 'Team Post' section$")
	public void post_should_be_sorted_in_order_with_arrow_pointing_down_after_he_clicks_on_icon_again_on_Team_Post_section(String sortOrder, String btnName){
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(btnName);
		Assert.assertTrue(myloJourneyPageTeamPostSection.verifyTeamPostSorted(sortOrder, MYLOConstants.TEAM_POSTS_DATES));
	}
	
	@Given("^'Post' should remain in \"([^\"]*)\" order after he clicks on \"([^\"]*)\" icon on Mylo Journey page$")
	public void post_should_remain_in_order_after_he_clicks_on_icon_on_Mylo_Journey_page(String sortOrder, String btnName){
		myloJourneyPageTeamPostSection.clickButtonsOnTeamPostSection(btnName);
		Assert.assertTrue(myloJourneyPageTeamPostSection.verifyTeamPostSorted(sortOrder, MYLOConstants.TEAM_POST_EXPANDED_DATES));
	}
}
