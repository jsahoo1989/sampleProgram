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
import com.aires.testdatatypes.pdt.PDT_HouseHuntingTripBenefit;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_HouseHuntingTripPage extends PDT_SharedSubBenefitPage {
	public PDT_HouseHuntingTripPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfTrip']")
	private WebElement _txtBoxNumOfTrips;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripTransportTypeList']")
	private WebElement _drpDownTransportationType;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripTransportTypeList'] span.ng-value-label")
	private List<WebElement> _drpDownTransportationTypeMultiSelectOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode']")
	private WebElement _drpDownAccompanyingFamilyMemberCode;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownAccompanyingFamilyMemberCodeOptions;

	@FindBy(how = How.CSS, using = "#collapseOne1 label.form-check-label")
	private List<WebElement> _radioBtnHouseHuntingTripTransport;
	
	@FindBy(how = How.XPATH, using = "//app-trip-transportation//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnGrossUpHouseHuntingTripTransport;	

	@FindBy(how = How.CSS, using = "#collapseOne1 input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHouseHuntingTripTransportReimbursedByOther;

	@FindBy(how = How.CSS, using = "#collapseOne1 textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHouseHuntingTripTransportComment;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfNightsPerTrip']")
	private WebElement _txtBoxNumOfNightsPerTrip;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountPerNightCode']")
	private WebElement _drpDownMaxAmt;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownMaxAmtOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountPerNightCode'] span.ng-value-label")
	private WebElement _drpDownMaxAmtSelectedOption;

	@FindBy(how = How.CSS, using = "input[formcontrolname='flatAmountPerNight']")
	private WebElement _txtBoxFlatAmtPerNight;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrencyCode;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownCurrencyCodeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownCurrencyCodeSelected;

	@FindBy(how = How.CSS, using = "#collapseTwo label.form-check-label")
	private List<WebElement> _radioBtnHouseHuntingTripLodging;

	@FindBy(how = How.CSS, using = "app-trip-lodging input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHouseHuntingTripLodgingReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-trip-lodging textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHouseHuntingTripLodgingComment;

	@FindBy(how = How.CSS, using = "input[formcontrolname='durationPerTrip']")
	private WebElement _txtBoxDurationPerTrip;

	@FindBy(how = How.CSS, using = "#collapseThree label.form-check-label")
	private List<WebElement> _radioBtnHouseHuntingTripMeals;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='maxAmountCode']")
	private WebElement _drpDownMaxAmount;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownMaxAmountOptions;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='maxAmountCode']/descendant::span[contains(@class,'ng-value-label')]")
	private WebElement _drpDownMaxAmountSelectedVal;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountEe']")
	private WebElement _txtBoxMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe']")
	private WebElement _drpDownTransfereeCurrency;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownTransfereeCurrencyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe']  span.ng-value-label")
	private WebElement _drpDownTransfereeCurrencyOptionSelected;

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

	@FindBy(how = How.CSS, using = "#collapseThree label.form-check-label")
	private List<WebElement> _radioBtnHouseHuntingTripMeal;

	@FindBy(how = How.CSS, using = "app-trip-meals input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHouseHuntingTripReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-trip-meals textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHouseHuntingTripMealComment;

	@FindBy(how = How.XPATH, using = "//label[text()='Number of Trips']")
	private WebElement _lblNoOfTrips;

	@FindBy(how = How.XPATH, using = "//label[text()='Transportation Type']")
	private WebElement _lblTransportationType;

	@FindBy(how = How.XPATH, using = "//label[text()='Accompanying Family Members']")
	private WebElement _lblAccompanyingFamilyMember;

	@FindBy(how = How.XPATH, using = "//label[text()='Number of Nights per Trip']")
	private WebElement _lblNumOfNightsPerTrip;

	@FindBy(how = How.XPATH, using = "//app-trip-lodging//label[contains(text(), 'Max. Amount')]")
	private WebElement _lblMaxAmt;

	@FindBy(how = How.XPATH, using = "//label[text()='Flat Amount/Night']")
	private WebElement _lblFlatAmount;

	@FindBy(how = How.XPATH, using = "//label[text()='Currency']")
	private WebElement _lblCurrency;

	@FindBy(how = How.XPATH, using = "//label[text()='Duration per Trip (Days)']")
	private WebElement _lblDurationPerTrip;

	@FindBy(how = How.XPATH, using = "//label[text()='Type']")
	private WebElement _lblType;

	@FindBy(how = How.XPATH, using = "//app-trip-meals//label[contains(text(), 'Max. Amount')]")
	private WebElement _lblMaxAmtHouseHuntingTripMeals;

	@FindBy(how = How.XPATH, using = "//app-trip-meals//label[contains(text(), 'Max. Amount - Transferee')]")
	private WebElement _lblMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//app-trip-meals//label[contains(text(), 'Max. Amount - Other Adults')]")
	private WebElement _lblMaxAmtOtherAdults;

	@FindBy(how = How.XPATH, using = "//app-trip-meals//label[contains(text(), 'Max. Amount - Children')]")
	private WebElement _lblMaxAmtChildren;
	
	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseOne1']")
	private WebElement _formHeaderHouseHuntingTripTransportation;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formHeaderHouseHuntingTripLodging;

	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _formHeaderHouseHuntingTripMeals;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseFour']")
	private WebElement _formHeaderHouseHuntingTripRentalCar;
	
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripTransportationExpenseCodeList']")
	private WebElement _drpDownTransportationExpenseCode;
	
	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownOptionsTransportationExpenseCode;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripTransportationExpenseCodeList'] span.ng-value-label")
	private List<WebElement> _drpDownSelectedOptionsTransportationExpenseCode;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripLodgingExpenseCodeList']")
	private WebElement _drpDownLodgingExpenseCode;
	
	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownOptionsLodgingExpenseCode;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripLodgingExpenseCodeList'] span.ng-value-label")
	private List<WebElement> _drpDownSelectedOptionsLodgingExpenseCode;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripMealsExpenseCodeList']")
	private WebElement _drpDownMealsExpenseCode;
	
	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownOptionsMealsExpenseCode;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripMealsExpenseCodeList'] span.ng-value-label")
	private List<WebElement> _drpDownSelectedOptionsMealsExpenseCode;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='distanceHht']/preceding-sibling::label")
	private WebElement _lblDistance;

	@FindBy(how = How.CSS, using = "input[formcontrolname='distanceHht']")
	private WebElement _txtBoxDistance;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfDistanceCodeHht']/ancestor::div/preceding-sibling::label")
	private WebElement _lblUnitOfDistance;

	@FindBy(how = How.CSS, using = "input[formcontrolname='unitOfDistanceCodeHht']")
	private List<WebElement> _radioBtnUnitOfDistance;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfDistanceCodeHht']/parent::label")
	private List<WebElement> _radioBtnUnitOfDistanceLabel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minDistanceEconomyHht']/preceding-sibling::label")
	private WebElement _lblMinDistanceForEconomyTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceEconomyHht']")
	private WebElement _txtBoxMinDistanceEconomy;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfEconomyCodeHht']/ancestor::div/preceding-sibling::label")
	private WebElement _lblUnitOfDistanceForEconomyCode;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfEconomyCodeHht']/parent::label")
	private List<WebElement> _lblUnitOfDistanceForEconomyAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='unitOfEconomyCodeHht']")
	private List<WebElement> _radioBtnUnitOfDistanceForEconomyCode;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='unitOfBusinessCodeHht']/preceding-sibling::label")
	private WebElement _lblBusinessClassAirFareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfBusinessCodeHht']")
	private WebElement _drpDownBusinessClassAirfareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfBusinessCodeHht'] span.ng-value-label")
	private WebElement _drpDownOptionSelectedBusinessClassAirfareUnit;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownOptionsBusinessClassAirfareUnit;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minDistanceBusinessHht']/preceding-sibling::label")
	private WebElement _lblMinDistanceForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceBusinessHht']")
	private WebElement _txtBoxMinDistanceForBusinessAirTravel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minTimeBusinessHht']/preceding-sibling::label")
	private WebElement _lblMinTimeForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minTimeBusinessHht']")
	private WebElement _txtBoxMinTimeForBusinessAirTravel;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripTransportTypeList'] span.ng-value-icon.left")
	private WebElement _iconClearTransportationType;
	
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='unitOfEconomyCodeHht']/preceding-sibling::label")
	private WebElement _lblEconomyClassAirFareUnit;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfEconomyCodeHht']")
	private WebElement _drpDownEconomyClassAirfareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfEconomyCodeHht'] span.ng-value-label")
	private WebElement _drpDownOptionSelectedEconomyClassAirfareUnit;

	@FindBy(how = How.CSS, using = "span.ng-option-label")
	private List<WebElement> _drpDownOptionsEconomyClassAirfareUnit;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minDistanceEconomyHht']/preceding-sibling::label")
	private WebElement _lblMinDistanceForEconomyAirTravel;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceEconomyHht']")
	private WebElement _txtBoxMinDistanceForEconomyAirTravel;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minTimeEconomyHht']/preceding-sibling::label")
	private WebElement _lblMinTimeForEconomyAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minTimeEconomyHht']")
	private WebElement _txtBoxMinTimeForEconomyAirTravel;
	
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
	
	@FindBy(how = How.CSS, using = "app-trip-rental-car input[formcontrolname='numOfDays']")
	private WebElement _txtBoxDurationTripRentalCar;
	
	@FindBy(how = How.XPATH, using = "//app-trip-rental-car//input[@formcontrolname='numOfDays']/preceding-sibling::label")
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
	
	@FindBy(how = How.XPATH, using = "//app-trip-rental-car//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnGrossUpPreTripRentalCar;
	
	@FindBy(how = How.XPATH, using = "//app-trip-rental-car//input[@formcontrolname='paidByCode']/parent::label")
	private List<WebElement> _radioBtnReimbursedByPreTripRentalCar;
	
	@FindBy(how = How.CSS, using = "app-trip-rental-car input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherPreTripRentalCar;
	
	@FindBy(how = How.CSS, using = "app-trip-rental-car textarea[formcontrolname='benefitComment']")
	private WebElement _textAreaBenefitCommentTripRentalCar;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripRentalCarExpenseCodeList']")
	private WebElement _drpDownRentalCarExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripRentalCarExpenseCodeList'] span.ng-value-label")
	private List<WebElement> _drpDownSelectedOptionsRentalCarExpenseCode;

	PDT_HouseHuntingTripBenefit houseHuntingTripBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getHouseHuntingTripDataList("House Hunting Trip");

	private String _accompanyingFamilyMemeber, _maxAmtHouseHuntingTripLodging, _maxAmtHouseHuntingTripMeals, _sizeClass;
	private ArrayList<String> _expenseCodeTransportation = null;
	private ArrayList<String> _expenseCodeLodging = null;
	private ArrayList<String> _expenseCodeMeals = null;
	private ArrayList<String> _expenseCodeRentalCar = null;
	private ArrayList<String> _transportType = null;
	private List<String> _expectedAccompFamilyMembersList;
	private List<String> _expectedSizeClassList;
	String [] _expectedAccompFamilyMembersArr = new String[] {PDTConstants.TRANSFEREE_ONLY, PDTConstants.TRANSFEREE_AND_FAMILY_MEMBER, PDTConstants.TRANSFEREE_AND_FAMILY};
	String [] _sizeClassArr = new String[] {PDTConstants.MID_SIZE, PDTConstants.FULL_SIZE, PDTConstants.PREMIUM, PDTConstants.OTHER};
	
	public void setExpenseCodeTransportation(ArrayList <String> expenseCode) {
		this._expenseCodeTransportation = expenseCode;
	}

	public ArrayList <String> getExpenseCodeTransportation() {
		return _expenseCodeTransportation;
	}
	
	public void setExpenseCodeLodging(ArrayList <String> expenseCode) {
		this._expenseCodeLodging = expenseCode;
	}

	public ArrayList <String> getExpenseCodeLodging() {
		return _expenseCodeLodging;
	}
	
	public void setExpenseCodeMeals(ArrayList <String> expenseCode) {
		this._expenseCodeMeals = expenseCode;
	}

	public ArrayList <String> getExpenseCodeMeals() {
		return _expenseCodeMeals;
	}
	
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

	public void setMaxAmtHouseHuntingTripLodging(String maxAmt) {
		_maxAmtHouseHuntingTripLodging = maxAmt;
	}

	public String getMaxAmtHouseHuntingTripLodging() {
		return _maxAmtHouseHuntingTripLodging;
	}

	public void setMaxAmtHouseHuntingTripMeals(String maxAmt) {
		_maxAmtHouseHuntingTripMeals = maxAmt;
	}

	public String getMaxAmtHouseHuntingTripMeals() {
		return _maxAmtHouseHuntingTripMeals;
	}
	
	public void setExpectedAccompFamilyMembersList(){
		_expectedAccompFamilyMembersList = Arrays.asList(_expectedAccompFamilyMembersArr);
	}
	
	public List<String> getExpectedAccompFamilyMembersList(){
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
	 * Add the Form Header of House Hunting Trip Transportation, House Hunting Trip Lodging & House Hunting Trip Meals in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION, _formHeaderHouseHuntingTripTransportation);
		subBenefitHeaderMap.put(PDTConstants.HOUSE_HUNTING_TRIP_LODGING, _formHeaderHouseHuntingTripLodging);
		subBenefitHeaderMap.put(PDTConstants.HOUSE_HUNTING_TRIP_MEALS, _formHeaderHouseHuntingTripMeals);
		subBenefitHeaderMap.put(PDTConstants.HOUSE_HUNTING_TRIP_RENTAL_CAR, _formHeaderHouseHuntingTripRentalCar);
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

	public void selectRandomTransportTypeOption(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);
			String randTransportTypeOption = CoreFunctions.getRandomAndUniqueMultipleSelectDropDownOptions(_drpDownTransportationTypeOptions);			
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
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL, _lblTransportationType.getText(), subBenefitFormName));			
		}
	}

	/**
	 * Fll HouseHuntingTrip Transportation Form.
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillHouseHuntingTripTransportationForm(PDT_AddNewPolicyPage addNewPolicyPage,
			String subBenefitFormName, String pageName, PDT_SharedSubBenefit_Steps objStep) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxNumOfTrips, _lblNoOfTrips.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxNumOfTrips, _lblNoOfTrips.getText(),
					houseHuntingTripBenefitData.houseHuntingTripTransportation.numberOfTrips);
			selectAllTransportTypeOptions(addNewPolicyPage, subBenefitFormName, objStep);

			setExpectedAccompFamilyMembersList();
			CoreFunctions.clickElement(driver, _drpDownAccompanyingFamilyMemberCode);
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownAccompanyingFamilyMemberCodeOptions)
					.equals(getExpectedAccompFamilyMembersList())) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ACCOMP_FAMILY_MEM, CoreConstants.PASS, getExpectedAccompFamilyMembersList().toString()));
			}
			String randAccompanyingFamilMember = _drpDownAccompanyingFamilyMemberCodeOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownAccompanyingFamilyMemberCodeOptions.size() - 1))
					.getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownAccompanyingFamilyMemberCodeOptions,
					randAccompanyingFamilMember, _lblAccompanyingFamilyMember.getText(), PDTConstants.DROP_DOWN, true);
			setAccompanyingFamilyMember(randAccompanyingFamilMember);
			
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHouseHuntingTripTransport);
			CoreFunctions.selectItemInListByText(driver, _lblRadioOptionsExcessBaggageFees,
					houseHuntingTripBenefitData.houseHuntingTripTransportation.excessBaggageFees, _lblExcessBaggageFees.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);
			
			verifyAndFillMaxAmtIfExcessBaggageIsYes();
			
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUpHouseHuntingTripTransport,
					houseHuntingTripBenefitData.houseHuntingTripTransportation.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripTransport,
					houseHuntingTripBenefitData.houseHuntingTripTransportation.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					houseHuntingTripBenefitData.houseHuntingTripTransportation.reimbursedBy,
					_txtBoxHouseHuntingTripTransportReimbursedByOther,
					houseHuntingTripBenefitData.houseHuntingTripTransportation.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaHouseHuntingTripTransportComment, PDTConstants.COMMENT,
					houseHuntingTripBenefitData.houseHuntingTripTransportation.comment);
			
			CoreFunctions.clickElement(driver, _drpDownTransportationExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.HOUSE_HUNTING_TRIP, PDTConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION,
							_drpDownOptionsTransportationExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION, DbFunctions.getExpenseCodeListForBenefit(PDTConstants.HOUSE_HUNTING_TRIP).toString(), CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsTransportationExpenseCode).toString()));
			ArrayList <String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0, _drpDownOptionsTransportationExpenseCode.size(), 5, driver, _drpDownOptionsTransportationExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES, _drpDownTransportationExpenseCode, _drpDownOptionsTransportationExpenseCode, _drpDownSelectedOptionsTransportationExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeTransportation(randExpenseCodeOptions);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	public void verifyAndFillFlatAmtPerNightTextBoxAndCurrencyDrpDown(PDT_AddNewPolicyPage addNewPolicyPage,
			String subBenefitFormName) {
		try {
			if (_drpDownMaxAmtSelectedOption.getText().equalsIgnoreCase(PDTConstants.FLAT_AMT_PER_NIGHT)
					&& CoreFunctions.isElementExist(driver, _txtBoxNumOfNightsPerTrip, 1)
							& CoreFunctions.isElementExist(driver, _drpDownCurrencyCode, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.FLAT_AMT_PER_NIGHT, subBenefitFormName));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.CURRENCY, subBenefitFormName));
				CoreFunctions.clickElement(driver, _txtBoxFlatAmtPerNight);
				CoreFunctions.clearAndSetText(driver, _txtBoxFlatAmtPerNight, _lblFlatAmount.getText(),
						houseHuntingTripBenefitData.houseHuntingTripLodging.flatAmtPerNight);
				CoreFunctions.clickElement(driver, _drpDownCurrencyCode);
				CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyCodeOptions,
						houseHuntingTripBenefitData.houseHuntingTripLodging.currencyCode, _lblCurrency.getText(),
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(PDTConstants.FAILED_TO_FILL_FIELD_VALUES);
		}
	}

	/**
	 * Fill House Hunting Trip Lodging form.
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillHouseHuntingTripLodgingForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxNumOfNightsPerTrip,
					_lblNumOfNightsPerTrip.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxNumOfNightsPerTrip, _lblNumOfNightsPerTrip.getText(),
					houseHuntingTripBenefitData.houseHuntingTripLodging.numberOfNightsPerTrip);
			CoreFunctions.clickElement(driver, _drpDownMaxAmt);
			String randMaxAmtOptions = _drpDownMaxAmtOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownMaxAmtOptions.size() - 1)).getText();
			
			CoreFunctions.selectItemInListByText(driver, _drpDownMaxAmtOptions, randMaxAmtOptions, _lblMaxAmt.getText(),
					PDTConstants.DROP_DOWN, true);
			
			setMaxAmtHouseHuntingTripLodging(randMaxAmtOptions);			
			verifyAndFillFlatAmtPerNightTextBoxAndCurrencyDrpDown(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHouseHuntingTripLodging);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripLodging,
					houseHuntingTripBenefitData.houseHuntingTripLodging.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripLodging,
					houseHuntingTripBenefitData.houseHuntingTripLodging.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					houseHuntingTripBenefitData.houseHuntingTripLodging.reimbursedBy,
					_txtBoxHouseHuntingTripLodgingReimbursedByOther,
					houseHuntingTripBenefitData.houseHuntingTripLodging.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaHouseHuntingTripLodgingComment, PDTConstants.COMMENT,
					houseHuntingTripBenefitData.houseHuntingTripLodging.comment);
			
			CoreFunctions.clickElement(driver, _drpDownLodgingExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.HOUSE_HUNTING_TRIP, PDTConstants.HOUSE_HUNTING_TRIP_LODGING,
							_drpDownOptionsLodgingExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.HOUSE_HUNTING_TRIP_LODGING, DbFunctions.getExpenseCodeListForBenefit(PDTConstants.HOUSE_HUNTING_TRIP).toString(), CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsLodgingExpenseCode).toString()));
			ArrayList <String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0, _drpDownOptionsLodgingExpenseCode.size(), 5, driver, _drpDownOptionsLodgingExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES, _drpDownLodgingExpenseCode, _drpDownOptionsLodgingExpenseCode, _drpDownSelectedOptionsLodgingExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeLodging(randExpenseCodeOptions);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}

	}

	public void checkIfFlatAmtIsSelected(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (_drpDownMaxAmountSelectedVal.getText().equalsIgnoreCase(PDTConstants.FLAT_AMT)) {
				verifyAndFillTransfereeMealInfo(addNewPolicyPage, subBenefitFormName);
				verifyAndFillAdultMealInfo(addNewPolicyPage, subBenefitFormName);
				verifyAndFillChildMealInfo(addNewPolicyPage, subBenefitFormName);
			}
		} catch(Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_SELECTED_VAL, CoreConstants.FAIL, PDTConstants.FLAT_AMT));
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
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtTransferee);
				CoreFunctions.selectItemInListByText(driver, _radioDetailTransfereeCode,
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtTransfereeDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownTransfereeCurrency);
				CoreFunctions.selectItemInListByText(driver, _drpDownTransfereeCurrencyOptions,
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtTransfereeCurrency,
						PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
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
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtAdult);
				CoreFunctions.selectItemInListByText(driver, _radioDetailAdult,
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtAdultDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownAdultCurrency);
				CoreFunctions.selectItemInListByText(driver, _drpDownAdultCurrencyOptions,
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtAdultCurrency, PDTConstants.CURRENCY,
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
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
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtChild);
				CoreFunctions.selectItemInListByText(driver, _radioDetailChild,
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtChildDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownCurrencyCodeChild);
				CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyCodeChildOptions,
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtChildCurrency, PDTConstants.CURRENCY,
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	/**
	 * Fill House Hunting Trip Meal form.
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillHouseHuntingTripMealForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxDurationPerTrip,
					_lblDurationPerTrip.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxDurationPerTrip, _lblDurationPerTrip.getText(),
					houseHuntingTripBenefitData.houseHuntingTripMeals.durationPerTripDays);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripMeals,
					houseHuntingTripBenefitData.houseHuntingTripMeals.mealTypeCode, _lblType.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);

			CoreFunctions.clickElement(driver, _drpDownMaxAmount);
			String randMaxAmtTripMeals = _drpDownMaxAmountOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownMaxAmountOptions.size() - 1)).getText();			
			CoreFunctions.selectItemInListByText(driver, _drpDownMaxAmountOptions, randMaxAmtTripMeals,
					_lblMaxAmtHouseHuntingTripMeals.getText(), PDTConstants.DROP_DOWN, true);
			
			setMaxAmtHouseHuntingTripMeals(randMaxAmtTripMeals);
			checkIfFlatAmtIsSelected(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHouseHuntingTripMeals);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripMeals,
					houseHuntingTripBenefitData.houseHuntingTripMeals.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripMeals,
					houseHuntingTripBenefitData.houseHuntingTripMeals.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					houseHuntingTripBenefitData.houseHuntingTripMeals.reimbursedBy,
					_txtBoxHouseHuntingTripReimbursedByOther,
					houseHuntingTripBenefitData.houseHuntingTripMeals.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaHouseHuntingTripMealComment, PDTConstants.COMMENT,
					houseHuntingTripBenefitData.houseHuntingTripMeals.comment);
			
			CoreFunctions.clickElement(driver, _drpDownMealsExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.HOUSE_HUNTING_TRIP, PDTConstants.HOUSE_HUNTING_TRIP_MEALS,
							_drpDownOptionsMealsExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.HOUSE_HUNTING_TRIP_MEALS, DbFunctions.getExpenseCodeListForBenefit(PDTConstants.HOUSE_HUNTING_TRIP).toString(), CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsMealsExpenseCode).toString()));
			ArrayList <String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0, _drpDownOptionsMealsExpenseCode.size(), 5, driver, _drpDownOptionsMealsExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES, _drpDownMealsExpenseCode, _drpDownOptionsMealsExpenseCode, _drpDownSelectedOptionsMealsExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeMeals(randExpenseCodeOptions);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	/**
	 * Fill House Hunting Trip sub-benefit based on sub-benefit name 
	 * @param subBenefit
	 * @param pageName
	 * @param addNewPolicyPage
	 */
	public void fillHouseHuntinTripSubBenefit(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefitPage subBenefitPage, PDT_SharedSubBenefit_Steps objStep) {		
		switch (subBenefit) {
		case PDTConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION:
			fillHouseHuntingTripTransportationForm(addNewPolicyPage, subBenefit, pageName, objStep);
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP_LODGING:
			fillHouseHuntingTripLodgingForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP_MEALS:
			fillHouseHuntingTripMealForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP_RENTAL_CAR:
			fillHouseHuntingTripRentalCar(addNewPolicyPage, subBenefit, pageName, objStep);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}		
	}
	
	/**
	 * Iterate House Hunting sub-benefits and fill their corresponding form.
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage 
	 */
	public void iterateAndFillHouseHuntingSubBenefits(String pageName, List<String> subBenefits,
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
			fillHouseHuntinTripSubBenefit(subBenefit, pageName, addNewPolicyPage, subBenefitPage, objStep);
		}
		try {
			CoreFunctions.click(driver, btnToClick, btnToClick.getText());
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}
	}
	
	public void verifyAndFillDistanceOptionsField(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
					.contains(PDTConstants.DISTANCE)) {

				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
						.verifyElementPresentOnPage(_lblDistance, PDTConstants.LABEL, PDTConstants.DISTANCE), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.DISTANCE));
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
						.verifyElementPresentOnPage(_txtBoxDistance, PDTConstants.TEXTBOX, PDTConstants.DISTANCE), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, PDTConstants.DISTANCE));
				// Boundary check for distance textbox
				String random9DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(9);
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
		List<String> economyAirFareUnit = new ArrayList<String>();
		try {
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
					.contains(PDTConstants.ECONOMY_CLASS_AIRFARE)) {
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
						_lblEconomyClassAirFareUnit, PDTConstants.LABEL, PDTConstants.ECONOMY_CLASS_AIRFARE), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.ECONOMY_CLASS_AIRFARE_UNIT));
				sharedSubBenefitStep.getCustomSoftAssertObj()
						.assertTrue(CoreFunctions.verifyElementPresentOnPage(_drpDownEconomyClassAirfareUnit,
								PDTConstants.DROP_DOWN, PDTConstants.ECONOMY_CLASS_AIRFARE_UNIT), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.DROP_DOWN, PDTConstants.ECONOMY_CLASS_AIRFARE_UNIT));

				CoreFunctions.clickElement(driver, _drpDownEconomyClassAirfareUnit);
				economyAirFareUnit = CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsEconomyClassAirfareUnit);
				
				for (String option : economyAirFareUnit) {					
					CoreFunctions.clickElement(driver, _drpDownEconomyClassAirfareUnit);
					CoreFunctions.selectItemInListByText(driver, _drpDownOptionsEconomyClassAirfareUnit,
							option, _lblEconomyClassAirFareUnit.getText(), PDTConstants.DROP_DOWN, true);
					verifyKmMilesHours(sharedSubBenefitStep, option, PDTConstants.ECONOMY_CLASS_AIRFARE);
				}
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify Economy Class AirFare options field");
		}
	}
	
	public void verifyKmMilesHours(PDT_SharedSubBenefit_Steps sharedSubBenefitStep, String option, String transportationType) {
		if (option.equalsIgnoreCase(PDTConstants.KM)
				|| option.equalsIgnoreCase(PDTConstants.MI)) {
			verifyKmMiles(sharedSubBenefitStep, transportationType);
		} else if (option.equalsIgnoreCase(PDTConstants.HOURS)) {
			verifyHours(sharedSubBenefitStep, transportationType);
		} else {
			Assert.fail("Not a valid option for Business Air Travel");
		}
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
			
			if(lblMinDistance.equals(null) || txtBoxMinDistance.equals(null)){
				Assert.fail("Verification of Km & Miles is not applicable for "+transportationType+" transportation type.");
			}
			sharedSubBenefitStep.getCustomSoftAssertObj()
			.assertTrue(CoreFunctions.verifyElementPresentOnPage(lblMinDistance,
					PDTConstants.LABEL, lblMinDistance.getText()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, lblMinDistance.getText()));
			
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
					txtBoxMinDistance, PDTConstants.TEXTBOX, lblMinDistance.getText()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, lblMinDistance.getText()));
		
			// Boundary check for Min Distance Business textbox
			String random9DigitStr=CoreFunctions.generateRandomNumberAsGivenLength(9);
			String random10DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(10);
			
			CoreFunctions.clickElement(driver, txtBoxMinDistance);
			CoreFunctions.clearAndSetText(driver, txtBoxMinDistance, lblMinDistance.getText(), random9DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(txtBoxMinDistance, "value"), random9DigitStr, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, random9DigitStr.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE_BUS_AIR_TRAVEL)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, random9DigitStr.length(), CoreFunctions.getAttributeText(txtBoxMinDistance, "value"), random9DigitStr));
			
			CoreFunctions.clearAndSetText(driver, txtBoxMinDistance, lblMinDistance.getText(), PDTConstants.ELEVEN_DIGIT_STRING);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(txtBoxMinDistance, "value"), PDTConstants.ELEVEN_DIGIT_STRING, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, PDTConstants.ELEVEN_DIGIT_STRING.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE_BUS_AIR_TRAVEL)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, PDTConstants.ELEVEN_DIGIT_STRING.length(), CoreFunctions.getAttributeText(txtBoxMinDistance, "value"),PDTConstants.ELEVEN_DIGIT_STRING));
			
			CoreFunctions.clearAndSetText(driver, txtBoxMinDistance, lblMinDistance.getText(), random10DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(txtBoxMinDistance, "value"), random10DigitStr, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, random10DigitStr.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_DISTANCE_BUS_AIR_TRAVEL)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_DISTANCE_FOR_BUSINESS_AIR_TRAVEL, random10DigitStr.length(), CoreFunctions.getAttributeText(txtBoxMinDistance, "value"), random10DigitStr));
		} catch(Exception e) {
			Assert.fail("Failed to verify Min. Distance for "+transportationType+".");
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
			
			if(lblMinTime.equals(null) || txtBoxMinTime.equals(null)){
				Assert.fail("Verification of Hours is not applicable for "+transportationType+" transportation type.");
			}
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
					lblMinTime, PDTConstants.LABEL, lblMinTime.getText()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, lblMinTime.getText()));
			
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
					txtBoxMinTime, PDTConstants.TEXTBOX, lblMinTime.getText()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, lblMinTime.getText()));
			
			// Boundary check for Min Distance Business textbox
			String random2DigitStr=CoreFunctions.generateRandomNumberAsGivenLength(2);
			String random3DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(3);
			
			CoreFunctions.clickElement(driver, txtBoxMinTime);
			CoreFunctions.clearAndSetText(driver, txtBoxMinTime, lblMinTime.getText(), random2DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(txtBoxMinTime, "value"), random2DigitStr, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, random2DigitStr.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_BUS_AIR_TRAVEL_INHRS)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, random2DigitStr.length(), CoreFunctions.getAttributeText(txtBoxMinTime, "value"), random2DigitStr));
			
			CoreFunctions.clearAndSetText(driver, txtBoxMinTime, lblMinTime.getText(), PDTConstants.FOUR_DIGIT_STRING);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(txtBoxMinTime, "value"), PDTConstants.FOUR_DIGIT_STRING, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, PDTConstants.FOUR_DIGIT_STRING.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_BUS_AIR_TRAVEL_INHRS)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHAR, CoreConstants.FAIL, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, PDTConstants.FOUR_DIGIT_STRING.length(), CoreFunctions.getAttributeText(txtBoxMinTime, "value"),PDTConstants.FOUR_DIGIT_STRING));
			
			CoreFunctions.clearAndSetText(driver, txtBoxMinTime, lblMinTime.getText(), random3DigitStr);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyTextForMaxLength(CoreFunctions.getAttributeText(txtBoxMinTime, "value"), random3DigitStr, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, random3DigitStr.length(), Integer.valueOf(PDTConstants.MAX_LENGTH_FOR_BUS_AIR_TRAVEL_INHRS)), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_FIELD_ACCEPTING_MAX_CHARACTERS, CoreConstants.FAIL, PDTConstants.MIN_TIME_FOR_BUSINESS_AIR_TRAVEL_IN_HOURS, random3DigitStr.length(), CoreFunctions.getAttributeText(txtBoxMinTime, "value"), random3DigitStr));
			
			
		} catch(Exception e) {
			Assert.fail("Failed to verify Hours for Business Air Travel.");
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
					verifyKmMilesHours(sharedSubBenefitStep, option, PDTConstants.BUSINESS_CLASS_AIRFARE);
				}
			}
		} catch (Exception e) {			
			Assert.fail("Failed to verify Economy Class AirFare options field");
		}
	}
	
	public boolean verifyHouseHuntingSubBenefitForTransportType(String pageName, String subBenefit,
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
			result = verifyHouseHuntingTripTransportationOptions(subBenefit, pageName, resultTable);
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
	
	public boolean verifyHouseHuntingTripTransportationOptions(String subBenefitFormName,
			String pageName, DataTable resultTable) {
		boolean result = false;
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxNumOfTrips, _lblNoOfTrips.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxNumOfTrips, _lblNoOfTrips.getText(),
					houseHuntingTripBenefitData.houseHuntingTripTransportation.numberOfTrips);

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
	
	public boolean verifyBusinessClassForVisibilty(Map<String, String> resultTableMap, String benefitCategory, String benefit) {
		boolean result = false;
		ArrayList<Boolean> resultElementVisible = new ArrayList<Boolean>();
		List<String> businessAirFareUnit = new ArrayList<String>();
		List<String> expectedBusinessAirFareUnit = new ArrayList<String>();
		expectedBusinessAirFareUnit.add(PDTConstants.KM);
		expectedBusinessAirFareUnit.add(PDTConstants.MI);
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
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DRPDOWN_OPTION, CoreConstants.PASS, businessAirFareUnit, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
				resultElementVisible.add(true);
			} else {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_DRPDOWN_OPTION, CoreConstants.FAIL, expectedBusinessAirFareUnit, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
				resultElementVisible.add(false);
			}
			
			for (String option : businessAirFareUnit) {					
				CoreFunctions.clickElement(driver, _drpDownBusinessClassAirfareUnit);
				CoreFunctions.selectItemInListByText(driver, _drpDownOptionsBusinessClassAirfareUnit,
						option, _lblBusinessClassAirFareUnit.getText(), PDTConstants.DROP_DOWN, true);
				resultElementVisible.add(verifyKmMilesHoursForVisibility(option, resultTableMap.get("Transportation_Type_Option")));
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
			Assert.fail("Exception occured while trying to verify Business Class fields for invisibilty after deselecting the Business Class Airfare option from Transportation Type dropdown.");
		}
		result = resultElementInVisible.stream().allMatch(t -> t.equals(true)) ? true : false;		
		printMessageForFieldInVisibility(result, resultTableMap.get("Transportation_Type_Option"), benefitCategory, benefit);
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
		if (option.equalsIgnoreCase(PDTConstants.KM)
				|| option.equalsIgnoreCase(PDTConstants.MI) || option.equalsIgnoreCase(PDTConstants.MILES)) {
			result = verifyKmMilesForVisibility(transportTypeOption);
		} else if (option.equalsIgnoreCase(PDTConstants.HOURS)) {
			result = verifyHoursForVisibility(transportTypeOption);
		} else {
			Assert.fail("Not a valid option for Business Air Travel");
		}
		return result;
	}
	
	public void verifyAndFillMaxAmtIfExcessBaggageIsYes() {
		int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _lblRadioOptionsExcessBaggageFees, "Yes");		
		//For debugging purpose 
		if(_radioButtonExcessBaggageFees.get(index).getAttribute("checked").equalsIgnoreCase("true")) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_EXCESS_BAGGAGE_CHOSEN, CoreConstants.PASS, _lblRadioOptionsExcessBaggageFees.get(0).getText()));
			verifyAndFillMaxAmt();
			verifyCurrencyFieldIsDisplayed();
		}
		
	}
	
	public void verifyAndFillMaxAmt() {
		if(CoreFunctions.verifyElementPresentOnPage(_txtBoxMaxAmountPerPerson, PDTConstants.TEXTBOX, _lblMaxAmtPerPerson.getText())) {
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmountPerPerson, _lblMaxAmtPerPerson.getText(),
					houseHuntingTripBenefitData.houseHuntingTripTransportation.maxAmtPerPerson);
		} else {
			Assert.fail("Max Amount per person field not persent on page.");
		}
	}
	
	public void verifyCurrencyFieldIsDisplayed() {
		if(CoreFunctions.verifyElementPresentOnPage(_drpDownExcessBaggageCurrencyCode, PDTConstants.DROP_DOWN, _lblCurrencyCode.getText())) {
			verifyDefaultUSCurrencySelected();
		} else {
			Assert.fail("Failed Currency field not persent on page.");
		}
	}
	
	public void verifyDefaultUSCurrencySelected() {
		if(_currencyOptionSelected.getText().trim().equalsIgnoreCase("U.S. Dollar")) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DEFAULT_CURRENCY, CoreConstants.PASS, _currencyOptionSelected.getText().trim()));
		}
		else {
			Assert.fail("Failed to verify default selected currency is U.S. Dollar. Actual currency selected is "+_currencyOptionSelected.getText());
		}
	}
	
	public void fillHouseHuntingTripRentalCar(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
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
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROPDOWN, CoreConstants.PASS, _lblSizeClass.getText(), getExpectedSizeClassList().toString()));
			}
			String randSizeClass = _drpDownOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownOptions.size() - 1))
					.getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownOptions,
					randSizeClass, _lblSizeClass.getText(), PDTConstants.DROP_DOWN, true);
			setSizeClass(randSizeClass);
			
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					houseHuntingTripBenefitData.houseHuntingTripRentalCar.sizeClass,
					_txtBoxOtherSizeClass,
					houseHuntingTripBenefitData.houseHuntingTripRentalCar.otherSizeClass, subBenefitFormName,
					PDTConstants.SIZE_CLASS_OTHER);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnGrossUpPreTripRentalCar);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUpPreTripRentalCar,
					houseHuntingTripBenefitData.houseHuntingTripRentalCar.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			
			
			CoreFunctions.selectItemInListByText(driver, _radioBtnReimbursedByPreTripRentalCar,
					houseHuntingTripBenefitData.houseHuntingTripRentalCar.reimbursedBy,
					PDTConstants.REIMBURSED_BY, PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					houseHuntingTripBenefitData.houseHuntingTripRentalCar.reimbursedBy,
					_txtBoxReimbursedByOtherPreTripRentalCar,
					houseHuntingTripBenefitData.houseHuntingTripRentalCar.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _textAreaBenefitCommentTripRentalCar, PDTConstants.COMMENT,
					houseHuntingTripBenefitData.houseHuntingTripRentalCar.comment);

			CoreFunctions.clickElement(driver, _drpDownRentalCarExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.HOUSE_HUNTING_TRIP, PDTConstants.HOUSE_HUNTING_TRIP_RENTAL_CAR,
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
