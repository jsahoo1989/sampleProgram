package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
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
import com.aires.testdatatypes.pdt.PDT_OneTimePaymentBenefit;

import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_OneTimePaymentReimbursemenPage extends PDT_SharedSubBenefitPage {
	public PDT_OneTimePaymentReimbursemenPage(WebDriver driver) {
		super(driver);
	}

	// Miscellaneous Relocation Allowance
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='methodCode']/preceding-sibling::label")
	private WebElement _lblCalculationMethod;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='methodCode']")
	private WebElement _drpDownCalculationMethod;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='methodCode'] span.ng-option-label")
	private List<WebElement> _drpDownCalculationMethodOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='methodCode'] span.ng-value-label")
	private WebElement _drpDownCalculationMethodSelected;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='methodOther']/preceding-sibling::label")
	private WebElement _lblOtherCalculationMethod;

	@FindBy(how = How.CSS, using = "input[formcontrolname='methodOther']")
	private WebElement _txtBoxOtherCalculationMethod;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='maxAmount']/preceding-sibling::label")
	private WebElement _lblMaxAmt;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmount']")
	private WebElement _txtBoxMaxAmount;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='currencyCode']/preceding-sibling::label")
	private WebElement _lblCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownCurrencyOptionsSelected;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='frequencyCode']/preceding-sibling::label")
	private WebElement _lblFrequency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownFrequency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='frequencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownFrequencyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownFrequencyOptionsSelected;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='pmtTimeCode']/preceding-sibling::label")
	private WebElement _lblWhenToMakePayment;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='pmtTimeCode']")
	private WebElement _drpDownWhenToMakePayment;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='pmtTimeCode'] span.ng-option-label")
	private List<WebElement> _drpDownWhenToMakePaymentOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='pmtTimeCode'] span.ng-value-label")
	private WebElement _drpDownWhenToMakePaymentOptionsSelected;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='pmtTimeWeeksBeforeCode']/preceding-sibling::label")
	private WebElement _lblIndicateNumOfWeeksBefore;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='pmtTimeWeeksBeforeCode']")
	private WebElement _drpDownIndicateNumOfWeeksBefore;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='pmtTimeWeeksBeforeCode'] span.ng-option-label")
	private List<WebElement> _drpDownIndicateNumOfWeeksBeforeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='pmtTimeWeeksBeforeCode'] span.ng-value-label")
	private WebElement _drpDownIndicateNumOfWeeksBeforeSelected;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='pmtTimeWeeksBeforeOther']/preceding-sibling::label")
	private WebElement _lblIndicateNumOfWeeksBeforeOther;

	@FindBy(how = How.CSS, using = "input[formcontrolname='pmtTimeWeeksBeforeOther']")
	private WebElement _txtBoxIndicateNumOfWeeksBeforeOther;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='pmtTimeOther']/preceding-sibling::label")
	private WebElement _lblOtherPaymentType;

	@FindBy(how = How.CSS, using = "input[formcontrolname='pmtTimeOther']")
	private WebElement _txtBoxOtherPaymentType;

	@FindBy(how = How.CSS, using = "app-misc-relocation label.form-check-label")
	private List<WebElement> _radioBtnMiscRelocationAllowance;

	@FindBy(how = How.CSS, using = "app-misc-relocation input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-misc-relocation textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaMiscRelocationAllowanceComment;

	// Lump Sum
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='oneTimeCalMethodCode']/preceding-sibling::label")
	private WebElement _lblLumpSumCalculationMethod;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='oneTimeCalMethodCode']")
	private WebElement _drpDownLumpSumCalculationMethod;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='oneTimeCalMethodCode'] span.ng-option-label")
	private List<WebElement> _drpDownLumpSumCalculationMethodOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='oneTimeCalMethodCode'] span.ng-value-label")
	private WebElement _drpDownLumpSumCalculationMethodSelected;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='oneTimeCalMethodOther']/preceding-sibling::label")
	private WebElement _lblLumpSumOtherCalculationMethod;

	@FindBy(how = How.CSS, using = "input[formcontrolname='oneTimeCalMethodOther']")
	private WebElement _txtBoxLumpSumOtherCalculationMethod;

	@FindBy(how = How.XPATH, using = "//app-lump-sum//input[@formcontrolname='maxAmount']/preceding-sibling::label")
	private WebElement _lblLumpSumMaxAmt;

	@FindBy(how = How.CSS, using = "app-lump-sum input[formcontrolname='maxAmount']")
	private WebElement _txtBoxLumpSumMaxAmount;

	@FindBy(how = How.XPATH, using = "//app-lump-sum//ng-select[@formcontrolname='currencyCode']/preceding-sibling::label")
	private WebElement _lblLumpSumCurrency;

	@FindBy(how = How.CSS, using = "app-lump-sum ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownLumpSumCurrency;

	@FindBy(how = How.CSS, using = "app-lump-sum ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownLumpSumCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-lump-sum ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownLumpSumCurrencyOptionsSelected;

	@FindBy(how = How.XPATH, using = "//app-lump-sum//ng-select[@formcontrolname='frequencyCode']/preceding-sibling::label")
	private WebElement _lblLumpSumFrequency;

	@FindBy(how = How.CSS, using = "app-lump-sum ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownLumpSumFrequency;

	@FindBy(how = How.CSS, using = "app-lump-sum ng-select[formcontrolname='frequencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownLumpSumFrequencyOptions;

	@FindBy(how = How.CSS, using = "app-lump-sum ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownLumpSumFrequencyOptionsSelected;

	@FindBy(how = How.XPATH, using = "//app-lump-sum//input[@formcontrolname='frequencyOther']/preceding-sibling::label")
	private WebElement _lblLumpSumFrequencyOther;

	@FindBy(how = How.CSS, using = "app-lump-sum input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxOtherFrequency;

	@FindBy(how = How.XPATH, using = "//app-lump-sum//ng-select[@formcontrolname='pmtTimeCode']/preceding-sibling::label")
	private WebElement _lblLumpSumWhenToMakePayment;

	@FindBy(how = How.CSS, using = "app-lump-sum ng-select[formcontrolname='pmtTimeCode']")
	private WebElement _drpDownLumpSumWhenToMakePayment;

	@FindBy(how = How.CSS, using = "app-lump-sum ng-select[formcontrolname='pmtTimeCode'] span.ng-option-label")
	private List<WebElement> _drpDownLumpSumWhenToMakePaymentOptions;

	@FindBy(how = How.CSS, using = "app-lump-sum ng-select[formcontrolname='pmtTimeCode'] span.ng-value-label")
	private WebElement _drpDownLumpSumWhenToMakePaymentOptionsSelected;

	@FindBy(how = How.XPATH, using = "//app-lump-sum//ng-select[@formcontrolname='pmtTimeWeeksBeforeCode']/preceding-sibling::label")
	private WebElement _lblLumpSumIndicateNumOfWeeksBefore;

	@FindBy(how = How.CSS, using = "app-lump-sum ng-select[formcontrolname='pmtTimeWeeksBeforeCode']")
	private WebElement _drpDownLumpSumIndicateNumOfWeeksBefore;

	@FindBy(how = How.CSS, using = "app-lump-sum ng-select[formcontrolname='pmtTimeWeeksBeforeCode'] span.ng-option-label")
	private List<WebElement> _drpDownLumpSumIndicateNumOfWeeksBeforeOptions;

	@FindBy(how = How.CSS, using = "app-lump-sum ng-select[formcontrolname='pmtTimeWeeksBeforeCode'] span.ng-value-label")
	private WebElement _drpDownLumpSumIndicateNumOfWeeksBeforeSelected;

	@FindBy(how = How.XPATH, using = "//app-lump-sum//input[@formcontrolname='pmtTimeWeeksBeforeOther']/preceding-sibling::label")
	private WebElement _lblLumpSumIndicateNumOfWeeksBeforeOther;

	@FindBy(how = How.CSS, using = "app-lump-sum input[formcontrolname='pmtTimeWeeksBeforeOther']")
	private WebElement _txtBoxLumpSumIndicateNumOfWeeksBeforeOther;

	@FindBy(how = How.CSS, using = "app-lump-sum label.form-check-label")
	private List<WebElement> _radioBtnLumpSum;

	@FindBy(how = How.CSS, using = "app-lump-sum input[formcontrolname='paidByOther']")
	private WebElement _txtBoxLumpSumReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-lump-sum textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaLumpSumComment;

	// Lease Break
	@FindBy(how = How.XPATH, using = "//app-lease-break//ng-select[@formcontrolname='leaseBreakMaxMonthCode']/preceding-sibling::label")
	private WebElement _lblLeaseBreakMaxNumOfMonths;

	@FindBy(how = How.CSS, using = "app-lease-break ng-select[formcontrolname='leaseBreakMaxMonthCode']")
	private WebElement _drpDownLeaseBreakMaxNumOfMonths;

	@FindBy(how = How.CSS, using = "app-lease-break ng-select[formcontrolname='leaseBreakMaxMonthCode'] span.ng-option-label")
	private List<WebElement> _drpDownLeaseBreakMaxNumOfMonthsOptions;

	@FindBy(how = How.CSS, using = "app-lease-break ng-select[formcontrolname='leaseBreakMaxMonthCode'] span.ng-value-label")
	private WebElement _drpDownLeaseBreakMaxNumOfMonthsOptionsSelected;

	@FindBy(how = How.XPATH, using = "//app-lease-break//input[@formcontrolname='maxMonthOther']/preceding-sibling::label")
	private WebElement _lblLeaseBreakMaxNumOfMonthsOther;

	@FindBy(how = How.CSS, using = "app-lease-break input[formcontrolname='maxMonthOther']")
	private WebElement _txtBoxLeaseBreakMaxNumOfMonthsOther;

	@FindBy(how = How.XPATH, using = "//app-lease-break//input[@formcontrolname='maxAmount']/preceding-sibling::label")
	private WebElement _lblLeaseBreakMaxAmount;

	@FindBy(how = How.CSS, using = "app-lease-break input[formcontrolname='maxAmount']")
	private WebElement _txtBoxLeaseBreakMaxAmount;

	@FindBy(how = How.XPATH, using = "//app-lease-break//ng-select[@formcontrolname='currencyCode']/preceding-sibling::label")
	private WebElement _lblLeaseBreakCurrency;

	@FindBy(how = How.CSS, using = "app-lease-break ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownLeaseBreakCurrency;

	@FindBy(how = How.CSS, using = "app-lease-break ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownLeaseBreakCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-lease-break ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownLeaseBreakCurrencyOptionsSelected;

	@FindBy(how = How.XPATH, using = "//app-lease-break//ng-select[@formcontrolname='frequencyCode']/preceding-sibling::label")
	private WebElement _lblLeaseBreakFrequency;

	@FindBy(how = How.CSS, using = "app-lease-break ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownLeaseBreakFrequency;

	@FindBy(how = How.CSS, using = "app-lease-break ng-select[formcontrolname='frequencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownLeaseBreakFrequencyOptions;

	@FindBy(how = How.CSS, using = "app-lease-break ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownLeaseBreakFrequencyOptionsSelected;

	@FindBy(how = How.XPATH, using = "//app-lease-break//input[@formcontrolname='frequencyOther']/preceding-sibling::label")
	private WebElement _lblLeaseBreakFrequencyOther;

	@FindBy(how = How.CSS, using = "app-lease-break input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxLeaseBreakOtherFrequency;

	@FindBy(how = How.CSS, using = "app-lease-break label.form-check-label")
	private List<WebElement> _radioBtnLeaseBreak;

	@FindBy(how = How.CSS, using = "app-lease-break input[formcontrolname='paidByOther']")
	private WebElement _txtBoxLeaseBreakReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-lease-break textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaLeaseBreakComment;

	// Applicance Allowance
	@FindBy(how = How.XPATH, using = "//app-appliance-allowance//input[@formcontrolname='maxAmount']/preceding-sibling::label")
	private WebElement _lblApplAllowanceMaxAmount;

	@FindBy(how = How.CSS, using = "app-appliance-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxApplAllowanceMaxAmount;

	@FindBy(how = How.XPATH, using = "//app-appliance-allowance//ng-select[@formcontrolname='currencyCode']/preceding-sibling::label")
	private WebElement _lblApplAllowanceCurrency;

	@FindBy(how = How.CSS, using = "app-appliance-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownApplAllowanceCurrency;

	@FindBy(how = How.CSS, using = "app-appliance-allowance ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownApplAllowanceCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-appliance-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownApplAllowanceCurrencyOptionsSelected;

	@FindBy(how = How.XPATH, using = "//app-appliance-allowance//ng-select[@formcontrolname='frequencyCode']/preceding-sibling::label")
	private WebElement _lblApplAllowanceFrequency;

	@FindBy(how = How.CSS, using = "app-appliance-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownApplAllowanceFrequency;

	@FindBy(how = How.CSS, using = "app-appliance-allowance ng-select[formcontrolname='frequencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownApplAllowanceFrequencyOptions;

	@FindBy(how = How.CSS, using = "app-appliance-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownApplAllowanceFrequencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-appliance-allowance label.form-check-label")
	private List<WebElement> _radioBtnApplAllowance;

	@FindBy(how = How.CSS, using = "app-appliance-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxApplAllowanceReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-appliance-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaApplAllowanceComment;

	// Auto Registration Cost
	@FindBy(how = How.XPATH, using = "//app-auto-registration//input[@formcontrolname='maxAmount']/preceding-sibling::label")
	private WebElement _lblAutoRegCostMaxAmount;

	@FindBy(how = How.CSS, using = "app-auto-registration input[formcontrolname='maxAmount']")
	private WebElement _txtBoxAutoRegCostMaxAmount;

	@FindBy(how = How.XPATH, using = "//app-auto-registration//ng-select[@formcontrolname='currencyCode']/preceding-sibling::label")
	private WebElement _lblAutoRegCostCurrency;

	@FindBy(how = How.CSS, using = "app-auto-registration ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownAutoRegCostCurrency;

	@FindBy(how = How.CSS, using = "app-auto-registration ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownAutoRegCostCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-auto-registration ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownAutoRegCostCurrencyOptionsSelected;

	@FindBy(how = How.XPATH, using = "//app-auto-registration//ng-select[@formcontrolname='frequencyCode']/preceding-sibling::label")
	private WebElement _lblAutoRegCostFrequency;

	@FindBy(how = How.CSS, using = "app-auto-registration ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownAutoRegCostFrequency;

	@FindBy(how = How.CSS, using = "app-auto-registration ng-select[formcontrolname='frequencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownAutoRegCostFrequencyOptions;

	@FindBy(how = How.CSS, using = "app-auto-registration ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownAutoRegCostFrequencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-auto-registration label.form-check-label")
	private List<WebElement> _radioBtnAutoRegCost;

	@FindBy(how = How.CSS, using = "app-auto-registration input[formcontrolname='paidByOther']")
	private WebElement _txtBoxAutoRegCostReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-auto-registration textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaAutoRegCostComment;

	// Auto Loss on Sale
	@FindBy(how = How.XPATH, using = "//app-auto-loss-on-sale//ng-select[@formcontrolname='maxNumOfAuto']/preceding-sibling::label")
	private WebElement _lblMaxNumOfAutos;

	@FindBy(how = How.CSS, using = "app-auto-loss-on-sale ng-select[formcontrolname='maxNumOfAuto']")
	private WebElement _drpDownMaxNumOfAutos;

	@FindBy(how = How.CSS, using = "app-auto-loss-on-sale ng-select[formcontrolname='maxNumOfAuto'] span.ng-option-label")
	private List<WebElement> _drpDownMaxNumOfAutosOptions;

	@FindBy(how = How.CSS, using = "app-auto-loss-on-sale ng-select[formcontrolname='maxNumOfAuto'] span.ng-value-label")
	private WebElement _drpDownMaxNumOfAutosOptionsSelected;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='maxNumOfAutoOther']/preceding-sibling::label")
	private WebElement _lblMaxNumOfAutosOther;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxNumOfAutoOther']")
	private WebElement _txtBoxMaxNumOfAutosOther;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='maxAmountPerAuto']/preceding-sibling::label")
	private WebElement _lblMaxAmtPerAuto;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountPerAuto']")
	private WebElement _txtBoxMaxAmtPerAuto;

	@FindBy(how = How.XPATH, using = "//app-auto-loss-on-sale//ng-select[@formcontrolname='currencyCode']/preceding-sibling::label")
	private WebElement _lblAutoLossOnSaleCurrency;

	@FindBy(how = How.CSS, using = "app-auto-loss-on-sale ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownAutoLossOnSaleCurrency;

	@FindBy(how = How.CSS, using = "app-auto-loss-on-sale ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownAutoLossOnSaleCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-auto-loss-on-sale ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownAutoLossOnSaleCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-auto-loss-on-sale label.form-check-label")
	private List<WebElement> _radioBtnAutoLossOnSale;

	@FindBy(how = How.CSS, using = "app-auto-loss-on-sale input[formcontrolname='paidByOther']")
	private WebElement _txtBoxAutoLossOnSaleReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-auto-loss-on-sale textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaAutoLossOnSaleComment;

	// Other One Time Payment
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='pmtDesc']/preceding-sibling::label")
	private WebElement _lblPaymentDesc;

	@FindBy(how = How.CSS, using = "input[formcontrolname='pmtDesc']")
	private WebElement _txtBoxPaymentDesc;

	@FindBy(how = How.XPATH, using = "//app-other-onetime-payment//input[@formcontrolname='maxAmount']/preceding-sibling::label")
	private WebElement _lblOtherOneTimePaymentMaxAmt;

	@FindBy(how = How.CSS, using = "app-other-onetime-payment input[formcontrolname='maxAmount']")
	private WebElement _txtBoxOtherOneTimePaymentMaxAmt;

	@FindBy(how = How.XPATH, using = "//app-other-onetime-payment//ng-select[@formcontrolname='currencyCode']/preceding-sibling::label")
	private WebElement _lblOtherOneTimePaymentCurrency;

	@FindBy(how = How.CSS, using = "app-other-onetime-payment ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownOtherOneTimePaymentCurrency;

	@FindBy(how = How.CSS, using = "app-other-onetime-payment ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownOtherOneTimePaymentCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-other-onetime-payment ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownOtherOneTimePaymentCurrencyOptionsSelected;

	@FindBy(how = How.XPATH, using = "//app-other-onetime-payment//ng-select[@formcontrolname='frequencyCode']/preceding-sibling::label")
	private WebElement _lblOtherOneTimePaymentFrequency;

	@FindBy(how = How.CSS, using = "app-other-onetime-payment ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownOtherOneTimePaymentFrequency;

	@FindBy(how = How.CSS, using = "app-other-onetime-payment ng-select[formcontrolname='frequencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownOtherOneTimePaymentFrequencyOptions;

	@FindBy(how = How.CSS, using = "app-other-onetime-payment ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownOtherOneTimePaymentFrequencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-other-onetime-payment label.form-check-label")
	private List<WebElement> _radioBtnOtherOneTimePayment;

	@FindBy(how = How.CSS, using = "app-other-onetime-payment input[formcontrolname='paidByOther']")
	private WebElement _txtBoxOtherOneTimePaymentReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-other-onetime-payment textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaOtherOneTimePaymentComment;
	
	@FindBy(how = How.CSS, using = "a[data-target='#collapseOne']")
	private WebElement _formHeaderMiscRelocationAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseTwo']")
	private WebElement _formHeaderLumpSum;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseThree']")
	private WebElement _formHeaderLeaseBreak;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseFour']")
	private WebElement _formHeaderApplianceAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseFive']")
	private WebElement _formHeaderAutoRegistrationCost;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseSix']")
	private WebElement _formHeaderAutoLossOnSale;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseSeven']")
	private WebElement _formHeaderOtherOneTimePayment;
	
	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;
	
	@FindBy(how = How.CSS, using = "div#headingOne > div.displayHeaderSection >h5")
	private WebElement _headingMiscRelocationAllowance;
	
	@FindBy(how = How.CSS, using = "div#headingTwo > div.displayHeaderSection >h5")
	private WebElement _headingLumpSum;
	
	@FindBy(how = How.CSS, using = "div#headingThree > div.displayHeaderSection >h5")
	private WebElement _headingLeaseBreak;
	
	@FindBy(how = How.CSS, using = "div#headingFour > div.displayHeaderSection >h5")
	private WebElement _headingApplianceAllowance;	
	
	@FindBy(how = How.CSS, using = "div#headingFour > div.displayHeaderSection >h5")
	private WebElement _headingAutoRegCost;
	
	@FindBy(how = How.CSS, using = "div#headingFour > div.displayHeaderSection >h5")
	private WebElement _headingAutoLossOnSale;
	
	@FindBy(how = How.CSS, using = "div#headingFour > div.displayHeaderSection >h5")
	private WebElement _headingOtherOneTimePayment;

	PDT_OneTimePaymentBenefit oneTimePaymentBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getOneTimePaymentBenefitDataList("One Time Payments and Reimbursements");

	private String calcMethod, freqMiscReloAllowanace, whenToMakePaymentMiscReloAllowance,
			indicateNumOfWeeksBeforeMuscReloAllowance, calcMethodLumpSum, freqLumpSum, whenToMakePaymentLumpSum,
			numOfWeeksForLumpSum, maxNumOfMonthsLeaseBreak, freqLeaseBreak, freqApplAllowance, freqAutoRegCost,
			maxNumOfAutos, freqOtherOneTimePayment;

	public void setCalcMethod(String calcMethodSelected) {
		calcMethod = calcMethodSelected;
	}

	public String getCalcMethod() {
		return calcMethod;
	}

	public void setFreqMiscReloAllowanace(String freqSelected) {
		freqMiscReloAllowanace = freqSelected;
	}

	public String getFreqMiscReloAllowanace() {
		return freqMiscReloAllowanace;
	}

	public void setWhenToMakePaymentMiscReloAllowanace(String whenToMakePaymentSelected) {
		whenToMakePaymentMiscReloAllowance = whenToMakePaymentSelected;
	}

	public String getWhenToMakePaymentMiscReloAllowanace() {
		return whenToMakePaymentMiscReloAllowance;
	}

	public void setNumOfWeeksForMiscReloAllowanace(String indicateNumOfWeeksSelected) {
		indicateNumOfWeeksBeforeMuscReloAllowance = indicateNumOfWeeksSelected;
	}

	public String getsetNumOfWeeksForMiscReloAllowanace() {
		return indicateNumOfWeeksBeforeMuscReloAllowance;
	}

	public void setCalcMethodLumpSum(String calcMethodSelected) {
		calcMethodLumpSum = calcMethodSelected;
	}

	public String getCalcMethodLumpSum() {
		return calcMethodLumpSum;
	}

	public void setFreqLumpSum(String freqSelected) {
		freqLumpSum = freqSelected;
	}

	public String getFreqLumpSum() {
		return freqLumpSum;
	}

	public void setWhenToMakePaymentLumpSum(String whenToMakePaymentSelected) {
		whenToMakePaymentLumpSum = whenToMakePaymentSelected;
	}

	public String getWhenToMakePaymentLumpSum() {
		return whenToMakePaymentLumpSum;
	}

	public void setNumOfWeeksForLumpSum(String NumOfWeeksForLumpSumSelected) {
		numOfWeeksForLumpSum = NumOfWeeksForLumpSumSelected;
	}

	public String getNumOfWeeksForLumpSum() {
		return numOfWeeksForLumpSum;
	}

	public void setMaxNumOfMonthsLeaseBreak(String maxNumOfMonthsLeaseBreakSelected) {
		maxNumOfMonthsLeaseBreak = maxNumOfMonthsLeaseBreakSelected;
	}

	public String getMaxNumOfMonthsLeaseBreak() {
		return maxNumOfMonthsLeaseBreak;
	}

	public void setFreqLeaseBreak(String freqLeaseBreakSelected) {
		freqLeaseBreak = freqLeaseBreakSelected;
	}

	public String getFreqLeaseBreak() {
		return freqLeaseBreak;
	}

	public void setFreqApplAllowance(String freqApplAllowanceSelected) {
		freqApplAllowance = freqApplAllowanceSelected;
	}

	public String getFreqApplAllowance() {
		return freqApplAllowance;
	}

	public void setFreqAutoRegCost(String freqAutoRegCostSelected) {
		freqAutoRegCost = freqAutoRegCostSelected;
	}

	public String getFreqAutoRegCost() {
		return freqAutoRegCost;
	}

	public void setMaxNumOfAutos(String maxNumOfAutosSelected) {
		maxNumOfAutos = maxNumOfAutosSelected;
	}

	public String getMaxNumOfAutos() {
		return maxNumOfAutos;
	}

	public void setFreqOtherOneTimePayment(String freqOtherOneTimePaymentSelected) {
		freqOtherOneTimePayment = freqOtherOneTimePaymentSelected;
	}

	public String getFreqOtherOneTimePayment() {
		return freqOtherOneTimePayment;
	}
	
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.MISC_RELOCATION_ALLOWANCE, _formHeaderMiscRelocationAllowance);
		subBenefitHeaderMap.put(PDTConstants.LUMP_SUM, _formHeaderLumpSum);
		subBenefitHeaderMap.put(PDTConstants.LEASE_BREAK, _formHeaderLeaseBreak);
		subBenefitHeaderMap.put(PDTConstants.APPLIANCE_ALLOWANCE, _formHeaderApplianceAllowance);
		subBenefitHeaderMap.put(PDTConstants.AUTO_REGISTRATION_COSTS, _formHeaderAutoRegistrationCost);
		subBenefitHeaderMap.put(PDTConstants.AUTO_LOSS_ON_SALE, _formHeaderAutoLossOnSale);
		subBenefitHeaderMap.put(PDTConstants.OTHER_ONE_TIME_PAYMENT, _formHeaderOtherOneTimePayment);
	}
	
	public void populateSubBenefitHeadingMap() {
		subBenefitHeadingMap.put(PDTConstants.MISC_RELOCATION_ALLOWANCE, _headingMiscRelocationAllowance);
		subBenefitHeadingMap.put(PDTConstants.LUMP_SUM, _headingLumpSum);
		subBenefitHeadingMap.put(PDTConstants.LEASE_BREAK, _headingLeaseBreak);
		subBenefitHeadingMap.put(PDTConstants.APPLIANCE_ALLOWANCE, _headingApplianceAllowance);
		subBenefitHeadingMap.put(PDTConstants.AUTO_REGISTRATION_COSTS, _headingAutoRegCost);
		subBenefitHeadingMap.put(PDTConstants.AUTO_LOSS_ON_SALE, _headingAutoLossOnSale);
		subBenefitHeadingMap.put(PDTConstants.OTHER_ONE_TIME_PAYMENT, _headingOtherOneTimePayment);
		
	}

	public void expandSubBenefitIfCollapsed(String subBenefitFormName, WebElement element) {
		if (subBenefitHeaderMap.get(subBenefitFormName).getAttribute("class").equalsIgnoreCase("collapsed"))
			CoreFunctions.clickElement(driver, element);
	}
	
	public void fillMiscRelocationAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownCalculationMethodOptions);
			String randCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownCalculationMethod, _drpDownCalculationMethodOptions,
					_drpDownCalculationMethodSelected,
					CoreFunctions.getLabelOfElement(driver, By.cssSelector("ng-select[formcontrolname='methodCode']"))
							.getText());
			setCalcMethod(randCalcMethod);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownCalculationMethodSelected, _lblCalculationMethod.getText(), _txtBoxOtherCalculationMethod,
					PDTConstants.OTHER_CALCULATION_METHOD,
					oneTimePaymentBenefitData.miscReloAllowance.otherCalculationMethod);
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmount, _lblMaxAmt.getText(),
					oneTimePaymentBenefitData.miscReloAllowance.maxAmount);
			CoreFunctions.clickElement(driver, _drpDownCurrency);
			CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyOptions,
					oneTimePaymentBenefitData.miscReloAllowance.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN,
					true);
			String randFrequency = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownFrequency, _drpDownFrequencyOptions, _drpDownFrequencyOptionsSelected,
					_lblFrequency.getText());
			setFreqMiscReloAllowanace(randFrequency);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnMiscRelocationAllowance);
			CoreFunctions.selectItemInListByText(driver, _radioBtnMiscRelocationAllowance,
					oneTimePaymentBenefitData.miscReloAllowance.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);

			String randWhenToMakePayment = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownWhenToMakePayment, _drpDownWhenToMakePaymentOptions,
					_drpDownWhenToMakePaymentOptionsSelected, _lblWhenToMakePayment.getText());
			setWhenToMakePaymentMiscReloAllowanace(randWhenToMakePayment);

			if (BusinessFunctions.verifyDisplayOfIndicateNumOfWeeksBefore(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownWhenToMakePaymentOptionsSelected, _lblWhenToMakePayment.getText(),
					_drpDownIndicateNumOfWeeksBefore)) {

				String randIndicateNumOfWeeksFormMiscReloAllowance = BusinessFunctions
						.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage, subBenefitFormName,
								_drpDownIndicateNumOfWeeksBefore, _drpDownIndicateNumOfWeeksBeforeOptions,
								_drpDownIndicateNumOfWeeksBeforeSelected, _lblIndicateNumOfWeeksBefore.getText());

				setNumOfWeeksForMiscReloAllowanace(randIndicateNumOfWeeksFormMiscReloAllowance);

				BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage,
						subBenefitFormName, _drpDownIndicateNumOfWeeksBeforeSelected,
						_lblIndicateNumOfWeeksBefore.getText(), _txtBoxIndicateNumOfWeeksBeforeOther,
						PDTConstants.INDICATE_NUM_OF_WEEKS_BEFORE,
						oneTimePaymentBenefitData.miscReloAllowance.otherNumOfWeeksBefore);
			}

			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownWhenToMakePaymentOptionsSelected, _lblWhenToMakePayment.getText(), _txtBoxOtherPaymentType,
					PDTConstants.OTHER_PAYMENT_TIME, oneTimePaymentBenefitData.miscReloAllowance.otherPaymentTime);

			CoreFunctions.selectItemInListByText(driver, _radioBtnMiscRelocationAllowance,
					oneTimePaymentBenefitData.miscReloAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					oneTimePaymentBenefitData.miscReloAllowance.reimbursedBy, _txtBoxReimbursedByOther,
					oneTimePaymentBenefitData.miscReloAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaMiscRelocationAllowanceComment, PDTConstants.COMMENT,
					oneTimePaymentBenefitData.miscReloAllowance.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillLumpSum(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownLumpSumCalculationMethodOptions);
			String randCalcMethodLumpSum = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownLumpSumCalculationMethod,
					_drpDownLumpSumCalculationMethodOptions, _drpDownLumpSumCalculationMethodSelected,
					_lblLumpSumCalculationMethod.getText());
			setCalcMethodLumpSum(randCalcMethodLumpSum);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownLumpSumCalculationMethodSelected, _lblLumpSumCalculationMethod.getText(),
					_txtBoxLumpSumOtherCalculationMethod, PDTConstants.OTHER_CALCULATION_METHOD,
					oneTimePaymentBenefitData.lumpSum.otherCalculationMethod);

			CoreFunctions.selectItemInListByText(driver, _radioBtnLumpSum, oneTimePaymentBenefitData.lumpSum.grossUp,
					PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST, true);

			if (_drpDownLumpSumCalculationMethodSelected.getText().equalsIgnoreCase(PDTConstants.FLAT_AMT)) {
				BusinessFunctions.verifyTextBoxIsDisplayedAndEnterTextBoxVal(driver, addNewPolicyPage,
						subBenefitFormName, _txtBoxLumpSumMaxAmount, _lblLumpSumMaxAmt.getText(),
						PDTConstants.MAX_AMOUNT, oneTimePaymentBenefitData.lumpSum.whenToMakePayment);
				BusinessFunctions.verifyDrpDownIsDisplayedAndSelectDropDownVal(driver, addNewPolicyPage,
						subBenefitFormName, _drpDownLumpSumCurrency, _drpDownLumpSumCurrencyOptions,
						_lblLumpSumCurrency.getText(), PDTConstants.CURRENCY,
						oneTimePaymentBenefitData.lumpSum.currency);

				String randFrequencyLumpSum = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
						addNewPolicyPage, subBenefitFormName, _drpDownLumpSumFrequency, _drpDownLumpSumFrequencyOptions,
						_drpDownLumpSumFrequencyOptionsSelected, _lblLumpSumFrequency.getText());
				setFreqLumpSum(randFrequencyLumpSum);
				BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage,
						subBenefitFormName, _drpDownLumpSumFrequencyOptionsSelected, _lblLumpSumFrequency.getText(),
						_txtBoxOtherFrequency, PDTConstants.OTHER_FREQUENCY,
						oneTimePaymentBenefitData.lumpSum.otherFrequency);
			}

			// Select when to make payment for lump sum.
			String randWhenToMakePaymentLumpSum = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownLumpSumWhenToMakePayment,
					_drpDownLumpSumWhenToMakePaymentOptions, _drpDownLumpSumWhenToMakePaymentOptionsSelected,
					_lblLumpSumWhenToMakePayment.getText());
			setWhenToMakePaymentLumpSum(randWhenToMakePaymentLumpSum);
			if (BusinessFunctions.verifyDisplayOfIndicateNumOfWeeksBefore(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownLumpSumWhenToMakePaymentOptionsSelected, _lblLumpSumWhenToMakePayment.getText(),
					_drpDownLumpSumIndicateNumOfWeeksBefore)) {
				String randIndicateNumOfWeeksLumpSum = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
						addNewPolicyPage, subBenefitFormName, _drpDownLumpSumIndicateNumOfWeeksBefore,
						_drpDownLumpSumIndicateNumOfWeeksBeforeOptions, _drpDownLumpSumIndicateNumOfWeeksBeforeSelected,
						_lblLumpSumIndicateNumOfWeeksBefore.getText());
				setNumOfWeeksForLumpSum(randIndicateNumOfWeeksLumpSum);
				BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage,
						subBenefitFormName, _drpDownLumpSumIndicateNumOfWeeksBeforeSelected,
						_lblLumpSumIndicateNumOfWeeksBefore.getText(), _txtBoxLumpSumIndicateNumOfWeeksBeforeOther,
						PDTConstants.OTHER,
						oneTimePaymentBenefitData.lumpSum.otherNumOfWeeksBefore);
			}

			CoreFunctions.selectItemInListByText(driver, _radioBtnLumpSum,
					oneTimePaymentBenefitData.lumpSum.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					oneTimePaymentBenefitData.lumpSum.reimbursedBy, _txtBoxLumpSumReimbursedByOther,
					oneTimePaymentBenefitData.lumpSum.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaLumpSumComment, PDTConstants.COMMENT,
					oneTimePaymentBenefitData.lumpSum.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}

	}

	public void fillLeaseBreak(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownLeaseBreakMaxNumOfMonthsOptions);
			String randMaxNumOfMonthsLeaseBreak = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownLeaseBreakMaxNumOfMonths,
					_drpDownLeaseBreakMaxNumOfMonthsOptions, _drpDownLeaseBreakMaxNumOfMonthsOptionsSelected,
					_lblLeaseBreakMaxNumOfMonths.getText());
			setMaxNumOfMonthsLeaseBreak(randMaxNumOfMonthsLeaseBreak);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownLeaseBreakMaxNumOfMonthsOptionsSelected, _lblLeaseBreakMaxNumOfMonths.getText(),
					_txtBoxLeaseBreakMaxNumOfMonthsOther, PDTConstants.OTHER,
					oneTimePaymentBenefitData.leaseBreak.maxNumOfMonths);

			CoreFunctions.selectItemInListByText(driver, _radioBtnLeaseBreak,
					oneTimePaymentBenefitData.leaseBreak.grossUp, PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST,
					true);

			CoreFunctions.clearAndSetText(driver, _txtBoxLeaseBreakMaxAmount, _lblLeaseBreakMaxAmount.getText(),
					oneTimePaymentBenefitData.leaseBreak.maxAmount);
			CoreFunctions.clickElement(driver, _drpDownLeaseBreakCurrency);
			CoreFunctions.selectItemInListByText(driver, _drpDownLeaseBreakCurrencyOptions,
					oneTimePaymentBenefitData.leaseBreak.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
			String randFrequencyLeaseBreak = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownLeaseBreakFrequency,
					_drpDownLeaseBreakFrequencyOptions, _drpDownLeaseBreakFrequencyOptionsSelected,
					_lblLeaseBreakFrequency.getText());
			setFreqLeaseBreak(randFrequencyLeaseBreak);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownLeaseBreakFrequencyOptionsSelected, _lblLeaseBreakFrequency.getText(),
					_txtBoxLeaseBreakOtherFrequency, PDTConstants.OTHER_FREQUENCY,
					oneTimePaymentBenefitData.leaseBreak.otherFrequency);

			CoreFunctions.selectItemInListByText(driver, _radioBtnLeaseBreak,
					oneTimePaymentBenefitData.leaseBreak.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					oneTimePaymentBenefitData.leaseBreak.reimbursedBy, _txtBoxLeaseBreakReimbursedByOther,
					oneTimePaymentBenefitData.leaseBreak.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaLeaseBreakComment, PDTConstants.COMMENT,
					oneTimePaymentBenefitData.leaseBreak.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillApplAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.clearAndSetText(driver, _txtBoxApplAllowanceMaxAmount, _lblApplAllowanceMaxAmount.getText(),
					oneTimePaymentBenefitData.applAllowance.maxAmount);
			CoreFunctions.clickElement(driver, _drpDownApplAllowanceCurrency);
			CoreFunctions.selectItemInListByText(driver, _drpDownApplAllowanceCurrencyOptions,
					oneTimePaymentBenefitData.applAllowance.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN,
					true);
			String randFrequencyApplAllowance = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownApplAllowanceFrequency,
					_drpDownApplAllowanceFrequencyOptions, _drpDownApplAllowanceFrequencyOptionsSelected,
					_lblApplAllowanceFrequency.getText());
			setFreqApplAllowance(randFrequencyApplAllowance);
			/*
			 * BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver,
			 * addNewPolicyPage, subBenefitFormName,
			 * _drpDownApplAllowanceFrequencyOptionsSelected,
			 * _lblApplAllowanceFrequency.getText(), _txtBoxLeaseBreakOtherFrequency,
			 * PDTConstants.OTHER_FREQUENCY,
			 * oneTimePaymentBenefitData.leaseBreak.otherFrequency);
			 */

			CoreFunctions.selectItemInListByText(driver, _radioBtnApplAllowance,
					oneTimePaymentBenefitData.applAllowance.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);

			CoreFunctions.selectItemInListByText(driver, _radioBtnApplAllowance,
					oneTimePaymentBenefitData.applAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					oneTimePaymentBenefitData.applAllowance.reimbursedBy, _txtBoxApplAllowanceReimbursedByOther,
					oneTimePaymentBenefitData.applAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaApplAllowanceComment, PDTConstants.COMMENT,
					oneTimePaymentBenefitData.applAllowance.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillAutoRegistrationCost(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.clearAndSetText(driver, _txtBoxAutoRegCostMaxAmount, _lblAutoRegCostMaxAmount.getText(),
					oneTimePaymentBenefitData.autoRegCost.maxAmount);
			CoreFunctions.clickElement(driver, _drpDownAutoRegCostCurrency);
			CoreFunctions.selectItemInListByText(driver, _drpDownAutoRegCostCurrencyOptions,
					oneTimePaymentBenefitData.autoRegCost.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN,
					true);
			String randFrequencyAutoRegCost = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownAutoRegCostFrequency,
					_drpDownAutoRegCostFrequencyOptions, _drpDownAutoRegCostFrequencyOptionsSelected,
					_lblAutoRegCostFrequency.getText());
			setFreqAutoRegCost(randFrequencyAutoRegCost);

			CoreFunctions.selectItemInListByText(driver, _radioBtnAutoRegCost,
					oneTimePaymentBenefitData.autoRegCost.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);

			CoreFunctions.selectItemInListByText(driver, _radioBtnAutoRegCost,
					oneTimePaymentBenefitData.autoRegCost.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					oneTimePaymentBenefitData.autoRegCost.reimbursedBy, _txtBoxAutoRegCostReimbursedByOther,
					oneTimePaymentBenefitData.autoRegCost.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaAutoRegCostComment, PDTConstants.COMMENT,
					oneTimePaymentBenefitData.autoRegCost.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillAutoLossOnSale(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownMaxNumOfAutosOptions);
			String randMaxNumOfAutos = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownMaxNumOfAutos, _drpDownMaxNumOfAutosOptions,
					_drpDownMaxNumOfAutosOptionsSelected, _lblMaxNumOfAutos.getText());
			setMaxNumOfAutos(randMaxNumOfAutos);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownMaxNumOfAutosOptionsSelected, _lblMaxNumOfAutos.getText(), _txtBoxMaxNumOfAutosOther,
					PDTConstants.OTHER, oneTimePaymentBenefitData.autoLossOnSale.otherMaxNumOfAutos);

			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmtPerAuto, _lblMaxAmtPerAuto.getText(),
					oneTimePaymentBenefitData.autoLossOnSale.maxAmtPerAuto);

			CoreFunctions.clickElement(driver, _drpDownAutoLossOnSaleCurrency);
			CoreFunctions.selectItemInListByText(driver, _drpDownAutoLossOnSaleCurrencyOptions,
					oneTimePaymentBenefitData.autoLossOnSale.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN,
					true);

			CoreFunctions.selectItemInListByText(driver, _radioBtnAutoLossOnSale,
					oneTimePaymentBenefitData.autoLossOnSale.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);

			CoreFunctions.selectItemInListByText(driver, _radioBtnAutoLossOnSale,
					oneTimePaymentBenefitData.autoLossOnSale.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					oneTimePaymentBenefitData.autoLossOnSale.reimbursedBy, _txtBoxAutoLossOnSaleReimbursedByOther,
					oneTimePaymentBenefitData.autoLossOnSale.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaAutoLossOnSaleComment, PDTConstants.COMMENT,
					oneTimePaymentBenefitData.autoLossOnSale.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillOtherOneTimePayment(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.clearAndSetText(driver, _txtBoxPaymentDesc, _lblPaymentDesc.getText(),
					oneTimePaymentBenefitData.otherOneTimePayment.paymentDesc);

			CoreFunctions.clearAndSetText(driver, _txtBoxOtherOneTimePaymentMaxAmt,
					_lblOtherOneTimePaymentMaxAmt.getText(), oneTimePaymentBenefitData.otherOneTimePayment.maxAmount);

			CoreFunctions.clickElement(driver, _drpDownOtherOneTimePaymentCurrency);
			CoreFunctions.selectItemInListByText(driver, _drpDownOtherOneTimePaymentCurrencyOptions,
					oneTimePaymentBenefitData.otherOneTimePayment.currency, PDTConstants.CURRENCY,
					PDTConstants.DROP_DOWN, true);

			String randFreqOtherOneTimePayment = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownOtherOneTimePaymentFrequency,
					_drpDownOtherOneTimePaymentFrequencyOptions, _drpDownOtherOneTimePaymentFrequencyOptionsSelected,
					_lblOtherOneTimePaymentFrequency.getText());

			setFreqOtherOneTimePayment(randFreqOtherOneTimePayment);

			CoreFunctions.selectItemInListByText(driver, _radioBtnOtherOneTimePayment,
					oneTimePaymentBenefitData.otherOneTimePayment.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);

			CoreFunctions.selectItemInListByText(driver, _radioBtnOtherOneTimePayment,
					oneTimePaymentBenefitData.otherOneTimePayment.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					oneTimePaymentBenefitData.otherOneTimePayment.reimbursedBy,
					_txtBoxOtherOneTimePaymentReimbursedByOther,
					oneTimePaymentBenefitData.otherOneTimePayment.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaOtherOneTimePaymentComment, PDTConstants.COMMENT,
					oneTimePaymentBenefitData.otherOneTimePayment.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}
	
	public void fillOneTimePaymentSubBenefit(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefitPage subBenefitPage) {		
		switch (subBenefit) {
		case PDTConstants.MISC_RELOCATION_ALLOWANCE:
			fillMiscRelocationAllowance(addNewPolicyPage, PDTConstants.MISC_RELOCATION_ALLOWANCE, pageName);
			break;
		case PDTConstants.LUMP_SUM:
			fillLumpSum(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.LEASE_BREAK:
			fillLeaseBreak(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.APPLIANCE_ALLOWANCE:
			fillApplAllowance(addNewPolicyPage,
					subBenefit, pageName);
			break;
		case PDTConstants.AUTO_REGISTRATION_COSTS:
			fillAutoRegistrationCost(addNewPolicyPage,
					subBenefit, pageName);
			break;
		case PDTConstants.AUTO_LOSS_ON_SALE:
			fillAutoLossOnSale(addNewPolicyPage,
					subBenefit, pageName);
			break;
		case PDTConstants.OTHER_ONE_TIME_PAYMENT:
			fillOtherOneTimePayment(addNewPolicyPage,
					subBenefit, pageName);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}		
	}
	
	/**
	 * Iterate OneTime Payment/Reimbursements sub-benefits and fill their corresponding form.
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage 
	 */
	public void iterateAndFillOneTimePaymentsReimbursementsSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep, String btnName, PDT_SharedSubBenefitPage subBenefitPage) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);			
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		WebElement btnToClick = (btnName != null) ?  buttonMap.get(btnName) : buttonMap.get(PDTConstants.SAVE);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			waitForProgressBarToDisapper();
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			fillOneTimePaymentSubBenefit(subBenefit, pageName, addNewPolicyPage, subBenefitPage);
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
