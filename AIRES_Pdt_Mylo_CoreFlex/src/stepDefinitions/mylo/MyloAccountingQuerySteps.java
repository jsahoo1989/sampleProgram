package stepDefinitions.mylo;

import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_AccountingQuerySection;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.MyloMemoryCapacityFileIds;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MyloAccountingQuerySteps {
	TestContext testContext;
	Mylo_LoginPage loginPage;
	Mylo_DashboardHomePage myloDashboardPage;
	Mylo_AssignmentPage myloAssignmentPage;
	MyloJourneyPage_AccountingQuerySection myloJourneyPageAccountingQuerySection;
	Mylo_JourneyPage myloJourneyPage;
	String sortColName;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);
	MyloMemoryCapacityFileIds myloFileIdDetails = FileReaderManager.getInstance().getMyloJsonReader()
			.getFileIdListByEnv("DEV5");

	public MyloAccountingQuerySteps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
		myloJourneyPageAccountingQuerySection=testContext.getMyloPageObjectManager().getJourneyAccountingQuery();
	}

	@Then("^tag script messages should be displayed for entering 'specialCharacters' on below fields after clicking on \"([^\"]*)\" button on \"([^\"]*)\" section$")
	public void tag_script_messages_should_be_displayed_for_entering_specialCharacters_on_below_fields_after_clicking_on_button_on_section(
			String btnName, String section, DataTable table) {
		myloJourneyPageAccountingQuerySection.verifySpecialCharactersToastMessage(table);
	}
	
	@Given("^he enters data beyond character limit for different fields under \"([^\"]*)\" section$")
	public void he_enters_data_beyond_character_limit_for_different_fields_under_section(String arg1, DataTable table){
		myloJourneyPageAccountingQuerySection.setFieldValueAsPerCharacterLimit(table);
	}

	@Then("^values should be successfully entered as per below character limit set for different fields under 'Accounting Query' section$")
	public void values_should_be_successfully_entered_as_per_below_character_limit_set_for_different_fields_under_Accounting_Query_section(DataTable arg1) {
	    
	}
}
