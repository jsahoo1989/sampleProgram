package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
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
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
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

	final By _buttonNextByLocator = By.cssSelector("button.btn-next");
	/************************************************************************/

	public static String selectedPolicyName;
	
	private String clientId, clientName, policyName;
	
	public void setClientId(String cId) {
		clientId = cId;
	}
	
	public void setClientName(String cName) {
		clientName = cName;
	}
	
	public void setPolicyName(String pName) {
		policyName = pName;
	}
	
	public String getClientId() {
		return clientId;
	}

	public String getClientName() {
		return clientName;
	}
	
	public String getPolicyName() {
		return policyName;
	}
	
	public String getElementText(String elementName) {
		String elementText = null;

		switch (elementName) {
		case PDTConstants.HEADING:
			elementText = _headingAddNewPolicyForm.getText();
			break;
		default:
			Assert.fail("Element not found");
		}
		return elementText;

	}

	public boolean verifyAddNewPolicyHeading(String pageName) {		
		return CoreFunctions.verifyElementOnPage(driver, _headingAddNewPolicyForm, PDTConstants.heading, PDTConstants.ADD_NEW_POLICY_FORM, pageName, true);
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
			Log.info("Policies are displayed");
			return true;
		}
		Log.info("Policies are not displayed");
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
	
	public void selectClient(List<Map<String, String>> clientPolicyInfo) {
		CoreFunctions.clearAndSetText(driver, _inputClientID, PDTConstants.CLIENT_ID, clientPolicyInfo.get(0).get("ClientId"));
		if(_optionsClientID.size() > 0 && !_optionsClientID.get(0).getText().equalsIgnoreCase(PDTConstants.NO_ITEMS_FOUND) ) {			
			selectClientFromClientDropDown(clientPolicyInfo.get(0).get("ClientId"), clientPolicyInfo.get(0).get("ClientName"));
		} else if(checkErrorPopUpExistsForClientId(clientPolicyInfo)) {
			String errorMsg = _popUpErrorMessage.getText();
			CoreFunctions.clickElement(driver, _buttonPopUpErrorOk);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_CLIENTID,
					CoreConstants.FAIL, clientPolicyInfo.get(0).get("ClientId"), errorMsg));
			Assert.fail(MessageFormat.format(PDTConstants.ERROR_POP_UP_DISPLAYED_FOR_CLIENTID,
					CoreConstants.FAIL, clientPolicyInfo.get(0).get("ClientId"), errorMsg));
		}
	}
	public void selectPolicy(List<Map<String, String>> clientPolicyInfo) {
		CoreFunctions.clickElement(driver, _selectPolicyName);
		CoreFunctions.clearAndSetText(driver, _inputPolicyName, PDTConstants.POLICY_NAME, clientPolicyInfo.get(0).get("PolicyName"));
		if(_optionsPolicyName.size() > 0 && !_optionsPolicyName.get(0).getText().equalsIgnoreCase(PDTConstants.NO_ITEMS_FOUND)) {			
			CoreFunctions.selectItemInListByText(driver, _optionsPolicyName, clientPolicyInfo.get(0).get("PolicyName"), true);
			setPolicyName(clientPolicyInfo.get(0).get("PolicyName"));
		} else if(checkErrorPopUpExistsForPolicy(clientPolicyInfo)) {			
			Assert.fail(MessageFormat.format(PDTConstants.CORPORATION_POLICY_DOES_NOT_EXIST,
					CoreConstants.FAIL, clientPolicyInfo.get(0).get("ClientId")));
		} else { 			
			Assert.fail(MessageFormat.format(PDTConstants.CORPORATION_POLICY_DOES_NOT_EXIST,
					CoreConstants.FAIL, clientPolicyInfo.get(0).get("ClientId")));
		} 
	}
	
	public boolean checkErrorPopUpExistsForClientId(List<Map<String, String>> clientPolicyInfo) {
		return (CoreFunctions.isElementExist(driver, _popUpErrorMessage, 3) && CoreFunctions.getElementText(driver, _popUpErrorMessage).equals(PDTConstants.RECORD_DOES_NOT_EXIST));
	}
	

	public boolean checkErrorPopUpExistsForPolicy(List<Map<String, String>> clientPolicyInfo) {
		if(CoreFunctions.isElementExist(driver, _popUpErrorMessage, 3) && CoreFunctions.getElementText(driver, _popUpErrorMessage).equals(PDTConstants.RECORD_DOES_NOT_EXIST)) {
			CoreFunctions.clickElement(driver, _buttonPopUpErrorOk);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.CORPORATION_POLICY_DOES_NOT_EXIST,
					CoreConstants.FAIL, clientPolicyInfo.get(0).get("ClientId")));
			return true;
		}
		return false;
	}
	
	public void selectClientFromClientDropDown(String clientId, String clientName) {
		boolean clientFound = false;
		try {
			for (WebElement element : _optionsClientID) {				
				if(element.getText().contains(clientId) && element.getText().contains(clientName)) {					
					CoreFunctions.clickElement(driver, element);
					setClientId(clientId);
					setClientName(clientName);
					clientFound = true;
					break;
				}
			}
		} catch(Exception e) {
			Assert.fail("Failed to search client :-"+clientName+"( "+clientId+" )");
		}		
	}
	

}
