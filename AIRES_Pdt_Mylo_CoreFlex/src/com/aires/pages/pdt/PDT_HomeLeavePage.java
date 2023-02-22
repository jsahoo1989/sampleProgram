package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_HomeLeaveBenefit;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
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

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownFrequencyOfTripOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignmentFreqOfTripCode'] span.ng-value-label")
	private WebElement _drpDownFrequencyOfTripOptionsSelected;

	@FindBy(how = How.CSS, using = "input[formcontrolname='assignmentFreqOfTripOther']")
	private WebElement _txtBoxFrequencyOfTripOther;

	@FindBy(how = How.XPATH, using = "//label[text()='Transportation Type']")
	private WebElement _lblTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportTypeList']")
	private WebElement _drpDownTransportationType;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportTypeList'] span.ng-value-label")
	private List<WebElement> _drpDownTransportationTypeMultiSelectOptions;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Accompanying Family Members')]")
	private WebElement _lblAccompFamilyMember;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode']")
	private WebElement _drpDownAccompFamilyMember;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
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

	@FindBy(how = How.CSS, using = "span.ng-option-label")
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

	@FindBy(how = How.CSS, using = "span.ng-option-label")
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

	@FindBy(how = How.CSS, using = "span.ng-option-label")
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

	@FindBy(how = How.CSS, using = "span.ng-option-label")
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
	
	@FindBy(how = How.CSS, using = "a[href='#collapseFour']")
	private WebElement _formHeaderHomeLeaveRentalCar;

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

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownOptionsBusinessClassAirfareUnit;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minDistanceBusinessHl']/preceding-sibling::label")
	private WebElement _lblMinDistanceForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceBusinessHl']")
	private WebElement _txtBoxMinDistanceForBusinessAirTravel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minTimeBusinessHl']/preceding-sibling::label")
	private WebElement _lblMinTimeForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minTimeBusinessHl']")
	private WebElement _txtBoxMinTimeForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportTypeList'] span.ng-value-icon.left")
	private WebElement _iconClearTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportationExpenseCodeList']")
	private WebElement _drpDownTransportationExpenseCode;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownOptionsTransportationExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportationExpenseCodeList'] span.ng-value-label")
	private List<WebElement> _drpDownSelectedOptionsTransportationExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveLodgingExpenseCodeList']")
	private WebElement _drpDownLodgingExpenseCode;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownOptionsLodgingExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveLodgingExpenseCodeList'] span.ng-value-label")
	private List<WebElement> _drpDownSelectedOptionsLodgingExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveMealsExpenseCodeList']")
	private WebElement _drpDownMealsExpenseCode;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownOptionsMealsExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveMealsExpenseCodeList'] span.ng-value-label")
	private List<WebElement> _drpDownSelectedOptionsMealsExpenseCode;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minDistanceEconomyHl']/preceding-sibling::label")
	private WebElement _lblMinDistanceForEconomyAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceEconomyHl']")
	private WebElement _txtBoxMinDistanceForEconomyAirTravel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minTimeEconomyHl']/preceding-sibling::label")
	private WebElement _lblMinTimeForEconomyAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minTimeEconomyHl']")
	private WebElement _txtBoxMinTimeForEconomyAirTravel;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='unitOfEconomyCodeHl']/preceding-sibling::label")
	private WebElement _lblEconomyClassAirFareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfEconomyCodeHl']")
	private WebElement _drpDownEconomyClassAirfareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfEconomyCodeHl'] span.ng-value-label")
	private WebElement _drpDownOptionSelectedEconomyClassAirfareUnit;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownOptionsEconomyClassAirfareUnit;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='excessBaggageFeesInd']/parent::label")
	private List<WebElement> _lblRadioOptionsExcessBaggageFees;

	@FindBy(how = How.CSS, using = "label > input[formcontrolname='excessBaggageFeesInd']")
	private List<WebElement> _radioButtonExcessBaggageFees;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='excessBaggageFeesInd']/parent::label/parent::div/preceding-sibling::label")
	private WebElement _lblExcessBaggageFees;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountPerPerson']")
	private WebElement _txtBoxMaxAmountPerPerson;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='maxAmountPerPerson']/preceding-sibling::label")
	private WebElement _lblMaxAmtPerPerson;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeExcessBagage']")
	private WebElement _drpDownExcessBaggageCurrencyCode;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private WebElement _dropDownOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeExcessBagage'] span.ng-value-label")
	private WebElement _currencyOptionSelected;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='currencyCodeExcessBagage']/preceding-sibling::label")
	private WebElement _lblCurrencyCode;

	@FindBy(how = How.XPATH, using = "//app-transporation//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnGrossUpPreTripTransport;
	
	@FindBy(how = How.CSS, using = "app-rental-car input[formcontrolname='numOfDays']")
	private WebElement _txtBoxDurationTripRentalCar;
	
	@FindBy(how = How.XPATH, using = "//app-rental-car//input[@formcontrolname='numOfDays']/preceding-sibling::label")
	private WebElement _lblDuration;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='classSizeCode']")
	private WebElement _drpDownSizeClass;
	
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='classSizeCode']/preceding-sibling::label")
	private WebElement _lblSizeClass;	
	
	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='classSizeCode'] span.ng-value-label")
	private WebElement _drpDownOptionSizeClassSelected;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='classSizeOther']")
	private WebElement _txtBoxOtherSizeClass;
	
	@FindBy(how = How.CSS, using = "#collapseFour label.form-check-label")
	private List<WebElement> _radioBtnPreTripRentalCar;
	
	@FindBy(how = How.XPATH, using = "//app-rental-car//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnGrossUpPreTripRentalCar;
	
	@FindBy(how = How.XPATH, using = "//app-rental-car//input[@formcontrolname='paidByCode']/parent::label")
	private List<WebElement> _radioBtnReimbursedByPreTripRentalCar;
	
	@FindBy(how = How.CSS, using = "app-rental-car input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherPreTripRentalCar;
	
	@FindBy(how = How.CSS, using = "app-rental-car textarea[formcontrolname='benefitComment']")
	private WebElement _textAreaBenefitCommentTripRentalCar;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveRentalCarExpenseCodeList']")
	private WebElement _drpDownRentalCarExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveRentalCarExpenseCodeList'] span.ng-value-label")
	private List<WebElement> _drpDownSelectedOptionsRentalCarExpenseCode;

	PDT_HomeLeaveBenefit homeLeaveBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getHomeLeaveDataList("Home Leave");

	private String _accompanyingFamilyMemeber, _maxAmtHomeLeaveMeals, _frequencyOfTrips, _sizeClass;
	private ArrayList<String> _transportType = null;
	private ArrayList<String> _expenseCodeTransportation = null;
	private ArrayList<String> _expenseCodeLodging = null;
	private ArrayList<String> _expenseCodeMeals = null;
	private ArrayList<String> _expenseCodeRentalCar = null;
	private List<String> _expectedAccompFamilyMembersList;
	private List<String> _expectedSizeClassList;
	String[] _expectedAccompFamilyMembersArr = new String[] { PDTConstants.TRANSFEREE_ONLY,
			PDTConstants.TRANSFEREE_AND_FAMILY_MEMBER, PDTConstants.TRANSFEREE_AND_FAMILY };
	String [] _sizeClassArr = new String[] {PDTConstants.MID_SIZE, PDTConstants.FULL_SIZE, PDTConstants.PREMIUM, PDTConstants.OTHER};

	public void setTransportType(ArrayList<String> transportTypeOptions) {
		this._transportType = transportTypeOptions;
	}

	public ArrayList<String> getTransportType() {
		return _transportType;
	}

	public void setAccompanyingFamilyMember(String accFamilyMem) {
		_accompanyingFamilyMemeber = accFamilyMem;
	}

	public String getAccompanyingFamilyMember() {
		return _accompanyingFamilyMemeber;
	}

	public void setMaxAmtHomeLeaveMeals(String maxAmt) {
		_maxAmtHomeLeaveMeals = maxAmt;
	}

	public String getMaxAmtHomeLeaveMeals() {
		return _maxAmtHomeLeaveMeals;
	}

	public void setFrequencyOfTrips(String freqTrips) {
		_frequencyOfTrips = freqTrips;
	}

	public String getFrequencyOfTrips() {
		return _frequencyOfTrips;
	}

	public void setExpenseCodeTransportation(ArrayList<String> expenseCode) {
		this._expenseCodeTransportation = expenseCode;
	}

	public ArrayList<String> getExpenseCodeTransportation() {
		return _expenseCodeTransportation;
	}

	public void setExpenseCodeLodging(ArrayList<String> expenseCode) {
		this._expenseCodeLodging = expenseCode;
	}

	public ArrayList<String> getExpenseCodeLodging() {
		return _expenseCodeLodging;
	}

	public void setExpenseCodeMeals(ArrayList<String> expenseCode) {
		this._expenseCodeMeals = expenseCode;
	}

	public ArrayList<String> getExpenseCodeMeals() {
		return _expenseCodeMeals;
	}

	public void setExpectedAccompFamilyMembersList() {
		_expectedAccompFamilyMembersList = Arrays.asList(_expectedAccompFamilyMembersArr);
	}

	public List<String> getExpectedAccompFamilyMembersList() {
		return _expectedAccompFamilyMembersList;
	}
	
	public void setSizeClassList(){
		_expectedSizeClassList = Arrays.asList(_sizeClassArr);
	}
	
	public List<String> getExpectedSizeClassList(){
		return _expectedSizeClassList;
	}
	
	public void setSizeClass(String sizeClass) {
		_sizeClass = sizeClass;
	}

	public String getSizeClass() {
		return _sizeClass;
	}
	
	public void setExpenseCodeRentalCar(ArrayList<String> expenseCode) {
		this._expenseCodeRentalCar = expenseCode;
	}

	public ArrayList<String> getExpenseCodeRentalCar() {
		return _expenseCodeRentalCar;
	}

	/**
	 * Add the Form Header of Home Leave Transportation, Home Leave Lodging & Home
	 * Leave Meals in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.HOME_LEAVE_TRANSPORTATION, _formHeaderHomeLeaveTransportation);
		subBenefitHeaderMap.put(PDTConstants.HOME_LEAVE_LODGING, _formHeaderHomeLeaveLodging);
		subBenefitHeaderMap.put(PDTConstants.HOME_LEAVE_MEALS, _formHeaderHomeLeaveMeals);
		subBenefitHeaderMap.put(PDTConstants.HOME_LEAVE_RENTAL_CAR, _formHeaderHomeLeaveRentalCar);
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
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblFrequencyOfTrips.getText(), subBenefitFormName));
				String randFrequencyOfTrips = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
						addNewPolicyPage, subBenefitFormName, _drpDownFrequencyOfTrip, _drpDownFrequencyOfTripOptions,
						_drpDownFrequencyOfTripOptionsSelected, _lblFrequencyOfTrips.getText());
				setFrequencyOfTrips(randFrequencyOfTrips);
				verifyAndFillOtherFreq(addNewPolicyPage, subBenefitFormName, randFrequencyOfTrips);
			} else {

				Assert.fail(PDTConstants.ASSIGNMENT_FREQTRIPS_NOT_DISPLAYED);
			}
		} catch (Exception e) {
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
				Assert.fail(MessageFormat.format(PDTConstants.OTHER_TEXTBOX_NOT_DISPLAYED, CoreConstants.FAIL,
						PDTConstants.OTHER, _lblFrequencyOfTrips.getText(), subBenefitFormName));
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_VERIFY_OTHER_TEXT_BOX, CoreConstants.FAIL,
					PDTConstants.OTHER, _lblFrequencyOfTrips.getText(), subBenefitFormName));
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
	 * 
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param tracingSet
	 * @param pageName
	 */
	public void fillHomeLeaveTransportationForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String tracingSet, String pageName, PDT_SharedSubBenefit_Steps objStep) {
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
			verifyAndFillNumberOfTripsBasedOnTracingSetValue(addNewPolicyPage, subBenefitFormName, tracingSet);
			selectAllTransportTypeOptions(addNewPolicyPage, subBenefitFormName, objStep);
			setExpectedAccompFamilyMembersList();
			CoreFunctions.clickElement(driver, _drpDownAccompFamilyMember);
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownAccompFamilyMemberOptions)
					.equals(getExpectedAccompFamilyMembersList())) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ACCOMP_FAMILY_MEM, CoreConstants.PASS,
						getExpectedAccompFamilyMembersList().toString()));
			}
			String randAccompanyingFamilMember = _drpDownAccompFamilyMemberOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownAccompFamilyMemberOptions.size() - 1)).getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownAccompFamilyMemberOptions, randAccompanyingFamilMember,
					_lblAccompFamilyMember.getText(), PDTConstants.DROP_DOWN, true);
			setAccompanyingFamilyMember(randAccompanyingFamilMember);

			CoreFunctions.selectItemInListByText(driver, _lblRadioOptionsExcessBaggageFees,
					homeLeaveBenefitData.homeLeaveTransportation.excessBaggageFees, _lblExcessBaggageFees.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);

			verifyAndFillMaxAmtIfExcessBaggageIsYes();

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHomeLeaveTransportation);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUpPreTripTransport,
					homeLeaveBenefitData.homeLeaveTransportation.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHomeLeaveTransportation,
					homeLeaveBenefitData.homeLeaveTransportation.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					homeLeaveBenefitData.homeLeaveTransportation.reimbursedBy,
					_txtBoxHomeLeaveTransportReimbursedByOther,
					homeLeaveBenefitData.homeLeaveTransportation.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaHomeLeaveTransportComment, PDTConstants.COMMENT,
					homeLeaveBenefitData.homeLeaveTransportation.comment);

			CoreFunctions.clickElement(driver, _drpDownTransportationExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver, PDTConstants.HOME_LEAVE,
							PDTConstants.HOME_LEAVE_TRANSPORTATION, _drpDownOptionsTransportationExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.HOME_LEAVE_TRANSPORTATION,
							DbFunctions.getExpenseCodeListForBenefit(PDTConstants.HOME_LEAVE).toString(),
							CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsTransportationExpenseCode)
									.toString()));
			ArrayList<String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownOptionsTransportationExpenseCode.size(), 5, driver,
					_drpDownOptionsTransportationExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES,
					_drpDownTransportationExpenseCode, _drpDownOptionsTransportationExpenseCode,
					_drpDownSelectedOptionsTransportationExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeTransportation(randExpenseCodeOptions);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Fill Home Leave Lodging Form.
	 * 
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillHomeLeaveLodgingForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName),
					subBenefitFormName, driver);
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
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, homeLeaveBenefitData.homeLeaveLodging.reimbursedBy,
					_txtBoxHomeLeaveLodgingReimbursedByOther, homeLeaveBenefitData.homeLeaveLodging.reimbursedByOther,
					subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaHomeLeaveLodgingComment, PDTConstants.COMMENT,
					homeLeaveBenefitData.homeLeaveLodging.comment);

			CoreFunctions.clickElement(driver, _drpDownLodgingExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver, PDTConstants.HOME_LEAVE,
							PDTConstants.HOME_LEAVE_LODGING, _drpDownOptionsLodgingExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.HOME_LEAVE_LODGING,
							DbFunctions.getExpenseCodeListForBenefit(PDTConstants.HOME_LEAVE).toString(),
							CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsLodgingExpenseCode)
									.toString()));
			ArrayList<String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownOptionsLodgingExpenseCode.size(), 5, driver, _drpDownOptionsLodgingExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES, _drpDownLodgingExpenseCode,
					_drpDownOptionsLodgingExpenseCode, _drpDownSelectedOptionsLodgingExpenseCode,
					randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeLodging(randExpenseCodeOptions);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
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
	 * 
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillHomeLeaveMealForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName),
					subBenefitFormName, driver);
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

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, homeLeaveBenefitData.homeLeaveMeals.reimbursedBy,
					_txtBoxHomeLeaveMealsReimbursedByOther, homeLeaveBenefitData.homeLeaveMeals.reimbursedByOther,
					subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaHomeLeaveMealsComment, PDTConstants.COMMENT,
					homeLeaveBenefitData.homeLeaveMeals.comment);

			CoreFunctions.clickElement(driver, _drpDownMealsExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver, PDTConstants.HOME_LEAVE,
							PDTConstants.HOME_LEAVE_MEALS, _drpDownOptionsMealsExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.HOME_LEAVE_MEALS,
							DbFunctions.getExpenseCodeListForBenefit(PDTConstants.HOME_LEAVE).toString(), CoreFunctions
									.getElementTextAndStoreInList(driver, _drpDownOptionsMealsExpenseCode).toString()));
			ArrayList<String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownOptionsMealsExpenseCode.size(), 5, driver, _drpDownOptionsMealsExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES, _drpDownMealsExpenseCode,
					_drpDownOptionsMealsExpenseCode, _drpDownSelectedOptionsMealsExpenseCode, randExpenseCodeOptions,
					subBenefitFormName);
			setExpenseCodeMeals(randExpenseCodeOptions);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Fill Home Leave sub-benefit based on sub-benefit name
	 * 
	 * @param subBenefit
	 * @param pageName
	 * @param addNewPolicyPage
	 * @param tracingSet
	 */
	public void fillHomeLeaveSubBenefit(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage,
			String tracingSet, PDT_SharedSubBenefitPage subBenefitPage, PDT_SharedSubBenefit_Steps objStep) {
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
		case PDTConstants.HOME_LEAVE_RENTAL_CAR:
			fillHomeLeaveRentalCarForm(addNewPolicyPage, subBenefit, pageName, objStep);
			break;
		default:
			Assert.fail(
					MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}
	}

	/**
	 * Iterate Home Leave sub-benefits and fill their corresponding form.
	 * 
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage
	 */
	public void iterateAndFillHomeLeaveSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep, String btnName,
			PDT_SharedSubBenefitPage subBenefitPage, String tracingSet) {
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
			e.printStackTrace();
			Assert.fail("Failed to verify Distance options field");
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
					verifyKmMilesHours(sharedSubBenefitStep, option, PDTConstants.BUSINESS_CLASS_AIRFARE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to verify Business Class AirFare options field");
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

	public boolean verifyHomeLeaveSubBenefitForTransportType(String pageName, String subBenefit,
			DataTable resultTable) {
		boolean result = false;
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
		timeBeforeAction = new Date().getTime();
		waitForProgressBarToDisapper();
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
		result = verifyHomeLeaveTripTransportationOptions(subBenefit, pageName, resultTable);
		try {
			CoreFunctions.click(driver, buttonMap.get(PDTConstants.PDT_BTN_SAVE_SUBMIT),
					buttonMap.get(PDTConstants.PDT_BTN_SAVE_SUBMIT).getText());
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL,
					PDTConstants.PDT_BTN_SAVE_SUBMIT));
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL,
					PDTConstants.PDT_BTN_SAVE_SUBMIT));
		}
		return result;
	}

	public boolean verifyHomeLeaveTripTransportationOptions(String subBenefitFormName, String pageName,
			DataTable resultTable) {
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

			// selectAllTransportTypeOptions(addNewPolicyPage, subBenefitFormName, objStep);
			result = verifyEachTransportationTypeOption(resultTable, pageName, subBenefitFormName);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHomeLeaveTransportation);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHomeLeaveTransportation,
					homeLeaveBenefitData.homeLeaveTransportation.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occured while trying to verify Transportation type for " + pageName + " -> "
					+ subBenefitFormName);
		}
		return result;
	}

	public boolean verifyEachTransportationTypeOption(DataTable resultTable, String benefitCategory, String benefit) {
		ArrayList<Boolean> result = new ArrayList<Boolean>();
		List<Map<String, String>> resultTableMap = resultTable.asMaps(String.class, String.class);
		CoreFunctions.clickElement(driver, _drpDownTransportationType);
		for (int i = 0; i < resultTableMap.size(); i++) {
			result.add(verifyTransportTypeOptions(resultTableMap.get(i), benefitCategory, benefit));
		}
		return result.stream().allMatch(t -> t.equals(true)) ? true : false;
	}

	public boolean verifyTransportTypeOptions(Map<String, String> resultTableMap, String benefitCategory,
			String benefit) {
		boolean result = false;
		switch (resultTableMap.get("Transportation_Type_Option")) {
		case PDTConstants.DISTANCE:
			result = verifyDistanceOptionFieldsForVisibilty(resultTableMap, benefitCategory, benefit)
					&& verifyDistanceOptionFieldsForInvisibilty(resultTableMap, benefitCategory, benefit);
			break;
		case PDTConstants.ECONOMY_CLASS_AIRFARE:
			result = verifyEconomyClassFieldsForVisibilty(resultTableMap, benefitCategory, benefit)
					&& verifyEconomyClassFieldsForInvisibilty(resultTableMap, benefitCategory, benefit);
			break;
		case PDTConstants.BUSINESS_CLASS_AIRFARE:
			result = verifyBusinessClassForVisibilty(resultTableMap, benefitCategory, benefit)
					&& verifyBusinessClassFieldsForInvisibilty(resultTableMap, benefitCategory, benefit);
			;
			break;
		default:
			Assert.fail("Not valid transportation type option");
		}
		return result;
	}

	public void printMessageForFieldVisibility(boolean result, String fieldName, String benefitCategory,
			String benefit) {
		if (result)
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TRANSPORTATION_TYPE_OPTION_VISIBILITY,
					CoreConstants.PASS, fieldName, benefit));
		else
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_TRANSPORTATION_TYPE_OPTION_VISIBILITY,
					CoreConstants.FAIL, fieldName, benefit));
	}

	public void printMessageForFieldInVisibility(boolean result, String fieldName, String benefitCategory,
			String benefit) {
		if (result)
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TRANSPORTATION_TYPE_OPTION_INVISIBILITY,
					CoreConstants.PASS, fieldName, benefit));
		else
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_TRANSPORTATION_TYPE_OPTION_INVISIBILITY,
							CoreConstants.FAIL, fieldName, benefit));
	}

	public boolean verifyDistanceOptionFieldsForVisibilty(Map<String, String> resultTableMap, String benefitCategory,
			String benefit) {
		boolean result = false;
		ArrayList<Boolean> resultElementVisible = new ArrayList<Boolean>();
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);
			CoreFunctions.selectItemInListByText(driver, _drpDownTransportationTypeOptions,
					resultTableMap.get("Transportation_Type_Option"), _lblTransportationType.getText(),
					PDTConstants.DROP_DOWN, true);
			CoreFunctions.clickElement(driver, _lblDistance);
			resultElementVisible.add(
					CoreFunctions.verifyElementPresentOnPage(_lblDistance, PDTConstants.LABEL, PDTConstants.DISTANCE));
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_txtBoxDistance, PDTConstants.TEXTBOX,
					PDTConstants.DISTANCE));
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_lblUnitOfDistance, PDTConstants.LABEL,
					PDTConstants.UNIT_OF_DISTANCE));
			for (WebElement btn : _radioBtnUnitOfDistanceLabel) {
				resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(btn, PDTConstants.RADIOBTN,
						_radioBtnUnitOfDistanceLabel.get(_radioBtnUnitOfDistanceLabel.indexOf(btn)).getText().trim()));
			}
		} catch (Exception e) {
			Assert.fail("Exception occured while trying to verify Distance fields for Visibility");
		}
		result = resultElementVisible.stream().allMatch(t -> t.equals(true)) ? true : false;
		printMessageForFieldVisibility(result, resultTableMap.get("Transportation_Type_Option"), benefitCategory,
				benefit);
		return result;
	}

	public boolean verifyDistanceOptionFieldsForInvisibilty(Map<String, String> resultTableMap, String benefitCategory,
			String benefit) {
		boolean result = false;
		ArrayList<Boolean> resultElementInVisible = new ArrayList<Boolean>();
		try {
			CoreFunctions.hoverAndSingleClick(driver, _iconClearTransportationType, "Clear Transport Type Option");
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _txtBoxDistance);
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_lblDistance, PDTConstants.LABEL,
					PDTConstants.DISTANCE));
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_txtBoxDistance,
					PDTConstants.TEXTBOX, PDTConstants.DISTANCE));
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_lblUnitOfDistance,
					PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE));
			resultElementInVisible.add(CoreFunctions.verifyListElementNotPresentOnPage(_radioBtnUnitOfDistanceLabel,
					PDTConstants.RADIOBTN, PDTConstants.KM));
			resultElementInVisible.add(CoreFunctions.verifyListElementNotPresentOnPage(_radioBtnUnitOfDistanceLabel,
					PDTConstants.RADIOBTN, PDTConstants.MILES));
		} catch (Exception e) {
			Assert.fail(
					"Failed to verify Distance fields for invisibilty after deselecting the Distance option from Transportation Type dropdown.");
		}
		result = resultElementInVisible.stream().allMatch(t -> t.equals(true)) ? true : false;
		printMessageForFieldInVisibility(result, resultTableMap.get("Transportation_Type_Option"), benefitCategory,
				benefit);
		return result;
	}
	
	public boolean verifyEconomyClassFieldsForVisibilty(Map<String, String> resultTableMap, String benefitCategory, String benefit) {
		boolean result = false;
		ArrayList<Boolean> resultElementVisible = new ArrayList<Boolean>();
		List<String> economyClassAirFareUnit = new ArrayList<String>();
		List<String> expectedEconomyClassAirFareUnit = new ArrayList<String>();
		expectedEconomyClassAirFareUnit.add(PDTConstants.KM);
		expectedEconomyClassAirFareUnit.add(PDTConstants.MI);
		expectedEconomyClassAirFareUnit.add(PDTConstants.HOURS);
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);
			CoreFunctions.selectItemInListByText(driver, _drpDownTransportationTypeOptions, resultTableMap.get("Transportation_Type_Option"),
					_lblTransportationType.getText(), PDTConstants.DROP_DOWN, true);
			CoreFunctions.clickElement(driver, _lblEconomyClassAirFareUnit);
			
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(
					_lblEconomyClassAirFareUnit, PDTConstants.LABEL, PDTConstants.ECONOMY_CLASS_AIRFARE_UNIT));
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_drpDownEconomyClassAirfareUnit,
							PDTConstants.DROP_DOWN, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));

			CoreFunctions.clickElement(driver, _drpDownEconomyClassAirfareUnit);
			economyClassAirFareUnit = CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsEconomyClassAirfareUnit);
			Log.info("business class air fare unit=="+economyClassAirFareUnit);
			Log.info("expected business class air fare unit=="+expectedEconomyClassAirFareUnit);
			if(expectedEconomyClassAirFareUnit.equals(economyClassAirFareUnit)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DRPDOWN_OPTION, CoreConstants.PASS, economyClassAirFareUnit, PDTConstants.ECONOMY_CLASS_AIRFARE_UNIT));
				resultElementVisible.add(true);
			} else {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DRPDOWN_OPTION, CoreConstants.FAIL, expectedEconomyClassAirFareUnit, PDTConstants.ECONOMY_CLASS_AIRFARE_UNIT));
				resultElementVisible.add(false);
			}
			
			for (String option : economyClassAirFareUnit) {					
				CoreFunctions.clickElement(driver, _drpDownEconomyClassAirfareUnit);
				CoreFunctions.selectItemInListByText(driver, _drpDownOptionsEconomyClassAirfareUnit,
						option, _lblEconomyClassAirFareUnit.getText(), PDTConstants.DROP_DOWN, true);
				resultElementVisible.add(verifyKmMilesHoursForVisibility(option, resultTableMap.get("Transportation_Type_Option")));
			}			
		}catch(Exception e) {
			Assert.fail("Exception occured while trying to verify Economy Class Airfare Option for Transportation drop down.");
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
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _lblEconomyClassAirFareUnit);
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_lblEconomyClassAirFareUnit, PDTConstants.LABEL, PDTConstants.ECONOMY_CLASS_AIRFARE_UNIT));
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_drpDownEconomyClassAirfareUnit, PDTConstants.DROP_DOWN, PDTConstants.ECONOMY_CLASS_AIRFARE_UNIT));
		} catch(Exception e) {
			Assert.fail("Exception occured while trying to verify Economy Class fields for invisibilty after deselecting the Economy Class Airfare option from Transportation Type dropdown.");
		}
		result = resultElementInVisible.stream().allMatch(t -> t.equals(true)) ? true : false;		
		printMessageForFieldInVisibility(result, resultTableMap.get("Transportation_Type_Option"), benefitCategory, benefit);
		return result;
	}

	public boolean verifyBusinessClassForVisibilty(Map<String, String> resultTableMap, String benefitCategory,
			String benefit) {
		boolean result = false;
		ArrayList<Boolean> resultElementVisible = new ArrayList<Boolean>();
		List<String> businessAirFareUnit = new ArrayList<String>();
		List<String> expectedBusinessAirFareUnit = new ArrayList<String>();
		expectedBusinessAirFareUnit.add(PDTConstants.KM);
		expectedBusinessAirFareUnit.add(PDTConstants.MI);
		expectedBusinessAirFareUnit.add(PDTConstants.HOURS);
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);
			CoreFunctions.selectItemInListByText(driver, _drpDownTransportationTypeOptions,
					resultTableMap.get("Transportation_Type_Option"), _lblTransportationType.getText(),
					PDTConstants.DROP_DOWN, true);
			CoreFunctions.clickElement(driver, _lblBusinessClassAirFareUnit);

			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_lblBusinessClassAirFareUnit,
					PDTConstants.LABEL, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(_drpDownBusinessClassAirfareUnit,
					PDTConstants.DROP_DOWN, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));

			CoreFunctions.clickElement(driver, _drpDownBusinessClassAirfareUnit);
			businessAirFareUnit = CoreFunctions.getElementTextAndStoreInList(driver,
					_drpDownOptionsBusinessClassAirfareUnit);
			Log.info("business class air fare unit==" + businessAirFareUnit);
			Log.info("expected business class air fare unit==" + expectedBusinessAirFareUnit);
			if (expectedBusinessAirFareUnit.equals(businessAirFareUnit)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DRPDOWN_OPTION,
						CoreConstants.PASS, businessAirFareUnit, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
				resultElementVisible.add(true);
			} else {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DRPDOWN_OPTION,
						CoreConstants.FAIL, expectedBusinessAirFareUnit, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
				resultElementVisible.add(false);
			}

			for (String option : businessAirFareUnit) {
				CoreFunctions.clickElement(driver, _drpDownBusinessClassAirfareUnit);
				CoreFunctions.selectItemInListByText(driver, _drpDownOptionsBusinessClassAirfareUnit, option,
						_lblBusinessClassAirFareUnit.getText(), PDTConstants.DROP_DOWN, true);
				resultElementVisible.add(verifyKmMilesHoursForVisibility(option, resultTableMap.get("Transportation_Type_Option")));
			}
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while trying to verify Business Class Airfare Option for Transportation drop down.");
		}
		result = resultElementVisible.stream().allMatch(t -> t.equals(true)) ? true : false;
		printMessageForFieldVisibility(result, resultTableMap.get("Transportation_Type_Option"), benefitCategory,
				benefit);
		return result;
	}

	public boolean verifyBusinessClassFieldsForInvisibilty(Map<String, String> resultTableMap, String benefitCategory,
			String benefit) {
		boolean result = false;
		ArrayList<Boolean> resultElementInVisible = new ArrayList<Boolean>();
		try {
			CoreFunctions.hoverAndSingleClick(driver, _iconClearTransportationType, "Clear Transport Type Option");
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _lblBusinessClassAirFareUnit);
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_lblBusinessClassAirFareUnit,
					PDTConstants.LABEL, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
			resultElementInVisible.add(CoreFunctions.verifyElementNotPresentOnPage(_drpDownBusinessClassAirfareUnit,
					PDTConstants.DROP_DOWN, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while trying to verify Business Class fields for invisibilty after deselecting the Business Class Airfare option from Transportation Type dropdown.");
		}
		result = resultElementInVisible.stream().allMatch(t -> t.equals(true)) ? true : false;
		printMessageForFieldInVisibility(result, resultTableMap.get("Transportation_Type_Option"), benefitCategory,
				benefit);
		return result;
	}
	
	public boolean verifyKmMilesForVisibility(String transportTypeOption) {
		ArrayList<Boolean> resultElementVisible = new ArrayList<Boolean>();
		try {
			WebElement lblDistance = (transportTypeOption.equalsIgnoreCase(PDTConstants.ECONOMY_CLASS_AIRFARE) ? _lblMinDistanceForEconomyAirTravel : _lblMinDistanceForBusinessAirTravel);
			WebElement txtBoxDistance = (transportTypeOption.equalsIgnoreCase(PDTConstants.ECONOMY_CLASS_AIRFARE) ? _txtBoxMinDistanceForEconomyAirTravel : _txtBoxMinDistanceForBusinessAirTravel);
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(lblDistance,
					PDTConstants.LABEL, lblDistance.getText()));
			
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(
					txtBoxDistance, PDTConstants.TEXTBOX, lblDistance.getText()));
		

		} catch(Exception e) {
			Assert.fail("Exception occured while trying to verify Min. Distance for "+transportTypeOption+".");
		}
		return  resultElementVisible.stream().allMatch(t -> t.equals(true)) ? true : false;
	}
	
	public boolean verifyHoursForVisibility(String transportTypeOption) {
		ArrayList<Boolean> resultElementVisible = new ArrayList<Boolean>();
		try {
			WebElement lblMinTime = (transportTypeOption.equalsIgnoreCase(PDTConstants.ECONOMY_CLASS_AIRFARE) ? _lblMinTimeForEconomyAirTravel : _lblMinTimeForBusinessAirTravel);
			WebElement txtBoxMinTime = (transportTypeOption.equalsIgnoreCase(PDTConstants.ECONOMY_CLASS_AIRFARE) ? _txtBoxMinTimeForEconomyAirTravel : _txtBoxMinTimeForBusinessAirTravel);
			CoreFunctions.clickElement(driver, lblMinTime);
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(
					lblMinTime, PDTConstants.LABEL, lblMinTime.getText()));
			
			resultElementVisible.add(CoreFunctions.verifyElementPresentOnPage(
					txtBoxMinTime, PDTConstants.TEXTBOX, lblMinTime.getText()));
		
		} catch(Exception e) {
			Assert.fail("Exception occured while trying to verify Hours for "+transportTypeOption+".");
		}
		return  resultElementVisible.stream().allMatch(t -> t.equals(true)) ? true : false;
	}

	public boolean verifyKmMilesHoursForVisibility(String option, String transportTypeOption) {
		boolean result = false;
		if (option.equalsIgnoreCase(PDTConstants.KM) || option.equalsIgnoreCase(PDTConstants.MI)
				|| option.equalsIgnoreCase(PDTConstants.MILES)) {
			result = verifyKmMilesForVisibility(transportTypeOption);
		} else if (option.equalsIgnoreCase(PDTConstants.HOURS)) {
			result = verifyHoursForVisibility(transportTypeOption);
			
		} else {
			Assert.fail("Not a valid option for Business Air Travel");
		}
		return result;
	}

	public void verifyKmMiles(PDT_SharedSubBenefit_Steps sharedSubBenefitStep, String transportationType) {
		try {
			WebElement lblMinDistance = transportationType.equalsIgnoreCase(PDTConstants.BUSINESS_CLASS_AIRFARE)
					? _lblMinDistanceForBusinessAirTravel
					: transportationType.equalsIgnoreCase(PDTConstants.ECONOMY_CLASS_AIRFARE)
							? _lblMinDistanceForEconomyAirTravel
							: null;
			WebElement txtBoxMinDistance = transportationType.equalsIgnoreCase(PDTConstants.BUSINESS_CLASS_AIRFARE)
					? _txtBoxMinDistanceForBusinessAirTravel
					: transportationType.equalsIgnoreCase(PDTConstants.ECONOMY_CLASS_AIRFARE)
							? _txtBoxMinDistanceForEconomyAirTravel
							: null;

			if (lblMinDistance.equals(null) || txtBoxMinDistance.equals(null)) {
				Assert.fail("Verification of Km & Miles is not applicable for " + transportationType
						+ " transportation type.");
			}
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyElementPresentOnPage(lblMinDistance, PDTConstants.LABEL,
							lblMinDistance.getText()),
					MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
							PDTConstants.LABEL, lblMinDistance.getText()));

			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyElementPresentOnPage(txtBoxMinDistance, PDTConstants.TEXTBOX,
							lblMinDistance.getText()),
					MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
							PDTConstants.TEXTBOX, lblMinDistance.getText()));

			// Boundary check for Min Distance Business textbox
			String random9DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(9);
			String random10DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(10);

			CoreFunctions.clickElement(driver, txtBoxMinDistance);
			CoreFunctions.clearAndSetText(driver, txtBoxMinDistance, lblMinDistance.getText(), random9DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(txtBoxMinDistance, "value"),
							random9DigitStr, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL,
							random9DigitStr.length(),
							Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE_BUS_AIR_TRAVEL)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL,
							random9DigitStr.length(), CoreFunctions.getAttributeText(txtBoxMinDistance, "value"),
							random9DigitStr));

			CoreFunctions.clearAndSetText(driver, txtBoxMinDistance, lblMinDistance.getText(),
					PDTConstants.ELEVEN_DIGIT_STRING);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(txtBoxMinDistance, "value"),
							PDTConstants.ELEVEN_DIGIT_STRING, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL,
							PDTConstants.ELEVEN_DIGIT_STRING.length(),
							Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE_BUS_AIR_TRAVEL)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL,
							PDTConstants.ELEVEN_DIGIT_STRING.length(),
							CoreFunctions.getAttributeText(txtBoxMinDistance, "value"),
							PDTConstants.ELEVEN_DIGIT_STRING));

			CoreFunctions.clearAndSetText(driver, txtBoxMinDistance, lblMinDistance.getText(), random10DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(txtBoxMinDistance, "value"),
							random10DigitStr, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL,
							random10DigitStr.length(),
							Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE_BUS_AIR_TRAVEL)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL,
							random10DigitStr.length(), CoreFunctions.getAttributeText(txtBoxMinDistance, "value"),
							random10DigitStr));
		} catch (Exception e) {
			Assert.fail("Failed to verify Min. Distance for " + transportationType + ".");
		}
	}

	public void verifyHours(PDT_SharedSubBenefit_Steps sharedSubBenefitStep, String transportationType) {
		try {
			WebElement lblMinTime = transportationType.equalsIgnoreCase(PDTConstants.BUSINESS_CLASS_AIRFARE)
					? _lblMinTimeForBusinessAirTravel
					: transportationType.equalsIgnoreCase(PDTConstants.ECONOMY_CLASS_AIRFARE)
							? _lblMinTimeForEconomyAirTravel
							: null;
			WebElement txtBoxMinTime = transportationType.equalsIgnoreCase(PDTConstants.BUSINESS_CLASS_AIRFARE)
					? _txtBoxMinTimeForBusinessAirTravel
					: transportationType.equalsIgnoreCase(PDTConstants.ECONOMY_CLASS_AIRFARE)
							? _txtBoxMinTimeForEconomyAirTravel
							: null;

			if (lblMinTime.equals(null) || txtBoxMinTime.equals(null)) {
				Assert.fail(
						"Verification of Hours is not applicable for " + transportationType + " transportation type.");
			}
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyElementPresentOnPage(lblMinTime, PDTConstants.LABEL, lblMinTime.getText()),
					MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
							PDTConstants.LABEL, lblMinTime.getText()));

			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyElementPresentOnPage(txtBoxMinTime, PDTConstants.TEXTBOX, lblMinTime.getText()),
					MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
							PDTConstants.TEXTBOX, lblMinTime.getText()));

			// Boundary check for Min Distance Business textbox
			String random2DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(2);
			String random3DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(3);

			CoreFunctions.clickElement(driver, txtBoxMinTime);
			CoreFunctions.clearAndSetText(driver, txtBoxMinTime, lblMinTime.getText(), random2DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(txtBoxMinTime, "value"),
							random2DigitStr, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS,
							random2DigitStr.length(),
							Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_BUS_AIR_TRAVEL_INHRS)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS,
							random2DigitStr.length(), CoreFunctions.getAttributeText(txtBoxMinTime, "value"),
							random2DigitStr));

			CoreFunctions.clearAndSetText(driver, txtBoxMinTime, lblMinTime.getText(), PDTConstants.FOUR_DIGIT_STRING);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(txtBoxMinTime, "value"),
							PDTConstants.FOUR_DIGIT_STRING, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS,
							PDTConstants.FOUR_DIGIT_STRING.length(),
							Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_BUS_AIR_TRAVEL_INHRS)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHAR, CoreConstants.FAIL,
							PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS,
							PDTConstants.FOUR_DIGIT_STRING.length(),
							CoreFunctions.getAttributeText(txtBoxMinTime, "value"), PDTConstants.FOUR_DIGIT_STRING));

			CoreFunctions.clearAndSetText(driver, txtBoxMinTime, lblMinTime.getText(), random3DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(txtBoxMinTime, "value"),
							random3DigitStr, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS,
							random3DigitStr.length(),
							Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_BUS_AIR_TRAVEL_INHRS)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS,
							random3DigitStr.length(), CoreFunctions.getAttributeText(txtBoxMinTime, "value"),
							random3DigitStr));

		} catch (Exception e) {
			Assert.fail("Failed to verify Hours for Business Air Travel.");
		}
	}

	public void verifyKmMilesHours(PDT_SharedSubBenefit_Steps sharedSubBenefitStep, String option,
			String transportationType) {
		if (option.equalsIgnoreCase(PDTConstants.KM) || option.equalsIgnoreCase(PDTConstants.MI)) {
			verifyKmMiles(sharedSubBenefitStep, transportationType);
		} else if (option.equalsIgnoreCase(PDTConstants.HOURS)) {
			verifyHours(sharedSubBenefitStep, transportationType);
		} else {
			Assert.fail("Not a valid option for Business Air Travel");
		}
	}

	public void verifyAndFillEconomyAirTravelField(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		List<String> economyAirFareUnit = new ArrayList<String>();
		try {
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
					.contains(PDTConstants.ECONOMY_CLASS_AIRFARE)) {
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyElementPresentOnPage(_lblEconomyClassAirFareUnit, PDTConstants.LABEL,
								PDTConstants.ECONOMY_CLASS_AIRFARE),
						MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
								PDTConstants.LABEL, PDTConstants.ECONOMY_CLASS_AIRFARE_UNIT));
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
						CoreFunctions.verifyElementPresentOnPage(_drpDownEconomyClassAirfareUnit,
								PDTConstants.DROP_DOWN, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT),
						MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
								PDTConstants.DROP_DOWN, PDTConstants.ECONOMY_CLASS_AIRFARE_UNIT));

				CoreFunctions.clickElement(driver, _drpDownEconomyClassAirfareUnit);
				economyAirFareUnit = CoreFunctions.getElementTextAndStoreInList(driver,
						_drpDownOptionsEconomyClassAirfareUnit);

				for (String option : economyAirFareUnit) {
					CoreFunctions.clickElement(driver, _drpDownEconomyClassAirfareUnit);
					CoreFunctions.selectItemInListByText(driver, _drpDownOptionsEconomyClassAirfareUnit, option,
							_lblEconomyClassAirFareUnit.getText(), PDTConstants.DROP_DOWN, true);
					verifyKmMilesHours(sharedSubBenefitStep, option, PDTConstants.ECONOMY_CLASS_AIRFARE);
				}
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify Economy Class AirFare options field");
		}
	}

	public void verifyAndFillMaxAmtIfExcessBaggageIsYes() {
		int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _lblRadioOptionsExcessBaggageFees,
				"Yes");
		// For debugging purpose
		if (_radioButtonExcessBaggageFees.get(index).getAttribute("checked").equalsIgnoreCase("true")) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_EXCESS_BAGGAGE_CHOSEN, CoreConstants.PASS,
					_lblRadioOptionsExcessBaggageFees.get(0).getText()));
			verifyAndFillMaxAmt();
			verifyCurrencyFieldIsDisplayed();
		}

	}

	public void verifyAndFillMaxAmt() {
		if (CoreFunctions.verifyElementPresentOnPage(_txtBoxMaxAmountPerPerson, PDTConstants.TEXTBOX,
				_lblMaxAmtPerPerson.getText())) {
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmountPerPerson, _lblMaxAmtPerPerson.getText(),
					homeLeaveBenefitData.homeLeaveTransportation.maxAmtPerPerson);
		} else {
			Assert.fail("Max Amount per person field not persent on page.");
		}
	}

	public void verifyCurrencyFieldIsDisplayed() {
		if (CoreFunctions.verifyElementPresentOnPage(_drpDownExcessBaggageCurrencyCode, PDTConstants.DROP_DOWN,
				_lblCurrencyCode.getText())) {
			verifyDefaultUSCurrencySelected();
		} else {
			Assert.fail("Failed Currency field not persent on page.");
		}
	}

	public void verifyDefaultUSCurrencySelected() {
		if (_currencyOptionSelected.getText().trim().equalsIgnoreCase("U.S. Dollar")) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DEFAULT_CURRENCY, CoreConstants.PASS,
					_currencyOptionSelected.getText().trim()));
		} else {
			Assert.fail("Failed to verify default selected currency is U.S. Dollar. Actual currency selected is "
					+ _currencyOptionSelected.getText());
		}
	}
	
	public void fillHomeLeaveRentalCarForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String pageName, PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			//expandSubBenefitIfCollapsed(subBenefitFormName, _headingFormPreTripRentalCar);
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxDurationTripRentalCar, _lblDuration.getText());
			
			// Boundary check for duration textbox				
			String random9DigitStr=CoreFunctions.generateRandomNumberAsGivenLength(9);
			String random10DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(10);
			
			CoreFunctions.clickElement(driver, _txtBoxDurationTripRentalCar);
			CoreFunctions.clearAndSetText(driver, _txtBoxDurationTripRentalCar, _lblDuration.getText(), random9DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyTextForMaxLength(
							CoreFunctions.getAttributeText(_txtBoxDurationTripRentalCar, "value"), random9DigitStr,
							_lblDuration.getText(), random9DigitStr.length(),
							Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, _lblDuration.getText(), random9DigitStr.length(),
							CoreFunctions.getAttributeText(_txtBoxDurationTripRentalCar, "value"), random9DigitStr));
					
			CoreFunctions.clearAndSetText(driver, _txtBoxDurationTripRentalCar, _lblDuration.getText(), PDTConstants.ELEVEN_DIGIT_STRING);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(
					CoreFunctions.getAttributeText(_txtBoxDurationTripRentalCar, "value"),
					PDTConstants.ELEVEN_DIGIT_STRING, _lblDuration.getText(), PDTConstants.ELEVEN_DIGIT_STRING.length(),
					Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, _lblDuration.getText(), PDTConstants.ELEVEN_DIGIT_STRING.length(),
							CoreFunctions.getAttributeText(_txtBoxDurationTripRentalCar, "value"),
							PDTConstants.ELEVEN_DIGIT_STRING));
			
			CoreFunctions.clearAndSetText(driver, _txtBoxDurationTripRentalCar, _lblDuration.getText(), random10DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyTextForMaxLength(
							CoreFunctions.getAttributeText(_txtBoxDurationTripRentalCar, "value"), random10DigitStr,
							_lblDuration.getText(), random10DigitStr.length(),
							Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE)),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS,
							CoreConstants.FAIL, _lblDuration.getText(), random10DigitStr.length(),
							CoreFunctions.getAttributeText(_txtBoxDurationTripRentalCar, "value"), random10DigitStr));
			
			CoreFunctions.clickElement(driver, _drpDownSizeClass);
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptions)
					.equals(getExpectedSizeClassList())) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROPDOWN, CoreConstants.PASS, _lblSizeClass.getText(), getExpectedAccompFamilyMembersList().toString()));
			}
			String randSizeClass = _drpDownOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownOptions.size() - 1))
					.getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownOptions,
					randSizeClass, _lblSizeClass.getText(), PDTConstants.DROP_DOWN, true);
			setSizeClass(randSizeClass);
			
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					homeLeaveBenefitData.homeLeaveRentalCar.sizeClass,
					_txtBoxOtherSizeClass,
					homeLeaveBenefitData.homeLeaveRentalCar.otherSizeClass, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnGrossUpPreTripRentalCar);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUpPreTripRentalCar,
					homeLeaveBenefitData.homeLeaveRentalCar.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			
			
			CoreFunctions.selectItemInListByText(driver, _radioBtnReimbursedByPreTripRentalCar,
					homeLeaveBenefitData.homeLeaveRentalCar.reimbursedBy,
					PDTConstants.REIMBURSED_BY, PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					homeLeaveBenefitData.homeLeaveRentalCar.reimbursedBy,
					_txtBoxReimbursedByOtherPreTripRentalCar,
					homeLeaveBenefitData.homeLeaveRentalCar.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _textAreaBenefitCommentTripRentalCar, PDTConstants.COMMENT,
					homeLeaveBenefitData.homeLeaveRentalCar.comment);

			CoreFunctions.clickElement(driver, _drpDownRentalCarExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.HOME_LEAVE, PDTConstants.HOME_LEAVE_RENTAL_CAR,
							_drpDownOptions),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.HOUSE_HUNTING_TRIP_RENTAL_CAR,
							DbFunctions.getExpenseCodeListForBenefit(PDTConstants.HOUSE_HUNTING_TRIP).toString(),
							CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptions)
									.toString()));
			ArrayList<String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownOptions.size(), 5, driver,
					_drpDownOptions);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES,
					_drpDownRentalCarExpenseCode, _drpDownOptions,
					_drpDownSelectedOptionsRentalCarExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeRentalCar(randExpenseCodeOptions);

		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}
}
