package com.aires.pages.pdt;

import java.text.MessageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_CompensationServicesBenefit;

public class PDT_CompensationServicesPage extends Base{
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
	
	PDT_CompensationServicesBenefit compensationServicesBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getCompensationServicesDataList("Compensation Services");
	
	public void fillLetterOfAssignmentForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaLetterOfAssignmentTaxComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaLetterOfAssignmentTaxComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.letterOfAssignment.comment);
		} catch (Exception e) {			
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillCostEstimateWithTaxForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaCostEstimateWithTaxComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaCostEstimateWithTaxComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.costEstimateWithTax.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillCostEstimateWithoutTaxForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaCostEstimateWithoutTaxComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaCostEstimateWithoutTaxComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.costEstimateWithoutTax.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillBalanceSheetForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaBalanceSheetComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaBalanceSheetComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.balanceSheet.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillAllowanceUpdateForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaAllowanceUpdateComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaAllowanceUpdateComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.allowanceUpdates.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillGlobalDataCollectionForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaGlobalDataCollectionComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaGlobalDataCollectionComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.globalDataCollection.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillPayrollInstructionsForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtAreaPayrollInstructionsComment,
					PDTConstants.COMMENT);
			CoreFunctions.clearAndSetText(driver, _txtAreaPayrollInstructionsComment, PDTConstants.COMMENT,
					compensationServicesBenefitData.payrollInstructions.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
}
