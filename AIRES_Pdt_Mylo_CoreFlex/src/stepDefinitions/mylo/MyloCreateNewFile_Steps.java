package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Map;
import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_CreateNewFileSection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.testdatatypes.mylo.Mylo_FileData;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloCreateNewFile_Steps {
	private TestContext testContext;
	private Mylo_DashboardHomePage myloDashboardPage;
	private MyloJourneyPage_CreateNewFileSection myloNewFileSection;

	public MyloCreateNewFile_Steps(TestContext context) {
		testContext = context;
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloNewFileSection = testContext.getMyloPageObjectManager().getJourneyPageCreateNewFileSection();
	}

	Mylo_FileData myloNewFileData = FileReaderManager.getInstance().getMyloJsonReader()
			.getFileDataByFileType(MYLOConstants.CREATE_NEW_FILE);

	@Given("^he is on CreateNewFile section after clicking on \"([^\"]*)\" displayed in left panel under \"([^\"]*)\" section$")
	public void he_is_on_CreateNewFile_section_after_clicking_on_displayed_in_left_panel_under_section(
			String buttonName, String arg2) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(buttonName);
	}

	@Then("^he enters below fields under CreateNewFile section$")
	public void he_enters_below_fields_under_CreateNewFile_section(DataTable table) {
		myloNewFileSection.verifyMandatoryFieldsToastMessagesCreateNewFileSection(table);
	}

	@Then("^messages corresponding to below fields should be displayed after entering \"([^\"]*)\" for different fields of New File section$")
	public void messages_corresponding_to_below_fields_should_be_displayed_after_entering_for_different_fields_of_New_File_section(
			String arg1, DataTable table) {
		myloNewFileSection.verifySpecialCharacterToastMessagesOtherSection(table);
	}

	@Given("^he has provided all mandatory information on \"([^\"]*)\" section with below Character Limit for mentioned fields$")
	public void he_has_provided_all_mandatory_information_on_section_with_below_Character_Limit_for_mentioned_fields(
			String buttonName, DataTable table) throws Throwable {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(buttonName);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		myloNewFileSection.enterAllFieldsForNewFile(data.get(0).get(MYLOConstants.CHARACTER_LENGTH),
				data.get(1).get(MYLOConstants.CHARACTER_LENGTH), myloNewFileData.newFile.clientName,
				myloNewFileData.newFile.office, myloNewFileData.newFile.journeyType, myloNewFileData.newFile.policyType,
				myloNewFileData.newFile.taxTreatment, Boolean.TRUE);
	}

	@When("^he clicks on \"([^\"]*)\" button present under New File section$")
	public void he_clicks_on_button_present_under_New_File_section(String buttonName) {
		myloNewFileSection.clickFieldsOnNewFileSection(buttonName);
	}

	@Then("^all values should be successfully saved as per below character limit for mentioned fields under \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" sections on Journey Page$")
	public void all_values_should_be_successfully_saved_as_per_below_character_limit_for_mentioned_fields_under_sections_on_Journey_Page(
			String section1, String section2, String section3, String section4, String section5, String section6,
			DataTable table) {
		Assert.assertTrue(myloNewFileSection.verifyFileInfoInDifferentSection(section1),
				MessageFormat.format(MYLOConstants.MISMATCH_DIFFERENT_FIELDVALUES, CoreConstants.FAIL, section1));
		Assert.assertTrue(myloNewFileSection.verifyFileInfoInDifferentSection(section2),
				MessageFormat.format(MYLOConstants.MISMATCH_DIFFERENT_FIELDVALUES, CoreConstants.FAIL, section2));
		Assert.assertTrue(myloNewFileSection.verifyFileInfoInDifferentSection(section3),
				MessageFormat.format(MYLOConstants.MISMATCH_DIFFERENT_FIELDVALUES, CoreConstants.FAIL, section3));
		Assert.assertTrue(myloNewFileSection.verifyFileInfoInDifferentSection(section4),
				MessageFormat.format(MYLOConstants.MISMATCH_DIFFERENT_FIELDVALUES, CoreConstants.FAIL, section4));
		Assert.assertTrue(myloNewFileSection.verifyFileInfoInDifferentSection(section5),
				MessageFormat.format(MYLOConstants.MISMATCH_DIFFERENT_FIELDVALUES, CoreConstants.FAIL, section5));
		Assert.assertTrue(myloNewFileSection.verifyFileInfoInDifferentSection(section6),
				MessageFormat.format(MYLOConstants.MISMATCH_DIFFERENT_FIELDVALUES, CoreConstants.FAIL, section6));
	}

	@Then("^following information should be displayed under different sections mentioned below on Journey Page$")
	public void following_information_should_be_displayed_under_different_sections_mentioned_below_on_Journey_Page(
			DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue(
					myloNewFileSection.verifyFileInfoMessageDisplayedDifferentSections(
							data.get(i).get(MYLOConstants.SECTION_NAME), data.get(i).get(MYLOConstants.MESSAGE)),
					MessageFormat.format(MYLOConstants.VERIFIED_ALL_VALUES_UPDATED_ON_SECTION, CoreConstants.FAIL,
							MYLOConstants.CREATE_NEW_FILE, data.get(i).get(MYLOConstants.SECTION_NAME),
							MYLOConstants.JOURNEY));
		}
	}

	@Given("^no dropdown options for client is visible for invalid client \"([^\"]*)\" entered$")
	public void no_dropdown_options_for_client_is_visible_for_invalid_client_entered(String clientID) {
		myloNewFileSection.setNewFileFields(MYLOConstants.CLIENT_NAME, clientID);
		Assert.assertFalse(myloNewFileSection.isClientOptionsExistsInDropdown(),
				"Client Option is appearing in the dropdown for invalid ClientID: " + clientID);
	}

	@When("^he selects \"([^\"]*)\" client with journeyType as \"([^\"]*)\" after all mandatory fields provided$")
	public void he_selects_client_with_journeyType_as_after_all_mandatory_fields_provided(String arg1,
			String journeyType) {
		myloNewFileSection.enterAllFieldsForNewFile(MYLOConstants.RANDOM, MYLOConstants.RANDOM,
				myloNewFileData.newFile.affinityEnabledClient, myloNewFileData.newFile.office, journeyType, "", "",
				Boolean.TRUE);
	}

	@Then("^policyType dropdown field should be readonly field for affinity enabled journey type under CreateNewFile section$")
	public void policytype_dropdown_field_should_be_readonly_field_for_affinity_enabled_journey_type_under_CreateNewFile_section() {
		Assert.assertTrue(myloNewFileSection.verifyPolicyTypeFieldReadonly());
	}

	@Then("^message \"([^\"]*)\" should be displayed after he clicks on \"([^\"]*)\" button$")
	public void message_should_be_displayed_after_he_clicks_on_button(String msg, String buttonName) {
		myloNewFileSection.clickFieldsOnNewFileSection(buttonName);
		Assert.assertTrue(myloNewFileSection.verifyToastMessage(msg));
	}

}
