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
import com.aires.businessrules.constants.COREFLEXConstants;
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

	// Logout Button
	@FindBy(how = How.XPATH, using = "//i[contains(text(),'exit_to_app')]")
	private WebElement _buttonLogout;

	// Back Button
	@FindBy(how = How.CSS, using = "button[class*='btn-back']")
	private WebElement _buttonBack;

	// Exit Button
	@FindBy(how = How.CSS, using = "button[class='btn-exit']")
	private WebElement _buttonExit;

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

	/**
	 * Generic Method to Click on an Element on a Page.
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
	 * Method to Verify AddNewPolicy Heading
	 * @param pageName
	 * @return
	 */
	public boolean verifyAddNewPolicyHeading(String pageName) {
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		if (_headingAddNewPolicyForm.getText().equalsIgnoreCase(PDTConstants.ADD_NEW_POLICY_FORM)) {
			CoreFunctions.highlightObject(driver, _headingAddNewPolicyForm);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_HEADING_ON_PAGE, CoreConstants.PASS,
					_headingAddNewPolicyForm.getText(), pageName));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL,
				pageName, PDTConstants.ADD_NEW_POLICY_FORM, _headingAddNewPolicyForm.getText()));
		return false;
	}

	/**
	 * Method to enter value in ClientID field
	 * @param inputValue
	 */
	public void enterClientID(String inputValue) {
		CoreFunctions.clearAndSetText(driver, _inputClientID, inputValue);
	}

	/**
	 * Method to Verify Client ID dropdown options with ID & Name 
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
	 * Getter Method to return Selected Policy Name
	 * 
	 * @return
	 */
	public String getSelectedPolicyName() {
		return selectedPolicyName;
	}

	/**
	 * Setter method to trim Policy ID and set Policy Name
	 * 
	 * @param policyName
	 */
	public void setSelectedPolicyName(String policyName) {
		if (policyName.contains("(#")) {
			String[] splittedPolicyName = policyName.split("\\(");
			policyName = splittedPolicyName[0].trim();
		}
		selectedPolicyName = policyName;
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
				CoreFunctions.selectItemInListByText(driver, _optionsPolicyName, policyName,true);
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
}
