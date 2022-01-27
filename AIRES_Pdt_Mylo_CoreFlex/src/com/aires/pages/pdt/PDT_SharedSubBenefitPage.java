package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
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
	private WebElement _formCandidateSelection;

	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formPreAcceptanceTripTransportation;

	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _formPreAcceptanceTripLodging;

	@FindBy(how = How.CSS, using = "a[href='#collapseFour']")
	private WebElement _formPreAcceptanceTripMeals;

	@FindBy(how = How.CSS, using = "div.card-header-info > h4.card-title")
	private WebElement _benefitCategoryName;

	@FindBy(how = How.CSS, using = "a[href='#collapseOne']")
	private WebElement _formImmigrationFees;

	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formImmigrationTravel;

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
	private WebElement _formHouseHuntingTripTransportation;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formHouseHuntingTripLodging;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _formHouseHuntingTripMeals;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseOne1']")
	private WebElement _formCulturalTrainingEmployee;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formCulturalTrainingFamily;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseOne1']")
	private WebElement _formLangTrainingEmployee;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formLangTrainingFamily;	
	
	@FindBy(how = How.CSS, using = "a[href='#collapseOne1']")
	private WebElement _formFinalMoveTransportation;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formFinalMoveLodging;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _formFinalMoveMeals;	
	
	HashMap<String, Boolean> resultMapForTabNameNotMatch = new HashMap<>();

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
		case PDTConstants.IMMIGRATION_FEES:
			element = _formImmigrationFees;
			break;
		case PDTConstants.IMMIGRATION_TRAVEL:
			element = _formImmigrationTravel;
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION:
			element = _formHouseHuntingTripTransportation;
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP_LODGING:
			element = _formHouseHuntingTripLodging;
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP_MEALS:
			element = _formHouseHuntingTripMeals;
			break;
		case PDTConstants.LANGUAGE_TRAINING_EMPLOYEE:
			element = _formLangTrainingEmployee;
			break;
		case PDTConstants.LANGUAGE_TRAINING_FAMILY:
			element = _formLangTrainingFamily;
			break;
		case PDTConstants.CULTURAL_TRAINING_EMPLOYEE:
			element = _formCulturalTrainingEmployee;
			break;
		case PDTConstants.CULTURAL_TRAINING_FAMILY:
			element = _formCulturalTrainingFamily;
			break;
		case PDTConstants.FINAL_MOVE_TRANSPORTATION:
			element = _formFinalMoveTransportation;
			break;
		case PDTConstants.FINAL_MOVE_LODGING:
			element = _formFinalMoveLodging;
			break;
		case PDTConstants.FINAL_MOVE_MEALS:
			element = _formFinalMoveMeals;
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return element;
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
//		CoreFunctions.explicitWaitForElementTextPresent(driver, _txtSubBenefitName, pageName, 3);
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			Assert.assertTrue(verifyFormIsDisplayed(subBenefit, getElementByName(subBenefit), pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefit, pageName));
			fillSubBenefitForm(subBenefit, addNewPolicyPage, objStep);
		}
		CoreFunctions.click(driver, _btnSaveAndContinue, _btnSaveAndContinue.getText());
	}

	public boolean verifyFormIsDisplayed(String formName, WebElement element, String pageName) {
		if (element.isDisplayed()) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_DISPLAYED, CoreConstants.PASS,
					formName, pageName));
			return true;
		}
		return false;
	}

	public void fillSubBenefitForm(String subBenefit, PDT_AddNewPolicyPage addNewPolicyPage,
			PDT_SharedSubBenefit_Steps subBenefitSteps) {
		switch (subBenefit) {
		case PDTConstants.CANDIDATE_SELECTION:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.CANDIDATE_SELECTION));
			subBenefitSteps.getPreAcceptServicePage().fillCandidateSelection(addNewPolicyPage, PDTConstants.CANDIDATE_SELECTION);
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION));
			subBenefitSteps.getPreAcceptServicePage().fillPreAcceptanceTripTransportation(addNewPolicyPage, PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION);
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING));
			subBenefitSteps.getPreAcceptServicePage().fillPreAcceptanceTripLodging(addNewPolicyPage, PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING);
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS));
			subBenefitSteps.getPreAcceptServicePage().fillPreAcceptanceTripMeals(addNewPolicyPage, PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS);
			break;
		case PDTConstants.IMMIGRATION_FEES:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.IMMIGRATION_FEES));
			subBenefitSteps.getImmigrationPage().fillImmigrationFeesForm(addNewPolicyPage,
					PDTConstants.IMMIGRATION_FEES);
			break;
		case PDTConstants.IMMIGRATION_TRAVEL:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.IMMIGRATION_TRAVEL));
			subBenefitSteps.getImmigrationPage().fillImmigrationTravelForm(addNewPolicyPage,
					PDTConstants.IMMIGRATION_TRAVEL);
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION));
			subBenefitSteps.getHouseHuntingTripPage().fillHouseHuntingTripTransportationForm(addNewPolicyPage,
					PDTConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION);
			break;
		case PDTConstants.HOUSE_HUNTING_TRIP_LODGING:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.HOUSE_HUNTING_TRIP_LODGING));
			subBenefitSteps.getHouseHuntingTripPage().fillHouseHuntingTripLodgingForm(addNewPolicyPage,
					PDTConstants.HOUSE_HUNTING_TRIP_LODGING);
			break;		
		case PDTConstants.HOUSE_HUNTING_TRIP_MEALS:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.HOUSE_HUNTING_TRIP_MEALS));
			subBenefitSteps.getHouseHuntingTripPage().fillHouseHuntingTripMealForm(addNewPolicyPage,
					PDTConstants.HOUSE_HUNTING_TRIP_MEALS);
			break;
		case PDTConstants.LANGUAGE_TRAINING_EMPLOYEE:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.LANGUAGE_TRAINING_EMPLOYEE));
			subBenefitSteps.getLanguageTrainingPage().fillLanguageTrainingEmployee(addNewPolicyPage,
					PDTConstants.LANGUAGE_TRAINING_EMPLOYEE);
			break;
		case PDTConstants.LANGUAGE_TRAINING_FAMILY:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.LANGUAGE_TRAINING_FAMILY));
			subBenefitSteps.getLanguageTrainingPage().fillLanguageTrainingFamily(addNewPolicyPage,
					PDTConstants.LANGUAGE_TRAINING_FAMILY);
			break;
		case PDTConstants.CULTURAL_TRAINING_EMPLOYEE:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.CULTURAL_TRAINING_EMPLOYEE));
			subBenefitSteps.getCulturalTrainingPage().fillCulturalTrainingEmployee(addNewPolicyPage,
					PDTConstants.CULTURAL_TRAINING_EMPLOYEE);
			break;
		case PDTConstants.CULTURAL_TRAINING_FAMILY:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.CULTURAL_TRAINING_FAMILY));
			subBenefitSteps.getCulturalTrainingPage().fillCulturalTrainingFamily(addNewPolicyPage,
					PDTConstants.CULTURAL_TRAINING_FAMILY);
			break;
		case PDTConstants.FINAL_MOVE_TRANSPORTATION:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.FINAL_MOVE_TRANSPORTATION));			
			subBenefitSteps.getFinalMovePage().fillFinalMoveTransportationForm(addNewPolicyPage,
					PDTConstants.FINAL_MOVE_TRANSPORTATION);
			break;
		case PDTConstants.FINAL_MOVE_LODGING:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.FINAL_MOVE_LODGING));
			subBenefitSteps.getFinalMovePage().fillFinalMoveLodgingForm(addNewPolicyPage,
					PDTConstants.FINAL_MOVE_LODGING);
			break;
		case PDTConstants.FINAL_MOVE_MEALS:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.FINAL_MOVE_MEALS));
			subBenefitSteps.getFinalMovePage().fillFinalMoveMealForm(addNewPolicyPage,
					PDTConstants.FINAL_MOVE_MEALS);
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
			Assert.assertTrue(verifyFormIsDisplayed(subBenefitName, getElementByName(subBenefitName), pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitName, pageName));
		} catch (Exception e) {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
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
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
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
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail("Failed to select 'Benefit differs for home owner Type' checkbox for sub-benefit:-"
					+ subBenefitName + " on " + pageName + "page.");
		}
	}

	public void selectEmployeeTypeHomeOwnerTypeForSubBenefit(String pageName, PDT_AddNewPolicyPage addNewPolicyPage,
			DataTable subBenefitTable) {
		List<Map<String, String>> subBenefits = subBenefitTable.asMaps(String.class, String.class);
		try {
			CoreFunctions.explicitWaitForElementTextPresent(driver, _txtSubBenefitName, pageName, 3);
			for (int i = 0; i < subBenefits.size(); i++) {
				selectSubBenefit(subBenefits.get(i).get("SubBenefit"), pageName, addNewPolicyPage);
				checkEmpType(subBenefits.get(i).get("Benefit_differs_for_Employee_type"),
						subBenefits.get(i).get("SubBenefit"), pageName, addNewPolicyPage);
				checkHomeType(subBenefits.get(i).get("Benefit_differs_for_Home_Owner_type"),
						subBenefits.get(i).get("SubBenefit"), pageName, addNewPolicyPage);
			}
		} catch (Exception e) {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
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
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
		} finally {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
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
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_SUB_BENEFITS, CoreConstants.FAIL,
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
}
