package stepDefinitions.pdt;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
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

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
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
	
	@When("^he clicks on 'SUBMIT' button after entering mandatory information for all the below selected sub benefits on \"([^\"]*)\" page$")
	public void he_clicks_on_SUBMIT_button_after_entering_mandatory_information_for_all_the_below_selected_sub_benefits_on_page(
			String policyBenefitPgName, DataTable subBenefitTable) {
		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
		List<String> subBenefits = subBenefitTable.asList(String.class);
		subBenefitPage.verifySelectedPolicyBenefitCategoryName(policyBenefitPgName);
		subBenefitPage.verifySubBenefitCategoriesAreDisplayed(subBenefits, policyBenefitPgName);
	}

	@Then("^success message \"([^\"]*)\" should be displayed on the \"([^\"]*)\" page$")
	public void success_message_should_be_displayed_on_the_page(String successMsg, String pageName) {
		Assert.assertTrue(subBenefitPage.verifySaveSuccessMessage(successMsg, pageName, addNewPolicyPage), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_SUCCESS_MSG, CoreConstants.FAIL, successMsg, pageName));
	}

	@Then("^newly created Policy should be displayed under \"([^\"]*)\" page after clicking on 'EXIT' button$")
	public void newly_created_Policy_should_be_displayed_under_page_after_clicking_on_EXIT_button(String pageName) {
		timeBeforeAction = new Date().getTime();
		subBenefitPage.exitFromPolicyBenefitPage();
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName);
		Assert.assertTrue(viewPolicyPage.searchAndVerifyPolicy(addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(), pageName, addNewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELEMENT_DISPLAYED_ON_PAGE, CoreConstants.FAIL, PDTConstants.POLICY_NAME,
						addNewPolicyPage.getPolicyName(), pageName, viewPolicyPage.getPolicyList()));
		DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
	}
	
	@When("^he selects 'Benefit differs for Employee type', 'Benefit differs for Homeowner type' for below Sub benefits on \"([^\"]*)\" page$")
	public void he_selects_Benefit_differs_for_Employee_type_Benefit_differs_for_Homeowner_type_for_below_Sub_benefits_on_page(String pageName, DataTable subBenefitTable) {
		subBenefitPage.selectEmployeeTypeHomeOwnerTypeForSubBenefit(pageName, addNewPolicyPage, subBenefitTable);
	}

	@Then("^below Tabs should appear in Sub benefit form on \"([^\"]*)\" page$")
	public void below_Tabs_should_appear_in_Sub_benefit_form_on_page(String pageName, DataTable subBenefitTable) {
		Assert.assertTrue(subBenefitPage.iterateSubBenefitForTabs(pageName, addNewPolicyPage, subBenefitTable), subBenefitPage.getTabNameNotMatch(pageName));		
		DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
	}
	
	@When("^he clicks on 'SUBMIT' button after entering mandatory information on \"([^\"]*)\" page$")
	public void he_clicks_on_SUBMIT_button_after_entering_mandatory_information_on_page(String pageName) throws Throwable {
		subBenefitPage.verifySelectedPolicyBenefitCategoryName(pageName);
		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
		subBenefitPage.fillSubBenefitForm(pageName, addNewPolicyPage, objStep, pageName);
	}
	
	@When("^he clicks on \"([^\"]*)\" button after entering mandatory information for all the below selected sub benefits on \"([^\"]*)\" page$")
	@And("^he has clicked on \"([^\"]*)\" button after entering mandatory information for all the below selected sub benefits on \"([^\"]*)\" page$")
	public void he_has_clicked_on_button_after_entering_mandatory_information_for_all_the_below_selected_sub_benefits_on_page(String btnName, String policyBenefitPgName, DataTable subBenefitTable) throws Throwable {
		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
		List<String> subBenefits = subBenefitTable.asList(String.class);
		subBenefitPage.verifySelectedPolicyBenefitCategoryName(policyBenefitPgName);
		subBenefitPage.verifySubBenefitCategoriesAreDisplayed(subBenefits, policyBenefitPgName);
		subBenefitPage.iterateAndSelectSubBenefits(policyBenefitPgName, subBenefits, addNewPolicyPage, objStep, btnName);
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
		Assert.assertTrue(viewPolicyPage.searchAndVerifyPolicy(addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(), pageName, addNewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELEMENT_DISPLAYED_ON_PAGE, CoreConstants.FAIL, PDTConstants.POLICY_NAME,
						addNewPolicyPage.getPolicyName(), pageName, viewPolicyPage.getPolicyList()));
	}
	
	@And("^he has navigated to \"([^\"]*)\" page after clicking on the \"([^\"]*)\" button of 'Confirmation' dialog on \"([^\"]*)\" page$")
	public void he_has_navigated_to_page_after_clicking_on_the_button_of_Confirmation_dialog_on_page(String pageName, String btnName, String benefitPageName) throws Throwable {
		subBenefitPage.clickOnConfirmDialogBtn(btnName);
		timeBeforeAction = new Date().getTime();
		Assert.assertTrue(viewPolicyPage.verifyViewPolicyHeading(pageName), MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, PDTConstants.heading, PDTConstants.VIEW_EDIT_POLICY_FORMS, pageName));
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName);
	}

	@When("^he views the newly created policy$")
	public void he_views_the_newly_created_policy() throws Throwable {
		viewPolicyPage.verifySubmittedPolicyStatus(addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(), PDTConstants.DRAFT);
		viewPolicyPage.navigateToGeneralInfoPage(addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(), PDTConstants.GENERAL_INFORMATION);
		generalInfoPage.verifyGeneralInfoAndPolicyBenefitPage(policyBenefitCategoryPage);
		policyBenefitCategoryPage.navigateToSubbenefitPage(policyBenefitCategoryPage.getBenefitCategoryName());
	}

	@Then("^information should not be saved for below sub-benefits of \"([^\"]*)\" page$")
	public void information_should_not_be_saved_for_below_sub_benefits_of_page(String policyBenefitPgName, DataTable subBenefitTable) throws Throwable {
		List<String> subBenefits = subBenefitTable.asList(String.class);		
		subBenefitPage.verifySubBenefitCategoriesAreDisplayed(subBenefits, policyBenefitPgName);
		Assert.assertTrue(subBenefitPage.verifySubBenefitCategoriesAreUnchecked(subBenefits.toString()), MessageFormat.format(PDTConstants.VERIFIED_DATA_SAVED_FOR_SUB_BENEFIT, CoreConstants.FAIL, subBenefits.toString()));
		DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
	}
}
