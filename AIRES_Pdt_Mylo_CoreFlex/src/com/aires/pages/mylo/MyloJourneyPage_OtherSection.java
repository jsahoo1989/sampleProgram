package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_OtherSection extends Base {
	
	public MyloJourneyPage_OtherSection(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;
	
	@FindBy(how = How.CSS, using = "app-transferee-family button[aria-controls='collapseOneTransferee']")
	private WebElement _transfereeAndFamilySection;
	
	@FindBy(how = How.CSS, using = "h2[class*='accchildhead']")
	private List<WebElement> _transfereeAndFamilySectionHeaders;
	
	@FindBy(how = How.CSS, using = "i[class='icon-FloppyDisk_Open']")
	private WebElement _otherSaveIcon;
	
	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Add Other Contact']")
	private WebElement _addOtherLink;
	
	@FindBy(how = How.CSS, using = "ng-select[name='O_Gender']")
	private WebElement _otherGender;
	
	@FindBy(how = How.CSS, using = "input[name='O_Title']")
	private WebElement _otherRelationship;
	
	@FindBy(how = How.CSS, using = "ng-select[name='O_Dest']")
	private WebElement _otherDestination;
	
	@FindBy(how = How.CSS, using = "ng-select[name='O_Citizenship']")
	private WebElement _otherCitizenship;
	
	@FindBy(how = How.ID, using = "O_firstname")
	private WebElement _otherFirstName;
	
	@FindBy(how = How.ID, using = "O_middlename")
	private WebElement _otherMiddleName;
	
	@FindBy(how = How.ID, using = "O_lastname")
	private WebElement _otherLastName;
	
	@FindBy(how = How.ID, using = "O_preferredname")
	private WebElement _otherPreferredName;
	
	@FindBy(how = How.ID, using = "O_Suffix")
	private WebElement _otherSuffix;
	
	@FindBy(how = How.ID, using = "O_MaidenName")
	private WebElement _otherMaidenName;
	
	@FindBy(how = How.CSS, using = "ng-select[name='O_Pronouns']")
	private WebElement _otherPronouns;
	
	@FindBy(how = How.ID, using = "O_DOB")
	private WebElement _otherDateOfBirth;
	
	@FindBy(how = How.XPATH, using = "//a[text()=' Add Phone ']")
	private WebElement _otherAddPhone;

	@FindBy(how = How.XPATH, using = "//a[text()=' Add Email ']")
	private WebElement _otherAddEmail;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	private WebElement _otherSaveButton;
	
	@FindBy(how = How.CSS, using = "app-others i[class='icon-Pencil_Open']")
	private WebElement _otherEditButton;
	
	@FindBy(how = How.CSS, using = "h2[id='headingChildSeven'] button")
	private WebElement _expandOtherSection;
	
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm btn']")
	private WebElement _YesButton;
	
	@FindBy(how = How.CSS, using = "button[class*='toast-close-btn']")
	private WebElement _closeBtn;
	
	@FindBy(how = How.ID, using = "P_Number")
	private List<WebElement> _otherPhoneNumber;

	@FindBy(how = How.ID, using = "T_Email")
	private List<WebElement> _otherEmailAddress;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Orig'] span[class='ng-value-label ng-star-inserted']")
	private List<WebElement> _otherPhoneOrgDestDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Type'] span[class='ng-value-label ng-star-inserted']")
	private List<WebElement> _otherPhoneTypeDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[name='T_Type2'] span[class='ng-value-label ng-star-inserted']")
	private List<WebElement> _otherEmailTypeDropdownValue;
	
	@FindBy(how = How.CSS, using = "ng-select[name='T_Type2']")
	private List<WebElement> _otherEmailTypeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Type']")
	private List<WebElement> _otherPhoneTypeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Orig']")
	private List<WebElement> _otherPhoneOrgDestDropdown;
	
	@FindBy(how = How.CSS, using = "input[id='P_Preferred']")
	private List<WebElement> _otherPhonePreferred;

	@FindBy(how = How.CSS, using = "input[id='P_Preferred']+span")
	private List<WebElement> _otherPhonePreferredSelect;
	
	@FindBy(how = How.CSS, using = "input[id='T_Preferred2']")
	private List<WebElement> _otherEmailPreferred;

	@FindBy(how = How.CSS, using = "input[id='T_Preferred2']+ span")
	private List<WebElement> _otherEmailPreferredSelect;
	
	final By _dropdownOptions = By.cssSelector("div[role='option']>span");
	final By _genderDropdownOptions = By.cssSelector("div[role='option']>div");
	
	LinkedHashMap<String, WebElement> otherWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, List<String>> otherDropdownFieldOptions = new LinkedHashMap<String, List<String>>();
	LinkedHashMap<String, String> otherUpdatedFieldValuesMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> otherFieldCharacterLimitMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> otherUpdatedDropdownFieldValuesMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, List<WebElement>> otherPhoneEmailFieldsMap = new LinkedHashMap<String, List<WebElement>>();
	List<String> originDestOption = new ArrayList<String>();
	List<String> phoneTypeOption = new ArrayList<String>();
	List<String> emailTypeOption = new ArrayList<String>();
	
	/**
	 * Map all Dependent Web Elements with Name
	 */
	public void mapOtherWebElementFields() {
		otherWebElementsMap.put(MYLOConstants.ADD_OTHER_LINK, _addOtherLink);
		otherWebElementsMap.put(MYLOConstants.GENDER, _otherGender);
		otherWebElementsMap.put(MYLOConstants.RELATIONSHIP, _otherRelationship);
		otherWebElementsMap.put(MYLOConstants.DESTINATION, _otherDestination);
		otherWebElementsMap.put(MYLOConstants.CITIZENSHIP, _otherCitizenship);
		otherWebElementsMap.put(MYLOConstants.OTHER_FIRSTNAME, _otherFirstName);
		otherWebElementsMap.put(MYLOConstants.OTHER_MIDDLENAME, _otherMiddleName);
		otherWebElementsMap.put(MYLOConstants.OTHER_LASTNAME, _otherLastName);
		otherWebElementsMap.put(MYLOConstants.OTHER_PREFERREDNAME, _otherPreferredName);
		otherWebElementsMap.put(MYLOConstants.OTHER_SUFFIX, _otherSuffix);
		otherWebElementsMap.put(MYLOConstants.OTHER_MAIDENNAME, _otherMaidenName);
		otherWebElementsMap.put(MYLOConstants.PRONOUNS, _otherPronouns);
		otherWebElementsMap.put(MYLOConstants.OTHER_DOB, _otherDateOfBirth);
		otherWebElementsMap.put(MYLOConstants.OTHER_ADD_PHONE, _otherAddPhone);
		otherWebElementsMap.put(MYLOConstants.OTHER_ADD_EMAIL, _otherAddEmail);
		otherWebElementsMap.put(MYLOConstants.EDIT_BUTTON, _otherEditButton);
		otherWebElementsMap.put(MYLOConstants.OTHER_DRODOWN_ARROW, _expandOtherSection);
		otherWebElementsMap.put(MYLOConstants.YES_BUTTON, _YesButton);
		otherWebElementsMap.put(MYLOConstants.SAVE_BUTTON, _otherSaveButton);
	}
	
	/**
	 * @param element
	 * @param elementName
	 * @return
	 * It returns the list of all options available in Partner Dropdown field
	 */
	public List<String> returnDropDownOptionsList(WebElement element, String elementName) {
		List<String> requiredList = new ArrayList<String>();
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, elementName);
			CoreFunctions.highlightElementAndClick(driver, element, elementName);
			requiredList = (elementName.equals(MYLOConstants.GENDER))?CoreFunctions.getElementListByLocator(driver, _genderDropdownOptions).stream()
					.map(x -> x.getText()).collect(Collectors.toList()):CoreFunctions.getElementListByLocator(driver, _dropdownOptions).stream()
					.map(x -> x.getText()).collect(Collectors.toList());
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, elementName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					elementName, MYLOConstants.DEPENDENT));
		}
		return requiredList;
	}
	
	
	public void saveDropdownListOptionsOnOtherSection(String fieldName) {
		mapOtherWebElementFields();
		otherDropdownFieldOptions.put(fieldName, returnDropDownOptionsList(otherWebElementsMap.get(fieldName), fieldName));
	}
	
	public List<String> getCountryDBValues(String fieldName) {
		List<String> countryDBValues = DbFunctions.getTransfereeDropdownListValues(fieldName);
		countryDBValues.remove(MYLOConstants.USA_STATE);
		return countryDBValues;
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Verify DropDownList values from Database
	 */
	public boolean verifyOtherFieldDropdownListOptions(String fieldName) {
		boolean flag = false;
		List<String> destinationOption = new ArrayList<String>();
		destinationOption.add("Yes");
		destinationOption.add("No");
		List<String> valuesFromUI = otherDropdownFieldOptions.get(fieldName);
		valuesFromUI.remove(MYLOConstants.SELECT_ONE);
		valuesFromUI.remove(MYLOConstants.USA_STATE);
		try {
			flag=(fieldName.equals(MYLOConstants.DESTINATION))?destinationOption.equals(valuesFromUI):
					(fieldName.equals(MYLOConstants.CITIZENSHIP))?getCountryDBValues(fieldName).equals(valuesFromUI):
					DbFunctions.getTransfereeDropdownListValues(fieldName).equals(valuesFromUI);

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MATCH, CoreConstants.PASS,
					fieldName, MYLOConstants.OTHER));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MISMATCH,
					CoreConstants.FAIL, fieldName, MYLOConstants.OTHER));
		return flag;
	}
	
	/**
	 * @param fieldName
	 * Click respective fields of Dependent section
	 */
	public void clickFieldsOnOtherSection(String fieldName) {
		mapOtherWebElementFields();
		try {
			WebElement element = otherWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, fieldName,100);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.OTHER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		}
	}
	
	/**
	 * @param fieldName
	 * @param fieldValue
	 * Set Value of different fields on Other section
	 */
	public void setOtherFields(String fieldName, String fieldValue) {
		mapOtherWebElementFields();
		try {
			WebElement reqWebElement = otherWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			if (fieldValue.equals(""))
				CoreFunctions.scrollToElementUsingJavaScript(driver,  _transfereeAndFamilySectionHeaders.get(3),
						MYLOConstants.OTHER);
			String setValue = CoreFunctions.setDifferentFieldsForMylo(driver, reqWebElement, fieldName, fieldValue);
			otherUpdatedFieldValuesMap.put(fieldName, setValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.OTHER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		}
	}
	
	/**
	 * Click on Other Save button
	 */
	public void clickOtherSaveButton() {
		try {
			//CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySection,
				//	MYLOConstants.TRANSFEREE_FAMILY);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _otherSaveIcon, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			//CoreFunctions.highlightElementAndClick(driver, _otherSaveIcon, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.scrollClickUsingJS(driver,_otherSaveIcon, MYLOConstants.SAVE_BUTTON);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.SAVE_BUTTON, MYLOConstants.OTHER, MYLOConstants.JOURNEY));
			Assert.fail(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.SAVE_BUTTON, MYLOConstants.OTHER, MYLOConstants.JOURNEY));
		}
	}
	
	/**
	 * Click on Other Save button
	 */
	public void clickSaveButtonOnOtherSection() {
		try {
			//CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySection,
				//	MYLOConstants.TRANSFEREE_FAMILY);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _otherSaveIcon, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.highlightElementAndClick(driver, _otherSaveIcon, MYLOConstants.SAVE_BUTTON);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.SAVE_BUTTON, MYLOConstants.OTHER, MYLOConstants.JOURNEY));
			Assert.fail(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.SAVE_BUTTON, MYLOConstants.OTHER, MYLOConstants.JOURNEY));
		}
	}
	
	/**
	 * @param table
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Other section
	 */
	public boolean verifyMandatoryFieldsToastMessagesOtherSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setOtherFields(MYLOConstants.OTHER_FIRSTNAME,
					data.get(i).get(MYLOConstants.OTHER_FIRSTNAME));
			setOtherFields(MYLOConstants.OTHER_LASTNAME, data.get(i).get(MYLOConstants.OTHER_LASTNAME));
			clickOtherSaveButton();
			flag = (verifyOtherSectionToastMessage(data.get(i).get(MYLOConstants.MESSAGE)));
		}
		return flag;
	}
	
	/**
	 * Map all Character Limits with respective Fields
	 */
	public void mapOtherFieldsCharacterLimitMap() {
		otherFieldCharacterLimitMap.put(MYLOConstants.OTHER_FIRSTNAME,
				MYLOConstants.PARTNER_FIRSTNAME_CHAR_LIMIT);
		otherFieldCharacterLimitMap.put(MYLOConstants.OTHER_LASTNAME,
				MYLOConstants.PARTNER_LASTNAME_CHAR_LIMIT);
		otherFieldCharacterLimitMap.put(MYLOConstants.OTHER_MIDDLENAME,
				MYLOConstants.PARTNER_MIDDLENAME_CHAR_LIMIT);
		otherFieldCharacterLimitMap.put(MYLOConstants.OTHER_SUFFIX,
				MYLOConstants.PARTNER_SUFFIX_CHAR_LIMIT);
		otherFieldCharacterLimitMap.put(MYLOConstants.OTHER_MAIDENNAME,
				MYLOConstants.PARTNER_MAIDENNAME_CHAR_LIMIT);
		otherFieldCharacterLimitMap.put(MYLOConstants.OTHER_PHONE_NUMBER,
				MYLOConstants.PARTNER_PHONE_NUMBER_CHAR_LIMIT);
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Verify Updated Values in respective fields of Other section
	 */
	public boolean verifyOtherFieldsUpdatedValue(String fieldName) {
		boolean flag = false;
		mapOtherFieldsCharacterLimitMap();
		String updatedValue = null;
		CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		try {
			updatedValue = otherUpdatedFieldValuesMap.get(fieldName);
			int fieldCharLimit = Integer.parseInt(otherFieldCharacterLimitMap.get(fieldName));
			updatedValue = updatedValue.length() > fieldCharLimit ? updatedValue.substring(0, fieldCharLimit)
					: updatedValue;
			flag = getOtherFields(fieldName).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.OTHER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.OTHER));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Get the Field Value of all Fields available on Partner section
	 */
	public String getOtherFields(String fieldName) {
		mapOtherWebElementFields();
		String requiredValue = null;
		List<String> dropdownFields = new ArrayList<String>();
		dropdownFields.add(MYLOConstants.CITIZENSHIP);
		dropdownFields.add(MYLOConstants.GENDER);
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, otherWebElementsMap.get(fieldName), fieldName);
			requiredValue = (dropdownFields.contains(fieldName))
					? CoreFunctions.getElementText(driver, otherWebElementsMap.get(fieldName))
					: CoreFunctions.getAttributeText(otherWebElementsMap.get(fieldName),
							MYLOConstants.TITLE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.OTHER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		}
		return requiredValue;
	}
	
	/**
	 * @param table
	 * @return
	 * 	Verify Toast Messages for Special Characters entered in fields of Other section
	 */
	public boolean verifySpecialCharacterToastMessagesOtherSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			setOtherFields(fieldName, MYLOConstants.SPECIAL_CHARACTERS_STRING);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _otherSaveIcon, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.highlightElementAndClick(driver, _otherSaveIcon, MYLOConstants.SAVE_BUTTON);
			flag = (verifyOtherSectionToastMessage(data.get(i).get(MYLOConstants.MESSAGE)));
			clickToastMesssgeCloseIcon();
			setOtherFields(fieldName, MYLOConstants.TEST);
		}
		return flag;
	}
	
	/**
	 * Click on Close Icon of Toast Message
	 */
	public void clickToastMesssgeCloseIcon() {
		try {
			CoreFunctions.isElementVisible(_closeBtn);
			CoreFunctions.highlightObject(driver, _closeBtn);
			CoreFunctions.sendKeysUsingAction(driver, _closeBtn, MYLOConstants.CLOSE_BUTTON);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.CLOSE_BUTTON, MYLOConstants.OTHER, MYLOConstants.JOURNEY));
			Assert.fail(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.CLOSE_BUTTON, MYLOConstants.OTHER, MYLOConstants.JOURNEY));
		}
	}
	
	/**
	 * @param table
	 * @return
	 * Verify Updated Values in respective fields of Dependent section
	 */
	public boolean verifyDifferentOtherFieldsUpdatedValue(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = (verifyOtherFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME)));
		}
		return flag;
	}
	
	/**
	 * @param elementName
	 * Scroll to respective element of Other Fields 
	 */
	public void scrollToOtherElement(String elementName) {
		mapOtherWebElementFields();
		try {
			CoreFunctions.scrollToElementUsingJavaScript(driver, otherWebElementsMap.get(elementName),
					elementName);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, elementName, MYLOConstants.OTHER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					elementName, MYLOConstants.OTHER));
		}
	}
	
	/**
	 * @param table
	 * @param buttonName
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Other Phone/Email section
	 */
	public boolean verifyMandatoryFieldsToastMessagesOtherPhoneEmailSection(DataTable table, String buttonName) {
		boolean flag = false;
		flag = (buttonName.equals(MYLOConstants.OTHER_ADD_PHONE))
				? verifyMandatoryFieldsToastMessagesOtherPhoneSection(table)
				: verifyMandatoryFieldsToastMessagesOtherEmailSection(table);
		return flag;
	}
	
	/**
	 * @param table
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Partner Email section
	 */
	public boolean verifyMandatoryFieldsToastMessagesOtherEmailSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setOtherPhoneEmailFields(MYLOConstants.OTHER_EMAIL_ADDRESS,
					data.get(i).get(MYLOConstants.OTHER_EMAIL_ADDRESS), 0);
			clickDropdownFieldsOnOtherSection(MYLOConstants.OTHER_EMAIL_TYPE, 0);
			setDifferentDropDownFields(MYLOConstants.OTHER_EMAIL_TYPE,
					data.get(i).get(MYLOConstants.OTHER_EMAIL_TYPE));
			clickOtherSaveButton();
			flag = (verifyOtherSectionToastMessage(data.get(i).get(MYLOConstants.MESSAGE)));
		}
		return flag;
	}
	
	/**
	 * @param elementName
	 * @param index
	 * Click respective dropdown fields of Other section
	 */
	public void clickDropdownFieldsOnOtherSection(String elementName, int index) {
		CoreFunctions.scrollToElementUsingJavaScript(driver, _otherPreferredName, MYLOConstants.OTHER_PREFERREDNAME);
		switch (elementName) {
		case MYLOConstants.OTHER_ORGDEST:
			originDestOption = returnDropDownOptionsList(_otherPhoneOrgDestDropdown.get(index), elementName);
			break;
		case MYLOConstants.OTHER_PHONE_TYPE:
			phoneTypeOption = returnDropDownOptionsList(_otherPhoneTypeDropdown.get(index), elementName);
			break;
		case MYLOConstants.OTHER_EMAIL_TYPE:
			emailTypeOption = returnDropDownOptionsList(_otherEmailTypeDropdown.get(index), elementName);
			break;
		case MYLOConstants.OTHER_PHONE_PREFERRED:
			CoreFunctions.click(driver, _otherPhonePreferredSelect.get(index), elementName);
			break;
		case MYLOConstants.OTHER_EMAIL_PREFERRED:
			CoreFunctions.scrollToElementUsingJavaScript(driver, _otherCitizenship, MYLOConstants.CITIZENSHIP);
			CoreFunctions.click(driver, _otherEmailPreferredSelect.get(index), elementName);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
		}
	}
	
	/**
	 * @param table
	 * @return
	 * 	Verify Toast Messages for Mandatory Fields of Other Phone section
	 */
	public boolean verifyMandatoryFieldsToastMessagesOtherPhoneSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setOtherPhoneEmailFields(MYLOConstants.OTHER_PHONE_NUMBER,
					data.get(i).get(MYLOConstants.OTHER_PHONE_NUMBER), 0);
			clickDropdownFieldsOnOtherSection(MYLOConstants.OTHER_ORGDEST, 0);
			setDifferentDropDownFields(MYLOConstants.OTHER_ORGDEST,
					data.get(i).get(MYLOConstants.OTHER_ORGDEST));
			clickDropdownFieldsOnOtherSection(MYLOConstants.OTHER_PHONE_TYPE, 0);
			setDifferentDropDownFields(MYLOConstants.OTHER_PHONE_TYPE,
					data.get(i).get(MYLOConstants.OTHER_PHONE_TYPE));
			clickOtherSaveButton();
			flag = (verifyOtherSectionToastMessage(data.get(i).get(MYLOConstants.MESSAGE)));
		}
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param fieldValue
	 * Set Value of different dropdown fields on Other section
	 */
	public void setDifferentDropDownFields(String fieldName, String fieldValue) {
		String updatedValue = null;
		try {
			List<WebElement> optionList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			updatedValue = BusinessFunctions.setDifferentDropDownFieldsForMylo(driver, fieldValue, optionList);
			otherUpdatedDropdownFieldValuesMap.put(fieldName, updatedValue);
			otherUpdatedFieldValuesMap.put(fieldName, updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.OTHER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		}
	}
	
	/**
	 * @param fieldName
	 * @param fieldValue
	 * @param index
	 * Set Value of different Phone/Email fields on Dependent section
	 */
	public void setOtherPhoneEmailFields(String fieldName, String fieldValue, int index) {
		mapOtherPhoneEmailField();
		try {
			WebElement reqWebElement = otherPhoneEmailFieldsMap.get(fieldName).get(index);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			if (fieldValue.equals(""))
				CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySectionHeaders.get(3),
						MYLOConstants.OTHER);
			String setValue = CoreFunctions.setDifferentFieldsForMylo(driver, reqWebElement, fieldName, fieldValue);
			otherUpdatedFieldValuesMap.put(fieldName, setValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.OTHER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		}
	}
	
	/**
	 * Map all Dependent Phone/Email Field Values
	 */
	public void mapOtherPhoneEmailField() {
		otherPhoneEmailFieldsMap.put(MYLOConstants.OTHER_PHONE_NUMBER, _otherPhoneNumber);
		otherPhoneEmailFieldsMap.put(MYLOConstants.OTHER_ORGDEST, _otherPhoneOrgDestDropdownValue);
		otherPhoneEmailFieldsMap.put(MYLOConstants.OTHER_PHONE_TYPE, _otherPhoneTypeDropdownValue);
		otherPhoneEmailFieldsMap.put(MYLOConstants.OTHER_EMAIL_ADDRESS, _otherEmailAddress);
		otherPhoneEmailFieldsMap.put(MYLOConstants.OTHER_EMAIL_TYPE, _otherEmailTypeDropdownValue);
	}
	
	/**
	 * @param table
	 * @param buttonName
	 * Set Value of all Phone/Email fields on Other section
	 */
	public void setFieldsOtherPhoneEmailSection(DataTable table, String buttonName) {
		if (buttonName.equals(MYLOConstants.OTHER_ADD_PHONE))
			setMandatoryFieldsOtherPhoneSection(table, 0);
		else
			setMandatoryFieldsOtherEmailSection(table, 0);
	}
	
	/**
	 * @param table
	 * @param index
	 * Set Value of all Email fields on Other section
	 */
	public void setMandatoryFieldsOtherEmailSection(DataTable table, int index) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setOtherPhoneEmailFields(data.get(i).get(MYLOConstants.FIELD_NAME),
					data.get(i).get(MYLOConstants.FIELD_VALUE), index);
			clickDropdownFieldsOnOtherSection(MYLOConstants.OTHER_EMAIL_TYPE, index);
			setDifferentDropDownFields(MYLOConstants.OTHER_EMAIL_TYPE,
					data.get(i).get(MYLOConstants.OTHER_EMAIL_TYPE));
		}
	}
	
	/**
	 * @param table
	 * @param index
	 * Set Value of all Phone fields on Other section
	 */
	public void setMandatoryFieldsOtherPhoneSection(DataTable table, int index) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setOtherPhoneEmailFields(data.get(i).get(MYLOConstants.FIELD_NAME),
					data.get(i).get(MYLOConstants.CHARACTER_LENGTH), index);
			clickDropdownFieldsOnOtherSection(MYLOConstants.OTHER_ORGDEST, index);
			setDifferentDropDownFields(MYLOConstants.OTHER_ORGDEST,
					data.get(i).get(MYLOConstants.OTHER_ORGDEST));
			clickDropdownFieldsOnOtherSection(MYLOConstants.OTHER_PHONE_TYPE, index);
			setDifferentDropDownFields(MYLOConstants.OTHER_PHONE_TYPE,
					data.get(i).get(MYLOConstants.OTHER_PHONE_TYPE));
		}
	}
	
	/**
	 * @param table
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Other Phone section
	 */
	public boolean verifyDifferentOtherPhoneFieldsUpdatedValue(DataTable table, int index) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = (verifyOtherPhoneFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME), index));
		}
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Dependent Phone section
	 */
	public boolean verifyOtherPhoneFieldsUpdatedValue(String fieldName, int index) {
		boolean flag = false;
		mapOtherFieldsCharacterLimitMap();
		String updatedValue = null;
		try {
			updatedValue = otherUpdatedFieldValuesMap.get(fieldName);
			int fieldCharLimit = Integer.parseInt(otherFieldCharacterLimitMap.get(fieldName));
			updatedValue = updatedValue.length() > fieldCharLimit ? updatedValue.substring(0, fieldCharLimit)
					: updatedValue;
			flag = getOtherPhoneEmailFields(fieldName, index).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.OTHER));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Get the Field Value of all Phone/Email Fields available on Dependent section
	 */
	public String getOtherPhoneEmailFields(String fieldName, int index) {
		mapOtherPhoneEmailField();
		String requiredValue = null;
		List<String> dropdownFields = new ArrayList<String>();
		dropdownFields.add(MYLOConstants.OTHER_EMAIL_TYPE);
		dropdownFields.add(MYLOConstants.OTHER_PHONE_TYPE);
		dropdownFields.add(MYLOConstants.OTHER_ORGDEST);
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver,
					otherPhoneEmailFieldsMap.get(fieldName).get(index), fieldName);
			requiredValue = (dropdownFields.contains(fieldName))
					? CoreFunctions.getElementText(driver, otherPhoneEmailFieldsMap.get(fieldName).get(index))
					: CoreFunctions.getAttributeText(otherPhoneEmailFieldsMap.get(fieldName).get(index),
							MYLOConstants.TITLE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.OTHER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		}
		return requiredValue;
	}
	
	/**
	 * @param table
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Partner Email section
	 */
	public boolean verifyDifferentOtherEmailFieldsUpdatedValue(DataTable table, int index) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = ((verifyOtherEmailFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME), index)));
		}
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Partner Email section
	 */
	public boolean verifyOtherEmailFieldsUpdatedValue(String fieldName, int index) {
		boolean flag = false;
		String updatedValue = null;
		try {
			updatedValue = otherUpdatedFieldValuesMap.get(fieldName);
			flag = getOtherPhoneEmailFields(fieldName, index).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.OTHER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.OTHER));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER));
		return flag;
	}
	

	/**
	 * @param section
	 * @param index
	 * @param number
	 * @return
	 * Check whether Preferred checkbox is selected for Other Phone/Email section
	 */
	public boolean isPreferredChecked(String section, int index, String number) {
		boolean flag=false;
		try {
			flag = (section.equals(MYLOConstants.OTHER_PHONE_NUMBER))
					? _otherPhonePreferred.get(index).isSelected()
					: _otherEmailPreferred.get(index).isSelected();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, section, MYLOConstants.OTHER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					section, MYLOConstants.OTHER));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_SELECTED, CoreConstants.PASS,
					number, MYLOConstants.PREFERRED, section, MYLOConstants.OTHER));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_NOT_SELECTED, CoreConstants.PASS,
					number, MYLOConstants.PREFERRED, section, MYLOConstants.OTHER));
		return flag;
	}
	
	/**
	 * @param table
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Other section
	 */
	public boolean verifyMandatoryToastMessageNewOtherSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setOtherFields(MYLOConstants.OTHER_FIRSTNAME,
					data.get(i).get(MYLOConstants.OTHER_FIRSTNAME));
			setOtherFields(MYLOConstants.OTHER_LASTNAME, data.get(i).get(MYLOConstants.OTHER_LASTNAME));
			clickFieldsOnOtherSection(MYLOConstants.SAVE_BUTTON);
			//clickOtherSaveButton();
			flag = (verifyOtherSectionToastMessage(data.get(i).get(MYLOConstants.MESSAGE)));
		}
		return flag;
	}
	

	public boolean verifyOtherSectionToastMessage(String msg) {
		boolean flag = false;
		flag = (BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, msg, MYLOConstants.TRANSFEREE_FAMILY));
		Assert.assertTrue(flag, MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL, msg,
				_alertMessage.getText(), MYLOConstants.JOURNEY));
		return flag;
	}

}
