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
import com.aires.utilities.Log;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginToPDT_Steps {
	TestContext testContext;
	PDT_LoginPage loginPage;
	PDT_ViewPolicyPage viewPolicyPage;

	PDT_LoginData loginData = FileReaderManager.getInstance().getJsonReader()
			.getloginDetailsByUserFirstName(PDTConstants.USER_FIRST_NAME);

	public LoginToPDT_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();

	}

	@Given("^he is on Policy App login page$")
	public void he_is_on_Policy_App_login_page() throws Throwable {
		loginPage.openApplication();
	}

	@Given("^he enters below login credentials in Username, Password fields$")
	public void he_enters_below_login_credentials_in_Username_Password_fields(DataTable loginData) throws Throwable {
		List<Map<String, String>> loginInfo = loginData.asMaps(String.class, String.class);
		Log.info("UserName:-" + loginInfo.get(0).get("userName"));
		Log.info("Password:-" + loginInfo.get(0).get("password"));
		loginPage.enterLoginCredentials(loginInfo.get(0).get("userName"), loginInfo.get(0).get("password"));
	}

	@When("^he clicks on Login button$")
	public void he_clicks_on_Login_button() throws Throwable {
		loginPage.clickLoginBtn();
		loginPage.verifyLoginCredentials();
	}

	@Then("^he should be redirected to \"([^\"]*)\" page$")
	public void he_should_be_redirected_to_page(String pageName) throws Throwable {
		Assert.assertTrue(viewPolicyPage.verifyViewPolicyHeading(pageName),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, pageName,
						PDTConstants.VIEW_EDIT_POLICY_FORMS, viewPolicyPage.getElementText(PDTConstants.HEADING)));
	}

	@Then("^below userName should be displayed on \"([^\"]*)\" page$")
	public void below_userName_should_be_displayed_on_page(String pageName, DataTable dataTable) throws Throwable {
		List<Map<String, String>> loginDetails = dataTable.asMaps(String.class, String.class);
		Assert.assertTrue(viewPolicyPage.verifyUserlogin(loginDetails.get(0).get("userName"), pageName),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_USERNAME, CoreConstants.FAIL, pageName,
						loginDetails.get(0).get("userName"), viewPolicyPage.getUserName()));
		viewPolicyPage.clickElementOfPage(PDTConstants.LOGOUT);
	}

	@Given("^he is logged into 'Aires Policy Tool' application as a \"([^\"]*)\" user$")
	public void he_is_logged_into_Aires_Policy_Tool_application_as_a_user(String userType) throws Throwable {
		Assert.assertTrue(loginPage.loginByUserType(userType, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));
	}

	@Given("^he enters \"([^\"]*)\" and \"([^\"]*)\" in username and password field$")
	public void he_enters_and_in_username_and_password_field(String userName, String password) throws Throwable {
		loginPage.enterLoginCredentials(userName, password);
	}

	@Then("^below \"([^\"]*)\" should be displayed on \"([^\"]*)\" page$")
	public void below_should_be_displayed_on_page(String userName, String pageName) throws Throwable {
		Assert.assertTrue(viewPolicyPage.verifyUserlogin(userName, pageName),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_USERNAME, CoreConstants.FAIL, pageName, userName,
						viewPolicyPage.getUserName()));
	}
	
	@Then("^Policies should be displayed on \"([^\"]*)\" page$")
	public void policies_should_be_displayed_on_page(String pageName) throws Throwable {
		Assert.assertTrue(viewPolicyPage.verifyPoliciesAreDisplayed(pageName), MessageFormat.format(PDTConstants.POLICIES_ARE_NOT_DISPLAYED, CoreConstants.FAIL, pageName));
	}

}
