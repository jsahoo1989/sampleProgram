package stepDefinitions.pdt;

import java.text.MessageFormat;
import java.util.List;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_PolicyBenefitCategoryPage;
import com.aires.utilities.ClientPolicyDetails;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDT_GeneralInfo_Steps {
	private TestContext testContext;	
	private PDT_AddNewPolicyPage addNewPolicyPage;
	private PDT_GeneralInformationPage generalInfoPage;
	private PDT_PolicyBenefitCategoryPage policyBenefitCategoryPage;		
	
	public PDT_GeneralInfo_Steps(TestContext context) {
		testContext = context;
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();		
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();		
		policyBenefitCategoryPage = testContext.getPageObjectManager().getpolicyBenefitCategoryPage();		
	}
	
	@Then("^by default \"([^\"]*)\" option should be selected for 'Core/Flex policy' drop down on \"([^\"]*)\" page$")
	public void by_default_option_should_be_selected_for_Core_Flex_policy_drop_down_on_page(String noOption, String generalInfoPageName) {
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		Assert.assertTrue(generalInfoPage.verifyClientDetails(ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL, ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID), generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyPolicyName(ClientPolicyDetails.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL, ClientPolicyDetails.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyCoreFlexPolicyField(noOption, generalInfoPageName),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DEFAULT_COREFLEX_POLICY, CoreConstants.FAIL, generalInfoPageName, noOption,
						generalInfoPage.getCoreFlexPolicyDefaultValue()));
	}
	
	@Then("^'Benefit Package Type' drop down should display below options$")
	public void Benefit_Package_Type_drop_down_should_display_below_options(DataTable benefitPackageTypeTable) {
		Assert.assertTrue(generalInfoPage.verifyBenefitPackageType(benefitPackageTypeTable),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BENEFIT_PACKAGE_TPE, CoreConstants.FAIL, generalInfoPage.getBenefitPackageTypeOptions(), benefitPackageTypeTable.asList(String.class).toString()));
	}
	
	@When("^he clicks on the 'Next' button after entering mandatory information on 'General Information' page$")
	public void he_clicks_on_the_Next_button_after_entering_mandatory_information_on_General_Information_page() {
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		
		Assert.assertTrue(generalInfoPage.verifyClientDetails(ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL, ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID), generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyPolicyName(ClientPolicyDetails.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL, ClientPolicyDetails.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));
		
		generalInfoPage.enterGeneralInformationFields();
	}
	
	@Given("^he has entered mandatory information on 'General Information' page followed by selection of \"([^\"]*)\" as Benefit Category on \"([^\"]*)\" page$")
	public void he_has_entered_mandatory_information_on_General_Information_page_followed_by_selection_of_as_Benefit_Category_on_page(String benefitCategory, String policyBenefitPage) {
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		//Use soft assert
		Assert.assertTrue(generalInfoPage.verifyClientDetails(ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL, ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID), generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyPolicyName(ClientPolicyDetails.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL, ClientPolicyDetails.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));
		
		generalInfoPage.enterGeneralInformationFields();
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(policyBenefitPage),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL, PDTConstants.heading, PDTConstants.POLICY_BENEFIT_CATEGORIES, policyBenefitPage, policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		policyBenefitCategoryPage.selectPolicyBenefitCategory(benefitCategory);
	}
	
	@Given("^he has selected below information for form fields on 'General Information' page followed by selection of \"([^\"]*)\" as Benefit Category on \"([^\"]*)\" page$")
	public void he_has_selected_below_information_for_form_fields_on_General_Information_page_followed_by_selection_of_as_Benefit_Category_on_page(String benefitCategory, String pageName, DataTable generalInfoTable) {
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		
		Assert.assertTrue(generalInfoPage.verifyClientDetails(ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL, ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID), generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyPolicyName(ClientPolicyDetails.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL, ClientPolicyDetails.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));
		
		generalInfoPage.enterGeneralInformationFields(generalInfoTable);
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(pageName),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL, PDTConstants.heading, PDTConstants.POLICY_BENEFIT_CATEGORIES, pageName, PDTConstants.POLICY_BENEFIT_CATEGORIES,
						PDTConstants.heading, policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		policyBenefitCategoryPage.selectPolicyBenefitCategory(benefitCategory);
	}
	
	@Given("^he has entered mandatory information on 'General Information' page with 'Expense Management client' as 'Yes' followed by selection of below categories on \"([^\"]*)\" page$")
	public void he_has_entered_mandatory_information_on_General_Information_page_with_Expense_Management_client_as_Yes_followed_by_selection_of_below_categories_on_page(String policyBenefitPage, DataTable tableBenefitCategories) {
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		//Use soft assert
		Assert.assertTrue(generalInfoPage.verifyClientDetails(ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL, ClientPolicyDetails.getClientId(), ClientPolicyDetails.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID), generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyPolicyName(ClientPolicyDetails.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL, ClientPolicyDetails.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));
		
		generalInfoPage.enterGeneralInformationFieldsWithExpenseCode();
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(policyBenefitPage),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL, PDTConstants.heading, PDTConstants.POLICY_BENEFIT_CATEGORIES, policyBenefitPage, policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		//policyBenefitCategoryPage.selectPolicyBenefitCategory(benefitCategory);
		
		List<String> benefitCategories = tableBenefitCategories.asList(String.class);
		policyBenefitCategoryPage.iterateBenefitList(benefitCategories);
	}
}
