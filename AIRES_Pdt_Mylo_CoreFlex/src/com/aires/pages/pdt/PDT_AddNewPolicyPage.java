package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.List;

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
	@FindBy(how = How.CSS, using = "button[class*='btn-next']")
	private WebElement _buttonNext;

	/************************************************************************/

	public static String selectedPolicyName;

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
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		if (_headingAddNewPolicyForm.getText().equalsIgnoreCase(PDTConstants.ADD_NEW_POLICY_FORM)) {
			CoreFunctions.highlightObject(driver, _headingAddNewPolicyForm);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_HEADING_ON_PAGE, CoreConstants.PASS,
					_headingAddNewPolicyForm.getText(), pageName));
			Log.info("Verified Heading");
			return true;
		}
		Log.info("Failed to verify Heading");
		Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL,
				pageName, PDTConstants.ADD_NEW_POLICY_FORM, _headingAddNewPolicyForm.getText()));
		return false;
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
		
		if(isPolicySelected) {
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

}
