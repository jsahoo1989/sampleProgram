package stepDefinitions.pdt;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
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
	
	@Given("^he is on the \"([^\"]*)\" page after clicking on the link \"([^\"]*)\" displayed under the left navigation menu on the 'View Policy' page$")
	public void he_is_on_the_Add_New_Policy_page_after_clicking_on_the_link_displayed_under_the_left_navigation_menu_on_the_View_Policy_page(String pageName, String addNewPolicyLink) {
		viewPolicyPage.clickElementOfPage(addNewPolicyLink);		
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(pageName),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL, PDTConstants.heading, PDTConstants.ADD_NEW_POLICY_FORM,
						pageName, PDTConstants.ADD_NEW_POLICY_FORM, addNewPolicyPage.getElementText(PDTConstants.HEADING)));
	}

	@Given("^he has clicked on the 'Next' button after selecting below information on the 'Add New Policy' page$")
	@When("^he clicks on the 'Next' button after selecting below information on the 'Add New Policy' page$")
	public void he_clicks_on_the_Next_button_after_selecting_below_information_on_the_Add_New_Policy_page(DataTable clientPolicyData) {
		List<Map<String, String>> clientPolicyInfo = clientPolicyData.asMaps(String.class, String.class);
		addNewPolicyPage.enterClientPolicyDetails(clientPolicyInfo);
	}
}
