package stepDefinitions.coreFlex;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_LoginPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CoreFlex_AddNewPolicy_Steps {
	
	TestContext testContext;
	PDT_LoginPage loginPage;
	PDT_ViewPolicyPage viewPolicyPage;
	PDT_AddNewPolicyPage addNewPolicyPage;
	PDT_GeneralInformationPage generalInfoPage;
	
	private static String selectedPolicyName;
	
	public CoreFlex_AddNewPolicy_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInformationPage();
	}
	
	
	
	@Given("^he has navigated to \"([^\"]*)\" menu from left navigation of 'Aires Policy Tool' homepage$")
	public void he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String pageName) throws Throwable {
	    
		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(pageName),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, pageName,
						PDTConstants.ADD_NEW_POLICY_FORM, addNewPolicyPage.getElementText(PDTConstants.HEADING)));
		
	}

	@When("^he enters valid ([^\"]*) in 'Client ID' dropdown list$")
	public void he_enters_valid_in_Client_ID_dropdown_list(String inputValue) throws Throwable {		
		addNewPolicyPage.enterClientID(inputValue);
		Assert.assertTrue(addNewPolicyPage.verifyValidClientIDResult(inputValue),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_VALID_CLIENT_ID_DROPDOWN_OPTIONS, CoreConstants.FAIL));
		
		
	}
	
	@When("^he enters invalid ([^\"]*) in 'Client ID' dropdown list$")
	public void he_enters_invalid_in_Client_ID_dropdown_list(String inputValue) throws Throwable {		
		addNewPolicyPage.enterClientID(inputValue);		
	}

	@Then("^'Policy Name' dropdown list should be displayed having all the policies tied to entered ([^\"]*) Client ID/Name$")
	public void policy_Name_dropdown_list_should_be_displayed_having_all_the_policies_tied_to_entered_Client_ID_Name(String inputValue) throws Throwable {
	    		
		Assert.assertTrue(addNewPolicyPage.validatePolicyNameList(),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME_FIELD_FOR_VALID_CLIENTID, CoreConstants.FAIL));		
		
	}

	@Then("^'No items found' text should be displayed in dropdown list followed by 'Record does not exist' Error popup for Invalid ([^\"]*)$")
	public void no_items_found_text_should_be_displayed_in_dropdown_list_followed_by_Record_does_not_exist_Error_popup_for_Invalid(String inputValue) throws Throwable {
	    
		Assert.assertTrue(addNewPolicyPage.verifyInvalidClientIDResult(inputValue),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_INVALID_CLIENT_ID_DROPDOWN_OPTIONS, CoreConstants.FAIL));
	}

	@Then("^'Policy Name' dropdown list should not be displayed for Invalid ([^\"]*)$")
	public void policy_Name_dropdown_list_should_not_be_displayed_for_Invalid(String inputValue) throws Throwable {
	   
		Assert.assertFalse(addNewPolicyPage.isPolicyNameDisplayed(inputValue),
				MessageFormat.format(PDTConstants.POLICY_NAME_FIELD_DISPLAYED_FOR_INVALID_CLIENT, CoreConstants.FAIL, inputValue));
	}
	
	@Given("^he has entered a valid \"([^\"]*)\" in 'Client ID' dropdown list$")
	public void he_has_entered_a_valid_in_Client_ID_dropdown_list(String inputValue) throws Throwable {
		addNewPolicyPage.enterClientID(inputValue);
		Assert.assertTrue(addNewPolicyPage.verifyValidClientIDResult(inputValue),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_VALID_CLIENT_ID_DROPDOWN_OPTIONS, CoreConstants.FAIL));
	}

	@Given("^he has selected a policy from 'Policy Name' dropdown list$")
	public void he_has_selected_a_policy_from_Policy_Name_dropdown_list() throws Throwable {
	    	    
	    Assert.assertTrue(addNewPolicyPage.selectPolicy(),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));
	    selectedPolicyName = addNewPolicyPage.getSelectedPolicyName();
	}

	@When("^he clicks on 'Next' button$")
	public void he_clicks_on_Next_button() throws Throwable {
		addNewPolicyPage.clickNext();
	}

	@Then("^user should be navigated to the \"([^\"]*)\" page of the selected Client Policy$")
	public void user_should_be_navigated_to_the_page_of_the_selected_Client_Policy(String pageName, DataTable dataTable) throws Throwable {
	    				
		Assert.assertTrue(generalInfoPage.validateGeneralInfo(pageName,dataTable,selectedPolicyName),
				MessageFormat.format(PDTConstants.FAILED_TO_SELECT_POLICY_FROM_POLICY_NAME_FIELD, CoreConstants.FAIL));		
		
	}

}
