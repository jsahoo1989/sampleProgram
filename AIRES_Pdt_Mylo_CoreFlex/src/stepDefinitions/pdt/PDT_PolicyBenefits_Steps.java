package stepDefinitions.pdt;
import java.text.MessageFormat;
import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.pdt.PDT_PolicyBenefitCategoryPage;
import cucumber.api.java.en.Then;

public class PDT_PolicyBenefits_Steps {
	private TestContext testContext;
	private PDT_PolicyBenefitCategoryPage policyBenefitCategoryPage;
		
	public PDT_PolicyBenefits_Steps(TestContext context) {
		testContext = context;
		policyBenefitCategoryPage = testContext.getPageObjectManager().getpolicyBenefitCategoryPage();		
	}
	
	@Then("^all the available benefit categories should be displayed on the \"([^\"]*)\" page$")
	public void all_the_available_benefit_categories_should_be_displayed_on_the_page(String policyBenefitPage) {
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(policyBenefitPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, PDTConstants.POLICY_BENEFIT_CATEGORIES,
						policyBenefitPage, policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoriesAreDisplayed(policyBenefitPage),
				MessageFormat.format(PDTConstants.BENEFIT_CATEGORIES_NOT_DISPLAYED, CoreConstants.FAIL, policyBenefitPage));
	}
}
