package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
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

	// Save As Draft Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Save as Draft')]")
	private WebElement _buttonSaveAsDraft;

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

	// Saved Custom Bundle Benefit List
	@FindBy(how = How.CSS, using = "li.list-group-item")
	private List<WebElement> _customBundleBenefitList;

	// Pop-Up Submit Status
	@FindBy(how = How.CSS, using = "h2[id='swal2-title']")
	private WebElement _popUpTextStatus;

	// Pop-Up Submit Message
	@FindBy(how = How.CSS, using = "div[id='swal2-content']")
	private WebElement _popUpTextMessage;

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

	// Approve This Policy Dialog Description
	@FindBy(how = How.CSS, using = "textarea[formcontrolname='versionDescription']")
	private WebElement _txtAreaDescription;
	
	@FindBy(how = How.XPATH, using = "//strong[text()='Policy Status:']/parent::label/following-sibling::label/span/i")
	private WebElement _policyStatusIndicator;

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
			case COREFLEXConstants.SAVE_AS_DRAFT:
				CoreFunctions.clickElement(driver, _buttonSaveAsDraft);
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
//				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.ASSOCIATE_THIS_POLICY:
				CoreFunctions.clickElement(driver, _popUpApprovePolicyCheckBox);
				break;
			case COREFLEXConstants.ADD_NEW_CUSTOM_BUNDLE:
