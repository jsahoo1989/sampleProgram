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
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_FinalMoveBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

public class PDT_FinalMovePage extends Base {
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

	@FindBy(how = How.XPATH, using = "//label[text()='Min. Mileage for Economy Air Travel (if applicable)']")
	private WebElement _lblMinMileageForEconomyAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minMileageEconomy']")
	private WebElement _txtBoxMinMileageEconomy;

	@FindBy(how = How.XPATH, using = "//label[text()='Min. Mileage for Business Air Travel (if applicable)']")
	private WebElement _lblMinMileageForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minMileageBusiness']")
	private WebElement _txtBoxMinMileageBusiness;

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

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='finalMoveDurationCode'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownDurationOptionsSelected;

	@FindBy(how = How.XPATH, using = "//label[text()='Number of Nights']")
	private WebElement _lblNumberOfNights;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfNight']")
	private WebElement _txtBoxNumberOfNights;

	@FindBy(how = How.XPATH, using = "//label[text()='Max. Amount (if applicable)']")
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
	
	//Final Move Meals	
	@FindBy(how = How.XPATH, using = "//label[text()='Number of Days for Meals']")
	private WebElement _lblNumOfDaysForMeals;
	
	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='finalMoveDurationCode']")
	private WebElement _drpDownNumOfDaysForMeals;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='finalMoveDurationCode'] span.ng-option-label")
	private List<WebElement> _drpDownNumOfDaysForMealsOptions;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='finalMoveDurationCode'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownNumOfDaysForMealsSelected;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Number of Days']")
	private WebElement _lblNumOfDays;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfDay']")
	private WebElement _txtBoxNumOfDays;

	@FindBy(how = How.XPATH, using = "//label[text()='Type']")
	private WebElement _lblType;
	
	@FindBy(how = How.CSS, using = "#collapseThree label.form-check-label")
	private List<WebElement> _radioBtnHouseHuntingTripMeals;
	
	@FindBy(how = How.XPATH, using = "//*[@id='collapseThree']//label[text()='Max. Amount (if applicable)']")
	private WebElement _lblMaxAmtFinalMoveMeals;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='maxAmountCode']")
	private WebElement _drpDownMaxAmountMeals;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='maxAmountCode'] span.ng-option-label")
	private List<WebElement> _drpDownMaxAmountMealsOptions;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='maxAmountCode'] span.ng-value-label.ng-star-inserted")
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
	
	@FindBy(how = How.XPATH, using = "//label[text()='Max Amount Transferee (if applicable)']")
	private WebElement _lblMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//label[text()='Max Amount Other Adults (if applicable)']")
	private WebElement _lblMaxAmtOtherAdults;

	@FindBy(how = How.XPATH, using = "//label[text()='Max Amount Children (if applicable)']")
	private WebElement _lblMaxAmtChildren;

	PDT_FinalMoveBenefit finalMoveBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getFinalMoveDataList("Final Move");

	private String transportType, accompanyingFamilyMemeber, duration, maxAmtFinalMoveLodging,
			maxAmtFinalMoveMeals, numOfDaysForMeals;

	public void setTransportType(String transType) {
		transportType = transType;
	}

	public String getTransportType() {
		return transportType;
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
			setTransportType(randTransportTypeOption);
		} catch (Exception e) {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL, _lblTransportationType.getText(), subBenefitFormName));
		}
	}

	public void fillFinalMoveTransportationForm(PDT_AddNewPolicyPage addNewPolicyPage,
			String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblTransportationType,
					_lblTransportationType.getText());
			selectRandomTransportTypeOption(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.clickElement(driver, _txtBoxMinMileageEconomy);
			CoreFunctions.clearAndSetText(driver, _txtBoxMinMileageEconomy, _lblMinMileageForEconomyAirTravel.getText(),
					finalMoveBenefitData.finalMoveTransportation.minMileageEconomyAir);
			CoreFunctions.clearAndSetText(driver, _txtBoxMinMileageBusiness,
					_lblMinMileageForBusinessAirTravel.getText(),
					finalMoveBenefitData.finalMoveTransportation.minMileageBusinessAir);
			String randAccompanyingFamilMember = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownAccompanyingFamilyMemberCode, _drpDownAccompanyingFamilyMemberCodeOptions,
					_drpDownAccompanyingFamilyMemberCodeOptionsSelected, _lblAccompanyingFamilyMember);
			setAccompanyingFamilyMember(randAccompanyingFamilMember);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnFinalMoveTransport);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinalMoveTransport,
					finalMoveBenefitData.finalMoveTransportation.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinalMoveTransport,
					finalMoveBenefitData.finalMoveTransportation.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					finalMoveBenefitData.finalMoveTransportation.reimbursedBy,
					_txtBoxFinalMoveTransportReimbursedByOther,
					finalMoveBenefitData.finalMoveTransportation.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaFinalMoveTransportComment, PDTConstants.COMMENT,
					finalMoveBenefitData.finalMoveTransportation.comment);
		} catch (Exception e) {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_SUB_BENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	public void verifyAndFillFlatAmtPerNightTextBoxAndCurrencyDrpDown(PDT_AddNewPolicyPage addNewPolicyPage,
			String subBenefitFormName) {
		try {
			if (_drpDownMaxAmtSelectedOption.getText().equalsIgnoreCase(PDTConstants.FLAT_AMT_PER_NIGHT)
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
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail(PDTConstants.FAILED_TO_FILL_FIELD_VALUES);
		}
	}

	public void verifyAndFillNumberOfNights(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (_drpDownDurationOptionsSelected.getText().equalsIgnoreCase(PDTConstants.SET_OF_NIGHTS)
					&& CoreFunctions.isElementExist(driver, _txtBoxNumberOfNights, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblNumberOfNights.getText(), subBenefitFormName));
				CoreFunctions.clickElement(driver, _txtBoxNumberOfNights);
				CoreFunctions.clearAndSetText(driver, _txtBoxNumberOfNights, _lblNumberOfNights.getText(),
						finalMoveBenefitData.finalMoveLodging.numberOfNights);
			}
		} catch (Exception e) {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_VALUE_IN_TEXTBOX, CoreConstants.FAIL, _lblNumberOfNights.getText(), subBenefitFormName));
		}
	}
	
	public void verifyAndFillNumberOfDays(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (_drpDownNumOfDaysForMealsSelected.getText().equalsIgnoreCase(PDTConstants.SET_OF_NIGHTS)
					&& CoreFunctions.isElementExist(driver, _txtBoxNumOfDays, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblNumOfDays.getText(), subBenefitFormName));
				CoreFunctions.clickElement(driver, _txtBoxNumOfDays);
				CoreFunctions.clearAndSetText(driver, _txtBoxNumOfDays, _lblNumOfDays.getText(),
						finalMoveBenefitData.finalMoveMeals.numberOfDays);
			}
		} catch (Exception e) {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_VALUE_IN_TEXTBOX, CoreConstants.FAIL, _lblNumOfDays.getText(), subBenefitFormName));
		}
	}

	public void fillFinalMoveLodgingForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _drpDownDuration, _lblDuration.getText());
			String randDuration = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownDuration, _drpDownDurationOptions,
					_drpDownDurationOptionsSelected, _lblDuration);
			setDuration(randDuration);			
			verifyAndFillNumberOfNights(addNewPolicyPage, subBenefitFormName);
			String maxAmt = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownMaxAmt, _drpDownMaxAmtOptions,
					_drpDownMaxAmtSelectedOption, _lblMaxAmt);
			setMaxAmtFinalMoveLodging(maxAmt);
			verifyAndFillFlatAmtPerNightTextBoxAndCurrencyDrpDown(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnFinalMoveLodging);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinalMoveLodging,
					finalMoveBenefitData.finalMoveLodging.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFinalMoveLodging,
					finalMoveBenefitData.finalMoveLodging.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					finalMoveBenefitData.finalMoveLodging.reimbursedBy,
					_txtBoxFinalMoveLodgingReimbursedByOther,
					finalMoveBenefitData.finalMoveLodging.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaFinalMoveLodgingComment, PDTConstants.COMMENT,
					finalMoveBenefitData.finalMoveLodging.comment);
		} catch (Exception e) {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_SUB_BENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
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
						finalMoveBenefitData.finalMoveMeals.maxAmtTransfereeCurrency,
						PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());			
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL, PDTConstants.TRANSFEREE_INFO, subBenefitFormName));
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
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL, PDTConstants.ADULT_INFO, subBenefitFormName));
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
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL, PDTConstants.CHILDREN_INFO, subBenefitFormName));
		}
	}

	public void fillFinalMoveMealForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _drpDownNumOfDaysForMeals,  _lblNumOfDaysForMeals.getText());
			String randNumDays = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownNumOfDaysForMeals, _drpDownNumOfDaysForMealsOptions,
					_drpDownNumOfDaysForMealsSelected, _lblNumOfDaysForMeals);
			setNumberOfDaysForMeals(randNumDays);			
			verifyAndFillNumberOfDays(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripMeals,
					finalMoveBenefitData.finalMoveMeals.type, _lblType.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);
			
			String maxAmt = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownMaxAmountMeals, _drpDownMaxAmountMealsOptions,
					_drpDownMaxAmountMealsSelectedVal, _lblMaxAmtFinalMoveMeals);
			setMaxAmtFinalMoveMeals(maxAmt);
			checkIfFlatAmtIsSelected(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHouseHuntingTripMeals);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripMeals,
					finalMoveBenefitData.finalMoveMeals.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripMeals,
					finalMoveBenefitData.finalMoveMeals.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					finalMoveBenefitData.finalMoveMeals.reimbursedBy,
					_txtBoxFinalMoveMealReimbursedByOther,
					finalMoveBenefitData.finalMoveMeals.reimbursedByOther, subBenefitFormName);

			CoreFunctions.clearAndSetText(driver, _txtAreaFinalMoveMealComment, PDTConstants.COMMENT,
					finalMoveBenefitData.finalMoveMeals.comment);

		} catch (Exception e) {			
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_SUB_BENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
}
