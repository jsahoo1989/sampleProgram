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

public class CoreFlex_FinalMove_BenefitsPage extends Base {
	public CoreFlex_FinalMove_BenefitsPage(WebDriver driver) {
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
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Final Move Transportation')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formFinalMoveTransportation;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Final Move Transportation')]")
	private WebElement _headerFinalMoveTransportation;

	// SubBenefit - Collapsable Menu 2
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Final Move Lodging')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formFinalMoveLodging;

	// SubBenefit - Collapsable Menu 3
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Final Move Meals')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formFinalMoveMeals;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='finalMoveTransportTypeList']")
	private WebElement _selectTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='finalMoveTransportTypeList'] span.ng-option-label")
	private List<WebElement> _selectTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minMileageEconomy']")
	private WebElement _inputMinMileageEconomy;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minMileageBusiness']")
	private WebElement _inputMinMileageBusiness;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minHrsBusinsAtrvl']")
	private WebElement _inputMinHrsForBusinessAirTravel;

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

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//ng-select[@formcontrolname='finalMoveDurationCode']")
	private WebElement _selectDuration;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//ng-select[@formcontrolname='finalMoveDurationCode']//div[@role='option']")
	private List<WebElement> _selectDurationOptions;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//ng-select[@formcontrolname='maxAmountCode']")
	private WebElement _selectMaxAmt;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//ng-select[@formcontrolname='maxAmountCode']//div[@role='option']")
	private List<WebElement> _selectMaxAmtOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfNight']")
	private WebElement _inputNumberOfNights;

	@FindBy(how = How.CSS, using = "input[formcontrolname='flatAmountPerNight']")
	private WebElement _inputFlatAmtPerNight;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _selectCurrencyCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _selectCurrencyCodeOptions;
	
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//ng-select[@formcontrolname='finalMoveDurationCode']")
	private WebElement _selectNumberOfDaysForMeals;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//ng-select[@formcontrolname='finalMoveDurationCode']//div[@role='option']")
	private List<WebElement> _selectNumberOfDaysForMealsOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfDay']")
	private WebElement _inputNumberOfDays;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='mealTypeCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnMealType;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountEe']")
	private WebElement _inputMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe']")
	private WebElement _selectTransfereeCurrency;

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

	/*********************************************************************/

	CoreFlex_MovingBenefitsData finalMoveBenefitData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMovingBenefitDataList(COREFLEXConstants.FINAL_MOVE);

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
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.FINAL_MOVE, expectedPageName,
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
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.FINAL_MOVE_BENEFITS_PAGE));
					throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.FINAL_MOVE_BENEFITS_PAGE));
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
		case COREFLEXConstants.FINAL_MOVE_TRANSPORTATION:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.FINAL_MOVE_TRANSPORTATION));
			fillFinalMoveTransportationSubBenefitForm(COREFLEXConstants.FINAL_MOVE_TRANSPORTATION);
			break;
		case COREFLEXConstants.FINAL_MOVE_LODGING:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.FINAL_MOVE_LODGING));
			fillFinalMoveLodgingSubBenefitForm(COREFLEXConstants.FINAL_MOVE_LODGING);
			break;
		case COREFLEXConstants.FINAL_MOVE_MEALS:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.FINAL_MOVE_MEALS));
			fillFinalMoveMealsSubBenefitForm(COREFLEXConstants.FINAL_MOVE_MEALS);
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to fill Final Move Transportation subBenefit form
	 * @param subBenefitFormName 
	 */
	private void fillFinalMoveTransportationSubBenefitForm(String subBenefitFormName) {
		try {			
			CoreFunctions.clickElement(driver, _selectTransportationType);
			CoreFunctions.selectItemInListByText(driver, _selectTransportationTypeOptions,
					finalMoveBenefitData.finalMoveTransportation.transportationType, true);
			CoreFunctions.clickElement(driver, _selectTransportationType);
			CoreFunctions.clearAndSetText(driver, _inputMinMileageEconomy,
					finalMoveBenefitData.finalMoveTransportation.minMilForEconomyAirTravel);
			CoreFunctions.clearAndSetText(driver, _inputMinMileageBusiness,
					finalMoveBenefitData.finalMoveTransportation.minMilForBusinessAirTravel);
			CoreFunctions.clearAndSetText(driver, _inputMinHrsForBusinessAirTravel,
					finalMoveBenefitData.finalMoveTransportation.minHrsForBusinessAirTravel);
			CoreFunctions.clearAndSetText(driver, _inputMinFlightTimeExlLayovers,
					finalMoveBenefitData.finalMoveTransportation.minFlightTimeExclLayovers);
			CoreFunctions.clickElement(driver, _selectAccompanyingFamilyMemberCode);
			CoreFunctions.selectItemInListByText(driver, _selectAccompanyingFamilyMemberCodeOptions,
					finalMoveBenefitData.finalMoveTransportation.accompanyingFamilyMembers, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnExcessBaggageFees,
					finalMoveBenefitData.finalMoveTransportation.excessBaggageFees, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmountPerPerson,
					finalMoveBenefitData.finalMoveTransportation.maxAmountPerPerson);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					finalMoveBenefitData.finalMoveTransportation.grossUp, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					finalMoveBenefitData.finalMoveTransportation.reimbursedBy, true);
			if (finalMoveBenefitData.finalMoveTransportation.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						finalMoveBenefitData.finalMoveTransportation.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment,
					finalMoveBenefitData.finalMoveTransportation.comment);			
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName,e.getMessage()));
		}
	}

	/**
	 * Method to fill Final Move Lodging subBenefit form
	 * @param subBenefitFormName 
	 */
	private void fillFinalMoveLodgingSubBenefitForm(String subBenefitFormName) {
		try {			
			CoreFunctions.clickElement(driver, _selectDuration);
			CoreFunctions.selectItemInListByText(driver, _selectDurationOptions,
					finalMoveBenefitData.finalMoveLodging.duration, true);
			CoreFunctions.clearAndSetText(driver, _inputNumberOfNights,
					finalMoveBenefitData.finalMoveLodging.numberOfNights);
			CoreFunctions.clickElement(driver, _selectMaxAmt);
			CoreFunctions.selectItemInListByText(driver, _selectMaxAmtOptions,
					finalMoveBenefitData.finalMoveLodging.maxAmount, true);	
			CoreFunctions.clearAndSetText(driver, _inputFlatAmtPerNight,
					finalMoveBenefitData.finalMoveLodging.flatAmountPerNight);
			CoreFunctions.clickElement(driver, _selectCurrencyCode);
			CoreFunctions.selectItemInListByText(driver, _selectCurrencyCodeOptions,
					finalMoveBenefitData.finalMoveLodging.currency, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					finalMoveBenefitData.finalMoveLodging.grossUp, true);			
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					finalMoveBenefitData.finalMoveLodging.reimbursedBy, true);
			if (finalMoveBenefitData.finalMoveLodging.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						finalMoveBenefitData.finalMoveLodging.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment,
					finalMoveBenefitData.finalMoveLodging.comment);			
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Method to fill Final Move Meals subBenefit form
	 * @param subBenefitFormName
	 */
	private void fillFinalMoveMealsSubBenefitForm(String subBenefitFormName) {
		try {			
			CoreFunctions.clickElement(driver, _selectNumberOfDaysForMeals);
			CoreFunctions.selectItemInListByText(driver, _selectNumberOfDaysForMealsOptions,
					finalMoveBenefitData.finalMoveMeals.numberOfDaysForMeal, true);
			CoreFunctions.clearAndSetText(driver, _inputNumberOfDays,
					finalMoveBenefitData.finalMoveMeals.numberOfDays);
			CoreFunctions.selectItemInListByText(driver, _radioBtnMealType,
					finalMoveBenefitData.finalMoveMeals.type, true);
			CoreFunctions.clickElement(driver, _selectMaxAmt);
			CoreFunctions.selectItemInListByText(driver, _selectMaxAmtOptions,
					finalMoveBenefitData.finalMoveMeals.maxAmount, true);
			
			CoreFunctions.clearAndSetText(driver, _inputMaxAmtTransferee,
					finalMoveBenefitData.finalMoveMeals.maxAmtTransferee);
			CoreFunctions.clickElement(driver, _selectTransfereeCurrency);
			CoreFunctions.selectItemInListByText(driver, _selectTransfereeCurrencyOptions,
					finalMoveBenefitData.finalMoveMeals.maxAmtTransfereeCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailTransfereeCode,
					finalMoveBenefitData.finalMoveMeals.maxAmtTransfereeDetail, true);
			
			CoreFunctions.clearAndSetText(driver, _inputMaxAmtAdult,
					finalMoveBenefitData.finalMoveMeals.maxAmtAdult);
			CoreFunctions.clickElement(driver, _selectAdultCurrency);
			CoreFunctions.selectItemInListByText(driver, _selectAdultCurrencyOptions,
					finalMoveBenefitData.finalMoveMeals.maxAmtAdultCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailAdult,
					finalMoveBenefitData.finalMoveMeals.maxAmtAdultDetail, true);
			
			CoreFunctions.clearAndSetText(driver, _inputMaxAmtChild,
					finalMoveBenefitData.finalMoveMeals.maxAmtChildren);
			CoreFunctions.clickElement(driver, _selectCurrencyCodeChild);
			CoreFunctions.selectItemInListByText(driver, _selectCurrencyCodeChildOptions,
					finalMoveBenefitData.finalMoveMeals.maxAmtChildrenCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailChild,
					finalMoveBenefitData.finalMoveMeals.maxAmtChildrenDetail, true);
			
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					finalMoveBenefitData.finalMoveMeals.grossUp, true);			
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					finalMoveBenefitData.finalMoveMeals.reimbursedBy, true);
			if (finalMoveBenefitData.finalMoveMeals.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						finalMoveBenefitData.finalMoveMeals.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment,
					finalMoveBenefitData.finalMoveMeals.comment);			
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
		case COREFLEXConstants.FINAL_MOVE_TRANSPORTATION:
			element = _formFinalMoveTransportation;
			break;
		case COREFLEXConstants.FINAL_MOVE_LODGING:
			element = _formFinalMoveLodging;
			break;
		case COREFLEXConstants.FINAL_MOVE_MEALS:
			element = _formFinalMoveMeals;
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return element;
	}

	/**
	 * Method to select Benefit Type and fill all Mandatory Fields
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
		Benefit finalMoveBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.FINAL_MOVE)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, finalMoveBenefit.getBenefitDisplayName(),
					finalMoveBenefit.getBenefitAmount(), finalMoveBenefit.getBenefitDesc(), aireManagedService);
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
			fillManadatoryDetails(benefitType, multipleBenefitSelection, finalMoveBenefit.getBenefitDisplayName(),
					finalMoveBenefit.getBenefitAmount(), finalMoveBenefit.getBenefitDesc(), aireManagedService);
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
}
