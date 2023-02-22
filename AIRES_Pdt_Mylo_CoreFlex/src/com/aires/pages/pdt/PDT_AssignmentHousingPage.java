package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_AssignmentHousingBenefit;

import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_AssignmentHousingPage extends PDT_SharedSubBenefitPage {
	public PDT_AssignmentHousingPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(how=How.XPATH, using="//input[@formcontrolname='assignMaxAmount']/preceding-sibling::label")
	private WebElement _lblMaxAmount;
	
	@FindBy(how=How.CSS, using = "input[formcontrolname='assignMaxAmount']")
	private WebElement _txtBoxMaxAmount;
	
	@FindBy(how = How.CSS, using = "app-housing-child label.form-check-label")
	private List<WebElement> _radioBtnAssignmentFees;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignCurrency']")
	private WebElement _drpDownCurrency;
	
	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownCurrencyOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignCurrency'] span.ng-value-label")
	private WebElement _drpDownCurrencyOptionsSelected;
	
	@FindBy(how = How.CSS, using = "app-housing-child input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-housing-child textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaAssignmentFeesComment;
	
	//Security
	@FindBy(how = How.CSS, using = "app-security-child label.form-check-label")
	private List<WebElement> _radioBtnSecurityDeposit;
	
	@FindBy(how = How.CSS, using = "app-security-child input[formcontrolname='paidByOther']")
	private WebElement _txtBoxSecurityDepositReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-security-child textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaSecurityDepositComment;
	
	//Finder Fees
	@FindBy(how = How.CSS, using = "app-fee-child label.form-check-label")
	private List<WebElement> _radioBtnFinderFees;
	
	@FindBy(how = How.CSS, using = "app-fee-child input[formcontrolname='paidByOther']")
	private WebElement _txtBoxFinderFeesReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-fee-child textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaFinderFeesComment;
	
	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseOne1']")
	private WebElement _formHeaderAssignmentHousing;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formHeaderSecurityDeposit;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _formHeaderFindersFees;
	
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;
	
	PDT_AssignmentHousingBenefit assignmentHousingBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getAssignmentHousingDataList("Assignment Housing");
	
	/**
	 * Add the Form Header of Assignment Housing sub-benefit in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.ASSIGNMENT_HOUSING, _formHeaderAssignmentHousing);
		subBenefitHeaderMap.put(PDTConstants.SECURITY_DEPOSIT, _formHeaderSecurityDeposit);
		subBenefitHeaderMap.put(PDTConstants.ASSIGNMENT_FINDER_FEES, _formHeaderFindersFees);
	}
	
	public void fillAssignmentHousingForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblMaxAmount,
					_lblMaxAmount.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmount, _lblMaxAmount.getText(),
					assignmentHousingBenefitData.assignmentHousing.maxAmount);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnAssignmentFees);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAssignmentFees,
					assignmentHousingBenefitData.assignmentHousing.detail, PDTConstants.DETAIL,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.clickElement(driver, _drpDownCurrency);
			CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyOptions,
					assignmentHousingBenefitData.assignmentHousing.currency, PDTConstants.CURRENCY,
					PDTConstants.DROP_DOWN, true);
			
			
			CoreFunctions.selectItemInListByText(driver, _radioBtnAssignmentFees,
					assignmentHousingBenefitData.assignmentHousing.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAssignmentFees,
					assignmentHousingBenefitData.assignmentHousing.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, assignmentHousingBenefitData.assignmentHousing.reimbursedBy, _txtBoxReimbursedByOther,
					assignmentHousingBenefitData.assignmentHousing.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaAssignmentFeesComment, PDTConstants.COMMENT,
					assignmentHousingBenefitData.assignmentHousing.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillSecurityDepositForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnSecurityDeposit);
			CoreFunctions.selectItemInListByText(driver, _radioBtnSecurityDeposit,
					assignmentHousingBenefitData.securityDeposit.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					assignmentHousingBenefitData.securityDeposit.reimbursedBy, _txtBoxSecurityDepositReimbursedByOther,
					assignmentHousingBenefitData.securityDeposit.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaSecurityDepositComment, PDTConstants.COMMENT,
					assignmentHousingBenefitData.securityDeposit.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillAssignmentFinderFeesForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnFinderFees);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinderFees,
					assignmentHousingBenefitData.finderFees.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinderFees,
					assignmentHousingBenefitData.finderFees.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					assignmentHousingBenefitData.finderFees.reimbursedBy, _txtBoxFinderFeesReimbursedByOther,
					assignmentHousingBenefitData.finderFees.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaFinderFeesComment, PDTConstants.COMMENT,
					assignmentHousingBenefitData.finderFees.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillAssignmentHousingSubBenefit(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefitPage subBenefitPage) {		
		switch (subBenefit) {
		case PDTConstants.ASSIGNMENT_HOUSING:
			fillAssignmentHousingForm(addNewPolicyPage,	subBenefit, pageName);
			break;
		case PDTConstants.SECURITY_DEPOSIT:
			fillSecurityDepositForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.ASSIGNMENT_FINDER_FEES:
			fillAssignmentFinderFeesForm(addNewPolicyPage, subBenefit, pageName);
			break;			
		default:
			Assert.fail(MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}		
	}
	
	/**
	 * Iterate Assignment Housing sub-benefits and fill their corresponding form.
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage 
	 */
	public void iterateAndFillAssignmentHousingSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep, String btnName, PDT_SharedSubBenefitPage subBenefitPage) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);			
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		WebElement btnToClick = (btnName != null) ?  buttonMap.get(btnName) : buttonMap.get(PDTConstants.SAVE);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			fillAssignmentHousingSubBenefit(subBenefit, pageName, addNewPolicyPage, subBenefitPage);
		}
		try {
			CoreFunctions.click(driver, btnToClick, btnToClick.getText());
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}
	}
}
