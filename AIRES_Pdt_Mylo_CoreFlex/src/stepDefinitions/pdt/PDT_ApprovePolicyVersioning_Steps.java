package stepDefinitions.pdt;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

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

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDT_ApprovePolicyVersioning_Steps {
	private TestContext testContext;
	private PDT_ViewPolicyPage viewPolicyPage;
	private PDT_AddNewPolicyPage addNewPolicyPage;
	private PDT_SharedSubBenefitPage subBenefitPage;
	private PDT_PolicyBenefitCategoryPage policyBenefitCategoryPage;
	private PDT_GeneralInformationPage generalInfoPage;
	long timeBeforeAction, timeAfterAction;
	
	public PDT_ApprovePolicyVersioning_Steps(TestContext context) {
		testContext = context;
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		subBenefitPage = testContext.getPageObjectManager().getSharedSubBenefitPage();
		policyBenefitCategoryPage = testContext.getPageObjectManager().getpolicyBenefitCategoryPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();
	}

	@When("^he clicks on the 'OK' button of success message \"([^\"]*)\" displayed on the \"([^\"]*)\" page$")
	public void he_clicks_on_the_OK_button_of_success_message_displayed_on_the_page(String successMsg,
			String pageName) {
		subBenefitPage.verifySaveSuccessMessage(successMsg, pageName, addNewPolicyPage);
	}

	@Then("^\"([^\"]*)\" button should become visible on the 'Policy Benefit' page$")
	public void button_should_become_visible(String btnName) {
		Assert.assertTrue(subBenefitPage.verifyButtonVisible(btnName, policyBenefitCategoryPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_VISIBLE, CoreConstants.FAIL, btnName,
						policyBenefitCategoryPage.getBenefitCategoryName()));
	}

	@Then("^\"([^\"]*)\" button should become disabled on the 'Policy Benefit' page$")
	public void button_should_become_disabled(String btnName) {
		Assert.assertTrue(subBenefitPage.verifyButtonDisabled(btnName, policyBenefitCategoryPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_DISABLED, CoreConstants.FAIL, btnName,
						policyBenefitCategoryPage.getBenefitCategoryName()));
	}
	
	@Given("^he is on the \"([^\"]*)\" Policy Benefit page$")
	public void he_is_on_the_Policy_Benefit_page(String arg1) {
	
	}
	
	@Given("^he is on the \"([^\"]*)\" page after selecting \"([^\"]*)\" as Benefit Category;$")
	public void he_is_on_the_page_after_selecting_as_Benefit_Category(String policyBenefitPage, String benefitCategory) throws Throwable {
		String pageName = PDTConstants.ADD_NEW_POLICY_FORM.substring(0, PDTConstants.ADD_NEW_POLICY_FORM.indexOf("Form")-1);
		timeBeforeAction = new Date().getTime();
		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName);
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(pageName),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, pageName,
						PDTConstants.ADD_NEW_POLICY_FORM, addNewPolicyPage.getElementText(PDTConstants.HEADING)));
		addNewPolicyPage.enterClientPolicyDetails();
		
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		
		Assert.assertTrue(generalInfoPage.verifyClientDetails(addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL, addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID), generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));
		
		Assert.assertTrue(generalInfoPage.verifyPolicyName(addNewPolicyPage.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL, addNewPolicyPage.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));
		
		generalInfoPage.enterGeneralInformationFields();
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(policyBenefitPage),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL, PDTConstants.heading, PDTConstants.POLICY_BENEFIT_CATEGORIES, policyBenefitPage, policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		policyBenefitCategoryPage.selectPolicyBenefitCategory(benefitCategory);
	}

	@When("^he clicks on 'Approve Policy' button after verifying success message \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void he_clicks_on_Approve_Policy_button_after_verifying_success_message_on_page(String successMsg, String pageName) {
		Assert.assertTrue(subBenefitPage.verifySaveSuccessMessage(successMsg, pageName, addNewPolicyPage), MessageFormat
				.format(PDTConstants.FAILED_TO_VERIFY_SUCCESS_MSG, CoreConstants.FAIL, successMsg, pageName));
		subBenefitPage.clickElementOfPage(PDTConstants.BTN_APPROVE_POLICY, pageName);
	}

	@Then("^below information should be displayed on 'Approve Policy' Pop-up$")
	public void below_information_should_be_displayed_on_Approve_Policy_Pop_up(DataTable popUpInfo) {
		List<List<String>> data =  popUpInfo.raw();		
		String [] chkBoxExistAuth = data.get(3).get(1).split("_");
		String [] chkBoxNewAuth = data.get(4).get(1).split("_");
		String [] buttonsArr = data.get(5).get(1).split(", ");
		String [] buttonApprove =  buttonsArr[0].split("_");
		String [] buttonCancel =  buttonsArr[1].split("_");
		subBenefitPage.verifyHeadingAndMsgOfPopUp(data);
		Assert.assertTrue(subBenefitPage.verifyCheckBoxAndMsg(data.get(3).get(0).substring(0, data.get(3).get(0).length()-1), chkBoxExistAuth[0], chkBoxExistAuth[1]), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CHECKBOX, chkBoxExistAuth[0], chkBoxExistAuth[1]));
		Assert.assertTrue(subBenefitPage.verifyCheckBoxAndMsg(data.get(4).get(0).substring(0, data.get(4).get(0).length()-1), chkBoxNewAuth[0], chkBoxNewAuth[1]), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CHECKBOX, CoreConstants.FAIL, chkBoxNewAuth[0], chkBoxNewAuth[1]));
		Assert.assertTrue(subBenefitPage.verifyButton(buttonApprove[0], buttonApprove[1]), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, buttonApprove[0], buttonApprove[1]));
		Assert.assertTrue(subBenefitPage.verifyButton(buttonCancel[0], buttonCancel[1]), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, buttonCancel[0], buttonCancel[1]));
		
	}
	
	@When("^he selects the checkbox having label 'Associate this policy with a NEW authorization in IRIS\\?' on 'Approve Policy' pop-up$")
	public void he_selects_the_checkbox_having_label_Associate_this_policy_with_a_NEW_authorization_in_IRIS_on_Approve_Policy_pop_up() {
		subBenefitPage.clickAssociateWithNewAuth();
	}

	@Then("^\"([^\"]*)\" button should become \"([^\"]*)\" on 'Approve Policy' pop-up$")
	public void button_should_become_on_Approve_Policy_pop_up(String btnName, String buttonState) {
		Assert.assertTrue(subBenefitPage.verifyButton(btnName, buttonState), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, btnName, buttonState));
	}
	
	@When("^he clicks on \"([^\"]*)\" button on 'Approve Policy' pop-up on \"([^\"]*)\" page$")
	public void he_clicks_on_button_on_Approve_Policy_pop_up_on_Policy_Benefit_page(String btnName, String pageName) {
		subBenefitPage.clickButtonOnApprovePolicyPopUp(btnName, pageName);	    
	}

	@Then("^Version \"([^\"]*)\" of Policy should be displayed on \"([^\"]*)\" page with \"([^\"]*)\" status$")
	public void version_of_Policy_should_be_displayed_on_View_Edit_Policy_Forms_page_with_status(String versionNo, String pageName, String policyStatus) {
		Assert.assertTrue(viewPolicyPage.verifyPolicyStatusWithVersion(addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(), policyStatus, versionNo, pageName));	
	}
	
	@Then("^Status of Policy should remain \"([^\"]*)\" with Version \"([^\"]*)\" on \"([^\"]*)\" Page$")
	public void status_of_Policy_should_remain_with_Version_on_Policy_Benefit_Page(String policyStatus, String policyVersion, String pageName) {
		Assert.assertTrue(subBenefitPage.verifyStatusAndVersionOfCanceledPolicy(addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(), policyStatus, policyVersion, pageName));
	}

}
