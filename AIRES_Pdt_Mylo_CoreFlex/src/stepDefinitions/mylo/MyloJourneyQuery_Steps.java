package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.MyloJourneyPage_QueryByServiceID;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class MyloJourneyQuery_Steps {
	private TestContext testContext;
	private MyloJourneyPage_QueryByServiceID myloJourneyPageQueryByServiceID;
	

	public MyloJourneyQuery_Steps(TestContext context) {
		testContext = context;
		myloJourneyPageQueryByServiceID = testContext.getMyloPageObjectManager().getJourneyQueryByServiceID();
	}


@Given("^he enters valid \"([^\"]*)\" subServiceId in the \"([^\"]*)\" field on QueryBySub-ServiceID section$")
public void he_enters_valid_subServiceId_in_the_field_on_QueryBySub_ServiceID_section(String subServiceIDType, String fieldName) throws Throwable {
	myloJourneyPageQueryByServiceID.setSubServiceIDValue(DbFunctions.getSubServiceID(subServiceIDType));
}

@When("^he clicks on \"([^\"]*)\" button on \"([^\"]*)\" section$")
public void he_clicks_on_button_on_section(String buttonName, String sectionHeader) throws Throwable {
	myloJourneyPageQueryByServiceID.clickExecuteButton();
}

@Then("^he should be taken to the Summary Overview section for that subservice on Mylo Journey page$")
public void he_should_be_taken_to_the_Summary_Overview_section_for_that_subservice_on_Mylo_Journey_page() throws Throwable {
	Assert.assertTrue(myloJourneyPageQueryByServiceID.isSummaryDisplayed(),MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,MYLOConstants.SUMMARY));
   
}

@Then("^he should be taken to the Summary Overview of associate file with shipment sidescreen being displayed$")
public void he_should_be_taken_to_the_Summary_Overview_of_associate_file_with_shipment_sidescreen_being_displayed() throws Throwable {
	Assert.assertTrue(myloJourneyPageQueryByServiceID.isShipmentSubServiceScreenDisplayed(),MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, MYLOConstants.SHIPMENT_WEBSWING));
	Assert.assertTrue(myloJourneyPageQueryByServiceID.isFileInformationSidePanelExist(),MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
    		 MYLOConstants.FILE_INFORMATION_SECTION));   
}

@When("^he enters data beyond number limit for \"([^\"]*)\" field under \"([^\"]*)\" section$")
public void he_enters_data_beyond_number_limit_for_field_under_section(String arg1, String arg2, DataTable table) throws Throwable {
	java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
	myloJourneyPageQueryByServiceID.setRandomSubServiceIDValue(Integer.valueOf(dataList.get(0).get("NumberLength")));
   
}

@Then("^values should be successfully entered as per below number limit set for \"([^\"]*)\" field  under \"([^\"]*)\" section$")
public void values_should_be_successfully_entered_as_per_below_number_limit_set_for_field_under_section(String arg1, String arg2, DataTable table) throws Throwable {
	java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
	CoreFunctions.verifyValue(Double.valueOf(myloJourneyPageQueryByServiceID.getSubServiceIDValue().length()),Double.valueOf(dataList.get(0).get("NumberLength")),dataList.get(0).get("Field Name"));
    
}

@Then("^he should not be able to enter any character in \"([^\"]*)\" field under \"([^\"]*)\" section$")
public void he_should_not_be_able_to_enter_any_character_in_field_under_section(String arg1, String arg2, DataTable table) throws Throwable {
	java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);	
	myloJourneyPageQueryByServiceID.setRandomStringInSubServiceID(Integer.valueOf(dataList.get(0).get("StringLength")));
	CoreFunctions.verifyText(myloJourneyPageQueryByServiceID.getSubServiceIDValue(), "");
}

@Then("^\"([^\"]*)\" modal should be closed after clicking on \"([^\"]*)\" button$")
public void modal_should_be_closed_after_clicking_on_button(String popUp, String button) throws Throwable {
	myloJourneyPageQueryByServiceID.clickCancelButton();;
	Assert.assertFalse(myloJourneyPageQueryByServiceID.isQueryBySubServiceIDPopUpExist(),MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
			popUp, MYLOConstants.QUERY_BY_SUB_SERVICE_ID));	
}

@When("^he clicks on \"([^\"]*)\" button after entering an invalid sub-service id in the \"([^\"]*)\" field on \"([^\"]*)\" section$")
public void he_clicks_on_button_after_entering_an_invalid_sub_service_id_in_the_field_on_section(String button, String field, String section, DataTable table) throws Throwable {
	java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
	myloJourneyPageQueryByServiceID.setRandomSubServiceIDValue(Integer.valueOf(dataList.get(0).get("NumberLength")));
	myloJourneyPageQueryByServiceID.clickExecuteButton();
}

@Then("^\"([^\"]*)\" popup message should be displayed$")
public void popup_message_should_be_displayed(String popupText) throws Throwable {
	Assert.assertTrue(myloJourneyPageQueryByServiceID.isNoSuchFilePopUpExist(),MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,MYLOConstants.NO_SUCH_FILE_FOUND));
		
}

@Then("^\"([^\"]*)\" modal should be closed after clicking on \"([^\"]*)\" icon on \"([^\"]*)\" section$")
public void modal_should_be_closed_after_clicking_on_icon_on_section(String popUp, String button, String section) throws Throwable {
	myloJourneyPageQueryByServiceID.clickCloseButton();
	Assert.assertFalse(myloJourneyPageQueryByServiceID.isQueryBySubServiceIDPopUpExist(),MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
			popUp, MYLOConstants.QUERY_BY_SUB_SERVICE_ID));	
}

}
