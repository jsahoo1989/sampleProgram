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
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_PartnerSection extends Base {
	
	public MyloJourneyPage_PartnerSection(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;
	
	@FindBy(how = How.CSS, using = "#partnerList+div a")
	private WebElement _addPartnerLink;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Gender']")
	private WebElement _partnerGender;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Title']")
	private WebElement _partnerRelationship;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Dest']")
	private WebElement _partnerNewDestination;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Citizenship']")
	private WebElement _partnerCitizenship;
	
	@FindBy(how = How.ID, using = "P_firstname")
	private WebElement _partnerFirstName;
	
	@FindBy(how = How.ID, using = "P_middlename")
	private WebElement _partnerMiddleName;
	
	@FindBy(how = How.ID, using = "P_lastname")
	private WebElement _partnerLastName;
	
	@FindBy(how = How.ID, using = "P_Suffix")
	private WebElement _partnerSuffix;
	
	@FindBy(how = How.ID, using = "P_MaidenName")
	private WebElement _partnerMaidenName;
	
	@FindBy(how = How.ID, using = "P_preferredname")
	private WebElement _partnerPreferredName;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Pronouns']")
	private WebElement _partnerPronouns;
	
	@FindBy(how = How.ID, using = "P_Age")
	private WebElement _partnerAge;
	
	@FindBy(how = How.ID, using = "P_DOB")
	private WebElement _partnerDateOfBirth;
	
	@FindBy(how = How.XPATH, using = "//a[text()=' Add Phone ']")
	private WebElement _partnerAddPhone;

	@FindBy(how = How.XPATH, using = "//a[text()=' Add Email ']")
	private WebElement _partnerAddEmail;
	
	@FindBy(how = How.CSS, using = "app-transferee-family button[aria-controls='collapseTwo']")
	private WebElement _transfereeAndFamilySection;
	
	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;
	
	@FindBy(how = How.CSS, using = "i[class='icon-FloppyDisk_Open']")
	private WebElement _partnerSaveIcon;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	private WebElement _partnerSaveButton;
	
	@FindBy(how = How.CSS, using = "app-partner i[class='icon-Pencil_Open']")
	private WebElement _partnerEditButton;
	
	@FindBy(how = How.CSS, using = "h2[id='headingChildThree'] button")
	private WebElement _expandPartnerSection;
	
	@FindBy(how = How.CSS, using = "button[class*='toast-close-btn']")
	private WebElement _closeBtn;
	
	@FindBy(how = How.CSS, using = "ng-select[name='T_Type2']")
	private List<WebElement> _partnerEmailTypeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Type']")
	private List<WebElement> _partnerPhoneTypeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Orig']")
	private List<WebElement> _partnerPhoneOrgDestDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Orig'] span[class='ng-value-label ng-star-inserted']")
	private List<WebElement> _partnerPhoneOrgDestDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Type'] span[class='ng-value-label ng-star-inserted']")
	private List<WebElement> _partnerPhoneTypeDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[name='T_Type2'] span[class='ng-value-label ng-star-inserted']")
	private List<WebElement> _partnerEmailTypeDropdownValue;
	
	@FindBy(how = How.CSS, using = "input[id='P_Preferred']")
	private List<WebElement> _partnerPhonePreferred;

	@FindBy(how = How.CSS, using = "input[id='P_Preferred']+span")
	private List<WebElement> _partnerPhonePreferredSelect;
	
	@FindBy(how = How.CSS, using = "input[id='T_Preferred2']")
	private List<WebElement> _partnerEmailPreferred;

	@FindBy(how = How.CSS, using = "input[id='T_Preferred2']+ span")
	private List<WebElement> _partnerEmailPreferredSelect;
	
	@FindBy(how = How.ID, using = "P_Number")
	private List<WebElement> _partnerPhoneNumber;

	@FindBy(how = How.ID, using = "T_Email")
	private List<WebElement> _partnerEmailAddress;
	
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm btn']")
	private WebElement _YesButton;
	
	final By _dropdownOptions = By.cssSelector("div[role='option']>span");
	final By _genderDropdownOptions = By.cssSelector("div[role='option']>div");
	
	LinkedHashMap<String, WebElement> partnerWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, List<String>> partnerDropdownFieldOptions = new LinkedHashMap<String, List<String>>();
	LinkedHashMap<String, String> partnerUpdatedFieldValuesMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> partnerFieldCharacterLimitMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, List<WebElement>> partnerPhoneEmailFieldsMap = new LinkedHashMap<String, List<WebElement>>();
	LinkedHashMap<String, String> partnerUpdatedDropdownFieldValuesMap = new LinkedHashMap<String, String>();
	List<String> originDestOption = new ArrayList<String>();
	List<String> phoneTypeOption = new ArrayList<String>();
	List<String> emailTypeOption = new ArrayList<String>();
	
	/**
	 * Map all Partner Web Elements with Name
	 */
	public void mapPartnerWebElementFields() {
		partnerWebElementsMap.put(MYLOConstants.ADD_PARTNER_LINK, _addPartnerLink);
		partnerWebElementsMap.put(MYLOConstants.GENDER, _partnerGender);
		partnerWebElementsMap.put(MYLOConstants.RELATIONSHIP, _partnerRelationship);
		partnerWebElementsMap.put(MYLOConstants.NEW_DESTINATION, _partnerNewDestination);
		partnerWebElementsMap.put(MYLOConstants.CITIZENSHIP, _partnerCitizenship);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_FIRSTNAME, _partnerFirstName);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_MIDDLENAME, _partnerMiddleName);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_LASTNAME, _partnerLastName);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_SUFFIX, _partnerSuffix);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_MAIDENNAME, _partnerMaidenName);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_PREFERREDNAME, _partnerPreferredName);
		partnerWebElementsMap.put(MYLOConstants.PRONOUNS, _partnerPronouns);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_AGE, _partnerAge);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_DOB, _partnerDateOfBirth);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_ADD_PHONE, _partnerAddPhone);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_ADD_EMAIL, _partnerAddEmail);
		partnerWebElementsMap.put(MYLOConstants.EDIT_BUTTON, _partnerEditButton);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_DRODOWN_ARROW, _expandPartnerSection);
		partnerWebElementsMap.put(MYLOConstants.YES_BUTTON, _YesButton);
		partnerWebElementsMap.put(MYLOConstants.SAVE_BUTTON, _partnerSaveButton);
	}
	
	/**
	 * Map all Character Limits with respective Fields
	 */
	public void mapPartnerFieldsCharacterLimitMap() {
		partnerFieldCharacterLimitMap.put(MYLOConstants.PARTNER_FIRSTNAME,
				MYLOConstants.PARTNER_FIRSTNAME_CHAR_LIMIT);
		partnerFieldCharacterLimitMap.put(MYLOConstants.PARTNER_LASTNAME,
				MYLOConstants.PARTNER_LASTNAME_CHAR_LIMIT);
		partnerFieldCharacterLimitMap.put(MYLOConstants.PARTNER_MIDDLENAME,
				MYLOConstants.PARTNER_MIDDLENAME_CHAR_LIMIT);
		partnerFieldCharacterLimitMap.put(MYLOConstants.PARTNER_SUFFIX,
				MYLOConstants.PARTNER_SUFFIX_CHAR_LIMIT);
		partnerFieldCharacterLimitMap.put(MYLOConstants.PARTNER_MAIDENNAME,
				MYLOConstants.PARTNER_MAIDENNAME_CHAR_LIMIT);
		partnerFieldCharacterLimitMap.put(MYLOConstants.PARTNER_PHONE_NUMBER,
				MYLOConstants.PARTNER_PHONE_NUMBER_CHAR_LIMIT);
	}
	
	/**
	 * Map all Partner Phone/Email Field Values
	 */
	public void mapPartnerPhoneEmailField() {
		partnerPhoneEmailFieldsMap.put(MYLOConstants.PARTNER_PHONE_NUMBER, _partnerPhoneNumber);
		partnerPhoneEmailFieldsMap.put(MYLOConstants.PARTNER_ORGDEST, _partnerPhoneOrgDestDropdownValue);
		partnerPhoneEmailFieldsMap.put(MYLOConstants.PARTNER_PHONE_TYPE, _partnerPhoneTypeDropdownValue);
		partnerPhoneEmailFieldsMap.put(MYLOConstants.PARTNER_EMAIL_ADDRESS, _partnerEmailAddress);
		partnerPhoneEmailFieldsMap.put(MYLOConstants.PARTNER_EMAIL_TYPE, _partnerEmailTypeDropdownValue);
	}
	
	/**
	 * @param elementName
	 * Scroll to respective element of Partner Fields 
	 */
	public void scrollToPartnerElement(String elementName) {
		mapPartnerWebElementFields();
		try {
			CoreFunctions.scrollToElementUsingJavaScript(driver, partnerWebElementsMap.get(elementName),
					elementName);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, elementName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					elementName, MYLOConstants.PARTNER));
		}
	}
	
	/**
	 * @param fieldName
	 * Click respective fields of Partner section
	 */
	public void clickFieldsOnPartnerSection(String fieldName) {
		mapPartnerWebElementFields();
		try {
			WebElement element = partnerWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, fieldName,100);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		}
	}
	
	/**
	 * @param elementName
	 * @param index
	 * Click respective dropdown fields of Partner section
	 */
	public void clickDropdownFieldsOnPartnerSection(String elementName, int index) {
		switch (elementName) {
		case MYLOConstants.PARTNER_ORGDEST:
			originDestOption = returnDropDownOptionsList(_partnerPhoneOrgDestDropdown.get(index), elementName);
			break;
		case MYLOConstants.PARTNER_PHONE_TYPE:
			phoneTypeOption = returnDropDownOptionsList(_partnerPhoneTypeDropdown.get(index), elementName);
			break;
		case MYLOConstants.PARTNER_EMAIL_TYPE:
			emailTypeOption = returnDropDownOptionsList(_partnerEmailTypeDropdown.get(index), elementName);
			break;
		case MYLOConstants.PARTNER_PHONE_PREFERRED:
			CoreFunctions.scrollToElementUsingJavaScript(driver, _partnerPreferredName, MYLOConstants.PARTNER_PREFERREDNAME);
			CoreFunctions.click(driver, _partnerPhonePreferredSelect.get(index), elementName);
			break;
		case MYLOConstants.PARTNER_EMAIL_PREFERRED:
			CoreFunctions.scrollToElementUsingJavaScript(driver, _partnerPreferredName, MYLOConstants.PARTNER_PREFERREDNAME);
			CoreFunctions.click(driver, _partnerEmailPreferredSelect.get(index), elementName);
			break;
		case MYLOConstants.RELATIONSHIP:
			CoreFunctions.click(driver, _partnerRelationship, elementName);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
		}
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
					MYLOConstants.CLOSE_BUTTON, MYLOConstants.PARTNER, MYLOConstants.JOURNEY));
			Assert.fail(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.CLOSE_BUTTON, MYLOConstants.PARTNER, MYLOConstants.JOURNEY));
		}
	}

	/**
	 * Click on Partner Save button
	 */
	public void clickPartnerSaveButton() {
		try {
			CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySection,
					MYLOConstants.TRANSFEREE_FAMILY);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _partnerSaveIcon, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.highlightElementAndClick(driver, _partnerSaveIcon, MYLOConstants.SAVE_BUTTON);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.SAVE_BUTTON, MYLOConstants.PARTNER, MYLOConstants.JOURNEY));
			Assert.fail(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.SAVE_BUTTON, MYLOConstants.PARTNER, MYLOConstants.JOURNEY));
		}
	}
	
	/**
	 * @param fieldName
	 * @param fieldValue
	 * Set Value of different fields on Partner section
	 */
	public void setPartnerFields(String fieldName, String fieldValue) {
		mapPartnerWebElementFields();
		try {
			WebElement reqWebElement = partnerWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			if (fieldValue.equals(""))
				CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySection,
						MYLOConstants.TRANSFEREE_FAMILY);
			String setValue = CoreFunctions.setDifferentFieldsForMylo(driver, reqWebElement, fieldName, fieldValue);
			partnerUpdatedFieldValuesMap.put(fieldName, setValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		}
	}
	
	/**
	 * @param fieldName
	 * @param fieldValue
	 * Set Value of different dropdown fields on Partner section
	 */
	public void setDifferentDropDownFields(String fieldName, String fieldValue) {
		String updatedValue = null;
		try {
			List<WebElement> optionList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			updatedValue = CoreFunctions.setDifferentDropDownFieldsForMylo(driver, fieldValue, optionList);
			partnerUpdatedDropdownFieldValuesMap.put(fieldName, updatedValue);
			partnerUpdatedFieldValuesMap.put(fieldName, updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		}
	}
	
	/**
	 * @param fieldName
	 * @param fieldValue
	 * @param index
	 * Set Value of different Phone/Email fields on Partner section
	 */
	public void setPartnerPhoneEmailFields(String fieldName, String fieldValue, int index) {
		mapPartnerPhoneEmailField();
		try {
			WebElement reqWebElement = partnerPhoneEmailFieldsMap.get(fieldName).get(index);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			if (fieldValue.equals(""))
				CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySection,
						MYLOConstants.TRANSFEREE_FAMILY);
			String setValue = CoreFunctions.setDifferentFieldsForMylo(driver, reqWebElement, fieldName, fieldValue);
			partnerUpdatedFieldValuesMap.put(fieldName, setValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		}
	}
	
	/**
	 * @param table
	 * @param index
	 * Set Value of all Phone fields on Partner section
	 */
	public void setMandatoryFieldsPartnerPhoneSection(DataTable table, int index) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setPartnerPhoneEmailFields(data.get(i).get(MYLOConstants.FIELD_NAME),
					data.get(i).get(MYLOConstants.CHARACTER_LENGTH), index);
			clickDropdownFieldsOnPartnerSection(MYLOConstants.PARTNER_ORGDEST, index);
			setDifferentDropDownFields(MYLOConstants.PARTNER_ORGDEST,
					data.get(i).get(MYLOConstants.PARTNER_ORGDEST));
			clickDropdownFieldsOnPartnerSection(MYLOConstants.PARTNER_PHONE_TYPE, index);
			setDifferentDropDownFields(MYLOConstants.PARTNER_PHONE_TYPE,
					data.get(i).get(MYLOConstants.PARTNER_PHONE_TYPE));
		}
	}
	
	/**
	 * @param table
	 * @param index
	 * Set Value of all Email fields on Partner section
	 */
	public void setMandatoryFieldsPartnerEmailSection(DataTable table, int index) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setPartnerPhoneEmailFields(data.get(i).get(MYLOConstants.FIELD_NAME),
					data.get(i).get(MYLOConstants.FIELD_VALUE), index);
			clickDropdownFieldsOnPartnerSection(MYLOConstants.PARTNER_EMAIL_TYPE, index);
			setDifferentDropDownFields(MYLOConstants.PARTNER_EMAIL_TYPE,
					data.get(i).get(MYLOConstants.PARTNER_EMAIL_TYPE));
		}
	}
	
	/**
	 * @param table
	 * @param buttonName
	 * Set Value of all Phone/Email fields on Partner section
	 */
	public void setFieldsPartnerPhoneEmailSection(DataTable table, String buttonName) {
		if (buttonName.equals(MYLOConstants.PARTNER_ADD_PHONE))
			setMandatoryFieldsPartnerPhoneSection(table, 0);
		else
			setMandatoryFieldsPartnerEmailSection(table, 0);
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
					CoreConstants.FAIL, elementName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					elementName, MYLOConstants.PARTNER));
		}
		return requiredList;
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Get the Field Value of all Fields available on Partner section
	 */
	public String getPartnerFields(String fieldName) {
		mapPartnerWebElementFields();
		String requiredValue = null;
		List<String> dropdownFields = new ArrayList<String>();
		dropdownFields.add(MYLOConstants.RELATIONSHIP);
		dropdownFields.add(MYLOConstants.CITIZENSHIP);
		dropdownFields.add(MYLOConstants.GENDER);
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, partnerWebElementsMap.get(fieldName), fieldName);
			requiredValue = (dropdownFields.contains(fieldName))
					? CoreFunctions.getElementText(driver, partnerWebElementsMap.get(fieldName))
					: CoreFunctions.getAttributeText(partnerWebElementsMap.get(fieldName),
							MYLOConstants.TITLE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		}
		return requiredValue;
	}
	
	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Get the Field Value of all Phone/Email Fields available on Partner section
	 */
	public String getPartnerPhoneEmailFields(String fieldName, int index) {
		mapPartnerPhoneEmailField();
		String requiredValue = null;
		List<String> dropdownFields = new ArrayList<String>();
		dropdownFields.add(MYLOConstants.PARTNER_EMAIL_TYPE);
		dropdownFields.add(MYLOConstants.PARTNER_PHONE_TYPE);
		dropdownFields.add(MYLOConstants.PARTNER_ORGDEST);
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver,
					partnerPhoneEmailFieldsMap.get(fieldName).get(index), fieldName);
			requiredValue = (dropdownFields.contains(fieldName))
					? CoreFunctions.getElementText(driver, partnerPhoneEmailFieldsMap.get(fieldName).get(index))
					: CoreFunctions.getAttributeText(partnerPhoneEmailFieldsMap.get(fieldName).get(index),
							MYLOConstants.TITLE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		}
		return requiredValue;
	}
	
	/**
	 * @param table
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Partner section
	 */
	public boolean verifyMandatoryFieldsToastMessagesPartnerSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setPartnerFields(MYLOConstants.PARTNER_FIRSTNAME,
					data.get(i).get(MYLOConstants.PARTNER_FIRSTNAME));
			setPartnerFields(MYLOConstants.PARTNER_LASTNAME, data.get(i).get(MYLOConstants.PARTNER_LASTNAME));
			clickPartnerSaveButton();
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
		}
		return flag;
	}
	
	/**
	 * @param table
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Partner section
	 */
	public boolean verifyMandatoryToastMessageNewPartnerSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setPartnerFields(MYLOConstants.PARTNER_FIRSTNAME,
					data.get(i).get(MYLOConstants.PARTNER_FIRSTNAME));
			setPartnerFields(MYLOConstants.PARTNER_LASTNAME, data.get(i).get(MYLOConstants.PARTNER_LASTNAME));
			clickFieldsOnPartnerSection(MYLOConstants.SAVE_BUTTON);
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
		}
		return flag;
	}
	
	/**
	 * @param table
	 * @return
	 * 	Verify Toast Messages for Special Characters entered in fields of Partner section
	 */
	public boolean verifySpecialCharacterToastMessagesPartnerSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			setPartnerFields(fieldName, MYLOConstants.SPECIAL_CHARACTERS_STRING);
			clickPartnerSaveButton();
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
			clickToastMesssgeCloseIcon();
			setPartnerFields(fieldName, MYLOConstants.TEST);
		}
		return flag;
	}
	
	/**
	 * @param table
	 * @return
	 * 	Verify Toast Messages for Mandatory Fields of Partner Phone section
	 */
	public boolean verifyMandatoryFieldsToastMessagesPartnerPhoneSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setPartnerPhoneEmailFields(MYLOConstants.PARTNER_PHONE_NUMBER,
					data.get(i).get(MYLOConstants.PARTNER_PHONE_NUMBER), 0);
			clickDropdownFieldsOnPartnerSection(MYLOConstants.PARTNER_ORGDEST, 0);
			setDifferentDropDownFields(MYLOConstants.PARTNER_ORGDEST,
					data.get(i).get(MYLOConstants.PARTNER_ORGDEST));
			clickDropdownFieldsOnPartnerSection(MYLOConstants.PARTNER_PHONE_TYPE, 0);
			setDifferentDropDownFields(MYLOConstants.PARTNER_PHONE_TYPE,
					data.get(i).get(MYLOConstants.PARTNER_PHONE_TYPE));
			clickPartnerSaveButton();
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
		}
		return flag;
	}
	
	/**
	 * @param table
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Partner Email section
	 */
	public boolean verifyMandatoryFieldsToastMessagesPartnerEmailSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setPartnerPhoneEmailFields(MYLOConstants.PARTNER_EMAIL_ADDRESS,
					data.get(i).get(MYLOConstants.PARTNER_EMAIL_ADDRESS), 0);
			clickDropdownFieldsOnPartnerSection(MYLOConstants.PARTNER_EMAIL_TYPE, 0);
			setDifferentDropDownFields(MYLOConstants.PARTNER_EMAIL_TYPE,
					data.get(i).get(MYLOConstants.PARTNER_EMAIL_TYPE));
			clickPartnerSaveButton();
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
		}
		return flag;
	}
	
	/**
	 * @param table
	 * @param buttonName
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Partner Phone/Email section
	 */
	public boolean verifyMandatoryFieldsToastMessagesPartnerPhoneEmailSection(DataTable table, String buttonName) {
		boolean flag = false;
		flag = (buttonName.equals(MYLOConstants.PARTNER_ADD_PHONE))
				? verifyMandatoryFieldsToastMessagesPartnerPhoneSection(table)
				: verifyMandatoryFieldsToastMessagesPartnerEmailSection(table);
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Verify Updated Values in respective fields of Partner section
	 */
	public boolean verifyPartnerFieldsUpdatedValue(String fieldName) {
		boolean flag = false;
		mapPartnerFieldsCharacterLimitMap();
		String updatedValue = null;
		try {
			updatedValue = partnerUpdatedFieldValuesMap.get(fieldName);
			int fieldCharLimit = Integer.parseInt(partnerFieldCharacterLimitMap.get(fieldName));
			updatedValue = updatedValue.length() > fieldCharLimit ? updatedValue.substring(0, fieldCharLimit)
					: updatedValue;
			flag = getPartnerFields(fieldName).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.PARTNER));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Partner Phone section
	 */
	public boolean verifyPartnerPhoneFieldsUpdatedValue(String fieldName, int index) {
		boolean flag = false;
		mapPartnerFieldsCharacterLimitMap();
		String updatedValue = null;
		try {
			updatedValue = partnerUpdatedFieldValuesMap.get(fieldName);
			int fieldCharLimit = Integer.parseInt(partnerFieldCharacterLimitMap.get(fieldName));
			updatedValue = updatedValue.length() > fieldCharLimit ? updatedValue.substring(0, fieldCharLimit)
					: updatedValue;
			flag = getPartnerPhoneEmailFields(fieldName, index).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.PARTNER));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Partner Email section
	 */
	public boolean verifyPartnerEmailFieldsUpdatedValue(String fieldName, int index) {
		boolean flag = false;
		String updatedValue = null;
		try {
			updatedValue = partnerUpdatedFieldValuesMap.get(fieldName);
			flag = getPartnerPhoneEmailFields(fieldName, index).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.PARTNER));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		return flag;
	}
	
	/**
	 * @param table
	 * @return
	 * Verify Updated Values in respective fields of Partner section
	 */
	public boolean verifyDifferentPartnerFieldsUpdatedValue(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = (verifyPartnerFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME)));
		}
		return flag;
	}
	
	/**
	 * @param table
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Partner Phone section
	 */
	public boolean verifyDifferentPartnerPhoneFieldsUpdatedValue(DataTable table, int index) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = (verifyPartnerPhoneFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME), index));
		}
		return flag;
	}
	
	/**
	 * @param table
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Partner Email section
	 */
	public boolean verifyDifferentPartnerEmailFieldsUpdatedValue(DataTable table, int index) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = ((verifyPartnerEmailFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME), index)));
		}
		return flag;
	}
	
	/**
	 * @param msg
	 * @param sectionType
	 * @return
	 * Verify Toast Messages appearing for Partner Section
	 */
	public boolean verifyToastMessage(String msg, String sectionType) {
		boolean flag = false;
		try {
			CoreFunctions.isElementVisible(_alertMessage);
			CoreFunctions.highlightObject(driver, _alertMessage);
			flag = (_alertMessage.getText().equals(msg));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.ALERT_MESSAGE, sectionType));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_DISPLAYED, CoreConstants.PASS,
					msg, MYLOConstants.JOURNEY));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL, msg,
					_alertMessage.getText(), MYLOConstants.JOURNEY));
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Verify DropDownList values from Database
	 */
	public boolean verifyPartnerFieldDropdownListOptions(String fieldName) {
		boolean flag = false;
		List<String> destinationOption = new ArrayList<String>();
		destinationOption.add("Yes");
		destinationOption.add("No");
		List<String> partnerRelationshipOption = new ArrayList<String>();
		partnerRelationshipOption.add("Domestic Partner");
		partnerRelationshipOption.add("Spouse");
		List<String> valuesFromUI = partnerDropdownFieldOptions.get(fieldName);
		valuesFromUI.remove(MYLOConstants.SELECT_ONE);
		valuesFromUI.remove(MYLOConstants.USA_STATE);
		try {
			flag=(fieldName.equals(MYLOConstants.NEW_DESTINATION))?destinationOption.equals(valuesFromUI):
				(fieldName.equals(MYLOConstants.RELATIONSHIP))?partnerRelationshipOption.equals(valuesFromUI):
					(fieldName.equals(MYLOConstants.CITIZENSHIP))?getCountryDBValues(fieldName).equals(valuesFromUI):
					DbFunctions.getTransfereeDropdownListValues(fieldName).equals(valuesFromUI);

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MATCH, CoreConstants.PASS,
					fieldName, MYLOConstants.PARTNER));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MISMATCH,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
		return flag;
	}
	
	public void saveDropdownListOptionsOnPartnerSection(String fieldName) {
		mapPartnerWebElementFields();
		partnerDropdownFieldOptions.put(fieldName, returnDropDownOptionsList(partnerWebElementsMap.get(fieldName), fieldName));
	}
	
	public List<String> getCountryDBValues(String fieldName) {
		List<String> countryDBValues = DbFunctions.getTransfereeDropdownListValues(fieldName);
		countryDBValues.remove(MYLOConstants.USA_STATE);
		return countryDBValues;
	}
	
	/**
	 * @param section
	 * @param index
	 * @param number
	 * @return
	 * Check whether Preferred checkbox is selected for Partner Phone/Email section
	 */
	public boolean isPreferredChecked(String section, int index, String number) {
		boolean flag=false;
		try {
			flag = (section.equals(MYLOConstants.PARTNER_PHONE_NUMBER))
					? _partnerPhonePreferred.get(index).isSelected()
					: _partnerEmailPreferred.get(index).isSelected();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, section, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					section, MYLOConstants.PARTNER));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_SELECTED, CoreConstants.PASS,
					number, MYLOConstants.PREFERRED, section, MYLOConstants.PARTNER));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_NOT_SELECTED, CoreConstants.PASS,
					number, MYLOConstants.PREFERRED, section, MYLOConstants.PARTNER));
		return flag;
	}
}
