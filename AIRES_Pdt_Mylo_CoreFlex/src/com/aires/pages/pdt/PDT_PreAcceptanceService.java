package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
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
import com.aires.testdatatypes.pdt.PDT_PreAcceptanceServiceBenefit;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class PDT_PreAcceptanceService extends Base {
	public PDT_PreAcceptanceService(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;

	@FindBy(how = How.CSS, using = "a[href='#collapseOne']")
	private WebElement _formCandidateSelection;

	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formPreAcceptanceTripTransportation;

	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _formPreAcceptanceTripLodging;

	@FindBy(how = How.CSS, using = "a[href='#collapseFour']")
	private WebElement _formPreAcceptanceTripMeals;

	@FindBy(how = How.CSS, using = "div.card-header-info > h4.card-title")
	private WebElement _subCategoryHeading;

	@FindBy(how = How.CSS, using = "#collapseOne label.form-check-label")
	private List<WebElement> _radioBtnCandidateSelection;

	@FindBy(how = How.CSS, using = "#collapseOne input[formcontrolname='paidByOther']")
	private WebElement _txtBoxCandidateSelReimbursedByOther;

	@FindBy(how = How.CSS, using = "#collapseOne textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCandidateSelComment;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfTrips']")
	private WebElement _txtBoxNumOfTrips;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportTypeList']")
	private WebElement _drpDownTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportTypeList'] span.ng-option-label")
	private List<WebElement> _drpDownTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportTypeList'] span.ng-value-label")
	private List<WebElement> _drpDownTransportationTypeMultiSelectOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='transportationTypeOther']")
	private WebElement _txtBoxTransportationTypeOther;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minMileageEconomy']")
	private WebElement _txtBoxMinMileageEconomy;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minMileageBusiness']")
	private WebElement _txtBoxMinMileageBusiness;

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

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountPerNightCode']")
	private WebElement _drpDownMaxAmt;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountPerNightCode'] span.ng-option-label")
	private List<WebElement> _drpDownMaxAmtOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountPerNightCode'] span.ng-value-label")
	private WebElement _drpDownMaxAmtSelectedOption;

	@FindBy(how = How.CSS, using = "input[formcontrolname='flatAmountPerNight']")
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

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='maxAmountCode']/descendant::span[contains(@class,'ng-value-label')]")
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

	@FindBy(how = How.XPATH, using = "//label[text()='Transportation Type']")
	private WebElement _lblTransportationType;

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

	@FindBy(how = How.CSS, using = "button.btn-next[type='submit']")
	private WebElement _btnSaveAndContinue;

	@FindBy(how = How.CSS, using = "div.swal2-popup.swal2-modal.swal2-icon-success.swal2-show")
	private WebElement _successPopUp;

	@FindBy(how = How.CSS, using = "div.swal2-html-container")
	private WebElement _successMsg;

	@FindBy(how = How.CSS, using = "button.swal2-confirm.swal2-styled")
	private WebElement _btnOkOnSuccessPopUp;

	@FindBy(how = How.XPATH, using = "//app-pre-trip-meals//label[contains(text(), 'Max. Amount')]")
	private WebElement _lblMaxAmtPreAcceptanceTripMeals;

	@FindBy(how = How.XPATH, using = "//app-pre-trip-meals//label[contains(text(), 'Max Amount - Transferee')]")
	private WebElement _lblMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//app-pre-trip-meals//label[contains(text(), 'Other Adults')]")
	private WebElement _lblMaxAmtOtherAdults;

	@FindBy(how = How.XPATH, using = "//app-pre-trip-meals//label[contains(text(), 'Max Amount - Children')]")
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

	final By _subBenefitCategoriesLocator = By.cssSelector("div.form-check > label.form-check-label");

	PDT_PreAcceptanceServiceBenefit preAcceptanceSubBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getPreAcceptanceDataList("Pre-Acceptance Services");

	private String transportType, accompanyingFamilyMemeber, maxAmtPreAcceptTripLodging, maxAmtPreAcceptTripMeals;

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

	public WebElement getElementByName(String elementName) {
		WebElement element = null;
		switch (elementName) {
		case PDTConstants.CANDIDATE_SELECTION:
			element = _formCandidateSelection;
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			element = _formPreAcceptanceTripTransportation;
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			element = _formPreAcceptanceTripLodging;
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			element = _formPreAcceptanceTripMeals;
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return element;
	}

	public String getElementText(String elementName) {
		String elementText = null;
		switch (elementName) {
		case PDTConstants.HEADING:
			elementText = _subCategoryHeading.getText();
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
		CoreFunctions.waitHandler(3);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _subCategoryHeading, _subCategoryHeading.getText());
		return CoreFunctions.verifyElementOnPage(driver, _subCategoryHeading, PDTConstants.heading, pageName, pageName,
				true);
	}

	public void selectSubBenefitAndVerifyFormIsDisplayed(DataTable subBenefitTable, String pageName) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		List<String> subBenefits = subBenefitTable.asList(String.class);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			Assert.assertTrue(verifyFormIsDisplayed(subBenefit, getElementByName(subBenefit), pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefit, pageName));
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

	public void fillCandidateSelection(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnCandidateSelection);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					preAcceptanceSubBenefitData.candidateSelection.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					preAcceptanceSubBenefitData.candidateSelection.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					preAcceptanceSubBenefitData.candidateSelection.reimbursedBy, _txtBoxCandidateSelReimbursedByOther,
					preAcceptanceSubBenefitData.candidateSelection.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaCandidateSelComment, PDTConstants.COMMENT,
					preAcceptanceSubBenefitData.candidateSelection.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
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
			setTransportType(randTransportTypeOption);

			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
					.toString().contains(PDTConstants.OTHER_TRAVEL_POLICY)) {
				CoreFunctions.clickElement(driver, _txtBoxTransportationTypeOther);
				CoreFunctions.clearAndSetText(driver, _txtBoxTransportationTypeOther, _lblTransportationOther.getText(),
						preAcceptanceSubBenefitData.preAcceptanceTripTransportation.transportationTypeOther);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL, _lblTransportationType.getText(), subBenefitFormName));
		}
	}

	public void fillPreAcceptanceTripTransportation(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxNumOfTrips, _lblNoOfTrips.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxNumOfTrips, _lblNoOfTrips.getText(),
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.numberOfTrips);

			selectRandomTransportTypeOption(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.clickElement(driver, _txtBoxMinMileageEconomy);
			CoreFunctions.clearAndSetText(driver, _txtBoxMinMileageEconomy, _lblMinMileageForEconomyAirTravel.getText(),
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.minMileageEconomyAir);
			CoreFunctions.clearAndSetText(driver, _txtBoxMinMileageBusiness,
					_lblMinMileageForBusinessAirTravel.getText(),
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.minMileageBusinessAir);
			CoreFunctions.clickElement(driver, _drpDownAccompanyingFamilyMemberCode);

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
			CoreFunctions.selectItemInListByText(driver, _radioBtnPreTripTransport,
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.reimbursedBy,
					PDTConstants.REIMBURSED_BY, PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.reimbursedBy,
					_txtBoxPreTripTransportReimbursedByOther,
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaPreTripTransportComment, PDTConstants.COMMENT,
					preAcceptanceSubBenefitData.preAcceptanceTripTransportation.comment);
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

	public void fillPreAcceptanceTripLodging(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
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

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					preAcceptanceSubBenefitData.preAcceptanceTripLodging.reimbursedBy,
					_txtBoxPreTripLodgingReimbursedByOther,
					preAcceptanceSubBenefitData.preAcceptanceTripLodging.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaPreTripLodgingComment, PDTConstants.COMMENT,
					preAcceptanceSubBenefitData.preAcceptanceTripLodging.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}

	}

	public void fillPreAcceptanceTripMeals(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
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

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					preAcceptanceSubBenefitData.preAcceptanceTripMeals.reimbursedBy,
					_txtBoxPreTripMealReimbursedByOther,
					preAcceptanceSubBenefitData.preAcceptanceTripMeals.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaPreTripMealComment, PDTConstants.COMMENT,
					preAcceptanceSubBenefitData.preAcceptanceTripMeals.comment);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
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
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL, PDTConstants.ADULT_INFO, subBenefitFormName));
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
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL, PDTConstants.CHILDREN_INFO, subBenefitFormName));
		}
	}

	public boolean verifySaveSuccessMessage(String msg, String pageName, PDT_AddNewPolicyPage addNewPolicyPage) {
		try {
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			if (CoreFunctions.isElementExist(driver, _successPopUp, 5) && _successMsg.getText().equalsIgnoreCase(msg)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_SUCCESS_MSG, CoreConstants.PASS,
						_successMsg.getText(), pageName));
				CoreFunctions.clickElement(driver, _btnOkOnSuccessPopUp);
				return true;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_SUCCESS_MSG, CoreConstants.FAIL, msg, pageName));
		}
		return false;
	}
}
