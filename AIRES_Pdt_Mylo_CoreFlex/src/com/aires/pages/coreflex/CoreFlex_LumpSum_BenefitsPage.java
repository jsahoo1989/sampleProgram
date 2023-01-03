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

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_AllowancesBenefitsData;
import com.hp.lft.sdk.java.Table;
import com.hp.lft.sdk.java.Window;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_LumpSum_BenefitsPage extends BenefitPage {

	public CoreFlex_LumpSum_BenefitsPage(WebDriver driver) {
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

	// Flex Policy Setup Header
	@FindBy(how = How.CSS, using = "div[class*='pcard-header'] > h4[class='card-title']")
	private WebElement _headerPage;

	// Left Navigation Completed Sections
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[contains(@class,'nav-item')]//p")
	private List<WebElement> _leftNavigationTitleList;

	// Left Navigation Selected Benefits List
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//a[contains(@class,'menu-pad')]//p")
	private List<WebElement> _leftNavigationTitleSelectedBenefitsList;

	// Core Benefit Type Selection
	@FindBy(how = How.ID, using = "core")
	private WebElement _textCore;

	// Flex Benefit Type Selection
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

	// SubBenefit Collapsable Secation
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Lump Sum')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formLumpSum;

	// Calculation Method Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='oneTimeCalMethodCode']")
	private WebElement _selectCalculationMethod;

	// Calculation Method Select Field Options
	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
	private List<WebElement> _selectCalculationMethodOptions;

	// Calculation Method Select Field Selected Value
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='oneTimeCalMethodCode'] span[class*='ng-value-label']")
	private WebElement _selectCalculationMethodSelectedValue;

	// Radio Button List
	@FindBy(how = How.XPATH, using = " //div[@class='collapse show']//label[@class='form-check-label']")
	private List<WebElement> _radioBtnCandidateSelection;

	// Reimbursed By Text Field
	@FindBy(how = How.CSS, using = "input[formcontrolname='paidByOther']")
	private WebElement _inputReimbursedBy;

	// Benefit Comment Text Area
	@FindBy(how = How.CSS, using = "textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaComment;

	// Max Amount Input Field
	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmount']")
	private WebElement _inputMaxAmount;

	// Currency Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _selectCurrency;

	// Currency Select Field Options
	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
	private List<WebElement> _selectCurrencyOptions;

	// Currency Select Field Selected Value
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span[class*='ng-value-label']")
	private WebElement _selectCurrencySelectedValue;

	// Frequency Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='frequencyCode']")
	private WebElement _selectFrequency;

	// Frequency Select Field Options
	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
	private List<WebElement> _selectFrequencyOptions;

	// Frequency Select Field Selected Value
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='frequencyCode'] span[class*='ng-value-label']")
	private WebElement _selectFrequencySelectedValue;

	// WhenToMakePayment Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='pmtTimeCode']")
	private WebElement _selectWhenToMakePayment;

	// WhenToMakePayment Select Field Options
	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
	private List<WebElement> _selectWhenToMakePaymentOptions;

	// WhenToMakePayment Select Field Selected Value
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='pmtTimeCode'] span[class*='ng-value-label']")
	private WebElement _selectWhenToMakePaymentSelectedValue;

	// IndicateNumberOfWeeks Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='pmtTimeWeeksBeforeCode']")
	private WebElement _selectIndicateNumberOfWeeks;

	// IndicateNumberOfWeeks Select Field Options
	@FindBy(how = How.CSS, using = "ng-dropdown-panel span[class*='ng-option-label']")
	private List<WebElement> _selectIndicateNumberOfWeeksOptions;

	// IndicateNumberOfWeeks Select Field SelectedValue
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='pmtTimeWeeksBeforeCode'] span[class*='ng-value-label']")
	private WebElement _selectIndicateNumberOfWeeksSelectedValue;

	// Benefit can be selected more than once Checkbox
	@FindBy(how = How.XPATH, using = "//input[@id='multiAddInd']/parent::label")
	private WebElement _inputMultiAddBenefit;

	// Policy Benefits data Missing Error Dialog
	@FindBy(how = How.XPATH, using = "//div[@id='swal2-content'][contains(text(),'Policy Benefits data missing. Please complete all the benefits.')]")
	private WebElement _errorDialogPolicyBenefitsDataMissing;

	// Policy Benefits data Missing Error Dialog - OK Button
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _errorDialogPolicyBenefitsDataMissingOKButton;

	// Error PopUp Ok Button
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _buttonOKErrorDialog;

	// Flex Points Validation Message
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='flexPoints']/following-sibling::div[contains(@class,'input-error')]/div")
	private WebElement _validationMessageFlexPoints;

	// Payments Radio Selection
	@FindBy(how = How.XPATH, using = "//div[@class='container']//label[@class='form-check-label']")
	private List<WebElement> _radioBenefitMandatoryButtons;

	// Aires Managed Services field required Text
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Aires Managed Service')]/following-sibling::div/div[contains(@class,'input-error')]")
	private WebElement _errorTextAiresManagedServicesRequiredField;

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

	// Flex Policy Setup Page Header
	@FindBy(how = How.XPATH, using = "//h4[@class='card-title'][contains(text(),'Lump Sum')]")
	private WebElement _headerPageName;

	// If Applicable Text
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'if applicable')]")
	private List<WebElement> _textIfApplicable;

	/*********************************************************************/

	CoreFlex_AllowancesBenefitsData allowancesBenefitData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getAllowanceBenefitDataList(COREFLEXConstants.LUMP_SUM);

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
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.LUMP_SUM, expectedPageName,
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
			case PDTConstants.OK:
				CoreFunctions.clickElement(driver, _buttonOKErrorDialog);
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
			CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList, elementName);
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
	 * @param benefitDescription
	 * @param benefitAllowanceAmount
	 * @param benefitName
	 */
	public void selectAndFillBenefitsAndSubBenefitDetails(String benefitType, String subBenefitNames,
			String multipleBenefitSelection, String flexPoints, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String paymentOption) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _headerPageName,
				COREFLEXConstants.LUMP_SUM_BENEFITS_PAGE);
		if (benefitType.equals(COREFLEXConstants.BOTH)) {
			selectBenefitTypeAndFillMandatoryFields(benefitType, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, paymentOption);
			selectBenefitTypeAndFillMandatoryFields(COREFLEXConstants.CORE_BENEFITS, multipleBenefitSelection,
					flexPoints, benefitDisplayName, benefitAllowanceAmount, benefitDescription, paymentOption);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames);
			selectBenefitTypeAndFillMandatoryFields(COREFLEXConstants.FLEX_BENEFITS, multipleBenefitSelection,
					flexPoints, benefitDisplayName, benefitAllowanceAmount, benefitDescription, paymentOption);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames);
		} else {
			selectBenefitTypeAndFillMandatoryFields(benefitType, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, paymentOption);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames);
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
	 */
	public void selectSubBenefitsAndFillMandatoryFields(String subBenefitNames) {

		List<String> subBenefitNamesList = new ArrayList<String>();
		if (subBenefitNames.contains(";"))
			subBenefitNamesList = Arrays.asList(subBenefitNames.split(";"));
		else
			subBenefitNamesList.add(subBenefitNames);

		for (String subBenefit : subBenefitNamesList) {
			if (subBenefitNamesList.size() > 1) {
				CoreFunctions.selectItemInListByText(driver, _subBenefitList, subBenefit, true);
			}
			if (CoreFunctions.isElementExist(driver, getElementByName(subBenefit), 5)) {
				fillSubBenefit(subBenefit);
			} else {
				Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
						CoreConstants.FAIL, subBenefit, COREFLEXConstants.LUMP_SUM_BENEFITS_PAGE));
				throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
						CoreConstants.FAIL, subBenefit, COREFLEXConstants.LUMP_SUM_BENEFITS_PAGE));
			}
		}

	}

	/**
	 * Method to Expand and call FillSubBenefit method
	 * 
	 * @param subBenefit
	 */
	public void fillSubBenefit(String subBenefit) {
		switch (subBenefit) {
		case COREFLEXConstants.LUMP_SUM:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.LUMP_SUM));
			fillLumpSumSubBenefitForm();
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to Fill SubBenefit Form
	 */
	private void fillLumpSumSubBenefitForm() {
		try {
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _selectCalculationMethod,
					COREFLEXConstants.CALCULATION_METHOD);
			CoreFunctions.clickElement(driver, _selectCalculationMethod);
			CoreFunctions.selectItemInListByText(driver, _selectCalculationMethodOptions,
					allowancesBenefitData.lumpSum.calculationMethod, true, COREFLEXConstants.CALCULATION_METHOD);
			if (allowancesBenefitData.lumpSum.calculationMethod.equalsIgnoreCase(COREFLEXConstants.FLAT_AMOUNT)) {
				CoreFunctions.clearAndSetTextUsingKeys(driver, _inputMaxAmount,
						allowancesBenefitData.lumpSum.maxAmountIfApplicable, COREFLEXConstants.MAX_AMOUNT);
				CoreFunctions.clickElement(driver, _selectCurrency);
				CoreFunctions.selectItemInListByText(driver, _selectCurrencyOptions,
						allowancesBenefitData.lumpSum.currency, true, COREFLEXConstants.CURRENCY);
				CoreFunctions.clickElement(driver, _selectFrequency);
				CoreFunctions.selectItemInListByText(driver, _selectFrequencyOptions,
						allowancesBenefitData.lumpSum.frequency, true, COREFLEXConstants.FREQUENCY);
			}
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					allowancesBenefitData.lumpSum.grossUp, true, COREFLEXConstants.GROSS_UP);
			CoreFunctions.clickElement(driver, _selectWhenToMakePayment);
			CoreFunctions.selectItemInListByText(driver, _selectWhenToMakePaymentOptions,
					allowancesBenefitData.lumpSum.whenToMakePayment, true, COREFLEXConstants.WHEN_TO_MAKE_PAYMENT_TEXT);
			if (allowancesBenefitData.lumpSum.whenToMakePayment
					.equalsIgnoreCase(COREFLEXConstants.WHEN_TO_MAKE_PAYMENT)) {
				CoreFunctions.clickElement(driver, _selectIndicateNumberOfWeeks);
				CoreFunctions.selectItemInListByText(driver, _selectIndicateNumberOfWeeksOptions,
						allowancesBenefitData.lumpSum.indicateNumberOfWeeksBeforeTransferDate, true,
						COREFLEXConstants.INDICATE_NUMBER_OF_WEEKS);
			}
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					allowancesBenefitData.lumpSum.reimbursedBy, true, COREFLEXConstants.REIMBURSED_BY);
			if (allowancesBenefitData.lumpSum.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetTextUsingKeys(driver, _inputReimbursedBy,
						allowancesBenefitData.lumpSum.reimbursedByOther, COREFLEXConstants.REIMBURSED_BY_OTHER);
			}
			CoreFunctions.clearAndSetTextUsingKeys(driver, _txtAreaComment, allowancesBenefitData.lumpSum.comment,
					COREFLEXConstants.COMMENT);
		} catch (Exception e) {
			Assert.fail(COREFLEXConstants.FAILED_TO_FILL_DUPLICATE_HOUSING_SUB_BENEFITS_FORM);
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
		case COREFLEXConstants.LUMP_SUM:
			element = _formLumpSum;
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
	 * @param benefitDescription
	 * @param benefitAllowanceAmount
	 * @param benefitName
	 */
	public void selectBenefitTypeAndFillMandatoryFields(String benefitType, String multipleBenefitSelection,
			String flexPoints, String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription,
			String paymentOption) {
		Benefit lumpSumBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.LUMP_SUM)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, lumpSumBenefit.getBenefitDisplayName(),
					lumpSumBenefit.getBenefitAmount(), lumpSumBenefit.getBenefitDesc(), paymentOption);
			break;
		case COREFLEXConstants.FLEX:
			CoreFunctions.clickElement(driver, _textFlex);
