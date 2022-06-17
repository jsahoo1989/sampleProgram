package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_CustomBundlesPage extends Base {

	public CoreFlex_CustomBundlesPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Submit Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')]")
	private WebElement _buttonSubmit;

	// Disabled Submit Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')][@disabled]")
	private WebElement _buttonSubmitDisabled;

	// Approve Policy Button
	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'APPROVE POLICY')]")
	private WebElement _buttonApprovePolicy;

	// Approve Button
	@FindBy(how = How.XPATH, using = "//app-approval-policy-modal//button/span[contains(text(),'APPROVE')]")
	private WebElement _buttonApprove;

	// Cancel Button
	@FindBy(how = How.XPATH, using = "//app-approval-policy-modal//button/span[contains(text(),'CANCEL')]")
	private WebElement _buttonCancelApproval;

	// Save & Submit Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Save & Submit')]")
	private WebElement _buttonSaveAndSubmit;

	// Back Button
	@FindBy(how = How.CSS, using = "button[class*='btn-back']")
	private WebElement _buttonBack;

	// Exit Button
	@FindBy(how = How.CSS, using = "button[class*='btn-exit']")
	private WebElement _buttonExit;

	// Logout Button
	@FindBy(how = How.XPATH, using = "//i[contains(text(),'exit_to_app')]")
	private WebElement _buttonLogout;

	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	// Policy Header
	@FindBy(how = How.CSS, using = "h4[class='card-title'] > b")
	private WebElement _headerPolicyInfo;

	// Page Header
	@FindBy(how = How.CSS, using = "div[class*='pcard-header'] > h4[class='card-title']")
	private WebElement _headerPage;

	// Left Navigation Active Tile
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']/li[contains(@class,'nav-item active')]//p")
	private WebElement _leftNavigationTitleActive;

	// Left Navigation Completed Sections
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[contains(@class,'nav-item')]//p")
	private List<WebElement> _leftNavigationTitleList;

	// Added New Custom Bundle Button
	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Add New Custom Bundle')]")
	private WebElement _buttonAddNewCustomBundle;

	// Bundle Name TextArea
	@FindBy(how = How.CSS, using = "*[formcontrolname='bundleName']")
	private WebElement _fieldBundleName;

	// Bundle List Select
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='benefitList']")
	private WebElement _selectBundleList;

	// Bundle List Select Options
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='benefitList']//div[@role='option']/span")
	private List<WebElement> _selectBundleListOptions;

	// Save Custom Bundle Button
	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Save Custom Bundle')]")
	private WebElement _buttonSaveCustomBundle;

	// Cancel Link
	@FindBy(how = How.CSS, using = "a[class='cancel-btn']")
	private WebElement _linkCancel;

	// Saved Custom Bundles Text
	@FindBy(how = How.XPATH, using = "//label/b[contains(text(),'Saved Custom Bundles')]")
	private WebElement _textSavedCustomBundles;

	// Saved Custom Bundles List
	@FindBy(how = How.CSS, using = "span[class='bundleName']")
	private List<WebElement> _textSavedCustomBundlesList;

	// Pop-Up Submit Status
	@FindBy(how = How.CSS, using = "h2[id='swal2-title']")
	private WebElement _popUpTextSubmitStatus;

	// Pop-Up Submit Message
	@FindBy(how = How.CSS, using = "div[id='swal2-content']")
	private WebElement _popUpTextSubmitMessage;

	// Pop-Up OK Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	private WebElement _popUpButtonOk;

	// Preview Transferee Experience Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Preview Transferee Experience')]")
	private WebElement _buttonPreviewTransfereeExp;

	// Approve This Policy Dialog Header
	@FindBy(how = How.CSS, using = "div.approve-header > p")
	private WebElement _popUpApprovePolicyHeader;

	// Approve This Policy Dialog Version Text
	@FindBy(how = How.CSS, using = "div.msg-1 > p")
	private WebElement _popUpApprovePolicyVersionText;

	// Approve This Policy Dialog Assignment Text
	@FindBy(how = How.CSS, using = "div.msg-2 > p")
	private WebElement _popUpApprovePolicyAssignmentText;

	// Approve This Policy Checkbox Selection
	@FindBy(how = How.CSS, using = "label.cbx-label")
	private WebElement _popUpApprovePolicyCheckBox;

	// Approve This Policy DefaultDate Selection
	@FindBy(how = How.CSS, using = "input[formcontrolname='newAuthDate']")
	private WebElement _popUpApprovePolicyDefaultAssignmentDate;

	// Policy Status
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Policy Status')]/parent::label/following-sibling::label")
	private WebElement _textPolicyStatus;

	// Policy Version
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Version Number')]/parent::label/following-sibling::label")
	private WebElement _textPolicyVersion;

	// Approve this Policy Dialog
	@FindBy(how = How.CSS, using = "app-approval-policy-modal")
	private WebElement _dialogApproveThisPolicy;

	/*********************************************************************/

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	/*********************************************************************/

	/**
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.CUSTOM_BUNDLES,
				expectedPageName, expectedPageName, true);
	}

	/**
	 * Method to get currently active Left Navigation Menu.
	 * 
	 * @return
	 */
	public String getLeftNavigationPageTitle() {
		try {
			return CoreFunctions.getElementText(driver, _leftNavigationTitleActive);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_FETCHING_LEFT_NAVIGATION_TITLE,
							CoreConstants.FAIL, e.getMessage()));
		}
		return null;
	}

	/**
	 * Generic Method to Click on an Element on a Page.
	 * 
	 * @param elementName
	 */
	public void clickElementOfPage(String elementName) {
		try {
			switch (elementName) {
			case COREFLEXConstants.LOGOUT:
				CoreFunctions.clickElement(driver, _buttonLogout);
				break;
			case COREFLEXConstants.SAVE_AND_SUBMIT:
				CoreFunctions.clickElement(driver, _buttonSaveAndSubmit);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.SUBMIT:
				CoreFunctions.clickElement(driver, _buttonSubmit);
				break;
			case COREFLEXConstants.APPROVE_POLICY:
				CoreFunctions.clickElement(driver, _buttonApprovePolicy);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.APPROVE:
				CoreFunctions.clickElement(driver, _buttonApprove);
				break;
			case COREFLEXConstants.CANCEL:
				CoreFunctions.clickElement(driver, _buttonCancelApproval);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.ASSOCIATE_THIS_POLICY:
				CoreFunctions.clickElement(driver, _popUpApprovePolicyCheckBox);
				break;
			case COREFLEXConstants.ADD_NEW_CUSTOM_BUNDLE:
				CoreFunctions.clickElement(driver, _buttonAddNewCustomBundle);
				break;
			case COREFLEXConstants.SAVE_CUSTOM_BUNDLE:
				CoreFunctions.clickUsingJS(driver, _buttonSaveCustomBundle, COREFLEXConstants.SAVE_CUSTOM_BUNDLE);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.OK:
				CoreFunctions.clickElement(driver, _popUpButtonOk);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.PREVIEW_TRANSFEREE_EXPERIENCE:
				CoreFunctions.clickElement(driver, _buttonPreviewTransfereeExp);
				break;
			case COREFLEXConstants.BACK:
				CoreFunctions.clickElement(driver, _buttonBack);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.EXIT:
				CoreFunctions.clickElement(driver, _buttonExit);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_AN_ELEMENT_OF_PAGE,
							CoreConstants.FAIL, elementName, e.getMessage()));
			throw new RuntimeException(e);
		}
	}

	/**
	 * Generic method to click on an Left Navigation Menu.
	 * 
	 * @param elementName
	 */
	public void clickLeftNavigationMenuOfPage(String elementName) {
		try {
			switch (elementName) {
			case COREFLEXConstants.GENERAL_INFORMATION:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.GENERAL_INFORMATION);
				break;
			case COREFLEXConstants.FLEX_POLICY_SETUP:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.FLEX_POLICY_SETUP);
				break;
			case COREFLEXConstants.POLICY_BENEFIT_CATEGORIES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.POLICY_BENEFIT_CATEGORIES);
				break;
			case COREFLEXConstants.DUPLICATE_HOUSING:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.DUPLICATE_HOUSING);
				break;
			case COREFLEXConstants.LUMP_SUM:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList, COREFLEXConstants.LUMP_SUM);
				break;
			case COREFLEXConstants.BENEFIT_SUMMARY:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.BENEFIT_SUMMARY);
				break;
			case COREFLEXConstants.CUSTOM_BUNDLES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.CUSTOM_BUNDLES);
				break;
			default:
				Assert.fail(PDTConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_LEFTNAVIGATION_ELEMENT_OF_PAGE,
					CoreConstants.FAIL, elementName, e.getMessage()));
			throw new RuntimeException(e);

		}
	}

	/**
	 * Method to Verify Policy Submit status and Message
	 * 
	 * @param submitStatusMessage
	 * @param policyName
	 * @return
	 */
	public boolean verifyPolicySubmitStatus(String expectedSubmitStatusMessage, String policyName) {
		boolean isPolicySubmitStatusVerified = false, isSubmitMessageVerified;
		String actualSubmitMessage = null;
		try {
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
			actualSubmitMessage = CoreFunctions.getElementText(driver, _popUpTextSubmitMessage);
			isSubmitMessageVerified = (expectedSubmitStatusMessage.replace("PolicyName", policyName))
					.equalsIgnoreCase(actualSubmitMessage);
			isPolicySubmitStatusVerified = CoreFunctions.getElementText(driver, _popUpTextSubmitStatus)
					.equals(COREFLEXConstants.SUCCESS) && isSubmitMessageVerified;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_SUBMIT_STATUS_AND_MESSAGE_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPolicySubmitStatusVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_SUBMIT_STATUS_AND_MESSAGE_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.PASS, actualSubmitMessage));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.POLICY_SUBMIT_STATUS_AND_MESSAGE_NOT_MATCHED_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, expectedSubmitStatusMessage, actualSubmitMessage));
		}
		return isPolicySubmitStatusVerified;
	}

	/**
	 * Method to iterate through DataTable List and Call Create New Custom Bundle
	 * 
	 * @param addNewCustomBundleButton
	 * @param policyType
	 * @param saveCustomBundleButton
	 * @param benefitType
	 * @return
	 */
	public boolean iterateAndAddNewCustomBundle(String addNewCustomBundleButton, String policyType,
			String saveCustomBundleButton) {
		try {
			List<String> bundleBenefitList = getBenefitList(policyType);
			if (policyType.equals(COREFLEXConstants.CORE)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.CANNOT_CREATE_CUSTOM_BUNDLE_FOR_CORE_BENEFIT_TYPE, CoreConstants.PASS));
				return true;
			}
			clickElementOfPage(addNewCustomBundleButton);
			if (createNewCustomBundle(policySetupPageData.customBundlesPage.customBundleName, bundleBenefitList,
					saveCustomBundleButton)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_ADDED_A_NEW_CUSTOM_BUNDLE_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.PASS, policySetupPageData.customBundlesPage.customBundleName));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_ADDING_A_NEW_CUSTOM_BUNDLE_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	/**
	 * Method to create a new Custom Bundle
	 * 
	 * @param bundleName
	 * @param bundleBenefitList
	 * @param saveCustomBundleButton
	 * @return
	 */
	private boolean createNewCustomBundle(String bundleName, List<String> bundleBenefitList,
			String saveCustomBundleButton) {
		CoreFunctions.clearAndSetText(driver, _fieldBundleName, bundleName);
		for (String benefit : bundleBenefitList) {
			CoreFunctions.clickElement(driver, _selectBundleList);
			CoreFunctions.selectItemInListByText(driver, _selectBundleListOptions, benefit, true);
		}
		clickElementOfPage(saveCustomBundleButton);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textSavedCustomBundles,
				COREFLEXConstants.SAVED_CUSTOM_BUNDLES);
		return CoreFunctions.searchElementExistsInListByText(driver, _textSavedCustomBundlesList, bundleName, true);
	}

	private List<String> getBenefitList(String policyType) {

		List<String> benefitNameList = new ArrayList<String>();
		if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					benefitNameList.add(ben.getBenefitDisplayName());
				}
			}
		}
		return benefitNameList;
	}

	public boolean verifySubmitButtonDisabledPostSubmission() {
		if (CoreFunctions.isElementExist(driver, _buttonSubmitDisabled, 5)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUBMIT_BUTTON_DISABLED_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.PASS));
			return true;
		} else
			return false;
	}

	public boolean verifyApproveThisPolicyDialog(String checkBoxSelection) {
		boolean isDialogHeaderVerified, isDialogTextVerified, isDialogOptionsVerified,
				isApproveThisPolicyDialogVerified;
		try {
			isDialogHeaderVerified = CoreFunctions.getElementText(driver, _popUpApprovePolicyHeader)
					.equals(COREFLEXConstants.EXPECTED_APPROVE_THIS_POLICY_DIALOG_HEADER);
			isDialogTextVerified = CoreFunctions.getElementText(driver, _popUpApprovePolicyVersionText)
					.equals(COREFLEXConstants.EXPECTED_APPROVE_THIS_POLICY_DIALOG_VERSION_TEXT)
					&& CoreFunctions.getElementText(driver, _popUpApprovePolicyAssignmentText)
							.equals(COREFLEXConstants.EXPECTED_APPROVE_THIS_POLICY_DIALOG_ASSIGNMENT_TEXT);
			isDialogOptionsVerified = (CoreFunctions.getElementText(driver, _popUpApprovePolicyCheckBox).trim())
					.equals(COREFLEXConstants.EXPECTED_APPROVE_THIS_POLICY_DIALOG_CHECKBOX_SELECTION.trim())
					&& CoreFunctions.getAttributeText(_popUpApprovePolicyDefaultAssignmentDate, "min")
							.equals(CoreFunctions.getCurrentDateAsGivenFormat("YYYY-MM-dd"));
			isApproveThisPolicyDialogVerified = isDialogHeaderVerified && isDialogTextVerified
					&& isDialogOptionsVerified;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_ADDING_A_NEW_CUSTOM_BUNDLE_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isApproveThisPolicyDialogVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_APPROVE_THIS_POLICY_DIALOG_HEADER_VERSION_ASSIGNMENT_TEXT_AND_FIELDS,
					CoreConstants.PASS));
		}
		return isApproveThisPolicyDialogVerified;
	}

	public boolean verifyPolicyStatusPostSubmission(String expectedPolicyStatus) {
		if (CoreFunctions.getElementText(driver, _textPolicyStatus).equals(expectedPolicyStatus)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_STATUS_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.PASS, expectedPolicyStatus));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, CoreFunctions.getElementText(driver, _textPolicyStatus),expectedPolicyStatus));
			return false;
		}
	}

	public boolean verifyPolicyVersionPostSubmission(String expectedPolicyVersion) {
		if (CoreFunctions.getElementText(driver, _textPolicyVersion).equals(expectedPolicyVersion)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_VERSION_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.PASS, expectedPolicyVersion));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_VERIFY_POLICY_VERSION_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL,CoreFunctions.getElementText(driver, _textPolicyVersion), expectedPolicyVersion));
			return false;
		}
	}

	public boolean verifyApprovalDialogNotDisplayed() {
		if (!CoreFunctions.isElementExist(driver, _dialogApproveThisPolicy, 5)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_APPROVE_THIS_POLICY_DIALOG_NOT_DISPLAYED_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.PASS));
			return true;
		} else
			return false;
	}

}
