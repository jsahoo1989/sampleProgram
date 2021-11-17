package stepDefinitions.iris;

import org.testng.Assert;

import com.aires.businessrules.constants.IRISConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.PageObjectManager_Pdt;
import com.aires.managers.WebDriverManager;
import com.aires.pages.iris.IRIS_Corporation_Accounting;
import com.aires.pages.iris.IRIS_Corporation_Main;
import com.aires.pages.iris.IRIS_Welcome12C;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IRIS_NewCoreFlexColumnSteps {

	private TestContext _testContext;
	WebDriverManager _webDriverManager;
	PageObjectManager_Pdt _pageObjectManager;

	public IRIS_NewCoreFlexColumnSteps(TestContext testContext) {
		_testContext = testContext;
	}

	@Given("^he has queried \"([^\"]*)\" corporation in \"([^\"]*)\" module from \"([^\"]*)\" window$")
	public void he_has_queried_corporation_in_module_from_window(String corporationId, String moduleName, String windowName)
			throws Throwable {
		
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

	@When("^he navigates to 'Policy table' of \"([^\"]*)\" tab from \"([^\"]*)\" module$")
	public void he_navigates_to_Policy_table_of_tab_from_module(String tabName,String moduleName) throws Throwable {
		
		switch (moduleName) {
		case IRISConstants.CORPORATION_MODULE:
			_testContext.getIrisPageManager().irisCorporationMain.selectCorporationModules(tabName);
			break;
		default:
			Assert.fail(IRISConstants.PAGE_NOT_FOUND);
		}

	}

	@Then("^\"([^\"]*)\" checkbox column should be displayed for each Policy in 'Policy table' before \"([^\"]*)\" column$")
	public void checkbox_column_should_be_displayed_for_each_Policy_in_Policy_table_before_column(String coreFlexColumnName,
			String springbaordCheckboxName) throws Throwable {
		_testContext.getIrisPageManager().irisCorporationAccounting = new IRIS_Corporation_Accounting();
		_testContext.getIrisPageManager().irisCorporationAccounting.verifyAccountingTab();
		_testContext.getIrisPageManager().irisCorporationAccounting.verifyPolicyTableColumn(coreFlexColumnName);
		
	}

	@Given("^he has checked and unchecked \"([^\"]*)\" checkbox for few Policies in 'Policy table' of \"([^\"]*)\" tab$")
	public void he_has_checked_and_unchecked_checkbox_for_few_Policies_in_Policy_table_of_tab(String arg1, String arg2)
			throws Throwable {

	}

	@When("^he clicks on 'Save' button$")
	public void he_clicks_on_Save_button() throws Throwable {

	}

	@Then("^a Pop-Up dialog having \"([^\"]*)\" message should be displayed$")
	public void a_Pop_Up_dialog_having_message_should_be_displayed(String arg1) throws Throwable {

	}

	@Then("^selection of the checked and unchecked \"([^\"]*)\" checkbox performed above should be maintained$")
	public void selection_of_the_checked_and_unchecked_checkbox_performed_above_should_be_maintained(String arg1)
			throws Throwable {

	}

}
