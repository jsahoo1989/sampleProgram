package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.MyloJourneyPage_AuthTrackSection;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_JourneyPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyAuthTrack_Steps {
	
	private TestContext testContext;
	private Mylo_JourneyPage myloJourneyPage;
	private Mylo_AssignmentPage myloAssignmentPage;
	private MyloJourneyPage_AuthTrackSection myloJourneyPageAuthTrack;

	public MyloJourneyAuthTrack_Steps(TestContext context) {
		testContext = context;
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
		myloJourneyPageAuthTrack=testContext.getMyloPageObjectManager().getJourneyPageAuthTrackSection();
	}
	
	@When("^he views \"([^\"]*)\" section$")
	public void he_views_section(String sectionName) {
		myloJourneyPage.scrollToJourneySection(sectionName, MYLOConstants.JOURNEY);
	}

	@Then("^\"([^\"]*)\",\"([^\"]*)\" button should be enabled for Resource(\\d+) or disabled for Without Resource(\\d+) depending on \"([^\"]*)\"$")
	public void button_should_be_enabled_for_Resource_or_disabled_for_Without_Resource_depending_on(String btnName1, String btnName2, int arg3, int arg4, String userType){
		myloJourneyPageAuthTrack.authTrackButtonEnabilityStatus(userType, btnName1);
		myloJourneyPageAuthTrack.authTrackButtonEnabilityStatus(userType, btnName2);
	}

	@Then("^he should be able to view the comments by hovering over to the Authorization/Tracking comments sections$")
	public void he_should_be_able_to_view_the_comments_by_hovering_over_to_the_Authorization_Tracking_comments_sections()  {
	    Assert.assertEquals(myloJourneyPageAuthTrack.getHoverCommentText(0),MYLOConstants.TEST);
	}
	
	@Given("^\"([^\"]*)\" of the file should be \"([^\"]*)\"  after clicking on \"([^\"]*)\" on FileInformation section$")
	public void of_the_file_should_be_after_clicking_on_on_FileInformation_section(String fieldName, String statusName, String btnName) {
		myloAssignmentPage.clickButtonOnAiresFileInformationSection(btnName);
		Assert.assertEquals(myloAssignmentPage.getFileInfoFieldValue(fieldName), statusName,
				MYLOConstants.MISMATCH_VALUE + fieldName);
	}

	@Then("^\"([^\"]*)\",\"([^\"]*)\" button should be disabled for both \"([^\"]*)\" status$")
	public void button_should_be_disabled_for_both_status(String btnName1, String btnName2, String type){
		myloJourneyPageAuthTrack.authTrackButtonEnabilityStatus(type, btnName1);
		myloJourneyPageAuthTrack.authTrackButtonEnabilityStatus(type, btnName2);
	}
	
	@When("^he clicks on \"([^\"]*)\" label of \"([^\"]*)\" section$")
	public void he_clicks_on_label_of_section(String fieldName, String sectionname){
		myloJourneyPage.scrollToJourneySection(MYLOConstants.AUTH_TRACK_SECTION, MYLOConstants.JOURNEY);
		myloJourneyPageAuthTrack.clickFieldsOnAuthTrackSection(fieldName, 0);
	}

	@Then("^popup should be displayed with below fields for Resource(\\d+) or doesnot appear for Without Resource(\\d+) depending on \"([^\"]*)\" logged in$")
	public void popup_should_be_displayed_with_below_fields_for_Resource_or_doesnot_appear_for_Without_Resource_depending_on_logged_in(int arg1, int arg2, String userType, DataTable table){
		myloJourneyPageAuthTrack.verifyMyloAuthTrackHistorySectionPopUp(userType, table);
	}
	
	@Given("^a new row is added with below fields after clicking on \"([^\"]*)\" icon on Authorization/Tracking section$")
	public void a_new_row_is_added_with_below_fields_after_clicking_on_icon_on_Authorization_Tracking_section(String fieldName, DataTable table) {
		myloJourneyPage.scrollToJourneySection(MYLOConstants.AUTH_TRACK_SECTION, MYLOConstants.JOURNEY);
		myloJourneyPageAuthTrack.clickFieldsOnAuthTrackSection(fieldName, 0);
		Assert.assertTrue(myloJourneyPageAuthTrack.verifyFieldsAvailableOnAuthTrackSection(table));
	}

	@When("^he clicks on \"([^\"]*)\" button on Authorization/Tracking section$")
	public void he_clicks_on_button_on_Authorization_Tracking_section(String btnName) {
		myloJourneyPageAuthTrack.clickFieldsOnAuthTrackSection(btnName, 0);
	}

	@Then("^below toast messages should be displayed for respective mandatory fields on Mylo Journey page$")
	public void below_toast_messages_should_be_displayed_for_respective_mandatory_fields_on_Mylo_Journey_page(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue(myloJourneyPageAuthTrack.verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE),i),MessageFormat.format(MYLOConstants.VERIFIED_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL,
					data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.JOURNEY));
		}
	}
	
	@Given("^he has provided all mandatory information with below Character Limit for mentioned fields after clicking on \"([^\"]*)\" icon on Authorization/Tracking section$")
	public void he_has_provided_all_mandatory_information_with_below_Character_Limit_for_mentioned_fields_after_clicking_on_icon_on_Authorization_Tracking_section(String btnName, DataTable table) {
		myloJourneyPage.scrollToJourneySection(MYLOConstants.AUTH_TRACK_SECTION, MYLOConstants.JOURNEY);
		myloJourneyPageAuthTrack.clickAddIcon();
		myloJourneyPageAuthTrack.clickFieldsOnAuthTrackSection(MYLOConstants.AUTH_TRACK_TYPE, 0);
		myloJourneyPageAuthTrack.setTypeDropDownField(MYLOConstants.AUTH_TRACK_TYPE, MYLOConstants.RANDOM, 0);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloJourneyPageAuthTrack.setAuthTrackFields(data.get(i).get(MYLOConstants.FIELD_NAME),
					data.get(i).get(MYLOConstants.CHARACTER_LENGTH),0);
		}
		
	}

	@Then("^all values should be successfully saved as per below character limit for mentioned fields under Authorization/Tracking section on Mylo Journey Page$")
	public void all_values_should_be_successfully_saved_as_per_below_character_limit_for_mentioned_fields_under_Authorization_Tracking_section_on_Mylo_Journey_Page(DataTable table) {
		myloJourneyPageAuthTrack.verifyDifferentAuthTrackFieldsUpdatedValue(table, 0);
	}

	@Then("^Saved data should get deleted after clicking on \"([^\"]*)\" icon under Authorization/Tracking section$")
	public void saved_data_should_get_deleted_after_clicking_on_icon_under_Authorization_Tracking_section(String btnName) {
		myloJourneyPageAuthTrack.clickFieldsOnAuthTrackSection(MYLOConstants.EDIT_BUTTON, 0);
		myloJourneyPageAuthTrack.deleteAuthTrackaData(1);
		myloJourneyPageAuthTrack.clickFieldsOnAuthTrackSection(MYLOConstants.YES_BUTTON, 0);
	}
	
	@Then("^authTracking fields should be sorted as per the \"([^\"]*)\" selected with \"([^\"]*)\" from \"([^\"]*)\" dropdown on Authorization/Tracking section$")
	public void authtracking_fields_should_be_sorted_as_per_the_selected_with_from_dropdown_on_Authorization_Tracking_section(String arg1, String arg2, String arg3, DataTable table) {
		myloJourneyPage.scrollToJourneySection(MYLOConstants.AUTH_TRACK_SECTION, MYLOConstants.JOURNEY);
		myloJourneyPageAuthTrack.verifyAuthTrackFieldSortingOrder(table);
	}
	
	@Given("^Authorization/Tracking Information does not exist for a file$")
	public void authorization_Tracking_Information_does_not_exist_for_a_file() {
		myloJourneyPage.scrollToJourneySection(MYLOConstants.AUTH_TRACK_SECTION, MYLOConstants.JOURNEY);
		Assert.assertTrue(myloJourneyPageAuthTrack.verifyNoAuthTrackFileLink(),MYLOConstants.NOAUTHTRACK_FILE_NOT_PRESENT);
	}

	@When("^he clicks on the box with the \"([^\"]*)\"$")
	public void he_clicks_on_the_box_with_the(String fieldName) {
		myloJourneyPageAuthTrack.clickOnNoAuthTrackLink();
	}

	@Then("^a new row is added with below fields on Authorization/Tracking section$")
	public void a_new_row_is_added_with_below_fields_on_Authorization_Tracking_section(DataTable table) {
		Assert.assertTrue(myloJourneyPageAuthTrack.verifyFieldsAvailableOnAuthTrackSection(table));
	}

}
