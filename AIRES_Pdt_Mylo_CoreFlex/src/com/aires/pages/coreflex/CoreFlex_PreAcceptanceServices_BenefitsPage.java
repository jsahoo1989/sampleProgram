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
import com.aires.testdatatypes.coreflex.CoreFlex_SettlingInBenefitsData;
import com.hp.lft.sdk.java.Table;
import com.hp.lft.sdk.java.Window;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_PreAcceptanceServices_BenefitsPage extends BenefitPage {
	public CoreFlex_PreAcceptanceServices_BenefitsPage(WebDriver driver) {
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
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Pre-Acceptance Trip Transportation')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formPreAcceptanceTripTransportation;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Pre-Acceptance Trip Transportation')]")
	private WebElement _headerPreAcceptanceTripTransportation;

	// SubBenefit - Collapsable Menu 2
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Pre-Acceptance Trip Lodging')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formPreAcceptanceTripLodging;

	// SubBenefit - Collapsable Menu 3
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Pre-Acceptance Rental Car')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formPreAcceptanceRentalCar;

	// SubBenefit - Collapsable Menu 4
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Pre-Acceptance Trip Meals')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formPreAcceptanceTripMeals;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfTrips']")
	private WebElement _inputNumOfTrips;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportTypeList']")
	private WebElement _selectTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportTypeList'] span[class*='ng-value-label']")
	private WebElement _selectTransportationTypeSelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='preAcceptanceTransportTypeList'] span.ng-option-label")
	private List<WebElement> _selectTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='distance']")
	private WebElement _inputDistance;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='unitOfDistanceCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnUnitOfDistance;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='unitOfDistanceCode']")
	private List<WebElement> _radioBtnUnitOfDistanceButtonList;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minFlightTimeExec']")
	private WebElement _inputMinFlightTimeExlLayovers;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode']")
	private WebElement _selectAccompanyingFamilyMemberCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span[class*='ng-value-label']")
	private WebElement _selectAccompanyingFamilyMemberCodeSelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-option-label")
	private List<WebElement> _selectAccompanyingFamilyMemberCodeOptions;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='excessBaggageFeesInd']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnExcessBaggageFees;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountPerPerson']")
	private WebElement _inputMaxAmountPerPerson;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfNightsPerTrip']")
	private WebElement _inputNumOfNightsPerTrip;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode']")
	private WebElement _selectAmount;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode'] span[class*='ng-value-label']")
	private WebElement _selectMaxAmountLodgingSelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode'] span.ng-option-label")
	private List<WebElement> _selectAmountOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='flatAmount']")
	private WebElement _inputFlatAmountPerNight;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _selectCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span[class*='ng-value-label']")
	private WebElement _selectCurrencySelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _selectCurrencyOptions;

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

	@FindBy(how = How.CSS, using = "app-pre-trip-meals input[formcontrolname='numOfDays']")
	private WebElement _inputNumOfDaysForMeals;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='mealTypeCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnMealType;

	@FindBy(how = How.CSS, using = "app-pre-trip-meals ng-select[formcontrolname='maxAmountCode']")
	private WebElement _selectMaxAmtMeals;

	@FindBy(how = How.CSS, using = "app-pre-trip-meals ng-select[formcontrolname='maxAmountCode'] span[class*=ng-option-label]")
	private List<WebElement> _selectMaxAmtMealsOptions;

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

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='excessBaggageFeesInd']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnExcessBaggageFeesLabelList;

	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='excessBaggageFeesInd']")
	private List<WebElement> _radioBtnExcessBaggageFeesButtonList;

	// Type - Radio Button Selection - Label List
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='mealTypeCode']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioMealsTypeLabelList;

	// Type - Radio Button Selection - Button List
	@FindBy(how = How.CSS, using = "div[class='collapse show'] input[formcontrolname='mealTypeCode']")
	private List<WebElement> _radioMealsTypeButtonList;

	@FindBy(how = How.CSS, using = "div[class='collapse show'] ng-select[formcontrolname='maxAmountCode'] span[class*='ng-value-label']")
	private WebElement _selectMaxAmtSelectedValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe'] span[class*='ng-value-label']")
	private WebElement _selectTransfereeCurrencySelectedValue;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCodeLabelList;

	@FindBy(how = How.CSS, using = "input[formcontrolname='detailEeCode']")
	private List<WebElement> _radioDetailTransfereeCodeButtonList;

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

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailAdultCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailAdultCodeLabelList;

	// Flex Policy Setup Page Header
	@FindBy(how = How.XPATH, using = "//h4[@class='card-title'][contains(text(),'Pre-Acceptance Services')]")
	private WebElement _headerPageName;

	// If Applicable Text
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'if applicable')]")
	private List<WebElement> _textIfApplicable;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//div[contains(@class,'RXCFServicesMonitoringBorderPanel')]")
	private List<WebElement> flexCardPanelList;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//div[contains(@class,'RXCFServicesMonitoringBorderPanel')]")
	private List<WebElement> coreCardPanelList;
	
	private By _serviceCompleted = By
			.cssSelector("span[class='RXBigIconPrimary ServicesSuccessIcon icon-check-approved']");

	private By travelRequested = By.xpath("div[4]//span[text()='Travel Requested']");
	private By travelBooked = By.xpath("div[4]//span[text()='Travel Booked']");
	private By travelBegins = By.xpath("div[4]//span[text()='Travel Begins']");
	private By travelEnds = By.xpath("div[4]//span[text()='Travel Ends']");

	/*********************************************************************/

	CoreFlex_SettlingInBenefitsData settlingInBenefitData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getSettlingInBenefitDataList(COREFLEXConstants.PRE_ACCEPTANCE_SERVICES);

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
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.PRE_ACCEPTANCE_SERVICES,
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
				COREFLEXConstants.PRE_ACCEPTANCE_SERVICES_BENEFITS_PAGE);
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
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.PRE_ACCEPTANCE_SERVICES_BENEFITS_PAGE));
					throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.PRE_ACCEPTANCE_SERVICES_BENEFITS_PAGE));
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
		case COREFLEXConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION));
			fillPreAcceptanceTripTransportationSubBenefitForm(COREFLEXConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION);
			break;
		case COREFLEXConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.PRE_ACCEPTANCE_TRIP_LODGING));
			fillPreAcceptanceTripLodgingSubBenefitForm(COREFLEXConstants.PRE_ACCEPTANCE_TRIP_LODGING);
			break;
		case COREFLEXConstants.PRE_ACCEPTANCE_RENTAL_CAR:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.PRE_ACCEPTANCE_RENTAL_CAR));
			fillPreAcceptanceRentalCarSubBenefitForm(COREFLEXConstants.PRE_ACCEPTANCE_RENTAL_CAR);
			break;
		case COREFLEXConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.PRE_ACCEPTANCE_TRIP_MEALS));
			fillPreAcceptanceTripMealsSubBenefitForm(COREFLEXConstants.PRE_ACCEPTANCE_TRIP_MEALS);
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to fill Pre-Acceptance Trip Transportation subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillPreAcceptanceTripTransportationSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputNumOfTrips,
					settlingInBenefitData.preAcceptanceTripTransportation.numberOfTrips);
			CoreFunctions.clickElement(driver, _selectTransportationType);
			CoreFunctions.selectItemInListByText(driver, _selectTransportationTypeOptions,
					settlingInBenefitData.preAcceptanceTripTransportation.transportationType, true);
			CoreFunctions.clickElement(driver, _selectTransportationType);
			if ((settlingInBenefitData.preAcceptanceTripTransportation.transportationType)
					.contains(COREFLEXConstants.DISTANCE)) {
				CoreFunctions.clearAndSetText(driver, _inputDistance,
						settlingInBenefitData.preAcceptanceTripTransportation.distance);
				CoreFunctions.selectItemInListByText(driver, _radioBtnUnitOfDistance,
						settlingInBenefitData.preAcceptanceTripTransportation.unitOfDistance, true);
			}			
			CoreFunctions.clearAndSetText(driver, _inputMinFlightTimeExlLayovers,
					settlingInBenefitData.preAcceptanceTripTransportation.minFlightTimeExclLayovers);
			CoreFunctions.clickElement(driver, _selectAccompanyingFamilyMemberCode);
			CoreFunctions.selectItemInListByText(driver, _selectAccompanyingFamilyMemberCodeOptions,
					settlingInBenefitData.preAcceptanceTripTransportation.accompanyingFamilyMember, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnExcessBaggageFees,
					settlingInBenefitData.preAcceptanceTripTransportation.excessBaggageFees, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmountPerPerson,
					settlingInBenefitData.preAcceptanceTripTransportation.maxAmountPerPerson);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					settlingInBenefitData.preAcceptanceTripTransportation.grossUp, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					settlingInBenefitData.preAcceptanceTripTransportation.reimbursedBy, true);
			if (settlingInBenefitData.preAcceptanceTripTransportation.reimbursedBy
					.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						settlingInBenefitData.preAcceptanceTripTransportation.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment,
					settlingInBenefitData.preAcceptanceTripTransportation.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName, e.getMessage()));
		}
	}

	/**
	 * Method to fill Pre-Acceptance Trip Lodging subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillPreAcceptanceTripLodgingSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputNumOfNightsPerTrip,
					settlingInBenefitData.preAcceptanceTripLodging.numberOfNightsPerTripLodging);
			CoreFunctions.clickElement(driver, _selectAmount);
			CoreFunctions.selectItemInListByText(driver, _selectAmountOptions,
					settlingInBenefitData.preAcceptanceTripLodging.amountLodging, true);
			CoreFunctions.clearAndSetText(driver, _inputFlatAmountPerNight,
					settlingInBenefitData.preAcceptanceTripLodging.flatAmountPerNightLodging);
			CoreFunctions.clickElement(driver, _selectCurrency);
			CoreFunctions.selectItemInListByText(driver, _selectCurrencyOptions,
					settlingInBenefitData.preAcceptanceTripLodging.currencyLodging, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					settlingInBenefitData.preAcceptanceTripLodging.grossUp, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					settlingInBenefitData.preAcceptanceTripLodging.reimbursedBy, true);
			if (settlingInBenefitData.preAcceptanceTripLodging.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						settlingInBenefitData.preAcceptanceTripLodging.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment,
					settlingInBenefitData.preAcceptanceTripLodging.comment);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Method to fill Pre-Acceptance Rental Car subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillPreAcceptanceRentalCarSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputDurationInDays,
					settlingInBenefitData.preAcceptanceRentalCar.durationDaysRentalCar);
			CoreFunctions.clickElement(driver, _selectRentalCarSize);
			CoreFunctions.selectItemInListByText(driver, _selectRentalCarSizeOptions,
					settlingInBenefitData.preAcceptanceRentalCar.rentalCarSize, true);
			if (settlingInBenefitData.preAcceptanceRentalCar.rentalCarSize.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputRentalCarOtherSize,
						settlingInBenefitData.preAcceptanceRentalCar.rentalCarSizeOther);
			}
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					settlingInBenefitData.preAcceptanceRentalCar.grossUp, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					settlingInBenefitData.preAcceptanceRentalCar.reimbursedBy, true);
			if (settlingInBenefitData.preAcceptanceRentalCar.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						settlingInBenefitData.preAcceptanceRentalCar.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment,
					settlingInBenefitData.preAcceptanceRentalCar.comment);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Method to fill Pre-Acceptance Trip Meals subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillPreAcceptanceTripMealsSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputNumOfDaysForMeals,
					settlingInBenefitData.preAcceptanceTripMeals.numberOfDaysForMeal);
			CoreFunctions.selectItemInListByText(driver, _radioBtnMealType,
					settlingInBenefitData.preAcceptanceTripMeals.type, true);
			CoreFunctions.clickElement(driver, _selectMaxAmtMeals);
			CoreFunctions.selectItemInListByText(driver, _selectMaxAmtMealsOptions,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmount, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmtTransferee,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtTransferee);
			CoreFunctions.clickElement(driver, _selectTransfereeCurrency);
			CoreFunctions.selectItemInListByText(driver, _selectTransfereeCurrencyOptions,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtTransfereeCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailTransfereeCode,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtTransfereeDetail, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmtAdult,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtAdult);
			CoreFunctions.clickElement(driver, _selectAdultCurrency);
			CoreFunctions.selectItemInListByText(driver, _selectAdultCurrencyOptions,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtAdultCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailAdult,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtAdultDetail, true);
			CoreFunctions.clearAndSetText(driver, _inputMaxAmtChild,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtChildren);
			CoreFunctions.clickElement(driver, _selectCurrencyCodeChild);
			CoreFunctions.selectItemInListByText(driver, _selectCurrencyCodeChildOptions,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtChildrenCurrency, true);
			CoreFunctions.selectItemInListByText(driver, _radioDetailChild,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtChildrenDetail, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					settlingInBenefitData.preAcceptanceTripMeals.grossUp, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					settlingInBenefitData.preAcceptanceTripMeals.reimbursedBy, true);
			if (settlingInBenefitData.preAcceptanceTripMeals.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						settlingInBenefitData.preAcceptanceTripMeals.reimbursedByOther);
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaComment,
					settlingInBenefitData.preAcceptanceTripMeals.comment);
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
		case COREFLEXConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			element = _formPreAcceptanceTripTransportation;
			break;
		case COREFLEXConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			element = _formPreAcceptanceTripLodging;
			break;
		case COREFLEXConstants.PRE_ACCEPTANCE_RENTAL_CAR:
			element = _formPreAcceptanceRentalCar;
			break;
		case COREFLEXConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			element = _formPreAcceptanceTripMeals;
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
	public void selectBenefitTypeAndFillMandatoryFields(String benefitType, String multipleBenefitSelection,
			String flexPoints, String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription,
			String aireManagedService) {
		Benefit preAcceptanceBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.PRE_ACCEPTANCE_SERVICES)).findAny()
				.orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, preAcceptanceBenefit.getBenefitDisplayName(),
					preAcceptanceBenefit.getBenefitAmount(), preAcceptanceBenefit.getBenefitDesc(), aireManagedService);
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
			fillManadatoryDetails(benefitType, multipleBenefitSelection, preAcceptanceBenefit.getBenefitDisplayName(),
					preAcceptanceBenefit.getBenefitAmount(), preAcceptanceBenefit.getBenefitDesc(), aireManagedService);
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
		Benefit preAcceptanceBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.PRE_ACCEPTANCE_SERVICES)).findAny()
				.orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, preAcceptanceBenefit.getBenefitDisplayName(),
					preAcceptanceBenefit.getBenefitAmount(), preAcceptanceBenefit.getBenefitDesc(), paymentOption,
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
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, preAcceptanceBenefit.getBenefitDisplayName(),
					preAcceptanceBenefit.getBenefitAmount(), preAcceptanceBenefit.getBenefitDesc(), paymentOption,
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
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.PRE_ACCEPTANCE_SERVICES_BENEFITS_PAGE));
					throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.PRE_ACCEPTANCE_SERVICES_BENEFITS_PAGE));
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
		case COREFLEXConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION));
			verifyPreAcceptanceTripTransportationSubBenefitForm(COREFLEXConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION);
			break;
		case COREFLEXConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.PRE_ACCEPTANCE_TRIP_LODGING));
			verifyPreAcceptanceTripLodgingSubBenefitForm(COREFLEXConstants.PRE_ACCEPTANCE_TRIP_LODGING);
			break;
		case COREFLEXConstants.PRE_ACCEPTANCE_RENTAL_CAR:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.PRE_ACCEPTANCE_RENTAL_CAR));
			verifyPreAcceptanceRentalCarSubBenefitForm(COREFLEXConstants.PRE_ACCEPTANCE_RENTAL_CAR);
			break;
		case COREFLEXConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.PRE_ACCEPTANCE_TRIP_MEALS));
			verifyPreAcceptanceTripMealsSubBenefitForm(COREFLEXConstants.PRE_ACCEPTANCE_TRIP_MEALS);
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to verify PreAcceptanceTripTransportation subBenefit form
	 */
	private void verifyPreAcceptanceTripTransportationSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(_inputNumOfTrips.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceTripTransportation.numberOfTrips,
					COREFLEXConstants.NUMBER_OF_TRIPS);
			CoreFunctions.highlightObject(driver, _inputNumOfTrips);
			CoreFunctions.verifyText(driver, _selectTransportationTypeSelectedValue,
					settlingInBenefitData.preAcceptanceTripTransportation.transportationType,
					COREFLEXConstants.TRANSPORTATION_TYPE);			
			if ((settlingInBenefitData.preAcceptanceTripTransportation.transportationType)
					.contains(COREFLEXConstants.DISTANCE)) {
				CoreFunctions.verifyText(_inputDistance.getDomProperty("value"),
						settlingInBenefitData.preAcceptanceTripTransportation.distance, COREFLEXConstants.DISTANCE);
				CoreFunctions.verifyRadioButtonSelection(driver, _radioBtnUnitOfDistance,
						_radioBtnUnitOfDistanceButtonList,
						settlingInBenefitData.preAcceptanceTripTransportation.unitOfDistance,
						COREFLEXConstants.UNIT_OF_DISTANCE);
			}			
			CoreFunctions.verifyText(_inputMinFlightTimeExlLayovers.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceTripTransportation.minFlightTimeExclLayovers,
					COREFLEXConstants.MIN_FLIGHT_TIME_EXCL_LAYOVERS);
			CoreFunctions.verifyText(driver, _selectAccompanyingFamilyMemberCodeSelectedValue,
					settlingInBenefitData.preAcceptanceTripTransportation.accompanyingFamilyMember,
					COREFLEXConstants.ACCOMPANYING_FAMILY_MEMBERS);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioBtnExcessBaggageFeesLabelList,
					_radioBtnExcessBaggageFeesButtonList,
					settlingInBenefitData.preAcceptanceTripTransportation.excessBaggageFees,
					COREFLEXConstants.EXCESS_BAGGAGE_FEES);
			CoreFunctions.verifyText(_inputMaxAmountPerPerson.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceTripTransportation.maxAmountPerPerson,
					COREFLEXConstants.MAX_AMOUNT);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					settlingInBenefitData.preAcceptanceTripTransportation.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					settlingInBenefitData.preAcceptanceTripTransportation.reimbursedBy,
					COREFLEXConstants.REIMBURSED_BY);
			if (settlingInBenefitData.preAcceptanceTripTransportation.reimbursedBy
					.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						settlingInBenefitData.preAcceptanceTripTransportation.reimbursedByOther,
						COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceTripTransportation.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(
					MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_PRE_ACCEPTANCE_SERVICES_SUB_BENEFITS_FORM,
							CoreConstants.FAIL, formName));
		}
	}

	/**
	 * Method to verify PreAcceptanceTripLodging subBenefit form
	 */
	private void verifyPreAcceptanceTripLodgingSubBenefitForm(String formName) {
		try {

			CoreFunctions.verifyText(_inputNumOfNightsPerTrip.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceTripLodging.numberOfNightsPerTripLodging,
					COREFLEXConstants.NUMBER_OF_NIGHTS);
			CoreFunctions.verifyText(driver, _selectMaxAmountLodgingSelectedValue,
					settlingInBenefitData.preAcceptanceTripLodging.amountLodging, COREFLEXConstants.MAX_AMOUNT);
			CoreFunctions.verifyText(_inputFlatAmountPerNight.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceTripLodging.flatAmountPerNightLodging,
					COREFLEXConstants.FLAT_AMOUNT_PER_NIGHT);
			CoreFunctions.verifyText(driver, _selectCurrencySelectedValue,
					settlingInBenefitData.preAcceptanceTripLodging.currencyLodging, COREFLEXConstants.CURRENCY);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					settlingInBenefitData.preAcceptanceTripLodging.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					settlingInBenefitData.preAcceptanceTripLodging.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (settlingInBenefitData.preAcceptanceTripLodging.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						settlingInBenefitData.preAcceptanceTripLodging.reimbursedByOther,
						COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceTripLodging.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(
					MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_PRE_ACCEPTANCE_SERVICES_SUB_BENEFITS_FORM,
							CoreConstants.FAIL, formName));
		}
	}

	/**
	 * Method to verify PreAcceptanceRentalCar subBenefit form
	 */
	private void verifyPreAcceptanceRentalCarSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(_inputDurationInDays.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceRentalCar.durationDaysRentalCar,
					COREFLEXConstants.DURATION_DAYS);
			CoreFunctions.highlightObject(driver, _inputDurationInDays);
			CoreFunctions.verifyText(driver, _selectRentalCarSizeSelectedValue,
					settlingInBenefitData.preAcceptanceRentalCar.rentalCarSize,
					COREFLEXConstants.RENTAL_CAR_SIZE_CLASS);
			if (settlingInBenefitData.preAcceptanceRentalCar.rentalCarSize.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputRentalCarOtherSize.getDomProperty("value"),
						settlingInBenefitData.preAcceptanceRentalCar.rentalCarSizeOther,
						COREFLEXConstants.RENTAL_CAR_OTHER_SIZE_CLASS);
				CoreFunctions.highlightObject(driver, _inputRentalCarOtherSize);
			}
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					settlingInBenefitData.preAcceptanceRentalCar.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					settlingInBenefitData.preAcceptanceRentalCar.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (settlingInBenefitData.preAcceptanceRentalCar.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						settlingInBenefitData.preAcceptanceRentalCar.reimbursedByOther,
						COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceRentalCar.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(
					MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_PRE_ACCEPTANCE_SERVICES_SUB_BENEFITS_FORM,
							CoreConstants.FAIL, formName));
		}
	}

	/**
	 * Method to verify PreAcceptanceTripMeals subBenefit form
	 */
	private void verifyPreAcceptanceTripMealsSubBenefitForm(String formName) {
		try {
			CoreFunctions.verifyText(_inputNumOfDaysForMeals.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceTripMeals.numberOfDaysForMeal,
					COREFLEXConstants.NUMBER_OF_DAYS_FOR_MEAL);
			CoreFunctions.highlightObject(driver, _inputNumOfDaysForMeals);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioMealsTypeLabelList, _radioMealsTypeButtonList,
					settlingInBenefitData.preAcceptanceTripMeals.type, COREFLEXConstants.MEAL_TYPE);
			CoreFunctions.verifyText(driver, _selectMaxAmtSelectedValue,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmount, COREFLEXConstants.MAX_AMOUNT);

			CoreFunctions.verifyText(_inputMaxAmtTransferee.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtTransferee,
					COREFLEXConstants.MAX_AMOUNT_TRANSFEREE);
			CoreFunctions.verifyText(driver, _selectTransfereeCurrencySelectedValue,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtTransfereeCurrency,
					COREFLEXConstants.CURRENCY_TRANSFEREE);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioDetailTransfereeCodeLabelList,
					_radioDetailTransfereeCodeButtonList,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtTransfereeDetail,
					COREFLEXConstants.TRANSFEREE_DETAIL);

			CoreFunctions.verifyText(_inputMaxAmtAdult.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtAdult, COREFLEXConstants.MAX_AMOUNT_ADULT);
			CoreFunctions.verifyText(driver, _selectAdultCurrencySelectedValue,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtAdultCurrency, COREFLEXConstants.CURRENCY_ADULT);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioDetailAdultCodeLabelList,
					_radioDetailAdultCodeButtonList, settlingInBenefitData.preAcceptanceTripMeals.maxAmtAdultDetail,
					COREFLEXConstants.ADULT_DETAIL);

			CoreFunctions.verifyText(_inputMaxAmtChild.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtChildren, COREFLEXConstants.MAX_AMOUNT_CHILDREN);
			CoreFunctions.verifyText(driver, _selectCurrencyCodeChildSelectedValue,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtChildrenCurrency,
					COREFLEXConstants.CURRENCY_CHILDREN);
			CoreFunctions.verifyRadioButtonSelection(driver, __radioDetailChildLabelList, _radioDetailChildButtonList,
					settlingInBenefitData.preAcceptanceTripMeals.maxAmtChildrenDetail,
					COREFLEXConstants.CHILDREN_DETAIL);

			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					settlingInBenefitData.preAcceptanceTripMeals.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					settlingInBenefitData.preAcceptanceTripMeals.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (settlingInBenefitData.preAcceptanceTripMeals.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						settlingInBenefitData.preAcceptanceTripMeals.reimbursedByOther,
						COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					settlingInBenefitData.preAcceptanceTripMeals.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(
					MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_PRE_ACCEPTANCE_SERVICES_SUB_BENEFITS_FORM,
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
