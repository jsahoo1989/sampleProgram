package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_AssignmentHousingBenefit;

public class PDT_AssignmentHousingPage extends Base {
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
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignCurrency'] span.ng-option-label")
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
	
	PDT_AssignmentHousingBenefit assignmentHousingBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getAssignmentHousingDataList("Assignment Housing");
	
	public void fillAssignmentHousingForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
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

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					assignmentHousingBenefitData.assignmentHousing.reimbursedBy, _txtBoxReimbursedByOther,
					assignmentHousingBenefitData.assignmentHousing.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaAssignmentFeesComment, PDTConstants.COMMENT,
					assignmentHousingBenefitData.assignmentHousing.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillSecurityDepositForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnSecurityDeposit);
			CoreFunctions.selectItemInListByText(driver, _radioBtnSecurityDeposit,
					assignmentHousingBenefitData.securityDeposit.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					assignmentHousingBenefitData.securityDeposit.reimbursedBy, _txtBoxSecurityDepositReimbursedByOther,
					assignmentHousingBenefitData.securityDeposit.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaSecurityDepositComment, PDTConstants.COMMENT,
					assignmentHousingBenefitData.securityDeposit.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillAssignmentFinderFeesForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnFinderFees);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinderFees,
					assignmentHousingBenefitData.finderFees.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinderFees,
					assignmentHousingBenefitData.finderFees.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					assignmentHousingBenefitData.finderFees.reimbursedBy, _txtBoxFinderFeesReimbursedByOther,
					assignmentHousingBenefitData.finderFees.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaFinderFeesComment, PDTConstants.COMMENT,
					assignmentHousingBenefitData.finderFees.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
}
