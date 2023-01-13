package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
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
import com.aires.testdatatypes.pdt.PDT_PreAcceptanceServiceBenefit;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_PreAcceptanceService extends PDT_SharedSubBenefitPage {
	public PDT_PreAcceptanceService(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;

	@FindBy(how = How.CSS, using = "div#headingOne > div.displayHeaderSection >h5")
	private WebElement _headingFormCandSel;

	@FindBy(how = How.CSS, using = "div#headingTwo > div.displayHeaderSection >h5")
	private WebElement _headingFormPreTripTransport;

	@FindBy(how = How.CSS, using = "div#headingThree > div.displayHeaderSection >h5")
	private WebElement _headingFormPreTripLodging;

	@FindBy(how = How.CSS, using = "div#headingFour > div.displayHeaderSection >h5")
	private WebElement _headingFormPreTripMeals;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseOne']")
	private WebElement _formHeaderCandidateSelection;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseTwo']")
	private WebElement _formHeaderPreAcceptanceTripTransportation;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseThree']")
	private WebElement _formHeaderPreAcceptanceTripLodging;

	@FindBy(how = How.CSS, using = "a[data-target='#collapseFour']")
	private WebElement _formHeaderPreAcceptanceTripMeals;

	@FindBy(how = How.CSS, using = "div.displayHeaderSection > h4.card-title")
	private WebElement _benefitCatName;

	@FindBy(how = How.CSS, using = "div.card-header-info > h4.card-title")
	private WebElement _benefitCategoryName;

	@FindBy(how = How.CSS, using = "#collapseOne label.form-check-label")
	private List<WebElement> _radioBtnCandidateSelection;

	@FindBy(how = How.CSS, using = "#collapseOne input[formcontrolname='paidByOther']")
	private WebElement _txtBoxCandidateSelReimbursedByOther;

	@FindBy(how = How.CSS, using = "#collapseOne textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCandidateSelComment;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfTrips']")
	private WebElement _txtBoxNumOfTrips;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='preAcceptanceTransportTypeList']/preceding-sibling::label")
	private WebElement _lblTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportTypeList']")
	private WebElement _drpDownTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportTypeList'] span.ng-option-label")
	private List<WebElement> _drpDownTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportTypeList'] span.ng-value-label")
	private List<WebElement> _drpDownTransportationTypeSelectedOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='transportationTypeOther']")
	private WebElement _txtBoxTransportationTypeOther;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode']")
	private WebElement _drpDownAccompanyingFamilyMemberCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-option-label")
	private List<WebElement> _drpDownAccompanyingFamilyMemberCodeOptions;

	@FindBy(how = How.CSS, using = "#collapseTwo label.form-check-label")
	private List<WebElement> _radioBtnPreTripTransport;

	@FindBy(how = How.CSS, using = "#collapseTwo input[formcontrolname='paidByOther']")
	private WebElement _txtBoxPreTripTransportReimbursedByOther;

	@FindBy(how = How.CSS, using = "#collapseTwo textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaPreTripTransportComment;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfNightsPerTrip']")
	private WebElement _txtBoxNumOfNightsPerTrip;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode']")
	private WebElement _drpDownMaxAmt;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode'] span.ng-option-label")
	private List<WebElement> _drpDownMaxAmtOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode'] span.ng-value-label")
	private WebElement _drpDownMaxAmtSelectedOption;

	@FindBy(how = How.CSS, using = "input[formcontrolname='flatAmount']")
	private WebElement _txtBoxFlatAmtPerNight;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrencyCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyCodeOptions;

	@FindBy(how = How.CSS, using = "#collapseThree label.form-check-label")
	private List<WebElement> _radioBtnPreTripLodging;

	@FindBy(how = How.CSS, using = "app-pre-trip-lodging input[formcontrolname='paidByOther']")
	private WebElement _txtBoxPreTripLodgingReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-pre-trip-lodging textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaPreTripLodgingComment;

	@FindBy(how = How.CSS, using = "#collapseFour input[formcontrolname='numOfDays']")
	private WebElement _txtBoxNumOfDaysPerMeal;

	@FindBy(how = How.CSS, using = "#collapseFour label.form-check-label")
	private List<WebElement> _radioBtnPreAcceptanceTripMeals;

	@FindBy(how = How.CSS, using = "#collapseFour ng-select[formcontrolname='maxAmountCode']")
	private WebElement _drpDownMaxAmount;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode'] span.ng-option-label")
	private List<WebElement> _drpDownMaxAmountOptions;

	@FindBy(how = How.XPATH, using = "//app-pre-trip-meals//ng-select[@formcontrolname='maxAmountCode']/descendant::span[contains(@class,'ng-value-label')]")
	private WebElement _drpDownMaxAmountSelectedVal;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountEe']")
	private WebElement _txtBoxMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioDetailTransfereeCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe']")
	private WebElement _drpDownTransfereeCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe'] span.ng-option-label")
	private List<WebElement> _drpDownTransfereeCurrencyOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountAdult']")
	private WebElement _txtBoxMaxAmtAdult;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailAdultCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioDetailAdult;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult']")
	private WebElement _drpDownAdultCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult'] span.ng-option-label")
	private List<WebElement> _drpDownAdultCurrencyOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountChild']")
	private WebElement _txtBoxMaxAmtChild;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailChildCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioDetailChild;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild']")
	private WebElement _drpDownCurrencyCodeChild;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyCodeChildOptions;

	@FindBy(how = How.CSS, using = "#collapseFour label.form-check-label")
	private List<WebElement> _radioBtnPreTripMeal;

	@FindBy(how = How.CSS, using = "app-pre-trip-meals input[formcontrolname='paidByOther']")
	private WebElement _txtBoxPreTripMealReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-pre-trip-meals textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaPreTripMealComment;

	@FindBy(how = How.XPATH, using = "//label[text()='Number of Trips']")
	private WebElement _lblNoOfTrips;

	@FindBy(how = How.XPATH, using = "//label[text()='Transportation Other']")
	private WebElement _lblTransportationOther;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minMileageEconomy']/preceding-sibling::label")
	private WebElement _lblMinMileageForEconomyAirTravel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minMileageBusiness']/preceding-sibling::label")
	private WebElement _lblMinMileageForBusinessAirTravel;

	@FindBy(how = How.XPATH, using = "//label[text()='Accompanying Family Member']")
	private WebElement _lblAccompanyingFamilyMember;

	@FindBy(how = How.XPATH, using = "//label[text()='Number of Nights per Trip']")
	private WebElement _lblNumOfNightsPerTrip;

	@FindBy(how = How.XPATH, using = "//app-pre-trip-lodging//label[contains(text(), 'Max Amount')]")
	private WebElement _lblMaxAmt;

	@FindBy(how = How.XPATH, using = "//app-pre-trip-lodging//label[contains(text(), 'Flat Amount/Night')]")
	private WebElement _lblFlatAmount;

	@FindBy(how = How.XPATH, using = "//label[text()='Currency']")
	private WebElement _lblCurrency;

	@FindBy(how = How.XPATH, using = "//label[text()='Number of Days for Meals']")
	private WebElement _lblNumOfDayPerMeal;

	@FindBy(how = How.XPATH, using = "//label[text()='Type']")
	private WebElement _lblType;

	@FindBy(how = How.XPATH, using = "//app-pre-trip-meals//label[contains(text(), 'Max. Amount')]")
	private WebElement _lblMaxAmtPreAcceptanceTripMeals;

	@FindBy(how = How.XPATH, using = "//app-pre-trip-meals//label[contains(text(), 'Max Amount - Transferee')]")
	private WebElement _lblMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//app-pre-trip-meals//label[contains(text(), 'Other Adults')]")
	private WebElement _lblMaxAmtOtherAdults;

	@FindBy(how = How.XPATH, using = "//app-pre-trip-meals//label[contains(text(), 'Max. Amount - Children')]")
	private WebElement _lblMaxAmtChildren;

	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname, 'candidateSelectionEmpTypeInd')]/parent::label")
	private WebElement _lblCandidateSelEmpType;

	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname, 'candidateSelectionHomeTypeInd')]/parent::label")
	private WebElement _lblCandidateSelHomeOwnerType;

	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname, 'tripTransportationEmpTypeInd')]/parent::label")
	private WebElement _lblPreAcceptTripTransportEmpType;

	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname, 'tripTransportationHomeTypeInd')]/parent::label")
	private WebElement _lblPreAcceptTripTransportHomeOwnerType;

	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname, 'tripLodgingEmpTypeInd')]/parent::label")
	private WebElement _lblPreAcceptTripLodgingEmpType;

	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname, 'tripLodgingHomeTypeInd')]/parent::label")
	private WebElement _lblPreAcceptTripLodgingHomeOwnerType;

	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname, 'tripMealsEmpTypeInd')]/parent::label")
	private WebElement _lblPreAcceptTripMealEmpType;

	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname, 'tripMealsHomeTypeInd')]/parent::label")
	private WebElement _lblPreAcceptTripMealHomeOwnerType;

	@FindBy(how = How.CSS, using = "div.pcard-header > h4.card-title")
	private WebElement _txtSubBenefitName;

	@FindBy(how = How.CSS, using = "div#collapseOne div.mat-tab-label-content")
	private List<WebElement> _tabOnCandidateSelectionForm;

	@FindBy(how = How.CSS, using = "div#collapseTwo div.mat-tab-label-content")
	private List<WebElement> _tabOnPreAcceptanceTripTransportation;

	@FindBy(how = How.CSS, using = "div#collapseThree div.mat-tab-label-content")
	private List<WebElement> _tabOnPreAcceptanceTripLodging;

	@FindBy(how = How.CSS, using = "div#collapseFour div.mat-tab-label-content")
	private List<WebElement> _tabOnPreAcceptanceTripMeals;

	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceCandidateSelectionExpenseCodeList']")
	private WebElement _drpDownCandSelectionExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceCandidateSelectionExpenseCodeList'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownOptionsCandSelectionExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceCandidateSelectionExpenseCodeList'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownSelectedOptionsCandSelectionExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportationExpenseCodeList']")
	private WebElement _drpDownTransportationExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportationExpenseCodeList'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownOptionsTransportationExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportationExpenseCodeList'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownSelectedOptionsTransportationExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceLodgingExpenseCodeList']")
	private WebElement _drpDownTripLodgingExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceLodgingExpenseCodeList'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownOptionsLodgingExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceLodgingExpenseCodeList'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownSelectedOptionsLodgingExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceMealsExpenseCodeList']")
	private WebElement _drpDownTripMealsExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceMealsExpenseCodeList'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownOptionsTripMealsExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceMealsExpenseCodeList'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownSelectedOptionsTripMealsExpenseCode;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='distance']/preceding-sibling::label")
	private WebElement _lblDistance;

	@FindBy(how = How.CSS, using = "input[formcontrolname='distance']")
	private WebElement _txtBoxDistance;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfDistanceCode']/ancestor::div/preceding-sibling::label")
	private WebElement _lblUnitOfDistance;

	@FindBy(how = How.CSS, using = "input[formcontrolname='unitOfDistanceCode']")
	private List<WebElement> _radioBtnUnitOfDistance;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfDistanceCode']/parent::label")
	private List<WebElement> _radioBtnUnitOfDistanceLabel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minDistanceEconomy']/preceding-sibling::label")
	private WebElement _lblMinDistanceForEconomyTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceEconomy']")
	private WebElement _txtBoxMinDistanceEconomy;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfEconomyCode']/ancestor::div/preceding-sibling::label")
	private WebElement _lblUnitOfDistanceForEconomyCode;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='unitOfEconomyCode']/parent::label")
	private List<WebElement> _lblUnitOfDistanceForEconomyAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='unitOfEconomyCode']")
	private List<WebElement> _radioBtnUnitOfDistanceForEconomyCode;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='unitOfBusinessCode']/preceding-sibling::label")
	private WebElement _lblBusinessClassAirFareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfBusinessCode']")
	private WebElement _drpDownBusinessClassAirfareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfBusinessCode'] span.ng-value-label")
	private WebElement _drpDownOptionSelectedBusinessClassAirfareUnit;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfBusinessCode'] span.ng-option-label")
	private List<WebElement> _drpDownOptionsBusinessClassAirfareUnit;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minDistanceBusiness']/preceding-sibling::label")
	private WebElement _lblMinDistanceForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceBusiness']")
	private WebElement _txtBoxMinDistanceForBusinessAirTravel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minTimeBusiness']/preceding-sibling::label")
	private WebElement _lblMinTimeForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minTimeBusiness']")
	private WebElement _txtBoxMinTimeForBusinessAirTravel;
	
	//@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportTypeList'] span.ng-value-icon.left")
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportTypeList'] span[title='Clear all']")
	private WebElement _iconClearTransportationType;	
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfBusinessCode'] span[title='Clear all']")
	private WebElement _iconClearBusinessAirTravel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='excessBaggageFeesInd']/parent::label")
	private List<WebElement> _lblRadioOptionsExcessBaggageFees;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='excessBaggageFeesInd']/parent::label/parent::div/preceding-sibling::label")
	private WebElement _lblExcessBaggageFees;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountPerPerson']")
	private WebElement _txtBoxMaxAmountPerPerson;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='maxAmountPerPerson']/preceding-sibling::label")
	private WebElement _lblMaxAmtPerPerson;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeExcessBagage']")
	private WebElement _drpDownExcessBaggageCurrencyCode;	

	@FindBy(how = How.CSS, using = "span.ng-option-label.ng-star-inserted")
	private WebElement _dropDownOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeExcessBagage'] span.ng-value-label.ng-star-inserted")
	private WebElement _currencyOptionSelected;
	
	@FindBy(how = How.CSS, using = "//ng-select[@formcontrolname='currencyCodeExcessBagage']/preceding-sibling::label")
	private WebElement _lblCurrencyCode;	
	
	final By _subBenefitCategoriesLocator = By.cssSelector("div.form-check > label.form-check-label");

	PDT_PreAcceptanceServiceBenefit preAcceptanceSubBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getPreAcceptanceDataList("Pre-Acceptance Services");

	private String accompanyingFamilyMemeber, maxAmtPreAcceptTripLodging, maxAmtPreAcceptTripMeals;
	private ArrayList<String> _expenseCodeCandSelection = null;
	private ArrayList<String> _expenseCodeTransportation = null;
	private ArrayList<String> _expenseCodeTripLodging = null;
	private ArrayList<String> _expenseCodeTripMeals = null;
	private ArrayList<String> _transportType = null;	
	private List<String> _expectedAccompFamilyMembersList;
	String [] _expectedAccompFamilyMembersArr = new String[] {PDTConstants.TRANSFEREE_ONLY, PDTConstants.TRANSFEREE_AND_FAMILY_MEMBER, PDTConstants.TRANSFEREE_AND_FAMILY};
	

	long timeBeforeAction, timeAfterAction;

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

	public void setMaxAmtPreAcceptTripLodging(String maxAmt) {
		maxAmtPreAcceptTripLodging = maxAmt;
	}

	public String getMaxAmtPreAcceptTripLodging() {
		return maxAmtPreAcceptTripLodging;
	}

	public void setMaxAmtPreAcceptTripMeals(String maxAmt) {
		maxAmtPreAcceptTripMeals = maxAmt;
	}

	public String getMaxAmtPreAcceptTripMeals() {
		return maxAmtPreAcceptTripMeals;
	}

	public void setExpenseCodeCandSelection(ArrayList<String> expenseCode) {
		this._expenseCodeCandSelection = expenseCode;
	}

	public ArrayList<String> getExpenseCodeCandSelection() {
		return _expenseCodeCandSelection;
	}

	public void setExpenseCodeTransportation(ArrayList<String> expenseCode) {
		this._expenseCodeTransportation = expenseCode;
	}

	public ArrayList<String> getExpenseCodeTransportation() {
		return _expenseCodeTransportation;
	}

	public void setExpenseCodeTripLodging(ArrayList<String> expenseCode) {
		this._expenseCodeTripLodging = expenseCode;
	}

	public ArrayList<String> getExpenseCodeTripLodging() {
		return _expenseCodeTripLodging;
	}

	public void setExpenseCodeTripMeals(ArrayList<String> expenseCode) {
		this._expenseCodeTripMeals = expenseCode;
	}

	public ArrayList<String> getExpenseCodeTripMeals() {
		return _expenseCodeTripMeals;
	}
	
	public void setExpectedAccompFamilyMembersList(){
		_expectedAccompFamilyMembersList = Arrays.asList(_expectedAccompFamilyMembersArr);
	}
	
	public List<String> getExpectedAccompFamilyMembersList(){
		return _expectedAccompFamilyMembersList;
	}

	public WebElement getElementByName(String elementName) {
		WebElement element = null;
		populateSubBenefitHeaderMap();
		try {
			element = subBenefitHeaderMap.get(elementName);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return element;
	}

	public void populateTabListMap() {
		tabListMap.put(PDTConstants.CANDIDATE_SELECTION, _tabOnCandidateSelectionForm);
		tabListMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION, _tabOnPreAcceptanceTripTransportation);
		tabListMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING, _tabOnPreAcceptanceTripLodging);
		tabListMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS, _tabOnPreAcceptanceTripMeals);
	}

	public List<WebElement> getTabListByName(String elementName) {
		List<WebElement> element = null;
		populateTabListMap();
		try {
			element = tabListMap.get(elementName);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return element;
	}

	public String getElementText(String elementName, String pageName) {
		String elementText = null;
		switch (elementName) {
		case PDTConstants.HEADING:
			elementText = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES)
					? _benefitCatName.getText()
					: _benefitCategoryName.getText();
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return elementText;
	}

	public boolean verifyFormIsDisplayed(String formName, WebElement element, String pageName) {
		if (element.isDisplayed()) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_DISPLAYED, CoreConstants.PASS,
					formName, pageName));
			return true;
		}
		return false;
	}

	public boolean verifyFormIsHidden(String formName, WebElement element, String pageName) {
		if (!CoreFunctions.isElementExist(driver, element, 1)) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_HIDDEN, CoreConstants.PASS, formName, pageName));
			return true;
		}
		return false;
	}

	public boolean verifySubCategoryHeading(String pageName) {
		if (CoreFunctions.isElementExist(driver, _progressBar, 3))
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		WebElement element = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES) ? _benefitCatName
				: _benefitCategoryName;
		CoreFunctions.explicitWaitTillElementVisibility(driver, element, element.getText());
		return CoreFunctions.verifyElementOnPage(driver, element, PDTConstants.heading, pageName, pageName, true);
	}

	public void selectSubBenefitAndVerifyFormIsDisplayed(DataTable subBenefitTable, String pageName) {
		try {
			CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
			List<String> subBenefits = subBenefitTable.asList(String.class);
			for (String subBenefit : subBenefits) {
				CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
				CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
				Assert.assertTrue(verifyFormIsDisplayed(subBenefit, getElementByName(subBenefit), pageName),
						MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefit, pageName));
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_SUB_BENEFIT, CoreConstants.FAIL));
		}
	}

	public void deselectSubBenefit(DataTable subBenefitTable, String pageName) {
		List<String> subBenefits = subBenefitTable.asList(String.class);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
		}
	}

	public void checkFormIsHidden(DataTable subBenefitTable, String pageName) {
		List<String> subBenefits = subBenefitTable.asList(String.class);
		for (String subBenefit : subBenefits) {
			Assert.assertTrue(verifyFormIsHidden(subBenefit, getElementByName(subBenefit), pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_HIDDEN, subBenefit, pageName));
		}
	}

	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.CANDIDATE_SELECTION, _formHeaderCandidateSelection);
		subBenefitHeaderMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION,
				_formHeaderPreAcceptanceTripTransportation);
		subBenefitHeaderMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING, _formHeaderPreAcceptanceTripLodging);
		subBenefitHeaderMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS, _formHeaderPreAcceptanceTripMeals);
	}

	public void populateSubBenefitHomeOwnerTypeLabelMap() {
		subBenefitHomeOwnerTypeLabelMap.put(PDTConstants.CANDIDATE_SELECTION, _lblCandidateSelHomeOwnerType);
		subBenefitHomeOwnerTypeLabelMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION,
				_lblPreAcceptTripTransportHomeOwnerType);
		subBenefitHomeOwnerTypeLabelMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING,
				_lblPreAcceptTripLodgingHomeOwnerType);
		subBenefitHomeOwnerTypeLabelMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS, _lblPreAcceptTripMealHomeOwnerType);
	}

	public void populateSubBenefitEmpTypeLabelMap() {
		subBenefitEmpTypeLabelMap.put(PDTConstants.CANDIDATE_SELECTION, _lblCandidateSelEmpType);
		subBenefitEmpTypeLabelMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION,
				_lblPreAcceptTripTransportEmpType);
		subBenefitEmpTypeLabelMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING, _lblPreAcceptTripLodgingEmpType);
		subBenefitEmpTypeLabelMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS, _lblPreAcceptTripMealEmpType);
	}

	public void expandSubBenefitIfCollapsed(String subBenefitFormName, WebElement element) {
		if (subBenefitHeaderMap.get(subBenefitFormName).getAttribute("class").equalsIgnoreCase("collapsed"))
			CoreFunctions.clickElement(driver, element);
	}

	public void populateSubBenefitHeadingMap() {
		subBenefitHeadingMap.put(PDTConstants.CANDIDATE_SELECTION, _headingFormCandSel);
		subBenefitHeadingMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION, _headingFormPreTripTransport);
		subBenefitHeadingMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING, _headingFormPreTripLodging);
		subBenefitHeadingMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS, _headingFormPreTripMeals);
	}

	public void fillCandidateSelection(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			expandSubBenefitIfCollapsed(subBenefitFormName, _headingFormCandSel);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnCandidateSelection);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					preAcceptanceSubBenefitData.candidateSelection.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					preAcceptanceSubBenefitData.candidateSelection.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					preAcceptanceSubBenefitData.candidateSelection.reimbursedBy, _txtBoxCandidateSelReimbursedByOther,
					preAcceptanceSubBenefitData.candidateSelection.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaCandidateSelComment, PDTConstants.COMMENT,
					preAcceptanceSubBenefitData.candidateSelection.comment);

			CoreFunctions.clickElement(driver, _drpDownCandSelectionExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.PRE_ACCEPTANCE_SERVICES, PDTConstants.CANDIDATE_SELECTION,
							_drpDownOptionsCandSelectionExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.CANDIDATE_SELECTION,
							DbFunctions.getExpenseCodeListForBenefit(PDTConstants.PRE_ACCEPTANCE_SERVICES).toString(),
							CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsCandSelectionExpenseCode)
									.toString()));
			ArrayList<String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownOptionsCandSelectionExpenseCode.size(), 5, driver, _drpDownOptionsCandSelectionExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES,
					_drpDownCandSelectionExpenseCode, _drpDownOptionsCandSelectionExpenseCode,
					_drpDownSelectedOptionsCandSelectionExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeCandSelection(randExpenseCodeOptions);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
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
					_drpDownTransportationTypeSelectedOptions, randTransportTypeOption, subBenefitFormName);
			setTransportType(randTransportTypeOption);
			verifyAndFillDistanceOptionsField(objStep);
			verifyAndFillEconomyAirTravelField(objStep);
			verifyAndFillBusinessAirTravelField(objStep);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL,
					_lblTransportationType.getText(), subBenefitFormName));
		}
	}

	public void fillPreAcceptanceTripTransportation(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String pageName, PDT_SharedSubBenefit_Steps objStep) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			expandSubBenefitIfCollapsed(subBenefitFormName, _headingFormPreTripTransport);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxNumOfTrips, _lblNoOfTrips.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxNumOfTrips, _lblNoOfTrips.getText(),
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.numberOfTrips);

			selectAllTransportTypeOptions(addNewPolicyPage, subBenefitFormName, objStep);

			setExpectedAccompFamilyMembersList();
			CoreFunctions.clickElement(driver, _drpDownAccompanyingFamilyMemberCode);
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownAccompanyingFamilyMemberCodeOptions)
					.equals(getExpectedAccompFamilyMembersList())) {
				Reporter.addStepLog("Verified Accompanying Family Members drop down contains "+ getExpectedAccompFamilyMembersList().toString()+" options");
			}
			String randAccompanyingFamilMember = _drpDownAccompanyingFamilyMemberCodeOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownAccompanyingFamilyMemberCodeOptions.size() - 1))
					.getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownAccompanyingFamilyMemberCodeOptions,
					randAccompanyingFamilMember, _lblAccompanyingFamilyMember.getText(), PDTConstants.DROP_DOWN, true);
			setAccompanyingFamilyMember(randAccompanyingFamilMember);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnPreTripTransport);
			CoreFunctions.selectItemInListByText(driver, _radioBtnPreTripTransport,
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			
			/*CoreFunctions.selectItemInListByText(driver, _lblRadioOptionsExcessBaggageFees,
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.excessBaggageFees, _lblExcessBaggageFees.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);*/
			
			CoreFunctions.selectItemInListByText(driver, _radioBtnPreTripTransport,
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.reimbursedBy,
					PDTConstants.REIMBURSED_BY, PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.reimbursedBy,
					_txtBoxPreTripTransportReimbursedByOther,
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaPreTripTransportComment, PDTConstants.COMMENT,
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.comment);

			CoreFunctions.clickElement(driver, _drpDownTransportationExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.PRE_ACCEPTANCE_SERVICES, PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION,
							_drpDownOptionsTransportationExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION,
							DbFunctions.getExpenseCodeListForBenefit(PDTConstants.PRE_ACCEPTANCE_SERVICES).toString(),
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
	
	public void verifyAndFillMaxAmtIfExcessBaggageIsYes() {
		int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _lblRadioOptionsExcessBaggageFees, "Yes");		
		//For debugging purpose Log.info("DomProperty=="+_inputBenefitCategory.get(index).getDomProperty("checked"));
		if(_lblRadioOptionsExcessBaggageFees.get(index).getAttribute("checked").equalsIgnoreCase("true")) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_EXCESS_BAGGAGE_CHOSEN, CoreConstants.PASS, _lblRadioOptionsExcessBaggageFees.get(0).getText()));
			verifyAndFillMaxAmt();
			verifyCurrencyFieldIsDisplayed();
		}
		
	}
	
	public void verifyAndFillMaxAmt() {
		if(CoreFunctions.verifyElementPresentOnPage(_txtBoxMaxAmountPerPerson, PDTConstants.TEXTBOX, _lblMaxAmtPerPerson.getText())) {
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmountPerPerson, _lblMaxAmtPerPerson.getText(),
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.maxAmtPerPerson);
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
			Reporter.addStepLog("Verified default currency selected is "+_currencyOptionSelected.getText().trim());
		}
		else {
			Assert.fail("Failed to verify default selected currency is U.S. Dollar. Actual currency selected is "+_currencyOptionSelected.getText());
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
				CoreFunctions.clearAndSetText(driver, _txtBoxFlatAmtPerNight, _lblFlatAmount.getText(),
						preAcceptanceSubBenefitData.preAcceptanceTripLodging.flatAmtPerNight);
				CoreFunctions.clickElement(driver, _drpDownCurrencyCode);
				CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyCodeOptions,
						preAcceptanceSubBenefitData.preAcceptanceTripLodging.currencyCode, _lblCurrency.getText(),
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(PDTConstants.FAILED_TO_FILL_FIELD_VALUES);
		}
	}

	public void fillPreAcceptanceTripLodging(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			expandSubBenefitIfCollapsed(subBenefitFormName, _headingFormPreTripLodging);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxNumOfNightsPerTrip,
					_lblNumOfNightsPerTrip.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxNumOfNightsPerTrip, _lblNumOfNightsPerTrip.getText(),
					preAcceptanceSubBenefitData.preAcceptanceTripLodging.numberOfNightsPerTrip);
			CoreFunctions.clickElement(driver, _drpDownMaxAmt);
			String randMaxAmtOptions = _drpDownMaxAmtOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownMaxAmtOptions.size() - 1)).getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownMaxAmtOptions, randMaxAmtOptions, _lblMaxAmt.getText(),
					PDTConstants.DROP_DOWN, true);
			setMaxAmtPreAcceptTripLodging(randMaxAmtOptions);
			verifyAndFillFlatAmtPerNightTextBoxAndCurrencyDrpDown(addNewPolicyPage, subBenefitFormName);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnPreTripLodging);
			CoreFunctions.selectItemInListByText(driver, _radioBtnPreTripLodging,
					preAcceptanceSubBenefitData.preAcceptanceTripLodging.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnPreTripLodging,
					preAcceptanceSubBenefitData.preAcceptanceTripLodging.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					preAcceptanceSubBenefitData.preAcceptanceTripLodging.reimbursedBy,
					_txtBoxPreTripLodgingReimbursedByOther,
					preAcceptanceSubBenefitData.preAcceptanceTripLodging.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaPreTripLodgingComment, PDTConstants.COMMENT,
					preAcceptanceSubBenefitData.preAcceptanceTripLodging.comment);

			CoreFunctions.clickElement(driver, _drpDownTripLodgingExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.PRE_ACCEPTANCE_SERVICES, PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING,
							_drpDownOptionsLodgingExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING,
							DbFunctions.getExpenseCodeListForBenefit(PDTConstants.PRE_ACCEPTANCE_SERVICES).toString(),
							CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsLodgingExpenseCode)
									.toString()));
			ArrayList<String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownOptionsLodgingExpenseCode.size(), 5, driver, _drpDownOptionsLodgingExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES,
					_drpDownTripLodgingExpenseCode, _drpDownOptionsLodgingExpenseCode,
					_drpDownSelectedOptionsLodgingExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeTripLodging(randExpenseCodeOptions);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}

	}

	public void fillPreAcceptanceTripMeals(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			expandSubBenefitIfCollapsed(subBenefitFormName, _headingFormPreTripMeals);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxNumOfDaysPerMeal,
					_lblNumOfDayPerMeal.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxNumOfDaysPerMeal, _lblNumOfDayPerMeal.getText(),
					preAcceptanceSubBenefitData.preAcceptanceTripMeals.numberOfDaysPerMeal);
			CoreFunctions.selectItemInListByText(driver, _radioBtnPreAcceptanceTripMeals,
					preAcceptanceSubBenefitData.preAcceptanceTripMeals.mealTypeCode, _lblType.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);

			CoreFunctions.clickElement(driver, _drpDownMaxAmount);
			String randMaxAmtTripMeals = _drpDownMaxAmountOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownMaxAmountOptions.size() - 1)).getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownMaxAmountOptions, randMaxAmtTripMeals,
					_lblMaxAmtPreAcceptanceTripMeals.getText(), PDTConstants.DROP_DOWN, true);
			setMaxAmtPreAcceptTripMeals(randMaxAmtTripMeals);
			checkIfFlatAmtIsSelected(addNewPolicyPage, subBenefitFormName);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnPreAcceptanceTripMeals);
			CoreFunctions.selectItemInListByText(driver, _radioBtnPreAcceptanceTripMeals,
					preAcceptanceSubBenefitData.preAcceptanceTripMeals.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnPreAcceptanceTripMeals,
					preAcceptanceSubBenefitData.preAcceptanceTripMeals.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					preAcceptanceSubBenefitData.preAcceptanceTripMeals.reimbursedBy,
					_txtBoxPreTripMealReimbursedByOther,
					preAcceptanceSubBenefitData.preAcceptanceTripMeals.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaPreTripMealComment, PDTConstants.COMMENT,
					preAcceptanceSubBenefitData.preAcceptanceTripMeals.comment);

			CoreFunctions.clickElement(driver, _drpDownTripMealsExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.PRE_ACCEPTANCE_SERVICES, PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS,
							_drpDownOptionsTripMealsExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS,
							DbFunctions.getExpenseCodeListForBenefit(PDTConstants.PRE_ACCEPTANCE_SERVICES).toString(),
							CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsTripMealsExpenseCode)
									.toString()));
			ArrayList<String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownOptionsTripMealsExpenseCode.size(), 5, driver, _drpDownOptionsTripMealsExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES,
					_drpDownTripMealsExpenseCode, _drpDownOptionsTripMealsExpenseCode,
					_drpDownSelectedOptionsTripMealsExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeTripMeals(randExpenseCodeOptions);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void checkIfFlatAmtIsSelected(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		if (_drpDownMaxAmountSelectedVal.getText().equalsIgnoreCase(PDTConstants.FLAT_AMT)) {
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
						preAcceptanceSubBenefitData.preAcceptanceTripMeals.maxAmtTransferee);
				CoreFunctions.selectItemInListByText(driver, _radioDetailTransfereeCode,
						preAcceptanceSubBenefitData.preAcceptanceTripMeals.maxAmtTransfereeDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownTransfereeCurrency);
				CoreFunctions.selectItemInListByText(driver, _drpDownTransfereeCurrencyOptions,
						preAcceptanceSubBenefitData.preAcceptanceTripMeals.maxAmtTransfereeCurrency,
						PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
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
						preAcceptanceSubBenefitData.preAcceptanceTripMeals.maxAmtAdult);
				CoreFunctions.selectItemInListByText(driver, _radioDetailAdult,
						preAcceptanceSubBenefitData.preAcceptanceTripMeals.maxAmtAdultDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownAdultCurrency);
				CoreFunctions.selectItemInListByText(driver, _drpDownAdultCurrencyOptions,
						preAcceptanceSubBenefitData.preAcceptanceTripMeals.maxAmtAdultCurrency, PDTConstants.CURRENCY,
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
				CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmtChild, _lblMaxAmtChildren.getText(),
						preAcceptanceSubBenefitData.preAcceptanceTripMeals.maxAmtChild);
				CoreFunctions.selectItemInListByText(driver, _radioDetailChild,
						preAcceptanceSubBenefitData.preAcceptanceTripMeals.maxAmtChildDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownCurrencyCodeChild);
				CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyCodeChildOptions,
						preAcceptanceSubBenefitData.preAcceptanceTripMeals.maxAmtChildCurrency, PDTConstants.CURRENCY,
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL,
					PDTConstants.CHILDREN_INFO, subBenefitFormName));
		}
	}

	/**
	 * @param subBenefit
	 * @param pageName
	 * @param addNewPolicyPage Fill PreAcceptance Sub-benefit form depending on the
	 *                         sub-benefit passed.
	 */
	public void fillSubBenefitForm(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage,
			PDT_SharedSubBenefit_Steps objStep) {
		switch (subBenefit) {
		case PDTConstants.CANDIDATE_SELECTION:
			fillCandidateSelection(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			fillPreAcceptanceTripTransportation(addNewPolicyPage, subBenefit, pageName, objStep);
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			fillPreAcceptanceTripLodging(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			fillPreAcceptanceTripMeals(addNewPolicyPage, subBenefit, pageName);
			break;
		default:
			Assert.fail(
					MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}
	}

	public void iterateAndFillPreAcceptanceSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep, String btnName) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		WebElement btnToClick = (btnName != null) ? buttonMap.get(btnName) : buttonMap.get(PDTConstants.SAVE);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			waitForProgressBarToDisapper();
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			fillSubBenefitForm(subBenefit, pageName, addNewPolicyPage, objStep);
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

	public void selectEmpTypeForSubBenefit(String subBenefit) {
		populateSubBenefitEmpTypeLabelMap();
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, subBenefitEmpTypeLabelMap.get(subBenefit),
				subBenefitEmpTypeLabelMap.get(subBenefit).getText() + "(" + subBenefit + ")");
		CoreFunctions.clickUsingJS(driver, subBenefitEmpTypeLabelMap.get(subBenefit),
				subBenefitEmpTypeLabelMap.get(subBenefit).getText() + "(" + subBenefit + ")");
	}

	public void selectHomeOwnerTypeForSubBenefit(String subBenefit) {
		populateSubBenefitHomeOwnerTypeLabelMap();
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, subBenefitHomeOwnerTypeLabelMap.get(subBenefit),
				subBenefitHomeOwnerTypeLabelMap.get(subBenefit).getText() + "(" + subBenefit + ")");
		CoreFunctions.clickUsingJS(driver, subBenefitHomeOwnerTypeLabelMap.get(subBenefit),
				subBenefitHomeOwnerTypeLabelMap.get(subBenefit).getText() + "(" + subBenefit + ")");
	}

	public void selectSubBenefit(String subBenefitName, String pageName, PDT_AddNewPolicyPage addNewPolicyPage) {
		try {
			populateSubBenefitHeaderMap();
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefitName, true);
			waitForProgressBarToDisapper();//
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitName), subBenefitName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitName, pageName));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to select sub-benefit:-" + subBenefitName + " on " + pageName + "page.");
		}
	}

	public void checkEmpType(String benefitDifferForEmpType, String subBenefitName, String pageName,
			PDT_AddNewPolicyPage addNewPolicyPage) {
		try {
			if (benefitDifferForEmpType.equalsIgnoreCase(PDTConstants.YES)) {
				selectEmpTypeForSubBenefit(subBenefitName);
			}
		} catch (Exception e) {
			Assert.fail("Failed to select 'Benefit differs for employee Type' checkbox for sub-benefit:-"
					+ subBenefitName + " on " + pageName + "page.");
		}
	}

	public void checkHomeType(String benefitDifferForHomeType, String subBenefitName, String pageName,
			PDT_AddNewPolicyPage addNewPolicyPage) {
		try {
			if (benefitDifferForHomeType.equalsIgnoreCase(PDTConstants.YES)) {
				selectHomeOwnerTypeForSubBenefit(subBenefitName);
			}
		} catch (Exception e) {
			Assert.fail("Failed to select 'Benefit differs for home owner Type' checkbox for sub-benefit:-"
					+ subBenefitName + " on " + pageName + "page.");
		}
	}

	public void selectEmployeeTypeHomeOwnerTypeForSubBenefit(String pageName, PDT_AddNewPolicyPage addNewPolicyPage,
			DataTable subBenefitTable) {
		List<Map<String, String>> subBenefits = subBenefitTable.asMaps(String.class, String.class);
		try {
			WebElement element = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES)
					? _benefitCatName
					: _benefitCategoryName;

			CoreFunctions.explicitWaitForElementTextPresent(driver, element, pageName, 3);
			waitForProgressBarToDisapper();
			for (int i = 0; i < subBenefits.size(); i++) {
				selectSubBenefit(subBenefits.get(i).get("SubBenefit"), pageName, addNewPolicyPage);
				checkEmpType(subBenefits.get(i).get("Benefit_differs_for_Employee_type"),
						subBenefits.get(i).get("SubBenefit"), pageName, addNewPolicyPage);
				checkHomeType(subBenefits.get(i).get("Benefit_differs_for_Home_Owner_type"),
						subBenefits.get(i).get("SubBenefit"), pageName, addNewPolicyPage);
			}
		} catch (Exception e) {
			Assert.fail("Failed to select sub-benefit, employee type & home owner type.");
		}
	}

	public boolean iterateSubBenefitForTabs(String pageName, PDT_AddNewPolicyPage addNewPolicyPage,
			DataTable subBenefitTable) {
		List<Map<String, String>> subBenefits = subBenefitTable.asMaps(String.class, String.class);
		HashMap<String, Boolean> resultMap = new HashMap<String, Boolean>();
		populateSubBenefitHeadingMap();
		try {
			CoreFunctions.explicitWaitForElementTextPresent(driver, _txtSubBenefitName, pageName, 3);
			waitForProgressBarToDisapper();
			for (int i = 0; i < subBenefits.size(); i++) {
				expandSubBenefitIfCollapsed(subBenefits.get(i).get("SubBenefit"),
						subBenefitHeadingMap.get(subBenefits.get(i).get("SubBenefit")));
				resultMap.putAll(verifyTabName(subBenefits.get(i).get("SubBenefit"), subBenefits.get(i).get("Tabs"),
						getTabListByName(subBenefits.get(i).get("SubBenefit")), addNewPolicyPage, pageName));
			}
			resultMapForTabNameNotMatch = getFilterMapWhereTabNameNotMatch(subBenefits.size(), resultMap);
		} catch (Exception e) {
		}
		return resultMapForTabNameNotMatch.isEmpty();
	}

	public HashMap<String, Boolean> getFilterMapWhereTabNameNotMatch(int countOfSubBenefits,
			HashMap<String, Boolean> resultMap) {
		Map<String, Boolean> filteredMap = new HashMap<>();
		filteredMap = resultMap.entrySet().stream().filter(x -> x.getValue().equals(false))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		return (HashMap<String, Boolean>) filteredMap;
	}

	public HashMap<String, Boolean> verifyTabName(String subBenefit, String tabNameString, List<WebElement> tabList,
			PDT_AddNewPolicyPage addNewPolicyPage, String pageName) {
		HashMap<String, Boolean> map = new HashMap<>();
		String[] tabNameArr = tabNameString.split(",");
		for (int i = 0; i < tabNameArr.length; i++) {
			if (CoreFunctions.searchElementExistsInListByTextIgnoreCase(driver, tabList, tabNameArr[i].trim())) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERFIED_TAB_DISPLAYED, CoreConstants.PASS,
						tabNameArr[i].trim(), subBenefit, pageName));
				map.put(subBenefit + "_" + tabNameArr[i].trim(), true);
			} else {
				map.put(subBenefit + "_" + tabNameArr[i].trim(), false);
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERFIED_TAB_NOT_DISPLAYED, CoreConstants.FAIL,
						tabNameArr[i].trim(), subBenefit, pageName));
			}
		}
		return map;
	}

	public String getTabNameNotMatch(String pageName) {
		String str = "";
		for (@SuppressWarnings("rawtypes")
		Map.Entry m : resultMapForTabNameNotMatch.entrySet()) {
			String[] tabName = m.getKey().toString().split("_");
			str += MessageFormat.format(PDTConstants.VERFIED_TAB_NOT_DISPLAYED, CoreConstants.FAIL, tabName[1],
					tabName[0], pageName);
		}
		return str;
	}

	public void verifyAndFillDistanceOptionsField(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeSelectedOptions)
					.contains(PDTConstants.DISTANCE)) {

				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
						.verifyElementPresentOnPage(_lblDistance, PDTConstants.LABEL, PDTConstants.DISTANCE), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.DISTANCE));
				sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
						.verifyElementPresentOnPage(_txtBoxDistance, PDTConstants.TEXTBOX, PDTConstants.DISTANCE), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, PDTConstants.DISTANCE));
				// Boundary check for distance textbox				
				String random9DigitStr=CoreFunctions.generateRandomNumberAsGivenLength(9);
				String random10DigitStr = CoreFunctions.generateRandomNumberAsGivenLength(10);
				//String random11DigitStr = "98765987645";
				
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
			Assert.fail("Failed to verify Distance options field");
		}
	}

	public void verifyAndFillEconomyAirTravelField(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeSelectedOptions)
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
				CoreFunctions.selectItemInListByText(driver, _lblUnitOfDistanceForEconomyAirTravel, PDTConstants.MILES);
			}
		} catch (Exception e) {			
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
				|| option.equalsIgnoreCase(PDTConstants.MILES)) {
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
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeSelectedOptions)
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
			Assert.fail("Failed to verify Business Class AirFare options field");
		}
	}
	
	public boolean verifyPreAcceptanceSubBenefitForTransportType(String pageName, String subBenefit,
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
			result = verifyPreAcceptanceTripTransportationOptions(subBenefit, pageName, resultTable);
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
	
	public boolean verifyPreAcceptanceTripTransportationOptions(String subBenefitFormName,
			String pageName, DataTable resultTable) {
		boolean result = false;
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			expandSubBenefitIfCollapsed(subBenefitFormName, _headingFormPreTripTransport);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxNumOfTrips, _lblNoOfTrips.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxNumOfTrips, _lblNoOfTrips.getText(),
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.numberOfTrips);

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
			e.printStackTrace();
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
			e.printStackTrace();
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
		} else {
			Assert.fail("Not a valid option for Business Air Travel");
		}
		return result;
	}

	
