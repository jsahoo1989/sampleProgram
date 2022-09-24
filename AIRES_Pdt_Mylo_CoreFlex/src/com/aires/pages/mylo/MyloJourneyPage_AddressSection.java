package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_AddressSection extends Base {

	public MyloJourneyPage_AddressSection(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "button[aria-controls='collapseoriginAddress']")
	private WebElement _originAddressDetailsBtn;

	@FindBy(how = How.CSS, using = "button[aria-controls='collapsedestinationAddress']")
	private WebElement _destinationAddressDetailsBtn;

	@FindBy(how = How.CSS, using = "button[aria-controls='collapsemailingAddress']")
	private WebElement _mailingAddressDetailsBtn;

	@FindBy(how = How.XPATH, using = "//app-address[@id='originAddress']//i[@class='icon-Pencil_Open']/parent::button")
	private WebElement _originAddressEditBtn;

	@FindBy(how = How.XPATH, using = "//app-address[@id='destinationAddress']//i[@class='icon-Pencil_Open']/parent::button")
	private WebElement _destinationAddressEditBtn;

	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//i[@class='icon-Pencil_Open']/parent::button")
	private WebElement _mailingAddressEditBtn;

	@FindBy(how = How.CSS, using = "#originAddress i[class='icon-FloppyDisk_Open save_section']")
	private WebElement _originAddressSaveBtn;

	@FindBy(how = How.CSS, using = "#destinationAddress i[class='icon-FloppyDisk_Open save_section']")
	private WebElement _destinationAddressSaveBtn;

	@FindBy(how = How.CSS, using = "app-address[id='originAddress'] button[class='right-panel-blue-btn mr-1']")
	private WebElement _originAddressCopyBtn;

	@FindBy(how = How.CSS, using = "app-address[id='destinationAddress'] button[class='right-panel-blue-btn mr-1']")
	private WebElement _destinationAddressCopyBtn;

	@FindBy(how = How.XPATH, using = "//app-address[@id='originAddress']//button[text()=' Copy to Mail ']")
	private WebElement _originAddressCopyToMailBtn;

	@FindBy(how = How.XPATH, using = "//app-address[@id='destinationAddress']//button[text()=' Copy to Mail ']")
	private WebElement _destinationAddressCopyToMailBtn;

	@FindBy(how = How.CSS, using = "#originAddress ng-select[name='country']")
	private WebElement _originCountry;

	@FindBy(how = How.CSS, using = "#destinationAddress ng-select[name='country']")
	private WebElement _destCountry;

	@FindBy(how = How.CSS, using = "#originAddress ng-select[name='country'] span[class='ng-value-label ng-star-inserted']")
	private WebElement _originCountryValue;

	@FindBy(how = How.CSS, using = "#destinationAddress ng-select[name='country'] span[class='ng-value-label ng-star-inserted']")
	private WebElement _destCountryValue;

	@FindBy(how = How.CSS, using = "#originAddress #address1")
	private WebElement _originAddress1;

	@FindBy(how = How.CSS, using = "#mailingAddress #address1")
	private WebElement _mailingAddress1;

	@FindBy(how = How.CSS, using = "#destinationAddress #address1")
	private WebElement _destAddress1;

	@FindBy(how = How.CSS, using = "#originAddress #address2")
	private WebElement _originAddress2;

	@FindBy(how = How.CSS, using = "#destinationAddress #address2")
	private WebElement _destAddress2;

	@FindBy(how = How.CSS, using = "#originAddress #city")
	private WebElement _originCity;

	@FindBy(how = How.CSS, using = "#destinationAddress #city")
	private WebElement _destCity;

	@FindBy(how = How.CSS, using = "#originAddress #zipCode")
	private WebElement _originZipCode;

	@FindBy(how = How.CSS, using = "#destinationAddress #zipCode")
	private WebElement _destZipCode;

	@FindBy(how = How.CSS, using = "#originAddress ng-select[name='state']")
	private WebElement _originState;

	@FindBy(how = How.CSS, using = "#destinationAddress ng-select[name='state']")
	private WebElement _destState;

	@FindBy(how = How.CSS, using = "#originAddress ng-select[name='state'] span[class='ng-value-label ng-star-inserted']")
	private WebElement _originStateValue;

	@FindBy(how = How.CSS, using = "#destinationAddress ng-select[name='state'] span[class='ng-value-label ng-star-inserted']")
	private WebElement _destStateValue;

	@FindBy(how = How.CSS, using = "#originAddress #state")
	private WebElement _originStateTextField;

	@FindBy(how = How.CSS, using = "#destinationAddress #state")
	private WebElement _destStateTextField;

	@FindBy(how = How.CSS, using = "#originAddress div[class='address-title-wrapper']+div")
	private WebElement _completeOriginAddress;

	@FindBy(how = How.CSS, using = "#mailingAddress div[class='address-title-wrapper']+div")
	private WebElement _completeMailingAddress;

	@FindBy(how = How.CSS, using = "#destinationAddress div[class='address-title-wrapper']+div")
	private WebElement _completeDestinationAddress;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "div[role='alert']")
	private List<WebElement> _alertMessages;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'toast-close-btn')]")
	private WebElement _closeBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	private WebElement _YesButton;

	@FindBy(how = How.XPATH, using = "//button[text()='No']")
	private WebElement _NoButton;

	@FindBy(how = How.XPATH, using = "//a[text()='Add Mailing Address']/preceding-sibling::i")
	private WebElement _addMailAddressBtn;

	@FindBy(how = How.CSS, using = "button[aria-label='Close this dialog']")
	private WebElement _closePopUpIcon;

	final By _dropdownOptions = By.xpath("//div[@role='option']/span");
	final By _originCopyBtn = By.xpath("//button[contains(@class,'copy-active')]");

	LinkedHashMap<String, WebElement> addressWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> addressTypeMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> addressValidFieldValueMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> addressUpdatedFieldValueMap = new LinkedHashMap<String, String>();

	public void mapAddressSectionWebElements() {
		addressWebElementsMap.put(MYLOConstants.ORIGIN_COUNTRY, _originCountry);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_COUNTRY, _destCountry);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_COUNTRY_VALUE, _originCountryValue);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_COUNTRY_VALUE, _destCountryValue);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS1, _originAddress1);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS1, _destAddress1);
		addressWebElementsMap.put(MYLOConstants.MAILING_ADDRESS1, _mailingAddress1);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS2, _originAddress2);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS2, _destAddress2);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_CITY, _originCity);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_CITY, _destCity);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ZIPCODE, _originZipCode);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ZIPCODE, _destZipCode);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_STATE, _originState);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_STATE, _destState);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_STATE_VALUE, _originStateValue);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_STATE_VALUE, _destStateValue);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_STATE_TEXT_FIELD, _originStateTextField);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_STATE_TEXT_FIELD, _destStateTextField);
		addressWebElementsMap.put(MYLOConstants.COMPLETE_ORIGIN_ADDRESS, _completeOriginAddress);
		addressWebElementsMap.put(MYLOConstants.COMPLETE_DESTINATION_ADDRESS, _completeDestinationAddress);
		addressWebElementsMap.put(MYLOConstants.COMPLETE_MAILING_ADDRESS, _completeMailingAddress);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS_SAVE_BUTTON, _originAddressSaveBtn);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS_SAVE_BUTTON, _destinationAddressSaveBtn);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS_EDIT_BUTTON, _originAddressEditBtn);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS_EDIT_BUTTON, _destinationAddressEditBtn);
		addressWebElementsMap.put(MYLOConstants.MAILING_ADDRESS_EDIT_BUTTON, _mailingAddressEditBtn);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS_DETAILS_BUTTON, _originAddressDetailsBtn);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS_DETAILS_BUTTON, _destinationAddressDetailsBtn);
		addressWebElementsMap.put(MYLOConstants.MAILING_ADDRESS_DETAILS_BUTTON, _mailingAddressDetailsBtn);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS_COPY_BUTTON, _originAddressCopyBtn);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS_COPY_BUTTON, _destinationAddressCopyBtn);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS_COPYTOMAIL_BUTTON, _originAddressCopyToMailBtn);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS_COPYTOMAIL_BUTTON,
				_destinationAddressCopyToMailBtn);
		addressWebElementsMap.put(MYLOConstants.YES_BUTTON, _YesButton);
		addressWebElementsMap.put(MYLOConstants.NO_BUTTON, _NoButton);
		addressWebElementsMap.put(MYLOConstants.ADD_MAILING_ADDRESS, _addMailAddressBtn);
		addressWebElementsMap.put(MYLOConstants.CLOSE_POPUP, _closePopUpIcon);
	}

	public void mapOtherAddresssValidFieldValue() {
		addressValidFieldValueMap.put(MYLOConstants.ORIGIN_CITY, MYLOConstants.CITY_VALUE);
		addressValidFieldValueMap.put(MYLOConstants.DESTINATION_CITY, MYLOConstants.CITY_VALUE);
		addressValidFieldValueMap.put(MYLOConstants.ORIGIN_ZIPCODE, MYLOConstants.ZIPCODE_VALUE);
		addressValidFieldValueMap.put(MYLOConstants.DESTINATION_ZIPCODE, MYLOConstants.ZIPCODE_VALUE);
		addressValidFieldValueMap.put(MYLOConstants.ORIGIN_ADDRESS1, MYLOConstants.ADDRESS1_VALUE);
		addressValidFieldValueMap.put(MYLOConstants.DESTINATION_ADDRESS1, MYLOConstants.ADDRESS1_VALUE);
		addressValidFieldValueMap.put(MYLOConstants.ORIGIN_ADDRESS2, MYLOConstants.ADDRESS2_VALUE);
		addressValidFieldValueMap.put(MYLOConstants.DESTINATION_ADDRESS2, MYLOConstants.ADDRESS2_VALUE);
		addressValidFieldValueMap.put(MYLOConstants.ORIGIN_STATE_TEXT_FIELD, MYLOConstants.STATE_VALUE);
		addressValidFieldValueMap.put(MYLOConstants.DESTINATION_STATE_TEXT_FIELD, MYLOConstants.STATE_VALUE);
	}

	public void clickFieldsOnAddressSection(String fieldName, String sectionName) {
		mapAddressSectionWebElements();
		try {
			WebElement element = addressWebElementsMap.get(fieldName);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, sectionName));
		}
	}

	public void setAddressMandatoryFields(String sectionType, String countryName, String stateName, String cityName,
			String type) {
		assignAddressTypeFields(sectionType);
		String updatedCountryValue = setAddressCountryStateDropdown(addressTypeMap.get(MYLOConstants.COUNTRY),
				countryName, sectionType);
		String updatedStateValue = (countryName.equals(MYLOConstants.RANDOM)
				|| countryName.equals(MYLOConstants.SELECT_ONE))
						? BusinessFunctions.setDifferentMyloFields(driver,
								addressTypeMap.get(MYLOConstants.STATE_TEXT_FIELD), stateName,
								addressWebElementsMap.get(addressTypeMap.get(MYLOConstants.STATE_TEXT_FIELD)), type)
						: setAddressCountryStateDropdown(addressTypeMap.get(MYLOConstants.STATE), stateName,
								sectionType);
		String cityType = (cityName.equals(MYLOConstants.BLANK)) ? MYLOConstants.BLANK : type;
		String updatedCityValue = BusinessFunctions.setDifferentMyloFields(driver,
				addressTypeMap.get(MYLOConstants.CITY), cityName,
				addressWebElementsMap.get(addressTypeMap.get(MYLOConstants.CITY)), cityType);
		addressUpdatedFieldValueMap.put(addressTypeMap.get(MYLOConstants.COUNTRYVALUE), updatedCountryValue);
		addressUpdatedFieldValueMap.put(addressTypeMap.get(MYLOConstants.STATEVALUE), updatedStateValue);
		addressUpdatedFieldValueMap.put(addressTypeMap.get(MYLOConstants.STATE_TEXT_FIELD), updatedStateValue);
		addressUpdatedFieldValueMap.put(addressTypeMap.get(MYLOConstants.CITY), updatedCityValue);
	}

	public String setAddressCountryStateDropdown(String fieldName, String fieldValue, String sectionType) {
		String updatedValue;
		clickFieldsOnAddressSection(fieldName, sectionType);
		List<WebElement> dropdownList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		List<String> valuesToIgnore = Stream.of(MYLOConstants.USA_STATE, MYLOConstants.INDIA_STATE,
				MYLOConstants.CANADA_STATE, MYLOConstants.SELECT_ONE).collect(Collectors.toList());
		updatedValue = (fieldValue.equals(MYLOConstants.RANDOM))
				? CoreFunctions.getRandomOutOfSelectedElementValueFromList(driver, dropdownList, valuesToIgnore)
				: fieldValue;
		BusinessFunctions.selectItemFromListUsingText(driver, dropdownList, updatedValue);
		return updatedValue;
	}

	public void addressSectionButtonEnabilityStatus(String type, String btnName, String sectionType) {
		mapAddressSectionWebElements();
		BusinessFunctions.verifyMyloButtonEnabilityStatus(type, addressWebElementsMap.get(btnName), btnName,
				sectionType, MYLOConstants.JOURNEY);
	}

	public void assignAddressTypeFields(String sectionType) {
		if (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS)) {
			addressTypeMap.put(MYLOConstants.COUNTRY, MYLOConstants.ORIGIN_COUNTRY);
			addressTypeMap.put(MYLOConstants.COUNTRYVALUE, MYLOConstants.ORIGIN_COUNTRY_VALUE);
			addressTypeMap.put(MYLOConstants.STATE, MYLOConstants.ORIGIN_STATE);
			addressTypeMap.put(MYLOConstants.STATE_TEXT_FIELD, MYLOConstants.ORIGIN_STATE_TEXT_FIELD);
			addressTypeMap.put(MYLOConstants.STATEVALUE, MYLOConstants.ORIGIN_STATE_VALUE);
			addressTypeMap.put(MYLOConstants.CITY, MYLOConstants.ORIGIN_CITY);
			addressTypeMap.put(MYLOConstants.ADDRESS1, MYLOConstants.ORIGIN_ADDRESS1);
			addressTypeMap.put(MYLOConstants.ADDRESS2, MYLOConstants.ORIGIN_ADDRESS2);
			addressTypeMap.put(MYLOConstants.ZIPCODE, MYLOConstants.ORIGIN_ZIPCODE);
			addressTypeMap.put(MYLOConstants.COPY_BUTTON, MYLOConstants.ORIGIN_ADDRESS_COPY_BUTTON);
		} else if (sectionType.equals(MYLOConstants.DESTINATION_ADDRESS)) {
			addressTypeMap.put(MYLOConstants.COUNTRY, MYLOConstants.DESTINATION_COUNTRY);
			addressTypeMap.put(MYLOConstants.COUNTRYVALUE, MYLOConstants.DESTINATION_COUNTRY_VALUE);
			addressTypeMap.put(MYLOConstants.STATE, MYLOConstants.DESTINATION_STATE);
			addressTypeMap.put(MYLOConstants.STATE_TEXT_FIELD, MYLOConstants.DESTINATION_STATE_TEXT_FIELD);
			addressTypeMap.put(MYLOConstants.STATEVALUE, MYLOConstants.DESTINATION_STATE_VALUE);
			addressTypeMap.put(MYLOConstants.CITY, MYLOConstants.DESTINATION_CITY);
			addressTypeMap.put(MYLOConstants.ADDRESS1, MYLOConstants.DESTINATION_ADDRESS1);
			addressTypeMap.put(MYLOConstants.ADDRESS2, MYLOConstants.DESTINATION_ADDRESS2);
			addressTypeMap.put(MYLOConstants.ZIPCODE, MYLOConstants.DESTINATION_ZIPCODE);
			addressTypeMap.put(MYLOConstants.COPY_BUTTON, MYLOConstants.DESTINATION_ADDRESS_COPY_BUTTON);
		}
	}

	public void verifyAddressSectionToastMessages(String sectionType, DataTable table) {
		mapOtherAddresssValidFieldValue();
		setAddressMandatoryFields(sectionType, MYLOConstants.RANDOM, MYLOConstants.STATE_VALUE,
				MYLOConstants.CITY_VALUE, MYLOConstants.VALUE);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			String fieldValue = data.get(i).get(MYLOConstants.FIELD_VALUE);
			BusinessFunctions.setDifferentMyloFields(driver, fieldName, fieldValue,
					addressWebElementsMap.get(fieldName), MYLOConstants.RANDOM_STRING);
			String btnName = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS))
					? MYLOConstants.ORIGIN_ADDRESS_SAVE_BUTTON
					: MYLOConstants.DESTINATION_ADDRESS_SAVE_BUTTON;
			clickFieldsOnAddressSection(btnName, sectionType);
			Assert.assertTrue(BusinessFunctions.verifyMyloToastMessage(driver, _alertMessages.get(0),
					data.get(i).get(MYLOConstants.MESSAGE), sectionType));
			closeToastmessage();
			mapOtherAddresssValidFieldValue();
			BusinessFunctions.setDifferentMyloFields(driver, fieldName, addressValidFieldValueMap.get(fieldName),
					addressWebElementsMap.get(fieldName), MYLOConstants.VALUE);
		}
	}

	public void setFieldValueAddressSection(String countryValue, String stateValue, String cityValue,
			String zipCodeValue, String address1Value, String address2Value, String sectionType) {
		assignAddressTypeFields(sectionType);
		setAddressMandatoryFields(sectionType, countryValue, stateValue, cityValue, MYLOConstants.RANDOM_STRING);
		String updatedZipCodeValue = BusinessFunctions.setDifferentMyloFields(driver,
				addressTypeMap.get(MYLOConstants.ZIPCODE), zipCodeValue,
				addressWebElementsMap.get(addressTypeMap.get(MYLOConstants.ZIPCODE)), MYLOConstants.RANDOM_STRING);
		String updatedAddress1Value = BusinessFunctions.setDifferentMyloFields(driver,
				addressTypeMap.get(MYLOConstants.ADDRESS1), address1Value,
				addressWebElementsMap.get(addressTypeMap.get(MYLOConstants.ADDRESS1)), MYLOConstants.RANDOM_STRING);
		String updatedAddress2Value = BusinessFunctions.setDifferentMyloFields(driver,
				addressTypeMap.get(MYLOConstants.ADDRESS2), address2Value,
				addressWebElementsMap.get(addressTypeMap.get(MYLOConstants.ADDRESS2)), MYLOConstants.RANDOM_STRING);
		addressUpdatedFieldValueMap.put(addressTypeMap.get(MYLOConstants.ZIPCODE), updatedZipCodeValue);
		addressUpdatedFieldValueMap.put(addressTypeMap.get(MYLOConstants.ADDRESS1), updatedAddress1Value);
		addressUpdatedFieldValueMap.put(addressTypeMap.get(MYLOConstants.ADDRESS2), updatedAddress2Value);
	}

	public String getAddressFieldValue(String fieldName, String sectionType) {
		mapAddressSectionWebElements();
		String requiredValue = "";
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, addressWebElementsMap.get(fieldName), fieldName);
			requiredValue = (fieldName.equals(addressTypeMap.get(MYLOConstants.COUNTRYVALUE))
					|| fieldName.equals(addressTypeMap.get(MYLOConstants.STATEVALUE))
					|| fieldName.equals(addressTypeMap.get(MYLOConstants.ORIGIN_ADDRESS_COPY_BUTTON))
					|| fieldName.equals(addressTypeMap.get(MYLOConstants.COPY_BUTTON))
					|| fieldName.equals(MYLOConstants.COMPLETE_ORIGIN_ADDRESS)
					|| fieldName.equals(MYLOConstants.COMPLETE_DESTINATION_ADDRESS)
					|| fieldName.equals(MYLOConstants.COMPLETE_MAILING_ADDRESS))
							? CoreFunctions.getElementText(driver, addressWebElementsMap.get(fieldName))
							: CoreFunctions.getAttributeText(addressWebElementsMap.get(fieldName), MYLOConstants.VALUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, sectionType));
		}
		return requiredValue;
	}

	public boolean verifyAddressFieldsUpdatedValue(String fieldName, String sectionType) {
		boolean flag = false;
		String updatedValue = null;
		try {
			updatedValue = addressUpdatedFieldValueMap.get(fieldName);
			flag = getAddressFieldValue(fieldName, sectionType).equals(updatedValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, sectionType));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, sectionType));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, sectionType));
		return flag;
	}

	public void closeToastmessage() {
		if (CoreFunctions.isElementVisible(_closeBtn)) {
			CoreFunctions.highlightObject(driver, _closeBtn);
			CoreFunctions.sendKeysUsingAction(driver, _closeBtn, _closeBtn.getText());
		}
	}

	public void verifyMandatoryFieldsToastMessagesAddressSection(String sectionType, DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setAddressMandatoryFields(sectionType, data.get(i).get(MYLOConstants.COUNTRY),
					data.get(i).get(MYLOConstants.STATE_TEXT_FIELD), data.get(i).get(MYLOConstants.CITY),
					MYLOConstants.RANDOM_STRING);
			String btnName = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS))
					? MYLOConstants.ORIGIN_ADDRESS_SAVE_BUTTON
					: MYLOConstants.DESTINATION_ADDRESS_SAVE_BUTTON;
			clickFieldsOnAddressSection(btnName, sectionType);
			Assert.assertTrue(BusinessFunctions.verifyMyloToastMessage(driver, _alertMessages.get(0),
					data.get(i).get(MYLOConstants.MESSAGE), sectionType));
			closeToastmessage();
		}
	}

	public boolean verifyCopyButtonText(String sectionType, String text, String btnName) {
		addressWebElementsMap.get(btnName).click();
		String actualText = driver.findElement(By.xpath("//button[contains(@class,'copy-active')]")).getText();
		boolean flag = (actualText.equals(text));
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_TEXT_VALUE, CoreConstants.PASS,
					btnName, text, sectionType));
		return flag;
	}

	public boolean verifyCopiedText(String expectedText, String sectionType) {
		clickFieldsOnAddressSection(MYLOConstants.MAILING_ADDRESS1, sectionType);
		addressWebElementsMap.get(MYLOConstants.MAILING_ADDRESS1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		addressWebElementsMap.get(MYLOConstants.MAILING_ADDRESS1).sendKeys(Keys.chord(Keys.CONTROL, "v"));
		boolean flag = (getAddressFieldValue(MYLOConstants.MAILING_ADDRESS1, sectionType)).equals(expectedText);
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_COPIED_TEXT_VALUE, CoreConstants.PASS,
					sectionType, expectedText));
		return flag;
	}

	public boolean verifiedAddressCopied(String sectionType) {
		String fullAddress = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS)) ? MYLOConstants.COMPLETE_ORIGIN_ADDRESS
				: MYLOConstants.COMPLETE_DESTINATION_ADDRESS;
		String addressToBeOverwridden = getAddressFieldValue(fullAddress, sectionType);
		String mailingAddress = getAddressFieldValue(MYLOConstants.COMPLETE_MAILING_ADDRESS,
				MYLOConstants.MAILING_ADDRESS);
		return (addressToBeOverwridden.equals(mailingAddress));
	}

	public boolean isAddressElementExist(String elementName) {
		mapAddressSectionWebElements();
		boolean flag = CoreFunctions.isElementExist(driver, addressWebElementsMap.get(elementName), 5);
		if (flag)
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, elementName));
		return flag;
	}

}
