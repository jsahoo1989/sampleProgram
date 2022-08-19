package stepDefinitions.mylo;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_IdentityChallengeSection;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyIdentityChallenge_Steps {
	private TestContext testContext;
	private Mylo_DashboardHomePage myloDashboardPage;
	private Mylo_JourneyPage myloJourneyPage;
	private Mylo_AssignmentPage myloAssignmentPage;
	private MyloJourneyPage_IdentityChallengeSection myloJourneyPageIdentityChallengeSection;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloJourneyIdentityChallenge_Steps(TestContext context) {
		testContext = context;
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
		myloJourneyPageIdentityChallengeSection = testContext.getMyloPageObjectManager()
				.getJourneyPageIdentityChallengeSection();
	}

	@Given("^he is on Mylo Journey page for fileID with client having the \"([^\"]*)\" requirement$")
	public void he_is_on_Mylo_Journey_page_for_fileID_with_client_having_the_requirement(String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloJourneyPage.getFileInfoFieldByEnvtAndType(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
	}

	@Given("^\"([^\"]*)\" button is displayed on footer section for the file not in \"([^\"]*)\" or \"([^\"]*)\" status$")
	public void button_is_displayed_on_footer_section_for_the_file_not_in_or_status(String arg1, String statusName1,
			String statusName2) {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(MYLOConstants.DETAILS_CARROT_BUTTON);
		String statusDisplayed = myloAssignmentPage.getFileInfoFieldValue(MYLOConstants.STATUS);
		Assert.assertNotEquals(statusDisplayed, statusName1, MYLOConstants.MISMATCH_VALUE + MYLOConstants.STATUS);
		Assert.assertNotEquals(statusDisplayed, statusName2, MYLOConstants.MISMATCH_VALUE + MYLOConstants.STATUS);
		Assert.assertTrue(myloJourneyPageIdentityChallengeSection.verifyIdentityChallengeButtonExist(),
				MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
						MYLOConstants.IDENTITY_CHALLENGE_QUESTION, MYLOConstants.JOURNEY));
	}

	@When("^he clicks on \"([^\"]*)\" button without making an entry in the Answer field after clicking on \"([^\"]*)\" button on Mylo Journey page$")
	public void he_clicks_on_button_without_making_an_entry_in_the_Answer_field_after_clicking_on_button_on_Mylo_Journey_page(
			String buttonName, String buttonName2) {
		myloJourneyPageIdentityChallengeSection.clickFieldsOnIdentityChallengeSection(buttonName2);
		myloJourneyPageIdentityChallengeSection.setFieldValueOfIdentityChallengeSection(MYLOConstants.IC_ANSWER, "");
		myloJourneyPageIdentityChallengeSection.clickFieldsOnIdentityChallengeSection(buttonName);
	}

	@Then("^validation message \"([^\"]*)\" should be displayed on Mylo Journey page$")
	public void validation_message_should_be_displayed_on_Mylo_Journey_page(String msg) {
		Assert.assertTrue(myloJourneyPageIdentityChallengeSection.verifyToastMessage(msg),
				MessageFormat.format(MYLOConstants.VERIFIED_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, msg,
						MYLOConstants.IDENTITY_CHALLENGE_QUESTION));
	}

	@Then("^validation message \"([^\"]*)\" should be displayed after he enter special characters in the Answer field of identity Challenge question on Mylo Journey page$")
	public void validation_message_should_be_displayed_after_he_enter_special_characters_in_the_Answer_field_of_identity_Challenge_question_on_Mylo_Journey_page(
			String msg) {
		myloJourneyPageIdentityChallengeSection.setFieldValueOfIdentityChallengeSection(MYLOConstants.IC_ANSWER,
				MYLOConstants.SPECIAL_CHARACTERS_STRING);
		myloJourneyPageIdentityChallengeSection.clickFieldsOnIdentityChallengeSection(MYLOConstants.SAVE_BUTTON);
		Assert.assertTrue(myloJourneyPageIdentityChallengeSection.verifyToastMessage(msg),
				MessageFormat.format(MYLOConstants.VERIFIED_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL, msg,
						MYLOConstants.IDENTITY_CHALLENGE_QUESTION));
	}

	@Given("^he is on \"([^\"]*)\" section on \"([^\"]*)\" for fileID with client having the \"([^\"]*)\" requirement$")
	public void he_is_on_section_on_for_fileID_with_client_having_the_requirement(String buttonName, String arg2,
			String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloJourneyPage.getFileInfoFieldByEnvtAndType(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		myloJourneyPageIdentityChallengeSection.clickFieldsOnIdentityChallengeSection(buttonName);
	}

	@Given("^answer entered is not saved by clicking on \"([^\"]*)\" button after he made an entry in the Answer field$")
	public void answer_entered_is_not_saved_by_clicking_on_button_after_he_made_an_entry_in_the_Answer_field(
			String buttonName) {
		myloJourneyPageIdentityChallengeSection.setFieldValueOfIdentityChallengeSection(MYLOConstants.IC_ANSWER,
				MYLOConstants.TEST);
		myloJourneyPageIdentityChallengeSection.clickFieldsOnIdentityChallengeSection(buttonName);
		myloJourneyPageIdentityChallengeSection
				.clickFieldsOnIdentityChallengeSection(MYLOConstants.IDENTITY_CHALLENGE_QUESTION);
		Assert.assertNotEquals(
				myloJourneyPageIdentityChallengeSection
						.getFieldValueOfIdentityChallengeSection(MYLOConstants.IC_ANSWER),
				MYLOConstants.TEST, "Value is Saved even after hitting Cancel button");
	}

	@Given("^answer entered is not saved by clicking on \"([^\"]*)\" popup after he made an entry in the Answer field$")
	public void answer_entered_is_not_saved_by_clicking_on_popup_after_he_made_an_entry_in_the_Answer_field(
			String buttonName) {
		myloJourneyPageIdentityChallengeSection.setFieldValueOfIdentityChallengeSection(MYLOConstants.IC_ANSWER,
				MYLOConstants.TEST);
		myloJourneyPageIdentityChallengeSection.clickFieldsOnIdentityChallengeSection(buttonName);
		myloJourneyPageIdentityChallengeSection
				.clickFieldsOnIdentityChallengeSection(MYLOConstants.IDENTITY_CHALLENGE_QUESTION);
		Assert.assertNotEquals(myloJourneyPageIdentityChallengeSection.getFieldValueOfIdentityChallengeSection(
				MYLOConstants.IC_ANSWER), MYLOConstants.TEST, "Value is Saved even after hitting Close button");
	}

	@When("^he clicks on \"([^\"]*)\" button after entering more than \"([^\"]*)\" characters in the Answer field$")
	public void he_clicks_on_button_after_entering_more_than_characters_in_the_Answer_field(String buttonName,
			String arg2) {
		myloJourneyPageIdentityChallengeSection.setFieldValueOfIdentityChallengeSection(MYLOConstants.IC_ANSWER, "151");
		myloJourneyPageIdentityChallengeSection.clickFieldsOnIdentityChallengeSection(buttonName);
	}

	@Then("^answer should be successfully saved for that Identity Challenge Question with maximum \"([^\"]*)\" characters on Mylo Journey page$")
	public void answer_should_be_successfully_saved_for_that_Identity_Challenge_Question_with_maximum_characters_on_Mylo_Journey_page(
			String arg1) {
		myloJourneyPageIdentityChallengeSection
				.clickFieldsOnIdentityChallengeSection(MYLOConstants.IDENTITY_CHALLENGE_QUESTION);
		Assert.assertTrue(
				myloJourneyPageIdentityChallengeSection
						.verifyIdentityChallengeFieldsUpdatedValue(MYLOConstants.IC_ANSWER),
				MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.IC_ANSWER, MYLOConstants.IDENTITY_CHALLENGE_QUESTION, MYLOConstants.JOURNEY));
	}

	@Then("^existing Identity Challenge Question should be displayed with editable answer field$")
	public void existing_Identity_Challenge_Question_should_be_displayed_with_editable_answer_field() {
		myloJourneyPageIdentityChallengeSection.setFieldValueOfIdentityChallengeSection(MYLOConstants.IC_ANSWER,
				MYLOConstants.TEST);
		Assert.assertEquals(myloJourneyPageIdentityChallengeSection.getFieldValueOfIdentityChallengeSection(
				MYLOConstants.IC_ANSWER), MYLOConstants.TEST, "Answer is not editable");
		Assert.assertEquals(
				myloJourneyPageIdentityChallengeSection
						.getFieldValueOfIdentityChallengeSection(MYLOConstants.IC_QUESTION),
				MYLOConstants.IC_QUESTION_VALUE, MYLOConstants.MISMATCH_VALUE + MYLOConstants.IC_QUESTION_VALUE);
	}

}