/*	public void verifyDistanceForVisibilty(Map<String, String> resultTableMap, PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);
			CoreFunctions.selectItemInListByText(driver, _drpDownTransportationTypeOptions, resultTableMap.get("Transportation_Type_Option"),
					_lblTransportationType.getText(), PDTConstants.DROP_DOWN, true);
			CoreFunctions.clickElement(driver, _lblDistance);
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
					.verifyElementPresentOnPage(_lblDistance, PDTConstants.LABEL, PDTConstants.DISTANCE), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.DISTANCE));
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
					.verifyElementPresentOnPage(_txtBoxDistance, PDTConstants.TEXTBOX, PDTConstants.DISTANCE), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, PDTConstants.DISTANCE));
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
		} catch(Exception e) {
			Assert.fail("Failed to verify Distance fields for Visibility");
		}
	}*/
		
/*	public void verifyDistanceForInvisibilty(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		CoreFunctions.clickUsingJS(driver, _iconClearTransportationType, "Clear Transport Type Option");
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _txtBoxDistance);
		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
				.verifyElementNotPresentOnPage(_lblDistance, PDTConstants.LABEL, PDTConstants.DISTANCE), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.DISTANCE));
		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
				.verifyElementNotPresentOnPage(_txtBoxDistance, PDTConstants.TEXTBOX, PDTConstants.DISTANCE), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, PDTConstants.DISTANCE));
		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementNotPresentOnPage(
				_lblUnitOfDistance, PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE));
		
		sharedSubBenefitStep.getCustomSoftAssertObj()
					.assertTrue(CoreFunctions.verifyListElementNotPresentOnPage(_radioBtnUnitOfDistanceLabel, PDTConstants.RADIOBTN,
							PDTConstants.KM), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.RADIOBTN,
											PDTConstants.KM));
		sharedSubBenefitStep.getCustomSoftAssertObj()
		.assertTrue(CoreFunctions.verifyListElementNotPresentOnPage(_radioBtnUnitOfDistanceLabel, PDTConstants.RADIOBTN,
				PDTConstants.MILES), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.RADIOBTN,
								PDTConstants.MILES));
			
		
	}*/
	
	/*
	 	public void verifyEconomyClassForVisibilty(Map<String, String> resultTableMap, PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		CoreFunctions.clickElement(driver, _drpDownTransportationType);
		CoreFunctions.selectItemInListByText(driver, _drpDownTransportationTypeOptions, resultTableMap.get("Transportation_Type_Option"),
				_lblTransportationType.getText(), PDTConstants.DROP_DOWN, true);
		CoreFunctions.clickElement(driver, _lblMinDistanceForEconomyTravel);
		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
				.verifyElementPresentOnPage(_lblMinDistanceForEconomyTravel, PDTConstants.LABEL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.DISTANCE));
		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
				.verifyElementPresentOnPage(_txtBoxMinDistanceEconomy, PDTConstants.TEXTBOX, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, PDTConstants.DISTANCE));
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
	}
 */

	/*
	 	public void verifyEconomyClassForInvisibilty(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		CoreFunctions.clickUsingJS(driver, _iconClearTransportationType, "Clear Transport Type Option");
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _txtBoxMinDistanceEconomy);
		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
				.verifyElementNotPresentOnPage(_lblMinDistanceForEconomyTravel, PDTConstants.LABEL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL));
		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions
				.verifyElementNotPresentOnPage(_txtBoxMinDistanceEconomy, PDTConstants.TEXTBOX, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, PDTConstants.MIN_DISTANCE_FOR_ECONOMY_AIR_TRAVEL));
		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementNotPresentOnPage(
				_lblUnitOfDistanceForEconomyCode, PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.UNIT_OF_DISTANCE));
		
		sharedSubBenefitStep.getCustomSoftAssertObj()
					.assertTrue(CoreFunctions.verifyListElementNotPresentOnPage(_lblUnitOfDistanceForEconomyAirTravel, PDTConstants.RADIOBTN,
							PDTConstants.KM), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.RADIOBTN,
											PDTConstants.KM));
		sharedSubBenefitStep.getCustomSoftAssertObj()
		.assertTrue(CoreFunctions.verifyListElementNotPresentOnPage(_lblUnitOfDistanceForEconomyAirTravel, PDTConstants.RADIOBTN,
				PDTConstants.MILES), MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.RADIOBTN,
								PDTConstants.MILES));		
	}
	 */
	
