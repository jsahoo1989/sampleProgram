package com.aires.pages.pdt;

import java.text.MessageFormat;
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
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_SharedSubBenefitPage extends Base {
	public PDT_SharedSubBenefitPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;

	@FindBy(how = How.CSS, using = "a[href='#collapseOne']")
	private WebElement _lnkFormCollapseOne;

	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _lnkFormCollapseTwo;

	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _lnkFormCollapseThree;

	@FindBy(how = How.CSS, using = "a[href='#collapseFour']")
	private WebElement _lnkFormCollapseFour;

	@FindBy(how = How.CSS, using = "div.card-header-info > h4.card-title")
	private WebElement _benefitCategoryName;

	@FindBy(how = How.CSS, using = "button.btn-next[type='submit']")
	private WebElement _btnSaveAndContinue;

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
	
	HashMap<String, Boolean> resultMapForTabNameNotMatch = new HashMap<>();
	LinkedHashMap<String, WebElement> formMap= new LinkedHashMap<String, WebElement>();

	public WebElement getElementByName(String elementName) {		
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
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		populateFormHeaderElement();
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			Assert.assertTrue(verifyFormIsDisplayed(subBenefit, getElementByName(subBenefit), subBenefit, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefit, pageName));
			fillSubBenefitForm(subBenefit, addNewPolicyPage, objStep);
		}
		try {
			CoreFunctions.click(driver, _btnSaveAndContinue, _btnSaveAndContinue.getText());
		} catch (NoSuchElementException e) {
			Assert.fail(PDTConstants.MISSING_SAVE_AND_SUBMIT_BTN);
	    } 
		catch (Exception e) {
			Assert.fail(PDTConstants.FAILED_TO_CLICK_ON_SAVE_AND_SUBMIT_BTN);
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
			PDT_SharedSubBenefit_Steps subBenefitSteps) {
		expandSubBenefitIfCollapsed(getElementByName(subBenefit));
		switch (subBenefit) {
		case PDTConstants.CANDIDATE_SELECTION:
			subBenefitSteps.getPreAcceptServicePage().fillCandidateSelection(addNewPolicyPage, PDTConstants.CANDIDATE_SELECTION);
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			subBenefitSteps.getPreAcceptServicePage().fillPreAcceptanceTripTransportation(addNewPolicyPage, PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION);
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			subBenefitSteps.getPreAcceptServicePage().fillPreAcceptanceTripLodging(addNewPolicyPage, PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING);
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			subBenefitSteps.getPreAcceptServicePage().fillPreAcceptanceTripMeals(addNewPolicyPage, PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS);
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
					PDTConstants.LANGUAGE_TRAINING_EMPLOYEE);
			break;
		case PDTConstants.LANGUAGE_TRAINING_FAMILY:
			subBenefitSteps.getLanguageTrainingPage().fillLanguageTrainingFamily(addNewPolicyPage,
					PDTConstants.LANGUAGE_TRAINING_FAMILY);
			break;
		case PDTConstants.CULTURAL_TRAINING_EMPLOYEE:
			subBenefitSteps.getCulturalTrainingPage().fillCulturalTrainingEmployee(addNewPolicyPage,
					PDTConstants.CULTURAL_TRAINING_EMPLOYEE);
			break;
		case PDTConstants.CULTURAL_TRAINING_FAMILY:
			subBenefitSteps.getCulturalTrainingPage().fillCulturalTrainingFamily(addNewPolicyPage,
					PDTConstants.CULTURAL_TRAINING_FAMILY);
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
			subBenefitSteps.getFinalMovePage().fillFinalMoveMealForm(addNewPolicyPage,
					PDTConstants.FINAL_MOVE_MEALS);
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
			subBenefitSteps.getHomeLeavePage().fillHomeLeaveMealForm(addNewPolicyPage,
					PDTConstants.HOME_LEAVE_MEALS);
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
			subBenefitSteps.getDestinationServicePage().fillAirPortPickUpForm(addNewPolicyPage, PDTConstants.AIRPORT_PICKUP);
			break;
		case PDTConstants.AREA_TOUR:
			subBenefitSteps.getDestinationServicePage().fillAreaTourForm(addNewPolicyPage, PDTConstants.AREA_TOUR);
			break;
		case PDTConstants.AUTO_RENTAL_DURING_ASSIGNMENT:
			subBenefitSteps.getDestinationServicePage().fillAutoRentalForm(addNewPolicyPage, PDTConstants.AUTO_RENTAL_DURING_ASSIGNMENT);
			break;
		case PDTConstants.CONCIERGE_SERVICES:
			subBenefitSteps.getDestinationServicePage().fillConciergeServicesForm(addNewPolicyPage, PDTConstants.CONCIERGE_SERVICES);
			break;
		case PDTConstants.DEPARTURE_SERVICES:
			subBenefitSteps.getDestinationServicePage().fillDepartureServicesForm(addNewPolicyPage, PDTConstants.DEPARTURE_SERVICES);
			break;
		case PDTConstants.FURNITURE_RENTAL:
			subBenefitSteps.getDestinationServicePage().fillFurnitureRentalForm(addNewPolicyPage, PDTConstants.FURNITURE_RENTAL);
			break;
		case PDTConstants.REIMBURSEMENT_OF_MEMEBERSHIP_DUES:
			subBenefitSteps.getDestinationServicePage().fillReimbursementOfMembershipDuesForm(addNewPolicyPage, PDTConstants.REIMBURSEMENT_OF_MEMEBERSHIP_DUES);
			break;
		case PDTConstants.SCHOOL_SEARCH:
			subBenefitSteps.getDestinationServicePage().fillSchoolSearchForm(addNewPolicyPage, PDTConstants.SCHOOL_SEARCH);
			break;
		case PDTConstants.SETTLING_IN_SERVICES:
			subBenefitSteps.getDestinationServicePage().fillSettlingServicesForm(addNewPolicyPage, PDTConstants.SETTLING_IN_SERVICES);
			break;
		case PDTConstants.TRANSITION_ASSISTANCE_PROGRAM:
			subBenefitSteps.getDestinationServicePage().fillTransitionAssistanceProgramForm(addNewPolicyPage, PDTConstants.TRANSITION_ASSISTANCE_PROGRAM);
			break;
		case PDTConstants.TUTION_AND_EDUCATION:
			subBenefitSteps.getDestinationServicePage().fillTutionAndEductionForm(addNewPolicyPage, PDTConstants.TUTION_AND_EDUCATION);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	public void expandSubBenefitIfCollapsed(WebElement subBenefitForm) {
		try {
			if (subBenefitForm.getAttribute("class").equalsIgnoreCase("collapsed"))
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
			CoreFunctions.click(driver, _lblCandidateSelEmpType,
					_lblCandidateSelEmpType.getText() + "(" + PDTConstants.CANDIDATE_SELECTION + ")");
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblPreAcceptTripTransportEmpType,
					_lblPreAcceptTripTransportEmpType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION
							+ ")");
			CoreFunctions.click(driver, _lblPreAcceptTripTransportEmpType, _lblPreAcceptTripTransportEmpType.getText()
					+ "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION + ")");
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblPreAcceptTripLodgingEmpType,
					_lblPreAcceptTripLodgingEmpType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING + ")");
			CoreFunctions.click(driver, _lblPreAcceptTripLodgingEmpType,
					_lblPreAcceptTripLodgingEmpType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING + ")");
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblPreAcceptTripMealEmpType,
					_lblPreAcceptTripMealEmpType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS + ")");
			CoreFunctions.click(driver, _lblPreAcceptTripMealEmpType,
					_lblPreAcceptTripMealEmpType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS + ")");
			break;
		}
	}

	public void selectHomeOwnerTypeForSubBenefit(String subBenefit) {
		switch (subBenefit) {
		case PDTConstants.CANDIDATE_SELECTION:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblCandidateSelHomeOwnerType,
					_lblCandidateSelHomeOwnerType.getText() + "(" + PDTConstants.CANDIDATE_SELECTION + ")");
			CoreFunctions.click(driver, _lblCandidateSelHomeOwnerType,
					_lblCandidateSelHomeOwnerType.getText() + "(" + PDTConstants.CANDIDATE_SELECTION + ")");
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblPreAcceptTripTransportHomeOwnerType,
					_lblPreAcceptTripTransportHomeOwnerType.getText() + "("
							+ PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION + ")");
			CoreFunctions.click(driver, _lblPreAcceptTripTransportHomeOwnerType,
					_lblPreAcceptTripTransportHomeOwnerType.getText() + "("
							+ PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION + ")");
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblPreAcceptTripLodgingHomeOwnerType,
					_lblPreAcceptTripLodgingHomeOwnerType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING
							+ ")");
			CoreFunctions.click(driver, _lblPreAcceptTripLodgingHomeOwnerType,
					_lblPreAcceptTripLodgingHomeOwnerType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING
							+ ")");
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _lblPreAcceptTripMealHomeOwnerType,
					_lblPreAcceptTripMealHomeOwnerType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS + ")");
			CoreFunctions.click(driver, _lblPreAcceptTripMealHomeOwnerType,
					_lblPreAcceptTripMealHomeOwnerType.getText() + "(" + PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS + ")");
			break;
		}
	}

	public void selectSubBenefit(String subBenefitName, String pageName, PDT_AddNewPolicyPage addNewPolicyPage) {
		try {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefitName, true);
			Assert.assertTrue(verifyFormIsDisplayed(subBenefitName, getElementByName(subBenefitName), subBenefitName, pageName),
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
			CoreFunctions.explicitWaitForElementTextPresent(driver, _txtSubBenefitName, pageName, 3);
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
		try {
			CoreFunctions.explicitWaitForElementTextPresent(driver, _txtSubBenefitName, pageName, 3);
			for (int i = 0; i < subBenefits.size(); i++) {
				expandSubBenefitIfCollapsed(getElementByName(subBenefits.get(i).get("SubBenefit")));
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
		for (Map.Entry m : resultMapForTabNameNotMatch.entrySet()) {
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
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_SUB_BENEFITS, CoreConstants.FAIL, pageName,
					subBenefitsFromDataTable.toString(),
					CoreFunctions.getElementTextAndStoreInList(driver, _subBenefitCategories).toString()));
	}
	
	public void verifySelectedPolicyBenefitCategoryName(String pageName) {
		CoreFunctions.explicitWaitForElementTextPresent(driver, _benefitCategoryName, pageName, 3);		
		if(!CoreFunctions.verifyElementOnPage(driver, _benefitCategoryName, PDTConstants.POLICY_BENEFIT_CATEGORY, pageName, pageName,
				true))
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL,
					PDTConstants.POLICY_BENEFIT_CATEGORY, pageName, pageName, _benefitCategoryName.getText()));
	}
	
	public void populateFormHeaderElement() {
		formMap.put(PDTConstants.CANDIDATE_SELECTION, _lnkFormCollapseOne);
		formMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION, _lnkFormCollapseTwo);
		formMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING, _lnkFormCollapseThree);
		formMap.put(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS, _lnkFormCollapseFour);
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
		formMap.put(PDTConstants.AIRPORT_PICKUP, _lnkFormCollapseAirport);
		formMap.put(PDTConstants.AREA_TOUR, _lnkFormCollapseTour);
		formMap.put(PDTConstants.AUTO_RENTAL_DURING_ASSIGNMENT, _lnkFormCollapseAutoRental);
		formMap.put(PDTConstants.CONCIERGE_SERVICES, _lnkFormCollapseConciergeServices);
		formMap.put(PDTConstants.DEPARTURE_SERVICES, _lnkFormCollapseDepartureServices);
		formMap.put(PDTConstants.FURNITURE_RENTAL, _lnkFormCollapseFurnitureRental);
		formMap.put(PDTConstants.REIMBURSEMENT_OF_MEMEBERSHIP_DUES, _lnkFormCollapseMembershipDues);
		formMap.put(PDTConstants.SCHOOL_SEARCH, _lnkFormCollapseSchoolSearch);
		formMap.put(PDTConstants.SETTLING_IN_SERVICES, _lnkFormCollapseSettlingInServices);
		formMap.put(PDTConstants.TRANSITION_ASSISTANCE_PROGRAM, _lnkFormCollapseTransitionAssistances);
		formMap.put(PDTConstants.TUTION_AND_EDUCATION, _lnkFormCollapseTutionEducation);
	}
}
