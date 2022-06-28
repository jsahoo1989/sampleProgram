package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyHistory_Steps {
	private TestContext testContext;
	private Mylo_LoginPage loginPage;
	private Mylo_DashboardHomePage myloDashboardPage;
	private Mylo_AssignmentPage myloAssignmentPage;
	private Mylo_JourneyPage myloJourneyPage;

	public MyloJourneyHistory_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
	}

	/**********************************************/
	@When("^he queries another file for file ID \"([^\"]*)\"$")
	public void he_queries_another_file_for_file_ID(String fileID) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.FILE_ID_ENTERED, CoreConstants.PASS, fileID));
		myloDashboardPage.clickExecuteButton();
	}

	@Then("^the prior file info should be displayed in the history card at the top of the page with the following data:$")
	public void the_prior_file_info_should_be_displayed_in_the_history_card_at_the_top_of_the_page_with_the_following_data(
			DataTable table) {
		Assert.assertTrue(myloAssignmentPage.verifyHistoryDetails(table.asMaps(String.class, String.class)),
				MYLOConstants.HISTORYCARD_DATA_NOT_MATCHING);
	}

	@Then("^the history card should continue to display after he refreshes the current session$")
	public void the_history_card_should_continue_to_display_after_he_refreshes_the_current_session() {
		myloAssignmentPage.pageRefresh();
		Assert.assertTrue(myloAssignmentPage.verifyHistoryCardPresent(), MYLOConstants.HISTORYCARD_NOTPRESENT);
	}

	@Then("^the history card should no longer display at the top of the page after he clicks on X$")
	public void the_history_card_should_no_longer_display_at_the_top_of_the_page_after_he_clicks_on_X() {
		myloAssignmentPage.clickElementHistoryCardSection(MYLOConstants.CloseHistoryCard);
		myloAssignmentPage.clickPopUpOkButton();
		Assert.assertFalse(myloAssignmentPage.verifyHistoryCardPresent(), MYLOConstants.HISTORYCARD_IS_PRESENT);
	}

	@Given("^he is on Mylo Assignment Summary page with (\\d+) recent files$")
	public void he_is_on_Mylo_Assignment_Summary_page_with_recent_files(int count) {
		List<String> fileIds = myloAssignmentPage.getMyloHistoryDetailsByEnv();
		myloDashboardPage.executeDifferentFileIds(count, fileIds);
	}

	@Given("^(\\d+) history cards is displayed at the top of the page ordered from left to right, left being the most recent$")
	public void history_cards_is_displayed_at_the_top_of_the_page_ordered_from_left_to_right_left_being_the_most_recent(
			int count) {
		Assert.assertTrue(myloAssignmentPage.verifyHistoryCardDetailsDisplayed(count),
				MYLOConstants.HISTORYCARD_DATA_NOT_MATCHING);
	}

	@Given("^(\\d+) most recent assignment history cards should display at the top of the page with (\\d+) card available in the dropdown of History card for (\\d+) recent files$")
	public void most_recent_assignment_history_cards_should_display_at_the_top_of_the_page_with_card_available_in_the_dropdown_of_History_card_for_recent_files(
			int arg1, int arg2, int totalFiles) {
		Assert.assertTrue(myloAssignmentPage.verifyHistoryCardDetailsDisplayed(totalFiles - 1),
				MYLOConstants.HISTORYCARD_DATA_NOT_MATCHING);
		int noOfHistCardDropdown = totalFiles - 4;
		myloAssignmentPage.clickElementHistoryCardSection(MYLOConstants.HistoryCardDropdown);
		Assert.assertTrue(myloAssignmentPage.verifyHistoryCardDetailsDropdown(noOfHistCardDropdown),
				MYLOConstants.HISTORYCARD_DATA_NOT_MATCHING);
		myloAssignmentPage.clickElementHistoryCardSection(MYLOConstants.HistoryCardDropdown);
	}

	@Then("^the least recent file history card should be displayed in the dropdown after he clicks on History card$")
	public void the_least_recent_file_history_card_should_be_displayed_in_the_dropdown_after_he_clicks_on_History_card() {
		myloAssignmentPage.clickElementHistoryCardSection(MYLOConstants.HistoryCardDropdown);
		Assert.assertTrue(myloAssignmentPage.verifyHistoryCardDetailsDropdown(1),
				MYLOConstants.HISTORYCARD_DATA_NOT_MATCHING);
	}

	@Then("^the history cards should no longer display at the top of the page after he relogins with same user$")
	public void the_history_cards_should_no_longer_display_at_the_top_of_the_page_after_he_relogins_with_same_user()
			throws InterruptedException {
		loginPage.loginWithUser(MYLOConstants.USER_WITH_RESOURCE15);
		String fileId = myloJourneyPage.getFileInfoFieldByEnvtAndType("activeAssignment", MYLOConstants.FILE_ID);
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileId);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.FILE_ID_ENTERED, CoreConstants.PASS, fileId));
		myloDashboardPage.clickExecuteButton();
		Assert.assertFalse(myloAssignmentPage.verifyHistoryCardPresent(), MYLOConstants.HISTORYCARD_IS_PRESENT);
	}

	@Then("^the most recent file should be added in the first position at the top with last (\\d+)th file being removed from the History dropdown$")
	public void the_most_recent_file_should_be_added_in_the_first_position_at_the_top_with_last_th_file_being_removed_from_the_History_dropdown(
			int arg1) {
		myloAssignmentPage.clickElementHistoryCardSection(MYLOConstants.HistoryCardDropdown);
		Assert.assertTrue(myloAssignmentPage.verifyHistoryCardDetailsDropdown(arg1 + 1),
				MYLOConstants.HISTORYCARD_DATA_NOT_MATCHING);
	}

	@When("^he deletes one of the history cards among (\\d+) recent files$")
	public void he_deletes_one_of_the_history_cards_among_recent_files(int totalCount) {
		myloAssignmentPage.deleteHistoryCard(totalCount);
		myloAssignmentPage.clickPopUpOkButton();
	}

	@Then("^file in (\\d+)nd position should now be displayed in the dropdown after he clicks on History card$")
	public void file_in_nd_position_should_now_be_displayed_in_the_dropdown_after_he_clicks_on_History_card(int arg1) {
		int noOfHistCardDropdown = (arg1 > 17) ? 17 : arg1;
		myloAssignmentPage.clickElementHistoryCardSection(MYLOConstants.HistoryCardDropdown);
		Assert.assertTrue(myloAssignmentPage.verifyHistoryCardDetailsDropdown(noOfHistCardDropdown),
				MYLOConstants.HISTORYCARD_DATA_NOT_MATCHING);
	}

	@Given("^remaining cards should shift one space towards the most recent for (\\d+) recent files$")
	public void remaining_cards_should_shift_one_space_towards_the_most_recent_for_recent_files(int arg1) {
		Assert.assertTrue(myloAssignmentPage.verifyHistoryCardDetailsDisplayed(arg1 - 1),
				MYLOConstants.HISTORYCARD_DATA_NOT_MATCHING);
	}

}
