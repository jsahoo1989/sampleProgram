package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
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
import com.aires.testdatatypes.pdt.PDT_LoginInfo;
import com.aires.utilities.ClientPolicyDetails;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

public class PDT_AddNewPolicyPage extends Base {

	public PDT_AddNewPolicyPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Add New Policy Forms
	@FindBy(how = How.CSS, using = "h4.mylo-card-title")
	private WebElement _headingAddNewPolicyForm;

	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr.foreground-closing")
	private WebElement _progressBar;

	// ClientID Input Field
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Client ID')]/following-sibling::ng-select//input")
	private WebElement _inputClientID;

	// Client Option
	@FindBy(how = How.CSS, using = "div[class='ng-option ng-option-marked'] > span")
	private WebElement _optionClientID;

	// ClientID Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Client ID')]/following-sibling::ng-select/descendant::div[@role='option']/span")
	private List<WebElement> _optionsClientID;

	// Policy Name Select Field
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Policy Name')]/following-sibling::ng-select")
	private WebElement _selectPolicyName;

	// Policy Name Options
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Policy Name')]/following-sibling::ng-select/descendant::div[@role='option']")
	private List<WebElement> _optionsPolicyName;

	// Error Pop-Up Box
	@FindBy(how = How.XPATH, using = "//div[@class='swal2-header']/h2[contains(text(),'Error')]")
	private WebElement _popUpError;

	// Error Pop-Up Message
	@FindBy(how = How.CSS, using = "div[id='swal2-content']")
	private WebElement _popUpErrorMessage;

	// Error Pop-Up OK Button
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _buttonPopUpErrorOk;

	// Next Button
	@FindBy(how = How.CSS, using = "button.btn-next")
	private WebElement _buttonNext;

	// Logout Button
	@FindBy(how = How.XPATH, using = "//i[contains(text(),'exit_to_app')]")
	private WebElement _buttonLogout;

	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Policy Name')]/following-sibling::ng-select//input")
	private WebElement _inputPolicyName;

	@FindBy(how = How.XPATH, using = "//label[text()='Policy Name']")
	private WebElement _lblPolicyName;

	@FindBy(how = How.CSS, using = "div.ng-option-disabled")
	private WebElement _policyLoader;
	// Back Button
	@FindBy(how = How.CSS, using = "button[class*='btn-back']")
	private WebElement _buttonBack;
	// Exit Button
	@FindBy(how = How.CSS, using = "button[class='btn-exit']")
	private WebElement _buttonExit;

	@FindBy(how = How.CSS, using = "ng-select[bindvalue='corporationPolicyId'] span.ng-value-label")
	private WebElement _selectedPolicy;

	@FindBy(how = How.CSS, using = "ng-select[bindvalue='corporationPolicyId'] input")
	private WebElement _inputPolicy;

	final By _buttonNextByLocator = By.cssSelector("button.btn-next");

	// ClientID Select Field
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Client ID')]/following-sibling::ng-select")
	private WebElement _selectClientID;

	// Policy Name Field Default Text
	@FindBy(how = How.XPATH, using = "//ng-select[@bindvalue='corporationPolicyId']//div[@class='ng-placeholder'][contains(text(),'No policy available for selection')]")
	private WebElement _policyNameDefaultText;

	private PDT_LoginInfo _loginInfo = FileReaderManager.getInstance().getJsonReader()
			.getLoginByEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase());
