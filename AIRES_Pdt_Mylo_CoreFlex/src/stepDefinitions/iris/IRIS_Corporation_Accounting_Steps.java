package stepDefinitions.iris;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.managers.PageObjectManager_Pdt;
import com.aires.managers.WebDriverManager;
import com.aires.pages.iris.IRIS_Corporation_Accounting;
import com.aires.pages.iris.IRIS_Corporation_Main;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.pages.iris.IRIS_Welcome12C;
import com.aires.testdatatypes.coreflex.CoreFlex_LoginInfo;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IRIS_Corporation_Accounting_Steps {

	private TestContext _testContext;
	WebDriverManager _webDriverManager;
	PageObjectManager_Pdt _pageObjectManager;
	
	private CoreFlex_LoginInfo _loginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getLoginInfoByEnviroment((CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));

	public IRIS_Corporation_Accounting_Steps(TestContext testContext) {
		_testContext = testContext;
	}

	@Given("^he has queried \"([^\"]*)\" corporation in \"([^\"]*)\" module from \"([^\"]*)\" window$")
	public void he_has_queried_corporation_in_module_from_window(String corporationId, String moduleName,
			String windowName) throws Throwable {

		_testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		_testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(moduleName);
		switch (moduleName) {
		case IRISConstants.CORPORATION_MODULE:
			_testContext.getIrisPageManager().irisCorporationMain = new IRIS_Corporation_Main();
			_testContext.getIrisPageManager().irisCorporationMain.queryCorporation(corporationId);
			break;
		default:
			Assert.fail(IRISConstants.PAGE_NOT_FOUND);
		}
	}

	@Given("^he has 'Checked/Unchecked' \"([^\"]*)\" checkbox for following Policy in 'Policy table' of \"([^\"]*)\" tab$")
	public void he_has_Checked_Unchecked_checkbox_for_following_Policy_in_Policy_table_of_tab(String coreFlexColumnName,
			String tabName, DataTable dataTable) throws Throwable {
		_testContext.getIrisPageManager().irisCorporationMain.selectCorporationModules(tabName);
		_testContext.getIrisPageManager().irisCorporationAccounting = new IRIS_Corporation_Accounting();
		_testContext.getIrisPageManager().irisCorporationAccounting.verifyAccountingTab();
		_testContext.getIrisPageManager().irisCorporationAccounting.verifyPolicyTableColumn(coreFlexColumnName);
		_testContext.getIrisPageManager().irisCorporationAccounting
				.performCoreFlexCheckboxSelectionForPolicy(coreFlexColumnName, dataTable);
	}

	@Given("^he has clicked on 'Save' button$")
	public void he_has_clicked_on_Save_button() throws Throwable {
		_testContext.getIrisPageManager().irisCorporationAccounting.clickOnSaveBtn();
	}

	@When("^he navigates back to \"([^\"]*)\" tab of Corporation module for \"([^\"]*)\" corporation after logging out and logging again to IRIS application$")
	public void he_navigates_back_to_tab_of_Corporation_module_for_corporation_after_logging_out_and_logging_again_to_IRIS_application(
			String tabName, String corporationId) throws Throwable {
		_testContext.getBasePage().cleanIrisProcesses();
		_testContext.getBasePage().invokeIrisApplication();
//		_loginDetails = FileReaderManager.getInstance().getJsonReader().getLoginByApplication("IRIS");
		_testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		_testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginInfo);
		_testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		_testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.CORPORATION_MODULE);
		_testContext.getIrisPageManager().irisCorporationMain = new IRIS_Corporation_Main();
		_testContext.getIrisPageManager().irisCorporationMain.queryCorporation(corporationId);
		_testContext.getIrisPageManager().irisCorporationMain.selectCorporationModules(IRISConstants.ACCOUNTING);
		_testContext.getIrisPageManager().irisCorporationAccounting = new IRIS_Corporation_Accounting();
		_testContext.getIrisPageManager().irisCorporationAccounting.verifyAccountingTab();
	}

	@Then("^selection of the 'Checked/Unchecked' \"([^\"]*)\" checkbox performed above should be maintained$")
	public void selection_of_the_Checked_Unchecked_checkbox_performed_above_should_be_maintained(
			String coreflexColumnName, DataTable dataTable) throws Throwable {
		_testContext.getIrisPageManager().irisCorporationAccounting
				.verifyCoreFlexCheckboxSelectionForPolicy(coreflexColumnName, dataTable);
		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);

		_testContext.getIrisPageManager().irisCorporationAccounting.performCoreFlexCheckboxSelectionForPolicy(
				coreflexColumnName, IRISConstants.UNCHECKED, dataMap.get(0).get("PolicyName"));
		_testContext.getIrisPageManager().irisCorporationAccounting.clickOnSaveBtn();
	}
}
