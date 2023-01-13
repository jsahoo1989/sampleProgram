package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.aires.testdatatypes.pdt.PDT_FinalMoveBenefit;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_FinalMovePage extends PDT_SharedSubBenefitPage {
	public PDT_FinalMovePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Transportation Type']")
	private WebElement _lblTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='finalMoveTransportTypeList']")
	private WebElement _drpDownTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='finalMoveTransportTypeList'] span.ng-option-label")
	private List<WebElement> _drpDownTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='finalMoveTransportTypeList'] span.ng-value-label")
	private List<WebElement> _drpDownTransportationTypeMultiSelectOptions;

	@FindBy(how = How.XPATH, using = "//label[text()='Accompanying Family Members']")
	private WebElement _lblAccompanyingFamilyMember;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode']")
	private WebElement _drpDownAccompanyingFamilyMemberCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-option-label")
	private List<WebElement> _drpDownAccompanyingFamilyMemberCodeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownAccompanyingFamilyMemberCodeOptionsSelected;

	@FindBy(how = How.CSS, using = "#collapseOne1 label.form-check-label")
	private List<WebElement> _radioBtnFinalMoveTransport;

	@FindBy(how = How.CSS, using = "#collapseOne1 input[formcontrolname='paidByOther']")
	private WebElement _txtBoxFinalMoveTransportReimbursedByOther;

	@FindBy(how = How.CSS, using = "#collapseOne1 textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaFinalMoveTransportComment;

	@FindBy(how = How.XPATH, using = "//label[text()='Duration']")
	private WebElement _lblDuration;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='finalMoveDurationCode']")
	private WebElement _drpDownDuration;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='finalMoveDurationCode'] span.ng-option-label")
	private List<WebElement> _drpDownDurationOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='finalMoveDurationCode'] span.ng-value-label")
	private WebElement _drpDownDurationOptionsSelected;

	@FindBy(how = How.XPATH, using = "//label[text()='Number of Nights']")
	private WebElement _lblNumberOfNights;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfNight']")
	private WebElement _txtBoxNumberOfNights;

	@FindBy(how = How.XPATH, using = "//label[text()='Max. Amount']")
	private WebElement _lblMaxAmt;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode']")
	private WebElement _drpDownMaxAmt;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode'] span.ng-option-label")
	private List<WebElement> _drpDownMaxAmtOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode'] span.ng-value-label")
	private WebElement _drpDownMaxAmtSelectedOption;

	@FindBy(how = How.XPATH, using = "//label[text()='Flat Amount/Night']")
	private WebElement _lblFlatAmount;

	@FindBy(how = How.CSS, using = "input[formcontrolname='flatAmountPerNight']")
	private WebElement _txtBoxFlatAmtPerNight;

	@FindBy(how = How.XPATH, using = "//label[text()='Currency']")
	private WebElement _lblCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrencyCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyCodeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownCurrencyCodeSelected;

	@FindBy(how = How.CSS, using = "#collapseTwo label.form-check-label")
	private List<WebElement> _radioBtnFinalMoveLodging;

	@FindBy(how = How.CSS, using = "app-trip-lodging input[formcontrolname='paidByOther']")
	private WebElement _txtBoxFinalMoveLodgingReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-final-lodging textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaFinalMoveLodgingComment;

	// Final Move Meals
	@FindBy(how = How.XPATH, using = "//label[text()='Number of Days for Meals']")
	private WebElement _lblNumOfDaysForMeals;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='finalMoveDurationCode']")
	private WebElement _drpDownNumOfDaysForMeals;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='finalMoveDurationCode'] span.ng-option-label")
	private List<WebElement> _drpDownNumOfDaysForMealsOptions;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='finalMoveDurationCode'] span.ng-value-label")
	private WebElement _drpDownNumOfDaysForMealsSelected;

	@FindBy(how = How.XPATH, using = "//label[text()='Number of Days']")
	private WebElement _lblNumOfDays;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfDay']")
	private WebElement _txtBoxNumOfDays;

	@FindBy(how = How.XPATH, using = "//label[text()='Type']")
	private WebElement _lblType;

	@FindBy(how = How.CSS, using = "#collapseThree label.form-check-label")
	private List<WebElement> _radioBtnHouseHuntingTripMeals;

	@FindBy(how = How.XPATH, using = "//*[@id='collapseThree']//label[text()='Max. Amount']")
	private WebElement _lblMaxAmtFinalMoveMeals;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='maxAmountCode']")
	private WebElement _drpDownMaxAmountMeals;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='maxAmountCode'] span.ng-option-label")
	private List<WebElement> _drpDownMaxAmountMealsOptions;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='maxAmountCode'] span.ng-value-label")
	private WebElement _drpDownMaxAmountMealsSelectedVal;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountEe']")
	private WebElement _txtBoxMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe']")
	private WebElement _drpDownTransfereeCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe'] span.ng-option-label")
	private List<WebElement> _drpDownTransfereeCurrencyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownTransfereeCurrencyOptionSelected;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountAdult']")
	private WebElement _txtBoxMaxAmtAdult;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailAdultCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailAdult;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult']")
	private WebElement _drpDownAdultCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult'] span.ng-option-label")
	private List<WebElement> _drpDownAdultCurrencyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownAdultCurrencyOptionSelected;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountChild']")
	private WebElement _txtBoxMaxAmtChild;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailChildCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailChild;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild']")
	private WebElement _drpDownCurrencyCodeChild;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyCodeChildOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownCurrencyCodeChildOptionSelected;

	@FindBy(how = How.CSS, using = "app-final-meals input[formcontrolname='paidByOther']")
	private WebElement _txtBoxFinalMoveMealReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-final-meals textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaFinalMoveMealComment;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='maxAmountEe']/preceding-sibling::label")
	private WebElement _lblMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='maxAmountAdult']/preceding-sibling::label")
	private WebElement _lblMaxAmtOtherAdults;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='maxAmountChild']/preceding-sibling::label")
	private WebElement _lblMaxAmtChildren;

	@FindBy(how = How.CSS, using = "a[href='#collapseOne1']")
	private WebElement _formHeaderFinalMoveTransportation;

	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formHeaderFinalMoveLodging;

	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _formHeaderFinalMoveMeals;

	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;

	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	// Transportation Type additional fields

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='distanceFm']/preceding-sibling::label")
	private WebElement _lblDistance;

	@FindBy(how = How.CSS, using = "input[formcontrolname='distanceFm']")
	private WebElement _txtBoxDistance;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfDistanceCodeFm']/ancestor::div/preceding-sibling::label")
	private WebElement _lblUnitOfDistance;

	@FindBy(how = How.CSS, using = "input[formcontrolname='unitOfDistanceCodeFm']")
	private List<WebElement> _radioBtnUnitOfDistance;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfDistanceCodeFm']/parent::label")
	private List<WebElement> _radioBtnUnitOfDistanceLabel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minDistanceEconomyFm']/preceding-sibling::label")
	private WebElement _lblMinDistanceForEconomyTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceEconomyFm']")
	private WebElement _txtBoxMinDistanceEconomy;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfEconomyCodeFm']/ancestor::div/preceding-sibling::label")
	private WebElement _lblUnitOfDistanceForEconomyCode;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfEconomyCodeFm']/parent::label")
	private List<WebElement> _lblUnitOfDistanceForEconomyAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='unitOfEconomyCodeFm']")
	private List<WebElement> _radioBtnUnitOfDistanceForEconomyCode;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='unitOfBusinessCodeFm']/preceding-sibling::label")
	private WebElement _lblBusinessClassAirFareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfBusinessCodeFm']")
	private WebElement _drpDownBusinessClassAirfareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfBusinessCodeFm'] span.ng-value-label")
	private WebElement _drpDownOptionSelectedBusinessClassAirfareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfBusinessCodeFm'] span.ng-option-label")
	private List<WebElement> _drpDownOptionsBusinessClassAirfareUnit;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minDistanceBusinessFm']/preceding-sibling::label")
	private WebElement _lblMinDistanceForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceBusinessFm']")
	private WebElement _txtBoxMinDistanceForBusinessAirTravel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minTimeBusinessFm']/preceding-sibling::label")
	private WebElement _lblMinTimeForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minTimeBusinessFm']")
	private WebElement _txtBoxMinTimeForBusinessAirTravel;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='finalMoveTransportTypeList'] span.ng-value-icon.left")
	private WebElement _iconClearTransportationType;

	private ArrayList<String> _transportType = null;

	PDT_FinalMoveBenefit finalMoveBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getFinalMoveDataList("Final Move");

	private String accompanyingFamilyMemeber, duration, maxAmtFinalMoveLodging, maxAmtFinalMoveMeals, numOfDaysForMeals;

	public void setTransportType(ArrayList<String> transportTypeOptions) {
		this._transportType = transportTypeOptions;
	}

	public ArrayList<String> getTransportType() {
		return _transportType;
	}

	public void setAccompanyingFamilyMember(String accFamilyMem) {
		accompanyingFamilyMemeber = accFamilyMem;
	}

	public String getAccompanyingFamilyMember() {
		return accompanyingFamilyMemeber;
	}

	public void setDuration(String durationPeriod) {
		duration = durationPeriod;
	}

	public String getDuration() {
		return duration;
	}

	public void setMaxAmtFinalMoveLodging(String maxAmt) {
		maxAmtFinalMoveLodging = maxAmt;
	}

	public String getMaxAmtFinalMoveLodging() {
		return maxAmtFinalMoveLodging;
	}

	public void setNumberOfDaysForMeals(String numOfDays) {
		numOfDaysForMeals = numOfDays;
	}

	public String getNumberOfDaysForMeals() {
		return numOfDaysForMeals;
	}

	public void setMaxAmtFinalMoveMeals(String maxAmt) {
		maxAmtFinalMoveMeals = maxAmt;
	}

	public String getMaxAmtFinalMoveMeals() {
		return maxAmtFinalMoveMeals;
	}

	/**
	 * Add the Form Header of Final Move Transportation, Final Move Lodging & Final
	 * Move Meals in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.FINAL_MOVE_TRANSPORTATION, _formHeaderFinalMoveTransportation);
		subBenefitHeaderMap.put(PDTConstants.FINAL_MOVE_LODGING, _formHeaderFinalMoveLodging);
		subBenefitHeaderMap.put(PDTConstants.FINAL_MOVE_MEALS, _formHeaderFinalMoveMeals);
	}

	public void selectRandomTransportTypeOption(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);
			String randTransportTypeOption = CoreFunctions
					.getRandomAndUniqueMultipleSelectDropDownOptions(_drpDownTransportationTypeOptions);
			String[] transportationType = randTransportTypeOption.split(",");
			for (int i = 0; i < transportationType.length; i++) {
				CoreFunctions.selectItemInListByText(driver, _drpDownTransportationTypeOptions,
						transportationType[i].trim(), _lblTransportationType.getText(), PDTConstants.DROP_DOWN, true);
			}
			if (_drpDownTransportationTypeMultiSelectOptions.size() > 1) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DOWN_MULTISELECT,
						CoreConstants.PASS, _lblTransportationType.getText(),
						CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
								.toString()));
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL,
					_lblTransportationType.getText(), subBenefitFormName));
		}
	}

	/**
	 * Fill Final Move Transportation Form.
	 * 
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillFinalMoveTransportationForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String pageName, PDT_SharedSubBenefit_Steps objStep) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName),
					subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblTransportationType,
					_lblTransportationType.getText());
			selectAllTransportTypeOptions(addNewPolicyPage, subBenefitFormName, objStep);

			String randAccompanyingFamilMember = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownAccompanyingFamilyMemberCode,
					_drpDownAccompanyingFamilyMemberCodeOptions, _drpDownAccompanyingFamilyMemberCodeOptionsSelected,
					_lblAccompanyingFamilyMember.getText());
			setAccompanyingFamilyMember(randAccompanyingFamilMember);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnFinalMoveTransport);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinalMoveTransport,
					finalMoveBenefitData.finalMoveTransportation.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinalMoveTransport,
					finalMoveBenefitData.finalMoveTransportation.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					finalMoveBenefitData.finalMoveTransportation.reimbursedBy,
					_txtBoxFinalMoveTransportReimbursedByOther,
					finalMoveBenefitData.finalMoveTransportation.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaFinalMoveTransportComment, PDTConstants.COMMENT,
					finalMoveBenefitData.finalMoveTransportation.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void verifyAndFillFlatAmtPerNightTextBoxAndCurrencyDrpDown(PDT_AddNewPolicyPage addNewPolicyPage,
			String subBenefitFormName) {
		try {
			if (_drpDownMaxAmtSelectedOption.getText().equalsIgnoreCase(PDTConstants.FLAT_AMT)
					&& CoreFunctions.isElementExist(driver, _txtBoxFlatAmtPerNight, 1)
							& CoreFunctions.isElementExist(driver, _drpDownCurrencyCode, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.FLAT_AMT_PER_NIGHT, subBenefitFormName));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.CURRENCY, subBenefitFormName));
				CoreFunctions.clickElement(driver, _txtBoxFlatAmtPerNight);
				CoreFunctions.clearAndSetText(driver, _txtBoxFlatAmtPerNight, _lblFlatAmount.getText(),
						finalMoveBenefitData.finalMoveLodging.flatAmountPerNight);
				CoreFunctions.clickElement(driver, _drpDownCurrencyCode);
				CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyCodeOptions,
						finalMoveBenefitData.finalMoveLodging.currency, _lblCurrency.getText(), PDTConstants.DROP_DOWN,
						true);
			}
		} catch (Exception e) {
			Assert.fail(PDTConstants.FAILED_TO_FILL_FIELD_VALUES);
		}
	}

	public void verifyAndFillNumberOfNights(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (_drpDownDurationOptionsSelected.getText().equalsIgnoreCase(PDTConstants.SET_OF_DAYS)
					&& CoreFunctions.isElementExist(driver, _txtBoxNumberOfNights, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblNumberOfNights.getText(), subBenefitFormName));
				CoreFunctions.clickElement(driver, _txtBoxNumberOfNights);
				CoreFunctions.clearAndSetText(driver, _txtBoxNumberOfNights, _lblNumberOfNights.getText(),
						finalMoveBenefitData.finalMoveLodging.numberOfNights);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_VALUE_IN_TEXTBOX, CoreConstants.FAIL,
					_lblNumberOfNights.getText(), subBenefitFormName));
		}
	}

	public void verifyAndFillNumberOfDays(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (_drpDownNumOfDaysForMealsSelected.getText().equalsIgnoreCase(PDTConstants.SET_OF_DAYS)
					&& CoreFunctions.isElementExist(driver, _txtBoxNumOfDays, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblNumOfDays.getText(), subBenefitFormName));
				CoreFunctions.clickElement(driver, _txtBoxNumOfDays);
				CoreFunctions.clearAndSetText(driver, _txtBoxNumOfDays, _lblNumOfDays.getText(),
						finalMoveBenefitData.finalMoveMeals.numberOfDays);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_VALUE_IN_TEXTBOX, CoreConstants.FAIL,
					_lblNumOfDays.getText(), subBenefitFormName));
		}
	}

	/**
	 * Fill Final Move Lodging Form.
	 * 
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillFinalMoveLodgingForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName),
					subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _drpDownDuration, _lblDuration.getText());
			String randDuration = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownDuration, _drpDownDurationOptions, _drpDownDurationOptionsSelected,
					_lblDuration.getText());
			setDuration(randDuration);
			verifyAndFillNumberOfNights(addNewPolicyPage, subBenefitFormName);
			String maxAmt = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownMaxAmt, _drpDownMaxAmtOptions, _drpDownMaxAmtSelectedOption,
					_lblMaxAmt.getText());
			setMaxAmtFinalMoveLodging(maxAmt);
			verifyAndFillFlatAmtPerNightTextBoxAndCurrencyDrpDown(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnFinalMoveLodging);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinalMoveLodging,
					finalMoveBenefitData.finalMoveLodging.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinalMoveLodging,
					finalMoveBenefitData.finalMoveLodging.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, finalMoveBenefitData.finalMoveLodging.reimbursedBy,
					_txtBoxFinalMoveLodgingReimbursedByOther, finalMoveBenefitData.finalMoveLodging.reimbursedByOther,
					subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaFinalMoveLodgingComment, PDTConstants.COMMENT,
					finalMoveBenefitData.finalMoveLodging.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void checkIfFlatAmtIsSelected(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		if (_drpDownMaxAmountMealsSelectedVal.getText().equalsIgnoreCase(PDTConstants.FLAT_AMT)) {
			verifyAndFillTransfereeMealInfo(addNewPolicyPage, subBenefitFormName);
			verifyAndFillAdultMealInfo(addNewPolicyPage, subBenefitFormName);
			verifyAndFillChildMealInfo(addNewPolicyPage, subBenefitFormName);
		}
	}

	public void verifyAndFillTransfereeMealInfo(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (CoreFunctions.isElementExist(driver, _txtBoxMaxAmtTransferee, 1)
					& CoreFunctions.isElementExist(driver, _drpDownTransfereeCurrency, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblMaxAmtTransferee.getText(), subBenefitFormName));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.CURRENCY, subBenefitFormName));
				CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmtTransferee, _lblMaxAmtTransferee.getText(),
						finalMoveBenefitData.finalMoveMeals.maxAmtTransferee);
				CoreFunctions.selectItemInListByText(driver, _radioDetailTransfereeCode,
						finalMoveBenefitData.finalMoveMeals.maxAmtTransfereeDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownTransfereeCurrency);
				CoreFunctions.selectItemInListByText(driver, _drpDownTransfereeCurrencyOptions,
						finalMoveBenefitData.finalMoveMeals.maxAmtTransfereeCurrency, PDTConstants.CURRENCY,
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL,
					PDTConstants.TRANSFEREE_INFO, subBenefitFormName));
		}
	}

	public void verifyAndFillAdultMealInfo(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (CoreFunctions.isElementExist(driver, _txtBoxMaxAmtAdult, 1)
					& CoreFunctions.isElementExist(driver, _drpDownAdultCurrency, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblMaxAmtOtherAdults.getText(), subBenefitFormName));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.CURRENCY, subBenefitFormName));
				CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmtAdult, _lblMaxAmtOtherAdults.getText(),
						finalMoveBenefitData.finalMoveMeals.maxAmtAdult);
				CoreFunctions.selectItemInListByText(driver, _radioDetailAdult,
						finalMoveBenefitData.finalMoveMeals.maxAmtAdultDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownAdultCurrency);
				CoreFunctions.selectItemInListByText(driver, _drpDownAdultCurrencyOptions,
						finalMoveBenefitData.finalMoveMeals.maxAmtAdultCurrency, PDTConstants.CURRENCY,
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL,
					PDTConstants.ADULT_INFO, subBenefitFormName));
		}
	}

	public void verifyAndFillChildMealInfo(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (CoreFunctions.isElementExist(driver, _txtBoxMaxAmtChild, 1)
					& CoreFunctions.isElementExist(driver, _drpDownCurrencyCodeChild, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblMaxAmtChildren.getText(), subBenefitFormName));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.CURRENCY, subBenefitFormName));
				CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmtChild, _lblMaxAmtChildren.getText(),
						finalMoveBenefitData.finalMoveMeals.maxAmtChildren);
				CoreFunctions.selectItemInListByText(driver, _radioDetailChild,
						finalMoveBenefitData.finalMoveMeals.maxAmtChildrenDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownCurrencyCodeChild);
				CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyCodeChildOptions,
						finalMoveBenefitData.finalMoveMeals.maxAmtChildrenCurrency, PDTConstants.CURRENCY,
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL,
					PDTConstants.CHILDREN_INFO, subBenefitFormName));
		}
	}

	/**
	 * Fill Final Move Meal Form
	 * 
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillFinalMoveMealForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName),
					subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _drpDownNumOfDaysForMeals,
					_lblNumOfDaysForMeals.getText());
			String randNumDays = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownNumOfDaysForMeals, _drpDownNumOfDaysForMealsOptions,
					_drpDownNumOfDaysForMealsSelected, _lblNumOfDaysForMeals.getText());
			setNumberOfDaysForMeals(randNumDays);
			verifyAndFillNumberOfDays(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripMeals,
					finalMoveBenefitData.finalMoveMeals.type, _lblType.getText(), PDTConstants.RADIO_BUTTON_LIST, true);

			String maxAmt = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownMaxAmountMeals, _drpDownMaxAmountMealsOptions,
					_drpDownMaxAmountMealsSelectedVal, _lblMaxAmtFinalMoveMeals.getText());
			setMaxAmtFinalMoveMeals(maxAmt);
			checkIfFlatAmtIsSelected(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHouseHuntingTripMeals);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripMeals,
					finalMoveBenefitData.finalMoveMeals.grossUp, PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST,
					true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripMeals,
					finalMoveBenefitData.finalMoveMeals.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, finalMoveBenefitData.finalMoveMeals.reimbursedBy,
					_txtBoxFinalMoveMealReimbursedByOther, finalMoveBenefitData.finalMoveMeals.reimbursedByOther,
					subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaFinalMoveMealComment, PDTConstants.COMMENT,
					finalMoveBenefitData.finalMoveMeals.comment);

		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Fill Final Move sub-benefit based on sub-benefit name
	 * 
	 * @param subBenefit
	 * @param pageName
	 * @param addNewPolicyPage
	 */
	public void fillFinalMoveSubBenefit(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage,
			PDT_SharedSubBenefitPage subBenefitPage, PDT_SharedSubBenefit_Steps objStep) {
		switch (subBenefit) {
		case PDTConstants.FINAL_MOVE_TRANSPORTATION:
			fillFinalMoveTransportationForm(addNewPolicyPage, subBenefit, pageName, objStep);
			break;
		case PDTConstants.FINAL_MOVE_LODGING:
			fillFinalMoveLodgingForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.FINAL_MOVE_MEALS:
			fillFinalMoveMealForm(addNewPolicyPage, subBenefit, pageName);
			break;
		default:
			Assert.fail(
					MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}
	}

	/**
	 * Iterate Final Move sub-benefits and fill their corresponding form.
	 * 
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage
	 */
	public void iterateAndFillFinalMoveSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep, String btnName,
			PDT_SharedSubBenefitPage subBenefitPage) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		WebElement btnToClick = (btnName != null) ? buttonMap.get(btnName) : buttonMap.get(PDTConstants.SAVE);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			fillFinalMoveSubBenefit(subBenefit, pageName, addNewPolicyPage, subBenefitPage, objStep);
		}
		try {
			CoreFunctions.click(driver, btnToClick, btnToClick.getText());
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}
	}

	public void selectAllTransportTypeOptions(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			PDT_SharedSubBenefit_Steps objStep) {
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);
			ArrayList<String> randTransportTypeOption = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownTransportationTypeOptions.size(), 4, driver, _drpDownTransportationTypeOptions);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.TRANSPORTATION_TYPE,
					_drpDownTransportationType, _drpDownTransportationTypeOptions,
					_drpDownTransportationTypeMultiSelectOptions, randTransportTypeOption, subBenefitFormName);
			setTransportType(randTransportTypeOption);
			verifyAndFillDistanceOptionsField(objStep);
			verifyAndFillEconomyAirTravelField(objStep);
			verifyAndFillBusinessAirTravelField(objStep);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL,
					_lblTransportationType.getText(), subBenefitFormName));
		}
	}

	public void verifyAndFillDistanceOptionsField(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
					.contains(PDTConstants.DISTANCE)) {

				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyElementPresentOnPage(_lblDistance, PDTConstants.LABEL,
								PDTConstants.DISTANCE),
						MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
								PDTConstants.LABEL, PDTConstants.DISTANCE));
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyElementPresentOnPage(_txtBoxDistance, PDTConstants.TEXTBOX,
								PDTConstants.DISTANCE),
						MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
								PDTConstants.TEXTBOX, PDTConstants.DISTANCE));
				// Boundary check for distance textbox
				String random9DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(9);
				String random10DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(10);

				CoreFunctions.clickElement(driver, _txtBoxDistance);
				CoreFunctions.clearAndSetText(driver, _txtBoxDistance, _lblDistance.getText(), random9DigitStr);
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxDistance, "value"),
								random9DigitStr, PDTConstants.DISTANCE, random9DigitStr.length(),
								Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE)),
						MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
								CoreConstants.FAIL, PDTConstants.DISTANCE, random9DigitStr.length(),
								CoreFunctions.getAttributeText(_txtBoxDistance, "value"), random9DigitStr));

				CoreFunctions.clearAndSetText(driver, _txtBoxDistance, _lblDistance.getText(),
						PDTConstants.ELEVEN_DIGIT_STRING);
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxDistance, "value"),
								PDTConstants.ELEVEN_DIGIT_STRING, PDTConstants.DISTANCE,
								PDTConstants.ELEVEN_DIGIT_STRING.length(),
								Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE)),
						MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
								CoreConstants.FAIL, PDTConstants.DISTANCE, PDTConstants.ELEVEN_DIGIT_STRING.length(),
								CoreFunctions.getAttributeText(_txtBoxDistance, "value"),
								PDTConstants.ELEVEN_DIGIT_STRING));

				CoreFunctions.clearAndSetText(driver, _txtBoxDistance, _lblDistance.getText(), random10DigitStr);
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxDistance, "value"),
								random10DigitStr, PDTConstants.DISTANCE, random10DigitStr.length(),
								Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE)),
						MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
								CoreConstants.FAIL, PDTConstants.DISTANCE, random10DigitStr.length(),
								CoreFunctions.getAttributeText(_txtBoxDistance, "value"), random10DigitStr));

				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyElementPresentOnPage(_lblUnitOfDistance, PDTConstants.LABEL,
								PDTConstants.UNIT_OF_DISTANCE),
						MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
								PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE));
				for (WebElement btn : _radioBtnUnitOfDistanceLabel) {
					sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
							CoreFunctions.verifyElementPresentOnPage(btn, PDTConstants.RADIOBTN,
									_radioBtnUnitOfDistanceLabel.get(_radioBtnUnitOfDistanceLabel.indexOf(btn))
											.getText().trim()),
							MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
									PDTConstants.RADIOBTN, _radioBtnUnitOfDistanceLabel
											.get(_radioBtnUnitOfDistanceLabel.indexOf(btn)).getText().trim()));
				}
				CoreFunctions.selectItemInListByText(driver, _radioBtnUnitOfDistanceLabel, PDTConstants.KM);
			}
		} catch (Exception e) {			
			Assert.fail("Failed to verify Distance options field");
		}
	}

	public void verifyAndFillEconomyAirTravelField(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
					.contains(PDTConstants.ECONOMY_CLASS_AIRFARE)) {
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyElementPresentOnPage(_lblMinDistanceForEconomyTravel, PDTConstants.LABEL,
								PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL),
						MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
								PDTConstants.LABEL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL));
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyElementPresentOnPage(_txtBoxMinDistanceEconomy, PDTConstants.TEXTBOX,
								PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL),
						MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
								PDTConstants.TEXTBOX, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL));
				// Boundary check for distance textbox
				String random9DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(9);
				String random10DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(10);

				CoreFunctions.clickElement(driver, _txtBoxMinDistanceEconomy);
				CoreFunctions.clearAndSetText(driver, _txtBoxMinDistanceEconomy,
						_lblMinDistanceForEconomyTravel.getText(), random9DigitStr);
				sharedSubBenefitStep.getCustomSoftAssertObj()
						.assertTrue(CoreFunctions.verifyTextForMaxLength(
								CoreFunctions.getAttributeText(_txtBoxMinDistanceEconomy, "value"), random9DigitStr,
								PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL, random9DigitStr.length(),
								Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_ECO_AIR_TRAVEL)),
								MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
										CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL,
										random9DigitStr.length(),
										CoreFunctions.getAttributeText(_txtBoxMinDistanceEconomy, "value"),
										random9DigitStr));

				CoreFunctions.clearAndSetText(driver, _txtBoxMinDistanceEconomy,
						_lblMinDistanceForEconomyTravel.getText(), PDTConstants.ELEVEN_DIGIT_STRING);
				sharedSubBenefitStep.getCustomSoftAssertObj()
						.assertTrue(CoreFunctions.verifyTextForMaxLength(
								CoreFunctions.getAttributeText(_txtBoxMinDistanceEconomy, "value"),
								PDTConstants.ELEVEN_DIGIT_STRING, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL,
								PDTConstants.ELEVEN_DIGIT_STRING.length(),
								Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_ECO_AIR_TRAVEL)),
								MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
										CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL,
										PDTConstants.ELEVEN_DIGIT_STRING.length(),
										CoreFunctions.getAttributeText(_txtBoxMinDistanceEconomy, "value"),
										PDTConstants.ELEVEN_DIGIT_STRING));

				CoreFunctions.clearAndSetText(driver, _txtBoxMinDistanceEconomy,
						_lblMinDistanceForEconomyTravel.getText(), random10DigitStr);
				sharedSubBenefitStep.getCustomSoftAssertObj()
						.assertTrue(CoreFunctions.verifyTextForMaxLength(
								CoreFunctions.getAttributeText(_txtBoxMinDistanceEconomy, "value"), random10DigitStr,
								PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL, random10DigitStr.length(),
								Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_ECO_AIR_TRAVEL)),
								MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
										CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL,
										random10DigitStr.length(),
										CoreFunctions.getAttributeText(_txtBoxMinDistanceEconomy, "value"),
										random10DigitStr));

				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyElementPresentOnPage(_lblUnitOfDistanceForEconomyCode, PDTConstants.LABEL,
								PDTConstants.UNIT_OF_DISTANCE),
						MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
								PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE));
				for (WebElement btn : _lblUnitOfDistanceForEconomyAirTravel) {
					sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
							CoreFunctions.verifyElementPresentOnPage(btn, PDTConstants.RADIOBTN,
									_lblUnitOfDistanceForEconomyAirTravel
											.get(_lblUnitOfDistanceForEconomyAirTravel.indexOf(btn)).getText().trim()),
							MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
									PDTConstants.RADIOBTN, _lblUnitOfDistanceForEconomyAirTravel
											.get(_lblUnitOfDistanceForEconomyAirTravel.indexOf(btn)).getText().trim()));
				}
				CoreFunctions.selectItemInListByText(driver, _lblUnitOfDistanceForEconomyAirTravel, PDTConstants.MILES);
			}
		} catch (Exception e) {			
			Assert.fail("Failed to verify Economy Class AirFare options field");
		}
	}

	public void verifyKmMiles(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyElementPresentOnPage(_lblMinDistanceForBusinessAirTravel, PDTConstants.LABEL,
							_lblMinDistanceForBusinessAirTravel.getText()),
					MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
							PDTConstants.LABEL, _lblMinDistanceForBusinessAirTravel.getText()));

			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyElementPresentOnPage(_txtBoxMinDistanceForBusinessAirTravel,
							PDTConstants.TEXTBOX, _lblMinDistanceForBusinessAirTravel.getText()),
					MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
							PDTConstants.TEXTBOX, _lblMinDistanceForBusinessAirTravel.getText()));

			// Boundary check for Min Distance Business textbox
			String random9DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(9);
			String random10DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(10);

			CoreFunctions.clickElement(driver, _txtBoxMinDistanceForBusinessAirTravel);
			CoreFunctions.clearAndSetText(driver, _txtBoxMinDistanceForBusinessAirTravel,
					_lblMinDistanceForBusinessAirTravel.getText(), random9DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(
					CoreFunctions.getAttributeText(_txtBoxMinDistanceForBusinessAirTravel, "value"), random9DigitStr,
					PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, random9DigitStr.length(),
					Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE_BUS_AIR_TRAVEL)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL,
							random9DigitStr.length(),
							CoreFunctions.getAttributeText(_txtBoxMinDistanceForBusinessAirTravel, "value"),
							random9DigitStr));

			CoreFunctions.clearAndSetText(driver, _txtBoxMinDistanceForBusinessAirTravel,
					_lblMinDistanceForBusinessAirTravel.getText(), PDTConstants.ELEVEN_DIGIT_STRING);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyTextForMaxLength(
							CoreFunctions.getAttributeText(_txtBoxMinDistanceForBusinessAirTravel, "value"),
							PDTConstants.ELEVEN_DIGIT_STRING, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL,
							PDTConstants.ELEVEN_DIGIT_STRING.length(),
							Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE_BUS_AIR_TRAVEL)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL,
							PDTConstants.ELEVEN_DIGIT_STRING.length(),
							CoreFunctions.getAttributeText(_txtBoxMinDistanceForBusinessAirTravel, "value"),
							PDTConstants.ELEVEN_DIGIT_STRING));

			CoreFunctions.clearAndSetText(driver, _txtBoxMinDistanceForBusinessAirTravel,
					_lblMinDistanceForBusinessAirTravel.getText(), random10DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(
					CoreFunctions.getAttributeText(_txtBoxMinDistanceForBusinessAirTravel, "value"), random10DigitStr,
					PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, random10DigitStr.length(),
					Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE_BUS_AIR_TRAVEL)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL,
							random10DigitStr.length(),
							CoreFunctions.getAttributeText(_txtBoxMinDistanceForBusinessAirTravel, "value"),
							random10DigitStr));
		} catch (Exception e) {
			Assert.fail("Failed to verify Min. Distance for Business Air Travel.");
		}
	}

	public void verifyHours(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyElementPresentOnPage(_lblMinTimeForBusinessAirTravel, PDTConstants.LABEL,
							_lblMinTimeForBusinessAirTravel.getText()),
					MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
							PDTConstants.LABEL, _lblMinTimeForBusinessAirTravel.getText()));

			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyElementPresentOnPage(_txtBoxMinTimeForBusinessAirTravel, PDTConstants.TEXTBOX,
							_lblMinTimeForBusinessAirTravel.getText()),
					MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
							PDTConstants.TEXTBOX, _lblMinTimeForBusinessAirTravel.getText()));

			// Boundary check for Min Distance Business textbox
			String random2DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(2);
			String random3DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(3);

			CoreFunctions.clickElement(driver, _txtBoxMinTimeForBusinessAirTravel);
			CoreFunctions.clearAndSetText(driver, _txtBoxMinTimeForBusinessAirTravel,
					_lblMinTimeForBusinessAirTravel.getText(), random2DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(
					CoreFunctions.getAttributeText(_txtBoxMinTimeForBusinessAirTravel, "value"), random2DigitStr,
					PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, random2DigitStr.length(),
					Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_BUS_AIR_TRAVEL_INHRS)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS,
							random2DigitStr.length(),
							CoreFunctions.getAttributeText(_txtBoxMinTimeForBusinessAirTravel, "value"),
							random2DigitStr));

			CoreFunctions.clearAndSetText(driver, _txtBoxMinTimeForBusinessAirTravel,
					_lblMinTimeForBusinessAirTravel.getText(), PDTConstants.FOUR_DIGIT_STRING);
			sharedSubBenefitStep.getCustomSoftAssertObj()
					.assertTrue(CoreFunctions.verifyTextForMaxLength(
							CoreFunctions.getAttributeText(_txtBoxMinTimeForBusinessAirTravel, "value"),
							PDTConstants.FOUR_DIGIT_STRING, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS,
							PDTConstants.FOUR_DIGIT_STRING.length(),
							Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_BUS_AIR_TRAVEL_INHRS)),
							MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHAR,
									CoreConstants.FAIL, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS,
									PDTConstants.FOUR_DIGIT_STRING.length(),
									CoreFunctions.getAttributeText(_txtBoxMinTimeForBusinessAirTravel, "value"),
									PDTConstants.FOUR_DIGIT_STRING));

			CoreFunctions.clearAndSetText(driver, _txtBoxMinTimeForBusinessAirTravel,
					_lblMinTimeForBusinessAirTravel.getText(), random3DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(
					CoreFunctions.getAttributeText(_txtBoxMinTimeForBusinessAirTravel, "value"), random3DigitStr,
					PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, random3DigitStr.length(),
					Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_BUS_AIR_TRAVEL_INHRS)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS,
							random3DigitStr.length(),
							CoreFunctions.getAttributeText(_txtBoxMinTimeForBusinessAirTravel, "value"),
							random3DigitStr));

		} catch (Exception e) {
			Assert.fail("Failed to verify Hours for Business Air Travel.");
		}
	}

	public void verifyKmMilesHours(PDT_SharedSubBenefit_Steps sharedSubBenefitStep, String option) {
		if (option.equalsIgnoreCase(PDTConstants.KM) || option.equalsIgnoreCase(PDTConstants.MILES)) {
			verifyKmMiles(sharedSubBenefitStep);
		} else if (option.equalsIgnoreCase(PDTConstants.HOURS)) {
			verifyHours(sharedSubBenefitStep);
		} else {
			Assert.fail("Not a valid option for Business Air Travel");
		}
	}

	public void verifyAndFillBusinessAirTravelField(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		List<String> businessAirFareUnit = new ArrayList<String>();
		try {
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
					.contains(PDTConstants.BUSINESS_CLASS_AIRFARE)) {
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyElementPresentOnPage(_lblBusinessClassAirFareUnit, PDTConstants.LABEL,
								PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT),
						MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
								PDTConstants.LABEL, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyElementPresentOnPage(_drpDownBusinessClassAirfareUnit,
								PDTConstants.DROP_DOWN, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT),
						MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
								PDTConstants.DROP_DOWN, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));

				CoreFunctions.clickElement(driver, _drpDownBusinessClassAirfareUnit);
				businessAirFareUnit = CoreFunctions.getElementTextAndStoreInList(driver,
						_drpDownOptionsBusinessClassAirfareUnit);

				for (String option : businessAirFareUnit) {
					CoreFunctions.clickElement(driver, _drpDownBusinessClassAirfareUnit);
					CoreFunctions.selectItemInListByText(driver, _drpDownOptionsBusinessClassAirfareUnit, option,
							_lblBusinessClassAirFareUnit.getText(), PDTConstants.DROP_DOWN, true);
					verifyKmMilesHours(sharedSubBenefitStep, option);
				}
			}
		} catch (Exception e) {			
			Assert.fail("Failed to verify Economy Class AirFare options field");
		}
	}
	
	public boolean verifyFinalMoveSubBenefitForTransportType(String pageName, String subBenefit,
			DataTable resultTable) {
		boolean result = false;
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		//WebElement btnToClick = (btnName != null) ? buttonMap.get(btnName) : buttonMap.get(PDTConstants.SAVE);
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			waitForProgressBarToDisapper();
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			//fillSubBenefitForm(subBenefit, pageName, addNewPolicyPage, objStep);
			result = verifyFinalMoveTripTransportationOptions(subBenefit, pageName, resultTable);
		try {
			CoreFunctions.click(driver, buttonMap.get(PDTConstants.SAVE_AND_CONTINUE), buttonMap.get(PDTConstants.SAVE_AND_CONTINUE).getText());
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, PDTConstants.SAVE_AND_CONTINUE));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, PDTConstants.SAVE_AND_CONTINUE));
		}
		return result;
	}
	
	public boolean verifyFinalMoveTripTransportationOptions(String subBenefitFormName,
			String pageName, DataTable resultTable) {
		boolean result = false;
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName),
					subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblTransportationType,
					_lblTransportationType.getText());

			//selectAllTransportTypeOptions(addNewPolicyPage, subBenefitFormName, objStep);
			result = verifyEachTransportationTypeOption(resultTable, pageName, subBenefitFormName);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occured while trying to verify Transportation type for "+pageName+" -> "+subBenefitFormName);
		}
		return result;
	}
	
	public boolean verifyEachTransportationTypeOption(DataTable resultTable,  String benefitCategory, String benefit) {
		ArrayList<Boolean> result = new ArrayList<Boolean>();
		List<Map<String, String>> resultTableMap = resultTable.asMaps(String.class, String.class);
		CoreFunctions.clickElement(driver, _drpDownTransportationType);
		for(int i=0; i<resultTableMap.size(); i++) {
			result.add(verifyTransportTypeOptions(resultTableMap.get(i), benefitCategory, benefit));
		}
		return result.stream().allMatch(t -> t.equals(true)) ? true : false;
	}
	
	public boolean verifyTransportTypeOptions(Map<String, String> resultTableMap, String benefitCategory, String benefit) {
		boolean result = false;
		switch(resultTableMap.get("Transportation_Type_Option")) {
		case PDTConstants.DISTANCE:
			result = verifyDistanceOptionFieldsForVisibilty(resultTableMap, benefitCategory, benefit) && verifyDistanceOptionFieldsForInvisibilty(resultTableMap, benefitCategory, benefit);
			break;
		case PDTConstants.ECONOMY_CLASS_AIRFARE:
			result = verifyEconomyClassFieldsForVisibilty(resultTableMap, benefitCategory, benefit) && verifyEconomyClassFieldsForInvisibilty(resultTableMap, benefitCategory, benefit);
			break;
		case PDTConstants.BUSINESS_CLASS_AIRFARE:
			result = verifyBusinessClassForVisibilty(resultTableMap, benefitCategory, benefit) && verifyBusinessClassFieldsForInvisibilty(resultTableMap, benefitCategory, benefit);;
			break;
		default:
			Assert.fail("Not valid transportation type option");
		}
		return result;
	}
	
	public void printMessageForFieldVisibility(boolean result, String fieldName, String benefitCategory, String benefit) {
		if(result)
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TRANSPORTATION_TYPE_OPTION_VISIBILITY, CoreConstants.PASS, fieldName, benefit));
		else
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_TRANSPORTATION_TYPE_OPTION_VISIBILITY, CoreConstants.FAIL, fieldName, benefit));
	}
	
	public void printMessageForFieldInVisibility(boolean result, String fieldName, String benefitCategory, String benefit) {
		if(result)
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TRANSPORTATION_TYPE_OPTION_INVISIBILITY, CoreConstants.PASS, fieldName, benefit));
		else
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_TRANSPORTATION_TYPE_OPTION_INVISIBILITY, CoreConstants.FAIL, fieldName, benefit));
	}
	
	public boolean verifyDistanceOptionFieldsForVisibilty(Map<String, String> resultTableMap, String benefitCategory, String benefit) {
		boolean result = false;
		ArrayList<Boolean> resultElementVisible = new ArrayList<Boolean>();
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);
			CoreFunctions.selectItemInListByText(driver, _drpDownTransportationTypeOptions, resultTableMap.get("Transportation_Type_Option"),
					_lblTransportationType.getText(), PDTConstants.DROP_DOWN, true);
			CoreFunctions.clickElement(driver, _lblDistance);
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_lblDistance, PDTConstants.LABEL, PDTConstants.DISTANCE));
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_txtBoxDistance, PDTConstants.TEXTBOX, PDTConstants.DISTANCE));
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_lblUnitOfDistance, PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE));
			for (WebElement btn : _radioBtnUnitOfDistanceLabel) {
				resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(btn, PDTConstants.RADIOBTN,
								_radioBtnUnitOfDistanceLabel.get(_radioBtnUnitOfDistanceLabel.indexOf(btn))
										.getText().trim()));
			}			
		} catch(Exception e) {
			Assert.fail("Exception occured while trying to verify Distance fields for Visibility");
		}
		result = resultElementVisible.stream().allMatch(t -> t.equals(true)) ? true : false;
		printMessageForFieldVisibility(result, resultTableMap.get("Transportation_Type_Option"), benefitCategory, benefit);
		return result;
	}

	public boolean verifyDistanceOptionFieldsForInvisibilty(Map<String, String> resultTableMap, String benefitCategory, String benefit) {
		boolean result = false;
		ArrayList<Boolean> resultElementInVisible = new ArrayList<Boolean>();
		try {
			CoreFunctions.hoverAndSingleClick(driver, _iconClearTransportationType, "Clear Transport Type Option");
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _txtBoxDistance);
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_lblDistance, PDTConstants.LABEL, PDTConstants.DISTANCE));
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_txtBoxDistance, PDTConstants.TEXTBOX, PDTConstants.DISTANCE));
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_lblUnitOfDistance, PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE));		
			resultElementInVisible.add(CoreFunctions.verifyListElementNotPresentOnPage(_radioBtnUnitOfDistanceLabel, PDTConstants.RADIOBTN, PDTConstants.KM));
			resultElementInVisible.add(CoreFunctions.verifyListElementNotPresentOnPage(_radioBtnUnitOfDistanceLabel, PDTConstants.RADIOBTN, PDTConstants.MILES));
		} catch(Exception e) {
			Assert.fail("Failed to verify Distance fields for invisibilty after deselecting the Distance option from Transportation Type dropdown.");
		}
		result = resultElementInVisible.stream().allMatch(t -> t.equals(true)) ? true : false;		
		printMessageForFieldInVisibility(result, resultTableMap.get("Transportation_Type_Option"), benefitCategory, benefit);
		return result;
	}
	
	public boolean verifyEconomyClassFieldsForVisibilty(Map<String, String> resultTableMap, String benefitCategory, String benefit) {
		boolean result = false;
		ArrayList<Boolean> resultElementVisible = new ArrayList<Boolean>();
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);
			CoreFunctions.selectItemInListByText(driver, _drpDownTransportationTypeOptions, resultTableMap.get("Transportation_Type_Option"),
					_lblTransportationType.getText(), PDTConstants.DROP_DOWN, true);
			CoreFunctions.clickElement(driver, _lblMinDistanceForEconomyTravel);
			CoreFunctions.explicitWaitForElementTextPresent(driver, _lblUnitOfDistanceForEconomyCode, PDTConstants.UNIT_OF_DISTANCE, 5);
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_lblMinDistanceForEconomyTravel, PDTConstants.LABEL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL));
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_txtBoxMinDistanceEconomy, PDTConstants.TEXTBOX, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL));
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_lblUnitOfDistanceForEconomyCode, PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE));
			for (WebElement btn : _lblUnitOfDistanceForEconomyAirTravel) {
				resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(btn, PDTConstants.RADIOBTN,
						_lblUnitOfDistanceForEconomyAirTravel.get(_lblUnitOfDistanceForEconomyAirTravel.indexOf(btn))
										.getText().trim()));
			}
		} catch(Exception e) {
			Assert.fail("Failed to verify Economy fields for Visibility");
		}
		result = resultElementVisible.stream().allMatch(t -> t.equals(true)) ? true : false;
		printMessageForFieldVisibility(result, resultTableMap.get("Transportation_Type_Option"), benefitCategory, benefit);
		return result;
	}

	public boolean verifyEconomyClassFieldsForInvisibilty(Map<String, String> resultTableMap, String benefitCategory, String benefit) {
		boolean result = false;
		ArrayList<Boolean> resultElementInVisible = new ArrayList<Boolean>();
		try {
			CoreFunctions.hoverAndSingleClick(driver, _iconClearTransportationType, "Clear Transport Type Option");
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _txtBoxMinDistanceEconomy);
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_lblMinDistanceForEconomyTravel, PDTConstants.LABEL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL));
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_txtBoxMinDistanceEconomy, PDTConstants.TEXTBOX, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL));
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_lblUnitOfDistanceForEconomyCode, PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE));
			resultElementInVisible.add(CoreFunctions.verifyListElementNotPresentOnPage(_lblUnitOfDistanceForEconomyAirTravel, PDTConstants.RADIOBTN, PDTConstants.KM));
			resultElementInVisible.add(CoreFunctions.verifyListElementNotPresentOnPage(_lblUnitOfDistanceForEconomyAirTravel, PDTConstants.RADIOBTN, PDTConstants.MILES));		
		} catch(Exception e) {
			Assert.fail("Exception occured while trying to verify Economy Class fields for invisibilty after deselecting the Economy Class Airfare option from Transportation Type dropdown.");
		}
		result = resultElementInVisible.stream().allMatch(t -> t.equals(true)) ? true : false;		
		printMessageForFieldInVisibility(result, resultTableMap.get("Transportation_Type_Option"), benefitCategory, benefit);
		return result;
	}
	
	public boolean verifyBusinessClassForVisibilty(Map<String, String> resultTableMap, String benefitCategory, String benefit) {
		boolean result = false;
		ArrayList<Boolean> resultElementVisible = new ArrayList<Boolean>();
		List<String> businessAirFareUnit = new ArrayList<String>();
		List<String> expectedBusinessAirFareUnit = new ArrayList<String>();
		expectedBusinessAirFareUnit.add(PDTConstants.KM);
		expectedBusinessAirFareUnit.add(PDTConstants.MILES);
		expectedBusinessAirFareUnit.add(PDTConstants.HOURS);
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);
			CoreFunctions.selectItemInListByText(driver, _drpDownTransportationTypeOptions, resultTableMap.get("Transportation_Type_Option"),
					_lblTransportationType.getText(), PDTConstants.DROP_DOWN, true);
			CoreFunctions.clickElement(driver, _lblBusinessClassAirFareUnit);
			
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(
					_lblBusinessClassAirFareUnit, PDTConstants.LABEL, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_drpDownBusinessClassAirfareUnit,
							PDTConstants.DROP_DOWN, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));

			CoreFunctions.clickElement(driver, _drpDownBusinessClassAirfareUnit);
			businessAirFareUnit = CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsBusinessClassAirfareUnit);
			Log.info("business class air fare unit=="+businessAirFareUnit);
			Log.info("expected business class air fare unit=="+expectedBusinessAirFareUnit);
			if(expectedBusinessAirFareUnit.equals(businessAirFareUnit)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_BUSINESS_CLASS_DRP_OPTION, CoreConstants.PASS, businessAirFareUnit));
				resultElementVisible.add(true);
			} else {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BUSINESS_CLASS_DRP_OPTION, CoreConstants.FAIL, expectedBusinessAirFareUnit));
				resultElementVisible.add(false);
			}
			
			for (String option : businessAirFareUnit) {					
				CoreFunctions.clickElement(driver, _drpDownBusinessClassAirfareUnit);
				CoreFunctions.selectItemInListByText(driver, _drpDownOptionsBusinessClassAirfareUnit,
						option, _lblBusinessClassAirFareUnit.getText(), PDTConstants.DROP_DOWN, true);
				resultElementVisible.add(verifyKmMilesHoursForVisibility(option));
			}			
		}catch(Exception e) {
			Assert.fail("Exception occured while trying to verify Business Class Airfare Option for Transportation drop down.");
		}
		result = resultElementVisible.stream().allMatch(t -> t.equals(true)) ? true : false;		
		printMessageForFieldVisibility(result, resultTableMap.get("Transportation_Type_Option"), benefitCategory, benefit);
		return result;
	}
	
	public boolean verifyBusinessClassFieldsForInvisibilty(Map<String, String> resultTableMap, String benefitCategory, String benefit) {
		boolean result = false;
		ArrayList<Boolean> resultElementInVisible = new ArrayList<Boolean>();
		try {
			CoreFunctions.hoverAndSingleClick(driver, _iconClearTransportationType, "Clear Transport Type Option");
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _lblBusinessClassAirFareUnit);
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_lblBusinessClassAirFareUnit, PDTConstants.LABEL, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_drpDownBusinessClassAirfareUnit, PDTConstants.DROP_DOWN, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
		} catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occured while trying to verify Business Class fields for invisibilty after deselecting the Economy Class Airfare option from Transportation Type dropdown.");
		}
		result = resultElementInVisible.stream().allMatch(t -> t.equals(true)) ? true : false;		
		printMessageForFieldInVisibility(result, resultTableMap.get("Transportation_Type_Option"), benefitCategory, benefit);
		return result;
	}

	public boolean verifyKmMilesForVisibility() {
		ArrayList<Boolean> resultElementVisible = new ArrayList<Boolean>();
		try {
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_lblMinDistanceForBusinessAirTravel,
					PDTConstants.LABEL, _lblMinDistanceForBusinessAirTravel.getText()));
			
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(
			_txtBoxMinDistanceForBusinessAirTravel, PDTConstants.TEXTBOX, _lblMinDistanceForBusinessAirTravel.getText()));
		

		} catch(Exception e) {
			Assert.fail("Exception occured while trying to verify Min. Distance for Business Air Travel.");
		}
		return  resultElementVisible.stream().allMatch(t -> t.equals(true)) ? true : false;
	}
	
	public boolean verifyHoursForVisibility() {
		ArrayList<Boolean> resultElementVisible = new ArrayList<Boolean>();
		try {
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(
					_lblMinTimeForBusinessAirTravel, PDTConstants.LABEL, _lblMinTimeForBusinessAirTravel.getText()));
			
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(
					_txtBoxMinTimeForBusinessAirTravel, PDTConstants.TEXTBOX, _lblMinTimeForBusinessAirTravel.getText()));
	
		} catch(Exception e) {
			Assert.fail("Exception occured while trying to verify Hours for Business Air Travel.");
		}
		return  resultElementVisible.stream().allMatch(t -> t.equals(true)) ? true : false;
	}

	public boolean verifyKmMilesHoursForVisibility(String option) {
		boolean result = false;
		if (option.equalsIgnoreCase(PDTConstants.KM)
				|| option.equalsIgnoreCase(PDTConstants.MI) || option.equalsIgnoreCase(PDTConstants.MILES)) {
			result = verifyKmMilesForVisibility();
		} else if (option.equalsIgnoreCase(PDTConstants.HOURS)) {
			result = verifyHoursForVisibility();
			CoreFunctions.clickElement(driver, _lblMinTimeForBusinessAirTravel);
		} else {
			Assert.fail("Not a valid option for Business Air Travel");
		}
		return result;
	}
}
