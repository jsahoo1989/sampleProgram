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
import com.aires.testdatatypes.pdt.PDT_RentalAssistanceBenefit;

public class PDT_RentalAssistancePage extends Base {
	public PDT_RentalAssistancePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='usRentDurationCode']/preceding-sibling::label")
	private WebElement _lblDurationLodging;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='usRentDurationCode']")
	private WebElement _drpDownDurationLodging;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='usRentDurationCode'] span.ng-option-label")
	private List<WebElement> _drpDownDurationLodgingOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='usRentDurationCode'] span.ng-value-label")
	private WebElement _drpDownDurationLodgingOptionsSelected;	

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='usRentDurationOther']/preceding-sibling::label")
	private WebElement _lblDurationOther;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='usRentDurationOther']")
	private WebElement _txtBoxDurationOther;
	
	@FindBy(how = How.CSS, using = "app-rental-tour label.form-check-label")
	private List<WebElement> _radioBtnRentalTour;

	@FindBy(how = How.CSS, using = "app-rental-tour input[formcontrolname='paidByOther']")
	private WebElement _txtBoxRentalTourReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-rental-tour textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaRentalTourComment;
	
	//Finder's Fees
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='maxAmount']/preceding-sibling::label")
	private WebElement _lblMaxAmt;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmount']")
	private WebElement _txtBoxMaxAmt;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrency;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownCurrencyOptionsSelected;
	
	@FindBy(how = How.CSS, using = "app-finder-fee label.form-check-label")
	private List<WebElement> _radioBtnFinderFees;

	@FindBy(how = How.CSS, using = "app-finder-fee input[formcontrolname='paidByOther']")
	private WebElement _txtBoxFinderFeesReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-finder-fee textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaFinderFeesComment;
	
	PDT_RentalAssistanceBenefit rentalAssistanceBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getRentalAssistanceDataList("Rental Assistance");
	private String duration;
	
	public void setDuration(String durationSelected) {
		duration = durationSelected;
	}
	
	public String  getDuration() {
		return duration;
	}
	
	public void fillRentalTourForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblDurationLodging,
					_lblDurationLodging.getText());
			String randDuration = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownDurationLodging, _drpDownDurationLodgingOptions, _drpDownDurationLodgingOptionsSelected,
					_lblDurationLodging);
			setDuration(randDuration);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownDurationLodgingOptionsSelected, _lblDurationLodging.getText(), _txtBoxDurationOther,
					_lblDurationOther, subBenefitFormName);
			
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnRentalTour);
			CoreFunctions.selectItemInListByText(driver, _radioBtnRentalTour,
					rentalAssistanceBenefitData.rentalTour.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnRentalTour,
					rentalAssistanceBenefitData.rentalTour.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					rentalAssistanceBenefitData.rentalTour.reimbursedBy, _txtBoxRentalTourReimbursedByOther,
					rentalAssistanceBenefitData.rentalTour.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaRentalTourComment, PDTConstants.COMMENT,
					rentalAssistanceBenefitData.rentalTour.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillFinderFeesForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblMaxAmt,
					_lblMaxAmt.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmt, _lblMaxAmt.getText(),
					rentalAssistanceBenefitData.finderFees.maxAmount);
			CoreFunctions.clickElement(driver, _drpDownCurrency);
			CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyOptions,
					rentalAssistanceBenefitData.finderFees.currency, PDTConstants.CURRENCY,
					PDTConstants.DROP_DOWN, true);
			
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnFinderFees);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinderFees,
					rentalAssistanceBenefitData.finderFees.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinderFees,
					rentalAssistanceBenefitData.finderFees.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					rentalAssistanceBenefitData.finderFees.reimbursedBy, _txtBoxFinderFeesReimbursedByOther,
					rentalAssistanceBenefitData.finderFees.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaFinderFeesComment, PDTConstants.COMMENT,
					rentalAssistanceBenefitData.finderFees.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
}
