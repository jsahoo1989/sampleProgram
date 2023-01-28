package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.utilities.ClientPolicyDetails;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_SharedSubBenefitPage extends Base {
	public PDT_SharedSubBenefitPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;

	@FindBy(how = How.CSS, using = "div.displayHeaderSection > h4.card-title")
	private WebElement _benefitCatName;

	@FindBy(how = How.CSS, using = "div.card-header-info > h4.card-title")
	private WebElement _benefitCategoryName;

	@FindBy(how = How.XPATH, using = "//span[text()='SAVE & SUBMIT']/parent::button")
	private WebElement _btnSaveAndSubmit;

	@FindBy(how = How.CSS, using = "div.pcard-header > div.displayHeaderSection > h4.card-title")
	private WebElement _txtSubBenefitName;

	@FindBy(how = How.CSS, using = "div#collapseOne div.mat-tab-label-content")
	private List<WebElement> _tabOnCandidateSelectionForm;

	@FindBy(how = How.CSS, using = "div#collapseTwo div.mat-tab-label-content")
	private List<WebElement> _tabOnPreAcceptanceTripTransportation;

	@FindBy(how = How.CSS, using = "div#collapseThree div.mat-tab-label-content")
	private List<WebElement> _tabOnPreAcceptanceTripLodging;

	@FindBy(how = How.CSS, using = "div#collapseFour div.mat-tab-label-content")
	private List<WebElement> _tabOnPreAcceptanceTripMeals;

	@FindBy(how = How.CSS, using = "div.swal2-popup.swal2-modal.swal2-icon-question.swal2-show")
	private WebElement _dialogconfirmation;

	@FindBy(how = How.CSS, using = "button.swal2-confirm.swal2-styled")
	private WebElement _btnOk;

	@FindBy(how = How.CSS, using = "button.btn.btn-exit, button.btn.btn-next")
	private WebElement _btnExit;

	@FindBy(how = How.CSS, using = "div.swal2-popup.swal2-modal.swal2-icon-success.swal2-show")
	private WebElement _successPopUp;

	@FindBy(how = How.CSS, using = "div.swal2-html-container")
	private WebElement _successMsg;

	@FindBy(how = How.CSS, using = "button.swal2-confirm.swal2-styled")
	private WebElement _btnOkOnSuccessPopUp;

	@FindBy(how = How.CSS, using = "div.validation-error-popup.swal2-icon-error.swal2-show")
	private WebElement _errorPopUp;

	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	@FindBy(how = How.CSS, using = "div[id='swal2-content']")
	private WebElement _errMsg;

	@FindBy(how = How.CSS, using = "button.swal2-confirm")
	private WebElement _btnOkOnConfirmationDialog;

	@FindBy(how = How.CSS, using = "button.swal2-deny")
	private WebElement _btnCancelOnConfirmationDialog;

	@FindBy(how = How.CSS, using = "button.swal2-cancel")
	private WebElement _btnSaveOnConfirmationDialog;

	@FindBy(how = How.CSS, using = "label.form-check-label input[type='checkbox']")
	private List<WebElement> _chkBoxesSubBenefitCategories;

	@FindBy(how = How.XPATH, using = "//span[text()='APPROVE POLICY']")
	private WebElement _btnApprovePolicy;

	@FindBy(how = How.CSS, using = "div.approve-header")
	private WebElement _headerApprovePopUp;

	@FindBy(how = How.CSS, using = "div.msg-1 > p")
	private WebElement _msg1ApprovePopUp;

	@FindBy(how = How.CSS, using = "div.msg-2 > p")
	private WebElement _msg2ApprovePopUp;

	@FindBy(how = How.CSS, using = "input[formcontrolname='existingAuthDateInd']")
	private WebElement _chkBoxExistingDateInd;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='existingAuthDateInd']/parent::label")
	private WebElement _lblExistingDateInd;

	@FindBy(how = How.CSS, using = "input[formcontrolname='newAuthDateInd']")
	private WebElement _chkBoxNewDateInd;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='newAuthDateInd']/parent::label")
	private WebElement _lblNewDateInd;

	@FindBy(how = How.XPATH, using = "//span[text()='APPROVE']/parent::button")
	private WebElement _btnApprove;

	@FindBy(how = How.XPATH, using = "//span[text()='CANCEL']")
	private WebElement _btnCancel;

	@FindBy(how = How.XPATH, using = "//strong[text()='Policy Status:']/parent::label/following-sibling::label")
	private WebElement _policyStatus;

	@FindBy(how = How.XPATH, using = "//strong[text()='Policy Status:']")
	private WebElement _policyStatusText;

	@FindBy(how = How.XPATH, using = "//strong[text()='Version Number:']/parent::label/following-sibling::label")
	private WebElement _policyVersion;

	@FindBy(how = How.CSS, using = "div.menu-pad div.col-10 >p")
	private List<WebElement> _leftNavBenefitCategories;

	@FindBy(how = How.XPATH, using = "//span[text()='SAVE & CONTINUE']/parent::button")
	private WebElement _btnSaveAndContinue;

	@FindBy(how = How.XPATH, using = "//span[text()='SAVE']/parent::button")
	private WebElement _btnSave;

	@FindBy(how = How.CSS, using = "i.ind-error")
	private WebElement _redErrorIconOnPolicyStatus;

	@FindBy(how = How.CSS, using = "//i[contains(@class, 'tabError')]/preceding-sibling::h4")
	private WebElement _redErrorIconOnBenefitName;

