package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.NoSuchElementException;
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
import com.aires.cucumber.TestContext;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_SharedSubBenefitPage extends Base {
	public PDT_SharedSubBenefitPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;

	@FindBy(how = How.CSS, using = "div#headingOne > div.displayHeaderSection >h5")
	private WebElement _lnkFormCandSel;

	@FindBy(how = How.CSS, using = "div#headingTwo > div.displayHeaderSection >h5")
	private WebElement _lnkFormPreTripTransport;

	@FindBy(how = How.CSS, using = "div#headingThree > div.displayHeaderSection >h5")
	private WebElement _lnkFormPreTripLodging;

	@FindBy(how = How.CSS, using = "div#headingFour > div.displayHeaderSection >h5")
	private WebElement _lnkFormPreTripMeals;

	@FindBy(how = How.CSS, using = "a[href='#collapseOne']")
	private WebElement _lnkFormCollapseOne;

	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _lnkFormCollapseTwo;

	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _lnkFormCollapseThree;

	@FindBy(how = How.CSS, using = "a[href='#collapseFour']")
	private WebElement _lnkFormCollapseFour;

	@FindBy(how = How.CSS, using = "a[href='#collapseFive']")
	private WebElement _lnkFormCollapse5;

	@FindBy(how = How.CSS, using = "a[href='#collapseSix']")
	private WebElement _lnkFormCollapseSix;

	@FindBy(how = How.CSS, using = "a[href='#collapseSeven']")
	private WebElement _lnkFormCollapseSeven;

	@FindBy(how = How.CSS, using = "div.displayHeaderSection > h4.card-title")
	private WebElement _benefitCatName;

	@FindBy(how = How.CSS, using = "div.card-header-info > h4.card-title")
	private WebElement _benefitCategoryName;

	@FindBy(how = How.XPATH, using = "//span[text()='SAVE & SUBMIT']/parent::button")
	private WebElement _btnSaveAndSubmit;

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

	@FindBy(how = How.CSS, using = "div.pcard-header > div.displayHeaderSection > h4.card-title")
	private WebElement _txtSubBenefitName;

	@FindBy(how = How.CSS, using = "div#collapseOne div.mat-tab-label-content")
	private List<WebElement> _tabOnCandidateSelectionForm;

	@FindBy(how = How.CSS, using = "div#collapseTwo div.mat-tab-label-content")
	private List<WebElement> _tabOnPreAcceptanceTripTransportation;

	@FindBy(how = How.CSS, using = "div#collapseThree div.mat-tab-label-content")
	private List<WebElement> _tabOnPreAcceptanceTripLodging;

	@FindBy(how = How.CSS, using = "div#collapseFour div.mat-tab-label-content")
	private List<WebElement> _tabOnPreAcceptanceTripMeals;

	@FindBy(how = How.CSS, using = "a[href='#collapseOne1']")
	private WebElement _lnkFormCollapseFive;

	@FindBy(how = How.CSS, using = "a[href='#collapseAirport']")
	private WebElement _lnkFormCollapseAirport;

	@FindBy(how = How.CSS, using = "a[href='#collapseTour']")
	private WebElement _lnkFormCollapseTour;

	@FindBy(how = How.CSS, using = "a[href='#collapseAutoRental']")
	private WebElement _lnkFormCollapseAutoRental;

	@FindBy(how = How.CSS, using = "a[href='#collapseConciergeServices']")
	private WebElement _lnkFormCollapseConciergeServices;

	@FindBy(how = How.CSS, using = "a[href='#collapseDepartureServices']")
	private WebElement _lnkFormCollapseDepartureServices;

	@FindBy(how = How.CSS, using = "a[href='#collapseFurnitureRental']")
	private WebElement _lnkFormCollapseFurnitureRental;

	@FindBy(how = How.CSS, using = "a[href='#collapseHealthClub']")
	private WebElement _lnkFormCollapseMembershipDues;

	@FindBy(how = How.CSS, using = "a[href='#collapseSchoolSearch']")
	private WebElement _lnkFormCollapseSchoolSearch;

	@FindBy(how = How.CSS, using = "a[href='#collapseSettlingInServices']")
	private WebElement _lnkFormCollapseSettlingInServices;

	@FindBy(how = How.CSS, using = "a[href='#collapseTransitionAssistances']")
	private WebElement _lnkFormCollapseTransitionAssistances;

	@FindBy(how = How.CSS, using = "a[href='#collapseTuitionEducation']")
	private WebElement _lnkFormCollapseTutionEducation;

	@FindBy(how = How.CSS, using = "div.swal2-popup.swal2-modal.swal2-icon-question.swal2-show")
	private WebElement _dialogconfirmation;

	@FindBy(how = How.CSS, using = "button.swal2-confirm.swal2-styled")
	private WebElement _btnOk;

	@FindBy(how = How.CSS, using = "button.btn.btn-info.btn-exit")
	private WebElement _btnExit;

	@FindBy(how = How.CSS, using = "div.swal2-popup.swal2-modal.swal2-icon-success.swal2-show")
	private WebElement _successPopUp;

	@FindBy(how = How.CSS, using = "div.swal2-html-container")
	private WebElement _successMsg;

	@FindBy(how = How.CSS, using = "button.swal2-confirm.swal2-styled")
	private WebElement _btnOkOnSuccessPopUp;

	@FindBy(how = How.CSS, using = "div.validation-error-popup.swal2-icon-error.swal2-show")
	private WebElement _errorPopUp;

	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	@FindBy(how = How.CSS, using = "div[id='swal2-content']")
	private WebElement _errMsg;

	@FindBy(how = How.CSS, using = "a[href='#collapse8']")
	private WebElement _lnkFormCollapseEight;

	@FindBy(how = How.CSS, using = "a[href='#collapse9']")
	private WebElement _lnkFormCollapseNine;

	@FindBy(how = How.CSS, using = "a[href='#collapse10']")
	private WebElement _lnkFormCollapseTen;

	@FindBy(how = How.CSS, using = "a[href='#collapse11']")
	private WebElement _lnkFormCollapseEleven;

	@FindBy(how = How.CSS, using = "a[href='#collapse12']")
	private WebElement _lnkFormCollapseTwelve;

	@FindBy(how = How.CSS, using = "a[href='#collapse13']")
	private WebElement _lnkFormCollapseThirteen;

	@FindBy(how = How.CSS, using = "a[href='#collapse14']")
	private WebElement _lnkFormCollapseFourteen;

	@FindBy(how = How.CSS, using = "a[href='#collapse15']")
	private WebElement _lnkFormCollapseFifteen;

	@FindBy(how = How.CSS, using = "a[href='#collapse16']")
	private WebElement _lnkFormCollapseSixteen;

	@FindBy(how = How.CSS, using = "a[href='#collapse17']")
	private WebElement _lnkFormCollapseSeventeen;

	@FindBy(how = How.CSS, using = "a[href='#collapse18']")
	private WebElement _lnkFormCollapseEightteen;

	@FindBy(how = How.CSS, using = "a[href='#collapseEight']")
	private WebElement _lnkFormCollapse8;

	@FindBy(how = How.CSS, using = "a[href='#collapseNine']")
	private WebElement _lnkFormCollapse9;

	@FindBy(how = How.CSS, using = "button.swal2-confirm")
	private WebElement _btnOkOnConfirmationDialog;

	@FindBy(how = How.CSS, using = "button.swal2-deny")
	private WebElement _btnCancelOnConfirmationDialog;

	@FindBy(how = How.CSS, using = "button.swal2-cancel")
	private WebElement _btnSaveOnConfirmationDialog;

	@FindBy(how = How.CSS, using = "label.form-check-label input[type='checkbox']")
	private List<WebElement> _chkBoxesSubBenefitCategories;

	@FindBy(how = How.XPATH, using = "//span[text()='APPROVE POLICY']")
	private WebElement _btnApprovePolicy;

	@FindBy(how = How.CSS, using = "div.approve-header")
	private WebElement _headerApprovePopUp;

	@FindBy(how = How.CSS, using = "div.msg-1 > p")
	private WebElement _msg1ApprovePopUp;

	@FindBy(how = How.CSS, using = "div.msg-2 > p")
	private WebElement _msg2ApprovePopUp;

	@FindBy(how = How.CSS, using = "input[formcontrolname='existingAuthDateInd']")
	private WebElement _chkBoxExistingDateInd;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='existingAuthDateInd']/parent::label")
	private WebElement _lblExistingDateInd;

	@FindBy(how = How.CSS, using = "input[formcontrolname='newAuthDateInd']")
	private WebElement _chkBoxNewDateInd;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='newAuthDateInd']/parent::label")
	private WebElement _lblNewDateInd;

	@FindBy(how = How.XPATH, using = "//span[text()='APPROVE']/parent::button")
	private WebElement _btnApprove;

	@FindBy(how = How.XPATH, using = "//span[text()='CANCEL']")
	private WebElement _btnCancel;

	@FindBy(how = How.XPATH, using = "//strong[text()='Policy Status:']/parent::label/following-sibling::label")
	private WebElement _policyStatus;

	@FindBy(how = How.XPATH, using = "//strong[text()='Policy Status:']")
	private WebElement _policyStatusText;

	@FindBy(how = How.XPATH, using = "//strong[text()='Version Number:']/parent::label/following-sibling::label")
	private WebElement _policyVersion;

	@FindBy(how = How.CSS, using = "div.menu-pad div.col-10 >p")
	private List<WebElement> _leftNavBenefitCategories;

	@FindBy(how = How.XPATH, using = "//span[text()='SAVE & CONTINUE']/parent::button")
	private WebElement _btnSaveAndContinue;
	
	@FindBy(how = How.XPATH, using = "//span[text()='SAVE']/parent::button")
	private WebElement _btnSave;
	
	@FindBy(how = How.CSS, using = "i.ind-error")
	private WebElement _redErrorIconOnPolicyStatus;
	
	@FindBy(how = How.CSS, using = "//i[contains(@class, 'tabError')]/preceding-sibling::h4")
	private WebElement _redErrorIconOnBenefitName; 
	
