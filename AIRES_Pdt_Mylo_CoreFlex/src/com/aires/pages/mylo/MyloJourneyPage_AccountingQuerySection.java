package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import cucumber.api.DataTable;

public class MyloJourneyPage_AccountingQuerySection extends Base {

	public MyloJourneyPage_AccountingQuerySection(WebDriver driver) {
		super(driver);
	}

	// WebElements related to Accounting Query section

	@FindBy(how = How.CSS, using = "input[formcontrolname='assignmentId']")
	private WebElement _assignmentId;

	@FindBy(how = How.CSS, using = "input[formcontrolname='transfereeFirstName']")
	private WebElement _tFName;

	@FindBy(how = How.CSS, using = "input[formcontrolname='transfereeLastName']")
	private WebElement _tLName;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='assignmentServiceCode']")
	private WebElement _service;

	@FindBy(how = How.CSS, using = "input[formcontrolname='subServiceId']")
	private WebElement _subServiceId;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='serviceStatusCode']")
	private WebElement _serviceStatusCode;

	@FindBy(how = How.CSS, using = "input[formcontrolname='trackingNumber']")
	private WebElement _trackingNumber;

	@FindBy(how = How.CSS, using = "input[formcontrolname='transactionId']")
	private WebElement _transactionId;

	@FindBy(how = How.CSS, using = "input[formcontrolname='financialId']")
	private WebElement _financialId;
	
	@FindBy(how = How.CSS, using = "button[type='submit']")
	private WebElement _executeButton;

	// WebElements related to Accounting Origin Address section

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='origCountryCode']")
	private WebElement _orgCountry;

	@FindBy(how = How.CSS, using = "input[formcontrolname='origStreetAddr1']")
	private WebElement _orgStreetAddress1;

	@FindBy(how = How.CSS, using = "input[formcontrolname='origStreetAddr2']")
	private WebElement _orgStreetAddress2;

	@FindBy(how = How.CSS, using = "input[formcontrolname='origCity']")
	private WebElement _orgCity;

	@FindBy(how = How.CSS, using = "input[formcontrolname='origZipCode']")
	private WebElement _orgZipCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='origStateCode']")
	private WebElement _orgStateDropdown;

	@FindBy(how = How.CSS, using = "input[formcontrolname='origProvince']")
	private WebElement _orgStateText;
	
	@FindBy(how = How.XPATH, using = "//button[text()=' Origin Address ']")
	private WebElement _orgAddressTab;

	// WebElements related to Accounting Destination Address section

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='destCountryCode']")
	private WebElement _destCountry;

	@FindBy(how = How.CSS, using = "input[formcontrolname='destStreetAddr1']")
	private WebElement _destStreetAddress1;

	@FindBy(how = How.CSS, using = "input[formcontrolname='destStreetAddr2']")
	private WebElement _destStreetAddress2;

	@FindBy(how = How.CSS, using = "input[formcontrolname='destCity']")
	private WebElement _destCity;

	@FindBy(how = How.CSS, using = "input[formcontrolname='destZipCode']")
	private WebElement _destZipCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='destStateCode']")
	private WebElement _destStateDropdown;

	@FindBy(how = How.CSS, using = "input[formcontrolname='destProvince']")
	private WebElement _destStateText;
	
	@FindBy(how = How.XPATH, using = "//button[text()=' Destination Address ']")
	private WebElement _destAddressTab;
	
	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;
	
	@FindBy(how = How.CSS, using = "button[class*='toast-close-btn']")
	private WebElement _closeBtn;
	
	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;

	final By _dropdownOptions = By.xpath("//div[@role='option']/span");

	LinkedHashMap<String, WebElement> accountingQueryFieldMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> accountingFieldsUpdatedValueMap = new LinkedHashMap<String, String>();
	List<String> accountingQueryDropdownFields = Stream.of(MYLOConstants.SERVICE, MYLOConstants.SERVICE_STATUS,
			MYLOConstants.ORIGIN_ADDRESS_COUNTRY, MYLOConstants.ORIGIN_ADDRESS_STATE,
			MYLOConstants.DESTINATION_ADDRESS_COUNTRY, MYLOConstants.DESTINATION_ADDRESS_STATE)
			.collect(Collectors.toList());

	public void mapAccountingQueryInputFields() {
		accountingQueryFieldMap.put(MYLOConstants.ASSIGNMENT_ID, _assignmentId);
		accountingQueryFieldMap.put(MYLOConstants.TRANSFEREE_FIRSTNAME, _tFName);
		accountingQueryFieldMap.put(MYLOConstants.TRANSFEREE_LASTNAME, _tLName);
		accountingQueryFieldMap.put(MYLOConstants.SUB_SERVICE_ID, _subServiceId);
		accountingQueryFieldMap.put(MYLOConstants.TRACKING_NUMBER, _trackingNumber);
		accountingQueryFieldMap.put(MYLOConstants.TRANSACTION_ID, _transactionId);
		accountingQueryFieldMap.put(MYLOConstants.FINANCIAL_ID, _financialId);
		accountingQueryFieldMap.put(MYLOConstants.ORIGIN_ADDRESS_STREET1, _orgStreetAddress1);
		accountingQueryFieldMap.put(MYLOConstants.ORIGIN_ADDRESS_STREET2, _orgStreetAddress2);
		accountingQueryFieldMap.put(MYLOConstants.ORIGIN_ADDRESS_CITY, _orgCity);
		accountingQueryFieldMap.put(MYLOConstants.ORIGIN_ADDRESS_ZIPCODE, _orgZipCode);
		accountingQueryFieldMap.put(MYLOConstants.ORIGIN_ADDRESS_STATE_TEXT, _orgStateText);
		accountingQueryFieldMap.put(MYLOConstants.DESTINATION_ADDRESS_STREET1, _destStreetAddress1);
		accountingQueryFieldMap.put(MYLOConstants.DESTINATION_ADDRESS_STREET2, _destStreetAddress2);
		accountingQueryFieldMap.put(MYLOConstants.DESTINATION_ADDRESS_CITY, _destCity);
		accountingQueryFieldMap.put(MYLOConstants.DESTINATION_ADDRESS_ZIPCODE, _destZipCode);
		accountingQueryFieldMap.put(MYLOConstants.DESTINATION_ADDRESS_STATE_TEXT, _destStateText);
	}

	public void mapAccountingQueryDropdownFields() {
		accountingQueryFieldMap.put(MYLOConstants.SERVICE, _service);
		accountingQueryFieldMap.put(MYLOConstants.SERVICE_STATUS, _serviceStatusCode);
		accountingQueryFieldMap.put(MYLOConstants.ORIGIN_ADDRESS_COUNTRY, _orgCountry);
		accountingQueryFieldMap.put(MYLOConstants.ORIGIN_ADDRESS_STATE, _orgStateDropdown);
		accountingQueryFieldMap.put(MYLOConstants.DESTINATION_ADDRESS_COUNTRY, _destCountry);
		accountingQueryFieldMap.put(MYLOConstants.DESTINATION_ADDRESS_STATE, _destStateDropdown);
	}
	
	public void clickAddressTabsIfNeeded(String fieldName) {
		if (fieldName.contains(MYLOConstants.DESTINATION))
			CoreFunctions.click(driver, _destAddressTab, MYLOConstants.DESTINATION_ADDRESS);
		else if (fieldName.contains(MYLOConstants.ORIGIN))
			CoreFunctions.click(driver, _orgAddressTab, MYLOConstants.ORIGIN_ADDRESS);
	}
	
	public void clickExecuteButton() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _executeButton, _executeButton.getText(), 10);
			CoreFunctions.scrollClickUsingJS(driver, _executeButton, _executeButton.getText());
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.EXECUTE));
		}
	}
	
	public void clickToastMesssgeCloseIcon() {
		try {
			CoreFunctions.isElementVisible(_closeBtn);
			CoreFunctions.highlightObject(driver, _closeBtn);
			CoreFunctions.sendKeysUsingAction(driver, _closeBtn, MYLOConstants.CLOSE_BUTTON);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.CLOSE_BUTTON, MYLOConstants.OTHER, MYLOConstants.JOURNEY));
		}
	}
	
	public void setAccountQueryFieldValues(String fieldName, String fieldValue, String type) {
		String updatedValue = "";
		setCountryForStateTextField(fieldName, fieldValue);			
		updatedValue = (accountingQueryDropdownFields.contains(fieldName))?setAccountingDropdownValues(fieldName,fieldValue)
				:setAccountingInputValues(fieldName, fieldValue, type);
		accountingFieldsUpdatedValueMap.put(fieldName, updatedValue);
	}
	
	public void setCountryForStateTextField(String fieldName, String fieldValue) {
		if(fieldName.equals(MYLOConstants.ORIGIN_ADDRESS_STATE_TEXT))
			setCountry(MYLOConstants.ORIGIN_ADDRESS, fieldValue);
		else if(fieldName.equals(MYLOConstants.DESTINATION_ADDRESS_STATE_TEXT))
			setCountry(MYLOConstants.DESTINATION_ADDRESS, fieldValue);
	}
	
	public String setCountry(String fieldName, String fieldValue) {
		String updatedValue;
		List<String> valuesToIgnore = Stream.of(MYLOConstants.USA_STATE, MYLOConstants.INDIA_STATE,
				MYLOConstants.CANADA_STATE, MYLOConstants.SELECT_ONE).collect(Collectors.toList());
		WebElement _countryDropdown=(fieldName.contains(MYLOConstants.ORIGIN))?_orgCountry:_destCountry;
		CoreFunctions.click(driver, _countryDropdown, fieldName);
		List<WebElement> dropdownList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		updatedValue = (fieldValue.equals(MYLOConstants.RANDOM))
				? CoreFunctions.getRandomOutOfSelectedElementValueFromList(driver, dropdownList, valuesToIgnore)
				: fieldValue;
		BusinessFunctions.selectItemFromListUsingText(driver, dropdownList, updatedValue);
		accountingFieldsUpdatedValueMap.put(fieldName, updatedValue);
		return updatedValue;
	}
	
	public String setAccountingInputValues(String fieldName, String fieldValue,String type) {
		mapAccountingQueryInputFields();
		String updatedValue = "";
		try {
			CoreFunctions.scrollToElementUsingJS(driver, accountingQueryFieldMap.get(fieldName), fieldName);
			updatedValue=BusinessFunctions.setMyloInputFields(driver, fieldName, fieldValue,
					accountingQueryFieldMap.get(fieldName), type);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.ACCOUNTING_QUERY));
		}
		return updatedValue;
	}
	
	public String setAccountingDropdownValues(String fieldName, String fieldValue) {
		mapAccountingQueryDropdownFields();
		String updatedValue = "";
		try {
			WebElement element = accountingQueryFieldMap.get(fieldName);
			CoreFunctions.scrollToElementUsingJS(driver, accountingQueryFieldMap.get(fieldName), fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, fieldName, 100);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			updatedValue = BusinessFunctions.setMyloDropdownFields(driver, _dropdownOptions, fieldValue, fieldName);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.ACCOUNTING_QUERY));
		}
		return updatedValue;
	}	
	
	public void verifySpecialCharactersToastMessage(DataTable table) {	
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			String fieldName = data.get(MYLOConstants.FIELD_NAME);
			clickAddressTabsIfNeeded(fieldName);
			setAccountQueryFieldValues(fieldName, MYLOConstants.RANDOM, MYLOConstants.SPECIAL_CHARACTERS_STRING);
			clickExecuteButton();
			Assert.assertTrue(verifyToastMessage(data.get(MYLOConstants.MESSAGE)),
					MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL,
							data.get(MYLOConstants.MESSAGE), _alertMessage.getText(), MYLOConstants.JOURNEY));
			clickToastMesssgeCloseIcon();
			BusinessFunctions.setMyloInputFields(driver, fieldName, MYLOConstants.BLANK, accountingQueryFieldMap.get(fieldName), MYLOConstants.BLANK);
		}
	}
	
	public void setFieldValueAsPerCharacterLimit(DataTable table) {
		List<String> numberFields = Stream.of(MYLOConstants.ASSIGNMENT_ID, MYLOConstants.SUB_SERVICE_ID,
				MYLOConstants.TRACKING_NUMBER,MYLOConstants.TRANSACTION_ID,MYLOConstants.FINANCIAL_ID,MYLOConstants.ZIPCODE).collect(Collectors.toList());
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			String fieldName = data.get(MYLOConstants.FIELD_NAME);
			clickAddressTabsIfNeeded(fieldName);
			String type= (numberFields.contains(fieldName))?MYLOConstants.RANDOM_INTEGER:MYLOConstants.RANDOM_STRING;
			setAccountQueryFieldValues(fieldName,data.get(MYLOConstants.CHARACTER_LENGTH), type);
		}
	}
	
	public boolean verifyToastMessage(String msg) {
		boolean flag = false;
		flag = (BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, msg, MYLOConstants.ACCOUNTING_QUERY));
		return flag;
	}

}
