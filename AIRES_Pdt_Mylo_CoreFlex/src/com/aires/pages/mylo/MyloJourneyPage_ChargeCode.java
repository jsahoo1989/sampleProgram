package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.utilities.CustomSoftAssert;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_ChargeCode extends Base {

	public MyloJourneyPage_ChargeCode(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Charge Codes']")
	private WebElement _chargeCodesButton;

	@FindBy(how = How.CSS, using = "button[class*='mylo-query-submit-btn']")
	private List<WebElement> _chargeCodeButtons;

	@FindBy(how = How.ID, using = "direct-tab")
	private WebElement _directChargeCodeTab;

	@FindBy(how = How.ID, using = "indirect-tab")
	private WebElement _inDirectChargeCodeTab;

	@FindBy(how = How.CSS, using = "mat-dialog-container[class*='mat-dialog']")
	private WebElement _chargeCodesPopup;

	@FindBy(how = How.CSS, using = "h5[class*='modal-title']")
	private WebElement _chargeCodesPopupHeader;

	@FindBy(how = How.XPATH, using = "//label[text()='Entity Code']/preceding-sibling::ng-select")
	private WebElement _entityCodeDropDown;

	@FindBy(how = How.CSS, using = "input[id='CostCenter']")
	private WebElement _costCenterInput;

	@FindBy(how = How.CSS, using = "input[id*='StartDate']")
	private WebElement _startDateInput;

	@FindBy(how = How.CSS, using = "input[id*='EndDate_0']")
	private WebElement _endDateInput;

	@FindBy(how = How.CSS, using = "input[id='Move']")
	private WebElement _percentMoveInput;

	@FindBy(how = How.XPATH, using = "//label[text()='Service Type']/preceding-sibling::ng-select")
	private WebElement _serviceTypeDropDown;

	@FindBy(how = How.XPATH, using = "//label[text()='FAR']/preceding-sibling::ng-select")
	private WebElement _farDropDown;

	@FindBy(how = How.XPATH, using = "//label[text()='GL Number']/preceding-sibling::ng-select")
	private WebElement _glNumberDropDown;

	@FindBy(how = How.CSS, using = "input[id='NetworkNumber']")
	private WebElement _networkNumberInput;

	@FindBy(how = How.CSS, using = "input[id*='ActivityCode']")
	private WebElement _activityCodeInput;

	@FindBy(how = How.CSS, using = "input[id*='WBS']")
	private WebElement _wbsInput;

	@FindBy(how = How.CSS, using = "input[id='ChargeCodenumberAuthorizer']")
	private WebElement _chargeCodeNumberInput;

	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;

	@FindBy(how = How.CSS, using = "div[role='alert']")
	private List<WebElement> _alertMessageList;

	@FindBy(how = How.CSS, using = "div[class*='modal-body'] div[class='row'] button")
	private WebElement _addChargeCodeButton;

	@FindBy(how = How.CSS, using = "div[class*='delete-icon']")
	private WebElement _deleteChargeCodeButton;

	@FindBy(how = How.CSS, using = "div[class*='modal-footer'] button")
	private WebElement _saveChargeCodeButton;

	@FindBy(how = How.CSS, using = "button[class*='toast-close-btn']")
	private WebElement _toastCloseButton;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	final By _dropdownOptions = By.cssSelector("div[role='option']>span");

	@FindBy(how = How.CSS, using = "div[role='option']>span")
	private List<WebElement> _dropdownOptionsElement;

	private boolean _isExists = false;

	LinkedHashMap<String, WebElement> chargeCodeWebElementsMap = new LinkedHashMap<String, WebElement>();

	/**
	 * Map all the New File section fields with there respective locators
	 */
	public void mapChargeCodeFields() {
		chargeCodeWebElementsMap.put(MYLOConstants.DIRECT_TAB, _directChargeCodeTab);
		chargeCodeWebElementsMap.put(MYLOConstants.INDIRECT_TAB, _inDirectChargeCodeTab);
		chargeCodeWebElementsMap.put(MYLOConstants.ENTITY_CODE, _entityCodeDropDown);
		chargeCodeWebElementsMap.put(MYLOConstants.COST_CENTER, _costCenterInput);
		chargeCodeWebElementsMap.put(MYLOConstants.START_DATE, _startDateInput);
		chargeCodeWebElementsMap.put(MYLOConstants.END_DATE, _endDateInput);
		chargeCodeWebElementsMap.put(MYLOConstants.PERCENTAGE_OF_MOVE, _percentMoveInput);
		chargeCodeWebElementsMap.put(MYLOConstants.SERVICE_TYPE, _serviceTypeDropDown);
		chargeCodeWebElementsMap.put(MYLOConstants.FAR, _farDropDown);
		chargeCodeWebElementsMap.put(MYLOConstants.GL_NUMBER, _glNumberDropDown);
		chargeCodeWebElementsMap.put(MYLOConstants.NETWORK_NUMBER, _networkNumberInput);
		chargeCodeWebElementsMap.put(MYLOConstants.ACTIVITY_CODE, _activityCodeInput);
		chargeCodeWebElementsMap.put(MYLOConstants.WBS, _wbsInput);
		chargeCodeWebElementsMap.put(MYLOConstants.CHARGE_CODE_NUMBER, _chargeCodeNumberInput);
		chargeCodeWebElementsMap.put(MYLOConstants.ADD_CHARGE_CODE_BUTTON, _addChargeCodeButton);
		chargeCodeWebElementsMap.put(MYLOConstants.DELETE_CHARGE_CODE_BUTTON, _deleteChargeCodeButton);
		chargeCodeWebElementsMap.put(MYLOConstants.SAVE_CHARGE_CODE_BUTTON, _saveChargeCodeButton);
		chargeCodeWebElementsMap.put(MYLOConstants.TOAST_CLOSE_BUTTON, _toastCloseButton);
	}

	/**
	 * Click charge code button
	 * 
	 */
	public void clickChargeCodeButton() {
		try {
			CoreFunctions.highlightElementAndClick(driver, _chargeCodesButton, MYLOConstants.CHARGE_CODES);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.CHARGE_CODES));
		}
	}

	/**
	 * Verify if Charge Codes popup is displayed
	 * 
	 * @return
	 */
	public void verifyChargeCodesPopupDisplayed() {
		try {
			if (CoreFunctions.isElementExist(driver, _chargeCodesPopup, MYLOConstants.CUSTOM_WAIT_TIME))
				Assert.assertTrue(
						CoreFunctions.getElementText(driver, _chargeCodesPopupHeader)
								.equals(MYLOConstants.CHARGE_CODES_HEADER),
						MessageFormat.format(MYLOConstants.CHARGE_CODES_HEADER, CoreConstants.FAIL));
			else
				Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						_chargeCodesPopup, MYLOConstants.CHARGE_CODES_POPUP));

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_chargeCodesPopup, MYLOConstants.CHARGE_CODES_POPUP));
		}
	}

	/**
	 * Click button in charge codes screen
	 * 
	 * @param buttonName
	 */
	public void clickButtonInChargeCodeDialog(String buttonName) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver, _chargeCodeButtons,
					buttonName, MYLOConstants.CLASS);
			CoreFunctions.highlightElementAndClick(driver, fieldElement, buttonName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, buttonName));
		}
	}

	public void verifyMandatoryFieldsToastMessagesChargeCodeSection(DataTable table, CustomSoftAssert _softAssert) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setChargeCodeDropdownValues(MYLOConstants.ENTITY_CODE, data.get(i).get("Entity Code"));
			setNewFileFields(MYLOConstants.COST_CENTER, data.get(i).get("Cost Center"), MYLOConstants.VALUE);
			setChargeCodeDateFields(MYLOConstants.START_DATE, data.get(i).get("Start Date"));
			setChargeCodeDateFields(MYLOConstants.END_DATE, data.get(i).get("End Date"));
			setNewFileFields(MYLOConstants.PERCENTAGE_OF_MOVE, data.get(i).get("Percentage Of Move"),
					MYLOConstants.VALUE);
			setChargeCodeDropdownValues(MYLOConstants.SERVICE_TYPE, data.get(i).get("Service Type"));
			setChargeCodeDropdownValues(MYLOConstants.FAR, data.get(i).get("FAR"));
			setChargeCodeDropdownValues(MYLOConstants.GL_NUMBER, data.get(i).get("GL Number"));
			setNewFileFields(MYLOConstants.NETWORK_NUMBER, data.get(i).get("Network Number"), MYLOConstants.VALUE);
			setNewFileFields(MYLOConstants.ACTIVITY_CODE, data.get(i).get("Activity code"), MYLOConstants.VALUE);
			setNewFileFields(MYLOConstants.CHARGE_CODE_NUMBER, data.get(i).get("Charge Code Number"),
					MYLOConstants.VALUE);
			clickFieldsOnChargeCodeSection(MYLOConstants.SAVE_CHARGE_CODE_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			_softAssert.assertTrue(CoreFunctions.searchElementExistsInListByText(driver, _alertMessageList,
					data.get(i).get("Message"), MYLOConstants.TRUE));
			/*
			 * _softAssert.assertTrue(BusinessFunctions.verifyMyloToastMessage(driver,
			 * _alertMessage, data.get(i).get("Message"),
			 * MYLOConstants.CHARGE_CODES_POPUP));
			 */
			clickFieldsOnChargeCodeSection(MYLOConstants.TOAST_CLOSE_BUTTON);
			clickFieldsOnChargeCodeSection(MYLOConstants.DELETE_CHARGE_CODE_BUTTON);
			clickFieldsOnChargeCodeSection(MYLOConstants.ADD_CHARGE_CODE_BUTTON);
		}

	}

	/**
	 * Set Input Fields for New File section based on the fieldName passed as a
	 * parameter
	 * 
	 * @param fieldName
	 * @param fieldValue
	 * @param type
	 */
	public void setNewFileFields(String fieldName, String fieldValue, String type) {
		mapChargeCodeFields();
		try {
			WebElement reqWebElement = chargeCodeWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			BusinessFunctions.setMyloInputFields(driver, fieldName, fieldValue, reqWebElement, type);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.CREATE_NEW_FILE));
		}
	}

	/**
	 * Set Dropdown Fields for New File section based on the fieldName passed as a
	 * parameter
	 * 
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 */
	public String setChargeCodeDropdownValues(String fieldName, String fieldValue) {
		clickFieldsOnChargeCodeSection(fieldName);
		String updatedValue = BusinessFunctions.setMyloDropdownFields(driver, _dropdownOptions, fieldValue, fieldName);
		return updatedValue;
	}

	/**
	 * Set Dropdown Fields for New File section based on the fieldName passed as a
	 * parameter
	 * 
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 */
	public void setChargeCodeFARGLDropdownValues(String fieldName, String fieldValue) {
		clickFieldsOnChargeCodeSection(fieldName);
		String updatedValue = "";
		try {
			if (fieldValue.equals(MYLOConstants.RANDOM)) {
				updatedValue = _dropdownOptionsElement.get(1).getText();
			} else
				updatedValue = fieldValue;
			BusinessFunctions.selectItemFromListUsingText(driver, _dropdownOptionsElement, updatedValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_SELECT_VALUE_FROM_DROPDOWN, CoreConstants.FAIL,
					fieldValue, fieldName));
		}
	}

	/**
	 * @param fieldName
	 * @param fieldValue
	 */
	public void setChargeCodeDateFields(String fieldName, String valueType) {
		clickFieldsOnChargeCodeSection(fieldName);
		WebElement reqWebElement = chargeCodeWebElementsMap.get(fieldName);
		String dateValue = (valueType.equals(MYLOConstants.CURRENT_DATE))
				? CoreFunctions.getCurrentDateAsGivenFormat("MM/dd/yyyy")
				: (valueType.equals(MYLOConstants.FUTURE_DATE)) ? CoreFunctions.addDaysInCurrentDate("MM/dd/yyyy", 2)
						: (valueType.equals(MYLOConstants.PAST_DATE))
								? CoreFunctions.subtractDaysInCurrentDate("MM/dd/yyyy", 2)
								: MYLOConstants.DATE_FORMART;
		CoreFunctions.clearAndSetText(driver, reqWebElement, dateValue);
	}

	public void clickFieldsOnChargeCodeSection(String fieldName) {
		mapChargeCodeFields();
		try {
			WebElement element = chargeCodeWebElementsMap.get(fieldName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			CoreFunctions.clickElement(driver, element);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.CHARGE_CODES));
		}
	}

	public boolean isElementExistOnPopUp(String fieldName) {
		mapChargeCodeFields();
		try {
			WebElement reqWebElement = chargeCodeWebElementsMap.get(fieldName);
			_isExists = CoreFunctions.isElementExist(driver, reqWebElement, MYLOConstants.CUSTOM_WAIT_TIME);
		} catch (Exception e) {
			_isExists = false;
		}
		return _isExists;
	}

	public boolean isElementHighlightedInRed(String fieldName) {
		mapChargeCodeFields();
		boolean flag = false;
		try {
			WebElement reqWebElement = chargeCodeWebElementsMap.get(fieldName);
			String hexColorValue = Color.fromString(reqWebElement.getCssValue(MYLOConstants.COLOR)).asHex();
			flag = (hexColorValue.equals(MYLOConstants.RED_COLOR_HEXCODE));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.CHARGE_CODES));
		}
		return flag;
	}

	public void enterRandomDataOnChargeCodeSection() {
		setChargeCodeDropdownValues(MYLOConstants.ENTITY_CODE, MYLOConstants.RANDOM);
		setNewFileFields(MYLOConstants.COST_CENTER, MYLOConstants.RANDOM_INTEGER, MYLOConstants.VALUE);
		setChargeCodeDateFields(MYLOConstants.START_DATE, MYLOConstants.CURRENT_DATE);
		setChargeCodeDateFields(MYLOConstants.END_DATE, MYLOConstants.FUTURE_DATE);
		setNewFileFields(MYLOConstants.PERCENTAGE_OF_MOVE, MYLOConstants.RANDOM_INTEGER, MYLOConstants.VALUE);
		setChargeCodeDropdownValues(MYLOConstants.SERVICE_TYPE, MYLOConstants.RANDOM);
		setChargeCodeFARGLDropdownValues(MYLOConstants.FAR, MYLOConstants.RANDOM);
		setChargeCodeFARGLDropdownValues(MYLOConstants.GL_NUMBER, MYLOConstants.RANDOM);
		setNewFileFields(MYLOConstants.NETWORK_NUMBER, MYLOConstants.RANDOM_INTEGER, MYLOConstants.VALUE);
		setNewFileFields(MYLOConstants.ACTIVITY_CODE, MYLOConstants.RANDOM_INTEGER, MYLOConstants.VALUE);
		setNewFileFields(MYLOConstants.CHARGE_CODE_NUMBER, MYLOConstants.RANDOM_INTEGER, MYLOConstants.VALUE);

	}

	public void enterRandomDataOnChargeCodeSectionForClient80023() {
		setChargeCodeDropdownValues(MYLOConstants.ENTITY_CODE, MYLOConstants.RANDOM);
		setNewFileFields(MYLOConstants.COST_CENTER, MYLOConstants.RANDOM_INTEGER, MYLOConstants.VALUE);
		setChargeCodeDateFields(MYLOConstants.START_DATE, MYLOConstants.CURRENT_DATE);
		setChargeCodeDateFields(MYLOConstants.END_DATE, MYLOConstants.FUTURE_DATE);
		setNewFileFields(MYLOConstants.PERCENTAGE_OF_MOVE, MYLOConstants.RANDOM_INTEGER, MYLOConstants.VALUE);
		setChargeCodeDropdownValues(MYLOConstants.SERVICE_TYPE, MYLOConstants.RANDOM);
		setChargeCodeFARGLDropdownValues(MYLOConstants.FAR, MYLOConstants.RANDOM);
		setChargeCodeFARGLDropdownValues(MYLOConstants.GL_NUMBER, MYLOConstants.RANDOM);
		setNewFileFields(MYLOConstants.NETWORK_NUMBER, MYLOConstants.RANDOM_INTEGER, MYLOConstants.VALUE);
		setNewFileFields(MYLOConstants.ACTIVITY_CODE, MYLOConstants.RANDOM_INTEGER, MYLOConstants.VALUE);
		setNewFileFields(MYLOConstants.CHARGE_CODE_NUMBER, MYLOConstants.RANDOM_INTEGER, MYLOConstants.VALUE);
		setNewFileFields(MYLOConstants.WBS, MYLOConstants.RANDOM_INTEGER, MYLOConstants.VALUE);

	}

	public void verifyMandatoryFieldsToastMessageForClient80023(DataTable table, CustomSoftAssert _softAssert,
			String message) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		setChargeCodeDropdownValues(MYLOConstants.ENTITY_CODE, data.get(0).get("Entity Code"));
		setNewFileFields(MYLOConstants.COST_CENTER, data.get(0).get("Cost Center"), MYLOConstants.VALUE);
		setChargeCodeDateFields(MYLOConstants.START_DATE, data.get(0).get("Start Date"));
		setChargeCodeDateFields(MYLOConstants.END_DATE, data.get(0).get("End Date"));
		setNewFileFields(MYLOConstants.PERCENTAGE_OF_MOVE, data.get(0).get("Percentage Of Move"), MYLOConstants.VALUE);
		setChargeCodeDropdownValues(MYLOConstants.SERVICE_TYPE, data.get(0).get("Service Type"));
		setChargeCodeFARGLDropdownValues(MYLOConstants.FAR, data.get(0).get("FAR"));
		setChargeCodeFARGLDropdownValues(MYLOConstants.GL_NUMBER, data.get(0).get("GL Number"));
		setNewFileFields(MYLOConstants.NETWORK_NUMBER, data.get(0).get("Network Number"), MYLOConstants.VALUE);
		setNewFileFields(MYLOConstants.ACTIVITY_CODE, data.get(0).get("Activity code"), MYLOConstants.VALUE);
		setNewFileFields(MYLOConstants.CHARGE_CODE_NUMBER, data.get(0).get("Charge Code Number"), MYLOConstants.VALUE);
		clickFieldsOnChargeCodeSection(MYLOConstants.SAVE_CHARGE_CODE_BUTTON);
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		_softAssert.assertTrue(
				CoreFunctions.searchElementExistsInListByText(driver, _alertMessageList, message, MYLOConstants.TRUE));
		/*
		 * _softAssert.assertTrue(BusinessFunctions.verifyMyloToastMessage(driver,
		 * _alertMessage, data.get(i).get("Message"),
		 * MYLOConstants.CHARGE_CODES_POPUP));
		 */
	}

	public boolean isCorrectToastMessageDisplayed(String message) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _alertMessage, "TostMessage");
		return BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, message,
				MYLOConstants.CHARGE_CODES_POPUP);

	}
}
