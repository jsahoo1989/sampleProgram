package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class PDT_GeneralInformationPage extends Base {
	public PDT_GeneralInformationPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// General Information Left Navigation Title
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//p[contains(text(),'General Information')]")
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

	@FindBy(how = How.XPATH, using = "//label[text()='Policy Geographic Scope']")
	private WebElement _lblPolicyType;

	@FindBy(how = How.XPATH, using = "//label[text()='Employee Type']")
	private WebElement _lblEmployeeType;

	@FindBy(how = How.XPATH, using = "//label[text()='Homeowner Type']")
	private WebElement _lblHomeOwnerType;

	@FindBy(how = How.XPATH, using = "//label[text()='Benefit Package Type']")
	private WebElement _lblBenefitPackageType;

	@FindBy(how = How.XPATH, using = "//label[text()='Capped Policy?']")
	private WebElement _lblCappedPolicy;

	@FindBy(how = How.XPATH, using = "//label[text()='Expense Management Client']")
	private WebElement _lblExpenseMgmtClient;

	// Next Button
	@FindBy(how = How.CSS, using = "button[class*='btn-next']")
	private WebElement _buttonNext;

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
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr.foreground-closing")
	private WebElement _progressBar;

	// Policy type Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='policyTypeCode'][class*='ng-select-clearable']")
	private WebElement _selectPolicyType;

	// Policy type Select Field - Value
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='policyTypeCode'][class*='ng-select-clearable'] span[class*='ng-value-label']")
	private WebElement _selectPolicyTypeValue;

	// Policy type Select Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Policy Geographic Scope')]/following-sibling::ng-select/descendant::div[@role='option']")
	private List<WebElement> _selectPolicyTypeOptions;

	// Employee type Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='employeeTypeCode'][class*='ng-select-clearable']")
	private WebElement _selectEmployeeType;

	// Employee type Select Field - Value
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='employeeTypeCode'][class*='ng-select-clearable'] span[class*='ng-value-label']")
	private WebElement _selectEmployeeTypeValue;

	// Employee type Select Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Employee Type')]/following-sibling::ng-select/descendant::div[@role='option']")
	private List<WebElement> _selectEmployeeTypeOptions;

	// Homeowner type Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeownerTypeCode'][class*='ng-select-clearable']")
	private WebElement _selectHomeownerType;

	// Homeowner type Select Field - Value
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='homeownerTypeCode'][class*='ng-select-clearable'] span[class*='ng-value-label']")
	private WebElement _selectHomeownerTypeValue;

	// Homeowner type Select Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Homeowner Type')]/following-sibling::ng-select/descendant::div[@role='option']")
	private List<WebElement> _selectHomeownerTypeOptions;

	// Capped Policy type Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='cappedPolicyCode'][class*='ng-select-clearable']")
	private WebElement _selectCappedPolicyType;

	// Capped Policy type Select Field - Value
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='cappedPolicyCode'][class*='ng-select-clearable'] span[class*='ng-value-label']")
	private WebElement _selectCappedPolicyTypeValue;

	// Capped Policy type Select Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Capped Policy')]/following-sibling::ng-select/descendant::div[@role='option']")
	private List<WebElement> _selectCappedPolicyTypeOptions;

	// Expense Management Client Radio Button No Selection
	@FindBy(how = How.XPATH, using = "//label[@class='form-check-label'][contains(string(),'No')]")
	private WebElement _radioExpenseManagementNoOption;

	// Expense Management Client Radio Text List
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='expnMgmtInd']/parent::label")
	private List<WebElement> _radioExpenseManagementTextList;

	// Expense Management Client Radio Text List
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='expnMgmtInd']")
	private List<WebElement> _radioExpenseManagementButtonList;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='tracingSet']//span[contains(@class,'ng-value-label')]")
	private WebElement _drpDownTracingSetSelectedVal;

	// Corporation Policy#
	@FindBy(how = How.XPATH, using = "//h4[@class='card-title']/following-sibling::p/b")
	private WebElement _textCorporationPolicyID;

	// Tracing Set
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='tracingSet']//span[contains(@class,'ng-value-label')]")
	private WebElement _textTracingSet;

	// Policy Status - General Information
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Policy Status:')]/following-sibling::label")
	private WebElement _textPolicyStatus;

	// Capped Policy Error Dialog Heading
	@FindBy(how = How.CSS, using = "h2[id='swal2-title']")
	private WebElement _cappedPolicyErrorDialogHeading;

	// Capped Policy Error Dialog Message
	@FindBy(how = How.CSS, using = "div[id='swal2-content']")
	private WebElement _cappedPolicyErrorDialogMessasgeText;

	// Capped Policy Error Dialog OK Button
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _cappedPolicyErrorDialogOKButton;

	// Points Based Flex Policy Default value
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='pointBasedFlexInd']//span[@class='ng-value-label ng-star-inserted']")
	private WebElement _textPointsBasedFlexPolicyDefaultValue;

	// Points Based Flex Policy Disabled field
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='pointBasedFlexInd'][contains(@class,'ng-select-disabled')]")
	private WebElement _fieldPointsBasedFlexPolicy;

	// Policy Geographic Scope
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Policy Geographic Scope')]/parent::label/following-sibling::label")
	private WebElement _textPolicyType;

	// Employee Type
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Employee Type')]/parent::label/following-sibling::label")
	private WebElement _textEmployeeType;

	// Homeowner Type
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Homeowner Type')]/parent::label/following-sibling::label")
	private WebElement _textHomeownerType;

	// Policy Version
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Version Number')]/parent::label/following-sibling::label")
	private WebElement _textPolicyVersion;

	// Points Based Flex Policy
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Points Based Flex Policy')]/parent::label/following-sibling::label")
	private WebElement _textPointsBasedFlexPolicy;

	// Corporation Policy Number
	@FindBy(how = How.CSS, using = "p.card-category > b")
	private WebElement _textCorporationPolicyNum;

	// OK Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	private WebElement _buttonOk;

	/*********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	/*********************************************************************/

	private String policyType, employeeType, homeOwnerType, benefitPackageType, cappedPolicy, expenseMgmt,
			tracingPrompt;

	long timeBeforeAction, timeAfterAction;

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
				&& _selectCoreFlexPolicyDefaultValue.getText().equals(expectedDefaultValue)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DEFAULT_COREFLEX_POLICY, CoreConstants.PASS,
					expectedDefaultValue, pageName));
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
		if (actualOptions.equals(expectedOptions)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_BENEFIT_PACKAGE_TYPE, CoreConstants.PASS,
					expectedOptions));
			return true;
		}
		return false;
	}

	public String getBenefitPackageTypeOptions() {
		return CoreFunctions.getElementTextAndStoreInList(driver, _selectBenefitPackageTypeOptions).toString();
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
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_CLIENT_DETAILS, CoreConstants.PASS,
					expectedClientID, expectedClientName));
			return true;
		}
		return false;

	}

	public boolean verifyPolicyName(String expectedPolicyName) {
		if (expectedPolicyName.contains(_headerPolicyInfo.getText().split(":")[1].trim())) {
			CoreFunctions.highlightObject(driver, _inputPolicyName);
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.VERIFIED_POLICY_NAME, CoreConstants.PASS, expectedPolicyName));
			return true;
		}
		return false;
	}

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
		case COREFLEXConstants.CORPORATION_POLICY_NUMBER:
			elementText = _textCorporationPolicyNum.getText().split(":")[1].trim();
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return elementText;
	}

	public void setPolicyType(String policy) {
		policyType = policy;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setEmployeeType(String empType) {
		employeeType = empType;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setHomeOwnerType(String homeType) {
		homeOwnerType = homeType;
	}

	public String getHomeOwnerType() {
		return homeOwnerType;
	}

	public void setBenefitPackageType(String benefitPackage) {
		benefitPackageType = benefitPackage;
	}

	public String getBenefitPackageType() {
		return benefitPackageType;
	}

	public void setCappedPolicy(String capPolicy) {
		cappedPolicy = capPolicy;
	}

	public String getCappedPolicy() {
		return cappedPolicy;
	}

	public void setExpenseMgmt(String option) {
		expenseMgmt = option;
	}

	public String getExpenseMgmt() {
		return expenseMgmt;
	}

	public String getTracingSet() {
		return tracingPrompt;
	}

	public void setTracingPrompt() {
		tracingPrompt = _drpDownTracingSetSelectedVal.getText();
	}

	public void enterGeneralInformationFields() {
		try {
			setTracingPrompt();
			CoreFunctions.clickElement(driver, _drpDwnPolicyType);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDwnPolicyTypeOptions);
			String randPolicyType = _drpDwnPolicyTypeOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDwnPolicyTypeOptions.size() - 1)).getText();
			CoreFunctions.selectItemInListByText(driver, _drpDwnPolicyTypeOptions, randPolicyType,
					_lblPolicyType.getText(), PDTConstants.DROP_DOWN, true);
			setPolicyType(randPolicyType);

			CoreFunctions.clickElement(driver, _drpDwnEmployeeType);
			String randEmployeeType = _drpDwnEmployeeTypeOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDwnEmployeeTypeOptions.size() - 1)).getText();
			CoreFunctions.selectItemInListByText(driver, _drpDwnEmployeeTypeOptions, randEmployeeType,
					_lblEmployeeType.getText(), PDTConstants.DROP_DOWN, true);
			setEmployeeType(randEmployeeType);

			CoreFunctions.clickElement(driver, _drpDwnHomeOwnerType);
			String randHomeOwnerType = _drpDwnHomeOwnerTypeOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDwnHomeOwnerTypeOptions.size() - 1)).getText();
			CoreFunctions.selectItemInListByText(driver, _drpDwnHomeOwnerTypeOptions, randHomeOwnerType,
					_lblHomeOwnerType.getText(), PDTConstants.DROP_DOWN, true);
			setHomeOwnerType(randHomeOwnerType);

			CoreFunctions.clickElement(driver, _selectBenefitPackageType);
			String randBenefitPackageType = _selectBenefitPackageTypeOptions
					.get(CoreFunctions.getRandomNumber(0, _selectBenefitPackageTypeOptions.size() - 1)).getText();
			CoreFunctions.selectItemInListByText(driver, _selectBenefitPackageTypeOptions, randBenefitPackageType,
					_lblBenefitPackageType.getText(), PDTConstants.DROP_DOWN, true);
			setBenefitPackageType(randBenefitPackageType);

			CoreFunctions.clickElement(driver, _drpDwnCappedPolicy);
			String randCappedPolicyOption = _drpDwnCappedPolicyOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDwnCappedPolicyOptions.size() - 1)).getText();
			CoreFunctions.selectItemInListByText(driver, _drpDwnCappedPolicyOptions, randCappedPolicyOption,
					_lblCappedPolicy.getText(), PDTConstants.DROP_DOWN, true);
			setCappedPolicy(randCappedPolicyOption);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnExpenseManagementClient);
			CoreFunctions.selectItemInListByText(driver, _radioBtnExpenseManagementClient, "No",
					_lblExpenseMgmtClient.getText(), PDTConstants.RADIO_BUTTON_LIST, true);
			timeBeforeAction = new Date().getTime();
			CoreFunctions.click(driver, _btnNext, _btnNext.getText());
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction,
					PDTConstants.POLICY_BENEFIT_CATEGORIES);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(PDTConstants.FAILED_TO_FILL_GENERAL_INFO_FORM);
		}

	}

	public void enterGeneralInformationFields(DataTable generalInfoTable) {
		List<Map<String, String>> generalInfo = generalInfoTable.asMaps(String.class, String.class);
		try {
			CoreFunctions.clickElement(driver, _drpDwnPolicyType);
			CoreFunctions.selectItemInListByText(driver, _drpDwnPolicyTypeOptions, generalInfo.get(0).get("PolicyType"),
					_lblPolicyType.getText(), PDTConstants.DROP_DOWN, true);

			CoreFunctions.clickElement(driver, _drpDwnEmployeeType);
			CoreFunctions.selectItemInListByText(driver, _drpDwnEmployeeTypeOptions,
					generalInfo.get(0).get("EmployeeType"), _lblEmployeeType.getText(), PDTConstants.DROP_DOWN, true);

			CoreFunctions.clickElement(driver, _drpDwnHomeOwnerType);
			CoreFunctions.selectItemInListByText(driver, _drpDwnHomeOwnerTypeOptions,
					generalInfo.get(0).get("HomeownerType"), _lblHomeOwnerType.getText(), PDTConstants.DROP_DOWN, true);

			CoreFunctions.clickElement(driver, _selectBenefitPackageType);
			CoreFunctions.selectItemInListByText(driver, _selectBenefitPackageTypeOptions,
					generalInfo.get(0).get("BenefitPackageType"), _lblBenefitPackageType.getText(),
					PDTConstants.DROP_DOWN, true);

			CoreFunctions.clickElement(driver, _drpDwnCappedPolicy);
			CoreFunctions.selectItemInListByText(driver, _drpDwnCappedPolicyOptions,
					generalInfo.get(0).get("CappedPolicy"), _lblCappedPolicy.getText(), PDTConstants.DROP_DOWN, true);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnExpenseManagementClient);
			CoreFunctions.selectItemInListByText(driver, _radioBtnExpenseManagementClient,
					generalInfo.get(0).get("ExpenseManagementClient"), _lblExpenseMgmtClient.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.click(driver, _btnNext, _btnNext.getText());
		} catch (Exception e) {
			Assert.fail(PDTConstants.FAILED_TO_FILL_GENERAL_INFO_FORM);
		}
	}

	/***************************
	 * CoreFlex Page Methods
	 *******************************/

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
				break;
			case PDTConstants.BACK:
				CoreFunctions.clickElement(driver, _buttonBack);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case PDTConstants.EXIT:
				CoreFunctions.clickElement(driver, _buttonExit);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case PDTConstants.OK:
				CoreFunctions.clickElement(driver, _buttonOk);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
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
			CoreFunctions.writeToPropertiesFile("Assignment_ClientName",
					CoreFunctions.getElementText(driver, _textClientName));
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
			case PDTConstants.POLICY_STATUS:
				if ((CoreFunctions.isElementExist(driver, _textPolicyStatus, 2))
						&& ((CoreFunctions.getElementText(driver, _textPolicyStatus).replace("error", "").trim())
								.equals(expectedDefaultValue)))
					isFieldVerified = true;
				break;
			case COREFLEXConstants.POLICY_VERSION:
				if ((CoreFunctions.isElementExist(driver, _textPolicyVersion, 2))
						&& (CoreFunctions.getElementText(driver, _textPolicyVersion)).equals(expectedDefaultValue))
					isFieldVerified = true;
				break;
			case PDTConstants.CORE_FLEX_POLICY:
				if ((CoreFunctions.isElementExist(driver, _selectCoreFlexPolicyDefaultValue, 2))
						&& (CoreFunctions.getElementText(driver, _selectCoreFlexPolicyDefaultValue))
								.equals(expectedDefaultValue))
					isFieldVerified = true;
				break;
			case PDTConstants.TRACING_SET:
				if ((CoreFunctions.isElementExist(driver, _textTracingSet, 2))
						&& (CoreFunctions.getElementText(driver, _textTracingSet)).equals(expectedDefaultValue))
					isFieldVerified = true;
				break;
			case PDTConstants.POINTS_BASED_FLEX_POLICY:
				if ((CoreFunctions.isElementExist(driver, _textPointsBasedFlexPolicyDefaultValue, 2))
						&& (CoreFunctions.getElementText(driver, _textPointsBasedFlexPolicyDefaultValue))
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
				CoreFunctions.selectItemInListByText(driver, _selectPolicyTypeOptions, fieldSelection, true, fieldName);
				isFieldOptionSelected = true;
				break;
			case PDTConstants.EMPLOYEE_TYPE:
				CoreFunctions.clickElement(driver, _selectEmployeeType);
				CoreFunctions.selectItemInListByText(driver, _selectEmployeeTypeOptions, fieldSelection, true,
						fieldName);
				isFieldOptionSelected = true;
				break;
			case PDTConstants.HOMEOWNER_TYPE:
				CoreFunctions.clickElement(driver, _selectHomeownerType);
				CoreFunctions.selectItemInListByText(driver, _selectHomeownerTypeOptions, fieldSelection, true,
						fieldName);
				isFieldOptionSelected = true;
				break;
			case PDTConstants.CAPPED_POLICY:
				CoreFunctions.clickElement(driver, _selectCappedPolicyType);
				CoreFunctions.selectItemInListByText(driver, _selectCappedPolicyTypeOptions, fieldSelection, true,
						fieldName);
				isFieldOptionSelected = true;
				break;
			case COREFLEXConstants.EXPENSE_MANAGEMENT_CLIENT:
				BusinessFunctions.selectRadioAsPerLabelText(driver, _radioExpenseManagementTextList, fieldSelection);
				isFieldOptionSelected = true;
				break;
			case PDTConstants.BENEFIT_PACKAGE_TYPE:
				CoreFunctions.clickElement(driver, _selectBenefitPackageType);
				CoreFunctions.selectItemInListByText(driver, _selectBenefitPackageTypeOptions, fieldSelection, true,
						fieldName);
				isFieldOptionSelected = true;
				break;
			case PDTConstants.POINTS_BASED_FLEX_POLICY:
				CoreFunctions.clickElement(driver, _selectPointsBasedFlexPolicy);
				CoreFunctions.selectItemInListByText(driver, _selectPointsBasedFlexPolicyOptions, fieldSelection, true,
						fieldName);
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
	public boolean verifyPageNavigationBasedOnPointsBasedFlexPolicySelection(String pointsBasedFlexSelection,
			String expectedPageTitle, String expectedLeftNavigationTitle,
			CoreFlex_FlexPolicySetupPage flexPolicySetupPage,
			PDT_PolicyBenefitCategoryPage pdtPolicyBenefitCategoryPage) {

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
				actualPageTitle = pdtPolicyBenefitCategoryPage.getPageHeaderTitle();
				actualLeftNavigationTitle = pdtPolicyBenefitCategoryPage.getLeftNavigationPageTitle();
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

	public boolean verifyCappedPointBasedPolicyConditions() {
		boolean isCappedPointsBasedPolicyConditionsVerified = false;
		try {
			selectFieldOption(PDTConstants.CAPPED_POLICY, PDTConstants.NO);
			selectFieldOption(PDTConstants.POINTS_BASED_FLEX_POLICY, PDTConstants.YES);
			selectFieldOption(PDTConstants.CAPPED_POLICY, PDTConstants.YES);
			verifyCappedAndPointsBasedFlexPolicyErrorDialog();
			selectFieldOption(PDTConstants.POINTS_BASED_FLEX_POLICY, PDTConstants.NO);
			selectFieldOption(PDTConstants.CAPPED_POLICY, PDTConstants.PARTIALLY_CAPPED);
			selectFieldOption(PDTConstants.POINTS_BASED_FLEX_POLICY, PDTConstants.YES);
			verifyCappedAndPointsBasedFlexPolicyErrorDialog();
			selectFieldOption(PDTConstants.CAPPED_POLICY, PDTConstants.YES);
			selectFieldOption(PDTConstants.POINTS_BASED_FLEX_POLICY, PDTConstants.YES);
			verifyCappedAndPointsBasedFlexPolicyErrorDialog();
			isCappedPointsBasedPolicyConditionsVerified = true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CAPPED_AND_POINTS_BASED_FLEX_POLICY_ERROR_POPUP_ON_GENERAL_INFO,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isCappedPointsBasedPolicyConditionsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.SUCCESSFULLY_VERIFIED_CAPPED_AND_POINTS_BASED_FLEX_POLICY_ERROR_POPUP_ON_GENERAL_INFORMATION_PAGE,
					CoreConstants.PASS));
		}
		return isCappedPointsBasedPolicyConditionsVerified;
	}

	private void verifyCappedAndPointsBasedFlexPolicyErrorDialog() {
		if (CoreFunctions.isElementExist(driver, _cappedPolicyErrorDialogMessasgeText, 3)
				&& (CoreFunctions.getElementText(driver, _cappedPolicyErrorDialogMessasgeText)
						.equals(PDTConstants.CAPPED_POINTS_ERROR_DIALOG_TEXT))) {
			CoreFunctions.clickElement(driver, _cappedPolicyErrorDialogOKButton);
		} else {
			Assert.fail(PDTConstants.ERROR_DIALOG_NOT_DISPLAYED);
		}
	}

	/**
	 * Filling General Information Page Mandatory fields from JSON File
	 */
	public void fillOtherMandatoryFields() {
		selectFieldOption(PDTConstants.POLICY_TYPE, policySetupPageData.generalInformationPage.policyType);
		selectFieldOption(PDTConstants.EMPLOYEE_TYPE, policySetupPageData.generalInformationPage.employeeType);
		selectFieldOption(PDTConstants.HOMEOWNER_TYPE, policySetupPageData.generalInformationPage.homeownerType);
		selectFieldOption(PDTConstants.CAPPED_POLICY, policySetupPageData.generalInformationPage.cappedPolicy);
		selectFieldOption(COREFLEXConstants.EXPENSE_MANAGEMENT_CLIENT,
				policySetupPageData.generalInformationPage.expenseManagement);
//		CoreFunctions.clickElement(driver, _radioExpenseManagementNoOption);
	}

	/**
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		return CoreFunctions.verifyElementOnPage(driver, _headerGeneralInfo, COREFLEXConstants.GENERAL_INFORMATION,
				expectedPageName, expectedPageName, true);
	}

	public boolean verifyFieldDisabledPostVersioning(String fieldName) {
		boolean isFieldDisabled = false;
		try {
			switch (fieldName) {
			case PDTConstants.POINTS_BASED_FLEX_POLICY:
				if (CoreFunctions.isElementExist(driver, _fieldPointsBasedFlexPolicy, 2))
					isFieldDisabled = true;
				break;
			default:
				Reporter.addStepLog(MessageFormat.format(PDTConstants.INVALID_GENERAL_INFORMATION_FIELD,
						CoreConstants.FAIL, fieldName));
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_GENERAL_INFORMATION_FIELD_DISABLED_STATUS,
					CoreConstants.FAIL, fieldName, e.getMessage()));
		}
		if (isFieldDisabled) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_FIELD_DISABLED_ON_GENERAL_INFORMATION_PAGE,
					CoreConstants.PASS, fieldName));
		}
		return isFieldDisabled;
	}

	/**
	 * Filling General Information Page Mandatory fields post versioning to verify
	 * Page Editable Functionality
	 */
	public void fillOtherMandatoryFieldsPostVersioning() {
		selectFieldOption(PDTConstants.POLICY_TYPE,
				policySetupPageData.generalInformationPagePostVersioning.policyType);
		selectFieldOption(PDTConstants.EMPLOYEE_TYPE,
				policySetupPageData.generalInformationPagePostVersioning.employeeType);
		selectFieldOption(PDTConstants.HOMEOWNER_TYPE,
				policySetupPageData.generalInformationPagePostVersioning.homeownerType);
		selectFieldOption(PDTConstants.CAPPED_POLICY,
				policySetupPageData.generalInformationPagePostVersioning.cappedPolicy);
		CoreFunctions.clickElement(driver, _radioExpenseManagementNoOption);
	}

	public boolean verifyPolicyNumberAfterVersioning(PDT_ViewPolicyPage viewPolicyPage) {
		try {
			String expectedPolicyVersion = viewPolicyPage
					.getNextPolicyVersion(CoreFunctions.getPropertyFromConfig("CoreFlex_PolicyVersion"));
			if (CoreFunctions.getElementText(driver, _textPolicyVersion).equals(expectedPolicyVersion)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_VERSION_POST_VERSIONING_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.PASS, expectedPolicyVersion));
				CoreFunctions.writeToPropertiesFile("CoreFlex_PolicyVersion", expectedPolicyVersion);
				return true;
			} else {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_POLICY_VERSION_POST_VERSIONING_ON_GENERAL_INFORMATION_PAGE,
						CoreConstants.FAIL, CoreFunctions.getElementText(driver, _textPolicyVersion),
						expectedPolicyVersion));
				return false;
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_NUMBER_POST_VERSIONING_ON_GENERAL_INFORMATION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	public void navigatePolicyBenefitPage(String expectedPageName) {
		try {
			timeBeforeAction = new Date().getTime();
			CoreFunctions.clickUsingJS(driver, _btnNext, _btnNext.getText());
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction,
					PDTConstants.POLICY_BENEFIT_CATEGORIES);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_PAGE,
					PDTConstants.POLICY_BENEFIT_CATEGORIES, CoreConstants.FAIL));
		}
	}

	public void verifyGeneralInfoAndPolicyBenefitPage(PDT_PolicyBenefitCategoryPage policyBenefitCategoryPage) {
		Assert.assertTrue(verifyPageNavigation(PDTConstants.GENERAL_INFORMATION), MessageFormat
				.format(PDTConstants.FAILED_TO_NAVIGATE_TO_PAGE, PDTConstants.GENERAL_INFORMATION, CoreConstants.FAIL));
		navigatePolicyBenefitPage(PDTConstants.POLICY_BENEFIT);
		Assert.assertTrue(policyBenefitCategoryPage.verifyPolicyBenefitCategoryHeading(PDTConstants.POLICY_BENEFIT),
				MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL,
						PDTConstants.heading, PDTConstants.POLICY_BENEFIT_CATEGORIES, PDTConstants.POLICY_BENEFIT,
						policyBenefitCategoryPage.getElementText(PDTConstants.HEADING)));
		Assert.assertTrue(
				policyBenefitCategoryPage
						.verifyIsPolicyBenefitCategoryChecked(policyBenefitCategoryPage.getBenefitCategoryName()),
				MessageFormat.format(PDTConstants.BENEFIT_CATEGORY_IS_NOT_SELECTED, CoreConstants.FAIL,
						policyBenefitCategoryPage.getBenefitCategoryName()));
	}

	public boolean verifyGeneralInfoAdditionalPolicyDetails() {
		try {
			CoreFunctions.verifyText(driver, _textPolicyType, policySetupPageData.generalInformationPage.policyType,
					PDTConstants.POLICY_TYPE);
			CoreFunctions.verifyText(driver, _textEmployeeType, policySetupPageData.generalInformationPage.employeeType,
					PDTConstants.EMPLOYEE_TYPE);
			CoreFunctions.verifyText(driver, _textHomeownerType,
					policySetupPageData.generalInformationPage.homeownerType, PDTConstants.HOMEOWNER_TYPE);
			CoreFunctions.verifyText(driver, _textPointsBasedFlexPolicy, COREFLEXConstants.YES,
					PDTConstants.POINTS_BASED_FLEX_POLICY);

			CoreFunctions.verifyText(driver, _selectPolicyTypeValue,
					policySetupPageData.generalInformationPage.policyType, PDTConstants.POLICY_TYPE);
			CoreFunctions.verifyText(driver, _selectEmployeeTypeValue,
					policySetupPageData.generalInformationPage.employeeType, PDTConstants.EMPLOYEE_TYPE);
			CoreFunctions.verifyText(driver, _selectHomeownerTypeValue,
					policySetupPageData.generalInformationPage.homeownerType, PDTConstants.HOMEOWNER_TYPE);
			CoreFunctions.verifyText(driver, _selectCappedPolicyTypeValue,
					policySetupPageData.generalInformationPage.cappedPolicy, PDTConstants.CAPPED_POLICY);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioExpenseManagementTextList,
					_radioExpenseManagementButtonList, policySetupPageData.generalInformationPage.expenseManagement,
					COREFLEXConstants.EXPENSE_MANAGEMENT_CLIENT);
			return true;
		} catch (Exception e) {
			Assert.fail(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ADDITIONAL_POLICY_DETAILS,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}

	}

}