/*	public void verifyBusinessClassForVisibilty(Map<String, String> resultTableMap, PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		List<String> businessAirFareUnit = new ArrayList<String>();
		List<String> expectedBusinessAirFareUnit = new ArrayList<String>();
		expectedBusinessAirFareUnit.add(PDTConstants.KM);
		expectedBusinessAirFareUnit.add(PDTConstants.MILES);
		expectedBusinessAirFareUnit.add(PDTConstants.HOURS);
		CoreFunctions.clickElement(driver, _drpDownTransportationType);
		CoreFunctions.selectItemInListByText(driver, _drpDownTransportationTypeOptions, resultTableMap.get("Transportation_Type_Option"),
				_lblTransportationType.getText(), PDTConstants.DROP_DOWN, true);
		CoreFunctions.clickElement(driver, _lblBusinessClassAirFareUnit);
		
		sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
				_lblBusinessClassAirFareUnit, PDTConstants.LABEL, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));
		sharedSubBenefitStep.getCustomSoftAssertObj()
				.assertTrue(CoreFunctions.verifyElementPresentOnPage(_drpDownBusinessClassAirfareUnit,
						PDTConstants.DROP_DOWN, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.DROP_DOWN, PDTConstants.BUSINESS_CLASS_AIRFARE_UNIT));

		CoreFunctions.clickElement(driver, _drpDownBusinessClassAirfareUnit);
		businessAirFareUnit = CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsBusinessClassAirfareUnit);
		Log.info("business class air fare unit=="+businessAirFareUnit);
		Log.info("expected business class air fare unit=="+expectedBusinessAirFareUnit);
		if(expectedBusinessAirFareUnit.equals(businessAirFareUnit)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_BUSINESS_CLASS_DRP_OPTION, CoreConstants.PASS, businessAirFareUnit));
		} else {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BUSINESS_CLASS_DRP_OPTION, CoreConstants.FAIL, expectedBusinessAirFareUnit));
		}
		
		for (String option : businessAirFareUnit) {					
			CoreFunctions.clickElement(driver, _drpDownBusinessClassAirfareUnit);
			CoreFunctions.selectItemInListByText(driver, _drpDownOptionsBusinessClassAirfareUnit,
					option, _lblBusinessClassAirFareUnit.getText(), PDTConstants.DROP_DOWN, true);
			verifyKmMilesHoursForVisibility(sharedSubBenefitStep, option);
		}
	}*/
		
