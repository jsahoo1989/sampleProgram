package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_AddressSection extends Base {

	public MyloJourneyPage_AddressSection(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(how = How.XPATH, using = "//a[text()='Add Origin Address']")
	private WebElement _addOrgnAddressLink;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Add Destination Address']")
	private WebElement _addDestAddressLink;
	
	@FindBy(how = How.CSS, using = "button[aria-controls='collapseoriginAddress']")
	private WebElement _orgnAddressDetailsBtn;

	@FindBy(how = How.CSS, using = "button[aria-controls='collapsedestinationAddress']")
	private WebElement _destAddressDetailsBtn;

	@FindBy(how = How.CSS, using = "button[aria-controls='collapsemailingAddress']")
	private WebElement _mailAddressDetailsBtn;

	@FindBy(how = How.CSS, using = "#originAddress button[class*='action-icon-right-panel']")
	private WebElement _orgnAddressEditBtn;

	@FindBy(how = How.CSS, using = "#destinationAddress button[class*='action-icon-right-panel']")
	private WebElement _destAddressEditBtn;

	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//i[@class='icon-Pencil_Open']/parent::button")
	private WebElement _mailAddressEditBtn;

	@FindBy(how = How.CSS, using = "#originAddress i[class='icon-FloppyDisk_Open save_section']")
	private WebElement _orgnAddressSaveBtn;

	@FindBy(how = How.CSS, using = "#destinationAddress i[class='icon-FloppyDisk_Open save_section']")
	private WebElement _destAddressSaveBtn;

	@FindBy(how = How.CSS, using = "#originAddress button[class='right-panel-blue-btn mr-1']")
	private WebElement _orgnAddressCopyBtn;

	@FindBy(how = How.CSS, using = "#destinationAddress button[class='right-panel-blue-btn mr-1']")
	private WebElement _destAddressCopyBtn;

	@FindBy(how = How.CSS, using = "#originAddress button[class*='right-panel-blue-btn ng']")
	private WebElement _orgnAddressCopyToMailBtn;

	@FindBy(how = How.CSS, using = "#destinationAddress button[class*='right-panel-blue-btn ng']")
	private WebElement _destAddressCopyToMailBtn;

	@FindBy(how = How.CSS, using = "#originAddress ng-select[name='country']")
	private WebElement _orgnCountry;

	@FindBy(how = How.CSS, using = "#destinationAddress ng-select[name='country']")
	private WebElement _destCountry;

	@FindBy(how = How.CSS, using = "#originAddress ng-select[name='country'] span[class='ng-value-label ng-star-inserted']")
	private WebElement _orgnCountryValue;

	@FindBy(how = How.CSS, using = "#destinationAddress ng-select[name='country'] span[class='ng-value-label ng-star-inserted']")
	private WebElement _destCountryValue;

	@FindBy(how = How.CSS, using = "#originAddress #address1")
	private WebElement _orgnAddress1;

	@FindBy(how = How.CSS, using = "#mailingAddress #address1")
	private WebElement _mailAddress1;

	@FindBy(how = How.CSS, using = "#destinationAddress #address1")
	private WebElement _destAddress1;

	@FindBy(how = How.CSS, using = "#originAddress #address2")
	private WebElement _orgnAddress2;

	@FindBy(how = How.CSS, using = "#destinationAddress #address2")
	private WebElement _destAddress2;

	@FindBy(how = How.CSS, using = "#originAddress #city")
	private WebElement _orgnCity;

	@FindBy(how = How.CSS, using = "#destinationAddress #city")
	private WebElement _destCity;

	@FindBy(how = How.CSS, using = "#originAddress #zipCode")
	private WebElement _orgnZipCode;

	@FindBy(how = How.CSS, using = "#destinationAddress #zipCode")
	private WebElement _destZipCode;

	@FindBy(how = How.CSS, using = "#originAddress ng-select[name='state']")
	private WebElement _orgnState;

	@FindBy(how = How.CSS, using = "#destinationAddress ng-select[name='state']")
	private WebElement _destState;

	@FindBy(how = How.CSS, using = "#originAddress ng-select[name='state'] span[class='ng-value-label ng-star-inserted']")
	private WebElement _orgnStateValue;

	@FindBy(how = How.CSS, using = "#destinationAddress ng-select[name='state'] span[class='ng-value-label ng-star-inserted']")
	private WebElement _destStateValue;

	@FindBy(how = How.CSS, using = "#originAddress #state")
	private WebElement _orgnStateTextField;

	@FindBy(how = How.CSS, using = "#destinationAddress #state")
	private WebElement _destStateTextField;

	@FindBy(how = How.CSS, using = "#originAddress div[class='address-title-wrapper']+div")
	private WebElement _completeOrgnAddress;

	@FindBy(how = How.CSS, using = "#mailingAddress div[class='address-title-wrapper']+div")
	private WebElement _completeMailAddress;

	@FindBy(how = How.CSS, using = "#destinationAddress div[class='address-title-wrapper']+div")
	private WebElement _completeDestAddress;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;

	@FindBy(how = How.CSS, using = "button[class*='toast-close-btn']")
	private WebElement _closeBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	private WebElement _YesButton;

	@FindBy(how = How.XPATH, using = "//button[text()='No']")
	private WebElement _NoButton;

	@FindBy(how = How.XPATH, using = "//a[text()='Add Mailing Address']/preceding-sibling::i")
	private WebElement _addMailAddressBtn;

	@FindBy(how = How.CSS, using = "button[aria-label='Close this dialog']")
	private WebElement _closePopUpIcon;
	
	@FindBy(how = How.CSS, using = "ng-select[name='popupcountry']")
	private WebElement _Country;
	
	@FindBy(how = How.XPATH, using = "//ng-select[@name='popupcountry']/following::ng-select[@name='state']")
	private WebElement _State;
	
	@FindBy(how = How.CSS, using = "input[id*='popupcity']")
	private WebElement _city;
	
	@FindBy(how = How.CSS, using = "input[id*='popupzipCode']")
	private WebElement _zipCode;
	
	@FindBy(how = How.CSS, using = "input[id*='popupaddress1']")
	private WebElement _address1;
	
	@FindBy(how = How.CSS, using = "input[id*='popupaddress2']")
	private WebElement _address2;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	private WebElement _saveBtn;
	
	@FindBy(how = How.XPATH, using = "//button[text()=' Destination ']")
	private WebElement _destinationAddressHeader;
	
	@FindBy(how = How.XPATH, using = "//button[text()=' Origin ']")
	private WebElement _originAddressHeader;
	
	final By _dropdownOptions = By.xpath("//div[@role='option']/span");
	final By _originCopyBtn = By.xpath("//button[contains(@class,'copy-active')]");

	LinkedHashMap<String, WebElement> addressWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> addressTypeMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> addressValidFieldValueMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> addressUpdatedFieldValueMap = new LinkedHashMap<String, String>();
	List<String> countryStateDropdownList = Stream
			.of(MYLOConstants.USA_STATE, MYLOConstants.INDIA_STATE, MYLOConstants.CANADA_STATE)
			.collect(Collectors.toList());

	public void mapAddressSectionWebElements() {
		addressWebElementsMap.put(MYLOConstants.ORIGIN_COUNTRY, _orgnCountry);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_COUNTRY, _destCountry);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_COUNTRY_VALUE, _orgnCountryValue);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_COUNTRY_VALUE, _destCountryValue);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS1, _orgnAddress1);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS1, _destAddress1);
		addressWebElementsMap.put(MYLOConstants.MAILING_ADDRESS1, _mailAddress1);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS2, _orgnAddress2);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS2, _destAddress2);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_CITY, _orgnCity);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_CITY, _destCity);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ZIPCODE, _orgnZipCode);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ZIPCODE, _destZipCode);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_STATE, _orgnState);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_STATE, _destState);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_STATE_VALUE, _orgnStateValue);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_STATE_VALUE, _destStateValue);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_STATE_TEXT_FIELD, _orgnStateTextField);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_STATE_TEXT_FIELD, _destStateTextField);
		addressWebElementsMap.put(MYLOConstants.COMPLETE_ORIGIN_ADDRESS, _completeOrgnAddress);
		addressWebElementsMap.put(MYLOConstants.COMPLETE_DESTINATION_ADDRESS, _completeDestAddress);
		addressWebElementsMap.put(MYLOConstants.COMPLETE_MAILING_ADDRESS, _completeMailAddress);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS_SAVE_BUTTON, _orgnAddressSaveBtn);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS_SAVE_BUTTON, _destAddressSaveBtn);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS_EDIT_BUTTON, _orgnAddressEditBtn);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS_EDIT_BUTTON, _destAddressEditBtn);
		addressWebElementsMap.put(MYLOConstants.MAILING_ADDRESS_EDIT_BUTTON, _mailAddressEditBtn);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS_DETAILS_BUTTON, _orgnAddressDetailsBtn);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS_DETAILS_BUTTON, _destAddressDetailsBtn);
		addressWebElementsMap.put(MYLOConstants.MAILING_ADDRESS_DETAILS_BUTTON, _mailAddressDetailsBtn);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS_COPY_BUTTON, _orgnAddressCopyBtn);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS_COPY_BUTTON, _destAddressCopyBtn);
		addressWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS_COPYTOMAIL_BUTTON, _orgnAddressCopyToMailBtn);
		addressWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS_COPYTOMAIL_BUTTON, _destAddressCopyToMailBtn);
		addressWebElementsMap.put(MYLOConstants.YES_BUTTON, _YesButton);
		addressWebElementsMap.put(MYLOConstants.NO_BUTTON, _NoButton);
		addressWebElementsMap.put(MYLOConstants.ADD_MAILING_ADDRESS, _addMailAddressBtn);
		addressWebElementsMap.put(MYLOConstants.CLOSE_POPUP, _closePopUpIcon);
	}

	public void clickFieldsOnAddressSection(String fieldName, String sectionName) {
		mapAddressSectionWebElements();
		try {
			WebElement element = addressWebElementsMap.get(fieldName);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, sectionName));
		}
	}

	public void clickSaveBtn(String sectionType) {
		String btnName = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS)) ? MYLOConstants.ORIGIN_ADDRESS_SAVE_BUTTON
				: MYLOConstants.DESTINATION_ADDRESS_SAVE_BUTTON;
		clickFieldsOnAddressSection(btnName, sectionType);
	}

	public void closeToastmessage() {
		if (CoreFunctions.isElementVisible(_closeBtn)) {
			CoreFunctions.highlightObject(driver, _closeBtn);
			CoreFunctions.sendKeysUsingAction(driver, _closeBtn, _closeBtn.getText());
		}
	}

	public String setAddressCountryStateDropdown(String fieldName, String fieldValue, String sectionType) {
		String updatedValue;
		List<String> valuesToIgnore = Stream.of(MYLOConstants.USA_STATE, MYLOConstants.INDIA_STATE,
				MYLOConstants.CANADA_STATE, MYLOConstants.SELECT_ONE).collect(Collectors.toList());
		clickFieldsOnAddressSection(fieldName, sectionType);
		List<WebElement> dropdownList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		updatedValue = (fieldValue.equals(MYLOConstants.RANDOM))
				? CoreFunctions.getRandomOutOfSelectedElementValueFromList(driver, dropdownList, valuesToIgnore)
				: fieldValue;
		BusinessFunctions.selectItemFromListUsingText(driver, dropdownList, updatedValue);
		addressUpdatedFieldValueMap.put(fieldName, updatedValue);
		return updatedValue;
	}

	public void setAddressFieldValues(String fieldName, String fieldValue, String type, String sectionType) {
		String updatedValue = "";
		scrollToSection(sectionType);
		updatedValue = (fieldName.contains(MYLOConstants.COUNTRY) || fieldName.equals(MYLOConstants.ORIGIN_STATE)
				|| fieldName.equals(MYLOConstants.DESTINATION_STATE))
						? setAddressCountryStateDropdown(fieldName, fieldValue, sectionType)
						: BusinessFunctions.setMyloInputFields(driver, fieldName, fieldValue,
								addressWebElementsMap.get(fieldName), type);
		addressUpdatedFieldValueMap.put(getFieldNameForUpdatingValue(fieldName), updatedValue);
	}

	public void setAddressMandatoryFields(String countryValue, String stateValue, String cityValue, String sectionType,
			String type) {
		if (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS)) {
			addressUpdatedFieldValueMap.put(MYLOConstants.ORIGIN_COUNTRY_VALUE,
					setAddressCountryStateDropdown(MYLOConstants.ORIGIN_COUNTRY, countryValue, sectionType));
			setAddressFieldValues((countryStateDropdownList.contains(countryValue)) ? MYLOConstants.ORIGIN_STATE
					: MYLOConstants.ORIGIN_STATE_TEXT_FIELD, stateValue, type, sectionType);
			addressUpdatedFieldValueMap.put(MYLOConstants.ORIGIN_CITY,
					BusinessFunctions.setMyloInputFields(driver, MYLOConstants.ORIGIN_CITY, cityValue, _orgnCity,
							(cityValue.equals(MYLOConstants.BLANK) ? cityValue : type)));
		}

		else if (sectionType.equals(MYLOConstants.DESTINATION_ADDRESS)) {
			addressUpdatedFieldValueMap.put(MYLOConstants.DESTINATION_COUNTRY_VALUE,
					setAddressCountryStateDropdown(MYLOConstants.DESTINATION_COUNTRY, countryValue, sectionType));
			setAddressFieldValues((countryStateDropdownList.contains(countryValue)) ? MYLOConstants.DESTINATION_STATE
					: MYLOConstants.DESTINATION_STATE_TEXT_FIELD, stateValue, type, sectionType);
			addressUpdatedFieldValueMap.put(MYLOConstants.DESTINATION_CITY, BusinessFunctions
					.setMyloInputFields(driver, MYLOConstants.DESTINATION_CITY, cityValue, _destCity, type));
		}
	}

	public String getFieldNameForUpdatingValue(String fieldName) {
		fieldName = (fieldName.equals(MYLOConstants.ORIGIN_COUNTRY)) ? MYLOConstants.ORIGIN_COUNTRY_VALUE
				: (fieldName.equals(MYLOConstants.DESTINATION_COUNTRY)) ? MYLOConstants.DESTINATION_COUNTRY_VALUE
						: (fieldName.equals(MYLOConstants.ORIGIN_STATE)) ? MYLOConstants.ORIGIN_STATE_VALUE
								: (fieldName.equals(MYLOConstants.DESTINATION_STATE))
										? MYLOConstants.DESTINATION_STATE_VALUE
										: fieldName;
		return fieldName;
	}

	public String getAddressFieldValue(String fieldName, String sectionType) {
		mapAddressSectionWebElements();
		List<String> textValues = new ArrayList<String>(
				Arrays.asList(MYLOConstants.ORIGIN_COUNTRY_VALUE, MYLOConstants.DESTINATION_COUNTRY_VALUE,
						MYLOConstants.STATEVALUE, MYLOConstants.ORIGIN_ADDRESS_COPY_BUTTON,
						MYLOConstants.DESTINATION_ADDRESS_COPY_BUTTON, MYLOConstants.COMPLETE_ORIGIN_ADDRESS,
						MYLOConstants.COMPLETE_DESTINATION_ADDRESS, MYLOConstants.COMPLETE_MAILING_ADDRESS));
		String requiredValue = "";
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, addressWebElementsMap.get(fieldName), fieldName);
			requiredValue = (textValues.contains(fieldName))
					? CoreFunctions.getElementText(driver, addressWebElementsMap.get(fieldName))
					: CoreFunctions.getAttributeText(addressWebElementsMap.get(fieldName), MYLOConstants.VALUE);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, sectionType));
		}
		return requiredValue;
	}

	public boolean isAddressElementExist(String elementName) {
		mapAddressSectionWebElements();
		boolean flag = CoreFunctions.isElementExist(driver, addressWebElementsMap.get(elementName), 5);
		if (flag)
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, elementName));
		return flag;
	}

	public void addressSectionButtonEnabilityStatus(String type, String btnName, String sectionType) {
		mapAddressSectionWebElements();
		BusinessFunctions.verifyMyloButtonEnabilityStatus(type, addressWebElementsMap.get(btnName), btnName,
				sectionType, MYLOConstants.JOURNEY);
	}

	public void verifyAddressSectionToastMessages(String sectionType, DataTable table) {
		setAddressMandatoryFields(MYLOConstants.RANDOM, MYLOConstants.STATE_VALUE, MYLOConstants.CITY_VALUE,
				sectionType, MYLOConstants.VALUE);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			String fieldValue = data.get(i).get(MYLOConstants.CHARACTER_LENGTH);
			BusinessFunctions.setMyloInputFields(driver, fieldName, fieldValue,
					addressWebElementsMap.get(fieldName), MYLOConstants.RANDOM_STRING);
			clickSaveBtn(sectionType);
			Assert.assertTrue(
					BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage,
							data.get(i).get(MYLOConstants.MESSAGE), sectionType),
					MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL,
							data.get(i).get(MYLOConstants.MESSAGE), _alertMessage.getText(), MYLOConstants.JOURNEY));
			closeToastmessage();
			setAddressFieldValues(fieldName, MYLOConstants.TEST, MYLOConstants.VALUE, sectionType);
		}
	}
	
	public String setCountryStateField(WebElement element,String fieldValue,String section) {
		CoreFunctions.highlightElementAndClick(driver, element, section);
		List<WebElement> dropdownList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		String updatedValue=(fieldValue.equals(MYLOConstants.RANDOM))?CoreFunctions.getRandomElementValueFromList(driver, dropdownList):fieldValue;
		BusinessFunctions.selectItemFromListUsingText(driver, dropdownList, updatedValue);
		return updatedValue;
	}
	
	public void addOriginAddressIfNotPresent() {
		if (MyloNewFileUtil.get_orgAddress1() == null) {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			CoreFunctions.scrollClickUsingJS(driver, _addOrgnAddressLink, MYLOConstants.ADD_ORIGIN_ADDRESS);
			MyloNewFileUtil.set_orgCountry(setCountryStateField(_Country,MYLOConstants.USA_STATE,MYLOConstants.ORIGIN_COUNTRY));
			MyloNewFileUtil.set_orgState(setCountryStateField(_State,MYLOConstants.RANDOM,MYLOConstants.ORIGIN_STATE));
			MyloNewFileUtil.set_orgCity(BusinessFunctions.setMyloInputFields(driver,
					MYLOConstants.ORIGIN_CITY, "8", _city, MYLOConstants.RANDOM_STRING));
			MyloNewFileUtil.set_orgZipCode(BusinessFunctions.setMyloInputFields(driver,
					MYLOConstants.ORIGIN_ZIPCODE, "8", _zipCode, MYLOConstants.RANDOM_INTEGER));
			MyloNewFileUtil.set_orgAddress1(BusinessFunctions.setMyloInputFields(driver,
					MYLOConstants.ORIGIN_ADDRESS1, "15", _address1, MYLOConstants.RANDOM_STRING));
			MyloNewFileUtil.set_orgAddress2(BusinessFunctions.setMyloInputFields(driver,
					MYLOConstants.ORIGIN_ADDRESS2, "15", _address2, MYLOConstants.RANDOM_STRING));
			CoreFunctions.highlightElementAndClick(driver, _saveBtn, MYLOConstants.ORIGIN_ADDRESS_SAVE_BUTTON);
		}
	}
		
	public void addDestinationAddressIfNotPresent() {
		if (MyloNewFileUtil.get_destAddress1() == null) {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			CoreFunctions.scrollClickUsingJS(driver, _addDestAddressLink, MYLOConstants.ADD_DESTINATION_ADDRESS);
			MyloNewFileUtil.set_destCountry(setCountryStateField(_Country,MYLOConstants.USA_STATE,MYLOConstants.DESTINATION_COUNTRY));
			MyloNewFileUtil.set_destState(setCountryStateField(_State,MYLOConstants.RANDOM,MYLOConstants.DESTINATION_STATE));
			MyloNewFileUtil.set_destCity(BusinessFunctions.setMyloInputFields(driver,
					MYLOConstants.DESTINATION_CITY, "8", _city, MYLOConstants.RANDOM_STRING));
			MyloNewFileUtil.set_destZipCode(BusinessFunctions.setMyloInputFields(
					driver, MYLOConstants.DESTINATION_ZIPCODE, "8", _zipCode, MYLOConstants.RANDOM_INTEGER));
			MyloNewFileUtil.set_destAddress1(BusinessFunctions.setMyloInputFields(
					driver, MYLOConstants.DESTINATION_ADDRESS1, "15", _address1, MYLOConstants.RANDOM_STRING));
			MyloNewFileUtil.set_destAddress2(BusinessFunctions.setMyloInputFields(
					driver, MYLOConstants.DESTINATION_ADDRESS2, "15", _address2, MYLOConstants.RANDOM_STRING));
			CoreFunctions.highlightElementAndClick(driver, _saveBtn, MYLOConstants.DESTINATION_ADDRESS_SAVE_BUTTON);
		}
	}
	
	public void scrollToSection(String sectionName) {
		if(sectionName.equals(MYLOConstants.DESTINATION_ADDRESS))
			CoreFunctions.scrollToElementUsingJavaScript(driver, _destinationAddressHeader, MYLOConstants.DESTINATION_ADDRESS);
		else
			CoreFunctions.scrollToElementUsingJavaScript(driver, _originAddressHeader, MYLOConstants.ORIGIN_ADDRESS);
	}

	public void verifyMandatoryFieldsToastMessagesAddressSection(String sectionType, DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			scrollToSection(sectionType);
			setAddressMandatoryFields(data.get(i).get(MYLOConstants.COUNTRY),
					data.get(i).get(MYLOConstants.STATE_TEXT_FIELD), data.get(i).get(MYLOConstants.CITY), sectionType,
					MYLOConstants.RANDOM_STRING);
			clickSaveBtn(sectionType);
			Assert.assertTrue(
					BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage,
							data.get(i).get(MYLOConstants.MESSAGE), sectionType),
					MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL,
							data.get(i).get(MYLOConstants.MESSAGE), _alertMessage.getText(), MYLOConstants.JOURNEY));
			closeToastmessage();
		}
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
		return flag;
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

	public boolean verifyAddressCopied(String sectionType) {
		String fullAddress = (sectionType.equals(MYLOConstants.ORIGIN_ADDRESS)) ? MYLOConstants.COMPLETE_ORIGIN_ADDRESS
				: MYLOConstants.COMPLETE_DESTINATION_ADDRESS;
		String addressToBeOverwridden = getAddressFieldValue(fullAddress, sectionType);
		String mailingAddress = getAddressFieldValue(MYLOConstants.COMPLETE_MAILING_ADDRESS,
				MYLOConstants.MAILING_ADDRESS);
		return (addressToBeOverwridden.equals(mailingAddress));
	}
}
