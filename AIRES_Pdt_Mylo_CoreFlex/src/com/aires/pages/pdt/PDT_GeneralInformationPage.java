package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class PDT_GeneralInformationPage extends Base {

	public PDT_GeneralInformationPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Add New Policy Forms
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//i[contains(text(),'pending_actions')]/following-sibling::p[contains(text(),'General Information')]")
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

	public boolean validateGeneralInfo(String pageName, DataTable dataTable, String selectedPolicyName) {

		boolean isGeneralInfoValid = false;
		boolean leftNavigationVerified, clientPolicyDetailsVerified = false;

		try {
			leftNavigationVerified = verifyLeftNavigationMenu(pageName);
			clientPolicyDetailsVerified = verifyClientPolicyDetails(pageName, dataTable, selectedPolicyName);
			isGeneralInfoValid = leftNavigationVerified && clientPolicyDetailsVerified;
		} catch (Exception e) {
			Log.info(e.getMessage());
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_GENERAL_INFORMATION_PAGE,
							CoreConstants.FAIL, e.getMessage()));
		}

		if (isGeneralInfoValid) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.SUCCESSFULLY_VERIFIED_CLIENT_AND_POLICY_DETAILS_ON_GENERAL_INFO_PAGE,
					CoreConstants.PASS, pageName));
		}

		return isGeneralInfoValid;

	}

	private boolean verifyClientPolicyDetails(String pageName, DataTable dataTable, String selectedPolicyName) {

		List<Map<String, String>> clientInfo = dataTable.asMaps(String.class, String.class);
		String expectedClientID = clientInfo.get(0).get("ClientID");
		String expectedClientName = clientInfo.get(0).get("ClientName");

		CoreFunctions.explicitWaitTillElementVisibility(driver, _headerGeneralInfo, PDTConstants.GENERAL_INFORMATION);

		boolean isPolicyNameCorrect = verifyPolicyNameOnGeneralInfo(selectedPolicyName);
		boolean isClientDetailsCorrect = verifyClientDetailsOnGenaralInfo(expectedClientID, expectedClientName);

		return (isPolicyNameCorrect && isClientDetailsCorrect);
	}

	public boolean verifyClientPolicyDetails(String clientID, String selectedPolicyName) {

		CoreFunctions.explicitWaitTillElementVisibility(driver, _headerGeneralInfo, PDTConstants.GENERAL_INFORMATION);

		boolean isPolicyNameCorrect = verifyPolicyNameOnGeneralInfo(selectedPolicyName);
		boolean isClientDetailsCorrect = verifyClientDetailsOnGenaralInfo(clientID);

		return (isPolicyNameCorrect && isClientDetailsCorrect);

	}

	private boolean verifyClientDetailsOnGenaralInfo(String expectedClientID) {
		if ((CoreFunctions.getElementText(driver, _textClientID).equals(expectedClientID))) {
			return true;
		} else
			return false;
	}

	private boolean verifyClientDetailsOnGenaralInfo(String expectedClientID, String expectedClientName) {

		if ((CoreFunctions.getElementText(driver, _textClientName).equals(expectedClientName))
				&& (CoreFunctions.getElementText(driver, _textClientID).equals(expectedClientID))) {
			return true;
		} else
			return false;

	}

	private boolean verifyPolicyNameOnGeneralInfo(String selectedPolicyName) {

		String[] expectedPolicyName = ((CoreFunctions.getElementText(driver, _headerPolicyInfo)).split(":"));

		if (selectedPolicyName.contains(expectedPolicyName[1].trim()))
			return true;
		else
			return false;
	}

	private boolean verifyLeftNavigationMenu(String pageName) {

		return (CoreFunctions.isElementExist(driver, _leftNavGeneralInfo, 5) ? true : false);

	}

	public boolean verifyGeneralInfoField(String fieldName, String defaultValue) {

		boolean isFieldVerified = false;

		try {

			switch (fieldName) {

			case PDTConstants.CORE_FLEX_POLICY:
				isFieldVerified = verifyCoreFlexPolicyField(defaultValue);
				break;

			case PDTConstants.BENEFIT_PACKAGE_TYPE:
				isFieldVerified = verifyBenefitPackageTypeField(defaultValue);
				break;

			case PDTConstants.POINTS_BASED_FLEX_POLICY:
				isFieldVerified = verifyPointsBasedFlexPolicyField(defaultValue);
				break;

			default:
				Assert.fail("Field not found");

			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_GENERAL_INFORMATION_FIELD,
							CoreConstants.FAIL, fieldName, e.getMessage()));
		}

		if (isFieldVerified) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.SUCCESSFULLY_VERIFIED_FIELD_AND_DEFAULT_VALUE_ON_GENERAL_INFORMATION_PAGE,
					CoreConstants.PASS, fieldName, defaultValue));
		}

		return isFieldVerified;

	}

	public boolean verifyGeneralInfoField(String fieldName, String defaultValue, DataTable dataTable) {

		boolean isFieldVerified = false;
		boolean isFieldDefaultValueVerified, isFieldSelectOptionsVerified = false;

		try {

			switch (fieldName) {

			case PDTConstants.CORE_FLEX_POLICY:
				isFieldVerified = verifyCoreFlexPolicyField(defaultValue);
				break;

			case PDTConstants.BENEFIT_PACKAGE_TYPE:
				isFieldDefaultValueVerified = verifyBenefitPackageTypeField(defaultValue);
				isFieldSelectOptionsVerified = verifyBenefitPackageTypeOptions(dataTable);
				isFieldVerified = isFieldDefaultValueVerified && isFieldSelectOptionsVerified;
				break;

			case PDTConstants.POINTS_BASED_FLEX_POLICY:
				isFieldDefaultValueVerified = verifyPointsBasedFlexPolicyField(defaultValue);
				isFieldSelectOptionsVerified = verifyPointsBasedFlexPolicyOptions(dataTable);
				isFieldVerified = isFieldDefaultValueVerified && isFieldSelectOptionsVerified;
				break;

			default:
				Assert.fail("Field not found");

			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_GENERAL_INFORMATION_FIELD,
							CoreConstants.FAIL, fieldName, e.getMessage()));
		}

		if (isFieldVerified) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.SUCCESSFULLY_VERIFIED_FIELD_AND_DEFAULT_VALUE_ON_GENERAL_INFORMATION_PAGE,
					CoreConstants.PASS, fieldName, defaultValue));
		}

		return isFieldVerified;

	}

	private boolean verifyPointsBasedFlexPolicyOptions(DataTable dataTable) {

		CoreFunctions.clickElement(driver, _selectPointsBasedFlexPolicy);

		List<String> expectedOptions = dataTable.asList(String.class);
		List<String> actualOptions = CoreFunctions.getElementTextAndStoreInList(driver,
				_selectPointsBasedFlexPolicyOptions);

		System.out.println("Expected Options : " + expectedOptions);
		System.out.println("Actual Options : " + actualOptions);

		return actualOptions.equals(expectedOptions) ? true : false;
	}

	private boolean verifyPointsBasedFlexPolicyField(String expectedDefaultValue) {

		if ((CoreFunctions.isElementExist(driver, _selectPointsBasedFlexPolicy, 2))) {
			return true;
		} else {
			return false;
		}
	}

	private boolean verifyBenefitPackageTypeOptions(DataTable dataTable) {

		CoreFunctions.clickElement(driver, _selectBenefitPackageType);

		List<String> expectedOptions = dataTable.asList(String.class);
		List<String> actualOptions = CoreFunctions.getElementTextAndStoreInList(driver,
				_selectBenefitPackageTypeOptions);

		System.out.println("Expected Options : " + expectedOptions);
		System.out.println("Actual Options : " + actualOptions);

		return actualOptions.equals(expectedOptions) ? true : false;
	}

	private boolean verifyBenefitPackageTypeField(String expectedDefaultValue) {

		if ((CoreFunctions.isElementExist(driver, _selectBenefitPackageType, 2))
				&& getActualDefaultValue().equals(expectedDefaultValue)) {

			return true;
		} else {
			return false;
		}

	}

	private String getActualDefaultValue() {

		String defaultValue;

		if (CoreFunctions.isElementExist(driver, _selectBenefitPackageTypeDefaultValue, 2))
			defaultValue = CoreFunctions.getElementText(driver, _selectBenefitPackageTypeDefaultValue);
		else
			defaultValue = CoreFunctions.getElementText(driver, _selectBenefitPackageTypeSelection);

		return defaultValue;
	}

	private boolean verifyCoreFlexPolicyField(String expectedDefaultValue) {

		if ((CoreFunctions.isElementExist(driver, _selectCoreFlexPolicy, 2))
				&& (CoreFunctions.getElementText(driver, _selectCoreFlexPolicyDefaultValue))
						.equals(expectedDefaultValue)) {

			return true;
		} else {
			return false;
		}
	}

	public boolean verifyFieldExist(String fieldName) {

		boolean isFieldExist = false;

		try {

			isFieldExist = CoreFunctions.isElementExist(driver, _selectPointsBasedFlexPolicy, 2);

		} catch (Exception e) {

			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_GENERAL_INFORMATION_FIELD,
							CoreConstants.FAIL, fieldName, e.getMessage()));

		}

		if (!isFieldExist) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.SUCCESSFULLY_VERIFIED_FIELD_NOT_DISPLAYED_ON_GENERAL_INFORMATION_PAGE,
					CoreConstants.PASS, fieldName));
		}

		return isFieldExist;
	}

	public boolean selectFieldOption(String fieldName, String fieldSelection) {

		boolean isFieldSelected = false;

		try {

			switch (fieldName) {

			case PDTConstants.POLICY_TYPE:
				isFieldSelected = selectPolicyTypeField(fieldSelection);
				break;

			case PDTConstants.EMPLOYEE_TYPE:
				isFieldSelected = selectEmployeeTypeField(fieldSelection);
				break;

			case PDTConstants.HOMEOWNER_TYPE:
				isFieldSelected = selectHomeownerTypeField(fieldSelection);
				break;

			case PDTConstants.CAPPED_POLICY:
				isFieldSelected = selectCappedPolicyField(fieldSelection);
				break;

			case PDTConstants.BENEFIT_PACKAGE_TYPE:
				isFieldSelected = selectBenefitPackageTypeField(fieldSelection);
				break;

			case PDTConstants.POINTS_BASED_FLEX_POLICY:
				isFieldSelected = selectPointsBasedFlexPolicyField(fieldSelection);
				break;

			default:
				Assert.fail("Field not found");

			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_SELECTING_GENERAL_INFORMATION_FIELD,
							CoreConstants.FAIL, fieldName, e.getMessage()));
		}

		if (isFieldSelected) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.SUCCESSFULLY_SELECTED_OPTION_FOR_FIELD_ON_GENERAL_INFORMATION_PAGE, CoreConstants.PASS,
					fieldSelection, fieldName));
		}

		return isFieldSelected;

	}

	private boolean selectCappedPolicyField(String fieldSelection) {
		if (CoreFunctions.isElementExist(driver, _selectCappedPolicyType, 5)) {
			CoreFunctions.clickElement(driver, _selectCappedPolicyType);
			CoreFunctions.selectItemInListByText(driver, _selectCappedPolicyTypeOptions, fieldSelection);
			return true;
		} else
			return false;
	}

	private boolean selectHomeownerTypeField(String fieldSelection) {
		if (CoreFunctions.isElementExist(driver, _selectHomeownerType, 5)) {
			CoreFunctions.clickElement(driver, _selectHomeownerType);
			CoreFunctions.selectItemInListByText(driver, _selectHomeownerTypeOptions, fieldSelection);
			return true;
		} else
			return false;
	}

	private boolean selectEmployeeTypeField(String fieldSelection) {
		if (CoreFunctions.isElementExist(driver, _selectEmployeeType, 5)) {
			CoreFunctions.clickElement(driver, _selectEmployeeType);
			CoreFunctions.selectItemInListByText(driver, _selectEmployeeTypeOptions, fieldSelection);
			return true;
		} else
			return false;
	}

	private boolean selectPolicyTypeField(String fieldSelection) {
		if (CoreFunctions.isElementExist(driver, _selectPolicyType, 5)) {
			CoreFunctions.clickElement(driver, _selectPolicyType);
			CoreFunctions.selectItemInListByText(driver, _selectPolicyTypeOptions, fieldSelection);
			return true;
		} else
			return false;
	}

	private boolean selectPointsBasedFlexPolicyField(String fieldSelection) {
		if (CoreFunctions.isElementExist(driver, _selectPointsBasedFlexPolicy, 5)) {
			CoreFunctions.clickElement(driver, _selectPointsBasedFlexPolicy);
			CoreFunctions.selectItemInListByText(driver, _selectPointsBasedFlexPolicyOptions, fieldSelection);
			return true;
		} else
			return false;
	}

	private boolean selectBenefitPackageTypeField(String fieldSelection) {

		if (CoreFunctions.isElementExist(driver, _selectBenefitPackageType, 5)) {
			CoreFunctions.clickElement(driver, _selectBenefitPackageType);
			CoreFunctions.selectItemInListByText(driver, _selectBenefitPackageTypeOptions, fieldSelection);
			return true;
		} else
			return false;

	}

	public void selectOtherMandatoryFields() {

		selectFieldOption(PDTConstants.POLICY_TYPE, PDTConstants.US_DOMESTIC);
		selectFieldOption(PDTConstants.EMPLOYEE_TYPE, PDTConstants.NEW_HIRE);
		selectFieldOption(PDTConstants.HOMEOWNER_TYPE, PDTConstants.HOMEOWNER);
		selectFieldOption(PDTConstants.CAPPED_POLICY, PDTConstants.YES);
		CoreFunctions.clickElement(driver, _radioExpenseManagementNoOption);

	}

	public boolean verifyPageNavigation(String pointsBasedFlexSelection, String expectedPageTitle,
			String expectedLeftNavigationTitle, CoreFlex_FlexPolicySetupPage flexPolicySetupPage,
			PDT_PolicyBenefitsCategoriesPage pdtPolicyBenefitsCategoriesPage) {

		boolean isNavigationCorrect = false;
		String actualPageTitle, actualLeftNavigationTitle;

		try {

			if (pointsBasedFlexSelection.equals("Yes")) {
				actualPageTitle = flexPolicySetupPage.getPageHeaderTitle();
				actualLeftNavigationTitle = flexPolicySetupPage.getLeftNavigationPageTitle();
				isNavigationCorrect = validatePageNavigation(actualPageTitle, actualLeftNavigationTitle,
						expectedPageTitle,expectedLeftNavigationTitle);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.SUCCESSFULLY_NAVIGATED_TO_PAGE_PAST_GENERAL_INFORMATION,
								CoreConstants.PASS, actualPageTitle));

			} else if (pointsBasedFlexSelection.equals("No")) {
				actualPageTitle = pdtPolicyBenefitsCategoriesPage.getPageHeaderTitle();
				actualLeftNavigationTitle = pdtPolicyBenefitsCategoriesPage.getLeftNavigationPageTitle();
				isNavigationCorrect = validatePageNavigation(actualPageTitle, actualLeftNavigationTitle,
						expectedPageTitle,expectedLeftNavigationTitle);
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

	private boolean validatePageNavigation(String actualPageTitle, String actualLeftNavigationTitle,
			String expectedPageTitle, String expectedLeftNavigationTitle) {

		System.out.println("Actual Page Title : " + actualPageTitle);		
		System.out.println("Expected Title : " + expectedPageTitle);
		System.out.println("Actual Left Navigation Title : " + actualLeftNavigationTitle);
		System.out.println("Expected Left Navigation Title : " + expectedLeftNavigationTitle);

		if ((actualPageTitle.equals(expectedPageTitle)) && (actualLeftNavigationTitle.equals(expectedLeftNavigationTitle)))
			return true;
		else
			return false;
	}

}
