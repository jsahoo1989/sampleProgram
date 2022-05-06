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

public class CoreFlex_DuplicateHousing_BenefitsPage extends Base {

	public CoreFlex_DuplicateHousing_BenefitsPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Save & Continue Button
	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'SAVE & CONTINUE')]")
	private WebElement _buttonSaveAndContinue;

	// Save & Continue Button
	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'SAVE AS DRAFT')]")
	private WebElement _buttonSaveAsDraft;

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

	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitList;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Duplicate Housing')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formDuplicateHousing;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='durationCode']")
	private WebElement _selectDuration;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='durationCode']//div[@role='option']")
	private List<WebElement> _selectDurationOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='durationOther']")
	private WebElement _inputDurationOther;

	@FindBy(how = How.XPATH, using = " //div[@class='collapse show']//label[@class='form-check-label']")
	private List<WebElement> _radioBtnCandidateSelection;

	@FindBy(how = How.CSS, using = "input[formcontrolname='paidByOther']")
	private WebElement _inputReimbursedBy;

	@FindBy(how = How.CSS, using = "textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaComment;

	// Benefit can be selected more than once Checkbox
	@FindBy(how = How.XPATH, using = "//input[@id='multiAddInd']/parent::label")
	private WebElement _inputMultiAddBenefit;

	// Policy Benefits data Missing Error Dialog
	@FindBy(how = How.XPATH, using = "//div[@id='swal2-content'][contains(text(),'Policy Benefits data missing. Please fill all the benefits.')]")
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

	/*********************************************************************/

	CoreFlex_HousingBenefitsData housingBenefitData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getHousingBenefitDataList(COREFLEXConstants.DUPLICATE_HOUSING);

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
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.DUPLICATE_HOUSING,
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
			case COREFLEXConstants.SAVE_AS_DRAFT:
				CoreFunctions.clickElement(driver, _buttonSaveAsDraft);
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
	 * @param benefitDescription
	 * @param benefitAllowanceAmount
	 * @param benefitDescription2
	 */
	public void selectAndFillBenefitsAndSubBenefitDetails(String benefitType, String subBenefitNames,
			String multipleBenefitSelection, String flexPoints, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String paymentOption) {
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
		clickElementOfPage(COREFLEXConstants.SAVE_AND_CONTINUE);

		if (CoreFunctions.isElementExist(driver, _errorDialogPolicyBenefitsDataMissing, 3)) {
			CoreFunctions.clickElement(driver, _errorDialogPolicyBenefitsDataMissingOKButton);
			clickElementOfPage(PDTConstants.BACK);
		}
	}

	/**
	 * Method to select and fill mentioned SubBenefits and fill all the SubBenefits
	 * section fields
	 * 
	 * @param subBenefitNames
	 */
	private void selectSubBenefitsAndFillMandatoryFields(String subBenefitNames) {

		List<String> subBenefitNamesList = new ArrayList<String>();
		if (subBenefitNames.contains(";"))
			subBenefitNamesList = Arrays.asList(subBenefitNames.split(";"));
		else
			subBenefitNamesList.add(subBenefitNames);

		for (String subBenefit : subBenefitNamesList) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitList, subBenefit, true);
			if (CoreFunctions.isElementExist(driver, getElementByName(subBenefit), 5)) {
				fillSubBenefit(subBenefit);
			} else {
				Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
						CoreConstants.FAIL, subBenefit, COREFLEXConstants.DUPLICATE_HOUSING_BENEFITS_PAGE));
				throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
						CoreConstants.FAIL, subBenefit, COREFLEXConstants.DUPLICATE_HOUSING_BENEFITS_PAGE));
			}
		}

	}

	/**
	 * Method to Expand and call FillSubBenefit method
	 * 
	 * @param subBenefit
	 */
	private void fillSubBenefit(String subBenefit) {
		switch (subBenefit) {
		case COREFLEXConstants.DUPLICATE_HOUSING:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.DUPLICATE_HOUSING));
			fillDuplicateHousingSubBenefitForm();
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to Fill SubBenefit Form
	 */
	private void fillDuplicateHousingSubBenefitForm() {
		try {
			CoreFunctions.clickElement(driver, _selectDuration);
			CoreFunctions.selectItemInListByText(driver, _selectDurationOptions,
					housingBenefitData.duplicateHousing.duration, true, COREFLEXConstants.DURATION);
			if (housingBenefitData.duplicateHousing.duration.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetTextUsingKeys(driver, _inputDurationOther,
						housingBenefitData.duplicateHousing.durationOther, COREFLEXConstants.DURATION_OTHER);
			}
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					housingBenefitData.duplicateHousing.grossUp, true, COREFLEXConstants.GROSS_UP);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					housingBenefitData.duplicateHousing.reimbursedBy, true, COREFLEXConstants.REIMBURSED_BY);
			if (housingBenefitData.duplicateHousing.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetTextUsingKeys(driver, _inputReimbursedBy,
						housingBenefitData.duplicateHousing.reimbursedByOther, COREFLEXConstants.REIMBURSED_BY_OTHER);
			}
			CoreFunctions.clearAndSetTextUsingKeys(driver, _txtAreaComment, housingBenefitData.duplicateHousing.comment,
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
		case COREFLEXConstants.DUPLICATE_HOUSING:
			element = _formDuplicateHousing;
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
	 * @param benefitDescription2
	 */
	private void selectBenefitTypeAndFillMandatoryFields(String benefitType, String multipleBenefitSelection,
			String flexPoints, String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription,
			String paymentOption) {
		Benefit duplicateHosuingBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.DUPLICATE_HOUSING)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			fillManadatoryDetails(benefitType, multipleBenefitSelection,
					duplicateHosuingBenefit.getBenefitDisplayName(), duplicateHosuingBenefit.getBenefitAmount(),
					duplicateHosuingBenefit.getBenefitDesc(), paymentOption);
			break;
		case COREFLEXConstants.FLEX:
			CoreFunctions.clickElement(driver, _textFlex);
			verifyNumericRangeFieldsValidation();
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputFlexPoints, flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, paymentOption);
			break;
		case COREFLEXConstants.CORE_BENEFITS:
			CoreFunctions.clickElement(driver, _textCoreBenefits);
			fillManadatoryDetails(benefitType, multipleBenefitSelection,
					duplicateHosuingBenefit.getBenefitDisplayName(), duplicateHosuingBenefit.getBenefitAmount(),
					duplicateHosuingBenefit.getBenefitDesc(), paymentOption);
			break;
		case COREFLEXConstants.FLEX_BENEFITS:
			CoreFunctions.clickElement(driver, _textFlexBenefits);
			verifyNumericRangeFieldsValidation();
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
	 * @param benefitDescription2
	 */
	private void fillManadatoryDetails(String benefitType, String multipleBenefitSelection, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String paymentOption) {

		if (((benefitType.equals(COREFLEXConstants.FLEX_BENEFITS)) || (benefitType.equals(COREFLEXConstants.FLEX)))
				& (multipleBenefitSelection.equals(COREFLEXConstants.YES))) {
			CoreFunctions.clickElement(driver, _inputMultiAddBenefit);
			CoreFunctions.selectItemInListByText(driver, _radioBenefitMandatoryButtons, paymentOption, true,
					COREFLEXConstants.PAYMENT_OPTION);
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
						.equals(COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE);
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
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_POINTS_FIELD_VALIDATION_ON_DUPLICATE_HOUSING_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

}