//			verifyNumericRangeFieldsValidation();
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputFlexPoints, flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, paymentOption);
			break;
		case COREFLEXConstants.CORE_BENEFITS:
			CoreFunctions.clickElement(driver, _textCoreBenefits);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, lumpSumBenefit.getBenefitDisplayName(),
					lumpSumBenefit.getBenefitAmount(), lumpSumBenefit.getBenefitDesc(), paymentOption);
			break;
		case COREFLEXConstants.FLEX_BENEFITS:
			CoreFunctions.clickElement(driver, _textFlexBenefits);
//			verifyNumericRangeFieldsValidation();
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputFlexPoints, flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, paymentOption);
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
	 * @param multipleBenefitSelection
	 * @param benefitType
	 * @param benefitDescription
	 * @param benefitAllowanceAmount
	 * @param benefitName
	 */
	public void fillManadatoryDetails(String benefitType, String multipleBenefitSelection, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String paymentOption) {

		if (((benefitType.equals(COREFLEXConstants.FLEX_BENEFITS)) || (benefitType.equals(COREFLEXConstants.FLEX)))
				& (multipleBenefitSelection.equals(COREFLEXConstants.YES))) {			
			CoreFunctions.selectItemInListByText(driver, _radioBenefitMandatoryButtons, paymentOption, true,
					COREFLEXConstants.PAYMENT_OPTION);
			CoreFunctions.clickElement(driver, _inputMultiAddBenefit);
		}
		CoreFunctions.clearAndSetTextUsingKeys(driver, _inputBenefitName, benefitDisplayName,
				COREFLEXConstants.BENEFIT_DISPLAY_NAME);
		CoreFunctions.clearAndSetTextUsingKeys(driver, _textAreaAllowanceAmountMessage, benefitAllowanceAmount,
				COREFLEXConstants.ALLOWANCE_AMOUNT_MESSAGE);
		CoreFunctions.clearAndSetTextUsingKeys(driver, _textAreaBenefitLongDescription, benefitDescription,
				COREFLEXConstants.BENEFIT_LONG_DESCRIPTION);
	}

	public void checkFieldValidation(String fieldName, String inputValue) {
		boolean isValidationMessageDisplayed = false;
		switch (fieldName) {
		case COREFLEXConstants.FLEX_POINT_VALUE:
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputFlexPoints, inputValue,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			clickElementOfPage(COREFLEXConstants.SAVE_AND_CONTINUE);
			clickElementOfPage(PDTConstants.OK);
			if (CoreFunctions.isElementExist(driver, _validationMessageFlexPoints, 5))
				isValidationMessageDisplayed = CoreFunctions.getElementText(driver, _validationMessageFlexPoints)
						.equals(COREFLEXConstants.POINT_FIVE_TO_ONE_THOUSAND_RANGE);
			BusinessFunctions.checkValidationBasedOnInput(isValidationMessageDisplayed, fieldName, inputValue);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
	}

	public void verifyNumericRangeFieldsValidation() {
		try {
			checkFieldValidation(COREFLEXConstants.FLEX_POINT_VALUE, "0.24");
			checkFieldValidation(COREFLEXConstants.FLEX_POINT_VALUE, "0.50");
			checkFieldValidation(COREFLEXConstants.FLEX_POINT_VALUE, "100.25");
			checkFieldValidation(COREFLEXConstants.FLEX_POINT_VALUE, "999.5");
			checkFieldValidation(COREFLEXConstants.FLEX_POINT_VALUE, "1001");
			checkRequiredFieldValidation(COREFLEXConstants.AIRES_MANAGED_SERVICE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_POINTS_FIELD_VALIDATION_ON_LUMP_SUM_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	private void checkRequiredFieldValidation(String fieldName) {
		try {
			switch (fieldName) {
			case COREFLEXConstants.AIRES_MANAGED_SERVICE:
				if (CoreFunctions.isElementExist(driver, _errorTextAiresManagedServicesRequiredField, 5)) {
					Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.REQUIRED_FIELD_MESSAGE_DISPLAYED,
							CoreConstants.FAIL, fieldName));
					throw new RuntimeException(MessageFormat.format(COREFLEXConstants.REQUIRED_FIELD_MESSAGE_DISPLAYED,
							CoreConstants.FAIL, fieldName));
				} else {
					Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.REQUIRED_FIELD_MESSAGE_NOT_DISPLAYED,
							CoreConstants.PASS, fieldName));
				}
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_REQUIRED_FIELD_VALIDATION_ON_LUMP_SUM_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
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
			verifySubBenefitDetails(subBenefitNames);
			verifyBenefitsMandatoryDetails(COREFLEXConstants.FLEX_BENEFITS, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, paymentOption, airesManagedService);
			verifySubBenefitDetails(subBenefitNames);
			return true;
		} else {
			verifyBenefitsMandatoryDetails(benefitType, multipleBenefitSelection, flexPoints, benefitDisplayName,
					benefitAllowanceAmount, benefitDescription, paymentOption, airesManagedService);
			verifySubBenefitDetails(subBenefitNames);
			return true;
		}
	}

	private void verifyBenefitsMandatoryDetails(String benefitType, String multipleBenefitSelection, String flexPoints,
			String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription, String paymentOption,
			String airesManagedService) {
		Benefit lumpSumBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.LUMP_SUM)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, lumpSumBenefit.getBenefitDisplayName(),
					lumpSumBenefit.getBenefitAmount(), lumpSumBenefit.getBenefitDesc(), paymentOption,
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
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, lumpSumBenefit.getBenefitDisplayName(),
					lumpSumBenefit.getBenefitAmount(), lumpSumBenefit.getBenefitDesc(), paymentOption,
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
	 * Method to Expand and call verifyLumpSumSubBenefitForm method
	 * 
	 * @param subBenefit
	 */
	private void verifySubBenefitDetails(String subBenefit) {
		switch (subBenefit) {
		case COREFLEXConstants.LUMP_SUM:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.LUMP_SUM));
			verifyLumpSumSubBenefitForm();
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to Verify SubBenefit Form
	 */
	private void verifyLumpSumSubBenefitForm() {
		try {
			CoreFunctions.verifyText(driver, _selectCalculationMethodSelectedValue,
					allowancesBenefitData.lumpSum.calculationMethod, COREFLEXConstants.CALCULATION_METHOD);
			if (allowancesBenefitData.lumpSum.calculationMethod.equalsIgnoreCase(COREFLEXConstants.FLAT_AMOUNT)) {
				CoreFunctions.verifyText(_inputMaxAmount.getDomProperty("value"),
						allowancesBenefitData.lumpSum.maxAmountIfApplicable, COREFLEXConstants.MAX_AMOUNT);
				CoreFunctions.highlightObject(driver, _inputMaxAmount);
				CoreFunctions.verifyText(driver, _selectCurrencySelectedValue, allowancesBenefitData.lumpSum.currency,
						COREFLEXConstants.CURRENCY);
				CoreFunctions.verifyText(driver, _selectFrequencySelectedValue, allowancesBenefitData.lumpSum.frequency,
						COREFLEXConstants.FREQUENCY);
			}
			CoreFunctions.verifyText(driver, _selectWhenToMakePaymentSelectedValue,
					allowancesBenefitData.lumpSum.whenToMakePayment, COREFLEXConstants.WHEN_TO_MAKE_PAYMENT_TEXT);
			if (allowancesBenefitData.lumpSum.whenToMakePayment
					.equalsIgnoreCase(COREFLEXConstants.WHEN_TO_MAKE_PAYMENT)) {
				CoreFunctions.verifyText(driver, _selectIndicateNumberOfWeeksSelectedValue,
						allowancesBenefitData.lumpSum.indicateNumberOfWeeksBeforeTransferDate,
						COREFLEXConstants.INDICATE_NUMBER_OF_WEEKS);
			}
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					allowancesBenefitData.lumpSum.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					allowancesBenefitData.lumpSum.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (allowancesBenefitData.lumpSum.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						allowancesBenefitData.lumpSum.reimbursedByOther, COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"), allowancesBenefitData.lumpSum.comment,
					COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);

		} catch (Exception e) {
			Assert.fail(COREFLEXConstants.FAILED_TO_VERIFY_LUMP_SUM_SUB_BENEFITS_FORM);
		}

	}

	public boolean changePolicyBenefitType(String benefitType, String changedPolicyType) {
		try {
			CoreFunctions.clickElement(driver, _textFlex);
			clickElementOfPage(COREFLEXConstants.SAVE_AND_CONTINUE);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CHANGING_POLICY_BENEFIT_TYPE_OF_ADDED_BENEFIT,
					CoreConstants.FAIL, changedPolicyType, benefitType, e.getMessage()));
		}
		return false;
	}

	@Override
	public boolean verifyFlexBenefitCardStatusAfterInitialActualization(int index, String expectedEstimatedDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean verifyFlexBenefitCardStatusAfterEndActualization(int index, String expectedEstimatedDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyCoreBenefitCardStatusAfterInitialActualization(int index, String expectedEstimatedDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean verifyCoreBenefitCardStatusAfterEndActualization(int index, Benefit benefit) {
		// TODO Auto-generated method stub
		return false;
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
