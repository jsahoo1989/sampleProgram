package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
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
import com.aires.testdatatypes.pdt.PDT_HomeLeaveBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_HomeLeavePage extends PDT_SharedSubBenefitPage {
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
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignmentFreqOfTripCode'] span.ng-option-label")
	private List<WebElement> _drpDownFrequencyOfTripOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignmentFreqOfTripCode'] span.ng-value-label")
	private WebElement _drpDownFrequencyOfTripOptionsSelected;


	@FindBy(how = How.CSS, using = "input[formcontrolname='assignmentFreqOfTripOther']")
	private WebElement _txtBoxFrequencyOfTripOther;

	@FindBy(how = How.XPATH, using = "//label[text()='Transportation Type']")
	private WebElement _lblTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportTypeList']")
	private WebElement _drpDownTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportTypeList'] span.ng-option-label")
	private List<WebElement> _drpDownTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportTypeList'] span.ng-value-label")
	private List<WebElement> _drpDownTransportationTypeMultiSelectOptions;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Accompanying Family Members')]")
	private WebElement _lblAccompFamilyMember;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode']")
	private WebElement _drpDownAccompFamilyMember;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-option-label")
	private List<WebElement> _drpDownAccompFamilyMemberOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-value-label")
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

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Max. Amount - Transferee')]")
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

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Max. Amount - Other Adults')]")
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

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Max. Amount - Children')]")
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
	
	@FindBy(how = How.CSS, using = "a[href='#collapseOne1']")
	private WebElement _formHeaderHomeLeaveTransportation;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formHeaderHomeLeaveLodging;

	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _formHeaderHomeLeaveMeals;
	
	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;
	
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='distanceHl']/preceding-sibling::label")
	private WebElement _lblDistance;

	@FindBy(how = How.CSS, using = "input[formcontrolname='distanceHl']")
	private WebElement _txtBoxDistance;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfDistanceCodeHl']/ancestor::div/preceding-sibling::label")
	private WebElement _lblUnitOfDistance;

	@FindBy(how = How.CSS, using = "input[formcontrolname='unitOfDistanceCodeHl']")
	private List<WebElement> _radioBtnUnitOfDistance;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfDistanceCodeHl']/parent::label")
	private List<WebElement> _radioBtnUnitOfDistanceLabel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minDistanceEconomyHl']/preceding-sibling::label")
	private WebElement _lblMinDistanceForEconomyTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceEconomyHl']")
	private WebElement _txtBoxMinDistanceEconomy;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfEconomyCodeHl']/ancestor::div/preceding-sibling::label")
	private WebElement _lblUnitOfDistanceForEconomyCode;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfEconomyCodeHl']/parent::label")
	private List<WebElement> _lblUnitOfDistanceForEconomyAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='unitOfEconomyCodeHl']")
	private List<WebElement> _radioBtnUnitOfDistanceForEconomyCode;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='unitOfBusinessCodeHl']/preceding-sibling::label")
	private WebElement _lblBusinessClassAirFareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfBusinessCodeHl']")
	private WebElement _drpDownBusinessClassAirfareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfBusinessCodeHl'] span.ng-value-label")
	private WebElement _drpDownOptionSelectedBusinessClassAirfareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfBusinessCodeHl'] span.ng-option-label")
	private List<WebElement> _drpDownOptionsBusinessClassAirfareUnit;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minDistanceBusinessHl']/preceding-sibling::label")
	private WebElement _lblMinDistanceForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceBusinessHl']")
	private WebElement _txtBoxMinDistanceForBusinessAirTravel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minTimeBusinessHl']/preceding-sibling::label")
	private WebElement _lblMinTimeForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minTimeBusinessHl']")
	private WebElement _txtBoxMinTimeForBusinessAirTravel;

	PDT_HomeLeaveBenefit homeLeaveBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getHomeLeaveDataList("Home Leave");

	private String accompanyingFamilyMemeber, maxAmtHomeLeaveMeals, frequencyOfTrips;
	private ArrayList<String> _transportType = null;

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

	/**
	 * Add the Form Header of Home Leave Transportation, Home Leave Lodging & Home Leave Meals in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.HOME_LEAVE_TRANSPORTATION, _formHeaderHomeLeaveTransportation);
		subBenefitHeaderMap.put(PDTConstants.HOME_LEAVE_LODGING, _formHeaderHomeLeaveLodging);
		subBenefitHeaderMap.put(PDTConstants.HOME_LEAVE_MEALS, _formHeaderHomeLeaveMeals);
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
		try {
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
		} catch(Exception e) {
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

	/**
	 * Fill Home Leave Transportation Form.
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param tracingSet
	 * @param pageName
	 */
	public void fillHomeLeaveTransportationForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String tracingSet, String pageName, PDT_SharedSubBenefit_Steps objStep) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblTransportationType,
					_lblTransportationType.getText());
			verifyAndFillNumberOfTripsBasedOnTracingSetValue(addNewPolicyPage, subBenefitFormName, tracingSet);
			selectAllTransportTypeOptions(addNewPolicyPage, subBenefitFormName, objStep);
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
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					homeLeaveBenefitData.homeLeaveTransportation.reimbursedBy,
					_txtBoxHomeLeaveTransportReimbursedByOther,
					homeLeaveBenefitData.homeLeaveTransportation.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaHomeLeaveTransportComment, PDTConstants.COMMENT,
					homeLeaveBenefitData.homeLeaveTransportation.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	/**
	 * Fill Home Leave Lodging Form.
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillHomeLeaveLodgingForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
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
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					homeLeaveBenefitData.homeLeaveLodging.reimbursedBy, _txtBoxHomeLeaveLodgingReimbursedByOther,
					homeLeaveBenefitData.homeLeaveLodging.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
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

	/**
	 * Fill Home Leave Meal Form.
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillHomeLeaveMealForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
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

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					homeLeaveBenefitData.homeLeaveMeals.reimbursedBy, _txtBoxHomeLeaveMealsReimbursedByOther,
					homeLeaveBenefitData.homeLeaveMeals.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaHomeLeaveMealsComment, PDTConstants.COMMENT,
					homeLeaveBenefitData.homeLeaveMeals.comment);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	/**
	 * Fill Home Leave sub-benefit based on sub-benefit name
	 * @param subBenefit
	 * @param pageName
	 * @param addNewPolicyPage
	 * @param tracingSet
	 */
	public void fillHomeLeaveSubBenefit(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage, String tracingSet, PDT_SharedSubBenefitPage subBenefitPage, PDT_SharedSubBenefit_Steps objStep) {		
		switch (subBenefit) {
		case PDTConstants.HOME_LEAVE_TRANSPORTATION:
			fillHomeLeaveTransportationForm(addNewPolicyPage, subBenefit, tracingSet, pageName, objStep);
			break;
		case PDTConstants.HOME_LEAVE_LODGING:
			fillHomeLeaveLodgingForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.HOME_LEAVE_MEALS:
			fillHomeLeaveMealForm(addNewPolicyPage, subBenefit, pageName);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}		
	}
	
	/**
	 * Iterate Home Leave sub-benefits and fill their corresponding form.
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage 
	 */
	public void iterateAndFillHomeLeaveSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep, String btnName, PDT_SharedSubBenefitPage subBenefitPage, String tracingSet) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);			
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		WebElement btnToClick = (btnName != null) ?  buttonMap.get(btnName) : buttonMap.get(PDTConstants.SAVE);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			fillHomeLeaveSubBenefit(subBenefit, pageName, addNewPolicyPage, tracingSet, subBenefitPage, objStep);
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
	
	public void verifyAndFillDistanceOptionsField(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
					.contains(PDTConstants.DISTANCE)) {

				CoreFunctions.clickElement(driver, _lblTransportationType);
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
						.verifyElementPresentOnPage(_lblDistance, PDTConstants.LABEL, PDTConstants.DISTANCE), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.DISTANCE));
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
						.verifyElementPresentOnPage(_txtBoxDistance, PDTConstants.TEXTBOX, PDTConstants.DISTANCE), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, PDTConstants.DISTANCE));
				// Boundary check for distance textbox				
				String random9DigitStr=CoreFunctions.generateRandomNumberAsGivenLength(9);
				String random10DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(10);
								
				CoreFunctions.clickElement(driver, _txtBoxDistance);
				CoreFunctions.clearAndSetText(driver, _txtBoxDistance, _lblDistance.getText(), random9DigitStr);
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxDistance, "value"), random9DigitStr, PDTConstants.DISTANCE, random9DigitStr.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.DISTANCE, random9DigitStr.length(), CoreFunctions.getAttributeText(_txtBoxDistance, "value"),random9DigitStr));
						
				CoreFunctions.clearAndSetText(driver, _txtBoxDistance, _lblDistance.getText(), PDTConstants.ELEVEN_DIGIT_STRING);
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxDistance, "value"), PDTConstants.ELEVEN_DIGIT_STRING, PDTConstants.DISTANCE, PDTConstants.ELEVEN_DIGIT_STRING.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.DISTANCE, PDTConstants.ELEVEN_DIGIT_STRING.length(), CoreFunctions.getAttributeText(_txtBoxDistance, "value"),PDTConstants.ELEVEN_DIGIT_STRING));
				
				CoreFunctions.clearAndSetText(driver, _txtBoxDistance, _lblDistance.getText(), random10DigitStr);
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxDistance, "value"), random10DigitStr, PDTConstants.DISTANCE, random10DigitStr.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.DISTANCE, random10DigitStr.length(), CoreFunctions.getAttributeText(_txtBoxDistance, "value"),random10DigitStr));

				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
						_lblUnitOfDistance, PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE));
				for (WebElement btn : _radioBtnUnitOfDistanceLabel) {
					sharedSubBenefitStep.getCustomSoftAssertObj()
							.assertTrue(CoreFunctions.verifyElementPresentOnPage(btn, PDTConstants.RADIOBTN,
									_radioBtnUnitOfDistanceLabel.get(_radioBtnUnitOfDistanceLabel.indexOf(btn))
											.getText().trim()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.RADIOBTN,
													_radioBtnUnitOfDistanceLabel.get(_radioBtnUnitOfDistanceLabel.indexOf(btn))
													.getText().trim()));
				}
				CoreFunctions.selectItemInListByText(driver, _radioBtnUnitOfDistanceLabel, PDTConstants.KM);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to verify Distance options field");
		}
	}

	public void verifyAndFillEconomyAirTravelField(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
					.contains(PDTConstants.ECONOMY_CLASS_AIRFARE)) {
				sharedSubBenefitStep.getCustomSoftAssertObj()
				.assertTrue(CoreFunctions.verifyElementPresentOnPage(_lblMinDistanceForEconomyTravel,
						PDTConstants.LABEL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL));
		sharedSubBenefitStep.getCustomSoftAssertObj()
				.assertTrue(CoreFunctions.verifyElementPresentOnPage(_txtBoxMinDistanceEconomy,
						PDTConstants.TEXTBOX, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL));
		// Boundary check for Min Distance Economy textbox
		String random9DigitStr=CoreFunctions.generateRandomNumberAsGivenLength(9);
		String random10DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(10);
		
		CoreFunctions.clickElement(driver, _txtBoxMinDistanceEconomy);
		CoreFunctions.clearAndSetText(driver, _txtBoxMinDistanceEconomy, _lblMinDistanceForEconomyTravel.getText(), random9DigitStr);
		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxMinDistanceEconomy, "value"), random9DigitStr, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL, random9DigitStr.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_ECO_AIR_TRAVEL)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL, random9DigitStr.length(), CoreFunctions.getAttributeText(_txtBoxMinDistanceEconomy, "value"), random9DigitStr));
		
		CoreFunctions.clearAndSetText(driver, _txtBoxMinDistanceEconomy, _lblMinDistanceForEconomyTravel.getText(), PDTConstants.ELEVEN_DIGIT_STRING);
		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxMinDistanceEconomy, "value"), PDTConstants.ELEVEN_DIGIT_STRING, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL, PDTConstants.ELEVEN_DIGIT_STRING.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_ECO_AIR_TRAVEL)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL, PDTConstants.ELEVEN_DIGIT_STRING.length(), CoreFunctions.getAttributeText(_txtBoxMinDistanceEconomy, "value"),PDTConstants.ELEVEN_DIGIT_STRING));
		
		CoreFunctions.clearAndSetText(driver, _txtBoxMinDistanceEconomy, _lblMinDistanceForEconomyTravel.getText(), random10DigitStr);
		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxMinDistanceEconomy, "value"), random10DigitStr, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL, random10DigitStr.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_ECO_AIR_TRAVEL)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL, random10DigitStr.length(), CoreFunctions.getAttributeText(_txtBoxMinDistanceEconomy, "value"), random10DigitStr));

		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
				_lblUnitOfDistanceForEconomyCode, PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE));
		for (WebElement btn : _lblUnitOfDistanceForEconomyAirTravel) {
			sharedSubBenefitStep.getCustomSoftAssertObj()
					.assertTrue(CoreFunctions.verifyElementPresentOnPage(btn, PDTConstants.RADIOBTN,
							_lblUnitOfDistanceForEconomyAirTravel
									.get(_lblUnitOfDistanceForEconomyAirTravel.indexOf(btn)).getText().trim()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.RADIOBTN,
											_lblUnitOfDistanceForEconomyAirTravel.get(_lblUnitOfDistanceForEconomyAirTravel.indexOf(btn))
											.getText().trim()));
		}
		CoreFunctions.selectItemInListByText(driver, _lblUnitOfDistanceForEconomyAirTravel, PDTConstants.MI);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to verify Economy Class AirFare options field");
		}
	}

	public void verifyKmMiles(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			sharedSubBenefitStep.getCustomSoftAssertObj()
			.assertTrue(CoreFunctions.verifyElementPresentOnPage(_lblMinDistanceForBusinessAirTravel,
					PDTConstants.LABEL, _lblMinDistanceForBusinessAirTravel.getText()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, _lblMinDistanceForBusinessAirTravel.getText()));
			
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
			_txtBoxMinDistanceForBusinessAirTravel, PDTConstants.TEXTBOX, _lblMinDistanceForBusinessAirTravel.getText()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, _lblMinDistanceForBusinessAirTravel.getText()));
		
			// Boundary check for Min Distance Business textbox
			String random9DigitStr=CoreFunctions.generateRandomNumberAsGivenLength(9);
			String random10DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(10);
			
			CoreFunctions.clickElement(driver, _txtBoxMinDistanceForBusinessAirTravel);
			CoreFunctions.clearAndSetText(driver, _txtBoxMinDistanceForBusinessAirTravel, _lblMinDistanceForBusinessAirTravel.getText(), random9DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxMinDistanceForBusinessAirTravel, "value"), random9DigitStr, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, random9DigitStr.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE_BUS_AIR_TRAVEL)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, random9DigitStr.length(), CoreFunctions.getAttributeText(_txtBoxMinDistanceForBusinessAirTravel, "value"), random9DigitStr));
			
			CoreFunctions.clearAndSetText(driver, _txtBoxMinDistanceForBusinessAirTravel, _lblMinDistanceForBusinessAirTravel.getText(), PDTConstants.ELEVEN_DIGIT_STRING);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxMinDistanceForBusinessAirTravel, "value"), PDTConstants.ELEVEN_DIGIT_STRING, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, PDTConstants.ELEVEN_DIGIT_STRING.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE_BUS_AIR_TRAVEL)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, PDTConstants.ELEVEN_DIGIT_STRING.length(), CoreFunctions.getAttributeText(_txtBoxMinDistanceForBusinessAirTravel, "value"),PDTConstants.ELEVEN_DIGIT_STRING));
			
			CoreFunctions.clearAndSetText(driver, _txtBoxMinDistanceForBusinessAirTravel, _lblMinDistanceForBusinessAirTravel.getText(), random10DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxMinDistanceForBusinessAirTravel, "value"), random10DigitStr, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, random10DigitStr.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE_BUS_AIR_TRAVEL)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, random10DigitStr.length(), CoreFunctions.getAttributeText(_txtBoxMinDistanceForBusinessAirTravel, "value"), random10DigitStr));
		} catch(Exception e) {
			Assert.fail("Failed to verify Min. Distance for Business Air Travel.");
		}
	}
	
	public void verifyHours(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
					_lblMinTimeForBusinessAirTravel, PDTConstants.LABEL, _lblMinTimeForBusinessAirTravel.getText()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, _lblMinTimeForBusinessAirTravel.getText()));
			
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
					_txtBoxMinTimeForBusinessAirTravel, PDTConstants.TEXTBOX, _lblMinTimeForBusinessAirTravel.getText()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, _lblMinTimeForBusinessAirTravel.getText()));
			
			// Boundary check for Min Distance Business textbox
			String random2DigitStr=CoreFunctions.generateRandomNumberAsGivenLength(2);
			String random3DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(3);
			
			CoreFunctions.clickElement(driver, _txtBoxMinTimeForBusinessAirTravel);
			CoreFunctions.clearAndSetText(driver, _txtBoxMinTimeForBusinessAirTravel, _lblMinTimeForBusinessAirTravel.getText(), random2DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxMinTimeForBusinessAirTravel, "value"), random2DigitStr, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, random2DigitStr.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_BUS_AIR_TRAVEL_INHRS)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, random2DigitStr.length(), CoreFunctions.getAttributeText(_txtBoxMinTimeForBusinessAirTravel, "value"), random2DigitStr));
			
			CoreFunctions.clearAndSetText(driver, _txtBoxMinTimeForBusinessAirTravel, _lblMinTimeForBusinessAirTravel.getText(), PDTConstants.FOUR_DIGIT_STRING);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxMinTimeForBusinessAirTravel, "value"), PDTConstants.FOUR_DIGIT_STRING, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, PDTConstants.FOUR_DIGIT_STRING.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_BUS_AIR_TRAVEL_INHRS)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHAR, CoreConstants.FAIL, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, PDTConstants.FOUR_DIGIT_STRING.length(), CoreFunctions.getAttributeText(_txtBoxMinTimeForBusinessAirTravel, "value"),PDTConstants.FOUR_DIGIT_STRING));
			
			CoreFunctions.clearAndSetText(driver, _txtBoxMinTimeForBusinessAirTravel, _lblMinTimeForBusinessAirTravel.getText(), random3DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(_txtBoxMinTimeForBusinessAirTravel, "value"), random3DigitStr, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, random3DigitStr.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_BUS_AIR_TRAVEL_INHRS)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, random3DigitStr.length(), CoreFunctions.getAttributeText(_txtBoxMinTimeForBusinessAirTravel, "value"), random3DigitStr));
			
			
		} catch(Exception e) {
			Assert.fail("Failed to verify Hours for Business Air Travel.");
		}	
	}

	public void verifyKmMilesHours(PDT_SharedSubBenefit_Steps sharedSubBenefitStep, String option) {
		if (option.equalsIgnoreCase(PDTConstants.KM)
				|| option.equalsIgnoreCase(PDTConstants.MI)) {
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
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
						_lblBusinessClassAirFareUnit, PDTConstants.LABEL, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
				sharedSubBenefitStep.getCustomSoftAssertObj()
						.assertTrue(CoreFunctions.verifyElementPresentOnPage(_drpDownBusinessClassAirfareUnit,
								PDTConstants.DROP_DOWN, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.DROP_DOWN, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));

				CoreFunctions.clickElement(driver, _drpDownBusinessClassAirfareUnit);
				businessAirFareUnit = CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsBusinessClassAirfareUnit);
				
				for (String option : businessAirFareUnit) {					
					CoreFunctions.clickElement(driver, _drpDownBusinessClassAirfareUnit);
					CoreFunctions.selectItemInListByText(driver, _drpDownOptionsBusinessClassAirfareUnit,
							option, _lblBusinessClassAirFareUnit.getText(), PDTConstants.DROP_DOWN, true);
					verifyKmMilesHours(sharedSubBenefitStep, option);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to verify Economy Class AirFare options field");
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
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL,
					_lblTransportationType.getText(), subBenefitFormName));
		}
	}
}
