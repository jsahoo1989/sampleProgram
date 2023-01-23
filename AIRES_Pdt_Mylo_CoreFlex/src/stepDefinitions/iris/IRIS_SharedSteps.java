package stepDefinitions.iris;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.iris.IRIS_ActivityAndFinancePage;
import com.aires.pages.iris.IRIS_AssignmentOverviewPage;
import com.aires.pages.iris.IRIS_AssignmentServicePage;
import com.aires.pages.iris.IRIS_AssignmentTransfereeNFamilyPage;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.pages.iris.IRIS_Welcome12C;
import com.aires.testdatatypes.coreflex.CoreFlex_LoginInfo;
import com.aires.testdatatypes.iris.IRIS_AssignmentData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IRIS_SharedSteps {

	private TestContext testContext;
	private CoreFlex_LoginInfo _loginInfo;

	int _initialTableRowCount = 0;

	public IRIS_SharedSteps(TestContext context) {
		testContext = context;
		_loginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getLoginByEnvt(BusinessFunctions.getEnvBasedOnExecutionType().toLowerCase());
	}

	@Given("^he has Created and Actualized a 'New' Transferee in 'Assignment' module of IRIS Application$")
	public void he_has_Created_and_Actualized_a_New_Transferee_in_Assignment_module_of_IRIS_Application()
			throws Throwable {
		// Creating and actualizing a new Transferee
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginInfo);
		testContext.getIrisPageManager().irisWelcome12C = new IRIS_Welcome12C();
		testContext.getIrisPageManager().irisWelcome12C.selectWelcomeWindowModule(IRISConstants.ASSIGNMENT_TAB);
		testContext.getIrisPageManager().irisAssignmentOverviewPage = new IRIS_AssignmentOverviewPage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentOverviewPage.verifyOverviewTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.OVERVIEW));
		IRIS_AssignmentData assignmentOverviewData = FileReaderManager.getInstance().getIrisJsonReader()
				.getAssignmentDataByTabName(IRISConstants.OVERVIEW);
		testContext.getIrisPageManager().irisAssignmentOverviewPage.selectNewAssignmentFromFileMenu();
		testContext.getIrisPageManager().irisAssignmentOverviewPage.addDetailsOnOverviewTabForNewAssignment(
				assignmentOverviewData, CoreFunctions.getPropertyFromConfig("Policy_ClientID"),
				CoreFunctions.getPropertyFromConfig("Assignment_Policy"));
		IRIS_AssignmentData assignmentTransfereeData = FileReaderManager.getInstance().getIrisJsonReader()
				.getAssignmentDataByTabName(IRISConstants.TRANSFEREE_AND_FAMILY);
		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.TRANSFEREE_AND_FAMILY);
		testContext
				.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage = new IRIS_AssignmentTransfereeNFamilyPage();
		testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
				.verifyTransfereeAndFamilyTab(IRISConstants.TRANSFEREE_AND_FAMILY);
		testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
				.addNewTransfereeDetails(assignmentTransfereeData);
		Assert.assertTrue(
				testContext.getIrisPageManager().irisAssignmentTransfereeAndFamilyPage
						.saveTransferee(IRISConstants.NEW_TRANSFEREE_CREATED_SUCCESS_MSG),
				IRISConstants.NEW_TRANSFEREE_CREATED_SUCCESS_MSG + " Message " + IRISConstants.IS_NOT_DISPLAYED);

		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.SERVICE);
		testContext.getIrisPageManager().irisAssignmentServicePage = new IRIS_AssignmentServicePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentServicePage.verifyServiceTab(), MessageFormat
				.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL, IRISConstants.SERVICE_TAB));
		_initialTableRowCount = testContext.getIrisPageManager().irisAssignmentServicePage
				.addService(IRISConstants.SERVICE_EXPENSE);
		testContext.getIrisPageManager().irisAssignmentServicePage.clickSaveButton();
		CoreFunctions.waitHandler(5);
		Assert.assertTrue(testContext.getIrisPageManager().irisAssignmentServicePage.verifySaveSuccessMessage(
				IRISConstants.SAVE_SUCCESSFUL_MESSAGE), IRISConstants.message + IRISConstants.IS_NOT_DISPLAYED);

		testContext.getIrisPageManager().irisAssignmentOverviewPage.switchTab(IRISConstants.ACTIVITY_FINANCE_TAB);
		testContext.getIrisPageManager().irisActivityAndFinancePage = new IRIS_ActivityAndFinancePage();
		Assert.assertTrue(testContext.getIrisPageManager().irisActivityAndFinancePage.verifyActivityAndFinanceTab(),
				MessageFormat.format(IRISConstants.FAIL_TO_VERIFY_CURRENT_TAB, CoreConstants.FAIL,
						IRISConstants.ACTIVITY_AND_FINANCE));
		testContext.getIrisPageManager().irisActivityAndFinancePage.displayActivityTable();
		testContext.getIrisPageManager().irisActivityAndFinancePage.actualizeTracingPrompt(IRISConstants.ACT_DATE,
				IRISConstants.ACTIVITY, IRISConstants.MAKE_FIRST_CONTACT);
	}

	@When("^he clicks on the \"([^\"]*)\" button of \"([^\"]*)\" dialog having message \"([^\"]*)\"$")
	public void he_clicks_on_the_button_of_dialog_having_message(String arg1, String arg2, String arg3)
			throws Throwable {
		testContext.getIrisPageManager().irisActivityAndFinancePage.clickOnSaveBtn();
		testContext.getIrisPageManager().irisActivityAndFinancePage.sendLoginCredentials(IRISConstants.YES,
				IRISConstants.SEND_CREDENTIALS, IRISConstants.SEND_USER_LOGIN_MSG);
	}

	@Then("^username, password email of newly created 'Assignment' should be sent to the provided email address$")
	public void username_password_email_of_newly_created_Assignment_should_be_sent_to_the_provided_email_address()
			throws Throwable {
		Assert.assertTrue(
				testContext.getIrisPageManager().irisActivityAndFinancePage
						.relonetCredentialsSent(IRISConstants.SUCCESS_MSG, IRISConstants.MESSAGE_DIALOG),
				MessageFormat.format(IRISConstants.FAILED_TO_VERIFY_MESSAGE, CoreConstants.FAIL,
						IRISConstants.SUCCESS_MSG));
		testContext.getBasePage().cleanIrisProcesses();

	}
}
