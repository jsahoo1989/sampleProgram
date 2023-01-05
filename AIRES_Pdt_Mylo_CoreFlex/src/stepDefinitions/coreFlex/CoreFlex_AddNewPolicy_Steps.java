package stepDefinitions.coreFlex;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CoreFlex_AddNewPolicy_Steps {

	private TestContext testContext;
	private PDT_AddNewPolicyPage addNewPolicyPage;
	

	public CoreFlex_AddNewPolicy_Steps(TestContext context) {
		testContext = context;
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
	}

	@When("^he enters the following 'Valid/Invalid' \"([^\"]*)\" value for the Client ID field$")
	public void he_enters_the_following_Valid_Invalid_value_for_the_Client_ID_field(String inputValue)
			throws Throwable {
		addNewPolicyPage.enterClientID(inputValue);
	}	

	@Then("^\"([^\"]*)\" drop-down field Visibility/Invisiblity should depend on the entered \"([^\"]*)\" \"([^\"]*)\" value$")
	public void drop_down_field_Visibility_Invisiblity_should_depend_on_the_entered_value(String fieldName,
			String dataValidity, String clientID) throws Throwable {
		Assert.assertTrue(addNewPolicyPage.verifyPolicyNameField(fieldName, dataValidity, clientID), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME_FIELD_FOR_ENTERED_CLIENTID, CoreConstants.FAIL));
	}

	@Given("^he has entered a valid 'ClientID' \"([^\"]*)\" in dropdown input field$")
	public void he_has_entered_a_valid_ClientID_in__dropdown_input_field(String clientID) throws Throwable {
		addNewPolicyPage.enterClientID(clientID);
		Assert.assertTrue(addNewPolicyPage.verifyAndClickValidClientIDResult(clientID), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_VALID_CLIENT_ID_DROPDOWN_OPTIONS, CoreConstants.FAIL));
	}

	@Given("^he has selected a policy from 'Policy Name' dropdown list$")
	public void he_has_selected_a_policy_from_Policy_Name_dropdown_list() throws Throwable {
		Assert.assertTrue(addNewPolicyPage.selectAPolicy(addNewPolicyPage.getFirstAvailablePolicyOption()),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));
	}

	@When("^he clicks on 'Next' button$")
	public void he_clicks_on_Next_button() throws Throwable {
		addNewPolicyPage.clickElementOfPage(PDTConstants.NEXT);
	}
	
	
}
