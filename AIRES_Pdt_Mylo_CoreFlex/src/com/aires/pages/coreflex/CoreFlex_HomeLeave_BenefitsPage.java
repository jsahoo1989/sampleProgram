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
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_MovingBenefitsData;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_HomeLeave_BenefitsPage extends Base {
	public CoreFlex_HomeLeave_BenefitsPage(WebDriver driver) {
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
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Home Leave Transportation')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formHomeLeaveTransportation;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Home Leave Transportation')]")
	private WebElement _headerHomeLeaveTransportation;

	// SubBenefit - Collapsable Menu 2
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Home Leave Lodging')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formHomeLeaveLodging;

	// SubBenefit - Collapsable Menu 3
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Home Leave Rental Car')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formHomeLeaveRentalCar;

	// SubBenefit - Collapsable Menu 4
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Home Leave Meals')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formHomeLeaveMeals;

	@FindBy(how = How.CSS, using = "input[formcontrolname='assignmentTrip']")
	private WebElement _inputAssignmentTrip;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignmentFreqOfTripCode']")
	private WebElement _selectFrequencyOfTrip;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignmentFreqOfTripCode'] span[class*='ng-value-label']")
	private WebElement _selectFrequencyOfTripSelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignmentFreqOfTripCode'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _selectFrequencyOfTripOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='assignmentFreqOfTripOther']")
	private WebElement _inputFrequencyOfTripOther;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportTypeList']")
	private WebElement _selectTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportTypeList'] span.ng-option-label")
	private List<WebElement> _selectTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='economyMinMileage']")
	private WebElement _inputMinMileageEconomy;

	@FindBy(how = How.CSS, using = "input[formcontrolname='businessMinMileage']")
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

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='numOfDays']")
	private WebElement _inputDurationInDays;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='classSizeCode']")
	private WebElement _selectRentalCarSize;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='classSizeCode'] span[class*='ng-value-label']")
	private WebElement _selectRentalCarSizeSelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='classSizeCode'] span.ng-option-label")
	private List<WebElement> _selectRentalCarSizeOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='classSizeOther']")
	private WebElement _inputRentalCarOtherSize;

	@FindBy(how = How.CSS, using = "app-meals input[formcontrolname='numOfDays']")
	private WebElement _inputNumOfDaysForMeals;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='typeCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnMealType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode']")
	private WebElement _selectMaxAmtMeals;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode'] span[class*=ng-option-label]")
	private List<WebElement> _selectMaxAmtMealsOptions;	

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCode;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCodeLabelList;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='detailEeCode']")
	private List<WebElement> _radioDetailTransfereeCodeButtonList;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountEe']")
	private WebElement _inputMaxAmtTransferee;

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
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailAdultCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailAdultCodeLabelList;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='detailAdultCode']")
	private List<WebElement> _radioDetailAdultCodeButtonList;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult']")
	private WebElement _selectAdultCurrency;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult'] span[class*='ng-value-label']")
	private WebElement _selectAdultCurrencySelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult'] span.ng-option-label")
	private List<WebElement> _selectAdultCurrencyOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountChild']")
	private WebElement _inputMaxAmtChild;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailChildCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailChild;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailChildCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> __radioDetailChildLabelList;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='detailChildCode']")
	private List<WebElement> _radioDetailChildButtonList;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild']")
	private WebElement _selectCurrencyCodeChild;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild'] span[class*='ng-value-label']")
	private WebElement _selectCurrencyCodeChildSelectedValue;

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
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='typeCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioMealsTypeLabelList;

	// Type - Radio Button Selection - Button List
	@FindBy(how = How.CSS, using = "div[class='collapse show'] input[formcontrolname='typeCode']")
	private List<WebElement> _radioMealsTypeButtonList;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeLeaveTransportTypeList'] span[class*='ng-value-label']")
	private WebElement _selectTransportationTypeSelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span[class*='ng-value-label']")
	private WebElement _selectAccompanyingFamilyMemberCodeSelectedValue;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='excessBaggageFeesInd']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnExcessBaggageFeesLabelList;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='excessBaggageFeesInd']")
	private List<WebElement> _radioBtnExcessBaggageFeesButtonList;
	
	@FindBy(how = How.CSS, using = "div[class='collapse show'] ng-select[formcontrolname='maxAmountCode'] span[class*='ng-value-label']")
	private WebElement _selectMaxAmtSelectedValue;

	/*********************************************************************/

	CoreFlex_MovingBenefitsData movingBenefitData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMovingBenefitDataList(COREFLEXConstants.HOME_LEAVE);

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
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.HOME_LEAVE, expectedPageName,
				expectedPageName, true);
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
				CoreFunctions.selectItemInListByText(driver, _subBenefitList, subBenefit.trim(), true);
				if (CoreFunctions.isElementExist(driver, getElementByName(subBenefit.trim()), 5)) {
					fillSubBenefit(subBenefit.trim(), benefitType);
				} else {
					Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.HOME_LEAVE_BENEFITS_PAGE));
					throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.HOME_LEAVE_BENEFITS_PAGE));
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
		case COREFLEXConstants.HOME_LEAVE_TRANSPORTATION:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOME_LEAVE_TRANSPORTATION));
			fillHomeLeaveTransportationSubBenefitForm(COREFLEXConstants.HOME_LEAVE_TRANSPORTATION);
			break;
		case COREFLEXConstants.HOME_LEAVE_LODGING:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOME_LEAVE_LODGING));
			fillHomeLeaveLodgingSubBenefitForm(COREFLEXConstants.HOME_LEAVE_LODGING);
			break;
		case COREFLEXConstants.HOME_LEAVE_RENTAL_CAR:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOME_LEAVE_RENTAL_CAR));
			fillHomeLeaveRentalCarSubBenefitForm(COREFLEXConstants.HOME_LEAVE_RENTAL_CAR);
			break;
		case COREFLEXConstants.HOME_LEAVE_MEALS:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOME_LEAVE_MEALS));
			fillHomeLeaveMealsSubBenefitForm(COREFLEXConstants.HOME_LEAVE_MEALS);
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to fill Home Leave Transportation subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillHomeLeaveTransportationSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputAssignmentTrip,
					movingBenefitData.homeLeaveTransportation.assignmentNumberOfTrips);
			CoreFunctions.clickElement(driver, _selectFrequencyOfTrip);
			CoreFunctions.selectItemInListByText(driver, _selectFrequencyOfTripOptions,
					movingBenefitData.homeLeaveTransportation.frequencyTrip, true);
			if (movingBenefitData.homeLeaveTransportation.frequencyTrip.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputFrequencyOfTripOther,
						movingBenefitData.homeLeaveTransportation.frequencyTripOther);
			}
			CoreFunctions.clickElement(driver, _selectTransportationType);
			CoreFunctions.selectItemInListByText(driver, _selectTransportationTypeOptions,
					movingBenefitData.homeLeaveTransportation.transportationType, true);
			CoreFunctions.clickElement(driver, _selectTransportationType);
			CoreFunctions.clearAndSetText(driver, _inputMinMileageEconomy,
					movingBenefitData.homeLeaveTransportation.minMilForEconomyAirTravel);
			CoreFunctions.clearAndSetText(driver, _inputMinMileageBusiness,
					movingBenefitData.homeLeaveTransportation.minMilForBusinessAirTravel);
			CoreFunctions.clearAndSetText(driver, _inputMinFlightTimeExlLayovers,
					movingBenefitData.homeLeaveTransportation.minFlightTimeExclLayovers);
			CoreFunctions.clickElement(driver, _selectAccompanyingFamilyMemberCode);
			CoreFunctions.selectItemInListByText(driver, _selectAccompanyingFamilyMemberCodeOptions,
					movingBenefitData.homeLeaveTransportation.accompanyingFamilyMember, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnExcessBaggageFees,
					movingBenefitData.homeLeaveTransportation.excessBaggageFees, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmountPerPerson,
					movingBenefitData.homeLeaveTransportation.maxAmountPerPerson);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					movingBenefitData.homeLeaveTransportation.grossUp, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					movingBenefitData.homeLeaveTransportation.reimbursedBy, true);
			if (movingBenefitData.homeLeaveTransportation.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						movingBenefitData.homeLeaveTransportation.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment, movingBenefitData.homeLeaveTransportation.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName, e.getMessage()));
		}
	}

	/**
	 * Method to fill Home Leave Lodging subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillHomeLeaveLodgingSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputDurationInDays,
					movingBenefitData.homeLeaveLodging.durationDays);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp, movingBenefitData.homeLeaveLodging.grossUp,
					true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					movingBenefitData.homeLeaveLodging.reimbursedBy, true);
			if (movingBenefitData.homeLeaveLodging.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						movingBenefitData.homeLeaveLodging.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment, movingBenefitData.homeLeaveLodging.comment);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Method to fill Home Leave Rental Car subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillHomeLeaveRentalCarSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputDurationInDays,
					movingBenefitData.homeLeaveRentalCar.durationDays);
			CoreFunctions.clickElement(driver, _selectRentalCarSize);
			CoreFunctions.selectItemInListByText(driver, _selectRentalCarSizeOptions,
					movingBenefitData.homeLeaveRentalCar.rentalCarSize, true);
			if (movingBenefitData.homeLeaveRentalCar.rentalCarSize.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputRentalCarOtherSize,
						movingBenefitData.homeLeaveRentalCar.rentalCarSizeOther);
			}
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp, movingBenefitData.homeLeaveRentalCar.grossUp,
					true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					movingBenefitData.homeLeaveRentalCar.reimbursedBy, true);
			if (movingBenefitData.homeLeaveRentalCar.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						movingBenefitData.homeLeaveRentalCar.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment, movingBenefitData.homeLeaveRentalCar.comment);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Method to fill Home Leave Meals subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillHomeLeaveMealsSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputNumOfDaysForMeals,
					movingBenefitData.homeLeaveMeals.numberOfDaysForMeal);
			CoreFunctions.selectItemInListByText(driver, _radioBtnMealType, movingBenefitData.homeLeaveMeals.type,
					true);
			CoreFunctions.clickElement(driver, _selectMaxAmtMeals);
			CoreFunctions.selectItemInListByText(driver, _selectMaxAmtMealsOptions,
					movingBenefitData.homeLeaveMeals.maxAmount, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmtTransferee,
					movingBenefitData.homeLeaveMeals.maxAmtTransferee);
			CoreFunctions.clickElement(driver, _selectTransfereeCurrency);
			CoreFunctions.selectItemInListByText(driver, _selectTransfereeCurrencyOptions,
					movingBenefitData.homeLeaveMeals.maxAmtTransfereeCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailTransfereeCode,
					movingBenefitData.homeLeaveMeals.maxAmtTransfereeDetail, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmtAdult, movingBenefitData.homeLeaveMeals.maxAmtAdult);
			CoreFunctions.clickElement(driver, _selectAdultCurrency);
			CoreFunctions.selectItemInListByText(driver, _selectAdultCurrencyOptions,
					movingBenefitData.homeLeaveMeals.maxAmtAdultCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailAdult,
					movingBenefitData.homeLeaveMeals.maxAmtAdultDetail, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmtChild, movingBenefitData.homeLeaveMeals.maxAmtChildren);
			CoreFunctions.clickElement(driver, _selectCurrencyCodeChild);
			CoreFunctions.selectItemInListByText(driver, _selectCurrencyCodeChildOptions,
					movingBenefitData.homeLeaveMeals.maxAmtChildrenCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailChild,
					movingBenefitData.homeLeaveMeals.maxAmtChildrenDetail, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp, movingBenefitData.homeLeaveMeals.grossUp,
					true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					movingBenefitData.homeLeaveMeals.reimbursedBy, true);
			if (movingBenefitData.homeLeaveMeals.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						movingBenefitData.homeLeaveMeals.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment, movingBenefitData.homeLeaveMeals.comment);
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
		case COREFLEXConstants.HOME_LEAVE_TRANSPORTATION:
			element = _formHomeLeaveTransportation;
			break;
		case COREFLEXConstants.HOME_LEAVE_LODGING:
			element = _formHomeLeaveLodging;
			break;
		case COREFLEXConstants.HOME_LEAVE_RENTAL_CAR:
			element = _formHomeLeaveRentalCar;
			break;
		case COREFLEXConstants.HOME_LEAVE_MEALS:
			element = _formHomeLeaveMeals;
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
		Benefit homeLeaveBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.HOME_LEAVE)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, homeLeaveBenefit.getBenefitDisplayName(),
					homeLeaveBenefit.getBenefitAmount(), homeLeaveBenefit.getBenefitDesc(), aireManagedService);
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
			fillManadatoryDetails(benefitType, multipleBenefitSelection, homeLeaveBenefit.getBenefitDisplayName(),
					homeLeaveBenefit.getBenefitAmount(), homeLeaveBenefit.getBenefitDesc(), aireManagedService);
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
		Benefit homeLeaveBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.HOME_LEAVE)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, homeLeaveBenefit.getBenefitDisplayName(),
					homeLeaveBenefit.getBenefitAmount(), homeLeaveBenefit.getBenefitDesc(), paymentOption,
					airesManagedService);
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
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, homeLeaveBenefit.getBenefitDisplayName(),
					homeLeaveBenefit.getBenefitAmount(), homeLeaveBenefit.getBenefitDesc(), paymentOption,
					airesManagedService);
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
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.HOME_LEAVE_BENEFITS_PAGE));
					throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.HOME_LEAVE_BENEFITS_PAGE));
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
		case COREFLEXConstants.HOME_LEAVE_TRANSPORTATION:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOME_LEAVE_TRANSPORTATION));
			verifyHomeLeaveTransportationSubBenefitForm(COREFLEXConstants.HOME_LEAVE_TRANSPORTATION);
			break;
		case COREFLEXConstants.HOME_LEAVE_LODGING:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOME_LEAVE_LODGING));
			verifyHomeLeaveLodgingSubBenefitForm(COREFLEXConstants.HOME_LEAVE_LODGING);
			break;
		case COREFLEXConstants.HOME_LEAVE_RENTAL_CAR:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOME_LEAVE_RENTAL_CAR));
			verifyHomeLeaveRentalCarSubBenefitForm(COREFLEXConstants.HOME_LEAVE_RENTAL_CAR);
			break;
		case COREFLEXConstants.HOME_LEAVE_MEALS:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.HOME_LEAVE_MEALS));
			verifyHomeLeaveMealsSubBenefitForm(COREFLEXConstants.HOME_LEAVE_MEALS);
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to verify HomeLeaveTransportation subBenefit form
	 */
	private void verifyHomeLeaveTransportationSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(_inputAssignmentTrip.getDomProperty("value"),
					movingBenefitData.homeLeaveTransportation.assignmentNumberOfTrips,
					COREFLEXConstants.ASSIGNMENT_NUMBER_OF_TRIPS);
			CoreFunctions.verifyText(driver, _selectFrequencyOfTripSelectedValue,
					movingBenefitData.homeLeaveTransportation.frequencyTrip,
					COREFLEXConstants.ASSIGNMENT_FREQUENCY_OF_TRIPS);
			if (movingBenefitData.homeLeaveTransportation.frequencyTrip.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputFrequencyOfTripOther.getDomProperty("value"),
						movingBenefitData.homeLeaveTransportation.frequencyTripOther,
						COREFLEXConstants.OTHER_FREQUENCY_OF_TRIPS);
			}
			CoreFunctions.verifyText(driver, _selectTransportationTypeSelectedValue,
					movingBenefitData.homeLeaveTransportation.transportationType,
					COREFLEXConstants.TRANSPORTATION_TYPE);
			CoreFunctions.verifyText(_inputMinMileageEconomy.getDomProperty("value"),
					movingBenefitData.homeLeaveTransportation.minMilForEconomyAirTravel,
					COREFLEXConstants.MIN_MILEAGE_FOR_ECONOMY_AIR_TRAVEL);
			CoreFunctions.verifyText(_inputMinMileageBusiness.getDomProperty("value"),
					movingBenefitData.homeLeaveTransportation.minMilForBusinessAirTravel,
					COREFLEXConstants.MIN_MILEAGE_FOR_BUSINESS_AIR_TRAVEL);
			CoreFunctions.verifyText(_inputMinFlightTimeExlLayovers.getDomProperty("value"),
					movingBenefitData.homeLeaveTransportation.minFlightTimeExclLayovers,
					COREFLEXConstants.MIN_FLIGHT_TIME_EXCL_LAYOVERS);
			CoreFunctions.verifyText(driver, _selectAccompanyingFamilyMemberCodeSelectedValue,
					movingBenefitData.homeLeaveTransportation.accompanyingFamilyMember,
					COREFLEXConstants.ACCOMPANYING_FAMILY_MEMBERS);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioBtnExcessBaggageFeesLabelList,
					_radioBtnExcessBaggageFeesButtonList, movingBenefitData.homeLeaveTransportation.excessBaggageFees,
					COREFLEXConstants.EXCESS_BAGGAGE_FEES);
			CoreFunctions.verifyText(_inputMaxAmountPerPerson.getDomProperty("value"),
					movingBenefitData.homeLeaveTransportation.maxAmountPerPerson, COREFLEXConstants.MAX_AMOUNT);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					movingBenefitData.homeLeaveTransportation.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					movingBenefitData.homeLeaveTransportation.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (movingBenefitData.homeLeaveTransportation.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						movingBenefitData.homeLeaveTransportation.reimbursedByOther,
						COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					movingBenefitData.homeLeaveTransportation.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_HOME_LEAVE_SUB_BENEFITS_FORM,
					CoreConstants.FAIL, formName));
		}
	}

	/**
	 * Method to verify HomeLeaveLodging subBenefit form
	 */
	private void verifyHomeLeaveLodgingSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(_inputDurationInDays.getDomProperty("value"),
					movingBenefitData.homeLeaveLodging.durationDays, COREFLEXConstants.DURATION_DAYS);
			CoreFunctions.highlightObject(driver, _inputDurationInDays);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					movingBenefitData.homeLeaveLodging.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					movingBenefitData.homeLeaveLodging.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (movingBenefitData.homeLeaveLodging.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						movingBenefitData.homeLeaveLodging.reimbursedByOther, COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					movingBenefitData.homeLeaveLodging.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_HOME_LEAVE_SUB_BENEFITS_FORM,
					CoreConstants.FAIL, formName));
		}
	}

	/**
	 * Method to verify HomeLeaveRentalCar subBenefit form
	 */
	private void verifyHomeLeaveRentalCarSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(_inputDurationInDays.getDomProperty("value"),
					movingBenefitData.homeLeaveRentalCar.durationDays, COREFLEXConstants.DURATION_DAYS);
			CoreFunctions.highlightObject(driver, _inputDurationInDays);
			CoreFunctions.verifyText(driver, _selectRentalCarSizeSelectedValue,
					movingBenefitData.homeLeaveRentalCar.rentalCarSize,
					COREFLEXConstants.RENTAL_CAR_SIZE_CLASS);
			if (movingBenefitData.homeLeaveRentalCar.rentalCarSize.equalsIgnoreCase(COREFLEXConstants.OTHER)) {	
				CoreFunctions.verifyText(_inputRentalCarOtherSize.getDomProperty("value"),
						movingBenefitData.homeLeaveRentalCar.rentalCarSizeOther, COREFLEXConstants.RENTAL_CAR_OTHER_SIZE_CLASS);
				CoreFunctions.highlightObject(driver, _inputRentalCarOtherSize);
			}
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					movingBenefitData.homeLeaveRentalCar.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					movingBenefitData.homeLeaveRentalCar.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (movingBenefitData.homeLeaveRentalCar.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						movingBenefitData.homeLeaveRentalCar.reimbursedByOther, COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					movingBenefitData.homeLeaveRentalCar.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_HOME_LEAVE_SUB_BENEFITS_FORM,
					CoreConstants.FAIL, formName));
		}
	}

	/**
	 * Method to verify FinalMoveMeals subBenefit form
	 */
	private void verifyHomeLeaveMealsSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(_inputNumOfDaysForMeals.getDomProperty("value"),
					movingBenefitData.homeLeaveMeals.numberOfDaysForMeal, COREFLEXConstants.NUMBER_OF_DAYS_FOR_MEAL);
			CoreFunctions.highlightObject(driver, _inputNumOfDaysForMeals);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioMealsTypeLabelList, _radioMealsTypeButtonList,
					movingBenefitData.homeLeaveMeals.type, COREFLEXConstants.MEAL_TYPE);
			CoreFunctions.verifyText(driver, _selectMaxAmtSelectedValue, movingBenefitData.homeLeaveMeals.maxAmount,
					COREFLEXConstants.MAX_AMOUNT);

			CoreFunctions.verifyText(_inputMaxAmtTransferee.getDomProperty("value"),
					movingBenefitData.homeLeaveMeals.maxAmtTransferee, COREFLEXConstants.MAX_AMOUNT_TRANSFEREE);
			CoreFunctions.verifyText(driver, _selectTransfereeCurrencySelectedValue,
					movingBenefitData.homeLeaveMeals.maxAmtTransfereeCurrency, COREFLEXConstants.CURRENCY_TRANSFEREE);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioDetailTransfereeCodeLabelList,
					_radioDetailTransfereeCodeButtonList, movingBenefitData.homeLeaveMeals.maxAmtTransfereeDetail,
					COREFLEXConstants.TRANSFEREE_DETAIL);

			CoreFunctions.verifyText(_inputMaxAmtAdult.getDomProperty("value"),
					movingBenefitData.homeLeaveMeals.maxAmtAdult, COREFLEXConstants.MAX_AMOUNT_ADULT);
			CoreFunctions.verifyText(driver, _selectAdultCurrencySelectedValue,
					movingBenefitData.homeLeaveMeals.maxAmtAdultCurrency, COREFLEXConstants.CURRENCY_ADULT);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioDetailAdultCodeLabelList,
					_radioDetailAdultCodeButtonList, movingBenefitData.homeLeaveMeals.maxAmtAdultDetail,
					COREFLEXConstants.ADULT_DETAIL);

			CoreFunctions.verifyText(_inputMaxAmtChild.getDomProperty("value"),
					movingBenefitData.homeLeaveMeals.maxAmtChildren, COREFLEXConstants.MAX_AMOUNT_CHILDREN);
			CoreFunctions.verifyText(driver, _selectCurrencyCodeChildSelectedValue,
					movingBenefitData.homeLeaveMeals.maxAmtChildrenCurrency, COREFLEXConstants.CURRENCY_CHILDREN);
			CoreFunctions.verifyRadioButtonSelection(driver, __radioDetailChildLabelList, _radioDetailChildButtonList,
					movingBenefitData.homeLeaveMeals.maxAmtChildrenDetail, COREFLEXConstants.CHILDREN_DETAIL);

			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					movingBenefitData.homeLeaveMeals.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					movingBenefitData.homeLeaveMeals.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (movingBenefitData.homeLeaveMeals.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						movingBenefitData.homeLeaveMeals.reimbursedByOther, COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"), movingBenefitData.homeLeaveMeals.comment,
					COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_HOME_LEAVE_SUB_BENEFITS_FORM,
					CoreConstants.FAIL, formName));
		}
	}
}
