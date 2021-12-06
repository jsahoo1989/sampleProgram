package stepDefinitions.pdt;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
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
	private TestContext testContext;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_AddNewPolicyPage addNewPolicyPage;
	private PDT_GeneralInformationPage generalInfoPage;
	private PDT_PolicyBenefitCategoryPage policyBenefitCategoryPage;
	private PDT_PreAcceptanceService preAcceptanceServicePage;
	
	public PDT_AddNewPolicy_Steps(TestContext context) {
		testContext = context;
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();
		policyBenefitCategoryPage = testContext.getPageObjectManager().getpolicyBenefitCategoryPage();
		preAcceptanceServicePage = testContext.getPageObjectManager().getPreAcceptanceServicePage();

	}
	
	@Given("^he is on the \"([^\"]*)\" page after clicking on the link \"([^\"]*)\" displayed under the left navigation menu on the 'View Policy' page$")
	public void he_is_on_the_Add_New_Policy_page_after_clicking_on_the_link_displayed_under_the_left_navigation_menu_on_the_View_Policy_page(String pageName, String addNewPolicyLink) {
		viewPolicyPage.clickElementOfPage(addNewPolicyLink);		
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(PDTConstants.ADD_NEW_POLICY_FORM),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL, PDTConstants.heading, PDTConstants.ADD_NEW_POLICY_FORM,
						pageName, PDTConstants.ADD_NEW_POLICY_FORM, addNewPolicyPage.getElementText(PDTConstants.HEADING)));
	}

	@Given("^he has clicked on the 'Next' button after selecting below information on the 'Add New Policy' page$")
	@When("^he clicks on the 'Next' button after selecting below information on the 'Add New Policy' page$")
	public void he_clicks_on_the_Next_button_after_selecting_below_information_on_the_Add_New_Policy_page(DataTable clientPolicyData) {
		List<Map<String, String>> clientPolicyInfo = clientPolicyData.asMaps(String.class, String.class);
		addNewPolicyPage.enterClientPolicyDetails(clientPolicyInfo);
	}

	@Then("^by default \"([^\"]*)\" option should be selected for 'Core/Flex policy' drop down on \"([^\"]*)\" page$")
	public void by_default_option_should_be_selected_for_Core_Flex_policy_drop_down_on_page(String noOption, String generalInfoPageName) {
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

	@Then("^'Benefit Package Type' drop down should display below options$")
	public void Benefit_Package_Type_drop_down_should_display_below_options(DataTable benefitPackageTypeTable) {
		Assert.assertTrue(generalInfoPage.verifyBenefitPackageType(benefitPackageTypeTable),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BENEFIT_PACKAGE_TPE, CoreConstants.FAIL, generalInfoPage.getBenefitPackageTypeOptions(), benefitPackageTypeTable.asList(String.class).toString()));
	}
	
	@When("^he clicks on the 'Next' button after selecting below information on 'General Information' page$")
	public void he_clicks_on_the_Next_button_after_selecting_below_information_on_General_Information_page(DataTable generalInfoTable) throws Throwable {
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		
		Assert.assertTrue(generalInfoPage.verifyClientDetails(addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL, addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID), generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyPolicyName(addNewPolicyPage.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL, addNewPolicyPage.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));
		
		generalInfoPage.enterGeneralInformationFields(generalInfoTable);
	}

	@Then("^all the available benefit categories should be displayed on the \"([^\"]*)\" page$")
	public void all_the_available_benefit_categories_should_be_displayed_on_the_page(String policyBenefitPage) {
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(policyBenefitPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, PDTConstants.POLICY_BENEFIT_CATEGORIES,
						policyBenefitPage, policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoriesAreDisplayed(policyBenefitPage),
				MessageFormat.format(PDTConstants.BENEFIT_CATEGORIES_NOT_DISPLAYED, CoreConstants.FAIL, policyBenefitPage));
	}
	
	@Given("^he has selected below information on 'General Information' page followed by selection of \"([^\"]*)\" as Benefit Category on \"([^\"]*)\" page$")
	public void he_has_selected_below_information_on_General_Information_page_followed_by_selection_of_as_Benefit_Category_on_page(String benefitCategory, String policyBenefitPage, DataTable generalInfoTable) {
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		
		Assert.assertTrue(generalInfoPage.verifyClientDetails(addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL, addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID), generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyPolicyName(addNewPolicyPage.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL, addNewPolicyPage.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));
		
		generalInfoPage.enterGeneralInformationFields(generalInfoTable);
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(policyBenefitPage),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL, PDTConstants.heading, PDTConstants.POLICY_BENEFIT_CATEGORIES, policyBenefitPage, PDTConstants.POLICY_BENEFIT_CATEGORIES,
						PDTConstants.heading, policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		policyBenefitCategoryPage.selectPolicyBenefitCategory(benefitCategory);
	}

	@Given("^sub benefit category form should appear after selecting below categories on \"([^\"]*)\" page$")
	public void sub_benefit_category_form_should_appear_after_selecting_below_categories_on_page(String pageName, DataTable subBenefitTable) {
		Assert.assertTrue(preAcceptanceServicePage.verifySubCategoryHeading(pageName),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL, PDTConstants.heading, pageName,
						pageName, pageName, preAcceptanceServicePage.getElementText(PDTConstants.HEADING)));
		preAcceptanceServicePage.selectSubBenefitAndVerifyFormIsDisplayed(subBenefitTable, pageName);
	}

	@When("^he unchecks the below sub benefit categories  on \"([^\"]*)\" page$")
	public void he_uncheck_the_below_sub_benefit_categories_on_page(String pageName, DataTable subBenefitTable) {
		preAcceptanceServicePage.deselectSubBenefit(subBenefitTable, pageName);
	}
	
	@Then("^below sub benefit categories form should disappear from  \"([^\"]*)\" page$")
	public void below_sub_benefit_categories_form_should_disappear_from_page(String pageName, DataTable subBenefitTable) {
		preAcceptanceServicePage.checkFormIsHidden(subBenefitTable, pageName);
	}
}
