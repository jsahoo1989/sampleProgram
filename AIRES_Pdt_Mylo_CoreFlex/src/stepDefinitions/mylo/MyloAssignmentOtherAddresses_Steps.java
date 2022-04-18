package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
	
	/**********************************************/
	@Given("^he is on \"([^\"]*)\" section after clicking on 'Add' link displayed in left panel under \"([^\"]*)\" section for file ID \"([^\"]*)\"$")
	public void he_is_on_section_after_clicking_on_Add_link_displayed_in_left_panel_under_section_for_file_ID(String sectionType, String section, String fileID) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.verifyUserName(MYLOConstants.USER_PROFILE_NAME);
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
		myloAssignmentPage.clickElementOnOtherAddressesSection(sectionType);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^\"([^\"]*)\" is the first country to be displayed with remaining countries in alphabetical order in \"([^\"]*)\" dropdown field$")
	public void is_the_first_country_to_be_displayed_with_remaining_countries_in_alphabetical_order_in_dropdown_field(String countryName, String fieldName) throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName);
		 Assert.assertTrue(myloAssignmentPage.verifyFirstCountry(countryName),CoreConstants.FAILED_TO_VERFY+countryName+MYLOConstants.AS_FIRST_COUNTRY  );
		 Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_COUNTRY_PRESENT,
					CoreConstants.PASS, MYLOConstants.USA_STATE,MYLOConstants.COUNTRY_DROPDOWN,MYLOConstants.OTHER_ADDRESS));
		 Assert.assertTrue(myloAssignmentPage.verifyDropdownListOrder(MYLOConstants.COUNTRY),MYLOConstants.COUNTRY_DROPDOWN_NOT_IN_ASCENDING_ORDER);
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_COUNTRIES_PRESENT,
					CoreConstants.PASS,MYLOConstants.COUNTRY_DROPDOWN,MYLOConstants.OTHER_ADDRESS));
			myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.COUNTRY);
		 MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
			Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
					+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^corresponding States and Territories is displayed in the 'State/Territory' dropdown after selecting \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as the country respectively$")
	public void corresponding_States_and_Territories_is_displayed_in_the_State_Territory_dropdown_after_selecting_and_as_the_country_respectively(String countryName1, String countryName2, String countryName3) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		List<String> countryList=Arrays.asList(countryName1, countryName2, countryName3);
		for (String country : countryList) {
			myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.COUNTRY);
			myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, country);
			myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.STATE);
			Assert.assertTrue(myloAssignmentPage.verifyStateListWithCountry(country),MYLOConstants.STATES_APPEARING_DOESNOT_BELONG + country);
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_STATES_APPEARING,
					CoreConstants.PASS, country,MYLOConstants.OTHER_ADDRESS));
			//myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.STATE);
		}
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
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
	
	@Then("^\"([^\"]*)\" field should be a free text field with label as \"([^\"]*)\"$")
	public void field_should_be_a_free_text_field_with_label_as(String fieldName, String expectedLabel) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyOtherAddressFieldAvailability(fieldName),CoreConstants.FAILED_TO_VERFY + MYLOConstants.STATE_FIELD_EDITABLE);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_STATE_FREE_TEXT_FIELD,
				CoreConstants.PASS,MYLOConstants.OTHER_ADDRESS));
		Assert.assertEquals(myloAssignmentPage.verifyOtherAddressFieldLabel(fieldName),expectedLabel,fieldName+ MYLOConstants.LABEL_IS_NOT_UPDATED + expectedLabel);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_FIELD_LABEL_UPDATED,
				CoreConstants.PASS, fieldName,expectedLabel,MYLOConstants.OTHER_ADDRESS));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^he enters below invalid data for mentioned fields with other mandatory data being provided for \"([^\"]*)\" section$")
	public void he_enters_below_invalid_data_for_mentioned_fields_with_other_mandatory_data_being_provided_for_section(String sectionType, DataTable table){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.verifyOtherAddressSectionToastMessages(sectionType,table);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@When("^he clicks on \"([^\"]*)\" button after entering below valid data for respective fields$")
	public void he_clicks_on_button_after_entering_below_valid_data_for_respective_fields(String buttonName, DataTable table){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.setFieldValueOtherAddressSection(table);
		myloAssignmentPage.clickElementOnOtherAddressesSection(buttonName);
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessage(MYLOConstants.OTHER_ADDDRESS_SAVED_MESSAGE));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>"); 
	}
	
	@Then("^below fieldValues should be successfully saved under \"([^\"]*)\" section$")
	public void below_fieldValues_should_be_successfully_saved_under_section(String sectionType,DataTable table) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(sectionType);
		Assert.assertTrue(myloAssignmentPage.verifyFieldValuesOtherAddress(sectionType, table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Then("^Saved data should get deleted after clicking on \"([^\"]*)\" button under \"([^\"]*)\" section$")
	public void saved_data_should_get_deleted_after_clicking_on_button_under_section(String buttonName, String sectionType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(buttonName);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.YES_BUTTON);
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessage(MYLOConstants.DELETE_SUCCESS_MESSAGE));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Then("^messages corresponding to below fields should be displayed after entering \"([^\"]*)\" along with the mandatory data for both \"([^\"]*)\", \"([^\"]*)\" section$")
	public void messages_corresponding_to_below_fields_should_be_displayed_after_entering_along_with_the_mandatory_data_for_both_section(String fieldValue, String sectionType1, String sectionType2, DataTable table) throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.setSpecialCharacters(sectionType1, table);
		myloAssignmentPage.setSpecialCharacters(sectionType2, table);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Then("^entered data for below fields should be successfully saved in \"([^\"]*)\" section$")
	public void entered_data_for_below_fields_should_be_successfully_saved_in_section(String sectionType, DataTable table){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(sectionType);
		myloAssignmentPage.verifyOtherAddressUpdatedFieldValues(sectionType, table);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^he enters below invalid data combination for mandatory fields for \"([^\"]*)\" section$")
	public void he_enters_below_invalid_data_combination_for_mandatory_fields_for_section(String sectionType, DataTable table) throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.verifyMandatoryFieldsToastMessagesOtherAddress(sectionType,table);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@When("^he enters below valid data for mandatory fields for \"([^\"]*)\" section$")
	public void he_enters_below_valid_data_for_mandatory_fields_for_section(String sectionType, DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			myloAssignmentPage.setMandatoryFieldValuesOtherAddressSection(sectionType, table);
			myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.SAVE_BUTTON);
			Assert.assertTrue(myloAssignmentPage.verifyAlertMessage(MYLOConstants.OTHER_ADDDRESS_SAVED_MESSAGE));
			myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.CLOSE_BUTTON);
		}
	}
	
	@Given("^he has saved below data on \"([^\"]*)\" under Other Addresses section after navigating to Assignment Page for file ID \"([^\"]*)\"$")
	public void he_has_saved_below_data_on_under_Other_Addresses_section_after_navigating_to_Assignment_Page_for_file_ID(String sectionType, String fileID, DataTable table){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.verifyUserName(MYLOConstants.USER_PROFILE_NAME);
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
		myloAssignmentPage.clickElementOnOtherAddressesSection(sectionType);
		myloAssignmentPage.setFieldValueOtherAddressSection(table);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.SAVE_BUTTON);
		Assert.assertTrue(myloAssignmentPage.verifyAlertMessage(MYLOConstants.OTHER_ADDDRESS_SAVED_MESSAGE));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^\"([^\"]*)\" is the first country to be displayed with remaining countries in alphabetical order on \"([^\"]*)\" under \"([^\"]*)\" section$")
	public void is_the_first_country_to_be_displayed_with_remaining_countries_in_alphabetical_order_on_under_section(String countryName, String fieldName, String sectionType) throws Throwable {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(sectionType);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.TEMP_EDIT_BUTTON);
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName);
		 Assert.assertTrue(myloAssignmentPage.verifyFirstCountry(countryName));
		 Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_COUNTRY_PRESENT,
					CoreConstants.PASS, countryName,MYLOConstants.COUNTRY_DROPDOWN,sectionType));
		 Assert.assertTrue(myloAssignmentPage.verifyDropdownListOrder(MYLOConstants.COUNTRY));
		 myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName);
		 Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_COUNTRIES_PRESENT,
					CoreConstants.PASS,MYLOConstants.COUNTRY_DROPDOWN,sectionType));
		 MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
			Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
					+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^corresponding States and Territories is displayed in the 'State/Territory' dropdown after selecting \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as the country respectively under \"([^\"]*)\" section$")
	public void corresponding_States_and_Territories_is_displayed_in_the_State_Territory_dropdown_after_selecting_and_as_the_country_respectively_under_section(String countryName1, String countryName2, String countryName3, String sectionType) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		List<String> countryList=Arrays.asList(countryName1, countryName2, countryName3);
		for (String country : countryList) {
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_COUNTRY);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, country);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_STATE);
		Assert.assertTrue(myloAssignmentPage.verifyStateListWithCountry(country));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_STATES_APPEARING,
				CoreConstants.PASS, country,MYLOConstants.COUNTRY_DROPDOWN,sectionType));
		}
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Given("^\"([^\"]*)\" field is a free text field with label \"([^\"]*)\" after selecting any \"([^\"]*)\" besides India, US or Canada$")
	public void field_is_a_free_text_field_with_label_after_selecting_any_besides_India_US_or_Canada(String fieldName2, String expectedLabel, String fieldName1){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName1);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, MYLOConstants.RANDOM);
		Assert.assertTrue(myloAssignmentPage.verifyOtherAddressFieldAvailability(fieldName2));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_STATE_FREE_TEXT_FIELD,
				CoreConstants.PASS,MYLOConstants.OTHER_ADDRESS));
		Assert.assertEquals(myloAssignmentPage.verifyOtherAddressFieldLabel(fieldName2),expectedLabel);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_FIELD_LABEL_UPDATED,
				CoreConstants.PASS, fieldName2,expectedLabel,MYLOConstants.OTHER_ADDRESS));
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_COUNTRY);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, MYLOConstants.USA_STATE);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_STATE);
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(MYLOConstants.STATE, MYLOConstants.CITY_ALASKA);	
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@When("^he clicks on \"([^\"]*)\" button after changing the \"([^\"]*)\" dropdown to \"([^\"]*)\"$")
	public void he_clicks_on_button_after_changing_the_dropdown_to(String buttonName, String fieldName, String fieldValue) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName);
		Assert.assertTrue(myloAssignmentPage.verifyTypeDropwnList(MYLOConstants.MAILING));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_VALUE_APPEARING,
				CoreConstants.PASS,MYLOConstants.MAILING,fieldName,MYLOConstants.OTHER_ADDRESS));
		Assert.assertTrue(myloAssignmentPage.verifyTypeDropwnList(MYLOConstants.TEMPORARY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_VALUE_APPEARING,
				CoreConstants.PASS,MYLOConstants.TEMPORARY,fieldName,MYLOConstants.OTHER_ADDRESS));
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName, fieldValue);
		myloAssignmentPage.clickElementOnOtherAddressesSection(buttonName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
	
	@Then("^below fieldValues should be successfully saved under \"([^\"]*)\" section after changing the \"([^\"]*)\" dropdown to \"([^\"]*)\" on clicking \"([^\"]*)\" button$")
	public void below_fieldValues_should_be_successfully_saved_under_section_after_changing_the_dropdown_to_on_clicking_button(String sectionType, String fieldName, String fieldValue, String buttonName, DataTable table){
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickElementOnOtherAddressesSection(buttonName);
		myloAssignmentPage.clickElementOnOtherAddressesSection(fieldName);
		Assert.assertTrue(myloAssignmentPage.verifyTypeDropwnList(MYLOConstants.MAILING));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_VALUE_APPEARING,
				CoreConstants.PASS,MYLOConstants.MAILING,fieldName,MYLOConstants.OTHER_ADDRESS));
		Assert.assertTrue(myloAssignmentPage.verifyTypeDropwnList(MYLOConstants.TEMPORARY));
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_VALUE_APPEARING,
				CoreConstants.PASS,MYLOConstants.TEMPORARY,fieldName,MYLOConstants.OTHER_ADDRESS));
		myloAssignmentPage.setFieldValueOnOtherAddressesSection(fieldName, fieldValue);
		myloAssignmentPage.clickElementOnOtherAddressesSection(MYLOConstants.OTHER_ADDRESS_SAVE_BUTTON);
		myloAssignmentPage.clickElementOnOtherAddressesSection(sectionType);
		Assert.assertTrue(myloAssignmentPage.verifyFieldValuesOtherAddress(sectionType, table));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
}
