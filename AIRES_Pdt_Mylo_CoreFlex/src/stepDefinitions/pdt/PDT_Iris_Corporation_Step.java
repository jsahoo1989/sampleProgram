package stepDefinitions.pdt;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.managers.PageObjectManager_Pdt;
import com.aires.managers.WebDriverManager;
import com.aires.pages.PDT_Mylo_CoreFlex_Common_LoginPage;
import com.aires.pages.iris.IRIS_Corporation_Accounting;
import com.aires.pages.iris.IRIS_Corporation_Main;
import com.aires.pages.iris.IRIS_Welcome12C;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_LoginPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.aires.testdatatypes.pdt.PDT_LoginData;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.aires.utilities.Log;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDT_Iris_Corporation_Step {
	TestContext testContext;
	WebDriverManager webDriverManager;
	PageObjectManager_Pdt pageObjectManager;
	PDT_LoginPage loginPage;
	PDT_ViewPolicyPage viewPolicyPage;
	PDT_AddNewPolicyPage addNewPolicyPage;
	PDT_Mylo_CoreFlex_Common_LoginPage pdtMyloCommonLoginPage;

	PDT_LoginData loginData = FileReaderManager.getInstance().getJsonReader()
			.getloginDetailsByUserFirstName(PDTConstants.USER_FIRST_NAME);
	//private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader().getLoginByApplication(CoreFunctions.getPropertyFromConfig("application"));
	private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader().getLoginByApplication(System.getProperty("application"));
	
	public PDT_Iris_Corporation_Step(TestContext context) {
		testContext = context;
	}
	
	@Given("^he has selected \"([^\"]*)\" module from \"([^\"]*)\" window$")
	public void he_has_selected_module_from_window(String moduleName, String windowName) throws Throwable {
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(moduleName);
	}

	@Given("^he has queried corporation from \"([^\"]*)\" module$")
	public void he_has_queried_corporation_from_module(String moduleName) throws Throwable {
		switch (moduleName) {
		case IRISConstants.CORPORATION_MODULE:
			testContext.getIrisPageManager().irisCorporationMain = new IRIS_Corporation_Main();			
			Log.info("pdtClientId="+BusinessFunctions.getClientAndPolicyDetails(_loginDetailsApplication)[0]);
			testContext.getIrisPageManager().irisCorporationMain.queryCorporation(BusinessFunctions.getClientAndPolicyDetails(_loginDetailsApplication)[0]);
			break;
		default:
			Assert.fail(IRISConstants.PAGE_NOT_FOUND);
		}
	}

	@Given("^he has added a new policy in the \"([^\"]*)\" tab$")
	public void he_has_added_a_new_policy_in_the_tab(String tabName) throws Throwable {
		testContext.getIrisPageManager().irisCorporationMain.selectCorporationModules(tabName);
		testContext.getIrisPageManager().irisCorporationAccounting = new IRIS_Corporation_Accounting();
		testContext.getIrisPageManager().irisCorporationAccounting.verifyAccountingTab();
		testContext.getIrisPageManager().irisCorporationAccounting.addPolicy();
	}

	@Given("^he logins to the PDT application as a \"([^\"]*)\" user$")
	public void he_logins_to_the_PDT_application_as_a_user(String userType) throws Throwable {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager_Pdt(webDriverManager.getDriver());

		webDriverManager.getDriver().navigate()
				.to(FileReaderManager.getInstance().getConfigReader().getPDTApplicationUrl());
		loginPage = pageObjectManager.getLoginPage();
		loginPage.openApplication();
		Assert.assertTrue(pdtMyloCommonLoginPage.loginByUserType(userType, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));
		/*loginPage.enterLoginCredentials(BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[0], BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[1]);
		loginPage.clickLoginBtn();
		loginPage.verifyLoginCredentials();*/
		viewPolicyPage = pageObjectManager.getViewPolicyPage();
		Assert.assertTrue(viewPolicyPage.verifyViewPolicyHeading(PDTConstants.VIEW_POLICY),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, PDTConstants.VIEW_POLICY,
						PDTConstants.VIEW_EDIT_POLICY_FORMS, viewPolicyPage.getElementText(PDTConstants.HEADING)));
		Assert.assertTrue(viewPolicyPage.verifyUserlogin(BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[0], PDTConstants.VIEW_POLICY),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_USERNAME, CoreConstants.FAIL, PDTConstants.VIEW_POLICY,
						BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[0], viewPolicyPage.getUserName()));
	}

	@When("^he searches the newly added policy for client Id in the \"([^\"]*)\" page$")
	public void he_searches_the_newly_added_policy_for_client_Id_in_the_page(String pageName) throws Throwable {
		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
		addNewPolicyPage = pageObjectManager.getAddNewPolicyPage();
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(pageName),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, pageName,
						PDTConstants.ADD_NEW_POLICY_FORM, addNewPolicyPage.getElementText(PDTConstants.HEADING)));
		addNewPolicyPage.selectClient(BusinessFunctions.getClientAndPolicyDetails(_loginDetailsApplication)[0], BusinessFunctions.getClientAndPolicyDetails(_loginDetailsApplication)[1]);
		
	}

	@Then("^newly added Policy should be displayed in Policy drop down of \"([^\"]*)\" page$")
	public void newly_added_Policy_should_be_displayed_in_Policy_drop_down_of_page(String arg1) throws Throwable {
		addNewPolicyPage.selectPolicyName(CoreFunctions.getPropertyFromConfig("pdPolicyName"));
		Assert.assertTrue(addNewPolicyPage.verifyPolicyName(CoreFunctions.getPropertyFromConfig("pdPolicyName")), MessageFormat.format(PDTConstants.VERIFIED_POLICY_NOT_DISPLAYED, CoreConstants.FAIL, CoreFunctions.getPropertyFromConfig("pdPolicyName")));
		DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
		webDriverManager.closeDriver();
	}
}
