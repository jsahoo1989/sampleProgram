package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.Date;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloAssignmentShipmentTab_Steps {
	TestContext testContext;
	Mylo_DashboardHomePage myloDashboardPage;
	Mylo_AssignmentPage myloAssignmentPage;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloAssignmentShipmentTab_Steps(TestContext context) {
		testContext = context;
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
		myloAssignmentPage = testContext.getMyloPageObjectManager().getAssignmentPage();
	}

	/**********************************************/

	@Given("^he is on Mylo Assignment Summary page for file with \"([^\"]*)\" subservices$")
	public void he_is_on_Mylo_Assignment_Summary_page_for_file_with_subservices(String shipmentStatus) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.verifyUserName(MYLOConstants.USER_PROFILE_NAME);
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsByShipmentServices(shipmentStatus, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.FILE_ID_ENTERED, CoreConstants.PASS, fileID));
		myloDashboardPage.clickExecuteButton();
		myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^message \"([^\"]*)\" is displayed with grayed out shipment button after he hovers on \"([^\"]*)\" tab$")
	public void message_is_displayed_with_grayed_out_shipment_button_after_he_hovers_on_tab(String msg,
			String tabName) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertEquals(myloAssignmentPage.getAssignmentTabsBgColor(tabName), MYLOConstants.GREY_COLOR_HEXCODE,
				"Background Color didnot match");
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_TAB_BG_COLOR, CoreConstants.PASS, tabName,
				MYLOConstants.GREY_COLOR, MYLOConstants.ASSIGNMENT));
		Assert.assertEquals(myloAssignmentPage.getAssignmentTabsHoverMessage(tabName), msg,
				MYLOConstants.FAILED_VERIFY_HOVER_MESSAGE);
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_HOVER_MESSAGE_DISPLAYED, CoreConstants.PASS,
				msg, MYLOConstants.ASSIGNMENT));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he clicks on \"([^\"]*)\" tab after navigating to Mylo Assignment Summary page for file with \"([^\"]*)\" subservice$")
	public void he_clicks_on_tab_after_navigating_to_Mylo_Assignment_Summary_page_for_file_with_subservice(
			String tabName, String shipmentStatus) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		String fileID = myloAssignmentPage.getFileDetailsByShipmentServices(shipmentStatus, MYLOConstants.FILE_ID);
		myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileID);
		myloDashboardPage.clickExecuteButton();
		myloAssignmentPage.verifyActiveTab(MYLOConstants.SUMMARY);
		myloAssignmentPage.clickAssignmentTabs(tabName);
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^he should get redirected to shipment screen no shipment drop-down appearing$")
	public void he_should_get_redirected_to_shipment_screen_no_shipment_drop_down_appearing() {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyShipmentSectionDisplayed());
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Given("^corresponding subserviceId should get displayed in the shipment dropdown after he clicks on \"([^\"]*)\" tab for \"([^\"]*)\" subservices$")
	public void corresponding_subserviceId_should_get_displayed_in_the_shipment_dropdown_after_he_clicks_on_tab_for_subservices(
			String tabName, String shipmentStatus) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		myloAssignmentPage.clickAssignmentTabs(tabName);
		Assert.assertTrue(myloAssignmentPage.verifyShipmentDropdown(shipmentStatus));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'And'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^corresponding benefits Id should get displayed in the shipment dropdown for \"([^\"]*)\" subservices$")
	public void corresponding_benefits_Id_should_get_displayed_in_the_shipment_dropdown_for_subservices(
			String shipmentStatus) {
		MYLOConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(myloAssignmentPage.verifyShipmentDropdown(shipmentStatus));
		MYLOConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (MYLOConstants.TIME_AFTER_ACTION - MYLOConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}
}
