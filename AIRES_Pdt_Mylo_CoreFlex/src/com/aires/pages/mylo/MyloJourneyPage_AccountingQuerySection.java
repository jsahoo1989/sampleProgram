package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_AccountingQuerySection extends Base {

	public MyloJourneyPage_AccountingQuerySection(WebDriver driver) {
		super(driver);
	}

	// WebElements related to Accounting Query section

	@FindBy(how = How.CSS, using = "app-accounting-query")
	private WebElement _accountingQueryPopUp;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='assignmentId']")
	private WebElement _assignmentId;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='transfereeFirstName']")
	private WebElement _tFName;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='transfereeLastName']")
	private WebElement _tLName;

	@FindBy(how = How.CSS, using = "app-accounting-query ng-select[formcontrolname='assignmentServiceCode']")
	private WebElement _service;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='subServiceId']")
	private WebElement _subServiceId;

	@FindBy(how = How.CSS, using = "app-accounting-query ng-select[formcontrolname='serviceStatusCode']")
	private WebElement _serviceStatusCode;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='trackingNumber']")
	private WebElement _trackingNumber;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='transactionId']")
	private WebElement _transactionId;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='financialId']")
	private WebElement _financialId;

	@FindBy(how = How.CSS, using = "app-accounting-query button[type='submit']")
	private WebElement _executeButton;

	@FindBy(how = How.CSS, using = "app-accounting-query button[class='mylo-query-cancel-btn']")
	private WebElement _cancelButton;

	// WebElements related to Accounting Origin Address section

	@FindBy(how = How.CSS, using = "app-accounting-query ng-select[formcontrolname='origCountryCode']")
	private WebElement _orgCountry;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='origStreetAddr1']")
	private WebElement _orgStreetAddress1;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='origStreetAddr2']")
	private WebElement _orgStreetAddress2;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='origCity']")
	private WebElement _orgCity;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='origZipCode']")
	private WebElement _orgZipCode;

	@FindBy(how = How.CSS, using = "app-accounting-query ng-select[formcontrolname='origStateCode']")
	private WebElement _orgStateDropdown;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='origProvince']")
	private WebElement _orgStateText;

	@FindBy(how = How.XPATH, using = "//button[text()=' Origin Address ']")
	private WebElement _orgAddressTab;

	// WebElements related to Accounting Destination Address section

	@FindBy(how = How.CSS, using = "app-accounting-query ng-select[formcontrolname='destCountryCode']")
	private WebElement _destCountry;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='destStreetAddr1']")
	private WebElement _destStreetAddress1;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='destStreetAddr2']")
	private WebElement _destStreetAddress2;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='destCity']")
	private WebElement _destCity;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='destZipCode']")
	private WebElement _destZipCode;

	@FindBy(how = How.CSS, using = "app-accounting-query ng-select[formcontrolname='destStateCode']")
	private WebElement _destStateDropdown;

	@FindBy(how = How.CSS, using = "app-accounting-query input[formcontrolname='destProvince']")
	private WebElement _destStateText;

	@FindBy(how = How.XPATH, using = "//button[text()=' Destination Address ']")
	private WebElement _destAddressTab;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "button[class*='toast-close-btn']")
	private WebElement _closeBtn;

	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;

	@FindBy(how = How.CSS, using = "app-query-result")
	private WebElement _queryResultPopUp;

	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	private WebElement _OKButtonPopUp;

	@FindBy(how = How.CSS, using = ".errortext")
	private WebElement _errorPopUpText;
	
	@FindBy(how = How.CSS, using = "div[role='dialog']")
	private WebElement _popUp;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Query']")
	private WebElement _querySubSection;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Accounting']")
	private WebElement _accountingBtn;

	// Query Result Section

	@FindBy(how = How.XPATH, using = "//cdk-virtual-scroll-viewport//ul/li[1]")
	private List<WebElement> _resultingFileIDs;

	@FindBy(how = How.XPATH, using = "//cdk-virtual-scroll-viewport//ul/li[2]")
	private List<WebElement> _resultingClientNames;

	@FindBy(how = How.XPATH, using = "//cdk-virtual-scroll-viewport//ul/li[3]")
	private List<WebElement> _resultingTransfereeNames;

	@FindBy(how = How.XPATH, using = "//cdk-virtual-scroll-viewport//ul/li[6]")
	private List<WebElement> _resultingStatus;

	private final By _dropdownOptions = By.xpath("//div[@role='option']/span");
	private final By _queryResultFileIds = By.xpath("//ul[@class='ng-star-inserted']/li[1]");

	LinkedHashMap<String, WebElement> accountingQueryFieldMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> accountingFieldsUpdatedValueMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, List<WebElement>> queryResultWebElementsMap = new LinkedHashMap<String, List<WebElement>>();
	LinkedHashMap<String, String> databaseColNameMap = new LinkedHashMap<String, String>();

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

	/**
	 * Map all the Team Post buttons with there respective locators
	 */
	public void mapQueryResultColumnWebElements() {
		queryResultWebElementsMap.put(MYLOConstants.FILEID, _resultingFileIDs);
		queryResultWebElementsMap.put(MYLOConstants.CLIENTNAME, _resultingClientNames);
		queryResultWebElementsMap.put(MYLOConstants.TRANSFEREENAME, _resultingTransfereeNames);
		queryResultWebElementsMap.put(MYLOConstants.STATUS, _resultingStatus);
	}

	public void mapDatabaseColumnNames() {
		databaseColNameMap.put(MYLOConstants.CLIENT__NAME, MYLOConstants.CLIENTNAME);
		databaseColNameMap.put(MYLOConstants.FILE_ID, MYLOConstants.FILEID);
		databaseColNameMap.put(MYLOConstants.JOURNEY_TYPE, MYLOConstants.JOURNEYTYPE);
		databaseColNameMap.put(MYLOConstants.TRANSFEREE_NAME, MYLOConstants.TRANSFEREENAME);
		databaseColNameMap.put(MYLOConstants.ORIGIN, MYLOConstants.ORIGIN);
		databaseColNameMap.put(MYLOConstants.DESTINATION, MYLOConstants.DESTINATION);
		databaseColNameMap.put(MYLOConstants.BOOKED, MYLOConstants.BOOKED);
		databaseColNameMap.put(MYLOConstants.STATUS, MYLOConstants.STATUS);
	}

	public void clickAddressTabsIfNeeded(String fieldName) {
		if (fieldName.contains(MYLOConstants.DESTINATION))
			CoreFunctions.click(driver, _destAddressTab, MYLOConstants.DESTINATION_ADDRESS);
		else if (fieldName.contains(MYLOConstants.ORIGIN))
			CoreFunctions.click(driver, _orgAddressTab, MYLOConstants.ORIGIN_ADDRESS);
	}

	public void clickButtonsOnAccountingQuerySection(String btnName) {
		try {
			WebElement element = (btnName.equals(MYLOConstants.EXECUTE)) ? _executeButton : _cancelButton;
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, element.getText(), 10);
			CoreFunctions.scrollClickUsingJS(driver, element, element.getText());
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, btnName));
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
		setCountryForStateTextField(fieldName, MYLOConstants.RANDOM);
		updatedValue = (accountingQueryDropdownFields.contains(fieldName))
				? setAccountingDropdownValues(fieldName, fieldValue)
				: setAccountingInputValues(fieldName, fieldValue, type);
		accountingFieldsUpdatedValueMap.put(fieldName, updatedValue);
	}

	public void setCountryForStateTextField(String fieldName, String fieldValue) {
		if (fieldName.equals(MYLOConstants.ORIGIN_ADDRESS_STATE_TEXT))
			setCountry(MYLOConstants.ORIGIN_ADDRESS, fieldValue);
		else if (fieldName.equals(MYLOConstants.DESTINATION_ADDRESS_STATE_TEXT))
			setCountry(MYLOConstants.DESTINATION_ADDRESS, fieldValue);
	}

	public String setCountry(String fieldName, String fieldValue) {
		String updatedValue;
		List<String> valuesToIgnore = Stream.of(MYLOConstants.USA_STATE, MYLOConstants.INDIA_STATE,
				MYLOConstants.CANADA_STATE, MYLOConstants.SELECT_ONE).collect(Collectors.toList());
		WebElement _countryDropdown = (fieldName.contains(MYLOConstants.ORIGIN)) ? _orgCountry : _destCountry;
		CoreFunctions.click(driver, _countryDropdown, fieldName);
		List<WebElement> dropdownList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		updatedValue = (fieldValue.equals(MYLOConstants.RANDOM))
				? CoreFunctions.getRandomOutOfSelectedElementValueFromList(driver, dropdownList, valuesToIgnore)
				: fieldValue;
		BusinessFunctions.selectItemFromListUsingText(driver, dropdownList, updatedValue);
		accountingFieldsUpdatedValueMap.put(fieldName, updatedValue);
		return updatedValue;
	}

	public String setAccountingInputValues(String fieldName, String fieldValue, String type) {
		mapAccountingQueryInputFields();
		String updatedValue = "";
		try {
			CoreFunctions.scrollToElementUsingJS(driver, accountingQueryFieldMap.get(fieldName), fieldName);
			updatedValue = BusinessFunctions.setMyloInputFields(driver, fieldName, fieldValue,
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
			accountingFieldsUpdatedValueMap.put(fieldName, updatedValue);
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
			clickButtonsOnAccountingQuerySection(MYLOConstants.EXECUTE);
			Assert.assertTrue(verifyToastMessage(data.get(MYLOConstants.MESSAGE)),
					MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL,
							data.get(MYLOConstants.MESSAGE), _alertMessage.getText(), MYLOConstants.JOURNEY));
			clickToastMesssgeCloseIcon();
			BusinessFunctions.setMyloInputFields(driver, fieldName, MYLOConstants.BLANK,
					accountingQueryFieldMap.get(fieldName), MYLOConstants.BLANK);
		}
	}

	public void setFieldValueAsPerCharacterLimit(DataTable table) {
		List<String> numberFields = Stream
				.of(MYLOConstants.ASSIGNMENT_ID, MYLOConstants.SUB_SERVICE_ID, MYLOConstants.TRACKING_NUMBER,
						MYLOConstants.TRANSACTION_ID, MYLOConstants.FINANCIAL_ID, MYLOConstants.ZIPCODE)
				.collect(Collectors.toList());
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			String fieldName = data.get(MYLOConstants.FIELD_NAME);
			clickAddressTabsIfNeeded(fieldName);
			String type = (numberFields.contains(fieldName)) ? MYLOConstants.RANDOM_INTEGER
					: MYLOConstants.RANDOM_STRING;
			setAccountQueryFieldValues(fieldName, data.get(MYLOConstants.CHARACTER_LENGTH), type);
		}
	}

	/**
	 * Get value of different fields available on Accounting section
	 * 
	 * @param fieldName
	 * @param type
	 * @return
	 */
	public String getAccountingQueryFieldValues(String fieldName) {
		mapAccountingQueryDropdownFields();
		mapAccountingQueryInputFields();
		String requiredValue = "";
		try {
			CoreFunctions.scrollToElementUsingJS(driver, accountingQueryFieldMap.get(fieldName), fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, accountingQueryFieldMap.get(fieldName), fieldName);
			requiredValue = CoreFunctions.getAttributeText(accountingQueryFieldMap.get(fieldName), MYLOConstants.VALUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.ACCOUNTING_QUERY));
		}
		return requiredValue;
	}

	public void verifyAccountingQueryFieldValueEntered(DataTable table) {
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			String fieldName = data.get(MYLOConstants.FIELD_NAME);
			clickAddressTabsIfNeeded(fieldName);
			int fieldCharLimit = Integer.parseInt(data.get(MYLOConstants.CHARACTER_LENGTH));
			String updatedValue = accountingFieldsUpdatedValueMap.get(fieldName).length() > fieldCharLimit
					? accountingFieldsUpdatedValueMap.get(fieldName).substring(0, fieldCharLimit)
					: accountingFieldsUpdatedValueMap.get(fieldName);
			Assert.assertEquals(getAccountingQueryFieldValues(fieldName), updatedValue);
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.ACCOUNTING_QUERY));
		}
	}

	public boolean verifyToastMessage(String msg) {
		boolean flag = false;
		flag = (BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, msg, MYLOConstants.ACCOUNTING_QUERY));
		return flag;
	}

	public boolean verifyAccountingQueryPopUpDisplayed() {
		boolean flag = CoreFunctions.isElementExist(driver, _accountingQueryPopUp, 5);
		return flag;
	}

	public void setFieldValueForSearch(String fieldName) {
		switch (fieldName) {
		case MYLOConstants.ASSIGNMENT_ID:
			setAccountQueryFieldValues(fieldName, MyloNewFileUtil.getFileID(), MYLOConstants.VALUE);
			break;
		case MYLOConstants.TRANSFEREE_NAME:
			setAccountingInputValues(MYLOConstants.TRANSFEREE_FIRSTNAME, MyloNewFileUtil.getTransfereeFirstName(),
					MYLOConstants.VALUE);
			setAccountingInputValues(MYLOConstants.TRANSFEREE_LASTNAME, MyloNewFileUtil.getTransfereeLastName(),
					MYLOConstants.VALUE);
			break;
		case MYLOConstants.TRACKING_NUMBER:
			setAccountingInputValues(MYLOConstants.TRACKING_NUMBER, MyloNewFileUtil.get_trackingNumber(),
					MYLOConstants.VALUE);
			break;
		case MYLOConstants.ORIGIN_ADDRESS:
			setAccountingDropdownValues(MYLOConstants.ORIGIN_ADDRESS_COUNTRY, MyloNewFileUtil.get_orgCountry());
			setAccountingDropdownValues(MYLOConstants.ORIGIN_ADDRESS_STATE, MyloNewFileUtil.get_orgState());
			setAccountingInputValues(MYLOConstants.ORIGIN_ADDRESS_ZIPCODE, MyloNewFileUtil.get_orgZipCode(),
					MYLOConstants.VALUE);
			setAccountingInputValues(MYLOConstants.ORIGIN_ADDRESS_CITY, MyloNewFileUtil.get_orgCity(),
					MYLOConstants.VALUE);
			setAccountingInputValues(MYLOConstants.ORIGIN_ADDRESS_STREET1, MyloNewFileUtil.get_orgAddress1(),
					MYLOConstants.VALUE);
			setAccountingInputValues(MYLOConstants.ORIGIN_ADDRESS_STREET2, MyloNewFileUtil.get_orgAddress2(),
					MYLOConstants.VALUE);
			break;
		case MYLOConstants.DESTINATION_ADDRESS:
			clickAddressTabsIfNeeded(MYLOConstants.DESTINATION_ADDRESS);
			setAccountingDropdownValues(MYLOConstants.DESTINATION_ADDRESS_COUNTRY, MyloNewFileUtil.get_destCountry());
			setAccountingDropdownValues(MYLOConstants.DESTINATION_ADDRESS_STATE, MyloNewFileUtil.get_destState());
			setAccountingInputValues(MYLOConstants.DESTINATION_ADDRESS_ZIPCODE, MyloNewFileUtil.get_destZipCode(),
					MYLOConstants.VALUE);
			setAccountingInputValues(MYLOConstants.DESTINATION_ADDRESS_CITY, MyloNewFileUtil.get_destCity(),
					MYLOConstants.VALUE);
			setAccountingInputValues(MYLOConstants.DESTINATION_ADDRESS_STREET1, MyloNewFileUtil.get_destAddress1(),
					MYLOConstants.VALUE);
			setAccountingInputValues(MYLOConstants.DESTINATION_ADDRESS_STREET2, MyloNewFileUtil.get_destAddress2(),
					MYLOConstants.VALUE);
			break;
		}
	}

	public boolean verifySearchedSingleFile(String fieldName, Map<String, String> fieldValues) {
		boolean flag = false;
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		switch (fieldName) {
		case MYLOConstants.ASSIGNMENT_ID:
			flag = fieldValues.get(fieldName).equals(MyloNewFileUtil.getFileID());
			break;
		case MYLOConstants.TRANSFEREE_NAME:
			flag = fieldValues.get(fieldName).split(" ")[0].equals(MyloNewFileUtil.getTransfereeFirstName())
					&& fieldValues.get(fieldName).split(" ")[1].equals(MyloNewFileUtil.getTransfereeLastName());
			break;
		case MYLOConstants.TRACKING_NUMBER:
			flag = fieldValues.get(fieldName).equals(MyloNewFileUtil.get_trackingNumber());
			break;
		case MYLOConstants.ORIGIN_ADDRESS:
			flag = fieldValues.get(MYLOConstants.ORIGIN_COUNTRY).equals(MyloNewFileUtil.get_orgCountry())
					&& fieldValues.get(MYLOConstants.ORIGIN_STATE).equals(MyloNewFileUtil.get_orgState())
					&& fieldValues.get(MYLOConstants.ORIGIN_CITY).equals(MyloNewFileUtil.get_orgCity())
					&& fieldValues.get(MYLOConstants.ORIGIN_ADDRESS1).equals(MyloNewFileUtil.get_orgAddress1())
					&& fieldValues.get(MYLOConstants.ORIGIN_ADDRESS2).equals(MyloNewFileUtil.get_orgAddress2())
					&& fieldValues.get(MYLOConstants.ORIGIN_ZIPCODE).equals(MyloNewFileUtil.get_orgZipCode());
			break;
		case MYLOConstants.DESTINATION_ADDRESS:
			flag = fieldValues.get(MYLOConstants.DESTINATION_COUNTRY).equals(MyloNewFileUtil.get_destCountry())
					&& fieldValues.get(MYLOConstants.DESTINATION_STATE).equals(MyloNewFileUtil.get_destState())
					&& fieldValues.get(MYLOConstants.DESTINATION_CITY).equals(MyloNewFileUtil.get_destCity())
					&& fieldValues.get(MYLOConstants.DESTINATION_ADDRESS1).equals(MyloNewFileUtil.get_destAddress1())
					&& fieldValues.get(MYLOConstants.DESTINATION_ADDRESS2).equals(MyloNewFileUtil.get_destAddress2())
					&& fieldValues.get(MYLOConstants.DESTINATION_ZIPCODE).equals(MyloNewFileUtil.get_destZipCode());
			break;
		}

		return flag;
	}

	public void clickOKButtonIfNoFileFound() {
			Assert.assertEquals(CoreFunctions.getElementText(driver, _errorPopUpText),
					MYLOConstants.NO_SUCH_FILE_FOUND);
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.NO_SUCH_FILE_FOUND_SERVICE_SERVICESTATUS,
					CoreConstants.PASS, accountingFieldsUpdatedValueMap.get(MYLOConstants.SERVICE),
					accountingFieldsUpdatedValueMap.get(MYLOConstants.SERVICE_STATUS)));
			CoreFunctions.clickUsingJS(driver, _OKButtonPopUp, MYLOConstants.OK_BUTTON);
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _popUp);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
	}

	public void checkAccountingResultModalAppears(String serviceValue, String serviceStatusValue) {
		while (!(CoreFunctions.isElementExist(driver, _queryResultPopUp, 5))) {
			if (CoreFunctions.isElementExist(driver, _OKButtonPopUp, 2)) {
			clickOKButtonIfNoFileFound();
			}
			else {
				CoreFunctions.click(driver, _querySubSection, MYLOConstants.QUERY);
				CoreFunctions.click(driver, _accountingBtn, MYLOConstants.ACCOUNTING);
			}
			setAccountingDropdownValues(MYLOConstants.SERVICE, serviceValue);
			setAccountingDropdownValues(MYLOConstants.SERVICE_STATUS, serviceStatusValue);
			clickButtonsOnAccountingQuerySection(MYLOConstants.EXECUTE);
		}
	}

	public boolean verifyAccountingFilesResultFromDB(String reqColumnValue) {
		mapQueryResultColumnWebElements();
		boolean flag = false;
		String noOfRecordsToValidate = CoreFunctions.getPropertyFromConfig(MYLOConstants.MAX_RECORDS_TO_VALIDATE);
		try {
			Set<String> reqDBValues = DbFunctions.getAccountingFilesInfoByServiceAndServiceStatus(
					accountingFieldsUpdatedValueMap.get(MYLOConstants.SERVICE),
					accountingFieldsUpdatedValueMap.get(MYLOConstants.SERVICE_STATUS), reqColumnValue,
					noOfRecordsToValidate);
			List<String> expectedValues = new ArrayList<>(reqDBValues);
			List<String> actualValues = queryResultWebElementsMap.get(reqColumnValue).stream().limit(reqDBValues.size())
			.map(x -> CoreFunctions.getElementText(driver, x)).collect(Collectors.toList());
			flag = expectedValues.equals(actualValues);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TO_VERFY, MYLOConstants.QUERY_RESULTS));
		}

		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_QUERY_RESULTS_MATCH_WITH_DATABASE,
					CoreConstants.PASS, reqColumnValue, MYLOConstants.ACCOUNTING_QUERY, MYLOConstants.SERVICE,
					accountingFieldsUpdatedValueMap.get(MYLOConstants.SERVICE), MYLOConstants.SERVICE_STATUS,
					accountingFieldsUpdatedValueMap.get(MYLOConstants.SERVICE_STATUS)));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_QUERY_RESULTS_MISMATCH_WITH_DATABASE,
					CoreConstants.FAIL, reqColumnValue, MYLOConstants.ACCOUNTING_QUERY, MYLOConstants.SERVICE,
					accountingFieldsUpdatedValueMap.get(MYLOConstants.SERVICE), MYLOConstants.SERVICE_STATUS,
					accountingFieldsUpdatedValueMap.get(MYLOConstants.SERVICE_STATUS)));
		return flag;
	}

	public boolean verifyAccountingSortResultFromDB(String sortColName, String sortingOrder) {
		mapQueryResultColumnWebElements();
		mapDatabaseColumnNames();
		boolean flag = false;
		String noOfRecordsToValidate = CoreFunctions.getPropertyFromConfig(MYLOConstants.MAX_RECORDS_TO_VALIDATE);
		try {
			Set<String> reqDBValues = DbFunctions.getAccountingSortResult(
					accountingFieldsUpdatedValueMap.get(MYLOConstants.SERVICE),
					accountingFieldsUpdatedValueMap.get(MYLOConstants.SERVICE_STATUS),
					databaseColNameMap.get(sortColName), sortingOrder, noOfRecordsToValidate);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			List<String> expectedValues = new ArrayList<>(reqDBValues);
			List<WebElement> _resultFileIDs = CoreFunctions.getElementListByLocator(driver, _queryResultFileIds);
			List<String> actualValues = _resultFileIDs.stream().limit(expectedValues.size())
			.map(x -> CoreFunctions.getElementText(driver, x)).collect(Collectors.toList());
			flag = expectedValues.equals(actualValues);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TO_VERFY, MYLOConstants.QUERY_RESULTS));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_FIELDS_SORTED, CoreConstants.PASS,
					MYLOConstants.MY_FILES_QUERY_RESULT, sortColName, sortingOrder));
		return flag;
	}

}
