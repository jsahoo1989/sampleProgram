package stepDefinitions.pdt;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_PolicyBenefitCategoryPage;
import com.aires.pages.pdt.PDT_SharedSubBenefitPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.aires.utilities.ClientPolicyDetails;
import com.aires.utilities.CustomSoftAssert;
import com.aires.utilities.Log;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDT_SilentSave_Steps {
	private TestContext testContext;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_AddNewPolicyPage addNewPolicyPage;
	private PDT_SharedSubBenefitPage subBenefitPage;
	private PDT_PolicyBenefitCategoryPage policyBenefitCategoryPage;
	private PDT_GeneralInformationPage generalInfoPage;
	String benefitCatPageNameBeforeSave, policyStatusBeforeSave;
	long timeBeforeAction, timeAfterAction;
	private CustomSoftAssert _softAssert;

	public PDT_SilentSave_Steps(TestContext context) {
		testContext = context;
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		subBenefitPage = testContext.getPageObjectManager().getSharedSubBenefitPage();
		policyBenefitCategoryPage = testContext.getPageObjectManager().getpolicyBenefitCategoryPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();
		_softAssert = testContext.getSoftAssertObject();
	}

	@When("^he clicks on 'Save' button after entering mandatory information for all sub-benefits of \"([^\"]*)\" page$")
	public void he_clicks_on_Save_button_after_entering_mandatory_information_for_all_sub_benefits_of_page(
			String benefitCategory) throws Throwable {
		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);		
		List<String> subBenefits = BusinessFunctions.getSubBenefitList(benefitCategory);
		benefitCatPageNameBeforeSave = subBenefitPage.getCurrentBenefitCategoryName(benefitCategory);
		policyStatusBeforeSave = subBenefitPage.getPolicyStatus();
		subBenefitPage.verifySelectedPolicyBenefitCategoryName(benefitCategory);
		subBenefitPage.verifySubBenefitCategoriesAreDisplayed(subBenefits, benefitCategory);
		subBenefitPage.navigateBenefitCategory(subBenefits, addNewPolicyPage, objStep, benefitCategory, PDTConstants.SAVE);
	}

	@Then("^Saved indicator is displayed for saved Policy Benefit Category on the left menu$")
	public void saved_indicator_is_displayed_for_saved_Policy_Benefit_Category_on_the_left_menu() throws Throwable {
		Assert.assertTrue(
				subBenefitPage.verifySavedIndicatorForBenefit(policyBenefitCategoryPage.getBenefitCategoryName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON_INDICATOR, CoreConstants.FAIL,
						PDTConstants.SAVE_INDICATOR, policyBenefitCategoryPage.getBenefitCategoryName()));
	}

	@Then("^he stays on the same benefit page without any change in policy status$")
	public void he_stays_on_the_same_benefit_page_without_any_change_in_policy_status() throws Throwable {
		Assert.assertTrue(subBenefitPage.verifyUserStaysOnSamePage(benefitCatPageNameBeforeSave),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_STAYS_ON_SAME_PAGE, CoreConstants.FAIL,
						benefitCatPageNameBeforeSave,
						subBenefitPage.getCurrentBenefitCategoryName(benefitCatPageNameBeforeSave)));

		Assert.assertTrue(subBenefitPage.verifyPolicyStatusRemainsSame(policyStatusBeforeSave),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_STATUS_REMAINS_SAME, CoreConstants.FAIL,
						policyStatusBeforeSave, PDTConstants.SAVE, subBenefitPage.getPolicyStatus()));
	}

	@Given("^he has entered mandatory information on 'General Information' page followed by selection of below Benefit Categories on \"([^\"]*)\" page$")
	public void he_has_entered_mandatory_information_on_General_Information_page_followed_by_selection_of_below_Benefit_Categories_on_page(
			String policyBenefitPage, DataTable benefitsTable) throws Throwable {
		generalInfoPage.explicitWaitForGeneralInfoHeading();

		Assert.assertTrue(
				generalInfoPage.verifyClientDetails(ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL,
						ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID),
						generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));

		Assert.assertTrue(generalInfoPage.verifyPolicyName(ClientPolicyDetails.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL,
						ClientPolicyDetails.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));

		generalInfoPage.enterGeneralInformationFields();
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(policyBenefitPage),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL,
						PDTConstants.heading, PDTConstants.POLICY_BENEFIT_CATEGORIES, policyBenefitPage,
						policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		List<String> benefits = benefitsTable.asList(String.class);
		policyBenefitCategoryPage.iterateBenefitList(benefits);
	}

	@When("^he clicks on 'Save & Continue' button on each benefit page after entering mandatory information for all sub-benefits of each selected benefit Category$")
	@Given("^he has clicked on 'Save & Continue' button on each benefit page after entering mandatory information for all sub-benefits of each selected benefit Category$")
	public void he_clicks_on_Save_Continue_button_after_entering_mandatory_information_for_all_sub_benefits_of_selected_Policy_benefit_categories()
			throws Throwable {
		subBenefitPage.iterateEachBenefitCategory(policyBenefitCategoryPage.getSelectedCategoriesName(), testContext,
				subBenefitPage, addNewPolicyPage);
	}

	@Then("^he navigates to the next Policy Benefit Category page without any change in policy status$")
	public void he_navigates_to_the_benefit_page_without_any_change_in_policy_status() throws Throwable {

	}

	@Then("^Saved indicator is displayed for all saved Policy Benefit Categories on the left menu$")
	public void saved_indicator_is_displayed_for_all_saved_Policy_Benefit_Categories_on_the_left_menu()
			throws Throwable {
		Assert.assertTrue(
				subBenefitPage.verifyIconIndicatorForBenefitCategories(
						policyBenefitCategoryPage.getSelectedCategoriesName(), PDTConstants.SAVE_INDICATOR,
						PDTConstants.CIRCLE_CHECK_INDICATOR),
				subBenefitPage.printFailedCategoriesWithIcon(PDTConstants.CIRCLE_CHECK_INDICATOR));
	}

	@Given("^he is on \"([^\"]*)\" Page after selecting Client/Policy information followed by filling information on \"([^\"]*)\" page$")
	public void he_is_on_Page_after_selecting_Client_Policy_information_followed_by_filling_information_on_page(
			String policyBenefitPage, String generInfoPage) throws Throwable {
		timeBeforeAction = new Date().getTime();
		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM, PDTConstants.VIEW_EDIT_POLICY_FORMS);
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, PDTConstants.ADD_NEW_POLICY);
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(PDTConstants.ADD_NEW_POLICY),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL,
						PDTConstants.ADD_NEW_POLICY, PDTConstants.ADD_NEW_POLICY_FORM,
						addNewPolicyPage.getElementText(PDTConstants.HEADING)));
		/*_softAssert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(PDTConstants.ADD_NEW_POLICY),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL,
						PDTConstants.ADD_NEW_POLICY, PDTConstants.ADD_NEW_POLICY_FORM,
						"testing"));*/
		addNewPolicyPage.enterClientPolicyDetails();
		generalInfoPage.explicitWaitForGeneralInfoHeading();

		Assert.assertTrue(
				generalInfoPage.verifyClientDetails(ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL,
						ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID),
						generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));

		Assert.assertTrue(generalInfoPage.verifyPolicyName(ClientPolicyDetails.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL,
						ClientPolicyDetails.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));

		generalInfoPage.enterGeneralInformationFields();
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(policyBenefitPage),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL,
						PDTConstants.heading, PDTConstants.POLICY_BENEFIT_CATEGORIES, policyBenefitPage,
						policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
	}

	@Given("^he has clicked on 'Next' button after selecting below categories on \"([^\"]*)\" Page$")
	public void he_has_clicked_on_Next_button_after_selecting_below_categories_on_Page(String policyBenefitCatPage,
			DataTable benefitsTable) throws Throwable {
		List<String> benefits = benefitsTable.asList(String.class);
		subBenefitPage.initPDTAllPagesList(benefits);
		policyBenefitCategoryPage.iterateBenefitList(benefits);
	}


	@When("^he clicks on \"([^\"]*)\" button after entering mandatory information for all sub-benefits on last benefit category page$")
	public void he_clicks_on_Save_Submit_button_after_entering_mandatory_information_for_all_sub_benefits_of_selected_benefit_categories(
			String btnName) {
		subBenefitPage.clickOnBtn(btnName);
	}

	@Then("^Policy status is changed to \"([^\"]*)\" having version \"([^\"]*)\" on header of 'Benefit Category' page$")
	public void policy_status_is_changed_to_on_Benefit_Category_page(String policyStatus, String policyVersion)
			{
		Assert.assertTrue(
				subBenefitPage.verifyStatusAndVersionOfPolicy(ClientPolicyDetails.getPolicyName().split("\\(#")[0].trim(),
						policyStatus, policyVersion, subBenefitPage.getCategoryName()));
	}

	@Then("^Saved indicator is displayed for all saved Policy Benefit Categories except the last Benefit Category on the left menu$")
	public void saved_indicator_is_displayed_for_all_saved_Policy_Benefit_Categories_except_the_last_Benefit_Category_on_the_left_menu()
			throws Throwable {
		policyBenefitCategoryPage.getSelectedCategoriesName().remove(subBenefitPage.getCategoryName());
		Assert.assertTrue(
				subBenefitPage.verifyIconIndicatorForBenefitCategories(
						policyBenefitCategoryPage.getSelectedCategoriesName(), PDTConstants.SAVE_INDICATOR,
						PDTConstants.CIRCLE_CHECK_INDICATOR),
				subBenefitPage.printFailedCategoriesWithIcon(PDTConstants.CIRCLE_CHECK_INDICATOR));
	}

	@When("^he clicks on 'Save' button after entering mandatory information for some of field values of \"([^\"]*)\" sub-benefit$")
	public void he_clicks_on_Save_button_after_entering_mandatory_information_for_some_of_field_values_of_sub_benefit(
			String benefitCategory) {
		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
		List<String> subBenefits = BusinessFunctions.getSubBenefitList(benefitCategory);
		benefitCatPageNameBeforeSave = subBenefitPage.getCurrentBenefitCategoryName(benefitCategory);
		policyStatusBeforeSave = subBenefitPage.getPolicyStatus();
		subBenefitPage.verifySelectedPolicyBenefitCategoryName(benefitCategory);
		subBenefitPage.verifySubBenefitCategoriesAreDisplayed(subBenefits, benefitCategory);
		subBenefitPage.setCompletePolicyState(false);
		subBenefitPage.navigateBenefitCategory(subBenefits, addNewPolicyPage, objStep, benefitCategory, PDTConstants.SAVE);
	}

	@Then("^\"([^\"]*)\" color 'exclamation mark' \"([^\"]*)\"  indicator is displayed on each sub-benefit tab header level where the mandatory field value is missing$")
	public void color_exclamation_mark_indicator_is_displayed_on_each_sub_benefit_tab_header_level_where_the_mandatory_field_value_is_missing(
			String redColorIndicator, String indicatorName) {
		List<String> subBenefits = BusinessFunctions
				.getSubBenefitList(policyBenefitCategoryPage.getBenefitCategoryName());
		Assert.assertTrue(subBenefitPage.verifyRedAlertIconOnSubBenefitName(subBenefits),
				subBenefitPage.printFailedSubBenefitNameWithoutRedIcon());
	}

	@Then("an 'exclamation mark' \"([^\"]*)\" indicator icon is displayed on Left menu for the Benefit if any of its sub benefit is in Incomplete state$")
	public void color_is_displayed_on_Left_menu_for_the_Benefit_if_any_of_its_sub_benefit_is_in_Incomplete_state(
			String errIndicator) {
		Log.info("BenefitCategorylist==" + policyBenefitCategoryPage.getSelectedCategoriesName());
		Assert.assertTrue(
				subBenefitPage.verifyErrorIndicatorForBenefit(policyBenefitCategoryPage.getBenefitCategoryName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON_INDICATOR, CoreConstants.FAIL,
						PDTConstants.ERROR_IND, policyBenefitCategoryPage.getBenefitCategoryName()));
	}

	@When("^he clicks on 'Save & Continue' button on each benefit page after entering mandatory information for some of the field values of sub-benefits$")
	@And("^he has clicked on 'Save & Continue' button on each benefit page after entering mandatory information for some of the field values of sub-benefits$")
	public void he_clicks_on_Save_Continue_button_on_each_benefit_page_after_entering_mandatory_information_for_some_of_the_field_values_of_sub_benefits() {
		policyStatusBeforeSave = subBenefitPage.getPolicyStatus();
		subBenefitPage.iterateEachBenefitCat(policyBenefitCategoryPage.getSelectedCategoriesName(), testContext,
				subBenefitPage, addNewPolicyPage);
	}

	@Then("^Policy status remains \"([^\"]*)\" on the last Benefit Page$")
	public void policy_status_remains_on_the_last_Benefit_Page(String arg1) {
		Assert.assertTrue(subBenefitPage.verifyPolicyStatusRemainsSame(policyStatusBeforeSave),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_STATUS_REMAINS_SAME, CoreConstants.FAIL,
						policyStatusBeforeSave, PDTConstants.SAVE_AND_CONTINUE, subBenefitPage.getPolicyStatus()));
	}

	@Then("^Side bar menu shows an 'exclamation mark' \"([^\"]*)\" indicator icon for the Benefit if any of its sub benefit is in Incomplete state$")
	public void side_bar_menu_shows_an_exclamation_mark_indicator_icon_for_the_Benefit_if_any_of_its_sub_benefit_is_in_Incomplete_state(
			String arg1) {
		policyBenefitCategoryPage.getSelectedCategoriesName().remove(subBenefitPage.getCategoryName());
		Assert.assertTrue(
				subBenefitPage.verifyIconIndicatorForBenefitCategories(
						policyBenefitCategoryPage.getSelectedCategoriesName(), PDTConstants.ERROR_IND,
						PDTConstants.ERROR_INDICATOR),
				subBenefitPage.printFailedCategoriesWithIcon(PDTConstants.ERROR_INDICATOR));
	}


	@When("^he clicks on 'Save & Submit' button after entering mandatory information for some of the field values on last benefit Category page$")
	public void he_clicks_on_Save_Submit_button_after_entering_mandatory_information_for_some_of_the_field_values_on_last_benefit_Category_page() {
		subBenefitPage.clickOnBtn(PDTConstants.PDT_BTN_SAVE_SUBMIT);
	}

	@Then("^below information is displayed in warning pop-up$")
	public void alert_message_is_displayed(DataTable warningTable) {
		List<Map<String, String>> warningPopUpInfo = warningTable.asMaps(String.class, String.class);
		Assert.assertTrue(subBenefitPage.verifyWarningTitle(warningPopUpInfo.get(0).get("Title")),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_WARNING_TITLE, CoreConstants.FAIL,
						warningPopUpInfo.get(0).get("Title"), subBenefitPage.getWarningTitle()));
		Assert.assertTrue(subBenefitPage.verifyWarningMessage(warningPopUpInfo.get(0).get("Message")),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_WARNING_MSG, CoreConstants.FAIL,
						warningPopUpInfo.get(0).get("Message"), subBenefitPage.getWarningMsg()));

	}
	
	@When("^he clicks on EXIT button on last benefit page$")
	public void he_clicks_on_EXIT_button_on_last_benefit_page() {
		timeBeforeAction = new Date().getTime();
		subBenefitPage.exitFromPolicyBenefitPage();

	}

	@Then("^he should navigate to \"([^\"]*)\" Forms page$")
	public void he_should_navigate_to_Forms_page(String pageName) {
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName);
		Assert.assertTrue(viewPolicyPage.verifyViewPolicyHeading(pageName),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL, PDTConstants.heading, PDTConstants.VIEW_EDIT_POLICY_FORMS, PDTConstants.VIEW_POLICY,
						viewPolicyPage.getElementText(PDTConstants.HEADING)));
		Assert.assertTrue(viewPolicyPage.searchAndVerifyPolicy(ClientPolicyDetails.getPolicyName().split("\\(#")[0].trim(), pageName, addNewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELEMENT_DISPLAYED_ON_PAGE, CoreConstants.FAIL, PDTConstants.POLICY_NAME,
						ClientPolicyDetails.getPolicyName(), pageName, viewPolicyPage.getPolicyList()));
	}
	
	@When("^he clicks on BACK button on last benefit category each page$")
	public void he_clicks_on_BACK_button_on_last_benefit_category_each_page() {
		subBenefitPage.clickOnBtn(PDTConstants.BACK.toUpperCase());
	}

	@Then("^he should navigate to previous page with same result on subsequent BACK button click$")
	public void he_should_navigate_to_previous_page_with_same_result_on_subsequent_BACK_button_click() throws Throwable {
		Assert.assertTrue(subBenefitPage.verifyUserNavigateToPrevPage(PDTConstants.PREVIOUS),subBenefitPage.printFailedExpectedActualPageMap(PDTConstants.PREVIOUS));
	}
	
	@Then("^a \"([^\"]*)\" should be displayed with below information$")
	public void a_Confirmation_pop_up_should_be_displayed_with_below_information(String popUpName, DataTable popUpInfo) {
		List<List<String>> data = popUpInfo.raw();
		subBenefitPage.verifyConfirmationPopContents(_softAssert, data, popUpName);
		_softAssert.assertTrue(subBenefitPage.verifyButtonsOnConfirmationPopUp(data.get(2).get(1), popUpName), subBenefitPage.getfailedButtonString(popUpName));
		_softAssert.assertAll();
	
	}

	@Then("^a \"([^\"]*)\" should be displayed with 'OK, CANCEL, SAVE' buttons with below functionalities on clicking these buttons$")
	public void a_Confirmation_pop_up_should_be_displayed_with_OK_CANCEL_SAVE_buttons_with_below_functionalities(String popUpName, DataTable popUpInfo) {
		List<List<String>> data = popUpInfo.raw();
		Assert.assertTrue(subBenefitPage.verifyOkBtnFunctionality(viewPolicyPage, data.get(0).get(0), popUpName), "Failed to verify Ok btn functionality");
		String benefitCategory = policyBenefitCategoryPage.getSelectedCategoriesName().get((policyBenefitCategoryPage.getSelectedCategoriesName().size()-1));
		String benefitCatPageNameBeforeEXITOperation = subBenefitPage.getCurrentBenefitCategoryName(benefitCategory);
		Assert.assertTrue(subBenefitPage.verifyCancelBtnFunctionality(viewPolicyPage, addNewPolicyPage, benefitCategory, testContext, benefitCatPageNameBeforeEXITOperation, data.get(1).get(0), PDTConstants.EXIT, popUpName), "Failed to verify Cancel btn functionality");
		Assert.assertTrue(subBenefitPage.verifySaveBtnFunctionality(viewPolicyPage, data.get(2).get(0), benefitCategory, generalInfoPage, popUpName), "Failed to verify Save btn functionality");
	}

	@Then("^a \"([^\"]*)\" should be displayed with 'OK, CANCEL, SAVE' buttons with below functionalities on click of these buttons$")
	public void a_Confirmation_pop_up_should_be_displayed_with_OK_CANCEL_SAVE_buttons_with_below_functionalities_on_click_of_these_buttons(String popUpName, DataTable popUpInfo) {
		List<List<String>> data = popUpInfo.raw();
		String currentBenefitCategory = policyBenefitCategoryPage.getSelectedCategoriesName().get((policyBenefitCategoryPage.getSelectedCategoriesName().size()-1));
		Assert.assertTrue(subBenefitPage.verifyOkBtnFunctionalityOnClickingBackBtn(viewPolicyPage, data.get(0).get(0), popUpName, currentBenefitCategory), "Failed to verify Ok btn functionality");
		String benefitCatPageNameBeforeBACKOperation = subBenefitPage.getCurrentBenefitCategoryName(currentBenefitCategory);
		Assert.assertTrue(subBenefitPage.verifyCancelBtnFunctionality(viewPolicyPage, addNewPolicyPage, currentBenefitCategory, testContext, benefitCatPageNameBeforeBACKOperation, data.get(1).get(0), PDTConstants.BACK, popUpName), "Failed to verify Cancel btn functionality");
		Assert.assertTrue(subBenefitPage.verifySaveBtnFunctionalityOnClickingBACKBtn(viewPolicyPage, data.get(2).get(0), currentBenefitCategory, generalInfoPage, popUpName), "Failed to verify Save btn functionality");
	}
	
	@Given("^he has clicked on \"([^\"]*)\" button followed by \"([^\"]*)\" button after entering mandatory information for all sub-benefits of each selected benefit Category$")
	public void he_has_clicked_on_button_followed_by_button_after_entering_mandatory_information_for_all_sub_benefits_of_each_selected_benefit_Category(String saveBtn, String exitBtn) {
		subBenefitPage.iterateEachBenefitCategory(policyBenefitCategoryPage.getSelectedCategoriesName(), testContext,
				subBenefitPage, addNewPolicyPage);
		subBenefitPage.clickOnBtn(saveBtn);
		subBenefitPage.waitForProgressBarToDisapper();
		subBenefitPage.clickOnBtn(exitBtn);
	}
	
	@When("^he clicks on EXIT button on any page$")
	public void he_clicks_on_EXIT_button_on_any_page() {
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		subBenefitPage.clickOnBtn(PDTConstants.EXIT.toUpperCase());
	}
	
	@When("^he clicks on newly added Policy after searching it on \"([^\"]*)\" page$")
	public void he_clicks_on_newly_added_Policy_after_searching_it_on_page(String pageName) {
		Assert.assertTrue(viewPolicyPage.verifyViewPolicyHeading(PDTConstants.VIEW_POLICY),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL, PDTConstants.heading, PDTConstants.VIEW_EDIT_POLICY_FORMS, PDTConstants.VIEW_POLICY,
						viewPolicyPage.getElementText(PDTConstants.HEADING)));
		
		viewPolicyPage.searchByPolicyNameAndClickPolicy(ClientPolicyDetails.getPolicyName().split("\\(#")[0].trim(),
				pageName);
	}

	@Then("^he should navigate back to \"([^\"]*)\" page without displaying exit modal after clicking on \"([^\"]*)\" buttons on following pages$")
	public void he_should_navigate_back_to_page_without_displaying_exit_modal_after_clicking_on_buttons_on_following_pages(String pageName, String buttons, DataTable pagesTable)  {
		List<List<String>> pagesList = pagesTable.raw();
		subBenefitPage.verifyExitBtnOnReadOnlyMode(pageName, buttons, pagesList, viewPolicyPage);
	}

}
