package stepDefinitions.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_AssignmentHousingPage;
import com.aires.pages.pdt.PDT_CompensationServicesPage;
import com.aires.pages.pdt.PDT_CulturalTrainingPage;
import com.aires.pages.pdt.PDT_DestinationServicesPage;
import com.aires.pages.pdt.PDT_DuplicateHousingPage;
import com.aires.pages.pdt.PDT_FinalMovePage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_HomeLeavePage;
import com.aires.pages.pdt.PDT_HomePurchasePage;
import com.aires.pages.pdt.PDT_HouseHoldGoodsPage;
import com.aires.pages.pdt.PDT_HouseHuntingTripPage;
import com.aires.pages.pdt.PDT_ImmigrationPage;
import com.aires.pages.pdt.PDT_LanguageTrainingPage;
import com.aires.pages.pdt.PDT_OneTimePaymentReimbursemenPage;
import com.aires.pages.pdt.PDT_OngoingPaymentReimbursementPage;
import com.aires.pages.pdt.PDT_PolicyBenefitCategoryPage;
import com.aires.pages.pdt.PDT_PreAcceptanceService;
import com.aires.pages.pdt.PDT_PropertyManagementPage;
import com.aires.pages.pdt.PDT_RentalAssistancePage;
import com.aires.pages.pdt.PDT_SharedSubBenefitPage;
import com.aires.pages.pdt.PDT_TemporaryLivingPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.aires.utilities.ClientPolicyDetails;
import com.aires.utilities.CustomSoftAssert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDT_SharedSubBenefit_Steps {
	private TestContext testContext;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_AddNewPolicyPage addNewPolicyPage;
	private PDT_PreAcceptanceService preAcceptanceServicePage;
	private PDT_SharedSubBenefitPage subBenefitPage;
	private PDT_ImmigrationPage immigrationPage;
	private PDT_HouseHuntingTripPage houseHuntingTripPage;
	private PDT_LanguageTrainingPage languageTrainingPage;
	private PDT_CulturalTrainingPage culturalTrainingPage;
	private PDT_FinalMovePage finalMovePage;
	private PDT_HomeLeavePage homeLeavePage;
	private PDT_TemporaryLivingPage temporaryLivingPage;
	private PDT_GeneralInformationPage generalInfoPage;
	private PDT_DestinationServicesPage destinationServicesPage;
	private PDT_RentalAssistancePage rentalAssistancePage;
	private PDT_CompensationServicesPage compensationServicesPage;
	private PDT_AssignmentHousingPage assignmentHousingPage;
	private PDT_DuplicateHousingPage duplicateHousingPage;
	private PDT_OneTimePaymentReimbursemenPage oneTimePaymentPage;
	private PDT_OngoingPaymentReimbursementPage ongoingPaymentReimbursementPage;
	private PDT_PropertyManagementPage propertyManagementPage;
	private PDT_HomePurchasePage homePurchasePage;
	private PDT_HouseHoldGoodsPage houseHoldGoodsPage;
	private PDT_PolicyBenefitCategoryPage policyBenefitCategoryPage;
	private CustomSoftAssert _softAssert;
	long timeBeforeAction, timeAfterAction;
	
	public PDT_SharedSubBenefit_Steps(TestContext context) {
		testContext = context;
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		preAcceptanceServicePage = testContext.getPageObjectManager().getPreAcceptanceServicePage();
		subBenefitPage = testContext.getPageObjectManager().getSharedSubBenefitPage();
		immigrationPage = testContext.getPageObjectManager().getImmigrationPage();
		houseHuntingTripPage = testContext.getPageObjectManager().getHouseHuntingTripPage();
		languageTrainingPage = testContext.getPageObjectManager().getLanguageTrainingPage();
		culturalTrainingPage = testContext.getPageObjectManager().getCulturalTrainingPage();
		finalMovePage = testContext.getPageObjectManager().getFinalMovePage();
		homeLeavePage = testContext.getPageObjectManager().getHomeLeavePage();
		temporaryLivingPage = testContext.getPageObjectManager().getTemporaryLivingPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();
		destinationServicesPage = testContext.getPageObjectManager().getDestinationServicesPage();
		rentalAssistancePage = testContext.getPageObjectManager().getRentalAssistancePage();
		compensationServicesPage = testContext.getPageObjectManager().getCompensationServicesPage();
		assignmentHousingPage = testContext.getPageObjectManager().getAssignmentHousingPage();
		duplicateHousingPage = testContext.getPageObjectManager().getDuplicateHousingPage();
		oneTimePaymentPage = testContext.getPageObjectManager().getOneTimePaymentPage();
		ongoingPaymentReimbursementPage = testContext.getPageObjectManager().getOngoingPaymentReimbursementPage();
		propertyManagementPage = testContext.getPageObjectManager().getPropertyManagementPage();
		homePurchasePage = testContext.getPageObjectManager().getHomePurchasePage();
		houseHoldGoodsPage =  testContext.getPageObjectManager().getHouseHoldGoodsPage();
		policyBenefitCategoryPage = testContext.getPageObjectManager().getpolicyBenefitCategoryPage();
		_softAssert = testContext.getSoftAssertObject();
	}
	
	public PDT_PreAcceptanceService getPreAcceptServicePage() {
		return preAcceptanceServicePage;
	}
	
	public PDT_ImmigrationPage getImmigrationPage() {
		return immigrationPage;
	}
	
	public PDT_HouseHuntingTripPage getHouseHuntingTripPage() {
		return houseHuntingTripPage;
	}
	
	public PDT_LanguageTrainingPage getLanguageTrainingPage() {
		return languageTrainingPage;
	}
	
	public PDT_CulturalTrainingPage getCulturalTrainingPage() {
		return culturalTrainingPage;
	}
	
	public PDT_FinalMovePage getFinalMovePage() {
		return finalMovePage;
	}
	
	public PDT_HomeLeavePage getHomeLeavePage() {
		return homeLeavePage;
	}
	
	public PDT_TemporaryLivingPage getTemporaryLivingPage() {
		return temporaryLivingPage;
	}
	
	public PDT_GeneralInformationPage getGeneralInfoPage() {
		return generalInfoPage;
	}
	
	public PDT_DestinationServicesPage getDestinationServicePage() {
		return destinationServicesPage;
	}
	
	public PDT_RentalAssistancePage getRentalAssistancePage() {
		return rentalAssistancePage;
	}
	
	public PDT_CompensationServicesPage getCompensationServicesPage() {
		return compensationServicesPage;
	}
	
	public PDT_AssignmentHousingPage getAssignmentHousingPage() {
		return assignmentHousingPage;
	}
	
	public PDT_DuplicateHousingPage getDuplicateHousingPage() {
		return duplicateHousingPage;
	}
	
	public PDT_OneTimePaymentReimbursemenPage getOneTimePaymentPage() {
		return oneTimePaymentPage;
	}
	
	public PDT_OngoingPaymentReimbursementPage getOngoingPaymentReimbursementPage() {
		return ongoingPaymentReimbursementPage;
	}
	
	public PDT_PropertyManagementPage getPropertyManagementPage() {
		return propertyManagementPage;
	}
	
	public PDT_HomePurchasePage getHomePurchasePage() {
		return homePurchasePage;
	}
	
	public PDT_HouseHoldGoodsPage getHouseHoldGoodsPage() {
		return houseHoldGoodsPage;
	}
	
	public CustomSoftAssert getCustomSoftAssertObj() {
		return _softAssert;
	}
	
	@When("^he clicks on 'SUBMIT' button after entering mandatory information for all the below selected sub benefits on \"([^\"]*)\" page$")
	public void he_clicks_on_SUBMIT_button_after_entering_mandatory_information_for_all_the_below_selected_sub_benefits_on_page(
			String policyBenefitPgName, DataTable subBenefitTable) {
		List<String> subBenefits = subBenefitTable.asList(String.class);
		subBenefitPage.verifySelectedPolicyBenefitCategoryName(policyBenefitPgName);
		subBenefitPage.verifySubBenefitCategoriesAreDisplayed(subBenefits, policyBenefitPgName);
	}

	@Then("^newly created Policy should be displayed under \"([^\"]*)\" page after clicking on 'EXIT' button$")
	public void newly_created_Policy_should_be_displayed_under_page_after_clicking_on_EXIT_button(String pageName) {
		timeBeforeAction = new Date().getTime();
		subBenefitPage.exitFromPolicyBenefitPage();
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName);
		Assert.assertTrue(viewPolicyPage.searchAndVerifyPolicy(ClientPolicyDetails.getPolicyName().split("\\(#")[0].trim(), pageName, addNewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELEMENT_DISPLAYED_ON_PAGE, CoreConstants.FAIL, PDTConstants.POLICY_NAME,
						ClientPolicyDetails.getPolicyName(), pageName, viewPolicyPage.getPolicyList()));
		DbFunctions.deletePolicyByPolicyId(ClientPolicyDetails.getPolicyId());
		_softAssert.assertAll();
	}
	
	@When("^he selects 'Benefit differs for Employee type', 'Benefit differs for Homeowner type' for below Sub benefits on \"([^\"]*)\" page$")
	public void he_selects_Benefit_differs_for_Employee_type_Benefit_differs_for_Homeowner_type_for_below_Sub_benefits_on_page(String pageName, DataTable subBenefitTable) {
		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
		subBenefitPage.selectEmpTypeHomeOwnerTypeForSubBenefit(pageName, objStep, addNewPolicyPage, subBenefitTable);
	}

	@Then("^below Tabs should appear in Sub benefit form on \"([^\"]*)\" page$")
	public void below_Tabs_should_appear_in_Sub_benefit_form_on_page(String pageName, DataTable subBenefitTable) {
		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
		subBenefitPage.iterateSubBenefitTabsForBenefit(pageName, objStep, addNewPolicyPage, subBenefitTable);	
		DbFunctions.deletePolicyByPolicyId(ClientPolicyDetails.getPolicyId());
	}
	
	@When("^he clicks on \"([^\"]*)\" button after entering mandatory information on \"([^\"]*)\" page$")
	public void he_clicks_on_SUBMIT_button_after_entering_mandatory_information_on_page(String btnName, String pageName) throws Throwable {
		subBenefitPage.verifySelectedPolicyBenefitCategoryName(pageName);
		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
		subBenefitPage.navigateBenefitCategory(objStep, addNewPolicyPage, pageName, btnName);
	}
	
	@When("^he clicks on \"([^\"]*)\" button after entering mandatory information for all the below selected sub benefits on \"([^\"]*)\" page$")
	@Given("^he has clicked on \"([^\"]*)\" button after entering mandatory information for all the below selected sub benefits on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_entering_mandatory_information_for_all_the_below_selected_sub_benefits_on_page(String btnName, String policyBenefitPgName, DataTable subBenefitTable) throws Throwable {
		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
		List<String> subBenefits = subBenefitTable.asList(String.class);
		subBenefitPage.verifySelectedPolicyBenefitCategoryName(policyBenefitPgName);
		subBenefitPage.verifySubBenefitCategoriesAreDisplayed(subBenefits, policyBenefitPgName);
		subBenefitPage.navigateBenefitCategory(subBenefits, addNewPolicyPage, objStep, policyBenefitPgName, btnName, generalInfoPage);
	}

	@When("^he clicks on \"([^\"]*)\" button of 'Confirmation' dialog on \"([^\"]*)\" page$")
	public void he_clicks_on_button_of_dialog(String btnName, String pageName) throws Throwable {
		subBenefitPage.clickOnConfirmDialogBtn(btnName);
	}

	@Then("^he should be navigated on the \"([^\"]*)\" page$")
	public void he_should_be_navigated_on_the_page(String pageName) throws Throwable {
		timeBeforeAction = new Date().getTime();
		Assert.assertTrue(viewPolicyPage.verifyViewPolicyHeading(pageName), MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, PDTConstants.heading, PDTConstants.VIEW_EDIT_POLICY_FORMS, pageName));
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName);
	}

	@Then("^Policy should not be displayed under \"([^\"]*)\" page$")
	public void policy_should_not_be_displayed_under_page(String pageName) throws Throwable {
		Assert.assertTrue(viewPolicyPage.searchAndVerifyPolicy(ClientPolicyDetails.getPolicyName().split("\\(#")[0].trim(), pageName, addNewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELEMENT_DISPLAYED_ON_PAGE, CoreConstants.FAIL, PDTConstants.POLICY_NAME,
						ClientPolicyDetails.getPolicyName(), pageName, viewPolicyPage.getPolicyList()));
	}
	
	@Given("^he has navigated to \"([^\"]*)\" page after clicking on the \"([^\"]*)\" button of 'Confirmation' dialog on \"([^\"]*)\" page$")
	public void he_has_navigated_to_page_after_clicking_on_the_button_of_Confirmation_dialog_on_page(String pageName, String btnName, String benefitPageName) throws Throwable {
		subBenefitPage.clickOnConfirmDialogBtn(btnName);
		timeBeforeAction = new Date().getTime();
		Assert.assertTrue(viewPolicyPage.verifyViewPolicyHeading(pageName), MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, PDTConstants.heading, PDTConstants.VIEW_EDIT_POLICY_FORMS, pageName));
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName);
	}

	@When("^he views the newly created policy$")
	public void he_views_the_newly_created_policy() throws Throwable {
		viewPolicyPage.verifySubmittedPolicyStatus(ClientPolicyDetails.getPolicyName().split("\\(#")[0].trim(), PDTConstants.DRAFT_ERR);
		viewPolicyPage.navigateToGeneralInfoPage(ClientPolicyDetails.getPolicyName().split("\\(#")[0].trim(), PDTConstants.GENERAL_INFORMATION);
		generalInfoPage.verifyGeneralInfoAndPolicyBenefitPage(policyBenefitCategoryPage);
		policyBenefitCategoryPage.navigateToSubbenefitPage(policyBenefitCategoryPage.getBenefitCategoryName());
	}

	@Then("^information should not be saved for below sub-benefits of \"([^\"]*)\" page$")
	public void information_should_not_be_saved_for_below_sub_benefits_of_page(String policyBenefitPgName, DataTable subBenefitTable) throws Throwable {
		List<String> subBenefits = subBenefitTable.asList(String.class);		
		subBenefitPage.verifySubBenefitCategoriesAreDisplayed(subBenefits, policyBenefitPgName);
		Assert.assertTrue(subBenefitPage.verifySubBenefitCategoriesAreUnchecked(subBenefits.toString()), MessageFormat.format(PDTConstants.VERIFIED_DATA_SAVED_FOR_SUB_BENEFIT, CoreConstants.FAIL, subBenefits.toString()));
		DbFunctions.deletePolicyByPolicyId(ClientPolicyDetails.getPolicyId());
	}
	
	@Then("^Policy Status should be changed to \"([^\"]*)\" along with Version \"([^\"]*)\" on the \"([^\"]*)\" page$")
	public void policy_Status_should_be_changed_to_along_with_Version_on_the_page(String policyStatus, String policyVersion, String pageName) throws Throwable {
		Assert.assertTrue(subBenefitPage.verifyStatusAndVersionOfPolicy(
				ClientPolicyDetails.getPolicyName().split("\\(#")[0].trim(), policyStatus, policyVersion, pageName));
	}
	
	
	@Given("^he has entered mandatory information for all the benefit forms after verifying the default selected option for Gross-Up, Reimbursed by fields on each benefit$")
	public void he_has_entered_mandatory_information_for_all_the_benefit_forms_after_verifying_the_default_selected_option_for_Gross_Up_Reimbursed_by_fields_on_each_benefit() {
		subBenefitPage.iterateEachBenefitCategory(policyBenefitCategoryPage.getSelectedCategoriesName(), testContext,
				subBenefitPage, addNewPolicyPage, generalInfoPage);
	}

	@When("^he clicks on \"([^\"]*)\" button on last benefit page$")
	public void he_clicks_on_button_on_last_benefit_page(String btnName) {
		subBenefitPage.clickOnBtn(btnName);
		subBenefitPage.waitForProgressBarToDisapper();
	}

	@Then("^submitted value of Gross-Up, Reimbursed by fields should be displayed on all sub-benefit forms$")
	public void updated_value_of_Gross_Up_Reimbursed_by_fields_should_be_displayed_on_all_sub_benefit_forms() throws Throwable {
		ArrayList<String> benefitCategories = policyBenefitCategoryPage.getSelectedCategoriesName();
		Assert.assertTrue(subBenefitPage.iterateBenefitCategoriesAndVerifyGrossUpReimbursedBy(benefitCategories, this), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_GROSSUP_REIMBURSED_BY, CoreConstants.FAIL));
		_softAssert.assertAll();

	}
	
}
