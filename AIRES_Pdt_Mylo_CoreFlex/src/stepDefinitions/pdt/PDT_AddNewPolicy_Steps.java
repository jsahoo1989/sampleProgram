package stepDefinitions.pdt;

import java.util.List;
import java.util.Map;

import com.aires.cucumber.TestContext;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class PDT_AddNewPolicy_Steps {
	private TestContext testContext;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_AddNewPolicyPage addNewPolicyPage;
	
	public PDT_AddNewPolicy_Steps(TestContext context) {
		testContext = context;
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
	}
	
	@Given("^he has clicked on the 'Next' button after selecting below information on the 'Add New Policy' page$")
	@When("^he clicks on the 'Next' button after selecting below information on the 'Add New Policy' page$")
	public void he_clicks_on_the_Next_button_after_selecting_below_information_on_the_Add_New_Policy_page(DataTable clientPolicyData) {
		List<Map<String, String>> clientPolicyInfo = clientPolicyData.asMaps(String.class, String.class);
		addNewPolicyPage.enterClientPolicyDetails(clientPolicyInfo);
	}
	
	@When("^he clicks on the 'Next' button after selecting client, policy information on the 'Add New Policy' page$")
	@Given("^he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page$")	
	public void he_clicks_on_the_Next_button_after_selecting_below_information_on_the_Add_New_Policy_page() {
		addNewPolicyPage.enterClientPolicyDetails();
	}
	
	@Given("^he has clicked on the 'Next' button after selecting non Blueprint enabled client, policy information on the 'Add New Policy' page$")
	public void he_has_clicked_on_the_Next_button_after_selecting_non_Blueprint_enabled_client_policy_information_on_the_Add_New_Policy_page() {
		addNewPolicyPage.enterNonBpClientPolicyDetails();
	}
}