//	private PDT_LoginInfo _loginInfo = FileReaderManager.getInstance().getJsonReader().getLoginByEnvt(System.getProperty("envt").toLowerCase());

	public static String selectedPolicyName;
	long timeBeforeAction, timeAfterAction;

	LinkedHashMap<String, WebElement> webElementsMap = new LinkedHashMap<String, WebElement>();

	public void initWebElementsMap() {
		webElementsMap.put(PDTConstants.HEADING, _headingAddNewPolicyForm);
		webElementsMap.put(PDTConstants.POLICY, _selectedPolicy);
	}

	public void waitForProgressBarToDisappear() {
		try {
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_WAIT_PROGRESS_BAR, CoreConstants.FAIL));
		}
	}

	public String getElementText(String elementName) {
		String elementText = null;
		initWebElementsMap();
		try {
			elementText = CoreFunctions.getElementText(driver, webElementsMap.get(elementName));
		} catch (Exception e) {
			Assert.fail(
					MessageFormat.format(PDTConstants.FAIL_TO_GET_TEXT_FOR_ELEMENT, CoreConstants.FAIL, elementName));
		}
		return elementText;
	}

	public boolean verifyAddNewPolicyHeading(String pageName) {
//		waitForProgressBarToDisappear();
		if (!CoreFunctions.verifyElementOnPage(driver, _headingAddNewPolicyForm, PDTConstants.heading,
				PDTConstants.ADD_NEW_POLICY_FORM, pageName, true))
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL,
					PDTConstants.ADD_NEW_POLICY, PDTConstants.ADD_NEW_POLICY_FORM,
					getElementText(PDTConstants.HEADING)));
		return CoreFunctions.verifyElementOnPage(driver, _headingAddNewPolicyForm, PDTConstants.heading,
				PDTConstants.ADD_NEW_POLICY_FORM, pageName, true);
	}

	public void enterClientID(String inputValue) {
		CoreFunctions.clearAndSetText(driver, _inputClientID, inputValue);
	}

	public boolean verifyValidClientIDResult(String inputValue) {
		boolean isResultValid = false;

		try {
			if (_optionsClientID.size() > 0) {
				isResultValid = verifyClientIDOptions(inputValue);
				CoreFunctions.clickElement(driver, _optionClientID);

			} else {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.CLIENT_OPTIONS_NOT_DISPLAYED_FOR_VALID_CLIENTID,
						CoreConstants.FAIL, inputValue));
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CLIENT_OPTIONS_FOR_VALID_CLIENTID,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isResultValid) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.SUCCESSFULLY_VERIFIED_CLIENT_OPTIONS_FOR_VALID_CLIENTID,
							CoreConstants.PASS, inputValue));
		}

		return isResultValid;
	}

	private boolean verifyClientIDOptions(String inputValue) {

		boolean isOptionsValid = false;

		for (WebElement element : _optionsClientID) {

			String[] resultString = element.getText().split("#");

			if ((element.getText().startsWith(resultString[0].trim()))
					|| (element.getText().startsWith(resultString[1].trim()))) {
				isOptionsValid = true;
				continue;
			} else {
				isOptionsValid = false;
				break;
			}
		}

		return isOptionsValid;

	}

	public boolean verifyInvalidClientIDResult(String inputValue) {

		boolean clientIDResultDisplayed = false;

		try {

			if (CoreFunctions.getElementText(driver, _popUpErrorMessage).equals(PDTConstants.RECORD_DOES_NOT_EXIST)) {
				clientIDResultDisplayed = true;
				CoreFunctions.clickElement(driver, _buttonPopUpErrorOk);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.SUCCESSFULLY_VERIFIED_CLIENT_OPTIONS_FOR_INVALID_CLIENTID,
								CoreConstants.PASS, inputValue));
			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_INVALID_CLIENT_ERROR_POPUP,
							CoreConstants.FAIL, e.getMessage()));
		}

		return clientIDResultDisplayed;

	}

	public boolean validatePolicyNameList() {

		boolean isPolicyListDisplayed = false;

		try {

			if (CoreFunctions.isElementExist(driver, _popUpError, 2)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_VALID_CLIENTID,
						CoreConstants.FAIL, CoreFunctions.getElementText(driver, _popUpErrorMessage)));
				return false;
			} else if (CoreFunctions.isElementExist(driver, _selectPolicyName, 5)) {
				CoreFunctions.clickElement(driver, _selectPolicyName);
				isPolicyListDisplayed = verifyPoliciesAreDisplayed();
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_NAME_LIST,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isPolicyListDisplayed) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.SUCCESSFULLY_DISPLAYED_POLICIES_IN_POLICY_LIST,
					CoreConstants.PASS));
		}

		return isPolicyListDisplayed;

	}

	private boolean verifyPoliciesAreDisplayed() {

		if (_optionsPolicyName.size() > 0) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.POLICIES_ARE_DISPLAYED, CoreConstants.PASS,
					PDTConstants.ADD_NEW_POLICY_FORM));
			return true;
		}
		return false;
	}

	public boolean isPolicyNameDisplayed(String inputValue) {

		boolean isPolicyNameFieldDisplayed = false;

		try {

			if (CoreFunctions.isElementExist(driver, _selectPolicyName, 5)) {

				Reporter.addStepLog(MessageFormat.format(PDTConstants.POLICY_NAME_FIELD_DISPLAYED_FOR_INVALID_CLIENT,
						CoreConstants.FAIL, inputValue));
				isPolicyNameFieldDisplayed = true;
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_NAME_FIELD,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (!isPolicyNameFieldDisplayed) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.POLICY_NAME_FIELD_NOT_DISPLAYED_FOR_INVALID_CLIENT,
					CoreConstants.PASS, inputValue));
		}

		return isPolicyNameFieldDisplayed;

	}

	public boolean selectPolicy() {

		boolean isPolicySelected = false;

		try {

			if (CoreFunctions.isElementExist(driver, _popUpError, 2)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_VALID_CLIENTID,
						CoreConstants.FAIL, CoreFunctions.getElementText(driver, _popUpErrorMessage)));

			} else if (CoreFunctions.isElementExist(driver, _selectPolicyName, 5)) {
				CoreFunctions.clickElement(driver, _selectPolicyName);
				isPolicySelected = selectAnyPolicy();

			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_NAME_LIST,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isPolicySelected) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.SUCCESSFULLY_SELECTED_POLICY_FROM_POLICY_NAME_LIST,
					CoreConstants.PASS));
		}

		return isPolicySelected;

	}

	private boolean selectAnyPolicy() {

		try {
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _optionsPolicyName);
			selectedPolicyName = _optionsPolicyName.get(0).getText();
			CoreFunctions.selectItemInListByText(driver, _optionsPolicyName, selectedPolicyName);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_SELECTING_POLICY,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;

	}

	public String getSelectedPolicyName() {
		return selectedPolicyName;
	}

	public void clickNext() {
		CoreFunctions.clickElement(driver, _buttonNext);
	}

	public void clickLogout() {
		CoreFunctions.clickElement(driver, _buttonLogout);
	}

	public boolean selectVerifiedPolicy() {

		boolean isPolicySelected = false;

		try {

			if (CoreFunctions.isElementExist(driver, _popUpError, 2)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_VALID_CLIENTID,
						CoreConstants.FAIL, CoreFunctions.getElementText(driver, _popUpErrorMessage)));

			} else if (CoreFunctions.isElementExist(driver, _selectPolicyName, 5)) {
				CoreFunctions.clickElement(driver, _selectPolicyName);
				CoreFunctions.selectItemInListByText(driver, _optionsPolicyName, selectedPolicyName);
				isPolicySelected = true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_NAME_LIST,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isPolicySelected) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.SUCCESSFULLY_SELECTED_POLICY_FROM_POLICY_NAME_LIST,
					CoreConstants.PASS));
		}

		return isPolicySelected;

	}

	public void enterClientPolicyDetails(List<Map<String, String>> clientPolicyInfo) {
		selectClient(clientPolicyInfo);
		selectPolicy(clientPolicyInfo);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _buttonNext, "Next", 7);
		CoreFunctions.click(driver, _buttonNext, _buttonNext.getText());
	}

	public void enterClientPolicyDetails() {
		selectClient(_loginInfo.details.clientId);
		waitForProgressBarToDisappear();
		selectPolicy(_loginInfo.details.policy);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _buttonNext, "Next", 7);
		timeBeforeAction = new Date().getTime();
		CoreFunctions.click(driver, _buttonNext, _buttonNext.getText());
		waitForProgressBarToDisappear();
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction,
				PDTConstants.GENERAL_INFORMATION);
	}

	public void selectClient(String clientIdFromJson) {
		CoreFunctions.clearAndSetText(driver, _inputClientID, PDTConstants.CLIENT_ID, clientIdFromJson);
		CoreFunctions.explicitWaitTillElementListVisibilityCustomTime(driver, _optionsClientID, 90);
		CoreFunctions.explicitWaitTillElementListClickable(driver, _optionsClientID);
		if (_optionsClientID.size() > 0
				&& !_optionsClientID.get(0).getText().equalsIgnoreCase(PDTConstants.NO_ITEMS_FOUND)) {
			selectClientFromClientDropDown(clientIdFromJson, _loginInfo.details.clientName);
		} else if (checkErrorPopUpExistsForClientId()) {
			String errorMsg = _popUpErrorMessage.getText();
			CoreFunctions.clickElement(driver, _buttonPopUpErrorOk);
			Assert.fail(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_CLIENTID, CoreConstants.FAIL,
					clientIdFromJson, errorMsg));
		}
	}

	public void selectClient(List<Map<String, String>> clientPolicyInfo) {
		CoreFunctions.clearAndSetText(driver, _inputClientID, PDTConstants.CLIENT_ID,
				clientPolicyInfo.get(0).get("ClientId"));
		CoreFunctions.explicitWaitTillElementListVisibilityCustomTime(driver, _optionsClientID, 70);
		if (_optionsClientID.size() > 0
				&& !_optionsClientID.get(0).getText().equalsIgnoreCase(PDTConstants.NO_ITEMS_FOUND)) {
			selectClientFromClientDropDown(clientPolicyInfo.get(0).get("ClientId"),
					clientPolicyInfo.get(0).get("ClientName"));
		} else if (checkErrorPopUpExistsForClientId()) {
			String errorMsg = _popUpErrorMessage.getText();
			CoreFunctions.clickElement(driver, _buttonPopUpErrorOk);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_CLIENTID,
					CoreConstants.FAIL, clientPolicyInfo.get(0).get("ClientId"), errorMsg));
			Assert.fail(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_CLIENTID, CoreConstants.FAIL,
					clientPolicyInfo.get(0).get("ClientId"), errorMsg));
		}
	}

	public void selectPolicy(String policyFromJson) {
		String policyId;
		CoreFunctions.clickElement(driver, _selectPolicyName);
		CoreFunctions.clearAndSetText(driver, _inputPolicyName, PDTConstants.POLICY_NAME, policyFromJson);
		if (_optionsPolicyName.size() > 0
				&& !_optionsPolicyName.get(0).getText().equalsIgnoreCase(PDTConstants.NO_ITEMS_FOUND)) {
			CoreFunctions.selectItemInListByText(driver, _optionsPolicyName, policyFromJson, _lblPolicyName.getText(),
					PDTConstants.DROP_DOWN, true);
			policyId = policyFromJson.split("#")[1].trim();
			ClientPolicyDetails.setPolicyId((Integer.parseInt(policyId.substring(0, policyId.length() - 1))));
			ClientPolicyDetails.setPolicyName(policyFromJson);
		} else if (checkErrorPopUpExistsForPolicy(_loginInfo.details.clientId, policyFromJson)) {
			Assert.fail(MessageFormat.format(PDTConstants.POLICY_DOES_NOT_EXIST, CoreConstants.FAIL, policyFromJson,
					_loginInfo.details.clientId));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.POLICY_DOES_NOT_EXIST, CoreConstants.FAIL, policyFromJson,
					_loginInfo.details.clientId));
		}
	}

	public void selectPolicy(List<Map<String, String>> clientPolicyInfo) {
		String policyId;
		CoreFunctions.clickElement(driver, _selectPolicyName);
		CoreFunctions.clearAndSetText(driver, _inputPolicyName, PDTConstants.POLICY_NAME,
				clientPolicyInfo.get(0).get("PolicyName"));
		if (_optionsPolicyName.size() > 0
				&& !_optionsPolicyName.get(0).getText().equalsIgnoreCase(PDTConstants.NO_ITEMS_FOUND)) {
			CoreFunctions.selectItemInListByText(driver, _optionsPolicyName, clientPolicyInfo.get(0).get("PolicyName"),
					_lblPolicyName.getText(), PDTConstants.DROP_DOWN, true);
			ClientPolicyDetails.setPolicyName(clientPolicyInfo.get(0).get("PolicyName"));
			policyId = clientPolicyInfo.get(0).get("PolicyName").split("#")[1].trim();
			ClientPolicyDetails.setPolicyId(Integer.parseInt(policyId.substring(0, policyId.length() - 1)));
		} else if (checkErrorPopUpExistsForPolicy(clientPolicyInfo.get(0).get("ClientId"),
				clientPolicyInfo.get(0).get("PolicyName"))) {
			Assert.fail(MessageFormat.format(PDTConstants.POLICY_DOES_NOT_EXIST, CoreConstants.FAIL,
					clientPolicyInfo.get(0).get("PolicyName"), clientPolicyInfo.get(0).get("ClientId")));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.POLICY_DOES_NOT_EXIST, CoreConstants.FAIL,
					clientPolicyInfo.get(0).get("PolicyName"), clientPolicyInfo.get(0).get("ClientId")));
		}
	}

	public boolean checkErrorPopUpExistsForClientId() {
		return (CoreFunctions.isElementExist(driver, _popUpErrorMessage, 3)
				&& CoreFunctions.getElementText(driver, _popUpErrorMessage).equals(PDTConstants.RECORD_DOES_NOT_EXIST));
	}

	public boolean checkErrorPopUpExistsForPolicy(String clientId, String policyName) {
		if (CoreFunctions.isElementExist(driver, _popUpErrorMessage, 3) && CoreFunctions
				.getElementText(driver, _popUpErrorMessage).equals(PDTConstants.RECORD_DOES_NOT_EXIST)) {
			CoreFunctions.clickElement(driver, _buttonPopUpErrorOk);
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.POLICY_DOES_NOT_EXIST, CoreConstants.FAIL, clientId, policyName));
			return true;
		}
		return false;
	}

	public void selectClientFromClientDropDown(String clientId, String clientName) {
		try {
			for (WebElement element : _optionsClientID) {
				if (element.getText().contains(clientId) && element.getText().contains(clientName)) {
					CoreFunctions.clickElement(driver, element);
					ClientPolicyDetails.setClientId(clientId);
					ClientPolicyDetails.setClientName(clientName);
					CoreFunctions.writeToPropertiesFile("Policy_ClientID", clientId);
					CoreFunctions.writeToPropertiesFile("Policy_ClientName", clientName);
					Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_VALUE_SELECTED_FROM_DROPDWON,
							CoreConstants.PASS, PDTConstants.CLIENT_NAME, clientName));
					break;
				}
			}
		} catch (Exception e) {
			Assert.fail("Failed to search client :-" + clientName + "( " + clientId + " )");
		}
	}

	/****************** CoreFlex Page Methods ***************************/

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
			case PDTConstants.CLIENT_ID:
				CoreFunctions.clickElement(driver, _selectClientID);
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
	 * Method to Verify Client ID dropdown options with ID & Name
	 * 
	 * @param inputValue
	 * @return
	 */
	private boolean verifyClientIDDropDownOptions(String inputValue) {
		boolean isOptionsValid = false;
		for (WebElement element : _optionsClientID) {
			String[] resultString = element.getText().split("#");
			if ((element.getText().startsWith(resultString[0].trim()))
					|| (element.getText().startsWith(resultString[1].trim()))) {
				isOptionsValid = true;
				continue;
			} else {
				isOptionsValid = false;
				break;
			}
		}
		return isOptionsValid;
	}

	/**
	 * Method to fetch & return first available policy option
	 * 
	 * @return
	 */
	public String getFirstAvailablePolicyOption() {
		try {
			CoreFunctions.clickElement(driver, _selectPolicyName);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _optionsPolicyName);
			setSelectedPolicyName(_optionsPolicyName.get(0).getText());
			return getSelectedPolicyName();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_SELECTING_POLICY,
					CoreConstants.FAIL, e.getMessage()));
		}
		return null;
	}

	/**
	 * Setter method to trim Policy ID and set Policy Name
	 * 
	 * @param policyName
	 */
	public void setSelectedPolicyName(String policyNameValue) {
		String policyNameOutput = null;
		if (policyNameValue.contains("(#")) {
			String[] splittedPolicyName = policyNameValue.split("\\(#");
			policyNameOutput = splittedPolicyName[0].trim();
			CoreFunctions.writeToPropertiesFile("Assignment_Policy", policyNameOutput);
			selectedPolicyName = policyNameOutput;
		}
		selectedPolicyName = policyNameOutput;
	}

	/**
	 * Method to select a policy based on provided Policy Name
	 * 
	 * @param policyName
	 * @return
	 */
	public boolean selectAPolicy(String policyName) {
		try {
			if (CoreFunctions.isElementExist(driver, _selectPolicyName, 5)) {
				CoreFunctions.clickElement(driver, _selectPolicyName);
				CoreFunctions.selectItemInListByText(driver, _optionsPolicyName, policyName, true);
				return true;
			} else if (CoreFunctions.isElementExist(driver, _popUpError, 2)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_VALID_CLIENTID,
						CoreConstants.FAIL, CoreFunctions.getElementText(driver, _popUpErrorMessage)));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_NAME_FIELD,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	/**
	 * Method to verify Policy name is displayed or not based on Valid/Invalid
	 * ClientID input
	 * 
	 * @param fieldName
	 * @param dataValidity
	 * @param clientID
	 * @return
	 */
	public boolean verifyPolicyNameField(String fieldName, String dataValidity, String clientID) {
		try {
			switch (dataValidity) {
			case PDTConstants.VALID:
				verifyAndClickValidClientIDResult(clientID);
				if (CoreFunctions.isElementExist(driver, _selectPolicyName, 5)) {
					Reporter.addStepLog(MessageFormat.format(PDTConstants.SUCCESSFULLY_DISPLAYED_POLICY_NAME_FIELD,
							CoreConstants.PASS, clientID));
					acceptPoliciesNotAvailablePopUpDialogIfExist(clientID);
					return true;
				}
				break;
			case PDTConstants.INVALID:
				CoreFunctions.explicitWaitTillElementVisibility(driver, _popUpErrorMessage,
						PDTConstants.RECORD_DOES_NOT_EXIST);
				if (CoreFunctions.getElementText(driver, _popUpErrorMessage)
						.equals(PDTConstants.RECORD_DOES_NOT_EXIST)) {
					CoreFunctions.clickElement(driver, _buttonPopUpErrorOk);
					Reporter.addStepLog(MessageFormat.format(
							PDTConstants.SUCCESSFULLY_DISPLAYED_RECORD_DOES_NOT_EXIST_ERROR_POP_UP_FOR_INVALID_CLIENTID,
							CoreConstants.PASS, CoreFunctions.getElementText(driver, _popUpErrorMessage), clientID));
					return true;
				}
				break;
			default:
				Assert.fail(PDTConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_NAME_FIELD,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	/**
	 * Method to validate 'CORPORATION_POLICY_DOES_NOT_EXIST' pop-up message if
	 * Policies are not available for Valid ClientID
	 * 
	 * @param clientID
	 */
	private void acceptPoliciesNotAvailablePopUpDialogIfExist(String clientID) {
		if (CoreFunctions.isElementExist(driver, _popUpErrorMessage, 1)) {
			if (CoreFunctions.getElementText(driver, _popUpErrorMessage)
					.equals(PDTConstants.CORPORATION_POLICY_DOES_NOT_EXIST)) {
				CoreFunctions.clickElement(driver, _buttonPopUpErrorOk);
				Reporter.addStepLog(MessageFormat.format(
						PDTConstants.CORPORATION_POLICIES_NOT_AVAILABLE_FOR_VALID_CLIENTID, CoreConstants.PASS,
						CoreFunctions.getElementText(driver, _popUpErrorMessage), clientID));
			}
		}
	}

	/**
	 * Method to verify and click Client ID Option for valid Client
	 * 
	 * @param inputValue
	 * @return
	 */
	public boolean verifyAndClickValidClientIDResult(String inputValue) {
		try {
			if ((_optionsClientID.size() > 0) && (verifyClientIDDropDownOptions(inputValue))) {
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.SUCCESSFULLY_VERIFIED_CLIENT_OPTIONS_FOR_VALID_CLIENTID,
								CoreConstants.PASS, inputValue));
				CoreFunctions.clickElement(driver, _optionClientID);
				return true;
			} else {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.CLIENT_OPTIONS_NOT_DISPLAYED_FOR_VALID_CLIENTID,
						CoreConstants.FAIL, inputValue));
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CLIENT_OPTIONS_FOR_VALID_CLIENTID,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public void selectClient(String clientId, String clientName) {
		CoreFunctions.clearAndSetText(driver, _inputClientID, PDTConstants.CLIENT_ID, clientId);
		CoreFunctions.explicitWaitTillElementListVisibilityCustomTime(driver, _optionsClientID, 70);
		if (_optionsClientID.size() > 0
				&& !_optionsClientID.get(0).getText().equalsIgnoreCase(PDTConstants.NO_ITEMS_FOUND)) {
			selectClientFromClientDropDown(clientId, clientName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
		} else if (checkErrorPopUpExistsForClientId()) {
			String errorMsg = _popUpErrorMessage.getText();
			CoreFunctions.clickElement(driver, _buttonPopUpErrorOk);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_CLIENTID,
					CoreConstants.FAIL, clientId, errorMsg));
			Assert.fail(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_CLIENTID, CoreConstants.FAIL,
					clientId, errorMsg));
		}
	}

	public void selectPolicyName(String policyName) {
		String policyId;
		String clientIdFromJson = _loginInfo.details.clientId;
		CoreFunctions.clickElement(driver, _selectPolicyName);
		CoreFunctions.clearAndSetText(driver, _inputPolicyName, PDTConstants.POLICY_NAME, policyName);
		if (_optionsPolicyName.size() > 0
				&& !_optionsPolicyName.get(0).getText().equalsIgnoreCase(PDTConstants.NO_ITEMS_FOUND)) {
			CoreFunctions.selectItemInListByText(driver, _optionsPolicyName, policyName, _lblPolicyName.getText(),
					PDTConstants.DROP_DOWN, true);
			ClientPolicyDetails.setPolicyName(_selectedPolicy.getText());
			policyId = _selectedPolicy.getText().split("#")[1].trim();
			Log.info("policyId=" + policyId);
			ClientPolicyDetails.setPolicyId(Integer.parseInt(policyId.substring(0, policyId.length() - 1)));
		} else if (checkErrorPopUpExistsForPolicy(clientIdFromJson, policyName)) {
			Assert.fail(MessageFormat.format(PDTConstants.POLICY_DOES_NOT_EXIST, CoreConstants.FAIL, policyName,
					clientIdFromJson));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.POLICY_DOES_NOT_EXIST, CoreConstants.FAIL, policyName,
					clientIdFromJson));
		}
	}

	public boolean verifyPolicyName(String policyName) {
		try {
			Log.info("selected Policy==" + _selectedPolicy.getText());
			if (_selectedPolicy.getText().contains(policyName)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_POLICY_DISPLAYED, CoreConstants.PASS,
						_selectedPolicy.getText()));
				return true;
			}
		} catch (Exception e) {
			Assert.fail("Exception occured while getting policy name");
		}
		return false;
	}

	public boolean selectFirstAvailableClientID() {
		try {
			String clientIDValue[] = null;
			CoreFunctions.clickElement(driver, _inputClientID);
			for (int i = 0; i < _optionsClientID.size(); i++) {

				if (_optionsClientID.get(i).getText().contains("49211")
						|| _optionsClientID.get(i).getText().contains("97402")
						|| _optionsClientID.get(i).getText().contains("94941")
						|| _optionsClientID.get(i).getText().contains("84243"))
					continue;
				else {
					CoreFunctions.clickElement(driver, _optionsClientID.get(i));
					CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
					if (CoreFunctions.isElementExist(driver, _policyNameDefaultText, 2)) {
						CoreFunctions.clickElement(driver, _inputClientID);
						continue;
					}
					CoreFunctions.clickElement(driver, _inputClientID);
					CoreFunctions.explicitWaitTillElementListVisibility(driver, _optionsClientID);
					clientIDValue = _optionsClientID.get(i).getText().split("#");
					CoreFunctions.clickElement(driver, _optionsClientID.get(i));
					CoreFunctions.writeToPropertiesFile("Policy_ClientID", (clientIDValue[1].replace(")", "").trim()));
					return true;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_SELECTING_CLIENTID,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	/**
	 * Method to select a policy with Text Automation in Policy Name - To make sure
	 * other Team Members don't update Automation Policy during execution
	 * 
	 * @param policyName
	 * @return
	 */
	public boolean selectAutomationPolicy() {
		try {
			if (CoreFunctions.isElementExist(driver, _selectPolicyName, 5)) {
				CoreFunctions.clickElement(driver, _selectPolicyName);
				CoreFunctions.clearAndSetText(driver, _inputPolicy, COREFLEXConstants.AUTOMATION_POLICY);
				CoreFunctions.explicitWaitTillElementListVisibility(driver, _optionsPolicyName);
				setSelectedPolicyName(_optionsPolicyName.get(0).getText());
				CoreFunctions.selectItemInListByText(driver, _optionsPolicyName, _optionsPolicyName.get(0).getText(),
						true);
				return true;
			} else if (CoreFunctions.isElementExist(driver, _popUpError, 2)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_VALID_CLIENTID,
						CoreConstants.FAIL, CoreFunctions.getElementText(driver, _popUpErrorMessage)));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_NAME_FIELD,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyAutomationPolicyPresent() {
		try {
			if (CoreFunctions.isElementExist(driver, _selectPolicyName, 10)) {
				CoreFunctions.clickElement(driver, _selectPolicyName);
				CoreFunctions.clearAndSetText(driver, _inputPolicy, COREFLEXConstants.AUTOMATION_POLICY);
				CoreFunctions.explicitWaitTillElementListVisibility(driver, _optionsPolicyName);
				return (_optionsPolicyName.size() >= 3) ? true : false;

			} else if (CoreFunctions.isElementExist(driver, _popUpError, 2)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_VALID_CLIENTID,
						CoreConstants.FAIL, CoreFunctions.getElementText(driver, _popUpErrorMessage)));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_NAME_FIELD,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}
}