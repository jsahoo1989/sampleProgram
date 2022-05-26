package stepDefinitions.mylo;

import java.util.Map;

import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_PartnerSection;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeSection;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyPartner_Steps {

	TestContext testContext;
	Mylo_LoginPage loginPage;
	Mylo_DashboardHomePage myloDashboardPage;
	Mylo_AssignmentPage myloAssignmentPage;
	MyloJourneyPage_TransfereeSection myloJourneyPageTransfereeSection;
	MyloJourneyPage_PartnerSection myloJourneyPagePartnerSection;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloJourneyPartner_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
		myloJourneyPageTransfereeSection = testContext.getMyloPageObjectManager().getJourneyPageTransfereeSection();
		myloJourneyPagePartnerSection = testContext.getMyloPageObjectManager().getJourneyPagePartnerSection();
	}
	
	@Given("^he is on \"([^\"]*)\" section after clicking on 'Add' link displayed in right panel under \"([^\"]*)\" section for  \"([^\"]*)\" fileID$")
	public void he_is_on_section_after_clicking_on_Add_link_displayed_in_right_panel_under_section_for_fileID(String sectionType, String sectionHeader, String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsDataByFieldAndStatus(fileType, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		myloJourneyPageTransfereeSection.highlightSectionHeader(sectionHeader);
		myloJourneyPageTransfereeSection.clickFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
		myloJourneyPageTransfereeSection.highlightSectionHeader(MYLOConstants.PARTNER);
		myloJourneyPagePartnerSection.clickFieldsOnPartnerSection(sectionType);
	}

	@When("^he clicks on below Partner dropdown fields$")
	public void he_clicks_on_below_Partner_dropdown_fields(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloJourneyPagePartnerSection
					.saveDropdownListOptionsOnPartnerSection(data.get(i).get(MYLOConstants.FIELD_NAME));
		}
	}

	@Then("^list of values displayed in the dropdown for below Partner fields should match with the values present in respective tables on database$")
	public void list_of_values_displayed_in_the_dropdown_for_below_Partner_fields_should_match_with_the_values_present_in_respective_tables_on_database(
			DataTable table){
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloJourneyPagePartnerSection
					.verifyPartnerFieldDropdownListOptions(data.get(i).get(MYLOConstants.FIELD_NAME));
		}
	}

}
