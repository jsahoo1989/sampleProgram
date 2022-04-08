package com.aires.pages.coreflex;

import java.text.MessageFormat;
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
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class CoreFlex_FlexPolicySetupPage extends Base {

	public CoreFlex_FlexPolicySetupPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Next Button
	@FindBy(how = How.CSS, using = "button[class*='btn-next']")
	private WebElement _buttonNext;

	// Back Button
	@FindBy(how = How.CSS, using = "button[class*='btn-back']")
	private WebElement _buttonBack;

	// Exit Button
	@FindBy(how = How.CSS, using = "button[class='btn-exit']")
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

	// Flex Policy Left Navigation Active Tile
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//a[contains(@class,'nav-link disabled')]//p")
	private WebElement _leftNavigationTitleActive;

	// Left Navigation Completed Sections
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[contains(@class,'nav-item')]//p")
	private List<WebElement> _leftNavigationTitleList;

	// Flex Setup type Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='flexSetupTypeCode']")
	private WebElement _selectFlexSetupType;

	// Flex Setup type Select Options
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='flexSetupTypeCode']/descendant::div[@role='option']/span")
	private List<WebElement> _selectFlexSetupTypeOptions;

	// Lock The Benefits Points Selection Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='benefitLockCode']")
	private WebElement _selectLockBenefitsPointsSelection;

	// ock The Benefits Points Selection Select Options
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='benefitLockCode']/descendant::div[@role='option']/span")
	private List<WebElement> _selectLockBenefitsPointsSelectionOptions;

	// Total Points Available Input Field
	@FindBy(how = How.CSS, using = "input[formcontrolname='staticPoints']")
	private WebElement _inputTotalPointsAvailable;

	// No Max/Unlimited Checkbox Field
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'No Max/Unlimited')]")
	private WebElement _checkboxNoMaxUnlimited;

	// After Relocation Only Section
	@FindBy(how = How.CSS, using = "label[class='cashout'] > p")
	private List<WebElement> _sectionCashoutAvailability;

	// Flex Allowance Type
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='allowanceTypeCode']/parent::label")
	private List<WebElement> _radioFlexAllowanceType;

	// Person Responsible For Benefit Selection
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='benefitSelection']/parent::label")
	private List<WebElement> _radioPersonResponsibleForBenefitSelection;

	// Custom Name for Cashout Benefit Text Field
	@FindBy(how = How.ID, using = "customCashoutName")
	private WebElement _inputCustomCashoutName;

	// Max Portion Cashout (%) Input Field
	@FindBy(how = How.ID, using = "inputMargin")
	private WebElement _inputMarginPortion;

	// Point Exchange Rate Input Field
	@FindBy(how = How.CSS, using = "input[formcontrolname='pointExchangeRate']")
	private WebElement _inputPointExchangeRate;

	// Benefits Expiration Tracing Prompt Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='benefitExpTracingPrompt']")
	private WebElement _selectBenefitExpirationTracingPrompt;

	// Benefits Expiration Tracing Prompt Select Field Options
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='benefitExpTracingPrompt']//div[@role='option']/span")
	private List<WebElement> _selectBenefitExpirationTracingPromptOptions;

	// Benefits Expiration Date Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='benefitExpDateCode']")
	private WebElement _selectBenefitExpirationDate;

	// Benefits Expiration Date Select Field Options
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='benefitExpDateCode']//div[@role='option']/span")
	private List<WebElement> _selectBenefitExpirationDateOptions;

	// Total Points Available Validation Message
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='staticPoints']/parent::div/div[@class='input-error']/div")
	private WebElement _validationMessageTotalPointsAvailable;

	// Points Exchange Rate Validation Message
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='pointExchangeRate']/ancestor::div/div[@class='input-error']/div/div")
	private WebElement _validationMessagePointsExchangeRate;

	// Max Portion CashOut Validation Message
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='maxPortionPercentage']/parent::span/parent::div//div[contains(@class,'input-error')]/div")
	private WebElement _validationMessageMaxPortionCashout;

	// Error PopUp Ok Button
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _buttonOKErrorDialog;

	// Error PopUp Text
	@FindBy(how = How.XPATH, using = "//div[@id='swal2-content'][contains(text(),'Please complete the required field(s)')]")
	private WebElement _textErrorDialog;

	/*********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	/*********************************************************************/

	/**
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.FLEX_POLICY_SETUP,
				expectedPageName, expectedPageName, true);
	}

	/**
	 * Method to get currently active Left Navigation Menu.
	 * 
	 * @return
	 */
	public String getLeftNavigationPageTitle() {
		try {
			return CoreFunctions.getElementText(driver, _leftNavigationTitleActive);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_FETCHING_LEFT_NAVIGATION_TITLE,
							CoreConstants.FAIL, e.getMessage()));
		}
		return null;
	}
	
	/**
	 * Method to get Navigated Page Header.
	 * 
	 * @return
	 */
	public String getPageHeaderTitle() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _headerPage, COREFLEXConstants.FLEX_POLICY_SETUP);
			return CoreFunctions.getElementText(driver, _headerPage);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_FETCHING_PAGE_HEADER_TITLE,
							CoreConstants.FAIL, e.getMessage()));
		}
		return null;
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
			case PDTConstants.NEXT:
				CoreFunctions.clickElement(driver, _buttonNext);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case PDTConstants.BACK:
				CoreFunctions.clickElement(driver, _buttonBack);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case PDTConstants.EXIT:
				CoreFunctions.clickElement(driver, _buttonExit);
				break;
			case PDTConstants.OK:
				CoreFunctions.clickElement(driver, _buttonOKErrorDialog);
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
	 * Method to select FlexPolicySetup page fields based on values provided
	 * 
	 * @param dataTable
	 */
	public void selectFlexPolicySetupPageFields(DataTable dataTable) {

		List<List<String>> dataList = dataTable.asLists(String.class);
		String fieldName, fieldSelection;
		BusinessFunctions.selectRadioAsPerLabelText(driver, _radioFlexAllowanceType,
				policySetupPageData.flexPolicySetupPage.flexAllowanceType);
		CoreFunctions.clickElement(driver, _selectLockBenefitsPointsSelection);
		CoreFunctions.selectItemInListByText(driver, _selectLockBenefitsPointsSelectionOptions,
				policySetupPageData.flexPolicySetupPage.lockTheBenefitsPointsSelection, true);
		CoreFunctions.clickElement(driver, _selectBenefitExpirationTracingPrompt);
		CoreFunctions.selectItemInListByText(driver, _selectBenefitExpirationTracingPromptOptions,
				policySetupPageData.flexPolicySetupPage.benefitsExpirationTracingPrompt, true);
		CoreFunctions.clickElement(driver, _selectBenefitExpirationDate);
		CoreFunctions.selectItemInListByText(driver, _selectBenefitExpirationDateOptions,
				policySetupPageData.flexPolicySetupPage.benefitsExpirationDate, true);

		for (int i = 0; i < dataList.get(0).size(); i++) {
			fieldName = dataList.get(0).get(i);
			fieldSelection = dataList.get(1).get(i);
			performPageFieldSelection(fieldName, fieldSelection);
		}

//		checkFieldValidation(COREFLEXConstants.TOTAL_POINTS_AVAILABLE, "ABCD");
//		checkFieldValidation(COREFLEXConstants.TOTAL_POINTS_AVAILABLE, "#$%");
//		checkFieldValidation(COREFLEXConstants.TOTAL_POINTS_AVAILABLE, "50 Points");

		CoreFunctions.clearAndSetTextUsingKeys(driver, _inputTotalPointsAvailable,
				policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable,
				COREFLEXConstants.TOTAL_POINTS_AVAILABLE);
	}

	/**
	 * Method to select or input values for Flex Policy Setup Fields based on
	 * provided parameters
	 * 
	 * @param fieldName
	 * @param fieldSelectionInput
	 */
	public void performPageFieldSelection(String fieldName, String fieldSelectionInput) {
		try {
			switch (fieldName) {
			case COREFLEXConstants.FLEX_ALLOWANCE_TYPE:
				BusinessFunctions.selectRadioAsPerLabelText(driver, _radioFlexAllowanceType,
						fieldSelectionInput.trim());
				break;
			case COREFLEXConstants.PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION:
				BusinessFunctions.selectRadioAsPerLabelText(driver, _radioPersonResponsibleForBenefitSelection,
						fieldSelectionInput.trim());
				break;
			case COREFLEXConstants.LOCK_THE_BENEFITS_POINTS_SELECTION:
				CoreFunctions.clickElement(driver, _selectLockBenefitsPointsSelection);
				CoreFunctions.selectItemInListByText(driver, _selectLockBenefitsPointsSelectionOptions,
						fieldSelectionInput, true, fieldName);
				break;
			case COREFLEXConstants.BENEFIT_EXPIRATION_TRACING_PROMPT:
				CoreFunctions.clickElement(driver, _selectBenefitExpirationTracingPrompt);
				CoreFunctions.selectItemInListByText(driver, _selectBenefitExpirationTracingPromptOptions,
						fieldSelectionInput, true, fieldName);
				break;
			case COREFLEXConstants.BENEFIT_EXPIRATION_DATE:
				CoreFunctions.clickElement(driver, _selectBenefitExpirationDate);
				CoreFunctions.selectItemInListByText(driver, _selectBenefitExpirationDateOptions, fieldSelectionInput,
						true, fieldName);
				break;
			case COREFLEXConstants.FLEX_SETUP_TYPE:
				CoreFunctions.clickElement(driver, _selectFlexSetupType);
				CoreFunctions.selectItemInListByText(driver, _selectFlexSetupTypeOptions, fieldSelectionInput, true,
						fieldName);
				break;
			case COREFLEXConstants.TOTAL_POINTS_AVAILABLE:
				CoreFunctions.setElementText(driver, _inputTotalPointsAvailable, fieldSelectionInput);
				break;
			case COREFLEXConstants.CASHOUT_AVAILABILITY:
				CoreFunctions.selectItemInListByText(driver, _sectionCashoutAvailability, fieldSelectionInput, true,
						fieldName);
				fillCashoutAvailabilityDetails(fieldSelectionInput);
				CoreFunctions.writeToPropertiesFile("PolicyCashoutType", fieldSelectionInput);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_ENTERING_FIELD_VALUE,
							CoreConstants.FAIL, fieldName, fieldSelectionInput, e.getMessage()));
			throw new RuntimeException(e.getMessage());
		}
	}

	private void fillCashoutAvailabilityDetails(String cashOutAvaiblityType) {

		try {
			switch (cashOutAvaiblityType) {
			case COREFLEXConstants.PORTION_CASHOUT:
			case COREFLEXConstants.AFTER_RELOCATION_ONLY:
				CoreFunctions.clearAndSetTextUsingKeys(driver, _inputCustomCashoutName,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
						COREFLEXConstants.CUSTOM_CASHOUT_NAME);
				CoreFunctions.clearAndSetTextUsingKeys(driver, _inputMarginPortion,
						policySetupPageData.flexPolicySetupPage.maxPortionCashoutPercent,
						COREFLEXConstants.MAX_PORTION_CASHOUT);
				CoreFunctions.clearAndSetTextUsingKeys(driver, _inputPointExchangeRate,
						policySetupPageData.flexPolicySetupPage.pointExchangeRate,
						COREFLEXConstants.POINT_EXCHANGE_RATE);
				break;
			case COREFLEXConstants.CASHOUT_NOT_AUTHORIZED:
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_FILLING_CASHOUT_AVAILIBLITY_DETAILS,
							CoreConstants.FAIL, cashOutAvaiblityType, e.getMessage()));
			throw new RuntimeException(e.getMessage());
		}
	}

	public void verifyNumericRangeFieldsValidation() {
		try {
			CoreFunctions.clickElement(driver, _selectFlexSetupType);
			CoreFunctions.selectItemInListByText(driver, _selectFlexSetupTypeOptions, COREFLEXConstants.STATIC_FIXED,
					true);
			checkFieldValidation(COREFLEXConstants.TOTAL_POINTS_AVAILABLE, "0.24");
			checkFieldValidation(COREFLEXConstants.TOTAL_POINTS_AVAILABLE, "0.50");
			checkFieldValidation(COREFLEXConstants.TOTAL_POINTS_AVAILABLE, "100.25");
			checkFieldValidation(COREFLEXConstants.TOTAL_POINTS_AVAILABLE, "999.5");
			checkFieldValidation(COREFLEXConstants.TOTAL_POINTS_AVAILABLE, "1001");
			CoreFunctions.selectItemInListByText(driver, _sectionCashoutAvailability, COREFLEXConstants.PORTION_CASHOUT,
					true);
			checkFieldValidation(COREFLEXConstants.POINT_EXCHANGE_RATE, "0.24");
			checkFieldValidation(COREFLEXConstants.POINT_EXCHANGE_RATE, "0.50");
			checkFieldValidation(COREFLEXConstants.POINT_EXCHANGE_RATE, "100.25");
			checkFieldValidation(COREFLEXConstants.POINT_EXCHANGE_RATE, "999.5");
			checkFieldValidation(COREFLEXConstants.POINT_EXCHANGE_RATE, "1001");
			checkFieldValidation(COREFLEXConstants.MAX_PORTION_CASHOUT, "0.99");
			checkFieldValidation(COREFLEXConstants.MAX_PORTION_CASHOUT, "1");
			checkFieldValidation(COREFLEXConstants.MAX_PORTION_CASHOUT, "50.3");
			checkFieldValidation(COREFLEXConstants.MAX_PORTION_CASHOUT, "100");
			checkFieldValidation(COREFLEXConstants.MAX_PORTION_CASHOUT, "100.01");
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FIELDS_VALIDATIONS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	public void checkFieldValidation(String fieldName, String inputValue) {
		switch (fieldName) {
		case COREFLEXConstants.TOTAL_POINTS_AVAILABLE:
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputTotalPointsAvailable, inputValue, fieldName);
			clickElementOfPage(PDTConstants.NEXT);
			validateTotalPointsAvailableField(fieldName, inputValue);
			break;
		case COREFLEXConstants.POINT_EXCHANGE_RATE:
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputPointExchangeRate, inputValue, fieldName);
			clickElementOfPage(PDTConstants.NEXT);
			validatePointsExchangeRateField(fieldName, inputValue);
			break;
		case COREFLEXConstants.MAX_PORTION_CASHOUT:
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputMarginPortion, inputValue, fieldName);
			clickElementOfPage(PDTConstants.NEXT);
			validateMaxPortionCashoutField(fieldName, inputValue);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
	}

	private void validateMaxPortionCashoutField(String fieldName, String inputValue) {
		acceptErrorDialogIfDisplayed();
		if (CoreFunctions.isElementExist(driver, _validationMessageMaxPortionCashout, 5))
			BusinessFunctions.checkValidationBasedOnInput(
					CoreFunctions.getElementText(driver, _validationMessageMaxPortionCashout), fieldName, inputValue);
	}

	private void validatePointsExchangeRateField(String fieldName, String inputValue) {
		acceptErrorDialogIfDisplayed();
		if (CoreFunctions.isElementExist(driver, _validationMessagePointsExchangeRate, 5))
			BusinessFunctions.checkValidationBasedOnInput(
					CoreFunctions.getElementText(driver, _validationMessagePointsExchangeRate)
							.equals(COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE_OLD_MESSAGE),
					fieldName, inputValue);
	}

	private void validateTotalPointsAvailableField(String fieldName, String inputValue) {
		acceptErrorDialogIfDisplayed();
		if (CoreFunctions.isElementExist(driver, _validationMessageTotalPointsAvailable, 5)) {
			BusinessFunctions.checkValidationBasedOnInput(
					CoreFunctions.getElementText(driver, _validationMessageTotalPointsAvailable)
							.equals(COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE_NEW_MESSAGE),
					fieldName, inputValue);
		} else if (CoreFunctions.getElementText(driver, _headerPage)
				.equals(COREFLEXConstants.POLICY_BENEFIT_CATEGORIES)) {
			Assert.fail(MessageFormat.format(COREFLEXConstants.USER_NAVIGATION_TO_POLICY_BENEFITS_CATEGORIES_INVALID,
					CoreConstants.FAIL, fieldName, inputValue));
		}
	}

	private void acceptErrorDialogIfDisplayed() {
		if (CoreFunctions.isElementExist(driver, _textErrorDialog, 2))
			clickElementOfPage(PDTConstants.OK);
	}

}
