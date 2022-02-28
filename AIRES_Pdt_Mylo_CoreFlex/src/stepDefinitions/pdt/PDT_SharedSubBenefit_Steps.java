package stepDefinitions.pdt;

import java.text.MessageFormat;
import java.util.List;

import org.testng.Assert;

import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_CulturalTrainingPage;
import com.aires.pages.pdt.PDT_DestinationServicesPage;
import com.aires.pages.pdt.PDT_FinalMovePage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_HomeLeavePage;
import com.aires.pages.pdt.PDT_HouseHuntingTripPage;
import com.aires.pages.pdt.PDT_ImmigrationPage;
import com.aires.pages.pdt.PDT_LanguageTrainingPage;
import com.aires.pages.pdt.PDT_PreAcceptanceService;
import com.aires.pages.pdt.PDT_SharedSubBenefitPage;
import com.aires.pages.pdt.PDT_TemporaryLivingPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;

import cucumber.api.DataTable;
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
	
	@When("^he clicks on 'SUBMIT' button after entering mandatory information for all the below selected sub benefits on \"([^\"]*)\" page$")
	public void he_clicks_on_SUBMIT_button_after_entering_mandatory_information_for_all_the_below_selected_sub_benefits_on_page(
			String policyBenefitPgName, DataTable subBenefitTable) {
		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
		List<String> subBenefits = subBenefitTable.asList(String.class);
		subBenefitPage.verifySelectedPolicyBenefitCategoryName(policyBenefitPgName);
		subBenefitPage.verifySubBenefitCategoriesAreDisplayed(subBenefits, policyBenefitPgName);
		subBenefitPage.iterateAndSelectSubBenefits(policyBenefitPgName, subBenefits, addNewPolicyPage, objStep);
	}

	@Then("^success message \"([^\"]*)\" should be displayed on the \"([^\"]*)\" page$")
	public void success_message_should_be_displayed_on_the_page(String successMsg, String pageName) {
		Assert.assertTrue(preAcceptanceServicePage.verifySaveSuccessMessage(successMsg, pageName, addNewPolicyPage), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_SUCCESS_MSG, CoreConstants.FAIL, successMsg, pageName));
	}

	@Then("^newly created Policy should be displayed under \"([^\"]*)\" page$")
	public void newly_created_Policy_should_be_displayed_under_page(String pageName) {		
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
}
