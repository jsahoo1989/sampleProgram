package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_HousingBenefitsData;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_HouseHuntingTrip_BenefitsPage extends Base {
	public CoreFlex_HouseHuntingTrip_BenefitsPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Save & Continue Button
	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'SAVE & CONTINUE')]")
	private WebElement _buttonSaveAndContinue;

	// Back Button
	@FindBy(how = How.CSS, using = "button[class*='btn-back']")
	private WebElement _buttonBack;

	// Exit Button
	@FindBy(how = How.CSS, using = "button[class*='btn-exit']")
	private WebElement _buttonExit;

	// Logout Button
	@FindBy(how = How.XPATH, using = "//i[contains(text(),'exit_to_app')]")
	private WebElement _buttonLogout;

	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	// Policy Header
	@FindBy(how = How.CSS, using = "h4[class='card-title'] > b")
	private WebElement _headerPolicyInfo;

	// Page Header
	@FindBy(how = How.CSS, using = "div[class*='pcard-header'] > h4[class='card-title']")
	private WebElement _headerPage;

	// Left Navigation Completed Sections
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[contains(@class,'nav-item')]//p")
	private List<WebElement> _leftNavigationTitleList;

	// Left Navigation Selected Benefits List
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//a[contains(@class,'menu-pad')]//p")
	private List<WebElement> _leftNavigationTitleSelectedBenefitsList;

	// Core Type Selection
	@FindBy(how = How.ID, using = "core")
	private WebElement _textCore;

	// Flex Type Selection
	@FindBy(how = How.ID, using = "flex")
	private WebElement _textFlex;

	// Flex Points Input Field
	@FindBy(how = How.CSS, using = "input[formcontrolname='flexPoints']")
	private WebElement _inputFlexPoints;

	// Core Benefit - Both Selection
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Core Benefits')]")
	private WebElement _textCoreBenefits;

	// Flex Benefit - Both Selection
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flex Benefits')]")
	private WebElement _textFlexBenefits;

	// Both Benefit Type Selection
	@FindBy(how = How.ID, using = "both")
	private WebElement _textBoth;

	// Benefit Display Name Input Field
	@FindBy(how = How.ID, using = "benefitName")
	private WebElement _inputBenefitName;

	// Allowance / Amount Message TextArea Field
	@FindBy(how = How.CSS, using = "textarea[name='shortDesc']")
	private WebElement _textAreaAllowanceAmountMessage;

	// Benefit Long Description TextArea Field
	@FindBy(how = How.CSS, using = "textarea[name='longDesc']")
	private WebElement _textAreaBenefitLongDescription;

	// SubBenefit List
	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitList;

	// Gross Up - Radio Button Selection
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='grossedUpInd']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnGrossUp;

	// Radio Button Selection From Entire SubBenefit Section
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//label[@class='form-check-label']")
	private List<WebElement> _radioBtnCandidateSelection;

	// Reimbursed By Other Input
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='paidByOther']")
	private WebElement _inputReimbursedBy;

	// Comment Text Area
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//textarea[@formcontrolname='benefitComment']")
	private WebElement _txtAreaComment;

	// Aires Managed Service Radio Button
	@FindBy(how = How.CSS, using = "div[class*='form-check-radio'] > label[class*='form-check']")
	private List<WebElement> _radioAiresManagedService;

	// Benefit can be selected more than once Checkbox
	@FindBy(how = How.XPATH, using = "//input[@id='multiAddInd']/parent::label")
	private WebElement _inputMultiAddBenefit;

	// Policy Benefits data Missing Error Dialog
	@FindBy(how = How.XPATH, using = "//div[@id='swal2-content'][contains(text(),'Policy Benefits data missing. Please complete all the benefits.')]")
	private WebElement _errorDialogPolicyBenefitsDataMissing;

	// Policy Benefits data Missing Error Dialog - OK Button
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _errorDialogPolicyBenefitsDataMissingOKButton;

	// SubBenefit - Collapsable Menu 1
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'House Hunting Trip Transportation')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formHouseHuntingTripTransportation;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'House Hunting Trip Transportation')]")
	private WebElement _headerHouseHuntingTripTransportation;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'House Hunting Trip Meals')]")
	private WebElement _headerHouseHuntingTripMeals;

	// SubBenefit - Collapsable Menu 2
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'House Hunting Trip Lodging')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formHouseHuntingTripLodging;

	// SubBenefit - Collapsable Menu 3
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'House Hunting Trip Rental Car')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formHouseHuntingTripRentalCar;

	// SubBenefit - Collapsable Menu 4
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'House Hunting Trip Meals')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formHouseHuntingTripMeals;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfTrip']")
	private WebElement _inputNumberOfTrip;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripTransportTypeList']")
	private WebElement _selectTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripTransportTypeList'] span.ng-option-label")
	private List<WebElement> _selectTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minMileageEconomy']")
	private WebElement _inputMinMileageEconomy;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minMileageBusiness']")
	private WebElement _inputMinMileageBusiness;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minFlightTimeExec']")
	private WebElement _inputMinFlightTimeExlLayovers;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode']")
	private WebElement _selectAccompanyingFamilyMemberCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-option-label")
	private List<WebElement> _selectAccompanyingFamilyMemberCodeOptions;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='excessBaggageFeesInd']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnExcessBaggageFees;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountPerPerson']")
	private WebElement _inputMaxAmountPerPerson;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfNightsPerTrip']")
	private WebElement _inputNumOfNightsPerTrip;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountPerNightCode']")
	private WebElement _selectMaxAmountLodging;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountPerNightCode'] span[class*='ng-value-label']")
	private WebElement _selectMaxAmountLodgingSelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountPerNightCode'] span.ng-option-label")
	private List<WebElement> _selectMaxAmountLodgingOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='flatAmountPerNight']")
	private WebElement _inputFlatAmountPerNight;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _selectCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _selectCurrencyOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfDays']")
	private WebElement _inputDurationNumOfDays;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='classSizeCode']")
	private WebElement _selectRentalCarSize;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='classSizeCode'] span[class*='ng-value-label']")
	private WebElement _selectRentalCarSizeSelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='classSizeCode'] span.ng-option-label")
	private List<WebElement> _selectRentalCarSizeOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='classSizeOther']")
	private WebElement _inputRentalCarOtherSize;

	@FindBy(how = How.CSS, using = "app-trip-meals input[formcontrolname='durationPerTrip']")
	private WebElement _inputNumOfDaysForMeals;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='mealTypeCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnMealType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode']")
	private WebElement _selectMaxAmtMeals;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode'] span[class*=ng-option-label]")
	private List<WebElement> _selectMaxAmtMealsOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountEe']")
	private WebElement _inputMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe']")
	private WebElement _selectTransfereeCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe'] span[class*='ng-value-label']")
	private WebElement _selectTransfereeCurrencySelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe'] span.ng-option-label")
	private List<WebElement> _selectTransfereeCurrencyOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountAdult']")
	private WebElement _inputMaxAmtAdult;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailAdultCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailAdult;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult']")
	private WebElement _selectAdultCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult'] span.ng-option-label")
	private List<WebElement> _selectAdultCurrencyOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountChild']")
	private WebElement _inputMaxAmtChild;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailChildCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailChild;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild']")
	private WebElement _selectCurrencyCodeChild;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild'] span.ng-option-label")
	private List<WebElement> _selectCurrencyCodeChildOptions;

	// Aires Managed Benefit Radio Label Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Aires Managed Service')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioAiresManagedLabelList;

	// Aires Managed Benefit Radio Button Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Aires Managed Service')]/following-sibling::div//input")
	private List<WebElement> _radioAiresManagedButtonList;

	// Benefit can be selected more than once Checkbox
	@FindBy(how = How.XPATH, using = "//input[@id='multiAddInd']/parent::label")
	private List<WebElement> _inputMultiAddBenefitLabel;

	// Benefit can be selected more than once Checkbox
	@FindBy(how = How.XPATH, using = "//input[@id='multiAddInd']")
	private List<WebElement> _inputMultiAddBenefitButton;

	// Gross Up Radio Label Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Gross-Up')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioGrossUpLabelList;

	// Gross Up Radio Button Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Gross-Up')]/following-sibling::div//input")
	private List<WebElement> _radioGrossUpButtonList;

	// Reimbursed By Radio Label Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Reimbursed By')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioReimbursedByLabelList;

	// Reimbursed By Radio Button Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Reimbursed By')]/following-sibling::div//input")
	private List<WebElement> _radioReimbursedByButtonList;

	// Type - Radio Button Selection - Label List
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='mealTypeCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioMealsTypeLabelList;

	// Type - Radio Button Selection - Button List
	@FindBy(how = How.CSS, using = "div[class='collapse show'] input[formcontrolname='mealTypeCode']")
	private List<WebElement> _radioMealsTypeButtonList;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripTransportTypeList'] span[class*='ng-value-label']")
	private WebElement _selectTransportationTypeSelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span[class*='ng-value-label']")
	private WebElement _selectAccompanyingFamilyMemberCodeSelectedValue;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='excessBaggageFeesInd']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnExcessBaggageFeesLabelList;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='excessBaggageFeesInd']")
	private List<WebElement> _radioBtnExcessBaggageFeesButtonList;

	@FindBy(how = How.CSS, using = "div[class='collapse show'] ng-select[formcontrolname='maxAmountCode'] span[class*='ng-value-label']")
	private WebElement _selectMaxAmtSelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span[class*='ng-value-label']")
	private WebElement _selectCurrencyCodeSelectedValue;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCodeLabelList;

	@FindBy(how = How.CSS, using = "input[formcontrolname='detailEeCode']")
	private List<WebElement> _radioDetailTransfereeCodeButtonList;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailAdultCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailAdultCodeLabelList;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult'] span[class*='ng-value-label']")
	private WebElement _selectAdultCurrencySelectedValue;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailChildCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> __radioDetailChildLabelList;

	@FindBy(how = How.CSS, using = "input[formcontrolname='detailChildCode']")
	private List<WebElement> _radioDetailChildButtonList;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild'] span[class*='ng-value-label']")
	private WebElement _selectCurrencyCodeChildSelectedValue;

	@FindBy(how = How.CSS, using = "input[formcontrolname='detailAdultCode']")
	private List<WebElement> _radioDetailAdultCodeButtonList;

	// Flex Policy Setup Page Header
	@FindBy(how = How.XPATH, using = "//h4[@class='card-title'][contains(text(),'House Hunting Trip')]")
	private WebElement _headerPageName;

	// If Applicable Text
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'if applicable')]")
	private List<WebElement> _textIfApplicable;

	/*********************************************************************/

	CoreFlex_HousingBenefitsData housingBenefitData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getHousingBenefitDataList(COREFLEXConstants.HOUSE_HUNTING_TRIP);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	/*********************************************************************/

	/**
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.HOUSE_HUNTING_TRIP,
				expectedPageName, expectedPageName, true);
	}

	/**
	 * Generic Method to Click on an Element on a Page.
	 * 
	 * @param elementName
	 */
	public void clickElementOfPage(String elementName) {
		try {
			switch (elementName) {
			case PDTConstants.LOGOUT:
				CoreFunctions.clickElement(driver, _buttonLogout);
				break;
			case COREFLEXConstants.SAVE_AND_CONTINUE:
				CoreFunctions.clickElement(driver, _buttonSaveAndContinue);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case PDTConstants.BACK:
				CoreFunctions.clickElement(driver, _buttonBack);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case PDTConstants.EXIT:
				CoreFunctions.clickElement(driver, _buttonExit);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_AN_ELEMENT_OF_PAGE,
							CoreConstants.FAIL, elementName, e.getMessage()));
			throw new RuntimeException(e);
		}
	}

	/**
	 * Generic method to click on an Left Navigation Menu.
	 * 
	 * @param elementName
	 */
	public void clickLeftNavigationMenuOfPage(String elementName) {
		try {
			switch (elementName) {
			case COREFLEXConstants.GENERAL_INFORMATION:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.GENERAL_INFORMATION);
				break;
			case COREFLEXConstants.FLEX_POLICY_SETUP:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.FLEX_POLICY_SETUP);
				break;
			case COREFLEXConstants.POLICY_BENEFIT_CATEGORIES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.POLICY_BENEFIT_CATEGORIES);
				break;
			case COREFLEXConstants.BENEFIT_SUMMARY:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.BENEFIT_SUMMARY);
				break;
			case COREFLEXConstants.CUSTOM_BUNDLES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.BENEFIT_SUMMARY);
				break;
			default:
				Assert.fail(PDTConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_LEFTNAVIGATION_ELEMENT_OF_PAGE,
					CoreConstants.FAIL, elementName, e.getMessage()));
			throw new RuntimeException(e);

		}
	}

	/**
	 * Method to call select Benefit Type and Sub Benefits, fill all mandatory
	 * fields methods
	 * 
	 * @param benefitType
	 * @param subBenefitNames
	 * @param multipleBenefitSelection
	 * @param flexPoints
	 * @param benefitDisplayName
	 * @param benefitAllowanceAmount
	 * @param benefitDescription
	 * @param aireManagedService
	 */
	public void selectAndFillBenefitsAndSubBenefitDetails(String benefitType, String subBenefitNames,
			String multipleBenefitSelection, String flexPoints, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String aireManagedService) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _headerPageName,
				COREFLEXConstants.HOUSE_HUNTING_TRIP_BENEFITS_PAGE);
		if (benefitType.equals(COREFLEXConstants.BOTH)) {
			selectBenefitTypeAndFillMandatoryFields(benefitType, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, aireManagedService);
			selectBenefitTypeAndFillMandatoryFields(COREFLEXConstants.CORE_BENEFITS, multipleBenefitSelection,
					flexPoints, benefitDisplayName, benefitAllowanceAmount, benefitDescription, aireManagedService);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames, COREFLEXConstants.CORE_BENEFITS);
			selectBenefitTypeAndFillMandatoryFields(COREFLEXConstants.FLEX_BENEFITS, multipleBenefitSelection,
					flexPoints, benefitDisplayName, benefitAllowanceAmount, benefitDescription, aireManagedService);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames, COREFLEXConstants.FLEX_BENEFITS);
		} else {
			selectBenefitTypeAndFillMandatoryFields(benefitType, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, aireManagedService);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames, benefitType);
		}
		BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable,
				benefitDisplayName, COREFLEXConstants.IF_APPLICABLE);
		clickElementOfPage(COREFLEXConstants.SAVE_AND_CONTINUE);

		if (CoreFunctions.isElementExist(driver, _errorDialogPolicyBenefitsDataMissing, 7)) {
			CoreFunctions.clickElement(driver, _errorDialogPolicyBenefitsDataMissingOKButton);
		}

	}

	/**
	 * Method to select and fill mentioned SubBenefits and fill all the SubBenefits
	 * section fields
	 * 
	 * @param subBenefitNames
	 * @param benefitType
	 */
	private void selectSubBenefitsAndFillMandatoryFields(String subBenefitNames, String benefitType) {
		try {
			List<String> subBenefitNamesList = new ArrayList<String>();
			if (subBenefitNames.contains(";"))
				subBenefitNamesList = Arrays.asList(subBenefitNames.split(";"));
			else
				subBenefitNamesList.add(subBenefitNames);

			for (String subBenefit : subBenefitNamesList) {
				if (subBenefitNamesList.size() > 1) {
					CoreFunctions.selectItemInListByText(driver, _subBenefitList, subBenefit, true);
				}
				if (CoreFunctions.isElementExist(driver, getElementByName(subBenefit.trim()), 5)) {
					fillSubBenefit(subBenefit.trim(), benefitType);
				} else {
					Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.HOUSE_HUNTING_TRIP_BENEFITS_PAGE));
					throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.HOUSE_HUNTING_TRIP_BENEFITS_PAGE));
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_AND_FILLING_AIRES_MANAGED_SUB_BENEFITS,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	/**
	 * Method to Expand and call FillSubBenefit method
	 * 
	 * @param subBenefit
	 * @param benefitType
	 */
	private void fillSubBenefit(String subBenefit, String benefitType) {
		switch (subBenefit) {
		case COREFLEXConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION));
			fillHouseHuntingTripTransportationSubBenefitForm(COREFLEXConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION);
			break;
		case COREFLEXConstants.HOUSE_HUNTING_TRIP_LODGING:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOUSE_HUNTING_TRIP_LODGING));
			fillHouseHuntingTripLodgingSubBenefitForm(COREFLEXConstants.HOUSE_HUNTING_TRIP_LODGING);
			break;
		case COREFLEXConstants.HOUSE_HUNTING_TRIP_RENTAL_CAR:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOUSE_HUNTING_TRIP_RENTAL_CAR));
			fillHouseHuntingTripRentalCarSubBenefitForm(COREFLEXConstants.HOUSE_HUNTING_TRIP_RENTAL_CAR);
			break;
		case COREFLEXConstants.HOUSE_HUNTING_TRIP_MEALS:
			CoreFunctions.clickElement(driver, _headerHouseHuntingTripMeals);
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOUSE_HUNTING_TRIP_MEALS));
			fillHouseHuntingTripMealsSubBenefitForm(COREFLEXConstants.HOUSE_HUNTING_TRIP_MEALS);
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to fill House Hunting Trip Transportation subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillHouseHuntingTripTransportationSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputNumberOfTrip,
					housingBenefitData.houseHuntingTripTransportation.numberOfTrips);
			CoreFunctions.clickElement(driver, _selectTransportationType);
			CoreFunctions.selectItemInListByText(driver, _selectTransportationTypeOptions,
					housingBenefitData.houseHuntingTripTransportation.transportationType, true);
			CoreFunctions.clickElement(driver, _selectTransportationType);
			CoreFunctions.clearAndSetText(driver, _inputMinMileageEconomy,
					housingBenefitData.houseHuntingTripTransportation.minMilForEconomyAirTravel);
			CoreFunctions.clearAndSetText(driver, _inputMinMileageBusiness,
					housingBenefitData.houseHuntingTripTransportation.minMilForBusinessAirTravel);
			CoreFunctions.clearAndSetText(driver, _inputMinFlightTimeExlLayovers,
					housingBenefitData.houseHuntingTripTransportation.minFlightTimeExclLayovers);
			CoreFunctions.clickElement(driver, _selectAccompanyingFamilyMemberCode);
			CoreFunctions.selectItemInListByText(driver, _selectAccompanyingFamilyMemberCodeOptions,
					housingBenefitData.houseHuntingTripTransportation.accompanyingFamilyMember, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnExcessBaggageFees,
					housingBenefitData.houseHuntingTripTransportation.excessBaggageFees, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmountPerPerson,
					housingBenefitData.houseHuntingTripTransportation.maxAmountPerPerson);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					housingBenefitData.houseHuntingTripTransportation.grossUp, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					housingBenefitData.houseHuntingTripTransportation.reimbursedBy, true);
			if (housingBenefitData.houseHuntingTripTransportation.reimbursedBy
					.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						housingBenefitData.houseHuntingTripTransportation.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment,
					housingBenefitData.houseHuntingTripTransportation.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName, e.getMessage()));
		}
	}

	/**
	 * Method to fill House Hunting Trip Lodging subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillHouseHuntingTripLodgingSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputNumOfNightsPerTrip,
					housingBenefitData.houseHuntingTripLodging.numberOfNightsPerTrip);
			CoreFunctions.clickElement(driver, _selectMaxAmountLodging);
			CoreFunctions.selectItemInListByText(driver, _selectMaxAmountLodgingOptions,
					housingBenefitData.houseHuntingTripLodging.maxAmountLodging, true);
			CoreFunctions.clearAndSetText(driver, _inputFlatAmountPerNight,
					housingBenefitData.houseHuntingTripLodging.flatAmountPerNight);
			CoreFunctions.clickElement(driver, _selectCurrency);
			CoreFunctions.selectItemInListByText(driver, _selectCurrencyOptions,
					housingBenefitData.houseHuntingTripLodging.currencyLodging, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					housingBenefitData.houseHuntingTripLodging.grossUp, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					housingBenefitData.houseHuntingTripLodging.reimbursedBy, true);
			if (housingBenefitData.houseHuntingTripLodging.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						housingBenefitData.houseHuntingTripLodging.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment, housingBenefitData.houseHuntingTripLodging.comment);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Method to fill House Hunting Trip Rental Car subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillHouseHuntingTripRentalCarSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputDurationNumOfDays,
					housingBenefitData.houseHuntingTripRentalCar.durationDays);
			CoreFunctions.clickElement(driver, _selectRentalCarSize);
			CoreFunctions.selectItemInListByText(driver, _selectRentalCarSizeOptions,
					housingBenefitData.houseHuntingTripRentalCar.rentalCarSize, true);
			if (housingBenefitData.houseHuntingTripRentalCar.rentalCarSize.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputRentalCarOtherSize,
						housingBenefitData.houseHuntingTripRentalCar.rentalCarSizeOther);
			}
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					housingBenefitData.houseHuntingTripRentalCar.grossUp, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					housingBenefitData.houseHuntingTripRentalCar.reimbursedBy, true);
			if (housingBenefitData.houseHuntingTripRentalCar.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						housingBenefitData.houseHuntingTripRentalCar.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment,
					housingBenefitData.houseHuntingTripRentalCar.comment);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Method to fill House Hunting Trip Meals subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillHouseHuntingTripMealsSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputNumOfDaysForMeals,
					housingBenefitData.houseHuntingTripMeals.numberOfDaysForMeal);
			CoreFunctions.selectItemInListByText(driver, _radioBtnMealType,
					housingBenefitData.houseHuntingTripMeals.type, true);
			CoreFunctions.clickElement(driver, _selectMaxAmtMeals);
			CoreFunctions.selectItemInListByText(driver, _selectMaxAmtMealsOptions,
					housingBenefitData.houseHuntingTripMeals.maxAmount, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmtTransferee,
					housingBenefitData.houseHuntingTripMeals.maxAmtTransferee);
			CoreFunctions.clickElement(driver, _selectTransfereeCurrency);
			CoreFunctions.selectItemInListByText(driver, _selectTransfereeCurrencyOptions,
					housingBenefitData.houseHuntingTripMeals.maxAmtTransfereeCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailTransfereeCode,
					housingBenefitData.houseHuntingTripMeals.maxAmtTransfereeDetail, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmtAdult,
					housingBenefitData.houseHuntingTripMeals.maxAmtAdult);
			CoreFunctions.clickElement(driver, _selectAdultCurrency);
			CoreFunctions.selectItemInListByText(driver, _selectAdultCurrencyOptions,
					housingBenefitData.houseHuntingTripMeals.maxAmtAdultCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailAdult,
					housingBenefitData.houseHuntingTripMeals.maxAmtAdultDetail, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmtChild,
					housingBenefitData.houseHuntingTripMeals.maxAmtChildren);
			CoreFunctions.clickElement(driver, _selectCurrencyCodeChild);
			CoreFunctions.selectItemInListByText(driver, _selectCurrencyCodeChildOptions,
					housingBenefitData.houseHuntingTripMeals.maxAmtChildrenCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailChild,
					housingBenefitData.houseHuntingTripMeals.maxAmtChildrenDetail, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					housingBenefitData.houseHuntingTripMeals.grossUp, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					housingBenefitData.houseHuntingTripMeals.reimbursedBy, true);
			if (housingBenefitData.houseHuntingTripMeals.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						housingBenefitData.houseHuntingTripMeals.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment, housingBenefitData.houseHuntingTripMeals.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Method to Expand SubBenefits Section is collapsed
	 * 
	 * @param subBenefitForm
	 */
	private void expandSubBenefitIfCollapsed(WebElement subBenefitForm) {
		if (subBenefitForm.getAttribute("class").equalsIgnoreCase("collapsed")) {
			CoreFunctions.clickElement(driver, subBenefitForm);
			CoreFunctions.waitHandler(1);
		}
	}

	/**
	 * Method to get SubBenefit Section Element
	 * 
	 * @param elementName
	 * @return
	 */
	public WebElement getElementByName(String elementName) {
		WebElement element = null;
		switch (elementName) {
		case COREFLEXConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION:
			element = _formHouseHuntingTripTransportation;
			break;
		case COREFLEXConstants.HOUSE_HUNTING_TRIP_LODGING:
			element = _formHouseHuntingTripLodging;
			break;
		case COREFLEXConstants.HOUSE_HUNTING_TRIP_RENTAL_CAR:
			element = _formHouseHuntingTripRentalCar;
			break;
		case COREFLEXConstants.HOUSE_HUNTING_TRIP_MEALS:
			element = _formHouseHuntingTripMeals;
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return element;
	}

	/**
	 * Method to select Benefit Type and fill all Mandatory Fields
	 * 
	 * @param benefitType
	 * @param multipleBenefitSelection
	 * @param flexPoints
	 * @param benefitDisplayName
	 * @param benefitAllowanceAmount
	 * @param benefitDescription
	 * @param aireManagedService
	 */
	private void selectBenefitTypeAndFillMandatoryFields(String benefitType, String multipleBenefitSelection,
			String flexPoints, String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription,
			String aireManagedService) {
		Benefit houseHuntingTripBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.HOUSE_HUNTING_TRIP)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			fillManadatoryDetails(benefitType, multipleBenefitSelection,
					houseHuntingTripBenefit.getBenefitDisplayName(), houseHuntingTripBenefit.getBenefitAmount(),
					houseHuntingTripBenefit.getBenefitDesc(), aireManagedService);
			break;
		case COREFLEXConstants.FLEX:
			CoreFunctions.clickElement(driver, _textFlex);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputFlexPoints, flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, aireManagedService);
			break;
		case COREFLEXConstants.CORE_BENEFITS:
			CoreFunctions.clickElement(driver, _textCoreBenefits);
			fillManadatoryDetails(benefitType, multipleBenefitSelection,
					houseHuntingTripBenefit.getBenefitDisplayName(), houseHuntingTripBenefit.getBenefitAmount(),
					houseHuntingTripBenefit.getBenefitDesc(), aireManagedService);
			break;
		case COREFLEXConstants.FLEX_BENEFITS:
			CoreFunctions.clickElement(driver, _textFlexBenefits);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputFlexPoints, flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, aireManagedService);
			break;
		case COREFLEXConstants.BOTH:
			CoreFunctions.clickElement(driver, _textBoth);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
	}

	/**
	 * Method to fill Default Mandatory Fields of Benefit
	 * 
	 * @param benefitType
	 * @param multipleBenefitSelection
	 * @param benefitDisplayName
	 * @param benefitAllowanceAmount
	 * @param benefitDescription
	 * @param aireManagedService
	 */
	private void fillManadatoryDetails(String benefitType, String multipleBenefitSelection, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String aireManagedService) {
		try {
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputBenefitName, benefitDisplayName,
					COREFLEXConstants.BENEFIT_DISPLAY_NAME);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _textAreaAllowanceAmountMessage, benefitAllowanceAmount,
					COREFLEXConstants.ALLOWANCE_AMOUNT_MESSAGE);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _textAreaBenefitLongDescription, benefitDescription,
					COREFLEXConstants.BENEFIT_LONG_DESCRIPTION);
			if ((benefitType.equals(COREFLEXConstants.FLEX_BENEFITS)) || (benefitType.equals(COREFLEXConstants.FLEX))) {
				if ((multipleBenefitSelection.equals(COREFLEXConstants.YES)))
					CoreFunctions.clickElement(driver, _inputMultiAddBenefit);
				CoreFunctions.selectItemInListByText(driver, _radioAiresManagedService, aireManagedService, true,
						COREFLEXConstants.AIRES_MANAGED_SERVICE);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_FILLING_MANDATORY_FIELDS_OF_BENEFIT,
							CoreConstants.FAIL, e.getMessage(), benefitDisplayName));
		}
	}

	public boolean verifyAddedBenefitsAndSubBenefitDetails(String benefitType, String subBenefitNames,
			String multipleBenefitSelection, String flexPoints, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String paymentOption,
			String airesManagedService) {
		if (benefitType.equals(COREFLEXConstants.BOTH)) {
			CoreFunctions.clickElement(driver, _textBoth);
			verifyBenefitsMandatoryDetails(COREFLEXConstants.CORE_BENEFITS, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, paymentOption, airesManagedService);
			iterateSubBenefitAndVerifyDetails(subBenefitNames, COREFLEXConstants.CORE_BENEFITS);
			verifyBenefitsMandatoryDetails(COREFLEXConstants.FLEX_BENEFITS, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, paymentOption, airesManagedService);
			iterateSubBenefitAndVerifyDetails(subBenefitNames, COREFLEXConstants.FLEX_BENEFITS);
			return true;
		} else {
			verifyBenefitsMandatoryDetails(benefitType, multipleBenefitSelection, flexPoints, benefitDisplayName,
					benefitAllowanceAmount, benefitDescription, paymentOption, airesManagedService);
			iterateSubBenefitAndVerifyDetails(subBenefitNames, benefitType);
			return true;
		}
	}

	private void verifyBenefitsMandatoryDetails(String benefitType, String multipleBenefitSelection, String flexPoints,
			String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription, String paymentOption,
			String airesManagedService) {
		Benefit houseHuntingTripBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.HOUSE_HUNTING_TRIP)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection,
					houseHuntingTripBenefit.getBenefitDisplayName(), houseHuntingTripBenefit.getBenefitAmount(),
					houseHuntingTripBenefit.getBenefitDesc(), paymentOption, airesManagedService);
			break;
		case COREFLEXConstants.FLEX:
			CoreFunctions.clickElement(driver, _textFlex);
			CoreFunctions.verifyText(_inputFlexPoints.getDomProperty("value"), flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			CoreFunctions.highlightObject(driver, _inputFlexPoints);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, paymentOption, airesManagedService);
			break;
		case COREFLEXConstants.CORE_BENEFITS:
			CoreFunctions.clickElement(driver, _textCoreBenefits);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection,
					houseHuntingTripBenefit.getBenefitDisplayName(), houseHuntingTripBenefit.getBenefitAmount(),
					houseHuntingTripBenefit.getBenefitDesc(), paymentOption, airesManagedService);
			break;
		case COREFLEXConstants.FLEX_BENEFITS:
			CoreFunctions.clickElement(driver, _textFlexBenefits);
			CoreFunctions.verifyText(_inputFlexPoints.getDomProperty("value"), flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			CoreFunctions.highlightObject(driver, _inputFlexPoints);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, paymentOption, airesManagedService);
			break;
		case COREFLEXConstants.BOTH:
			CoreFunctions.clickElement(driver, _textBoth);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}

	}

	private void verifyManadatoryDetails(String benefitType, String multipleBenefitSelection, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String paymentOption,
			String airesManagedService) {
		if ((benefitType.equals(COREFLEXConstants.FLEX_BENEFITS)) || (benefitType.equals(COREFLEXConstants.FLEX))) {
			if ((multipleBenefitSelection.equals(COREFLEXConstants.YES))) {
				CoreFunctions.verifyRadioButtonSelection(driver, _inputMultiAddBenefitLabel,
						_inputMultiAddBenefitButton, COREFLEXConstants.BENEFIT_SELECTED_MORE_THAN_ONCE,
						COREFLEXConstants.MULTIPLE_BENEFIT_SELECTION);
			}
			CoreFunctions.verifyRadioButtonSelection(driver, _radioAiresManagedLabelList, _radioAiresManagedButtonList,
					airesManagedService, COREFLEXConstants.AIRES_MANAGED_SERVICE);
		}
		CoreFunctions.verifyText(_inputBenefitName.getDomProperty("value"), benefitDisplayName,
				COREFLEXConstants.BENEFIT_DISPLAY_NAME);
		CoreFunctions.highlightObject(driver, _inputBenefitName);
		CoreFunctions.verifyText(_textAreaAllowanceAmountMessage.getDomProperty("value"), benefitAllowanceAmount,
				COREFLEXConstants.ALLOWANCE_AMOUNT_MESSAGE);
		CoreFunctions.highlightObject(driver, _textAreaAllowanceAmountMessage);
		CoreFunctions.verifyText(_textAreaBenefitLongDescription.getDomProperty("value"), benefitDescription,
				COREFLEXConstants.BENEFIT_LONG_DESCRIPTION);
		CoreFunctions.highlightObject(driver, _textAreaBenefitLongDescription);
	}

	/**
	 * Method to iterate and verify mentioned SubBenefits details
	 * 
	 * @param subBenefitNames
	 * @param benefitType
	 */
	private void iterateSubBenefitAndVerifyDetails(String subBenefitNames, String benefitType) {
		try {
			List<String> subBenefitNamesList = new ArrayList<String>();
			if (subBenefitNames.contains(";"))
				subBenefitNamesList = Arrays.asList(subBenefitNames.split(";"));
			else
				subBenefitNamesList.add(subBenefitNames);

			for (String subBenefit : subBenefitNamesList) {
				if (CoreFunctions.isElementExist(driver, getElementByName(subBenefit.trim()), 5)) {
					verifySubBenefitDetails(subBenefit.trim(), benefitType);
				} else {
					Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.HOUSE_HUNTING_TRIP_BENEFITS_PAGE));
					throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.HOUSE_HUNTING_TRIP_BENEFITS_PAGE));
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_AND_VERIFYING_SUB_BENEFIT_DETAILS,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	/**
	 * Method to Expand and call SubBenefit Verification Method's
	 * 
	 * @param subBenefit
	 * @param benefitType
	 */
	private void verifySubBenefitDetails(String subBenefit, String benefitType) {
		switch (subBenefit) {
		case COREFLEXConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION));
			verifyHouseHuntingTripTransportationSubBenefitForm(COREFLEXConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION);
			break;
		case COREFLEXConstants.HOUSE_HUNTING_TRIP_LODGING:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOUSE_HUNTING_TRIP_LODGING));
			verifyHouseHuntingTripLodgingSubBenefitForm(COREFLEXConstants.HOUSE_HUNTING_TRIP_LODGING);
			break;
		case COREFLEXConstants.HOUSE_HUNTING_TRIP_RENTAL_CAR:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOUSE_HUNTING_TRIP_RENTAL_CAR));
			verifyHouseHuntingTripRentalCarSubBenefitForm(COREFLEXConstants.HOUSE_HUNTING_TRIP_RENTAL_CAR);
			break;
		case COREFLEXConstants.HOUSE_HUNTING_TRIP_MEALS:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOUSE_HUNTING_TRIP_MEALS));
			verifyHouseHuntingTripMealsSubBenefitForm(COREFLEXConstants.HOUSE_HUNTING_TRIP_MEALS);
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to verify HouseHuntingTripTransportation subBenefit form
	 */
	private void verifyHouseHuntingTripTransportationSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(_inputNumberOfTrip.getDomProperty("value"),
					housingBenefitData.houseHuntingTripTransportation.numberOfTrips, COREFLEXConstants.NUMBER_OF_TRIPS);
			CoreFunctions.verifyText(driver, _selectTransportationTypeSelectedValue,
					housingBenefitData.houseHuntingTripTransportation.transportationType,
					COREFLEXConstants.TRANSPORTATION_TYPE);
			CoreFunctions.verifyText(_inputMinMileageEconomy.getDomProperty("value"),
					housingBenefitData.houseHuntingTripTransportation.minMilForEconomyAirTravel,
					COREFLEXConstants.MIN_MILEAGE_FOR_ECONOMY_AIR_TRAVEL);
			CoreFunctions.verifyText(_inputMinMileageBusiness.getDomProperty("value"),
					housingBenefitData.houseHuntingTripTransportation.minMilForBusinessAirTravel,
					COREFLEXConstants.MIN_MILEAGE_FOR_BUSINESS_AIR_TRAVEL);
			CoreFunctions.verifyText(_inputMinFlightTimeExlLayovers.getDomProperty("value"),
					housingBenefitData.houseHuntingTripTransportation.minFlightTimeExclLayovers,
					COREFLEXConstants.MIN_FLIGHT_TIME_EXCL_LAYOVERS);
			CoreFunctions.verifyText(driver, _selectAccompanyingFamilyMemberCodeSelectedValue,
					housingBenefitData.houseHuntingTripTransportation.accompanyingFamilyMember,
					COREFLEXConstants.ACCOMPANYING_FAMILY_MEMBERS);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioBtnExcessBaggageFeesLabelList,
					_radioBtnExcessBaggageFeesButtonList,
					housingBenefitData.houseHuntingTripTransportation.excessBaggageFees,
					COREFLEXConstants.EXCESS_BAGGAGE_FEES);
			CoreFunctions.verifyText(_inputMaxAmountPerPerson.getDomProperty("value"),
					housingBenefitData.houseHuntingTripTransportation.maxAmountPerPerson, COREFLEXConstants.MAX_AMOUNT);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					housingBenefitData.houseHuntingTripTransportation.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					housingBenefitData.houseHuntingTripTransportation.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (housingBenefitData.houseHuntingTripTransportation.reimbursedBy
					.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						housingBenefitData.houseHuntingTripTransportation.reimbursedByOther,
						COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					housingBenefitData.houseHuntingTripTransportation.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_HOUSE_HUNTING_TRIP_SUB_BENEFITS_FORM,
					CoreConstants.FAIL, formName));
		}
	}

	/**
	 * Method to verify HouseHuntingTrip subBenefit form
	 */
	private void verifyHouseHuntingTripLodgingSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(_inputNumOfNightsPerTrip.getDomProperty("value"),
					housingBenefitData.houseHuntingTripLodging.numberOfNightsPerTrip,
					COREFLEXConstants.NUMBER_OF_NIGHTS);
			CoreFunctions.verifyText(driver, _selectMaxAmountLodgingSelectedValue,
					housingBenefitData.houseHuntingTripLodging.maxAmountLodging, COREFLEXConstants.MAX_AMOUNT);
			CoreFunctions.verifyText(_inputFlatAmountPerNight.getDomProperty("value"),
					housingBenefitData.houseHuntingTripLodging.flatAmountPerNight,
					COREFLEXConstants.FLAT_AMOUNT_PER_NIGHT);
			CoreFunctions.verifyText(driver, _selectCurrencyCodeSelectedValue,
					housingBenefitData.houseHuntingTripLodging.currencyLodging, COREFLEXConstants.CURRENCY);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					housingBenefitData.houseHuntingTripLodging.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					housingBenefitData.houseHuntingTripLodging.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (housingBenefitData.houseHuntingTripLodging.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						housingBenefitData.houseHuntingTripLodging.reimbursedByOther,
						COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					housingBenefitData.houseHuntingTripLodging.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_HOUSE_HUNTING_TRIP_SUB_BENEFITS_FORM,
					CoreConstants.FAIL, formName));
		}
	}

	/**
	 * Method to verify HouseHuntingTrip subBenefit form
	 */
	private void verifyHouseHuntingTripRentalCarSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(_inputDurationNumOfDays.getDomProperty("value"),
					housingBenefitData.houseHuntingTripRentalCar.durationDays, COREFLEXConstants.DURATION_DAYS);
			CoreFunctions.highlightObject(driver, _inputDurationNumOfDays);
			CoreFunctions.verifyText(driver, _selectRentalCarSizeSelectedValue,
					housingBenefitData.houseHuntingTripRentalCar.rentalCarSize,
					COREFLEXConstants.RENTAL_CAR_SIZE_CLASS);
			if (housingBenefitData.houseHuntingTripRentalCar.rentalCarSize.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputRentalCarOtherSize.getDomProperty("value"),
						housingBenefitData.houseHuntingTripRentalCar.rentalCarSizeOther,
						COREFLEXConstants.RENTAL_CAR_OTHER_SIZE_CLASS);
				CoreFunctions.highlightObject(driver, _inputRentalCarOtherSize);
			}
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					housingBenefitData.houseHuntingTripRentalCar.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					housingBenefitData.houseHuntingTripRentalCar.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (housingBenefitData.houseHuntingTripRentalCar.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						housingBenefitData.houseHuntingTripRentalCar.reimbursedByOther,
						COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					housingBenefitData.houseHuntingTripRentalCar.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_HOUSE_HUNTING_TRIP_SUB_BENEFITS_FORM,
					CoreConstants.FAIL, formName));
		}
	}

	/**
	 * Method to verify HouseHuntingTripMeals subBenefit form
	 */
	private void verifyHouseHuntingTripMealsSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(_inputNumOfDaysForMeals.getDomProperty("value"),
					housingBenefitData.houseHuntingTripMeals.numberOfDaysForMeal,
					COREFLEXConstants.NUMBER_OF_DAYS_FOR_MEAL);
			CoreFunctions.highlightObject(driver, _inputNumOfDaysForMeals);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioMealsTypeLabelList, _radioMealsTypeButtonList,
					housingBenefitData.houseHuntingTripMeals.type, COREFLEXConstants.MEAL_TYPE);
			CoreFunctions.verifyText(driver, _selectMaxAmtSelectedValue,
					housingBenefitData.houseHuntingTripMeals.maxAmount, COREFLEXConstants.MAX_AMOUNT);

			CoreFunctions.verifyText(_inputMaxAmtTransferee.getDomProperty("value"),
					housingBenefitData.houseHuntingTripMeals.maxAmtTransferee, COREFLEXConstants.MAX_AMOUNT_TRANSFEREE);
			CoreFunctions.verifyText(driver, _selectTransfereeCurrencySelectedValue,
					housingBenefitData.houseHuntingTripMeals.maxAmtTransfereeCurrency,
					COREFLEXConstants.CURRENCY_TRANSFEREE);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioDetailTransfereeCodeLabelList,
					_radioDetailTransfereeCodeButtonList,
					housingBenefitData.houseHuntingTripMeals.maxAmtTransfereeDetail,
					COREFLEXConstants.TRANSFEREE_DETAIL);

			CoreFunctions.verifyText(_inputMaxAmtAdult.getDomProperty("value"),
					housingBenefitData.houseHuntingTripMeals.maxAmtAdult, COREFLEXConstants.MAX_AMOUNT_ADULT);
			CoreFunctions.verifyText(driver, _selectAdultCurrencySelectedValue,
					housingBenefitData.houseHuntingTripMeals.maxAmtAdultCurrency, COREFLEXConstants.CURRENCY_ADULT);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioDetailAdultCodeLabelList,
					_radioDetailAdultCodeButtonList, housingBenefitData.houseHuntingTripMeals.maxAmtAdultDetail,
					COREFLEXConstants.ADULT_DETAIL);

			CoreFunctions.verifyText(_inputMaxAmtChild.getDomProperty("value"),
					housingBenefitData.houseHuntingTripMeals.maxAmtChildren, COREFLEXConstants.MAX_AMOUNT_CHILDREN);
			CoreFunctions.verifyText(driver, _selectCurrencyCodeChildSelectedValue,
					housingBenefitData.houseHuntingTripMeals.maxAmtChildrenCurrency,
					COREFLEXConstants.CURRENCY_CHILDREN);
			CoreFunctions.verifyRadioButtonSelection(driver, __radioDetailChildLabelList, _radioDetailChildButtonList,
					housingBenefitData.houseHuntingTripMeals.maxAmtChildrenDetail, COREFLEXConstants.CHILDREN_DETAIL);

			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					housingBenefitData.houseHuntingTripMeals.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					housingBenefitData.houseHuntingTripMeals.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (housingBenefitData.houseHuntingTripMeals.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						housingBenefitData.houseHuntingTripMeals.reimbursedByOther,
						COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					housingBenefitData.houseHuntingTripMeals.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_HOUSE_HUNTING_TRIP_SUB_BENEFITS_FORM,
					CoreConstants.FAIL, formName));
		}
	}
}
