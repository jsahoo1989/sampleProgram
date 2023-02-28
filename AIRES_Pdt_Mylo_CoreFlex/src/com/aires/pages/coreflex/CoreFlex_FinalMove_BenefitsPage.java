package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_MovingBenefitsData;
import com.hp.lft.sdk.java.Table;
import com.hp.lft.sdk.java.Window;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_FinalMove_BenefitsPage extends BenefitPage {
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
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'loading-foreground')] | //div[contains(@class,'foreground-closing')]")
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

	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
	private List<WebElement> _selectTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='finalMoveTransportTypeList'] span[class*='ng-value-label']")
	private WebElement _selectTransportationTypeSelectedValue;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceEconomyFm']")
	private WebElement _inputDistanceEconomy;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='unitOfEconomyCodeFm']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnUnitOfDistanceEconomy;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='unitOfEconomyCodeFm']")
	private List<WebElement> _radioBtnUnitOfDistanceEconomyButtonList;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minDistanceEconomyHht']")
	private WebElement _inputMinDistanceEconomy;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minHrsBusinsAtrvl']")
	private WebElement _inputMinHrsForBusinessAirTravel;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minFlightTimeExec']")
	private WebElement _inputMinFlightTimeExlLayovers;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode']")
	private WebElement _selectAccompanyingFamilyMemberCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span[class*='ng-value-label']")
	private WebElement _selectAccompanyingFamilyMemberCodeSelectedValue;

	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
	private List<WebElement> _selectAccompanyingFamilyMemberCodeOptions;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='excessBaggageFeesInd']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnExcessBaggageFees;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='excessBaggageFeesInd']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnExcessBaggageFeesLabelList;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='excessBaggageFeesInd']")
	private List<WebElement> _radioBtnExcessBaggageFeesButtonList;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountPerPerson']")
	private WebElement _inputMaxAmountPerPerson;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//ng-select[@formcontrolname='finalMoveDurationCode']")
	private WebElement _selectDuration;

	@FindBy(how = How.CSS, using = "div[class='collapse show'] ng-select[formcontrolname='finalMoveDurationCode'] span[class*='ng-value-label']")
	private WebElement _selectDurationSelectedValue;

	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
	private List<WebElement> _selectDurationOptions;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//ng-select[@formcontrolname='maxAmountCode']")
	private WebElement _selectMaxAmt;

	@FindBy(how = How.CSS, using = "div[class='collapse show'] ng-select[formcontrolname='maxAmountCode'] span[class*='ng-value-label']")
	private WebElement _selectMaxAmtSelectedValue;

	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
	private List<WebElement> _selectMaxAmtOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfNight']")
	private WebElement _inputNumberOfNights;

	@FindBy(how = How.CSS, using = "input[formcontrolname='flatAmountPerNight']")
	private WebElement _inputFlatAmtPerNight;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _selectCurrencyCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span[class*='ng-value-label']")
	private WebElement _selectCurrencyCodeSelectedValue;

	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
	private List<WebElement> _selectCurrencyCodeOptions;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//ng-select[@formcontrolname='finalMoveDurationCode']")
	private WebElement _selectNumberOfDaysForMeals;

	@FindBy(how = How.CSS, using = "div[class='collapse show'] ng-select[formcontrolname='finalMoveDurationCode'] span[class*='ng-value-label']")
	private WebElement _selectNumberOfDaysForMealsSelectedValue;

	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
	private List<WebElement> _selectNumberOfDaysForMealsOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfDay']")
	private WebElement _inputNumberOfDays;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='mealTypeCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnMealType;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountEe']")
	private WebElement _inputMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCode;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCodeLabelList;

	@FindBy(how = How.CSS, using = "input[formcontrolname='detailEeCode']")
	private List<WebElement> _radioDetailTransfereeCodeButtonList;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe']")
	private WebElement _selectTransfereeCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe'] span[class*='ng-value-label']")
	private WebElement _selectTransfereeCurrencySelectedValue;

	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
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

	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
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

	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
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
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//label[contains(text(),'Gross-Up')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioGrossUpLabelList;

	// Gross Up Radio Button Selection
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//label[contains(text(),'Gross-Up')]/following-sibling::div//input")
	private List<WebElement> _radioGrossUpButtonList;

	// Reimbursed By Radio Label Selection
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//label[contains(text(),'Reimbursed By')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioReimbursedByLabelList;

	// Reimbursed By Radio Button Selection
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//label[contains(text(),'Reimbursed By')]/following-sibling::div//input")
	private List<WebElement> _radioReimbursedByButtonList;

	// Type - Radio Button Selection - Label List
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='mealTypeCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioMealsTypeLabelList;

	// Type - Radio Button Selection - Button List
	@FindBy(how = How.CSS, using = "div[class='collapse show'] input[formcontrolname='mealTypeCode']")
	private List<WebElement> _radioMealsTypeButtonList;

	// Flex Policy Setup Page Header
	@FindBy(how = How.XPATH, using = "//h4[@class='card-title'][contains(text(),'Final Move')]")
	private WebElement _headerPageName;

	// If Applicable Text
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'if applicable')]")
	private List<WebElement> _textIfApplicable;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//div[contains(@class,'RXCFServicesMonitoringBorderPanel')]")
	private List<WebElement> flexCardPanelList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//div[contains(@class,'RXCFServicesMonitoringBorderPanel')]")
	private List<WebElement> coreCardPanelList;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfEconomyCodeFm']")
	private WebElement _selectUnitOfDistanceEconomy;

	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
	private List<WebElement> _selectUnitOfDistanceEconomyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='unitOfEconomyCodeFm'] span[class*='ng-value-label']")
	private WebElement _selectUnitOfDistanceEconomySelectedValue;

	private By _serviceCompleted = By
			.cssSelector("span[class='RXBigIconPrimary ServicesSuccessIcon icon-check-approved']");

	private By travelRequested = By.xpath("div[4]//span[text()='Travel Requested']");
	private By travelBooked = By.xpath("div[4]//span[text()='Travel Booked']");
	private By travelBegins = By.xpath("div[4]//span[text()='Travel Begins']");
	private By travelEnds = By.xpath("div[4]//span[text()='Travel Ends']");

	/*********************************************************************/

	CoreFlex_MovingBenefitsData movingBenefitData = FileReaderManager.getInstance().getCoreFlexJsonReader()
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
			case COREFLEXConstants.POINT_POLICY_SETUP:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.POINT_POLICY_SETUP);
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
				COREFLEXConstants.FINAL_MOVE_BENEFITS_PAGE);
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
		BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefitDisplayName,
				COREFLEXConstants.IF_APPLICABLE);
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
	public void selectSubBenefitsAndFillMandatoryFields(String subBenefitNames, String benefitType) {
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
	public void fillSubBenefit(String subBenefit, String benefitType) {
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
	 * 
	 * @param subBenefitFormName
	 */
	private void fillFinalMoveTransportationSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clickElement(driver, _selectTransportationType);
			CoreFunctions.selectItemInListByText(driver, _selectTransportationTypeOptions,
					movingBenefitData.finalMoveTransportation.transportationType, true);
			CoreFunctions.clickElement(driver, _selectTransportationType);
			fillTransportationTripBasedOnTypeSelection();
			CoreFunctions.clearAndSetText(driver, _inputMinFlightTimeExlLayovers,
					movingBenefitData.finalMoveTransportation.minFlightTimeExclLayovers);
			CoreFunctions.clickElement(driver, _selectAccompanyingFamilyMemberCode);
			CoreFunctions.selectItemInListByText(driver, _selectAccompanyingFamilyMemberCodeOptions,
					movingBenefitData.finalMoveTransportation.accompanyingFamilyMembers, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnExcessBaggageFees,
					movingBenefitData.finalMoveTransportation.excessBaggageFees, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmountPerPerson,
					movingBenefitData.finalMoveTransportation.maxAmountPerPerson);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					movingBenefitData.finalMoveTransportation.grossUp, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					movingBenefitData.finalMoveTransportation.reimbursedBy, true);
			if (movingBenefitData.finalMoveTransportation.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						movingBenefitData.finalMoveTransportation.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment, movingBenefitData.finalMoveTransportation.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName, e.getMessage()));
		}
	}

	private void fillTransportationTripBasedOnTypeSelection() {
		if ((movingBenefitData.finalMoveTransportation.transportationType)
				.contains(COREFLEXConstants.ECONOMY_CLASS_AIRFARE)) {
			CoreFunctions.clickElement(driver, _selectUnitOfDistanceEconomy);
			CoreFunctions.selectItemInListByText(driver, _selectUnitOfDistanceEconomyOptions,
					movingBenefitData.finalMoveTransportation.unitOfEconomyDistance, true);
			CoreFunctions.clearAndSetText(driver, _inputDistanceEconomy,
					movingBenefitData.finalMoveTransportation.minDistanceForEconomyAirTravel);
		}
	}

	/**
	 * Method to fill Final Move Lodging subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillFinalMoveLodgingSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clickElement(driver, _selectDuration);
			CoreFunctions.selectItemInListByText(driver, _selectDurationOptions,
					movingBenefitData.finalMoveLodging.duration, true);
			CoreFunctions.clearAndSetText(driver, _inputNumberOfNights,
					movingBenefitData.finalMoveLodging.numberOfNights);
			CoreFunctions.clickElement(driver, _selectMaxAmt);
			CoreFunctions.selectItemInListByText(driver, _selectMaxAmtOptions,
					movingBenefitData.finalMoveLodging.maxAmount, true);
			CoreFunctions.clearAndSetText(driver, _inputFlatAmtPerNight,
					movingBenefitData.finalMoveLodging.flatAmountPerNight);
			CoreFunctions.clickElement(driver, _selectCurrencyCode);
			CoreFunctions.selectItemInListByText(driver, _selectCurrencyCodeOptions,
					movingBenefitData.finalMoveLodging.currency, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp, movingBenefitData.finalMoveLodging.grossUp,
					true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					movingBenefitData.finalMoveLodging.reimbursedBy, true);
			if (movingBenefitData.finalMoveLodging.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						movingBenefitData.finalMoveLodging.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment, movingBenefitData.finalMoveLodging.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Method to fill Final Move Meals subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillFinalMoveMealsSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clickElement(driver, _selectNumberOfDaysForMeals);
			CoreFunctions.selectItemInListByText(driver, _selectNumberOfDaysForMealsOptions,
					movingBenefitData.finalMoveMeals.numberOfDaysForMeal, true);
			CoreFunctions.clearAndSetText(driver, _inputNumberOfDays, movingBenefitData.finalMoveMeals.numberOfDays);
			CoreFunctions.selectItemInListByText(driver, _radioBtnMealType, movingBenefitData.finalMoveMeals.type,
					true);
			CoreFunctions.clickElement(driver, _selectMaxAmt);
			CoreFunctions.selectItemInListByText(driver, _selectMaxAmtOptions,
					movingBenefitData.finalMoveMeals.maxAmount, true);

			CoreFunctions.clearAndSetText(driver, _inputMaxAmtTransferee,
					movingBenefitData.finalMoveMeals.maxAmtTransferee);
			CoreFunctions.clickElement(driver, _selectTransfereeCurrency);
			CoreFunctions.selectItemInListByText(driver, _selectTransfereeCurrencyOptions,
					movingBenefitData.finalMoveMeals.maxAmtTransfereeCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailTransfereeCode,
					movingBenefitData.finalMoveMeals.maxAmtTransfereeDetail, true);

			CoreFunctions.clearAndSetText(driver, _inputMaxAmtAdult, movingBenefitData.finalMoveMeals.maxAmtAdult);
			CoreFunctions.clickElement(driver, _selectAdultCurrency);
			CoreFunctions.selectItemInListByText(driver, _selectAdultCurrencyOptions,
					movingBenefitData.finalMoveMeals.maxAmtAdultCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailAdult,
					movingBenefitData.finalMoveMeals.maxAmtAdultDetail, true);

			CoreFunctions.clearAndSetText(driver, _inputMaxAmtChild, movingBenefitData.finalMoveMeals.maxAmtChildren);
			CoreFunctions.clickElement(driver, _selectCurrencyCodeChild);
			CoreFunctions.selectItemInListByText(driver, _selectCurrencyCodeChildOptions,
					movingBenefitData.finalMoveMeals.maxAmtChildrenCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailChild,
					movingBenefitData.finalMoveMeals.maxAmtChildrenDetail, true);

			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp, movingBenefitData.finalMoveMeals.grossUp,
					true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					movingBenefitData.finalMoveMeals.reimbursedBy, true);
			if (movingBenefitData.finalMoveMeals.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						movingBenefitData.finalMoveMeals.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment, movingBenefitData.finalMoveMeals.comment);
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
	public void expandSubBenefitIfCollapsed(WebElement subBenefitForm) {
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
		CoreFunctions.waitHandler(1);
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
	public void selectBenefitTypeAndFillMandatoryFields(String benefitType, String multipleBenefitSelection,
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
	public void fillManadatoryDetails(String benefitType, String multipleBenefitSelection, String benefitDisplayName,
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
		Benefit finalMoveBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.FINAL_MOVE)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, finalMoveBenefit.getBenefitDisplayName(),
					finalMoveBenefit.getBenefitAmount(), finalMoveBenefit.getBenefitDesc(), paymentOption,
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
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, finalMoveBenefit.getBenefitDisplayName(),
					finalMoveBenefit.getBenefitAmount(), finalMoveBenefit.getBenefitDesc(), paymentOption,
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
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.FINAL_MOVE_BENEFITS_PAGE));
					throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.FINAL_MOVE_BENEFITS_PAGE));
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
		case COREFLEXConstants.FINAL_MOVE_TRANSPORTATION:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.FINAL_MOVE_TRANSPORTATION));
			verifyFinalMoveTransportationSubBenefitForm(COREFLEXConstants.FINAL_MOVE_TRANSPORTATION);
			break;
		case COREFLEXConstants.FINAL_MOVE_LODGING:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.FINAL_MOVE_LODGING));
			verifyFinalMoveLodgingSubBenefitForm(COREFLEXConstants.FINAL_MOVE_LODGING);
			break;
		case COREFLEXConstants.FINAL_MOVE_MEALS:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.FINAL_MOVE_MEALS));
			verifyFinalMoveMealsSubBenefitForm(COREFLEXConstants.FINAL_MOVE_MEALS);
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to verify FinalMoveTransportation subBenefit form
	 */
	private void verifyFinalMoveTransportationSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(driver, _selectTransportationTypeSelectedValue,
					movingBenefitData.finalMoveTransportation.transportationType,
					COREFLEXConstants.TRANSPORTATION_TYPE);
			if ((movingBenefitData.finalMoveTransportation.transportationType)
					.contains(COREFLEXConstants.ECONOMY_CLASS_AIRFARE)) {
				CoreFunctions.verifyText(driver, _selectUnitOfDistanceEconomySelectedValue,
						movingBenefitData.finalMoveTransportation.unitOfEconomyDistance,
						COREFLEXConstants.UNIT_OF_DISTANCE);
				CoreFunctions.verifyText(_inputDistanceEconomy.getDomProperty("value"),
						movingBenefitData.finalMoveTransportation.minDistanceForEconomyAirTravel,
						COREFLEXConstants.ECONOMY_CLASS_AIRFARE);
			}
			CoreFunctions.verifyText(_inputMinFlightTimeExlLayovers.getDomProperty("value"),
					movingBenefitData.finalMoveTransportation.minFlightTimeExclLayovers,
					COREFLEXConstants.MIN_FLIGHT_TIME_EXCL_LAYOVERS);
			CoreFunctions.verifyText(driver, _selectAccompanyingFamilyMemberCodeSelectedValue,
					movingBenefitData.finalMoveTransportation.accompanyingFamilyMembers,
					COREFLEXConstants.ACCOMPANYING_FAMILY_MEMBERS);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioBtnExcessBaggageFeesLabelList,
					_radioBtnExcessBaggageFeesButtonList, movingBenefitData.finalMoveTransportation.excessBaggageFees,
					COREFLEXConstants.EXCESS_BAGGAGE_FEES);
			CoreFunctions.verifyText(_inputMaxAmountPerPerson.getDomProperty("value"),
					movingBenefitData.finalMoveTransportation.maxAmountPerPerson, COREFLEXConstants.MAX_AMOUNT);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					movingBenefitData.finalMoveTransportation.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					movingBenefitData.finalMoveTransportation.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (movingBenefitData.finalMoveTransportation.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						movingBenefitData.finalMoveTransportation.reimbursedByOther,
						COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					movingBenefitData.finalMoveTransportation.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_FINAL_MOVE_SUB_BENEFITS_FORM,
					CoreConstants.FAIL, formName));
		}
	}

	/**
	 * Method to verify FinalMoveLodging subBenefit form
	 */
	private void verifyFinalMoveLodgingSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(driver, _selectDurationSelectedValue, movingBenefitData.finalMoveLodging.duration,
					COREFLEXConstants.DURATION);
			CoreFunctions.verifyText(_inputNumberOfNights.getDomProperty("value"),
					movingBenefitData.finalMoveLodging.numberOfNights, COREFLEXConstants.NUMBER_OF_NIGHTS);
			CoreFunctions.verifyText(driver, _selectMaxAmtSelectedValue, movingBenefitData.finalMoveLodging.maxAmount,
					COREFLEXConstants.MAX_AMOUNT);
			CoreFunctions.verifyText(_inputFlatAmtPerNight.getDomProperty("value"),
					movingBenefitData.finalMoveLodging.flatAmountPerNight, COREFLEXConstants.FLAT_AMOUNT_PER_NIGHT);
			CoreFunctions.verifyText(driver, _selectCurrencyCodeSelectedValue,
					movingBenefitData.finalMoveLodging.currency, COREFLEXConstants.CURRENCY);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					movingBenefitData.finalMoveLodging.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					movingBenefitData.finalMoveLodging.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (movingBenefitData.finalMoveLodging.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						movingBenefitData.finalMoveLodging.reimbursedByOther, COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					movingBenefitData.finalMoveLodging.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_FINAL_MOVE_SUB_BENEFITS_FORM,
					CoreConstants.FAIL, formName));
		}
	}

	/**
	 * Method to verify FinalMoveMeals subBenefit form
	 */
	private void verifyFinalMoveMealsSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(driver, _selectNumberOfDaysForMealsSelectedValue,
					movingBenefitData.finalMoveMeals.numberOfDaysForMeal, COREFLEXConstants.NUMBER_OF_DAYS_FOR_MEAL);
			CoreFunctions.verifyText(_inputNumberOfDays.getDomProperty("value"),
					movingBenefitData.finalMoveMeals.numberOfDays, COREFLEXConstants.NUMBER_OF_DAYS);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioMealsTypeLabelList, _radioMealsTypeButtonList,
					movingBenefitData.finalMoveMeals.type, COREFLEXConstants.MEAL_TYPE);
			CoreFunctions.verifyText(driver, _selectMaxAmtSelectedValue, movingBenefitData.finalMoveMeals.maxAmount,
					COREFLEXConstants.MAX_AMOUNT);

			CoreFunctions.verifyText(_inputMaxAmtTransferee.getDomProperty("value"),
					movingBenefitData.finalMoveMeals.maxAmtTransferee, COREFLEXConstants.MAX_AMOUNT_TRANSFEREE);
			CoreFunctions.verifyText(driver, _selectTransfereeCurrencySelectedValue,
					movingBenefitData.finalMoveMeals.maxAmtTransfereeCurrency, COREFLEXConstants.CURRENCY_TRANSFEREE);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioDetailTransfereeCodeLabelList,
					_radioDetailTransfereeCodeButtonList, movingBenefitData.finalMoveMeals.maxAmtTransfereeDetail,
					COREFLEXConstants.TRANSFEREE_DETAIL);

			CoreFunctions.verifyText(_inputMaxAmtAdult.getDomProperty("value"),
					movingBenefitData.finalMoveMeals.maxAmtAdult, COREFLEXConstants.MAX_AMOUNT_ADULT);
			CoreFunctions.verifyText(driver, _selectAdultCurrencySelectedValue,
					movingBenefitData.finalMoveMeals.maxAmtAdultCurrency, COREFLEXConstants.CURRENCY_ADULT);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioDetailAdultCodeLabelList,
					_radioDetailAdultCodeButtonList, movingBenefitData.finalMoveMeals.maxAmtAdultDetail,
					COREFLEXConstants.ADULT_DETAIL);

			CoreFunctions.verifyText(_inputMaxAmtChild.getDomProperty("value"),
					movingBenefitData.finalMoveMeals.maxAmtChildren, COREFLEXConstants.MAX_AMOUNT_CHILDREN);
			CoreFunctions.verifyText(driver, _selectCurrencyCodeChildSelectedValue,
					movingBenefitData.finalMoveMeals.maxAmtChildrenCurrency, COREFLEXConstants.CURRENCY_CHILDREN);
			CoreFunctions.verifyRadioButtonSelection(driver, __radioDetailChildLabelList, _radioDetailChildButtonList,
					movingBenefitData.finalMoveMeals.maxAmtChildrenDetail, COREFLEXConstants.CHILDREN_DETAIL);

			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					movingBenefitData.finalMoveMeals.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					movingBenefitData.finalMoveMeals.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (movingBenefitData.finalMoveMeals.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						movingBenefitData.finalMoveMeals.reimbursedByOther, COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"), movingBenefitData.finalMoveMeals.comment,
					COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_FINAL_MOVE_SUB_BENEFITS_FORM,
					CoreConstants.FAIL, formName));
		}
	}

	@Override
	public boolean verifyFlexBenefitCardStatusAfterInitialActualization(int index, String expectedEstimatedDate) {
		return CoreFunctions.isElementExist(driver,
				CoreFunctions.findSubElement(flexCardPanelList.get(index), travelRequested), 3)
				&& CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(index), travelBooked), 3)
				&& CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(index), travelBegins), 3)
				&& CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(index), travelEnds), 3);
	}

	@Override
	protected boolean verifyFlexBenefitCardStatusAfterEndActualization(int index, String expectedEstimatedDate) {
		return CoreFunctions.isElementExist(driver,
				CoreFunctions.findSubElement(flexCardPanelList.get(index), travelRequested), 3)
				&& CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(index), travelBooked), 3)
				&& CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(index), travelBegins), 3)
				&& CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(index), travelEnds), 3);
	}

	@Override
	public boolean verifyCoreBenefitCardStatusAfterInitialActualization(int index, String expectedEstimatedDate) {
		return CoreFunctions.isElementExist(driver,
				CoreFunctions.findSubElement(coreCardPanelList.get(index), travelRequested), 3)
				&& CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(index), travelBooked), 3)
				&& CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(index), travelBegins), 3)
				&& CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(index), travelEnds), 3);
	}

	@Override
	protected boolean verifyCoreBenefitCardStatusAfterEndActualization(int index, Benefit benefit) {
		return CoreFunctions.isElementExist(driver,
				CoreFunctions.findSubElement(coreCardPanelList.get(index), _serviceCompleted), 3);
	}

	@Override
	public void addSubService(Window _IRIS, Table table, Benefit benefit, String coreFlexType) {
		try {
			table.waitUntilVisible();
			int rowCount = Helpers.getTableRowCount(table);
			table.getCell(rowCount - 1, "Type").setValue(benefit.getIrisSubserviceType());
			table.getCell(rowCount - 1, "Name").setValue(benefit.getIrisSubserviceName());
			CoreFunctions.waitHandler(1);
			table.getCell(rowCount - 1, "Core/Flex").setValue(coreFlexType);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_ADDING_SERVICE_SUBSERVICE_ON_SERVICES_TAB_OF_IRIS_APPLICATION,
					CoreConstants.FAIL, benefit.getIrisSubserviceType(), e.getMessage()));
		}

	}
}
