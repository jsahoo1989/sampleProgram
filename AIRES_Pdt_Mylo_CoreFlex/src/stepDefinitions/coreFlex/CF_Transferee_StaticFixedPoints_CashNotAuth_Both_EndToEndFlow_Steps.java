package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.PageObjectManager_CoreFlex;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DashboardHomePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DetailsPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_Transferee_StaticFixedPoints_CashNotAuth_Both_EndToEndFlow_Steps {

	private TestContext testContext;
	private PageObjectManager_CoreFlex _pageObjectManagerCoreFlex;
	private TransfereeSubmissions_DashboardHomePage transfereeSubmissionsDashboardHomePage;
	private TransfereeSubmissions_DetailsPage transfereeSubmissionsDetailsPage;

	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;

	public static List<Map<String, String>> selectedBenefitDetails;

	public CF_Transferee_StaticFixedPoints_CashNotAuth_Both_EndToEndFlow_Steps(TestContext context) {
		testContext = context;
		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();
		mxTransfereeMyBenefitsBundlePage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeMyBenefitsBundlePage();
		transfereeSubmissionsDashboardHomePage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDashboardHomePage();
		transfereeSubmissionsDetailsPage = testContext.getCoreFlexPageObjectManager()
				.getTransfereeSubmissionsDetailsPage();
	}

	@Given("^he has clicked on \"([^\"]*)\" button for a benefit under 'Submitted Benefits' section$")
	public void he_has_clicked_on_button_for_a_benefit_under_Submitted_Benefits_section(String buttonName)
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.deleteSubmittedBenefit(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_DELETE_SUBMITTED_BENEFIT, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Given'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@When("^he confirms 'Remove Benefit Selection' dialog by entering username and clicking on \"([^\"]*)\"$")
	public void he_confirms_Remove_Benefit_Selection_dialog_by_entering_username_and_clicking_on(String buttonName)
			throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.isDeleteBenefitPopupDisplayed(), MessageFormat
				.format(MobilityXConstants.REMOVE_BENEFIT_SELECTION_POPUP_NOT_DISPLAYED, CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyBenefitsDetailsOnRemoveBenefitDialog(),
				MessageFormat.format(MobilityXConstants.POINTS_AND_BENEFIT_DETAILS_NOT_MATCHED_ON_SUBMIT_BUNDLE_POPUP,
						CoreConstants.FAIL));
		mxTransfereeMyBenefitsBundlePage.reviewAndConfirmRemoveBenefitSubmission(
				MobilityXConstants.SUBMIT_BENEFITS_OPTIONAL_NOTES,
				CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
						+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
				buttonName);
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'When'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^'Delete Request Sent' growl message should be displayed on 'My Benefit Bundle' page$")
	public void delete_Request_Sent_growl_message_should_be_displayed_on_My_Benefit_Bundle_page() throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyRemoveBenefitRequestSuccessMessage(), MessageFormat
				.format(MobilityXConstants.DELETE_BENEFIT_REQUEST_SENT_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");
	}

	@Then("^'Status' of the deleted benefit should be displayed as \"([^\"]*)\" under 'Submitted Benefits' section of 'My Benefit Bundle' page$")
	public void status_of_the_deleted_benefit_should_be_displayed_as_under_Submitted_Benefits_section_of_My_Benefit_Bundle_page(
			String arg1) throws Throwable {
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();		
		Assert.assertTrue(mxTransfereeMyBenefitsBundlePage.verifyDeletedBenefitStatus(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_VERIFY_DELETED_BENEFIT_STATUS, CoreConstants.FAIL));		
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken by <i>'Then'</i> statement is :"
				+ (CoreConstants.TIME_AFTER_ACTION - CoreConstants.TIME_BEFORE_ACTION) / 1000 + " Seconds </b>");

	}

}
