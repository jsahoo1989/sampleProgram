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
import com.aires.testdatatypes.pdt.PDT_HomeLeaveBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

public class PDT_HomeLeavePage extends Base {
	public PDT_HomeLeavePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//label[text()='TRANSFER - Number of Trips']")
	private WebElement _lblTransferNumOfTrips;

	@FindBy(how = How.CSS, using = "input[formcontrolname='transferTrip']")
	private WebElement _txtBoxTransferNumOfTrips;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'ASSIGNMENT - Number of Trips')]")
	private WebElement _lblAssignmentNumOfTrips;

	@FindBy(how = How.CSS, using = "input[formcontrolname='assignmentTrip']")
	private WebElement _txtBoxAssignmentTrip;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'ASSIGNMENT - Frequency of Trips')]")
	private WebElement _lblFrequencyOfTrips;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignmentFreqOfTripCode']")
	private WebElement _drpDownFrequencyOfTrip;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignmentFreqOfTripCode'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownFrequencyOfTripOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignmentFreqOfTripCode'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownFrequencyOfTripOptionsSelected;

	@FindBy(how = How.CSS, using = "input[formcontrolname='assignmentFreqOfTripOther']")
	private WebElement _txtBoxFrequencyOfTripOther;

	@FindBy(how = How.XPATH, using = "//label[text()='Transportation Type']")
	private WebElement _lblTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportTypeList']")
	private WebElement _drpDownTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportTypeList'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportTypeList'] span.ng-value-label")
	private List<WebElement> _drpDownTransportationTypeMultiSelectOptions;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Min. Mileage for Economy Air Travel')]")
	private WebElement _lblMinMileageEconomyAir;

	@FindBy(how = How.CSS, using = "input[formcontrolname='economyMinMileage']")
	private WebElement _txtBoxMinMileageEconomy;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Min. Mileage for Business Air Travel')]")
	private WebElement _lblMinMileageBusiness;

	@FindBy(how = How.CSS, using = "input[formcontrolname='businessMinMileage']")
	private WebElement _txtBoxMinMileageBusiness;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Accompanying Family Members')]")
	private WebElement _lblAccompFamilyMember;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode']")
	private WebElement _drpDownAccompFamilyMember;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownAccompFamilyMemberOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownAccompFamilyMemberOptionSelected;

	@FindBy(how = How.CSS, using = "app-transporation label.form-check-label")
	private List<WebElement> _radioBtnHomeLeaveTransportation;

	@FindBy(how = How.CSS, using = "app-transporation input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHomeLeaveTransportReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-transporation textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHomeLeaveTransportComment;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Duration (Days)')]")
	private WebElement _lblDurationInDays;

	@FindBy(how = How.CSS, using = "app-lodging input[formcontrolname='numOfDays']")
	private WebElement _txtBoxDurationInDays;

	@FindBy(how = How.CSS, using = "app-lodging label.form-check-label")
	private List<WebElement> _radioBtnHomeLeaveLodging;

	@FindBy(how = How.CSS, using = "app-lodging input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHomeLeaveLodgingReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-lodging textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHomeLeaveLodgingComment;

	// Home Leave Meals
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Duration Number of Days for Meals')]")
	private WebElement _lblNumOfDaysForMeals;

	@FindBy(how = How.CSS, using = "app-meals input[formcontrolname='numOfDays']")
	private WebElement _txtBoxHomeNumOfDaysForMeals;

	@FindBy(how = How.XPATH, using = "//label[text()='Type']")
	private WebElement _lblType;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Max. Amount')]")
	private WebElement _lblMaxAmount;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode']")
	private WebElement _drpDownMaxAmtMeals;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode'] span.ng-option-label")
	private List<WebElement> _drpDownMaxAmtMealsOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode'] span.ng-value-label")
	private WebElement _drpDownMaxAmtMealsOptionsSelected;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Max Amount - Transferee')]")
	private WebElement _lblMaxAmtTransferee;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountEe']")
	private WebElement _txtBoxMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe']")
	private WebElement _drpDownTransfereeCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe'] span.ng-option-label")
	private List<WebElement> _drpDownTransfereeCurrencyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe'] span.ng-value-label")
	private WebElement _drpDownTransfereeCurrencyOptionSelected;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Max Amount - Other Adults')]")
	private WebElement _lblMaxAmtOtherAdults;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountAdult']")
	private WebElement _txtBoxMaxAmtAdult;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailAdultCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailAdult;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult']")
	private WebElement _drpDownAdultCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult'] span.ng-option-label")
	private List<WebElement> _drpDownAdultCurrencyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult'] span.ng-value-label")
	private WebElement _drpDownAdultCurrencyOptionSelected;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Max Amount - Children')]")
	private WebElement _lblMaxAmtChildren;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountChild']")
	private WebElement _txtBoxMaxAmtChild;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailChildCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailChild;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild']")
	private WebElement _drpDownCurrencyCodeChild;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyCodeChildOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild'] span.ng-value-label")
	private WebElement _drpDownCurrencyCodeChildOptionSelected;

	@FindBy(how = How.CSS, using = "app-meals label.form-check-label")
	private List<WebElement> _radioBtnHomeLeaveMeals;

	@FindBy(how = How.CSS, using = "app-meals input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHomeLeaveMealsReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-meals textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHomeLeaveMealsComment;

	PDT_HomeLeaveBenefit homeLeaveBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getHomeLeaveDataList("Home Leave");

	private String transportType, accompanyingFamilyMemeber, maxAmtHomeLeaveMeals, frequencyOfTrips;

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

	public void setMaxAmtHomeLeaveMeals(String maxAmt) {
		maxAmtHomeLeaveMeals = maxAmt;
	}

	public String getMaxAmtHomeLeaveMeals() {
		return maxAmtHomeLeaveMeals;
	}

	public void setFrequencyOfTrips(String freqTrips) {
		frequencyOfTrips = freqTrips;
	}

	public String getFrequencyOfTrips() {
		return frequencyOfTrips;
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
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL,
					_lblTransportationType.getText(), subBenefitFormName));
		}
	}

	public void verifyAndFillTransferNumberOfTrips(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		if (CoreFunctions.isElementExist(driver, _txtBoxTransferNumOfTrips, 1)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED, CoreConstants.PASS,
					_lblTransferNumOfTrips.getText(), subBenefitFormName));
			CoreFunctions.clearAndSetText(driver, _txtBoxTransferNumOfTrips, _lblTransferNumOfTrips.getText(),
					homeLeaveBenefitData.homeLeaveTransportation.transferNumberOfTrips);
		} else {
			Assert.fail(PDTConstants.TRANSFER_NUMTRIPS_NOT_DISPLAYED);
		}

	}

	public void verifyAndFillAssignmentNumberOfTrips(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		if (CoreFunctions.isElementExist(driver, _txtBoxAssignmentTrip, 1)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED, CoreConstants.PASS,
					_lblAssignmentNumOfTrips.getText(), subBenefitFormName));
			CoreFunctions.clearAndSetText(driver, _txtBoxAssignmentTrip, _lblAssignmentNumOfTrips.getText(),
					homeLeaveBenefitData.homeLeaveTransportation.assignmentNumberOfTrips);
		} else {
			Assert.fail(PDTConstants.ASSIGNMENT_NUMTRIPS_NOT_DISPLAYED);
		}
	}

	public void verifyAndSelectFrequencyOfTrips(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		if (CoreFunctions.isElementExist(driver, _drpDownFrequencyOfTrip, 1)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED, CoreConstants.PASS,
					_lblFrequencyOfTrips.getText(), subBenefitFormName));
			String randFrequencyOfTrips = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownFrequencyOfTrip, _drpDownFrequencyOfTripOptions,
					_drpDownFrequencyOfTripOptionsSelected, _lblFrequencyOfTrips.getText());
			setFrequencyOfTrips(randFrequencyOfTrips);
			verifyAndFillOtherFreq(addNewPolicyPage, subBenefitFormName, randFrequencyOfTrips);
		} else {
			Assert.fail(PDTConstants.ASSIGNMENT_FREQTRIPS_NOT_DISPLAYED);
		}
	}

	public void verifyAndFillOtherFreq(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String randFrequencyOfTrips) {
		try {
			if (_drpDownFrequencyOfTripOptionsSelected.getText().equalsIgnoreCase(PDTConstants.OTHER)
					&& CoreFunctions.isElementExist(driver, _txtBoxFrequencyOfTripOther, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED_FOR_DRPDOWN,
						CoreConstants.PASS, PDTConstants.OTHER, _lblFrequencyOfTrips.getText(), subBenefitFormName));
				CoreFunctions.clearAndSetText(driver, _txtBoxFrequencyOfTripOther, PDTConstants.OTHER,
						homeLeaveBenefitData.homeLeaveTransportation.frequencyTripOther);
			} else if (_drpDownFrequencyOfTripOptionsSelected.getText().equalsIgnoreCase(PDTConstants.OTHER)
					&& !CoreFunctions.isElementExist(driver, _txtBoxFrequencyOfTripOther, 1)) {
				Assert.fail(MessageFormat.format(PDTConstants.OTHER_TEXTBOX_NOT_DISPLAYED, CoreConstants.FAIL, PDTConstants.OTHER, _lblFrequencyOfTrips.getText(), subBenefitFormName));
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_VERIFY_OTHER_TEXT_BOX, CoreConstants.FAIL, PDTConstants.OTHER, _lblFrequencyOfTrips.getText(), subBenefitFormName));
		}
	}

	public void verifyAndFillNumberOfTripsBasedOnTracingSetValue(PDT_AddNewPolicyPage addNewPolicyPage,
			String subBenefitFormName, String tracingSetVal) {
		switch (tracingSetVal) {
		case PDTConstants.TRANSFER:
			verifyAndFillTransferNumberOfTrips(addNewPolicyPage, subBenefitFormName);
			break;
		case PDTConstants.ASSIGNMENT:
			verifyAndFillAssignmentNumberOfTrips(addNewPolicyPage, subBenefitFormName);
			verifyAndSelectFrequencyOfTrips(addNewPolicyPage, subBenefitFormName);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.INVALID_TRACINGSET, tracingSetVal));
		}
	}

	public void fillHomeLeaveTransportationForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String tracingSet) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblTransportationType,
					_lblTransportationType.getText());
			verifyAndFillNumberOfTripsBasedOnTracingSetValue(addNewPolicyPage, subBenefitFormName, tracingSet);
			selectRandomTransportTypeOption(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.clickElement(driver, _txtBoxMinMileageEconomy);
			CoreFunctions.clearAndSetText(driver, _txtBoxMinMileageEconomy, _lblMinMileageEconomyAir.getText(),
					homeLeaveBenefitData.homeLeaveTransportation.minMileageEconomyAir);
			CoreFunctions.clearAndSetText(driver, _txtBoxMinMileageBusiness, _lblMinMileageBusiness.getText(),
					homeLeaveBenefitData.homeLeaveTransportation.minMileageBusinessAir);
			String randAccompanyingFamilMember = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownAccompFamilyMember, _drpDownAccompFamilyMemberOptions,
					_drpDownAccompFamilyMemberOptionSelected, _lblAccompFamilyMember.getText());
			setAccompanyingFamilyMember(randAccompanyingFamilMember);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHomeLeaveTransportation);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHomeLeaveTransportation,
					homeLeaveBenefitData.homeLeaveTransportation.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHomeLeaveTransportation,
					homeLeaveBenefitData.homeLeaveTransportation.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					homeLeaveBenefitData.homeLeaveTransportation.reimbursedBy,
					_txtBoxHomeLeaveTransportReimbursedByOther,
					homeLeaveBenefitData.homeLeaveTransportation.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaHomeLeaveTransportComment, PDTConstants.COMMENT,
					homeLeaveBenefitData.homeLeaveTransportation.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	public void fillHomeLeaveLodgingForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxDurationInDays,
					_lblDurationInDays.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxDurationInDays, _lblDurationInDays.getText(),
					homeLeaveBenefitData.homeLeaveLodging.durationInDays);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHomeLeaveLodging);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHomeLeaveLodging,
					homeLeaveBenefitData.homeLeaveLodging.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHomeLeaveLodging,
					homeLeaveBenefitData.homeLeaveLodging.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					homeLeaveBenefitData.homeLeaveLodging.reimbursedBy, _txtBoxHomeLeaveLodgingReimbursedByOther,
					homeLeaveBenefitData.homeLeaveLodging.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaHomeLeaveLodgingComment, PDTConstants.COMMENT,
					homeLeaveBenefitData.homeLeaveLodging.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	public void checkIfFlatAmtIsSelected(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (_drpDownMaxAmtMealsOptionsSelected.getText().equalsIgnoreCase(PDTConstants.FLAT_AMT)) {
				verifyAndFillTransfereeMealInfo(addNewPolicyPage, subBenefitFormName);
				verifyAndFillAdultMealInfo(addNewPolicyPage, subBenefitFormName);
				verifyAndFillChildMealInfo(addNewPolicyPage, subBenefitFormName);
			}
		} catch (Exception e) {
			Assert.fail(PDTConstants.FAILED_TO_VERIFY_FLAT_AMT);
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
						homeLeaveBenefitData.homeLeaveMeals.maxAmtTransferee);
				CoreFunctions.selectItemInListByText(driver, _radioDetailTransfereeCode,
						homeLeaveBenefitData.homeLeaveMeals.maxAmtTransfereeDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownTransfereeCurrency);
				CoreFunctions.selectItemInListByText(driver, _drpDownTransfereeCurrencyOptions,
						homeLeaveBenefitData.homeLeaveMeals.maxAmtTransfereeCurrency, PDTConstants.CURRENCY,
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
						homeLeaveBenefitData.homeLeaveMeals.maxAmtAdult);
				CoreFunctions.selectItemInListByText(driver, _radioDetailAdult,
						homeLeaveBenefitData.homeLeaveMeals.maxAmtAdultDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownAdultCurrency);
				CoreFunctions.selectItemInListByText(driver, _drpDownAdultCurrencyOptions,
						homeLeaveBenefitData.homeLeaveMeals.maxAmtAdultCurrency, PDTConstants.CURRENCY,
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
						homeLeaveBenefitData.homeLeaveMeals.maxAmtChild);
				CoreFunctions.selectItemInListByText(driver, _radioDetailChild,
						homeLeaveBenefitData.homeLeaveMeals.maxAmtChildDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownCurrencyCodeChild);
				CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyCodeChildOptions,
						homeLeaveBenefitData.homeLeaveMeals.maxAmtChildCurrency, PDTConstants.CURRENCY,
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL,
					PDTConstants.CHILDREN_INFO, subBenefitFormName));
		}
	}

	public void fillHomeLeaveMealForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxHomeNumOfDaysForMeals,
					_lblNumOfDaysForMeals.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxHomeNumOfDaysForMeals, _lblNumOfDaysForMeals.getText(),
					homeLeaveBenefitData.homeLeaveMeals.numberOfDaysPerMeal);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHomeLeaveMeals);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHomeLeaveMeals,
					homeLeaveBenefitData.homeLeaveMeals.type, _lblType.getText(), PDTConstants.RADIO_BUTTON_LIST, true);

			String maxAmt = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownMaxAmtMeals, _drpDownMaxAmtMealsOptions,
					_drpDownMaxAmtMealsOptionsSelected, _lblMaxAmount.getText());
			setMaxAmtHomeLeaveMeals(maxAmt);
			checkIfFlatAmtIsSelected(addNewPolicyPage, subBenefitFormName);

			CoreFunctions.selectItemInListByText(driver, _radioBtnHomeLeaveMeals,
					homeLeaveBenefitData.homeLeaveMeals.grossUp, PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST,
					true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHomeLeaveMeals,
					homeLeaveBenefitData.homeLeaveMeals.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					homeLeaveBenefitData.homeLeaveMeals.reimbursedBy, _txtBoxHomeLeaveMealsReimbursedByOther,
					homeLeaveBenefitData.homeLeaveMeals.reimbursedByOther, subBenefitFormName);

			CoreFunctions.clearAndSetText(driver, _txtAreaHomeLeaveMealsComment, PDTConstants.COMMENT,
					homeLeaveBenefitData.homeLeaveMeals.comment);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

}
