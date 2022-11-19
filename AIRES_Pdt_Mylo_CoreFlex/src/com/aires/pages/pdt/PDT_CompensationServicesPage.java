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
import com.aires.testdatatypes.pdt.PDT_CompensationServicesBenefit;

import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_CompensationServicesPage extends PDT_SharedSubBenefitPage{
	public PDT_CompensationServicesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "app-letter-of-assignment textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaLetterOfAssignmentTaxComment;
	
	@FindBy(how = How.CSS, using = "app-cost-estimate-with-tax textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCostEstimateWithTaxComment;
	
	@FindBy(how = How.CSS, using = "app-cost-estimate-without-tax textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCostEstimateWithoutTaxComment;
	
	@FindBy(how = How.CSS, using = "app-balance-sheets textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaBalanceSheetComment;
	
	@FindBy(how = How.CSS, using = "app-allowance-update textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaAllowanceUpdateComment;
	
	@FindBy(how = How.CSS, using = "app-global-data-collection textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaGlobalDataCollectionComment;
	
	@FindBy(how = How.CSS, using = "app-payroll-instructions textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaPayrollInstructionsComment;
	
	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseOne']")
	private WebElement _formHeaderLetterOfAssignment;

	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formHeaderCostEstimateWithTax;

	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _formHeaderCostEstimateWithoutTax;

	@FindBy(how = How.CSS, using = "a[href='#collapseFour']")
	private WebElement _formHeaderBalanceSheet;

	@FindBy(how = How.CSS, using = "a[href='#collapseFive']")
	private WebElement _formHeaderAllowanceUpdates;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseSix']")
	private WebElement _formHeaderGlobalDataCollection;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseSeven']")
	private WebElement _formHeaderPayrollInstructions;
	
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;
	
	PDT_CompensationServicesBenefit compensationServicesBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getCompensationServicesDataList("Compensation Services");
	
	/**
	 * Add the Form Header of Compensation Services sub-benefit in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.LETTER_OF_ASSIGNMENT, _formHeaderLetterOfAssignment);
		subBenefitHeaderMap.put(PDTConstants.COST_ESTIMATE_WITH_TAX, _formHeaderCostEstimateWithTax);
		subBenefitHeaderMap.put(PDTConstants.COST_ESTIMATE_WITHOUT_TAX, _formHeaderCostEstimateWithoutTax);
		subBenefitHeaderMap.put(PDTConstants.BALANCE_SHEET, _formHeaderBalanceSheet);
		subBenefitHeaderMap.put(PDTConstants.ALLOWANCE_UPDATES, _formHeaderAllowanceUpdates);
		subBenefitHeaderMap.put(PDTConstants.GLOBAL_DATA_COLLECTION, _formHeaderGlobalDataCollection);
		subBenefitHeaderMap.put(PDTConstants.PAYROLL_INSTRUCTIONS, _formHeaderPayrollInstructions);
	}
	
	public void fillCompensationServicesSubBenefit(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefitPage subBenefitPage) {
		switch(subBenefit) {
		case PDTConstants.LETTER_OF_ASSIGNMENT:
			fillLetterOfAssignmentForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.COST_ESTIMATE_WITH_TAX:
			fillCostEstimateWithTaxForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.COST_ESTIMATE_WITHOUT_TAX:
			fillCostEstimateWithoutTaxForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.BALANCE_SHEET:
			fillBalanceSheetForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.ALLOWANCE_UPDATES:
			fillAllowanceUpdateForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.GLOBAL_DATA_COLLECTION:
			fillGlobalDataCollectionForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.PAYROLL_INSTRUCTIONS:
			fillPayrollInstructionsForm(addNewPolicyPage, subBenefit, pageName);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}
	}
	
	public void fillLetterOfAssignmentForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaLetterOfAssignmentTaxComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaLetterOfAssignmentTaxComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.letterOfAssignment.comment);
		} catch (Exception e) {			
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillCostEstimateWithTaxForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaCostEstimateWithTaxComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaCostEstimateWithTaxComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.costEstimateWithTax.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillCostEstimateWithoutTaxForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaCostEstimateWithoutTaxComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaCostEstimateWithoutTaxComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.costEstimateWithoutTax.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillBalanceSheetForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaBalanceSheetComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaBalanceSheetComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.balanceSheet.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillAllowanceUpdateForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaAllowanceUpdateComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaAllowanceUpdateComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.allowanceUpdates.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillGlobalDataCollectionForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaGlobalDataCollectionComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaGlobalDataCollectionComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.globalDataCollection.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillPayrollInstructionsForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaPayrollInstructionsComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaPayrollInstructionsComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.payrollInstructions.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	/**
	 * Iterate Compensation Services Services sub-benefits and fill their corresponding form.
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage 
	 */
	public void iterateAndFillCompensationServicesSubBenefits(String pageName, List<String> subBenefits,
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
			fillCompensationServicesSubBenefit(subBenefit, pageName, addNewPolicyPage, subBenefitPage);
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