//	@FindBy(how = How.CSS, using = "//i[contains(@class, 'tabError')]/parent::h5")
	@FindBy(how = How.CSS, using = "h5>i")
	private List<WebElement> _listRedErrorIconOnSubBenefitName;

	@FindBy(how = How.CSS, using = "div.col-md-12 h5")
	private List<WebElement> _listSubBenefitName;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Policy Benefit Categories')]/ancestor::li/following-sibling::li/descendant::i")
	private List<WebElement> _listSaveIconOnLeftmenu;

	@FindBy(how = How.CSS, using = "div.menu-pad div>i")
	private List<WebElement> _listIconOnLeftmenu;

	@FindBy(how = How.CSS, using = "div.menu-pad div>p")
	private List<WebElement> _listBenefitCategoryNameOnLeftMenu;

	@FindBy(how = How.CSS, using = "div.menu-pad")
	private List<WebElement> _listIconWithBenefitCategoryNameOnLeftmenu;

	@FindBy(how = How.XPATH, using = "//span/i/ancestor::label")
	private WebElement _policyStat;

	@FindBy(how = How.XPATH, using = "//span/i")
	private WebElement _policyIconStat;

	@FindBy(how = How.CSS, using = "h2.swal2-title")
	private WebElement _warningTitle;

	@FindBy(how = How.CSS, using = "div.swal2-content")
	private WebElement _warningMsg;

	@FindBy(how = How.CSS, using = "button.btn.btn-info.btn-back")
	private WebElement _btnBack;

	@FindBy(how = How.CSS, using = "button.btn.btn-info.btn-next")
	private WebElement _btnNext;

	@FindBy(how = How.ID, using = "swal2-title")
	private WebElement _headingOnConfirmationPopUp;

	@FindBy(how = How.ID, using = "swal2-content")
	private WebElement _messageOnConfirmationPopUp;

	@FindBy(how = How.CSS, using = "div.swal2-popup.swal2-show")
	private WebElement _confirmationPopUp;

	@FindBy(how = How.CSS, using = "i[mattooltip='Exit']")
	private WebElement _xButton;

	@FindBy(how = How.CSS, using = "div>p.px-0")
	private List<WebElement> _listLeftMenu;

	@FindBy(how = How.CSS, using = "textarea[formcontrolname='versionDescription']")
	private WebElement _txtAreaDescription;

	@FindBy(how = How.XPATH, using = "//textarea[@formcontrolname='versionDescription']/preceding-sibling::label")
	private WebElement _lblDescription;

	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Version Number')]/parent::label/following-sibling::label")
	private WebElement _versionNumber;

	LinkedHashMap<String, WebElement> formMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> subBenefitMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, WebElement> subBenefitAncestorMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> failedCategoriesWithIconMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> iconIndicatorMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> failedExpectedActualPagMap = new LinkedHashMap<String, String>();

	LinkedHashMap<String, WebElement> subBenefitHeaderMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, WebElement> buttonMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, WebElement> confirmationDialogButtonMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, WebElement> subBenefitHomeOwnerTypeLabelMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, WebElement> subBenefitEmpTypeLabelMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, WebElement> subBenefitHeadingMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, List<WebElement>> tabListMap = new LinkedHashMap<String, List<WebElement>>();
	LinkedHashMap<String, PDT_SharedSubBenefit_Steps> formMap1 = new LinkedHashMap<String, PDT_SharedSubBenefit_Steps>();
	HashMap<String, Boolean> resultMapForTabNameNotMatch = new HashMap<>();

	ArrayList<String> failedSubBenefits = new ArrayList<String>();
	ArrayList<String> pdtPagesList = new ArrayList<String>();
	ArrayList<String> failedButtonsList = new ArrayList<String>();
	long timeBeforeAction, timeAfterAction;
	boolean completePolicyState = true;

	public void setCompletePolicyState(boolean cPolicyState) {
		completePolicyState = cPolicyState;
	}

	public boolean getCompletePolicyState() {
		return completePolicyState;
	}

	public WebElement getElementByName(String pageName, String elementName) {
		return formMap.get(elementName);
	}

	public void navigateBenefitCategory(PDT_SharedSubBenefit_Steps subBenefitSteps,
			PDT_AddNewPolicyPage addNewPolicyPage, String pageName, String btnName) {
		switch (pageName) {
		case PDTConstants.DUPLICATE_HOUSING:
			subBenefitSteps.getDuplicateHousingPage().fillDuplicateHousingForm(addNewPolicyPage, pageName, btnName);
			break;
		case PDTConstants.PROPERTY_MANAGEMENT:
			subBenefitSteps.getPropertyManagementPage().fillPropertyManagementForm(addNewPolicyPage,
					PDTConstants.PROPERTY_MANAGEMENT, btnName);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	public void navigateBenefitCategory(List<String> subBenefits, PDT_AddNewPolicyPage addNewPolicyPage,
			PDT_SharedSubBenefit_Steps subBenefitSteps, String pageName, String btnName,
			PDT_GeneralInformationPage generalInfoPage) {
		switch (pageName) {
		case PDTConstants.PRE_ACCEPTANCE_SERVICES:
			subBenefitSteps.getPreAcceptServicePage().iterateAndFillPreAcceptanceSubBenefits(pageName, subBenefits,
					addNewPolicyPage, subBenefitSteps, btnName);
			break;
		case PDTConstants.CULTURAL_TRAINING:
			subBenefitSteps.getCulturalTrainingPage().iterateAndFillCulturalTrainingSubBenefits(pageName, subBenefits,
					addNewPolicyPage, subBenefitSteps, btnName, this, generalInfoPage);
			break;
		case PDTConstants.LANGUAGE_TRAINING:
			subBenefitSteps.getLanguageTrainingPage().iterateAndFillLanguageTrainingSubBenefits(pageName, subBenefits,
					addNewPolicyPage, subBenefitSteps, btnName, this, generalInfoPage);
			break;
		case PDTConstants.IMMIGRATION:
			subBenefitSteps.getImmigrationPage().iterateAndFillImmigrationSubBenefits(pageName, subBenefits,
					subBenefitSteps, btnName, this);
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP:
			subBenefitSteps.getHouseHuntingTripPage().iterateAndFillHouseHuntingSubBenefits(pageName, subBenefits,
					addNewPolicyPage, subBenefitSteps, btnName, this);
			break;
		case PDTConstants.FINAL_MOVE:
			subBenefitSteps.getFinalMovePage().iterateAndFillFinalMoveSubBenefits(pageName, subBenefits,
					addNewPolicyPage, subBenefitSteps, btnName, this);
			break;
		case PDTConstants.HOME_LEAVE:
			subBenefitSteps.getHomeLeavePage().iterateAndFillHomeLeaveSubBenefits(pageName, subBenefits,
					addNewPolicyPage, subBenefitSteps, btnName, this,
					subBenefitSteps.getGeneralInfoPage().getTracingSet());
			break;
		case PDTConstants.TEMPORARY_LIVING:
			subBenefitSteps.getTemporaryLivingPage().iterateAndFillTempLivingSubBenefits(pageName, subBenefits,
					addNewPolicyPage, subBenefitSteps, btnName, this);
			break;
		case PDTConstants.DESTINATION_SERVICES:
			subBenefitSteps.getDestinationServicePage().iterateAndFillDestinationServicesSubBenefits(pageName,
					subBenefits, addNewPolicyPage, subBenefitSteps, btnName, this);
			break;
		case PDTConstants.RENTAL_ASSISTANCE:
			subBenefitSteps.getRentalAssistancePage().iterateAndFillRentalAssistanceSubBenefits(pageName, subBenefits,
					addNewPolicyPage, subBenefitSteps, btnName, this);
			break;
		case PDTConstants.COMPENSATION_SERVICES:
			subBenefitSteps.getCompensationServicesPage().iterateAndFillCompensationServicesSubBenefits(pageName,
					subBenefits, addNewPolicyPage, subBenefitSteps, btnName, this);
			break;
		case PDTConstants.ASSIGNMENT_HOUSING_COMPANY_SPONSORED:
			subBenefitSteps.getAssignmentHousingPage().iterateAndFillAssignmentHousingSubBenefits(pageName, subBenefits,
					addNewPolicyPage, subBenefitSteps, btnName, this);
			;
			break;
		case PDTConstants.ONE_TIME_PAYMENTS_REIMBURSEMENTS:
			subBenefitSteps.getOneTimePaymentPage().iterateAndFillOneTimePaymentsReimbursementsSubBenefits(pageName,
					subBenefits, addNewPolicyPage, subBenefitSteps, btnName, this);
			break;
		case PDTConstants.ONGOING_PAYMENTS_REIMBURSEMENTS:
			subBenefitSteps.getOngoingPaymentReimbursementPage().iterateAndFillOngoingPaymentsReimbursementsSubBenefits(
					pageName, subBenefits, addNewPolicyPage, subBenefitSteps, btnName, this);
			break;
		/*
		 * case PDTConstants.DUPLICATE_HOUSING:
		 * subBenefitSteps.getDuplicateHousingPage().fillDuplicateHousingForm(
		 * addNewPolicyPage, PDTConstants.DUPLICATE_HOUSING); break; case
		 * PDTConstants.PROPERTY_MANAGEMENT:
		 * subBenefitSteps.getPropertyManagementPage().fillPropertyManagementForm(
		 * addNewPolicyPage, PDTConstants.PROPERTY_MANAGEMENT); break;
		 */
		case PDTConstants.HOME_PURCHASE:
			subBenefitSteps.getHomePurchasePage().iterateAndFillHomePurchaseSubBenefits(pageName, subBenefits,
					addNewPolicyPage, subBenefitSteps, btnName, this);
			break;
		case PDTConstants.HOUSEHOLD_GOODS:
			subBenefitSteps.getHouseHoldGoodsPage().iterateAndFillHouseHoldGoodsSubBenefits(pageName, subBenefits,
					addNewPolicyPage, subBenefitSteps, btnName, this);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	public boolean checkIfEditLabelBenefit(String subBenefitName) {
		try {
			if ((subBenefitName.equalsIgnoreCase(PDTConstants.CANDIDATE_SELECTION)
					|| subBenefitName.equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION)
					|| subBenefitName.equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING)
					|| subBenefitName.equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS)))
				return true;
			else
				return false;
		} catch (Exception e) {
			Assert.fail("Failed to expand sub benefit form:-" + subBenefitName);
			return false;
		}

	}

	public void expandSubBenefitIfCollapsed(WebElement subBenefitForm, String subBenefitName) {
		try {
			if (checkIfEditLabelBenefit(subBenefitName)) {
				if (subBenefitAncestorMap.get(subBenefitName).getAttribute("class").equalsIgnoreCase("collapsed"))
					CoreFunctions.clickElement(driver, subBenefitForm);

			} else if (subBenefitForm.getAttribute("class").equalsIgnoreCase("collapsed"))
				CoreFunctions.clickElement(driver, subBenefitForm);
		} catch (Exception e) {
			Assert.fail("Failed to expand sub benefit form:-" + subBenefitForm.getText());
		}
	}

	public void verifySubBenefitCategoriesAreDisplayed(List<String> subBenefitsFromDataTable, String pageName) {
		List<String> listSubBenefitCat = null;
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		listSubBenefitCat = CoreFunctions.getElementTextAndStoreInList(driver, _subBenefitCategories);
		if(pageName.equalsIgnoreCase(PDTConstants.ONGOING_PAYMENTS_REIMBURSEMENTS))
			listSubBenefitCat.remove(PDTConstants.HARDSHIP_ALLOWANCE);
		if (subBenefitsFromDataTable.equals(listSubBenefitCat))
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_SUB_BENEFITS_DISPLAYED, CoreConstants.PASS,
					subBenefitsFromDataTable.toString(), pageName));
		else
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_SUB_BENEFITS, CoreConstants.FAIL, pageName,
					subBenefitsFromDataTable.toString(),
					CoreFunctions.getElementTextAndStoreInList(driver, _subBenefitCategories).toString()));
	}

	public void verifySelectedPolicyBenefitCategoryName(String pageName) {
		waitForProgressBarToDisapper();
		try {
			WebElement element = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES)
					|| pageName.trim().equalsIgnoreCase(PDTConstants.ONE_TIME_PAYMENTS_REIMBURSEMENTS) || pageName.trim().equalsIgnoreCase(PDTConstants.ONGOING_PAYMENTS_REIMBURSEMENTS) ? _benefitCatName
							: _benefitCategoryName;

			CoreFunctions.explicitWaitForElementTextPresent(driver, element, pageName, 3);
			if (!CoreFunctions.verifyElementOnPage(driver, element, PDTConstants.POLICY_BENEFIT_CATEGORY, pageName,
					pageName, true))
				Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL,
						PDTConstants.POLICY_BENEFIT_CATEGORY, pageName, pageName, element.getText()));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL,
					PDTConstants.POLICY_BENEFIT_CATEGORY, pageName, pageName, PDTConstants.PRE_ACCEPTANCE_SERVICES));
		}
	}

	public void exitFromPolicyBenefitPage() {
		waitForProgressBarToDisapper();
		CoreFunctions.click(driver, _btnExit, PDTConstants.EXIT);
		if (CoreFunctions.isElementExist(driver, _dialogconfirmation, 1)) {
			CoreFunctions.clickWithoutReporting(driver, _btnOk, _btnOk.getText());
		}
	}

	public void populateBtnMap() {
		buttonMap.put(PDTConstants.PDT_BTN_SAVE_SUBMIT, _btnSaveAndSubmit);
		buttonMap.put(PDTConstants.EXIT.toUpperCase(), _btnExit);
		buttonMap.put(PDTConstants.BTN_APPROVE_POLICY, _btnApprovePolicy);
		buttonMap.put(PDTConstants.BTN_APPROVE, _btnApprove);
		buttonMap.put(PDTConstants.BTN_CANCEL, _btnCancel);
		buttonMap.put(PDTConstants.SAVE, _btnSave);
		buttonMap.put(PDTConstants.SAVE_AND_CONTINUE, _btnSaveAndContinue);
		buttonMap.put(PDTConstants.BACK.toUpperCase(), _btnBack);
		buttonMap.put(PDTConstants.NEXT.toUpperCase(), _btnNext);
		buttonMap.put(PDTConstants.XBTN, _xButton);
	}

	public void populateConfirmDialogbuttonMap() {
		confirmationDialogButtonMap.put(PDTConstants.OK, _btnOkOnConfirmationDialog);
		confirmationDialogButtonMap.put(PDTConstants.CANCEL, _btnCancelOnConfirmationDialog);
		confirmationDialogButtonMap.put(PDTConstants.SAVE, _btnSaveOnConfirmationDialog);
		confirmationDialogButtonMap.put(PDTConstants.HEADING, _headingOnConfirmationPopUp);
		confirmationDialogButtonMap.put(PDTConstants.MESSAGE, _messageOnConfirmationPopUp);
	}

	public void clickOnConfirmDialogBtn(String btnName) {
		try {
			populateConfirmDialogbuttonMap();
			if (CoreFunctions.isElementExist(driver, _dialogconfirmation, 1))
				CoreFunctions.clickUsingJS(driver, confirmationDialogButtonMap.get(btnName), btnName);
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}
	}

	public boolean verifySubBenefitCategoriesAreUnchecked(String subBenefitCategoryName) {
		List<Boolean> resultList = new ArrayList<Boolean>();
		boolean result;
		try {
			for (WebElement _chBoxSubBenefit : _chkBoxesSubBenefitCategories) {
				result = (_chBoxSubBenefit.getDomProperty("checked").equals("false")) ? true : false;
				resultList.add(result);
			}
			if (resultList.stream().allMatch(t -> t.equals(true))) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DATA_NOT_SAVED_SUB_BENEFIT,
						CoreConstants.PASS, subBenefitCategoryName));
				return true;
			}
		} catch (Exception e) {
			Assert.fail("Exception occured while verifying sub-benefit categories unchecked");
		}
		Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_VERIFY_DATA_NOT_SAVED_SUB_BENEFIT,
				CoreConstants.FAIL, subBenefitCategoryName));
		return false;
	}

	public boolean verifyButtonVisible(String btnName, PDT_PolicyBenefitCategoryPage policyBenefitCategoryPage) {
		try {
			waitForProgressBarToDisapper();
			if (CoreFunctions.isElementExist(driver, _btnApprovePolicy, 5)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_BTN_VISIBLE, CoreConstants.PASS, btnName,
						policyBenefitCategoryPage.getBenefitCategoryName()));

				return true;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_VISIBLE, CoreConstants.FAIL, btnName,
					policyBenefitCategoryPage.getBenefitCategoryName()));
		}
		return false;
	}

	public boolean verifyButtonDisabled(String btnName, PDT_PolicyBenefitCategoryPage policyBenefitCategoryPage) {
		try {
			if (_btnSaveAndSubmit.getAttribute("disabled").equalsIgnoreCase("true")) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_BTN_ENABLED, CoreConstants.PASS, btnName,
						policyBenefitCategoryPage.getBenefitCategoryName()));
				return true;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_DISABLED, CoreConstants.FAIL, btnName,
					policyBenefitCategoryPage.getBenefitCategoryName()));
		}
		return false;
	}

	public void clickElementOfPage(String btnName, String pageName) {
		try {
			populateBtnMap();
			waitForProgressBarToDisapper();
			CoreFunctions.clickUsingJS(driver, buttonMap.get(btnName), btnName);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK, CoreConstants.FAIL,
					PDTConstants.BTN_APPROVE_POLICY, pageName));
		}
	}

	public void verifyHeadingAndMsgOfPopUp(List<List<String>> data) {
		waitForProgressBarToDisapper();
		CoreFunctions.explicitWaitForElementTextPresent(driver, _headerApprovePopUp, data.get(0).get(1), 10);
		CoreFunctions.verifyText(driver, _headerApprovePopUp, data.get(0).get(1), data.get(0).get(0));
		CoreFunctions.verifyText(driver, _msg1ApprovePopUp, data.get(1).get(1), data.get(1).get(0));
		CoreFunctions.verifyText(driver, _msg2ApprovePopUp, data.get(2).get(1), data.get(2).get(0));
	}

	public boolean verifyCheckBoxAndMsg(String fieldName, String msg, String status) {
		try {
			if (status.equalsIgnoreCase("disabled")
					&& _chkBoxExistingDateInd.getAttribute("disabled").equalsIgnoreCase("true")) {
				CoreFunctions.highlightObject(driver, _chkBoxExistingDateInd);
				CoreFunctions.verifyText(driver, _lblExistingDateInd, msg, fieldName);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_CHKBOX_MSG, CoreConstants.PASS, msg, status));
				return true;
			} else if (status.equalsIgnoreCase("enabled")
					&& _chkBoxNewDateInd.getDomProperty("disabled").equalsIgnoreCase("false")) {
				CoreFunctions.highlightObject(driver, _chkBoxNewDateInd);
				CoreFunctions.verifyText(driver, _lblNewDateInd, msg, fieldName);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_CHKBOX_MSG, CoreConstants.PASS, msg, status));
				return true;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CHECKBOX, CoreConstants.FAIL, msg, status));
		}
		return false;
	}

	public boolean verifyDescription() {
		try {
			if (CoreFunctions.isElementExist(driver, _txtAreaDescription, 1)) {
				CoreFunctions.highlightObject(driver, _lblDescription);
				CoreFunctions.highlightObject(driver, _txtAreaDescription);
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_FIELD_IS_DISPLAYED, CoreConstants.PASS,
						_lblDescription.getText()));
				return true;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.VERIFIED_FIELD_IS_NOT_DISPLAYED, CoreConstants.PASS,
					_lblDescription.getText()));
		}
		return false;
	}

	public boolean verifyButton(String btnName, String btnStatus) {
		try {
			if (btnName.equalsIgnoreCase("approve") && btnStatus.equalsIgnoreCase("disabled")
					&& _btnApprove.getAttribute("disabled").equalsIgnoreCase("true")) {
				CoreFunctions.highlightObject(driver, _btnApprove);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_BTN_STATE, CoreConstants.PASS, btnName, btnStatus));
				return true;
			} else if (btnName.equalsIgnoreCase("approve") && btnStatus.equalsIgnoreCase("enabled")
					&& _btnApprove.getDomProperty("disabled").equalsIgnoreCase("false")) {
				CoreFunctions.highlightObject(driver, _btnApprove);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_BTN_STATE, CoreConstants.PASS, btnName, btnStatus));
				return true;
			} else if (btnName.equalsIgnoreCase("cancel") && btnStatus.equalsIgnoreCase("enabled")
					&& CoreFunctions.isElementExist(driver, _btnCancel, 3)) {
				CoreFunctions.highlightObject(driver, _btnCancel);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_BTN_STATE, CoreConstants.PASS, btnName, btnStatus));
				return true;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, CoreConstants.FAIL, btnName,
					btnStatus));
		}
		return false;
	}

	public void clickAssociateWithNewAuth() {
		CoreFunctions.clickElement(driver, _lblNewDateInd);
	}

	public void clickAssociateWithExistingAuth() {
		CoreFunctions.clickElement(driver, _lblExistingDateInd);
	}

	public String getPolicyDescrption() {
		return "Version " + _versionNumber.getText() + "description for Policy" + ClientPolicyDetails.getPolicyName();
	}

	public void enterVersionDescription() {
		try {
			CoreFunctions.clearAndSetText(driver, _txtAreaDescription, _lblDescription.getText(),
					getPolicyDescrption());
		} catch (Exception e) {
			Assert.fail("Exception occured while entering Version description");
		}
	}

	public void approvePolicy(String btnName, String pageName) {
		try {
			timeBeforeAction = new Date().getTime();
			CoreFunctions.click(driver, buttonMap.get(btnName), btnName);
			waitForProgressBarToDisapper();
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction,
					PDTConstants.VIEW_EDIT_POLICY_FORMS);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK, CoreConstants.FAIL, btnName, pageName));
		}
	}

	public boolean verifyStatusAndVersionOfPolicy(String selectedPolicyName, String expectedPolicyStatus,
			String expectedPolicyVersion, String pageName) {
		waitForProgressBarToDisapper();
		CoreFunctions.scrollToElementUsingJS(driver, _policyStatusText, _policyStatusText.getText());
		CoreFunctions.explicitWaitForElementTextPresent(driver, _policyStatus, expectedPolicyStatus, 20);
		if (expectedPolicyStatus.equalsIgnoreCase(_policyStatus.getText().trim())
				&& expectedPolicyVersion.equalsIgnoreCase(_policyVersion.getText().trim())) {
			CoreFunctions.highlightObject(driver, _policyStatus);
			CoreFunctions.highlightObject(driver, _policyVersion);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_POLICY_VERSION_STATUS, CoreConstants.PASS,
					selectedPolicyName, expectedPolicyVersion, expectedPolicyStatus, pageName));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_VERSION_STATUS,
					CoreConstants.FAIL, selectedPolicyName, expectedPolicyVersion, _policyVersion.getText().trim(),
					expectedPolicyStatus, _policyStatus.getText().trim(), pageName));
			return false;
		}
	}

	public void clickButtonOnApprovePolicyPopUp(String btnName, String pageName) {
		try {
			populateBtnMap();
			if (btnName.equalsIgnoreCase(PDTConstants.BTN_APPROVE)) {
				approvePolicy(btnName, pageName);
			} else if (btnName.equalsIgnoreCase(PDTConstants.BTN_CANCEL)) {
				CoreFunctions.highlightElementAndClick(driver, buttonMap.get(btnName), btnName);
			} else {
				Assert.fail(MessageFormat.format(PDTConstants.BTN_DOES_NOT_EXIST, CoreConstants.FAIL, btnName));
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.BTN_DOES_NOT_EXIST, CoreConstants.FAIL, btnName));
		}
	}

	public void navigateBenefitCategories(String benefitCategoryName) {
		waitForProgressBarToDisapper();
		for (WebElement benefitName : _leftNavBenefitCategories) {
			if (_benefitCategoryName.getText().trim().equalsIgnoreCase(benefitCategoryName))
				return;
			else
				CoreFunctions.click(driver, _btnSaveAndContinue, _btnSaveAndContinue.getText());
		}
	}

	public boolean verifySavedIndicatorForBenefit(String benefitCategoryName) {
		waitForProgressBarToDisapper();
		int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listBenefitCategoryNameOnLeftMenu,
				benefitCategoryName);
		if (_listIconOnLeftmenu.get(index).getText().equalsIgnoreCase("check_circle_outline")) {
			CoreFunctions.highlightObject(driver, _listIconWithBenefitCategoryNameOnLeftmenu.get(index));
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON_INDICATOR, CoreConstants.PASS,
					PDTConstants.SAVE_INDICATOR, benefitCategoryName));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON_INDICATOR, CoreConstants.FAIL,
				PDTConstants.SAVE_INDICATOR, benefitCategoryName, getCurrentBenefitCategoryName(benefitCategoryName)));
		return false;
	}

	public String getCurrentBenefitCategoryName(String pageName) {
		WebElement element = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES) ? _benefitCatName
				: _benefitCategoryName;
		CoreFunctions.explicitWaitForElementTextPresent(driver, element, pageName, 10);
		return element.getText();
	}

	public boolean verifyUserStaysOnSamePage(String expectedPageName) {
		if (expectedPageName.equalsIgnoreCase(getCurrentBenefitCategoryName(expectedPageName))) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_STAYS_ON_SAME_PAGE, CoreConstants.PASS,
					expectedPageName));
			return true;
		}
		return false;
	}

	public String getPolicyStatus() {
		return _policyStat.getText().split(" ")[0];
	}

	public String getPolicyStatusWithIcon() {
		return _policyStat.getText();
	}

	public boolean verifyPolicyStatusRemainsSame(String policyStatusBeforeSave) {
		if (policyStatusBeforeSave.equalsIgnoreCase(getPolicyStatus())) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_POLICY_STATUS_REMAINS_SAME,
					CoreConstants.PASS, policyStatusBeforeSave, PDTConstants.SAVE));
			return true;
		}
		return false;
	}

	public void iterateEachBenefitCategory(List<String> benefitsList, TestContext testContext,
			PDT_SharedSubBenefitPage subBenefitPage, PDT_AddNewPolicyPage addNewPolicyPage,
			PDT_GeneralInformationPage generalInfoPage) {
		for (String benefitCategory : benefitsList) {
			List<String> subBenefits = BusinessFunctions.getSubBenefitList(benefitCategory);
			PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
			verifySelectedPolicyBenefitCategoryName(benefitCategory);
			verifySubBenefitCategoriesAreDisplayed(subBenefits, benefitCategory);
			if (benefitsList.get(benefitsList.size() - 1).equalsIgnoreCase(benefitCategory))
				navigateBenefitCategory(subBenefits, addNewPolicyPage, objStep, benefitCategory, null, generalInfoPage);
			else {
				navigateBenefitCategory(subBenefits, addNewPolicyPage, objStep, benefitCategory,
						PDTConstants.SAVE_AND_CONTINUE, generalInfoPage);
			}
		}
	}

	public boolean verifyIconIndicatorForBenefitCategories(ArrayList<String> benefitCategoryList, String indicatorName,
			String iconIndicator) {
		populateIconIndicatorMap();
		BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		for (String benefitCategoryName : benefitCategoryList) {
			int index = BusinessFunctions.returnindexFromListUsingText(driver, _listBenefitCategoryNameOnLeftMenu,
					benefitCategoryName);
			if (_listIconOnLeftmenu.get(index).getText().equalsIgnoreCase(iconIndicator)) {
				CoreFunctions.highlightObject(driver, _listIconWithBenefitCategoryNameOnLeftmenu.get(index));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON_INDICATOR, CoreConstants.PASS,
						indicatorName, benefitCategoryName));

			} else
				failedCategoriesWithIconMap.put(benefitCategoryName, _listIconOnLeftmenu.get(index).getText());
		}
		boolean result = failedCategoriesWithIconMap.size() > 0 ? false : true;
		return result;
	}

	public void populateIconIndicatorMap() {
		iconIndicatorMap.put("check_circle_outline", PDTConstants.SAVE_INDICATOR_LEFT_MENU);
		iconIndicatorMap.put("error", PDTConstants.ERROR_INDICATOR_LEFT_MENU);
		iconIndicatorMap.put("assignment", PDTConstants.DRAFT_INDICATOR_LEFT_MENU);
	}

	public String printFailedCategoriesWithIcon(String expectedIconIndicator) {
		String msgToPrint = "";
		for (Map.Entry<String, String> it : failedCategoriesWithIconMap.entrySet())
			msgToPrint.concat(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CATEGORY_NAME, CoreConstants.FAIL,
					it.getKey(), expectedIconIndicator, expectedIconIndicator, iconIndicatorMap.get(it.getValue())));
		return msgToPrint;
	}

	public void clickOnBtn(String btnName) {
		try {
			populateBtnMap();
			CoreFunctions.clickUsingJS(driver, buttonMap.get(btnName), btnName);
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}
	}

	public boolean verifyIconColorAndName(String iconColor, String iconName) {
		if (_policyIconStat.getText().equalsIgnoreCase(iconName)
				&& _policyIconStat.getAttribute("color").equalsIgnoreCase(iconColor)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON_COLOR_NAME_ON_HEADER,
					CoreConstants.PASS, iconColor, iconName));
			return true;
		}
		return false;
	}

	public String getIconColor() {
		return _policyIconStat.getAttribute("color");
	}

	public String getIconName() {
		return _policyIconStat.getText();
	}

	public String getCategoryName() {
		return _benefitCategoryName.getText();
	}

	public boolean verifyRedAlertIconOnSubBenefitName(List<String> subBenefitNameList) {
		waitForProgressBarToDisapper();
		for (String subBenefitName : subBenefitNameList) {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listSubBenefitName, subBenefitName,
					true);
			if (index > -1 && _listRedErrorIconOnSubBenefitName.get(index).getText().equalsIgnoreCase("error")
					&& _listRedErrorIconOnSubBenefitName.get(index).getAttribute("class").contains("tabError")) {
				CoreFunctions.highlightObject(driver, _listRedErrorIconOnSubBenefitName.get(index));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_RED_ERROR_INDICATOR_ON_SUBBENEFIT,
						CoreConstants.PASS, PDTConstants.RED_COLOR_ERR_INDICATOR, subBenefitName));

			} else
				failedSubBenefits.add(subBenefitName);
		}
		boolean result = failedSubBenefits.size() > 0 ? false : true;
		return result;
	}

	public String printFailedSubBenefitNameWithoutRedIcon() {
		String msgToPrint = "";
		for (String subBenefitName : failedSubBenefits)
			msgToPrint.concat(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_RED_COLOR_ICON_DISPLAYED_ON_SUBBENEFIT,
					CoreConstants.FAIL, subBenefitName).concat("<br/>"));
		return msgToPrint;
	}

	public boolean verifyErrorIndicatorForBenefit(String benefitCategoryName) {
		waitForProgressBarToDisapper();
		int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listBenefitCategoryNameOnLeftMenu,
				benefitCategoryName);
		if (_listIconOnLeftmenu.get(index).getText().equalsIgnoreCase("error")) {
			CoreFunctions.highlightObject(driver, _listIconWithBenefitCategoryNameOnLeftmenu.get(index));
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON_INDICATOR, CoreConstants.PASS,
					PDTConstants.ERROR_IND, benefitCategoryName));
			return true;
		}
		return false;
	}

	public void iterateEachBenefitCat(List<String> benefitsList, TestContext testContext,
			PDT_SharedSubBenefitPage subBenefitPage, PDT_AddNewPolicyPage addNewPolicyPage,
			PDT_GeneralInformationPage generalInfoPage) {
		for (String benefitCategory : benefitsList) {
			List<String> subBenefits = BusinessFunctions.getSubBenefitList(benefitCategory);
			PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
			verifySelectedPolicyBenefitCategoryName(benefitCategory);
			verifySubBenefitCategoriesAreDisplayed(subBenefits, benefitCategory);
			subBenefitPage.setCompletePolicyState(false);
			if (benefitsList.get(benefitsList.size() - 1).equalsIgnoreCase(benefitCategory))
				navigateBenefitCategory(subBenefits, addNewPolicyPage, objStep, benefitCategory, null, generalInfoPage);
			else
				navigateBenefitCategory(subBenefits, addNewPolicyPage, objStep, benefitCategory,
						PDTConstants.SAVE_AND_CONTINUE, generalInfoPage);

		}
	}

	public boolean verifyWarningTitle(String warnTitle) {
		waitForProgressBarToDisapper();
		if (_warningTitle.getText().equalsIgnoreCase(warnTitle)) {
			CoreFunctions.highlightObject(driver, _warningTitle);
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.VERIFIED_WARNING_TITLE, CoreConstants.PASS, warnTitle));
			return true;
		}
		return false;
	}

	public boolean verifyWarningMessage(String warnMsg) {
		if (_warningMsg.getText().equalsIgnoreCase(warnMsg)) {
			CoreFunctions.highlightObject(driver, _warningMsg);
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.VERIFIED_WARNING_MESSAGE, CoreConstants.PASS, warnMsg));
			return true;
		}
		return false;
	}

	public String getWarningTitle() {
		return _warningTitle.getText();
	}

	public String getWarningMsg() {
		return _warningMsg.getText();
	}

	public void initPDTAllPagesList(List<String> benefitCategoryList) {
		pdtPagesList.add(PDTConstants.GENERAL_INFORMATION);
		pdtPagesList.add(PDTConstants.POLICY_BENEFIT_CATEGORIES);
		pdtPagesList.addAll(benefitCategoryList);
	}

	public ArrayList<String> getPDTPagesList() {
		return pdtPagesList;
	}

	public void waitForProgressBarToDisapper() {
		BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
	}

	public boolean verifyPageName(String pageName, String pageNavigationType) {
		BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		try {
			WebElement element = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES)
					? _benefitCatName
					: _benefitCategoryName;

			CoreFunctions.explicitWaitForElementTextPresent(driver, element, pageName, 3);
			if (element.getText().equalsIgnoreCase(pageName)
					&& pageNavigationType.equalsIgnoreCase(PDTConstants.PREVIOUS)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_NAVIGATED_TO_PREV_PAGE,
						CoreConstants.PASS, pageName));
				return true;
			} else if (element.getText().equalsIgnoreCase(pageName)
					&& pageNavigationType.equalsIgnoreCase(PDTConstants.NEXT)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_NAVIGATED_TO_NEXT_PAGE,
						CoreConstants.PASS, pageName));
				return true;
			} else
				failedExpectedActualPagMap.put(pageName, element.getText());
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCUR_NAV_TO_PAGE, CoreConstants.FAIL,
					pageNavigationType.toLowerCase()));
		}
		return false;
	}

	public boolean verifyUserNavigateToPrevPage(String pageNavigationType) {
		ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		Collections.reverse(pdtPagesList);
		for (int i = 1; i <= pdtPagesList.size() - 1; i++) {
			waitForProgressBarToDisapper();
			resultList.add(verifyPageName(pdtPagesList.get(i), pageNavigationType));
			if (i < pdtPagesList.size() - 1)
				clickOnBtn(PDTConstants.BACK.toUpperCase());
		}
		return resultList.stream().allMatch(n -> n == true);
	}

	public String printFailedExpectedActualPageMap(String navigationType) {
		String str = "";
		String failMsg = (navigationType.equalsIgnoreCase(PDTConstants.PREVIOUS)
				? PDTConstants.FAIL_TO_VERIFY_NAVIGATED_TO_PREV_PAGE
				: PDTConstants.FAIL_TO_VERIFY_NAVIGATED_TO_NEXT_PAGE);
		for (Map.Entry<String, String> set : failedExpectedActualPagMap.entrySet()) {
			str.concat(MessageFormat.format(failMsg, CoreConstants.FAIL, set.getKey(), set.getValue())).concat("<br/>");
		}
		return str;
	}

	public void selectEmpTypeHomeOwnerTypeForSubBenefit(String pageName, PDT_SharedSubBenefit_Steps subBenefitSteps,
			PDT_AddNewPolicyPage addNewPolicyPage, DataTable subBenefitTable) {
		switch (pageName) {
		case PDTConstants.PRE_ACCEPTANCE_SERVICES:
			subBenefitSteps.getPreAcceptServicePage().selectEmployeeTypeHomeOwnerTypeForSubBenefit(pageName,
					addNewPolicyPage, subBenefitTable);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	public void iterateSubBenefitTabsForBenefit(String pageName, PDT_SharedSubBenefit_Steps subBenefitSteps,
			PDT_AddNewPolicyPage addNewPolicyPage, DataTable subBenefitTable) {
		switch (pageName) {
		case PDTConstants.PRE_ACCEPTANCE_SERVICES:
			Assert.assertTrue(subBenefitSteps.getPreAcceptServicePage().iterateSubBenefitForTabs(pageName,
					addNewPolicyPage, subBenefitTable),
					subBenefitSteps.getPreAcceptServicePage().getTabNameNotMatch(pageName));
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	public void verifyConfirmationPopContents(SoftAssert _softAssert, List<List<String>> confirmPopupData,
			String popUpName) {
		try {
			if (CoreFunctions.isElementExist(driver, _dialogconfirmation, 1)) {
				verifyConfirmationHeadingAndMessage(_softAssert, confirmPopupData, popUpName);
			} else {
				Assert.fail(MessageFormat.format(PDTConstants.POP_UP_NOT_DISPLAYED, CoreConstants.FAIL, popUpName));
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.POP_UP_NOT_DISPLAYED, CoreConstants.FAIL, popUpName));
		}

	}

	public void verifyConfirmationHeadingAndMessage(SoftAssert _softAssert, List<List<String>> confirmPopupData,
			String popupName) {
		populateConfirmDialogbuttonMap();
		try {
			for (int i = 0; i < confirmPopupData.size() - 1; i++) {
				_softAssert.assertTrue(
						BusinessFunctions.verifyPopUpContent(driver,
								confirmationDialogButtonMap.get(confirmPopupData.get(i).get(0).toLowerCase()),
								confirmPopupData.get(i).get(0), confirmPopupData.get(i).get(1), popupName, true),
						MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_POPUP, CoreConstants.FAIL,
								confirmPopupData.get(i).get(0), confirmPopupData.get(i).get(1), popupName));
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify popup contents");
		}

	}

	public boolean verifyButtonDisplayed(WebElement button, String buttonName, String popUpName) {
		try {
			if (button.isDisplayed() && button.getText().equalsIgnoreCase(buttonName)) {
				CoreFunctions.highlightObject(driver, button);
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_BUTTON_DISPLAYED_ON_POPUP,
						CoreConstants.PASS, buttonName, popUpName));
				return true;
			} else {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BUTTON_DISPLAYED_ON_POPUP,
						CoreConstants.FAIL, buttonName, popUpName, button.getText()));
				return false;
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify button " + buttonName + " on " + popUpName);
			return false;
		}
	}

	public boolean verifyButtonsOnConfirmationPopUp(String buttonString, String popUpName) {
		String button[] = buttonString.split(", ");
		for (int i = 0; i < button.length; i++) {
			if (!verifyButtonDisplayed(confirmationDialogButtonMap.get(button[i]), button[i], popUpName))
				failedButtonsList.add(button[i]);
		}
		boolean flag = (failedButtonsList.size() > 0) ? false : true;
		return flag;
	}

	public String getfailedButtonString(String popUpName) {
		String str = "";
		for (int i = 0; i < failedButtonsList.size(); i++) {
			str.concat("Failed to verify " + failedButtonsList.get(i) + " button on " + popUpName);
		}
		return str;
	}

	public void clickBtnOnConfirmation(String btnName, String popUpName) {
		if (CoreFunctions.isElementExist(driver, _dialogconfirmation, 1)) {
			verifyButtonDisplayed(confirmationDialogButtonMap.get(btnName), btnName, popUpName);
			// CoreFunctions.clickWithoutReporting(driver, _btnOk, _btnOk.getText());
			CoreFunctions.click(driver, confirmationDialogButtonMap.get(btnName),
					confirmationDialogButtonMap.get(btnName).getText());
		}
	}

	public boolean verifyOkBtnFunctionality(PDT_ViewPolicyPage viewPolicyPage, String btnName, String popUpName) {
		// clickBtnOnConfirmation(btnName, popUpName);
		clickOnConfirmDialogBtn(btnName);
		viewPolicyPage.waitForProgressBarToDisapper();
		viewPolicyPage.searchByPolicyNameAndClickIcon(PDTConstants.ICON_EDIT,
				ClientPolicyDetails.getPolicyName().split("\\(#")[0].trim(), PDTConstants.VIEW_EDIT_POLICY_FORMS);
		verifyDraftIconWithUnsavedBenefitCategoryOnLeftMenu();
		// verifySubBenefitCategoryForLastBenefitPageNotChecked();
		return verifySubBenefitCategoriesAreUnchecked(
				CoreFunctions.getElementTextAndStoreInList(driver, _subBenefitCategories).toString());
	}

	public boolean verifyUserNavigateToNextPage() {
		ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		for (int i = 0; i <= pdtPagesList.size() - 1; i++) {
			waitForProgressBarToDisapper();
			resultList.add(verifyPageName(pdtPagesList.get(i), PDTConstants.NEXT));
			if (i < pdtPagesList.size() - 1)
				clickOnBtn(PDTConstants.NEXT.toUpperCase());
		}
		return resultList.stream().allMatch(n -> n == true);
	}

	public void verifyDraftIconWithUnsavedBenefitCategoryOnLeftMenu() {
		waitForProgressBarToDisapper();
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listBenefitCategoryNameOnLeftMenu,
					pdtPagesList.get(pdtPagesList.size() - 1));
			if (_listIconOnLeftmenu.get(index).getText().equalsIgnoreCase("assignment")) {
				CoreFunctions.highlightObject(driver, _listIconWithBenefitCategoryNameOnLeftmenu.get(index));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON_INDICATOR, CoreConstants.PASS,
						PDTConstants.DRAFT, _listBenefitCategoryNameOnLeftMenu.get(index).getText()));
				CoreFunctions.clickWithoutReporting(driver, _listIconWithBenefitCategoryNameOnLeftmenu.get(index),
						_listIconWithBenefitCategoryNameOnLeftmenu.get(index).getText());
			} else {
				Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON_INDICATOR, CoreConstants.FAIL,
						PDTConstants.DRAFT, _listBenefitCategoryNameOnLeftMenu.get(index).getText(),
						_listIconOnLeftmenu.get(index).getText()));
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify Draft icon with " + pdtPagesList.get(pdtPagesList.size() - 1)
					+ " benefit category on left menu");
		}
	}

	public boolean verifyCancelBtnFunctionality(PDT_ViewPolicyPage viewPolicyPage,
			PDT_AddNewPolicyPage addNewPolicyPage, String benefitCategory, TestContext testContext,
			String expectedPageName, String btnName, String btnToClickAfterEnteringData, String popUpName,
			PDT_GeneralInformationPage generalInfoPage) {
		PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
		List<String> subBenefits = BusinessFunctions.getSubBenefitList(benefitCategory);
		navigateBenefitCategory(subBenefits, addNewPolicyPage, objStep, benefitCategory,
				btnToClickAfterEnteringData.toUpperCase(), generalInfoPage);
		clickOnConfirmDialogBtn(btnName);
		if (expectedPageName.equalsIgnoreCase(getCurrentBenefitCategoryName(expectedPageName))) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_STAYS_ON_SAME_PAGE_AFTER_CANCEL,
					CoreConstants.PASS, expectedPageName));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_STAYS_ON_SAME_PAGE_AFTER_CANCEL,
				CoreConstants.FAIL, expectedPageName, getCurrentBenefitCategoryName(expectedPageName)));
		return false;
	}

	public boolean verifySaveBtnFunctionality(PDT_ViewPolicyPage viewPolicyPage, String btnName,
			String benefitCategoryName, PDT_GeneralInformationPage generalInfoPage, String popUpName) {
		clickOnBtn(PDTConstants.EXIT.toUpperCase());
		clickOnConfirmDialogBtn(btnName.toUpperCase());
		viewPolicyPage.waitForProgressBarToDisapper();
		viewPolicyPage.searchByPolicyNameAndClickIcon(PDTConstants.ICON_EDIT,
				ClientPolicyDetails.getPolicyName().split("\\(#")[0].trim(), PDTConstants.VIEW_EDIT_POLICY_FORMS);
		verifySavedIndicatorForBenefit(benefitCategoryName);
		if (generalInfoPage.getPolicyStatus().equalsIgnoreCase(PDTConstants.DRAFT_CHECK_CIRCLE)) {
			CoreFunctions.highlightObject(driver, _policyStat);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DATA_SAVED, CoreConstants.PASS));
			return true;
		}
		return false;
	}

	public boolean verifyOkBtnFunctionalityOnClickingBackBtn(PDT_ViewPolicyPage viewPolicyPage, String btnName,
			String popUpName, String currentBenefitCategory) {
		clickOnConfirmDialogBtn(btnName);
		waitForProgressBarToDisapper();
		
		verifyUserIsOnPrevPage(currentBenefitCategory);
		verifyDraftIconWithUnsavedBenefitCategoryOnLeftMenu();
		return verifySubBenefitCategoriesAreUnchecked(
				CoreFunctions.getElementTextAndStoreInList(driver, _subBenefitCategories).toString());
	}

	public void verifyUserIsOnPrevPage(String currentBenefitCategory) {
		String prevCatName = getPreviousCategoryPagename(currentBenefitCategory);
		
		if (prevCatName.equalsIgnoreCase(getCurrentBenefitCategoryName(prevCatName))) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_NAVIGATED_TO_PREV_PAGE, CoreConstants.PASS,
					prevCatName));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_NAVIGATED_TO_PREV_PAGE, CoreConstants.FAIL,
					prevCatName, getCurrentBenefitCategoryName(prevCatName)));
		}
	}

	public String getPreviousCategoryPagename(String currentBenefitCategory) {
		String prevPageName = null;
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listBenefitCategoryNameOnLeftMenu,
					currentBenefitCategory);
			
			if (index > 0)
				prevPageName = _listBenefitCategoryNameOnLeftMenu.get(index - 1).getText();
			else
				Assert.fail(" Oops Navigated to first page i.e. General Information");
		} catch (Exception e) {

		}
		return prevPageName;
	}

	public boolean verifySaveBtnFunctionalityOnClickingBACKBtn(PDT_ViewPolicyPage viewPolicyPage, String btnName,
			String benefitCategoryName, PDT_GeneralInformationPage generalInfoPage, String popUpName) {
		clickOnBtn(PDTConstants.BACK.toUpperCase());
		clickOnConfirmDialogBtn(btnName.toUpperCase());
		waitForProgressBarToDisapper();
		verifyUserIsOnPrevPage(benefitCategoryName);
		verifySavedIndicatorForBenefit(benefitCategoryName);
		if (getPolicyStatusWithIcon().equalsIgnoreCase(PDTConstants.DRAFT_CHECK_CIRCLE)) {
			CoreFunctions.highlightObject(driver, _policyStat);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DATA_SAVED, CoreConstants.PASS));
			return true;
		}
		return false;
	}

	public void verifyExitBtnOnReadOnlyMode(String pageName, String buttons, List<List<String>> pagesList,
			PDT_ViewPolicyPage viewPolicyPage) {
		String btnArr[] = buttons.split("/");
		for (int i = 0; i < btnArr.length; i++) {
			navigatePages(pagesList, btnArr[i], viewPolicyPage);
		}

	}

	public void verifyPageName(String pageName) {
		try {
			if (_benefitCategoryName.getText().equalsIgnoreCase(pageName))
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_HE_IS_ON_PAGE, CoreConstants.PASS, pageName));
			else
				Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_HE_IS_ON_PAGE, CoreConstants.FAIL,
						pageName, _benefitCategoryName.getText()));

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_HE_IS_ON_PAGE, CoreConstants.FAIL, pageName,
					_benefitCategoryName.getText()));
		}

	}

	public boolean verifyExitDialogNotDisplayed() {
		try {
			if (_dialogconfirmation.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void verifyPageNameAndClickOnBtn(String pageName, String btn, PDT_ViewPolicyPage viewPolicyPage) {
		try {
			if (_benefitCategoryName.getText().equalsIgnoreCase(pageName)) {
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_HE_IS_ON_PAGE, CoreConstants.PASS, pageName));
				clickOnBtn(btn);
				if (!verifyExitDialogNotDisplayed())
					Reporter.addStepLog(
							MessageFormat.format(PDTConstants.VERIFIED_EXIT_MODAL_NOT_DISPLAYED, CoreConstants.PASS));
				else
					Assert.fail(MessageFormat.format(PDTConstants.VERIFIED_EXIT_MODAL_DISPLAYED, CoreConstants.FAIL));
				waitForProgressBarToDisapper();
				verifyPageName(PDTConstants.VIEW_EDIT_POLICY_FORMS);
				viewPolicyPage.searchByPolicyNameAndClickPolicy(
						ClientPolicyDetails.getPolicyName().split("\\(#")[0].trim(),
						PDTConstants.VIEW_EDIT_POLICY_FORMS);

			} else {
				waitForProgressBarToDisapper();
				CoreFunctions.selectItemInListByText(driver, _listLeftMenu, pageName);
				waitForProgressBarToDisapper();
				verifyPageName(pageName);
				clickOnBtn(btn);
				if (!verifyExitDialogNotDisplayed())
					Reporter.addStepLog(
							MessageFormat.format(PDTConstants.VERIFIED_EXIT_MODAL_NOT_DISPLAYED, CoreConstants.PASS));
				else
					Reporter.addStepLog(
							MessageFormat.format(PDTConstants.VERIFIED_EXIT_MODAL_DISPLAYED, CoreConstants.FAIL));
				waitForProgressBarToDisapper();
				verifyPageName(PDTConstants.VIEW_EDIT_POLICY_FORMS);
				viewPolicyPage.searchByPolicyNameAndClickPolicy(
						ClientPolicyDetails.getPolicyName().split("\\(#")[0].trim(),
						PDTConstants.VIEW_EDIT_POLICY_FORMS);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_HE_IS_ON_PAGE, CoreConstants.FAIL, pageName,
					_benefitCategoryName.getText()));
		}

	}

	public void navigatePages(List<List<String>> pagesList, String btn, PDT_ViewPolicyPage viewPolicyPage) {
		waitForProgressBarToDisapper();
		for (int i = 0; i < pagesList.size(); i++) {
			for (int j = 0; j < pagesList.get(i).size(); j++)
				verifyPageNameAndClickOnBtn(pagesList.get(i).get(j), btn, viewPolicyPage);
		}
	}

	public boolean iterateBenefitCategoriesAndVerifyGrossUpReimbursedBy(ArrayList<String> benefitCategories,
			PDT_SharedSubBenefit_Steps subBenefitStep) {
		ArrayList<Boolean> resultBenefitCatList = new ArrayList<Boolean>();
		populateBtnMap();
		Collections.reverse(benefitCategories);
		for (String bc : benefitCategories) {
			// CoreFunctions.clickUsingJS(driver, buttonMap.get(PDTConstants.BACK),
			// PDTConstants.BACK);
			resultBenefitCatList.addAll(iterateBenefitsAndVerifyGrossUpReimbursedBy(bc,
					BusinessFunctions.getSubBenefitList(bc), subBenefitStep));
			CoreFunctions.clickUsingJS(driver, buttonMap.get(PDTConstants.BACK.toUpperCase()),
					PDTConstants.BACK.toUpperCase());
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		}
		boolean result = resultBenefitCatList.stream().allMatch(t -> t.equals(true)) ? true : false;
		return result;
	}

	public ArrayList<Boolean> iterateBenefitsAndVerifyGrossUpReimbursedBy(String benefitCategory,
			ArrayList<String> benefits, PDT_SharedSubBenefit_Steps subBenefitStep) {
		ArrayList<Boolean> result = new ArrayList<Boolean>();
		for (String benefit : benefits) {
			result.add(verifyEachBenefitForGrossUpAndReimbursedBy(benefitCategory, benefit, subBenefitStep));
		}
		return result;
	}

	public boolean verifyEachBenefitForGrossUpAndReimbursedBy(String benefitCategory, String benefit,
			PDT_SharedSubBenefit_Steps subBenefitStep) {
		boolean verificationResult = false;
		switch (benefit) {
		case (PDTConstants.CULTURAL_TRAINING_EMPLOYEE):
			verificationResult = subBenefitStep.getCulturalTrainingPage()
					.verifyGrossUpAndReimbursedByForEmployee(benefitCategory, benefit);
			break;
		case (PDTConstants.CULTURAL_TRAINING_FAMILY):
			verificationResult = subBenefitStep.getCulturalTrainingPage()
					.verifyGrossUpAndReimbursedByForFamily(benefitCategory, benefit);
			break;
		case (PDTConstants.LANGUAGE_TRAINING_EMPLOYEE):
			verificationResult = subBenefitStep.getLanguageTrainingPage()
					.verifyGrossUpAndReimbursedByForEmployee(benefitCategory, benefit);
			break;
		case (PDTConstants.LANGUAGE_TRAINING_FAMILY):
			verificationResult = subBenefitStep.getLanguageTrainingPage()
					.verifyGrossUpAndReimbursedByForFamily(benefitCategory, benefit);
			break;
		default:
			Assert.fail("Functionality not implemented for:-" + benefit);
		}
		return verificationResult;
	}

	public boolean navigateBenefitCategory(String subBenefit,
			PDT_SharedSubBenefit_Steps subBenefitSteps, String pageName,
			PDT_GeneralInformationPage generalInfoPage, DataTable resultTable) {
		boolean result = false;
		switch (pageName) {
		case PDTConstants.PRE_ACCEPTANCE_SERVICES:
			result = subBenefitSteps.getPreAcceptServicePage().verifyPreAcceptanceSubBenefitForTransportType(pageName, subBenefit,
					resultTable);
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP:
			result = subBenefitSteps.getHouseHuntingTripPage().verifyHouseHuntingSubBenefitForTransportType(pageName, subBenefit,
					resultTable);
			break;
		case PDTConstants.FINAL_MOVE:
			result = subBenefitSteps.getFinalMovePage().verifyFinalMoveSubBenefitForTransportType(pageName, subBenefit,
					resultTable);
			break;
		case PDTConstants.HOME_LEAVE:
			result = subBenefitSteps.getHomeLeavePage().verifyHomeLeaveSubBenefitForTransportType(pageName, subBenefit, resultTable);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return result;
	}

	public boolean iterateBenefits(List<Map<String, String>> benefitsMap, PDT_SharedSubBenefit_Steps subBenefitSteps,
			PDT_SharedSubBenefitPage subBenefitPage, PDT_GeneralInformationPage generalInfoPage, DataTable resultTable) {
		ArrayList<Boolean> result = new ArrayList<Boolean>();
		for (int i = 0; i < benefitsMap.size(); i++) {
			verifySelectedPolicyBenefitCategoryName(benefitsMap.get(i).get("BenefitCategories"));
			result.add(navigateBenefitCategory(benefitsMap.get(i).get("Benefit"),  subBenefitSteps,
					benefitsMap.get(i).get("BenefitCategories"), generalInfoPage, resultTable));
		}
		return  result.stream().allMatch(t -> t.equals(true)) ? true : false;
	}
}
