package stepDefinitions.mylo;

import java.text.MessageFormat;
import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.MyloJourneyPage_IdentityChallengeSection;
import com.aires.pages.mylo.MyloJourneyPage_SendLoginCredentials;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.pages.mylo.Mylo_LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneySendLoginCredentials_Steps {
	private TestContext testContext;
	Mylo_LoginPage myloLoginPage;
	private Mylo_DashboardHomePage myloDashboardPage;
	private Mylo_JourneyPage myloJourneyPage;
	private MyloJourneyPage_IdentityChallengeSection myloJourneyPageIdentityChallengeSection;
	private MyloJourneyPage_SendLoginCredentials myloJourneyPageSendLoginCredentials;

	public MyloJourneySendLoginCredentials_Steps(TestContext context) {
		testContext = context;
		myloLoginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
		myloJourneyPageIdentityChallengeSection = testContext.getMyloPageObjectManager()
				.getJourneyPageIdentityChallengeSection();
		myloJourneyPageSendLoginCredentials = testContext.getMyloPageObjectManager()
				.getJourneyPageSendLoginCredential();
	}

	@Given("^he is on Mylo Journey page for fileID with \"([^\"]*)\" requirement$")
	public void he_is_on_Mylo_Journey_page_for_fileID_with_requirement(String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
	}

	@When("^he clicks on the \"([^\"]*)\" button$")
	public void he_clicks_on_the_button(String btnName) {
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(btnName);
	}

	@Then("^pop up \"([^\"]*)\" should be displayed on MyloJourney page$")
	public void pop_up_should_be_displayed_on_MyloJourney_page(String popUpmsg) {
		Assert.assertTrue(myloJourneyPageSendLoginCredentials.verifyPopUpErrorMessage(popUpmsg),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP_MESSAGE_PAGE, CoreConstants.FAIL, popUpmsg,
						MYLOConstants.JOURNEY));
	}

	@Given("^he is on Mylo Journey page for fileID with \"([^\"]*)\" requirement without valid email for the transferee$")
	public void he_is_on_Mylo_Journey_page_for_fileID_with_requirement_without_valid_email_for_the_transferee(
			String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
	}

	@When("^he clicks on the \"([^\"]*)\" button after answering the Identity Challenge Question$")
	public void he_clicks_on_the_button_after_answering_the_Identity_Challenge_Question(String btnName) {
		myloJourneyPageIdentityChallengeSection
				.clickFieldsOnIdentityChallengeSection(MYLOConstants.IDENTITY_CHALLENGE_QUESTION);
		myloJourneyPageIdentityChallengeSection.setFieldValueOfIdentityChallengeSection(MYLOConstants.IC_ANSWER,
				MYLOConstants.TEST);
		myloJourneyPageIdentityChallengeSection.clickFieldsOnIdentityChallengeSection(MYLOConstants.SAVE_BUTTON);
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(btnName);

	}

	@Then("^\"([^\"]*)\" popup should be displayed containing the Identity Challenge Question Answer$")
	public void popup_should_be_displayed_containing_the_Identity_Challenge_Question_Answer(String arg1) {
		Assert.assertTrue(
				myloJourneyPageSendLoginCredentials.verifyIdentityVerificationPopUp(MYLOConstants.IC_QUESTION_VALUE,
						MYLOConstants.TEST),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP_MESSAGE_PAGE, CoreConstants.FAIL,
						MYLOConstants.IC_QUESTION + MYLOConstants.SPACE + MYLOConstants.IC_ANSWER,
						MYLOConstants.JOURNEY));
	}

	@Then("^popup \"([^\"]*)\" should be displayed after he clicks on \"([^\"]*)\" button$")
	public void popup_should_be_displayed_after_he_clicks_on_button(String popUpmsg, String btnName) {
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(btnName);
		Assert.assertTrue(myloJourneyPageSendLoginCredentials.verifyPopUpErrorMessage(popUpmsg),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP_MESSAGE_PAGE, CoreConstants.FAIL, popUpmsg,
						MYLOConstants.JOURNEY));
	}

	@Given("^he is on Mylo Journey page for fileID with \"([^\"]*)\" requirement having valid email for the transferee$")
	public void he_is_on_Mylo_Journey_page_for_fileID_with_requirement_having_valid_email_for_the_transferee(
			String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, "611085");
		myloDashboardPage.clickExecuteButton();
	}

	@When("^he clicks on \"([^\"]*)\" button after verifying the \"([^\"]*)\" popup$")
	public void he_clicks_on_button_after_verifying_the_popup(String btnName, String arg2) {
		Assert.assertTrue(
				myloJourneyPageSendLoginCredentials.verifyIdentityVerificationPopUp(MYLOConstants.IC_QUESTION_VALUE,
						MYLOConstants.TEST),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP_MESSAGE_PAGE, CoreConstants.FAIL,
						MYLOConstants.IC_QUESTION + MYLOConstants.SPACE + MYLOConstants.IC_ANSWER,
						MYLOConstants.JOURNEY));
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(btnName);
	}

	@Then("^popup \"([^\"]*)\" should be displayed on Mylo Journey page$")
	public void popup_should_be_displayed_on_Mylo_Journey_page(String popUpmsg) {
		Assert.assertTrue(myloJourneyPageSendLoginCredentials.verifyPopUpErrorMessage(popUpmsg),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP_MESSAGE_PAGE, CoreConstants.FAIL, popUpmsg,
						MYLOConstants.JOURNEY));
	}

	@Given("^he is on Mylo Journey page for fileID with \"([^\"]*)\" requirement having valid previously used email for the actualized transferee$")
	public void he_is_on_Mylo_Journey_page_for_fileID_with_requirement_having_valid_previously_used_email_for_the_actualized_transferee(
			String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
	}

	@Then("^popup should display prompting the user that email has been already used$")
	public void popup_should_display_prompting_the_user_that_email_has_been_already_used() {
		Assert.assertTrue(myloJourneyPageSendLoginCredentials.verifyMyloPopUpMessage(MYLOConstants.DUPLICATE_EMAIL_MSG),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP_MESSAGE_PAGE, CoreConstants.FAIL,
						MYLOConstants.DUPLICATE_EMAIL_MSG, MYLOConstants.JOURNEY));
	}

	@Then("^popup should be closed after clicking on \"([^\"]*)\" button$")
	public void popup_should_be_closed_after_clicking_on_button(String btnName) {
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(btnName);
		Assert.assertFalse(myloJourneyPageSendLoginCredentials.isPopUpexist(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.SEND_LOGIN_CREDENTIALS, MYLOConstants.JOURNEY));
	}

	@Then("^popup message \"([^\"]*)\" should be displayed on Mylo Journey page$")
	public void popup_message_should_be_displayed_on_Mylo_Journey_page(String msg) {
		Assert.assertTrue(myloJourneyPageSendLoginCredentials.verifyMyloPopUpMessage(msg), MessageFormat.format(
				MYLOConstants.FAILED_TO_VERIFY_POPUP_MESSAGE_PAGE, CoreConstants.FAIL, msg, MYLOConstants.JOURNEY));
	}

	@Given("^he is on Mylo Journey page for fileID with \"([^\"]*)\" requirement which has already received SSO email$")
	public void he_is_on_Mylo_Journey_page_for_fileID_with_requirement_which_has_already_received_SSO_email(
			String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
	}

	@Given("^he is on Mylo Journey page for fileID with \"([^\"]*)\" of actualized transferee having multiple emails$")
	public void he_is_on_Mylo_Journey_page_for_fileID_with_of_actualized_transferee_having_multiple_emails(
			String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
	}

	@Given("^popup \"([^\"]*)\" is displayed after clicking on \"([^\"]*)\" button$")
	public void popup_is_displayed_after_clicking_on_button(String msg, String btnName) {
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(btnName);
		Assert.assertTrue(myloJourneyPageSendLoginCredentials.verifyMyloPopUpMessage(msg), MessageFormat.format(
				MYLOConstants.FAILED_TO_VERIFY_POPUP_MESSAGE_PAGE, CoreConstants.FAIL, msg, MYLOConstants.JOURNEY));
	}

	@When("^he clicks on \"([^\"]*)\" button after selecting any email address from the popup$")
	public void he_clicks_on_button_after_selecting_any_email_address_from_the_popup(String btnName) {
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(MYLOConstants.EMAIL1);
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(btnName);
	}

	@Then("^popup \"([^\"]*)\" should be displayed on Mylo Journey page for resending the login credentials$")
	public void popup_should_be_displayed_on_Mylo_Journey_page_for_resending_the_login_credentials(String msg) {
		Assert.assertTrue(myloJourneyPageSendLoginCredentials.verifyMyloPopUpMessage(msg), MessageFormat.format(
				MYLOConstants.FAILED_TO_VERIFY_POPUP_MESSAGE_PAGE, CoreConstants.FAIL, msg, MYLOConstants.JOURNEY));
	}

	@Then("^login credentials should be sent to the email selected after clicking on \"([^\"]*)\"$")
	public void login_credentials_should_be_sent_to_the_email_selected_after_clicking_on(String btnName) {
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(btnName);
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(MYLOConstants.SEND_USERNAME_PSWD);
		Assert.assertTrue(myloLoginPage.readCredentialsFromMail(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_READ_USER_CREDENTIALS_FROM_GENERATED_EMAIL, CoreConstants.FAIL));
	}

	@Given("^login credentials should not be sent to the email selected after clicking on \"([^\"]*)\"$")
	public void login_credentials_should_not_be_sent_to_the_email_selected_after_clicking_on(String btnName) {
		myloJourneyPageSendLoginCredentials
				.clickFieldsOnSendLoginCredentialsSection(MYLOConstants.SEND_LOGIN_CREDENTIALS);
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(MYLOConstants.EMAIL1);
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(btnName);
		Assert.assertFalse(myloJourneyPageSendLoginCredentials.isPopUpexist(),
				MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
						MYLOConstants.SEND_LOGIN_CREDENTIALS, MYLOConstants.JOURNEY));
	}
	
	@Given("^he is in Login Credentials popup to send username and password for fileID with \"([^\"]*)\" requirement$")
	public void he_is_in_Login_Credentials_popup_to_send_username_and_password_for_fileID_with_requirement(String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(MYLOConstants.SEND_LOGIN_CREDENTIALS);
	}
	
	@Given("^login credentials should be sent to the email selected after clicking on \"([^\"]*)\" button$")
	public void login_credentials_should_be_sent_to_the_email_selected_after_clicking_on_button(String btnName) {
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(btnName);
		Assert.assertTrue(myloLoginPage.readCredentialsFromMail(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_READ_USER_CREDENTIALS_FROM_GENERATED_EMAIL, CoreConstants.FAIL));
	}
	
	@When("^he clicks on \"([^\"]*)\" button after verifying the \"([^\"]*)\" popup on Mylo Journey page$")
	public void he_clicks_on_button_after_verifying_the_popup_on_Mylo_Journey_page(String btnName, String msg) {
		Assert.assertTrue(myloJourneyPageSendLoginCredentials.verifyMyloPopUpMessage(msg), MessageFormat.format(
				MYLOConstants.FAILED_TO_VERIFY_POPUP_MESSAGE_PAGE, CoreConstants.FAIL, msg, MYLOConstants.JOURNEY));
		myloJourneyPageSendLoginCredentials.clickFieldsOnSendLoginCredentialsSection(btnName);	
		}
	
	@Given("^he is on Mylo Journey page for fileID with \"([^\"]*)\" that matches another file in Mylo$")
	public void he_is_on_Mylo_Journey_page_for_fileID_with_that_matches_another_file_in_Mylo(String fileType){
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
		myloDashboardPage.closePopUp();
	}

	@Then("^File Linking Window should appear with existing transferee details along with Data Integrity Alert messages$")
	public void file_Linking_Window_should_appear_with_existing_transferee_details_along_with_Data_Integrity_Alert_messages() {
		myloJourneyPageSendLoginCredentials.verifyFileLinkingSection();
		Assert.assertFalse(myloJourneyPageSendLoginCredentials.verifyfileLinkingButtonsEnability(MYLOConstants.LINK_TO_EXISTING_JOURNEY),MessageFormat.format(
				MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, MYLOConstants.LINK_TO_EXISTING_JOURNEY,MYLOConstants.FILE_LINKING_POPUP, MYLOConstants.JOURNEY));
		Assert.assertFalse(myloJourneyPageSendLoginCredentials.verifyfileLinkingButtonsEnability(MYLOConstants.LINK_TO_NEW_JOURNEY),MessageFormat.format(
				MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, MYLOConstants.LINK_TO_NEW_JOURNEY,MYLOConstants.FILE_LINKING_POPUP, MYLOConstants.JOURNEY));
	}

	@Then("^\"([^\"]*)\",\"([^\"]*)\" buttons should be enabled after selecting the transferee displayed$")
	public void buttons_should_be_enabled_after_selecting_the_transferee_displayed(String btnName1, String btnName2) {
		myloJourneyPageSendLoginCredentials.selectTransfereeInFileLinkingPopUp();
		Assert.assertTrue(myloJourneyPageSendLoginCredentials.verifyfileLinkingButtonsEnability(btnName1),MessageFormat.format(
				MYLOConstants.BUTTON_DISABLED, CoreConstants.FAIL, btnName1,MYLOConstants.FILE_LINKING_POPUP, MYLOConstants.JOURNEY));
		Assert.assertTrue(myloJourneyPageSendLoginCredentials.verifyfileLinkingButtonsEnability(btnName2),MessageFormat.format(
				MYLOConstants.BUTTON_DISABLED, CoreConstants.FAIL,btnName2,MYLOConstants.FILE_LINKING_POPUP, MYLOConstants.JOURNEY));
	}
}

