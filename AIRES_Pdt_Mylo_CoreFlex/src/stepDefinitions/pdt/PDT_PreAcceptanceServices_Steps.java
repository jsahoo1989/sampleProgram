package stepDefinitions.pdt;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_PreAcceptanceService;
import com.aires.pages.pdt.PDT_ViewPolicyPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDT_PreAcceptanceServices_Steps {
	private TestContext testContext;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_AddNewPolicyPage addNewPolicyPage;
	private PDT_PreAcceptanceService preAcceptanceServicePage;

	public PDT_PreAcceptanceServices_Steps(TestContext context) {
		testContext = context;
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		preAcceptanceServicePage = testContext.getPageObjectManager().getPreAcceptanceServicePage();		
	}
	
	@Given("^sub benefit category form should appear after selecting below categories on \"([^\"]*)\" page$")
	public void sub_benefit_category_form_should_appear_after_selecting_below_categories_on_page(String pageName,
			DataTable subBenefitTable) {
		Assert.assertTrue(preAcceptanceServicePage.verifySubCategoryHeading(pageName),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL,
						PDTConstants.heading, pageName, pageName, pageName,
						preAcceptanceServicePage.getElementText(PDTConstants.HEADING, pageName)));
		preAcceptanceServicePage.selectSubBenefitAndVerifyFormIsDisplayed(subBenefitTable, pageName);
	}

	@When("^he unchecks the below sub benefit categories  on \"([^\"]*)\" page$")
	public void he_uncheck_the_below_sub_benefit_categories_on_page(String pageName, DataTable subBenefitTable) {
		preAcceptanceServicePage.deselectSubBenefit(subBenefitTable, pageName);
	}

	@Then("^below sub benefit categories form should disappear from  \"([^\"]*)\" page$")
	public void below_sub_benefit_categories_form_should_disappear_from_page(String pageName,
			DataTable subBenefitTable) {
		preAcceptanceServicePage.checkFormIsHidden(subBenefitTable, pageName);
		DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
	}
}
