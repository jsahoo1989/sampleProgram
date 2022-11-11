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
import com.aires.testdatatypes.pdt.PDT_RentalAssistanceBenefit;

import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_RentalAssistancePage extends PDT_SharedSubBenefitPage {
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
	
	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseOne']")
	private WebElement _formHeaderRentalTour;

	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formHeaderFinderFees;
	
	PDT_RentalAssistanceBenefit rentalAssistanceBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getRentalAssistanceDataList("Rental Assistance");
	private String duration;
	
	public void setDuration(String durationSelected) {
		duration = durationSelected;
	}
	
	public String  getDuration() {
		return duration;
	}
	
	/**
	 * Add the Form Header of Rental Assistance sub-benefit in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.RENTAL_TOUR, _formHeaderRentalTour);
		subBenefitHeaderMap.put(PDTConstants.FINDER_FEES, _formHeaderFinderFees);
	}
	
	public void fillRentalTourForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblDurationLodging,
					_lblDurationLodging.getText());
			String randDuration = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownDurationLodging, _drpDownDurationLodgingOptions, _drpDownDurationLodgingOptionsSelected,
					_lblDurationLodging.getText());
			setDuration(randDuration);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownDurationLodgingOptionsSelected, _lblDurationLodging.getText(), _txtBoxDurationOther,
					PDTConstants.DURATION_OTHER, subBenefitFormName);
			
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnRentalTour);
			CoreFunctions.selectItemInListByText(driver, _radioBtnRentalTour,
					rentalAssistanceBenefitData.rentalTour.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnRentalTour,
					rentalAssistanceBenefitData.rentalTour.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					rentalAssistanceBenefitData.rentalTour.reimbursedBy, _txtBoxRentalTourReimbursedByOther,
					rentalAssistanceBenefitData.rentalTour.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaRentalTourComment, PDTConstants.COMMENT,
					rentalAssistanceBenefitData.rentalTour.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillFinderFeesForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
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

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					rentalAssistanceBenefitData.finderFees.reimbursedBy, _txtBoxFinderFeesReimbursedByOther,
					rentalAssistanceBenefitData.finderFees.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaFinderFeesComment, PDTConstants.COMMENT,
					rentalAssistanceBenefitData.finderFees.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillRentalAssistanceSubBenefit(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefitPage subBenefitPage) {		
		switch (subBenefit) {
		case PDTConstants.RENTAL_TOUR:
			fillRentalTourForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.FINDER_FEES:
			fillFinderFeesForm(addNewPolicyPage, subBenefit, pageName);
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
	public void iterateAndFillRentalAssistanceSubBenefits(String pageName, List<String> subBenefits,
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
			fillRentalAssistanceSubBenefit(subBenefit, pageName, addNewPolicyPage, subBenefitPage);
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
