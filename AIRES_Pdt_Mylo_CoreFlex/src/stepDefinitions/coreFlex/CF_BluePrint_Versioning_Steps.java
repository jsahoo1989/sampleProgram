package stepDefinitions.coreFlex;

import java.text.MessageFormat;
import java.util.Date;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.coreflex.CoreFlex_BluePrint_LoginPage;
import com.aires.pages.coreflex.CoreFlex_CustomBundlesPage;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CF_BluePrint_Versioning_Steps {

	private TestContext testContext;

	private CoreFlex_CustomBundlesPage coreFlexCustomBundlesPage;
	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private CoreFlex_BluePrint_LoginPage bluePrintCFLoginPage;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_GeneralInformationPage generalInfoPage;	

	public CF_BluePrint_Versioning_Steps(TestContext context) {
		testContext = context;
		coreFlexCustomBundlesPage = testContext.getCoreFlexPageObjectManager().getCoreFlexCustomBundlesPage();
		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();
		bluePrintCFLoginPage = testContext.getPageObjectManager().getBluePrintCoreFlexLoginPage();
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();
	}

	@When("^he clicks on \"([^\"]*)\" button to close 'Approve this Policy' dialog$")
	public void he_clicks_on_button_to_close_Approve_this_Policy_dialog(String buttonName) throws Throwable {
		coreFlexCustomBundlesPage.clickElementOfPage(buttonName);
	}

	@Then("^'Approve this Policy' dialog should be closed$")
	public void approve_this_Policy_dialog_should_be_closed() throws Throwable {
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyApprovalDialogNotDisplayed(), MessageFormat.format(
				COREFLEXConstants.APPROVE_THIS_POLICY_DIALOG_DISPLAYED_AFTER_CANCEL_OPERATION, CoreConstants.FAIL));
	}

	@Then("^user should be navigated to \"([^\"]*)\" page having 'Policy Status' and 'Version Number' displayed as \"([^\"]*)\" and \"([^\"]*)\" respectively$")
	public void user_should_be_navigated_to_page_having_Policy_Status_and_Version_Number_displayed_as_and_respectively(
			String navigatedPageName, String expectedPolicyStatus, String expectedPolicyVersion) throws Throwable {
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicyStatusPostSubmission(expectedPolicyStatus),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, navigatedPageName));
		Assert.assertTrue(coreFlexCustomBundlesPage.verifyPolicyVersionPostSubmission(expectedPolicyVersion),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_VERSION_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, navigatedPageName));
		Assert.assertTrue(coreFlexCustomBundlesPage.verifySubmitButtonDisabledPostSubmission(),
				MessageFormat.format(
						COREFLEXConstants.SUBMIT_BUTTON_NOT_DISABLED_AFTER_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.FAIL, navigatedPageName));
	}

	@When("^he navigates to \"([^\"]*)\" after clicking on 'Manage my Points' button on \"([^\"]*)\" page$")
	public void he_navigates_to_after_clicking_on_Manage_my_Points_button_on_page(String navigatedPage,
			String sourcePage) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Flex Planning Tool Home</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
	}

	@Then("^benefits selected on Active BluePrint \"([^\"]*)\" - \"([^\"]*)\" Type Policy should be displayed on \"([^\"]*)\" page$")
	public void benefits_selected_on_Active_BluePrint_Type_Policy_should_be_displayed_on_page(String version,
			String policyType, String pageName) throws Throwable {

		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyAvailablePointsMessage(),
				MessageFormat.format(
						MobilityXConstants.FAILED_TO_VALIDATE_AVAILABLE_POINTS_MESSAGE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyBenefitDetailsOnFPT(policyType), MessageFormat.format(
				MobilityXConstants.BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE_OF_MXTRANSFEREE_NOT_MATCHED_WITH_BENEFITS_DETAILS_SET_IN_BLUEPRINT_APPLICATION,
				CoreConstants.FAIL));
	}

	@Then("^custom bundle created in Active BluePrint \"([^\"]*)\" - \"([^\"]*)\" Policy should be displayed on \"([^\"]*)\" page$")
	public void custom_bundle_created_in_Active_BluePrint_Type_Policy_should_be_displayed_on_page(String version,
			String policyType, String pageName) throws Throwable {

		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.SUGGESTED_OPTIONS_LINK);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifyUserNavigationToSuggestedBundlesPage(), MessageFormat
				.format(MobilityXConstants.FAILED_TO_NAVIGATE_TO_SUGGESTED_BUNDLES_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to navigate to <i>Suggested Bundles</i> page is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.verifySuggestedBundlesDetails(), MessageFormat.format(
				MobilityXConstants.CUSTOM_BUNDLE_DETAILS_NOT_MATCHED_ON_SUGGESTED_BUNDLES_PAGE, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_BENEFITS_LIST);
	}

	@Given("^he has searched for 'Active' points based CoreFlex policy that has one or more assignments/files on \"([^\"]*)\" page$")
	public void he_has_searched_for_Active_points_based_CoreFlex_policy_that_has_one_or_more_assignments_files_on_page(
			String pageName) throws Throwable {
		Assert.assertTrue(bluePrintCFLoginPage.verifyLoginPageNavigation(), MessageFormat.format(
				PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_BLUE_PRINT_APPLICATION_LOGIN_PAGE, CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog(
				"<b>Total time taken to navigate to <i>CoreFlex Policy BluePrint Application Login</i> page is :"
						+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION,
								CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");
		Assert.assertTrue(bluePrintCFLoginPage.loginByUserType(PDTConstants.CSM, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));
		viewPolicyPage.searchAndVerifyPolicy(CoreFunctions.getPropertyFromConfig("Assignment_Policy"), pageName);
	}

	@Given("^he has clicked on \"([^\"]*)\" icon of the searched 'Active' points based CoreFlex policy$")
	public void he_has_clicked_on_icon_of_the_searched_Active_points_based_CoreFlex_policy(String editIcon)
			throws Throwable {
		viewPolicyPage.clickElementOfPage(editIcon);
		CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
	}

	@Given("^he has entered 'Description' after verifying 'Version Control' popup screen contents$")
	public void he_has_entered_Description_after_verifying_Version_Control_popup_screen_contents() throws Throwable {
		Assert.assertTrue(viewPolicyPage.isVersionControlDialogDisplayed(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_DISPLAY_VERSION_CONTROL_DIALOG_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
						CoreConstants.FAIL));
		CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
		Reporter.addStepLog("<b>Total time taken to display to <i>Version Control</i> dialog is :"
				+ CoreFunctions.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
				+ " Seconds </b>");
		Assert.assertTrue(viewPolicyPage.verifyVersionControlDialog(),
				MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_VERSION_CONTROL_DIALOG_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
						CoreConstants.FAIL));
		viewPolicyPage.enterVersionControlDialogDescription();
	}

	@When("^he clicks on \"([^\"]*)\" button on 'Version Control' popup screen$")
	public void he_clicks_on_button_on_Version_Control_popup_screen(String arg1) throws Throwable {
		viewPolicyPage.clickElementOfPage(COREFLEXConstants.CREATE);
	}

	@Then("^user should be navigated to \"([^\"]*)\" page of 'New Version' policy in 'Editable' mode having Policy Status displayed as \"([^\"]*)\"$")
	public void user_should_be_navigated_to_page_of_New_Version_policy_in_Editable_mode_having_Policy_Status_displayed_as(
			String navigatedPageName, String newPolicyStatus) throws Throwable {
		Assert.assertTrue(generalInfoPage.verifyPageNavigation(COREFLEXConstants.GENERAL_INFORMATION_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.validateClientAndPolicyDetailsOnGeneralInfo(COREFLEXConstants.GENERAL_INFORMATION_PAGE,
						CoreFunctions.getPropertyFromConfig("Policy_ClientID"),
						CoreFunctions.getPropertyFromConfig("Assignment_Policy")),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_CLIENT_POLICY_DATA_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.POLICY_STATUS, PDTConstants.DRAFT),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.POLICY_STATUS));
		Assert.assertTrue(
				generalInfoPage.verifyPolicyNumberAfterVersioning(viewPolicyPage),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_VERSION_NUMBER_POST_VERSIONING,
						CoreConstants.FAIL));		
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.TRACING_SET,
						CoreFunctions.getPropertyFromConfig("Policy_TracingSet")),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.TRACING_SET));
		generalInfoPage.fillOtherMandatoryFieldsPostVersioning();
	}

	@Then("^'Points Based Flex Policy' field should be disabled with default value as \"([^\"]*)\"$")
	public void points_Based_Flex_Policy_field_should_be_disabled_with_default_value_as(String pointsBasedFlexPolicyDefaultValue) throws Throwable {
		Assert.assertTrue(
				generalInfoPage.verifyFieldDisabledPostVersioning(PDTConstants.POINTS_BASED_FLEX_POLICY),
				MessageFormat.format(COREFLEXConstants.FIELD_NOT_DISABLED_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL, PDTConstants.POINTS_BASED_FLEX_POLICY));	
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.POINTS_BASED_FLEX_POLICY, pointsBasedFlexPolicyDefaultValue),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.POINTS_BASED_FLEX_POLICY));
	}
	
	@Given("^he has verified 'Enabled/Disabled' status of searched 'Points Based CoreFlex Policy' Icons - \"([^\"]*)\" Versioning on \"([^\"]*)\" page$")
	public void he_has_verified_Enabled_Disabled_status_of_searched_Points_Based_CoreFlex_Policy_Icons_Versioning_on_page(String versioning, String pageName, DataTable dataTable) throws Throwable {
		Assert.assertTrue(
				viewPolicyPage.verifyPolicyIconsStatus(versioning,pageName,dataTable),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_ICONS_ENABLED_DISABLED_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
						CoreConstants.FAIL, pageName));
	}

	@Given("^he has clicked on \"([^\"]*)\" icon of \"([^\"]*)\" - \"([^\"]*)\" version of the searched points based CoreFlex policy$")
	public void he_has_clicked_on_icon_of_version_of_the_searched_points_based_CoreFlex_policy(String iconName, String policyVersion, String policyStatus) throws Throwable {
		
		viewPolicyPage.clickPolicyActionIcon(iconName,policyVersion,policyStatus);
	}

	@Given("^he has navigated to \"([^\"]*)\" page of 'New Version' policy in 'Editable' mode having Policy Status displayed as \"([^\"]*)\"$")
	public void he_has_navigated_to_page_of_New_Version_policy_in_Editable_mode_having_Policy_Status_displayed_as(String arg1, String arg2) throws Throwable {
		
		Assert.assertTrue(generalInfoPage.verifyPageNavigation(COREFLEXConstants.GENERAL_INFORMATION_PAGE),
				MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_COREFLEX_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.validateClientAndPolicyDetailsOnGeneralInfo(COREFLEXConstants.GENERAL_INFORMATION_PAGE,
						CoreFunctions.getPropertyFromConfig("Policy_ClientID"),
						CoreFunctions.getPropertyFromConfig("Assignment_Policy")),
				MessageFormat.format(PDTConstants.FAILED_TO_VALIDATE_CLIENT_POLICY_DATA_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL));
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.POLICY_STATUS, PDTConstants.DRAFT),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.POLICY_STATUS));
		Assert.assertTrue(
				generalInfoPage.verifyPolicyNumberAfterVersioning(viewPolicyPage),
				MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_VERSION_NUMBER_POST_VERSIONING,
						CoreConstants.FAIL));		
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.TRACING_SET,
						CoreFunctions.getPropertyFromConfig("Policy_TracingSet")),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.TRACING_SET));
		Assert.assertTrue(
				generalInfoPage.verifyFieldDisabledPostVersioning(PDTConstants.POINTS_BASED_FLEX_POLICY),
				MessageFormat.format(COREFLEXConstants.FIELD_NOT_DISABLED_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL, PDTConstants.POINTS_BASED_FLEX_POLICY));	
		Assert.assertTrue(
				generalInfoPage.verifyGeneralInfoFieldDefaultValue(PDTConstants.POINTS_BASED_FLEX_POLICY, COREFLEXConstants.YES),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_VALUE_OF_GENERAL_INFORMATION_PAGE_FIELD,
						CoreConstants.FAIL, PDTConstants.POINTS_BASED_FLEX_POLICY));
	}

	@Given("^he has verified 'Policy-Benefits-SubBenefits' details of \"([^\"]*)\" - \"([^\"]*)\" version Policy matches with \"([^\"]*)\" policy$")
	public void he_has_verified_Policy_Benefits_SubBenefits_details_of_version_Policy_matches_with_policy(String arg1, String arg2, String arg3) throws Throwable {
	    
	}

	@Given("^he has verified 'CustomBundles' and 'Transferee Preview' details of \"([^\"]*)\" - \"([^\"]*)\" version Policy matches with \"([^\"]*)\" policy$")
	public void he_has_verified_CustomBundles_and_Transferee_Preview_details_of_version_Policy_matches_with_policy(String arg1, String arg2, String arg3) throws Throwable {
	    
	}

	@Given("^he has acknowledged 'Submit Success' dialog after clicking on \"([^\"]*)\" button on \"([^\"]*)\" page$")
	public void he_has_acknowledged_Submit_Success_dialog_after_clicking_on_button_on_page(String arg1, String arg2) throws Throwable {
	    
	}

	@Given("^he has verified Policy Status and Version displayed as \"([^\"]*)\" and \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void he_has_verified_Policy_Status_and_Version_displayed_as_and_on_page(String arg1, String arg2, String arg3) throws Throwable {
	   
	}

	
	
}
