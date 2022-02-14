package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;
import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloAssignmentOtherAddresses_Steps {
	
	TestContext testContext;
	Mylo_LoginPage loginPage;
	Mylo_DashboardHomePage myloDashboardPage;
	Mylo_AssignmentPage myloAssignmentPage;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloAssignmentOtherAddresses_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
	}
	
	@Given("^he clicks on \"([^\"]*)\" under Other Addresses section after navigating to Assignment Page for file ID \"([^\"]*)\"$")
	public void he_clicks_on_under_Other_Addresses_section_after_navigating_to_Assignment_Page_for_file_ID(String buttonName, String fileID) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.verifyUserName(MYLOConstants.USER_PROFILE_NAME);
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.ASSIGNMENT);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
		myloAssignmentPage.clickElementOnOtherAddressesSection(buttonName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^system should change the \"([^\"]*)\" field label to \"([^\"]*)\"$")
	public void system_should_change_the_field_label_to(String fieldName, String expectedLabel) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertEquals(myloAssignmentPage.verifyOtherAddressFieldLabel(fieldName),expectedLabel,fieldName+ MYLOConstants.LABEL_IS_NOT_UPDATED + expectedLabel);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_FIELD_LABEL_UPDATED,
				CoreConstants.PASS, fieldName,expectedLabel,MYLOConstants.OTHER_ADDRESS));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^\"([^\"]*)\" should be the first country to be displayed after he clicks on the \"([^\"]*)\" Dropdown field$")
	public void should_be_the_first_country_to_be_displayed_after_he_clicks_on_the_Dropdown_field(String countryName, String fieldName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName);
		 Assert.assertTrue(myloAssignmentPage.verifyFirstCountry(countryName),CoreConstants.FAILED_TO_VERFY+countryName+MYLOConstants.AS_FIRST_COUNTRY  );
		 Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_COUNTRIES_PRESENT,
					CoreConstants.PASS, MYLOConstants.COUNTRY,MYLOConstants.STATE,MYLOConstants.OTHER_ADDRESS));
		 MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
			Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
					+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^remaining countries should be in alphabetical order$")
	public void remaining_countries_should_be_in_alphabetical_order() {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyDropdownListAlphabeticalOrder(MYLOConstants.COUNTRY),MYLOConstants.COUNTRY_DROPDOWN_NOT_IN_ASCENDING_ORDER);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_COUNTRY_PRESENT,
				CoreConstants.PASS, MYLOConstants.COUNTRY_DROPDOWN,MYLOConstants.OTHER_ADDRESS));
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.COUNTRY);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^\"([^\"]*)\" and Territories should display in the \"([^\"]*)\" dropdown not in abbreviated after selecting \"([^\"]*)\" as the country$")
	public void and_Territories_should_display_in_the_dropdown_not_in_abbreviated_after_selecting_as_the_country(String arg1, String fieldName, String countryName){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.COUNTRY);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, countryName);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.STATE);
		Assert.assertTrue(myloAssignmentPage.verifyStateListWithCountry(countryName),MYLOConstants.STATES_APPEARING_DOESNOT_BELONG + countryName);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_STATES_APPEARING,
				CoreConstants.PASS, countryName,MYLOConstants.COUNTRY_DROPDOWN,MYLOConstants.OTHER_ADDRESS));
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.STATE);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he enters any \"([^\"]*)\" besides India, US or Canada$")
	public void he_enters_any_besides_India_US_or_Canada(String fieldName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName, MYLOConstants.RANDOM);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@When("^he enters \"([^\"]*)\" \"([^\"]*)\" besides India, US or Canada$")
	public void he_enters_besides_India_US_or_Canada(String fieldValue, String fieldName){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName, fieldValue);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	   
	}

	@Then("^\"([^\"]*)\" field should be a free text field$")
	public void field_should_be_a_free_text_field(String fieldName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyOtherAddressFieldAvailability(fieldName),CoreConstants.FAILED_TO_VERFY + MYLOConstants.STATE_FIELD_EDITABLE);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_STATE_FREE_TEXT_FIELD,
				CoreConstants.PASS,MYLOConstants.OTHER_ADDRESS));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^he selects any \"([^\"]*)\" after selecting \"([^\"]*)\" as \"([^\"]*)\"$")
	public void he_selects_any_after_selecting_as(String fieldName1, String countryName, String fieldName2){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName2);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, countryName);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.STATE);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.STATE,MYLOConstants.RANDOM);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^a warning message should display as \"([^\"]*)\" after clicking on \"([^\"]*)\" button$")
	public void a_warning_message_should_display_as_after_clicking_on_button(String msg, String buttonName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(buttonName);
		Assert.assertTrue(myloAssignmentPage.verifyPopUpMessage(msg));
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.OK_BUTTON);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	
	@When("^he clicks on the \"([^\"]*)\" button under the \"([^\"]*)\" section$")
	public void he_clicks_on_the_button_under_the_section(String buttonName, String arg2) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(buttonName);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.OK_BUTTON);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he enters a \"([^\"]*)\" greater than (\\d+) characters$")
	public void he_enters_greater_than_characters(String fieldName, int maxlimit) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName, String.valueOf(maxlimit+1));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he enters a \"([^\"]*)\" less than or equal to (\\d+) characters$")
	public void he_enters_a_less_than_or_equal_to_characters(String fieldName, int maxlimit) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName, String.valueOf(maxlimit));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^below warning message should display after clicking on \"([^\"]*)\" button for \"([^\"]*)\" section$")
	public void below_warning_message_should_display_after_clicking_on_button_for_section(String buttonName, String sectionType, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		myloAssignmentPage.clickElementOnOtherAddressesSection(buttonName);
		Assert.assertTrue(myloAssignmentPage.verifyPopUpMessage(data.get(0).get(sectionType)));
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.OK_BUTTON);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}


	@Then("^\"([^\"]*)\" should be successfully saved in \"([^\"]*)\" section$")
	public void should_be_successfully_saved_in_section(String fieldName, String sectionName){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(sectionName);
		Assert.assertTrue(myloAssignmentPage.verifyUpdatedFieldValueOtherAddress(fieldName));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	

	@Then("^Saved data should get deleted after clicking on \"([^\"]*)\" button under \"([^\"]*)\" section$")
	public void saved_data_should_get_deleted_after_clicking_on_button_under_section(String buttonName, String arg2) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(buttonName);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.YES_BUTTON);
		Assert.assertTrue(myloAssignmentPage.verifySuccessMessage(MYLOConstants.DELETE_SUCCESS_MESSAGE));
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.OK_BUTTON);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^he selects \"([^\"]*)\" as \"([^\"]*)\" under \"([^\"]*)\"$")
	public void he_selects_as_under(String fieldValue, String fieldName, String sectionType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName, fieldValue);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Then("^\"([^\"]*)\" with \"([^\"]*)\" should be successfully saved in \"([^\"]*)\" section$")
	public void with_should_be_successfully_saved_in_section(String fieldName1, String fieldName2, String sectionName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(sectionName);
		Assert.assertTrue(myloAssignmentPage.verifyUpdatedFieldValueOtherAddress(fieldName1));
		Assert.assertTrue(myloAssignmentPage.verifyUpdatedFieldValueOtherAddress(fieldName2));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^he enters a \"([^\"]*)\" as \"([^\"]*)\"$")
	public void he_enters_a_as_(String fieldName, String fieldValue) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName, fieldValue);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^he enters a \"([^\"]*)\" less than (\\d+) characters$")
	public void he_enters_a_less_than_characters(String fieldName, int minlimit){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName, String.valueOf(minlimit-1));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he enters \"([^\"]*)\" as \"([^\"]*)\" with \"([^\"]*)\" as \"([^\"]*)\"$")
	public void he_enters_as_with_as(String fieldName1, String fieldValue1, String fieldName2, String fieldValue2){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName1, fieldValue1);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName2, fieldValue2);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^he clicks on \"([^\"]*)\" button after entering below details in \"([^\"]*)\" section$")
	public void he_clicks_on_button_after_entering_below_details_in_section(String buttonName, String sectionType, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.COUNTRY);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, data.get(0).get(MYLOConstants.COUNTRY));
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_ADDRESS1, data.get(0).get(MYLOConstants.TEMP_ADDRESS_ADDRESS1));
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_ADDRESS2, data.get(0).get(MYLOConstants.TEMP_ADDRESS_ADDRESS2));
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_CITY, data.get(0).get(MYLOConstants.TEMP_ADDRESS_CITY));
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.STATE);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.STATE, data.get(0).get(MYLOConstants.STATE));
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_ZIPCODE, data.get(0).get(MYLOConstants.TEMP_ADDRESS_ZIPCODE));
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_FROMDATE, data.get(0).get(MYLOConstants.TEMP_ADDRESS_FROMDATE));
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_COMMENTS, data.get(0).get(MYLOConstants.TEMP_ADDRESS_COMMENTS));
		myloAssignmentPage.clickElementOnOtherAddressesSection(buttonName);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.OK_BUTTON);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^he clicks on the \"([^\"]*)\" Dropdown field after clicking on \"([^\"]*)\" button under \"([^\"]*)\" section$")
	public void he_clicks_on_the_Dropdown_field_after_clicking_on_button_under_section(String fieldName, String buttonName, String sectionType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(sectionType);
		myloAssignmentPage.clickElementOnOtherAddressesSection(buttonName);
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
		
	}

	@Given("^\"([^\"]*)\" should be the first country to be displayed with remaining countries should be in alphabetical order$")
	public void should_be_the_first_country_to_be_displayed_with_remaining_countries_should_be_in_alphabetical_order(String countryName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		 Assert.assertTrue(myloAssignmentPage.verifyFirstCountry(countryName));
		 Assert.assertTrue(myloAssignmentPage.verifyDropdownListAlphabeticalOrder(MYLOConstants.COUNTRY));
		 myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.COUNTRY);
		 MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
			Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
					+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^\"([^\"]*)\" field should be a free text field with label \"([^\"]*)\" after selecting any \"([^\"]*)\" besides India, US or Canada$")
	public void field_should_be_a_free_text_field_with_label_after_selecting_any_besides_India_US_or_Canada(String fieldName2, String expectedLabel, String fieldName1) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName1);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, MYLOConstants.RANDOM);
		Assert.assertTrue(myloAssignmentPage.verifyOtherAddressFieldAvailability(fieldName2));
		Assert.assertEquals(myloAssignmentPage.verifyOtherAddressFieldLabel(fieldName2),expectedLabel);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^he reset the value of \"([^\"]*)\" as \"([^\"]*)\" with \"([^\"]*)\" as \"([^\"]*)\"$")
	public void he_reset_the_value_of_as_with_as(String fieldName1, String fieldValue1, String fieldName2, String fieldValue2)  {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName1);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, fieldValue1);
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName2);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.STATE, fieldValue2);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^\"([^\"]*)\" and \"([^\"]*)\" options should be available after clicking on \"([^\"]*)\" dropdown$")
	public void and_options_should_be_available_after_clicking_on_dropdown(String listContent1, String listContent2, String fieldName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName);
		Assert.assertTrue(myloAssignmentPage.verifyTypeDropwnList(listContent1));
		Assert.assertTrue(myloAssignmentPage.verifyTypeDropwnList(listContent2));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	

	@When("^he clicks on \"([^\"]*)\" button after changing the \"([^\"]*)\" dropdown to \"([^\"]*)\"$")
	public void he_clicks_on_button_after_changing_the_dropdown_to(String buttonName, String fieldName, String fieldValue) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName, fieldValue);
		myloAssignmentPage.clickElementOnOtherAddressesSection(buttonName);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.OK_BUTTON);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^System should save the address in \"([^\"]*)\" with \"([^\"]*)\" becoming empty$")
	public void system_should_save_the_address_in_with_becoming_empty(String sectionType1, String sectionType2) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyOtherAddressFieldAvailability(sectionType1));
		Assert.assertFalse(myloAssignmentPage.verifyOtherAddressFieldAvailability(sectionType2));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^\"([^\"]*)\" should be the first country to be displayed with remaining countries should be in alphabetical order under \"([^\"]*)\" section$")
	public void should_be_the_first_country_to_be_displayed_with_remaining_countries_should_be_in_alphabetical_order_under_section(String countryName, String sectionType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		 Assert.assertTrue(myloAssignmentPage.verifyFirstCountry(countryName));
		 Assert.assertTrue(myloAssignmentPage.verifyDropdownListAlphabeticalOrder(MYLOConstants.COUNTRY));
		 myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_COUNTRY);
		 MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
			Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
					+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^below fieldValues should appear under \"([^\"]*)\" section$")
	public void below_fieldValues_should_appear_under_section(String sectionType, DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(sectionType);
		Assert.assertTrue(myloAssignmentPage.verifyOtherAddressFieldValues(sectionType, table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^\"([^\"]*)\" and Territories should display in the \"([^\"]*)\" dropdown not in abbreviated after selecting \"([^\"]*)\" as the country under \"([^\"]*)\" section$")
	public void and_Territories_should_display_in_the_dropdown_not_in_abbreviated_after_selecting_as_the_country_under_section(String arg1, String fieldName, String countryName, String sectionType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_COUNTRY);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, countryName);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_STATE);
		Assert.assertTrue(myloAssignmentPage.verifyStateListWithCountry(countryName));
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_STATE);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^System should save the address in \"([^\"]*)\" with \"([^\"]*)\" becoming empty after changing the \"([^\"]*)\" dropdown to \"([^\"]*)\"$")
	public void system_should_save_the_address_in_with_becoming_empty_after_changing_the_dropdown_to(String sectionType2, String sectionType1, String fieldName, String fieldValue) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.MAIL_EDIT_BUTTON);
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName, fieldValue);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.OTHER_ADDRESS_SAVE_BUTTON);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.OK_BUTTON);
		Assert.assertTrue(myloAssignmentPage.verifyOtherAddressFieldAvailability(sectionType2));
		Assert.assertFalse(myloAssignmentPage.verifyOtherAddressFieldAvailability(sectionType1));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

}
