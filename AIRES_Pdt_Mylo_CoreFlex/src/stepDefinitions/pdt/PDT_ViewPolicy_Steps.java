package stepDefinitions.pdt;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.pdt.PDT_LoginPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.aires.testdatatypes.pdt.PDT_LoginData;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PDT_ViewPolicy_Steps {
	TestContext testContext;
	PDT_LoginPage loginPage;
	PDT_ViewPolicyPage viewPolicyPage;
	
	PDT_LoginData loginData = FileReaderManager.getInstance().getJsonReader()
			.getloginDetailsByUserFirstName(PDTConstants.USER_FIRST_NAME);

	public PDT_ViewPolicy_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();

	}
	
	@Given("^he is logged into Policy App application with below credentials$")
	public void he_is_logged_into_Policy_App_application_with_below_credentials(DataTable loginData) {
		loginPage.openApplication();
		List<Map<String, String>> loginInfo = loginData.asMaps(String.class, String.class);
		loginPage.enterLoginCredentials(loginInfo.get(0).get("userName"), loginInfo.get(0).get("password"));
		loginPage.clickLoginBtn();		
		Assert.assertTrue(viewPolicyPage.verifyViewPolicyHeading(PDTConstants.VIEW_POLICY),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL, PDTConstants.heading, PDTConstants.VIEW_EDIT_POLICY_FORMS, PDTConstants.VIEW_POLICY,
						viewPolicyPage.getElementText(PDTConstants.HEADING)));
		
		Assert.assertTrue(viewPolicyPage.verifyUserlogin(loginInfo.get(0).get("userName"), PDTConstants.VIEW_POLICY),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_USERNAME, CoreConstants.FAIL, PDTConstants.VIEW_POLICY,
						loginInfo.get(0).get("userName"), viewPolicyPage.getUserName()));
	}

	@Given("^he is on \"([^\"]*)\" page$")
	public void he_is_on_page(String pageName) {
		Assert.assertTrue(viewPolicyPage.verifyViewPolicyHeading(pageName),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL, PDTConstants.heading, PDTConstants.VIEW_EDIT_POLICY_FORMS, PDTConstants.VIEW_POLICY,
						viewPolicyPage.getElementText(PDTConstants.HEADING)));
	}

	@Then("^he should be able to verify Policy data on \"([^\"]*)\" page after performing below SearchBy operations$")
	public void he_should_be_able_to_verify_Policy_data_on_page_after_performing_below_SearchBy_operations(String pageName, DataTable policyTableData) {
		List<Map<String, String>> policyData = policyTableData.asMaps(String.class, String.class);
		viewPolicyPage.iteratePolicyData(policyData, pageName);
	}
}
