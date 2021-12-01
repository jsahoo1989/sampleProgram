package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
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
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='benefitPackageTypeCode'")
	private WebElement _selectBenefitPackageType;

	// Benefit Package Type Default Value
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='benefitPackageTypeCode']//span[contains(@class,'ng-value-label')]")
	private WebElement _selectBenefitPackageTypeDefaultValue;

	// Benefit Package Type Please Select Value
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='benefitPackageTypeCode']//div[@class='ng-placeholder']")
	private WebElement _selectBenefitPackageTypeSelection;

	// Benefit Package Type Select Options
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='benefitPackageTypeCode'] div.ng-option")
	private List<WebElement> _selectBenefitPackageTypeOptions;

	// Points Based Flex Policy Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='pointBasedFlexInd'][class*='ng-select-clearable']")
	private WebElement _selectPointsBasedFlexPolicy;

	// Points Based Flex Policy Select Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Points Based Flex Policy')]/following-sibling::ng-select/descendant::div[@role='option']")
	private List<WebElement> _selectPointsBasedFlexPolicyOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='policyName']")
	private WebElement _inputPolicyName;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='policyTypeCode']")
	private WebElement _drpDwnPolicyType;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='policyTypeCode'] span.ng-option-label")
	private List<WebElement> _drpDwnPolicyTypeOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='employeeTypeCode']")
	private WebElement _drpDwnEmployeeType;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='employeeTypeCode'] span.ng-option-label")
	private List<WebElement> _drpDwnEmployeeTypeOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeownerTypeCode']")
	private WebElement _drpDwnHomeOwnerType;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeownerTypeCode'] span.ng-option-label")
	private List<WebElement> _drpDwnHomeOwnerTypeOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='cappedPolicyCode']")
	private WebElement _drpDwnCappedPolicy;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='cappedPolicyCode'] span.ng-option-label")
	private List<WebElement> _drpDwnCappedPolicyOptions;
	
	@FindBy(how = How.CSS, using = "label[class='form-check-label']")
	private List<WebElement> _radioBtnExpenseManagementClient;
	
	@FindBy(how = How.CSS, using = "button.btn-next")
	private WebElement _btnNext;
	
	private String policyType, employeeType, homeOwnerType;
	
	/*********************************************************************/

	public boolean validateGeneralInfo(String pageName, DataTable dataTable, String selectedPolicyName) {

		boolean isGeneralInfoValid = false;
		boolean leftNavigationVerified, clientPolicyDetailsVerified = false;

		try {
			leftNavigationVerified = verifyLeftNavigationMenu(pageName);
			clientPolicyDetailsVerified = verifyClientPolicyDetails(pageName, dataTable, selectedPolicyName);
			isGeneralInfoValid = leftNavigationVerified && clientPolicyDetailsVerified;
		} catch (Exception e) {
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

	private boolean verifyClientDetailsOnGenaralInfo(String expectedClientID, String expectedClientName) {

		if ((CoreFunctions.getElementText(driver, _textClientName).equals(expectedClientName))
				&& (CoreFunctions.getElementText(driver, _textClientID).equals(expectedClientID))) {
			return true;
		} else
			return false;

	}

	private boolean verifyPolicyNameOnGeneralInfo(String selectedPolicyName) {

		String[] expectedPolicyName = (CoreFunctions.getElementText(driver, _headerPolicyInfo)).split(":");

		if (selectedPolicyName.contains(expectedPolicyName[1].trim()))
			return true;
		else
			return false;
	}

	private boolean verifyLeftNavigationMenu(String pageName) {

		return (CoreFunctions.isElementExist(driver, _leftNavGeneralInfo, 5) ? true : false);

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

		defaultValue = CoreFunctions.getElementText(driver, _selectBenefitPackageTypeDefaultValue);

		if (defaultValue.isEmpty()) {
			defaultValue = CoreFunctions.getElementText(driver, _selectBenefitPackageTypeSelection);
		}

		return defaultValue;
	}
	
	public boolean verifyCoreFlexPolicyField(String expectedDefaultValue) {

		if ((CoreFunctions.isElementExist(driver, _selectCoreFlexPolicy, 2))
				&& (CoreFunctions.getElementText(driver, _selectCoreFlexPolicyDefaultValue))
						.equals(expectedDefaultValue)) {			
			return true;
		}
		return false;
	}

	public boolean verifyCoreFlexPolicyField(String expectedDefaultValue, String pageName) {

		if ((CoreFunctions.isElementExist(driver, _selectCoreFlexPolicy, 2))
				&& _selectCoreFlexPolicyDefaultValue.getText()
						.equals(expectedDefaultValue)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DEFAULT_COREFLEX_POLICY, CoreConstants.PASS, expectedDefaultValue, pageName));
			return true;
		}
		return false;
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
	
	public String getCoreFlexPolicyDefaultValue() {
		return _selectCoreFlexPolicyDefaultValue.getText().trim();
	}
	
	public boolean verifyBenefitPackageType(DataTable benefitPackageTypeTable) {
		CoreFunctions.clickElement(driver, _selectBenefitPackageType);

		List<String> expectedOptions = benefitPackageTypeTable.asList(String.class);
		List<String> actualOptions = CoreFunctions.getElementTextAndStoreInList(driver,
				_selectBenefitPackageTypeOptions);
		if(actualOptions.equals(expectedOptions)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_BENEFIT_PACKAGE_TYPE, CoreConstants.PASS, expectedOptions));
			return true;
		}		
		return false;
	}
	
	public String getBenefitPackageTypeOptions() {
		return CoreFunctions.getElementTextAndStoreInList(driver,
				_selectBenefitPackageTypeOptions).toString();
	}
	
	public void explicitWaitForGeneralInfoHeading() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _headerGeneralInfo, PDTConstants.GENERAL_INFORMATION);
	}
	
	public boolean verifyClientDetails(String expectedClientID, String expectedClientName) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textClientName, PDTConstants.CLIENT_NAME);
		if ((_textClientName.getText().equals(expectedClientName))
				&& (_textClientID.getText().equals(expectedClientID))) {
			CoreFunctions.highlightObject(driver, _textClientName);
			CoreFunctions.highlightObject(driver, _textClientID);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_CLIENT_DETAILS, CoreConstants.PASS, expectedClientID, expectedClientName));
			return true;
		}
		return false;

	}

	public boolean verifyPolicyName(String expectedPolicyName) {		
		if (expectedPolicyName.contains(_headerPolicyInfo.getText().split(":")[1].trim())) {
			CoreFunctions.highlightObject(driver, _inputPolicyName);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_POLICY_NAME, CoreConstants.PASS, expectedPolicyName));
			return true;
		}
		return false;
	}
	
	/*public String getClientId() {
		return _textClientID.getText().trim();
	}
	
	public String getClientName() {
		return _textClientName.getText().trim();
	}
	
	public String getPolicyName() {		
		return _headerPolicyInfo.getText().split(":")[1].trim();		
	}*/
	
	public String getElementText(String elementName) {
		String elementText = null;
		switch (elementName) {
		case PDTConstants.CLIENT_ID:
			elementText = _textClientID.getText().trim();
			break;
		case PDTConstants.CLIENT_NAME:
			elementText = _textClientName.getText().trim();
			break;
		case PDTConstants.POLICY_NAME:
			elementText = _headerPolicyInfo.getText().split(":")[1].trim();
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return elementText;
	}
	
	public void setPolicyType(String policy) {
		policyType = policy;
	}
	
	public void setEmployeeType(String empType) {
		employeeType = empType;
	}
	
	public void setHomeOwnerType(String homeType) {
		homeOwnerType = homeType;
	}

	public void enterGeneralInformationFields(DataTable generalInfoTable) {
		List<Map<String, String>> generalInfo = generalInfoTable.asMaps(String.class, String.class);
		CoreFunctions.clickElement(driver, _drpDwnPolicyType);
		CoreFunctions.selectItemInListByText(driver, _drpDwnPolicyTypeOptions, generalInfo.get(0).get("PolicyType"), true);
		CoreFunctions.clickElement(driver, _drpDwnEmployeeType);
		setPolicyType(generalInfo.get(0).get("PolicyType"));
		CoreFunctions.selectItemInListByText(driver, _drpDwnEmployeeTypeOptions, generalInfo.get(0).get("EmployeeType"), true);
		CoreFunctions.clickElement(driver, _drpDwnHomeOwnerType);
		setEmployeeType(generalInfo.get(0).get("EmployeeType"));
		CoreFunctions.selectItemInListByText(driver, _drpDwnHomeOwnerTypeOptions, generalInfo.get(0).get("HomeownerType"), true);
		setHomeOwnerType(generalInfo.get(0).get("HomeownerType"));
		CoreFunctions.clickElement(driver, _selectBenefitPackageType);
		CoreFunctions.selectItemInListByText(driver, _selectBenefitPackageTypeOptions, generalInfo.get(0).get("BenefitPackageType"), true);
		CoreFunctions.clickElement(driver, _drpDwnCappedPolicy);
		CoreFunctions.selectItemInListByText(driver, _drpDwnCappedPolicyOptions, generalInfo.get(0).get("CappedPolicy"), true);
		CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnExpenseManagementClient);
		CoreFunctions.selectItemInListByText(driver, _radioBtnExpenseManagementClient, generalInfo.get(0).get("ExpenseManagementClient"), true);
		CoreFunctions.click(driver, _btnNext, _btnNext.getText());
	}
}
