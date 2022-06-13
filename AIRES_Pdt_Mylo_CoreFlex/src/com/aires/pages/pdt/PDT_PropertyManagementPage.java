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
import com.aires.testdatatypes.pdt.PDT_PropertyManagementBenefit;

public class PDT_PropertyManagementPage extends Base {
	public PDT_PropertyManagementPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='calculationMethodCode']")
	private WebElement _drpDownCalculationMethod;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='calculationMethodCode'] span.ng-option-label")
	private List<WebElement> _drpDownCalculationMethodOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='calculationMethodCode'] span.ng-value-label")
	private WebElement _drpDownCalculationMethodOptionSelected;

	@FindBy(how = How.CSS, using = "input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxCalculationMethodOther;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountCode']")
	private WebElement _txtBoxMaxAmt;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownCurrencyOptionSelected;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownFrequency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='frequencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownFrequencyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownFrequencyOptionSelected;

	@FindBy(how = How.CSS, using = "input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxFrequencyOther;

	@FindBy(how = How.CSS, using = "button.btn-next[type='submit']")
	private WebElement _btnSaveAndContinue;

	private String calcMethod, frequency;
	PDT_PropertyManagementBenefit propManagementBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getPropertyManagementDataList("Property Management");

	public void setCalcMethod(String calcMethodSelected) {
		calcMethod = calcMethodSelected;
	}

	public String getCalcMethod() {
		return calcMethod;
	}

	public void setFrequency(String frequencySelected) {
		frequency = frequencySelected;
	}

	public String getFrequency() {
		return frequency;
	}

	public void fillPropertyManagementForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownCalculationMethodOptions);
			String randCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownCalculationMethod, _drpDownCalculationMethodOptions,
					_drpDownCalculationMethodOptionSelected, PDTConstants.CALCULATION_METHOD);
			setCalcMethod(randCalcMethod);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownCalculationMethodOptionSelected, PDTConstants.CALCULATION_METHOD,
					_txtBoxCalculationMethodOther, PDTConstants.OTHER_CALCULATION_METHOD,
					propManagementBenefitData.otherCalculationMethod);

			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmt, propManagementBenefitData.maxAmount);
			CoreFunctions.clickElement(driver, _drpDownCurrency);
			CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyOptions, propManagementBenefitData.currency,
					PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);

			Assert.assertTrue(BusinessFunctions.verifyDefaultOptionIsSelectedInDrpDown(_drpDownFrequencyOptionSelected.getText(),
					PDTConstants.MONTHLY, PDTConstants.FREQUENCY), MessageFormat.format(PDTConstants.VERIFIED_DEFAULT_OPTION_NOT_SELECTED,
							CoreConstants.FAIL, PDTConstants.MONTHLY, PDTConstants.FREQUENCY));

			String randFrequency = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownFrequency, _drpDownFrequencyOptions, _drpDownFrequencyOptionSelected,
					PDTConstants.FREQUENCY);
			setFrequency(randFrequency);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownFrequencyOptionSelected, PDTConstants.FREQUENCY, _txtBoxFrequencyOther,
					PDTConstants.OTHER_FREQUENCY, propManagementBenefitData.frequencyOther);
			CoreFunctions.click(driver, _btnSaveAndContinue, _btnSaveAndContinue.getText());
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}
}