//				CoreFunctions.clickElement(driver, _buttonAddNewCustomBundle);
				CoreFunctions.clickUsingJS(driver, _buttonAddNewCustomBundle, COREFLEXConstants.ADD_NEW_CUSTOM_BUNDLE);
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
			CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList, elementName);
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
			actualSubmitMessage = CoreFunctions.getElementText(driver, _popUpTextMessage);
			isSubmitMessageVerified = (expectedSubmitStatusMessage.replace("PolicyName", policyName))
					.equalsIgnoreCase(actualSubmitMessage);
			isPolicySubmitStatusVerified = CoreFunctions.getElementText(driver, _popUpTextStatus)
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
			String saveCustomBundleButton, String policyRequiredFor) {
		try {
			List<String> bundleBenefitList = getBenefitList(policyType, policyRequiredFor);
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

	private List<String> getBenefitList(String policyType, String policyRequiredFor) {
		List<String> benefitNameList = new ArrayList<String>();
		try {

			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					if ((ben.getPolicyCreationGroup().contains(policyRequiredFor)))
						benefitNameList.add(ben.getBenefitDisplayName());
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_ADDING_A_NEW_CUSTOM_BUNDLE_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}

		return benefitNameList;
	}

	public boolean verifySubmitButtonDisabledPostSubmission() {
		if (CoreFunctions.isElementExist(driver, _buttonSubmitDisabled, 5)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUBMIT_BUTTON_DISABLED_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.PASS));
			CoreFunctions.highlightObject(driver, _buttonSubmitDisabled);
			return true;
		} else
			return false;
	}

	public boolean verifyApproveThisPolicyDialog(String policyVersion) {
		boolean isApproveThisPolicyDialogVerified;
		String policyVersionNumber = policyVersion.replace("V", "").trim();
		try {
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _popUpApprovePolicyHeader),
					COREFLEXConstants.EXPECTED_APPROVE_THIS_POLICY_DIALOG_HEADER,
					COREFLEXConstants.APPROVE_POLICY_DIALOG_HEADER);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _popUpApprovePolicyVersionText),
					(COREFLEXConstants.EXPECTED_APPROVE_THIS_POLICY_DIALOG_VERSION_TEXT).replace("VN",
							policyVersionNumber),
					COREFLEXConstants.APPROVE_POLICY_DIALOG_VERSION_TEXT);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _popUpApprovePolicyAssignmentText),
					(policyVersionNumber.equals("1"))
							? COREFLEXConstants.EXPECTED_APPROVE_THIS_POLICY_DIALOG_ASSIGNMENT_TEXT_FIRST_VERSION
							: COREFLEXConstants.EXPECTED_APPROVE_THIS_POLICY_DIALOG_ASSIGNMENT_TEXT_SECOND_VERSION,
					COREFLEXConstants.APPROVE_POLICY_DIALOG_ASSIGNMENT_TEXT);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _popUpApprovePolicyCheckBox).trim(),
					COREFLEXConstants.EXPECTED_APPROVE_THIS_POLICY_DIALOG_CHECKBOX_SELECTION.trim(),
					COREFLEXConstants.APPROVE_POLICY_DIALOG_CHECKBOX_OPTION);
			isApproveThisPolicyDialogVerified = true;
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
			CoreFunctions.clearAndSetText(driver, _txtAreaDescription,
					COREFLEXConstants.VERSION_DIALOG_DESCRIPTION_SHORT_TEXT);
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
					CoreConstants.FAIL, CoreFunctions.getElementText(driver, _textPolicyStatus), expectedPolicyStatus));
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
					CoreConstants.FAIL, CoreFunctions.getElementText(driver, _textPolicyVersion),
					expectedPolicyVersion));
			return false;
		}
	}

	public boolean verifyApprovalDialogNotDisplayed() {
		CoreFunctions.waitHandler(2);
		if (!CoreFunctions.isElementExist(driver, _dialogApproveThisPolicy, 5)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_APPROVE_THIS_POLICY_DIALOG_NOT_DISPLAYED_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.PASS));
			return true;
		} else
			return false;
	}

	public boolean verifyAddedCustomBundlePostVersioningCloning(String policyRequiredFor) {
		boolean isAddedCustomBundleVerified = false;
		try {
			if (CoreFunctions.searchElementExistsInListByText(driver, _textSavedCustomBundlesList,
					policySetupPageData.customBundlesPage.customBundleName, true)) {
				List<String> actualBenefitList = _customBundleBenefitList.stream().map(x -> x.getText())
						.collect(Collectors.toList());
				Collections.sort(actualBenefitList);
				List<String> expectedBenefitList = getBenefitDisplayNameList(policyRequiredFor);
				Collections.sort(expectedBenefitList);
				isAddedCustomBundleVerified = actualBenefitList.equals(expectedBenefitList);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ADDED_CUSTOM_BUNDLE_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isAddedCustomBundleVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_ADDED_CUSTOM_BUNDLE_ON_CUSTOM_BUNDLES_PAGE_POST_VERSIONING_CLONING,
					CoreConstants.PASS));
		}
		return isAddedCustomBundleVerified;
	}

	private List<String> getBenefitDisplayNameList(String policyRequiredFor) {
		List<String> benefitNameList = new ArrayList<String>();
		for (FlexBenefit benefit : flexBenefits) {
			for (Benefit ben : benefit.getBenefits()) {
				if (ben.getPolicyCreationGroup().contains(policyRequiredFor))
					benefitNameList.add(ben.getBenefitDisplayName());
			}
		}
		return benefitNameList;
	}

	public boolean verifyButtonDisplayedOnDraftPolicyStatus() {
		try {
			if (CoreFunctions.isElementExist(driver, _buttonSubmit, 3)
					&& CoreFunctions.isElementExist(driver, _buttonPreviewTransfereeExp, 3)
					&& CoreFunctions.isElementExist(driver, _buttonSaveAsDraft, 3)
					&& !(CoreFunctions.isElementExist(driver, _buttonApprovePolicy, 3))) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_BUTTONS_DISPLAYED_IN_DRAFT_POLICY_STATUS_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_BUTTONS_DISPLAYED_IN_DRAFT_POLICY_STATUS_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyPolicySaveAsDraftDialogStatus(String expectedDialogMessage) {
		boolean isPolicyDraftStatusVerified = false;
		String actualDialogMessage = null;
		try {
			actualDialogMessage = CoreFunctions.getElementText(driver, _popUpTextMessage);
			isPolicyDraftStatusVerified = CoreFunctions.getElementText(driver, _popUpTextStatus)
					.equals(COREFLEXConstants.SUCCESS) && actualDialogMessage.equalsIgnoreCase(expectedDialogMessage);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_SAVE_AS_DRAFT_DIALOG_STATUS_AND_MESSAGE_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPolicyDraftStatusVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_SAVE_AS_DRAFT_DIALOG_STATUS_AND_MESSAGE_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.PASS, expectedDialogMessage));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.POLICY_SAVE_AS_DRAFT_DIALOG_STATUS_AND_MESSAGE_NOT_MATCHED_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, expectedDialogMessage, actualDialogMessage));
		}
		return isPolicyDraftStatusVerified;
	}

	public boolean verifyPolicyStatusPostSaveAsDraft(String expectedPolicyStatus) {
		if (CoreFunctions.getElementText(driver, _textPolicyStatus).equals(expectedPolicyStatus)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_STATUS_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.PASS, expectedPolicyStatus));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS_POST_SAVE_AS_DRAFT_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, CoreFunctions.getElementText(driver, _textPolicyStatus), expectedPolicyStatus));
			return false;
		}
	}

	public boolean verifyPolicyVersionPostSaveAsDraft(String expectedPolicyVersion) {
		if (CoreFunctions.getElementText(driver, _textPolicyVersion).equals(expectedPolicyVersion)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_VERSION_POST_SAVE_AS_DRAFT_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.PASS, expectedPolicyVersion));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_VERIFY_POLICY_VERSION_POST_SAVE_AS_DRAFT_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, CoreFunctions.getElementText(driver, _textPolicyVersion),
					expectedPolicyVersion));
			return false;
		}
	}

	public boolean verifyApproveButtonDisplayedPostSubmission() {
		if (CoreFunctions.isElementExist(driver, _buttonApprovePolicy, 5)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.APPROVE_POLICY_BUTTON_DISPLAYED_POST_POLICY_SUBMISSION_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.PASS, COREFLEXConstants.CUSTOM_BUNDLES));
			CoreFunctions.highlightObject(driver, _buttonApprovePolicy);
			return true;
		} else
			return false;
	}

	public boolean verifyButtonDisplayedOnSubmittedPolicyStatus() {
		try {
			if (CoreFunctions.isElementExist(driver, _buttonSubmitDisabled, 3)
					&& CoreFunctions.isElementExist(driver, _buttonPreviewTransfereeExp, 3)
					&& !(CoreFunctions.isElementExist(driver, _buttonSaveAsDraft, 3))
					&& (CoreFunctions.isElementExist(driver, _buttonApprovePolicy, 3))) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_BUTTONS_DISPLAYED_IN_SUBMITTED_POLICY_STATUS_ON_CUSTOM_BUNDLES_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_BUTTONS_DISPLAYED_IN_SUBMITTED_POLICY_STATUS_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyPolicyStatus(String expectedPolicyStatus) {
		if (CoreFunctions.getElementText(driver, _textPolicyStatus).equals(expectedPolicyStatus)) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_STATUS,
					CoreConstants.PASS, expectedPolicyStatus));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS,
					CoreConstants.FAIL, CoreFunctions.getElementText(driver, _textPolicyStatus), expectedPolicyStatus));
			return false;
		}
	}
	
	public boolean verifyOnPointPolicyStatusIndicator(String expectedPolicyStatusIndicator,
			String expectedPolicyStatusHoverText,String pageName) {
		try {
			CoreFunctions.verifyText(getActualPolicyStatusIndicator(), expectedPolicyStatusIndicator,
					COREFLEXConstants.DRAFT_POLICY_STATUS_INDICATOR);
			CoreFunctions.verifyText(CoreFunctions.getAttributeText(_policyStatusIndicator, "mattooltip"), expectedPolicyStatusHoverText,
					COREFLEXConstants.DRAFT_POLICY_STATUS_INDICATOR_HOVER_TEXT);
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_DRAFT_POLICY_STATUS_INDICATOR_AND_HOVER_TEXT,
					CoreConstants.PASS,expectedPolicyStatusIndicator,expectedPolicyStatusHoverText,pageName));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_POLICY_STATUS_INDICATOR,
					CoreConstants.FAIL, e.getMessage(),pageName));
			return false;
		}
	}

	private String getActualPolicyStatusIndicator() {
		return CoreFunctions.getElementText(driver, _policyStatusIndicator).equalsIgnoreCase("error")
				? COREFLEXConstants.RED_INDICATOR
				: (CoreFunctions.getElementText(driver, _policyStatusIndicator).equalsIgnoreCase("check_circle")
						? COREFLEXConstants.GREEN_INDICATOR
						: null);
	}

}