//	@FindBy(how = How.CSS, using = "//i[contains(@class, 'tabError')]/parent::h5")
	@FindBy(how = How.CSS, using = "h5>i")
	private List<WebElement> _listRedErrorIconOnSubBenefitName;
	
	@FindBy(how = How.CSS, using = "div.col-md-12 h5")
	private List<WebElement> _listSubBenefitName;
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Policy Benefit Categories')]/ancestor::li/following-sibling::li/descendant::i")
	private List<WebElement> _listSaveIconOnLeftmenu;
	
	@FindBy(how = How.CSS, using = "div.menu-pad div>i")
	private List<WebElement> _listIconOnLeftmenu;	
	
	@FindBy(how = How.CSS, using = "div.menu-pad div>p")
	private List<WebElement> _listBenefitCategoryNameOnLeftMenu;
	
	@FindBy(how = How.CSS, using = "div.menu-pad")
	private List<WebElement> _listIconWithBenefitCategoryNameOnLeftmenu;
	
	@FindBy(how = How.XPATH, using = "//span/i/ancestor::label")
	private WebElement _policyStat;
	
	@FindBy(how = How.XPATH, using = "//span/i")
	private WebElement _policyIconStat;
	
	@FindBy(how = How.CSS, using = "h2.swal2-title")
	private WebElement _warningTitle;
	
	@FindBy(how = How.CSS, using = "div.swal2-content")
	private WebElement _warningMsg;
	
	@FindBy(how = How.CSS, using = "button.btn.btn-info.btn-back")
	private WebElement _btnBack;
	
	@FindBy(how = How.CSS, using = "button.btn.btn-info.btn-next")
	private WebElement _btnNext;
		
	HashMap<String, Boolean> resultMapForTabNameNotMatch = new HashMap<>();
	LinkedHashMap<String, WebElement> formMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, WebElement> buttonMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, WebElement> confirmationDialogButtonMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> subBenefitMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, WebElement> subBenefitAncestorMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> failedCategoriesWithIconMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> iconIndicatorMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> failedExpectedActualPrevPagMap = new LinkedHashMap<String, String>();
	ArrayList<String> failedSubBenefits = new ArrayList<String>();
	ArrayList<String> pdtPagesList = new ArrayList<String>();
	long timeBeforeAction, timeAfterAction;
	boolean completePolicyState = true;

	public void setCompletePolicyState(boolean cPolicyState) {
		completePolicyState = cPolicyState;
	}
	
	public boolean getCompletePolicyState() {
		return completePolicyState;
	}
	
	public WebElement getElementByName(String pageName, String elementName) {
		if (pageName.equalsIgnoreCase(PDTConstants.ASSIGNMENT_HOUSING_COMPANY_SPONSORED)
				&& elementName.equalsIgnoreCase(PDTConstants.ASSIGNMENT_FINDER_FEES))
			return _lnkFormCollapseThree;
		else
			return formMap.get(elementName);
	}

	public List<WebElement> getTabListByName(String elementName) {
		List<WebElement> element = null;
		switch (elementName) {
		case PDTConstants.CANDIDATE_SELECTION:
			element = _tabOnCandidateSelectionForm;
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			element = _tabOnPreAcceptanceTripTransportation;
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			element = _tabOnPreAcceptanceTripLodging;
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			element = _tabOnPreAcceptanceTripMeals;
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return element;
	}

	public void iterateAndSelectSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep, String btnName) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		populateFormHeaderElement();
		populateSubBenefitAncestorMap();
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			if (CoreFunctions.isElementExist(driver, _progressBar, 4))
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			Assert.assertTrue(
					verifyFormIsDisplayed(subBenefit, getElementByName(pageName, subBenefit), subBenefit, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefit, pageName));
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			fillSubBenefitForm(subBenefit, addNewPolicyPage, objStep, pageName);
		}
		try {
			CoreFunctions.click(driver, buttonMap.get(btnName), btnName);
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}

	}

	public boolean verifyFormIsDisplayed(String formName, WebElement element, String subBenefitName, String pageName) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, element, subBenefitName);
		if (element.isDisplayed()) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_DISPLAYED, CoreConstants.PASS,
					formName, pageName));
			return true;
		}
		return false;
	}

	public void fillSubBenefitForm(String subBenefit, PDT_AddNewPolicyPage addNewPolicyPage,
			PDT_SharedSubBenefit_Steps subBenefitSteps, String pageName) {
		if (!pageName.equalsIgnoreCase(PDTConstants.DUPLICATE_HOUSING)
				&& !pageName.equalsIgnoreCase(PDTConstants.PROPERTY_MANAGEMENT))
			expandSubBenefitIfCollapsed(getElementByName(pageName, subBenefit), subBenefit);
		if (pageName.equalsIgnoreCase(PDTConstants.ASSIGNMENT_HOUSING_COMPANY_SPONSORED)
				&& subBenefit.equalsIgnoreCase(PDTConstants.ASSIGNMENT_FINDER_FEES)) {
			subBenefitSteps.getAssignmentHousingPage().fillAssignmentFinderFeesForm(addNewPolicyPage,
					PDTConstants.ASSIGNMENT_FINDER_FEES);
			return;
		}
		switch (subBenefit) {
		case PDTConstants.CANDIDATE_SELECTION:
			subBenefitSteps.getPreAcceptServicePage().fillCandidateSelection(addNewPolicyPage,
					PDTConstants.CANDIDATE_SELECTION);
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			subBenefitSteps.getPreAcceptServicePage().fillPreAcceptanceTripTransportation(addNewPolicyPage,
					PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION);
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			subBenefitSteps.getPreAcceptServicePage().fillPreAcceptanceTripLodging(addNewPolicyPage,
					PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING);
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			subBenefitSteps.getPreAcceptServicePage().fillPreAcceptanceTripMeals(addNewPolicyPage,
					PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS);
			break;
		case PDTConstants.IMMIGRATION_FEES:
			subBenefitSteps.getImmigrationPage().fillImmigrationFeesForm(addNewPolicyPage,
					PDTConstants.IMMIGRATION_FEES);
			break;
		case PDTConstants.IMMIGRATION_TRAVEL:
			subBenefitSteps.getImmigrationPage().fillImmigrationTravelForm(addNewPolicyPage,
					PDTConstants.IMMIGRATION_TRAVEL);
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION:
			subBenefitSteps.getHouseHuntingTripPage().fillHouseHuntingTripTransportationForm(addNewPolicyPage,
					PDTConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION);
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP_LODGING:
			subBenefitSteps.getHouseHuntingTripPage().fillHouseHuntingTripLodgingForm(addNewPolicyPage,
					PDTConstants.HOUSE_HUNTING_TRIP_LODGING);
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP_MEALS:
			subBenefitSteps.getHouseHuntingTripPage().fillHouseHuntingTripMealForm(addNewPolicyPage,
					PDTConstants.HOUSE_HUNTING_TRIP_MEALS);
			break;
		case PDTConstants.LANGUAGE_TRAINING_EMPLOYEE:
			subBenefitSteps.getLanguageTrainingPage().fillLanguageTrainingEmployee(addNewPolicyPage,
					PDTConstants.LANGUAGE_TRAINING_EMPLOYEE, this);
			break;
		case PDTConstants.LANGUAGE_TRAINING_FAMILY:
			subBenefitSteps.getLanguageTrainingPage().fillLanguageTrainingFamily(addNewPolicyPage,
					PDTConstants.LANGUAGE_TRAINING_FAMILY, this);
			break;
		case PDTConstants.CULTURAL_TRAINING_EMPLOYEE:
			subBenefitSteps.getCulturalTrainingPage().fillCulturalTrainingEmployee(addNewPolicyPage,
					PDTConstants.CULTURAL_TRAINING_EMPLOYEE, this);
			break;
		case PDTConstants.CULTURAL_TRAINING_FAMILY:
			subBenefitSteps.getCulturalTrainingPage().fillCulturalTrainingFamily(addNewPolicyPage,
					PDTConstants.CULTURAL_TRAINING_FAMILY, this);
			break;
		case PDTConstants.FINAL_MOVE_TRANSPORTATION:
			subBenefitSteps.getFinalMovePage().fillFinalMoveTransportationForm(addNewPolicyPage,
					PDTConstants.FINAL_MOVE_TRANSPORTATION);
			break;
		case PDTConstants.FINAL_MOVE_LODGING:
			subBenefitSteps.getFinalMovePage().fillFinalMoveLodgingForm(addNewPolicyPage,
					PDTConstants.FINAL_MOVE_LODGING);
			break;
		case PDTConstants.FINAL_MOVE_MEALS:
			subBenefitSteps.getFinalMovePage().fillFinalMoveMealForm(addNewPolicyPage, PDTConstants.FINAL_MOVE_MEALS);
			break;
		case PDTConstants.HOME_LEAVE_TRANSPORTATION:
			subBenefitSteps.getHomeLeavePage().fillHomeLeaveTransportationForm(addNewPolicyPage,
					PDTConstants.HOME_LEAVE_TRANSPORTATION, subBenefitSteps.getGeneralInfoPage().getTracingSet());
			break;
		case PDTConstants.HOME_LEAVE_LODGING:
			subBenefitSteps.getHomeLeavePage().fillHomeLeaveLodgingForm(addNewPolicyPage,
					PDTConstants.HOME_LEAVE_LODGING);
			break;
		case PDTConstants.HOME_LEAVE_MEALS:
			subBenefitSteps.getHomeLeavePage().fillHomeLeaveMealForm(addNewPolicyPage, PDTConstants.HOME_LEAVE_MEALS);
			break;
		case PDTConstants.TEMPORARY_LIVING_TRANSPORTATION:
			subBenefitSteps.getTemporaryLivingPage().fillTemporaryLivingTransportationForm(addNewPolicyPage,
					PDTConstants.TEMPORARY_LIVING_TRANSPORTATION);
			break;
		case PDTConstants.TEMPORARY_LIVING_LODGING:
			subBenefitSteps.getTemporaryLivingPage().fillTemporaryLivingLodgingForm(addNewPolicyPage,
					PDTConstants.TEMPORARY_LIVING_LODGING);
			break;
		case PDTConstants.TEMPORARY_LIVING_MEALS:
			subBenefitSteps.getTemporaryLivingPage().fillTemporaryLivingMealsForm(addNewPolicyPage,
					PDTConstants.TEMPORARY_LIVING_MEALS);
			break;
		case PDTConstants.AIRPORT_PICKUP:
			subBenefitSteps.getDestinationServicePage().fillAirPortPickUpForm(addNewPolicyPage,
					PDTConstants.AIRPORT_PICKUP);
			break;
		case PDTConstants.AREA_TOUR:
			subBenefitSteps.getDestinationServicePage().fillAreaTourForm(addNewPolicyPage, PDTConstants.AREA_TOUR);
			break;
		case PDTConstants.AUTO_RENTAL_DURING_ASSIGNMENT:
			subBenefitSteps.getDestinationServicePage().fillAutoRentalForm(addNewPolicyPage,
					PDTConstants.AUTO_RENTAL_DURING_ASSIGNMENT);
			break;
		case PDTConstants.CONCIERGE_SERVICES:
			subBenefitSteps.getDestinationServicePage().fillConciergeServicesForm(addNewPolicyPage,
					PDTConstants.CONCIERGE_SERVICES);
			break;
		case PDTConstants.DEPARTURE_SERVICES:
			subBenefitSteps.getDestinationServicePage().fillDepartureServicesForm(addNewPolicyPage,
					PDTConstants.DEPARTURE_SERVICES);
			break;
		case PDTConstants.FURNITURE_RENTAL:
			subBenefitSteps.getDestinationServicePage().fillFurnitureRentalForm(addNewPolicyPage,
					PDTConstants.FURNITURE_RENTAL);
			break;
		case PDTConstants.REIMBURSEMENT_OF_MEMEBERSHIP_DUES:
			subBenefitSteps.getDestinationServicePage().fillReimbursementOfMembershipDuesForm(addNewPolicyPage,
					PDTConstants.REIMBURSEMENT_OF_MEMEBERSHIP_DUES);
			break;
		case PDTConstants.EDUCATION_ASSISTANCE:
			subBenefitSteps.getDestinationServicePage().fillSchoolSearchForm(addNewPolicyPage,
					PDTConstants.EDUCATION_ASSISTANCE);
			break;
		case PDTConstants.EDUCATION_ASSISTANT:
			subBenefitSteps.getDestinationServicePage().fillSchoolSearchForm(addNewPolicyPage,
					PDTConstants.EDUCATION_ASSISTANT);
			break;
		case PDTConstants.SETTLING_IN_SERVICES:
			subBenefitSteps.getDestinationServicePage().fillSettlingServicesForm(addNewPolicyPage,
					PDTConstants.SETTLING_IN_SERVICES);
			break;
		case PDTConstants.TRANSITION_ASSISTANCE_PROGRAM:
			subBenefitSteps.getDestinationServicePage().fillTransitionAssistanceProgramForm(addNewPolicyPage,
					PDTConstants.TRANSITION_ASSISTANCE_PROGRAM);
			break;
		case PDTConstants.TUTION_AND_EDUCATION:
			subBenefitSteps.getDestinationServicePage().fillTutionAndEductionForm(addNewPolicyPage,
					PDTConstants.TUTION_AND_EDUCATION);
			break;
		case PDTConstants.RENTAL_TOUR:
			subBenefitSteps.getRentalAssistancePage().fillRentalTourForm(addNewPolicyPage, PDTConstants.RENTAL_TOUR);
			break;
		case PDTConstants.FINDER_FEES:
			subBenefitSteps.getRentalAssistancePage().fillFinderFeesForm(addNewPolicyPage, PDTConstants.FINDER_FEES);
			break;
		case PDTConstants.LETTER_OF_ASSIGNMENT:
			subBenefitSteps.getCompensationServicesPage().fillLetterOfAssignmentForm(addNewPolicyPage,
					PDTConstants.LETTER_OF_ASSIGNMENT);
			break;
		case PDTConstants.COST_ESTIMATE_WITH_TAX:
			subBenefitSteps.getCompensationServicesPage().fillCostEstimateWithTaxForm(addNewPolicyPage,
					PDTConstants.COST_ESTIMATE_WITH_TAX);
			break;
		case PDTConstants.COST_ESTIMATE_WITHOUT_TAX:
			subBenefitSteps.getCompensationServicesPage().fillCostEstimateWithoutTaxForm(addNewPolicyPage,
					PDTConstants.COST_ESTIMATE_WITHOUT_TAX);
			break;
		case PDTConstants.BALANCE_SHEET:
			subBenefitSteps.getCompensationServicesPage().fillBalanceSheetForm(addNewPolicyPage,
					PDTConstants.BALANCE_SHEET);
			break;
		case PDTConstants.ALLOWANCE_UPDATES:
			subBenefitSteps.getCompensationServicesPage().fillAllowanceUpdateForm(addNewPolicyPage,
					PDTConstants.ALLOWANCE_UPDATES);
			break;
		case PDTConstants.GLOBAL_DATA_COLLECTION:
			subBenefitSteps.getCompensationServicesPage().fillGlobalDataCollectionForm(addNewPolicyPage,
					PDTConstants.GLOBAL_DATA_COLLECTION);
			break;
		case PDTConstants.PAYROLL_INSTRUCTIONS:
			subBenefitSteps.getCompensationServicesPage().fillPayrollInstructionsForm(addNewPolicyPage,
					PDTConstants.PAYROLL_INSTRUCTIONS);
			break;
		case PDTConstants.ASSIGNMENT_HOUSING:
			subBenefitSteps.getAssignmentHousingPage().fillAssignmentHousingForm(addNewPolicyPage,
					PDTConstants.ASSIGNMENT_HOUSING);
			break;
		case PDTConstants.SECURITY_DEPOSIT:
			subBenefitSteps.getAssignmentHousingPage().fillSecurityDepositForm(addNewPolicyPage,
					PDTConstants.SECURITY_DEPOSIT);
			break;
		/*
		 * case PDTConstants.ASSIGNMENT_FINDER_FEES:
		 * subBenefitSteps.getAssignmentHousingPage().fillSecurityDepositForm(
		 * addNewPolicyPage, PDTConstants.SECURITY_DEPOSIT); break;
		 */
		case PDTConstants.MISC_RELOCATION_ALLOWANCE:
			subBenefitSteps.getOneTimePaymentPage().fillMiscRelocationAllowance(addNewPolicyPage,
					PDTConstants.MISC_RELOCATION_ALLOWANCE);
			break;
		case PDTConstants.LUMP_SUM:
			subBenefitSteps.getOneTimePaymentPage().fillLumpSum(addNewPolicyPage, PDTConstants.LUMP_SUM);
			break;
		case PDTConstants.LEASE_BREAK:
			subBenefitSteps.getOneTimePaymentPage().fillLeaseBreak(addNewPolicyPage, PDTConstants.LEASE_BREAK);
			break;
		case PDTConstants.APPLIANCE_ALLOWANCE:
			subBenefitSteps.getOneTimePaymentPage().fillApplAllowance(addNewPolicyPage,
					PDTConstants.APPLIANCE_ALLOWANCE);
			break;
		case PDTConstants.AUTO_REGISTRATION_COSTS:
			subBenefitSteps.getOneTimePaymentPage().fillAutoRegistrationCost(addNewPolicyPage,
					PDTConstants.AUTO_REGISTRATION_COSTS);
			break;
		case PDTConstants.AUTO_LOSS_ON_SALE:
			subBenefitSteps.getOneTimePaymentPage().fillAutoLossOnSale(addNewPolicyPage,
					PDTConstants.AUTO_LOSS_ON_SALE);
			break;
		case PDTConstants.OTHER_ONE_TIME_PAYMENT:
			subBenefitSteps.getOneTimePaymentPage().fillOtherOneTimePayment(addNewPolicyPage,
					PDTConstants.OTHER_ONE_TIME_PAYMENT);
			break;
		case PDTConstants.COLA:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillCola(addNewPolicyPage, PDTConstants.COLA);
			break;
		case PDTConstants.PER_DIEM:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillPerDiem(addNewPolicyPage, PDTConstants.PER_DIEM);
			break;
		case PDTConstants.MOBILITY_PREMIUM:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillMobilityPremium(addNewPolicyPage,
					PDTConstants.MOBILITY_PREMIUM);
			break;
		case PDTConstants.TRANSPORTATION_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillTransportationAllowance(addNewPolicyPage,
					PDTConstants.TRANSPORTATION_ALLOWANCE);
			break;
		case PDTConstants.HOUSING_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillHousingAllowance(addNewPolicyPage,
					PDTConstants.HOUSING_ALLOWANCE);
			break;
		case PDTConstants.HOME_MAINTENANCE_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillHomeMaintenanceAllowance(addNewPolicyPage,
					PDTConstants.HOME_MAINTENANCE_ALLOWANCE);
			break;
		case PDTConstants.FURNITURE_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillFurnitureAllowance(addNewPolicyPage,
					PDTConstants.FURNITURE_ALLOWANCE);
			break;
		case PDTConstants.HARDSHIP_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillHardshipAllowance(addNewPolicyPage,
					PDTConstants.HARDSHIP_ALLOWANCE);
			break;
		case PDTConstants.BANKING_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillBankingAllowance(addNewPolicyPage,
					PDTConstants.BANKING_ALLOWANCE);
			break;
		case PDTConstants.AT_SEA_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillAtSeaAllowance(addNewPolicyPage,
					PDTConstants.AT_SEA_ALLOWANCE);
			break;
		case PDTConstants.COMMUTER_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillCommuterAllowance(addNewPolicyPage,
					PDTConstants.COMMUTER_ALLOWANCE);
			break;
		case PDTConstants.DIFFERENTIAL_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillDifferentialAllowance(addNewPolicyPage,
					PDTConstants.DIFFERENTIAL_ALLOWANCE);
			break;
		case PDTConstants.GOODS_AND_SERVICES_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillGoodsAndServicesAllowance(addNewPolicyPage,
					PDTConstants.GOODS_AND_SERVICES_ALLOWANCE);
			break;
		case PDTConstants.HOME_LEAVE_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillHomeLeaveAllowance(addNewPolicyPage,
					PDTConstants.HOME_LEAVE_ALLOWANCE);
			break;
		case PDTConstants.HOME_RETENTION_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillHomeRetentionAllowance(addNewPolicyPage,
					PDTConstants.HOME_RETENTION_ALLOWANCE);
			break;
		case PDTConstants.HOUSEKEEPING_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillHouseKeepingAllowance(addNewPolicyPage,
					PDTConstants.HOUSEKEEPING_ALLOWANCE);
			break;
		case PDTConstants.UTILITY_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillUtilityAllowance(addNewPolicyPage,
					PDTConstants.UTILITY_ALLOWANCE);
			break;
		case PDTConstants.OTHER_ONGOING_ALLOWANCE:
			subBenefitSteps.getOngoingPaymentReimbursementPage().fillOtherOngoingAllowance(addNewPolicyPage,
					PDTConstants.OTHER_ONGOING_ALLOWANCE);
			break;
		case PDTConstants.DUPLICATE_HOUSING:
			subBenefitSteps.getDuplicateHousingPage().fillDuplicateHousingForm(addNewPolicyPage,
					PDTConstants.DUPLICATE_HOUSING);
			break;
		case PDTConstants.PROPERTY_MANAGEMENT:
			subBenefitSteps.getPropertyManagementPage().fillPropertyManagementForm(addNewPolicyPage,
					PDTConstants.PROPERTY_MANAGEMENT);
			break;
		case PDTConstants.HOME_PURCHASE_CLOSING_COSTS:
			subBenefitSteps.getHomePurchasePage().fillHomePurchaseClosingCostForm(addNewPolicyPage,
					PDTConstants.HOME_PURCHASE_CLOSING_COSTS);
			break;
		case PDTConstants.HOME_PURCHASE_POINTS:
			subBenefitSteps.getHomePurchasePage().fillHomePurchasePointsForm(addNewPolicyPage,
					PDTConstants.HOME_PURCHASE_POINTS);
			break;
		case PDTConstants.HOME_PURCHASE_INSPECTIONS:
			subBenefitSteps.getHomePurchasePage().fillHomePurchaseInspectionForm(addNewPolicyPage,
					PDTConstants.HOME_PURCHASE_INSPECTIONS);
			break;
		case PDTConstants.HOME_PURCHASE_BONUS:
			subBenefitSteps.getHomePurchasePage().fillHomePurchaseBonusForm(addNewPolicyPage,
					PDTConstants.HOME_PURCHASE_BONUS);
			break;
		case PDTConstants.MORTGAGE_DIFFERENTIALS:
			subBenefitSteps.getHomePurchasePage().fillMortgageDifferentialForm(addNewPolicyPage,
					PDTConstants.MORTGAGE_DIFFERENTIALS);
			break;
		case PDTConstants.MORTGAGE_SUBSIDY:
			subBenefitSteps.getHomePurchasePage().fillMortgageSubsidyForm(addNewPolicyPage,
					PDTConstants.MORTGAGE_SUBSIDY);
			break;
		case PDTConstants.US_DOM_VANLINE_SHIPMENT:
			subBenefitSteps.getHouseHoldGoodsPage().fillUSDomesticForm(addNewPolicyPage,
					PDTConstants.US_DOM_VANLINE_SHIPMENT);
			break;
		case PDTConstants.AUTO_SHIPMENT:
			subBenefitSteps.getHouseHoldGoodsPage().fillAutoShipmentForm(addNewPolicyPage, PDTConstants.AUTO_SHIPMENT);
			break;
		case PDTConstants.SELF_MOVE:
			subBenefitSteps.getHouseHoldGoodsPage().fillSelfMoveForm(addNewPolicyPage, PDTConstants.SELF_MOVE);
			break;
		case PDTConstants.AIR_SHIPMENT:
			subBenefitSteps.getHouseHoldGoodsPage().fillAirShipmentForm(addNewPolicyPage, PDTConstants.AIR_SHIPMENT);
			break;
		case PDTConstants.SEA_SHIPMENT:
			subBenefitSteps.getHouseHoldGoodsPage().fillSeaShipmentForm(addNewPolicyPage, PDTConstants.SEA_SHIPMENT);
			break;
		case PDTConstants.NONUS_INLAND_SHIPMENT:
			subBenefitSteps.getHouseHoldGoodsPage().fillNonUsInlandShipmentForm(addNewPolicyPage,
					PDTConstants.NONUS_INLAND_SHIPMENT);
			break;
		case PDTConstants.PERMANENT_STORAGE:
			subBenefitSteps.getHouseHoldGoodsPage().fillPermanentStorageForm(addNewPolicyPage,
					PDTConstants.PERMANENT_STORAGE);
			break;
		case PDTConstants.PET_SHIPMENT:
			subBenefitSteps.getHouseHoldGoodsPage().fillPetShipmentForm(addNewPolicyPage, PDTConstants.PET_SHIPMENT);
			break;
		case PDTConstants.DISCARD_DONATE:
			subBenefitSteps.getHouseHoldGoodsPage().fillDiscardDonateForm(addNewPolicyPage,
					PDTConstants.DISCARD_DONATE);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	public boolean checkIfEditLabelBenefit(String subBenefitName) {
		try{
			if ((subBenefitName.equalsIgnoreCase(PDTConstants.CANDIDATE_SELECTION)
							|| subBenefitName.equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION)
							|| subBenefitName.equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING)
							|| subBenefitName.equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS)))
				return true;
			
			/*if ((System.getProperty("envt").toLowerCase().equalsIgnoreCase(CoreConstants.ENVT_QA))
					&& (subBenefitName.equalsIgnoreCase(PDTConstants.CANDIDATE_SELECTION)
							|| subBenefitName.equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION)
							|| subBenefitName.equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING)
							|| subBenefitName.equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS)))
				return true;*/
			else
				return false;
		} catch (Exception e) {
			Assert.fail("Failed to expand sub benefit form:-" + subBenefitName);
			return false;
		}

	}

	public void expandSubBenefitIfCollapsed(WebElement subBenefitForm, String subBenefitName) {
		try {
			if (checkIfEditLabelBenefit(subBenefitName)) {
				if (subBenefitAncestorMap.get(subBenefitName).getAttribute("class").equalsIgnoreCase("collapsed"))
					CoreFunctions.clickElement(driver, subBenefitForm);

			} else if (subBenefitForm.getAttribute("class").equalsIgnoreCase("collapsed"))
				CoreFunctions.clickElement(driver, subBenefitForm);
		} catch (Exception e) {
			Assert.fail("Failed to expand sub benefit form:-" + subBenefitForm.getText());
		}
	}

	public void selectEmpTypeForSubBenefit(String subBenefit) {
		switch (subBenefit) {
		case PDTConstants.CANDIDATE_SELECTION:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblCandidateSelEmpType,
					_lblCandidateSelEmpType.getText() + "(" + PDTConstants.CANDIDATE_SELECTION + ")");
			CoreFunctions.clickUsingJS(driver, _lblCandidateSelEmpType,
					_lblCandidateSelEmpType.getText() + "(" + PDTConstants.CANDIDATE_SELECTION + ")");
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblPreAcceptTripTransportEmpType,
					_lblPreAcceptTripTransportEmpType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION
							+ ")");
			CoreFunctions.clickUsingJS(driver, _lblPreAcceptTripTransportEmpType,
					_lblPreAcceptTripTransportEmpType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION
							+ ")");
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblPreAcceptTripLodgingEmpType,
					_lblPreAcceptTripLodgingEmpType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING + ")");
			CoreFunctions.clickUsingJS(driver, _lblPreAcceptTripLodgingEmpType,
					_lblPreAcceptTripLodgingEmpType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING + ")");
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblPreAcceptTripMealEmpType,
					_lblPreAcceptTripMealEmpType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS + ")");
			CoreFunctions.clickUsingJS(driver, _lblPreAcceptTripMealEmpType,
					_lblPreAcceptTripMealEmpType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS + ")");
			break;
		}
	}

	public void selectHomeOwnerTypeForSubBenefit(String subBenefit) {
		switch (subBenefit) {
		case PDTConstants.CANDIDATE_SELECTION:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblCandidateSelHomeOwnerType,
					_lblCandidateSelHomeOwnerType.getText() + "(" + PDTConstants.CANDIDATE_SELECTION + ")");
			CoreFunctions.clickUsingJS(driver, _lblCandidateSelHomeOwnerType,
					_lblCandidateSelHomeOwnerType.getText() + "(" + PDTConstants.CANDIDATE_SELECTION + ")");
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblPreAcceptTripTransportHomeOwnerType,
					_lblPreAcceptTripTransportHomeOwnerType.getText() + "("
							+ PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION + ")");
			CoreFunctions.clickUsingJS(driver, _lblPreAcceptTripTransportHomeOwnerType,
					_lblPreAcceptTripTransportHomeOwnerType.getText() + "("
							+ PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION + ")");
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblPreAcceptTripLodgingHomeOwnerType,
					_lblPreAcceptTripLodgingHomeOwnerType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING
							+ ")");
			CoreFunctions.clickUsingJS(driver, _lblPreAcceptTripLodgingHomeOwnerType,
					_lblPreAcceptTripLodgingHomeOwnerType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING
							+ ")");
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblPreAcceptTripMealHomeOwnerType,
					_lblPreAcceptTripMealHomeOwnerType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS + ")");
			CoreFunctions.clickUsingJS(driver, _lblPreAcceptTripMealHomeOwnerType,
					_lblPreAcceptTripMealHomeOwnerType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS + ")");
			break;
		}
	}

	public void selectSubBenefit(String subBenefitName, String pageName, PDT_AddNewPolicyPage addNewPolicyPage) {
		try {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefitName, true);
			waitForProgressBarToDisapper();
			Assert.assertTrue(
					verifyFormIsDisplayed(subBenefitName, getElementByName(pageName, subBenefitName), subBenefitName,
							pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitName, pageName));
		} catch (Exception e) {
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
			
			/*WebElement element = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES)
					&& System.getProperty("envt").toLowerCase().equalsIgnoreCase(CoreConstants.ENVT_QA)
							? _benefitCatName
							: _benefitCategoryName;*/
			CoreFunctions.explicitWaitForElementTextPresent(driver, element, pageName, 3);
			if (CoreFunctions.isElementExist(driver, _progressBar, 3))
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			populateFormHeaderElement();
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
		populateSubBenefitAncestorMap();
		try {
			CoreFunctions.explicitWaitForElementTextPresent(driver, _txtSubBenefitName, pageName, 3);
			if (CoreFunctions.isElementExist(driver, _progressBar, 3))
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			for (int i = 0; i < subBenefits.size(); i++) {
				expandSubBenefitIfCollapsed(getElementByName(pageName, subBenefits.get(i).get("SubBenefit")),
						subBenefits.get(i).get("SubBenefit"));
				resultMap.putAll(verifyTabName(subBenefits.get(i).get("SubBenefit"), subBenefits.get(i).get("Tabs"),
						getTabListByName(subBenefits.get(i).get("SubBenefit")), addNewPolicyPage, pageName));
			}
			resultMapForTabNameNotMatch = getFilterMapWhereTabNameNotMatch(subBenefits.size(), resultMap);
		} catch (Exception e) {
		}
		return resultMapForTabNameNotMatch.isEmpty();
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

	public void verifySubBenefitCategoriesAreDisplayed(List<String> subBenefitsFromDataTable, String pageName) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		if (subBenefitsFromDataTable.equals(CoreFunctions.getElementTextAndStoreInList(driver, _subBenefitCategories)))
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_SUB_BENEFITS_DISPLAYED, CoreConstants.PASS,
					subBenefitsFromDataTable.toString(), pageName));
		else
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_SUB_BENEFITS, CoreConstants.FAIL,
					pageName, subBenefitsFromDataTable.toString(),
					CoreFunctions.getElementTextAndStoreInList(driver, _subBenefitCategories).toString()));
	}

	public void verifySelectedPolicyBenefitCategoryName(String pageName) {
		waitForProgressBarToDisapper();
		if (pageName.equalsIgnoreCase("One-Time Payments/Reimbursements")
				|| pageName.equalsIgnoreCase("Ongoing Payments/Reimbursements")) {
			return;
		}
		try {
			WebElement element = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES)					
							? _benefitCatName
							: _benefitCategoryName;
			
			/*WebElement element = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES)
					&& System.getProperty("envt").toLowerCase().equalsIgnoreCase(CoreConstants.ENVT_QA)
							? _benefitCatName
							: _benefitCategoryName;*/			
			CoreFunctions.explicitWaitForElementTextPresent(driver, element, pageName, 3);
			if (!CoreFunctions.verifyElementOnPage(driver, element, PDTConstants.POLICY_BENEFIT_CATEGORY, pageName,
					pageName, true))
				Reporter.addStepLog(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE,
						CoreConstants.FAIL, PDTConstants.POLICY_BENEFIT_CATEGORY, pageName, pageName, element.getText()));	
		} catch(Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE,
						CoreConstants.FAIL, PDTConstants.POLICY_BENEFIT_CATEGORY, pageName, pageName, PDTConstants.PRE_ACCEPTANCE_SERVICES));
		}
	}

	public void populateFormHeaderElement() {
		formMap.put(PDTConstants.CANDIDATE_SELECTION, _lnkFormCandSel);
		formMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION, _lnkFormPreTripTransport);
		formMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING, _lnkFormPreTripLodging);
		formMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS, _lnkFormPreTripMeals);		
		formMap.put(PDTConstants.IMMIGRATION_FEES, _lnkFormCollapseOne);
		formMap.put(PDTConstants.IMMIGRATION_TRAVEL, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION, _lnkFormCollapseFive);
		formMap.put(PDTConstants.HOUSE_HUNTING_TRIP_LODGING, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.HOUSE_HUNTING_TRIP_MEALS, _lnkFormCollapseThree);
		formMap.put(PDTConstants.LANGUAGE_TRAINING_EMPLOYEE, _lnkFormCollapseFive);
		formMap.put(PDTConstants.LANGUAGE_TRAINING_FAMILY, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.CULTURAL_TRAINING_EMPLOYEE, _lnkFormCollapseFive);
		formMap.put(PDTConstants.CULTURAL_TRAINING_FAMILY, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.FINAL_MOVE_TRANSPORTATION, _lnkFormCollapseFive);
		formMap.put(PDTConstants.FINAL_MOVE_LODGING, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.FINAL_MOVE_MEALS, _lnkFormCollapseThree);
		formMap.put(PDTConstants.HOME_LEAVE_TRANSPORTATION, _lnkFormCollapseFive);
		formMap.put(PDTConstants.HOME_LEAVE_LODGING, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.HOME_LEAVE_MEALS, _lnkFormCollapseThree);
		formMap.put(PDTConstants.TEMPORARY_LIVING_LODGING, _lnkFormCollapseFive);
		formMap.put(PDTConstants.TEMPORARY_LIVING_MEALS, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.TEMPORARY_LIVING_TRANSPORTATION, _lnkFormCollapseThree);
		formMap.put(PDTConstants.AIRPORT_PICKUP, _lnkFormCollapseAirport);
		formMap.put(PDTConstants.AREA_TOUR, _lnkFormCollapseTour);
		formMap.put(PDTConstants.AUTO_RENTAL_DURING_ASSIGNMENT, _lnkFormCollapseAutoRental);
		formMap.put(PDTConstants.CONCIERGE_SERVICES, _lnkFormCollapseConciergeServices);
		formMap.put(PDTConstants.DEPARTURE_SERVICES, _lnkFormCollapseDepartureServices);
		formMap.put(PDTConstants.FURNITURE_RENTAL, _lnkFormCollapseFurnitureRental);
		formMap.put(PDTConstants.REIMBURSEMENT_OF_MEMEBERSHIP_DUES, _lnkFormCollapseMembershipDues);
		formMap.put(PDTConstants.EDUCATION_ASSISTANCE, _lnkFormCollapseSchoolSearch);
		formMap.put(PDTConstants.EDUCATION_ASSISTANT, _lnkFormCollapseSchoolSearch);
		formMap.put(PDTConstants.SETTLING_IN_SERVICES, _lnkFormCollapseSettlingInServices);
		formMap.put(PDTConstants.TRANSITION_ASSISTANCE_PROGRAM, _lnkFormCollapseTransitionAssistances);
		formMap.put(PDTConstants.TUTION_AND_EDUCATION, _lnkFormCollapseTutionEducation);
		formMap.put(PDTConstants.RENTAL_TOUR, _lnkFormCollapseOne);
		formMap.put(PDTConstants.FINDER_FEES, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.LETTER_OF_ASSIGNMENT, _lnkFormCollapseOne);
		formMap.put(PDTConstants.COST_ESTIMATE_WITH_TAX, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.COST_ESTIMATE_WITHOUT_TAX, _lnkFormCollapseThree);
		formMap.put(PDTConstants.BALANCE_SHEET, _lnkFormCollapseFour);
		formMap.put(PDTConstants.ALLOWANCE_UPDATES, _lnkFormCollapse5);
		formMap.put(PDTConstants.GLOBAL_DATA_COLLECTION, _lnkFormCollapseSix);
		formMap.put(PDTConstants.PAYROLL_INSTRUCTIONS, _lnkFormCollapseSeven);
		formMap.put(PDTConstants.ASSIGNMENT_HOUSING, _lnkFormCollapseFive);
		formMap.put(PDTConstants.SECURITY_DEPOSIT, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.MISC_RELOCATION_ALLOWANCE, _lnkFormCollapseOne);
		formMap.put(PDTConstants.LUMP_SUM, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.LEASE_BREAK, _lnkFormCollapseThree);
		formMap.put(PDTConstants.APPLIANCE_ALLOWANCE, _lnkFormCollapseFour);
		formMap.put(PDTConstants.AUTO_REGISTRATION_COSTS, _lnkFormCollapse5);
		formMap.put(PDTConstants.AUTO_LOSS_ON_SALE, _lnkFormCollapseSix);
		formMap.put(PDTConstants.OTHER_ONE_TIME_PAYMENT, _lnkFormCollapseSeven);
		formMap.put(PDTConstants.COLA, _lnkFormCollapseOne);
		formMap.put(PDTConstants.PER_DIEM, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.MOBILITY_PREMIUM, _lnkFormCollapseThree);
		formMap.put(PDTConstants.TRANSPORTATION_ALLOWANCE, _lnkFormCollapseFour);
		formMap.put(PDTConstants.HOUSING_ALLOWANCE, _lnkFormCollapse5);
		formMap.put(PDTConstants.HOME_MAINTENANCE_ALLOWANCE, _lnkFormCollapseSix);
		formMap.put(PDTConstants.FURNITURE_ALLOWANCE, _lnkFormCollapseSeven);
		formMap.put(PDTConstants.HARDSHIP_ALLOWANCE, _lnkFormCollapseEight);
		formMap.put(PDTConstants.BANKING_ALLOWANCE, _lnkFormCollapseNine);
		formMap.put(PDTConstants.AT_SEA_ALLOWANCE, _lnkFormCollapseTen);
		formMap.put(PDTConstants.COMMUTER_ALLOWANCE, _lnkFormCollapseEleven);
		formMap.put(PDTConstants.DIFFERENTIAL_ALLOWANCE, _lnkFormCollapseTwelve);
		formMap.put(PDTConstants.GOODS_AND_SERVICES_ALLOWANCE, _lnkFormCollapseThirteen);
		formMap.put(PDTConstants.HOME_LEAVE_ALLOWANCE, _lnkFormCollapseFourteen);
		formMap.put(PDTConstants.HOME_RETENTION_ALLOWANCE, _lnkFormCollapseFifteen);
		formMap.put(PDTConstants.HOUSEKEEPING_ALLOWANCE, _lnkFormCollapseSixteen);
		formMap.put(PDTConstants.UTILITY_ALLOWANCE, _lnkFormCollapseSeventeen);
		formMap.put(PDTConstants.OTHER_ONGOING_ALLOWANCE, _lnkFormCollapseEightteen);
		formMap.put(PDTConstants.HOME_PURCHASE_CLOSING_COSTS, _lnkFormCollapseFive);
		formMap.put(PDTConstants.HOME_PURCHASE_POINTS, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.HOME_PURCHASE_INSPECTIONS, _lnkFormCollapseThree);
		formMap.put(PDTConstants.HOME_PURCHASE_BONUS, _lnkFormCollapseFour);
		formMap.put(PDTConstants.MORTGAGE_DIFFERENTIALS, _lnkFormCollapse5);
		formMap.put(PDTConstants.MORTGAGE_SUBSIDY, _lnkFormCollapseSix);
		formMap.put(PDTConstants.US_DOM_VANLINE_SHIPMENT, _lnkFormCollapseFive);
		formMap.put(PDTConstants.AUTO_SHIPMENT, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.SELF_MOVE, _lnkFormCollapseThree);
		formMap.put(PDTConstants.AIR_SHIPMENT, _lnkFormCollapseFour);
		formMap.put(PDTConstants.SEA_SHIPMENT, _lnkFormCollapse5);
		formMap.put(PDTConstants.NONUS_INLAND_SHIPMENT, _lnkFormCollapseSix);
		formMap.put(PDTConstants.PERMANENT_STORAGE, _lnkFormCollapseSeven);
		formMap.put(PDTConstants.PET_SHIPMENT, _lnkFormCollapse8);
		formMap.put(PDTConstants.DISCARD_DONATE, _lnkFormCollapse9);

	}

	public void exitFromPolicyBenefitPage() {
		waitForProgressBarToDisapper();
		CoreFunctions.click(driver, _btnExit, PDTConstants.EXIT);
		if (CoreFunctions.isElementExist(driver, _dialogconfirmation, 1)) {
			CoreFunctions.clickWithoutReporting(driver, _btnOk, _btnOk.getText());
		}
	}

	public boolean verifySaveSuccessMessage(String msg, String pageName, PDT_AddNewPolicyPage addNewPolicyPage) {
		try {
			waitForProgressBarToDisapper();
			if (CoreFunctions.isElementExist(driver, _successPopUp, 5) && _successMsg.getText().equalsIgnoreCase(msg)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_SUCCESS_MSG, CoreConstants.PASS,
						_successMsg.getText(), pageName));
				CoreFunctions.clickElement(driver, _btnOkOnSuccessPopUp);
				return true;
			}
		} catch (Exception e) {
			Assert.fail(
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_SUCCESS_MSG, CoreConstants.FAIL, msg, pageName));
		}
		return false;
	}

	public void populateBtnMap() {
		buttonMap.put(PDTConstants.PDT_BTN_SAVE_SUBMIT, _btnSaveAndSubmit);
		buttonMap.put(PDTConstants.EXIT.toUpperCase(), _btnExit);
		buttonMap.put(PDTConstants.BTN_APPROVE_POLICY, _btnApprovePolicy);
		buttonMap.put(PDTConstants.BTN_APPROVE, _btnApprove);
		buttonMap.put(PDTConstants.BTN_CANCEL, _btnCancel);
		buttonMap.put(PDTConstants.SAVE, _btnSave);
		buttonMap.put(PDTConstants.SAVE_AND_CONTINUE, _btnSaveAndContinue);
		buttonMap.put(PDTConstants.BACK.toUpperCase(), _btnBack);
		buttonMap.put(PDTConstants.NEXT.toUpperCase(), _btnNext);
	}

	public void populateConfirmDialogbuttonMap() {
		confirmationDialogButtonMap.put(PDTConstants.OK, _btnOkOnConfirmationDialog);
		confirmationDialogButtonMap.put(PDTConstants.CANCEL, _btnCancelOnConfirmationDialog);
		confirmationDialogButtonMap.put(PDTConstants.SAVE, _btnSaveOnConfirmationDialog);
	}

	public void clickOnConfirmDialogBtn(String btnName) {
		try {
			if (CoreFunctions.isElementExist(driver, _dialogconfirmation, 1))
				CoreFunctions.click(driver, confirmationDialogButtonMap.get(btnName), btnName);
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}
	}

	public boolean verifySubBenefitCategoriesAreUnchecked(String subBenefitCategoryName) {
		List<Boolean> resultList = new ArrayList<Boolean>();
		for (WebElement _chBoxSubBenefit : _chkBoxesSubBenefitCategories) {
			if (_chBoxSubBenefit.getDomProperty("checked").equals("false")) {
				resultList.add(true);
			}

		}
		if (resultList.stream().allMatch(t -> t.equals(true))) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DATA_NOT_SAVED_SUB_BENEFIT,
					CoreConstants.PASS, subBenefitCategoryName));
			return true;
		}
		return false;
	}

	public boolean verifyButtonVisible(String btnName, PDT_PolicyBenefitCategoryPage policyBenefitCategoryPage) {
		try {
			waitForProgressBarToDisapper();
			if (CoreFunctions.isElementExist(driver, _btnApprovePolicy, 5)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_BTN_VISIBLE, CoreConstants.PASS, btnName,
						policyBenefitCategoryPage.getBenefitCategoryName()));

				return true;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_VISIBLE, CoreConstants.FAIL, btnName,
					policyBenefitCategoryPage.getBenefitCategoryName()));
		}
		return false;
	}

	public boolean verifyButtonDisabled(String btnName, PDT_PolicyBenefitCategoryPage policyBenefitCategoryPage) {
		try {
			if (_btnSaveAndSubmit.getAttribute("disabled").equalsIgnoreCase("true")) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_BTN_ENABLED, CoreConstants.PASS, btnName,
						policyBenefitCategoryPage.getBenefitCategoryName()));
				return true;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_DISABLED, CoreConstants.FAIL, btnName,
					policyBenefitCategoryPage.getBenefitCategoryName()));
		}
		return false;
	}

	public void clickElementOfPage(String btnName, String pageName) {
		try {
			waitForProgressBarToDisapper();
			CoreFunctions.clickUsingJS(driver, buttonMap.get(btnName), btnName);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK, CoreConstants.FAIL,
					PDTConstants.BTN_APPROVE_POLICY, pageName));
		}
	}

	public void verifyHeadingAndMsgOfPopUp(List<List<String>> data) {
		waitForProgressBarToDisapper();
		CoreFunctions.explicitWaitForElementTextPresent(driver, _headerApprovePopUp, data.get(0).get(1), 10);
		CoreFunctions.verifyText(driver, _headerApprovePopUp, data.get(0).get(1), data.get(0).get(0));
		CoreFunctions.verifyText(driver, _msg1ApprovePopUp, data.get(1).get(1), data.get(1).get(0));
		CoreFunctions.verifyText(driver, _msg2ApprovePopUp, data.get(2).get(1), data.get(2).get(0));
	}

	public boolean verifyCheckBoxAndMsg(String fieldName, String msg, String status) {
		try {
			if (status.equalsIgnoreCase("disabled")
					&& _chkBoxExistingDateInd.getAttribute("disabled").equalsIgnoreCase("true")) {
				CoreFunctions.highlightObject(driver, _chkBoxExistingDateInd);
				CoreFunctions.verifyText(driver, _lblExistingDateInd, msg, fieldName);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_CHKBOX_MSG, CoreConstants.PASS, msg, status));
				return true;
			} else if (status.equalsIgnoreCase("enabled")
					&& _chkBoxNewDateInd.getDomProperty("disabled").equalsIgnoreCase("false")) {
				CoreFunctions.highlightObject(driver, _chkBoxNewDateInd);
				CoreFunctions.verifyText(driver, _lblNewDateInd, msg, fieldName);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_CHKBOX_MSG, CoreConstants.PASS, msg, status));
				return true;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CHECKBOX, CoreConstants.FAIL, msg, status));
		}
		return false;
	}

	public boolean verifyButton(String btnName, String btnStatus) {
		try {
			if (btnName.equalsIgnoreCase("approve") && btnStatus.equalsIgnoreCase("disabled")
					&& _btnApprove.getAttribute("disabled").equalsIgnoreCase("true")) {
				CoreFunctions.highlightObject(driver, _btnApprove);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_BTN_STATE, CoreConstants.PASS, btnName, btnStatus));
				return true;
			} else if (btnName.equalsIgnoreCase("approve") && btnStatus.equalsIgnoreCase("enabled")
					&& _btnApprove.getDomProperty("disabled").equalsIgnoreCase("false")) {
				CoreFunctions.highlightObject(driver, _btnApprove);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_BTN_STATE, CoreConstants.PASS, btnName, btnStatus));
				return true;
			} else if (btnName.equalsIgnoreCase("cancel") && btnStatus.equalsIgnoreCase("enabled")
					&& CoreFunctions.isElementExist(driver, _btnCancel, 3)) {
				CoreFunctions.highlightObject(driver, _btnCancel);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_BTN_STATE, CoreConstants.PASS, btnName, btnStatus));
				return true;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, CoreConstants.FAIL, btnName,
					btnStatus));
		}
		return false;
	}

	public void clickAssociateWithNewAuth() {
		CoreFunctions.clickElement(driver, _lblNewDateInd);
	}

	public void clickAssociateWithExistingAuth() {
		CoreFunctions.clickElement(driver, _lblExistingDateInd);
	}

	public void approvePolicy(String btnName, String pageName) {
		try {
			timeBeforeAction = new Date().getTime();
			CoreFunctions.click(driver, buttonMap.get(btnName), btnName);
			waitForProgressBarToDisapper();
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction,
					PDTConstants.VIEW_EDIT_POLICY_FORMS);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK, CoreConstants.FAIL,
					PDTConstants.BTN_APPROVE_POLICY, pageName));
		}
	}

	public boolean verifyStatusAndVersionOfPolicy(String selectedPolicyName, String expectedPolicyStatus,
			String expectedPolicyVersion, String pageName) {
		waitForProgressBarToDisapper();
		CoreFunctions.scrollToElementUsingJS(driver, _policyStatus, _policyStatusText.getText());
		CoreFunctions.explicitWaitForElementTextPresent(driver, _policyStatusText, _policyStatusText.getText(), 10);
		if (expectedPolicyStatus.equalsIgnoreCase(_policyStatus.getText().trim())
				&& expectedPolicyVersion.equalsIgnoreCase(_policyVersion.getText().trim())) {
			CoreFunctions.highlightObject(driver, _policyStatus);
			CoreFunctions.highlightObject(driver, _policyVersion);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_POLICY_VERSION_STATUS, CoreConstants.PASS,
					selectedPolicyName, expectedPolicyVersion, expectedPolicyStatus, pageName));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_VERSION_STATUS,
					CoreConstants.FAIL, selectedPolicyName, expectedPolicyVersion, _policyVersion.getText().trim(),
					expectedPolicyStatus, _policyStatus.getText().trim(), pageName));
			return false;
		}
	}

	public void clickButtonOnApprovePolicyPopUp(String btnName, String pageName) {
		try {
			populateBtnMap();
			if (btnName.equalsIgnoreCase(PDTConstants.BTN_APPROVE)) {
				approvePolicy(btnName, pageName);
			} else if (btnName.equalsIgnoreCase(PDTConstants.BTN_CANCEL)) {
				CoreFunctions.highlightElementAndClick(driver, buttonMap.get(btnName), btnName);
			} else {
				Assert.fail(MessageFormat.format(PDTConstants.BTN_DOES_NOT_EXIST, CoreConstants.FAIL, btnName));				
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.BTN_DOES_NOT_EXIST, CoreConstants.FAIL, btnName));
		}
	}

	public void navigateBenefitCategories(String benefitCategoryName) {
		waitForProgressBarToDisapper();
		for (WebElement benefitName : _leftNavBenefitCategories) {
			if (_benefitCategoryName.getText().trim().equalsIgnoreCase(benefitCategoryName))
				return;
			else
				CoreFunctions.click(driver, _btnSaveAndContinue, _btnSaveAndContinue.getText());
		}
	}

	public void populateSubBenefitAncestorMap() {
		subBenefitAncestorMap.put(PDTConstants.CANDIDATE_SELECTION, _lnkFormCollapseOne);
		subBenefitAncestorMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION, _lnkFormCollapseTwo);
		subBenefitAncestorMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING, _lnkFormCollapseThree);
		subBenefitAncestorMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS, _lnkFormCollapseFour);
	}
	
	public boolean verifySavedIndicatorForBenefit(String benefitCategoryName) {
		waitForProgressBarToDisapper();
		int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listBenefitCategoryNameOnLeftMenu, benefitCategoryName);
		if(_listIconOnLeftmenu.get(index).getText().equalsIgnoreCase("check_circle_outline")) {
			CoreFunctions.highlightObject(driver, _listIconWithBenefitCategoryNameOnLeftmenu.get(index));
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON_INDICATOR, CoreConstants.PASS, PDTConstants.SAVE_INDICATOR, benefitCategoryName));
			return true;
		}
		return false;
	}
	
	public String getCurrentBenefitCategoryName(String pageName) {
		WebElement element = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES)				
						? _benefitCatName
						: _benefitCategoryName;
		/*WebElement element = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES)
				&& System.getProperty("envt").toLowerCase().equalsIgnoreCase(CoreConstants.ENVT_QA)
						? _benefitCatName
						: _benefitCategoryName;*/
		return element.getText();
	}
	
	public boolean verifyUserStaysOnSamePage(String expectedPageName) {
		if(expectedPageName.equalsIgnoreCase(getCurrentBenefitCategoryName(expectedPageName))) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_STAYS_ON_SAME_PAGE, CoreConstants.PASS, expectedPageName));
			return true;
		}
		return false;
	}
	
	public String getPolicyStatus() {
		return _policyStat.getText().split(" ")[0];
	}
	
	public boolean verifyPolicyStatusRemainsSame(String policyStatusBeforeSave) {
		if(policyStatusBeforeSave.equalsIgnoreCase(getPolicyStatus())) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_POLICY_STATUS_REMAINS_SAME, CoreConstants.PASS, policyStatusBeforeSave, PDTConstants.SAVE));
			return true;
		}
		return false;
	}
	
	public void iterateEachBenefitCategory(List<String> benefitsList, TestContext testContext, PDT_SharedSubBenefitPage subBenefitPage, PDT_AddNewPolicyPage addNewPolicyPage) {
		for (String benefitCategory : benefitsList) {
			List<String> subBenefits = BusinessFunctions.getSubBenefitList(benefitCategory);
			PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
			verifySelectedPolicyBenefitCategoryName(benefitCategory);
			verifySubBenefitCategoriesAreDisplayed(subBenefits, benefitCategory);
			if(benefitsList.get(benefitsList.size()-1).equalsIgnoreCase(benefitCategory))
				iterateAndSelectSubBenefits(benefitCategory, subBenefits, addNewPolicyPage, objStep);
			else
				iterateAndSelectSubBenefits(benefitCategory, subBenefits, addNewPolicyPage, objStep, PDTConstants.SAVE_AND_CONTINUE);
		}
	}
	
	public void iterateAndSelectSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		populateFormHeaderElement();
		populateSubBenefitAncestorMap();
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			if (CoreFunctions.isElementExist(driver, _progressBar, 4))
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			Assert.assertTrue(
					verifyFormIsDisplayed(subBenefit, getElementByName(pageName, subBenefit), subBenefit, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefit, pageName));
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			fillSubBenefitForm(subBenefit, addNewPolicyPage, objStep, pageName);
		}
	}
	
	public boolean verifyIconIndicatorForBenefitCategories(ArrayList<String> benefitCategoryList, String indicatorName, String iconIndicator) {
		populateIconIndicatorMap();		
		if (CoreFunctions.isElementExist(driver, _progressBar, 7))
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		for(String benefitCategoryName : benefitCategoryList) {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listBenefitCategoryNameOnLeftMenu, benefitCategoryName);
			if(_listIconOnLeftmenu.get(index).getText().equalsIgnoreCase(iconIndicator)) {
				CoreFunctions.highlightObject(driver, _listIconWithBenefitCategoryNameOnLeftmenu.get(index));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON_INDICATOR, CoreConstants.PASS, indicatorName, benefitCategoryName));
				
			} else
				failedCategoriesWithIconMap.put(benefitCategoryName, _listIconOnLeftmenu.get(index).getText());
		}	
		boolean result = failedCategoriesWithIconMap.size() > 0 ? false:true;
		return result;		
	}

	public void populateIconIndicatorMap() {
		iconIndicatorMap.put("check_circle_outline", PDTConstants.SAVE_INDICATOR_LEFT_MENU);
		iconIndicatorMap.put("error", PDTConstants.ERROR_INDICATOR_LEFT_MENU);
		iconIndicatorMap.put("assignment", PDTConstants.DRAFT_INDICATOR_LEFT_MENU);
	}
	
	public String printFailedCategoriesWithIcon(String expectedIconIndicator) {
		String msgToPrint = "";
		 for(Map.Entry<String,String>it:failedCategoriesWithIconMap.entrySet())
			 msgToPrint.concat(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_CATEGORY_NAME, CoreConstants.FAIL, it.getKey(), expectedIconIndicator, expectedIconIndicator, iconIndicatorMap.get(it.getValue())));
		 return msgToPrint;
	}
	
	public void clickOnBtn(String btnName) {
		try {
			CoreFunctions.clickUsingJS(driver, buttonMap.get(btnName), btnName);
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}
	}
	
	public boolean verifyIconColorAndName(String iconColor, String iconName) {
		if(_policyIconStat.getText().equalsIgnoreCase(iconName) && _policyIconStat.getAttribute("color").equalsIgnoreCase(iconColor)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON_COLOR_NAME_ON_HEADER, CoreConstants.PASS, iconColor, iconName));
			return true;
		}
		return false;		
	}
	
	public String getIconColor() {
		return _policyIconStat.getAttribute("color");
	}
	
	public String getIconName() {
		return _policyIconStat.getText();
	}
	
	public String getCategoryName() {
		return _benefitCategoryName.getText();
	}
	
	public boolean verifyRedAlertIconOnSubBenefitName(List<String> subBenefitNameList) {
		waitForProgressBarToDisapper();
		for(String subBenefitName : subBenefitNameList) {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listSubBenefitName, subBenefitName, true);
			if(index > -1 &&_listRedErrorIconOnSubBenefitName.get(index).getText().equalsIgnoreCase("error") && _listRedErrorIconOnSubBenefitName.get(index).getAttribute("class").contains("tabError")) {
				CoreFunctions.highlightObject(driver, _listRedErrorIconOnSubBenefitName.get(index));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_RED_ERROR_INDICATOR_ON_SUBBENEFIT, CoreConstants.PASS, PDTConstants.RED_COLOR_ERR_INDICATOR, subBenefitName));
				
			} else
				failedSubBenefits.add(subBenefitName);
		}	
		boolean result = failedSubBenefits.size() > 0 ? false:true;
		return result;
	}
	
	public String printFailedSubBenefitNameWithoutRedIcon() {
		String msgToPrint = "";
		 for(String subBenefitName : failedSubBenefits)
			 msgToPrint.concat(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_RED_COLOR_ICON_DISPLAYED_ON_SUBBENEFIT, CoreConstants.FAIL, subBenefitName).concat("<br/>"));
		 return msgToPrint;
	}
	
	public boolean verifyErrorIndicatorForBenefit(String benefitCategoryName) {
		waitForProgressBarToDisapper();
		int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listBenefitCategoryNameOnLeftMenu, benefitCategoryName);
		if(_listIconOnLeftmenu.get(index).getText().equalsIgnoreCase("error")) {
			CoreFunctions.highlightObject(driver, _listIconWithBenefitCategoryNameOnLeftmenu.get(index));
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON_INDICATOR, CoreConstants.PASS, PDTConstants.ERROR_IND, benefitCategoryName));
			return true;
		}
		return false;
	}
	
	public void iterateEachBenefitCat(List<String> benefitsList, TestContext testContext, PDT_SharedSubBenefitPage subBenefitPage, PDT_AddNewPolicyPage addNewPolicyPage) {
		for (String benefitCategory : benefitsList) {
			List<String> subBenefits = BusinessFunctions.getSubBenefitList(benefitCategory);
			PDT_SharedSubBenefit_Steps objStep = new PDT_SharedSubBenefit_Steps(testContext);
			verifySelectedPolicyBenefitCategoryName(benefitCategory);
			verifySubBenefitCategoriesAreDisplayed(subBenefits, benefitCategory);
			subBenefitPage.setCompletePolicyState(false);
			if(benefitsList.get(benefitsList.size()-1).equalsIgnoreCase(benefitCategory))
				iterateAndSelectSubBenefits(benefitCategory, subBenefits, addNewPolicyPage, objStep);
			else
				iterateAndSelectSubBenefits(benefitCategory, subBenefits, addNewPolicyPage, objStep, PDTConstants.SAVE_AND_CONTINUE);
		}
	}
	
	public boolean verifyWarningTitle(String warnTitle) {
		waitForProgressBarToDisapper();
		if(_warningTitle.getText().equalsIgnoreCase(warnTitle)) {
			CoreFunctions.highlightObject(driver, _warningTitle);			
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_WARNING_TITLE, CoreConstants.PASS, warnTitle));
			return true;
		}
		return false;
	}
	
	public boolean verifyWarningMessage(String warnMsg) {
		if(_warningMsg.getText().equalsIgnoreCase(warnMsg)) {			
			CoreFunctions.highlightObject(driver, _warningMsg);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_WARNING_MESSAGE, CoreConstants.PASS, warnMsg));
			return true;
		}
		return false;
	}
	
	public String getWarningTitle() {
		return _warningTitle.getText();
	}
	
	public String getWarningMsg() {
		return _warningMsg.getText();
	}
	
	public void initPDTAllPagesList(List<String> benefitCategoryList) {
		pdtPagesList.add(PDTConstants.GENERAL_INFORMATION);
		pdtPagesList.add(PDTConstants.POLICY_BENEFIT_CATEGORIES);
		pdtPagesList.addAll(benefitCategoryList);
	}
	
	public ArrayList<String> getPDTPagesList(){
		return pdtPagesList;
	}
	
	public void waitForProgressBarToDisapper() {
		if(CoreFunctions.isElementExist(driver, _progressBar, 7)) {		
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);			
		}
	}
	
	public boolean verifyPageName(String pageName) {
		if (CoreFunctions.isElementExist(driver, _progressBar, 4))
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		try {
			WebElement element = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES)					
							? _benefitCatName
							: _benefitCategoryName;
			
			/*WebElement element = pageName.trim().equalsIgnoreCase(PDTConstants.PRE_ACCEPTANCE_SERVICES)
					&& System.getProperty("envt").toLowerCase().equalsIgnoreCase(CoreConstants.ENVT_QA)
							? _benefitCatName
							: _benefitCategoryName;*/
			
			CoreFunctions.explicitWaitForElementTextPresent(driver, element, pageName, 3);
			if(element.getText().equalsIgnoreCase(pageName)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_NAVIGATED_TO_PREV_PAGE, CoreConstants.PASS, pageName));
				return true;
			} else
				failedExpectedActualPrevPagMap.put(pageName, element.getText());
		} catch(Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCUR_NAV_TO_PREV_PAGE,
						CoreConstants.FAIL));			
		}
		return false;
	}
	
	public boolean verifyUserNavigateToPrevPage() {
		ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		Collections.reverse(pdtPagesList);		
		for(int i = 1; i <= pdtPagesList.size()-1; i++) {
			waitForProgressBarToDisapper();
			resultList.add(verifyPageName(pdtPagesList.get(i)));
			if(i <  pdtPagesList.size()-1)
				clickOnBtn(PDTConstants.BACK.toUpperCase());
		}
		return resultList.stream().allMatch(n -> n == true);
	}
	
	public String printFailedExpectedActualPrevPageMap() {
		String str = "";
        for (Map.Entry<String, String> set :
        	failedExpectedActualPrevPagMap.entrySet()) {
        	str.concat(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_NAVIGATED_TO_PREV_PAGE, CoreConstants.FAIL, set.getKey(), set.getValue())).concat("<br/>");
       }
        return str;
	}
}
