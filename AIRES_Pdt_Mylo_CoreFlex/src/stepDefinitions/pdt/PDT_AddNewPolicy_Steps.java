package stepDefinitions.pdt;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_PolicyBenefitCategoryPage;
import com.aires.pages.pdt.PDT_PreAcceptanceService;
import com.aires.pages.pdt.PDT_ViewPolicyPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDT_AddNewPolicy_Steps {
	TestContext testContext;
	PDT_ViewPolicyPage viewPolicyPage;
	PDT_AddNewPolicyPage addNewPolicyPage;
	PDT_GeneralInformationPage generalInfoPage;
	PDT_PolicyBenefitCategoryPage policyBenefitCategoryPage;
	PDT_PreAcceptanceService preAcceptanceServicePage;
	
	public PDT_AddNewPolicy_Steps(TestContext context) {
		testContext = context;
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();
		policyBenefitCategoryPage = testContext.getPageObjectManager().getpolicyBenefitCategoryPage();
		preAcceptanceServicePage = testContext.getPageObjectManager().getPreAcceptanceServicePage();

	}
	@Given("^he is on \"([^\"]*)\" page after clicking link \"([^\"]*)\" from left menu navigation on \"([^\"]*)\" page$")
	public void he_is_on_page_after_clicking_link_from_left_menu_navigation_on_page(String currentPage, String addNewPolicyLink, String parentPage) {		
		viewPolicyPage.clickElementOfPage(addNewPolicyLink);
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(PDTConstants.ADD_NEW_POLICY_FORM),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, PDTConstants.ADD_NEW_POLICY_FORM,
						PDTConstants.ADD_NEW_POLICY_FORM, addNewPolicyPage.getElementText(PDTConstants.HEADING)));		
	}

	@Given("^he has clicked on \"([^\"]*)\" button after selecting below Client, Policy information on \"([^\"]*)\" page$")
	@When("^he clicks on \"([^\"]*)\" button after selecting below Client, Policy information on \"([^\"]*)\" page$")
	public void he_clicks_on_button_after_selecting_below_Client_Policy_information_on_page(String nextbtn, String addNewPolicyFormPage, DataTable clientPolicyData) {
		List<Map<String, String>> clientPolicyInfo = clientPolicyData.asMaps(String.class, String.class);
		addNewPolicyPage.enterClientPolicyDetails(clientPolicyInfo);
	}

	@Then("^by default \"([^\"]*)\" option should be selected for \"([^\"]*)\" drop down on \"([^\"]*)\" page$")
	public void by_default_option_should_be_selected_for_drop_down_on_page(String noOption, String coreFlexPolicyField, String generalInfoPageName) {
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		Assert.assertTrue(generalInfoPage.verifyClientDetails(addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL, addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID), generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyPolicyName(addNewPolicyPage.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL, addNewPolicyPage.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyCoreFlexPolicyField(noOption, generalInfoPageName),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_COREFLEX_POLICY, CoreConstants.FAIL, generalInfoPageName, noOption,
						generalInfoPage.getCoreFlexPolicyDefaultValue()));
	}

	@Then("^\"([^\"]*)\" drop down should display below options$")
	public void drop_down_should_display_below_options(String benefitPackageTypeDropDown, DataTable benefitPackageTypeTable) {
		Assert.assertTrue(generalInfoPage.verifyBenefitPackageType(benefitPackageTypeTable),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BENEFIT_PACKAGE_TPE, CoreConstants.FAIL, generalInfoPage.getBenefitPackageTypeOptions(), benefitPackageTypeTable.asList(String.class).toString()));
	}
	
	@When("^he clicks on \"([^\"]*)\" button after selecting below information for form fields on \"([^\"]*)\" page$")
	public void he_clicks_on_button_after_selecting_below_information_for_form_fields_on_page(String nextBtn, String generalInformationPage, DataTable generalInfoTable) throws Throwable {
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		
		Assert.assertTrue(generalInfoPage.verifyClientDetails(addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL, addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID), generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyPolicyName(addNewPolicyPage.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL, addNewPolicyPage.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));
		
		generalInfoPage.enterGeneralInformationFields(generalInfoTable);
	}

	@Then("^benefit categories should be displayed on \"([^\"]*)\" page$")
	public void benefit_categories_should_be_displayed_on_page(String policyBenefitPage) {
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(policyBenefitPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, PDTConstants.POLICY_BENEFIT_CATEGORIES,
						policyBenefitPage, policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoriesAreDisplayed(policyBenefitPage),
				MessageFormat.format(PDTConstants.BENEFIT_CATEGORIES_NOT_DISPLAYED, CoreConstants.FAIL, policyBenefitPage));
	}
	
	@Given("^he has selected below information for form fields on \"([^\"]*)\" page followed by selection of \"([^\"]*)\" as Benefit Category on \"([^\"]*)\" page$")
	public void he_has_selected_below_information_for_form_fields_on_page_followed_by_selection_of_as_Benefit_Category_on_page(String generalInformationPage, String benefitCategory, String policyBenefitPage, DataTable generalInfoTable) {
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		
		Assert.assertTrue(generalInfoPage.verifyClientDetails(addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL, addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID), generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyPolicyName(addNewPolicyPage.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL, addNewPolicyPage.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));
		
		generalInfoPage.enterGeneralInformationFields(generalInfoTable);
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(policyBenefitPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, PDTConstants.POLICY_BENEFIT_CATEGORIES,
						policyBenefitPage, policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		policyBenefitCategoryPage.selectPolicyBenefitCategory(benefitCategory);
	}

/*	@When("^he selects the below sub benefit on \"([^\"]*)\" page followed by deselect$")
	public void he_selects_the_below_sub_benefit_on_page_followed_by_deselect(String policySubBenefitPage, DataTable subBenefitTable) {
		Assert.assertTrue(preAcceptanceServicePage.verifySubCategoryHeading(policySubBenefitPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, policySubBenefitPage,
						policySubBenefitPage, preAcceptanceServicePage.getElementText(PDTConstants.HEADING)));
		preAcceptanceServicePage.selectSubBenefitAndVerifyFormIsDisplayed(subBenefitTable, policySubBenefitPage);
	}

	@Then("^corresponding sub benefit form should first display on selection followed by hide on deselection$")
	public void corresponding_sub_benefit_form_should_first_display_on_selection_followed_by_hide_on_deselection() {
		
	}*/
	

	@Given("^sub benefit category form appears after selecting below categories on \"([^\"]*)\" page$")
	public void sub_benefit_category_form_appears_after_selecting_below_categories_on_page(String pageName, DataTable subBenefitTable) {
		Assert.assertTrue(preAcceptanceServicePage.verifySubCategoryHeading(pageName),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, pageName,
						pageName, preAcceptanceServicePage.getElementText(PDTConstants.HEADING)));
		preAcceptanceServicePage.selectSubBenefitAndVerifyFormIsDisplayed(subBenefitTable, pageName);
	}

	@When("^he deselects the below sub benefit category  on \"([^\"]*)\" page$")
	public void he_deselects_the_below_sub_benefit_category_on_page(String pageName, DataTable subBenefitTable) {
		preAcceptanceServicePage.deselectSubBenefit(subBenefitTable, pageName);
	}
	
	@Then("^below sub benefit category form should disappear from  \"([^\"]*)\" page$")
	public void below_sub_benefit_category_form_should_disappear_from_page(String pageName, DataTable subBenefitTable) {
		preAcceptanceServicePage.checkFormIsHidden(subBenefitTable, pageName);
	}
}
