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
import com.aires.testdatatypes.pdt.PDT_OngoingPaymentReimbursementBenefit;

import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_OngoingPaymentReimbursementPage extends PDT_SharedSubBenefitPage {
	public PDT_OngoingPaymentReimbursementPage(WebDriver driver) {
		super(driver);
	}

	// COLA
	@FindBy(how = How.CSS, using = "div#headingOne > div.displayHeaderSection >h5")
	private WebElement _headingFormCola;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Type of Payment']")
	private WebElement _lblTypeOfPayment;

	@FindBy(how = How.CSS, using = "app-cola label.form-check-label")
	private List<WebElement> _radioBtnCola;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='calculationMethod']/preceding-sibling::label")
	private WebElement _lblColaCalcMethod;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownColaCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownColaCalcMethodOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownColaCalcMethodSelectedOption;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='calculationMethodOther']/preceding-sibling::label")
	private WebElement _lblColaOtherCalcMethod;

	@FindBy(how = How.CSS, using = "input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxColaOtherCalcMethod;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minDiffToQulify']/preceding-sibling::label")
	private WebElement _lblColaMinDiffToQualify;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDiffToQulify']")
	private WebElement _txtBoxColaMinDiffToQualify;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='frequencyCode']/preceding-sibling::label")
	private WebElement _lblColaPaymentFrequency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownColaPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownColaPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownColaPaymentFrequencySelectedOption;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='frequencyOther']/preceding-sibling::label")
	private WebElement _lblColaPaymentFreqOther;

	@FindBy(how = How.CSS, using = "input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxColaPaymentFreqOther;

	@FindBy(how = How.XPATH, using = "//app-cola//ng-select[@formcontrolname='currencyCode']/preceding-sibling::label")
	private WebElement _lblColaCurrency;

	@FindBy(how = How.CSS, using = "app-cola ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownColaCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownColaCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-cola ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownColaCurrencyOptionsSelected;

	@FindBy(how = How.XPATH, using = "//app-cola//ng-select[@formcontrolname='paymentDuration']/preceding-sibling::label")
	private WebElement _lblPaymentDuration;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='paymentDuration']")
	private WebElement _drpDownColaPaymentDuration;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownColaPaymentDurationOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='paymentDuration'] span.ng-value-label")
	private WebElement _drpDownColaPaymentDurationOptionsSelected;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='paymentDurationOther']/preceding-sibling::label")
	private WebElement _lblOtherPaymentDuration;

	@FindBy(how = How.CSS, using = "input[formcontrolname='paymentDurationOther']")
	private WebElement _txtBoxOtherPaymentDuration;

	@FindBy(how = How.CSS, using = "app-cola input[formcontrolname='paidByOther']")
	private WebElement _txtBoxColaReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-cola textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaColaComment;

	// Per Diem
	@FindBy(how = How.CSS, using = "div#headingTwo > div.displayHeaderSection >h5")
	private WebElement _headingFormPerDiem;
	
	@FindBy(how = How.XPATH, using = "//app-per-diem//ng-select[@formcontrolname='calculationMethod']/preceding-sibling::label")
	private WebElement _lblPerDiemCalcMethod;

	@FindBy(how = How.CSS, using = "app-per-diem ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownPerDiemCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownPerDiemCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-per-diem ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownPerDiemCalcMethodSelectedOption;

	@FindBy(how = How.XPATH, using = "//app-per-diem//input[@formcontrolname='calculationMethodOther']/preceding-sibling::label")
	private WebElement _lblPerDiemOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-per-diem input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxPerDiemOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-per-diem input[formcontrolname='maxAmount']")
	private WebElement _txtBoxPerDiemMaxAmt;

	@FindBy(how = How.CSS, using = "app-per-diem ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownPerDiemCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownPerDiemCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-per-diem ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownPerDiemCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-per-diem ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownPerDiemPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownPerDiemPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-per-diem ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownPerDiemPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-per-diem input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxPerDiemOtherFrequency;

	@FindBy(how = How.CSS, using = "app-per-diem label.form-check-label")
	private List<WebElement> _radioBtnPerDiem;

	@FindBy(how = How.CSS, using = "app-per-diem input[formcontrolname='paidByOther']")
	private WebElement _txtBoxPerDiemReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-per-diem textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaPerDiemComment;

	// Mobility Premium
	@FindBy(how = How.CSS, using = "div#headingThree > div.displayHeaderSection >h5")
	private WebElement _headingFormMobilityPremium;
	
	@FindBy(how = How.CSS, using = "app-mobility-premium ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownMobilityPremCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownMobilityPremCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-mobility-premium ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownMobilityPremCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-mobility-premium input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxMobilityPremOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-mobility-premium input[formcontrolname='maxAmount']")
	private WebElement _txtBoxMobilityPremMaxAmt;

	@FindBy(how = How.CSS, using = "app-mobility-premium ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownMobilityPremCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownMobilityPremCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-mobility-premium ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownMobilityPremCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-mobility-premium ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownMobilityPremPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownMobilityPremPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-mobility-premium ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownMobilityPremPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-mobility-premium input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxMobilityPremOtherFrequency;

	@FindBy(how = How.CSS, using = "app-mobility-premium label.form-check-label")
	private List<WebElement> _radioBtnMobilityPrem;

	@FindBy(how = How.CSS, using = "app-mobility-premium input[formcontrolname='paidByOther']")
	private WebElement _txtBoxMobilityPremReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-mobility-premium textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaMobilityPremComment;

	// Transportation Allowance
	@FindBy(how = How.CSS, using = "div#headingFour > div.displayHeaderSection >h5")
	private WebElement _headingFormTransportationAllowance;
	
	@FindBy(how = How.CSS, using = "app-transportation-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownTransportAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownTransportAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-transportation-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownTransportAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-transportation-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxTransportAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-transportation-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxTransportAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-transportation-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownTransportAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownTransportAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-transportation-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownTransportAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-transportation-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownTransportAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownTransportAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-transportation-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownTransportAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-transportation-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxTransportAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-transportation-allowance label.form-check-label")
	private List<WebElement> _radioBtnTransportAllow;

	@FindBy(how = How.CSS, using = "app-transportation-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxTransportAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-transportation-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaTransportAllowComment;

	// Housing Allowance
	@FindBy(how = How.CSS, using = "div#headingFive > div.displayHeaderSection >h5")
	private WebElement _headingFormHousingAllowance;
	
	@FindBy(how = How.CSS, using = "app-housing-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownHousingAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHousingAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-housing-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownHousingAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-housing-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxHousingAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-housing-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxHousingAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-housing-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownHousingAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHousingAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-housing-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownHousingAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-housing-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownHousingAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHousingAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-housing-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownHousingAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-housing-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxHousingAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-housing-allowance label.form-check-label")
	private List<WebElement> _radioBtnHousingAllow;

	@FindBy(how = How.CSS, using = "app-housing-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHousingAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-housing-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHousingAllowComment;

	// Home Maintenance Allowance
	@FindBy(how = How.CSS, using = "div#headingSix > div.displayHeaderSection >h5")
	private WebElement _headingFormHomeMaintainAllowance;
	
	@FindBy(how = How.CSS, using = "app-home-maintenance-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownHomeMaintAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHomeMaintAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-home-maintenance-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownHomeMaintAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-home-maintenance-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxHomeMaintAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-home-maintenance-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxHomeMaintAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-home-maintenance-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownHomeMaintAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHomeMaintAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-home-maintenance-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownHomeMaintAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-home-maintenance-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownHomeMaintAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHomeMaintAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-home-maintenance-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownHomeMaintAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-home-maintenance-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxHomeMaintAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-home-maintenance-allowance label.form-check-label")
	private List<WebElement> _radioBtnHomeMaintAllow;

	@FindBy(how = How.CSS, using = "app-home-maintenance-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHomeMaintAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-home-maintenance-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHomeMaintAllowComment;

	// Furniture Allowance
	@FindBy(how = How.CSS, using = "div#headingSeven > div.displayHeaderSection >h5")
	private WebElement _headingFormFurnitureAllowance;
	
	@FindBy(how = How.CSS, using = "app-furniture-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownFurnitureAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownFurnitureAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-furniture-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownFurnitureAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-furniture-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxFurnitureAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-furniture-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxFurnitureAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-furniture-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownFurnitureAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownFurnitureAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-furniture-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownFurnitureAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-furniture-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownFurnitureAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownFurnitureAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-furniture-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownFurnitureAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-furniture-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxFurnitureAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-furniture-allowance label.form-check-label")
	private List<WebElement> _radioBtnFurnitureAllow;

	@FindBy(how = How.CSS, using = "app-furniture-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxFurnitureAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-furniture-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaFurnitureAllowComment;

	// Hardship Allowance
	@FindBy(how = How.CSS, using = "div#headingEight > div.displayHeaderSection >h5")
	private WebElement _headingFormHardshipAllowance;
	
	@FindBy(how = How.CSS, using = "app-hardship-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownHardshipAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHardshipAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-hardship-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownHardshipAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-hardship-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxHardshipAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-hardship-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxHardshipAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-hardship-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownHardshipAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHardshipAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-hardship-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownHardshipAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-hardship-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownHardshipAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHardshipAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-hardship-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownHardshipAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-hardship-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxHardshipAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-hardship-allowance label.form-check-label")
	private List<WebElement> _radioBtnHardshipAllow;

	@FindBy(how = How.CSS, using = "app-hardship-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHardshipAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-hardship-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHardshipAllowComment;

	// Banking Allowance
	@FindBy(how = How.CSS, using = "div#headingNine > div.displayHeaderSection >h5")
	private WebElement _headingFormBankingAllowance;
	
	@FindBy(how = How.CSS, using = "app-banking-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownBankingAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownBankingAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-banking-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownBankingAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-banking-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxBankingAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-banking-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxBankingAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-banking-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownBankingAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownBankingAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-banking-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownBankingAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-banking-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownBankingAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownBankingAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-banking-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownBankingAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-banking-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxBankingAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-banking-allowance label.form-check-label")
	private List<WebElement> _radioBtnBankingAllow;

	@FindBy(how = How.CSS, using = "app-banking-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxBankingAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-banking-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaBankingAllowComment;

	// At sea allowance
	@FindBy(how = How.CSS, using = "div#headingTen > div.displayHeaderSection >h5")
	private WebElement _headingFormSeaAllowance;
	
	@FindBy(how = How.CSS, using = "app-at-sea-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownAtSeaAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownAtSeaAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-at-sea-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownAtSeaAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-at-sea-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxAtSeaAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-at-sea-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxAtSeaAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-at-sea-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownAtSeaAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownAtSeaAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-at-sea-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownAtSeaAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-at-sea-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownAtSeaAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownAtSeaAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-at-sea-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownAtSeaAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-at-sea-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxAtSeaAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-at-sea-allowance label.form-check-label")
	private List<WebElement> _radioBtnAtSeaAllow;

	@FindBy(how = How.CSS, using = "app-at-sea-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxAtSeaAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-at-sea-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaAtSeaAllowComment;

	// Commuter Allowance
	@FindBy(how = How.CSS, using = "div#heading11 > div.displayHeaderSection >h5")
	private WebElement _headingFormCommuterAllowance;
	
	@FindBy(how = How.CSS, using = "app-commuter-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownCommuterAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownCommuterAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-commuter-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownCommuterAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-commuter-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxCommuterAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-commuter-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxCommuterAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-commuter-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCommuterAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownCommuterAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-commuter-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownCommuterAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-commuter-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownCommuterAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownCommuterAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-commuter-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownCommuterAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-commuter-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxCommuterAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-commuter-allowance label.form-check-label")
	private List<WebElement> _radioBtnCommuterAllow;

	@FindBy(how = How.CSS, using = "app-commuter-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxCommuterAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-commuter-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommuterAllowComment;

	// Differential Allowance
	@FindBy(how = How.CSS, using = "div#heading12 > div.displayHeaderSection >h5")
	private WebElement _headingFormDifferentialAllowance;
	
	@FindBy(how = How.CSS, using = "app-differential-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownDiffAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownDiffAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-differential-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownDiffAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-differential-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxDiffAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-differential-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxDiffAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-differential-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownDiffAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownDiffAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-differential-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownDiffAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-differential-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownDiffAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownDiffAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-differential-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownDiffAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-differential-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxDiffAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-differential-allowance label.form-check-label")
	private List<WebElement> _radioBtnDiffAllow;

	@FindBy(how = How.CSS, using = "app-differential-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxDiffAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-differential-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaDiffAllowComment;

	// Goods And Services Allowance
	@FindBy(how = How.CSS, using = "div#heading13 > div.displayHeaderSection >h5")
	private WebElement _headingFormGoodsAndServicesAllowance;
	
	@FindBy(how = How.CSS, using = "app-goods-services-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownGoodAndServicesAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownGoodAndServicesAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-goods-services-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownGoodAndServicesAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-goods-services-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxGoodAndServicesAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-goods-services-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxGoodAndServicesAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-goods-services-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownGoodAndServicesAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownGoodAndServicesAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-goods-services-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownGoodAndServicesAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-goods-services-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownGoodAndServicesAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownGoodAndServicesAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-goods-services-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownGoodAndServicesAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-goods-services-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxGoodAndServicesAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-goods-services-allowance label.form-check-label")
	private List<WebElement> _radioBtnGoodAndServicesAllow;

	@FindBy(how = How.CSS, using = "app-goods-services-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxGoodAndServicesAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-goods-services-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaGoodAndServicesAllowComment;

	// Home Leave Allowance
	@FindBy(how = How.CSS, using = "div#heading14 > div.displayHeaderSection >h5")
	private WebElement _headingFormHomeLeaveAllowance;
	
	@FindBy(how = How.CSS, using = "app-home-leave-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownHomeLeaveAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHomeLeaveAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-home-leave-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownHomeLeaveAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-home-leave-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxHomeLeaveAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-home-leave-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxHomeLeaveAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-home-leave-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownHomeLeaveAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHomeLeaveAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-home-leave-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownHomeLeaveAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-home-leave-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownHomeLeaveAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHomeLeaveAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-home-leave-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownHomeLeaveAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-home-leave-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxHomeLeaveAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-home-leave-allowance label.form-check-label")
	private List<WebElement> _radioBtnHomeLeaveAllow;

	@FindBy(how = How.CSS, using = "app-home-leave-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHomeLeaveAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-home-leave-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHomeLeaveAllowComment;

	// Home Retention Allowance
	@FindBy(how = How.CSS, using = "div#heading15 > div.displayHeaderSection >h5")
	private WebElement _headingFormHomeRetentionAllowance;
	
	@FindBy(how = How.CSS, using = "app-home-retention-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownHomeRetentionAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHomeRetentionAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-home-retention-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownHomeRetentionAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-home-retention-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxHomeRetentionAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-home-retention-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxHomeRetentionAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-home-retention-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownHomeRetentionAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHomeRetentionAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-home-retention-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownHomeRetentionAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-home-retention-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownHomeRetentionAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHomeRetentionAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-home-retention-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownHomeRetentionAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-home-retention-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxHomeRetentionAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-home-retention-allowance label.form-check-label")
	private List<WebElement> _radioBtnHomeRetentionAllow;

	@FindBy(how = How.CSS, using = "app-home-retention-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHomeRetentionAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-home-retention-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHomeRetentionAllowComment;

	// HouseKeeping Allowance
	@FindBy(how = How.CSS, using = "div#heading16 > div.displayHeaderSection >h5")
	private WebElement _headingFormHouseKeepingAllowance;
	
	@FindBy(how = How.CSS, using = "app-housekeeping-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownHouseKeepingAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHouseKeepingAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-housekeeping-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownHouseKeepingAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-housekeeping-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxHouseKeepingAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-housekeeping-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxHouseKeepingAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-housekeeping-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownHouseKeepingAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHouseKeepingAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-housekeeping-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownHouseKeepingAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-housekeeping-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownHouseKeepingAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownHouseKeepingAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-housekeeping-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownHouseKeepingAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-housekeeping-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxHouseKeepingAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-housekeeping-allowance label.form-check-label")
	private List<WebElement> _radioBtnHouseKeepingAllow;

	@FindBy(how = How.CSS, using = "app-housekeeping-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHouseKeepingAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-housekeeping-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHouseKeepingAllowComment;

	// Utility Allowance
	@FindBy(how = How.CSS, using = "div#heading17 > div.displayHeaderSection >h5")
	private WebElement _headingFormUtilityAllowance;
	
	@FindBy(how = How.CSS, using = "app-utility-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownUtilityAllowCalcMethod;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownUtilityAllowCalcMethodOptions;

	@FindBy(how = How.CSS, using = "app-utility-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownUtilityAllowCalcMethodSelectedOption;

	@FindBy(how = How.CSS, using = "app-utility-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxUtilityAllowOtherCalcMethod;

	@FindBy(how = How.CSS, using = "app-utility-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxUtilityAllowMaxAmt;

	@FindBy(how = How.CSS, using = "app-utility-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownUtilityAllowCurrency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownUtilityAllowCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-utility-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownUtilityAllowCurrencyOptionsSelected;

	@FindBy(how = How.CSS, using = "app-utility-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownUtilityAllowPaymentFrequency;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownUtilityAllowPaymentFrequencyOption;

	@FindBy(how = How.CSS, using = "app-utility-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownUtilityAllowPaymentFrequencySelectedOption;

	@FindBy(how = How.CSS, using = "app-utility-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxUtilityAllowOtherFrequency;

	@FindBy(how = How.CSS, using = "app-utility-allowance label.form-check-label")
	private List<WebElement> _radioBtnUtilityAllow;

	@FindBy(how = How.CSS, using = "app-utility-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxUtilityAllowReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-utility-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaUtilityAllowComment;
	
	//Other ongoing Allowance
	@FindBy(how = How.CSS, using = "div#heading18 > div.displayHeaderSection >h5")
	private WebElement _headingFormOtherOngoingAllowance;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='allowanceDesc']/preceding-sibling::label")
	private WebElement _lblAllowanceDesc;
	
	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance input[formcontrolname='allowanceDesc']")
	private WebElement _txtBoxAllowanceDesc;
	
	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance ng-select[formcontrolname='calculationMethod']")
	private WebElement _drpDownOthOngoingCalcMeth;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownOthOngoingCalcMethOptions;

	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance ng-select[formcontrolname='calculationMethod'] span.ng-value-label")
	private WebElement _drpDownOthOngoingCalcMethSelectedOption;

	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance input[formcontrolname='calculationMethodOther']")
	private WebElement _txtBoxOthOngoingOthCalcMeth;

	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance input[formcontrolname='maxAmount']")
	private WebElement _txtBoxOthOngoingMaxAmt;

	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownOthOngoingCurr;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownOthOngoingCurrOptions;

	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownOthOngoingCurrOptionsSelected;

	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance ng-select[formcontrolname='frequencyCode']")
	private WebElement _drpDownOthOngoingFreq;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownOthOngoingFreqOption;

	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance ng-select[formcontrolname='frequencyCode'] span.ng-value-label")
	private WebElement _drpDownOthOngoingFreqSelectedOption;

	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance input[formcontrolname='frequencyOther']")
	private WebElement _txtBoxOthOngoingOthFreq;

	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance label.form-check-label")
	private List<WebElement> _radioBtnOthOngoingAllow;

	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance input[formcontrolname='paidByOther']")
	private WebElement _txtBoxOthOngoingReimbursedByOth;

	@FindBy(how = How.CSS, using = "app-other-ongoing-allowance textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaOtherOngoingComment;
	
	@FindBy(how = How.CSS, using = "a[data-target='#collapseOne']")
	private WebElement _formHeaderCOLA;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseTwo']")
	private WebElement _formHeaderPerDiem;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseThree']")
	private WebElement _formHeaderMobilityPremium;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseFour']")
	private WebElement _formHeaderTransportationAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseFive']")
	private WebElement _formHeaderHousingAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseSix']")
	private WebElement _formHeaderHomeMaintenanceAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseSeven']")
	private WebElement _formHeaderFurnitureAllowance;
	
	@FindBy(how = How.CSS, using = "a[data-target='#collapseEight']")
	private WebElement _formHeaderHardshipAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseNine']")
	private WebElement _formHeaderBankingAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseTen']")
	private WebElement _formHeaderAtSeaAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapse11']")
	private WebElement _formHeaderCommuterAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapse12']")
	private WebElement _formHeaderDifferentialAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapse13']")
	private WebElement _formHeaderGoodsAndServicesAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapse14']")
	private WebElement _formHeaderHomeLeaveAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapse15']")
	private WebElement _formHeaderHomeRetentionAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapse16']")
	private WebElement _formHeaderHouseKeepingAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapse17']")
	private WebElement _formHeaderUtilityAllowance;

	@FindBy(how = How.CSS, using = "a[data-target='#collapse18']")
	private WebElement _formHeaderOtherOngoingAllowance;
	
	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;

	PDT_OngoingPaymentReimbursementBenefit ongoingPaymentReimbursementBenefitData = FileReaderManager.getInstance()
			.getJsonReader().getOngoingPaymentReimbursementDataList("Ongoing Payments and Reimbursements");

	private String colaCalcMethod, colaPaymentFreq, paymentDuration, perDiemCalcMethod, perDiemFreq,
			mobilityPremCalcMethod, mobilityPremFreq, transportAllowCalcMethod, transportAllowPayFreq,
			housingAllowCalcMethod, housingAllowPayFreq, homeMaintainAllowCalcMethod, homeMaintainPayFreq,
			furnAllowCalcMethod, furnAllowPayFreq, hardshipAllowCalcMethod, hardshipAllowPayFreq, bankAllowCalcMethod,
			bankAllowPayFreq, atSeaAllowCalcMethod, atSeaAllowPayFreq, commutAllowCalcMethod, commutAllowPayFreq,
			diffAllowCalcMethod, diffAllowPayFreq, goodsServicesAllowCalcMethod, goodsServicesAllowPayFreq,
			homeLeaveAllowCalcMethod, homeLeaveAllowPayFreq, homeRetentionAllowCalcMethod, homeRetentionAllowPayFreq,
			houseKeepingAllowCalcMethod, houseKeepingAllowPayFreq, utilityAllowCalcMethod, utilityAllowPayFreq,
			otherOngoingAllowCalcMethod, otherOngoingAllowPayFreq;

	public void setColaCalcMethod(String colaCalcMethodSelected) {
		colaCalcMethod = colaCalcMethodSelected;
	}

	public String getColaCalcMethod() {
		return colaCalcMethod;
	}

	public void setColaPaymentFreq(String colaPaymentFreqSelected) {
		colaPaymentFreq = colaPaymentFreqSelected;
	}

	public String getColaPaymentFreq() {
		return colaPaymentFreq;
	}

	public void setPaymentDuration(String paymentDurationSelected) {
		paymentDuration = paymentDurationSelected;
	}

	public String getPaymentDuration() {
		return paymentDuration;
	}

	public void setPerDiemCalcMethod(String calcMethodSelected) {
		perDiemCalcMethod = calcMethodSelected;
	}

	public String getPerDiemCalcMethod() {
		return perDiemCalcMethod;
	}

	public void setPerDiemFreq(String perDiemFreqSelected) {
		perDiemFreq = perDiemFreqSelected;
	}

	public String getPerDiemFreq() {
		return perDiemFreq;
	}

	public void setMobilityPremCalcMethod(String mobilityPremCalcMethodSelected) {
		mobilityPremCalcMethod = mobilityPremCalcMethodSelected;
	}

	public String getMobilityPremCalcMethod() {
		return mobilityPremCalcMethod;
	}

	public void setMobilityPremFreq(String mobilityPremFreqSelected) {
		mobilityPremFreq = mobilityPremFreqSelected;
	}

	public String getMobilityPremFreq() {
		return mobilityPremFreq;
	}

	public void setTransportAllowCalcMethod(String transportAllowCalcMethodSelected) {
		transportAllowCalcMethod = transportAllowCalcMethodSelected;
	}

	public String getTransportAllowCalcMethod() {
		return transportAllowCalcMethod;
	}

	public void setTransportAllowPayFreq(String transportAllowFreqSelected) {
		transportAllowPayFreq = transportAllowFreqSelected;
	}

	public String getTransportAllowPayFreq() {
		return transportAllowPayFreq;
	}

	public void setHousingAllowCalcMethod(String housingAllowCalcMethodSelected) {
		housingAllowCalcMethod = housingAllowCalcMethodSelected;
	}

	public String getHousingAllowCalcMethod() {
		return housingAllowCalcMethod;
	}

	public void setHousingAllowPayFreq(String housingAllowFreqSelected) {
		housingAllowPayFreq = housingAllowFreqSelected;
	}

	public String getHousingAllowPayFreq() {
		return housingAllowPayFreq;
	}

	public void setHomeMaintCalcMethod(String homeMaintAllowCalcMethodSelected) {
		homeMaintainAllowCalcMethod = homeMaintAllowCalcMethodSelected;
	}

	public String getHomeMaintCalcMethod() {
		return homeMaintainAllowCalcMethod;
	}

	public void setHomeMaintPayFreq(String homeMaintFreqSelected) {
		homeMaintainPayFreq = homeMaintFreqSelected;
	}

	public String getHomeMaintPayFreq() {
		return homeMaintainPayFreq;
	}

	public void setFurnAllowCalcMethod(String furnAllowCalcMethodSelected) {
		furnAllowCalcMethod = furnAllowCalcMethodSelected;
	}

	public String getFurnAllowCalcMethod() {
		return furnAllowCalcMethod;
	}

	public void setFurnAllowPayFreq(String furnFreqSelected) {
		furnAllowPayFreq = furnFreqSelected;
	}

	public String getFurnAllowPayFreq() {
		return furnAllowPayFreq;
	}

	public void setHardshipAllowCalcMethod(String hardshipCalcMethodSelected) {
		hardshipAllowCalcMethod = hardshipCalcMethodSelected;
	}

	public String getHardshipAllowCalcMethod() {
		return hardshipAllowCalcMethod;
	}

	public void setHardshipAllowPayFreq(String hardshipFreqSelected) {
		hardshipAllowPayFreq = hardshipFreqSelected;
	}

	public String getHardshipAllowPayFreq() {
		return hardshipAllowPayFreq;
	}

	public void setBankAllowCalcMethod(String bankAllowCalcMethodSelected) {
		bankAllowCalcMethod = bankAllowCalcMethodSelected;
	}

	public String getBankAllowCalcMethod() {
		return bankAllowCalcMethod;
	}

	public void setBankAllowPayFreq(String bankAllowFreqSelected) {
		bankAllowPayFreq = bankAllowFreqSelected;
	}

	public String getBankAllowPayFreq() {
		return bankAllowPayFreq;
	}

	public void setAtSeaAllowCalcMethod(String atSeaAllowCalcMethodSelected) {
		atSeaAllowCalcMethod = atSeaAllowCalcMethodSelected;
	}

	public String getAtSeaAllowCalcMethod() {
		return atSeaAllowCalcMethod;
	}

	public void setAtSeaAllowPayFreq(String atSeaAllowFreqSelected) {
		atSeaAllowPayFreq = atSeaAllowFreqSelected;
	}

	public String getAtSeaAllowPayFreq() {
		return atSeaAllowPayFreq;
	}

	public void setCommutAllowCalcMethod(String commutAllowCalcMethodSelected) {
		commutAllowCalcMethod = commutAllowCalcMethodSelected;
	}

	public String getCommutAllowCalcMethod() {
		return commutAllowCalcMethod;
	}

	public void setCommutAllowPayFreq(String commutAllowFreqSelected) {
		commutAllowPayFreq = commutAllowFreqSelected;
	}

	public String getCommutAllowPayFreq() {
		return commutAllowPayFreq;
	}
	
	public void setDiffAllowCalcMethod(String diffAllowCalcMethodSelected) {
		diffAllowCalcMethod = diffAllowCalcMethodSelected;
	}

	public String getDiffAllowCalcMethod() {
		return diffAllowCalcMethod;
	}

	public void setDiffAllowPayFreq(String diffAllowPayFreqSelected) {
		diffAllowPayFreq = diffAllowPayFreqSelected;
	}

	public String getDiffAllowPayFreq() {
		return diffAllowPayFreq;
	}
	
	public void setGoodsServicesAllowCalcMethod(String goodsServicesAllowCalcMethodSelected) {
		goodsServicesAllowCalcMethod = goodsServicesAllowCalcMethodSelected;
	}

	public String getGoodsServicesAllowCalcMethod() {
		return goodsServicesAllowCalcMethod;
	}

	public void setGoodsServicesAllowPayFreq(String goodsServicesAllowPayFreqSelected) {
		goodsServicesAllowPayFreq = goodsServicesAllowPayFreqSelected;
	}

	public String getGoodsServicesAllowPayFreq() {
		return goodsServicesAllowPayFreq;
	}
	
	public void setHomeLeaveAllowCalcMethod(String homeLeaveAllowCalcMethodSelected) {
		homeLeaveAllowCalcMethod = homeLeaveAllowCalcMethodSelected;
	}

	public String getHomeLeaveAllowCalcMethod() {
		return homeLeaveAllowCalcMethod;
	}

	public void setHomeLeaveAllowPayFreq(String homeLeaveAllowPayFreqSelected) {
		homeLeaveAllowPayFreq = homeLeaveAllowPayFreqSelected;
	}

	public String getHomeLeaveAllowPayFreq() {
		return homeLeaveAllowPayFreq;
	}
	
	public void setHomeRetentionAllowCalcMethod(String homeRetentionAllowCalcMethodSelected) {
		homeRetentionAllowCalcMethod = homeRetentionAllowCalcMethodSelected;
	}

	public String getHomeRetentionAllowCalcMethod() {
		return homeRetentionAllowCalcMethod;
	}

	public void setHomeRetentionAllowPayFreq(String homeRetentionAllowPayFreqSelected) {
		homeRetentionAllowPayFreq = homeRetentionAllowPayFreqSelected;
	}

	public String getHomeRetentionAllowPayFreq() {
		return homeRetentionAllowPayFreq;
	}
	
	public void setHouseKeepingAllowCalcMethod(String houseKeepingAllowCalcMethodSelected) {
		houseKeepingAllowCalcMethod = houseKeepingAllowCalcMethodSelected;
	}

	public String getHouseKeepingAllowCalcMethod() {
		return houseKeepingAllowCalcMethod;
	}

	public void setHouseKeepingAllowPayFreq(String houseKeepingAllowPayFreqSelected) {
		houseKeepingAllowPayFreq = houseKeepingAllowPayFreqSelected;
	}

	public String getHouseKeepingAllowPayFreq() {
		return houseKeepingAllowPayFreq;
	}
	
	public void setUtilityAllowCalcMethod(String utilityAllowCalcMethodSelected) {
		utilityAllowCalcMethod = utilityAllowCalcMethodSelected;
	}

	public String getUtilityAllowCalcMethod() {
		return utilityAllowCalcMethod;
	}

	public void setUtilityAllowPayFreq(String utilityAllowPayFreqSelected) {
		utilityAllowPayFreq = utilityAllowPayFreqSelected;
	}

	public String getUtilityAllowPayFreq() {
		return utilityAllowPayFreq;
	}
	
	public void setOtherOngoingAllowCalcMethod(String otherOngoingAllowCalcMethodSelected) {
		otherOngoingAllowCalcMethod = otherOngoingAllowCalcMethodSelected;
	}

	public String getOtherOngoingAllowCalcMethod() {
		return otherOngoingAllowCalcMethod;
	}

	public void setOtherOngoingAllowPayFreq(String otherOngoingAllowPayFreqSelected) {
		otherOngoingAllowPayFreq = otherOngoingAllowPayFreqSelected;
	}

	public String getOtherOngoingAllowPayFreq() {
		return otherOngoingAllowPayFreq;
	}

	/**
	 * Add the Form Header of Compensation Services sub-benefit in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.COLA, _formHeaderCOLA);
		subBenefitHeaderMap.put(PDTConstants.PER_DIEM, _formHeaderPerDiem);
		subBenefitHeaderMap.put(PDTConstants.MOBILITY_PREMIUM, _formHeaderMobilityPremium);
		subBenefitHeaderMap.put(PDTConstants.TRANSPORTATION_ALLOWANCE, _formHeaderTransportationAllowance);
		subBenefitHeaderMap.put(PDTConstants.HOUSING_ALLOWANCE, _formHeaderHousingAllowance);
		subBenefitHeaderMap.put(PDTConstants.HOME_MAINTENANCE_ALLOWANCE, _formHeaderHomeMaintenanceAllowance);
		subBenefitHeaderMap.put(PDTConstants.FURNITURE_ALLOWANCE, _formHeaderFurnitureAllowance);
		subBenefitHeaderMap.put(PDTConstants.HARDSHIP_ALLOWANCE, _formHeaderHardshipAllowance);
		subBenefitHeaderMap.put(PDTConstants.BANKING_ALLOWANCE, _formHeaderBankingAllowance);
		subBenefitHeaderMap.put(PDTConstants.AT_SEA_ALLOWANCE, _formHeaderAtSeaAllowance);
		subBenefitHeaderMap.put(PDTConstants.COMMUTER_ALLOWANCE, _formHeaderCommuterAllowance);
		subBenefitHeaderMap.put(PDTConstants.DIFFERENTIAL_ALLOWANCE, _formHeaderDifferentialAllowance);
		subBenefitHeaderMap.put(PDTConstants.GOODS_AND_SERVICES_ALLOWANCE, _formHeaderGoodsAndServicesAllowance);
		subBenefitHeaderMap.put(PDTConstants.HOME_LEAVE_ALLOWANCE, _formHeaderHomeLeaveAllowance);
		subBenefitHeaderMap.put(PDTConstants.HOME_RETENTION_ALLOWANCE, _formHeaderHomeRetentionAllowance);
		subBenefitHeaderMap.put(PDTConstants.HOUSEKEEPING_ALLOWANCE, _formHeaderHouseKeepingAllowance);
		subBenefitHeaderMap.put(PDTConstants.UTILITY_ALLOWANCE, _formHeaderUtilityAllowance);
		subBenefitHeaderMap.put(PDTConstants.OTHER_ONGOING_ALLOWANCE, _formHeaderOtherOngoingAllowance);
	}
	

	
	public void fillCola(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(_headingFormCola, subBenefitFormName, driver);

		CoreFunctions.explicitWaitTillElementListVisibility(driver, _radioBtnCola);
		CoreFunctions.selectItemInListByText(driver, _radioBtnCola, ongoingPaymentReimbursementBenefitData.cola.typeOfPayment,
				_lblTypeOfPayment.getText(), PDTConstants.RADIO_BUTTON_LIST, true);
		
		String randColaCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownColaCalcMethod, _drpDownColaCalcMethodOptions,
				_drpDownColaCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD);
		setColaCalcMethod(randColaCalcMethod);

		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownColaCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD, _txtBoxColaOtherCalcMethod,
				PDTConstants.OTHER_CALCULATION_METHOD,
				ongoingPaymentReimbursementBenefitData.cola.otherCalculationMethod);

		CoreFunctions.clearAndSetText(driver, _txtBoxColaMinDiffToQualify, _lblColaMinDiffToQualify.getText(),
				ongoingPaymentReimbursementBenefitData.cola.minDifferentialQty);

		String randPaymentFrequency = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownColaPaymentFrequency, _drpDownColaPaymentFrequencyOption,
				_drpDownColaPaymentFrequencySelectedOption, _lblColaPaymentFrequency.getText());
		setColaPaymentFreq(randPaymentFrequency);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownColaPaymentFrequencySelectedOption, _lblColaPaymentFrequency.getText(),
				_txtBoxColaPaymentFreqOther, PDTConstants.OTHER_FREQUENCY,
				ongoingPaymentReimbursementBenefitData.cola.otherPaymentFrequency);

		CoreFunctions.clickElement(driver, _drpDownColaCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownColaCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.cola.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN,
				true);

		String randPaymentDuration = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownColaPaymentDuration, _drpDownColaPaymentDurationOptions,
				_drpDownColaPaymentDurationOptionsSelected, _lblPaymentDuration.getText());
		setPaymentDuration(randPaymentDuration);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownColaPaymentDurationOptionsSelected, _lblPaymentDuration.getText(), _txtBoxOtherPaymentDuration,
				"Other Payment Duration", ongoingPaymentReimbursementBenefitData.cola.otherPaymentDuration);

		CoreFunctions.selectItemInListByText(driver, _radioBtnCola, ongoingPaymentReimbursementBenefitData.cola.grossUp,
				PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST, true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnCola,
				ongoingPaymentReimbursementBenefitData.cola.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.cola.reimbursedBy, _txtBoxColaReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.cola.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaColaComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.cola.comments);
	}

	public void fillPerDiem(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownPerDiemCalcMethodOptions);
		String randPerDiemCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownPerDiemCalcMethod, _drpDownPerDiemCalcMethodOptions,
				_drpDownPerDiemCalcMethodSelectedOption, _lblPerDiemCalcMethod.getText());
		setPerDiemCalcMethod(randPerDiemCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownPerDiemCalcMethodSelectedOption, _lblPerDiemCalcMethod.getText(), _txtBoxPerDiemOtherCalcMethod,
				PDTConstants.OTHER_CALCULATION_METHOD,
				ongoingPaymentReimbursementBenefitData.perDiem.otherCalculationMethod);

		CoreFunctions.clearAndSetText(driver, _txtBoxPerDiemMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.perDiem.maxAmount);

		CoreFunctions.clickElement(driver, _drpDownPerDiemCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownPerDiemCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.perDiem.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN,
				true);

		String randPerDiemFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownPerDiemPaymentFrequency, _drpDownPerDiemPaymentFrequencyOption,
				_drpDownPerDiemPaymentFrequencySelectedOption, PDTConstants.FREQUENCY);
		setPerDiemFreq(randPerDiemFreq);

		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownPerDiemPaymentFrequencySelectedOption, PDTConstants.FREQUENCY, _txtBoxPerDiemOtherFrequency,
				PDTConstants.OTHER_FREQUENCY, ongoingPaymentReimbursementBenefitData.perDiem.otherFrequency);

		CoreFunctions.selectItemInListByText(driver, _radioBtnPerDiem,
				ongoingPaymentReimbursementBenefitData.perDiem.grossUp, PDTConstants.GROSS_UP,
				PDTConstants.RADIO_BUTTON_LIST, true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnPerDiem,
				ongoingPaymentReimbursementBenefitData.perDiem.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.perDiem.reimbursedBy, _txtBoxPerDiemReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.perDiem.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaPerDiemComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.perDiem.comments);
	}

	public void fillMobilityPremium(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);

		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownMobilityPremCalcMethodOptions);
		String randMobilityPremCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownMobilityPremCalcMethod,
				_drpDownMobilityPremCalcMethodOptions, _drpDownMobilityPremCalcMethodSelectedOption,
				PDTConstants.CALCULATION_METHOD);
		setMobilityPremCalcMethod(randMobilityPremCalcMethod);

		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownMobilityPremCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD,
				_txtBoxMobilityPremOtherCalcMethod, PDTConstants.OTHER_CALCULATION_METHOD,
				ongoingPaymentReimbursementBenefitData.mobilityPremium.otherCalculationMethod);

		CoreFunctions.clearAndSetText(driver, _txtBoxMobilityPremMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.mobilityPremium.maxAmount);

		CoreFunctions.clickElement(driver, _drpDownMobilityPremCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownMobilityPremCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.mobilityPremium.currency, PDTConstants.CURRENCY,
				PDTConstants.DROP_DOWN, true);

		String randMobilityPremFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownMobilityPremPaymentFrequency, _drpDownMobilityPremPaymentFrequencyOption,
				_drpDownMobilityPremPaymentFrequencySelectedOption, PDTConstants.FREQUENCY);
		setMobilityPremFreq(randMobilityPremFreq);

		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownMobilityPremPaymentFrequencySelectedOption, PDTConstants.FREQUENCY,
				_txtBoxMobilityPremOtherFrequency, PDTConstants.OTHER_FREQUENCY,
				ongoingPaymentReimbursementBenefitData.mobilityPremium.otherFrequency);

		CoreFunctions.selectItemInListByText(driver, _radioBtnMobilityPrem,
				ongoingPaymentReimbursementBenefitData.mobilityPremium.grossUp, PDTConstants.GROSS_UP,
				PDTConstants.RADIO_BUTTON_LIST, true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnMobilityPrem,
				ongoingPaymentReimbursementBenefitData.mobilityPremium.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.mobilityPremium.reimbursedBy,
				_txtBoxMobilityPremReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.mobilityPremium.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaMobilityPremComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.mobilityPremium.comments);
	}

	public void fillTransportationAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownTransportAllowCalcMethodOptions);
		String randTransportAllowCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownTransportAllowCalcMethod,
				_drpDownTransportAllowCalcMethodOptions, _drpDownTransportAllowCalcMethodSelectedOption,
				PDTConstants.CALCULATION_METHOD);
		setTransportAllowCalcMethod(randTransportAllowCalcMethod);

		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownTransportAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD,
				_txtBoxTransportAllowOtherCalcMethod, PDTConstants.OTHER_CALCULATION_METHOD,
				ongoingPaymentReimbursementBenefitData.transportationAllowance.otherCalculationMethod);

		CoreFunctions.clearAndSetText(driver, _txtBoxTransportAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.transportationAllowance.maxAmount);

		CoreFunctions.clickElement(driver, _drpDownTransportAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownTransportAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.transportationAllowance.currency, PDTConstants.CURRENCY,
				PDTConstants.DROP_DOWN, true);

		String randTransportAllowPayFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownTransportAllowPaymentFrequency,
				_drpDownTransportAllowPaymentFrequencyOption, _drpDownTransportAllowPaymentFrequencySelectedOption,
				PDTConstants.FREQUENCY);
		setTransportAllowPayFreq(randTransportAllowPayFreq);

		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownTransportAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY,
				_txtBoxTransportAllowOtherFrequency, PDTConstants.OTHER_FREQUENCY,
				ongoingPaymentReimbursementBenefitData.transportationAllowance.otherFrequency);

		CoreFunctions.selectItemInListByText(driver, _radioBtnTransportAllow,
				ongoingPaymentReimbursementBenefitData.transportationAllowance.grossUp, PDTConstants.GROSS_UP,
				PDTConstants.RADIO_BUTTON_LIST, true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnTransportAllow,
				ongoingPaymentReimbursementBenefitData.transportationAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.transportationAllowance.reimbursedBy,
				_txtBoxTransportAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.transportationAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaTransportAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.transportationAllowance.comments);
	}

	public void fillHousingAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownHousingAllowCalcMethodOptions);
		String randHousingAllowCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownHousingAllowCalcMethod,
				_drpDownHousingAllowCalcMethodOptions, _drpDownHousingAllowCalcMethodSelectedOption,
				PDTConstants.CALCULATION_METHOD);
		setHousingAllowCalcMethod(randHousingAllowCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownHousingAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD,
				_txtBoxHousingAllowOtherCalcMethod, PDTConstants.OTHER_CALCULATION_METHOD,
				ongoingPaymentReimbursementBenefitData.housingAllowance.otherCalculationMethod);

		CoreFunctions.clearAndSetText(driver, _txtBoxHousingAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.housingAllowance.maxAmount);

		CoreFunctions.clickElement(driver, _drpDownHousingAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownHousingAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.housingAllowance.currency, PDTConstants.CURRENCY,
				PDTConstants.DROP_DOWN, true);

		String randHousingAllowPayFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownHousingAllowPaymentFrequency,
				_drpDownHousingAllowPaymentFrequencyOption, _drpDownHousingAllowPaymentFrequencySelectedOption,
				PDTConstants.FREQUENCY);
		setHousingAllowPayFreq(randHousingAllowPayFreq);

		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownHousingAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY,
				_txtBoxHousingAllowOtherFrequency, PDTConstants.OTHER_FREQUENCY,
				ongoingPaymentReimbursementBenefitData.housingAllowance.otherFrequency);

		CoreFunctions.selectItemInListByText(driver, _radioBtnHousingAllow,
				ongoingPaymentReimbursementBenefitData.housingAllowance.grossUp, PDTConstants.GROSS_UP,
				PDTConstants.RADIO_BUTTON_LIST, true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnHousingAllow,
				ongoingPaymentReimbursementBenefitData.housingAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.housingAllowance.reimbursedBy,
				_txtBoxHousingAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.housingAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaHousingAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.housingAllowance.comments);
	}

	public void fillHomeMaintenanceAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownHomeMaintAllowCalcMethodOptions);
		String randHomeMaintAllowance = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownHomeMaintAllowCalcMethod,
				_drpDownHomeMaintAllowCalcMethodOptions, _drpDownHomeMaintAllowCalcMethodSelectedOption,
				PDTConstants.CALCULATION_METHOD);
		setHomeMaintCalcMethod(randHomeMaintAllowance);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownHomeMaintAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD,
				_txtBoxHomeMaintAllowOtherCalcMethod, PDTConstants.OTHER_CALCULATION_METHOD,
				ongoingPaymentReimbursementBenefitData.homeMaintainAllowance.otherCalculationMethod);

		CoreFunctions.clearAndSetText(driver, _txtBoxHomeMaintAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.homeMaintainAllowance.maxAmount);

		CoreFunctions.clickElement(driver, _drpDownHomeMaintAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownHomeMaintAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.homeMaintainAllowance.currency, PDTConstants.CURRENCY,
				PDTConstants.DROP_DOWN, true);

		String randHomeMaintAllowPayFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownHomeMaintAllowPaymentFrequency,
				_drpDownHomeMaintAllowPaymentFrequencyOption, _drpDownHomeMaintAllowPaymentFrequencySelectedOption,
				PDTConstants.FREQUENCY);
		setHomeMaintPayFreq(randHomeMaintAllowPayFreq);

		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownHomeMaintAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY,
				_txtBoxHomeMaintAllowOtherFrequency, PDTConstants.OTHER_FREQUENCY,
				ongoingPaymentReimbursementBenefitData.homeMaintainAllowance.otherFrequency);

		CoreFunctions.selectItemInListByText(driver, _radioBtnHomeMaintAllow,
				ongoingPaymentReimbursementBenefitData.homeMaintainAllowance.grossUp, PDTConstants.GROSS_UP,
				PDTConstants.RADIO_BUTTON_LIST, true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnHomeMaintAllow,
				ongoingPaymentReimbursementBenefitData.homeMaintainAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.homeMaintainAllowance.reimbursedBy,
				_txtBoxHomeMaintAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.homeMaintainAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaHomeMaintAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.homeMaintainAllowance.comments);
	}

	public void fillFurnitureAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownFurnitureAllowCalcMethodOptions);
		String randFurnAllowCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownFurnitureAllowCalcMethod,
				_drpDownFurnitureAllowCalcMethodOptions, _drpDownFurnitureAllowCalcMethodSelectedOption,
				PDTConstants.CALCULATION_METHOD);
		setFurnAllowCalcMethod(randFurnAllowCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownFurnitureAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD,
				_txtBoxFurnitureAllowOtherCalcMethod, PDTConstants.OTHER_CALCULATION_METHOD,
				ongoingPaymentReimbursementBenefitData.furnitureAllowance.otherCalculationMethod);

		CoreFunctions.clearAndSetText(driver, _txtBoxFurnitureAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.furnitureAllowance.maxAmount);

		CoreFunctions.clickElement(driver, _drpDownFurnitureAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownFurnitureAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.furnitureAllowance.currency, PDTConstants.CURRENCY,
				PDTConstants.DROP_DOWN, true);

		String randFurnAllowPayFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownFurnitureAllowPaymentFrequency,
				_drpDownFurnitureAllowPaymentFrequencyOption, _drpDownFurnitureAllowPaymentFrequencySelectedOption,
				PDTConstants.FREQUENCY);
		setFurnAllowPayFreq(randFurnAllowPayFreq);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownFurnitureAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY,
				_txtBoxFurnitureAllowOtherFrequency, PDTConstants.OTHER_FREQUENCY,
				ongoingPaymentReimbursementBenefitData.furnitureAllowance.otherFrequency);

		CoreFunctions.selectItemInListByText(driver, _radioBtnFurnitureAllow,
				ongoingPaymentReimbursementBenefitData.furnitureAllowance.grossUp, PDTConstants.GROSS_UP,
				PDTConstants.RADIO_BUTTON_LIST, true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnFurnitureAllow,
				ongoingPaymentReimbursementBenefitData.furnitureAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.furnitureAllowance.reimbursedBy,
				_txtBoxFurnitureAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.furnitureAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaFurnitureAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.furnitureAllowance.comments);
	}

	public void fillHardshipAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		//BusinessFunctions.expandSubBenefitIfCollapsed(_headingFormHardshipAllowance, subBenefitFormName, driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownHardshipAllowCalcMethodOptions);
		String randHardshipAllowCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownHardshipAllowCalcMethod,
				_drpDownHardshipAllowCalcMethodOptions, _drpDownHardshipAllowCalcMethodSelectedOption,
				PDTConstants.CALCULATION_METHOD);
		setHardshipAllowCalcMethod(randHardshipAllowCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownHardshipAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD,
				_txtBoxHardshipAllowOtherCalcMethod, PDTConstants.OTHER_CALCULATION_METHOD,
				ongoingPaymentReimbursementBenefitData.hardshipAllowance.otherCalculationMethod);

		CoreFunctions.clearAndSetText(driver, _txtBoxHardshipAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.hardshipAllowance.maxAmount);

		CoreFunctions.clickElement(driver, _drpDownHardshipAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownHardshipAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.hardshipAllowance.currency, PDTConstants.CURRENCY,
				PDTConstants.DROP_DOWN, true);

		String randHardshipAllowPayFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownHardshipAllowPaymentFrequency,
				_drpDownHardshipAllowPaymentFrequencyOption, _drpDownHardshipAllowPaymentFrequencySelectedOption,
				PDTConstants.FREQUENCY);
		setHardshipAllowPayFreq(randHardshipAllowPayFreq);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownHardshipAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY,
				_txtBoxHardshipAllowOtherFrequency, PDTConstants.OTHER_FREQUENCY,
				ongoingPaymentReimbursementBenefitData.hardshipAllowance.otherFrequency);

		CoreFunctions.selectItemInListByText(driver, _radioBtnHardshipAllow,
				ongoingPaymentReimbursementBenefitData.hardshipAllowance.grossUp, PDTConstants.GROSS_UP,
				PDTConstants.RADIO_BUTTON_LIST, true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnHardshipAllow,
				ongoingPaymentReimbursementBenefitData.hardshipAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.hardshipAllowance.reimbursedBy,
				_txtBoxHardshipAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.hardshipAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaHardshipAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.hardshipAllowance.comments);
	}

	public void fillBankingAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		//BusinessFunctions.expandSubBenefitIfCollapsed(_headingFormBankingAllowance, subBenefitFormName, driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownBankingAllowCalcMethodOptions);
		String randBankAllowCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownBankingAllowCalcMethod,
				_drpDownBankingAllowCalcMethodOptions, _drpDownBankingAllowCalcMethodSelectedOption,
				PDTConstants.CALCULATION_METHOD);
		setBankAllowCalcMethod(randBankAllowCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownBankingAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD,
				_txtBoxBankingAllowOtherCalcMethod, PDTConstants.OTHER_CALCULATION_METHOD,
				ongoingPaymentReimbursementBenefitData.bankingAllowance.otherCalculationMethod);

		CoreFunctions.clearAndSetText(driver, _txtBoxBankingAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.bankingAllowance.maxAmount);

		CoreFunctions.clickElement(driver, _drpDownBankingAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownBankingAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.bankingAllowance.currency, PDTConstants.CURRENCY,
				PDTConstants.DROP_DOWN, true);

		String randBankingAllowPaymentFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownBankingAllowPaymentFrequency,
				_drpDownBankingAllowPaymentFrequencyOption, _drpDownBankingAllowPaymentFrequencySelectedOption,
				PDTConstants.FREQUENCY);
		setBankAllowPayFreq(randBankingAllowPaymentFreq);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownBankingAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY,
				_txtBoxBankingAllowOtherFrequency, PDTConstants.OTHER_FREQUENCY,
				ongoingPaymentReimbursementBenefitData.bankingAllowance.otherFrequency);

		CoreFunctions.selectItemInListByText(driver, _radioBtnBankingAllow,
				ongoingPaymentReimbursementBenefitData.bankingAllowance.grossUp, PDTConstants.GROSS_UP,
				PDTConstants.RADIO_BUTTON_LIST, true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnBankingAllow,
				ongoingPaymentReimbursementBenefitData.bankingAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.bankingAllowance.reimbursedBy,
				_txtBoxBankingAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.bankingAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaBankingAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.bankingAllowance.comments);
	}

	public void fillAtSeaAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		//BusinessFunctions.expandSubBenefitIfCollapsed(_headingFormSeaAllowance, subBenefitFormName, driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownAtSeaAllowCalcMethodOptions);
		String randAtSeaAllowCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownAtSeaAllowCalcMethod, _drpDownAtSeaAllowCalcMethodOptions,
				_drpDownAtSeaAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD);
		setAtSeaAllowCalcMethod(randAtSeaAllowCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownAtSeaAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD,
				_txtBoxAtSeaAllowOtherCalcMethod, PDTConstants.OTHER_CALCULATION_METHOD,
				ongoingPaymentReimbursementBenefitData.atSeaAllowanace.otherCalculationMethod);

		CoreFunctions.clearAndSetText(driver, _txtBoxAtSeaAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.atSeaAllowanace.maxAmount);

		CoreFunctions.clickElement(driver, _drpDownAtSeaAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownAtSeaAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.atSeaAllowanace.currency, PDTConstants.CURRENCY,
				PDTConstants.DROP_DOWN, true);

		String randAtSeaAllowPayFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownAtSeaAllowPaymentFrequency,
				_drpDownAtSeaAllowPaymentFrequencyOption, _drpDownAtSeaAllowPaymentFrequencySelectedOption,
				PDTConstants.FREQUENCY);
		setAtSeaAllowPayFreq(randAtSeaAllowPayFreq);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownAtSeaAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY,
				_txtBoxAtSeaAllowOtherFrequency, PDTConstants.OTHER_FREQUENCY,
				ongoingPaymentReimbursementBenefitData.atSeaAllowanace.otherFrequency);

		CoreFunctions.selectItemInListByText(driver, _radioBtnAtSeaAllow,
				ongoingPaymentReimbursementBenefitData.atSeaAllowanace.grossUp, PDTConstants.GROSS_UP,
				PDTConstants.RADIO_BUTTON_LIST, true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnAtSeaAllow,
				ongoingPaymentReimbursementBenefitData.atSeaAllowanace.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.atSeaAllowanace.reimbursedBy, _txtBoxAtSeaAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.atSeaAllowanace.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaAtSeaAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.atSeaAllowanace.comments);
	}

	public void fillCommuterAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		//BusinessFunctions.expandSubBenefitIfCollapsed(_headingFormCommuterAllowance, subBenefitFormName, driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownCommuterAllowCalcMethodOptions);
		String randCommutAllowCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownCommuterAllowCalcMethod,
				_drpDownCommuterAllowCalcMethodOptions, _drpDownCommuterAllowCalcMethodSelectedOption,
				PDTConstants.CALCULATION_METHOD);
		setCommutAllowCalcMethod(randCommutAllowCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownCommuterAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD,
				_txtBoxCommuterAllowOtherCalcMethod, PDTConstants.OTHER_CALCULATION_METHOD,
				ongoingPaymentReimbursementBenefitData.commuterAllowance.otherCalculationMethod);

		CoreFunctions.clearAndSetText(driver, _txtBoxCommuterAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.commuterAllowance.maxAmount);

		CoreFunctions.clickElement(driver, _drpDownCommuterAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownCommuterAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.commuterAllowance.currency, PDTConstants.CURRENCY,
				PDTConstants.DROP_DOWN, true);

		String randCommutAllowPayFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
				addNewPolicyPage, subBenefitFormName, _drpDownCommuterAllowPaymentFrequency,
				_drpDownCommuterAllowPaymentFrequencyOption, _drpDownCommuterAllowPaymentFrequencySelectedOption,
				PDTConstants.FREQUENCY);
		setCommutAllowPayFreq(randCommutAllowPayFreq);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownCommuterAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY,
				_txtBoxCommuterAllowOtherFrequency, PDTConstants.OTHER_FREQUENCY,
				ongoingPaymentReimbursementBenefitData.commuterAllowance.otherFrequency);

		CoreFunctions.selectItemInListByText(driver, _radioBtnCommuterAllow,
				ongoingPaymentReimbursementBenefitData.commuterAllowance.grossUp, PDTConstants.GROSS_UP,
				PDTConstants.RADIO_BUTTON_LIST, true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnCommuterAllow,
				ongoingPaymentReimbursementBenefitData.commuterAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.commuterAllowance.reimbursedBy,
				_txtBoxCommuterAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.commuterAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaCommuterAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.commuterAllowance.comments);
	}

	public void fillDifferentialAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		//BusinessFunctions.expandSubBenefitIfCollapsed(_headingFormDifferentialAllowance, subBenefitFormName, driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownDiffAllowCalcMethodOptions);
		String randDiffAllowCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownDiffAllowCalcMethod, _drpDownDiffAllowCalcMethodOptions,
				_drpDownDiffAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD);
		setDiffAllowCalcMethod(randDiffAllowCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownDiffAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD, _txtBoxDiffAllowOtherCalcMethod,
				PDTConstants.OTHER_CALCULATION_METHOD, ongoingPaymentReimbursementBenefitData.differentialAllowance.otherCalculationMethod);
		
		CoreFunctions.clearAndSetText(driver, _txtBoxDiffAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.differentialAllowance.maxAmount);
		
		CoreFunctions.clickElement(driver, _drpDownDiffAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownDiffAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.differentialAllowance.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
		
		String randDiffAllowPayFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownDiffAllowPaymentFrequency, _drpDownDiffAllowPaymentFrequencyOption,
				_drpDownDiffAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY);
		setDiffAllowPayFreq(randDiffAllowPayFreq);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownDiffAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY, _txtBoxDiffAllowOtherFrequency,
				PDTConstants.OTHER_FREQUENCY, ongoingPaymentReimbursementBenefitData.differentialAllowance.otherFrequency);
		
		CoreFunctions.selectItemInListByText(driver, _radioBtnDiffAllow,
				ongoingPaymentReimbursementBenefitData.differentialAllowance.grossUp, PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST,
				true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnDiffAllow,
				ongoingPaymentReimbursementBenefitData.differentialAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.differentialAllowance.reimbursedBy, _txtBoxDiffAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.differentialAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaDiffAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.differentialAllowance.comments);
	}

	public void fillGoodsAndServicesAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		//BusinessFunctions.expandSubBenefitIfCollapsed(_headingFormGoodsAndServicesAllowance, subBenefitFormName, driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownGoodAndServicesAllowCalcMethodOptions);
		String randGoodsServicesCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownGoodAndServicesAllowCalcMethod, _drpDownGoodAndServicesAllowCalcMethodOptions,
				_drpDownGoodAndServicesAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD);
		setGoodsServicesAllowCalcMethod(randGoodsServicesCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownGoodAndServicesAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD, _txtBoxGoodAndServicesAllowOtherCalcMethod,
				PDTConstants.OTHER_CALCULATION_METHOD, ongoingPaymentReimbursementBenefitData.goodsAndServicesAllowance.otherCalculationMethod);
		
		CoreFunctions.clearAndSetText(driver, _txtBoxGoodAndServicesAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.goodsAndServicesAllowance.maxAmount);
		
		CoreFunctions.clickElement(driver, _drpDownGoodAndServicesAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownGoodAndServicesAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.goodsAndServicesAllowance.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
		
		String randGoodServicesPayFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownGoodAndServicesAllowPaymentFrequency, _drpDownGoodAndServicesAllowPaymentFrequencyOption,
				_drpDownGoodAndServicesAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY);
		setGoodsServicesAllowPayFreq(randGoodServicesPayFreq);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownGoodAndServicesAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY, _txtBoxGoodAndServicesAllowOtherFrequency,
				PDTConstants.OTHER_FREQUENCY, ongoingPaymentReimbursementBenefitData.goodsAndServicesAllowance.otherFrequency);
		
		CoreFunctions.selectItemInListByText(driver, _radioBtnGoodAndServicesAllow,
				ongoingPaymentReimbursementBenefitData.goodsAndServicesAllowance.grossUp, PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST,
				true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnGoodAndServicesAllow,
				ongoingPaymentReimbursementBenefitData.goodsAndServicesAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.goodsAndServicesAllowance.reimbursedBy, _txtBoxGoodAndServicesAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.goodsAndServicesAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaGoodAndServicesAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.goodsAndServicesAllowance.comments);
	}

	public void fillHomeLeaveAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		//BusinessFunctions.expandSubBenefitIfCollapsed(_headingFormHomeLeaveAllowance, subBenefitFormName, driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownHomeLeaveAllowCalcMethodOptions);
		String randHomeLeaveAllowCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownHomeLeaveAllowCalcMethod, _drpDownHomeLeaveAllowCalcMethodOptions,
				_drpDownHomeLeaveAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD);
		setHomeLeaveAllowCalcMethod(randHomeLeaveAllowCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownHomeLeaveAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD, _txtBoxHomeLeaveAllowOtherCalcMethod,
				PDTConstants.OTHER_CALCULATION_METHOD, ongoingPaymentReimbursementBenefitData.homeLeaveAllowance.otherCalculationMethod);
		
		CoreFunctions.clearAndSetText(driver, _txtBoxHomeLeaveAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.homeLeaveAllowance.maxAmount);
		
		CoreFunctions.clickElement(driver, _drpDownHomeLeaveAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownHomeLeaveAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.homeLeaveAllowance.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
		
		String randHomeLeaveAllowPayFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownHomeLeaveAllowPaymentFrequency, _drpDownHomeLeaveAllowPaymentFrequencyOption,
				_drpDownHomeLeaveAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY);
		setHomeLeaveAllowPayFreq(randHomeLeaveAllowPayFreq);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownHomeLeaveAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY, _txtBoxHomeLeaveAllowOtherFrequency,
				PDTConstants.OTHER_FREQUENCY, ongoingPaymentReimbursementBenefitData.homeLeaveAllowance.otherFrequency);
		
		CoreFunctions.selectItemInListByText(driver, _radioBtnHomeLeaveAllow,
				ongoingPaymentReimbursementBenefitData.homeLeaveAllowance.type, PDTConstants.TYPE, PDTConstants.RADIO_BUTTON_LIST,
				true);
		
		CoreFunctions.selectItemInListByText(driver, _radioBtnHomeLeaveAllow,
				ongoingPaymentReimbursementBenefitData.homeLeaveAllowance.grossUp, PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST,
				true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnHomeLeaveAllow,
				ongoingPaymentReimbursementBenefitData.homeLeaveAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.homeLeaveAllowance.reimbursedBy, _txtBoxHomeLeaveAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.homeLeaveAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaHomeLeaveAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.homeLeaveAllowance.comments);
	}

	public void fillHomeRetentionAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		//BusinessFunctions.expandSubBenefitIfCollapsed(_headingFormHomeRetentionAllowance, subBenefitFormName, driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownHomeRetentionAllowCalcMethodOptions);
		String randHomeRetnAllowCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownHomeRetentionAllowCalcMethod, _drpDownHomeRetentionAllowCalcMethodOptions,
				_drpDownHomeRetentionAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD);
		setHomeRetentionAllowCalcMethod(randHomeRetnAllowCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownHomeRetentionAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD, _txtBoxHomeRetentionAllowOtherCalcMethod,
				PDTConstants.OTHER_CALCULATION_METHOD, ongoingPaymentReimbursementBenefitData.homeRetentionAllowance.otherCalculationMethod);
		
		CoreFunctions.clearAndSetText(driver, _txtBoxHomeRetentionAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.homeRetentionAllowance.maxAmount);
		
		CoreFunctions.clickElement(driver, _drpDownHomeRetentionAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownHomeRetentionAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.homeRetentionAllowance.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
		
		String randHomeRetentionAllowPayFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownHomeRetentionAllowPaymentFrequency, _drpDownHomeRetentionAllowPaymentFrequencyOption,
				_drpDownHomeRetentionAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY);
		setHomeRetentionAllowPayFreq(randHomeRetentionAllowPayFreq);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownHomeRetentionAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY, _txtBoxHomeRetentionAllowOtherFrequency,
				PDTConstants.OTHER_FREQUENCY, ongoingPaymentReimbursementBenefitData.homeRetentionAllowance.otherFrequency);
		
		CoreFunctions.selectItemInListByText(driver, _radioBtnHomeRetentionAllow,
				ongoingPaymentReimbursementBenefitData.homeRetentionAllowance.grossUp, PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST,
				true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnHomeRetentionAllow,
				ongoingPaymentReimbursementBenefitData.homeRetentionAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.homeRetentionAllowance.reimbursedBy, _txtBoxHomeRetentionAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.homeRetentionAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaHomeRetentionAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.homeRetentionAllowance.comments);
	}

	public void fillHouseKeepingAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		//BusinessFunctions.expandSubBenefitIfCollapsed(_headingFormHouseKeepingAllowance, subBenefitFormName, driver);
		
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownHouseKeepingAllowCalcMethodOptions);
		String randHouseKeepAllowCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownHouseKeepingAllowCalcMethod, _drpDownHouseKeepingAllowCalcMethodOptions,
				_drpDownHouseKeepingAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD);
		setHouseKeepingAllowCalcMethod(randHouseKeepAllowCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownHouseKeepingAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD, _txtBoxHouseKeepingAllowOtherCalcMethod,
				PDTConstants.OTHER_CALCULATION_METHOD, ongoingPaymentReimbursementBenefitData.houseKeepingAllowance.calculationMethod);
		
		CoreFunctions.clearAndSetText(driver, _txtBoxHouseKeepingAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.houseKeepingAllowance.maxAmount);
		
		CoreFunctions.clickElement(driver, _drpDownHouseKeepingAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownHouseKeepingAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.houseKeepingAllowance.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
		
		String randHouseKeepAllowPayFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownHouseKeepingAllowPaymentFrequency, _drpDownHouseKeepingAllowPaymentFrequencyOption,
				_drpDownHouseKeepingAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY);
		setHouseKeepingAllowPayFreq(randHouseKeepAllowPayFreq);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownHouseKeepingAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY, _txtBoxHouseKeepingAllowOtherFrequency,
				PDTConstants.OTHER_FREQUENCY, ongoingPaymentReimbursementBenefitData.houseKeepingAllowance.otherFrequency);
		
		CoreFunctions.selectItemInListByText(driver, _radioBtnHouseKeepingAllow,
				ongoingPaymentReimbursementBenefitData.houseKeepingAllowance.grossUp, PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST,
				true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnHouseKeepingAllow,
				ongoingPaymentReimbursementBenefitData.houseKeepingAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.houseKeepingAllowance.reimbursedBy, _txtBoxHouseKeepingAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.houseKeepingAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaHouseKeepingAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.houseKeepingAllowance.comments);
	}

	public void fillUtilityAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		//BusinessFunctions.expandSubBenefitIfCollapsed(_headingFormUtilityAllowance, subBenefitFormName, driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownUtilityAllowCalcMethodOptions);
		String randUtilityAllowCalcMethod = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownUtilityAllowCalcMethod, _drpDownUtilityAllowCalcMethodOptions,
				_drpDownUtilityAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD);
		setUtilityAllowCalcMethod(randUtilityAllowCalcMethod);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownUtilityAllowCalcMethodSelectedOption, PDTConstants.CALCULATION_METHOD, _txtBoxUtilityAllowOtherCalcMethod,
				PDTConstants.OTHER_CALCULATION_METHOD, ongoingPaymentReimbursementBenefitData.utilityAllowance.otherCalculationMethod);
		
		CoreFunctions.clearAndSetText(driver, _txtBoxUtilityAllowMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.utilityAllowance.maxAmount);
		
		CoreFunctions.clickElement(driver, _drpDownUtilityAllowCurrency);
		CoreFunctions.selectItemInListByText(driver, _drpDownUtilityAllowCurrencyOptions,
				ongoingPaymentReimbursementBenefitData.utilityAllowance.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
		
		String randMaxNumOfAutos = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownUtilityAllowPaymentFrequency, _drpDownUtilityAllowPaymentFrequencyOption,
				_drpDownUtilityAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY);
		setUtilityAllowPayFreq(randMaxNumOfAutos);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownUtilityAllowPaymentFrequencySelectedOption, PDTConstants.FREQUENCY, _txtBoxUtilityAllowOtherFrequency,
				PDTConstants.OTHER_FREQUENCY, ongoingPaymentReimbursementBenefitData.utilityAllowance.otherFrequency);
		
		CoreFunctions.selectItemInListByText(driver, _radioBtnUtilityAllow,
				ongoingPaymentReimbursementBenefitData.utilityAllowance.grossUp, PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST,
				true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnUtilityAllow,
				ongoingPaymentReimbursementBenefitData.utilityAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.utilityAllowance.reimbursedBy, _txtBoxUtilityAllowReimbursedByOther,
				ongoingPaymentReimbursementBenefitData.utilityAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaUtilityAllowComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.utilityAllowance.comments);
	}

	public void fillOtherOngoingAllowance(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
		//BusinessFunctions.expandSubBenefitIfCollapsed(_headingFormOtherOngoingAllowance, subBenefitFormName, driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownOthOngoingCalcMethOptions);
		
		CoreFunctions.clearAndSetText(driver, _txtBoxAllowanceDesc, _lblAllowanceDesc.getText(),
				ongoingPaymentReimbursementBenefitData.otherOngoingAllowance.allowanceDescription);
		
		String randOthOngoinCalcMeth = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownOthOngoingCalcMeth, _drpDownOthOngoingCalcMethOptions,
				_drpDownOthOngoingCalcMethSelectedOption, PDTConstants.CALCULATION_METHOD);
		setOtherOngoingAllowCalcMethod(randOthOngoinCalcMeth);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownOthOngoingCalcMethSelectedOption, PDTConstants.CALCULATION_METHOD, _txtBoxOthOngoingOthCalcMeth,
				PDTConstants.OTHER_CALCULATION_METHOD, ongoingPaymentReimbursementBenefitData.otherOngoingAllowance.otherCalculationMethod);
		
		CoreFunctions.clearAndSetText(driver, _txtBoxOthOngoingMaxAmt, PDTConstants.MAX_AMOUNT,
				ongoingPaymentReimbursementBenefitData.otherOngoingAllowance.maxAmount);
		
		CoreFunctions.clickElement(driver, _drpDownOthOngoingCurr);
		CoreFunctions.selectItemInListByText(driver, _drpDownOthOngoingCurrOptions,
				ongoingPaymentReimbursementBenefitData.otherOngoingAllowance.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
		
		String randOthOngoingFreq = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
				subBenefitFormName, _drpDownOthOngoingFreq, _drpDownOthOngoingFreqOption,
				_drpDownOthOngoingFreqSelectedOption, PDTConstants.FREQUENCY);
		setOtherOngoingAllowPayFreq(randOthOngoingFreq);
		BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
				_drpDownOthOngoingFreqSelectedOption, PDTConstants.FREQUENCY, _txtBoxOthOngoingOthFreq,
				PDTConstants.OTHER_FREQUENCY, ongoingPaymentReimbursementBenefitData.otherOngoingAllowance.otherFrequency);
		
		CoreFunctions.selectItemInListByText(driver, _radioBtnOthOngoingAllow,
				ongoingPaymentReimbursementBenefitData.otherOngoingAllowance.grossUp, PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST,
				true);

		CoreFunctions.selectItemInListByText(driver, _radioBtnOthOngoingAllow,
				ongoingPaymentReimbursementBenefitData.otherOngoingAllowance.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.RADIO_BUTTON_LIST, true);

		BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
				ongoingPaymentReimbursementBenefitData.otherOngoingAllowance.reimbursedBy, _txtBoxOthOngoingReimbursedByOth,
				ongoingPaymentReimbursementBenefitData.otherOngoingAllowance.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		CoreFunctions.clearAndSetText(driver, _txtAreaOtherOngoingComment, PDTConstants.COMMENT,
				ongoingPaymentReimbursementBenefitData.otherOngoingAllowance.comments);
	}
	
	public void fillOngoingPaymentSubBenefit(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefitPage subBenefitPage) {		
		switch (subBenefit) {
		case PDTConstants.COLA:
			fillCola(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.PER_DIEM:
			fillPerDiem(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.MOBILITY_PREMIUM:
			fillMobilityPremium(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.TRANSPORTATION_ALLOWANCE:
			fillTransportationAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.HOUSING_ALLOWANCE:
			fillHousingAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.HOME_MAINTENANCE_ALLOWANCE:
			fillHomeMaintenanceAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.FURNITURE_ALLOWANCE:
			fillFurnitureAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.HARDSHIP_ALLOWANCE:
			fillHardshipAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.BANKING_ALLOWANCE:
			fillBankingAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.AT_SEA_ALLOWANCE:
			fillAtSeaAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.COMMUTER_ALLOWANCE:
			fillCommuterAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.DIFFERENTIAL_ALLOWANCE:
			fillDifferentialAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.GOODS_AND_SERVICES_ALLOWANCE:
			fillGoodsAndServicesAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.HOME_LEAVE_ALLOWANCE:
			fillHomeLeaveAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.HOME_RETENTION_ALLOWANCE:
			fillHomeRetentionAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.HOUSEKEEPING_ALLOWANCE:
			fillHouseKeepingAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.UTILITY_ALLOWANCE:
			fillUtilityAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.OTHER_ONGOING_ALLOWANCE:
			fillOtherOngoingAllowance(addNewPolicyPage, subBenefit, pageName);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}		
	}
	
	/**
	 * Iterate Destination Services sub-benefits and fill their corresponding form.
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage 
	 */
	public void iterateAndFillOngoingPaymentsReimbursementsSubBenefits(String pageName, List<String> subBenefits,
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
			fillOngoingPaymentSubBenefit(subBenefit, pageName, addNewPolicyPage, subBenefitPage);
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