/*	public void verifyKmMilesForVisibility(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			sharedSubBenefitStep.getCustomSoftAssertObj()
			.assertTrue(CoreFunctions.verifyElementPresentOnPage(_lblMinDistanceForBusinessAirTravel,
					PDTConstants.LABEL, _lblMinDistanceForBusinessAirTravel.getText()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, _lblMinDistanceForBusinessAirTravel.getText()));
			
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
			_txtBoxMinDistanceForBusinessAirTravel, PDTConstants.TEXTBOX, _lblMinDistanceForBusinessAirTravel.getText()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, _lblMinDistanceForBusinessAirTravel.getText()));
		

		} catch(Exception e) {
			Assert.fail("Failed to verify Min. Distance for Business Air Travel.");
		}
	}*/
	
/*	public void verifyHoursForVisibility(PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
					_lblMinTimeForBusinessAirTravel, PDTConstants.LABEL, _lblMinTimeForBusinessAirTravel.getText()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.LABEL, _lblMinTimeForBusinessAirTravel.getText()));
			
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(CoreFunctions.verifyElementPresentOnPage(
					_txtBoxMinTimeForBusinessAirTravel, PDTConstants.TEXTBOX, _lblMinTimeForBusinessAirTravel.getText()), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.TEXTBOX, _lblMinTimeForBusinessAirTravel.getText()));
			
		
		} catch(Exception e) {
			Assert.fail("Failed to verify Hours for Business Air Travel.");
		}	
	}*/
}
