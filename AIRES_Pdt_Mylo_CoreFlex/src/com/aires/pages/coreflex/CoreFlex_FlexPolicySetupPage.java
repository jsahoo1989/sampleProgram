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

	// Total Points Available Input Field
	@FindBy(how = How.CSS, using = "input[formcontrolname='staticPoints']")
	private WebElement _inputTotalPointsAvailable;

	// No Max/Unlimited Checkbox Field
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'No Max/Unlimited')]")
	private WebElement _checkboxNoMaxUnlimited;

	// After Relocation Only Section
	@FindBy(how = How.CSS, using = "label[class='cashout'] > p")
	private List<WebElement> _sectionCashoutAvailiblity;

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
	

	/*********************************************************************/

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
			case COREFLEXConstants.POLICY_BENEFITS_CATEGORIES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.POLICY_BENEFITS_CATEGORIES);
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
	 * Method to verify navigated Page Header Title and Left Navigation
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		return (getPageHeaderTitle().equals(expectedPageName))
				& (getLeftNavigationPageTitle().equals(expectedPageName));
	}

	/**
	 * Method to select FlexPolicySetup page fields based on values provided
	 * 
	 * @param dataTable
	 */
	public void selectFlexPolicySetupPageFields(DataTable dataTable) {

		List<List<String>> dataList = dataTable.asLists(String.class);
		String fieldName, fieldSelection;

		for (int i = 0; i < dataList.get(0).size(); i++) {
			fieldName = dataList.get(0).get(i);
			fieldSelection = dataList.get(1).get(i);
			performPageFieldSelection(fieldName, fieldSelection);
		}

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
				BusinessFunctions.selectRadioAsPerLabelText(driver, _radioFlexAllowanceType, fieldSelectionInput.trim());
				break;
			case COREFLEXConstants.PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION:
				BusinessFunctions.selectRadioAsPerLabelText(driver, _radioPersonResponsibleForBenefitSelection,
						fieldSelectionInput.trim());
				break;
			case COREFLEXConstants.FLEX_SETUP_TYPE:
				CoreFunctions.clickElement(driver, _selectFlexSetupType);
				CoreFunctions.selectItemInListByText(driver, _selectFlexSetupTypeOptions, fieldSelectionInput, true);
				break;
			case COREFLEXConstants.TOTAL_POINTS_AVAILABLE:
				CoreFunctions.setElementText(driver, _inputTotalPointsAvailable, fieldSelectionInput);
				break;
			case COREFLEXConstants.CASHOUT_AVAILIBLITY:
				CoreFunctions.selectItemInListByText(driver, _sectionCashoutAvailiblity, fieldSelectionInput, true);
				fillCashoutAvailiblityDetails(fieldSelectionInput);
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

	private void fillCashoutAvailiblityDetails(String cashOutAvaiblityType) {

		try {
			switch (cashOutAvaiblityType) {
			case COREFLEXConstants.PORTION_CASHOUT:
			case COREFLEXConstants.AFTER_RELOCATION_ONLY:
				CoreFunctions.clearAndSetText(driver, _inputCustomCashoutName, CoreFunctions.generateRandomString(8));
				CoreFunctions.set(driver, _inputMarginPortion, CoreFunctions.generateRandomNumberInGivenRange(1,100));
				CoreFunctions.clearAndSetText(driver, _inputPointExchangeRate, CoreFunctions.generateRandomNumberInGivenRange(1,100));
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

}
