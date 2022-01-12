package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class PDT_GeneralInformationPage extends Base {

	public PDT_GeneralInformationPage(WebDriver driver) {
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

	// Add New Policy Forms
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//i/following-sibling::p[contains(text(),'General Information')]")
	private WebElement _leftNavGeneralInfo;

	// General Information Header
	@FindBy(how = How.XPATH, using = "//h4[@class='card-title'][contains(text(),'General Information')]")
	private WebElement _headerGeneralInfo;

	// Policy Header
	@FindBy(how = How.CSS, using = "h4[class='card-title'] > b")
	private WebElement _headerPolicyInfo;

	// Client Name - General Information
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Client Name:')]/following-sibling::label")
	private WebElement _textClientName;

	// Client ID - General Information
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Client#')]/following-sibling::label")
	private WebElement _textClientID;

	// CoreFlex Policy Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='coreFlexInd'][class*='ng-select-disabled']")
	private WebElement _selectCoreFlexPolicy;

	// CoreFlex Policy Select Field Default Value
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='coreFlexInd']//span[@class='ng-value-label']")
	private WebElement _selectCoreFlexPolicyDefaultValue;

	// Benefit Package Type Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='benefitPackageTypeCode'][class*='ng-select-clearable']")
	private WebElement _selectBenefitPackageType;

	// Benefit Package Type Default Value
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='benefitPackageTypeCode']//span[contains(@class,'ng-value-label')]")
	private WebElement _selectBenefitPackageTypeDefaultValue;

	// Benefit Package Type Please Select Value
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='benefitPackageTypeCode']//div[@class='ng-placeholder']")
	private WebElement _selectBenefitPackageTypeSelection;

	// Benefit Package Type Select Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Benefit Package Type')]/following-sibling::ng-select/descendant::div[@role='option']")
	private List<WebElement> _selectBenefitPackageTypeOptions;

	// Points Based Flex Policy Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='pointBasedFlexInd'][class*='ng-select-clearable']")
	private WebElement _selectPointsBasedFlexPolicy;

	// Points Based Flex Policy Select Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Points Based Flex Policy')]/following-sibling::ng-select/descendant::div[@role='option']")
	private List<WebElement> _selectPointsBasedFlexPolicyOptions;

	// Policy type Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='policyTypeCode'][class*='ng-select-clearable']")
	private WebElement _selectPolicyType;

	// Policy type Select Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Policy Type')]/following-sibling::ng-select/descendant::div[@role='option']")
	private List<WebElement> _selectPolicyTypeOptions;

	// Employee type Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='employeeTypeCode'][class*='ng-select-clearable']")
	private WebElement _selectEmployeeType;

	// Employee type Select Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Employee Type')]/following-sibling::ng-select/descendant::div[@role='option']")
	private List<WebElement> _selectEmployeeTypeOptions;

	// Homeowner type Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeownerTypeCode'][class*='ng-select-clearable']")
	private WebElement _selectHomeownerType;

	// Homeowner type Select Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Homeowner Type')]/following-sibling::ng-select/descendant::div[@role='option']")
	private List<WebElement> _selectHomeownerTypeOptions;

	// Capped Policy type Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='cappedPolicyCode'][class*='ng-select-clearable']")
	private WebElement _selectCappedPolicyType;

	// Capped Policy type Select Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Capped Policy')]/following-sibling::ng-select/descendant::div[@role='option']")
	private List<WebElement> _selectCappedPolicyTypeOptions;

	// Expense Management Client Radio Button No Selection
	@FindBy(how = How.XPATH, using = "//label[@class='form-check-label'][contains(string(),'No')]")
	private WebElement _radioExpenseManagementNoOption;

	/*********************************************************************/

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
				Assert.fail(PDTConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_AN_ELEMENT_OF_PAGE,
							CoreConstants.FAIL, elementName, e.getMessage()));
			throw new RuntimeException(e);
		}
	}

	/**
	 * Method to validate ClientID, Policy Name & Left Navigation Menu of General
	 * Information page.
	 * 
	 * @param pageName
	 * @param expectedClientID
	 * @param selectedPolicyName
	 * @return
	 */
	public boolean validateClientAndPolicyDetailsOnGeneralInfo(String pageName, String expectedClientID,
			String selectedPolicyName) {

		boolean isGeneralInfoDetailsValid = false;
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _headerGeneralInfo,
					PDTConstants.GENERAL_INFORMATION);
			isGeneralInfoDetailsValid = verifyLeftNavigationMenu(pageName)
					&& (verifyPolicyNameOnGeneralInfo(selectedPolicyName)
							&& verifyClientDetailsOnGenaralInfo(expectedClientID));
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_GENERAL_INFORMATION_PAGE,
							CoreConstants.FAIL, e.getMessage()));
		}
		if (isGeneralInfoDetailsValid) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.SUCCESSFULLY_VERIFIED_CLIENT_AND_POLICY_DETAILS_ON_GENERAL_INFO_PAGE,
					CoreConstants.PASS, pageName));
		}
		return isGeneralInfoDetailsValid;

	}

	public boolean verifyClientPolicyDetails(String clientID, String selectedPolicyName) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _headerGeneralInfo, PDTConstants.GENERAL_INFORMATION);
		return (verifyPolicyNameOnGeneralInfo(selectedPolicyName) && verifyClientDetailsOnGenaralInfo(clientID));
	}

	private boolean verifyClientDetailsOnGenaralInfo(String expectedClientID) {
		return (CoreFunctions.getElementText(driver, _textClientID).equals(expectedClientID)) ? true : false;
	}

	private boolean verifyPolicyNameOnGeneralInfo(String selectedPolicyName) {
		String[] expectedPolicyName = ((CoreFunctions.getElementText(driver, _headerPolicyInfo)).split(":"));
		return (selectedPolicyName.contains(expectedPolicyName[1].trim())) ? true : false;
	}

	private boolean verifyLeftNavigationMenu(String pageName) {
		return (CoreFunctions.isElementExist(driver, _leftNavGeneralInfo, 5) ? true : false);
	}

	/**
	 * Method to verify General Information Field Default Value
	 * 
	 * @param fieldName
	 * @param expectedDefaultValue
	 * @return
	 */
	public boolean verifyGeneralInfoFieldDefaultValue(String fieldName, String expectedDefaultValue) {
		boolean isFieldVerified = false;
		try {
			switch (fieldName) {
			case PDTConstants.CORE_FLEX_POLICY:
				if ((CoreFunctions.isElementExist(driver, _selectCoreFlexPolicy, 2))
						&& (CoreFunctions.getElementText(driver, _selectCoreFlexPolicyDefaultValue))
								.equals(expectedDefaultValue))
					isFieldVerified = true;
				break;
			default:
				Reporter.addStepLog(MessageFormat.format(PDTConstants.INVALID_GENERAL_INFORMATION_FIELD,
						CoreConstants.FAIL, fieldName));
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_GENERAL_INFORMATION_FIELD_DEFAULT_VALUES,
					CoreConstants.FAIL, fieldName, expectedDefaultValue, e.getMessage()));
		}
		if (isFieldVerified) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.SUCCESSFULLY_VERIFIED_FIELD_AND_DEFAULT_VALUE_ON_GENERAL_INFORMATION_PAGE,
					CoreConstants.PASS, fieldName, expectedDefaultValue));
		}
		return isFieldVerified;
	}

	/**
	 * Method to verify field visibility and field options on General Information
	 * Page.
	 * 
	 * @param fieldName
	 * @param fieldVisibility
	 * @param fieldOptions
	 * @param coreFlexPolicyFieldValue
	 * @return
	 */
	public boolean verifyFieldVisibilityAndOptionsOnGeneralInfoPage(String fieldName, String expectedFieldVisibility,
			String expectedFieldOptions, String coreFlexPolicyFieldValue) {

		boolean isFieldVisibilityVerified, isFieldSelectOptionsVerified = false;
		boolean isFieldVerified = false;

		try {
			isFieldVisibilityVerified = verifyFieldVisibilityBasedOnCoreFlexPolicyFieldValue(fieldName,
					coreFlexPolicyFieldValue, expectedFieldVisibility);
			isFieldSelectOptionsVerified = verifyFieldOptions(fieldName, coreFlexPolicyFieldValue,
					expectedFieldOptions);
			isFieldVerified = isFieldVisibilityVerified & isFieldSelectOptionsVerified;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_FIELD_VISIBILITY_AND_OPTIONS_OF_GENERAL_INFORMATION_FIELD,
					CoreConstants.FAIL, fieldName, e.getMessage()));
		}
		if (isFieldVerified) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.SUCCESSFULLY_VERIFIED_VISBILITY_AND_OPTIONS_OF_FIELD_ON_GENERAL_INFORMATION_PAGE,
					CoreConstants.PASS, fieldName));
		}
		return isFieldVerified;
	}

	/**
	 * Method to verify general information field visibility based on CoreFlex
	 * Policy Field - Y/N Option
	 * 
	 * @param fieldName
	 * @param coreFlexPolicyFieldValue
	 * @param expectedFieldVisibility
	 * @return
	 */
	private boolean verifyFieldVisibilityBasedOnCoreFlexPolicyFieldValue(String fieldName,
			String coreFlexPolicyFieldValue, String expectedFieldVisibility) {

		boolean fieldVisibility = false;

		switch (fieldName) {
		case PDTConstants.BENEFIT_PACKAGE_TYPE:
			fieldVisibility = CoreFunctions.isElementExist(driver, _selectBenefitPackageType, 5);
			break;
		case PDTConstants.POINTS_BASED_FLEX_POLICY:
			fieldVisibility = CoreFunctions.isElementExist(driver, _selectPointsBasedFlexPolicy, 5);
			break;
		default:
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.INVALID_FIELD_NAME_OPTION, CoreConstants.FAIL, fieldName));
			return false;
		}

		switch (coreFlexPolicyFieldValue) {
		case PDTConstants.YES:
			if (fieldName.equals(PDTConstants.BENEFIT_PACKAGE_TYPE)) {
				return fieldVisibility ? false : true;
			} else if (fieldName.equals(PDTConstants.POINTS_BASED_FLEX_POLICY)) {
				return fieldVisibility ? true : false;
			}
			break;
		case PDTConstants.NO:
			if (fieldName.equals(PDTConstants.BENEFIT_PACKAGE_TYPE)) {
				return fieldVisibility ? true : false;
			} else if (fieldName.equals(PDTConstants.POINTS_BASED_FLEX_POLICY)) {
				return fieldVisibility ? false : true;
			}
			break;
		default:
			Reporter.addStepLog(MessageFormat.format(PDTConstants.INVALID_COREFLEX_POLICY_FIELD_OPTION,
					CoreConstants.FAIL, coreFlexPolicyFieldValue));
			return false;
		}
		return false;
	}

	/**
	 * Method to verify General Information Field Options
	 * 
	 * @param fieldName
	 * @param coreFlexPolicyFieldValue
	 * @param expectedFieldOptions
	 * @return
	 */
	private boolean verifyFieldOptions(String fieldName, String coreFlexPolicyFieldValue, String expectedFieldOptions) {
		List<String> actualOptions = null;

		switch (coreFlexPolicyFieldValue) {
		case PDTConstants.YES:
			if (fieldName.equals(PDTConstants.BENEFIT_PACKAGE_TYPE)
					&& !(CoreFunctions.isElementExist(driver, _selectBenefitPackageType, 5))) {
				return true;
			} else if (fieldName.equals(PDTConstants.BENEFIT_PACKAGE_TYPE)
					&& (CoreFunctions.isElementExist(driver, _selectBenefitPackageType, 5))) {
				return false;
			} else if (fieldName.equals(PDTConstants.POINTS_BASED_FLEX_POLICY)
					&& !(CoreFunctions.isElementExist(driver, _selectPointsBasedFlexPolicy, 5))) {
				return false;
			} else if (fieldName.equals(PDTConstants.POINTS_BASED_FLEX_POLICY)
					&& (CoreFunctions.isElementExist(driver, _selectPointsBasedFlexPolicy, 5))) {
				CoreFunctions.clickElement(driver, _selectPointsBasedFlexPolicy);
				actualOptions = CoreFunctions.getElementTextAndStoreInList(driver, _selectPointsBasedFlexPolicyOptions);
				return actualOptions.equals(Arrays.asList(expectedFieldOptions.split(","))) ? true : false;
			}
		case PDTConstants.NO:
			if (fieldName.equals(PDTConstants.BENEFIT_PACKAGE_TYPE)
					&& (CoreFunctions.isElementExist(driver, _selectBenefitPackageType, 5))) {
				CoreFunctions.clickElement(driver, _selectBenefitPackageType);
				actualOptions = CoreFunctions.getElementTextAndStoreInList(driver, _selectBenefitPackageTypeOptions);
				return actualOptions.equals(Arrays.asList(expectedFieldOptions.split(","))) ? true : false;
			} else if (fieldName.equals(PDTConstants.BENEFIT_PACKAGE_TYPE)
					&& !(CoreFunctions.isElementExist(driver, _selectBenefitPackageType, 5))) {
				return false;
			} else if (fieldName.equals(PDTConstants.POINTS_BASED_FLEX_POLICY)
					&& !(CoreFunctions.isElementExist(driver, _selectPointsBasedFlexPolicy, 5))) {
				return true;
			} else if (fieldName.equals(PDTConstants.POINTS_BASED_FLEX_POLICY)
					&& (CoreFunctions.isElementExist(driver, _selectPointsBasedFlexPolicy, 5))) {
				return false;
			}
		default:
			Reporter.addStepLog(MessageFormat.format(PDTConstants.INVALID_COREFLEX_POLICY_FIELD_OPTION,
					CoreConstants.FAIL, coreFlexPolicyFieldValue));
			return false;
		}
	}

	/**
	 * Method to select field name option on General Information Page.
	 * 
	 * @param fieldName
	 * @param fieldSelection
	 * @return
	 */
	public boolean selectFieldOption(String fieldName, String fieldSelection) {
		boolean isFieldOptionSelected = false;
		try {
			switch (fieldName) {
			case PDTConstants.POLICY_TYPE:
				CoreFunctions.clickElement(driver, _selectPolicyType);
				CoreFunctions.selectItemInListByText(driver, _selectPolicyTypeOptions, fieldSelection,true);
				isFieldOptionSelected = true;
				break;
			case PDTConstants.EMPLOYEE_TYPE:
				CoreFunctions.clickElement(driver, _selectEmployeeType);
				CoreFunctions.selectItemInListByText(driver, _selectEmployeeTypeOptions, fieldSelection,true);
				isFieldOptionSelected = true;
				break;
			case PDTConstants.HOMEOWNER_TYPE:
				CoreFunctions.clickElement(driver, _selectHomeownerType);
				CoreFunctions.selectItemInListByText(driver, _selectHomeownerTypeOptions, fieldSelection,true);
				isFieldOptionSelected = true;
				break;
			case PDTConstants.CAPPED_POLICY:
				CoreFunctions.clickElement(driver, _selectCappedPolicyType);
				CoreFunctions.selectItemInListByText(driver, _selectCappedPolicyTypeOptions, fieldSelection,true);
				isFieldOptionSelected = true;
				break;
			case PDTConstants.BENEFIT_PACKAGE_TYPE:
				CoreFunctions.clickElement(driver, _selectBenefitPackageType);
				CoreFunctions.selectItemInListByText(driver, _selectBenefitPackageTypeOptions, fieldSelection,true);
				isFieldOptionSelected = true;
				break;
			case PDTConstants.POINTS_BASED_FLEX_POLICY:
				CoreFunctions.clickElement(driver, _selectPointsBasedFlexPolicy);
				CoreFunctions.selectItemInListByText(driver, _selectPointsBasedFlexPolicyOptions, fieldSelection,true);
				isFieldOptionSelected = true;
				break;
			default:
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.INVALID_FIELD_NAME_OPTION, CoreConstants.FAIL, fieldName));
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_SELECTING_GENERAL_INFORMATION_FIELD,
							CoreConstants.FAIL, fieldName, e.getMessage()));
		}
		return isFieldOptionSelected;
	}

	/**
	 * Method to fill all other Mandatory fields of General Information Page.
	 * 
	 * @param dataTable
	 */
	public void fillOtherMandatoryFields(DataTable dataTable) {
		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
		selectFieldOption(PDTConstants.POLICY_TYPE, dataMap.get(0).get("PolicyType"));
		selectFieldOption(PDTConstants.EMPLOYEE_TYPE, dataMap.get(0).get("EmployeeType"));
		selectFieldOption(PDTConstants.HOMEOWNER_TYPE, dataMap.get(0).get("HomeownerType"));
		selectFieldOption(PDTConstants.CAPPED_POLICY, dataMap.get(0).get("CappedPolicy"));
		CoreFunctions.clickElement(driver, _radioExpenseManagementNoOption);
	}

	/**
	 * Method to verify Page Navigation past General Information Page based on
	 * PointsBasedFlexPolicy - Yes/No Option
	 * 
	 * @param pointsBasedFlexSelection
	 * @param expectedPageTitle
	 * @param expectedLeftNavigationTitle
	 * @param flexPolicySetupPage
	 * @param pdtPolicyBenefitsCategoriesPage
	 * @return
	 */
	public boolean verifyPageNavigation(String pointsBasedFlexSelection, String expectedPageTitle,
			String expectedLeftNavigationTitle, CoreFlex_FlexPolicySetupPage flexPolicySetupPage,
			PDT_PolicyBenefitsCategoriesPage pdtPolicyBenefitsCategoriesPage) {

		boolean isNavigationCorrect = false;
		String actualPageTitle, actualLeftNavigationTitle;
		try {
			if (pointsBasedFlexSelection.equals("Yes")) {
				actualPageTitle = flexPolicySetupPage.getPageHeaderTitle();
				actualLeftNavigationTitle = flexPolicySetupPage.getLeftNavigationPageTitle();
				isNavigationCorrect = ((actualPageTitle.equals(expectedPageTitle))
						&& (actualLeftNavigationTitle.equals(expectedLeftNavigationTitle))) ? true : false;
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.SUCCESSFULLY_NAVIGATED_TO_PAGE_PAST_GENERAL_INFORMATION,
								CoreConstants.PASS, actualPageTitle));
			} else if (pointsBasedFlexSelection.equals("No")) {
				actualPageTitle = pdtPolicyBenefitsCategoriesPage.getPageHeaderTitle();
				actualLeftNavigationTitle = pdtPolicyBenefitsCategoriesPage.getLeftNavigationPageTitle();
				isNavigationCorrect = ((actualPageTitle.equals(expectedPageTitle))
						&& (actualLeftNavigationTitle.equals(expectedLeftNavigationTitle))) ? true : false;
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.SUCCESSFULLY_NAVIGATED_TO_PAGE_PAST_GENERAL_INFORMATION,
								CoreConstants.PASS, actualPageTitle));
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_PAGE_NAVIGATION_PAST_GENERAL_INFO,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isNavigationCorrect;
	}
}
