package stepDefinitions.pdt;

import java.text.MessageFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.managers.PageObjectManager_MobilityX;
import com.aires.managers.PageObjectManager_Pdt;
import com.aires.managers.WebDriverManager;
import com.aires.pages.PDT_Mylo_CoreFlex_Common_LoginPage;
import com.aires.pages.mobilityx.MobilityX_DashboardHomePage;
import com.aires.pages.mobilityx.MobilityX_LoginPage;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_CulturalTrainingPage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_PolicyAssignmentPage;
import com.aires.pages.pdt.PDT_PolicyBenefitCategoryPage;
import com.aires.pages.pdt.PDT_SharedSubBenefitPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;

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
	private MobilityX_LoginPage _loginPage;
	private WebDriverManager _webDriverManager;
	private PageObjectManager_MobilityX _pageObjectManager;
	private MobilityX_DashboardHomePage _dashboardHomePage;
	private PDT_Mylo_CoreFlex_Common_LoginPage _pdtMyloCommonLoginPage;
	private PDT_PolicyAssignmentPage _policyAssignmentPage;
	private PageObjectManager_Pdt _pageObjectManagerPDT;
	private PDT_CulturalTrainingPage _culturalTrainingPage;
	LinkedHashMap<String, String> subBenefitMap = new LinkedHashMap<String, String>();

	long timeBeforeAction, timeAfterAction;
	/*private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader()
			.getLoginByApplication(CoreFunctions.getPropertyFromConfig("application").toLowerCase());*/
	private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader()
			.getLoginByApplication(System.getProperty("application").toLowerCase());

	public void populateSubBenefitMap() {
		subBenefitMap.put(PDTConstants.LANG_TRAINING,
				PDTConstants.LANGUAGE_TRAINING_EMPLOYEE + ", " + PDTConstants.LANGUAGE_TRAINING_FAMILY);
	}

	public PDT_ApprovePolicyVersioning_Steps(TestContext context) {
		testContext = context;
		viewPolicyPage = testContext.getPageObjectManager().getViewPolicyPage();
		addNewPolicyPage = testContext.getPageObjectManager().getAddNewPolicyPage();
		subBenefitPage = testContext.getPageObjectManager().getSharedSubBenefitPage();
		policyBenefitCategoryPage = testContext.getPageObjectManager().getpolicyBenefitCategoryPage();
		generalInfoPage = testContext.getPageObjectManager().getGeneralInfoPage();
		_pdtMyloCommonLoginPage = testContext.getPageObjectManager().getCommonLoginPage();
		_policyAssignmentPage = testContext.getPageObjectManager().getPolicyAssignmentPage();
		_culturalTrainingPage = testContext.getPageObjectManager().getCulturalTrainingPage();

	}

	@When("^he clicks on the 'OK' button of success message \"([^\"]*)\" displayed on the \"([^\"]*)\" page$")
	public void he_clicks_on_the_OK_button_of_success_message_displayed_on_the_page(String successMsg,
			String pageName) {
		subBenefitPage.verifySaveSuccessMessage(successMsg, pageName, addNewPolicyPage);
	}

	@Then("^\"([^\"]*)\" button should become visible on the 'Policy Benefit' page$")
	public void button_should_become_visible(String btnName) {
		Assert.assertTrue(
				subBenefitPage.verifyStatusAndVersionOfPolicy(addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(),
						PDTConstants.STATUS_SUBMITTED, PDTConstants.VERSION_V1, PDTConstants.POLICY_BENEFIT));

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
	public void he_is_on_the_page_after_selecting_as_Benefit_Category(String policyBenefitPage, String benefitCategory)
			throws Throwable {
		String pageName = PDTConstants.ADD_NEW_POLICY_FORM.substring(0,
				PDTConstants.ADD_NEW_POLICY_FORM.indexOf("Form") - 1);
		timeBeforeAction = new Date().getTime();
		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName);
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(pageName),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, pageName,
						PDTConstants.ADD_NEW_POLICY_FORM, addNewPolicyPage.getElementText(PDTConstants.HEADING)));
		addNewPolicyPage.enterClientPolicyDetails();
		generalInfoPage.explicitWaitForGeneralInfoHeading();

		Assert.assertTrue(
				generalInfoPage.verifyClientDetails(addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL,
						addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID),
						generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));

		Assert.assertTrue(generalInfoPage.verifyPolicyName(addNewPolicyPage.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL,
						addNewPolicyPage.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));

		generalInfoPage.enterGeneralInformationFields();
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(policyBenefitPage),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL,
						PDTConstants.heading, PDTConstants.POLICY_BENEFIT_CATEGORIES, policyBenefitPage,
						policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		policyBenefitCategoryPage.selectPolicyBenefitCategory(benefitCategory);
	}

	@When("^he clicks on 'Approve Policy' button after verifying status \"([^\"]*)\" on header section of \"([^\"]*)\" page$")
	public void he_clicks_on_Approve_Policy_button_after_verifying_success_message_on_page(String policyStatus,
			String pageName) {
		Assert.assertTrue(
				subBenefitPage.verifyStatusAndVersionOfPolicy(addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(),
						policyStatus, PDTConstants.VERSION_V1, pageName));
		subBenefitPage.clickElementOfPage(PDTConstants.BTN_APPROVE_POLICY, pageName);
	}

	@Then("^below information should be displayed on 'Approve Policy' Pop-up$")
	public void below_information_should_be_displayed_on_Approve_Policy_Pop_up(DataTable popUpInfo) {
		List<List<String>> data = popUpInfo.raw();
		String[] chkBoxExistAuth = data.get(3).get(1).split("_");
		String[] chkBoxNewAuth = data.get(4).get(1).split("_");
		String[] buttonsArr = data.get(5).get(1).split(", ");
		String[] buttonApprove = buttonsArr[0].split("_");
		String[] buttonCancel = buttonsArr[1].split("_");
		subBenefitPage.verifyHeadingAndMsgOfPopUp(data);
		Assert.assertTrue(
				subBenefitPage.verifyCheckBoxAndMsg(data.get(3).get(0).substring(0, data.get(3).get(0).length() - 1),
						chkBoxExistAuth[0], chkBoxExistAuth[1]),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CHECKBOX, chkBoxExistAuth[0], chkBoxExistAuth[1]));
		Assert.assertTrue(
				subBenefitPage.verifyCheckBoxAndMsg(data.get(4).get(0).substring(0, data.get(4).get(0).length() - 1),
						chkBoxNewAuth[0], chkBoxNewAuth[1]),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CHECKBOX, CoreConstants.FAIL, chkBoxNewAuth[0],
						chkBoxNewAuth[1]));
		Assert.assertTrue(subBenefitPage.verifyButton(buttonApprove[0], buttonApprove[1]),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, buttonApprove[0], buttonApprove[1]));
		Assert.assertTrue(subBenefitPage.verifyButton(buttonCancel[0], buttonCancel[1]),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, buttonCancel[0], buttonCancel[1]));

	}

	@When("^he selects the checkbox having label 'Associate this policy with a NEW authorization in IRIS\\?' on 'Approve Policy' pop-up$")
	public void he_selects_the_checkbox_having_label_Associate_this_policy_with_a_NEW_authorization_in_IRIS_on_Approve_Policy_pop_up() {
		subBenefitPage.clickAssociateWithNewAuth();
	}

	@Then("^\"([^\"]*)\" button should become \"([^\"]*)\" on 'Approve Policy' pop-up$")
	public void button_should_become_on_Approve_Policy_pop_up(String btnName, String buttonState) {
		Assert.assertTrue(subBenefitPage.verifyButton(btnName, buttonState),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, btnName, buttonState));
	}

	@When("^he clicks on \"([^\"]*)\" button on 'Approve Policy' pop-up on \"([^\"]*)\" page$")
	public void he_clicks_on_button_on_Approve_Policy_pop_up_on_Policy_Benefit_page(String btnName, String pageName) {
		subBenefitPage.clickButtonOnApprovePolicyPopUp(btnName, pageName);
	}

	@Then("^Version \"([^\"]*)\" of Policy should be displayed on \"([^\"]*)\" page with \"([^\"]*)\" status$")
	public void version_of_Policy_should_be_displayed_on_View_Edit_Policy_Forms_page_with_status(String versionNo,
			String pageName, String policyStatus) {
		Assert.assertTrue(viewPolicyPage.verifyPolicyStatusWithVersion(
				addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(), policyStatus, versionNo, pageName));
	}

	@Then("^Status of Policy should remain \"([^\"]*)\" with Version \"([^\"]*)\" on \"([^\"]*)\" Page$")
	public void status_of_Policy_should_remain_with_Version_on_Policy_Benefit_Page(String policyStatus,
			String policyVersion, String pageName) {
		Assert.assertTrue(subBenefitPage.verifyStatusAndVersionOfPolicy(
				addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(), policyStatus, policyVersion, pageName));
	}

	@Given("^he is on the \"([^\"]*)\" page after approving a policy with below sub-benefits of \"([^\"]*)\" Benefit Category;$")
	public void he_is_on_the_page_after_approving_a_policy_with_below_sub_benefits_of_Benefit_Category(
			String viewEditPolicyPage, String benefitCategory, DataTable subBenefitTable) {
		String pageName = PDTConstants.ADD_NEW_POLICY_FORM.substring(0,
				PDTConstants.ADD_NEW_POLICY_FORM.indexOf("Form") - 1);
		timeBeforeAction = new Date().getTime();
		viewPolicyPage.clickElementOfPage(PDTConstants.ADD_NEW_POLICY_FORM);
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName);
		Assert.assertTrue(addNewPolicyPage.verifyAddNewPolicyHeading(pageName),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, pageName,
						PDTConstants.ADD_NEW_POLICY_FORM, addNewPolicyPage.getElementText(PDTConstants.HEADING)));
		addNewPolicyPage.enterClientPolicyDetails();
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		Assert.assertTrue(
				generalInfoPage.verifyClientDetails(addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL,
						addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID),
						generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));

		Assert.assertTrue(generalInfoPage.verifyPolicyName(addNewPolicyPage.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL,
						addNewPolicyPage.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));

		generalInfoPage.enterGeneralInformationFields();
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(PDTConstants.POLICY_BENEFIT),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL,
						PDTConstants.heading, PDTConstants.POLICY_BENEFIT_CATEGORIES, PDTConstants.POLICY_BENEFIT,
						policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		policyBenefitCategoryPage.selectPolicyBenefitCategory(benefitCategory);

		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
		List<String> subBenefits = subBenefitTable.asList(String.class);
		subBenefitPage.verifySelectedPolicyBenefitCategoryName(benefitCategory);
		subBenefitPage.verifySubBenefitCategoriesAreDisplayed(subBenefits, benefitCategory);
		subBenefitPage.iterateAndSelectSubBenefits(benefitCategory, subBenefits, addNewPolicyPage, objStep,
				PDTConstants.PDT_BTN_SAVE_SUBMIT);
		Assert.assertTrue(
				subBenefitPage.verifyStatusAndVersionOfPolicy(addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(),
						PDTConstants.STATUS_SUBMITTED, PDTConstants.VERSION_V1, PDTConstants.POLICY_BENEFIT));

		subBenefitPage.clickElementOfPage(PDTConstants.BTN_APPROVE_POLICY, PDTConstants.POLICY_BENEFIT);

		subBenefitPage.clickAssociateWithNewAuth();
		subBenefitPage.clickButtonOnApprovePolicyPopUp(PDTConstants.BTN_APPROVE, PDTConstants.POLICY_BENEFIT);
		Assert.assertTrue(
				viewPolicyPage.verifyPolicyStatusWithVersion(addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(),
						PDTConstants.STATUS_ACTIVE, PDTConstants.VERSION_V1, pageName));
		_pdtMyloCommonLoginPage.logoutFromPDTApplication();
	}

	@Given("^he has submitted a new authorization form in MobilityX application using template \"([^\"]*)\"$")
	public void he_has_submitted_a_new_authorization_form_in_MobilityX_application_using_template(String template) {
		_webDriverManager = new WebDriverManager();
		_pageObjectManager = new PageObjectManager_MobilityX(_webDriverManager.getDriver());
		_webDriverManager.getDriver().navigate().to(BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[3]);
		_loginPage = _pageObjectManager.getLoginPage();
		_loginPage.openApplication();
		_loginPage.enterUsernameAndPasswordForMobilityX(
				BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[4],
				BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[5]);
		_loginPage.clickSignIn();

		_loginPage.handle_Cookie_AfterLogin();
		Assert.assertTrue(_loginPage.verifyUserlogin(BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[6]),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FIRST_AND_LAST_NAME, CoreConstants.FAIL,
						BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[6],
						MobilityXConstants.HOME_PAGE));

		_dashboardHomePage = _pageObjectManager.getDashboardHomePage();
		_dashboardHomePage.enterEmpFirstAndLastNameForNewAuthorization();
		_dashboardHomePage.selectAuthorizationOptionForEmployee(MobilityXConstants.NEW_TRANSFER_ASSIGNMENT);
		MobilityX_AuthorizationData authorizationData = FileReaderManager.getInstance().getJsonReader()
				.getDataByModuleName("Authorization");
		_dashboardHomePage.fillAuthFormBasedOnTemplate(authorizationData, template);
		CoreFunctions.waitHandler(8);
		Assert.assertTrue(_dashboardHomePage.verifySuccessDialogDisplayed(),
				MobilityXConstants.SUCCESS_DIALOG + MobilityXConstants.IS_NOT_DISPLAYED);
		_dashboardHomePage.logout();
		_webDriverManager.getDriver().close();
	}

	@When("^he clicks on \"([^\"]*)\" icon on \"([^\"]*)\" page of 'PDT' application for the newly created Active policy$")
	public void he_clicks_on_Assignment_History_icon_on_page_for_the_newly_created_Active_policy(String iconName,
			String pageName) {
		_webDriverManager = new WebDriverManager();
		_webDriverManager.getDriver().navigate()
				.to(FileReaderManager.getInstance().getConfigReader().getPDTApplicationUrl());
		_pageObjectManagerPDT = new PageObjectManager_Pdt(_webDriverManager.getDriver());
		_pdtMyloCommonLoginPage = _pageObjectManagerPDT.getCommonLoginPage();
		viewPolicyPage = _pageObjectManagerPDT.getViewPolicyPage();
		Assert.assertTrue(_pdtMyloCommonLoginPage.loginByUserType(PDTConstants.CSM, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));
		viewPolicyPage.searchByPolicyName(iconName, addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(), pageName);
	}

	@Then("^Assignment details should be displayed in 'Assignment History' Page$")
	public void assignment_details_should_be_displayed_in_Assignment_History_Page() {
		_policyAssignmentPage = _pageObjectManagerPDT.getPolicyAssignmentPage();
		Assert.assertTrue(_policyAssignmentPage.verifyAssignmentInfo(),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ASSIGNMENT_DETAILS, CoreConstants.FAIL));
	}

	@Then("^below information should be displayed in the pop-up$")
	public void below_information_should_be_displayed_in_the_pop_up(DataTable popUpInfo) {
		List<List<String>> data = popUpInfo.raw();
		String[] buttonsArr = data.get(4).get(1).split(", ");
		String[] buttonApprove = buttonsArr[0].split("_");
		String[] buttonCancel = buttonsArr[1].split("_");
		viewPolicyPage.contentsOfPopUp(data);
		Assert.assertTrue(viewPolicyPage.verifyButton(buttonApprove[0], buttonApprove[1]),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, buttonApprove[0], buttonApprove[1]));
		Assert.assertTrue(viewPolicyPage.verifyButton(buttonCancel[0], buttonCancel[1]),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, buttonCancel[0], buttonCancel[1]));
	}

	@Then("^\"([^\"]*)\" button becomes \"([^\"]*)\" after entering text on Description textbox$")
	public void create_button_becomes_enabled_after_entering_text_on_Description_textbox(String btnName,
			String btnStatus) {
		Assert.assertTrue(viewPolicyPage.enterDescriptionAndVerifyCreateBtn(btnName, btnStatus),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, btnName, btnStatus));
	}

	@Given("^he has navigated to 'General Information page' of PDT application followed by selection of \"([^\"]*)\" as Benefit Category on \"([^\"]*)\" page after clicking on \"([^\"]*)\" icon on \"([^\"]*)\" page$")
	public void he_has_navigated_to_General_Information_page_of_PDT_application_followed_by_selection_of_as_Benefit_Category_on_page_after_clicking_on_icon_on_page(
			String benefitCategoryName, String policyBenefitPage, String editIcon, String viewEditPolicyPage)
			throws Throwable {
		_webDriverManager = new WebDriverManager();
		_webDriverManager.getDriver().navigate()
				.to(FileReaderManager.getInstance().getConfigReader().getPDTApplicationUrl());
		_pageObjectManagerPDT = new PageObjectManager_Pdt(_webDriverManager.getDriver());
		_pdtMyloCommonLoginPage = _pageObjectManagerPDT.getCommonLoginPage();
		viewPolicyPage = _pageObjectManagerPDT.getViewPolicyPage();
		Assert.assertTrue(_pdtMyloCommonLoginPage.loginByUserType(PDTConstants.CSM, viewPolicyPage),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_LOGGED_IN_USER, CoreConstants.FAIL));
		viewPolicyPage.searchByPolicyName(editIcon, addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(),
				viewEditPolicyPage);

		String[] buttonsArr = PDTConstants.BUTTONS_STATE.split(", ");
		String[] buttonApprove = buttonsArr[0].split("_");
		String[] buttonCancel = buttonsArr[1].split("_");
		viewPolicyPage.contentsOfPopUp();
		Assert.assertTrue(viewPolicyPage.verifyButton(buttonApprove[0], buttonApprove[1]),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, buttonApprove[0], buttonApprove[1]));
		Assert.assertTrue(viewPolicyPage.verifyButton(buttonCancel[0], buttonCancel[1]),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, buttonCancel[0], buttonCancel[1]));
		viewPolicyPage.enterDescription();
		generalInfoPage = _pageObjectManagerPDT.getGeneralInfoPage();
		generalInfoPage.explicitWaitForGeneralInfoHeading();
		Assert.assertTrue(
				generalInfoPage.verifyClientDetails(addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CLIENT_DETAILS, CoreConstants.FAIL,
						addNewPolicyPage.getClientId(), addNewPolicyPage.getClientName(),
						generalInfoPage.getElementText(PDTConstants.CLIENT_ID),
						generalInfoPage.getElementText(PDTConstants.CLIENT_NAME)));

		Assert.assertTrue(generalInfoPage.verifyPolicyName(addNewPolicyPage.getPolicyName()),
				MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_NAME, CoreConstants.FAIL,
						addNewPolicyPage.getPolicyName(), generalInfoPage.getElementText(PDTConstants.POLICY_NAME)));
		generalInfoPage.navigatePolicyBenefitPage(PDTConstants.POLICY_BENEFIT);
		policyBenefitCategoryPage = _pageObjectManagerPDT.getpolicyBenefitCategoryPage();
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(policyBenefitPage),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL,
						PDTConstants.heading, PDTConstants.POLICY_BENEFIT_CATEGORIES, policyBenefitPage,
						policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		policyBenefitCategoryPage.selectPolicyBenefitCategory(benefitCategoryName);
	}

	@Given("^he has submitted the mandatory information for \"([^\"]*)\" sub-benefit forms$")
	public void he_has_submitted_the_mandatory_information_for_sub_benefit_forms(String benefitCategory)
			throws Throwable {
		/********************************************/
		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
		objStep.initPageObjectMan(_pageObjectManagerPDT);
		List<String> subBenefits = BusinessFunctions.getSubBenefitList(benefitCategory);
		subBenefitPage = _pageObjectManagerPDT.getSharedSubBenefitPage();
		subBenefitPage.navigateBenefitCategories(benefitCategory);
		subBenefitPage.verifySelectedPolicyBenefitCategoryName(benefitCategory);
		subBenefitPage.verifySubBenefitCategoriesAreDisplayed(subBenefits, benefitCategory);
		subBenefitPage.iterateAndSelectSubBenefits(benefitCategory, subBenefits, addNewPolicyPage, objStep,
				PDTConstants.PDT_BTN_SAVE_SUBMIT);
	}

	@When("^he approves the policy after selecting the checkbox having label 'Associate this policy with a NEW authorization in IRIS\\?' on 'Approve Policy' pop-up with Default Date on \"([^\"]*)\" page$")
	public void he_approves_the_policy_after_selecting_the_checkbox_having_label_Associate_this_policy_with_a_NEW_authorization_in_IRIS_on_Approve_Policy_pop_up_with_Default_Date(
			String pageName) throws Throwable {
		Assert.assertTrue(
				subBenefitPage.verifyStatusAndVersionOfPolicy(addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(),
						PDTConstants.STATUS_SUBMITTED, PDTConstants.VERSION_NUM_V2, PDTConstants.POLICY_BENEFIT));
		subBenefitPage.clickElementOfPage(PDTConstants.BTN_APPROVE_POLICY, PDTConstants.POLICY_BENEFIT);
		subBenefitPage.clickAssociateWithNewAuth();
		subBenefitPage.clickButtonOnApprovePolicyPopUp(PDTConstants.BTN_APPROVE, PDTConstants.POLICY_BENEFIT);
	}

	@Then("^both versions \"([^\"]*)\" of Policy should be displayed on \"([^\"]*)\" Policy Forms with below information$")
	public void both_versions_of_Policy_should_be_displayed_on_Policy_Forms_with_below_information(String versionInfo,
			String pageName, DataTable policyInfoTable) throws Throwable {
		_policyAssignmentPage = _pageObjectManagerPDT.getPolicyAssignmentPage();
		String policyName = addNewPolicyPage.getPolicyName().split("\\(#")[0].trim();
		List<Map<String, String>> policyInfo = policyInfoTable.asMaps(String.class, String.class);
		for (int i = 0; i < policyInfo.size(); i++) {
			viewPolicyPage.waitForProgressBarToDisapper();
			viewPolicyPage.populateIconMap();
			viewPolicyPage.enterPolicyName(policyName);
			viewPolicyPage.waitForProgressBarToDisapper();
			Assert.assertTrue(
					viewPolicyPage.searchAndVerifyPolicyByNameVersionStatus(policyName, policyInfo.get(i).get("Status"),
							policyInfo.get(i).get("Version"), pageName),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_VER_STATUS, CoreConstants.FAIL,
							policyName, policyInfo.get(i).get("Status"), policyInfo.get(i).get("Version"), pageName));
			viewPolicyPage.iterateAndVerifyIcons(policyInfo.get(i).get("EnabledIcon"), "Enabled", pageName);
			viewPolicyPage.navigateAssignmentHistoryPage(_policyAssignmentPage);
			Assert.assertTrue(viewPolicyPage.verifyAssignmentLinkedCount(policyName, Integer.parseInt(policyInfo.get(i).get("Assignments_Linked")), _policyAssignmentPage), MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ASSIGNMENT_LINKED_COUNT, CoreConstants.FAIL,
					Integer.parseInt(policyInfo.get(i).get("Assignments_Linked")), _policyAssignmentPage.getTransfereeCount()));
			_policyAssignmentPage.exitAssignmentTransfereePage();
			viewPolicyPage.iterateAndVerifyIcons(policyInfo.get(i).get("DisabledIcon"), "Disabled", pageName);
		}
	}
	
	@When("^he approves the policy after selecting selecting the checkbox having label 'Associate this policy with an existing authorization in IRIS\\?' on 'Approve Policy' pop-up with Default Date$")
	public void he_approves_the_policy_after_selecting_selecting_the_checkbox_having_label_Associate_this_policy_with_an_existing_authorization_in_IRIS_on_Approve_Policy_pop_up_with_Default_Date() throws Throwable {
		Assert.assertTrue(
				subBenefitPage.verifyStatusAndVersionOfPolicy(addNewPolicyPage.getPolicyName().split("\\(#")[0].trim(),
						PDTConstants.STATUS_SUBMITTED, PDTConstants.VERSION_NUM_V2, PDTConstants.POLICY_BENEFIT));

		subBenefitPage.clickElementOfPage(PDTConstants.BTN_APPROVE_POLICY, PDTConstants.POLICY_BENEFIT);
		subBenefitPage.clickAssociateWithExistingAuth();
		subBenefitPage.clickButtonOnApprovePolicyPopUp(PDTConstants.BTN_APPROVE, PDTConstants.POLICY_BENEFIT);
	}
}
