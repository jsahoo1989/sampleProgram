package stepDefinitions.mylo;

import org.testng.Assert;

import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.MyloJourneyPage_TaxReportingSection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyTaxReportingInformation_Steps {
	private TestContext testContext;
	private Mylo_JourneyPage myloJourneyPage;
	private MyloJourneyPage_TaxReportingSection myloJourneyPageTaxReporting;
	private Mylo_DashboardHomePage myloDashboardPage;

	public MyloJourneyTaxReportingInformation_Steps(TestContext context) {
		testContext = context;
		myloJourneyPage = testContext.getMyloPageObjectManager().getJourneyPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloJourneyPageTaxReporting = testContext.getMyloPageObjectManager().getJourneyPageTaxReportingSection();
	}

	@Then("^\"([^\"]*)\" button should be enabled for Resource(\\d+) or disabled for Without Resource(\\d+) depending on \"([^\"]*)\"$")
	public void button_should_be_enabled_for_Resource_or_disabled_for_Without_Resource_depending_on(String btnName,
			int arg2, int arg3, String userType) {
		myloJourneyPageTaxReporting.taxReportingButtonEnabilityStatus(userType, btnName);
	}

	@Then("^\"([^\"]*)\" button should be disabled for both \"([^\"]*)\" status$")
	public void button_should_be_disabled_for_both_status(String btnName, String fileType) {
		myloJourneyPageTaxReporting.taxReportingButtonEnabilityStatus(fileType, btnName);
	}

	@Given("^the Expense management box is selected on Mylo Journey Tax Reporting Information section$")
	public void the_Expense_management_box_is_selected_on_Mylo_Journey_Tax_Reporting_Information_section() {
		myloJourneyPage.scrollToJourneySection(MYLOConstants.TAX_REPORTING_SECTION, MYLOConstants.JOURNEY);
		Assert.assertTrue(myloJourneyPageTaxReporting
				.checkBoxIsSelectedOnTaxReportingSection(MYLOConstants.EXPENSE_MANAGEMENT_CHECKBOX));
	}

	@When("^he un-checks the expense management box after clicking on \"([^\"]*)\" button on Mylo Journey Tax Reporting Information section$")
	public void he_un_checks_the_expense_management_box_after_clicking_on_button_on_Mylo_Journey_Tax_Reporting_Information_section(
			String btnName) {
		myloJourneyPageTaxReporting.clickFieldsOnTaxReportingSection(btnName);
		myloJourneyPageTaxReporting.clickFieldsOnTaxReportingSection(MYLOConstants.EXPENSE_MANAGEMENT);
	}

	@Then("^a popup should display \"([^\"]*)\" on Mylo Journey Tax Reporting Information section$")
	public void a_popup_should_display_on_Mylo_Journey_Tax_Reporting_Information_section(String msg) {
		Assert.assertTrue(myloJourneyPageTaxReporting.verifyPopUpMessage(msg));
	}

	@When("^he clicks on below dropdown fields after clicking on \"([^\"]*)\" button on Tax Reporting Information$")
	public void he_clicks_on_below_dropdown_fields_after_clicking_on_button_on_Tax_Reporting_Information(String btnName,
			DataTable table) {
		myloJourneyPage.scrollToJourneySection(MYLOConstants.TAX_REPORTING_SECTION, MYLOConstants.JOURNEY);
		myloJourneyPageTaxReporting.clickFieldsOnTaxReportingSection(btnName);
		myloJourneyPageTaxReporting.saveDropdownOptionsListOnTaxReportingSection(table);
	}

	@Then("^list of values displayed in the dropdown for below fields should match with the expected values$")
	public void list_of_values_displayed_in_the_dropdown_for_below_fields_should_match_with_the_expected_values(
			DataTable table) {
		myloJourneyPageTaxReporting.verifyDropDownListOnTaxReportInfo(table);
	}

	@Given("^he is on Mylo Journey Summary page for file ID with \"([^\"]*)\" where payment completion date has been passed$")
	public void he_is_on_Mylo_Journey_Summary_page_for_file_ID_with_where_payment_completion_date_has_been_passed(
			String fileType) {
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, myloJourneyPage.getFileInfo(fileType,MYLOConstants.FILE_ID));
		myloDashboardPage.clickExecuteButton();
	}

	@Then("^\"([^\"]*)\" button should be disabled on Tax Reporting Information section$")
	public void button_should_be_disabled_on_Tax_Reporting_Information_section(String btnName) {
		myloJourneyPageTaxReporting.taxReportingButtonEnabilityStatus(MYLOConstants.PAYMENT_CUT_OFF_COMPLETION,
				btnName);
	}

	@Given("^he has provided all mandatory information with below number Limit for mentioned fields after clicking on \"([^\"]*)\" icon on Tax Reporting Information section$")
	public void he_has_provided_all_mandatory_information_with_below_number_Limit_for_mentioned_fields_after_clicking_on_icon_on_Tax_Reporting_Information_section(
			String btnName, DataTable table) {
		myloJourneyPage.scrollToJourneySection(MYLOConstants.TAX_REPORTING_SECTION, MYLOConstants.JOURNEY);
		myloJourneyPageTaxReporting.clickFieldsOnTaxReportingSection(btnName);
		myloJourneyPageTaxReporting.setValuesOnTaxReportingSection(table);
	}

	@When("^he clicks on \"([^\"]*)\" button on Tax Reporting Information section$")
	public void he_clicks_on_button_on_Tax_Reporting_Information_section(String arg1) {
		myloJourneyPageTaxReporting.clickFieldsOnTaxReportingSection(MYLOConstants.SAVE_BUTTON);
	}

	@Then("^all values should be successfully saved as per below number limit for mentioned fields under Tax Reporting Information section on Mylo Journey Page$")
	public void all_values_should_be_successfully_saved_as_per_below_number_limit_for_mentioned_fields_under_Tax_Reporting_Information_section_on_Mylo_Journey_Page(
			DataTable table) {
		myloJourneyPageTaxReporting.verifyDifferentTaxReportingFieldsUpdatedValue(table);
	}

	@Then("^\"([^\"]*)\" field should get updated by the system generated mylo username along with date/time on Tax Reporting Information section$")
	public void field_should_get_updated_by_the_system_generated_mylo_username_along_with_date_time_on_Tax_Reporting_Information_section(
			String arg1) {
		Assert.assertTrue(myloJourneyPageTaxReporting.verifyUpdatedByField(MYLOConstants.MXSSODEV5),
				"Updated By User, Date and Time didnot get matched on Tax Reporting Section");
	}

}
